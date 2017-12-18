package org.usfirst.frc.team2220.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	Joystick Driver = new Joystick(0);
	Joystick Driver2 = new Joystick(1);
	
	public Joystick getDriverJoystick() {
		
		return Driver;
		
	}
	
	public Joystick getDriver2Joystick() {
		
		return Driver2;
		
	}
	
	
	Button leftBumper = new JoystickButton(getDriverJoystick(), 4);
	Button rightBumper = new JoystickButton(getDriverJoystick(), 5);
	
	
	
	public double deadzone(double output, double threshold) {
		if (output <= threshold && output >= - threshold) {
			return 0.;
			
		}
		return output;
	}
	
}
