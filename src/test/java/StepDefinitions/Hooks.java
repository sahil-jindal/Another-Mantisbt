package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mantis.POM.DriverLib;
import com.mantis.POM.POMLoginClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;

public class Hooks {

	static DriverLib libDriver = new DriverLib();
	static WebDriver driver = libDriver.getWebDriver();

	@Before
	public void login() {
		POMLoginClass login = new POMLoginClass(driver);
		login.login("administrator", "root");
		
	}

//	@After
//	public void logout() {
//		driver = libDriver.getWebDriver();
//		driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/a/i[2]")).click();
//		driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/ul/li[4]/a")).click();
//		System.out.println("user logout");
//	}
//
//	@AfterAll
//	public static void final_quit() {
//		driver.quit();
//	}

}
