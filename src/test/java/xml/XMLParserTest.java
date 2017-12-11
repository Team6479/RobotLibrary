package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

//test the parsing of the xml file
public class XMLParserTest {
	public static void main(String[] args) {
		XMLParserTest test = new XMLParserTest();
	}
	public XMLParserTest() {
        try 
        {
        		//read the xml
    			SAXReader reader = new SAXReader();
    			File file = new File(getClass().getClassLoader().getResource("systems.xml").getFile());
			Document document = reader.read(file);
			
			
			//get all subsystems
			List<Node> subsystemNodes = document.selectNodes("/robot/subsystem");
			List<Subsystem> subsystems = new ArrayList<Subsystem>();
			for(Node node: subsystemNodes) {
				Subsystem sub = new Subsystem(node);
				subsystems.add(sub);
				System.out.printf("%s\n\n", sub);
			}
			
			
			
			
			//get all actions
			List<Node> actionNodes = document.selectNodes("/robot/actions/action");
			

		}
		catch(DocumentException e)
        {
			e.printStackTrace();
		}
	}
	
	class Action {
		String id;
		List<String> actions;
		Action(Node node) {
			id = node.selectSingleNode("id").getText();
			List<Node> actionNodes = node.selectNodes("use");
			for(Node actionNode: actionNodes) {
				actions.add(actionNode.getText());
			}
		}
	}
	
	
	//components
	class Component {
		String id;
		Component(Node node) {
			id = node.selectSingleNode("id").getText();
		}
		@Override
		public String toString() {
			return String.format("%s: id[%s]", getClass().getSimpleName(), id);
		}
		
		//all actions for this subsystem
		//actionName, action
		Map<String, Component> components;
	}
	class Motor extends Component {
		String type;
		int port;
		Motor(Node node) {
			super(node);
			type = node.selectSingleNode("type").getText();
			port = Integer.parseInt(node.selectSingleNode("port").getText());
		}
		@Override
		public String toString() {
			return String.format("%s type[%s] port[%d]", super.toString(), type, port);
		}
	}
	class Solenoid extends Component {
		int port;
		Solenoid(Node node) {
			super(node);
			port = Integer.parseInt(node.selectSingleNode("port").getText());
		}
		@Override
		public String toString() {
			return String.format("%s port[%d]", super.toString(), port);
		}
	}
	class DoubleSolenoid extends Component {
		int portOn;
		int portOff;
		DoubleSolenoid(Node node) {
			super(node);
			portOn = Integer.parseInt(node.selectSingleNode("portOn").getText());
			portOff = Integer.parseInt(node.selectSingleNode("portOff").getText());
		}
		@Override
		public String toString() {
			return String.format("%s portOn[%d] portOff[%d]", super.toString(), portOn, portOff);
		}
	}
	
	
	class Subsystem {
		String id;
		//map of all components, using id of component as key
		Map<String, Component> components;
		
		Subsystem(Node node) {
			
			id = node.selectSingleNode("id").getText();
			
			Node componentNodes = node.selectSingleNode("components");
			
			//get all motors of the subsystem
			List<Node> motorNodes = componentNodes.selectNodes("motor");
			//get all dsols of the subsystem
			List<Node> dsolNodes = componentNodes.selectNodes("double_solenoid");
			//get all dols of the subsystem
			List<Node> solNodes = componentNodes.selectNodes("solenoid");
			
			components = new HashMap<String, Component>();
			
			for(Node n: motorNodes) {
				Motor motor = new Motor(n);
				components.put(motor.id, motor);
			}
			for(Node n: dsolNodes) {
				DoubleSolenoid dsol = new DoubleSolenoid(n);
				components.put(dsol.id, dsol);
			}
			for(Node n: solNodes) {
				Solenoid sol = new Solenoid(n);
				components.put(sol.id, sol);
			}
			
		}
		@Override
		public String toString() {
			String output = String.format("Subsystem: name[%s]", id);
			for(Entry<String, Component> entry : components.entrySet()) {
				output += String.format("\n%s", entry.getValue().toString());
			}
			return output;
		}
		
	}
}
