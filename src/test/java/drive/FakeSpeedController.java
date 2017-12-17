package drive;

import edu.wpi.first.wpilibj.SpeedController;

//this is a class simply to look like a speed controller, it fucntions like a speed controller, but it doesn not control anything
//for testing purposed only
public class FakeSpeedController implements SpeedController {

	//keep track of speed
	private double speed;
	private boolean inverted;
	public FakeSpeedController() {
		speed = 0;
		inverted = false;
	}

	@Override
	public void set(double speed) {
		this.speed = speed;
		
	}
	@Override
	public double get() {
		return speed;
	}
	@Override
	public void setInverted(boolean isInverted) {
		inverted = isInverted;
	}
	@Override
	public boolean getInverted() {
		return inverted;
	}
	@Override
	public void disable() {
		speed = 0;
		
	}
	@Override
	public void stopMotor() {
		speed = 0;
	}
	
	
	
	
	//unnescary methods
	@Override
	public void pidWrite(double output) {}

}
