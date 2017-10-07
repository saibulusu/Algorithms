package strings;

import org.junit.Test;

public class LongestNonRepeatingSubstring {
	
	//return the longest substring that does not have any repeating characters
	public static String longest(String string){
		//if the length of the string is less than 2, return that string
		if(string.length() < 2) return string;
		//start at the first character
		String sub = string.substring(0, 1);
		//iterate through the whole string, evaluate every possible substring
		for(int i = 0; i < string.length(); i++){
			for(int j = i; j < string.length() + 1; j++){
				String splash = string.substring(i, j);
				/*
				 * if the current substring is non repeating and the length
				 * is greater than the length of the current sub, reset sub
				 */
				if(isNonRepeating(splash) && splash.length() > sub.length())
					sub = splash;
			}
		}
		//the longest substring will now have been calculated
		return sub;
	}
	
	//determine if a string is non repeating
	public static boolean isNonRepeating(String string){
		/*
		 * if the length of the string is less than 2, then it is its own 
		 * longest repeating substring
		 */
		
		if(string.length() < 2) return true;
		//iterate through the whole string
		for(int i = 0; i < string.length() - 1; i++){
			//iterate through the current character to the end
			for(int j = i + 1; j < string.length(); j++){
				//if the two chars are equal, return false, because then this string is repeating
				if(string.charAt(i) == string.charAt(j)) return false;
			}
		}
		//otherwise, if we never return false, return true
		return true;
	}
	
	@Test
	public void test(){
		String a = "Hello, World!";
		assert(longest(a).equals(", World!"));
		
		String b = "Programming is great";
		assert(longest(b).equals("is great"));
		
		String c = "";
		assert(longest(c).equals(c));
		
		String d = "a";
		assert(longest(d).equals(d));
	}
	
}
