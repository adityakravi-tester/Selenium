package week3.day3.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecondLarget {

	public static void main(String[] args) {
		int [] array =  {3, 2, 11, 4, 6, 7};
		List<Integer> list = new ArrayList<>();
		//Convert array to list
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		//Sort list
		Collections.sort(list);
		System.out.println("Second larget number: " + list.get(list.size() - 2));
	}
}
