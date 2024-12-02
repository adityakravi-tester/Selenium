package week3.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import week2.day4.LeadsTestData;
import week2.day4.TestData;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// Preconditions
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();

		// Login with valid credentials
		driver.findElement(By.id("username")).sendKeys(TestData.username);
		driver.findElement(By.id("password")).sendKeys(TestData.password);
		driver.findElement(By.className("decorativeSubmit")).click();

		// Navigate to Find lead page and validate title
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		System.out.print("User is on the Find Lead Page: ");
		System.out.println(driver.getTitle().equals("Find Leads | opentaps CRM") ? "Pass" : "Fail");
		
		//Find lead by phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.cssSelector("[name=phoneNumber]")).sendKeys(LeadsTestData.phone);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		WebElement firstRowLeadIdElement = driver.findElement(By.xpath("((//div[text()='Lead ID']/ancestor::div[3]/following-sibling::div//table)[1]//a)[1]"));
		String firstRowLeadId = firstRowLeadIdElement.getText();
		System.out.println("First row lead id: " + firstRowLeadId);
		firstRowLeadIdElement.click();
		
		//Click delete
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		//Find lead by saved lead id
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(firstRowLeadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		String noRecordsMessage = driver.findElement(By.xpath("//*[text()='No records to display']")).getText();
		if(noRecordsMessage != null && noRecordsMessage.equals("No records to display")) {
			System.out.println("Lead details deleted successfully");
		}
		
		driver.close();
	}
}
