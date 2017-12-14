package config;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ResourcesProperlyAddedTest {

	@Test
	public void shouldFindResources() {
		//try and get the files
		assertNotNull("Cannot find resource 'systems.xml'", getClass().getClassLoader().getResource("systems.xml"));
		assertNotNull("Cannot find resource 'parsedXML'", getClass().getClassLoader().getResource("parsedXML"));
		assertNotNull("Cannot find resource 'parsedJava'", getClass().getClassLoader().getResource("parsedJava"));
	}

}
