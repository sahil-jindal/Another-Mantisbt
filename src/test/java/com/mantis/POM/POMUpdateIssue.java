package com.mantis.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class POMUpdateIssue {

	WebDriver driver;

	By viewissuebutton = By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/a/i");
	By editButton = By.xpath("//input[@type='submit'][@value='Edit']");
	By status = By.xpath("//*[@id=\"status\"]");
	By resolution = By.xpath("//*[@id=\"resolution\"]");
	By updateButton = By.xpath("//*[@id=\"update_bug_form\"]/div/div[3]/input");
	By newStatus = By.xpath("//*[@id=\"history\"]/div[2]/div/div/table/tbody/tr[last()-1]/td[last()]");

	public POMUpdateIssue(WebDriver driver) {
		this.driver = driver;
	}

	public void updateIssue(String id, String reso, String stats) throws Exception {

		Thread.sleep(1000);
		driver.get("http://localhost/mantisbt/bug_update.php");

		driver.findElement(viewissuebutton).click();
		Thread.sleep(1000);

		try {
			driver.findElement(By.linkText(id)).click();
			driver.findElement(editButton).click();
			Thread.sleep(1000);

			new Select(driver.findElement(status)).selectByVisibleText(stats);
			Thread.sleep(1000);
			new Select(driver.findElement(resolution)).selectByVisibleText(reso);
			Thread.sleep(1000);
			driver.findElement(updateButton).click();
			Thread.sleep(2000);
			if (!driver.getCurrentUrl().equals("http://localhost/mantisbt/bug_update.php")) {
				System.out.println("working");
			}

			else {
				System.out.println("enter a valid combination");

			}
			System.out.println("updated status of " + id + " is ");
			System.out.println(driver.findElement(newStatus).getText());

//			System.out.println(id + " resolved");
		} catch (Exception e) {
			System.out.println("enter a valid id");
		}

	}
}
