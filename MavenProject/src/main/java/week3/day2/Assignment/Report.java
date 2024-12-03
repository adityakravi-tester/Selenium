package week3.day2.Assignment;
import org.openqa.selenium.chrome.ChromeDriver;
public class Report {
	
	public void reportStep(String message, String status) {
		System.out.println("Test Status: " + status);
		switch (status) {
		case "Passed":
		case "Failed":
		case "Skipped":
			System.out.println(message);
			break;
		default:
			System.out.println("Incorrect Test Status");
			break;
		}
	}
	
	public void reportStep(String message, String status, boolean snap) {
		reportStep(message, status);
		if(snap) {
			System.out.println("Snapshot taken for " + status + " test");
		}
	}
	
	public static void main(String[] args) {
		Report report = new Report();
		ChromeDriver driver = new ChromeDriver();
		report.reportStep("Browser Launched Successfully", "Passed");
		
		driver.get("https://google.com");
		report.reportStep("Failed to get URL", "Failed", true);
	}
}
