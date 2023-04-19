package com.mantis.POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverLib {

	static WebDriver driver;

	public WebDriver getWebDriver() {
		WebDriver driver = DriverLib.driver;
		if (driver == null) {
			driver = startWebDriver();
			DriverLib.driver = driver;
		}

		return driver;
	}

	private WebDriver startWebDriver() {
		WebDriver driver;
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*", "--start-maximized");
		driver = new ChromeDriver(ops);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost/mantisbt/login_page.php");

		return driver;

	}

}
