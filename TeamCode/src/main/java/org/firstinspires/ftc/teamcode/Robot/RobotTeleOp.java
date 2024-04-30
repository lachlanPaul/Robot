package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.common.BothWheels;

/**
 * Main OpMode for a generic regular wheel robot with two motors.
 * Basic drive capabilities. Maybe even arm, suspension and drone launching in the future.
 * That's up to the builders though.
 *
 * @author Lachlan Paul, 2024
 */
@Disabled
@TeleOp(name = "RobotTeleOp")
public class RobotTeleOp extends LinearOpMode {
    public DcMotor leftWheel;
    public DcMotor rightWheel;
    public BothWheels bothWheels;

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

            telemetry.addData("Left Wheel Power", leftWheel.getPower());
            telemetry.addData("Right Wheel Power", rightWheel.getPower());
            telemetry.update();
        }
    }
}
