package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class ToteElevator {
	Victor toteElevator;
	Encoder encChain;
	DigitalInput top;
	DigitalInput bottom;
	PIDController pid;
	int position = 0;
	int topLocation = Integer.MAX_VALUE;
	int bottomLocation = Integer.MIN_VALUE;

	public ToteElevator(Victor v, Encoder e, DigitalInput to, DigitalInput b, PIDController p) {
		toteElevator = v;
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

	public void setPIDPositionUp() {
		//Elevator Dummy Mode
		//toteElevator.set(0.5);
	    
		//Elevator PID Control
		if (getTop() == false) {
			if ((position + 40) < topLocation) {
				pid.enable();
				position = position + 40;
				pid.setSetpoint(position);
			}
		} else {
			pid.enable();
			topLocation = getEncoder();
			position = position - 20;
			pid.setSetpoint(position);

			if (VariableMap.VERBOSE_CONSOLE) {
				System.out.println("ELEVATOR UP DISABLED BY LIMIT SWITCH!");
			}
		}
	}

	public void setPIDPositionDown() {
		//Elevator Dummy Mode
		//toteElevator.set(-0.5);
		
		//Elevator PID Control
		if (getBottom() == false) {
			if((position - 40) > bottomLocation){
				pid.enable();
				position = position - 40;
				pid.setSetpoint(position);
			}
		}else{
			resetEncoder();
			pid.disable();
			if (VariableMap.VERBOSE_CONSOLE) {
				System.out.println("ELEVATOR DOWN DISABLED BY LIMIT SWITCH");
			}
		}
	}
	
	public void setPIDPositionZero(){
		
	}

	public void stopElevator() {
		toteElevator.set(0.0);
	}

	public int getEncoder() {
		return encChain.get();
	}

	public int getPIDPosition() {
		return position;
	}

	public void setSetPoint(int point) {
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

	public void disablePID() {
		pid.disable();
		position = 0;
		toteElevator.set(0.0);
	}
}
