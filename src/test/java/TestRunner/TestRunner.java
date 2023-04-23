package TestRunner;

import org.testng.annotations.Listeners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(ListenerTest.class)
@CucumberOptions(
	features = "Features", 
	glue = "StepDefinitions",
// 	tags = "@ReportIssue or @UpdateIssue or @DeleteIssue or @OpenIssue"
// 	tags = "@ReportIssue"
// 	tags = "@UpdateIssue"
// 	tags = "@DeleteIssue"
	tags = "@OpenIssue"
)
public class TestRunner extends AbstractTestNGCucumberTests {}
