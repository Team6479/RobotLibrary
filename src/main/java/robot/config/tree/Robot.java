package robot.config.tree;

import java.util.Map;
import java.util.Map.Entry;

public class Robot {

	public Robot(Map<String, Subsystem> subsystems) {
		this.subsystems = subsystems;
	}
	@Override
	public String toString() {
		String output = "Robot\n";
		for(Entry<String, Subsystem> entry: subsystems.entrySet()) {
			//replace all tabs with double tabs so output looks nice
			output += String.format("\t%s\n", entry.getValue().toString().replaceAll("\t", "\t\t"));
		}
		return output;
	}
	
	private Map<String, Subsystem> subsystems;

	public Map<String, Subsystem> getSubsystems() {
		return subsystems;
	}

	public void setSubsystems(Map<String, Subsystem> subsystems) {
		this.subsystems = subsystems;
	}

}
