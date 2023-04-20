package StepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.mantis.POM.DriverLib;
import com.mantis.POM.POMDeleteIssue;
import com.mantis.POM.POMReportIssue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteIssue {

	DriverLib driverLib = new DriverLib();
	WebDriver driver = driverLib.getWebDriver();
	POMDeleteIssue pomDeleteIssue = new POMDeleteIssue(driver);
	
	boolean status, createdIssue = false;
	String issueID;
	
	@Given("User is on now on homepage")
	public void user_is_on_now_on_homepage() {
	    status = pomDeleteIssue.checkHomePage();
	}
	
	@Given("User creates an issue for delete with values <category> <reproducibility> <severity> <priority> <summary> <description>")
	public void user_creates_an_issue_for_delete_with_values_category_reproducibility_severity_priority_summary_description(DataTable dataTable) {
		List<Map<String, String>> issueDetails = dataTable.asMaps();
		
		String category = issueDetails.get(0).get("category");
		String reproductivity = issueDetails.get(0).get("reproducibility");
		String severity = issueDetails.get(0).get("severity");
		String priority = issueDetails.get(0).get("priority");
		String summary = issueDetails.get(0).get("summary");
		String description = issueDetails.get(0).get("description");
		
		POMReportIssue reportIssue = new POMReportIssue(driver);
		
		reportIssue.goToReportIssuePage();
		issueID = reportIssue.createIssue(category, reproductivity, severity, priority, summary, description);
		createdIssue = true;
	}
	
	@When("User click on view issues button for delete")
	public void user_click_on_view_issues_button_for_delete() {
	    pomDeleteIssue.goToViewPage();
	}
	
	@When("User clicks on a issue id to delete")
	public void user_clicks_on_a_issue_id_to_delete() {
		pomDeleteIssue.clickOnIssue(issueID);
	}
	
	@Then("User should reach on a delete issue page and click on delete")
	public void user_should_reach_on_a_delete_issue_page_and_click_on_delete() {
	    pomDeleteIssue.deleteIssue(issueID);
	    createdIssue = false;
	}
	
	@Then("Issue has been deleted")
	public void issue_has_been_deleted() {
	    if(!createdIssue) {
	    	System.out.println("Issue id " + issueID + " deleted");
	    } else {
	    	System.out.println("Error occurred while deleting issue");
	    }
	}
	
	@Then("go to the view issue page")
	public void go_to_the_view_issue_page() {
	    pomDeleteIssue.goToViewPage();
	}
	
	@Then("check for issue")
	public void check_for_issue() {
	    
	}
	
	@Then("validate delete Issue on db")
	public void validate_delete_Issue_on_db() {
	    System.out.println("validate delete Issue on db");
	}
}
