package robot.config.tree;

import java.util.Map;
import java.util.Map.Entry;

public class Robot {

	public Robot(Map<String, Subsystem> subsystems, Map<String, Controller> controllers) {
		this.subsystems = subsystems;
		this.controllers = controllers;
	}
	@Override
	public String toString() {
		String output = "Robot\n";
		for(Entry<String, Subsystem> entry: subsystems.entrySet()) {
			//replace all tabs with double tabs so output looks nice
			output += String.format("\t%s\n", entry.getValue().toString().replaceAll("\t", "\t\t"));
		}
		for(Entry<String, Controller> entry: controllers.entrySet()) {
			//replace all tabs with double tabs so output looks nice
			output += String.format("\t%s\n", entry.getValue().toString());
		}
		return output;
	}
	
	private Map<String, Subsystem> subsystems;
	private Map<String, Controller> controllers;

	public Map<String, Subsystem> getSubsystems() {
		return subsystems;
	}

	public void setSubsystems(Map<String, Subsystem> subsystems) {
		this.subsystems = subsystems;
	}
	public Map<String, Controller> getControllers() {
		return controllers;
	}
	public void setControllers(Map<String, Controller> controllers) {
		this.controllers = controllers;
	}

}
