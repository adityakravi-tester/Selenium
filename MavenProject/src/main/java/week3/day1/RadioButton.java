package week3.day1;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.leafground.com/radio.xhtml");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		//Select favorite browser
		String favoriteBrowser = "Edge";
		List<WebElement> browserLabels = driver.findElements(By.xpath("//h5[text()='Your most favorite browser']/following-sibling::div//label"));
		WebElement selectRadioButton = selectRadioButtonBasedOnMatch(browserLabels, favoriteBrowser);
		selectRadioButton.click();
		
		//Unselectable
		String unselectable = "Chennai";
		List<WebElement> unselectableLabels = driver.findElements(By.xpath("//h5[text()='UnSelectable']/following-sibling::div//label"));
		WebElement unselectableLabelsElement = selectRadioButtonBasedOnMatch(unselectableLabels, unselectable);
		unselectableLabelsElement.click();
		boolean selected = driver.findElement(By.xpath("//input[@value='"+unselectable+"']")).isSelected();
		System.out.println("is city selected: "+ selected);
		unselectableLabelsElement.click();
		boolean unselected = driver.findElement(By.xpath("//input[@value='"+unselectable+"']")).isSelected();
		System.out.println("is city selected: "+ unselected);
		
		//Find the default selected Radio button
		String [] browserOptions = {"Option1","Option2","Option3","Option4"};
		System.out.println("Default radio selected is: " + getDefaultCitySelection(driver, browserOptions));
		
		//Select the age group (only if not selected)
		WebElement ageGroup21To40 = driver.findElement(By.xpath("//input[@value='21-40 Years']"));
		System.out.println("is the age group 21 to 40 selected: "+ ageGroup21To40.isSelected());
		if(!ageGroup21To40.isSelected()) {
			driver.findElement(By.xpath("//input[@value='21-40 Years']/ancestor::div[2]/following-sibling::label")).click();
		}
	}
	
	public static String getDefaultCitySelection(WebDriver driver, String [] browsersOptions) {
		for(String browser : browsersOptions) {
			WebElement defaultElement = driver.findElement(By.xpath("//input[@value='"+ browser +"']"));
			if(defaultElement.isSelected()) {
				return driver.findElement(By.xpath("//input[@value='" + browser + "']/ancestor::div[2]/following-sibling::label")).getText();
			}
		}
		return null;
	}
	
	public static WebElement selectRadioButtonBasedOnMatch(List<WebElement> label, String match) {
		WebElement radioButton = null;
		for(int i = 0; i < label.size(); i++) {
			if(label.get(i).getText().equals(match)) {
				radioButton = label.get(i);
				break;
			}
		}
		return radioButton;
	}
}
