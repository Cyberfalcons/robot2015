package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class JoystickControllerWrapper extends Controller {
	Joystick left;
	Joystick right;

	public JoystickControllerWrapper(int usbL, int usbR) {
		left = new Joystick(usbL);
		right = new Joystick(usbR);
	}
	
	/*
	 * Initialize for operator (one joystick)
	 */
	public JoystickControllerWrapper(int usb) {
		right = new Joystick(usb);
	}

	@Override
	public double getRightX() {
		return right.getX();
	}

	@Override
	public double getRightY() {
		return right.getY();
	}

	@Override
	public double getLeftX() {
		return left.getX();
	}

	@Override
	public double getLeftY() {
		return left.getY();
	}

	@Override
	public boolean getRightButton1() {
		return right.getRawButton(1);
	}

	@Override
	public boolean getRightButton2() {
		return right.getRawButton(2);
	}

	@Override
	public boolean getRightButton3() {
		return right.getRawButton(3);
	}

	@Override
	public boolean getRightButton4() {
		return right.getRawButton(4);
	}

	@Override
	public boolean getRightButton5() {
		return right.getRawButton(5);
	}

	@Override
	public boolean getRightButton6() {
		return right.getRawButton(6);
	}

	@Override
	public boolean getRightButton7() {
		return right.getRawButton(7);
	}

	public boolean getRightButton8() {
		return right.getRawButton(8);
	}

	@Override
	public boolean getRightButton9() {
		return right.getRawButton(9);
	}

	@Override
	public boolean getRightButton10() {
		return right.getRawButton(10);
	}

	@Override
	public boolean getRightButton11() {
		return right.getRawButton(11);
	}

	@Override
	public boolean getLeftButton1() {
		return left.getRawButton(1);
	}

	@Override
	public boolean getLeftButton2() {
		return left.getRawButton(2);
	}

	@Override
	public boolean getLeftButton3() {
		return left.getRawButton(3);
	}

	@Override
	public boolean getLeftButton4() {
		return left.getRawButton(4);
	}

	@Override
	public boolean getLeftButton5() {
		return left.getRawButton(5);
	}

	@Override
	public boolean getLeftButton6() {
		return left.getRawButton(6);
	}

	@Override
	public boolean getLeftButton7() {
		return left.getRawButton(7);
	}

	@Override
	public boolean getLeftButton8() {
		return left.getRawButton(8);
	}

	@Override
	public boolean getLeftButton9() {
		return left.getRawButton(9);
	}

	@Override
	public boolean getLeftButton10() {
		return left.getRawButton(10);
	}

	@Override
	public boolean getLeftButton11() {
		return left.getRawButton(11);
	}
}
