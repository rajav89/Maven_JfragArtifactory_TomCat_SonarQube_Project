package steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import base.CommonMethods;

public class Assignment2 extends CommonMethods{
	
	@Test
	public void tc02() {
		setXLFile("C:\\Users\\r7002201\\git\\RajaVenuchetty_SDETL3_Selenium\\TestData.xlsx","testData")	;
		
		Base webDriverInit = new Base();
		wait = new WebDriverWait(getDriver(), 30);		
		getDriver().get("https://www.olay.co.uk/en-gb");
		getDriver().manage().window().maximize();
		olaCreateAccouForntLogin();
		signIn("https://www.olay.co.uk/en-gb");
		//signIn("https://www.olay.com.cn/");
		//signIn("https://www.olaz.de/de-de");
		//signIn("https://www.olay.es/es-es");
	}

}

