package org.usfirst.frc.team3710.robot;

public class VariableMap {
	// A file for constants used in the robot code

	/*
	 * PWM Ports (motor outputs)
	 * 
	 * Port 0 - Drive Left 
	 * Port 1 - Drive Right 
	 * Port 2 - Left Roller 
	 * Port 3 - Right Roller 
	 * Port 4 - Bin Elevator Main Chain 
	 * Port 5 - Can Burglar Victor
	 * Port 6 - Pinch Claw
	 * Port 7 - Can Burglar Servo Release 1
	 * Port 8 - 
	 * Port 9 - 
	 */
	public static final int PWM_DRIVE_LEFT_A = 0;
	public static final int PWM_DRIVE_RIGHT_A = 1;
	public static final int PWM_ROLLER_LEFT = 2;
	public static final int PWM_ROLLER_RIGHT = 3;
	public static final int PWM_BIN_ELEVATOR = 4;
	public static final int PWM_CAN_BURGLAR_VICTOR = 5;
	public static final int PWM_PINCH_CLAW = 6;
	public static final int PWN_CAN_BURGLAR_SERVO_RELEASE_1 = 7;
	public static final int PWM_DRIVE_LEFT_B = 8;
	public static final int PWM_DRIVE_RIGHT_B = 9;
	

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
	 * Port 0 - Bin Elevator height pot
	 * Port 1 - 
	 * Port 2 - 
	 * Port 3 - 
	 */
	public static final int AIN_BIN_HEIGHT_POT = 0;
	

	/* Misc useful constants */
	public static final double BIN_ELEVATOR_CHAIN_SPEED = 1.00;
	public static final double BIN_ELEVATOR_CONSTANT_FORCE = 0.10;
	public static final double CLAW_ROLLER_SPEED = 1.0;
	public static final double PINCH_CLAW_SPEED = 1.0;
	public static final double CAN_BURGLAR_SPEED = 1.0;
	public static final double BIN_ELEVATOR_PID_P = 0.006;
	public static final double BIN_ELEVATOR_PID_I = 0.0;
	public static final double BIN_ELEVATOR_PID_D = 0.006;
	public static boolean SLOW_MODE = false;
	
	
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
