package robot.drive;

import edu.wpi.first.wpilibj.SpeedController;

/**
 * <h1>Multiple SpeedController</h1>
 * Takes care of several SpeedControllers at once
 * <p>
 * <b>NOTE:</b> This is also implemented in WPILIB as of 2018 as {@link SpeedControllerGroup}}. This class is deprecated
 * 
 * 
 * @author Jacob Abraham
 */
@Deprecated
public class MultiSpeedController implements SpeedController {

	/**
	 * All SpeedController objects to be taken care of by this class
	 */
	private SpeedController[] speedControllers;
	/**
	 * Current speed of all SpeedControllers
	 */
	private double speed;
	/**
	 * Whether or not the SpeedControllers are inverted, default is not inverted
	 */
	private boolean inverted;

	/**
	 * Convenience constructor, sets inverted to a default value of false
	 * @param speedControllers list of speed controller to be taken care of by this class
	 */
	public MultiSpeedController(SpeedController... speedControllers) {
		this.speedControllers = speedControllers;
		//defualt state
		inverted = false;
		for(SpeedController speedController: speedControllers) {
			speedController.setInverted(inverted);
		}
		set(0.0);
	}
	/**
	 * Main constructor
	 * @param inverted whether or not the speed controllers should be inverted
	 * @param speedControllers list of speed controller to be taken care of by this class
	 */
	public MultiSpeedController(boolean inverted, SpeedController... speedControllers) {
		this.speedControllers = speedControllers;
		//defualt state
		this.inverted = inverted;
		for(SpeedController speedController: speedControllers) {
			speedController.setInverted(inverted);
		}
		set(0.0);
	}
	/**
	 * Get the current speed of the speed controllers
	 * @return current speed
	 * @see SpeedController
	 */
	@Override
	public double get() {
		return speed;
	}
	/**
	 * Set the current speed of the speed controllers
	 * @param speed new speed to be set
	 * @see SpeedController
	 */
	@Override
	public void set(double speed) {
		this.speed = speed;

		for(SpeedController speedController: speedControllers) {
			speedController.set(speed);
		}
	}
	/**
	 * Set the current speed to the output of a PID controller
	 * @param output output of a PID Controller
	 * @see SpeedController
	 * @see PIDOutput
	 */
	@Override
	public void pidWrite(double output) {
		set(output);
	}
	/**
	 * Set inversion for the SpeedControllers
	 * @param isInverted whether or not the SpeedControllers should be inverted
	 * @see SpeedController
	 */
	@Override
	public void setInverted(boolean isInverted) {
		inverted = isInverted;
		for(SpeedController speedController: this.speedControllers) {
			speedController.setInverted(isInverted);
		}
	}
	/**
	 * Get whether or not the SpeedControllers are inverted
	 * @return true if inverted
	 * @see SpeedController
	 */
	@Override
	public boolean getInverted() {
		return inverted;
	}
	/**
	 * Stop all motors by setting them to 0
	 * @see SpeedController
	 */
	@Override
	public void stopMotor() {
		for(SpeedController speedController: this.speedControllers) {
			speedController.set(0.0);
		}
	}
	/**
	 * Disable all motors
	 * @see SpeedController
	 */
	@Override
	public void disable() {
		for(SpeedController speedController: this.speedControllers) {
			speedController.disable();
		}
	}
}
