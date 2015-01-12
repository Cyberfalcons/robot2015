/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author Alex
 */
public class BinElevator {
     //TODO: move to VariableMap
   double chainSpeed = 1;
    Jaguar binElevator;
    Encoder encChain;
   
    
    
    //TODO: figure out how bin elevator works and do it
    
    public BinElevator () {
        binElevator = new Jaguar (4);
    }
    public void raiseBin () {
    // TODO: 
    }
    private void setChainUp () {
        binElevator.set (chainSpeed);
        
    }
    private void setChainDown () {
        binElevator.set (-chainSpeed);
        
    }
    public int getEncoderEnc () {
        return encChain.get ();
    }
}
