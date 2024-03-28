package org.firstinspires.ftc.teamcode.Ribbit;

import com.qualcomm.robotcore.hardware.Servo;

public class RibbitCannon {
    public Servo prolong;

    public RibbitCannon(Servo pl) {
        prolong = pl;
    }

    public void fire() {
        prolong.setPosition(0.0);
    }

    public void reset() {
        prolong.setPosition(1.0);
    }
}
