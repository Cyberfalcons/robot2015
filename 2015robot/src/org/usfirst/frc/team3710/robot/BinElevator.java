package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class BinElevator {
	Victor binElevator;
	Encoder encChain;
	DigitalInput top;
	DigitalInput bottom;
	PIDController pid;
	int position = 0;

	public BinElevator(Victor v, Encoder e, DigitalInput to, DigitalInput b, PIDController p) {
		binElevator = v;
		encChain = e;
		top = to;
		bottom = b;
		pid = p;

		encChain.setMaxPeriod(.1);
		encChain.setMinRate(10);
		encChain.setDistancePerPulse(5);
		encChain.setReverseDirection(false);
		encChain.setSamplesToAverage(7);
	}

	public void setPositionUp() {
		pid.enable();
		if (getTop() == false) {
			position = position + 40;
			pid.setSetpoint(position);
		}
	}

	public void setPositionDown() {
		pid.enable();
		if (getBottom() == false) {
			position = position - 40;
			pid.setSetpoint(position);
		} else {
			resetEncoder();
			stopChain();
			position = 0;
		}
	}

	public void stopChain() {
		pid.setSetpoint(0);
		pid.disable();
	}

	public int getEncoder() {
		return encChain.get();
	}
	
	public void setSetPoint(int point){
		pid.setSetpoint(point);
	}

	public void resetEncoder() {
		encChain.reset();
	}

	public boolean getTop() {
		return top.get();
	}

	public boolean getBottom() {
		return bottom.get();
	}
}
