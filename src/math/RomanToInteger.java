package math;
 import java.util.HashMap;

import org.junit.Test;
 public class RomanToInteger {
 	//convert a string s representing Roman numerals to an integer
	public int convert(String s) {
		//place all conversion keys in a HashMap
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
 		//create an array for all of the characters in this string
		int[] array = new int[s.length()];
		for (int i = 0; i < array.length; i++) {
			//convert each character to the int
			array[i] = map.get(s.charAt(i));
		}
 		//iterate through the whole array and check compare with every other value after it
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				/*
				 * if the current value is greater than something following it, then this value
				 *is meant to be subtracted
				 */
				if (array[j] > array[i]) {
					array[i] *= -1;
					break;
				}
			}
		}
 		//now that the array is changed, add everything in the entire array and return
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			count += array[i];
		}
 		return count;
	}
	
	@Test
	public void test(){
		String a = "I";
		assert(convert(a) == 1);
		
		String b = "II";
		assert(convert(b) == 2);
		
		String c = "IV";
		assert(convert(c) == 4);
		
		String d = "V";
		assert(convert(d) == 5);
		
		String e = "C";
		assert(convert(e) == 100);
		
		String f = "XCVIII";
		assert(convert(f) == 98);
		
		String g = "CMXCIX";
		assert(convert(g) == 999);
	}
 }