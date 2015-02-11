package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.io.*;
import java.util.ArrayList;

public class Robot extends IterativeRobot {
	
	//Systems
	Controller driverControl;
	Drive drive;
	PinchClaw claw;
	BinElevator binElevator;
	CanBurglar canBurglar;
	RollerClaw rollerClaw;
	ToteElevator toteElevator;
	PowerDistributionPanel pdp;

	// Controller and Sensor
	Talon driveRightTalon, driveLeftTalon, binElevatorTalon,rollerClawRightTalon, rollerClawLeftTalon, toteElevatorTalon;
	Encoder encDriveLeft, encDriveRight, encBinElevator;
	Victor pinchClawVictor;
	Solenoid canBurglarSolenoid;
	DigitalInput toteElevatorTop, toteElevatorBottom;

	// SmartDashboard Objects
	private int autonomousMode = 0;
	private SendableChooser autoChooser;
	
	//Data Collection
	ArrayList<Double> pdpChannel0Current;
	ArrayList<Double> pdpChannel1Current;
	ArrayList<Double> pdpChannel2Current;
	ArrayList<Double> pdpChannel3Current;
	ArrayList<Double> pdpChannel4Current;
	ArrayList<Double> pdpChannel5Current;
	ArrayList<Double> pdpChannel6Current;
	ArrayList<Double> pdpChannel7Current;
	ArrayList<Double> pdpChannel8Current;
	ArrayList<Double> pdpChannel9Current;
	
	ArrayList<Double> pdpTemp;
	ArrayList<Double> pdpTotalCurrent;
	ArrayList<Double> pdpVoltage;
	ArrayList<Double> pdpTotalPower;
	ArrayList<Double> pdpTotalEnergy;
	
	//Misc
	int tick = 0;
	boolean dataToWrite = false;
	
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
		
		//Data Collection
		pdpChannel0Current = new ArrayList<Double>();
		pdpChannel1Current = new ArrayList<Double>();
		pdpChannel2Current = new ArrayList<Double>();
		pdpChannel3Current = new ArrayList<Double>();
		pdpChannel4Current = new ArrayList<Double>();
		pdpChannel5Current = new ArrayList<Double>();
		pdpChannel6Current = new ArrayList<Double>();
		pdpChannel7Current = new ArrayList<Double>();
		pdpChannel8Current = new ArrayList<Double>();
		pdpChannel9Current = new ArrayList<Double>();
		
		pdpTemp = new ArrayList<Double>();
		pdpTotalCurrent = new ArrayList<Double>();
		pdpVoltage = new ArrayList<Double>();
		pdpTotalPower = new ArrayList<Double>();
		pdpTotalEnergy = new ArrayList<Double>();
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
		tick = 0;
		dataToWrite = true;
	}

	public void teleopPeriodic() {
		tick++;
		drive();
		collectData();
	}

	public void testPeriodic() {

	}
	
	public void disabledPeriodic(){
		if (dataToWrite == true)
		{
			try{
			File f = new File("sad.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			
			
			
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		dataToWrite = false;
	}

	public void drive() {
		driverControl.checkFlip();
		drive.setDriveRight(driverControl.driveRight());
		drive.setDriveLeft(driverControl.driveLeft());
	}
	
	public void raiseBinElevator(int stackHeight){
		
	}
	
	public void lowerBinElevator(int stackHeight){
		
	}
	
	public void collectData(){
		if(tick % 5 == 0){
			pdpChannel0Current.add(pdp.getCurrent(0));
			pdpChannel1Current.add(pdp.getCurrent(1));
			pdpChannel2Current.add(pdp.getCurrent(2));
			pdpChannel3Current.add(pdp.getCurrent(3));
			pdpChannel4Current.add(pdp.getCurrent(4));
			pdpChannel5Current.add(pdp.getCurrent(5));
			pdpChannel6Current.add(pdp.getCurrent(6));
			pdpChannel7Current.add(pdp.getCurrent(7));
			pdpChannel8Current.add(pdp.getCurrent(8));
			pdpChannel9Current.add(pdp.getCurrent(9));
			
			pdpTemp.add(pdp.getTemperature());
			pdpTotalCurrent.add(pdp.getTotalCurrent());
			pdpVoltage.add(pdp.getVoltage());
			pdpTotalPower.add(pdp.getTotalPower());
			pdpTotalEnergy.add(pdp.getTotalEnergy());
		}
	}

	@SuppressWarnings("deprecation")
	private void initializeSmartDashboard() {
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
		SmartDashboard.putString("PDP Total Energy: ", "Energy: " + pdp.getTotalEnergy());
	}
}
