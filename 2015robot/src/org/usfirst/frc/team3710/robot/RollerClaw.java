package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.DigitalInput;

public class RollerClaw {
        VariableMap map;

	Jaguar leftRoller;
	Jaguar rightRoller;

	/**
	* Is the bin fully in?
	*/
	DigitalInput binThere;

	public RollerClaw(VariableMap vm) {
                map = vm;
		leftRoller = new Jaguar(map.PWM_ROLLER_LEFT);
		rightRoller = new Jaguar(map.PWM_ROLLER_RIGHT);
		binThere = new DigitalInput(map.DIO_BIN_IN_THROAT);  
	}
	
	//TODO: check directions
	private void rightRollerIn() {
		rightRoller.set(VariableMap.CLAW_ROLLER_SPEED);
	}
	
	private void rightRollerOut() {
		rightRoller.set(-VariableMap.CLAW_ROLLER_SPEED);
	}
	
	private void rightRollerStop() {
		rightRoller.set(0);
	}

	private void leftRollerIn() {
		leftRoller.set(VariableMap.CLAW_ROLLER_SPEED);
	}
	
	private void leftRollerOut() {
		leftRoller.set(-VariableMap.CLAW_ROLLER_SPEED);
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
