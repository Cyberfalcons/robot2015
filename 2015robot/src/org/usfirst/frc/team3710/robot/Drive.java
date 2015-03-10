package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class Drive {
	Talon leftA;
	Talon leftB;
	Talon rightA;
	Talon rightB;
	Encoder encRight;
	Encoder encLeft;
	PIDController pidLeft;
	PIDController pidRight;

	public Drive(Talon la, Talon lb, Talon ra, Talon rb, Encoder el, Encoder er, PIDController lpid, PIDController rpid) {
		leftA = la;
		leftB = lb;
		rightA = ra;
		rightB = rb;

		encLeft = el;
		encLeft.setMaxPeriod(.1);
		encLeft.setMinRate(10);
		encLeft.setDistancePerPulse(5);
		encLeft.setReverseDirection(false);
		encLeft.setSamplesToAverage(7);

		encRight = er;
		encRight.setMaxPeriod(.1);
		encRight.setMinRate(10);
		encRight.setDistancePerPulse(5);
		encRight.setReverseDirection(false);
		encRight.setSamplesToAverage(7);
		
		pidLeft = lpid;
		pidRight = rpid;
	}

	public void setDriveRight(double power) {
		if(VariableMap.SLOW_MODE_DRIVE == true){
			rightA.set(power/2);
			rightB.set(power/2);
		}
		else{
			rightA.set(power);
			rightB.set(power);
		}
	}

	public void setDriveLeft(double power) {
		if(VariableMap.SLOW_MODE_DRIVE == true){
			leftA.set(power/2);
			leftB.set(power/2);
		}
		else{
			leftA.set(power);
			leftB.set(power);
		}
	}
	
	public void setPIDDriveLeft(int position){
		pidLeft.enable();
		pidLeft.setSetpoint(position);
		double output = pidLeft.get();
		setDriveLeft(output);
		
		if(encLeft.get() == position){
			disableLeftPIDControl();
		}
	}
	
	public void setPIDDriveRight(int position){
		pidRight.enable();
		pidRight.setSetpoint(position);
		double output = pidRight.get();
		setDriveRight(output);
		
		if(encRight.get() == position){
			disableRightPIDControl();
		}
	}
	
	public void disableLeftPIDControl(){
		pidLeft.disable();
		leftA.set(0.0);
		leftB.set(0.0);
	}
	
	public void disableRightPIDControl(){
		pidRight.disable();
		rightA.set(0.0);
		rightB.set(0.0);
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
}
