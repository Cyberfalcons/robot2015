package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class Robot extends IterativeRobot {

	Controller driverControl;
	VariableMap vm;
	Drive drive;
	
	Jaguar driveRight, driveLeft;
	Encoder encLeft, encRight;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		vm = new VariableMap();
		driverControl = new JoystickControllerWrapper(1,2);
		
		driveLeft = new Jaguar(vm.PWM_DRIVE_LEFT);
		driveRight = new Jaguar(vm.PWM_DRIVE_RIGHT);
		
		encLeft = new Encoder(vm.DIO_DRIVE_ENC_LEFT_A,
				vm.DIO_DRIVE_ENC_LEFT_B, false, Encoder.EncodingType.k4X);
		encLeft.setMaxPeriod(.1);
		encLeft.setMinRate(10);
		encLeft.setDistancePerPulse(5);
		encLeft.setReverseDirection(false);
		encLeft.setSamplesToAverage(7);

		encRight = new Encoder(vm.DIO_DRIVE_ENC_RIGHT_A,
				vm.DIO_DRIVE_ENC_RIGHT_B, false, Encoder.EncodingType.k4X);
		encRight.setMaxPeriod(.1);
		encRight.setMinRate(10);
		encRight.setDistancePerPulse(5);
		encRight.setReverseDirection(false);
		encRight.setSamplesToAverage(7);
		
		drive = new Drive(vm,driveLeft,driveRight,encLeft,encRight);
	}

	public void autonomousInit() {

	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {

	}

	public void teleopInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		drive();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}
	
	public void drive() {
		driverControl.checkFlip();
		drive.setDriveRight(driverControl.driveRight());
		drive.setDriveLeft(driverControl.driveLeft());
	}

}
