package robot.config.tree;

import org.dom4j.Node;

public class Motor extends Component {
	
	public Motor(Node node) {
		super(node);
		type = node.selectSingleNode("type").getText();
		port = Integer.parseInt(node.selectSingleNode("port").getText());
	}
	@Override
	public String toString() {
		return String.format("%s type[%s] port[%d]", super.toString(), type, port);
	}
	
	private String type;
	private int port;
	
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
