package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.io.*;
import java.util.LinkedList;

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
	Talon driveRightTalon, driveLeftTalon;
	Encoder encDriveLeft, encDriveRight, encBinElevator;
	Victor pinchClawVictor, binElevatorVictor, rollerClawRightVictor, rollerClawLeftVictor, toteElevatorVictor;
	Solenoid canBurglarSolenoid;
	DigitalInput toteElevatorTop, toteElevatorBottom, binElevatorTop, binElevatorBottom;

	// SmartDashboard Objects
	private int autonomousMode = 0;
	private SendableChooser autoChooser;
	
	//Data Collection
	LinkedList<Double> pdpChannel0Current;
	LinkedList<Double> pdpChannel1Current;
	LinkedList<Double> pdpChannel2Current;
	LinkedList<Double> pdpChannel3Current;
	LinkedList<Double> pdpChannel4Current;
	LinkedList<Double> pdpChannel5Current;
	LinkedList<Double> pdpChannel6Current;
	LinkedList<Double> pdpChannel7Current;
	LinkedList<Double> pdpChannel8Current;
	LinkedList<Double> pdpChannel9Current;
	
	LinkedList<Double> pdpTemp;
	LinkedList<Double> pdpTotalCurrent;
	LinkedList<Double> pdpVoltage;
	LinkedList<Double> pdpTotalPower;
	LinkedList<Double> pdpTotalEnergy;
	
	//Misc
	int ticks = 0;
	boolean dataToWrite = false;
	int numDataPoints = 0;
	
	public void robotInit() {
		// Drive
		driveLeftTalon = new Talon(VariableMap.PWM_DRIVE_LEFT);
		driveRightTalon = new Talon(VariableMap.PWM_DRIVE_RIGHT);
		encDriveLeft = new Encoder(VariableMap.DIO_DRIVE_ENC_LEFT_A,VariableMap.DIO_DRIVE_ENC_LEFT_B, false,Encoder.EncodingType.k4X);
		encDriveRight = new Encoder(VariableMap.DIO_DRIVE_ENC_RIGHT_A,VariableMap.DIO_DRIVE_ENC_RIGHT_B, false,Encoder.EncodingType.k4X);

		// Pinch Claw
		pinchClawVictor = new Victor(VariableMap.PWM_PINCH_CLAW);

		// Bin Elevator
		binElevatorVictor = new Victor(VariableMap.PWM_BIN_ELEVATOR);
		encBinElevator = new Encoder(VariableMap.DIO_BIN_ELEVATOR_ENC_A,VariableMap.DIO_BIN_ELEVATOR_ENC_B, false,Encoder.EncodingType.k4X);
        binElevatorTop = new DigitalInput(VariableMap.DIO_BIN_ELEVATOR_TOP);
        binElevatorBottom = new DigitalInput(VariableMap.DIO_BIN_ELEVATOR_BOTTOM);
		
		// Can Burglar
		canBurglarSolenoid = new Solenoid(VariableMap.SOL_CAN_BURGLAR);

		// Roller Claw
		rollerClawRightVictor = new Victor(VariableMap.PWM_ROLLER_RIGHT);
		rollerClawLeftVictor = new Victor(VariableMap.PWM_ROLLER_LEFT);

		// Tote Elevator
		toteElevatorVictor = new Victor(VariableMap.PWM_TOTE_ELEVATOR);
		toteElevatorBottom = new DigitalInput(VariableMap.DIO_TOTE_ELEVATOR_BOTTOM);
		toteElevatorTop = new DigitalInput(VariableMap.DIO_TOTE_ELEVATOR_TOP);

		// Systems
		drive = new Drive(driveLeftTalon, driveRightTalon, encDriveLeft,encDriveRight);
		claw = new PinchClaw(pinchClawVictor);
		binElevator = new BinElevator(binElevatorVictor, encBinElevator, binElevatorTop, binElevatorBottom);
		canBurglar = new CanBurglar(canBurglarSolenoid);
		rollerClaw = new RollerClaw(rollerClawLeftVictor, rollerClawRightVictor);
		toteElevator = new ToteElevator(toteElevatorVictor, toteElevatorBottom,toteElevatorTop);
		driverControl = new JoystickControllerWrapper(1, 2);
		pdp = new PowerDistributionPanel();

		// SmartDashboard
		initializeSmartDashboard();
		
		//Data Collection
		pdpChannel0Current = new LinkedList<Double>();
		pdpChannel1Current = new LinkedList<Double>();
		pdpChannel2Current = new LinkedList<Double>();
		pdpChannel3Current = new LinkedList<Double>();
		pdpChannel4Current = new LinkedList<Double>();
		pdpChannel5Current = new LinkedList<Double>();
		pdpChannel6Current = new LinkedList<Double>();
		pdpChannel7Current = new LinkedList<Double>();
		pdpChannel8Current = new LinkedList<Double>();
		pdpChannel9Current = new LinkedList<Double>();
		
		pdpTemp = new LinkedList<Double>();
		pdpTotalCurrent = new LinkedList<Double>();
		pdpVoltage = new LinkedList<Double>();
		pdpTotalPower = new LinkedList<Double>();
		pdpTotalEnergy = new LinkedList<Double>();
	}

	public void autonomousInit() {
		autonomousMode = (int) autoChooser.getSelected();
		dataToWrite = true;
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
		collectData();
	}

	public void teleopInit() {
		ticks = 0;
		numDataPoints = 0;
		dataToWrite = true;
	}

	public void teleopPeriodic() {
		ticks++;
		drive();
		collectData();
	}

	public void testPeriodic() {

	}
	
	public void disabledPeriodic(){
		if (dataToWrite == true)
		{
			try{
			File f = new File("data.csv");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			
			//Writing headers
			bw.write("Channel 0 Current, Channel 1 Current, Channel 2 Current, Channel 3 Current, Channel 4 Current, Channel 5 Current, Channel 6 Current, Channel 7 Current, Channel 8 Current, Channel 9 Current, Temperature, Total Current, Voltage, Total Power, Total Energy");
			bw.newLine();
			for(int i = 0; i < numDataPoints; i++)
			{
				bw.write(pdpChannel0Current.get(i) + "," + pdpChannel1Current.get(i) + "," + pdpChannel2Current.get(i) + "," + pdpChannel3Current.get(i) + "," + pdpChannel4Current.get(i) + "," + pdpChannel5Current.get(i) + "," + pdpChannel6Current.get(i) + "," + pdpChannel7Current.get(i) + "," + pdpChannel8Current.get(i) + "," + pdpChannel9Current.get(i) + "," + pdpTemp.get(i) + "," + pdpTotalCurrent.get(i) + "," + pdpVoltage.get(i) + "," + pdpTotalPower.get(i) + "," + pdpTotalEnergy.get(i));
				bw.newLine();
			}
			
			bw.close();
			fw.close();
			
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
			if(ticks % 20 == 0)
			{
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
				
				numDataPoints++;
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