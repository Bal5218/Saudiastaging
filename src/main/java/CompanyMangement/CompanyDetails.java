package CompanyMangement;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import addTraveler.GenericUtility;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class CompanyDetails {
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("EditCompanyDetails", "Sheet2");
	}

	@Test(dataProvider = "getexceldata")
	public static void editCompanyDetails(String TestCaseId, String TCType, String TestScenario, String ccode,
			String URL, String Employee, String TravelerType, String Username, String Password, String NatureOfBusiness,
			String Counrty, String City, String Language, String Nemployee, String countrycode,
			String AnnualTravelBudget, String reference, String Changes, String DevisionDetails, String STATUS,
			String DsavCancil, String Division, String CancilConfirm, String DivisionName, String BranchName,
			String BranchCode, String Country, String Bsavecancil, String EditBranchName, String EditBranchcode,
			String PhoneNumber,String CostCenterName,String costcentercode,String Scostsavcancil,String CostCenterNamea
			,String costcentercodea) throws Throwable {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + " - " + TCType + " - " + TestScenario);
		TestBase.Companycode(ccode, URL);
		Thread.sleep(100);
		QaRobot.impliwait(30);
		WebElement SaudiyaLogInTab = QaBrowser.driver.findElement(By.xpath("//span[text()='Login ']"));
		JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
		js2.executeScript("arguments[0].click()", SaudiyaLogInTab);
//		QaRobot.ClickOnElement("SaudiyaLogInTab");
		Thread.sleep(2000);
		QaRobot.PassValue("EmailAdd", Username);
		QaRobot.PassValue("Password", Password);
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Login Page");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("ClickOnlogin");
		Thread.sleep(2000);
		QaExtentReport.test.log(Status.INFO, "<b><i>Employee Name is  </i></b>" + Employee);
		QaExtentReport.test.log(Status.INFO, "<b><i> Traveler Type is  </i></b>" + TravelerType);
		Thread.sleep(500);
		// QaBrowser.driver.findElement(By.xpath("//span[@class=\"menu-label\"]")).click();
		// Thread.sleep(500);
		// QaBrowser.driver.findElement(By.xpath("(//li[@class=\"ng-star-inserted\"]/a)[4]")).click();

		QaExtentReport.extentScreenshot("Add Traveler");
		Thread.sleep(700);
		/**
		 * this is for company details information needs to be edit.
		 * 
		 */
		QaBrowser.driver.findElement(By.xpath("//span[text()='BARBARIQUE']")).click();
		Thread.sleep(500);
		QaBrowser.driver.findElement(By.xpath("//a[text()='Company management']")).click();
		Thread.sleep(500);
