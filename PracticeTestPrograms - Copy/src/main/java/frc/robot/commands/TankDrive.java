/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.*;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class TankDrive extends Command {

    public TankDrive() {
        requires(Robot.driveBase);
    }

    protected void execute() {
        double throttle = (1.0 - Robot.m_oi.LEFT_JOY.getThrottle()) / -2.0;

        Robot.driveBase.set(ControlMode.PercentOutput, Robot.m_oi.getleftjoyy() * throttle,
                Robot.m_oi.getrightjoyy() * throttle);
    }

    protected boolean isFinished() {

        return false;
    }

    protected void interupt() {

        end();
    }

}
