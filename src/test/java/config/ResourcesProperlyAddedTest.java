package config;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ResourcesProperlyAddedTest {

	@Test
	public void shouldFindResources() {
		//try and get the files
		assertNotNull("Cannot find resource 'systems.xml'", getClass().getClassLoader().getResource("systems.xml"));
		assertNotNull("Cannot find resource 'ParsedXML'", getClass().getClassLoader().getResource("ParsedXML"));
	}

}
