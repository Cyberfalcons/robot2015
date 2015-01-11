package edu.wpi.first.wpilibj.templates;



public class VariableMap {
	// A file for constants used in the robot code

	/* PWM Ports (motor outputs)
	 *
	 * Port 0 - Drive Left
	 * Port 1 - Drive Right
	 * Port 2 - Left Roller
	 * Port 3 - Right Roller
	 * Port 4 - Bin Elevator Main Chain
	 * Port 5 -
	 * Port 6 -
	 * Port 7 -
	 * Port 8 -
	 * Port 9 - Can Burglar Retract
	 */
	 public static int PWM_DRIVE_LEFT = 0;
	 public static int PWM_DRIVE_RIGHT = 1;
	 public static int PWM_ROLLER_LEFT = 2;
	 public static int PWM_ROLLER_RIGHT = 3;
	 public static int PWM_BIN_ELEVATOR = 4;
	 public static int PWM_CAN_BURGLAR = 9;
	 
	 
	/* Digital IO Pins
	 *
	 * Port 0 - Drive Encoder Left
	 * Port 1 - Drive Encoder Right
	 * Port 2 - Step Bumper
	 * Port 3 - Bin In Place
	 * Port 4 -
	 * Port 5 -
	 * Port 6 -
	 * Port 7 -
	 * Port 8 -
	 * Port 9 -
	 */
	 public static int DIO_DRIVE_ENC_LEFT = 0;
	 public static int DIO_DRIVE_ENC_RIGHT = 1;
	 public static int DIO_STEP_BUMPER = 2;
	 public static int DIO_BIN_IN_THROAT = 3; // This probably needs a better name


	/* Misc useful constants */
	
	public static double BIN_ELEVATOR_CHAIN_SPEED = 1.0;
	public static double CLAW_ROLLER_SPEED = 1.0;

}
