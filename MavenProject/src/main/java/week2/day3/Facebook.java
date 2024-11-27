package week2.day3;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Facebook {

	// <editor-fold defaultstate="expanded" desc="Methods">
	public static void main(String[] args) {
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		//Maximize window
		driver.manage().window().maximize();
		//Get URL
		driver.get("https://www.facebook.com/");
		//Validate title
		System.out.println(driver.getTitle().equals("Log in to Facebook"));
		//Enter Username
		driver.findElement(By.id("email")).sendKeys("testleaf.2023@gmail.com");
		//Enter Password
		driver.findElement(By.id("pass")).sendKeys("Tuna@321");
		//Click Login
		driver.findElement(By.id("loginbutton")).click();
		//Validate error message for incorrect creds
		WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_box")));
		String errorMessage = errorMessageElement.getText();
		System.out.println(errorMessage.contains("Invalid username or password"));
		
	}
	// </editor-fold>
}
