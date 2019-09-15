package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import static android.os.SystemClock.sleep;

@TeleOp(name = "TestMecanumEnc")
@Disabled
public class TestMecanumEncoder extends DMRelicAbstract {
    public TestMecanumEncoder() {
    }

    @Override
    public void init() {

        super.init();

        // Set all motors to run without encoders
        motorRightA.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRightB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLeftA.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLeftB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        //parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;

        //imu = hardwareMap.get(BNO055IMU.class, "imu");
        //imu.initialize(parameters);

        IncVal = 5;

    }

    @Override
    public void loop() {

        super.loop();
/*
        // Set drive motor power
        motorRightA.setPower(powerRightA);
        motorRightB.setPower(powerRightB);
        motorLeftA.setPower(powerLeftA);
        motorLeftB.setPower(powerLeftB);
*/
        targetPower = 0.5f;     // Set power
        targetDrRotateDeg = 0f;// Set rotation

        if (gamepad1.a) {
            targetDrDistInch = 12f; // Set target distance
            telemetry.addData("A pressed: ",  "12 inch");
            sleep(500);
        } else if (gamepad1.b) {
            targetDrDistInch = 6f; // Set target distance
            telemetry.addData("B pressed: ",  "6 inch");
            sleep(500);
        } else if (gamepad1.x) {
            targetDrDistInch = 2f; // Set target distance
            telemetry.addData("x pressed: ",  "2 inch");
            sleep(500);
        } else if (gamepad1.y) {
            targetDrDistInch = 1f; // Set target distance
            telemetry.addData("y pressed: ",  "1 inch");
            sleep(500);
        } else {
            targetDrDistInch = 0f; // Set target distance
            telemetry.addData("Please press a button",  "a - 12, b - 6, x - 2, y - 1");
            sleep(200);
        }




        targetPosLeftA = cmdMoveA(targetDrDistInch, ENCODER_CNT_PER_IN_DRIVE, targetPower, motorLeftA);
        targetPosLeftB = cmdMoveA(targetDrDistInch, ENCODER_CNT_PER_IN_DRIVE, targetPower, motorLeftB);
        targetPosRightA = cmdMoveA(targetDrDistInch, ENCODER_CNT_PER_IN_DRIVE, targetPower, motorRightA);
        targetPosRightB = cmdMoveA(targetDrDistInch, ENCODER_CNT_PER_IN_DRIVE, targetPower, motorRightB);

        telemetry.addData("RightA: ",  powerRightA);
        telemetry.addData("RightB: ",  powerRightB);
        telemetry.addData("LeftA: ",  powerLeftA);
        telemetry.addData("LeftB: ",  powerLeftB);
        telemetry.update();
// End OpMode Loop Method
    }
    @Override
    public void stop ()
    {
        super.stop();
    }
}
