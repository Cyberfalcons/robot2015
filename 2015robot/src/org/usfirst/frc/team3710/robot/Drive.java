package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class Drive {
	VariableMap map;

	Jaguar left;
	Jaguar right;
	Encoder encRight;
	Encoder encLeft;

	public Drive(VariableMap vm, Jaguar l, Jaguar r, Encoder el, Encoder er) {
		map = vm;
		left = l;
		right = r;
		encRight = er;
		encLeft = el;
	}

	/**
	 * drives the right side motor at a specified power
	 * 
	 * @param power
	 *            : power to run the motor at
	 */
	public void setDriveRight(double power) {
		right.set(power);
	}

	/**
	 * drives the left side motor at a specified power
	 * 
	 * @param power
	 *            : power to run the motor at
	 */
	public void setDriveLeft(double power) {
		left.set(power);
	}

	/**
	 * get how far the encoder has turned
	 * 
	 * @return
	 */
	public int getEncoderRight() {
		return encRight.get();
	}

	/**
	 * get how far the encoder has turned
	 * 
	 * @return
	 */
	public int getEncoderLeft() {
		return encLeft.get();
	}
}
