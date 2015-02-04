package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class JoystickController extends Controller{
	Joystick left;
	Joystick right;

	public JoystickController(int usbL, int usbR) {
		left = new Joystick(usbL);
		right = new Joystick(usbR);
	}
	
	public double getRightX()
	{
		return right.getX();
	}
	
	public double getRightY()
	{
		return right.getY();
	}
	
	public double getLeftX()
	{
		return left.getX();
	}
	
	public double getLeftY()
	{
		return left.getY();
	}

	public boolean getRightButton1() {
		return right.getRawButton(1);
	}

	public boolean getRightButton2() {
		return right.getRawButton(2);
	}

	public boolean getRightButton3() {
		return right.getRawButton(3);
	}

	public boolean getRightButton4() {
		return right.getRawButton(4);
	}

	public boolean getRightButton5() {
		return right.getRawButton(5);
	}

	public boolean getRightButton6() {
		return right.getRawButton(6);
	}

	public boolean getRightButton7() {
		return right.getRawButton(7);
	}

	public boolean getRightButton8() {
		return right.getRawButton(8);
	}

	public boolean getRightButton9() {
		return right.getRawButton(9);
	}

	public boolean getRightButton10() {
		return right.getRawButton(10);
	}

	public boolean getRightButton11() {
		return right.getRawButton(11);
	}

	public boolean getLeftButton1() {
		return left.getRawButton(1);
	}

	public boolean getLeftButton2() {
		return left.getRawButton(2);
	}

	public boolean getLeftButton3() {
		return left.getRawButton(3);
	}

	public boolean getLeftButton4() {
		return left.getRawButton(4);
	}

	public boolean getLeftButton5() {
		return left.getRawButton(5);
	}

	public boolean getLeftButton6() {
		return left.getRawButton(6);
	}

	public boolean getLeftButton7() {
		return left.getRawButton(7);
	}

	public boolean getLeftButton8() {
		return left.getRawButton(8);
	}

	public boolean getLeftButton9() {
		return left.getRawButton(9);
	}

	public boolean getLeftButton10() {
		return left.getRawButton(10);
	}

	public boolean getLeftButton11() {
		return left.getRawButton(11);
	}
}
