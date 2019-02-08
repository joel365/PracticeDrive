/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

/**
 * Add your docs here.
 */
public class EncoderMotor extends Subsystem{
    private TalonSRX _encoderMotor = new TalonSRX(RobotMap.ENCODER_MOTOR.value);

    public EncoderMotor(){
        _encoderMotor.set(ControlMode.PercentOutput, 0);
        _encoderMotor.configFactoryDefault();
        _encoderMotor.setNeutralMode(NeutralMode.Brake);

    }
   
       

   public void intakeset(){
    _encoderMotor.set(ControlMode.PercentOutput, 0.5);
   }
   public void outTake(){
    _encoderMotor.set(ControlMode.PercentOutput, -0.5);

   }
   public void releaseset(){
    _encoderMotor.set(ControlMode.PercentOutput, 0);
   }


   
   
   
    @Override
    public void initDefaultCommand() {
        
    }
}
