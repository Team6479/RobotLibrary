package drive;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import robot.drive.Drive;
import robot.drive.MultiSpeedController;

public class DriveOutputsExpectedTest {

	@Test
	public void shouldRaiseToPower() {
		
		//testing controllers
		SpeedController controller1 = new MultiSpeedController(null, null);
		SpeedController controller2 = new MultiSpeedController(null, null);
		//drive class for testing
		Drive drive = new Drive(controller1, controller2);
		
		double input1 = 0;
		double input2 = 0;
		int scale = 1;
		String message = "With input (%f, %f) and scale factor %d, the expected value (%f, %f) did not match (%f, %f) using %s";
		
		
		//test values
		double[] values = {0, 1, -1, 0.75, -0.75, 0.5, -0.5, 0.25, -0.25, 0.125, -0.125};
		
		//go through each scale, 1 to 5
		for(scale = 1; scale <= 5; scale++) {
			//adjust the scale on drive
			drive.setScaleFactor(scale);
			//go through values twice so that every value is compared agaisnt all others and itself
			for(int i = 0; i < values.length; i++) {
				input1 = values[i];
				for(int j = 0; j < values.length; j++) {
					input2 = values[j];
					testTank(drive, input1, input2, message);
				}
			}
		}
	}
	
	public void testTank(Drive drive, double input1, double input2, String message) {
		//apply inputs to drive
		drive.tank(input1, input2);
		//get the actual value
		double actual1 = drive.getLeftSpeed();
		double actual2 = drive.getRightSpeed();
		
		//compute the value
		
		
		//assertEquals(message, expected, actual);
	}

}
