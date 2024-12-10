package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonActions {

	public static void main(String[] args) throws IOException {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Actions actions = new Actions(driver);
		
		WebElement conditionsElement = driver.findElement(By.xpath("//*[text()='Conditions of Use & Sale']"));
		actions.scrollToElement(conditionsElement).perform();
		System.out.println(conditionsElement.getText());
		
		File screenshotAs = conditionsElement.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("img.png"));
		
		
	}
}
