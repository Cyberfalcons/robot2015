package org.usfirst.frc.team3710.robot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ConfigParser {
	public double ElevatorPID_Normal_P;
	public double ElevatorPID_Normal_I;
	public double ElevatorPID_Normal_D;

	public double DrivePID_P;
	public double DrivePID_I;
	public double DrivePID_D;

	public boolean AutoOn;

	public ConfigParser() {

	}

	public void LoadFromFile() {
		File f = new File("file.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public double getElevatorPID_Normal_P() {
		return ElevatorPID_Normal_P;
	}

	public double getElevatorPID_Normal_I() {
		return ElevatorPID_Normal_I;
	}

	public double getElevatorPID_Normal_D() {
		return ElevatorPID_Normal_D;
	}

	public double getDrivePID_P() {
		return DrivePID_P;
	}

	public double getDrivePID_I() {
		return DrivePID_I;
	}

	public double getDrivePID_D() {
		return DrivePID_D;
	}

	public boolean getAutoOn() {
		return AutoOn;
	}
}
