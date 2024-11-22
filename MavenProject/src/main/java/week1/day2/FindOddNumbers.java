package week1.day2;

// A program to find odd numbers from 0 to maxRange
public class FindOddNumbers {
	
	public static void main(String[] args) {
		int maxRange = 10;
		System.out.print("Odd numbers from 1 to " + maxRange + " : ");
		for(int i = 0; i <= maxRange; i++) {
			if(i%2 == 1) {
				System.out.print(i + " ");
			}
		}
	}

}
