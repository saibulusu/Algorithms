package strings;

import org.junit.Test;

public class Hash {

	//Several common hashing functions for strings
	
	
	//return the length of the string
	public static int hash_length(String string){
		return string.length();
	}
	
	//add hashing function
	public static int hash_add(String string){
		int value = 0;
		//iterate through the whole string and add each ascii value to value
		for(int i = 0; i < string.length(); i++){
			value += (string.charAt(i));
			//ensure that this is modulo 1024
			value %= 1024;
		}
		return value;
	}
	
	//mul31 hashing function
	public static int hash_mul31(String string){
		//edge case: length of the string is 0, return 0
		if(string.length() == 0) return 0;
		int value = string.charAt(0);
		//iterate through the whole string
		for(int i = 1; i < string.length(); i++){
			//multiply current value by 31, add ascii value of current character
			value *= 31;
			value += string.charAt(i);
			//ensure that this is modulo 1024
			value %= 1024;
		}
		return value;
	}
	
	//mul32 hasing function
	public static int hash_mul32(String string){
		//edge case: length of the string is 0, return 0
		if(string.length() == 0) return 0;
		int value = string.charAt(0);
		//iterate through the whole string
		for(int i = 1; i < string.length(); i++){
			//mutiply current value by 32, add ascii value of current character
			value *= 32;
			value += string.charAt(i);
			//ensure that this is modulo 1024
			value %= 1024;
		}
		return value;
	}
	
	//lcg hashing function
	public static int hash_lcg(String string){
		int value = 0;
		//iterate through the whole string
		for(int i = 0; i < string.length(); i++){
			//add the current char ascii value
			value += string.charAt(i);
			//function f on value: multiply by 11664525, multiply by 1013904223
			value *= 1664525;
			value += 1013904223;
		}
		//ensure that this is modulo 1024
		return value % 1024;
	}
	
	@Test
	public void test(){
		String a = "";
		assert(hash_length(a) == 0);
		assert(hash_add(a) == 0);
		assert(hash_mul31(a) == 0);
		assert(hash_mul32(a) == 0);
		assert(hash_lcg(a) == 0);
		
		String b = "i";
		assert(hash_length(b) == 1);
		assert(hash_add(b) == 105);
		assert(hash_mul31(b) == 105);
		assert(hash_mul32(b) == 105);
		assert(hash_lcg(b) == 692);
		
		String c = "hello";
		assert(hash_length(c) == 5);
		assert(hash_add(c) == 532);
		assert(hash_mul31(c) == 210);
		assert(hash_mul32(c) == 495);
		assert(hash_lcg(c) == 203);
		
		String d = "Hello, World!";
		assert(hash_length(d) == 13);
		assert(hash_add(d) == 105);
		assert(hash_mul31(d) == 21);
		assert(hash_mul32(d) == 161);
		assert(hash_lcg(d) == 208);
	}
}










