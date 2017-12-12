package robot.config.parser;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import robot.config.tree.Robot;
import robot.config.tree.Subsystem;

public class ConfigParser {
	
	//static method to parse and return a robot object
	public static Robot parseXML(File xml) {
		try 
        {	
        		//read the xml
    			SAXReader reader = new SAXReader();
			Document document = reader.read(xml);
			
			//get all subsystems
			List<Node> subsystemNodes = document.selectNodes("/robot/subsystem");
			Map<String, Subsystem> subsystems = new HashMap<String, Subsystem>();
			for(Node node: subsystemNodes) {
				Subsystem sub = new Subsystem(node);
				subsystems.put(sub.getId(), sub);
			}
			//make a robot
			Robot robot = new Robot(subsystems);
			return robot;

		}
		catch(DocumentException e)
        {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
