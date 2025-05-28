package addTraveler;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import flightbookingAssignTask.TripTypeSearchPage;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class AddTraveler {
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("AddTraveler2", "Sheet8");
	}

	@Test(dataProvider = "getexceldata")
	public static void flightBooking(String TestCaseId, String TCType, String TestScenario, String ccode, String URL,
			String Employee, String TravelerType, String Username, String Password, String Salutation1,
			String DateOfbirth, String FirstName, String LastName, String EmployeeCode, String Username1, String BRANCH,
			String UserType, String SavedEmailAddress, String PhoneNumber) throws Throwable {
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
		QaBrowser.driver.findElement(By.xpath("//span[@class=\"menu-label\"]")).click();
		Thread.sleep(500);
		QaBrowser.driver.findElement(By.xpath("(//li[@class=\"ng-star-inserted\"]/a)[4]")).click();
		// span[text()=' Add new traveler ']
		QaExtentReport.extentScreenshot("Add Traveler");
		Thread.sleep(700);
		WebElement addTraveler = QaBrowser.driver.findElement(By.xpath("//span[text()=' Add new traveler ']"));
		JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
		js3.executeScript("arguments[0].click()", addTraveler);
		Thread.sleep(2000);

		QaBrowser.driver.findElement(By.xpath("//div[@id='mat-select-value-3']")).click();
		Thread.sleep(2000);
		List<WebElement> natureOfSalutataion = QaBrowser.driver
				.findElements(By.xpath("//div[@id=\"cdk-overlay-0\"]//mat-option/span"));
		Thread.sleep(1000);
		for (WebElement Salutation : natureOfSalutataion) {

			String business = Salutation.getText();

			if (business.equalsIgnoreCase(Salutation1)) {
				Salutation.click();
				break;
			}
		}
		Thread.sleep(200);
		QaRobot.PassValue("SFirstName", FirstName);
		Thread.sleep(200);
		QaRobot.PassValue("SLastName", LastName);
		Thread.sleep(200);
		QaRobot.ClickOnElement("SMaleRadioButton");
		Thread.sleep(200);
		QaRobot.ClickOnElement("SDateOfBirth");

		QaBrowser.driver.findElement(By.xpath("//div[@class=\"year-range year-cell\"]")).click();
		String[] DateSelection = DateOfbirth.split("-");
		String expDate = DateSelection[0];// 20
		String month = DateSelection[1];// AUG
		String year = DateSelection[2];// 1991

		TripTypeSearchPage.selectDateInCalendarOneWay1(expDate, month, year);
		Thread.sleep(200);
		WebElement confirmButton = QaBrowser.driver.findElement(By.xpath("//span[text()='Confirm']"));
		JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
		js5.executeScript("arguments[0].click()", confirmButton);
		Thread.sleep(200);
		QaRobot.PassValue2("SemployeeCode", EmployeeCode);
		Thread.sleep(200);
		QaRobot.PassValue("SUserName", Username1);
		Thread.sleep(200);
		QaBrowser.driver.findElement(By.xpath("(//div[contains(@id,'mat-select-value-')])[2]")).click();

		List<WebElement> listOfBranch = QaBrowser.driver
				.findElements(By.xpath("//div[@id=\"cdk-overlay-1\"]//mat-option/span"));
		Thread.sleep(1000);
		for (WebElement Branch : listOfBranch) {

			String business = Branch.getText();
			System.out.println(business);

			if (business.equalsIgnoreCase(BRANCH)) {
				Branch.click();
				break;
			}
		}

		switch (UserType) {
		case "Administrator":
			QaBrowser.driver.findElement(By.xpath("//input[contains(@id,'mat-radio-') and @value='0']")).click();
			QaExtentReport.extentScreenshot("Traveler Management page");
			QaRobot.PassValue("SsavedEmailAddress", SavedEmailAddress);
			QaRobot.PassValue("SphoneNumber", PhoneNumber);
			QaBrowser.driver
					.findElement(
							By.xpath("//input[@id=\"mat-mdc-checkbox-4-input\"]/../..//div[@class=\"mdc-checkbox\"]"))
					.click();
			Thread.sleep(600);

			QaBrowser.driver
					.findElement(
							By.xpath("//input[@id=\"mat-mdc-checkbox-5-input\"]/../..//div[@class=\"mdc-checkbox\"]"))
					.click();
			Thread.sleep(600);


			QaBrowser.driver
					.findElement(
							By.xpath("//input[@id=\"mat-mdc-checkbox-6-input\"]/../..//div[@class=\"mdc-checkbox\"]"))
					.click();
			Thread.sleep(600);
			WebElement saveButton = QaBrowser.driver.findElement(By.xpath("//span[text()=' Save']"));
			JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
			js4.executeScript("arguments[0].click()", saveButton);
			// span[text()=' Save']
			QaExtentReport.extentScreenshot("Add new traveler page");
			break;
		case "TravelArranger":
			QaBrowser.driver.findElement(By.xpath("//input[contains(@id,'mat-radio-') and @value='1']")).click();
			QaExtentReport.extentScreenshot("Traveler Management page");
			QaRobot.PassValue("SsavedEmailAddress", SavedEmailAddress);
			QaRobot.PassValue("SphoneNumber", PhoneNumber);
			QaBrowser.driver
					.findElement(
							By.xpath("//input[@id=\"mat-mdc-checkbox-4-input\"]/../..//div[@class=\"mdc-checkbox\"]"))
					.click();
			Thread.sleep(1000);

			QaBrowser.driver
					.findElement(
							By.xpath("//input[@id=\"mat-mdc-checkbox-5-input\"]/../..//div[@class=\"mdc-checkbox\"]"))
					.click();
			Thread.sleep(1000);

			QaBrowser.driver
					.findElement(
							By.xpath("//input[@id=\"mat-mdc-checkbox-6-input\"]/../..//div[@class=\"mdc-checkbox\"]"))
					.click();
			Thread.sleep(1000);
			WebElement saveButton1 = QaBrowser.driver.findElement(By.xpath("//span[text()=' Save']"));
			JavascriptExecutor js6 = (JavascriptExecutor) QaBrowser.driver;
			js6.executeScript("arguments[0].click()", saveButton1);
			// span[text()=' Save']
			QaExtentReport.extentScreenshot("Add new traveler page");
			break;
		case "Employee":
			QaExtentReport.extentScreenshot("Traveler Management page");
			QaRobot.PassValue("SsavedEmailAddress", SavedEmailAddress);
			QaRobot.PassValue("SphoneNumber", PhoneNumber);
			QaBrowser.driver.findElement(By.xpath("//input[contains(@id,'mat-radio-') and @value='2']")).click();
			Thread.sleep(500);
			QaBrowser.driver.findElement(By.xpath("(//div[@class=\"mdc-checkbox\"])[1]")).click();

			Thread.sleep(500);
			QaBrowser.driver.findElement(By.xpath("(//div[@class=\"mdc-checkbox\"])[8]")).click();

			Thread.sleep(500);
			QaBrowser.driver.findElement(By.xpath("(//div[@class=\"mdc-checkbox\"])[9]")).click();

			Thread.sleep(500);
			QaBrowser.driver.findElement(By.xpath("(//div[@class=\"mdc-checkbox\"])[10]")).click();

			Thread.sleep(1000);
			WebElement saveButton2 = QaBrowser.driver.findElement(By.xpath("//span[text()=' Save']"));
			JavascriptExecutor js7 = (JavascriptExecutor) QaBrowser.driver;
			js7.executeScript("arguments[0].click()", saveButton2);
			break;

		}

	}
	@AfterTest
	public static void After_Test() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}
}
