package week2.day2;

public class ChangeCase {

	public static void main(String[] args) {
		new ChangeCase().changeOddLetterCase("changeme");
	}
	
	public void changeOddLetterCase(String str) {
		char[] charArray = str.toCharArray();
		StringBuilder sb = new StringBuilder(str.length());
		for (int i = 0; i < charArray.length; i++) {
			if(i%2!=0) {
				charArray[i] = Character.toUpperCase(charArray[i]);
			}
			sb.append(charArray[i]);
		}
		System.out.println(sb.toString());
	}
}
