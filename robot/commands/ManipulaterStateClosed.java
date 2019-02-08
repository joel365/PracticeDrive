/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.PneumaticsManipulator;
import frc.robot.*;
import frc.robot.RobotMap;
/**
 * Add your docs here.
 */
public class ManipulaterStateClosed extends Command{
    private int state;
    public ManipulaterStateClosed(int x){
        requires(Robot.grab);
        state = x;
    
      }
      
      
      
        @Override
        protected void execute() {
            if(state == 0){
                Robot.grab.openSolenoid();
            }else if (state == 1){
                Robot.grab.closeSolenoid();
            }    
            state = 3;
            
               
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
