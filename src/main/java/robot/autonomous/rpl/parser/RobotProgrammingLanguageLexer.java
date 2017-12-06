// Generated from RobotProgrammingLanguage.g4 by ANTLR 4.7

package robot.autonomous.rpl.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RobotProgrammingLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INTEGER=1, DECIMAL=2, WORD=3, WHITESPACE=4, NEWLINE=5;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"UPPER", "LOWER", "NUMBER", "INTEGER", "DECIMAL", "WORD", "WHITESPACE", 
		"NEWLINE"
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


	public RobotProgrammingLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RobotProgrammingLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\79\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\5\6\5\33\n\5\r\5\16\5\34\3\6\7\6 \n\6\f\6\16\6#\13\6\3\6\3"+
		"\6\6\6\'\n\6\r\6\16\6(\3\7\3\7\6\7-\n\7\r\7\16\7.\3\b\3\b\3\t\5\t\64\n"+
		"\t\3\t\3\t\5\t8\n\t\2\2\n\3\2\5\2\7\2\t\3\13\4\r\5\17\6\21\7\3\2\6\3\2"+
		"C\\\3\2c|\3\2\62;\4\2\13\13\"\"\2<\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2\2\5\25\3\2\2\2\7\27\3\2\2\2\t"+
		"\32\3\2\2\2\13!\3\2\2\2\r,\3\2\2\2\17\60\3\2\2\2\21\67\3\2\2\2\23\24\t"+
		"\2\2\2\24\4\3\2\2\2\25\26\t\3\2\2\26\6\3\2\2\2\27\30\t\4\2\2\30\b\3\2"+
		"\2\2\31\33\5\7\4\2\32\31\3\2\2\2\33\34\3\2\2\2\34\32\3\2\2\2\34\35\3\2"+
		"\2\2\35\n\3\2\2\2\36 \5\7\4\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3"+
		"\2\2\2\"$\3\2\2\2#!\3\2\2\2$&\7\60\2\2%\'\5\7\4\2&%\3\2\2\2\'(\3\2\2\2"+
		"(&\3\2\2\2()\3\2\2\2)\f\3\2\2\2*-\5\3\2\2+-\5\5\3\2,*\3\2\2\2,+\3\2\2"+
		"\2-.\3\2\2\2.,\3\2\2\2./\3\2\2\2/\16\3\2\2\2\60\61\t\5\2\2\61\20\3\2\2"+
		"\2\62\64\7\17\2\2\63\62\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\658\7\f\2"+
		"\2\668\7\17\2\2\67\63\3\2\2\2\67\66\3\2\2\28\22\3\2\2\2\n\2\34!(,.\63"+
		"\67\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}