package travelerWithAllDetails;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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
		return QaDataProvider.getTestdata("AddBasicInformation", "Sheet2");
	}

	@Test(dataProvider = "getexceldata")
	public static void addBsicInformation(String TestCaseId, String TCType, String TestScenario, String ccode,
			String URL, String Employee, String TravelerType, String Username, String Password, String Country,
			String documentList, String DateofBirth, String IssuingCountry, String Validtity, String ExpiryDate,
			String moveToNextdetails, String Department, String Employeegrade, String Designation, String Division,
			String BusinessUnit, String CostCentre, String project, String employsavecancil, String CardOption,
			String cardtype, String expiryMonth, String expiryYear, String card, String savecards, String preferences,
			String selectlonghaulmealpreference, String stop, String maxLayover, String classprefere,
			String preferredonline, String otherpre, String loyalityExpirtdate, String savecancilpre,
			String countrycode, String emergencysave, String Salutation, String FirstName, String LastName,
			String Gender, String Relation, String Email, String Countrycode, String Nationality, String Documenttype,
			String issueplace, String savecancildependent,String travelArranger,String preference,String Shorthaulseatpreference
			,String preferedLoyality,String Airline

	) throws Throwable {
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
		String username = QaBrowser.driver.findElement(By.xpath("//table//tr/td[2]")).getText();

		if (Username.equalsIgnoreCase(username)) {
			Thread.sleep(1000);
			QaBrowser.driver.findElement(By.xpath("//table//tr/td[1]")).click();
		}

		/**
		 * this class is used to edit the basic details of traveler.
		 * 
		 */
//		QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Personal information')]")).click();
//		QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Contact details')]")).click();
//		QaBrowser.driver.findElement(By.xpath("//mat-icon[contains(text(),'edit')]")).click();
//		QaRobot.PassValue3("SphoneNumber2", "9876543210");
//		QaRobot.PassValue3("SHomeaddress", "GMD MEGAPOLISH");
//		QaBrowser.ClickOnElement("ScountryRegion");
//		try {
//			
//			List<WebElement> country_List = QaBrowser.driver
//					.findElements(By.xpath("//div[@id='cdk-overlay-0']//mat-option//span"));
//			for (WebElement countrylist : country_List) {
//				Thread.sleep(500);
//
//				String country = countrylist.getText();
//				Thread.sleep(500);
//				System.out.println(country);
//				if (country.equalsIgnoreCase(Country)) {
//					countrylist.click();
//					break;
//				}
//			}
//		} catch (StaleElementReferenceException e) {
//			e.printStackTrace();
//		}
//		QaBrowser.ClickOnElement("ScountryCity");
//		WebElement city = QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"city\"]"));
//		city.clear();
//		city.sendKeys("Delhi");
//		city.sendKeys(Keys.ENTER);
//		WebElement postalcode = QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"PostalCode\"]"));
//		postalcode.sendKeys("122008");
//		
		/**
		 * this document information interface is used to edit the document information
		 * details of traveler.
		 * 
		 */
		// DocumentInformation.documentInformation(Country,
		// documentList,DateofBirth,IssuingCountry,Validtity,ExpiryDate,moveToNextdetails);
		/**
		 * this employment details page is used to edit the employment information of
		 * traveler against corporate.
		 * 
		 */
		// EmploymentDetailPage.employmentDetailPage(Department,Employeegrade,Designation,Division,BusinessUnit,CostCentre,project,employsavecancil);
		/**
		 * 
		 */
//		SaveCardPage.saveCardDetails(CardOption,cardtype,expiryMonth,expiryYear,card,savecards);
		/**
		 * Here, we set the preference of traveling which is for domestic and
		 * international.
		 */
		// Preferences.preferences(preferences,selectlonghaulmealpreference,stop,maxLayover,classprefere,preferredonline,otherpre,loyalityExpirtdate,savecancilpre);
		/**
		 * 
		 * 
		 */
		// EmergencyContactDetails.emergencyContactDetails(countrycode,emergencysave);
		/**
		 * //div[contains(text(),'Saved dependents')] here , we are going to save
		 * dependent
		 */
		SaveDependent.savedependent(DateofBirth, IssuingCountry, Validtity, ExpiryDate,stop,maxLayover,classprefere,preferredonline, Salutation, FirstName, LastName,
				Gender, Relation, Email, Countrycode, Nationality, Documenttype,

			issueplace, savecancildependent,preference,selectlonghaulmealpreference,Shorthaulseatpreference,preferedLoyality,Airline);
		/**
		 * manager and deligation setting.
		 * 
		 */
	//	ManagerAndDelegationSetting.manageranddelegationsetting(travelArranger,savecancildependent);
	}

	@AfterTest
	public static void After_Test() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}

}
