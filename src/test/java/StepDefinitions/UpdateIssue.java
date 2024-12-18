package StepDefinitions;

import static org.testng.Assert.fail;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.mantis.POM.POMReportIssue;
import com.mantis.POM.POMUpdateIssue;
import com.utility.DriverLib;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateIssue {

	private DriverLib driverLib = new DriverLib();
	private WebDriver driver = driverLib.getWebDriver();
	private POMUpdateIssue ui = new POMUpdateIssue(driver);
	private POMReportIssue ri = new POMReportIssue(driver);	
	private String issueId;

	public UpdateIssue() {
		System.out.printf("-----------------------------------------------------------------------------------%n");
		System.out.printf("| %-12s |", "UPDATE ISSUE");
	}

	@Given("User is on currently on homepage")
	public void user_is_on_currently_on_homepage() {
		System.out.printf(" %-40s |","LOGIN");
		try {
			ui.checkHomePage();
			System.out.printf(" %-7s |%-12s |%n","PASS", "");
		} catch (Exception e) {
			System.out.printf(" %-7s |%-12s |%n","FAIL", "");
			fail("Exception in check home page");
		}	
	}

	@Given("User creates an issue with values {string} {string} {string} {string} {string} {string} {string}")
	public void user_creates_an_issue(String catog, String repro, String sever, String prior, String summary,
			String description, String stat) {
		System.out.printf("| %-12s | %-40s |","","FETCH SUMMARY DETAILS");
		try {
			ui.fetchSummaryDetails(sever , catog , stat);
			ri.goToReportIssuePage();
			System.out.printf(" %-7s |%-12s |%n","PASS", "");
		} catch (NoSuchElementException e) {
			System.out.printf(" %-7s |%-12s |%n","FAIL", "");
			fail("Exception in fetch summary details");
		}
		System.out.printf("| %-12s | %-40s |","","CREATE ISSUE");

		try {
			issueId = ri.createIssue(catog, repro, sever, prior, summary, description);
			System.out.printf(" %-7s |%-12s |%n","PASS", "");
		} catch (Exception e) {
			System.out.printf(" %-7s |%-12s |%n","FAIL", "");
			fail("Exception in create Issue of Update Issue");
		}
	}

	@When("User click on view issues button")
	public void click_on_view_issues_button() {
		System.out.printf("| %-12s | %-40s |","","VIEW ISSUE PAGE");

		try {
			ui.goToViewIssuePage();
			System.out.printf(" %-7s |%-12s |%n","PASS", "");
		} catch (NoSuchElementException e) {
			System.out.printf(" %-7s |%-12s |%n","FAIL", "");
			fail("Exception in View Issue page button");
		}

	}

	@Then("User clicks on a issue id")
	public void user_clicks_on_a_issue_id() {
		System.out.printf("| %-12s | %-40s |","","CLICK ON ISSUE ID");
		try {
			ui.clickOnIssue(issueId);
			System.out.printf(" %-7s |%-12s |%n","PASS", "");

		} catch (Exception e) {
			System.out.printf(" %-7s |%-12s |%n","FAIL", "");

			fail("Exception in issue generated button");
		}
	}

	@Then("User clicks on edit button")
	public void user_clicks_on_edit_button() {
		System.out.printf("| %-12s | %-40s |","","CLICK ON EDIT BUTTON");
		try {
			ui.clickOnEditButton();
			System.out.printf(" %-7s |%-12s |%n","PASS", "");
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.printf(" %-7s |%-12s |%n","FAIL", "");
			fail("Exception in Edit Button");
		}

	}

	@Then("User updates status as {string} and resolution as {string}")
	public void user_updates_status_as_and_resolution_as(String stat, String resolution) {
		
		boolean status = false;
		System.out.printf("| %-12s | %-40s |","","UPDATE ISSUE");
		try {
			status = ui.updateIssue(stat, resolution);
			if (status) {
				System.out.printf(" %-7s |%-12s |%n","PASS", "");
			} else {
				System.out.printf(" %-7s |%-12s |%n","FAIL", "");		
			}
		} catch (Exception e) {
			System.out.printf(" %-7s |%-12s |%n","FAIL", "");
			fail("Exception in update issue");
		}
			
	}

	@Then("go to view issue page for updateIssue")
	public void go_to_view_issue_page_for_update() {
		System.out.printf("| %-12s | %-40s |","","VIEW ISSUE PAGE");
		try {
			ui.goToViewIssuePage();
			System.out.printf(" %-7s |%-12s |%n","PASS", "");
		} catch (NoSuchElementException e) {
			System.out.printf(" %-7s |%-12s |%n","FAIL", "");
			fail("Exception in view issue page button");
		}
	}

	@Then("click on issue updated")
	public void click_on_issue_updated() {
		System.out.printf("| %-12s | %-40s |","","CLICK ON ISSUE UPDATED");
		try {
			ui.clickOnIssue(issueId);
			System.out.printf(" %-7s |%-12s |%n","PASS", "");
		} catch (NoSuchElementException e) {
			System.out.printf(" %-7s |%-12s |%n","FAIL", "");
			fail("Exception in issue updated button");
		}
	}

	@Then("validate update issue on issue page with {string} and {string}")
	public void validate_update_issue_on_issue_page(String stat, String resolution) {

		boolean status = false;
		System.out.printf("| %-12s | %-40s |","","VALIDATE ON ISSUE PAGE");

		try {
			status = ui.validateUpdate(stat, resolution);
			System.out.printf(" %-7s |","PASS");
		} catch (NoSuchElementException e) {
			System.out.printf(" %-7s |","FAIL");
			fail("Exception in Validate update");
		}
		if (status) {
			System.out.printf("%-12s |%n","SUCCESS");
		} else {
			System.out.printf("%-12s |%n","FAILURE");		}
	}

	@Then("validate update issue on db with {string} and {string}")
	public void validate_update_issue_on_db(String stat, String resolution) {

		boolean status = false;
		System.out.printf("| %-12s | %-40s |","","VALIDATE DATABASE");

		try {
			status = ui.validateUpdateDB(issueId, stat, resolution);
			System.out.printf(" %-7s |","PASS");
		} catch (Exception e) {
			System.out.printf(" %-7s |","FAIL");
			fail("Exception in validate DB for update issue");
		}

		if (status) {
			System.out.printf("%-12s |%n","SUCCESS");
		} else {
			System.out.printf("%-12s |%n","FAILURE");
		}
	}
	
	@Then("validate on summary page {string} and {string} and {string}")
	public void validate_on_summary_page_and_and(String sever, String catog, String stat) {
		
		boolean status = false;
		System.out.printf("| %-12s | %-40s |","","VALIDATE SUMMARY PAGE");
		
			try {
				status =  ui.validateSummary( sever , catog , stat );
				System.out.printf(" %-7s |","PASS");
			} catch (Exception e) {
				System.out.printf(" %-7s |%-12s |%n","FAIL", "FAILURE");
				e.printStackTrace();
				fail("Exception in validate Summary page for Update Issue");
			}
			if(status)
			{
				System.out.printf("%-12s |%n","SUCCESS");
			}
			else
			{
				System.out.printf("%-12s |%n","FAILURE");
			}
		}	 
	}