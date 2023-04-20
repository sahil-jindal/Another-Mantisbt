package com.mantis.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POMLoginClass {

	By UN = By.xpath("//*[@id=\"username\"]");
	By PWD = By.xpath("//*[@id=\"password\"]");
	By SUBMIT = By.xpath("//input[@type='submit']");
	
	WebDriver driver;
	
	public POMLoginClass(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver login(String un, String pwd)
	{
		driver.findElement(UN).sendKeys(un);
		driver.findElement(SUBMIT).click();
		driver.findElement(PWD).sendKeys(pwd);
		driver.findElement(SUBMIT).click();
		return driver;
	}

	public void clearLoginValues()
	{
		driver.findElement(UN).clear();
		driver.findElement(PWD).clear();
		
	}
	
	public void clearUN()
	{
		//driver.findElement(UN).clear();
	}
	
	public void clearPWD()
	{
		driver.findElement(PWD).clear();
	}
}
