package xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import static org.junit.Assert.*;

import robot.config.parser.ConfigParser;
import robot.config.tree.Robot;

//test the parsing of the xml file
public class XMLParserTest {

	@Test
	public void shouldParseXMLIntoValidRobotConfig() {
		try 
		{
			//get xml file
			File xml = new File(getClass().getClassLoader().getResource("systems.xml").getFile());
			//parse the xml
			Robot robot = ConfigParser.parseXML(xml);
			String robotStr = robot.toString();

			//if returns no Robot, failure
			assertNotNull("Robot config cannot be null", robot);

			//get parsed file
			File parsed = new File(getClass().getClassLoader().getResource("ParsedXML").getFile());
			String parsedStr = "";
			BufferedReader read = new BufferedReader(new FileReader(parsed));
			int next = 0;
			while((next = read.read()) != -1) {
				parsedStr += (char)next;
			}
			read.close();

			assertEquals("", parsedStr, robotStr);
		}
		catch (IOException e) {
			fail("Error reading file");
		}
		catch (NullPointerException e) {
			fail("Error parsing xml");
		}
	}
}
