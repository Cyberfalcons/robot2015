package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	private Controller driverControl;
	private Drive drive;
	private PinchClaw claw;
	private BinElevator binElevator;
	private CanBurglar canBurglar;
	private RollerClaw rollerClaw;
	private ToteElevator toteElevator;
	private PowerDistributionPanel pdp;

	// Controller and Sensor
	private Talon driveRightTalon, driveLeftTalon, binElevatorTalon,rollerClawRightTalon, rollerClawLeftTalon, toteElevatorTalon;
	private Encoder encDriveLeft, encDriveRight, encBinElevator;
	private Victor pinchClawVictor;
	private Solenoid canBurglarSolenoid;
	private DigitalInput toteElevatorTop, toteElevatorBottom;

	// SmartDashboard Objects
	private int autonomousMode = 0;
	private SendableChooser autoChooser;

	public void robotInit() {
		// Drive
		driveLeftTalon = new Talon(VariableMap.PWM_DRIVE_LEFT);
		driveRightTalon = new Talon(VariableMap.PWM_DRIVE_RIGHT);
		encDriveLeft = new Encoder(VariableMap.DIO_DRIVE_ENC_LEFT_A,VariableMap.DIO_DRIVE_ENC_LEFT_B, false,Encoder.EncodingType.k4X);
		encDriveRight = new Encoder(VariableMap.DIO_DRIVE_ENC_RIGHT_A,VariableMap.DIO_DRIVE_ENC_RIGHT_B, false,Encoder.EncodingType.k4X);

		// Pinch Claw
		pinchClawVictor = new Victor(VariableMap.PWM_PINCH_CLAW);

		// Bin Elevator
		binElevatorTalon = new Talon(VariableMap.PWM_BIN_ELEVATOR);
		encBinElevator = new Encoder(VariableMap.DIO_BIN_ELEVATOR_ENC_A,VariableMap.DIO_BIN_ELEVATOR_ENC_B, false,Encoder.EncodingType.k4X);

		// Can Burglar
		canBurglarSolenoid = new Solenoid(VariableMap.SOL_CAN_BURGLAR);

		// Roller Claw
		rollerClawRightTalon = new Talon(VariableMap.PWM_ROLLER_RIGHT);
		rollerClawLeftTalon = new Talon(VariableMap.PWM_ROLLER_LEFT);

		// Tote Elevator
		toteElevatorTalon = new Talon(VariableMap.PWM_TOTE_ELEVATOR);
		toteElevatorBottom = new DigitalInput(VariableMap.DIO_TOTE_ELEVATOR_BOTTOM);
		toteElevatorTop = new DigitalInput(VariableMap.DIO_TOTE_ELEVATOR_TOP);

		// Systems
		drive = new Drive(driveLeftTalon, driveRightTalon, encDriveLeft,encDriveRight);
		claw = new PinchClaw(pinchClawVictor);
		binElevator = new BinElevator(binElevatorTalon, encBinElevator);
		canBurglar = new CanBurglar(canBurglarSolenoid);
		rollerClaw = new RollerClaw(rollerClawLeftTalon, rollerClawRightTalon);
		toteElevator = new ToteElevator(toteElevatorTalon, toteElevatorBottom,toteElevatorTop);
		driverControl = new JoystickControllerWrapper(1, 2);
		pdp = new PowerDistributionPanel();

		// SmartDashboard
		initializeSmartDashboard();
	}

	public void autonomousInit() {
		autonomousMode = (int) autoChooser.getSelected();
	}

	public void autonomousPeriodic() {
		switch(autonomousMode)
		{
		//Default Mode
		case 0:
			break;
		//Custom 1
		case 1:
			break;
		}
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

	@SuppressWarnings("deprecation")
	public void initializeSmartDashboard() {
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Default", 0);
		autoChooser.addObject("Custom 1", 1);
		SmartDashboard.putData("Autonomous Chooser", autoChooser);

		SmartDashboard.putDouble("Left Encoder", encDriveLeft.get());
		SmartDashboard.putDouble("Right Encoder", encDriveRight.get());
		SmartDashboard.putDouble("Bin Elevator", encBinElevator.get());
		
		SmartDashboard.putString("PDP Channel 0", "Current: " + pdp.getCurrent(0));
		SmartDashboard.putString("PDP Channel 1", "Current: " + pdp.getCurrent(1));
		SmartDashboard.putString("PDP Channel 2", "Current: " + pdp.getCurrent(2));
		SmartDashboard.putString("PDP Channel 3", "Current: " + pdp.getCurrent(3));
		SmartDashboard.putString("PDP Channel 4", "Current: " + pdp.getCurrent(4));
		SmartDashboard.putString("PDP Channel 5", "Current: " + pdp.getCurrent(5));
		SmartDashboard.putString("PDP Channel 6", "Current: " + pdp.getCurrent(6));
		
		SmartDashboard.putString("PDP Temp", "Temp: " + pdp.getTemperature());
		SmartDashboard.putString("PDP Total Current", "Current: " + pdp.getTotalCurrent());
		SmartDashboard.putString("PDP Voltage", "Voltage: " + pdp.getVoltage());
		SmartDashboard.putString("PDP Total Power", "Power: " + pdp.getTotalPower() + " watts");
	}
}
