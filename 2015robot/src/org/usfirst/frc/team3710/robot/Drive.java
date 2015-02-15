package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class Drive {
	Talon leftA;
	Talon leftB;
	Talon rightA;
	Talon rightB;
	Encoder encRight;
	Encoder encLeft;

	public Drive(Talon la, Talon lb, Talon ra, Talon rb, Encoder el, Encoder er) {
		leftA = la;
		rightA = ra;
		leftB = lb;
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
	}

	/**
	 * drives the right side motor at a specified power
	 * 
	 * @param power
	 *            : power to run the motor at
	 */
	public void setDriveRight(double power) {
		rightA.set(power);
		rightB.set(power);
	}

	/**
	 * drives the left side motor at a specified power
	 * 
	 * @param power
	 *            : power to run the motor at
	 */
	public void setDriveLeft(double power) {
		leftA.set(power);
		leftB.set(power);
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

	public void resetLeftEncoder() {
		encLeft.reset();
	}

	public void resetRightEncoder() {
		encRight.reset();
	}
}
