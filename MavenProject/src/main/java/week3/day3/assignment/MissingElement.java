package week3.day3.assignment;

import java.util.*;

public class MissingElement {

	public static void main(String[] args) {
		int [] array =  {1, 2, 3, 4, 10, 6, 8};
		List<Integer> list = new ArrayList<>();
		//Convert array to list
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		
		//Sort
		Collections.sort(list);
		FindMissingNumber(list);
	}
	
	//Easier method
	public static void FindMissingNumber(List<Integer> list) {
		int biggestNumber = Collections.max(list);
		System.out.print("Missing numbers are: ");
		for(int i=1; i <= biggestNumber/2; i++ ) {
			if(!list.contains(biggestNumber - i)) {
				System.out.print(biggestNumber - i + " ");
			}
		}
	}
}
