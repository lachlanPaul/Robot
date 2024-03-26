package org.firstinspires.ftc.teamcode.Ribbit;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class RibbitTeleOp extends LinearOpMode {
    public DcMotor leftWheel;
    public DcMotor rightWheel;

    @Override
    public void runOpMode() throws InterruptedException {
        leftWheel = hardwareMap.get(DcMotor.class, "leftWheel");
        rightWheel = hardwareMap.get(DcMotor.class, "rightWheel");

        waitForStart();

        while (opModeIsActive()) {
            leftWheel.setDirection(DcMotor.Direction.REVERSE);
            rightWheel.setDirection(DcMotor.Direction.FORWARD);

            leftWheel.setPower(-gamepad1.left_stick_y + gamepad1.right_stick_x);
            rightWheel.setPower(-gamepad1.left_stick_y - gamepad1.right_stick_x);

            telemetry.addData("Left Wheel Power:", leftWheel.getPower());
            telemetry.addData("Right Wheel Power:", rightWheel.getPower());
            telemetry.update();
        }
    }
}
