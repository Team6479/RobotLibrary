package robot.autonomous.rpl.listener;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import rpl.*;
import rpl.RobotProgrammingLanguageParser.CommandContext;
import rpl.RobotProgrammingLanguageParser.FileContext;
import rpl.RobotProgrammingLanguageParser.LineContext;
import rpl.RobotProgrammingLanguageParser.MultipleCommandContext;

//implents listener from anltr to acces the tree
public class RPLListener implements RobotProgrammingLanguageListener {

	public void enterEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void exitEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void visitErrorNode(ErrorNode arg0) {
		// TODO Auto-generated method stub
		
	}

	public void visitTerminal(TerminalNode arg0) {
		// TODO Auto-generated method stub
		
	}

	public void enterFile(FileContext ctx) {
		// TODO Auto-generated method stub
		
	}

	public void exitFile(FileContext ctx) {
		// TODO Auto-generated method stub
		
	}

	public void enterLine(LineContext ctx) {
		// TODO Auto-generated method stub
		
	}

	public void exitLine(LineContext ctx) {
		// TODO Auto-generated method stub
		
	}

	public void enterMultipleCommand(MultipleCommandContext ctx) {
		// TODO Auto-generated method stub
		
	}

	public void exitMultipleCommand(MultipleCommandContext ctx) {
		// TODO Auto-generated method stub
		
	}

	public void enterCommand(CommandContext ctx) {
		// TODO Auto-generated method stub
		
	}

	public void exitCommand(CommandContext ctx) {
		// TODO Auto-generated method stub
		
	}
	

}
