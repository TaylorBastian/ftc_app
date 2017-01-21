package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="RMHSATon", group="Aton")

public class RMHSAton extends LinearOpMode  {
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
        leftmotor.setDirection(DcMotor.Direction.REVERSE);
        pusher.setPosition(0.65);



        rightmotor.setPower(-0.50);
        leftmotor.setPower(-0.50);

        sleep(1500);

        rightmotor.setPower(0);
        leftmotor.setPower(0);
        for(double i=0;i<1;i=i+0.1){
            shootermotor.setPower(i);
            sleep(100);
        }

        sleep(4000);
        /*
        rightmotor.setPower(-0.5);
        leftmotor.setPower(-0.5);
        sleep(500);
        rightmotor.setPower(0);
        sleep(500);
        rightmotor.setPower(0.5);
        leftmotor.setPower(0.5);
        sleep(500);
        rightmotor.setPower(0);
        leftmotor.setPower(0);
        */
        pusher.setPosition(0.4);

        sleep(3000);

        pusher.setPosition(0.65);
        leftmotor.setPower(1);
        rightmotor.setPower(-1);
        sleep(250);
        leftmotor.setPower(-1);
        rightmotor.setPower(1);
        sleep(500);
        leftmotor.setPower(0);
        rightmotor.setPower(0);
        sleep(500);
        pusher.setPosition(0.4);

        sleep(1000);

        for(double i=1;i>0;i=i-0.1){
            shootermotor.setPower(i);
            sleep(100);
        }
        pusher.setPosition(0.65);





    }
}
