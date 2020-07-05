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

public class Assignment3 extends CommonMethods{
	
	@Test
	public void tc03() {
		setXLFile("C:\\Users\\r7002201\\git\\RajaVenuchetty_SDETL3_Selenium\\TestData.xlsx","testData");		
		
		Base webDriverInit = new Base();
		wait = new WebDriverWait(getDriver(), 30);		
		getDriver().get("https://www.makemytrip.com/");
		getDriver().manage().window().maximize();
		click(mmTOnewayCheckBoxLoc);
		click(mmTFromCityTextboxLoc);
		getDriver().findElement(By.xpath(String.format(mmTSelectCityNameLoc, getExcelStringData(1, 0)))).click();		
		jsClick(mmTToCityTextboxLoc);
		getDriver().findElement(By.xpath(String.format(mmTSelectCityNameLoc, getExcelStringData(1, 1)))).click();
		jsClick(mmTDepartureCalenderLoc);
		getText(calenderTitleLinkLoc);
		inputDOBData(getExcelStringData(1, 2));
		click(mmTSearchButtonLoc);
		getAllText(mmTFlishtPrice);
		click(mmTBookNowButtonLoc);
	}

}

