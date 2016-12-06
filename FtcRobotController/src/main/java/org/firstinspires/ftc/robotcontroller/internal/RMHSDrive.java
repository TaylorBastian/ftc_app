package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class RMHSDrive extends LinearOpMode {
    DcMotor leftmotor;
    DcMotor rightmotor;
    DcMotor middlemotor;
    @Override
    public void runOpMode() throws InterruptedException {
        leftmotor=hardwareMap.dcMotor.get("l");
        rightmotor=hardwareMap.dcMotor.get("r");
        middlemotor=hardwareMap.dcMotor.get("m");

        rightmotor.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();
        while(opModeIsActive()){
            if(gamepad1.right_stick_x==0) {
                leftmotor.setPower(-gamepad1.left_stick_y);
                rightmotor.setPower(-gamepad1.left_stick_y);

                middlemotor.setPower(-gamepad1.left_stick_x);
            }else{
                leftmotor.setPower(gamepad1.right_stick_x);
                rightmotor.setPower(-gamepad1.right_stick_x);
                middlemotor.setPower(0);
            }
        }
    }
}
