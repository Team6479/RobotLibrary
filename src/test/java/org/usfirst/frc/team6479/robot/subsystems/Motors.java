package org.usfirst.frc.team6479.robot.subsystems;

import org.usfirst.frc.team6479.robot.RobotMap;
import org.usfirst.frc.team6479.robot.commands.Drive;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Motors extends Subsystem {

	private Victor leftMotor;
	private Victor rightMotor;
	
	public Motors() {
		leftMotor = new Victor(RobotMap.leftMotor);
		rightMotor = new Victor(RobotMap.rightMotor);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Drive());
    }
    
    public void setLeftMotor(double speed) {
    	leftMotor.set(speed);
    }
    
    public void setRightMotor(double speed) {
    	rightMotor.set(speed);
    }
    
}

