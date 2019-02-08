/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class UI {

    public void update() {
        double leftMotorSpeed = Robot.driveBase.getLeftSpeed();
        double rightMotorSpeed = Robot.driveBase.getRightSpeed();
       //speed is always positive, so dashboard is +
        
        SmartDashboard.putNumber("DB/Slider 0", leftMotorSpeed*2.5+2.5);
        SmartDashboard.putNumber("DB/Slider 1", rightMotorSpeed*2.5+2.5);
            
    }

}