package robot.config.tree;

import org.dom4j.Node;

public class Component {
	
	public Component(Node node) {
		id = node.selectSingleNode("id").getText();
	}
	@Override
	public String toString() {
		return String.format("%s: id[%s]", getClass().getSimpleName(), id);
	}
	public String getVariableName() {
		return id;
	}
	
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
