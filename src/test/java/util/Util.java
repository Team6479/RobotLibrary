package util;

import org.junit.Assert;

public class Util {
	
	public static void fail(String message) {
		System.out.println(RED + "FAIL: " + RESET + message);
		Assert.fail(message);
	}
	public static void assertTrue(String message, boolean value) {
		try {
			Assert.assertTrue(message, value);
			System.out.println(GREEN + "PASS: " + RESET + message);
		}
		catch(AssertionError e) {
			fail(message);
		}
	}
	public static void assertNotNull(String message, Object value) {
		try {
			Assert.assertNotNull(message, value);
			System.out.println(GREEN + "PASS: " + RESET + message);
		}
		catch(AssertionError e) {
			fail(message);
		}
	}
	public static void assertEquals(String message, String value1, String value2) {
		try {
			Assert.assertEquals(message, value1, value2);
			System.out.println(GREEN + "PASS: " + RESET + message);
		}
		catch(AssertionError e) {
			fail(message);
		}
	}
	
	
	//colors
	public static final String BLACK = "\033[30m";
	public static final String RED = "\033[31m";
	public static final String GREEN = "\033[32m";
	public static final String YELLOW = "\033[33m";
	public static final String BLUE = "\033[34m";
	public static final String PURPLE = "\033[35m";
	public static final String CYAN = "\033[36m";
	public static final String WHITE = "\033[37m";
	//Reset
	public static final String RESET = "\033[0m";

}
