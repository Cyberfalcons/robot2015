package org.usfirst.frc.team3710.robot;

public class ConfigParser {
	public double ElevatorPID_Normal_P;
	public double ElevatorPID_Normal_I;
	public double ElevatorPID_Normal_D;
	
	public double ElevatorPID_Jerky_P;
	public double ElevatorPID_Jerky_I;
	public double ElevatorPID_Jerky_D;
	
	public double DrivePID_P;
	public double DrivePID_I;
	public double DrivePID_D;
	
	public ConfigParser(){
		
	}

	public double getElevatorPID_Normal_P() {
		return ElevatorPID_Normal_P;
	}

	public void setElevatorPID_Normal_P(double elevatorPID_Normal_P) {
		ElevatorPID_Normal_P = elevatorPID_Normal_P;
	}

	public double getElevatorPID_Normal_I() {
		return ElevatorPID_Normal_I;
	}

	public void setElevatorPID_Normal_I(double elevatorPID_Normal_I) {
		ElevatorPID_Normal_I = elevatorPID_Normal_I;
	}

	public double getElevatorPID_Normal_D() {
		return ElevatorPID_Normal_D;
	}

	public void setElevatorPID_Normal_D(double elevatorPID_Normal_D) {
		ElevatorPID_Normal_D = elevatorPID_Normal_D;
	}

	public double getElevatorPID_Jerky_P() {
		return ElevatorPID_Jerky_P;
	}

	public void setElevatorPID_Jerky_P(double elevatorPID_Jerky_P) {
		ElevatorPID_Jerky_P = elevatorPID_Jerky_P;
	}

	public double getElevatorPID_Jerky_I() {
		return ElevatorPID_Jerky_I;
	}

	public void setElevatorPID_Jerky_I(double elevatorPID_Jerky_I) {
		ElevatorPID_Jerky_I = elevatorPID_Jerky_I;
	}

	public double getElevatorPID_Jerky_D() {
		return ElevatorPID_Jerky_D;
	}

	public void setElevatorPID_Jerky_D(double elevatorPID_Jerky_D) {
		ElevatorPID_Jerky_D = elevatorPID_Jerky_D;
	}

	public double getDrivePID_P() {
		return DrivePID_P;
	}

	public void setDrivePID_P(double drivePID_P) {
		DrivePID_P = drivePID_P;
	}

	public double getDrivePID_I() {
		return DrivePID_I;
	}

	public void setDrivePID_I(double drivePID_I) {
		DrivePID_I = drivePID_I;
	}

	public double getDrivePID_D() {
		return DrivePID_D;
	}

	public void setDrivePID_D(double drivePID_D) {
		DrivePID_D = drivePID_D;
	}
}
