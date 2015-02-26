package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class BinElevator {
	Victor binElevator;
	Encoder encChain;
	DigitalInput top;
	DigitalInput bottom;
	PIDController pid;
	AnalogInput heightPot;

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
		if (getTop() == false) {
			binElevator.set(VariableMap.BIN_ELEVATOR_CHAIN_SPEED);
		} else {
			setChainStopped();
		}
	}

	public void setChainDown() {
		if (getBottom() == false) {
			binElevator.set(-VariableMap.BIN_ELEVATOR_CHAIN_SPEED);
		} else {
			setChainStopped();
		}
	}

	public void setChainStopped() {
		binElevator.set(0);
	}

	public int getEncoderEnc() {
		return encChain.get();
	}

	public void resetEncoder() {
		encChain.reset();
	}

	public double getPotHeight() {
		return heightPot.getValue();
	}

	public boolean getTop() {
		return top.get();
	}

	public boolean getBottom() {
		return bottom.get();
	}
}
