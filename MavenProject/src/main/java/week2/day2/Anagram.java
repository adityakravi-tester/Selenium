package week2.day2;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String text1 = "stops";
		String text2 = "potss";
		
		if(text1.length() != text2.length()) {
			System.out.println("Lengths mismatch, therefore the strings are not an Anagram");
		} else {
			char[] charArray = text1.toCharArray();
			char[] charArray2 = text2.toCharArray();
			
			Arrays.sort(charArray);
			Arrays.sort(charArray2);
			
			if(Arrays.compare(charArray, charArray2) == 0) {
				System.out.println("The given strings are Anagram.");
			} else {
				System.out.println("The given strings are not an Anagram.");
			}
		}
	}
}
