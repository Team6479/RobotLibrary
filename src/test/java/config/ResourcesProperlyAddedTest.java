package config;

import org.junit.Assert;
import org.junit.Test;

public class ResourcesProperlyAddedTest {

	@Test
	public void shouldFindResources() {
		//try and get the files
		Assert.assertNotNull("Finding resource 'systems.xml'", getClass().getClassLoader().getResource("systems.xml"));
		Assert.assertNotNull("Finding resource 'parsedXML'", getClass().getClassLoader().getResource("parsedXML"));
		Assert.assertNotNull("Finding resource 'parsedJava'", getClass().getClassLoader().getResource("parsedJava"));
	}

}
