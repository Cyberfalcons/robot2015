package org.usfirst.frc.team3710.robot;

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
			return getLeftY() * (0.5+(getRightZ()*0.5)) * -1;
		else
			return getLeftY() * (0.5+(getRightZ()*0.5));
	}
	
	public double driveRight() {
		if (controlFlip)
			return getRightY() * (0.5+(getRightZ()*0.5));
		else
			return getRightY() * (0.5+(getRightZ()*0.5)) * -1;
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

	public boolean getRightButton1() {
		return false;
	}

	public boolean getRightButton2() {
		return false;
	}

	public boolean getRightButton3() {
		return false;
	}

	public boolean getRightButton4() {
		return false;
	}

	public boolean getRightButton5() {
		return false;
	}

	public boolean getRightButton6() {
		return false;
	}

	public boolean getRightButton7() {
		return false;
	}

	public boolean getRightButton8() {
		return false;
	}

	public boolean getRightButton9() {
		return false;
	}

	public boolean getRightButton10() {
		return false;
	}

	public boolean getRightButton11() {
		return false;
	}

	public boolean getLeftButton1() {
		return false;
	}

	public boolean getLeftButton2() {
		return false;
	}

	public boolean getLeftButton3() {
		return false;
	}

	public boolean getLeftButton4() {
		return false;
	}

	public boolean getLeftButton5() {
		return false;
	}

	public boolean getLeftButton6() {
		return false;
	}

	public boolean getLeftButton7() {
		return false;
	}

	public boolean getLeftButton8() {
		return false;
	}

	public boolean getLeftButton9() {
		return false;
	}

	public boolean getLeftButton10() {
		return false;
	}

	public boolean getLeftButton11() {
		return false;
	}

	public boolean getBtnX() {
		return false;
	}

	public boolean getBtnY() {
		return false;
	}

	public boolean getBtnA() {
		return false;
	}

	public boolean getBtnB() {
		return false;
	}

	public boolean getBtnLB() {
		return false;
	}

	public boolean getBtnRB() {
		return false;
	}

	public boolean getBtnBACK() {
		return false;
	}

	public boolean getBtnSTART() {
		return false;
	}

	public double getRightX() {
		return 0.0;
	}

	public double getRightY() {
		return 0.0;
	}
	
	public double getRightZ() {
		return 1.0;
	}

	public double getLeftX() {
		return 0.0;
	}

	public double getLeftY() {
		return 0.0;
	}
	
	public double getLeftZ() {
		return 1.0;
	}
	
	public boolean getRightTrigger() {
		return false;
	}
	
	public boolean getLeftTrigger() {
		return false;
	}
	
	public boolean getDpadLEFT() {
		return false;
	}
	
	public boolean getDpadRIGHT() {
		return false;
	}
}
