package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {

		// Launch browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Load URL
		driver.get(TestData.url);

		// Login with valid credentials
		driver.findElement(By.id("username")).sendKeys(TestData.username);
		driver.findElement(By.id("password")).sendKeys(TestData.password);
		driver.findElement(By.className("decorativeSubmit")).click();

		// Navigate to create account page and validate title
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Create Account']")).click();
		driver.findElement(By.cssSelector("#accountName")).sendKeys(AccountsTestData.accountName);
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(AccountsTestData.description);

		WebElement industryDropdown = driver.findElement(By.xpath("//select[@name='industryEnumId']"));
		Select selectIndustry = new Select(industryDropdown);
		selectIndustry.selectByVisibleText(AccountsTestData.industry);

		WebElement ownershipDropdown = driver.findElement(By.xpath("//select[@name='ownershipEnumId']"));
		Select selectOwnership = new Select(ownershipDropdown);
		selectOwnership.selectByVisibleText(AccountsTestData.ownership);

		WebElement sourceDropdown = driver.findElement(By.xpath("//select[@id='dataSourceId']"));
		Select selectSource = new Select(sourceDropdown);
		selectSource.selectByValue("LEAD_EMPLOYEE");

		WebElement marketingCampaignDropdown = driver.findElement(By.xpath("//select[@id='marketingCampaignId']"));
		Select selectMarketingCampaign = new Select(marketingCampaignDropdown);
		selectMarketingCampaign.selectByIndex(6);

		WebElement stateDropdown = driver.findElement(By.xpath("//select[@id='generalStateProvinceGeoId']"));
		Select selectState = new Select(stateDropdown);
		selectState.selectByValue("TX");

		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();

		WebElement errorMessage = driver.findElement(By.xpath("//li[@class='errorMessage']"));
		if (errorMessage == null) {
			// Validate accountName
			String isTitle = driver.getTitle().equals("Account Details | opentaps CRM") ? "Pass" : "Fail";
			System.out.println("User is on account details: " + isTitle);
			String accountName = driver.findElement(By.xpath("//span[contains(text(),'John Doe')]")).getText();
			accountName.contains(AccountsTestData.accountName);
		} else {
			String error = driver.findElement(By.xpath("//li[@class='errorMessage']")).getText();
			System.out.println("Error: " + error);
			error.contains(AccountsTestData.accountExistsErrorMessage);
		}
	}
}
