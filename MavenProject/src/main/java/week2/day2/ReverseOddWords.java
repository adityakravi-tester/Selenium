package week2.day2;

public class ReverseOddWords {

	public static void main(String[] args) {
		//new ReverseOddWords().reverseWords("I am a software tester");
		new ReverseOddWords().reverseWords2("I am a software tester");
	}
	
	//easy method using stringbuilder
	public void reverseWords(String str) {
		String[] wordsInStr = str.split(" ");
		StringBuilder str2 = new StringBuilder(str.length());
		for(int i = 0; i < wordsInStr.length; i++) {
			//System.out.println(wordsInStr[i]);
			if(i%2 == 0)
				str2.append(wordsInStr[i]).append(" ");
			else
				str2.append(new StringBuilder(wordsInStr[i]).reverse()).append(" ");	
		}		
		System.out.println("Updated String is: " + str2.toString());
	}
	
	//method using toCharArray()
	public void reverseWords2(String str) {
		String[] wordsInStr = str.split(" ");
		String newString = "";
		for(int i = 0; i < wordsInStr.length; i++) {
			String characterString = "";
			if(i%2 != 0) {
				char[] charArray = wordsInStr[i].toCharArray();
				for(int j = charArray.length-1; j >= 0; j-- ) {
					characterString = characterString + charArray[j];
				}
				characterString = characterString + " ";
			} else {
				newString = newString + wordsInStr[i] + " ";
			}
			newString = newString + characterString;
		}		
		System.out.println("Updated String is: " + newString);
	}

}
