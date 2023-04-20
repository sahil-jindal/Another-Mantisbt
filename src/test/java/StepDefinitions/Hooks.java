package StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.mantis.POM.DriverLib;
import com.mantis.POM.POMLoginClass;
import com.mantis.POM.POMLogoutMantisbt;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	static DriverLib libDriver = new DriverLib();
	static WebDriver driver = libDriver.getWebDriver();

	@Before
	public void login() {
		POMLoginClass login = new POMLoginClass(driver);
		login.login("administrator", "root");
	}

	@After
	public void logout() {
		POMLogoutMantisbt logout = new POMLogoutMantisbt();
		try {
			logout.logout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@AfterAll
//	public static void final_quit() {
//		driver.close();
//		driver.quit();
//	}

}
