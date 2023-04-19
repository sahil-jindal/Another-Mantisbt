package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "Features",
	    glue = "StepDefinitions",
	   tags = "@ReportIssue"
	)

public class TestRunner extends AbstractTestNGCucumberTests{

	
}
