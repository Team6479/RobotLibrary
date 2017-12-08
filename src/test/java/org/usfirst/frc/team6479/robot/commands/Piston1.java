package org.usfirst.frc.team6479.robot.commands;

import org.usfirst.frc.team6479.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Piston1 extends Command {

    public Piston1() {
    	requires(Robot.pneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		if(Robot.oi.rightBumper.wasJustPressed())
		{	
			if(Robot.pneumatics.getDoubleSolenoid().get() == Value.kForward)
			{
				Robot.pneumatics.setDoubleSolenoid(Value.kReverse);
			}
			else if(Robot.pneumatics.getDoubleSolenoid().get() == Value.kReverse)
			{
				Robot.pneumatics.setDoubleSolenoid(Value.kForward);
			}
			else {
				Robot.pneumatics.setDoubleSolenoid(Value.kForward);
			}
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
