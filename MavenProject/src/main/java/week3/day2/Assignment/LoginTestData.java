package week3.day2.Assignment;

public class LoginTestData extends TestData{
	public void enterUsername() {
		System.out.println("Username entered successfully");
	}
	public void enterPassword() {
		System.out.println("Password entered successfully");
	}
	
	public static void main(String[] args) {
		LoginTestData ltd = new LoginTestData();
		ltd.enterCredentials();
		ltd.enterUsername();
		ltd.enterPassword();
		ltd.navigateToHomePage();
	}
}
