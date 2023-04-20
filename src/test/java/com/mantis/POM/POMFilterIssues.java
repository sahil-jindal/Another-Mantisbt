package com.mantis.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class POMFilterIssues {

	By prioritylink = By.xpath("//form[@id='filters_form_open']//table//tr[1]/td[5]/a");
	By priorityselect = By.xpath("//form[@id='filters_form_open']//table//tr[2]/td[5]/select");
	By severitylink = By.xpath("//form[@id='filters_form_open']//table//tr[1]/td[6]/a");
	By severityselect = By.xpath("//form[@id='filters_form_open']//table//tr[2]/td[6]/select");
	By Statuslink = By.xpath("//form[@id='filters_form_open']//table//tr[3]/td[3]/a");
	By Statusselect = By.xpath("//form[@id='filters_form_open']//table//tr[4]/td[3]/select");
	By ViewIssueButton = By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/a/span");
	By SubmitButton = By.xpath("//form[@id='filters_form_open']//input[@type='submit']");
	By IssueList = By.xpath("//*[@class='column-id']");
	By PriorityList = By.xpath("//*[@class='column-priority']/i");
	By SeverityList = By.xpath("//*[@class='column-severity']");
	By StatusList = By.xpath("//*[@class='column-status']");

	WebDriver driver;

	public POMFilterIssues(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkHomePage() throws NoSuchElementException {
		return driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/a/span")).isDisplayed();
	}

	public void goToViewIssuePage() throws NoSuchElementException {
		driver.findElement(ViewIssueButton).click();
	}

	public void applyPriorityFilter(String prior) throws Exception {

		driver.findElement(prioritylink).click();
		Thread.sleep(1000);
		new Select(driver.findElement(priorityselect)).selectByVisibleText(prior);
		Thread.sleep(1000);
		driver.findElement(SubmitButton).click();
	}

	public void applySeverittyFilter(String sever) throws Exception {

		driver.findElement(severitylink).click();
		Thread.sleep(1000);
		new Select(driver.findElement(severityselect)).selectByVisibleText(sever);
		Thread.sleep(1000);
		driver.findElement(SubmitButton).click();
	}

	public void applyStatusFilter(String status) throws Exception {

		driver.findElement(Statuslink).click();
		Thread.sleep(1000);
		new Select(driver.findElement(Statusselect)).selectByVisibleText(status);
		Thread.sleep(1000);
		driver.findElement(SubmitButton).click();
	}

	public boolean validateFilter(String prior, String sever, String stats) throws NoSuchElementException {

		boolean status = true;

		List<WebElement> ilist = driver.findElements(IssueList);
		List<WebElement> plist = driver.findElements(PriorityList);
		List<WebElement> severlist = driver.findElements(SeverityList);
		List<WebElement> statlist = driver.findElements(StatusList);

		if (prior.contains("none"))
			if (plist.size() != 0)
				status = false;
		for (int i = 1; i < ilist.size(); i++) {
			if ((!prior.contains("none"))) {
				if ((!(plist.get(i - 1).getAttribute("title")).contains(prior)) && (!prior.contains("any"))) {
					status = false;
				}
			}
			if ((!(severlist.get(i).getText()).contains(sever)) && (!sever.contains("any"))) {
				status = false;
			}
			if ((!(statlist.get(i).getText()).contains(stats)) && (!stats.contains("any"))) {
				status = false;
			}
			
		}
		return status;
	}
}