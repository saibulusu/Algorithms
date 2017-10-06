package math;

import org.junit.Test;

public class IntegerToRoman {

	//return a string representing the Roman numeral version of i
	public static String convert(int i){
		String answer = "";
		//set up the string that the method will return and add to it
		
		//for each of the possible values of each Roman numeral character
		//check if i is greater than or equal to that value in order to check
		//if that corresponding character should be added
		while(i >= 1000){
			answer += "M";
			i -= 1000;
		}
		while(i >= 900){
			answer += "CM";
			i -= 900;
		}
		while(i >= 500){
			answer += "D";
			i -= 500;
		}
		while(i >= 400){
			answer += "CD";
			i -= 400;
		}
		while(i >= 100){
			answer += "C";
			i -= 100;
		}
		while(i >= 90){
			answer += "XC";
			i -= 90;
		}
		while(i >= 50){
			answer += "L";
			i -= 50;
		}
		while(i >= 40){
			answer += "XL";
			i -= 40;
		}
		while(i >= 10){
			answer += "X";
			i -= 10;
		}
		while(i >= 9){
			answer += "IX";
			i -= 9;
		}
		while(i >= 5){
			answer += "V";
			i -= 5;
		}
		while(i >= 4){
			answer += "IV";
			i -= 4;
		}
		while(i >= 1){
			answer += "I";
			i --;
		}
		
		//return the string at the end
		return answer;
	}

	@Test
	public void test(){
		int a = 1;
		assert(convert(a).equals("I"));
		
		int b = 2;
		assert(convert(b).equals("II"));
		
		int c = 4;
		assert(convert(c).equals("IV"));
		
		int d = 5;
		assert(convert(d).equals("V"));
		
		int e = 100;
		assert(convert(e).equals("C"));
		
		int f = 98;
		assert(convert(f).equals("XCVIII"));
		
		int g = 999;
		assert(convert(g).equals("CMXCIX"));
	}
	
}






