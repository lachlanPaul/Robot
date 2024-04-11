package org.firstinspires.ftc.teamcode.common;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class MecanumDrive {
    private final DcMotor frontLeft;
    private final DcMotor frontRight;
    private final DcMotor backLeft;
    private final DcMotor backRight;

    public MecanumDrive(DcMotor fl, DcMotor fr, DcMotor bl, DcMotor br) {
        frontLeft = fl;
        frontRight = fr;
        backLeft = bl;
        backRight = br;

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void setPowerWithController(double x, double y, double r) {
        frontLeft.setPower(x + y + r);
        frontRight.setPower(x - y - r);
        backLeft.setPower(y - x - r);
        backRight.setPower(y + x - r);
    }

    public void setPowerManually(double power) {
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
    }

    public void setAllMotorsTarget(double x, double y, double r) {
        frontLeft.setPower(x + y + r);
        frontRight.setPower(x - y - r);
        backLeft.setPower(y - x - r);
        backRight.setPower(y + x - r);
    }

    void setAllMotorsMode(DcMotor.RunMode mode) {
        frontLeft.setMode(mode);
        frontRight.setMode(mode);
        backLeft.setMode(mode);
        backRight.setMode(mode);
    }
}
