/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public enum RobotMap {
   //current motor ID's
    LEFTMOTOR_1(1), LEFTMOTOR_2(4), RIGHTMOTOR_1(2), RIGHTMOTOR_2(3), ENCODER_MOTOR(8),
    
    // axis and trigger joystick ID's
    JOYSTICK_LX(0), JOYSTICK_LY(1), JOYSTICK_LT(2),
    JOYSTICK_RX(4), JOYSTICK_RY(5), JOYSTICK_RT(3),

    //Button Joystick ID's
    JOYSTICK_A(1), JOYSTICK_B(2), JOYSTICK_X(3), JOYSTICK_Y(4),

    // directive input for type of control values
    TANK_DRIVE(0), ARCADE_DRIVE(1),PISTON_OPEN(0),PISTON_CLOSED(1),
    
    // this will be the commands for all the Pneumatics
    COMPRESSOR_ID(1), SOLENOID_OPEN_ID(1),SOLENOID_CLOSE_ID(2)

    ;
    public int value;
    RobotMap(int value){
        this.value = value;
    }
}


 
