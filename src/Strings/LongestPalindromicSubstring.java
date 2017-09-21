package Strings;

import org.junit.Test;

public class LongestPalindromicSubstring {
	
	//find the longest substring that is also palindromic
	public static String longest(String string){
		//if the length of the string is less than two, return the string
		if(string.length() < 2) return string;
		//start at the first char
		String sub = string.substring(0, 0);
		//iterate through every possible substring
		for(int i = 0; i < string.length(); i++){
			for(int j = i; j < string.length() + 1; j++){
				String splash = string.substring(i, j);
				//if the current substring is palindromic and has a greater length than the
				//current longest palindromic substring, reset sub
				if(isPalindromic(splash) && splash.length() > sub.length()){
					sub = splash;
				}
			}
		}
		//if every substring that is palindromic has a lesser or equal to length, then this is 
		//the correct substring
		return sub;
	}
	
	//check if a given string is palindromic
	public static boolean isPalindromic(String string){
		//iterate through the first half of the array
		for(int i = 0; i < string.length()/2; i++){
			//recognize the value at the other end
			int j = string.length() - i - 1;
			//if these two chars are different, then this string is not a palindrome
			if(string.charAt(i) != string.charAt(j)){
				 return false;
			}
		}
		//if every character is matched, then this is a palindrome
		return true;
	}
	
	@Test
	public void test(){
		String a = "hello";
		System.out.println(longest(a));
		assert(longest(a).equals("ll"));
		
		String b = "programming";
		assert(longest(b).equals("mm"));
		
		String c = "java";
		assert(longest(c).equals("ava"));
		
		String d = "abcdefedcba";
		assert(longest(d).equals(d));
		
		String e = "";
		assert(longest(e).equals(""));
	}
	
}
