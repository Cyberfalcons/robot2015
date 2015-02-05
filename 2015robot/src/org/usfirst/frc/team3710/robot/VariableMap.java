package org.usfirst.frc.team3710.robot;

public class VariableMap {
	// A file for constants used in the robot code

	/* PWM Ports (motor outputs)
	 *
	 * Port 0 - Drive Left
	 * Port 1 - Drive Right
	 * Port 2 - Left Roller
	 * Port 3 - Right Roller
	 * Port 4 - Bin Elevator Main Chain
	 * Port 5 - Tote Elevator Main Chain
	 * Port 6 -
	 * Port 7 -
	 * Port 8 -
	 * Port 9 - Can Burglar Retract
	 */
	 public static final int PWM_DRIVE_LEFT = 0;
	 public static final int PWM_DRIVE_RIGHT = 1;
	 public static final int PWM_ROLLER_LEFT = 2;
	 public static final int PWM_ROLLER_RIGHT = 3;
	 public static final int PWM_BIN_ELEVATOR = 4;
	 public static final int PWM_TOTE_ELEVATOR = 5;
	 public static final int PWM_CAN_BURGLAR = 9;
	 
	 
	/* Digital IO Pins
	 *
	 * Port 0 - Drive Encoder Left A
	 * Port 1 - Drive Encoder Left B
	 * Port 2 - Drive Encoder Right A
	 * Port 3 - Drive Encoder Right B
	 * Port 4 - Bin Zeroing Bottom
	 * Port 5 - Bin Zeroing Top
	 * Port 6 - Bin Elevator Encoder A
	 * Port 7 - Bin Elevator Encoder B
	 * Port 8 - Tote Elevator Bottom 
	 * Port 9 - Tote Elevator Top
	 */
	 public static final int DIO_DRIVE_ENC_LEFT_A = 0;
	 public static final int DIO_DRIVE_ENC_LEFT_B = 1;
	 public static final int DIO_DRIVE_ENC_RIGHT_A = 2;
	 public static final int DIO_DRIVE_ENC_RIGHT_B = 3;
	 public static final int DIO_BIN_ZEROING_TOP = 4;
	 public static final int DIO_BIN_ZEROING_BOTTOM = 5;
	 public static final int DIO_BIN_ELEVATOR_ENC_A = 6;
	 public static final int DIO_BIN_ELEVATOR_ENC_B = 7;
	 public static final int DIO_TOTE_ELEVATOR_BOTTOM = 8;
	 public static final int DIO_TOTE_ELEVATOR_TOP = 9;


	/* Misc useful constants */
	public static final double BIN_ELEVATOR_CHAIN_SPEED = 1.0;
	public static final double TOTE_ELEVATOR_CHAIN_SPEED = 1.0;
	public static final double CLAW_ROLLER_SPEED = 1.0;

}
