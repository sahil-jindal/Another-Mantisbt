package StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.mantis.POM.DriverLib;
import com.mantis.POM.POMReportIssue;
import com.mantis.POM.POMUpdateIssue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateIssue {

	String issueId;
	boolean status = true, check = true;
	DriverLib driverLib = new DriverLib();
	WebDriver driver = driverLib.getWebDriver();
	POMUpdateIssue ui = new POMUpdateIssue(driver);
	POMReportIssue ri = new POMReportIssue(driver);

	@Given("User is on currently on homepage")
	public void user_is_on_currently_on_homepage() {
		status = ui.checkHomePage();
	}

	@Given("User creates an issue with values {string} {string} {string} {string} {string} {string} {string}")
	public void user_creates_an_issue(String catog, String repro, String sever, String prior, String summary, String description, String stat) {
		ui.fetchSummaryDetails(sever, catog, stat);
		ri.goToReportIssuePage();
		try {
			issueId = ri.createIssue(catog, repro, sever, prior, summary, description);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User click on view issues button")
	public void click_on_view_issues_button() {
		if (status) {
			ui.goToViewIssuePage();
		} else {
			System.out.println("Home Page not reached");
		}
	}

	@Then("User clicks on a issue id")
	public void user_clicks_on_a_issue_id() {
		if (status) {
			status = ui.clickOnIssue(issueId);
		} else {
			System.out.println("Home Page not reached");
		}
	}

	@Then("User clicks on edit button")
	public void user_clicks_on_edit_button() {
		if (status) {
			status = ui.clickOnEditButton();
		} else {
			System.out.println("Home Page not reached");
		}
	}

	@Then("User updates status as {string} and resolution as {string}")
	public void user_updates_status_as_and_resolution_as(String stat, String resolution) {
		if (status) {
			status = ui.updateIssue(stat, resolution);
		} else {
			System.out.println("Home Page not reached");
		}
	}

	@Then("go to view issue page for updateIssue")
	public void go_to_view_issue_page_for_update() {
		if (status) {
			ui.goToViewIssuePage();
		} else {
			System.out.println("Home Page not reached");
		}
	}

	@Then("click on issue updated")
	public void click_on_issue_updated() {
		if (status) {
			status = ui.clickOnIssue(issueId);
		} else {
			System.out.println("Home Page not reached");
		}
	}

	@Then("validate update issue on issue page with {string} and {string}")
	public void validate_update_issue_on_issue_page(String stat, String resolution) {
		if (status) {
			check = ui.validateUpdate(stat, resolution);
			if (check) {
				System.out.println("Values validated successfully");
			} else {
				System.out.println("Values doesnot match");
			}
		} else {
			System.out.println("Home Page not reached");
		}
	}

	@Then("validate update issue on db with {string} and {string}")
	public void validate_update_issue_on_db(String stat, String resolution) {
		if (status) {
			check = ui.validateUpdateDB(issueId, stat, resolution);
			if (check) {
				System.out.println("DB Values validated successfully");
			} else {
				System.out.println("DB Values doesnot match");
			}
		} else {
			System.out.println("Home Page not reached");
		}
	}

	@Then("validate on summary page {string} and {string} and {string}")
	public void validate_on_summary_page_and_and(String sever, String catog, String stat) {
		if (status) {
			check = ui.validateSummary(sever, catog, stat);
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
