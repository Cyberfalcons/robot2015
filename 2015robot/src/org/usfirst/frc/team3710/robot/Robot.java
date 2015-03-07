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
	CanBurglar_v2 canBurglar;
	PowerDistributionPanel pdp;

	// Controller and Sensor
	Talon driveRightTalonA, driveLeftTalonA, driveRightTalonB, driveLeftTalonB;
	Encoder encDriveLeft, encDriveRight, binElevatorEncoder;
	Victor pinchClawVictor, binElevatorVictor, rollerClawRightVictor, rollerClawLeftVictor, canBurglarVictor;
	DigitalInput binElevatorTop, binElevatorBottom, canBurglarLimitSwitch;
	PIDController binElevatorPID;
	Servo canBurglarRelease1;

	// SmartDashboard Objects
	int autonomousMode = 0;
	int sensorMode = 0;
	SendableChooser autoChooser, autoSensorMode;

	// Misc
	int ticks = 0;
	double binElevatorPIDP = VariableMap.BIN_ELEVATOR_PID_P;
	double binElevatorPIDI = VariableMap.BIN_ELEVATOR_PID_I;
	double binElevatorPIDD = VariableMap.BIN_ELEVATOR_PID_D;
	
	// Autonomous Variables
	boolean servoMoved = false;

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
		binElevatorEncoder = new Encoder(VariableMap.DIO_BIN_ELEVATOR_ENC_A, VariableMap.DIO_BIN_ELEVATOR_ENC_B, false, Encoder.EncodingType.k4X);
		binElevatorTop = new DigitalInput(VariableMap.DIO_BIN_ELEVATOR_TOP);
		binElevatorBottom = new DigitalInput(VariableMap.DIO_BIN_ELEVATOR_BOTTOM);
		binElevatorPID = new PIDController(binElevatorPIDP, binElevatorPIDI, binElevatorPIDD, binElevatorEncoder, binElevatorVictor);

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
		binElevator = new BinElevator(binElevatorVictor, binElevatorEncoder, binElevatorTop, binElevatorBottom, binElevatorPID);
		rollerClaw = new RollerClaw(rollerClawLeftVictor, rollerClawRightVictor);
		driverControl = new JoystickControllerWrapper(0, 1);
		operatorControl = new XBoxControllerWrapper(2);
		canBurglar = new CanBurglar_v2(canBurglarVictor, canBurglarLimitSwitch, canBurglarRelease1);
		pdp = new PowerDistributionPanel();

		// SmartDashboard
		initializeSmartDashboard();
	}

	public void autonomousInit() {
		ticks = 0;
		autonomousMode = (int) autoChooser.getSelected();
		sensorMode = (int) autoSensorMode.getSelected();
	}

	public void autonomousPeriodic() {
		ticks++;
		switch (autonomousMode) {
		// Can Burgle and Drive
		case 0:
			//Ticks
			if(sensorMode == 0){
				if(servoMoved == false){
					canBurglar.setServoPosition(1.0);
					servoMoved = true;
				}
				
				if(ticks < 2000){
					drive.setDriveLeft(-1.00);
					drive.setDriveRight(-1.00);
				}
				else if(ticks > 2000){
					drive.setDriveLeft(0.00);
					drive.setDriveRight(0.00);
				}
				
				if((ticks > 3000) && (canBurglar.getLimitSwitch() == false)){
					canBurglar.retract();
				}else if(canBurglar.getLimitSwitch() == true){
					canBurglar.stop();
				}
				
				if((ticks > 5000) && (canBurglar.getLimitSwitch() == true)){
					canBurglar.setServoPosition(-1.0);
				}
			//Encoders
			}else if(sensorMode == 1){
				if(servoMoved == false){
					canBurglar.setServoPosition(1.0);
					servoMoved = true;
				}
				
				if((drive.getEncoderLeft() < 5000)&&(drive.getEncoderRight() < 5000)){
					drive.setDriveLeft(-1.00);
					drive.setDriveRight(-1.00);
				}else if((drive.getEncoderLeft() > 5000)&&(drive.getEncoderRight() > 5000)){
					drive.setDriveRight(0.0);
					drive.setDriveLeft(0.0);
				}
				
				if((ticks > 3000) && (canBurglar.getLimitSwitch() == false)){
					canBurglar.retract();
				}else if(canBurglar.getLimitSwitch() == true){
					canBurglar.stop();
				}
				
				if((ticks > 5000) && (canBurglar.getLimitSwitch() == true)){
					canBurglar.setServoPosition(-1.0);
				}
			}
			
			break;
			
		// Just Drive
		case 1:
			//Ticks
			if(sensorMode == 0){
				if(ticks <= 5000){
					drive.setDriveLeft(1.00);
					drive.setDriveRight(1.00);
				}else if(ticks> 5000){
					drive.setDriveLeft(0.0);
					drive.setDriveRight(0.0);
				}
		    //Encoders
			}else if(sensorMode == 1){
				if((drive.getEncoderLeft() < 5000) && (drive.getEncoderRight() < 5000)){
					drive.setDriveLeft(1.00);
					drive.setDriveRight(1.00);
				}else if((drive.getEncoderLeft() > 5000) && (drive.getEncoderRight() > 5000)){
					drive.setDriveLeft(0.00);
					drive.setDriveRight(0.00);
				}
			}
			break;
			
		//Do Nothing
		case 2:
			
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
		
		if(VariableMap.VERBOSE_CONSOLE){
			System.out.println("Elevator Encoder: " +  binElevator.getEncoder());
			System.out.println("Elevator Top: " + binElevator.getTop());
			System.out.println("Elevator Bottom: " + binElevator.getBottom());
		}
	}

	public void testPeriodic() {

	}
	
	public void disabledInit(){
		
	}

	public void disabledPeriodic() {

	}

	public void doDrive() {
		driverControl.checkFlip();
		drive.setDriveRight(driverControl.driveRight());
		drive.setDriveLeft(driverControl.driveLeft());
		
		if(operatorControl.getBtnA())
		{
			if(VariableMap.SLOW_MODE == false){
				VariableMap.SLOW_MODE = true;
			}else if(VariableMap.SLOW_MODE == true){
				VariableMap.SLOW_MODE = false;
			}
		}
	}

	public void doPinchClaw() {
		if (driverControl.openPinchClaw()) {
			claw.openClaw();
		} else if (driverControl.closePinchClaw()) {
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
		} else  if(operatorControl.getBtnB()){
			rollerClaw.binClockWise();
		} else  if(operatorControl.getBtnX()){
			rollerClaw.binCounterClockWise();
		}else {
			rollerClaw.stop();
		}
	}

	public void doCanBurglar() {
		if(driverControl.getRightButton10()){
			canBurglar.retract();
		}else{
			canBurglar.stop();
		}
		
		if(driverControl.getRightButton6()){
			canBurglar.setServoPosition(1.0);
		}else if(driverControl.getRightButton7()){
			canBurglar.setServoPosition(-1.0);
		}
	}

	public void doBinElevator() {
		if (driverControl.elevatorUp()) {
			binElevator.setPositionUp();
		} else if (driverControl.elevatorDown()) {
			binElevator.setPositionDown();
		}else if(driverControl.getRightButton11()){
			binElevator.setSetPoint(0);
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
		SmartDashboard.putDouble("Elevator Encoder", binElevator.getEncoder());

		SmartDashboard.putDouble("Bin Elevator PID P", binElevatorPIDP);
		SmartDashboard.putDouble("Bin Elevator PID I", binElevatorPIDI);
		SmartDashboard.putDouble("Bin Elevator PID D", binElevatorPIDD);
		
		SmartDashboard.putBoolean("Bin Elevator Top", binElevator.getTop());
		SmartDashboard.putBoolean("Bin Elevator Bottom", binElevator.getBottom());
	}

	@SuppressWarnings("deprecation")
	private void initializeSmartDashboard() {
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Get Bins and Drive", 0);
		autoChooser.addObject("Just drive", 1);
		autoChooser.addObject("Do Nothing", 2);
		
		autoSensorMode = new SendableChooser();
		autoSensorMode.addDefault("Ticks", 0);
		autoSensorMode.addObject("Encoders", 1);
		
		SmartDashboard.putData("Autonomous Chooser", autoChooser);
		SmartDashboard.putData("Auto Sensor Chooser", autoSensorMode);

		SmartDashboard.putDouble("Left Encoder", encDriveLeft.get());
		SmartDashboard.putDouble("Right Encoder", encDriveRight.get());
		SmartDashboard.putDouble("Elevator Encoder", binElevator.getEncoder());

		SmartDashboard.putDouble("Bin Elevator PID P", binElevatorPIDP);
		SmartDashboard.putDouble("Bin Elevator PID I", binElevatorPIDI);
		SmartDashboard.putDouble("Bin Elevator PID D", binElevatorPIDD);
		
		SmartDashboard.putBoolean("Bin Elevator Top", binElevator.getTop());
		SmartDashboard.putBoolean("Bin Elevator Bottom", binElevator.getBottom());
	}
}