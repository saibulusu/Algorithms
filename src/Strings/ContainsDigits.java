package Strings;

import org.junit.Test;

public class ContainsDigits {
	
	//check if a given string contains only digits, no letters, etc
	public static boolean containsDigits(String string){
		//if the length of the string is 0, it does not contains any digits
		if(string.length() == 0) return false;
		//iterate through the whole string
		for(int i = 0; i < string.length(); i++){
			//if the current char is outside of the ascii range for 
			//chars 0 - 9, return false
			char current = string.charAt(i);
			if(current < 48 || current > 57)
				return false;
		}
		//if every char is within this range, return true
		return true;
	}
	
	@Test
	public void test(){
		String a = "123";
		assert(containsDigits(a));
		
		String  b = "123a";
		assert(!containsDigits(b));
		
		String c = "";
		assert(!containsDigits(c));
		
		String e = "abc";
		assert(!containsDigits(e));
	}
	
}
