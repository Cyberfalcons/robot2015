/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author Alex
 * @author Michelle
 */
public class RollerClaw {
    //TODO: move to VariableMap
   double rollerSpeed = 1;
    
    Jaguar leftRoller;
    Jaguar rightRoller;
    
    /**
     * bin is fully in, want to stop rollers
     */
    DigitalInput binThere;
    
    public RollerClaw() {
        leftRoller = new Jaguar (2);
        rightRoller = new Jaguar (3);
        binThere = new DigitalInput (1);
            
    }
    //TODO: check direction
    private void rightRollerIn() {
      rightRoller.set(rollerSpeed);
    }
    private void rightRollerOut() {
      rightRoller.set(-rollerSpeed);
    }
    private void rightRollerStop() {
      rightRoller.set(0);
    }
    
    private void leftRollerIn() {
      leftRoller.set(rollerSpeed);
    }
    private void leftRollerOut() {
      leftRoller.set(-rollerSpeed);
    }
    private void leftRollerStop() {
      leftRoller.set(0);
    }
    public void binIn() {
        if (binThere.get()) {
           leftRollerStop();
           rightRollerStop();
        }
        else {
            leftRollerIn();
            rightRollerIn();
        }
    }
        
    public void binOut() {
        rightRollerOut();
        leftRollerOut();
    }
    
    public void binClockWise() {
        rightRollerIn();
        leftRollerOut();
    }
    
    public void binCounterClockWise(){
        rightRollerOut();
        leftRollerIn();
    }
    
    public void stop() {
        rightRollerStop();
        leftRollerStop();
    }
            
}
