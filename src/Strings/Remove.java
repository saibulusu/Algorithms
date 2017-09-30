package Strings;

import org.junit.Test;

public class Remove {
	
	//remove every instance of the characters in array
	public static String remove(String string, char[] array){
		//iterate through everything in array
		for(char c : array){
			//iterate through each character in the string
			for(int i = 0; i < string.length(); i++){
				//if the current character is the current character in array
				if(c == string.charAt(i))
					//reset string to everything before and after that character from array
					string = string.substring(0, i) + string.substring(i + 1);
			}
		}
		return string;
	}

	@Test
	public void test(){
		char[] array = {'a', 'e', 'i', 'o', 'u'};
		
		String a = "hello";
		
		assert(remove(a, array).equals("hll"));
		
		String b = "programming";
		
		assert(remove(b, array).equals("prgrmmng"));
		
		String c = "java";
		
		assert(remove(c, array).equals("jv"));
	}
}
