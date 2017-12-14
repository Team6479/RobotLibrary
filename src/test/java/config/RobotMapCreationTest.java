package config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.squareup.javapoet.JavaFile;

import robot.config.parser.ConfigParser;
import robot.config.tree.Robot;

public class RobotMapCreationTest {

	private Robot robot;
	private String parsedStr;
	
	@Before
	public void setupTest() throws IOException {
		//get xml file
		File xml = new File(getClass().getClassLoader().getResource("systems.xml").getFile());
		robot = ConfigParser.parseXML(xml);
		
		//get parsed file
		//File parsed = new File(getClass().getClassLoader().getResource("ParsedXML").getFile());
		//parsedStr = "";
		/*BufferedReader read = new BufferedReader(new FileReader(parsed));
		int next = 0;
		while((next = read.read()) != -1) {
			parsedStr += (char)next;
		}
		read.close();*/
	}
	
	@Test
	public void shouldParseRobotIntoValidJavaClass() {
		try 
		{
			//parse the robot
			JavaFile file = ConfigParser.generateJavaFile(robot, "test");
			StringBuilder fileAsString = new StringBuilder();
			file.writeTo(fileAsString);

			//assertEquals("The class does not generate as expected", parsedStr, fileAsString);
			
			System.out.println(fileAsString);
		}
		catch (IOException e) {
			fail("Could not parse as a string for testing purposes");
		}
	}

}
