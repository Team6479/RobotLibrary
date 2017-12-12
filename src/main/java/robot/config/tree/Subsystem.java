package robot.config.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Node;

public class Subsystem {
	
	public Subsystem(Node node) {
		
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
			components.put(motor.getId(), motor);
		}
		for(Node n: dsolNodes) {
			DoubleSolenoid dsol = new DoubleSolenoid(n);
			components.put(dsol.getId(), dsol);
		}
		for(Node n: solNodes) {
			Solenoid sol = new Solenoid(n);
			components.put(sol.getId(), sol);
		}
	}
	@Override
	public String toString() {
		String output = String.format("Subsystem: name[%s]", id);
		for(Entry<String, Component> entry : components.entrySet()) {
			output += String.format("\n\t%s", entry.getValue().toString());
		}
		return output;
	}
	
	private String id;
	//map of all components, using id of component as key
	private Map<String, Component> components;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Map<String, Component> getComponents() {
		return components;
	}
	public void setComponents(Map<String, Component> components) {
		this.components = components;
	}
}