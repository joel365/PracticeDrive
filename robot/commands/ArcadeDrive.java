/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

/**
 * Add your docs here.
 */
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

import frc.robot.Robot;

public class ArcadeDrive extends Command{

    
    public ArcadeDrive() {
        requires(Robot.driveBase);
    }

    @Override
    protected void execute() {
        Robot.driveBase.setControlRequest(RobotMap.ARCADE_DRIVE.value, Robot.oi);
        
    }

    @Override
    protected boolean isFinished() {

        return false;
    }

    @Override
    protected void interrupted() {

        end();
    }

}