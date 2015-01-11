/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author Alex
 * @author Dylan
 */
public class BinElevator {
	Jaguar binElevator;

	//TODO: figure out how bin elevator works and do it

	public BinElevator() {
		binElevator = new Jaguar(VariableMap.PWM_BIN_ELEVATOR);
	}
	
	public void raiseBin() {
	// TODO: 
	}
	
	private void setChainUp() {
		binElevator.set(VariableMap.BIN_ELEVATOR_CHAIN_SPEED);
		
	}
	
	private void setChainDown() {
		binElevator.set(-VariableMap.BIN_ELEVATOR_CHAIN_SPEED);
	}
    
}
