package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class CanBurglar {
	Solenoid binRetractor;
	boolean isRetracted = false;

	public CanBurglar(Solenoid s) {
		binRetractor = s;
	}

	public void extend() {
		if (isRetracted == true) {
			binRetractor.set(true);
			isRetracted = false;
		}
	}

	public void retract() {
		if (isRetracted == false) {
			binRetractor.set(false);
			isRetracted = true;
		}
	}

	public boolean getRetractedState() {
		return isRetracted;
	}
}
