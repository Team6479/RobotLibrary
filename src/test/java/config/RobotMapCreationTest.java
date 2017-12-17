package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
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
		File parsed = new File(getClass().getClassLoader().getResource("parsedJava").getFile());
		parsedStr = "";
		BufferedReader read = new BufferedReader(new FileReader(parsed));
		int next = 0;
		while((next = read.read()) != -1) {
			parsedStr += (char)next;
		}
		read.close();
	}

	@Test
	public void shouldParseRobotIntoValidJavaClass() throws Exception {
		//parse the robot
		JavaFile file = ConfigParser.generateJavaFile(robot, "test");
		StringBuilder fileAsString = new StringBuilder();
		file.writeTo(fileAsString);

		Assert.assertEquals("Java file matches expected output", parsedStr, fileAsString.toString());
	}

}
