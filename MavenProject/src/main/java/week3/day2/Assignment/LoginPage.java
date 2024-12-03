package week3.day2.Assignment;

public class LoginPage extends BasePage{
	@Override
	public void performCommonTasks() {
		System.out.println("Performed Common Task on Login Page");
	}
	
	public static void main(String[] args) {
		LoginPage lp = new LoginPage();
		lp.findElement();
		lp.enterText();
		lp.clickElement();
		lp.performCommonTasks();
		
		BasePage bp  = new BasePage();
		bp.performCommonTasks();
	}
}
