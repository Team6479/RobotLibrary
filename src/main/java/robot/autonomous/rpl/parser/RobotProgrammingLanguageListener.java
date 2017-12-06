// Generated from RobotProgrammingLanguage.g4 by ANTLR 4.7

package robot.autonomous.rpl.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RobotProgrammingLanguageParser}.
 */
public interface RobotProgrammingLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RobotProgrammingLanguageParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(RobotProgrammingLanguageParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobotProgrammingLanguageParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(RobotProgrammingLanguageParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobotProgrammingLanguageParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(RobotProgrammingLanguageParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobotProgrammingLanguageParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(RobotProgrammingLanguageParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobotProgrammingLanguageParser#multipleCommand}.
	 * @param ctx the parse tree
	 */
	void enterMultipleCommand(RobotProgrammingLanguageParser.MultipleCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobotProgrammingLanguageParser#multipleCommand}.
	 * @param ctx the parse tree
	 */
	void exitMultipleCommand(RobotProgrammingLanguageParser.MultipleCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobotProgrammingLanguageParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(RobotProgrammingLanguageParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobotProgrammingLanguageParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(RobotProgrammingLanguageParser.CommandContext ctx);
}