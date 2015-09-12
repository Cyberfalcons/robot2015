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
	DoubleSolenoid canBurglarSolenoid1, canBurglarSolenoid2;
	ConfigParser config;
	Timer timer;

	// Misc
	boolean autoOn = true;

	//Used to initialize all objects and systems when the robot is power up
	//You must initialize objects here and then pass them to their coresponding systems
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
		canBurglarSolenoid1 = new DoubleSolenoid(VariableMap.PCM_CAN_BURGLAR_SOLE_1_A,VariableMap.PCM_CAN_BURGLAR_SOLE_1_B);
		canBurglarSolenoid2 = new DoubleSolenoid(VariableMap.PCM_CAN_BURGLAR_SOLE_2_A,VariableMap.PCM_CAN_BURGLAR_SOLE_2_B);
		
		// Systems
		drive = new Drive(driveLeftTalonA, driveRightTalonA, encDriveLeft,encDriveRight, driveLeftPID, driveRightPID);
		toteElevator = new ToteElevator(toteElevatorVictor, toteElevatorEncoder,toteElevatorTop, toteElevatorBottom, toteElevatorPID);
		canBurglar = new CanBurglar_v3(canBurglarSolenoid1, canBurglarSolenoid2);
		lamp = new Lamp();
		ramp = new Ramp();
		driverControl = new JoystickControllerWrapper(0, 1);
		operatorControl = new XBoxControllerWrapper(2);
		pdp = new PowerDistributionPanel();
		config = new ConfigParser();
		timer = new Timer();
	}

	//This method is ran when the robot is first switched into autonomous
	//Use this to clear all variables and start timers
	public void autonomousInit() {
		VariableMap.SLOW_MODE_DRIVE = false;
		drive.resetLeftEncoder();
		drive.resetRightEncoder();
		timer.start();
	}

	//A periodic method that is ran during autonomous mode
	//This is basically a while loop until the robot is switched out of autonomous
	public void autonomousPeriodic() {
		if (autoOn == true) {
			System.out.println("DRIVE LEFT: " + drive.getEncoderLeft());
			System.out.println("DRIVE RIGHT: " + drive.getEncoderRight());
			
			canBurglar.deploy1();
			canBurglar.deploy2();

			if ((timer.get() > 0.0) && (timer.get() < 2.30)) {
				if((timer.get() > 0.75)&&(timer.get() < 1.0)){
					//Forward
					driveLeftPID.setPID(VariableMap.DRIVE_PID_P,VariableMap.DRIVE_PID_I,VariableMap.DRIVE_PID_D);
					driveRightPID.setPID(VariableMap.DRIVE_PID_P,VariableMap.DRIVE_PID_I,VariableMap.DRIVE_PID_D);
					drive.setPIDDriveLeft(-18);
					drive.setPIDDriveRight(18);
				}else if((timer.get() > 1.0)&&(timer.get() < 2.0)){
					driveLeftPID.setPID(0.040, 0.000, 0.002);
					driveRightPID.setPID(0.040, 0.000, 0.002);
					//drive.setPIDDriveLeft(drive.getEncoderLeft() + 3);
					//drive.setPIDDriveRight(drive.getEncoderRight() + 3);
				}else if((timer.get() > 2.0) && (timer.get() < 3.0)){
					driveLeftPID.setPID(0.030, 0.000, 0.002);
					driveRightPID.setPID(0.030, 0.000, 0.002);
					//drive.setPIDDriveLeft(drive.getEncoderLeft() - 6);
					//drive.setPIDDriveRight(drive.getEncoderRight() - 6);
				}else if((timer.get() > 3.0)&&(timer.get() < 4.0)){
					driveLeftPID.setPID(0.040, 0.000, 0.002);
					driveRightPID.setPID(0.040, 0.000, 0.002);
					//drive.setPIDDriveLeft(drive.getEncoderLeft() + 3);
					//drive.setPIDDriveRight(drive.getEncoderRight() + 3);
				}
			} else if ((timer.get() > 2.3)) {
				//Backwards
				driveLeftPID.setPID(VariableMap.DRIVE_PID_P,VariableMap.DRIVE_PID_I,VariableMap.DRIVE_PID_D);
				driveRightPID.setPID(VariableMap.DRIVE_PID_P,VariableMap.DRIVE_PID_I,VariableMap.DRIVE_PID_D);
				drive.setPIDDriveLeft(230);
				drive.setPIDDriveRight(-230);
			}
		}
	}

	//Same thing as autonomous init but for tele operated mode
	public void teleopInit() {
		timer.stop();
		drive.disableLeftPIDControl();
		drive.disableRightPIDControl();
		toteElevator.resetEncoder();
		toteElevator.disablePID();
		toteElevatorPID.setPID(VariableMap.TOTE_ELEVATOR_PID_P,VariableMap.TOTE_ELEVATOR_PID_I, VariableMap.TOTE_ELEVATOR_PID_D);
	}

	//Same thing as autonomous periodic but for tele operated mode
	public void teleopPeriodic() {
		doDrive();
		doToteElevator();
		doCanBurglar();

		//This is used to debugging
		if (VariableMap.VERBOSE_CONSOLE) {
			System.out.println("Elevator Encoder: " + toteElevator.getEncoder());
			System.out.println("Elevator Top: " + toteElevator.getTop());
			System.out.println("Elevator Bottom: " + toteElevator.getBottom());
			System.out.println("DRIVE LEFT: " + drive.getEncoderLeft());
			System.out.println("DRIVE RIGHT: " + drive.getEncoderRight());
		}
		
		System.out.println("Elevator Encoder: " + toteElevator.getEncoder());
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
		if(driverControl.getRightButton6()){
			canBurglar.deploy1();
		}
		else if(driverControl.getRightButton7()){
			canBurglar.retract1();
		}
		else if(driverControl.getLeftButton6()){
			canBurglar.deploy2();
		}
		else if(driverControl.getLeftButton7()){
			canBurglar.retract2();
		}
		
		
		
	}

	public void doToteElevator() {
		if (driverControl.elevatorUp()) {
			toteElevator.setPIDPositionUp();
		} else if (driverControl.elevatorDown()) {
		    toteElevator.setPIDPositionDown();
		} else if (driverControl.getRightButton11()) {
			toteElevator.setSetPoint(0);
		} else{
			//toteElevator.stopElevator();
		}
	}
}