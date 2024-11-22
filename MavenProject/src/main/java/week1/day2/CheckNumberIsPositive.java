package week1.day2;

//This assignment checks whether a number is negative or positive
public class CheckNumberIsPositive {

	public static void main(String[] args) {
		
		int version = 10;
		if(version < 0) {
			System.out.println(version + " is a negative number.");
		} else if(version > 0) {
			System.out.println(version + " is a positive number.");
		} else {
			System.out.println(version + "is zero.");
		}
	}
}
