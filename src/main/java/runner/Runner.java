package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue = "step", 
		features = "classpath:features",
		tags = "@C001_T003"
		)
public class Runner {
}