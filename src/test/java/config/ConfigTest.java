package config;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//test suite for this package
@RunWith(Suite.class)
@SuiteClasses({
        ResourcesProperlyAddedTest.class,
        XMLParserTest.class,
        RobotMapCreationTest.class })
public class ConfigTest {
}
