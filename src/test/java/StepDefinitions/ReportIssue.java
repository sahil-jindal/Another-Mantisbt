package StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.mantis.POM.DriverLib;
import com.mantis.POM.POMReportIssue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReportIssue {

	String issueId;
	boolean status = true, check = true;
	DriverLib driverLib = new DriverLib();
	WebDriver driver = driverLib.getWebDriver();
	POMReportIssue ri = new POMReportIssue(driver);

	@Given("user is on homepage")
	public void user_is_on_homepage() {
		status = ri.checkHomePage();
	}

	@When("user click on report issue button")
	public void user_click_on_report_issue_button() {
		if (status) {
			ri.goToReportIssuePage();
		} else {
			System.out.println("Home Page not reached");
		}
	}

	@When("user enter the issue details as {string} and {string} and {string} and {string} and {string} and {string} click on Submit issue")
	public void user_enter_the_issue_details_as_and_and_and_and_and_click_on_submit_issue(String catog, String repro, String sever, String prior, String summary, String description) {
		ri.fetchSummaryDetails(sever, catog);
		ri.goToReportIssuePage();
		
		if (status) {
			try {
				issueId = ri.createIssue(catog, repro, sever, prior, summary, description);
			} catch (Exception e) {
				System.out.println("Issue not created");
			}
		} else {
			System.out.println("Home Page not reached");
		}
	}

	@Then("go to view issue page")
	public void go_to_view_issue_page() {
		if (status) {
			ri.goToViewIssuePage();
		} else {
			System.out.println("Home Page not reached");
		}
	}

	@Then("click on issue generated")
	public void click_on_issue_generated() {
		if (status) {
			status = ri.clickOnIssue(issueId);
		} else {
			System.out.println("Home Page not reached");
		}
	}

	@Then("validate on issue page for values {string} and {string} and {string} and {string} and {string} and {string}")
	public void validate_on_issue_page_for_values(String catog, String repro, String sever, String prior, String summary, String description) {
		if (status) {
			check = ri.validateIssue(catog, repro, sever, prior, summary, description);
			if (check) {
				System.out.println("Values validated successfully");
			} else {
				System.out.println("Values doesnot match");
			}
		} else {
			System.out.println("Home Page not reached");
		}
	}

	@Then("validate on db for values {string} and {string} and {string} and {string} and {string} and {string}")
	public void validate_on_db_for_values(String catog, String repro, String sever, String prior, String summary, String description) {
		if (status) {
			check = ri.validateDBIssue(issueId, catog, repro, sever, prior, summary, description);
			if (check) {
				System.out.println("DB Values validated successfully");
			} else {
				System.out.println("DB Values doesnot match");
			}
		} else {
			System.out.println("Home Page not reached");
		}
	}

	@Then("validate on summary page {string} and {string}")
	public void validate_on_summary_page(String sever, String catog) {
		if (status) {
			check = ri.validateSummary(sever, catog);
			if (check) {
				System.out.println("Summary Values validated successfully");
			} else {
				System.out.println("Summary Values doesnot match");
			}
		} else {
			System.out.println("Home Page not reached");
		}
	}
}
