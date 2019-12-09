package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.hp.lft.sdk.*;

import unittesting.*;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "com.hp.lft.cucumberv4.CucumberReporter" }, 
	glue = "step", features = "classpath:features")
public class LeanFtTest extends UnitTestClassBase {

	public LeanFtTest() {

	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = new LeanFtTest();
		globalSetup(LeanFtTest.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		globalTearDown();
	}

	@Test
	public void test() throws GeneralLeanFtException {
	}
}