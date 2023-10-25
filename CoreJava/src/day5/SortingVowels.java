package day5;

import java.util.Iterator;

public class SortingVowels {

	String s = "Hello how are you";
	int count = 0;

	public String[] split() {

		String[] words = s.split(" ");
		return words;

	}

	public int vowels(String[] words) {
		for (String string : words) {
		for (int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				count = count + 1;
			}
		}
		}
		return count;

	}
	
	

	public static void main(String[] args) {
		

	}

}
