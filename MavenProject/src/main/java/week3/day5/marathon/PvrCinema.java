package week3.day5.marathon;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PvrCinema {

	public static void main(String[] args) throws InterruptedException {
		Random rand = new Random();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.pvrcinemas.com/home");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement selectQuickBook = driver.findElement(By.cssSelector("span.cinemas-inactive"));
		selectQuickBook.click();
		//Select Cinema
		WebElement selectCinema = driver.findElement(By.xpath("//span[text()='Select Cinema']"));
		selectCinema.click();
		Thread.sleep(1000);
		List<WebElement> listOfCinema = driver.findElements(By.xpath("//ul[@class='p-dropdown-items']//li"));
		selectElementFromList(listOfCinema, "INOX: Royal Heritage Mall, Pune");
		
		List<WebElement> listOfDates = driver.findElements(By.xpath("//ul[@class='p-dropdown-items']//li"));
		selectElementFromList(listOfDates, "Tomorrow");
		
		//Select Movie
		List<WebElement> listOfMovies = driver.findElements(By.xpath("//ul[@class='p-dropdown-items']//li"));
		selectElementFromList(listOfMovies, "MOANA 2");
		
		//Select Time
		List<WebElement> availableTimes = driver.findElements(By.xpath("//ul[@class='p-dropdown-items']//li"));
		selectElementFromList(availableTimes, "10:05 AM");
		
		//Book
		WebElement bookButton = driver.findElement(By.xpath("//button[@type='submit']/span[text()='Book']"));
		bookButton.click();
		
		//Accept TnC
		WebElement acceptTnC = driver.findElement(By.xpath("(//div[@class='accpet-btn-flow-seat']/button)[2]"));
		acceptTnC.click();
		
		//Select a random seat
		List<WebElement> activeSeats = driver.findElements(By.xpath("//span[@class='seat-current-pvr']"));
		int randomSeat = rand.nextInt(activeSeats.size());
		WebElement selectedSeatNumber = activeSeats.get(randomSeat);
		selectedSeatNumber.click();
		
		//Proceed
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		//Print Seat
		WebElement actualSeatNumber = driver.findElement(By.cssSelector("div.seat-number p"));
		System.out.println("Actual Seat is: "+ actualSeatNumber.getText());
		
		//Print Total
		String grandTotal = driver.findElement(By.xpath("(//div[@class='all-grand']//h6)[2]")).getText();
		System.out.println("Grand Total: " + grandTotal);
		
		//Proceed
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		Thread.sleep(1000);
		
		//Close Popup
		List<WebElement> elements = driver.findElements(By.xpath("//i[contains(@class,'pi-times')]"));
		driver.executeScript("arguments[0].click();",elements.get(0));
		
		//Print Title
		System.out.println("Page Title: " + driver.getTitle());
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
