package week4.day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import week2.day4.TestData;

public class MergeLead {

	public static void main(String[] args) {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http://leaftaps.com/opentaps/control/login");

		// Login with valid credentials
		driver.findElement(By.id("username")).sendKeys(TestData.username);
		driver.findElement(By.id("password")).sendKeys(TestData.password);
		driver.findElement(By.className("decorativeSubmit")).click();

		// Navigate to Create lead page and validate title
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_contacts' and text()='Merge Contacts']"));
		
		//Select From Contact
		WebElement fromContact = driver.findElement(By.xpath("(//form[@name='MergePartyForm']//img)[1]"));
		fromContact.click();
		List<String> windowList = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowList.get(1));
		WebElement firstFromContactId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(@class,'partyId')]//div[not(text()='Contact ID')]//a")));
		firstFromContactId.click();
		driver.switchTo().window(windowList.get(0));
		
		//Select To Contact
		WebElement toContact = driver.findElement(By.xpath("(//form[@name='MergePartyForm']//img)[2]"));
		toContact.click();
		List<String> newWindowList = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(newWindowList.get(1));
		WebElement firstToContactId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[contains(@class,'partyId')]//div[not(text()='Contact ID')]//a)[2]")));
		firstToContactId.click();
		driver.switchTo().window(newWindowList.get(0));
		//Merge
		driver.findElement(By.cssSelector("a.buttonDangerous")).click();
		driver.switchTo().alert().accept();
		// Get title
		driver.getTitle();
		System.out.println("Title of the page is: " + driver.getTitle());

		// Close the window
		driver.quit();
	}
}
