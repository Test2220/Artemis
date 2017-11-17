package org.usfirst.frc.team2220.robot.commands;

import org.usfirst.frc.team2220.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SolenoidControl extends Command{
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void initialize() {
		
	}
	
	public Command setLowHeight() {
		
		
		RobotMap.rightSol1.set(true); //True means tank drive
		RobotMap.rightSol2.set(false);
		
		RobotMap.leftSol1.set(true); //True means tank drive
		RobotMap.leftSol2.set(false);
		return null;
		
	}
	
	public Command  setHighHeight() {
		
		
		RobotMap.rightSol1.set(false); //True means tank drive
		RobotMap.rightSol2.set(true);
		
		RobotMap.leftSol1.set(false); //True means tank drive
		RobotMap.leftSol2.set(true);
		return null;
		
	}
	
}
