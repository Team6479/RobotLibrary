package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import robot.config.parser.ConfigParser;
import robot.config.tree.Robot;

//test the parsing of the xml file
public class XMLParserTest {

	private File xml;
	private String parsedStr;

	@Before
	public void setupTest() throws IOException {
		//get xml file
		xml = new File(getClass().getClassLoader().getResource("systems.xml").getFile());

		//get parsed file
		File parsed = new File(getClass().getClassLoader().getResource("parsedXML").getFile());
		parsedStr = "";
		BufferedReader read = new BufferedReader(new FileReader(parsed));
		int next = 0;
		while((next = read.read()) != -1) {
			parsedStr += (char)next;
		}
		read.close();
	}

	@Test
	public void shouldParseXMLIntoValidRobotConfig() {
		//parse the xml
		Robot robot = ConfigParser.parseXML(xml);
		String robotStr = robot.toString();

		//if returns no Robot, failure
		Assert.assertNotNull("Valid robot object returned", robot);

		Assert.assertEquals("The expected xml parsing matches the actual parsing", parsedStr, robotStr);
	}
}
