package org.firstinspires.ftc.teamcode.Ribbit;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class RibbitTeleOp extends LinearOpMode {
    public DcMotor leftWheel;
    public DcMotor rightWheel;
    public Servo leftClaw;
    public Servo rightClaw;
    public Servo prolong;

    public RibbitClaws claws;
    public RibbitCannon cannon;

    @Override
    public void runOpMode() throws InterruptedException {
        leftWheel = hardwareMap.get(DcMotor.class, "leftWheel");
        rightWheel = hardwareMap.get(DcMotor.class, "rightWheel");

        claws = new RibbitClaws(leftClaw, rightClaw);
        cannon = new RibbitCannon(prolong);

        leftWheel.setDirection(DcMotor.Direction.REVERSE);
        rightWheel.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {
            leftWheel.setPower(-gamepad1.left_stick_y + gamepad1.right_stick_x);
            rightWheel.setPower(-gamepad1.left_stick_y - gamepad1.right_stick_x);

            if (gamepad1.right_trigger == 1.0) {
                cannon.fire();
            }

            if (gamepad1.b) {
                cannon.reset();
            }

            if (gamepad2.left_trigger == 1.0) {
                claws.toggleLeftClaw();
            }

            if (gamepad2.right_trigger == 1.0) {
                claws.toggleRightClaw();
            }

            telemetry.addData("Left Wheel Power:", leftWheel.getPower());
            telemetry.addData("Right Wheel Power:", rightWheel.getPower());

            telemetry.addData("Left Claw: ", (claws.leftClawOpen ? "Closed" : "Open"));
            telemetry.addData("Right Claw: ", (claws.rightClawOpen ? "Closed" : "Open"));

            telemetry.update();
        }
    }
}
