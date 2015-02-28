package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	// Systems
	Controller driverControl, operatorControl;
	Drive drive;
	PinchClaw claw;
	BinElevator binElevator;
	RollerClaw rollerClaw;
	PowerDistributionPanel pdp;
	CanBurglar_v2 canBurglar;

	// Controller and Sensor
	Talon driveRightTalonA, driveLeftTalonA, driveRightTalonB, driveLeftTalonB;
	Encoder encDriveLeft, encDriveRight, encBinElevator;
	Victor pinchClawVictor, binElevatorVictor, rollerClawRightVictor, rollerClawLeftVictor, canBurglarVictor;
	DigitalInput binElevatorTop, binElevatorBottom, canBurglarLimitSwitch;
	AnalogInput binElevatorHeightPot;
	PIDController binElevatorPID;
	Servo canBurglarRelease1;

	// SmartDashboard Objects
	private int autonomousMode = 0;
	private SendableChooser autoChooser;

	// Misc
	int ticks = 0;
	double binElevatorPIDP = VariableMap.BIN_ELEVATOR_PID_P;
	double binElevatorPIDI = VariableMap.BIN_ELEVATOR_PID_I;
	double binElevatorPIDD = VariableMap.BIN_ELEVATOR_PID_D;

	public void robotInit() {
		// Drive
		driveLeftTalonA = new Talon(VariableMap.PWM_DRIVE_LEFT_A);
		driveLeftTalonB = new Talon(VariableMap.PWM_DRIVE_LEFT_B);
		driveRightTalonA = new Talon(VariableMap.PWM_DRIVE_RIGHT_A);
		driveRightTalonB = new Talon(VariableMap.PWM_DRIVE_RIGHT_B);
		encDriveLeft = new Encoder(VariableMap.DIO_DRIVE_ENC_LEFT_A, VariableMap.DIO_DRIVE_ENC_LEFT_B, false, Encoder.EncodingType.k4X);
		encDriveRight = new Encoder(VariableMap.DIO_DRIVE_ENC_RIGHT_A, VariableMap.DIO_DRIVE_ENC_RIGHT_B, false, Encoder.EncodingType.k4X);

		// Pinch Claw
		pinchClawVictor = new Victor(VariableMap.PWM_PINCH_CLAW);

		// Bin Elevator
		binElevatorVictor = new Victor(VariableMap.PWM_BIN_ELEVATOR);
		encBinElevator = new Encoder(VariableMap.DIO_BIN_ELEVATOR_ENC_A, VariableMap.DIO_BIN_ELEVATOR_ENC_B, false, Encoder.EncodingType.k4X);
		binElevatorTop = new DigitalInput(VariableMap.DIO_BIN_ELEVATOR_TOP);
		binElevatorBottom = new DigitalInput(VariableMap.DIO_BIN_ELEVATOR_BOTTOM);
		binElevatorHeightPot = new AnalogInput(VariableMap.AIN_BIN_HEIGHT_POT);
		binElevatorPID = new PIDController(binElevatorPIDP, binElevatorPIDI, binElevatorPIDD, encBinElevator, binElevatorVictor);

		// Roller Claw
		rollerClawRightVictor = new Victor(VariableMap.PWM_ROLLER_RIGHT);
		rollerClawLeftVictor = new Victor(VariableMap.PWM_ROLLER_LEFT);

		// Can Burglar
		canBurglarVictor = new Victor(VariableMap.PWM_CAN_BURGLAR_VICTOR);
		canBurglarLimitSwitch = new DigitalInput(VariableMap.DIO_CAN_BURGLAR_LIMIT_SWITCH);
		canBurglarRelease1 = new Servo(VariableMap.PWN_CAN_BURGLAR_SERVO_RELEASE_1);

		// Systems
		drive = new Drive(driveLeftTalonA, driveLeftTalonB, driveRightTalonA, driveRightTalonB, encDriveLeft, encDriveRight);
		claw = new PinchClaw(pinchClawVictor);
		binElevator = new BinElevator(binElevatorVictor, encBinElevator, binElevatorTop, binElevatorBottom, binElevatorPID, binElevatorHeightPot);
		rollerClaw = new RollerClaw(rollerClawLeftVictor, rollerClawRightVictor);
		driverControl = new JoystickControllerWrapper(0, 1);
		operatorControl = new XBoxControllerWrapper(2);
		canBurglar = new CanBurglar_v2(canBurglarVictor, canBurglarLimitSwitch, canBurglarRelease1);
		pdp = new PowerDistributionPanel();

		// SmartDashboard
		initializeSmartDashboard();
	}

	public void autonomousInit() {
		autonomousMode = (int) autoChooser.getSelected();
	}

	public void autonomousPeriodic() {
		switch (autonomousMode) {
		// Default Mode
		case 0:
			
			break;
		// Custom 1
		case 1:
			break;
		}
	}

	public void teleopInit() {
		ticks = 0;
	}

	public void teleopPeriodic() {
		ticks++;
		doDrive();
		doPinchClaw();
		doBinElevator();
		doRollerClaw();
		doCanBurglar();
		
		updateValuesFromSmartDashboard();
	}

	public void testPeriodic() {

	}
	
	public void disabledInit(){
		canBurglar.servoTo0();
	}

	public void disabledPeriodic() {

	}

	public void doDrive() {
		driverControl.checkFlip();
		drive.setDriveRight(driverControl.driveRight());
		drive.setDriveLeft(driverControl.driveLeft());
	}

	public void doPinchClaw() {
		if (driverControl.openPinchClaw() || operatorControl.oOpenPinchClaw()) {
			claw.openClaw();
		} else if (driverControl.closePinchClaw()
				|| operatorControl.oOpenPinchClaw()) {
			claw.closeClaw();
		} else {
			claw.stopClaw();
		}
	}

	public void doRollerClaw() {
		if (driverControl.rollerIn()) {
			rollerClaw.binIn();
		} else if (driverControl.rollerOut()) {
			rollerClaw.binOut();
		} else {
			rollerClaw.stop();
		}
	}

	public void doCanBurglar() {
		if(driverControl.getRightButton10()){
			canBurglar.servoTo1();
		}else if(driverControl.getRightButton11()){
			canBurglar.servoToMinus1();
		}else{
			canBurglar.servoTo0();
		}
	}

	public void doBinElevator() {
		if (driverControl.elevatorUp() || operatorControl.oElevatorUp()) {
			binElevator.setChainUp();
		} else if (driverControl.elevatorDown()|| operatorControl.oElevatorDown()) {
			binElevator.setChainDown();
		} else {
			binElevator.setChainStopped();
		}
	}

	@SuppressWarnings("deprecation")
	public void updateValuesFromSmartDashboard() {
		binElevatorPIDP = SmartDashboard.getNumber("Bin Elevator PID P");
		binElevatorPIDI = SmartDashboard.getNumber("Bin Elevator PID I");
		binElevatorPIDD = SmartDashboard.getNumber("Bin Elevator PID D");
		binElevatorPID.setPID(binElevatorPIDP, binElevatorPIDI, binElevatorPIDD);

		SmartDashboard.putDouble("Left Encoder", encDriveLeft.get());
		SmartDashboard.putDouble("Right Encoder", encDriveRight.get());

		SmartDashboard.putDouble("Bin Elevator PID P", binElevatorPIDP);
		SmartDashboard.putDouble("Bin Elevator PID I", binElevatorPIDI);
		SmartDashboard.putDouble("Bin Elevator PID D", binElevatorPIDD);
	}

	@SuppressWarnings("deprecation")
	private void initializeSmartDashboard() {
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Default", 0);
		autoChooser.addObject("Custom 1", 1);
		
		SmartDashboard.putData("Autonomous Chooser", autoChooser);

		SmartDashboard.putDouble("Left Encoder", encDriveLeft.get());
		SmartDashboard.putDouble("Right Encoder", encDriveRight.get());

		SmartDashboard.putDouble("Bin Elevator PID P", binElevatorPIDP);
		SmartDashboard.putDouble("Bin Elevator PID I", binElevatorPIDI);
		SmartDashboard.putDouble("Bin Elevator PID D", binElevatorPIDD);
	}
}