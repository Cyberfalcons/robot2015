package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class BinElevator {
	Victor binElevator;	
	Encoder encChain;
	DigitalInput top;
	DigitalInput bottom;
	PIDController pid;
	int position = 0;
	int topLocation = 0;
	boolean sensorsDisabled = false;

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
		if(sensorsDisabled != true){
			pid.enable();
			if (getTop() == false) {
				position = position + 40;
				pid.setSetpoint(position);
			} else if (getTop() == true) {
				topLocation = getEncoder();
				position = position - 20;
				pid.setSetpoint(position);

				if (VariableMap.VERBOSE_CONSOLE) {
					System.out.println("ELEVATOR UP DISABLED BY LIMIT SWITCH!");
				}
			}
		}else if(sensorsDisabled){
			pid.disable();
			binElevator.set(0.5);
		}
	}

	public void setPositionDown() {
		if(sensorsDisabled != true){
			pid.enable();
			if (getBottom() == false) {
				position = position - 40;
				pid.setSetpoint(position);
			} else if (getBottom() == true) {
				resetEncoder();
				if (VariableMap.VERBOSE_CONSOLE) {
					System.out.println("ELEVATOR DOWN DISABLED BY LIMIT SWITCH");
				}
			}
		}else if(sensorsDisabled){
			pid.disable();
			binElevator.set(-0.5);
		}
	}
	
	public void stopElevator(){
		binElevator.set(0.0);
	}

	public int getEncoder() {
		return encChain.get();
	}
	
	public int getPIDPosition(){
		return position;
	}
	
	public int getTopLocation(){
		return topLocation;
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
	
	public void setSensorsDisabled(boolean b){
		sensorsDisabled = b;
		if(sensorsDisabled == true){
			pid.disable();
			position = 0;
		}
	}
	
	public boolean getSensorsDisabled(){
		return sensorsDisabled;
	}
	
	public void disablePID(){
		pid.disable();
	}
	
	public void resetPosition(){
		position = 0;
	}
}
