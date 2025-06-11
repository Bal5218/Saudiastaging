package travelerWithAllDetails;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import addTraveler.GenericUtility;
import flightbookingAssignTask.TripTypeSearchPage;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class SaveDependent {
	public static void savedependent(String DateofBirth, String IssuingCountry, String Validtity, String ExpiryDate,
			String Salutation, String FirstName, String LastName, String Gender, String Relation, String Email,
			String Countrycode, String Nationality, String Documenttype, String issueplace, String savecancildependent,String preference,
			String selectlonghaulmealpreference,String Shorthaulseatpreference )
			throws Throwable {
		QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Saved dependents')]")).click();
		Thread.sleep(1000);
		QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Dependents details')]")).click();
		Thread.sleep(1000);
		// boolean addbutton =
		// QaBrowser.driver.findElement(By.xpath("//a[contains(text(),'Add
		// now')]")).isDisplayed();
//		if(addbutton) {
//			QaBrowser.driver.findElement(By.xpath("//a[contains(text(),'Add now')]")).click();
//		}
//		else {
//			QaBrowser.driver.findElement(By.xpath("//mat-icon[text()='add']")).click();
//		}
		List<WebElement> addNowLinks = QaBrowser.driver.findElements(By.xpath("//a[contains(text(),'Add now')]"));
		if (!addNowLinks.isEmpty() && addNowLinks.get(0).isDisplayed()) {
			addNowLinks.get(0).click();
		} else {
			QaBrowser.driver.findElement(By.xpath("//mat-icon[text()='add']")).click();
		}
		QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'Title')]/../..//mat-select")).click();
		GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span", Salutation);
		WebElement firstN = QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"dependantFirstName\"]"));
		firstN.click();
		firstN.sendKeys(FirstName);
		WebElement LastN = QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"dependantLastName\"]"));
		LastN.click();
		LastN.sendKeys(LastName);
		// label[contains(text(),'Male')]/../..//input
		switch (Gender) {
		case "Male":
			QaBrowser.driver.findElement(By.xpath("// label[contains(text(),'Male')]/../..//input")).click();
			break;
		case "Female":
			QaBrowser.driver.findElement(By.xpath("//label[contains(text(),'Female')]/../..//input")).click();
			break;

		}
		QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'Relation')]/../.. //mat-select")).click();
		Thread.sleep(1500);
		GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span", Relation);
		WebElement email = QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"email\"]"));
		email.click();
		email.clear();
		email.sendKeys(Email);
		QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Country Code')]/../..//input")).click();
		GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel[starts-with(@id,'a')]//div/span", Countrycode);
		WebElement phoneNumber = QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"phoneNo\"]"));
		phoneNumber.click();
		phoneNumber.sendKeys("9876543210");
		QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Nationality')]/../..//input")).click();
		GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", Nationality);
		QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Document Type')]/../..//input")).click();
		GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", Documenttype);
		switch (Documenttype) {
		case "Passport":
			QaExtentReport.extentScreenshot("Added dependent");
			WebElement passportText = QaBrowser.driver
					.findElement(By.xpath("//input[@formcontrolname=\"dependantPasportNo\"]"));
			passportText.click();
			passportText.sendKeys("N1234567890");
			QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'DOB')]/../..//input")).click();
			QaBrowser.driver.findElement(By.xpath("//div[text()=' 1990 – 2013 ']")).click();
			String[] DateSelection = DateofBirth.split("-");
			String expDate = DateSelection[0];// 20
			String month = DateSelection[1];// AUG
			String year = DateSelection[2];// 1991

			TripTypeSearchPage.selectDateInCalendarOneWay1(expDate, month, year);
			Thread.sleep(200);
			try {
				GenericUtility.clickConfirmButton("//span[contains(text(),'Confirm')]");

			} catch (ElementClickInterceptedException e) {
				Thread.sleep(2000);
				e.printStackTrace();
				WebElement A = QaBrowser.driver.findElement(By.xpath("//span[contains(text(),'Confirm')]"));
				JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
				js.executeScript("arguments[0].click()", A);

			}
			QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Issue Country')]/../..//input")).click();
			GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", IssuingCountry);
			QaBrowser.driver.findElement(By.xpath("//div[text()='Place of issue']/../..//input")).click();
			GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", issueplace);
			QaBrowser.driver.findElement(By.xpath("//mat-label[text()='Valid From']/../..//input")).click();

			QaBrowser.driver.findElement(By.xpath("//div[text()=' 1990 – 2013 ']")).click();
			String[] DateSelection1 = Validtity.split("-");
			String expDate1 = DateSelection1[0];// 20
			String month1 = DateSelection1[1];// AUG
			String year1 = DateSelection1[2];// 1991

			TripTypeSearchPage.selectDateInCalendarOneWay1(expDate1, month1, year1);
			Thread.sleep(200);
			try {
				GenericUtility.clickConfirmButton("//span[contains(text(),'Confirm')]");

			} catch (ElementClickInterceptedException e) {
				Thread.sleep(2000);
				e.printStackTrace();
				WebElement A = QaBrowser.driver.findElement(By.xpath("//span[contains(text(),'Confirm')]"));
				JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
				js.executeScript("arguments[0].click()", A);

			}

			QaBrowser.driver.findElement(By.xpath(
					"//mat-label[contains(text(),'Expiry Date')]/../..//input[@formcontrolname=\"passportExpiry\"]"))
					.click();
			String[] DateSelection2 = ExpiryDate.split("-");
			String expDate2 = DateSelection2[0];// 20
			String month2 = DateSelection2[1];// AUG
			String year2 = DateSelection2[2];// 1991

			TripTypeSearchPage.selectDateInCalendarOneWay1(expDate2, month2, year2);
			Thread.sleep(200);
			try {
				GenericUtility.clickConfirmButton("//span[contains(text(),'Confirm')]");

			} catch (ElementClickInterceptedException e) {
				Thread.sleep(2000);
				e.printStackTrace();
				WebElement A = QaBrowser.driver.findElement(By.xpath("//span[contains(text(),'Confirm')]"));
				JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
				js.executeScript("arguments[0].click()", A);

			}

			break;

		case "National ID":
			WebElement nationalid = QaBrowser.driver
					.findElement(By.xpath("//mat-label[contains(text(),'National ID Number')]/../..//input"));
			nationalid.click();
			nationalid.sendKeys("987654321012");

			QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'DOB')]/../..//input")).click();
			QaBrowser.driver.findElement(By.xpath("//div[text()=' 1990 – 2013 ']")).click();
			String[] DateSelection12 = DateofBirth.split("-");
			String expDate12 = DateSelection12[0];// 20
			String month12 = DateSelection12[1];// AUG
			String year12 = DateSelection12[2];// 1991

			TripTypeSearchPage.selectDateInCalendarOneWay1(expDate12, month12, year12);
			Thread.sleep(200);
			try {
				GenericUtility.clickConfirmButton("//span[contains(text(),'Confirm')]");

			} catch (ElementClickInterceptedException e) {
				Thread.sleep(2000);
				e.printStackTrace();
				WebElement A = QaBrowser.driver.findElement(By.xpath("//span[contains(text(),'Confirm')]"));
				JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
				js.executeScript("arguments[0].click()", A);

			}
			QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Issue Country')]/../..//input")).click();
			GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", IssuingCountry);
			QaBrowser.driver.findElement(By.xpath("//div[text()='Place of issue']/../..//input")).click();
			GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", issueplace);
			QaBrowser.driver.findElement(By.xpath("//mat-label[text()='Valid From']/../..//input")).click();

			QaBrowser.driver.findElement(By.xpath("//div[text()=' 1990 – 2013 ']")).click();
			String[] DateSelection112 = Validtity.split("-");
			String expDate112 = DateSelection112[0];// 20
			String month112 = DateSelection112[1];// AUG
			String year112 = DateSelection112[2];// 1991

			TripTypeSearchPage.selectDateInCalendarOneWay1(expDate112, month112, year112);
			Thread.sleep(200);
			try {
				GenericUtility.clickConfirmButton("//span[contains(text(),'Confirm')]");

			} catch (ElementClickInterceptedException e) {
				Thread.sleep(2000);
				e.printStackTrace();
				WebElement A = QaBrowser.driver.findElement(By.xpath("//span[contains(text(),'Confirm')]"));
				JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
				js.executeScript("arguments[0].click()", A);

			}

			QaBrowser.driver.findElement(By.xpath(
					"//mat-label[contains(text(),'Expiry Date')]/../..//input[@formcontrolname=\"passportExpiry\"]"))
					.click();
			String[] DateSelection21 = ExpiryDate.split("-");
			String expDate21 = DateSelection21[0];// 20
			String month21 = DateSelection21[1];// AUG
			String year21 = DateSelection21[2];// 1991

			TripTypeSearchPage.selectDateInCalendarOneWay1(expDate21, month21, year21);
			Thread.sleep(200);
			try {
				GenericUtility.clickConfirmButton("//span[contains(text(),'Confirm')]");

			} catch (ElementClickInterceptedException e) {
				Thread.sleep(2000);
				e.printStackTrace();
				WebElement A = QaBrowser.driver.findElement(By.xpath("//span[contains(text(),'Confirm')]"));
				JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
				js.executeScript("arguments[0].click()", A);

			}

			break;
		case "IQAMA Number":
			WebElement IQamaNumber = QaBrowser.driver
					.findElement(By.xpath("//mat-label[contains(text(),'IQAMA Number')]/../..//input"));
			IQamaNumber.click();
			IQamaNumber.sendKeys("NMA1234567890123");

			QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'DOB')]/../..//input")).click();
			QaBrowser.driver.findElement(By.xpath("//div[text()=' 1990 – 2013 ']")).click();
			String[] DateSelection1221 = DateofBirth.split("-");
			String expDate1221 = DateSelection1221[0];// 20
			String month1221 = DateSelection1221[1];// AUG
			String year1221 = DateSelection1221[2];// 1991

			TripTypeSearchPage.selectDateInCalendarOneWay1(expDate1221, month1221, year1221);
			Thread.sleep(200);
			try {
				GenericUtility.clickConfirmButton("//span[contains(text(),'Confirm')]");

			} catch (ElementClickInterceptedException e) {
				Thread.sleep(2000);
				e.printStackTrace();
				WebElement A = QaBrowser.driver.findElement(By.xpath("//span[contains(text(),'Confirm')]"));
				JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
				js.executeScript("arguments[0].click()", A);

			}
			QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Issue Country')]/../..//input")).click();
			GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", IssuingCountry);
			QaBrowser.driver.findElement(By.xpath("//div[text()='Place of issue']/../..//input")).click();
			GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", issueplace);
			QaBrowser.driver.findElement(By.xpath("//mat-label[text()='Valid From']/../..//input")).click();

			QaBrowser.driver.findElement(By.xpath("//div[text()=' 1990 – 2013 ']")).click();
			String[] DateSelection1121 = Validtity.split("-");
			String expDate1121 = DateSelection1121[0];// 20
			String month1121 = DateSelection1121[1];// AUG
			String year1121 = DateSelection1121[2];// 1991

			TripTypeSearchPage.selectDateInCalendarOneWay1(expDate1121, month1121, year1121);
			Thread.sleep(200);
			try {
				GenericUtility.clickConfirmButton("//span[contains(text(),'Confirm')]");

			} catch (ElementClickInterceptedException e) {
				Thread.sleep(2000);
				e.printStackTrace();
				WebElement A = QaBrowser.driver.findElement(By.xpath("//span[contains(text(),'Confirm')]"));
				JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
				js.executeScript("arguments[0].click()", A);

			}

			QaBrowser.driver.findElement(By.xpath(
					"//mat-label[contains(text(),'Expiry Date')]/../..//input[@formcontrolname=\"passportExpiry\"]"))
					.click();
			String[] DateSelection2121 = ExpiryDate.split("-");
			String expDate2121 = DateSelection2121[0];// 20
			String month2121 = DateSelection2121[1];// AUG
			String year2121 = DateSelection2121[2];// 1991

			TripTypeSearchPage.selectDateInCalendarOneWay1(expDate2121, month2121, year2121);
			Thread.sleep(200);
			try {
				GenericUtility.clickConfirmButton("//span[contains(text(),'Confirm')]");

			} catch (ElementClickInterceptedException e) {
				Thread.sleep(2000);
				e.printStackTrace();
				WebElement A = QaBrowser.driver.findElement(By.xpath("//span[contains(text(),'Confirm')]"));
				JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
				js.executeScript("arguments[0].click()", A);

			}

			break;
		case "TSA":
			WebElement tsa = QaBrowser.driver.findElement(
					By.xpath("//mat-label[contains(text(),'TSA Precheck / Known Traveler number')]/../..//input"));
			tsa.click();
			tsa.sendKeys("TT98765432");
			break;

		case "Redress Number":
			WebElement redressnumber = QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'Redress number')]/../..//input"));
			redressnumber.click();
			redressnumber.sendKeys("987654321");

			break;

		}
		boolean aa = Boolean.parseBoolean(preference);
		while (aa) {
			QaBrowser.driver.findElement(By.xpath("(//h4[text()=' Preference ']/../../..//span)[3]")).click();
			QaBrowser.driver.findElement(By.xpath("//mat-label[text()='Longhaul Seat Preference']/../..//mat-select")).click();
			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span", selectlonghaulmealpreference);
			QaBrowser.driver.findElement(By.xpath("//mat-label[text()='Shorthaul Seat Preferences']/../..//mat-select")).click();
			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span", Shorthaulseatpreference);
			
			
			break;
		}
		switch (savecancildependent) {
		case "save":
			QaExtentReport.extentScreenshot("Added dependent");
			WebElement a = QaBrowser.driver
					.findElement(By.xpath("//span[contains(text(),'Save ')]/../..//button[2]/span[2]"));
			JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
			js.executeScript("arguments[0].click()", a);

			break;
		case "cancil":
			QaExtentReport.extentScreenshot("Added dependent");
			WebElement b = QaBrowser.driver
					.findElement(By.xpath("//span[contains(text(),'Cancel')]/../..//button[1]/span[2]"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			js1.executeScript("arguments[0].click()", b);
			break;

		}
	}
}
