package org.firstinspires.ftc.teamcode.common;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Methods that can be used to simplify Autonomous movement
 *
 * @author Lachlan Paul, 2024
 */
public class AutonomousMovement {
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    public AutonomousMovement(DcMotor fl, DcMotor fr, DcMotor bl, DcMotor br) {
        frontLeft = fl;
        frontRight = fr;
        backLeft = bl;
        backRight = br;

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void moveForward(int cm) {
        // TODO: Figure out proper unit of measurement.
        //  setTargetPosition() uses encoder ticks and not a specific unit of measurement.
        setAllMotorsMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setTargetPosition(cm);
        frontRight.setTargetPosition(cm);
    }

    public void moveBackwards(int cm) {
        moveForward(-cm);
    }

    public void moveRight(int cm) {
        setAllMotorsMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    private void setAllMotorsMode(DcMotor.RunMode mode) {
        frontLeft.setMode(mode);
        frontRight.setMode(mode);
        backLeft.setMode(mode);
        backRight.setMode(mode);
    }

    public void update() {
        if (!frontLeft.isBusy()) frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        if (!frontRight.isBusy()) frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        if (!backLeft.isBusy()) backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        if (!backRight.isBusy()) backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}
