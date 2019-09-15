package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TestMecanumTrig")
@Disabled
public class TestMecanumTrig extends DMRelicAbstract {
    public TestMecanumTrig() {
    }

    @Override
    public void init() {

        super.init();

        // Set all motors to run without encoders
        motorRightA.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorRightB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorLeftA.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorLeftB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        //parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;

        //imu = hardwareMap.get(BNO055IMU.class, "imu");
        //imu.initialize(parameters);

        IncVal = 5;

    }

    @Override
    public void loop() {

        super.loop();

        double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
        double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
        double rightX = gamepad1.right_stick_x;
        final double v1 = r * Math.cos(robotAngle) + rightX;
        final double v2 = r * Math.sin(robotAngle) - rightX;
        final double v3 = r * Math.sin(robotAngle) + rightX;
        final double v4 = r * Math.cos(robotAngle) - rightX;

               
        // Set drive motor power
        motorRightA.setPower(v2);  //rightfront = v2
        motorRightB.setPower(v4); //rightrear = v4
        motorLeftA.setPower(v1);  //leftfront = v1
        motorLeftB.setPower(v3);  //leftrear = v3


        telemetry.addData("RightA - right front: ",  v2);
        telemetry.addData("RightB - right rear: ",  v4);
        telemetry.addData("LeftA - left front: ",  v1);
        telemetry.addData("LeftB - left rear: ",  v3);
        telemetry.update();
// End OpMode Loop Method
    }
    @Override
    public void stop ()
    {
        super.stop();
    }
}
