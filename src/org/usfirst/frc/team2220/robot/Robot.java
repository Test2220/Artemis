
package org.usfirst.frc.team2220.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2220.robot.commands.DriveWithXBox;
import org.usfirst.frc.team2220.robot.commands.SolenoidControl;
import org.usfirst.frc.team2220.robot.commands.TestCommand;
import org.usfirst.frc.team2220.robot.subsystems.*;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;

@SuppressWarnings("unused")
public class Robot extends IterativeRobot {
		

	public static OI oi;
	public static RobotMap robotmap;
	public static TankDrive tankdrive;
	
	//Variables
	Timer autoTimer;
	int autoCase;
	double navXVal;
	boolean tank;
	
	Command autonomousCommand;
	//Command teleOpCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	//Create a robot drive object using PWMs 1, 2, 3 and 4
    RobotDrive m_robotDrive;
	
	//CANTalon
	private CANTalon lDriveMaster;
	private CANTalon lDriveSlave;
	private CANTalon rDriveMaster; 
	private CANTalon rDriveSlave;
	
	//NavX
	public static AHRS navX;
	
	
	@Override
	public void robotInit() {
		RobotMap.init();
		//autonomousCommand = new TestCommand();
		//teleOpCommand = new DriveWithXBox();
		oi = new OI();
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(320, 240);
		camera.setFPS(30);
		camera.setBrightness(50);
		
		
		chooser.addDefault("NormalAuto", new TestCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("AutoVal", chooser);
		
		
		//Compressor
		Compressor aCompressor = new Compressor();
		aCompressor.start();
		
		//Initialize CANTalons
		lDriveMaster = new CANTalon(RobotMap.leftMaster);
		lDriveSlave = new CANTalon(RobotMap.leftSlave);
		rDriveMaster = new CANTalon(RobotMap.rightMaster);
		rDriveSlave = new CANTalon(RobotMap.rightSlave);
		rDriveMaster.setInverted(true);
		rDriveSlave.setInverted(true);
		//Init Robot Drive
		m_robotDrive = new RobotDrive(lDriveMaster, lDriveSlave, rDriveMaster, rDriveSlave);
		
		//Set Modes
		//lDriveSlave.changeControlMode(TalonControlMode.Follower);
		//lDriveSlave.set(lDriveMaster.getDeviceID());
		//rDriveSlave.changeControlMode(TalonControlMode.Follower);
		//rDriveSlave.set(rDriveMaster.getDeviceID()); 
		
		//Initialize NavX
		navX = new AHRS(SPI.Port.kMXP);
		
	}


	@Override
	public void disabledInit() {

		//teleOpCommand.cancel();
		
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		//teleOpCommand.cancel();
		if (autonomousCommand != null)
			autonomousCommand.start();
		/*autoTimer = new Timer();
		autoTimer.start();
		autoCase = 0;*/
	
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		/*if (autoTimer.get() > 3 && autoTimer.get() < 4) {
		
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
				
				lDriveMaster.set(0.3);
				rDriveMaster.set(-0.3);
				
				break;
				
			case 1:
				
				lDriveMaster.set(0.5);
				rDriveMaster.set(0.5);
				
			case 2: 
				
				lDriveMaster.set(0);
				rDriveMaster.set(0);
		
		} */
	}

	@Override
	public void teleopInit() {

		if (autonomousCommand != null)
			autonomousCommand.cancel();
		//teleOpCommand.start();
			
		RobotMap.rightSol1.set(true); //True means tank drive
		RobotMap.rightSol2.set(false);
			
		RobotMap.leftSol1.set(true); //True means tank drive
		RobotMap.leftSol2.set(false);
		
		tank = true;
		
	}

	

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//double leftOutput = oi.deadzone(oi.getDriverJoystick().getRawAxis(1), 0.2) ;
		//double rightOutput = oi.deadzone(oi.getDriverJoystick().getRawAxis(5), 0.2) ;
		double rightOutput = oi.deadzone(oi.getDriverJoystick().getY(), 0.2);
		double leftOutput = oi.deadzone(oi.getDriverJoystick().getX(), 0.2);
		double getTwist =  oi.deadzone(-oi.getDriverJoystick().getTwist(), 0.2);
		if (oi.getDriverJoystick().getRawButton(4)) {
			
			RobotMap.rightSol1.set(true); //True means tank drive
			RobotMap.rightSol2.set(false);
			
			RobotMap.leftSol1.set(true); //True means tank drive
			RobotMap.leftSol2.set(false);
			
			tank = true;
			
		}
		
		if (oi.getDriverJoystick().getRawButton(5)) {
		
			
			RobotMap.rightSol1.set(false); //True means tank drive
			RobotMap.rightSol2.set(true);
			
			RobotMap.leftSol1.set(false); //True means tank drive
			RobotMap.leftSol2.set(true);
			
			tank = false;
		}
		
		if (tank){
			m_robotDrive.arcadeDrive(-oi.deadzone(oi.getDriverJoystick().getRawAxis(0), 0.1), -oi.deadzone(oi.getDriverJoystick().getRawAxis(1), 0.1));
		}
		else{
			m_robotDrive.mecanumDrive_Cartesian(-leftOutput, -rightOutput,  getTwist, 0);
		}
		
		//mainDrive.tankDrive(oi.getDriverJoystick().getRawAxis(1), oi.getDriverJoystick().getRawAxis(5));
		//MecanumDrive.polarDrive();
		//MecanumDrive.cartesianDrive(PUT GYRO HERE);
		SmartDashboard.putNumber("NavX Value", navX.getAngle());
		

	}


	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
