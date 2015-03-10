package org.usfirst.frc.team3710.robot;

public class VariableMap {

	/*
	 * PWM Ports (motor outputs)
	 * 
	 * Port 0 - Drive Left A
	 * Port 1 - Drive Right A
	 * Port 2 - Drive Left B
	 * Port 3 - Drive Right B
	 * Port 4 - Left Roller 
	 * Port 5 - Right Roller 
	 * Port 6 - Bin Elevator Main Chain 
	 * Port 7 - Can Burglar Victor
	 * Port 8 - Pinch Claw
	 * Port 9 - Can Burglar Servo Release 1
	 */
	public static final int PWM_DRIVE_LEFT_A = 0;
	public static final int PWM_DRIVE_RIGHT_A = 1;
	public static final int PWM_DRIVE_LEFT_B = 2;
	public static final int PWM_DRIVE_RIGHT_B = 3;
	public static final int PWM_ROLLER_LEFT = 4;
	public static final int PWM_ROLLER_RIGHT = 5;
	public static final int PWM_BIN_ELEVATOR = 6;
	public static final int PWM_CAN_BURGLAR_VICTOR = 7;
	public static final int PWM_PINCH_CLAW = 8;
	public static final int PWN_CAN_BURGLAR_SERVO_RELEASE_1 = 9;
	

	/*
	 * Digital IO Pins
	 * 
	 * Port 0 - Drive Encoder Left A 
	 * Port 1 - Drive Encoder Left B 
	 * Port 2 - Drive Encoder Right A 
	 * Port 3 - Drive Encoder Right B 
	 * Port 4 - Bin Zeroing Bottom 
	 * Port 5 - Bin Zeroing Top 
	 * Port 6 - Bin Elevator Encoder A 
	 * Port 7 - Bin Elevator Encoder B 
	 * Port 8 - Can Burglar Limit Switch
	 * Port 9 - 
	 */
	
	public static final int DIO_DRIVE_ENC_LEFT_A = 0;
	public static final int DIO_DRIVE_ENC_LEFT_B = 1;
	public static final int DIO_DRIVE_ENC_RIGHT_A = 2;
	public static final int DIO_DRIVE_ENC_RIGHT_B = 3;
	public static final int DIO_BIN_ELEVATOR_TOP = 4;
	public static final int DIO_BIN_ELEVATOR_BOTTOM = 5;
	public static final int DIO_BIN_ELEVATOR_ENC_A = 6;
	public static final int DIO_BIN_ELEVATOR_ENC_B = 7;
	public static final int DIO_CAN_BURGLAR_LIMIT_SWITCH = 8;

	
	/*
	 * Analog Pins
	 * 
	 * Port 0 - 
	 * Port 1 - 
	 * Port 2 - 
	 * Port 3 - 
	 */
	

	/* Misc useful variables */
	public static final double BIN_ELEVATOR_CHAIN_SPEED = 1.00;
	public static final double BIN_ELEVATOR_CONSTANT_FORCE = 0.10;
	public static final double CLAW_ROLLER_SPEED = 1.0;
	public static final double PINCH_CLAW_SPEED = 1.0;
	public static final double CAN_BURGLAR_SPEED = 1.0;
	public static final double BIN_ELEVATOR_PID_P = 0.006;
	public static final double BIN_ELEVATOR_PID_I = 0.0;
	public static final double BIN_ELEVATOR_PID_D = 0.006;
	public static final double DRIVE_PID_P = 0.000;
	public static final double DRIVE_PID_I = 0.000;
	public static final double DRIVE_PID_D = 0.000;
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
	 * Port 9 - Roller Claw Left
	 * Port 10 - Roller Claw Right
	 * Port 11 -
	 * Port 12 -
	 * Port 13 -
	 * Port 14 -
	 * Port 15 - 
	 */

}
