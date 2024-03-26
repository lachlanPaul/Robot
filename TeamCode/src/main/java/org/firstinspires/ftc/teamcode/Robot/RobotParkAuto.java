package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.common.BothWheels;

@Autonomous(name = "RobotParkAuto")
public class RobotParkAuto extends LinearOpMode {
    public DcMotor leftWheel;
    public DcMotor rightWheel;
    public BothWheels bothWheels;

    @Override
    public void runOpMode() throws InterruptedException {
        leftWheel = hardwareMap.get(DcMotor.class, "leftWheel");
        rightWheel = hardwareMap.get(DcMotor.class, "rightWheel");
        bothWheels = new BothWheels(leftWheel, rightWheel);

        waitForStart();

        if (opModeIsActive()) {
            leftWheel.setDirection(DcMotor.Direction.REVERSE);
            rightWheel.setDirection(DcMotor.Direction.FORWARD);

            // TODO: The official docs does this differently
            //  This is an easier way though. It's a pain to write however,
            //  so I'll have to look into how the official docs does it sometime.
            bothWheels.setBothWheelPowers(1.0);
            sleep(500);
            bothWheels.turnLeftByPower(1.0);
            sleep(500);
            bothWheels.setBothWheelPowers(1.0);
            sleep(500);
            bothWheels.turnRightByPower(1.0);
            sleep(500);

            bothWheels.stopBothWheels();
        }
    }
}
