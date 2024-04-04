package org.firstinspires.ftc.teamcode.Ribbit;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.common.Cannon;
import org.firstinspires.ftc.teamcode.common.Claws;

public class RibbitTeleOp extends LinearOpMode {
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    public double x;
    public double y;
    public double r;

    public Servo leftClaw;
    public Servo rightClaw;
    public Servo prolong;

    public Claws claws;
    public Cannon cannon;

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.get(DcMotor.class, "fl");
        frontRight = hardwareMap.get(DcMotor.class, "fr");
        backLeft = hardwareMap.get(DcMotor.class, "bl");
        backRight = hardwareMap.get(DcMotor.class, "br");

        claws = new Claws(leftClaw, rightClaw);
        cannon = new Cannon(prolong);

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {
            x = gamepad1.left_stick_x;
            y = -gamepad1.left_stick_y;
            r = gamepad1.right_stick_x;

            frontLeft.setPower(x + y + r);
            frontRight.setPower(x - y - r);
            backLeft.setPower(y - x - r);
            backRight.setPower(y + x - r);

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

            telemetry.addData("X Power", x);
            telemetry.addData("Y Power", y);
            telemetry.addData("R Power", r);

            telemetry.addData("Left Claw: ", (claws.isClawOpen(Claws.ServoSide.LEFT) ? "Closed" : "Open"));
            telemetry.addData("Right Claw: ", (claws.isClawOpen(Claws.ServoSide.RIGHT) ? "Closed" : "Open"));

            telemetry.update();
        }
    }
}
