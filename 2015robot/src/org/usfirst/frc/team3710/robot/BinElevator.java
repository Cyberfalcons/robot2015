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
		if (getTop() == false) {
			//pid.enable();
			//binElevator.set(pid.getSetpoint());
			binElevator.set(VariableMap.BIN_ELEVATOR_CHAIN_SPEED);
		} else {
			setChainStopped();
		}
	}

	public void setChainDown() {
		updatePot();
		if (getBottom() == false) {
			//pid.enable();
			//binElevator.set(-pid.getSetpoint());
			binElevator.set(-VariableMap.BIN_ELEVATOR_CHAIN_SPEED);
		} else {
			potHeight = 0;
			setChainStopped();
		}
	}

	public void setChainStopped() {
		pid.disable();
		binElevator.set(0);
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
	
	private void updatePot()
	{
		potHeight = heightPot.getValue();
	}
}
