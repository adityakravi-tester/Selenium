package week3.day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Button {

	public static void main(String[] args) {
		
		//Preconditions
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		//Click and confirm title
		WebElement clickButton = driver.findElement(By.xpath("//h5[text()='Click and Confirm title.']/parent::div//span"));
		clickButton.click();
		System.out.println("Title is dashboard: "  + driver.getTitle().equals("Dashboard"));
		driver.navigate().back();
		
		//Confirm if the button is disabled.
		WebElement disabledButton = driver.findElement(By.xpath("//h5[text()='Confirm if the button is disabled.']/parent::div/button"));
		System.out.println("Button is disabled: "  + !disabledButton.isEnabled());
		
		//Position of Submit button
		WebElement submitButton = driver.findElement(By.xpath("//h5[text()='Find the position of the Submit button']/parent::div/button"));
		System.out.println("Position of the submit button is: X = "  + submitButton.getLocation().getX() +
						   " Y = " + submitButton.getLocation().getY());
		
		//Find the Save button color
		WebElement saveButtonBackgroundColor = driver.findElement(By.xpath("//h5[text()='Find the Save button color']/parent::div/button"));
		System.out.println("Button is disabled: "  + saveButtonBackgroundColor.getCssValue("background-color"));
		
		//Find the height and width of this button
		WebElement submitButtonSize = driver.findElement(By.xpath("//h5[text()='Find the height and width of this button']/parent::div/button"));
		System.out.println("Submit button size is:  height = "  + submitButtonSize.getSize().height + ", width = " + submitButtonSize.getSize().width);
		
		//Close the driver window
		driver.close();
	}
}
