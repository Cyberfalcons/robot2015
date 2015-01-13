/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author Alex
 * @author Dylan
 */
public class Drive {
    VariableMap map;
    
    Jaguar left;
    Jaguar right;
    DigitalInput stepBumper;
    Encoder encRight;
    Encoder encLeft;      
    
    public Drive(VariableMap vm){
        map = vm;
        left = new Jaguar(vm.PWM_DRIVE_LEFT);
        right = new Jaguar(map.PWM_DRIVE_RIGHT);
        stepBumper = new DigitalInput(map.DIO_STEP_BUMPER);
        encLeft = new Encoder(map.DIO_DRIVE_ENC_LEFT_A, map.DIO_DRIVE_ENC_LEFT_B);
        encRight = new Encoder(map.DIO_DRIVE_ENC_RIGHT_A, map.DIO_DRIVE_ENC_RIGHT_B);
    }
    /**
     * drives the right side motor at a specified power
     * @param power: power to run the motor at
     */
    public void setDriveRight (double power){
        right.set(power);
    }
    
    /**
     * drives the left side motor at a specified power
     * @param power: power to run the motor at
     */
    public void setDriveLeft (double power) {
        left.set(power);
    }
    
    /**
     * determines if the robot is up against a wall
     * @return boolean true if against wall
     */
    public boolean getHitStep () {
        return stepBumper.get(); 
    }
    
    /**
     * get how far the encoder has turned
     * @return 
     */
    public int getEncoderRight () {
        return encRight.get();
    }
  
    /**
     * get how far the encoder has turned
     * @return 
     */
    public int getEncoderLeft () {
        return encLeft.get();
    }
}
