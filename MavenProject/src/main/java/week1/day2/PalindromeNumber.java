package week1.day2;

public class PalindromeNumber {

	public static void main(String[] args) {

		int input = 123456;
		int output = 654321;
		int numberOfDigits = 0;
		int sum = 0;

		//Loop to find number of digits in the number
		for (int i = 123456; i > 0; i = i / 10) {
			numberOfDigits++;
		}
		
		//Loop to get the remainder one by one and form a number 
		for (int i = 123456; i > 0; i = i / 10) {
			int rem = i % 10;
			int temp = rem;
			for(int j = 1; j < numberOfDigits; j++) {
				temp = temp * 10;
			}
			sum = sum + temp; 
			numberOfDigits --;
		}
		
		if(output == sum) {
			System.out.println("Number " + input + "is a palindrome number");
		} else {
			System.out.println("Number " + input + "is not a palindrome number");
		}
	}
}
