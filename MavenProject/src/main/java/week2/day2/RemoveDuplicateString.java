package week2.day2;

import java.util.LinkedHashSet;

public class RemoveDuplicateString {

	public static void main(String[] args) {
		new RemoveDuplicateString().removeDuplicate("We learn Java basics as part of java sessions in java week1");
		//new RemoveDuplicateString().removeDuplicate2("We learn Java basics as part of java sessions in java week1");

	}

	//easy method
	public void removeDuplicate2(String str) {
		LinkedHashSet<String> newString = new LinkedHashSet<>();
		String[] split = str.split(" ");
		StringBuilder sb = new StringBuilder(str.length());
		for(int i = 0; i < split.length; i++) {
			if(newString.add(split[i].toLowerCase())) {
				sb.append(split[i]).append(" ");
			}
		}
		
		System.out.println(sb.toString());	
	}
	
	//lengthy method
	public void removeDuplicate(String str) {
		String[] wordsInString = str.split(" ");
		int count = 0;
		for(int i = 0; i < wordsInString.length; i++) {
			for(int j=1; j < wordsInString.length; j++) {
				if(i==j) continue;
				if(wordsInString[i].equalsIgnoreCase(wordsInString[j])) {
					wordsInString[j] = "";
					count++;
				}
			}
		}
		
		if(count > 0) {
			for(int i=0; i < wordsInString.length; i++) {
				System.out.print(wordsInString[i] + " ");
			}
		}	
	}
	
	
}
