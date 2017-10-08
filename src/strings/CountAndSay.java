package strings;

import org.junit.Test;

public class CountAndSay {

	public static String countAndSay(int n) {
		//Start at String s is "1", and work up to n
		String s = "1";
		while ((n--) > 1) {
			//if the number is greater than 2
			String temp = "";
			//start at 1, and go up to the length of the string, and add 1
			int count = 1;
			for (int i = 1; i < s.length(); i++) {
				//if the current char is not the same as the previous char
				if (s.charAt(i) != s.charAt(i - 1)) {
					/*
					 * stop counting
					 * add count as well as the char being counted to the new string
					 */
					temp += count;
					temp += s.charAt(i - 1);
					//reset count
					count = 1;
				} else {
					//otherwise, just add count, if the two chars are equal
					count++;
				}
			}
			
			//the last char being repeated or not has not yet been added
			temp += count;
			temp += s.charAt(s.length() - 1);
			s = temp;
		}
		return s;
	}
	
	@Test
	public void test(){
		assert(countAndSay(1).equals("1"));
		
		assert(countAndSay(2).equals("11"));
		
		assert(countAndSay(3).equals("21"));
		
		assert(countAndSay(4).equals("1211"));
		
		assert(countAndSay(5).equals("111221"));
	}

}
