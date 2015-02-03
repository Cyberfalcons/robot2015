package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class BinElevator {
	VariableMap map;
	Jaguar binElevator;
	Encoder encChain;

	// TODO: figure out how bin elevator works and do it

	public BinElevator(VariableMap vm) {
		map = vm;
		binElevator = new Jaguar(map.PWM_BIN_ELEVATOR);

		encChain = new Encoder(map.DIO_BIN_ELEVATOR_ENC_A,
				map.DIO_BIN_ELEVATOR_ENC_B, false, Encoder.EncodingType.k4X);
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
		binElevator.set(map.BIN_ELEVATOR_CHAIN_SPEED);
	}

	private void setChainDown() {
		binElevator.set(-map.BIN_ELEVATOR_CHAIN_SPEED);
	}

	public int getEncoderEnc() {
		return encChain.get();
	}
}
