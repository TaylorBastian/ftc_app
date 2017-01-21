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
    Double shooterpower;

    @Override
    public void runOpMode() throws InterruptedException {

        //hardware map stuff
        leftmotor=hardwareMap.dcMotor.get("l");
        rightmotor=hardwareMap.dcMotor.get("r");
        spinnermotor=hardwareMap.dcMotor.get("s");
        shootermotor=hardwareMap.dcMotor.get("ss");
        pusher=hardwareMap.servo.get("p");
        shooterpower=0.0;
        shootermotor.setDirection(DcMotor.Direction.REVERSE);

        //set servo start position
        pusher.setPosition(0.65);

        //Wait for play button to start
        waitForStart();

        //Op mode loop
        while(opModeIsActive()){


            //Suck
            if(gamepad1.left_bumper){
                spinnermotor.setPower(0.50f);
            }

            //Push out
            if(gamepad1.right_bumper){
                spinnermotor.setPower(-0.50f);
            }

            //Shut off if no buttons pressed
            if (!gamepad1.left_bumper&&!gamepad1.right_bumper){
                spinnermotor.setPower(0);
            }


            //Shooter Wheel Control
            if(gamepad2.right_bumper){
               if(shooterpower<0.99){
                   shooterpower=shooterpower+0.01;
               }
            }
            else{
                if(shooterpower>0.01){
                    shooterpower=shooterpower-0.01;
                }
            }
            if(shooterpower<=0.99 && shooterpower>=0.01) {
                shootermotor.setPower(shooterpower);
            }


            //Push ball
            if(gamepad2.a) {
                pusher.setPosition(0.4);
            }

            //Reset servo position
            if(gamepad2.x) {
                pusher.setPosition(0.65);
            }

            telemetry.addData("Shooter Power",shooterpower);
            telemetry.addData("Servo Possition", pusher.getPosition());
            telemetry.update();
            //set wheel motors
            rightmotor.setPower(gamepad1.right_stick_y);
            leftmotor.setPower(-gamepad1.left_stick_y);
        }
    }
}
