package strings;

import org.junit.Test;

public class StringToInt {
	
	//A string that represents a number is converted to an int
	public static int stringToInt(String string){
		//if the number is negative, then set counter to -1, and multiply at the end
		int counter = 1;
		if(string.charAt(0) == '-'){
			counter *= -1;
			string = string.substring(1);
		} else if (string.charAt(0) == '+'){
			/*
			 * if for some reason the first character says +, which it does not need to,
			 * just ignore this character
			 */
			string = string.substring(1);
		}
		
		int value = 0;
		//start off at 0
		for(int i = string.length() - 1; i >= 0; i--){
			//iterate through the whole array backwards
			int current = convert(string.charAt(i));
			//set the current value using convert
			value += current * Math.pow(10, string.length() - 1- i);
			//add this on to value by multiplying with the appropriate power of 10s
		}
		/*
		 * return the product of value and counter, which only makes a difference if 
		 * counter is -1
		 */
		return value * counter;
	}
	
	/* 
	 * convert a char directly to the number of that char
	 * for example, '7' becomes 7
	 */
	public static int convert(char c){
		//convert c to an integer with ascii conversion, and then subtract 48
		return (int) c - 48;
	}

	@Test
	public void test(){
		String a = "123";
		assert(stringToInt(a) == 123);
		
		String b = "-123";
		assert(stringToInt(b) == -123);
		
		String c = "0";
		assert(stringToInt(c) == 0);
		
		String d = "-0";
		assert(stringToInt(d) == 0);
	}
}
