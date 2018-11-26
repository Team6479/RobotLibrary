package robot.sensors;

import edu.wpi.first.wpilibj.Ultrasonic;

/**
 * Manages two ultrasonic sensors
 * 
 * @author Jacob Abraham
 * @author Thomas Quillan
 */
public class DoubleUltrasonic {

	private Ultrasonic left;
	private Ultrasonic right;
	
	/**
	 * 
	 * ping is input
	 * echo is output
	 * 
	 * @param pingLeft left input
	 * @param echoLeft left output
	 * @param pingRight right input
	 * @param echoRight right output
	 */
	public DoubleUltrasonic(int pingLeft, int echoLeft, int pingRight, int echoRight) {
		left = new Ultrasonic(pingLeft, echoLeft);
		right = new Ultrasonic(pingRight, echoRight);
		//sets right to auto as well
		left.setAutomaticMode(true);
	}
	public double get() {
		return ((getLeftValue() + getRightValue()) / 2);
	}

	/**
	 * Get value of the left ultrasonic sensor.
	 * 
	 * @return double Value of left
	 */
	public double getLeftValue() {
		return left.getRangeInches();
	}

	/**
	 * Get value of the right ultrasonic sensor.
	 * 
	 * @return double Value of right
	 */
	public double getRightValue() {
		return right.getRangeInches();
	}

}
