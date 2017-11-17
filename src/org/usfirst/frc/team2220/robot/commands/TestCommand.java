package org.usfirst.frc.team2220.robot.commands;

import org.usfirst.frc.team2220.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class TestCommand extends Command{

	Timer autoTimer;
	int autoCase;
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	 // Called just before this Command runs the first time
    protected void initialize() {
    	
    	autoTimer = new Timer();
		autoTimer.start();
		autoCase = 0;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (autoTimer.get() > 3 && autoTimer.get() < 4) {
    		
			autoCase = 1;
			
		} else if (autoTimer.get() > 4 && autoTimer.get() < 7) {
			
			autoCase = 0;
			
		} else if (autoTimer.get() > 7 && autoTimer.get() < 10) {
			
			autoCase = 1;
			
		} else if (autoTimer.get() > 10) {
			
			autoCase = 2;
			
		}
		
			
			switch (autoCase) {
			
			case 0: 
				
				Robot.tankdrive.lDriveMaster.set(0.3);
				Robot.tankdrive.rDriveMaster.set(-0.3);
				
				break;
				
			case 1:
				
				Robot.tankdrive.lDriveMaster.set(0.3);
				Robot.tankdrive.rDriveMaster.set(-0.3);
				
			case 2: 
				
				Robot.tankdrive.stopAll();
		
	}
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

}
