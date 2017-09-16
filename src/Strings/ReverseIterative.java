package Strings;

import org.junit.Test;

public class ReverseIterative {

	public static String reverseIterate(String string){
		//go through the whole string backwards
		for(int i = string.length() - 1; i >= 0; i--){
			//add the current char to the string
			string += string.charAt(i);
		}
		//return the latter half of this string
		string = string.substring(string.length()/2);
		return string;
	}
	
	@Test
	public void test(){
		String a = "Hello, World!";
		a = reverseIterate(a);
		
		System.out.println(a);
		assert(a.equals("!dlroW ,olleH"));
		
		String b = "";
		b = reverseIterate(b);
		
		assert(b.equals(""));
		
		String c = "abababababa";
		c = reverseIterate(c);
		
		assert(c.equals("abababababa"));
	}
}
