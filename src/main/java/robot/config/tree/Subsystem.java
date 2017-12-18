package robot.config.tree;

import java.util.ArrayList;
import java.util.List;

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
		//get all encoders of the subsystem
		List<Node> encNodes = componentNodes.selectNodes("encoder");
		
		components = new ArrayList<Component>();
		
		for(Node n: motorNodes) {
			Motor motor = new Motor(n);
			components.add(motor);
		}
		for(Node n: dsolNodes) {
			DoubleSolenoid dsol = new DoubleSolenoid(n);
			components.add(dsol);
		}
		for(Node n: solNodes) {
			Solenoid sol = new Solenoid(n);
			components.add(sol);
		}
		for(Node n: encNodes) {
			Encoder enc = new Encoder(n);
			components.add(enc);
		}
	}
	@Override
	public String toString() {
		String output = String.format("Subsystem: name[%s]", id);
		for(Component comp : components) {
			output += String.format("\n\t%s", comp.toString());
		}
		return output;
	}
	
	private String id;
	//map of all components, using id of component as key
	private List<Component> components;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Component> getComponents() {
		return components;
	}
	public void setComponents(List<Component> components) {
		this.components = components;
	}
}