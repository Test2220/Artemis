package org.usfirst.frc.team2220.robot.commands;

import org.usfirst.frc.team2220.robot.Robot;
import org.usfirst.frc.team2220.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveWithXBox extends Command{

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Get Deadzone Values
    	double leftOutput = Robot.oi.deadzone(Robot.oi.getDriverJoystick().getRawAxis(1), 0.1);
		double rightOutput = Robot.oi.deadzone(Robot.oi.getDriverJoystick().getRawAxis(5), 0.2) ;
		
		//Set Output Values
		Robot.tankdrive.setLeft(leftOutput);
		Robot.tankdrive.setRight(rightOutput);
		
if (Robot.oi.getDriverJoystick().getRawButton(4)) {
			
			RobotMap.rightSol1.set(true); //True means tank drive
			RobotMap.rightSol2.set(false);
			
			RobotMap.leftSol1.set(true); //True means tank drive
			RobotMap.leftSol2.set(false);
			
		}
		
		if (Robot.oi.getDriverJoystick().getRawButton(5)) {
		
			
			RobotMap.rightSol1.set(false); //True means tank drive
			RobotMap.rightSol2.set(true);
			
			RobotMap.leftSol1.set(false); //True means tank drive
			RobotMap.leftSol2.set(true);
		}
		
		if (Robot.oi.getDriverJoystick().getRawButton(6)) {
			
			new AutoTurn().TurnWithGyro(30);
			
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
