package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import base.Base;
import base.CommonMethods;

public class CommonUtilities extends Base {

	private static final TimeUnit SECONDS = null;
	public static File file;
	public static FileInputStream fis;
	public static XSSFWorkbook excelWorkBook;
	public static XSSFSheet excelSheet;
	public static XSSFCell excelCell;

	public static WebDriverWait wait;

	public static void click(By element) {
		getDriver().findElement(element).click();
	}

	public static void jsScroll() {
		JavascriptExecutor jsClick = (JavascriptExecutor) getDriver();
		jsClick.executeScript("scroll(0,250)");

	}

	public static void jsClick(By element) {

		JavascriptExecutor jsClick = (JavascriptExecutor) getDriver();
		jsClick.executeScript("arguments[0].click()", getDriver().findElement(element));
	}

	public static void getUrl(String url) {
		getDriver().get(url);
	}

	public static void typeText(By Element, String text) {
		getDriver().findElement(Element).sendKeys(text.trim());
	}

	public static void verifyTextDisplayed(By element, String text) {
		wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));

	}

	public static void waitAndClick(By element) {
		wait = new WebDriverWait(getDriver(), 120);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
			click(element);
		} catch (NoSuchElementException nseE) {
			System.out.println("Error >> " + nseE);

			click(element);
		}
	}

	public static String randomMailId() {
		int number = (int) (Math.random() * 10000 + 1);
		String randommailid = "mailTo" + Integer.toString(number) + "@gmail.com";
		return randommailid;
	}

	public static void setXLFile(String filepath, String sheetName) {

		file = new File(filepath);
		try {
			fis = new FileInputStream(file);
			System.out.println(fis);
			excelWorkBook = new XSSFWorkbook(fis);
			excelSheet = excelWorkBook.getSheet(sheetName);

		} catch (IOException ioe) {
			System.out.println("Exception in FIS >" + ioe);
		}

	}

	public static String getExcelStringData(int roNum, int colNum) {
		String cell = null;
		excelCell = excelSheet.getRow(roNum).getCell(colNum);
		cell = excelCell.getStringCellValue();

		return cell;

	}

	public static int getExcelNumericData(int roNum, int colNum) {
		int cell;
		excelCell = excelSheet.getRow(roNum).getCell(colNum);
		cell = (int) excelCell.getNumericCellValue();

		return cell;

	}

	public static String randomPassword() {
		Random random = new Random();
		int randNum = random.nextInt(1000);
		String password = "password" + Integer.toString(randNum);
		return password;
	}

	public static void writeExcel(int roNum, int colNum, String value) {
		try {

			excelSheet.getRow(roNum).createCell(colNum).setCellValue(value);
			FileOutputStream fos = new FileOutputStream(file);
			excelWorkBook.write(fos);
			fos.close();

		} catch (IOException ioe) {
			System.out.println("Exception in Write Excel >> " + ioe);
		}

	}

	public static String getText(By element) {
		String text = getDriver().findElement(element).getText();
		System.out.println("Text >> " + text);
		return text;
	}

	public static void selectByText(By element, String text) {
		Select select = new Select(getDriver().findElement(element));
		List<WebElement> ele = select.getOptions();
		int i;
		for (i = 0; i < ele.size(); i++) {
			System.out.println("Options > " + ele.get(i).getText());
			if (ele.get(i).getText().trim().contains(text)) {

				select.selectByVisibleText(ele.get(i).getText());
				break;
			}
		}
	}

	public static void getAllText(By element) {
		List<WebElement> noOfProduct = getDriver().findElements(element);
		System.out.println(">>Size>> " + noOfProduct.size());
		for (WebElement ele : noOfProduct) {
			System.out.println("Value From List > " + ele.getText());
		}

	}

	public static void waitt(int waitTime) {
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
