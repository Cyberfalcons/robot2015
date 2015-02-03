package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class ToteElevator {

	VariableMap map;
	Jaguar toteElevator;
	DigitalInput toteBottom;
	DigitalInput toteTop;

	public ToteElevator(VariableMap vm) {
		map = vm;
		toteElevator = new Jaguar(map.PWM_TOTE_ELEVATOR);
		toteBottom = new DigitalInput(map.DIO_TOTE_ELEVATOR_BOTTOM);
		toteTop = new DigitalInput(map.DIO_TOTE_ELEVATOR_TOP);
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
		toteElevator.set(map.TOTE_ELEVATOR_CHAIN_SPEED);
	}

	private void setChainDown() {
		toteElevator.set(map.TOTE_ELEVATOR_CHAIN_SPEED);
	}
}
