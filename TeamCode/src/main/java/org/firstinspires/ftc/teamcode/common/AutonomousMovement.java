package org.firstinspires.ftc.teamcode.common;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Methods that can be used to simplify Autonomous movement
 *
 * @author Lachlan Paul, 2024
 */
public class AutonomousMovement {
    public DcMotor leftWheel;
    public DcMotor rightWheel;

    public AutonomousMovement(DcMotor leftW, DcMotor rightW) {
        leftWheel = leftW;
        rightWheel = rightW;

        leftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        rightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void moveForward(int cm) {
        // TODO: Figure out proper unit of measurement.
        //  setTargetPosition() uses encoder ticks and not a specific unit of measurement.
        leftWheel.setTargetPosition(cm);
        rightWheel.setTargetPosition(cm);
    }
}
