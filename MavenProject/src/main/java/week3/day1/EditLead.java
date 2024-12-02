package week3.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import week2.day4.LeadsTestData;
import week2.day4.TestData;

public class EditLead {

	public static void main(String[] args) {
		// Preconditions
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();

		// Login with valid credentials
		driver.findElement(By.id("username")).sendKeys(TestData.username);
		driver.findElement(By.id("password")).sendKeys(TestData.password);
		driver.findElement(By.className("decorativeSubmit")).click();

		// Navigate to Create lead page and validate title
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		System.out.print("User is on the Create Lead Page: ");
		System.out.println(driver.getTitle().equals("Create Lead | opentaps CRM") ? "Pass" : "Fail");
		
		// Enter First Name
		WebElement companyName = driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']"));
		companyName.sendKeys(LeadsTestData.companyName);
		System.out.println("Company Name entered: " + companyName.getAttribute("value"));
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']"));
		firstName.sendKeys(LeadsTestData.firstName);;
		System.out.println("First Name entered: " + firstName.getAttribute("value"));
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']"));
		lastName.sendKeys(LeadsTestData.lastName);
		System.out.println("Last Name entered: " + lastName.getAttribute("value"));
		
		WebElement localFirstName = driver.findElement(By.xpath("//input[@name='firstNameLocal']"));
		localFirstName.sendKeys(LeadsTestData.localFirstName);
		System.out.println("Local First Name entered: " + localFirstName.getAttribute("value"));
		
		WebElement department = driver.findElement(By.cssSelector("#createLeadForm_departmentName"));
		department.sendKeys(LeadsTestData.department);
		System.out.println("Department Name entered: " + department.getAttribute("value"));

		WebElement description = driver.findElement(By.id("createLeadForm_description"));
		description.sendKeys(LeadsTestData.description);
		System.out.println("Description entered: " + description.getAttribute("value"));
		
		WebElement email = driver.findElement(By.id("createLeadForm_primaryEmail"));
		email.sendKeys(LeadsTestData.email);
		System.out.println("Email entered: " + email.getAttribute("value"));

		//Select State
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select selectSource = new Select(state);
		selectSource.selectByVisibleText("New York");
		System.out.println("Selected state: " + selectSource.getFirstSelectedOption().getText());
		
		//Click create
		driver.findElement(By.name("submitButton")).click();
		
		//Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		//Clear description
		WebElement clearDescription = driver.findElement(By.id("updateLeadForm_description"));
		clearDescription.clear();
		System.out.println("Description field is cleared: " + clearDescription.getAttribute("value").isBlank());
		
		//Enter important note
		WebElement importantNote = driver.findElement(By.id("updateLeadForm_importantNote"));
		importantNote.sendKeys(LeadsTestData.importantNote);
		System.out.println("Important Note entered: " + importantNote.getAttribute("value"));

		//Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//Get title
		System.out.println("Title of the page is: " + driver.getTitle());
		
		//Close the window
		driver.quit();
	}
}
