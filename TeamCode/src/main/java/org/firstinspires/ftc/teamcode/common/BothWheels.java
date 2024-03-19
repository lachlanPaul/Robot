package org.firstinspires.ftc.teamcode.common;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Functions and methods that interact with both wheels identically.
 * This might be pointless, but meh ¯\_(ツ)_/¯
 *
 * @author Lachlan Paul, 2024
 */
public class BothWheels {
    public DcMotor leftWheel;
    public DcMotor rightWheel;

    public BothWheels(DcMotor leftW, DcMotor rightW) {
        leftWheel = leftW;
        rightWheel = rightW;
    }

    public void setBothWheelPowers(double power) {
        leftWheel.setPower(power);
        rightWheel.setPower(power);
    }

    public void turnLeftByPower(double power) {
        leftWheel.setPower(-power);
        rightWheel.setPower(power);
    }

    public void turnRightByPower(double power) {
        leftWheel.setPower(power);
        rightWheel.setPower(-power);
    }

    public void stopBothWheels() {
        setBothWheelPowers(0);
    }
}
