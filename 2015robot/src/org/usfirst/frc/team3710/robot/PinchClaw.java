package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class PinchClaw {
	Victor claw;

	VariableMap map;
	boolean isClawOpen = true;

	public PinchClaw(VariableMap vm, Victor c) {
		map = vm;
		claw = c;
	}

	public void openClaw(){
		claw.set(map.PINCH_CLAW_SPEED);
	}

	public void closeClaw() {
		claw.set(-map.PINCH_CLAW_SPEED);
	}

	public boolean getIfClawOpen() {
		return isClawOpen;
	}
}
