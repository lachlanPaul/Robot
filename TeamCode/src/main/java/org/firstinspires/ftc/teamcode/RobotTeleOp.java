package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Main OpMode for ROBOT_NAME_HERE.
 * Basic drive and arm capabilities. Maybe even suspension and drone launching in the future.
 *
 * @author Lachlan Paul, 2024
 */
public class RobotTeleOp extends LinearOpMode {
    public DcMotor leftWheel;
    public DcMotor rightWheel;

    @Override
    public void runOpMode() throws InterruptedException {
        leftWheel = hardwareMap.get(DcMotor.class, "leftWheel");
        rightWheel = hardwareMap.get(DcMotor.class, "rightWheel");

        // TODO: Make sure these are correct
        leftWheel.setDirection(DcMotor.Direction.REVERSE);
        rightWheel.setDirection(DcMotor.Direction.FORWARD);
    }
}
