package com.mantis.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POMDeleteIssue {

	public By viewissuebutton = By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/a/i");
	By deleteButton = By.xpath("//input[@type='submit'][@value='Delete']");
	By confirmDeleteButton = By.xpath("//input[@type='submit'][@value='Delete Issues']");

	WebDriver driver;

	public POMDeleteIssue(WebDriver driver) {
		this.driver = driver;
	}

	public void goToViewPage() {
		driver.get("http://localhost/mantisbt/my_view_page.php");
		driver.findElement(viewissuebutton).click();
	}

	public void deleteIssue(String id) {
		try {
			driver.findElement(By.linkText(id)).click();
			driver.findElement(deleteButton).click();
			driver.findElement(confirmDeleteButton).click();
		} catch (Exception e) {
			System.out.println("enter a valid id");
		}
	}

	public boolean checkHomePage() {
		return driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/a/span")).isDisplayed();
	}
	
	public boolean clickOnIssue(String issueId) {
		try {
			driver.findElement(By.linkText(issueId)).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
