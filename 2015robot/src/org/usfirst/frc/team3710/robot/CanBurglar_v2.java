package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class CanBurglar_v2 {
	Victor canBurglarVictor;
	DigitalInput retractedSwitch;

	public CanBurglar_v2(Victor v, DigitalInput l) {
		canBurglarVictor = v;
		retractedSwitch = l;
	}

	public void retract() {
		if (getLimitSwitch() != true) {
			retractString();
		}
	}

	public void extend() {
		if (getLimitSwitch() != false) {
			extendString();
		}
	}

	private void retractString() {

	}

	private void extendString() {

	}

	public void stop() {
		canBurglarVictor.set(0.0);
	}

	public boolean getLimitSwitch() {
		return retractedSwitch.get();
	}
}
