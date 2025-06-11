package travelerWithAllDetails;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import addTraveler.GenericUtility;
import utilities.QaBrowser;

public class EmploymentDetailPage {

	public static void employmentDetailPage(String Department, String Employeegrade, String Designation,String Division,String BusinessUnit,String CostCentre,
			String project,String employsavecancil)
			throws Throwable {
		Thread.sleep(1000);
		QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Employment details')]")).click();
		QaBrowser.driver.findElement(By.xpath("//mat-icon[contains(text(),'edit')]")).click();
		QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'Department')]/../../..//mat-select"))
				.click();
		List<WebElement> department_List = QaBrowser.driver
				.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
		Thread.sleep(500);
		System.out.println(department_List.size());

		for (WebElement national : department_List) {
			String nationlist = national.getText();
			Thread.sleep(1000);
			System.out.println(nationlist);
			if (nationlist.equalsIgnoreCase(Department)) {
				national.click();
				break;
			}
		}
		QaBrowser.driver
				.findElement(By
						.xpath("//mat-label[contains(text(),'Employee Grade Category (Optional)')]/../..//mat-select"))
				.click();

		List<WebElement> emloyeegrade_List = QaBrowser.driver
				.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
		Thread.sleep(500);
		System.out.println(emloyeegrade_List.size());

		for (WebElement national : emloyeegrade_List) {
			String nationlist = national.getText();
			System.out.println(nationlist);
			if (nationlist.equalsIgnoreCase(Employeegrade)) {
				national.click();
				break;
			}

		}
		QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),' Designation')]/../..//mat-select"))
				.click();
		Thread.sleep(1000);
		List<WebElement> disignation_List = QaBrowser.driver
				.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
		Thread.sleep(500);
		System.out.println(disignation_List.size());

		for (WebElement designation : disignation_List) {
			String disiglist = designation.getText();
			System.out.println(disiglist);
			if (disiglist.equalsIgnoreCase(Designation)) {
				designation.click();
				break;
			}

		}
		QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'Division (Optional)')]/../..//mat-select"))
				.click();
		List<WebElement> division_List = QaBrowser.driver
				.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
		Thread.sleep(500);
		System.out.println(division_List.size());

		for (WebElement devision : division_List) {
			String disiglist = devision.getText();
			System.out.println(disiglist);
			if (disiglist.equalsIgnoreCase(Division)) {
				devision.click();
				break;
			}
	}
		QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'Business Unit (Optional)')]/../..//mat-select")).click();
		List<WebElement> business_Unit_List = QaBrowser.driver
				.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
		Thread.sleep(500);
		System.out.println(business_Unit_List.size());

		for (WebElement business : business_Unit_List) {
			String businesslist = business.getText();
			System.out.println(businesslist);
			if (businesslist.equalsIgnoreCase(BusinessUnit)) {
				GenericUtility.clickConfirmButton("//div[contains(@id,'cdk-overlay-')]//mat-option/span");
			//	business.click();
				break;
			}
	}
		GenericUtility.clickConfirmButton("//mat-label[contains(text(),'Cost Center (Optional)')]/../..//mat-select");
	//	QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'Cost Center (Optional)')]/../..//mat-select")).click();
		List<WebElement> Cost_Center_List = QaBrowser.driver
				.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
		Thread.sleep(500);
		System.out.println(Cost_Center_List.size());

		for (WebElement costcenter : Cost_Center_List) {
			String centrelist = costcenter.getText();
			System.out.println(centrelist);
			if (centrelist.equalsIgnoreCase(CostCentre)) {
				GenericUtility.clickConfirmButton("//div[contains(@id,'cdk-overlay-')]//mat-option/span");
			//	costcenter.click();
				break;
			}
	}
		QaBrowser.driver.findElement(By.xpath("//mat-label[contains(text(),'Project (Optional)')]/../..//mat-select")).click();
		List<WebElement> project_List = QaBrowser.driver
				.findElements(By.xpath("//div[contains(@id,'cdk-overlay-')]//mat-option/span"));
		Thread.sleep(500);
		System.out.println(project_List.size());

		for (WebElement project1 : project_List) {
			String projectlist = project1.getText();
			System.out.println(projectlist);
			if (projectlist.equalsIgnoreCase(project)) {
				
				project1.click();
				break;
			}
	}
		switch (employsavecancil) {
		case "save":
			QaBrowser.driver.findElement(By.xpath("//div[@class=\"inner-action\"]/button[2]")).click();
			break;
		case "cancil":
			QaBrowser.driver.findElement(By.xpath("//div[@class=\"inner-action\"]/button[1]")).click();
			break;
	}
}
}