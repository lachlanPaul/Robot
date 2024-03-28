package org.firstinspires.ftc.teamcode.Ribbit;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.common.AutonomousMovement;

public class RibbitParkAuto extends LinearOpMode {
    public DcMotor leftWheel;
    public DcMotor rightWheel;
    public AutonomousMovement autoMovement;

    @Override
    public void runOpMode() throws InterruptedException {
        leftWheel = hardwareMap.get(DcMotor.class, "leftWheel");
        rightWheel = hardwareMap.get(DcMotor.class, "rightWheel");
        autoMovement = new AutonomousMovement(leftWheel, rightWheel);

        while (opModeIsActive()) {
            leftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
            rightWheel.setDirection(DcMotorSimple.Direction.REVERSE);

            autoMovement.moveForward(5);

            autoMovement.update();
        }
    }
}
