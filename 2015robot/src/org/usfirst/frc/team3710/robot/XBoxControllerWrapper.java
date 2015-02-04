package org.usfirst.frc.team3710.robot;

public class XBoxControllerWrapper extends Controller {

	private XBoxController pad;
	
	public XBoxControllerWrapper(int usb) {
		pad = new XBoxController(usb);
	}
	
	public boolean getBtnX() {
		return pad.getBtnX();
	}

	public boolean getBtnY() {
		return pad.getBtnY();
	}

	public boolean getBtnA() {
		return pad.getBtnA();
	}

	public boolean getBtnB() {
		return pad.getBtnB();
	}

	public boolean getBtnLB() {
		return pad.getBtnLB();
	}

	public boolean getBtnRB() {
		return pad.getBtnRB();
	}

	public boolean getBtnBACK() {
		return pad.getBtnBACK();
	}

	public boolean getBtnSTART() {
		return pad.getBtnSTART();
	}

	public double getRightX() {
		return pad.getRawAxis(4);
	}

	public double getRightY() {
		return pad.getRawAxis(5);
	}

	public double getLeftX() {
		return pad.getRawAxis(1);
	}

	public double getLeftY() {
		return pad.getRawAxis(2);
	}
}
