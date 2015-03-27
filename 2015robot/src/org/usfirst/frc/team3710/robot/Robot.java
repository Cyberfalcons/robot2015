package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class Robot extends IterativeRobot {

	// Systems
	Controller driverControl, operatorControl;
	Drive drive;
	ToteElevator toteElevator;
	CanBurglar_v3 canBurglar;
	PowerDistributionPanel pdp;
	Lamp lamp;
	Ramp ramp;

	// Controller and Sensor
	Talon driveRightTalonA, driveLeftTalonA;
	Encoder encDriveLeft, encDriveRight, toteElevatorEncoder;
	Victor toteElevatorVictor;
	DigitalInput toteElevatorTop, toteElevatorBottom;
	PIDController toteElevatorPID, driveLeftPID, driveRightPID;
	DoubleSolenoid canBurglarSolenoid;
	ConfigParser config;
	Timer timer;

	// Misc
	boolean autoOn = false;

	public void robotInit() {
		// Drive
		driveLeftTalonA = new Talon(VariableMap.PWM_DRIVE_LEFT_A);
		driveRightTalonA = new Talon(VariableMap.PWM_DRIVE_RIGHT_A);
		encDriveLeft = new Encoder(VariableMap.DIO_DRIVE_ENC_LEFT_A,VariableMap.DIO_DRIVE_ENC_LEFT_B, false,Encoder.EncodingType.k4X);
		encDriveRight = new Encoder(VariableMap.DIO_DRIVE_ENC_RIGHT_A,VariableMap.DIO_DRIVE_ENC_RIGHT_B, false,Encoder.EncodingType.k4X);
		driveLeftPID = new PIDController(VariableMap.DRIVE_PID_P,VariableMap.DRIVE_PID_I, VariableMap.DRIVE_PID_D, encDriveLeft,driveLeftTalonA);
		driveRightPID = new PIDController(VariableMap.DRIVE_PID_P,VariableMap.DRIVE_PID_I, VariableMap.DRIVE_PID_D,encDriveRight, driveRightTalonA);

		// Tote Elevator
		toteElevatorVictor = new Victor(VariableMap.PWM_TOTE_ELEVATOR);
		toteElevatorEncoder = new Encoder(VariableMap.DIO_TOTE_ELEVATOR_ENC_A,VariableMap.DIO_TOTE_ELEVATOR_ENC_B, false,Encoder.EncodingType.k4X);
		toteElevatorTop = new DigitalInput(VariableMap.DIO_TOTE_ELEVATOR_TOP);
	    toteElevatorBottom = new DigitalInput(VariableMap.DIO_TOTE_ELEVATOR_BOTTOM);
		toteElevatorPID = new PIDController(VariableMap.TOTE_ELEVATOR_PID_P, VariableMap.TOTE_ELEVATOR_PID_I,VariableMap.TOTE_ELEVATOR_PID_D, toteElevatorEncoder, toteElevatorVictor);

		// Can Burglar
		canBurglarSolenoid = new DoubleSolenoid(VariableMap.PCM_CAN_BURGLAR_SOLE_1,VariableMap.PCM_CAN_BURGLAR_SOLE_2);

		// Systems
		drive = new Drive(driveLeftTalonA, driveRightTalonA, encDriveLeft,encDriveRight, driveLeftPID, driveRightPID);
		toteElevator = new ToteElevator(toteElevatorVictor, toteElevatorEncoder,toteElevatorTop, toteElevatorBottom, toteElevatorPID);
		canBurglar = new CanBurglar_v3(canBurglarSolenoid);
		lamp = new Lamp();
		ramp = new Ramp();
		driverControl = new JoystickControllerWrapper(0, 1);
		operatorControl = new XBoxControllerWrapper(2);
		pdp = new PowerDistributionPanel();
		config = new ConfigParser();
		timer = new Timer();
	}

	public void autonomousInit() {
		VariableMap.SLOW_MODE_DRIVE = false;
		drive.resetLeftEncoder();
		drive.resetRightEncoder();
		timer.start();
		toteElevatorPID.setPID(0.018, 0.0, 0.006);
	}

	public void autonomousPeriodic() {
		if (autoOn == true) {
			System.out.println("DRIVE LEFT: " + drive.getEncoderLeft());
			System.out.println("DRIVE RIGHT: " + drive.getEncoderRight());

			if ((timer.get() > 0.25) && (timer.get() < 0.5)) {
				toteElevator.setPIDPositionUp();
			} else if ((timer.get() < 0.75) && (timer.get() > 0.5)) {
				toteElevator.setPIDPositionDown();
			} else if ((timer.get() > 1.25)) {
				toteElevator.disablePID();
			}

			if ((timer.get() > 2.90) && (timer.get() < 5.00)) {
				drive.setPIDDriveLeft(-70);
				drive.setPIDDriveRight(70);
			} else if ((timer.get() > 5.1)) {
				drive.setPIDDriveLeft(390);
				drive.setPIDDriveRight(-390);
			}
		}
	}

	public void teleopInit() {
		drive.disableLeftPIDControl();
		drive.disableRightPIDControl();
		toteElevator.resetEncoder();
		toteElevator.disablePID();
		toteElevatorPID.setPID(VariableMap.TOTE_ELEVATOR_PID_P,VariableMap.TOTE_ELEVATOR_PID_I, VariableMap.TOTE_ELEVATOR_PID_D);
	}

	public void teleopPeriodic() {
		doDrive();
		doToteElevator();
		doCanBurglar();

		if (VariableMap.VERBOSE_CONSOLE) {
			System.out.println("Elevator Encoder: " + toteElevator.getEncoder());
			System.out.println("Elevator Top: " + toteElevator.getTop());
			System.out.println("Elevator Bottom: " + toteElevator.getBottom());
			System.out.println("DRIVE LEFT: " + drive.getEncoderLeft());
			System.out.println("DRIVE RIGHT: " + drive.getEncoderRight());
		}
	}

	public void testPeriodic() {

	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {

	}

	public void doDrive() {
		driverControl.checkFlip();

		if (operatorControl.getBtnA()) {
			drive.flipSlowMode();
		}

		drive.setDriveRight(driverControl.driveRight());
		drive.setDriveLeft(driverControl.driveLeft());
	}

	public void doCanBurglar() {

	}

	public void doToteElevator() {
		if (driverControl.elevatorUp()) {
			toteElevator.setPIDPositionUp();
		} else if (driverControl.elevatorDown()) {
		    toteElevator.setPIDPositionDown();
		} else if (driverControl.getRightButton11()) {
			toteElevator.setSetPoint(0);
		}
	}
}