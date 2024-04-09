package org.firstinspires.ftc.teamcode.common;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Arm motor
 *
 * @author Lachlan Paul, 2024
 */
public class Arm {
    public DcMotor arm;
    public Arm(DcMotor am) {
        arm = am;
    }

    public void setPowerWithController(double power) {
        arm.setPower(power);
    }
}
