package CompanyMangement;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import addTraveler.GenericUtility;
import utilities.QaBrowser;

public class BasicInformation {
	public static void basicInformation(String DevisionDetails, String STATUS, String Division, String CancilConfirm,
			String BranchName, String BranchCode, String Country, String City, String Bsavecancil,
			String EditBranchName, String EditBranchcode, String PhoneNumber) throws Throwable {
		QaBrowser.driver.findElement(By.xpath("//div[text()='Branch information']")).click();
		switch (DevisionDetails) {
		case "Add":
			QaBrowser.driver.findElement(By.xpath("//mat-icon[text()='add']")).click();
			switch (STATUS) {
			case "Active":
				QaBrowser.driver.findElement(By.xpath("//label[text()='Active']/..//input")).click();
				break;
			case "Inactive":
				QaBrowser.driver.findElement(By.xpath("//label[text()='Inactive']/..//input")).click();
				break;
			}

			GenericUtility.clickConfirmButton("//mat-label[text()='Division ']/../..//mat-select");
			try {
				GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span",
						Division);
			} catch (ElementClickInterceptedException e) {
				GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span",
						Division);
			}
			GenericUtility.clickConfirmButtonwithpassingvalue(
					"//mat-label[text()='Corporate Branch Name']/../..//input", BranchName);
			GenericUtility.clickConfirmButtonwithpassingvalue("//mat-label[text()='Branch Code ']/../..//input",
					BranchCode);
			GenericUtility.clickConfirmButton("//div[text()='Country/Region']/../../..//input");

			try {
				GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", Country);
			} catch (ElementClickInterceptedException e) {
				GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", Country);
			}
			GenericUtility.clickConfirmButton("//div[text()='City']/../..//input");
			try {
				GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", City);
			} catch (ElementClickInterceptedException e) {
				GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", City);
			}

			WebElement phonenum = QaBrowser.driver
					.findElement(By.xpath("//mat-label[text()='Phone Number']/../..//input"));
			phonenum.click();
			phonenum.clear();
			phonenum.sendKeys(PhoneNumber);

			switch (Bsavecancil) {

			case "save":
				WebElement saveButton = QaBrowser.driver.findElement(By.xpath("//span[text()='Save']"));
				JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
				js.executeScript("arguments[0].click()", saveButton);
				break;

			case "cancil":
				WebElement cancilButton = QaBrowser.driver.findElement(By.xpath("//span[text()='Cancel']"));
				JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
				js1.executeScript("arguments[0].click()", cancilButton);
				break;
			}

			break;

		case "Edit":
			QaBrowser.driver.findElement(By.xpath("//table//tbody//tr//td[text()='" + BranchName + "']/..//td[7]/a[1]"))
					.click();
			switch (STATUS) {
			case "Active":
				QaBrowser.driver.findElement(By.xpath("//label[text()='Active']/..//input")).click();
				break;
			case "Inactive":
				QaBrowser.driver.findElement(By.xpath("//label[text()='Inactive']/..//input")).click();
				break;
			}

			GenericUtility.clickConfirmButton("//mat-label[text()='Division ']/../..//mat-select");
			try {
				GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span",
						Division);
			} catch (ElementClickInterceptedException e) {
				GenericUtility.handleMultipleSuggestation("//div[contains(@id,'cdk-overlay-')]//mat-option/span",
						Division);
			}
			GenericUtility.clickConfirmButtonwithpassingvalue(
					"//mat-label[text()='Corporate Branch Name']/../..//input", EditBranchName);
			GenericUtility.clickConfirmButtonwithpassingvalue("//mat-label[text()='Branch Code ']/../..//input",
					EditBranchcode);
			GenericUtility.clickConfirmButton("//div[text()='Country/Region']/../../..//input");
			try {
				GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", Country);
			} catch (ElementClickInterceptedException e) {
				GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", Country);
			}
			GenericUtility.clickConfirmButton("//div[text()='City']/../..//input");
			try {
				GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", City);
			} catch (ElementClickInterceptedException e) {
				GenericUtility.handleMultipleSuggestation("//ng-dropdown-panel//div/span", City);
			}

			WebElement phonenum1 = QaBrowser.driver
					.findElement(By.xpath("//mat-label[text()='Phone Number']/../..//input"));
			phonenum1.click();
			phonenum1.clear();
			phonenum1.sendKeys(PhoneNumber);

			switch (Bsavecancil) {

			case "save":
				WebElement saveButton = QaBrowser.driver.findElement(By.xpath("//span[text()='Save']"));
				JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
				js.executeScript("arguments[0].click()", saveButton);
				break;

			case "cancil":
				WebElement cancilButton = QaBrowser.driver.findElement(By.xpath("//span[text()='Cancel']"));
				JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
				js1.executeScript("arguments[0].click()", cancilButton);
				break;
			}

			break;
		case "Remove":
			QaBrowser.driver.findElement(By.xpath("//table//tbody//tr//td[text()='" + BranchName + "']/..//td[7]/a[2]"))
					.click();
			switch (CancilConfirm) {
			case "Cancil":
				WebElement Ab1 = QaBrowser.driver.findElement(
						By.xpath("//span[text()='Cancel']"));

				JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
				js1.executeScript("arguments[0].click()", Ab1);
				break;
			case "Confirm":
				WebElement Ab12 = QaBrowser.driver.findElement(
						By.xpath("//span[text()='Confirm']"));

				JavascriptExecutor js12 = (JavascriptExecutor) QaBrowser.driver;
				js12.executeScript("arguments[0].click()", Ab12);
				break;

			}//span[text()='Confirm']

			break;

		}
	}
}
