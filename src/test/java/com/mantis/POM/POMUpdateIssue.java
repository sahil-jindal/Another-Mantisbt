package com.mantis.POM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.mantisbt.jdbconn.DBConnection;

public class POMUpdateIssue {


	By ReportIssueButton = By.xpath("//*[@id=\"sidebar\"]/ul/li[3]/a/span");
	By ViewIssueButton = By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/a/span");

	By viewissuebutton = By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/a/i");
	By editButton = By.xpath("//input[@type='submit'][@value='Edit']");
	By status = By.xpath("//div[@class='table-responsive'][1]/table/tbody//tr/td[@class='bug-status']/select");
	By resolution = By.xpath("//*[@id=\"resolution\"]");
	By updateButton = By.xpath("//*[@id=\"update_bug_form\"]/div/div[3]/input");
	By newStatus = By.xpath("//*[@id=\"history\"]/div[2]/div/div/table/tbody/tr[last()-1]/td[last()]");
	By IssueStat = By.xpath("//div[@class='table-responsive'][1]/table/tbody//tr/td[@class='bug-status']");
	By IssueRes = By.xpath("//div[@class='table-responsive'][1]/table/tbody//tr/td[@class='bug-resolution']");


	WebDriver driver;
	private static Statement st = null;
	static {
		 DBConnection dbConn = new DBConnection();
		try {
			st = dbConn.getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public POMUpdateIssue(WebDriver driver) {
		this.driver = driver;
	}

	public boolean updateIssue(String stats, String reso){

		System.out.println(reso + stats);
		boolean statust = true;
		try {
		    Thread.sleep(1000);
		    System.out.println("select1");
			new Select(driver.findElement(status)).selectByVisibleText(stats);
			Thread.sleep(1000);
			System.out.println("Select2");
			new Select(driver.findElement(resolution)).selectByVisibleText(reso);
			Thread.sleep(1000);
			driver.findElement(updateButton).click();
			Thread.sleep(2000);
			if (!driver.getCurrentUrl().equals("http://localhost/mantisbt/bug_update.php")) {
				System.out.println("working");
			}

			else {
				System.out.println("enter a valid combination");
                statust = false;
			}
			System.out.println(driver.findElement(newStatus).getText());

//			System.out.println(id + " resolved");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			statust = false;
			System.out.println("enter a valid id");
			e.printStackTrace();
		}

		return statust;
	}
	
	public boolean checkHomePage() {
		return driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/a/span")).isDisplayed();
	}
	
	public void goToViewIssuePage() {
		driver.findElement(ViewIssueButton).click();
	}
	
	public boolean clickOnIssue(String issueId) {
		try {
			driver.findElement(By.linkText(issueId)).click();
			return true;
		} catch (Exception e) {

			return false;
		}

	}
	
	public boolean clickOnEditButton() {
		try {
			driver.findElement(editButton).click();
			Thread.sleep(1000);
			return true;
		} catch (Exception e) {

			return false;
		}

	}
	
	public boolean validateUpdate(String stat , String resolution) {
		
		boolean match = true;

		if (!stat.contains(driver.findElement(IssueStat).getText())) {
			match = false;
			// n=n+1;
			System.out.println("cat" + (driver.findElement(IssueStat).getText()) + stat);
		}
		if (!resolution.contains(driver.findElement(IssueRes).getText())) {
			match = false;
			System.out.println("repro" + (driver.findElement(IssueRes).getText()) + resolution);
		}
		
		return match;
	}
	
	public boolean validateUpdateDB(String id ,String stat , String resolution) {
		
		IssueVariable iv =new IssueVariable();
		boolean check = true;
		ResultSet rs;
		String query ="select * from mantis_bug_table where id="+Integer.parseInt(id);
		
		try {
			rs=st.executeQuery(query);
			
			if(rs.next()) {
				if(!(rs.getInt(9) == iv.status.get(stat)))
					check=false;
				if(!(rs.getInt(10) == iv.resolution.get(resolution)))
					check=false;
			}
			else
				check=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	    return check;	
	}
}
