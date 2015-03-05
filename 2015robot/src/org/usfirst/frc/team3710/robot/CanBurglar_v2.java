package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class CanBurglar_v2 {
	Victor canBurglarVictor;
	DigitalInput retractedSwitch;
	Servo releaseServo;

	public CanBurglar_v2(Victor v, DigitalInput l, Servo r1) {
		canBurglarVictor = v;
		retractedSwitch = l;
		releaseServo = r1;
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

	public void setServoPosition(double position) {
		releaseServo.set(position);
	}
}
