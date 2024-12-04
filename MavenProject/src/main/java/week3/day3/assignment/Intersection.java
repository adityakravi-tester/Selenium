package week3.day3.assignment;

import java.util.ArrayList;
import java.util.List;

public class Intersection {

	public static void main(String[] args) {
		int[] array = { 3, 2, 11, 4, 6, 7 };
		int[] secondArray = { 1, 2, 8, 4, 9, 7 };

		List<Integer> listOfArray = new ArrayList<>();
		List<Integer> listOfSecondArray = new ArrayList<>();

		//Convert first array to list
		for (int i = 0; i < array.length; i++) {
			listOfArray.add(array[i]);
		}
		//Convert second array to list
		for (int i = 0; i < secondArray.length; i++) {
			listOfSecondArray.add(secondArray[i]);
		}
		//check both lists for common elements
		for(int i = 0; i < listOfArray.size(); i++) {
			if(listOfArray.get(i) == listOfSecondArray.get(i)) {
				System.out.println(listOfArray.get(i));
			}
		}
	}
}
