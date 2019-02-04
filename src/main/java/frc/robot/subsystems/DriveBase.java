/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

/**
 * Add your docs here.
 */

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Commands.*;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

public class DriveBase extends Subsystem {

    private TalonSRX _leftMaster = new TalonSRX(RobotMap.LEFTMOTOR_1.value);
	private TalonSRX _rightMaster = new TalonSRX(RobotMap.RIGHTMOTOR_1.value);
	private TalonSRX _leftSlave = new TalonSRX(RobotMap.LEFTMOTOR_2.value);
	private TalonSRX _rightSlave = new TalonSRX(RobotMap.RIGHTMOTOR_2.value);

    public DriveBase() {
        /* Ensure motor output is neutral during init */
		_leftMaster.set(ControlMode.PercentOutput, 0);
		_rightMaster.set(ControlMode.PercentOutput, 0);
		_leftSlave.set(ControlMode.PercentOutput, 0);
		_rightSlave.set(ControlMode.PercentOutput, 0);

		/* Factory Default all hardware to prevent unexpected behaviour */
		_leftMaster.configFactoryDefault();
		_rightMaster.configFactoryDefault();
		_leftSlave.configFactoryDefault();
		_rightSlave.configFactoryDefault();
		
		/* Set Neutral mode */
		_leftMaster.setNeutralMode(NeutralMode.Brake);
		_rightMaster.setNeutralMode(NeutralMode.Brake);
		_leftSlave.setNeutralMode(NeutralMode.Brake);
		_rightSlave.setNeutralMode(NeutralMode.Brake);
		
		/* Configure output direction */
		_leftMaster.setInverted(false);
		_rightMaster.setInverted(true);
		
		_leftSlave.follow(_leftMaster);
		_rightSlave.follow(_rightMaster);

    }

    public void arcadeSet(double forward, double turn){
        /* Arcade Drive using PercentOutput along with Arbitrary Feed Forward supplied by turn */
		_leftMaster.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, +turn);
		_rightMaster.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, -turn);
    }

    public void tankSet(double left, double right){
        /* Arcade Drive using PercentOutput along with Arbitrary Feed Forward supplied by turn */
		_leftMaster.set(ControlMode.PercentOutput, left, DemandType.ArbitraryFeedForward, 0);
		_rightMaster.set(ControlMode.PercentOutput, right, DemandType.ArbitraryFeedForward, 0);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    }
}
