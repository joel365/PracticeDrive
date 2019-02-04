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
    LEFTMOTOR_1(1), LEFTMOTOR_2(4), RIGHTMOTOR_1(2), RIGHTMOTOR_2(3),
    JOYSTICK_LX(0), JOYSTICK_LY(1), JOYSTICK_LT(2),
    JOYSTICK_RX(4), JOYSTICK_RY(5), JOYSTICK_RT(3),
    ;
    public int value;
    RobotMap(int value){
        this.value = value;
    }
}
