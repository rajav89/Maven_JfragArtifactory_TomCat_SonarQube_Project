package steps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;

import base.Base;
import base.CommonMethods;
import utilities.CommonUtilities;

public class Assignment1 extends CommonMethods {

	@Test
	public void tC01() {
		setXLFile("C:\\Users\\r7002201\\git\\RajaVenuchetty_SDETL3_Selenium\\TestData.xlsx","testData1");
		wait = new WebDriverWait(getDriver(), 30);
		launchApplication("https://demoqa.com/selectable/");
		getDriver().manage().window().maximize();
		Selectable();
		getDriver().navigate().to("https://demoqa.com/html-contact-form/");
		htmlContactForm();
		String url = partialLinkText("Google L");		
		newTab();
		ArrayList<String> tab = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tab.get(1));
		System.out.println("window < " + tab.size());
		getDriver().get(url);				
		getDriver().switchTo().window(tab.get(0));
		getDriver().navigate().to(" https://demoqa.com/droppable/");
		dragandDropBox(dragBoxLoc,dropBoxLoc);
		getDriver().navigate().to("https://demoqa.com/datepicker/");
		click(dateTextBoxLoc);		
		inputDOBData(getExcelStringData(1, 4));
		getDriver().navigate().to("https://demoqa.com/selectmenu/");		
		selectDropDownOptions(selectSpeedDropDownListLoc,speedDropDownBoxLoc);		
		selectDropDownOptions(selectFileDropDownListLoc,FileDropDownBoxLoc);		
		selectDropDownOptions(selectNumberDropDownListLoc,NumericDropDownBoxLoc);		
		selectDropDownOptions(selectTitleDropDownListLoc,TitleDropDownBoxLoc);
		//getDriver().navigate().to("https://demoqa.com/controlgroup/"); //Environment not working

	}

}
