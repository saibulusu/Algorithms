package strings;

import org.junit.Test;

public class ReverseRecursive {

	//recursive method
	public static String reverseRecurse(String string) {
		//if the length of the string is 0, return an empty string
		return (string.length() == 0) ? "" : 
			/*
			 * if the length is greater than zero, return the last character and recursively
			 * call reverse on everything before the last character
			 */
			string.charAt(string.length() - 1) + 
			reverseRecurse(string.substring(0, string.length() - 1));
	}

	@Test
	public void test() {
		String a = "Hello, World!";
		a = reverseRecurse(a);

		System.out.println(a);
		assert (a.equals("!dlroW ,olleH"));

		String b = "";
		b = reverseRecurse(b);

		assert (b.equals(""));

		String c = "abababababa";
		c = reverseRecurse(c);

		assert (c.equals("abababababa"));
	}
}
