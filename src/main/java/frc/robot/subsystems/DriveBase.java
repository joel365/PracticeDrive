/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class DriveBase extends Subsystem /*implements PIDOutput*/ {

  private TalonSRX Leftmotor_1;
  private TalonSRX Leftmotor_2;
  private TalonSRX Rightmotor_1;
  private TalonSRX Rightmotor_2;

  //public final PIDController turnController;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public DriveBase() {
    Leftmotor_1 = new TalonSRX(RobotMap.LEFT_MOTOR_1.value);
    Leftmotor_2 = new TalonSRX(RobotMap.LEFT_MOTOR_2.value);
    Rightmotor_1 = new TalonSRX(RobotMap.RIGHT_MOTOR_1.value);
    Rightmotor_2 = new TalonSRX(RobotMap.RIGHT_MOTOR_2.value);

    Robot.intTalon(Leftmotor_1);
    Robot.intTalon(Leftmotor_2);
    Robot.intTalon(Rightmotor_1);
    Robot.intTalon(Rightmotor_2);

    Leftmotor_2.follow(Leftmotor_1);
    Rightmotor_2.follow(Rightmotor_1);
  }

  public void set(ControlMode mode, Double leftvalue1, Double rightvalue1) {
    Leftmotor_1.set(mode, leftvalue1);
    Rightmotor_1.set(mode, rightvalue1);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDrive());
  }

 /* public void pidWrite(double output) {
    set(ControlMode.PercentOutput, -output, output);
  }*/
}
