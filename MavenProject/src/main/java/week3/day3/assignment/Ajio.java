package week3.day3.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ajio {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.ajio.com/");
		
		driver.findElement(By.name("searchVal")).sendKeys("bags", Keys.ENTER);
		
		WebElement mensCheckbox = driver.findElement(By.id("Men"));
		driver.findElement(By.cssSelector("[for=Men]")).click();
		System.out.println("Men's checkbox selected: " + wait.until(d -> mensCheckbox.isSelected()));
		
		WebElement fashionBagsCheckbox = driver.findElement(By.id("Men - Fashion Bags"));
		driver.findElement(By.cssSelector("[for='Men - Fashion Bags']")).click();
		System.out.println("Fashion checkbox has become stale: " + wait.until(ExpectedConditions.stalenessOf(fashionBagsCheckbox)));
		try {
			System.out.println("Fashion Bag checkbox selected: " + fashionBagsCheckbox.isSelected());
		} catch(StaleElementReferenceException ex) {
			fashionBagsCheckbox = driver.findElement(By.id("Men - Fashion Bags"));
			System.out.println("Fashion Bag checkbox selected: " + fashionBagsCheckbox.isSelected());
		}
		
		List<WebElement> products = driver.findElements(By.xpath("//div[@id='main-content']//div[@class='preview']"));
		System.out.println("Number of products after filtering: " + products.size());
		
		for(int i = 0; i < products.size(); i++) {
			String brandName = products.get(i).findElement(By.xpath(".//div[@class='brand']/strong")).getText();
			String productName = products.get(i).findElement(By.xpath(".//div[@class='nameCls']")).getText();
			String price = products.get(i).findElement(By.xpath(".//span[@class='price  ']/strong")).getText();
			
			System.out.println("Brand: " + brandName);
		    System.out.println("Product: " + productName);
		    System.out.println("Price: " + price);
		    System.out.println("----------------------------------");
		}
	}
}
