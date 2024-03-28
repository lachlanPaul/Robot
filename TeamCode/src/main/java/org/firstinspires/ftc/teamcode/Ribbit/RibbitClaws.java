package org.firstinspires.ftc.teamcode.Ribbit;

import com.qualcomm.robotcore.hardware.Servo;

public class RibbitClaws {
    public Servo leftClaw;
    public Servo rightClaw;

    public boolean leftClawOpen = false;
    public boolean rightClawOpen = false;

    public RibbitClaws(Servo lClaw, Servo rClaw){
        leftClaw = lClaw;
        rightClaw = rClaw;
    }

    public void toggleLeftClaw() {
        if (leftClaw.getPosition() == 1.0) {
            leftClaw.setPosition(0.0);
            leftClawOpen = false;
        } else if (leftClaw.getPosition() == 0.0) {
            leftClaw.setPosition(1.0);
            leftClawOpen = true;
        }
    }

    public void toggleRightClaw() {
        if (rightClaw.getPosition() == 1.0) {
            rightClaw.setPosition(0.0);
            rightClawOpen = false;
        } else if (rightClaw.getPosition() == 0.0) {
            rightClaw.setPosition(1.0);
            rightClawOpen = true;
        }
    }
}
