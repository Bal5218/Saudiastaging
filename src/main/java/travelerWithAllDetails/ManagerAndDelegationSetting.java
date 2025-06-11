package travelerWithAllDetails;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import addTraveler.GenericUtility;
import utilities.QaBrowser;
import utilities.QaExtentReport;

public class ManagerAndDelegationSetting {

	public static void manageranddelegationsetting(String travelArranger,String savecancildependent) throws Throwable {
		QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Manager & delegation settings')]")).click();
		QaBrowser.driver.findElement(By.xpath("//div[text()='Reporting manager & traveler arranger']")).click();
		WebElement managernametextfield = QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'Manager Name')]/../..//input"));
		managernametextfield.click();
		managernametextfield.sendKeys("Prince Chaurasia");
		QaBrowser.driver.findElement(By.xpath("//mat-label[text()='Select and add Traveler arranger']/../..//mat-select")).click();
		GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span", travelArranger);
		
		QaBrowser.driver.findElement(By.xpath("//mat-label[text()='Favorite Fruits']/../..//input")).click();
		GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span", "Lemon");
		switch (savecancildependent) {
		case "save":
		//	QaExtentReport.extentScreenshot("Added dependent");
			WebElement a = QaBrowser.driver
					.findElement(By.xpath("//span[text()='Save']"));
			JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
			js.executeScript("arguments[0].click()", a);

			break;
		case "cancil":
	//		QaExtentReport.extentScreenshot("Added dependent");
			WebElement b = QaBrowser.driver
					.findElement(By.xpath("//span[text()='Cancel']"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			js1.executeScript("arguments[0].click()", b);
			break;

		}
		
	}
}
