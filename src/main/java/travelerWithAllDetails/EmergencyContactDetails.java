package travelerWithAllDetails;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import addTraveler.GenericUtility;
import utilities.QaBrowser;

public class EmergencyContactDetails {
	public static void emergencyContactDetails(String countrycode,String emergencysave) throws Throwable {
		QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Emergency contact details')]")).click();
		QaBrowser.driver.findElement(By.xpath("//mat-icon[contains(text(),'edit')]")).click();
		WebElement contactTextField = QaBrowser.driver
				.findElement(By.xpath("//input[@formcontrolname=\"contactName\"]"));
		contactTextField.click();
		Thread.sleep(1500);
		contactTextField.clear();
		contactTextField.sendKeys("Balkrishna");
		Thread.sleep(1000);
		WebElement relationwithuser = QaBrowser.driver
				.findElement(By.xpath("//input[@formcontrolname=\"relationWithUser\"]"));
		relationwithuser.click();
		Thread.sleep(1500);
		relationwithuser.clear();
		relationwithuser.sendKeys("friend");
		Thread.sleep(2000);
		QaBrowser.driver
				.findElement(By
						.xpath("//mat-label[contains(text(),'Emergency Phone Number Country Code')]/../..//mat-select"))
				.click();
		GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span", countrycode);
		WebElement emergencyPhonenumber = QaBrowser.driver
				.findElement(By.xpath("//input[@formcontrolname=\"emergencyPhoneNumber\"]"));
		emergencyPhonenumber.click();
		Thread.sleep(1500);
		emergencyPhonenumber.clear();
		emergencyPhonenumber.sendKeys("9876543210");
		Thread.sleep(2000);
		QaBrowser.driver
				.findElement(By.xpath(
						"//mat-label[contains(text(),'Alt. Emergency Phone Number Country...')]/../..//mat-select"))
				.click();
		Thread.sleep(2000);
		GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span", countrycode);
		WebElement altemer = QaBrowser.driver.findElement(By.xpath("//input[@formcontrolname=\"altEmergencyPhoneNumber\"]"));
		altemer.click();
		Thread.sleep(1500);
		altemer.clear();
		Thread.sleep(1500);
		altemer.sendKeys("9191585632");
		switch (emergencysave) {
		case "save":
			WebElement save = QaBrowser.driver.findElement(By.xpath("//span[text()=' Save']"));
			JavascriptExecutor js121 = (JavascriptExecutor) QaBrowser.driver;
			js121.executeScript("arguments[0].click()", save);
			break;
		case "cancil":
			WebElement cancil = QaBrowser.driver.findElement(By.xpath("//span[text()='Cancel']"));
			JavascriptExecutor js1211 = (JavascriptExecutor) QaBrowser.driver;
			js1211.executeScript("arguments[0].click()", cancil);
			break;
		
		}
		
		
	}
}
