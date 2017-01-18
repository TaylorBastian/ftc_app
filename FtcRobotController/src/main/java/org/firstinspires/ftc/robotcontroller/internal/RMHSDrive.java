package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class RMHSDrive extends LinearOpMode {
    DcMotor leftmotor;
    DcMotor rightmotor;
    DcMotor spinnermotor;
    DcMotor shootermotor;
    Servo pusher;


    @Override
    public void runOpMode() throws InterruptedException {

        //hardware map stuff
        leftmotor=hardwareMap.dcMotor.get("l");
        rightmotor=hardwareMap.dcMotor.get("r");
        spinnermotor=hardwareMap.dcMotor.get("s");
        shootermotor=hardwareMap.dcMotor.get("ss");
        pusher=hardwareMap.servo.get("p");
        
        //set servo start position
        pusher.setPosition(0.5);

        //Wait for play button to start
        waitForStart();

        //Op mode loop
        while(opModeIsActive()){


            //Suck
            if(gamepad1.right_bumper){
                spinnermotor.setPower(0.50f);
            }

            //Push out
            if(gamepad1.left_bumper){
                spinnermotor.setPower(-0.50f);
            }

            //Shut off if no buttons pressed
            if (!gamepad1.left_bumper&&!gamepad1.right_bumper){
                spinnermotor.setPower(0);
            }


            //Shooter Wheel Control
            if(gamepad1.a){
                shootermotor.setPower(-1.0);
            }
            else{
                shootermotor.setPower(0);
            }

            //Push ball
            if(gamepad1.dpad_right) {
                pusher.setPosition(0);
            }

            //Reset servo position
            if(gamepad1.dpad_left) {
                pusher.setPosition(0.5);
            }


            //set wheel motors
            rightmotor.setPower(gamepad1.right_stick_y);
            leftmotor.setPower(-gamepad1.left_stick_y);
        }
    }
}
