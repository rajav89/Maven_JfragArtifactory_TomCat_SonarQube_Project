package pageData;

import org.openqa.selenium.By;

public interface Locaters {

	public static String logoutMsgText = "You have been logged off your account. It is now safe to leave the computer.";
	public static String logiUrl = "https://demo.opencart.com/";

	By createAccountLoc = By.xpath("//*[@class='caret']");

	//
	public static By selectableItemLoc = By.xpath("//*[@id='selectable']/li");
	public static By fistNameTextBoxLoc = By.xpath("//*[@class='firstname']");
	public static By lastNameTextBoxLoc = By.xpath("//*[@id='lname']");
	public static By countryTextBoxLoc = By.xpath("//*[@name='country']");
	public static By subjectTextBoxLoc = By.xpath("//*[@name='subject']");
	public static By submitButtonLoc = By.xpath("//*[@type='submit']");
	public static By dragBoxLoc = By.xpath("//*[@class='ui-widget-content ui-draggable ui-draggable-handle']");
	public static By dropBoxLoc = By.xpath("//*[@class='ui-widget-header ui-droppable']");
	public static By selectSpeedDropDownLoc = By.xpath("//*[@id='speed']");
	public static By speedDropDownBoxLoc = By.xpath("//*[@id='speed-button']");
	public static By FileDropDownBoxLoc = By.xpath("//*[@id='files-button']");
	public static By NumericDropDownBoxLoc = By.xpath("//*[@id='number-button']");
	public static By TitleDropDownBoxLoc = By.xpath("//*[@id='salutation-button']");
	public static By speedDropDownMenuLoc = By.xpath("//*[@id='speed-menu']");

	public static By selectSpeedDropDownListLoc = By.xpath("//*[@id='speed-menu']//li");
	public static By selectFileDropDownListLoc = By.xpath("//*[@id='files-menu']//li");
	public static By selectNumberDropDownListLoc = By.xpath("//*[@id='number-menu']//li");
	public static By selectTitleDropDownListLoc = By.xpath("//*[@id='salutation-menu']//li");

	// Dynamic Locaters
	public static String selectableItemBynaLoc = "//*[@id='selectable']/li[%s]";
	public static String dateLoc = "(//*[@class='ui-state-default'])[%s]";
	public static String selectMenuListStringLoc = "//*[@id='speed-menu']//li[%s]";
	public static String mmTSelectCityNameLoc = "//*[@role='option']//div//div[text()='%s']";
	public static String mmTCalenderDateSelection = "(//*[@class='dateInnerCell'])[%s]";
	

	// DatetimePicker

	public static By dateTextBoxLoc = By.xpath("//*[@id='datepicker']");
	public static By yearLoc = By.xpath("//*[@class='ui-datepicker-year']");
	public static By calenderPickerTitle = By.xpath("//*[@class='ui-datepicker-title']");
	public static By calenderLeftButtonLoc = By.xpath("//*[@class='ui-icon ui-icon-circle-triangle-w']");
	public static By calenderRightButtonLoc = By.xpath("//*[@class='ui-icon ui-icon-circle-triangle-e']");

	// olay Locaters

	public static By olayRegisterLinkLoc = By.xpath("(//*[@class='event_profile_register'])[1]");
	public static By olaEmailTextBoxLoc = By.xpath("//*[@data-key='emailAddress']");
	public static By olaPasswordTextBoxLoc = By.xpath("//*[@data-key='newPassword']");
	public static By olaPasswordConfirmTextLoc = By.xpath("(//*[@controltype='password'])[2]");
	public static By olabirthdayDateDropDownLoc = By.xpath("//*[@data-key='birthdate[dateselect_day]']");
	public static By olabirthdayMonthDropDownLoc = By.xpath("//*[@data-key='birthdate[dateselect_month]']");
	public static By olabirthdayYearDropDownLoc = By.xpath("//*[@data-key='birthdate[dateselect_year]']");
	public static By olaAdvertisementCloseButton = By.xpath("//*[@alt='Close']");
	public static By olaRejectCookiesButtonLoc = By.xpath("//*[@id='onetrust-reject-all-handler']");
	public static By olaFormSubmitButtonLoc = By.xpath("//*[@type='submit']");
	//public static By olaFirstNameTextBoxLoc = By.xpath("//*[@data-key='firstName']");
	//public static By olaLastNameTextBoxLoc = By.xpath("//*[@data-key='lastName']");
	//public static By olaAddressTextBoxLoc = By.xpath("//*[@data-key='addressStreet1']");
	//public static By olaAddressCityTextBoxLoc = By.xpath("//*[@data-key='addressCity']");
	//public static By olaPostalCodeTextBoxLoc = By.xpath("//*[@data-key='addressPostalCode']");
	public static By olaSkipToThisStepLinkLoc = By.xpath("//*[@title='Skip This Step']");
	public static By olaProfileViewLoc = By.xpath("//*[text()='YOUR PROFILE']");
	public static By olaGermanProfileViewLoc = By.xpath("//*[text()='Beginnen Sie mit der Anmeldung bei Ihrem Olaz-Konto.']");
	
	public static By olasignOutLinkLoc = By.xpath("//*[@title='Sign Out']");
	public static By olaLogoutConfirmationbuttonLoc = By.xpath("//*[@title='Logout']");

	public static By olaSignInLinkLoc = By.xpath("//*[@class='event_profile_login']");
	public static By olaSignInEmailIdTextBoxLoc = By.xpath("//*[@data-key='signInEmailAddress']");
	public static By olaSignInPasswordTextBoxLoc = By.xpath("//*[@data-key='currentPassword']");
	public static By olaSignInButtonLoc = By.xpath("//*[@value='SIGN IN']");
	public static By olaSignInGermanButtonLoc = By.xpath("//*[@value='ANMELDEN']");
	public static By olaSignInSpanButtonLoc = By.xpath("//*[@value='INICIAR SESIÓN']");
	
	
	//Makemy trip portal
	public static By mmTOnewayCheckBoxLoc = By.xpath("//*[@data-cy='oneWayTrip']");
	public static By mmTRoundTripCheckBoxLoc = By.xpath("//*[@data-cy='roundTrip']");
	public static By mmTMultiCityCheckBoxLoc = By.xpath("//*[@data-cy='mulitiCityTrip']");
	public static By mmTFromCityTextboxLoc = By.xpath("//*[@id='fromCity']");
	public static By mmTToCityTextboxLoc = By.xpath("//*[@id='toCity']");
	
	public static By mmTDepartureCalenderLoc = By.xpath("//*[@for='departure']");
	public static By mmTReturnCalenderLoc = By.xpath("//*[@for='return']");
	public static By mmTNextMonthArrowButtonLoc = By.xpath("//*[@aria-label='Next Month']");
	public static By mmTPreviouesMonthArrowButtonLoc = By.xpath("//*[@aria-label='Previous Month']");
	public static By calenderTitleLinkLoc = By.xpath("(//*[@class='DayPicker-Months']//*[@class='DayPicker-Caption'])[1]//div");
	public static By mmTSearchButtonLoc = By.xpath("//*[text()='Search']");
	public static By mmTFlishtPrice = By.xpath("//*[@class='actual-price']");
	public static By mmTBookNowButtonLoc = By.xpath("//*[text()='Book Now']");
	
	////*[@class='actual-price']/following::*[text()='Book Now']
	
		
	
	
}


