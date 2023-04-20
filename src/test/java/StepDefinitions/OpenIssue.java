package StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.mantis.POM.DriverLib;
import com.mantis.POM.POMFilterIssues;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class OpenIssue {

	boolean status = true, check = true;
	DriverLib driverLib = new DriverLib();
	WebDriver driver = driverLib.getWebDriver();
	POMFilterIssues oi = new POMFilterIssues(driver);

	@Given("user is on the home page")
	public void user_is_on_the_home_page() {
		status = oi.checkHomePage();
	}

	@Then("navigate to view issue page")
	public void navigate_to_view_issue_page() {
		if (status) {
			oi.goToViewIssuePage();
		} else {
			System.out.println("Home Page not reached");
		}

	}

	@Then("apply priority filter as {string}")
	public void apply_priority_filter_as(String prior) {
		if (status) {
			oi.applyPriorityFilter(prior);
		} else {
			System.out.println("Home Page not reached");
		}

	}

	@Then("apply severity filter as {string}")
	public void apply_severity_filter_as(String sever) {
		if (status) {
			oi.applySeverittyFilter(sever);
		} else {
			System.out.println("Home Page not reached");
		}

	}

	@Then("apply reporter filter as {string}")
	public void apply_reporter_filter_as(String stat) {
		if (status) {
			oi.applyStatusFilter(stat);
		} else {
			System.out.println("Home Page not reached");
		}
	}

	@Then("validate all filters with values {string} {string} {string}")
	public void validate_all_filters(String prior, String sever, String stat) {
		if (status) {
			check = oi.validateFilter(prior, sever, stat);
			
			if (check) {
				System.out.println("Filter Values validated successfully");
			} else {
				System.out.println("Filter Values doesnot match");
			}

		} else {
			System.out.println("Home Page not reached");
		}
	}
}
