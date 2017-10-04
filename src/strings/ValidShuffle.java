package strings;

import org.junit.Test;

public class ValidShuffle {
	
	//Check if the characters of a and b appear in their proper order within string
	public static boolean validShuffle(String string, String a, String b){
		//if the lengths do not add up, then this is definitely not a valid shuffle
		if(string.length() != a.length() + b.length()){
			return false;
		}
		
		//counting the indices of aCount and bCount
		int aCount = 0;
		int bCount = 0;
		
		//iterate through each character in string
		for(int i = 0; i < string.length(); i++){
			//if the values of aCount or bCount are out of range, then string is no a valid shuffle
			if(aCount > a.length() || bCount > b.length()){ 
				return false;
			}
			//aCount and bCount should not be out of range still
			//increment aCount if the character at aCount in a is the current character in string
			if(aCount < a.length() && string.charAt(i) == a.charAt(aCount)){
				aCount++;
			} else if(bCount < b.length() && string.charAt(i) == b.charAt(bCount)){
				//same logic for b and bCount
				bCount++;
			} else {
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void test(){
		String string = "abc";
		String a = "abc";
		String b = "";
		
		assert(validShuffle(string, a, b));
		
		string = "Hello, World!";
		a = "llo,d!";
		b = "He Worl";
		
		assert(validShuffle(string, a, b));
		
		string = "   ";
		a = "   ";
		b = "   ";
		
		assert(!validShuffle(string, a, b));
		
		string = "hello";
		a = "lle";
		b = "ho";
		
		assert(!validShuffle(string, a, b));
	}
	
}







