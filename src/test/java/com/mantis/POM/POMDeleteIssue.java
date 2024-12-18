package com.mantis.POM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.utility.DBConnection;

public class POMDeleteIssue {

	By del = By.xpath("//input[@type='submit'][@value='Delete']");
	By deletebutton = By.xpath("//input[@type='submit'][@value='Delete Issues']");
	By ViewIssueButton = By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/a/span");
	By ReportIssueButton = By.xpath("//*[@id=\"sidebar\"]/ul/li[3]/a/span");

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

	public POMDeleteIssue(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkHomePage() throws NoSuchElementException {
		return driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/a/span")).isDisplayed();
	}

	public void goToReportIssuePage() throws NoSuchElementException {
		driver.findElement(ReportIssueButton).click();
	}

	public void goToViewIssuePage() throws NoSuchElementException {
		driver.findElement(ViewIssueButton).click();
	}

	public void clickOnIssueId(String id) throws Exception {
		driver.findElement(By.linkText(id)).click();
	}

	public void clickOnDeleteButton() throws NoSuchElementException {
		driver.findElement(del).click();
		driver.findElement(deletebutton).click();
	}

	public boolean validateDelete(String id) throws Exception {
		boolean status = false;

		try {
			driver.findElement(By.linkText(id)).click();

		} catch (Exception e) {
			status = true;
			return status;
		}

		return status;
	}

	public boolean validateDeleteDB(String id) {

		boolean status = false;

		ResultSet rs;
		String query = "select * from mantis_bug_table where id=" + Integer.parseInt(id);

		try {
			rs = st.executeQuery(query);
			if (!rs.next())
				status = true;

		} catch (SQLException e) {
			status = true;
			return status;
		}
		return status;
	}
}
