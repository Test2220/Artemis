package org.usfirst.frc.team2220.robot.subsystems;

import org.usfirst.frc.team2220.robot.Robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MecanumDrive extends Subsystem {
	
	static RobotDrive mecanumDrive;
	
	//Polar Drive is centered around relative to Robot
	public static void polarDrive() {
		
		mecanumDrive.mecanumDrive_Polar(Robot.oi.getDriverJoystick().getRawAxis(1), Robot.oi.getDriverJoystick().getRawAxis(5),0);
		
	}
	
	//CaretesianDrive is based on gyro headings and relative heading
	public static void cartesianDrive(double gyroInput) {
		
		mecanumDrive.mecanumDrive_Cartesian(Robot.oi.getDriverJoystick().getRawAxis(1), Robot.oi.getDriverJoystick().getRawAxis(5), 0, gyroInput);
		
	}
	
	

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
