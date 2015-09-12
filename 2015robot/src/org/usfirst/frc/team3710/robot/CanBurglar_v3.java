package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class CanBurglar_v3 {
	//Solenoids for canburglar
	DoubleSolenoid solenoid1, solenoid2;
	
	// True/False variables to tell if the arms are retracted or not
	boolean retracted1 = true;
	boolean retracted2 = true;

	//Constructor Method Used to pass solenoids from the main robot class to the canburglar class
	public CanBurglar_v3(DoubleSolenoid ds1, DoubleSolenoid ds2) {
		solenoid1 = ds1;
		solenoid2 = ds2;
	}

	//Retracts the first solenoid if it is not already retracted
	public void retract1() {
		if(retracted1 == false){
			solenoid1.set(DoubleSolenoid.Value.kForward);
			retracted1 = true;
		}
	}

	//Deploys the first solenoid if it is not already deployed
	public void deploy1() {
		if(retracted1 == true){
			solenoid1.set(DoubleSolenoid.Value.kReverse);
			retracted1 = false;
		}
	}
	
	//Retracts the second solenoid if it is not already retracted
	public void retract2() {
		if(retracted2 == false){
			solenoid2.set(DoubleSolenoid.Value.kForward);
			retracted2 = true;
		}
	}

	//Deploys the second solenoid if it is not already deployed
	public void deploy2() {
		if(retracted2 == true){
			solenoid2.set(DoubleSolenoid.Value.kReverse);
			retracted2 = false;
		}
	}
}
