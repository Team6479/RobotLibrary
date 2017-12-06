// Generated from RobotProgrammingLanguage.g4 by ANTLR 4.7

package robot.autonomous.rpl.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RobotProgrammingLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RobotProgrammingLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RobotProgrammingLanguageParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(RobotProgrammingLanguageParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobotProgrammingLanguageParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(RobotProgrammingLanguageParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobotProgrammingLanguageParser#multipleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleCommand(RobotProgrammingLanguageParser.MultipleCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobotProgrammingLanguageParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(RobotProgrammingLanguageParser.CommandContext ctx);
}