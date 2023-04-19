package com.mantis.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class POMReportIssue {

	By ReportIssueButton = By.xpath("//*[@id=\"sidebar\"]/ul/li[3]/a/span");
	By ViewIssueButton = By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/a/span");

	By Category = By.xpath("//*[@id=\"category_id\"]");
	By Reproducibility = By.xpath("//*[@id=\"reproducibility\"]");
	By Severity = By.xpath("//*[@id=\"severity\"]");
	By Priority = By.xpath("//*[@id=\"priority\"]");
	By Summ = By.xpath("//*[@id=\"summary\"]");
	By Desc = By.xpath("//*[@id=\"description\"]");
	By uploadFile = By.xpath("//*[@id=\"report_bug_form\"]/div/div[2]/div[1]/div/table/tbody/tr[12]/td/div[2]/i");
	By Submit = By.xpath("//*[@id=\"report_bug_form\"]/div/div[2]/div[2]/input");
	By IssueCat = By.xpath(
			"//div[@class='table-responsive'][1]/table/tbody//tr[@class='bug-header-data']//td[@class='bug-category']");
	By IssueRepro = By.xpath("//div[@class='table-responsive'][1]/table/tbody//tr/td[@class='bug-reproducibility']");
	By IssueSev = By.xpath("//div[@class='table-responsive'][1]/table/tbody//tr/td[@class='bug-severity']");
	By IssuePri = By.xpath("//div[@class='table-responsive'][1]/table/tbody//tr/td[@class='bug-priority']");
	By IssueSum = By.xpath("//div[@class='table-responsive'][1]/table/tbody//tr/td[@class='bug-summary']");
	By IssueDesc = By.xpath("//div[@class='table-responsive'][1]/table/tbody//tr/td[@class='bug-description']");

	WebDriver driver;

	public POMReportIssue(WebDriver driver) {
		this.driver = driver;
	}

	public void goToReportIssuePage() {
		driver.findElement(ReportIssueButton).click();
	}

	public void goToViewIssuePage() {
		driver.findElement(ViewIssueButton).click();
	}

	public boolean clickOnIssue(String issueId) {
		try {
			driver.findElement(By.linkText(issueId));
			return true;
		} catch (Exception e) {

			return false;
		}

	}

	public boolean validateIssue(String catog, String repro, String sever, String prior, String summary,
			String description) {
		boolean match = true;

		if (!catog.contains(driver.findElement(IssueCat).getText())) {
			match = false;
			// n=n+1;
			System.out.println("cat" + (driver.findElement(IssueCat).getText()) + catog);
		}
		if (!repro.contains(driver.findElement(IssueRepro).getText())) {
			match = false;
			System.out.println("repro" + (driver.findElement(IssueRepro).getText()) + repro);
		}
		if (!sever.contains(driver.findElement(IssueSev).getText())) {
			match = false;
			System.out.println("sever" + (driver.findElement(IssueSev).getText()) + sever);
		}
		if (!prior.contains(driver.findElement(IssuePri).getText())) {
			match = false;
			System.out.println("prior" + (driver.findElement(IssuePri).getText()) + prior);
		}
		if (!driver.findElement(IssueSum).getText().contains(summary)) {
			match = false;
			System.out.println("sum" + (driver.findElement(IssueSum).getText()) + summary);
		}
		if (!description.contains(driver.findElement(IssueDesc).getText())) {
			match = false;
			System.out.println("desc" + (driver.findElement(IssueDesc).getText()) + description);
		}

		return match;
	}

	public String createIssue(String catog, String repro, String sever, String prior, String summary,
			String description) throws Exception {

		Thread.sleep(1000);

		new Select(driver.findElement(Category)).selectByVisibleText(catog);
		Thread.sleep(1000);

		new Select(driver.findElement(Reproducibility)).selectByVisibleText(repro);
		Thread.sleep(1000);

		new Select(driver.findElement(Severity)).selectByVisibleText(sever);
		Thread.sleep(1000);

		new Select(driver.findElement(Priority)).selectByVisibleText(prior);
		Thread.sleep(1000);

		driver.findElement(Summ).sendKeys(summary);
		Thread.sleep(1000);

		driver.findElement(Desc).sendKeys(description);
		Thread.sleep(1000);

		driver.findElement(uploadFile).click();
		Thread.sleep(3000);

		driver.findElement(Submit).click();

		Thread.sleep(1000);
		return driver.findElement(By.xpath("//td[@class='bug-id']")).getText();
	}

	public boolean checkHomePage() {
		return driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/a/span")).isDisplayed();
	}

}