//		QaBrowser.driver.findElement(By.xpath("//mat-icon[text()='edit']")).click();
//		Thread.sleep(2000);
//		GenericUtility.clickConfirmButtonwithpassingvalue("//mat-label[text()='Company Name']/../..//input",
//				"Barbarique");
//
//		Thread.sleep(2000);
//		GenericUtility.clickConfirmButton("//mat-label[text()='Nature of Business']/../..//mat-select");
//		try {
//			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span",
//					NatureOfBusiness);
//		} catch (ElementClickInterceptedException e) {
//			e.printStackTrace();
//			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span",
//					NatureOfBusiness);
//		}
//		WebElement companyRegistrationid = QaBrowser.driver
//				.findElement(By.xpath("//mat-label[text()='Company Registration ID']/../..//input"));
//		companyRegistrationid.click();
//		companyRegistrationid.clear();
//		companyRegistrationid.sendKeys("9876543210");
//		GenericUtility.clickConfirmButton("//div[text()='Country/Region']/../..//input");
//
//		try {
//			GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div//span", Counrty);
//		} catch (ElementClickInterceptedException e) {
//			e.printStackTrace();
//			GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div//span", Counrty);
//		}
//		GenericUtility.clickConfirmButton("//div[text()='City']/../..//input");
//		Thread.sleep(1000);
//		try {
//			GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", City);
//		} catch (ElementClickInterceptedException e) {
//			e.printStackTrace();
//			GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", City);
//		}
//		GenericUtility.clickConfirmButtonwithpassingvalue("//mat-label[text()='Postal Code']/../..//input", "122008");
//
//		GenericUtility.clickConfirmButton("//mat-label[text()='Language']/../..//mat-select");
//		try {
//			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span", Language);
//		} catch (ElementClickInterceptedException e) {
//			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span", Language);
//		}
//		try {
//			GenericUtility.clickConfirmButtonwithpassingvalue("//mat-label[text()='Head Office Address']/../../input",
//					"Delhi");
//		} catch (ElementClickInterceptedException e) {
//			GenericUtility.clickConfirmButtonwithpassingvalue("//mat-label[text()='Head Office Address']/../../input",
//					"Delhi");
//		}
//		GenericUtility.clickConfirmButtonwithpassingvalue(
//				"//mat-label[text()='Company Email Address (Optional)']/../../input", "testengineer@yopmail.com");
//		GenericUtility.clickConfirmButton("//mat-label[text()='Number of Employee']/../..//mat-select");
//		// mat-label[text()='Number of Employee']/../..//mat-select
//		try {
//			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span",
//					Nemployee);
//		} catch (ElementClickInterceptedException e) {
//			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span",
//					Nemployee);
//		}
//		GenericUtility.clickConfirmButton("//div[text()='Country Code']/../..//div[@class=\"ng-input\"]");
//		// ng-dropdown-panel//div/span
//		try {
//			GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", countrycode);
//		} catch (ElementClickInterceptedException e) {
//			GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", countrycode);
//		}
//		Thread.sleep(2500);
//		GenericUtility.clickConfirmButtonwithpassingvalue("//mat-label[text()='Company Code']/../..//input",
//				"DAS76542");
//
//		GenericUtility.clickConfirmButton(
//				"//mat-label[text()='Annual International Travel Budget on Saudia (SAR)']/../..//mat-select");
//		try {
//			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span",
//					AnnualTravelBudget);
//
//		} catch (ElementClickInterceptedException e) {
//			GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span",
//					AnnualTravelBudget);
//		}
//		boolean Ref = Boolean.parseBoolean(reference);
//		while (Ref) {
//			QaBrowser.driver.findElement(By.xpath("//h4[text()='References ']")).click();
//
//			break;
//		}
//
//		switch (Changes) {
//		case "SaveChanges":
//
//			WebElement B = QaBrowser.driver.findElement(
//					By.xpath("//span[text()=' Save changes']/..//span[@class=\"mat-mdc-focus-indicator\"]"));
//			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
//			js1.executeScript("arguments[0].click()", B);
//
//			break;
//		case "Cancil":
//			WebElement A = QaBrowser.driver
//					.findElement(By.xpath("//span[text()='Cancel']/..//span[@class=\"mat-mdc-button-touch-target\"]"));
//			JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
//			js.executeScript("arguments[0].click()", A);
//
//			break;
//
//		}

		/**
		 * this is for Division details needs to be changed.
		 * 
		 */
		// DivisionDetails.divisionDetails(DevisionDetails, STATUS, DsavCancil,
		// Division, CancilConfirm,DivisionName);
		/**
		 * there is need to edit ,delete and add branch information
		 */
	//	BasicInformation.basicInformation(DevisionDetails, STATUS, Division, CancilConfirm, BranchName, BranchCode,
	//			Country, City, Bsavecancil, EditBranchName, EditBranchcode, PhoneNumber);
		/**
		 * costCentreOverview
		 */
		CostCentreOverview.costCentreOverview( DevisionDetails, STATUS,CancilConfirm, BranchName, CostCenterName, costcentercode,Scostsavcancil,CostCenterNamea,costcentercodea);

	}
//	@AfterTest
//	public static void After_Test() {
//		QaExtentReport.test.getExtent().flush();
////		QaBrowser.driver.close();
//	}
}
