package resister_Corporate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.TestBase;
import flightbookingAssignTask.TripTypeSearchPage;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class ResisterFromSBT {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("CorporateRegistration", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void flightBooking(String TestCaseId, String TCType, String TestScenario, String ccode, String URL,
			String CompanyName, String NOBusiness, String NOEmp, String RegId, String ContryCode, String CountryName,
			String CityCode, String CityName, String HOAddress, String CompanyURL, String AnnualBudget,
			String DateOfbirth, String NationalId, String Employeecode, String TravellerName, String JobTitle,
			String BEmail, String PCode, String Phonenumber, String Password) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + " - " + TCType + " - " + TestScenario);
		TestBase.Companycode(ccode, URL);
		WebElement registerButton = QaBrowser.driver.findElement(By.xpath("//span[text()='Register Now ']"));
		Thread.sleep(3000);
		JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
		js2.executeScript("arguments[0].click()", registerButton);
		Thread.sleep(3000);
		WebElement continueregisterButton = QaBrowser.driver
				.findElement(By.xpath("//span[text()='Continue to Registration ']"));
		JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
		js3.executeScript("arguments[0].click()", continueregisterButton);

		QaRobot.impliwait(30);
		QaRobot.PassValue("SCompanyName", CompanyName);
		QaRobot.ClickOnElement("SNatureOfBusiness");
		List<WebElement> natureOfBusiness = QaBrowser.driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div/span"));
		for (WebElement natOfBusiness : natureOfBusiness) {
			String business = natOfBusiness.getText();
			if (business.equalsIgnoreCase(NOBusiness)) {
				natOfBusiness.click();
				break;
			}
		}

		QaRobot.ClickOnElement("SNoOFEmp");
		List<WebElement> noOfEmployee = QaBrowser.driver
				.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
		for (WebElement natOfEmployee : noOfEmployee) {
			String employeenNo = natOfEmployee.getText();
			System.out.println(employeenNo);
			if (employeenNo.equalsIgnoreCase(NOEmp)) {
				natOfEmployee.click();
				break;
			}
		}

		QaRobot.PassValue("SRegId", RegId);
		QaBrowser.driver.findElement(By.xpath("(//div[@class='ng-input']/input)[2]")).click();

		List<WebElement> Country = QaBrowser.driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div/span"));
		for (WebElement selectedCountry : Country) {
			String scountry = selectedCountry.getText();
			System.out.println(scountry);
			if (scountry.equalsIgnoreCase(CountryName)) {
				selectedCountry.click();
				break;
			}
		}

		QaBrowser.driver.findElement(By.xpath("(//div[@class='ng-input']/input)[3]")).click();
		Thread.sleep(2000);
		List<WebElement> City = QaBrowser.driver
				.findElements(By.xpath("//ng-dropdown-panel[starts-with(@id,'a')]//span"));
		Thread.sleep(1000);
		for (WebElement selectedCity : City) {

			String scity = selectedCity.getText();
			System.out.println(scity);
			Thread.sleep(1000);
			if (scity.equalsIgnoreCase(CityName)) {

				selectedCity.click();
				break;
			}
		}
		// ng-dropdown-panel[@class='ng-dropdown-panel ng-star-inserted
		// ng-select-bottom']//div/span
		WebElement A = QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname='PostalCode']"));
		A.click();
		A.sendKeys("122018");

		QaRobot.PassValue("SHeadOfficeAddress", HOAddress);
		// QaRobot.PassValue("SCompanyURL", CompanyURL);
		QaBrowser.driver.findElement(By.xpath("// div[@id=\"mat-select-value-5\"]")).click();

		// aRobot.PassValue("SAnnualBudget", AnnualBudget);

		List<WebElement> B = QaBrowser.driver.findElements(By.xpath("//div[@id=\"cdk-overlay-1\"]//mat-option/span"));
		for (WebElement C : B) {

			String d = C.getText();
			System.out.println(d);
			if (d.equalsIgnoreCase(AnnualBudget)) {
				C.click();
				break;
			}
		}

		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Corporate information");

		WebElement registerButton1 = QaBrowser.driver.findElement(By.xpath("//span[text()=' Save & continue ']"));

		JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
		js4.executeScript("arguments[0].click()", registerButton1);

		Thread.sleep(2000);
		QaBrowser.driver.findElement(By.xpath("//div[@class=\"ng-input\"]/input")).click();

		List<WebElement> Country1 = QaBrowser.driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div/span"));
		for (WebElement selectedCountry1 : Country1) {
			String scountry1 = selectedCountry1.getText();
			System.out.println(scountry1);
			if (scountry1.equalsIgnoreCase(CountryName)) {
				selectedCountry1.click();
				break;
			}
		}

		QaRobot.PassValue1("SnationalId", NationalId);
		QaBrowser.driver.findElement(By.xpath("(//div[contains(@class,'mat-mdc-form-field-icon-suffix ng-tns-')])[1]"))
				.click();
		QaBrowser.driver.findElement(By.xpath("//div[@class=\"year-range year-cell\"]")).click();
		String[] DateSelection = DateOfbirth.split("-");
		String expDate = DateSelection[0];// 20
		String month = DateSelection[1];// AUG
		String year = DateSelection[2];// 1991

		TripTypeSearchPage.selectDateInCalendarOneWay1(expDate, month, year);
		WebElement confirmButton = QaBrowser.driver.findElement(By.xpath("//span[text()='Confirm']"));

		JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
		js5.executeScript("arguments[0].click()", confirmButton);

		String EmployeeName[] = TravellerName.split(" ");
		String FNTitle = EmployeeName[0];
		String FN = EmployeeName[1];
		String LN = EmployeeName[2];
