package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.CommonUtilities;

public class Base {
	
	public static WebDriver webDriver = null;

	@Before
	public void Base() {
		if (webDriver == null) {

			System.setProperty("webdriver.chrome.driver", "E:\\Software\\Chrome 70\\chromedriver.exe");
			webDriver = new ChromeDriver();
			System.out.println("**Chrome driver initiated**");
		} else {
			System.out.println("**Chrome driver already instantiated**");
		}
	}

	public static WebDriver getDriver() {
		if (webDriver == null)
			return webDriver;
		else
			return webDriver;
	}
	
	@After
	public void AfterTest() {		
		System.out.println("<<<<< After Class >>>>>");
		getDriver().close();
	}

}
