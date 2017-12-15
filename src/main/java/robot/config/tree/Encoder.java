package robot.config.tree;

import org.dom4j.Node;

public class Encoder extends Component {
	
	public Encoder(Node node) {
		super(node);
		channelA = Integer.parseInt(node.selectSingleNode("channelA").getText());
		channelB = Integer.parseInt(node.selectSingleNode("channelB").getText());
	}
	@Override
	public String toString() {
		return String.format("%s channelA[%d] channelB[%d]", super.toString(), channelA, channelB);
	}
	@Override
	public String getVariableName() {
		return getId();
	}
	
	private int channelA;
	private int channelB;
	
	public int getChannelA() {
		return channelA;
	}
	public void setChannelA(int channelA) {
		this.channelA = channelA;
	}
	public int getChannelB() {
		return channelB;
	}
	public void setChannelB(int channelB) {
		this.channelB = channelB;
	}
	
}

