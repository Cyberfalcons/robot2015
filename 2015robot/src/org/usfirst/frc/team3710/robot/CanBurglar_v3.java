package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class CanBurglar_v3 {
	DoubleSolenoid solenoid;
	boolean retracted = true;

	public CanBurglar_v3(DoubleSolenoid ds) {
		solenoid = ds;
	}

	public void retract() {
		if(retracted == false){
			solenoid.set(DoubleSolenoid.Value.kForward);
		}
	}

	public void deploy() {
		if(retracted == true){
			solenoid.set(DoubleSolenoid.Value.kReverse);
		}
	}
	
	public void stop(){
		solenoid.set(DoubleSolenoid.Value.kOff);
	}
}
