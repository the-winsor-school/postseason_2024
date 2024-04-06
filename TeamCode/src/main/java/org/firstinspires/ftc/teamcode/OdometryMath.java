package org.firstinspires.ftc.teamcode;

public class OdometryMath {

    private double centerToXDeadwheelDistance = 0; //in inches
    private double centerToYDeadwheelDistance = 0; //in inches

    private double localDeltaX = 0;
    private double localDeltaY = 0;
    private double localDeltaTheta = 0;

    private double worldDeltaX = 0;
    private double worldDeltaY = 0;
    private double worldDeltaTheta = 0;

    private double tolerance = 1;

    private WheelController wheelController;

    public OdometryMath(WheelController wheelController) {
        this.wheelController = wheelController;
    }

    private void updateLocalDeltas() {
        double currentRightX = wheelController.getXRightEncoderInches();
        double currentLeftX = wheelController.getXLeftEncoderInches();
        double currentY = wheelController.getYEncoderInches();

        wheelController.resetDeadwheels();
        wheelController.resetIMU();

        localDeltaTheta = wheelController.getTheta();
        localDeltaX = (currentLeftX + currentRightX) / 2;
        localDeltaY = currentY - (centerToYDeadwheelDistance * localDeltaTheta);
    }

    private void updateWorldDeltas() {
        worldDeltaX += localDeltaX;
        worldDeltaY += localDeltaY;
        worldDeltaTheta += localDeltaTheta;
    }

    public void updateCurrentPosition() {
        updateLocalDeltas();
        updateWorldDeltas();
    }

    public DIRECTION feedbackController(double current, double target, double tolerance) {
        if ((current - target) > tolerance) { //current too high
            return DIRECTION.DOWN;
        }
        else if ((target - current) > tolerance) { //target is too high
            return DIRECTION.UP;
        }
        return DIRECTION.STOP;
    }

    public enum DIRECTION {
        UP,
        DOWN,
        STOP
    }

    public boolean checkPosition(double targetX, double targetY, double targetTheta) {
        updateCurrentPosition();

        if ((feedbackController(worldDeltaX, targetX, tolerance) == DIRECTION.STOP) &&
                (feedbackController(worldDeltaY, targetY, tolerance) == DIRECTION.STOP) &&
                (feedbackController(worldDeltaTheta, targetTheta, tolerance) == DIRECTION.STOP)) {
            return true;
        }
        return false;
    }
}
