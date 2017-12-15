package robot.config.tree;

import org.dom4j.Node;

public class Controller {

	public Controller(Node node) {
		id = node.selectSingleNode("id").getText();
		type = node.selectSingleNode("type").getText();
		port = Integer.parseInt(node.selectSingleNode("port").getText());
	}
	@Override
	public String toString() {
		return String.format("Controller: id[%s] type[%s] port[%d]", id, type, port);
	}
	
	private String id;
	private String type;
	private int port;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
}
