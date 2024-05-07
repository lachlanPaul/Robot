package org.firstinspires.ftc.teamcode.common;

import com.qualcomm.robotcore.hardware.Servo;

public class Claws {
    public Servo leftClaw;
    public Servo rightClaw;

    private boolean leftClawOpen = false;
    private boolean rightClawOpen = false;

    public double CLOSED_POSITION = 0.0;
    public double OPEN_POSITION = 1.0;

    public Claws(Servo lClaw, Servo rClaw){
        leftClaw = lClaw;
        rightClaw = rClaw;

        leftClawOpen = leftClaw.getPosition() == OPEN_POSITION;
        rightClawOpen = rightClaw.getPosition() == OPEN_POSITION;
    }

    public void toggleClaw(ServoSide servo) {
        switch (servo) {
            case LEFT:
                if (leftClaw.getPosition() == OPEN_POSITION) {
                    leftClaw.setPosition(CLOSED_POSITION);
                    leftClawOpen = false;
                } else if (leftClaw.getPosition() == CLOSED_POSITION) {
                    leftClaw.setPosition(OPEN_POSITION);
                    leftClawOpen = true;
                }
            case RIGHT:
                if (rightClaw.getPosition() == OPEN_POSITION) {
                    rightClaw.setPosition(CLOSED_POSITION);
                    rightClawOpen = false;
                } else if (rightClaw.getPosition() == CLOSED_POSITION) {
                    rightClaw.setPosition(OPEN_POSITION);
                    rightClawOpen = true;
                }
        }
    }

    public boolean isClawOpen(ServoSide servo) {
        switch (servo) {
            case LEFT:
                return leftClawOpen;
            case RIGHT:
                return rightClawOpen;
        }
        return false;
    }

    /**
     * Opens both claws.
     * I've found that this saves time when two pixels are being dropped on the backboard.
     */
    public void openBothClaws() {
        if (isClawOpen(ServoSide.LEFT)) {
            toggleClaw(ServoSide.LEFT);
        }

        if (isClawOpen(ServoSide.RIGHT)) {
            toggleClaw(ServoSide.RIGHT);
        }
    }

    public enum ServoSide {
        LEFT,
        RIGHT
    }
}
