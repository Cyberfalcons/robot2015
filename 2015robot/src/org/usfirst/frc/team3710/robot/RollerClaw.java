package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class RollerClaw {
	Victor leftRoller;
	Victor rightRoller;
	PowerDistributionPanel pdp;
	double leftCurrent = 0.0;
	double rightCurrent = 0.0;
	double currentCutOff = 5.0;

	public RollerClaw(Victor l, Victor r) {
		leftRoller = l;
		rightRoller = r;
		pdp = new PowerDistributionPanel();
	}

	private void rightRollerIn() {
		if (rightCurrent < currentCutOff) {
			rightRoller.set(-VariableMap.CLAW_ROLLER_SPEED);
		}
	}

	private void rightRollerOut() {
		if (rightCurrent < currentCutOff) {
			rightRoller.set(VariableMap.CLAW_ROLLER_SPEED);
		}
	}

	private void rightRollerStop() {
		rightRoller.set(0);
	}

	private void leftRollerIn() {
		if (leftCurrent < currentCutOff) {
			leftRoller.set(VariableMap.CLAW_ROLLER_SPEED);
		}
	}

	private void leftRollerOut() {
		if (leftCurrent < currentCutOff) {
			leftRoller.set(-VariableMap.CLAW_ROLLER_SPEED);
		}
	}

	private void leftRollerStop() {
		leftRoller.set(0);
	}

	public void binIn() {
		leftRollerIn();
		rightRollerIn();
		updateCurrents();
	}

	public void binOut() {
		rightRollerOut();
		leftRollerOut();
		updateCurrents();
	}

	public void binClockWise() {
		rightRollerIn();
		leftRollerOut();
		updateCurrents();
	}

	public void binCounterClockWise() {
		rightRollerOut();
		leftRollerIn();
		updateCurrents();
	}

	public void stop() {
		rightRollerStop();
		leftRollerStop();
		updateCurrents();
	}

	private void updateCurrents() {
		leftCurrent = pdp.getCurrent(9);
		rightCurrent = pdp.getCurrent(10);
	}
}
