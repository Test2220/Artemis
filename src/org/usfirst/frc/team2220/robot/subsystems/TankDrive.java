package org.usfirst.frc.team2220.robot.subsystems;

import org.usfirst.frc.team2220.robot.RobotMap;
import org.usfirst.frc.team2220.robot.commands.DriveWithXBox;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TankDrive extends Subsystem{

	public CANTalon lDriveMaster;
	public CANTalon lDriveSlave;
	public CANTalon rDriveMaster; 
	public CANTalon rDriveSlave;
	public int secondsToMove; 
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	

	public TankDrive() {
		
		lDriveMaster = new CANTalon(RobotMap.leftMaster);
		lDriveSlave = new CANTalon(RobotMap.leftSlave);
		rDriveMaster = new CANTalon(RobotMap.rightMaster);
		rDriveSlave = new CANTalon(RobotMap.rightSlave);
		
		//Set Modes
		lDriveSlave.changeControlMode(TalonControlMode.Follower);
		lDriveSlave.set(lDriveMaster.getDeviceID());
		rDriveSlave.changeControlMode(TalonControlMode.Follower);
		rDriveSlave.set(rDriveMaster.getDeviceID());
		
	}
	
	public void setLeft(double value) {
		
		lDriveMaster.set(value);
		
	}
	
	public void setRight(double value) {
		
		rDriveMaster.set(value);
		
	}
	public void driveForward() {
		
		lDriveMaster.set(0.2);
		rDriveMaster.set(0.2);
		
		
	}
	
	public  void stopAll() {
		
		lDriveMaster.set(0);
		rDriveMaster.set(0);
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
		setDefaultCommand(new DriveWithXBox());
		
	}
	
}
