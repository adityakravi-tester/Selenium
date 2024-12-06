package week3.day5.marathon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String searchString = "Bags for boys";
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchString);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='autocomplete-results-container']//div[@aria-label='"+ searchString.toLowerCase() +"']")).click();
		
		//show results
		String results = driver.findElement(By.xpath("//h1[@data-csa-c-slot-id='nav-ribContainer']//div[contains(@class,'a-section a-spacing-small a-spacing-top-small')]")).getText();
		System.out.println("Result: " + results);
		
		//Select 2 brands, change the integer argument to select any number of brands
		selectBrandsFirstNBrands(driver, 2);
		
		//Sort, change the sorting option by providing valid option
		driver.findElement(By.cssSelector("span.a-button-inner")).click();
		Thread.sleep(1000);
		List<WebElement> sortingOptions = driver.findElements(By.cssSelector("div.a-popover-wrapper li a"));
		selectElementFromList(sortingOptions, "Newest Arrivals");
		
		//ItemName for first product, change the integer value to get the item info for any item
		List<WebElement> itemSearchResults = driver.findElements(By.xpath("//div[contains(@cel_widget_id,'MAIN-SEARCH_RESULTS')]"));
		getItemInformation(driver, itemSearchResults, 1);
		
		//Title
		String title = driver.findElement(By.cssSelector("#nav-progressive-subnav img")).getAttribute("alt");
		System.out.println("Title: " + title);
		
		//close browser
		driver.close();
		
	}
	
	public static void selectBrandsFirstNBrands(WebDriver driver, int n) throws InterruptedException {
		Thread.sleep(1000);
		List<WebElement> brandList = driver.findElements(By.xpath("//div[@id='brandsRefinements']//a/span[not(@class='a-expander-prompt' or text()='Clear')]"));
		List<String> brands = new ArrayList<>();
		for(int i =0; i< brandList.size(); i++) {
			brands.add(brandList.get(i).getText());
		}
		
		for(int i = 0; i < n; i++) {
			driver.findElement(By.xpath("//div[@id='brandsRefinements']/ul//li//a/span[text()='" + brands.get(i) +"']")).click();
			Thread.sleep(1000);
			WebElement seeAllBrands = driver.findElement(By.cssSelector("#brandsRefinements span.a-expander-prompt"));
			seeAllBrands.click();
			Thread.sleep(1000);
		}
	}
	
	
	public static void getItemInformation(WebDriver driver, List<WebElement> itemSearchResults, int itemNum) {
		for (int i = 0; i < itemSearchResults.size(); i++) {
			if(itemNum - 1 == i) {
				WebElement name = itemSearchResults.get(i).findElement(By.xpath(".//span[contains(@class,'a-size-base-plus a-color-base a-text-normal')]"));
				System.out.println("Item Name: " + name.getText());
				try {
					WebElement price = itemSearchResults.get(i).findElement(By.xpath(".//span[contains(@class,'a-price-whole')]"));
					System.out.println("Price: " + price.getText());
				} catch(NoSuchElementException ex) {
					System.out.println("Price not available for this item");
				}
				break;
			}
		}
	}
	
	
	public static void selectElementFromList(List<WebElement> elements, String match) throws InterruptedException {
		for (int i = 0; i < elements.size(); i++) {
			String currentCinema = elements.get(i).getText();
			if(currentCinema.contains(match)) {
				elements.get(i).click();
				break;
			}
		}
		elements.clear();
		Thread.sleep(1000);
	}
}
