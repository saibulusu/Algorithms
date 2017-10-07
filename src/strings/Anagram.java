package strings;

import org.junit.Test;

public class Anagram {
	
	public static boolean anagram(String a, String b){
		/*
		 * replace all spaces with empty strings 
		 * this will remove every space from the string
		 */
		a = a.replace(" ", "");
		b = b.replace(" ", "");
		//sort all of the characters in both strings
		a = sort(a);
		b = sort(b);
		
		/*
		 * if a is equal to b now, then it is an anagram
		 * else, it is not an anagram
		 */
		return a.equals(b);
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
		String b = "olleWHldro!, ";
		
		assert(anagram(a, b));
		
		a = "";
		b = "";
		
		assert(anagram(a, b));
		
		a = "programming";
		b = "gramproming";
		
		assert(anagram(a, b));
		
		a = "I like Java";
		b = " I like Java ";
		
		assert(anagram(a, b));
		
		a = "Programming is great";
		b = "grammingPro si great is o";
		
		assert(!anagram(a, b));
		
		a = "HELLO";
		b = "hello";
		
		assert(!anagram(a, b));
	}
	
}















