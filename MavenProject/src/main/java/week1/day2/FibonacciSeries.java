package week1.day2;

//Print list of fibonacci series till a given range
public class FibonacciSeries {

	public static void main(String[] args) {	
		int range = 8;
		int firstNumber = 0;
		int secondNumber = 1;
		System.out.print("Fibonacci series: " + firstNumber + " " + secondNumber + " ");
		int thirdNumber = 0;
		for(int i = 0; i <= range; i++) {
			thirdNumber = firstNumber + secondNumber;
			System.out.print(thirdNumber + " ");
			firstNumber = secondNumber;
			secondNumber = thirdNumber;	
		}
	}
}
