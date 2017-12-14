package robot.config.tree;

import org.dom4j.Node;

public class DoubleSolenoid extends Component {
	
	public DoubleSolenoid(Node node) {
		super(node);
		portOn = Integer.parseInt(node.selectSingleNode("portOn").getText());
		portOff = Integer.parseInt(node.selectSingleNode("portOff").getText());
	}
	@Override
	public String toString() {
		return String.format("%s portOn[%d] portOff[%d]", super.toString(), portOn, portOff);
	}
	@Override
	public String getVariableName() {
		return getId();
	}
	
	private int portOn;
	private int portOff;
	
	public int getPortOn() {
		return portOn;
	}
	public void setPortOn(int portOn) {
		this.portOn = portOn;
	}
	public int getPortOff() {
		return portOff;
	}
	public void setPortOff(int portOff) {
		this.portOff = portOff;
	}
}