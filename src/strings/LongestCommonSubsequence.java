package strings;

import org.junit.Test;

public class LongestCommonSubsequence {

	//Find the length of the longest common subsequence between two Strings
	public static int lengthOfLCS(String a, int aStop, String b, int bStop) {
		//Base case: if the stopper index is less than 0 for either, then return 0
		if(aStop == -1 || bStop == -1) return 0;
		
		//create char arrays because they are easier to index and compare
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();
		
		//if the current char in both is the same
		if(A[aStop] == B[bStop]) {
			//return recursively: go back one in each String and add one
			return lengthOfLCS(a, aStop - 1, b, bStop - 1) + 1;
		}
		
		//else, compute the length of both String without removing one character
		int alpha = lengthOfLCS(a, aStop - 1, b, bStop);
		int beta = lengthOfLCS(a, aStop, b, bStop - 1);
		
		//return the max value between these two computations
		return Math.max(alpha, beta);
	}
	
	public static int lengthOfLCS(String a, String b) {
		return lengthOfLCS(a, a.length() - 1, b, b.length() - 1);
	}
	
	@Test
	public void test() {
		String a = "abc";
		String b = "cba";
		
		assert(lengthOfLCS(a, b) == 1);
		
		String c = "Hello, World!";
		String d = "e,djajgle";
		
		assert(lengthOfLCS(c, d) == 3);
	}
}
