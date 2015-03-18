package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class Robot extends IterativeRobot {

	// Systems
	Controller driverControl, operatorControl;
	Drive drive;
	BinElevator binElevator;
	RollerClaw rollerClaw;
	CanBurglar_v3 canBurglar;
	PowerDistributionPanel pdp;
	Lamp lamp;
	Ramp ramp;

	// Controller and Sensor
	Talon driveRightTalonA, driveLeftTalonA;
	Encoder encDriveLeft, encDriveRight, binElevatorEncoder;
	Victor binElevatorVictor, rollerClawRightVictor, rollerClawLeftVictor;
	DigitalInput binElevatorTop, binElevatorBottom;
	PIDController binElevatorPID, driveLeftPID, driveRightPID;
	DoubleSolenoid canBurglarSolenoid;
	ConfigParser config;
	Timer timer;

	// Misc
	double binElevatorPIDP = VariableMap.BIN_ELEVATOR_PID_P;
	double binElevatorPIDI = VariableMap.BIN_ELEVATOR_PID_I;
	double binElevatorPIDD = VariableMap.BIN_ELEVATOR_PID_D;
	
	boolean autoOn = false;

	public void robotInit() {
		// Drive
		driveLeftTalonA = new Talon(VariableMap.PWM_DRIVE_LEFT_A);
		driveRightTalonA = new Talon(VariableMap.PWM_DRIVE_RIGHT_A);
		encDriveLeft = new Encoder(VariableMap.DIO_DRIVE_ENC_LEFT_A,VariableMap.DIO_DRIVE_ENC_LEFT_B, false,Encoder.EncodingType.k4X);
		encDriveRight = new Encoder(VariableMap.DIO_DRIVE_ENC_RIGHT_A,VariableMap.DIO_DRIVE_ENC_RIGHT_B, false,Encoder.EncodingType.k4X);
		driveLeftPID = new PIDController(VariableMap.DRIVE_PID_P,VariableMap.DRIVE_PID_I, VariableMap.DRIVE_PID_D, encDriveLeft,driveLeftTalonA);
		driveRightPID = new PIDController(VariableMap.DRIVE_PID_P,VariableMap.DRIVE_PID_I, VariableMap.DRIVE_PID_D,encDriveRight, driveRightTalonA);

		// Bin Elevator
		binElevatorVictor = new Victor(VariableMap.PWM_BIN_ELEVATOR);
		binElevatorEncoder = new Encoder(VariableMap.DIO_BIN_ELEVATOR_ENC_A,VariableMap.DIO_BIN_ELEVATOR_ENC_B, false,Encoder.EncodingType.k4X);
		binElevatorTop = new DigitalInput(VariableMap.DIO_BIN_ELEVATOR_TOP);
		binElevatorBottom = new DigitalInput(VariableMap.DIO_BIN_ELEVATOR_BOTTOM);
		binElevatorPID = new PIDController(binElevatorPIDP, binElevatorPIDI,binElevatorPIDD, binElevatorEncoder, binElevatorVictor);

		// Roller Claw
		rollerClawRightVictor = new Victor(VariableMap.PWM_ROLLER_RIGHT);
		rollerClawLeftVictor = new Victor(VariableMap.PWM_ROLLER_LEFT);

		// Can Burglar
		canBurglarSolenoid = new DoubleSolenoid(VariableMap.PCM_CAN_BURGLAR_SOLE_1,VariableMap.PCM_CAN_BURGLAR_SOLE_2);

		// Systems
		drive = new Drive(driveLeftTalonA, driveRightTalonA, encDriveLeft,encDriveRight, driveLeftPID, driveRightPID);
		binElevator = new BinElevator(binElevatorVictor, binElevatorEncoder,binElevatorTop, binElevatorBottom, binElevatorPID);
		rollerClaw = new RollerClaw(rollerClawLeftVictor, rollerClawRightVictor);
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
		binElevatorPID.setPID(0.018, 0.0, 0.006);
	}

	public void autonomousPeriodic() {
		if (autoOn == true) {
			System.out.println("DRIVE LEFT: " + drive.getEncoderLeft());
			System.out.println("DRIVE RIGHT: " + drive.getEncoderRight());

			if ((timer.get() > 0.25) && (timer.get() < 0.5)) {
				binElevator.setPIDPositionUp();
			} else if ((timer.get() < 0.75) && (timer.get() > 0.5)) {
				binElevator.setPIDPositionDown();
			} else if ((timer.get() > 1.25)) {
				binElevator.disablePID();
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
		binElevator.resetEncoder();
		binElevator.disablePID();
		binElevatorPID.setPID(VariableMap.BIN_ELEVATOR_PID_P,VariableMap.BIN_ELEVATOR_PID_I, VariableMap.BIN_ELEVATOR_PID_D);
	}

	public void teleopPeriodic() {
		doDrive();
		doBinElevator();
		doRollerClaw();
		doCanBurglar();

		if (VariableMap.VERBOSE_CONSOLE) {
			System.out.println("Elevator Encoder: " + binElevator.getEncoder());
			System.out.println("Elevator Top: " + binElevator.getTop());
			System.out.println("Elevator Bottom: " + binElevator.getBottom());
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

	public void doRollerClaw() {

		if (operatorControl.getBtnB()) {
			rollerClaw.flipSlowMode();
		}

		if (driverControl.rollerIn()) {
			rollerClaw.binIn();
		} else if (driverControl.rollerOut()) {
			rollerClaw.binOut();
		} else if (operatorControl.getBtnB()) {
			rollerClaw.binClockWise();
		} else {
			rollerClaw.stop();
		}
	}

	public void doCanBurglar() {

	}

	public void doBinElevator() {
		if (driverControl.elevatorUp()) {
			binElevator.setPIDPositionUp();
		} else if (driverControl.elevatorDown()) {
			binElevator.setPIDPositionDown();
		} else if (driverControl.getRightButton11()) {
			binElevator.setSetPoint(0);
		}
	}
}