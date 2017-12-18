package robot.config.tree;

import java.util.List;

public class Robot {

	public Robot(List<Subsystem> subsystems, List<Controller> controllers) {
		this.subsystems = subsystems;
		this.controllers = controllers;
	}
	@Override
	public String toString() {
		String output = "Robot\n";
		for(Subsystem sub: subsystems) {
			//replace all tabs with double tabs so output looks nice
			output += String.format("\t%s\n", sub.toString().replaceAll("\t", "\t\t"));
		}
		for(Controller con: controllers) {
			//replace all tabs with double tabs so output looks nice
			output += String.format("\t%s\n", con.toString());
		}
		return output;
	}
	
	private List<Subsystem> subsystems;
	private List<Controller> controllers;

	public List<Subsystem> getSubsystems() {
		return subsystems;
	}

	public void setSubsystems(List<Subsystem> subsystems) {
		this.subsystems = subsystems;
	}
	public List<Controller> getControllers() {
		return controllers;
	}
	public void setControllers(List<Controller> controllers) {
		this.controllers = controllers;
	}

}
