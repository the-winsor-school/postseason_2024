package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class WheelController {
    private DcMotor rf;
    private DcMotor rb;
    private DcMotor lf;
    private DcMotor lb;

    private DcMotor xLeftEncoder;
    private DcMotor xRightEncoder;
    private DcMotor yEncoder;

    public WheelController(DcMotor rf, DcMotor rb, DcMotor lf, DcMotor lb,
                           DcMotor xLeftEncoder, DcMotor xRightEncoder, DcMotor yEncoder) {
        this.rf = rf;
        this.rb = rb;
        this.lf = lf;
        this.lb = lb;

        this.xLeftEncoder = xLeftEncoder;
        this.xRightEncoder = xRightEncoder;
        this.yEncoder = yEncoder;
    }

    public int getXRightEncoderValue() {
        return xRightEncoder.getCurrentPosition(); }
    public int getXLeftEncoderValue() {
        return xLeftEncoder.getCurrentPosition(); }
    public int getYEncoderValue() {
        return yEncoder.getCurrentPosition(); }

    public double getXRightEncoderInches() {
        return deadwheelTicksToInches(getXRightEncoderValue()); }

    public double getXLeftEncoderInches() {
        return deadwheelTicksToInches(getXLeftEncoderValue()); }

    public double getYEncoderInches() {
        return deadwheelTicksToInches(getYEncoderValue()); }



    //TODO implement the imu here
    public double getTheta() {return 0;}

    public void resetDeadwheels() {
        xRightEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        xLeftEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        yEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public double deadwheelTicksToInches (double ticks) {
        return 0;
    }

    public void resetIMU() {
        //TODO Reset IMU
    }

}
