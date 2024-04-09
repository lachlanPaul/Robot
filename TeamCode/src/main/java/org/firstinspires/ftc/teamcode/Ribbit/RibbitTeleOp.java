package org.firstinspires.ftc.teamcode.Ribbit;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.common.Arm;
import org.firstinspires.ftc.teamcode.common.Cannon;
import org.firstinspires.ftc.teamcode.common.Claws;
import org.firstinspires.ftc.teamcode.common.MecanumDrive;

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
        frontLeft = hardwareMap.get(DcMotor.class, "fl");
        frontRight = hardwareMap.get(DcMotor.class, "fr");
        backLeft = hardwareMap.get(DcMotor.class, "bl");
        backRight = hardwareMap.get(DcMotor.class, "br");

        armMotor = hardwareMap.get(DcMotor.class, "am");
        suspensionMotor = hardwareMap.get(DcMotor.class, "sm");

        leftClaw = hardwareMap.get(Servo.class, "lc");
        rightClaw = hardwareMap.get(Servo.class, "rc");
        prolong = hardwareMap.get(Servo.class, "pl");

        drive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
        clawArm = new Arm(armMotor);
        suspensionArm = new Arm(suspensionMotor);
        claws = new Claws(leftClaw, rightClaw);
        cannon = new Cannon(prolong);

        waitForStart();

        while (opModeIsActive()) {
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

            telemetry.addData("Front Left Power:", frontLeft.getPower());
            telemetry.addData("Front Right Power:", frontRight.getPower());
            telemetry.addData("Back Left Power", backLeft.getPower());
            telemetry.addData("Back Right Power", backRight.getPower());

            telemetry.addData("Left Claw: ", (claws.isClawOpen(Claws.ServoSide.LEFT) ? "Closed" : "Open"));
            telemetry.addData("Right Claw: ", (claws.isClawOpen(Claws.ServoSide.RIGHT) ? "Closed" : "Open"));

            telemetry.update();
        }
    }
}
