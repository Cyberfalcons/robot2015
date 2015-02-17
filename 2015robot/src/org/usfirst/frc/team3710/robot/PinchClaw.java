package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class PinchClaw {
	Victor claw;

	boolean isClawOpen = true;

	public PinchClaw(Victor c) {
		claw = c;
	}

	public void openClaw(){
		claw.set(VariableMap.PINCH_CLAW_SPEED);
	}

	public void closeClaw() {
		claw.set(-VariableMap.PINCH_CLAW_SPEED);
	}
	
	public void stopClaw() {
		claw.set(0);
	}

	public boolean getIfClawOpen() {
		return isClawOpen;
	}
}
