package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class Controller {

	private static boolean pinchLock;
	private static boolean toteLock;
	private static boolean elevatorLock;
	private static boolean rollerLock;
	
	private static boolean controlFlip;
	private static boolean flipLock;
	
	public Controller() {

	}
	
	public boolean openPinchClaw() {
		if (!pinchLock && (getRightButton4() || getBtnLB())) {
			pinchLock = true;
			return true;
		}
		else
			return false;
	}
	
	public boolean closePinchClaw() {
		if (!pinchLock && (getRightButton5() || getBtnRB())) {
			pinchLock = true;
			return true;
		}
		else
			return false;
	}
	
	public boolean dropToteStack() {
		if (!toteLock && (getRightButton2() || getLeftTrigger())) {
			pinchLock = true;
			return true;
		}
		else
			return false;
	}
	
	public void checkFlip() {
		if (!flipLock && (getLeftButton6() || getBtnA())) {
			flipLock = true;
			controlFlip = !controlFlip;
		}
		else if (flipLock && !(getLeftButton6() || getBtnA())) {
			flipLock = false;
		}
	}
	
	public double driveLeft() {
		if (controlFlip)
			return getLeftY() * -1;
		else
			return getLeftY();
	}
	
	public double driveRight() {
		if (controlFlip)
			return getRightY() * -1;
		else
			return getRightY();
	}
	
	public boolean elevatorUp() {
		if (!elevatorLock && (getRightButton3() || getDpadLEFT())) {
			elevatorLock = true;
			return true;
		}
		else
			return false;
	}
	
	public boolean elevatorDown() {
		if (!elevatorLock && (getRightButton2() || getDpadRIGHT())) {
			elevatorLock = true;
			return true;
		}
		else
			return false;
	}
	
	public boolean rollerIn() {
		if (!rollerLock && (getLeftButton2() || false/*TODO: XBox control*/)) {
			rollerLock = true;
			return true;
		}
		else
			return false;
	}
	
	public boolean rollerOut() {
		if (!rollerLock && (getLeftButton3() || false/*TODO: XBox control*/)) {
			rollerLock = true;
			return true;
		}
		else
			return false;
	}
	
	public boolean toteIntake() {
		if (!rollerLock && (getLeftButton4() || false/*TODO: XBox control*/)) {
			rollerLock = true;
			return true;
		}
		else
			return false;
	}
	
	public boolean oOpenPinchClaw() {
		if (!pinchLock && (getRightButton4() || getBtnX())) {
			pinchLock = true;
			return true;
		}
		else
			return false;
	}
	
	public boolean oClosePinchClaw() {
		if (!pinchLock && (getRightButton5() || getBtnB())) {
			pinchLock = true;
			return true;
		}
		else
			return false;
	}
	
	public boolean oDropToteStack() {
		if (!toteLock && (getRightButton1() || getLeftTrigger())) {
			pinchLock = true;
			return true;
		}
		else
			return false;
	}
	
	public boolean oElevatorUp() {
		if (!elevatorLock && (getRightButton3() || getBtnY())) {
			elevatorLock = true;
			return true;
		}
		else
			return false;
	}
	
	public boolean oElevatorDown() {
		if (!elevatorLock && (getRightButton2() || getBtnA())) {
			elevatorLock = true;
			return true;
		}
		else
			return false;
	}
	
	public void unlockElevator() {
		elevatorLock = false;
	}
	
	public void unlockTote() {
		toteLock = false;
	}
	
	public void unlockPinch() {
		pinchLock = false;
	}
	
	public void unlockRoller() {
		rollerLock = false;
	}
	
	public double oElevatorManual() {
		return getRightY();
	}

	private boolean getRightButton1() {
		return false;
	}

	private boolean getRightButton2() {
		return false;
	}

	private boolean getRightButton3() {
		return false;
	}

	private boolean getRightButton4() {
		return false;
	}

	private boolean getRightButton5() {
		return false;
	}

	private boolean getRightButton6() {
		return false;
	}

	private boolean getRightButton7() {
		return false;
	}

	private boolean getRightButton8() {
		return false;
	}

	private boolean getRightButton9() {
		return false;
	}

	private boolean getRightButton10() {
		return false;
	}

	private boolean getRightButton11() {
		return false;
	}

	private boolean getLeftButton1() {
		return false;
	}

	private boolean getLeftButton2() {
		return false;
	}

	private boolean getLeftButton3() {
		return false;
	}

	private boolean getLeftButton4() {
		return false;
	}

	private boolean getLeftButton5() {
		return false;
	}

	private boolean getLeftButton6() {
		return false;
	}

	private boolean getLeftButton7() {
		return false;
	}

	private boolean getLeftButton8() {
		return false;
	}

	private boolean getLeftButton9() {
		return false;
	}

	private boolean getLeftButton10() {
		return false;
	}

	private boolean getLeftButton11() {
		return false;
	}

	private boolean getBtnX() {
		return false;
	}

	private boolean getBtnY() {
		return false;
	}

	private boolean getBtnA() {
		return false;
	}

	private boolean getBtnB() {
		return false;
	}

	private boolean getBtnLB() {
		return false;
	}

	private boolean getBtnRB() {
		return false;
	}

	private boolean getBtnBACK() {
		return false;
	}

	private boolean getBtnSTART() {
		return false;
	}

	private double getRightX() {
		return 0.0;
	}

	private double getRightY() {
		return 0.0;
	}

	private double getLeftX() {
		return 0.0;
	}

	private double getLeftY() {
		return 0.0;
	}
	
	private boolean getRightTrigger() {
		return false;
	}
	
	private boolean getLeftTrigger() {
		return false;
	}
	
	private boolean getDpadLEFT() {
		return false;
	}
	
	private boolean getDpadRIGHT() {
		return false;
	}
}
