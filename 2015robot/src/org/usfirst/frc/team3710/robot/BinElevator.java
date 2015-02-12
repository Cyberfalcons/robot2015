package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class BinElevator {
	Victor binElevator;
	Encoder encChain;
	DigitalInput top;
	DigitalInput bottom;

	public BinElevator(Victor v, Encoder e, DigitalInput to, DigitalInput b) {
		binElevator = v;
		encChain = e;
		top = to;
		bottom = b;

		encChain.setMaxPeriod(.1);
		encChain.setMinRate(10);
		encChain.setDistancePerPulse(5);
		encChain.setReverseDirection(false);
		encChain.setSamplesToAverage(7);
	}

	public void raiseBin(int distance) {
		if (getEncoderEnc() != distance) {
			setChainUp();
		}
	}

	public void lowerBin() {
		setChainDown();
	}

	private void setChainUp() {
		binElevator.set(VariableMap.BIN_ELEVATOR_CHAIN_SPEED);
	}

	private void setChainDown() {
		binElevator.set(-VariableMap.BIN_ELEVATOR_CHAIN_SPEED);
	}

	public int getEncoderEnc() {
		return encChain.get();
	}

	public void resetEncoder() {
		encChain.reset();
	}
}
