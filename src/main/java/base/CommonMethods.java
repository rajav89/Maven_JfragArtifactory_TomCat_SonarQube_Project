package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import pageData.Locaters;
import utilities.CommonUtilities;

public class CommonMethods extends CommonUtilities implements Locaters {
	public static String month;
	public static String year;
	public static String date;
	public static int yearInNumber;
	public static int monthInNumber;
	public static String monthNumber;
	public static int compareMonthNumber;
	public static int monthFromInputForNumber;
	public static int monthFromCalenderForNumber;
	public static String password;
	public static String emailId;

	public void launchApplication(String url) {
		wait = new WebDriverWait(getDriver(), 30);
		getDriver().get(url);
		getDriver().manage().window().maximize();
	}

	public static void Selectable() {
		List<WebElement> selectItems = getDriver().findElements(selectableItemLoc);
		System.out.println("<size > " + selectItems.size());
		for (int i = 1; i < selectItems.size() + 1; i++) {
			getDriver().findElement(By.xpath(String.format(selectableItemBynaLoc, i))).click();
		}
		getAllText(selectableItemLoc);
	}

	public static void olaCreateAccouForntLogin() {
		click(olayRegisterLinkLoc);
		emailId = randomMailId();
		System.out.println("emailId >>> " + emailId);
		typeText(olaEmailTextBoxLoc, emailId);
		password = randomPassword();
		typeText(olaPasswordTextBoxLoc, password);
		System.out.println("password >>> " + password);
		typeText(olaPasswordConfirmTextLoc, password);
		String DOB = "20/12/1992"; // dd/m/yyyy
		String[] doBArray = inputdoBData(DOB);
		selectDropDownOption(olabirthdayDateDropDownLoc, doBArray[0]);
		selectDropDownOption(olabirthdayMonthDropDownLoc, doBArray[1]);
		selectDropDownOption(olabirthdayYearDropDownLoc, doBArray[2]);
		click(olaRejectCookiesButtonLoc);
		click(olaAdvertisementCloseButton);
		wait = new WebDriverWait(getDriver(), 40);
		wait.until(ExpectedConditions.elementToBeClickable(olaFormSubmitButtonLoc));
		jsScroll();
		jsClick(olaFormSubmitButtonLoc);
		// click(olaFormSubmitButtonLoc);
		click(olaSkipToThisStepLinkLoc);
		Assert.assertEquals("YOUR PROFILE", getDriver().findElement(olaProfileViewLoc).getText());
		click(olasignOutLinkLoc);
		click(olaLogoutConfirmationbuttonLoc);
	}

	public static void signIn(String url) {
		getDriver().navigate().to(url);
		click(olaSignInLinkLoc);
		typeText(olaSignInEmailIdTextBoxLoc, emailId);
		typeText(olaSignInPasswordTextBoxLoc, password);
		String currenturl = getDriver().getCurrentUrl();

		if (currenturl.contains("de-de")) {
			click(olaSignInGermanButtonLoc);
		} else if (currenturl.contains("es-es")) {
			click(olaSignInSpanButtonLoc);
		} else {
			click(olaSignInButtonLoc);
		}
		Assert.assertEquals("YOUR PROFILE", getDriver().findElement(olaProfileViewLoc).getText());
		click(olasignOutLinkLoc);
		click(olaLogoutConfirmationbuttonLoc);
	}

	public static void htmlContactForm() {
		setXLFile("C:\\Users\\r7002201\\git\\RajaVenuchetty_SDETL3_Selenium\\TestData.xlsx", "testData1");
		typeText(fistNameTextBoxLoc, getExcelStringData(1, 0));
		typeText(lastNameTextBoxLoc, getExcelStringData(1, 1));
		typeText(countryTextBoxLoc, getExcelStringData(1, 2));
		typeText(subjectTextBoxLoc, getExcelStringData(1, 3));
		click(submitButtonLoc);
		getDriver().navigate().back();
	}

	public static String partialLinkText(String text) {
		String link = getDriver().findElement(By.partialLinkText(text)).getAttribute("href");

		return link;
	}

