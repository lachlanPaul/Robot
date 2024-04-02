package org.firstinspires.ftc.teamcode.common;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Drone Launcher
 *
 * @author Lachlan Paul, 2024
 */
public class Cannon {
    public Servo prolong;

    public Cannon(Servo pl) {
        prolong = pl;
    }

    public void fire() {
        prolong.setPosition(0.0);
    }

    public void reset() {
        prolong.setPosition(1.0);
    }
}
