package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class CanBurglar_v2 {
	Victor canBurglarVictor;
	DigitalInput retractedSwitch;
	Servo servo1, servo2;
	boolean servosMoved;

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
		return servosMoved;
	}
	
	public void setServosMoved(boolean b){
		servosMoved = b;
	}

	public void toggleServos() {
		if(servosMoved == true){
			servo1.set(1.0);
			servo2.set(-1.0);
		}
		else{
			servo1.set(-1.0);
			servo2.set(1.0);
		}
	}
}
