package week3.day2.Assignment;

public class ReporterBase {
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
	
	public void takeSnap() {
		System.out.println("Snapshot taken by Reporter Base Class");
	}
}
