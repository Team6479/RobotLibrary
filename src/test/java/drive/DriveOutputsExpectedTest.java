package drive;

import org.junit.Assert;
import org.junit.Test;

import edu.wpi.first.wpilibj.SpeedController;
import robot.drive.Drive;

public class DriveOutputsExpectedTest {

	@Test
	public void shouldRaiseToPower() {
		
		//testing controllers
		SpeedController controller1 = new FakeSpeedController();
		SpeedController controller2 = new FakeSpeedController();
		//drive class for testing
		Drive drive = new Drive(controller1, controller2);
		
		double input1 = 0;
		double input2 = 0;
		int scale = 1;
		String message = "With input (%f, %f) and scale factor %d, the expected value was (%f, %f) and the actual value was (%f, %f) using ";
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
					testTank(drive, input1, input2, message + "Tank Drive");
					testHalfTank(drive, input1, input2, message + "Half Tank Drive");
					testArcade(drive, input1, input2, message + "Arcade Drive");
				}
			}
		}
	}
	
	public void testTank(Drive drive, double input1, double input2, String message) {
		//apply inputs to drive
		drive.tank(input1, input2);
		
		//get the scale factor
		int scale = drive.getScaleFactor();
		
		//get the actual value
		double actual1 = drive.getLeftSpeed();
		double actual2 = drive.getRightSpeed();
		
		//compute the value
		double expected1 = input1;
		double expected2 = input2;
		
		//if scale is even, need to store sign
		//if scale is odd, no need to store sign, will not be erased by odd power exponent
		//NOTE: this is using bitwise operations to determin if even or odd, if 0, the number is even
		//DO NOT use scale%2 to dtermine if even, this is slow
		if((scale & 1) == 1) {
			//odd
			expected1 = Math.pow(expected1, scale);
			expected2 = Math.pow(expected2, scale);
		}
		else {
			//even
			//get the sign
			int sign1 = (int)Math.signum(expected1);
			int sign2 = (int)Math.signum(expected2);
			//apply sign 
			expected1 = Math.pow(expected1, scale) * sign1;
			expected2 = Math.pow(expected2, scale) * sign2;
		}
		
		//value to compare diff to
		double epsilon = 0.0001;
		//if vales are equal, pass
		boolean areEqual = (Math.abs(expected1 - actual1) <= epsilon && Math.abs(expected2 - actual2) <= epsilon);
		
		String desc = String.format(message, input1, input2, scale, expected1, expected2, actual1, actual2);
		
		Assert.assertTrue(desc, areEqual);
	}
	public void testHalfTank(Drive drive, double input1, double input2, String message) {
		//apply inputs to drive
		drive.halfTank(input1, input2);
		
		//test the tank drive with half values
		testTank(drive, input1 / 2, input2 / 2, message);
	}
	public void testArcade(Drive drive, double input1, double input2, String message) {
		//apply inputs to drive
		drive.arcade(input1, input2);
		
		//apply the arcade shift to the test tank method
		testTank(drive, input1 - input2, input1 + input2, message);
	}
	public void testHalfArcade(Drive drive, double input1, double input2, String message) {
		//apply inputs to drive
		drive.arcade(input1, input2);
		
		//test the aracde drive with half values
		testArcade(drive, input1 / 2, input2 / 2, message);
	}

}
