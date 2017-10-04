package math;

import org.junit.Test;

public class Luhn {
	
	//check if a given number is a valid credit card number
	public static boolean luhn(int n){
		//set the integer to a string
		String digits = String.valueOf(n);
		int j = 1;
		//use j to check from the back if the current index is even
		int sum = 0;
		//if sum is divisible by ten in the end, it is valid
		for(int i = digits.length() - 1; i >= 0; i--){
			//iterate through the digits backward
			//set the current digit
			int current = Integer.parseInt(digits.substring(i, i + 1));
			if(j % 2 == 0){
				//if the current index from the back is even, double the current digit
				current *= 2;
				//if that double of the current digit, then subtract 9
				if(current >= 10){
					current -= 9;
				}
				//add current to sum
				sum += current;
			} else {
				//if the current index from the back is odd, simply add it to the sum
				sum += current;
			}
			j++;
			//j switches from odd to even and vice-versa
		}
		//if sum is divisible by ten, then return true
		return sum % 10 == 0;
	}
	
	@Test
	public void test(){
		int a = 1234;
		assert(!luhn(a));
		
		int b = 123456789;
		assert(!luhn(b));
		
		int c = 14121412;
		assert(luhn(c));
		
		int d = 4131231;
		assert(luhn(d));
	}
}
