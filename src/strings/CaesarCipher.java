package strings;

import org.junit.Test;

public class CaesarCipher {
	
	//given a string and a shift value, decrypt the string
	public static String decrypt(String string, int shift){
		String caesar = "";
		//start with an empty string
		shift = shift % 26;
		//find the remainder when divided by 26, because rotating by 26 multiple times does not matter
		for(int i = 0; i < string.length(); i++){
			//iterate though the whole string for each character
			char current = string.charAt(i);
			int iCurrent = (int)(string.charAt(i));
			//convert the current character via ascii and rotate the character
			iCurrent += shift;
			//if the character is out of bounds, set it back in bounds
			if(iCurrent > 122){
				iCurrent -= 26;
			}
			if(iCurrent < 97){
				iCurrent += 26;
			}
			//convert the number back into a char, and append to the string
			current = (char)(iCurrent);
			caesar += current;
		}
		//return the string
		string = caesar;
		return string;
	}
	
	//encrypt a given string by the value shift for rotation
	public static String encrypt(String string, int shift){
		String caesar = "";
		//find the remainder when dividing by 26, because rotating by 26 multiple times does not matter
		shift = shift % 26;
		for(int i = 0; i < string.length(); i++){
			//iterate through the whole string for each character
			char current = string.charAt(i);
			int iCurrent = (int)(string.charAt(i));
			//take the current value and convert to int, subtract shift
			iCurrent -= shift;
			//if the character is out of bounds, set it back in bounds
			if(iCurrent > 122){
				iCurrent -= 26;
			}
			if(iCurrent < 97){
				iCurrent += 26;
			}
			//convert the int back into a char and append into the string
			current = (char)(iCurrent);
			caesar += current;
		}
		//return the string
		string = caesar;
		return string;
	}
	
	
	@Test
	public void test(){
		String a = "a";
		assert(decrypt(a, 5).equals("f"));
		
		String b = "z";
		assert(decrypt(b, 5).equals("e"));
		
		String c = "abcdefghijklmnopqrstuvwxyz";
		assert(decrypt(c, 26).equals(c));
		assert(decrypt(c, -1).equals("zabcdefghijklmnopqrstuvwxy"));
		
		String d = "helloworld";
		d = encrypt(d, 1);
		assert(d.equals("gdkknvnqkc"));
		assert(decrypt(d, 1).equals("helloworld"));
		
		int i = (int)(Math.random() * 100);
		String e = "programminginjavaisgreat";
		assert(decrypt(encrypt(e, i), i).equals(e));
	}
}







