package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class CanBurglar_v2 {
	Victor canBurglarVictor;
	DigitalInput retractedSwitch;
	Servo release1;

	public CanBurglar_v2(Victor v, DigitalInput l, Servo r1) {
		canBurglarVictor = v;
		retractedSwitch = l;
		release1 = r1;
	}

	public void retract() {
//		if (getLimitSwitch() != true) {
			retractString();
//		}
	}

	public void extend() {
		if (getLimitSwitch() != false) {
			extendString();
		}
	}

	void retractString() {
		canBurglarVictor.set(0.75);
	}

	private void extendString() {

	}

	public void stop() {
		canBurglarVictor.set(0.0);
	}

	public boolean getLimitSwitch() {
		return retractedSwitch.get();
	}
	
	public void servoTo1()
	{
		release1.setPosition(1.0);
	}
	
	public void servoToMinus1()
	{
		release1.setPosition(-1.0);
	}
	
	public void servoTo0()
	{
		release1.setPosition(0.0);
	}
}
