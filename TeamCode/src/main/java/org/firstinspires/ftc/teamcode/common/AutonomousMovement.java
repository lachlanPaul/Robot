package org.firstinspires.ftc.teamcode.common;

import com.qualcomm.robotcore.hardware.DcMotor;

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

    public MecanumDrive drive;

    public AutonomousMovement(DcMotor fl, DcMotor fr, DcMotor bl, DcMotor br) {
        frontLeft = fl;
        frontRight = fr;
        backLeft = bl;
        backRight = br;

        drive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
    }

    public void moveForward(double y, int runForSeconds) {
        // TODO: Figure out proper unit of measurement.
        //  setTargetPosition() uses encoder ticks and not a specific unit of measurement.
        drive.setAllMotorsMode(DcMotor.RunMode.RUN_TO_POSITION);
        long capture = System.nanoTime();

        if (capture > System.nanoTime() + runForSeconds * 1e9) {
            drive.setAllMotorsTarget(y, 0, 0);
        }

        update();
    }

    public void moveBackwards(double y, int seconds) {
        moveForward(-y, seconds);
    }

    public void moveRight(double x, int runForSeconds) {
        drive.setAllMotorsMode(DcMotor.RunMode.RUN_TO_POSITION);
        long capture = System.nanoTime();

        while (capture > System.nanoTime() + runForSeconds * 1e9) {
            drive.setAllMotorsTarget(0.0, x, 0.0);
        }

        update();
    }

    public void moveLeft(double x, int seconds) {
        moveRight(-x, seconds);
    }

    public void update() {
        if (!frontLeft.isBusy()) frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        if (!frontRight.isBusy()) frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        if (!backLeft.isBusy()) backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        if (!backRight.isBusy()) backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}
