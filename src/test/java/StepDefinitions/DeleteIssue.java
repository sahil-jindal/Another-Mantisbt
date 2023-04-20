package StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.mantis.POM.DriverLib;
import com.mantis.POM.POMDeleteIssue;

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
	
	@When("User click on view issues button for delete")
	public void user_click_on_view_issues_button_for_delete() {
	    deleteIssue.goToViewPage();
	}
	
	@When("User clicks on a issue id  {string} and click on delete button")
	public void user_clicks_on_a_issue_id_and_click_on_delete_button(String IssueID) {
	    deleteIssue.deleteIssue(IssueID);
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
