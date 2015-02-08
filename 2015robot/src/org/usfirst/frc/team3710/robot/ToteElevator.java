package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class ToteElevator {
	Talon toteElevator;
	DigitalInput toteBottom;
	DigitalInput toteTop;

	public ToteElevator(Talon t, DigitalInput tB, DigitalInput tT) {
		toteElevator = t;
		toteBottom = tB;
		toteTop = tT;
	}

	public void raiseStack() {
		if (getTop() != true) {
			setChainUp();
		}
	}

	public void lowerStack() {
		if (getBottom() != true) {
			setChainDown();
		}
	}

	public boolean getBottom() {
		return toteBottom.get();
	}

	public boolean getTop() {
		return toteTop.get();
	}

	private void setChainUp() {
		toteElevator.set(VariableMap.TOTE_ELEVATOR_CHAIN_SPEED);
	}

	private void setChainDown() {
		toteElevator.set(VariableMap.TOTE_ELEVATOR_CHAIN_SPEED);
	}
}
