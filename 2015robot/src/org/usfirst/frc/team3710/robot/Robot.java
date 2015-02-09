package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class Robot extends IterativeRobot {

	Controller driverControl;
	Drive drive;
	PinchClaw claw;
	BinElevator binElevator;
	CanBurglar canBurglar;
	RollerClaw rollerClaw;
	ToteElevator toteElevator;
	PowerDistributionPanel pdp;

	//Controller and Sensor
	Talon driveRightTalon, driveLeftTalon, binElevatorTalon, rollerClawRightTalon, rollerClawLeftTalon, toteElevatorTalon;
	Encoder encDriveLeft, encDriveRight, encBinElevator;
	Victor pinchClawVictor;
	Solenoid canBurglarSolenoid;
	DigitalInput toteElevatorTop, toteElevatorBottom;

	public void robotInit() {
		//Drive
		driveLeftTalon = new Talon(VariableMap.PWM_DRIVE_LEFT);
		driveRightTalon = new Talon(VariableMap.PWM_DRIVE_RIGHT);
		encDriveLeft = new Encoder(VariableMap.DIO_DRIVE_ENC_LEFT_A, VariableMap.DIO_DRIVE_ENC_LEFT_B, false, Encoder.EncodingType.k4X);
		encDriveRight = new Encoder(VariableMap.DIO_DRIVE_ENC_RIGHT_A,VariableMap.DIO_DRIVE_ENC_RIGHT_B, false, Encoder.EncodingType.k4X);
		
		//Pinch Claw
		pinchClawVictor = new Victor(VariableMap.PWM_PINCH_CLAW);
		
		//Bin Elevator
		binElevatorTalon = new Talon(VariableMap.PWM_BIN_ELEVATOR);
		encBinElevator = new Encoder(VariableMap.DIO_BIN_ELEVATOR_ENC_A,VariableMap.DIO_BIN_ELEVATOR_ENC_B, false, Encoder.EncodingType.k4X);
		
		//Can Burglar
		canBurglarSolenoid = new Solenoid(VariableMap.SOL_CAN_BURGLAR);
		
		//Roller Claw
		rollerClawRightTalon = new Talon(VariableMap.PWM_ROLLER_RIGHT);
		rollerClawLeftTalon = new Talon(VariableMap.PWM_ROLLER_LEFT);
		
		//Tote Elevator
		toteElevatorTalon = new Talon(VariableMap.PWM_TOTE_ELEVATOR);
		toteElevatorBottom = new DigitalInput(VariableMap.DIO_TOTE_ELEVATOR_BOTTOM);
		toteElevatorTop = new DigitalInput(VariableMap.DIO_TOTE_ELEVATOR_TOP);
		
		//Systems
		drive = new Drive(driveLeftTalon, driveRightTalon, encDriveLeft, encDriveRight);
		claw = new PinchClaw(pinchClawVictor);
		binElevator = new BinElevator(binElevatorTalon, encBinElevator);
		canBurglar = new CanBurglar(canBurglarSolenoid);
		rollerClaw = new RollerClaw(rollerClawLeftTalon, rollerClawRightTalon);
		toteElevator = new ToteElevator(toteElevatorTalon, toteElevatorBottom, toteElevatorTop);
		driverControl = new JoystickControllerWrapper(1, 2);
		pdp = new PowerDistributionPanel();
	}

	public void autonomousInit() {

	}

	public void autonomousPeriodic() {

	}

	public void teleopInit() {

	}

	public void teleopPeriodic() {
		drive();
	}

	public void testPeriodic() {

	}

	public void drive() {
		driverControl.checkFlip();
		drive.setDriveRight(driverControl.driveRight());
		drive.setDriveLeft(driverControl.driveLeft());
	}
	
	public void initializeSmartDashboard(){
		
	}

}
