package robot.config.tree;

import org.dom4j.Node;

public class Solenoid extends Component {

	public Solenoid(Node node) {
		super(node);
		port = Integer.parseInt(node.selectSingleNode("port").getText());
	}
	@Override
	public String toString() {
		return String.format("%s port[%d]", super.toString(), port);
	}
	@Override
	public String getVariableName() {
		return getId();
	}
	
	private int port;
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
}
