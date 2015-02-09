package org.usfirst.frc.team3710.robot;

public class XBoxControllerWrapper extends Controller {

	private XBoxController pad;
	
	public XBoxControllerWrapper(int usb) {
		pad = new XBoxController(usb);
	}

	@Override
	public boolean getBtnX() {
		return pad.getBtnX();
	}

	@Override
	public boolean getBtnY() {
		return pad.getBtnY();
	}

	@Override
	public boolean getBtnA() {
		return pad.getBtnA();
	}

	@Override
	public boolean getBtnB() {
		return pad.getBtnB();
	}

	@Override
	public boolean getBtnLB() {
		return pad.getBtnLB();
	}

	@Override
	public boolean getBtnRB() {
		return pad.getBtnRB();
	}

	@Override
	public boolean getBtnBACK() {
		return pad.getBtnBACK();
	}

	@Override
	public boolean getBtnSTART() {
		return pad.getBtnSTART();
	}

	@Override
	public double getRightX() {
		return pad.getRawAxis(4);
	}

	@Override
	public double getRightY() {
		return pad.getRawAxis(5);
	}

	@Override
	public double getLeftX() {
		return pad.getRawAxis(1);
	}

	@Override
	public double getLeftY() {
		return pad.getRawAxis(2);
	}

	@Override
	public boolean getDpadLEFT() {
		if (pad.getDpadX() > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean getDpadRIGHT() {
		if (pad.getTriggers() < 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean getLeftTrigger() {
		if (pad.getTriggers() > 0.1)
			return true;
		else
			return false;
	}

	@Override
	public boolean getRightTrigger() {
		if (pad.getTriggers() < -0.1)
			return true;
		else
			return false;
	}
	
}
