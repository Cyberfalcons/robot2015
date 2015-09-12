package org.usfirst.frc.team3710.robot;

//Used to layout all ports and interfaces that the robot uses so that you do not put two systems on one PWM or something!
public class VariableMap {

	/*
	 * PWM Ports (motor outputs)
	 * 
	 * Port 0 - Drive Left A
	 * Port 1 - Drive Right A
	 * Port 2 - Left Roller 
	 * Port 3 - Right Roller 
	 * Port 4 - Tote Elevator Main Chain 
	 * Port 5 - 
	 * Port 6 - 
	 * Port 7 - 
	 * Port 8 - 
	 * Port 9 - 
	 */
	public static final int PWM_DRIVE_LEFT_A = 0;
	public static final int PWM_DRIVE_RIGHT_A = 1;
	public static final int PWM_ROLLER_LEFT = 2;
	public static final int PWM_ROLLER_RIGHT = 3;
	public static final int PWM_TOTE_ELEVATOR = 4;
	
	/*
	 * PCM Modules
	 * Port 0 - CanBurglar Double Solenoid 1 A
	 * Port 1 - CanBurglar Double Solenoid 1 B
	 * Port 2 - CanBurglar Double Solenoid 2 A
	 * Port 3 - CanBurglar Double Solenoid 2 B
	 * Port 4 -
	 * Port 5 -
	 * Port 6 -
	 * Port 7 -
	 */
	public static final int PCM_CAN_BURGLAR_SOLE_1_A = 0;
	public static final int PCM_CAN_BURGLAR_SOLE_1_B = 1;
	public static final int PCM_CAN_BURGLAR_SOLE_2_A = 2;
	public static final int PCM_CAN_BURGLAR_SOLE_2_B = 3;
	

	/*
	 * Digital IO Pins
	 * 
	 * Port 0 - Drive Encoder Left A 
	 * Port 1 - Drive Encoder Left B 
	 * Port 2 - Drive Encoder Right A 
	 * Port 3 - Drive Encoder Right B 
	 * Port 4 - Tote Zeroing Bottom 
	 * Port 5 - Tote Zeroing Top 
	 * Port 6 - Tote Elevator Encoder A 
	 * Port 7 - Tote Elevator Encoder B 
	 * Port 8 - 
	 * Port 9 - 
	 */
	
	public static final int DIO_DRIVE_ENC_LEFT_A = 0;
	public static final int DIO_DRIVE_ENC_LEFT_B = 1;
	public static final int DIO_DRIVE_ENC_RIGHT_A = 2;
	public static final int DIO_DRIVE_ENC_RIGHT_B = 3;
	public static final int DIO_TOTE_ELEVATOR_TOP = 4;
	public static final int DIO_TOTE_ELEVATOR_BOTTOM = 5;
	public static final int DIO_TOTE_ELEVATOR_ENC_A = 6;
	public static final int DIO_TOTE_ELEVATOR_ENC_B = 7;

	
	/*
	 * Analog Pins
	 * 
	 * Port 0 - 
	 * Port 1 - 
	 * Port 2 - 
	 * Port 3 - 
	 */
	

	/* Misc useful variables */
	public static final double TOTE_ELEVATOR_CHAIN_SPEED = 1.00;
	public static final double CLAW_ROLLER_SPEED = 1.0;
	public static final double TOTE_ELEVATOR_PID_P = 0.006;
	public static final double TOTE_ELEVATOR_PID_I = 0.0;
	public static final double TOTE_ELEVATOR_PID_D = 0.006;
	public static final double DRIVE_PID_P = 0.006;
	public static final double DRIVE_PID_I = 0.000;
	public static final double DRIVE_PID_D = 0.002;
	public static boolean SLOW_MODE_DRIVE = false;
	public static boolean SLOW_MODE_ROLLER = false;
	public static boolean VERBOSE_CONSOLE = false;
	
	/* Power Channels
	 * 
	 * Port 0 - 
	 * Port 1 - 
	 * Port 2 - 
	 * Port 3 - 
	 * Port 4 -
	 * Port 5 - 
	 * Port 6 -
	 * Port 7 -
	 * Port 8 -
	 * Port 9 - 
	 * Port 10 - 
	 * Port 11 -
	 * Port 12 -
	 * Port 13 -
	 * Port 14 -
	 * Port 15 - 
	 */

}
