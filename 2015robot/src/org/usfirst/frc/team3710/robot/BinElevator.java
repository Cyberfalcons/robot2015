package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class BinElevator {
	Victor binElevator;
	Encoder encChain;
	DigitalInput top;
	DigitalInput bottom;
	PIDController pid;
	AnalogInput heightPot;

	int potHeight = 0;

	boolean goingUp = false;
	boolean goingDown = false;

	public BinElevator(Victor v, Encoder e, DigitalInput to, DigitalInput b, PIDController p, AnalogInput pot) {
		binElevator = v;
		encChain = e;
		top = to;
		bottom = b;
		pid = p;
		heightPot = pot;

		encChain.setMaxPeriod(.1);
		encChain.setMinRate(10);
		encChain.setDistancePerPulse(5);
		encChain.setReverseDirection(false);
		encChain.setSamplesToAverage(7);
	}

	public void setChainUp() {
		updatePot();
		pid.enable();
		goingDown = false;
		goingUp = true;

		if (getTop() == false) {
			//binElevator.set(VariableMap.BIN_ELEVATOR_CHAIN_SPEED);
			pid.setSetpoint(1500);
		} else {
			stopChain();
		}
	}

	public void setChainDown() {
		updatePot();
		pid.enable();
		goingDown = true;
		goingUp = false;

		if (getBottom() == false) {
			//binElevator.set(-VariableMap.BIN_ELEVATOR_CHAIN_SPEED);
			pid.setSetpoint(0);
		} else {
			potHeight = 0;
			stopChain();
		}
	}

	public void setConstantForce() {
		if (goingUp) {
			//binElevator.set(VariableMap.BIN_ELEVATOR_CONSTANT_FORCE);
		} else if (goingDown) {
			//binElevator.set(-VariableMap.BIN_ELEVATOR_CONSTANT_FORCE);
		}
	}

	public void stopChain() {
		//binElevator.set(0);
		pid.disable();
		goingUp = false;
		goingDown = false;
	}

	public int getEncoderEnc() {
		return encChain.get();
	}

	public void resetEncoder() {
		encChain.reset();
	}

	public double getPotHeight() {
		return potHeight;
	}

	public boolean getTop() {
		return top.get();
	}

	public boolean getBottom() {
		return bottom.get();
	}

	private void updatePot() {
		potHeight = heightPot.getValue();
	}
}
