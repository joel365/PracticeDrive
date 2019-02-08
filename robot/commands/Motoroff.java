package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
/**
 * Add your docs here.
 */
public class Motoroff extends Command {

 public Motoroff(){
    requires(Robot.test);
 }
    @Override
    protected void execute() {
        Robot.test.releaseset();
        
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