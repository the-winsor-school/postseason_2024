package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {

    private DcMotor rf;
    private DcMotor rb;
    private DcMotor lf;
    private DcMotor lb;

    private DcMotor xLeftEncoder;
    private DcMotor xRightEncoder;
    private DcMotor yEncoder;

    private LinearOpMode opMode;
    private HardwareMap map;

    public Robot(LinearOpMode opMode) {
        this.opMode = opMode;
        this.map = opMode.hardwareMap;

        rf = map.tryGet(DcMotor.class, "rf");
        rb = map.tryGet(DcMotor.class, "rb");
        lf = map.tryGet(DcMotor.class, "lf");
        lb = map.tryGet(DcMotor.class, "lb");

        xLeftEncoder = map.tryGet(DcMotor.class, "xLeftEncoder");
        xRightEncoder = map.tryGet(DcMotor.class, "xRightEncoder");
        yEncoder = map.tryGet(DcMotor.class, "yEncoder");
    }
}
