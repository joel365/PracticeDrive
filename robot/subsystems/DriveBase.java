/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

/**
 * Add your docs here.
 */

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.OI;
public class DriveBase extends Subsystem {
	private double leftXRequest;
    private double leftYRequest;
    private double rightXRequest;
    private double rightYRequest;
	private double leftSpeed;
	private double rightSpeed;
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
	public void setControlRequest(int driveType, OI oi) {
        this.leftXRequest = oi.leftX;
        this.leftYRequest = oi.leftY;
        this.rightXRequest = oi.rightX;
        this.rightYRequest = oi.rightY;
        if(driveType == RobotMap.TANK_DRIVE.value) {
            tankSet();
        } else if(driveType == RobotMap.ARCADE_DRIVE.value) {
            arcadeSet();
        }
    }
    public void arcadeSet() {
        leftSpeed += (-leftYRequest+leftXRequest-leftSpeed);
        rightSpeed += (-leftYRequest-leftXRequest-rightSpeed);
        _leftMaster.set(ControlMode.PercentOutput, leftSpeed, DemandType.ArbitraryFeedForward, 0);
		_rightMaster.set(ControlMode.PercentOutput, rightSpeed, DemandType.ArbitraryFeedForward, 0);   
    }

    public void tankSet() {
        leftSpeed += (-leftYRequest-leftSpeed);
        rightSpeed += (-rightYRequest-rightSpeed);
        _leftMaster.set(ControlMode.PercentOutput, -leftYRequest, DemandType.Neutral, 0);
		_rightMaster.set(ControlMode.PercentOutput, -rightYRequest, DemandType.Neutral, 0);
    }

	public double getLeftSpeed() {
        return leftSpeed;
    }

    public double getRightSpeed() {
        return rightSpeed;
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    }
   
}
