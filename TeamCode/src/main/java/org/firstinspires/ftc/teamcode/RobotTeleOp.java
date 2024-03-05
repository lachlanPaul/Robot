package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Main OpMode for ROBOT_NAME_HERE.
 * Basic drive and arm capabilities. Maybe even suspension and drone launching in the future.
 * That's up to the builders though.
 *
 * @author Lachlan Paul, 2024
 */
@TeleOp(name = "RobotTeleOp")
public class RobotTeleOp extends LinearOpMode {
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

            leftWheel.setPower(-gamepad1.left_stick_y);
            rightWheel.setPower(-gamepad1.left_stick_y);

            // This makes it so the robot can rotate.
            // It works without the if statement but there's probably a better way.
            // It's just here for future reference.
            // if (gamepad1.right_stick_x != 0)
            leftWheel.setPower(gamepad1.right_stick_x);
            rightWheel.setPower(-gamepad1.right_stick_x);

            telemetry.addData("Left Wheel Power", leftWheel.getPower());
            telemetry.addData("Right Wheel Power", rightWheel.getPower());
            telemetry.update();
        }
    }
}
