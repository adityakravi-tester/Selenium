package week1.day2;

public class FindOddOrEven {

	public static void main(String[] args) {
		int number = 22;
		if (number >= 0) {
			if (number % 2 == 0) {
				System.out.println(number + " is an even number");
			} else {
				System.out.println(number + " is an odd number");
			}
		} else {
			System.out.println("only positive integers can be odd or even");
		}
	}
}
