package robot.drive;

import edu.wpi.first.wpilibj.SpeedController;


//driving class, has different driving configurations
public class Drive {
	
	private SpeedController left;
	private SpeedController right;
	//scale factor, inputs exponented by a factor to imporve slow speed control, default is 1
	private int scaleFactor;

	public Drive(SpeedController left, SpeedController right) {
		this.left = left;
		this.right = right;
		scaleFactor = 1;
	}
	
	public void setScaleFactor(int scaleFactor) {
		this.scaleFactor = scaleFactor;
	}

	//tank drive
	public void tank(double leftValue, double rightValue) {
		double adjustedLeft = adjustValue(leftValue);
		double adjustedRight = adjustValue(rightValue);
		left.set(adjustedLeft);
		right.set(adjustedRight);
	}
	//half tank drive for fine motor control
	public void halfTank(double leftValue, double rightValue) {
		tank(leftValue / 2, rightValue / 2);
	}
	
	//arcade drive
	public void arcade(double throttle, double turn) {
		tank(throttle - turn, throttle + turn);
	}
	//half arcade drive for fine motor control
	public void halfArcade(double throttle, double turn) {
		arcade(throttle / 2, turn / 2);
	}
	
	//apply the scale factor to a value while keeping the sign
	private double adjustValue(double value) {
		//take the value to the power defined by scaleFactor
		//use copy sign to keep the sign of the value
		double newValue = Math.copySign(Math.pow(value, scaleFactor), value);
		return newValue;
	}
	
	public double getLeftSpeed() {
		return left.get();
	}
	public double getRightSpeed() {
		return right.get();
	}
	public int getScaleFactor() {
		return scaleFactor;
	}
}
