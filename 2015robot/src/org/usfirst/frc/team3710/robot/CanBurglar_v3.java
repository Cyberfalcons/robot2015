package org.usfirst.frc.team3710.robot;

import edu.wpi.first.wpilibj.*;

public class CanBurglar_v3 {
	DoubleSolenoid solenoid1, solenoid2;
	boolean retracted1 = true;
	boolean retracted2 = true;

	public CanBurglar_v3(DoubleSolenoid ds1, DoubleSolenoid ds2) {
		solenoid1 = ds1;
		solenoid2 = ds2;
	}

	public void retract1() {
		if(retracted1 == false){
			solenoid1.set(DoubleSolenoid.Value.kForward);
			retracted1 = true;
		}
	}

	public void deploy1() {
		if(retracted1 == true){
			solenoid1.set(DoubleSolenoid.Value.kReverse);
			retracted1 = false;
		}
	}
	
	public void retract2() {
		if(retracted2 == false){
			solenoid2.set(DoubleSolenoid.Value.kForward);
			retracted2 = true;
		}
	}

	public void deploy2() {
		if(retracted2 == true){
			solenoid2.set(DoubleSolenoid.Value.kReverse);
			retracted2 = false;
		}
	}
}
