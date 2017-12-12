package robot.autonomous.rpl.listener;


import rpl.RobotProgrammingLanguageBaseListener;
import rpl.RobotProgrammingLanguageParser;

//implents listener from anltr to acces the tree
public class RPLListener extends RobotProgrammingLanguageBaseListener {
	
	
	public RPLListener() {
		
	}
	
	//get each command line
	@Override 
	public void exitMultipleCommand(RobotProgrammingLanguageParser.MultipleCommandContext ctx) {
		
		
		//get the time
		
		
	}
}
