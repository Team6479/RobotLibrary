package robot.autonomous.dynamic;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * <h1>Robot Control</h1>
 * Knows about and controls all functions on the robot. This class is capable of managing {@link SpeedController}, {@link Solenoid}, and {@link DoubleSolenoid} objects.
 * 
 * 
 * @author Jacob Abraham
 */

//TODO: redo log() to fucntion with a map so that motor values can be named
//TODO: rewrite with maps instead of arrays
public class RobotControl {
	
	/**
	 * Holds all {@link SpeedController} objects managed by this class
	 */
	private SpeedController[] motorControllers;
	/**
	 * Holds all {@link Solenoid} objects managed by this class
	 */
	private Solenoid[] solenoids;
	/**
	 * Holds all {@link DoubleSolenoid} objects managed by this class
	 */
	private DoubleSolenoid[] doubleSolenoids;
	
	
	/**
	 * Constructor that the arrays that store the objects
	 * 
	 * @param motorControllers array of the {@link SpeedController} objects managed by this class
	 * @param solenoids array of the {@link Solenoid} objects managed by this class
	 * @param doubleSolenoids array of the {@link DoubleSolenoid} objects managed by this class
	 */
	public RobotControl(SpeedController[] motorControllers, Solenoid[] solenoids, DoubleSolenoid[] doubleSolenoids) {
		this.motorControllers = motorControllers;
		this.solenoids = solenoids;
		this.doubleSolenoids = doubleSolenoids;
	}
	
	
	/**
	 * Stops all motors and sets solenoids to a neutral state
	 */
	public void stop() {
		for(SpeedController sc: motorControllers) {
			sc.set(0);
		}
		for(Solenoid s: solenoids) {
			s.set(false);
		}
		for(DoubleSolenoid ds: doubleSolenoids) {
			ds.set(Value.kOff);
		}
	}
	
	/**
	 * Write the current value of all objects to a string
	 * @return a string of the form '{[&lt;&gt;,&lt;&gt;,...][&lt;&gt;,&lt;&gt;,...][&lt;&gt;,&lt;&gt;,...]}' in the order of: {@link SpeedController}, {@link Solenoid}, {@link DoubleSolenoid}
	 */
	public String log() {
		//motor controller values
		String motorValues = "[";
		for(SpeedController sc: motorControllers) {
			//get the speed
			double speed = sc.get();
			motorValues += String.format("%.4f,", speed);
			
		}
		//remove trailing comma
		motorValues = motorValues.substring(0, motorValues.length() - 2);
		motorValues += "]";
		
		
		//solenoid values
		String solenoidValues = "[";
		for(Solenoid s: solenoids) {
			//get the current state
			boolean state = s.get();
			solenoidValues += String.format("%b,", state);
			
		}
		//remove trailing comma
		solenoidValues = solenoidValues.substring(0, solenoidValues.length() - 2);
		solenoidValues += "]";
		
		
		//double solenoid values
		String dSolenoidValues = "[";
		for(DoubleSolenoid ds: doubleSolenoids) {
			//get the current state
			String state = ds.get().name();
			dSolenoidValues += String.format("%s,", state);
			
		}
		//remove trailing comma
		dSolenoidValues = dSolenoidValues.substring(0, dSolenoidValues.length() - 2);
		dSolenoidValues += "]";
		
		
		return String.format("{%s%s%s}\n", motorValues, solenoidValues, dSolenoidValues);
	}
	
	/**
	 * Read in a string, parse it, and set the values to the control objects
	 * @param values string of the form '{[#,#,...][#,#,...][#,#,...]}' in the order of: {@link SpeedController}, {@link Solenoid}, {@link DoubleSolenoid}
	 * @return true if successfully parsed and values set
	 */
	public boolean set(String values) {
		//compute the speeds
		//remove the ending brackets and braces
		String input = values.substring(2, values.length() - 2);
		//split the string for character arrangement ][
		String[] types = input.split("\\]\\[");
		
		//types must be of length 2. if not, return false
		if(types.length != 2) {
			return false;
		}
		
		//parse values, if error occurs return false
		if(!parseMotor(types[0]) || !parseSolenoid(types[1]) || !parseDoubleSolenoid(types[2])) {
			return false;
		}
		
		//return with no error
		return true;
	}
	
	/**
	 * Parse a string of {@link SpeedController} values and set them to the corresponding {@link SpeedController}
	 * @param values string of the form '[<>,<>,...]' which contains {@link SpeedController} values in order
	 * @return true if successfully parsed and values set
	 */
	private boolean parseMotor(String values) {
		
		//split the comma seperated vaues
		String[] speeds = values.split(",");
		
		//if the length of the speeds and the length of the motorControllers is different, return false
		if(speeds.length != motorControllers.length) {
			return false;
		}
		
		for(int i = 0; i < speeds.length; i++)
		{
			SpeedController sc = motorControllers[i];
			sc.set(Double.parseDouble(speeds[i]));
		}
		
		//return with no error
		return true;
	}
	
	/**
	 * Parse a string of {@link Solenoid} values and set them to the corresponding {@link Solenoid}
	 * @param values string of the form '[<>,<>,...]' which contains {@link Solenoid} values in order
	 * @return true if successfully parsed and values set
	 */
	private boolean parseSolenoid(String values) {
	
		//split the comma seperated vaues
		String[] states = values.split(",");
		
		//if the length of the speeds and the length of the solenoids is different, return false
		if(states.length != solenoids.length) {
			return false;
		}
		
		for(int i = 0; i < states.length; i++)
		{
			Solenoid s = solenoids[i];
			s.set(Boolean.getBoolean(states[i]));
		}
	
		//return with no error
		return true;
	}
	
	/**
	 * Parse a string of {@link DoubleSolenoid} values and set them to the corresponding {@link DoubleSolenoid}
	 * @param values string of the form '[<>,<>,...]' which contains {@link DoubleSolenoid} values in order
	 * @return true if successfully parsed and values set
	 */
	private boolean parseDoubleSolenoid(String values) {
		
		//split the comma seperated vaues
		String[] states = values.split(",");
		
		//if the length of the speeds and the length of the dsolenoids is different, return false
		if(states.length != doubleSolenoids.length) {
			return false;
		}
		
		for(int i = 0; i < states.length; i++)
		{
			DoubleSolenoid s = doubleSolenoids[i];
			s.set(DoubleSolenoid.Value.valueOf(states[i]));
		}
		
		//return with no error
		return true;
	}
}
