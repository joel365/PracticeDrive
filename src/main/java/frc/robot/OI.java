/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
import edu.wpi.first.wpilibj.Joystick;

public class OI {

	Joystick _gamepad = new Joystick(1);
	public double leftX;
	public double rightX;
	public double leftY;
	public double rightY;
	public double leftTrigger;
	public double rightTrigger;

    public OI() {

    }

    public void update() {
        /* Gamepad processing */
		
		leftY = deadband(_gamepad.getRawAxis(RobotMap.JOYSTICK_LY.value));
		leftX = deadband(_gamepad.getRawAxis(RobotMap.JOYSTICK_LX.value));
		leftTrigger = deadband(_gamepad.getRawAxis(RobotMap.JOYSTICK_LT.value));
		rightY = deadband(_gamepad.getRawAxis(RobotMap.JOYSTICK_RY.value));
		rightX = deadband(_gamepad.getRawAxis(RobotMap.JOYSTICK_RX.value));
		rightTrigger = deadband(_gamepad.getRawAxis(RobotMap.JOYSTICK_RT.value));
    }

    /** Deadband 5 percent, used on the gamepad */
	private double deadband(double value) {
		/* Upper deadband */
		if (value >= +0.05) 
			return value;
		
		/* Lower deadband */
		if (value <= -0.05)
			return value;
		
		/* Outside deadband */
		return 0;
	}

}
