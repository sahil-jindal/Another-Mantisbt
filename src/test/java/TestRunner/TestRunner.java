package TestRunner;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(ListenerTest.class)
@CucumberOptions(
	features = "Features",
	glue = "StepDefinitions"
)
public class TestRunner extends AbstractTestNGCucumberTests {}
