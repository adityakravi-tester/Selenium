package week1.day2;

//Assignment to check if a number is prime or not
public class IsPrime {

	public static void main(String[] args) {
		int input = 73;
		boolean isPrime = true;
		for(int i = 2; i < input; i++) {
			if(input % i == 0) {
				isPrime = false;
				break;
			}
		}
		if(isPrime) {
			System.out.println(input + " is a prime number");
		} else {
			System.out.println(input + " is not a prime number");
		}
	}
}
