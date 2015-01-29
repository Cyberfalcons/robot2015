package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	
	XBoxController xboxDriver;
    VariableMap vm;
    Drive drive;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	vm = new VariableMap();
        xboxDriver = new XBoxController(1);
        drive = new Drive(vm);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {  	
        // Drive!
        drive.setDriveRight(xboxDriver.getRightY());
        drive.setDriveLeft(xboxDriver.getLeftY());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
