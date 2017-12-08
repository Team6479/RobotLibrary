package org.usfirst.frc.team6479.robot.subsystems;

import org.usfirst.frc.team6479.robot.Robot;
import org.usfirst.frc.team6479.robot.RobotMap;
import org.usfirst.frc.team6479.robot.commands.Piston1;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
	
	private DoubleSolenoid dubsolenoid;
	
	public Pneumatics() {
		dubsolenoid = new DoubleSolenoid(RobotMap.onSolenoid, RobotMap.offSolenoid);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new  Piston1());
    }
    
    public void setDoubleSolenoid(Value val) {
    		dubsolenoid.set(val);
    }

    
    public DoubleSolenoid getDoubleSolenoid() {
    	return dubsolenoid;
    }
}

