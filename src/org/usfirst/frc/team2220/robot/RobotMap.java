package org.usfirst.frc.team2220.robot;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final int leftMaster = 1,
								leftSlave = 2,
								rightMaster = 3,
								rightSlave = 4;
	
	public static final  Solenoid rightSol1 = new Solenoid(6);
	public static final Solenoid rightSol2 = new Solenoid(7);
	public static final Solenoid leftSol1 = new Solenoid(4);
	public static final Solenoid leftSol2 = new Solenoid(5);
	public static void init() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
