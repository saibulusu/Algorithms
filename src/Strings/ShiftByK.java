package Strings;

import org.junit.Test;

public class ShiftByK {
	
	public static String shiftByK(String string, int k){
		k = k % string.length();
		string = string.substring(string.length() - k) + string.substring(0, string.length() - k);
		return string;
	}
	
	@Test
	public void test(){
		String a = "Hello, World!";
		a = shiftByK(a, 4);
		
		assert(a.equals("rld!Hello, Wo"));
		
		
		String b = "Let's go Java";
		b = shiftByK(b, b.length());
		
		assert(b.equals("Let's go Java"));
		
		
		String c = "This is a legitimate sentence";
		c = shiftByK(c, c.length() + 4);
		
		assert(c.equals("enceThis is a legitimate sent"));
		
		c = shiftByK(c, c.length() - 4);
		
		assert(c.equals("This is a legitimate sentence"));
	}
}
