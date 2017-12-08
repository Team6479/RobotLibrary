package org.usfirst.frc.team6479.robot;

import org.usfirst.frc.team6479.robot.custom.ButtonTracker;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public XboxController xbox;
	public Compressor compressor;
	public ButtonTracker rightBumper;
	public ButtonTracker leftBumper;
	
	public OI() {
		xbox = new XboxController(RobotMap.xbox);
		compressor = new Compressor();
		rightBumper = new ButtonTracker(xbox, 6);
		leftBumper = new ButtonTracker(xbox, 5);
	}
}
