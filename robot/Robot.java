/**
 * Phoenix Software License Agreement
 *
 * Copyright (C) Cross The Road Electronics.  All rights
 * reserved.
 * 
 * Cross The Road Electronics (CTRE) licenses to you the right to 
 * use, publish, and distribute copies of CRF (Cross The Road) firmware files (*.crf) and 
 * Phoenix Software API Libraries ONLY when in use with CTR Electronics hardware products
 * as well as the FRC roboRIO when in use in FRC Competition.
 * 
 * THE SOFTWARE AND DOCUMENTATION ARE PROVIDED "AS IS" WITHOUT
 * WARRANTY OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING WITHOUT
 * LIMITATION, ANY WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, TITLE AND NON-INFRINGEMENT. IN NO EVENT SHALL
 * CROSS THE ROAD ELECTRONICS BE LIABLE FOR ANY INCIDENTAL, SPECIAL, 
 * INDIRECT OR CONSEQUENTIAL DAMAGES, LOST PROFITS OR LOST DATA, COST OF
 * PROCUREMENT OF SUBSTITUTE GOODS, TECHNOLOGY OR SERVICES, ANY CLAIMS
 * BY THIRD PARTIES (INCLUDING BUT NOT LIMITED TO ANY DEFENSE
 * THEREOF), ANY CLAIMS FOR INDEMNITY OR CONTRIBUTION, OR OTHER
 * SIMILAR COSTS, WHETHER ASSERTED ON THE BASIS OF CONTRACT, TORT
 * (INCLUDING NEGLIGENCE), BREACH OF WARRANTY, OR OTHERWISE
 */

/**
 * Description:
 * The ArcadeDrive_AuxFeedForward example demonstrates the ability to create an Arcade
 * Drive based robot by using the Talon's and Victor's Feed Forward feature. 
 * 
 * The Auxiliary Feed Forward feature allows the user to apply more or less output on 
 * the motor controllers current control mode's output, regardless of it being open or closed. 
 * 
 * Controls:
 * Left Joystick Y-Axis: Drive robot forward and reverse
 * Right Joystick X-Axis: Turn robot right and left
 * 
 * Supported Version:
 * 	- Talon SRX: 4.0
 * 	- Victor SPX: 4.0
 * 	- Pigeon IMU: 4.0
 * 	- CANifier: 4.0
 */
package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.EncoderMotor;
import frc.robot.subsystems.PneumaticsManipulator;

public class Robot extends TimedRobot {
  /** Hardware, either Talon could be a Victor */
  public static DriveBase driveBase = new DriveBase();
  public static OI oi = new OI();
  public static UI ui = new UI();
  public static EncoderMotor test = new EncoderMotor();
  public static PneumaticsManipulator grab = new PneumaticsManipulator();
 //this thread is for the camera
 //Thread m_visionThread;

  @Override
  public void robotInit() {
   SmartDashboard.putData(Scheduler.getInstance());
   CameraServer.getInstance().startAutomaticCapture();
   grab.startCompressor();
}

  

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {
    ui.update();
    oi.update();
    Scheduler.getInstance().run();
  }

  

}
