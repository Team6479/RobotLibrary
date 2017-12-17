package config;

import org.junit.Test;

import util.Util;

public class ResourcesProperlyAddedTest {

	@Test
	public void shouldFindResources() {
		//try and get the files
		Util.assertNotNull("Finding resource 'systems.xml'", getClass().getClassLoader().getResource("systems.xml"));
		Util.assertNotNull("Finding resource 'parsedXML'", getClass().getClassLoader().getResource("parsedXML"));
		Util.assertNotNull("Finding resource 'parsedJava'", getClass().getClassLoader().getResource("parsedJava"));
	}

}
