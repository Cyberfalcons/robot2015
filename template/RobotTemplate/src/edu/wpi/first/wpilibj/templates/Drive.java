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
    Jaguar left;
    Jaguar right;
    DigitalInput stepBumper;
    Encoder encRight;
    Encoder encLeft;      
    
    public Drive(){
        left = new Jaguar(VariableMap.PWM_DRIVE_LEFT);
        right = new Jaguar(VariableMap.PWM_DRIVE_RIGHT);
        stepBumper = new DigitalInput(VariableMap.DIO_STEP_BUMPER);
        encLeft = new Encoder(VariableMap.DIO_DRIVE_ENC_LEFT);
        encRight = new Encoder(VariableMap.DIO_DRIVE_ENC_RIGHT);
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
