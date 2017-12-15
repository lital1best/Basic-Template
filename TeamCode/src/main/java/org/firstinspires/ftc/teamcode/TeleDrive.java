/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.util.ElapsedTime;
//import com.qualcomm.robotcore.util.Range;

/**
 * This file contains an example of an iterative (Non-Linear) "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all iterative OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="Basic: TeleOp Drive", group="TeleOps")
@Disabled
public class TeleDrive extends OpMode
{
    // Declare OpMode members.
    private DcMotor arm_motor;
    private double up_arm;
    private double down_arm;
    private double arm_power;
    private DcMotor shrink_motor;
    private double shrink_power;
    private DcMotor roller_gripper_motor;
    private double emitter;
    private double receptor;
    private double roller_gripper_power
    //private ElapsedTime runtime = new ElapsedTime(); // Used as an ndecation of runtime for some process that you may need.

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        arm_motor = hardwareMap.dcMotor.get("arm_motor");
        up_arm = gamepad2.dpad_up;
        down_arm = gamepad2.dpad_down;
        arm_power = 0;
        shrink_motor = hardwareMap.dcMotor.get("shrink_motor");
        shrink_button = gamepad2.x;
        expand_button = gamepad2.b;
        shrink_power = 0;
        roller_gripper_motor = hardwareMap.dcMotor.get("roller_gripper_motor");
        roller_gripper_power = 0;
        emitter = gamepad2.y;
        receptor = gamepad2.a;


        //telemetry.addData("Status", "Initialized");//Using Telemetry lets you tha abilty to show live important data to the drive through 		the driver station. Customie it and use it wisely
	/*
	 *Here goes all the code that requires an initialization once the driver hits INIT button on the DS.
	 * You can see this method as a "constructor" used for initialization.
	*/


        // Tell the driver that initialization is complete.
        //telemetry.addData("Status", "Initialized");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        //runtime.reset();//You can learn about run time and it methods in other resources.
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        if (up_arm) :{
            arm_power += 0.1;
            arm_motor.setPower(arm_power);
        }
        if (down_arm):{
            arm_power -= 0.1;
            arm_motor.setPower(arm_power);
        }
        if (expand_button):{
            shrink_power -= 0.1;
            arm_motor.setPower(shrink_power);
        }
        if (shrink_button):{
            shrink_power += 0.1;
            arm_motor.setPower(shrink_power);
        }
        if (receptor):{
            roller_gripper_power -= 0.1;
            arm_motor.setPower(roller_gripper_power);
        }
        if (emitter):{
            roller_gripper_power += 0.1;
            arm_motor.setPower(roller_gripper_power);
        }



        //YOUR CODE GOES HERE!

        // Show the elapsed game time and wheel power.
        //telemetry.addData("Status", "Run Time: " + runtime.toString());
        //telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}
