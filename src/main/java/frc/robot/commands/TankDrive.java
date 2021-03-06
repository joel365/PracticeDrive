/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

/**
 * Add your docs here.
 */
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TankDrive extends Command{

    public TankDrive() {
        requires(Robot.driveBase);
    }

    @Override
    protected void execute() {
        Robot.driveBase.tankSet(-Robot.oi.leftY, -Robot.oi.rightY);
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

