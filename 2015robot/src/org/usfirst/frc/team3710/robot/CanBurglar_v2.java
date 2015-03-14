package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class CanBurglar_v2 {
	Victor canBurglarVictor;
	DigitalInput retractedSwitch;
	Servo servo1, servo2;
	boolean servosToggled;

	public CanBurglar_v2(Victor v, DigitalInput l, Servo r1, Servo r2) {
		canBurglarVictor = v;
		retractedSwitch = l;
		servo1 = r1;
		servo2 = r2;
	}

	public void retract() {
		retractString();
	}

	void retractString() {
		canBurglarVictor.set(0.75);
	}


	public void stop() {
		canBurglarVictor.set(0.0);
	}

	public boolean getLimitSwitch() {
		return retractedSwitch.get();
	}
	
	public boolean getServosMoved(){
		return servosToggled;
	}
	
	public void setServosMoved(boolean b){
		servosToggled = b;
	}

	public void toggleServos() {
		if(servosToggled != true){
			servo1.set(1.0);
			servo2.set(-1.0);
			servosToggled = true;
		}
		else if(servosToggled == true){
			servo1.set(-1.0);
			servo2.set(1.0);
			servosToggled = false;
		}
	}
}
