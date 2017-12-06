// Generated from RobotProgrammingLanguage.g4 by ANTLR 4.7

package robot.autonomous.rpl.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RobotProgrammingLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INTEGER=1, DECIMAL=2, WORD=3, WHITESPACE=4, NEWLINE=5;
	public static final int
		RULE_file = 0, RULE_line = 1, RULE_multipleCommand = 2, RULE_command = 3;
	public static final String[] ruleNames = {
		"file", "line", "multipleCommand", "command"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INTEGER", "DECIMAL", "WORD", "WHITESPACE", "NEWLINE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "RobotProgrammingLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RobotProgrammingLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(RobotProgrammingLanguageParser.EOF, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RobotProgrammingLanguageListener ) ((RobotProgrammingLanguageListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RobotProgrammingLanguageListener ) ((RobotProgrammingLanguageListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobotProgrammingLanguageVisitor ) return ((RobotProgrammingLanguageVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(8);
				line();
				}
				}
				setState(11); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD );
			setState(13);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LineContext extends ParserRuleContext {
		public MultipleCommandContext multipleCommand() {
			return getRuleContext(MultipleCommandContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(RobotProgrammingLanguageParser.NEWLINE, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RobotProgrammingLanguageListener ) ((RobotProgrammingLanguageListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RobotProgrammingLanguageListener ) ((RobotProgrammingLanguageListener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobotProgrammingLanguageVisitor ) return ((RobotProgrammingLanguageVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			multipleCommand();
			setState(16);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultipleCommandContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(RobotProgrammingLanguageParser.INTEGER, 0); }
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public MultipleCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RobotProgrammingLanguageListener ) ((RobotProgrammingLanguageListener)listener).enterMultipleCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RobotProgrammingLanguageListener ) ((RobotProgrammingLanguageListener)listener).exitMultipleCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobotProgrammingLanguageVisitor ) return ((RobotProgrammingLanguageVisitor<? extends T>)visitor).visitMultipleCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleCommandContext multipleCommand() throws RecognitionException {
		MultipleCommandContext _localctx = new MultipleCommandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_multipleCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(18);
				command();
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD );
			setState(23);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommandContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(RobotProgrammingLanguageParser.WORD, 0); }
		public TerminalNode WHITESPACE() { return getToken(RobotProgrammingLanguageParser.WHITESPACE, 0); }
		public TerminalNode DECIMAL() { return getToken(RobotProgrammingLanguageParser.DECIMAL, 0); }
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RobotProgrammingLanguageListener ) ((RobotProgrammingLanguageListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RobotProgrammingLanguageListener ) ((RobotProgrammingLanguageListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobotProgrammingLanguageVisitor ) return ((RobotProgrammingLanguageVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_command);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(WORD);
			setState(26);
			match(WHITESPACE);
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DECIMAL) {
				{
				setState(27);
				match(DECIMAL);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\7!\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\6\2\f\n\2\r\2\16\2\r\3\2\3\2\3\3\3\3\3\3\3\4\6"+
		"\4\26\n\4\r\4\16\4\27\3\4\3\4\3\5\3\5\3\5\5\5\37\n\5\3\5\2\2\6\2\4\6\b"+
		"\2\2\2\37\2\13\3\2\2\2\4\21\3\2\2\2\6\25\3\2\2\2\b\33\3\2\2\2\n\f\5\4"+
		"\3\2\13\n\3\2\2\2\f\r\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\17\3\2\2\2"+
		"\17\20\7\2\2\3\20\3\3\2\2\2\21\22\5\6\4\2\22\23\7\7\2\2\23\5\3\2\2\2\24"+
		"\26\5\b\5\2\25\24\3\2\2\2\26\27\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30"+
		"\31\3\2\2\2\31\32\7\3\2\2\32\7\3\2\2\2\33\34\7\5\2\2\34\36\7\6\2\2\35"+
		"\37\7\4\2\2\36\35\3\2\2\2\36\37\3\2\2\2\37\t\3\2\2\2\5\r\27\36";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}