package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class Drive {
	Talon leftA;
	Talon rightA;
	Encoder encRight;
	Encoder encLeft;
	PIDController pidLeft;
	PIDController pidRight;

	public Drive(Talon la, Talon ra, Encoder el, Encoder er, PIDController lpid, PIDController rpid) {
		leftA = la;
		rightA = ra;

		encLeft = el;
		encLeft.setMaxPeriod(.1);
		encLeft.setMinRate(10);
		encLeft.setDistancePerPulse(1);
		encLeft.setReverseDirection(false);
		encLeft.setSamplesToAverage(7);

		encRight = er;
		encRight.setMaxPeriod(.1);
		encRight.setMinRate(10);
		encRight.setDistancePerPulse(1);
		encRight.setReverseDirection(false);
		encRight.setSamplesToAverage(7);
		
		pidLeft = lpid;
		pidRight = rpid;
	}

	public void setDriveRight(double power) {
		if(VariableMap.SLOW_MODE_DRIVE == true){
			rightA.set((power/2));
		}
		else{
			rightA.set((power / 0.85));
		}
	}

	public void setDriveLeft(double power) {
		if(VariableMap.SLOW_MODE_DRIVE == true){
			leftA.set((power/2));
		}
		else{
			leftA.set((power / 0.85));
		}
	}
	
	public void setPIDDriveLeft(int position){
		pidLeft.enable();
		pidLeft.setSetpoint(position);
	}
	
	public void setPIDDriveRight(int position){
		pidRight.enable();
		pidRight.setSetpoint(position);
	}
	
	public void disableLeftPIDControl(){
		pidLeft.disable();
		leftA.set(0.0);
	}
	
	public void disableRightPIDControl(){
		pidRight.disable();
		rightA.set(0.0);
	}

	public int getEncoderRight() {
		return encRight.get();
	}

	public int getEncoderLeft() {
		return encLeft.get();
	}

	public void resetLeftEncoder() {
		encLeft.reset();
	}

	public void resetRightEncoder() {
		encRight.reset();
	}
	
	public void flipSlowMode(){
		if(VariableMap.SLOW_MODE_DRIVE == false){
			VariableMap.SLOW_MODE_DRIVE = true;
		}else if(VariableMap.SLOW_MODE_DRIVE == true){
			VariableMap.SLOW_MODE_DRIVE = false;
		}
	}
}
