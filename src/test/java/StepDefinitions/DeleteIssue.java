package StepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.mantis.POM.DriverLib;
import com.mantis.POM.POMDeleteIssue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteIssue {

	DriverLib driverLib = new DriverLib();
	WebDriver driver = driverLib.getWebDriver();
	POMDeleteIssue deleteIssue = new POMDeleteIssue(driver);
	
	boolean status = true, check = true;
	
	@Given("User is on now on homepage")
	public void user_is_on_now_on_homepage() {
	    status = deleteIssue.checkHomePage();
	}
	
	@Given("User creates an issue for delete with values <category> <reproducibility> <severity> <priority> <summary> <description>")
	public void user_creates_an_issue_for_delete_with_values_category_reproducibility_severity_priority_summary_description(DataTable dataTable) {
		List<Map<String, String>> issueDetails = dataTable.asMaps();
		
		String category = issueDetails.get(0).get("category");
		String reproductivity = issueDetails.get(0).get("reproductivity");
		String severity = issueDetails.get(0).get("severity");
		String priority = issueDetails.get(0).get("priority");
		String summary = issueDetails.get(0).get("summary");
		String description = issueDetails.get(0).get("description");
		
		
		System.out.println(category);
	}
	
	@When("User click on view issues button for delete")
	public void user_click_on_view_issues_button_for_delete() {
	    deleteIssue.goToViewPage();
	}
	
	@When("User clicks on a issue id to delete")
	public void user_clicks_on_a_issue_id_to_delete() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("User should reach on a delete issue page and click on delete")
	public void user_should_reach_on_a_delete_issue_page_and_click_on_delete() {
	    System.out.println("User should reach on a delete issue page and click on delete");
	}
	
	@Then("Issue has been deleted")
	public void issue_has_been_deleted() {
	    System.out.println("Issue has been deleted");
	}
	
	@Then("go to the view issue page")
	public void go_to_the_view_issue_page() {
	    System.out.println("go to the view issue page");
	}
	
	@Then("check for issue")
	public void check_for_issue() {
	    System.out.println("check for issue");
	}
	
	@Then("validate delete Issue on db")
	public void validate_delete_Issue_on_db() {
	    System.out.println("validate delete Issue on db");
	}
}