//		QaRobot.selectTextByLocator("//select[@id='tittle']", FNTitle);
		TestBase.listofTitle(By.xpath("//div[@id=\"cdk-overlay-2\"]//mat-option/span"), FNTitle,
				By.xpath("//div[@id='mat-select-value-1']/span"));
		QaRobot.PassValue("STravelexpFN", FN);
		QaRobot.PassValue("STravelexpLN", LN);
		QaRobot.PassValue("SJobTitle", JobTitle);
		QaRobot.PassValue("Sempcode", Employeecode);
		QaRobot.PassValue("SBusinessEmail", BEmail);

		TestBase.listofautosuggestion(By.xpath("//div[@id=\"cdk-overlay-3\"]//mat-option/span/div/span"), ContryCode,
				PCode, By.xpath("//input[@formcontrolname=\"stateGroup\"]"));
		QaRobot.PassValue("Sphoneno", Phonenumber);
		QaRobot.PassValue("snewpassword", Password);
		QaRobot.PassValue("sconfirmpassword", Password);

		QaRobot.ClickOnElement("SCheckBox1");
		WebElement continueButton2 = QaBrowser.driver.findElement(By.xpath("//span[text()=' Save & continue ']"));

		JavascriptExecutor js6 = (JavascriptExecutor) QaBrowser.driver;
		js6.executeScript("arguments[0].click()", continueButton2);

		// span[text()=' Save & continue ']
//		QaRobot.ClickOnElement("SCheckBox2");
		QaRobot.ClickOnElement("SCheckBox3");
		QaExtentReport.extentScreenshot("Travel administrator information");
		Thread.sleep(2000);

		WebElement joinbutton = QaBrowser.driver.findElement(By.xpath("//span[text()=' Join Now ']"));

		JavascriptExecutor js7 = (JavascriptExecutor) QaBrowser.driver;
		js7.executeScript("arguments[0].click()", joinbutton);

		Thread.sleep(8000);

		QaBrowser.driver.findElement(By.xpath("//span[text()=' Verify ']")).click();

		// span[text()=' Join Now ']
		// QaRobot.ClickOnElement("STravelAdministratorJoin");
	}

	@AfterTest
	public static void After_Test() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}
}
