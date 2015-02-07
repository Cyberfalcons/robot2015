package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class PinchClaw {
	Victor claw;

	VariableMap map;
	boolean isClawOpen = true;

	public PinchClaw(VariableMap vm) {
		map = vm;
		claw = new Victor(map.PWM_PINCH_CLAW);
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
