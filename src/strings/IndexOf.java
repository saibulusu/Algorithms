package strings;

import org.junit.Test;

public class IndexOf {
	
	//Check if needle is contained in haystack, and return the index at which that happens
	public static int indexOf(String haystack, String needle){
		//edge case where the length of the needle is greater than the length of the haystack
		//return -1, because obviously the needle is not in the haystack
		if(needle.length() > haystack.length()) return -1;
		//iterate through everything in haystack except for the last needle.length characters
		//you can't start at one of those characters and expect to find the string
		for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
			//if everything starting at the current index to the needle.length + this index
			//is the same as the needle, return this index
			if(checkSubstring(haystack, needle, i)) {
				return i;
			}
		}
		//if nothing above finds the string, then this needle is not in the haystack
		return -1;
	}
	
	//check if the substring from start to start + needle.length() is equal to needle itself
	public static boolean checkSubstring(String haystack, String needle, int start) {
		//iterate through these indices in this string
		for(int i = start; i < needle.length() + start; i++) {
			//if character at i in the haystack isn't the same as the character at i - start in needle
			//these two strings would not be equal
			if(haystack.charAt(i) != needle.charAt(i - start)) return false;
		} return true;
	}
	
	@Test
	public void test(){
		String a = "Hello, World!";
		String a1 = "Hello";
		
		assert(indexOf(a, a1) == 0);
		
		String b = "Programming is great";
		String b1 = "is";
		
		assert(indexOf(b, b1) == 12);
		
		String c = "";
		String c1 = "java";
		
		assert(indexOf(c, c1) == -1);
		
		String d = "coding for fun";
		String d1 = "github";
		
		assert(indexOf(d, d1) == -1);
		assert(indexOf(d, "") == 0);
	}
}
