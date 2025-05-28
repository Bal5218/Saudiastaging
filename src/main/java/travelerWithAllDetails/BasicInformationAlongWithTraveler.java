package travelerWithAllDetails;

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
public class BasicInformationAlongWithTraveler {
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("AddBasicInformation", "Sheet1");
	}
	@Test(dataProvider = "getexceldata")
	public static void addBsicInformation(String TestCaseId, String TCType, String TestScenario, String ccode, String URL,
			String Employee,String TravelerType, String Username, String Password) throws Throwable {
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
		
		QaExtentReport.extentScreenshot("Add Traveler");
		Thread.sleep(700);
		 WebElement searchField = QaBrowser.driver.findElement(By.xpath("//input[@name=\"search\"]"));
		 searchField.click();
		 searchField.sendKeys("rohit");
		 QaBrowser.driver.findElement(By.xpath("//mat-icon[@class=\"mat-icon notranslate"
		 		+ " search-icon material-symbols-outlined mat-icon-no-color\"]")).click();
		 String username=QaBrowser.driver.findElement(By.xpath("//table//tr/td[2]")).getText();
		
		if(Username.equalsIgnoreCase(username)) {
			QaBrowser.driver.findElement(By.xpath("//table//tr/td[1]")).click();
		}
		QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Personal information')]")).click();
		//mat-icon[contains(text(),'edit')]
		QaBrowser.driver.findElement(By.xpath("//mat-icon[contains(text(),'edit')]")).click();
		
		
		
		
	}
//	@AfterTest
//	public static void After_Test() {
//		QaExtentReport.test.getExtent().flush();
////		QaBrowser.driver.close();
//	}
}
