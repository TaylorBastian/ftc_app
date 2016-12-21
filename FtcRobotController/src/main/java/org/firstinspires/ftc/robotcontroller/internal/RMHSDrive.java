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
            if(gamepad1.a){
                middlemotor.setPower(1);
            }
            if(gamepad1.x){
                middlemotor.setPower(-1);
            }
            if (!gamepad1.a&&!gamepad1.x){
                middlemotor.setPower(0);
            }
            rightmotor.setPower(gamepad1.right_stick_y);
            leftmotor.setPower(-gamepad1.left_stick_y);

        }
    }
}
