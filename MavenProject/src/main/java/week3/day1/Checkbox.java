package week3.day1;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {

	public static void main(String[] args) {
		// Preconditions
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		// Click basic checkbox
		WebElement basicCheckbox = driver.findElement(By.xpath("//span[text()='Basic']"));
		basicCheckbox.click();

		// Click basic checkbox
		WebElement notificationCheckbox = driver.findElement(By.xpath("//span[text()='Ajax']"));
		notificationCheckbox.click();
		WebElement fadingNotification = driver.findElement(By.xpath("//span[text()='Checked']"));
		String checkedMessge = fadingNotification.getText();
		System.out.println("Notification message " + checkedMessge + " is displayed.");
		
		//Select favorite language
		WebElement favoriteLanguageCheckbox = driver.findElement(By.xpath("//label[text()='Java']"));
		favoriteLanguageCheckbox.click();
		
		//Select and validate Tristate checkbox
		WebElement tristateCheckbox = driver.findElement(By.xpath("//h5[text()='Tri State Checkbox']/following-sibling::div//span/parent::div"));
		tristateCheckbox.click();
		tristateCheckbox = driver.findElement(By.xpath("//input[contains(@id,'ajaxTriState_input')]"));
		System.out.println("tristateCheckbox is Selected: "+tristateCheckbox.isSelected());
		
		//Select and validate toggle
		driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).click();
		boolean displayed = driver.findElement(By.xpath("//span[@class='ui-growl-title']")).isDisplayed();
		System.out.println("Toggle is displayed: "+displayed);
		
		//Validate if checkbox is disabled 
		boolean isCheckboxEnabled = driver.findElement(By.xpath("//h5[text()='Verify if check box is disabled']/parent::div//input")).isEnabled();
		System.out.println("is checkbox enabled: " + isCheckboxEnabled);
		
		//Select cities and validate if selected
		driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
		String [] cities = {"Paris","Barcelona","Amsterdam"};
		for(String city : cities) {
			driver.findElement(By.xpath("//div[contains(@id,'multiple_panel')]//li/label[text()='" + city + "']")).click();
		}
		
		List<WebElement> selectedCities = driver.findElements(By.xpath("//ul[@data-label='Cities']//span[@class='ui-selectcheckboxmenu-token-label']"));
		for(WebElement selectedCity : selectedCities) {
			System.out.println("Selected Cities: " + selectedCity.getText());
		}
		
		for(String city : cities) {
			boolean selected = driver.findElement(By.xpath("//div[contains(@id,'multiple_panel')]//li/label[text()='"+city+"']/parent::li//input")).isSelected();
			System.out.println("is the city " + city + " selected: " + selected);
		}
		
		driver.close();
	}
}
