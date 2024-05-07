package org.firstinspires.ftc.teamcode.Ribbit;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.common.Arm;
import org.firstinspires.ftc.teamcode.common.Cannon;
import org.firstinspires.ftc.teamcode.common.Claws;
import org.firstinspires.ftc.teamcode.common.MecanumDrive;

@TeleOp(name = "RibbitTeleOp")
public class RibbitTeleOp extends LinearOpMode {
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    public DcMotor armMotor;
    public DcMotor suspensionMotor;

    public Servo leftClaw;
    public Servo rightClaw;
    public Servo prolong;

    public MecanumDrive drive;
    public Arm clawArm;
    public Arm suspensionArm;
    public Claws claws;
    public Cannon cannon;

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.tryGet(DcMotor.class, "fl");
        frontRight = hardwareMap.tryGet(DcMotor.class, "fr");
        backLeft = hardwareMap.tryGet(DcMotor.class, "bl");
        backRight = hardwareMap.tryGet(DcMotor.class, "br");

//        armMotor = hardwareMap.tryGet(DcMotor.class, "am");
//        suspensionMotor = hardwareMap.tryGet(DcMotor.class, "sm");
//
//        leftClaw = hardwareMap.tryGet(Servo.class, "lc");
//        rightClaw = hardwareMap.tryGet(Servo.class, "rc");
//        prolong = hardwareMap.tryGet(Servo.class, "pl");

        drive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
//        clawArm = new Arm(armMotor);
//        suspensionArm = new Arm(suspensionMotor);
//        claws = new Claws(leftClaw, rightClaw);
//        cannon = new Cannon(prolong);

        waitForStart();

        while (opModeIsActive()) {
            try {
                drive.setPowerWithController(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);
                clawArm.setPowerWithController(gamepad2.right_stick_y);
                suspensionArm.setPowerWithController(gamepad2.left_stick_y);

                if (gamepad1.right_trigger == 1.0) {
                    cannon.fire();
                }

                if (gamepad1.b) {
                    cannon.reset();
                }

                if (gamepad2.left_trigger == 1.0) {
                    claws.toggleClaw(Claws.ServoSide.LEFT);
                }

                if (gamepad2.right_trigger == 1.0) {
                    claws.toggleClaw(Claws.ServoSide.RIGHT);
                }

                if (gamepad2.y) {
                    claws.openBothClaws();
                }

                telemetry.addData("Front Left Power:", frontLeft.getPower());
                telemetry.addData("Front Right Power:", frontRight.getPower());
                telemetry.addData("Back Left Power", backLeft.getPower());
                telemetry.addData("Back Right Power", backRight.getPower());

                telemetry.addData("Left Claw: ", (claws.isClawOpen(Claws.ServoSide.LEFT) ? "Closed" : "Open"));
                telemetry.addData("Right Claw: ", (claws.isClawOpen(Claws.ServoSide.RIGHT) ? "Closed" : "Open"));

                telemetry.update();
            } catch(NullPointerException e) {
                Log.e("NULLPOINTER", "Tried to call function from null component");
            }
        }
    }
}
