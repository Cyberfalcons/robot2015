package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class CanBurglar {

	VariableMap map;
	Solenoid binRetractor;
	boolean isRetracted = false;

	public CanBurglar(VariableMap vm) {
		map = vm;
		binRetractor = new Solenoid(map.SOL_CAN_BURGLAR);
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
