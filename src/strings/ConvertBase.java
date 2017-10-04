package strings;

import org.junit.Test;

public class ConvertBase {
	
	//convert any integer (positive or negative)
	public static String convert(String string, int baseFrom, int baseTo){
		
		//if the number is negative, return a negative sign before the rest of the conversion
		if(string.charAt(0) == '-'){
			//recursively call convert on everything else in the string
			String alpha = convert(string.substring(1), baseFrom, baseTo);
			return (alpha.equals("0")) ? "0" : 
				//if the value is 0, no need of a negative sign
				"-" + alpha;
		}
		
		int value = convertFrom(string, baseFrom);
		//convert from the current base to base 10
		
		//convert to the new base from base 10 value
		String convert = convertTo(value, baseTo);
		
		return convert;
	}
	
	//convert anything from base 10 to something else
	public static String convertTo(int value, int base){
		String convert = "";
		//if the value is 0, return "0"
		if(value == 0) convert = "0";
		while(value != 0){
			//keep adding the remainder of division at the back of the string
			convert = (value % base) + convert;
			//divide by the target base
			value /= base;
		}
		return convert;
	}
	
	//convert any number from a given base to base 10
	public static int convertFrom(String string, int base){
		int value = 0;
		//start at 0, and add each digit's value in that given base
		for(int i = 0; i < string.length(); i++){
			//iterate through the whole String string
			//convert the character to the current value, and multiply that value by the
			//appropriate power of the base
			value += (string.charAt(i) - 48) * Math.pow(base, string.length() - 1 - i);
		}
		return value;
	}

	
	@Test
	public void Test(){
		String a = "101";
		int aFrom = 2;
		int aTo = 4;
		
		assert(convert(a, aFrom, aTo).equals("11"));
		
		
		String b = "0";
		int bFrom = 10;
		int bTo = 2;
		
		assert(convert(b, bFrom, bTo).equals("0"));
		
		
		String c = "-0";
		int cFrom = 30;
		int cTo = 4;

		assert(convert(c, cFrom, cTo).equals("0"));
		
		
		String d = "-100";
		int dFrom = 4;
		int dTo = 5;
		
		assert(convert(d, dFrom, dTo).equals("-31"));
		
		
		String e = "11111111";
		int eFrom = 2;
		int eTo = 10;
		
		assert(convert(e, eFrom, eTo).equals("255"));
		
		
		eTo = 9;
		
		assert(convert(e, eFrom, eTo).equals("313"));
		
		e = "-" + e;
		
		assert(convert(e, eFrom, eTo).equals("-313"));
	}
}
