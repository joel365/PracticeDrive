/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ManipulaterStateClosed;
/**
 * Add your docs here.
 */
public class PneumaticsManipulator extends Subsystem{

    Compressor mainCompressor;
    Solenoid pistonExtSolenoid;
    Solenoid pistonCntSolenoid;


    public PneumaticsManipulator(){
        mainCompressor = new Compressor(1);
        
        pistonCntSolenoid = new Solenoid(1);
        pistonExtSolenoid = new Solenoid(2);

    }
    public void startCompressor(){
        mainCompressor.start();
    }

    public void openSolenoid(){


    }
    public void closeSolenoid(){


    }

    public void initDefaultCommand(){
        
    }
}
