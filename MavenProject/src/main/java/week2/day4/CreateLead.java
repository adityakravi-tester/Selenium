package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public static void main(String[] args) {
		
		//Launch browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Load URL
		driver.get(LeadsTestData.url);
		
		//Login with valid credentials
		driver.findElement(By.id("username")).sendKeys(LeadsTestData.username);
		driver.findElement(By.id("password")).sendKeys(LeadsTestData.password);
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Navigate to create lead page and validate title
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		System.out.print("User is on the Create Lead Page: ");
		System.out.println(driver.getTitle().equals("Create Lead | opentaps CRM") ? "Pass" : "Fail");
		
		//Create lead using the test data
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(LeadsTestData.companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(LeadsTestData.firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(LeadsTestData.lastName);
		
		WebElement sourceDropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select selectSource = new Select(sourceDropdown);
		selectSource.selectByIndex(4);
		
		WebElement marketingCampaignDropdown = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select selectMarketingCampaign = new Select(marketingCampaignDropdown);
		selectMarketingCampaign.selectByVisibleText(LeadsTestData.marketingCampaign);
		
		WebElement ownershipDropdown = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select selectOwnership = new Select(ownershipDropdown);
		selectOwnership.selectByValue("OWN_CCORP");
		
		driver.findElement(By.name("submitButton")).click();
		
		//Validate View Leads page after lead creation and Get Lead details
		System.out.print("User is on the View Lead Page: ");
		System.out.println(driver.getTitle().equals("View Lead | opentaps CRM") ? "Pass" : "Fail");
		String leadsFirstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		String leadsLastName = driver.findElement(By.id("viewLead_lastName_sp")).getText();
		String leadsCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		
		//Validate lead details
		System.out.print("Validate first Name: ");
		System.out.println(leadsFirstName.equals(LeadsTestData.firstName) ? "Pass" : "Fail");
		System.out.print("Validate last Name: ");
		System.out.println(leadsLastName.equals(LeadsTestData.lastName) ? "Pass" : "Fail");
		System.out.print("Validate company Name: ");
		System.out.println(leadsCompanyName.contains(LeadsTestData.companyName) ? "Pass" : "Fail");
	}
}