	public static void newTab() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_T);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_T);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void dragandDropBox(By drag, By drop) {
		Actions action = new Actions(getDriver());
		action.dragAndDrop(getDriver().findElement(drag), getDriver().findElement(drop)).build().perform();
	}

	public static void dateManipulation(String dateTitle) {

		String[] splitTitle = dateTitle.split(" ");
		System.out.println("<<< Month >>> " + splitTitle[0]);
		System.out.println("<<< Year >>> " + splitTitle[1]);

		month = splitTitle[0];
		year = splitTitle[1];
		yearInNumber = Integer.parseInt(year);
		System.out.println("Year in number> " + yearInNumber);

		monthNumber = Integer.toString(getMonthNumber(month)).trim();
		monthInNumber = getMonthNumber(month.trim());
		monthFromCalenderForNumber = getMonthNumber(month);

	}

	public static void calenderTraversing(String daTe, String monTh, String yeaR) {

		String dateTitle = getText(calenderTitleLinkLoc);
		dateManipulation(dateTitle);

		int Year = Integer.parseInt(yeaR);
		monthFromInputForNumber = Integer.parseInt(monTh);
		String getMonth = getMonthName().trim();

		System.out.println(monTh + " < month & MonthNumber> " + monthNumber);
		System.out.println("<<*********>> " + dateTitle + "><" + getMonth.trim() + " " + yeaR.trim());

		while (!((yearInNumber == Year) && (monTh.equalsIgnoreCase(monthNumber)))) {

			dateTitle = getText(calenderTitleLinkLoc);
			dateManipulation(dateTitle);

			System.out.println(monTh + " < month & MonthNumber> " + monthNumber);
			System.out.println("<<*********>> " + dateTitle + "><" + getMonth.trim() + " " + yeaR.trim());

			if (!dateTitle.trim().equalsIgnoreCase(getMonth.trim() + " " + yeaR.trim())) {

				if ((yearInNumber < Year || !dateTitle.trim().equalsIgnoreCase(getMonth.trim() + " " + yeaR.trim())))
					click(mmTNextMonthArrowButtonLoc);
				else if ((yearInNumber > Year)
						|| !dateTitle.trim().equalsIgnoreCase(getMonth.trim() + " " + yeaR.trim()))
					click(mmTPreviouesMonthArrowButtonLoc);

			}

			if (dateTitle.trim().equalsIgnoreCase(getMonth + " " + yeaR)) {
				System.out.println(dateTitle + "><" + getMonth + " " + yeaR);
				getDriver().findElement(By.xpath(String.format(mmTCalenderDateSelection, daTe))).click();
				break;
			}
		}
	}

	public static void inputDOBData(String dob) {
		String[] doB = dob.split("/");
		System.out.println(doB[0]);
		System.out.println(doB[1]);
		System.out.println(doB[2]);
		calenderTraversing(doB[0], doB[1], doB[2]);
	}

	public static String[] inputdoBData(String dob) {
		String[] doB = dob.split("/");
		System.out.println(doB[0]);
		System.out.println(doB[1]);
		System.out.println(doB[2]);
		return doB;
	}

	public static String getMonthName() {
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] month = dfs.getMonths();
		System.out.println("returning Month in Name> " + month[monthFromInputForNumber - 1]);

		return month[monthFromInputForNumber - 1];

	}

	public static int getMonthNumber(String monthName) {
		Date date = null;
		try {
			date = new SimpleDateFormat("MMMM").parse(monthName);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		System.out.println("returning month in number> " + cal.get(Calendar.MONTH));

		return cal.get(Calendar.MONTH) + 1;
	}

	public static List<WebElement> getListElements(By element) {
		List<WebElement> selectMenu = getDriver().findElements(element);
		System.out.println("SelectMenu size > " + selectMenu.size());

		return selectMenu;
	}

	public static void selectDropDownOptions(By Element, By element1) {
		int i = 0;
		click(element1);
		for (WebElement menu : getListElements(Element)) {
			System.out.println("Menu Option > " + getListElements(Element).get(i).getText());
			try {
				getListElements(Element).get(i).click();
			} catch (Exception e) {
				System.out.println("Exception in Select DropDownOptions >>> " + e);
			}

			if (!(getListElements(Element).size() == i + 1))
				click(element1);
			i++;
		}
	}

	public static void selectDropDownOption(By element, String text) {
		Select select = new Select(getDriver().findElement(element));
		select.selectByValue(text);
	}

}
