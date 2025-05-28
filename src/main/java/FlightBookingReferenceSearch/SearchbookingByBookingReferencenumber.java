package FlightBookingReferenceSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class SearchbookingByBookingReferencenumber {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("saudia1", "LocalserverBooking");
	}

	@Test(dataProvider = "getexceldata")
	public static void bookingSearch(String TestCaseId, String TestScenario, String Module, String URL, String Employee,
			String TravelerType, String Username, String Password,String SearchBy,String NoOFExtra
, String BookingReference,String Lastname,String triptype) throws Throwable {
		
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);

		TestBase.Companycode(Module, URL);
		QaRobot.impliwait(30);
		QaRobot.clickOnDisableElement("SaudiyaLogInTab1");
		// QaRobot.ClickOnElement("SaudiyaLogInTab1");
		QaRobot.PassValue("emailAddress", Username);
		QaRobot.PassValue("password1", Password);

		Thread.sleep(2000);

//		WebElement capchaFrame = QaBrowser.driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
//
//		QaBrowser.driver.switchTo().frame(capchaFrame);
//
//		QaRobot.ClickOnElement("FrameCheckbox");
//		Thread.sleep(20000);
//
//		QaBrowser.driver.switchTo().defaultContent();

		QaExtentReport.extentScreenshot("Login Page");
		Thread.sleep(5000);

		QaRobot.clickOnDisableElement("SaudiyaLogInTab1");

		// Assuming 'driver' is your WebDriver instance
		JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;

		// Locate the element you want to scroll to
		WebElement element = QaBrowser.driver
				.findElement(By.xpath("//ul[@class='f-row ng-star-inserted']//span[text()=' Book & Manage ']"));
// Use JavaScript to scroll the element into view
		js.executeScript("arguments[0].scrollIntoView(false);", element);
		QaBrowser.driver.findElement(By.xpath("//ul[@class='f-row ng-star-inserted']//span[text()=' Book & Manage ']")).click();
		Thread.sleep(3000);
		QaExtentReport.test.log(Status.INFO, "<b><i>Employee Name is  </i></b>" + Employee);
		QaExtentReport.test.log(Status.INFO, "<b><i> Traveler Type is  </i></b>" + TravelerType);

		BookAndManagePage.bookAndManage(SearchBy,NoOFExtra, BookingReference,Lastname,triptype);
	}
	@AfterTest
	public static void After_Test() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}
}
