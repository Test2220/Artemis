package org.usfirst.frc.team2220.robot.commands;

import org.usfirst.frc.team2220.robot.Robot;
import org.usfirst.frc.team2220.robot.subsystems.TankDrive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class basicAuto extends Command{
	
	public int autoCase;
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public basicAuto () {
		
		switch (autoCase) {
		
		case 0: 
			Robot.tankdrive.driveForward();
			
			break;
			
		case 1: 
			Robot.tankdrive.stopAll();
		
		}
		
	}
	

	
	}
	


