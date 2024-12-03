package week3.day2.Assignment;

public class ReporterSub extends ReporterBase{

	@Override
	public void takeSnap() {
		System.out.println("Snapshot taken by Reporter Sub Class");
	}
	
	
	public static void main(String[] args) {
		ReporterSub rs = new ReporterSub();
		rs.reportStep("Test Passed", "Passed");
		rs.takeSnap();
		
	}
}
