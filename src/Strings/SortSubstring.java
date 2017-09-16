package Strings;

import org.junit.Test;

public class SortSubstring {
	
	public static String sortSubstring(String string, int start, int end){
		//if the start and end indices are out of range
		if(start < 0 || start > string.length() - 1 || end < 0 || end > string.length() - 1){
			return null;
		}
		//return everything from 0 to start, before the sorted substring, before the rest of the string
		return string.substring(0, start) + 
				sort(string.substring(start, end + 1)) + string.substring(end + 1);
	}
	
	public static String sort(String string){
		//convert the string to a char array
		char[] chars = string.toCharArray();
		//iterate through the whole array besides the last value
		for(int i = 0; i < chars.length - 1; i++){
			//reiterate through the whole array besides the last i values
			for(int j = 0; j < chars.length - 1 - i; j++){
				if(chars[j] > chars[j + 1]){
					//swap the characters if the current character comes after the next character
					char temp = chars[j];
					chars[j] = chars[j + 1];
					chars[j + 1] = temp;
				}
			}
		}
		//place the array back into the string
		string = String.valueOf(chars);
		return string;
	}
	
	
	@Test
	public void test(){
		String a = "Hello, World!";
		a = sortSubstring(a, 4, 6);
		
		assert(a.equals("Hell ,oWorld!"));
		
		
		String b = "Let's go Java";
		b = sortSubstring(b, 0, b.length() - 1);
		
		assert(b.equals("  'JLaaegostv"));
		
		
		String c = "This is a legitimate sentence";
		c = sortSubstring(c, c.length(), c.length() + 4);
		
		assert(c == null);
	}
	
}
