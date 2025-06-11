package travelerWithAllDetails;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import addTraveler.GenericUtility;
import flightbookingAssignTask.TripTypeSearchPage;
import utilities.QaBrowser;

public class DocumentInformation {

	public static void documentInformation(String Country,String documentList,String DateofBirth,String IssuingCountry,String Validtity,
			String ExpiryDate,String moveToNextdetails ) throws Throwable {
		Thread.sleep(1000);
		QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Document Information')]")).click();
		QaBrowser.driver.findElement(By.xpath("//mat-icon[contains(text(),'add')]")).click();
		QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"countryControl0\"]")).click();
		List<WebElement> nationality_List = QaBrowser.driver
				.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
		Thread.sleep(500);
		System.out.println(nationality_List.size());
		
	for(WebElement national:nationality_List) {
		String nationlist=national.getText();
		System.out.println(nationlist);
		if(nationlist.equalsIgnoreCase(Country)) {
			national.click();
			break;
		}
	}
		QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'Document type')]/../..//mat-select")).click();
		//div[contains(@id,'cdk-overlay-')]//mat-option/span
		List<WebElement> document_List = QaBrowser.driver
				.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
		Thread.sleep(500);
		System.out.println(document_List.size());
		
	for(WebElement documentlist : document_List) {
		String docu=documentlist.getText();
		System.out.println(docu);
		if(docu.equalsIgnoreCase(documentList)) {
			documentlist.click();
			break;
		}
	}
	WebElement Passport = QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"Passportno\"]"));
	Passport.click();
	Passport.sendKeys("N987654321");
	QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'DOB')]/ancestor::div[@class=\"f-col\"]//mat-icon")).click();
	QaBrowser.driver.findElement(By.xpath("//div[contains(text(),' 1990 – 2013 ')]")).click();
	String[] DateSelection = DateofBirth.split("-");
	String expDate = DateSelection[0];// 20
	String month = DateSelection[1];// AUG
	String year = DateSelection[2];// 1991

	TripTypeSearchPage.selectDateInCalendarOneWay1(expDate, month, year);
	Thread.sleep(200);
	try {
	GenericUtility.clickConfirmButton("//span[contains(text(),'Confirm')]");

	}catch(ElementClickInterceptedException e) {
		Thread.sleep(2000);
		e.printStackTrace();
		WebElement A = QaBrowser.driver.findElement(By.xpath("//span[contains(text(),'Confirm')]"));
		JavascriptExecutor js =(JavascriptExecutor)QaBrowser.driver;
		js.executeScript("arguments[0].click()", A);
		
	}
	QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"nationalityOptions\"]")).click();
	List<WebElement> issuing_Country = QaBrowser.driver.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
	 for(int i=1;i<=issuing_Country.size()-1;i++) {
	String icountry=	 issuing_Country.get(i).getText();
	System.out.println(icountry);
	if(icountry.equalsIgnoreCase(IssuingCountry)) {
		Thread.sleep(2000);
		issuing_Country.get(i).click();
		break;
	}
	
	 }
	WebElement part = QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'Place of Issue')]/../..//input"));
	JavascriptExecutor js =(JavascriptExecutor)QaBrowser.driver;
	js.executeScript("arguments[0].click()",part);
	part.click();
	part.sendKeys("Delhi");
	List<WebElement> part_Of_Issue = QaBrowser.driver.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
	
	for(WebElement partofissue:part_Of_Issue) {
		String partissue=partofissue.getText();
		System.out.println(partissue);
		Thread.sleep(1000);
		if(partissue.equalsIgnoreCase("Delhi")) {
			Thread.sleep(1500);
			GenericUtility.clickConfirmButton("//div[contains(@id,'cdk-overlay-')]//mat-option/span");
	//		partofissue.click();
			break;
		}
	}
	 QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'Valid from ')]/../..//input")).click();
	 QaBrowser.driver.findElement(By.xpath("//div[contains(text(),' 1990 – 2013 ')]")).click();
	 String[] DateSelection1 = Validtity.split("-");
		String expDate1 = DateSelection1[0];// 20
		String month1 = DateSelection1[1];// AUG
		String year1 = DateSelection1[2];// 1991

		TripTypeSearchPage.selectDateInCalendarOneWay1(expDate1, month1, year1);
		Thread.sleep(200);
		try {
			GenericUtility.clickConfirmButton("//span[contains(text(),'Confirm')]");

		}catch(ElementClickInterceptedException e) {
			Thread.sleep(2000);
			e.printStackTrace();
			WebElement A = QaBrowser.driver.findElement(By.xpath("//span[contains(text(),'Confirm')]"));
			JavascriptExecutor js1 =(JavascriptExecutor)QaBrowser.driver;
			js1.executeScript("arguments[0].click()", A);
			
		}
		//span[contains(text(),'Confirm')]
		QaBrowser.driver.findElement(By.xpath("//mat-label[text()='Expiry Date']/../..//input")).click();
		 String[] DateSelection2 = ExpiryDate.split("-");
		String expDate2 = DateSelection2[0];// 20
		String month2 = DateSelection2[1];// AUG
		String year2 = DateSelection2[2];// 2029

		TripTypeSearchPage.selectDateInCalendarOneWay1(expDate2, month2, year2);
		Thread.sleep(200);
		try {
			GenericUtility.clickConfirmButton("//span[contains(text(),'Confirm')]");
		} catch (Exception e) {
			WebElement B = QaBrowser.driver.findElement(By.xpath("//span[contains(text(),'Confirm')]"));
			JavascriptExecutor js1 =(JavascriptExecutor)QaBrowser.driver;
			js1.executeScript("arguments[0].click()", B);
		}
		
		switch (moveToNextdetails) {
		case "save":
			QaBrowser.driver.findElement(By.xpath("//div[@class=\"inner-action ng-star-inserted\"]/button[2]")).click();
			break;
		case "cancil":
			QaBrowser.driver.findElement(By.xpath("//div[@class=\"inner-action ng-star-inserted\"]/button[1]")).click();
			break;
	}
	

	}
}
