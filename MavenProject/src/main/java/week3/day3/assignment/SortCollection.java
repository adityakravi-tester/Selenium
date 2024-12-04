package week3.day3.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCollection {

	public static void main(String[] args) {
		String [] array = {"HCL", "Wipro", "Aspire Systems", "CTS"};
		
		List<String> list = new ArrayList<>();
		//Convert array to list
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		
		Collections.sort(list);
		for (int i = list.size()-1; i >= 0; i--) {
			System.out.println(list.get(i));
		}
	}
}
