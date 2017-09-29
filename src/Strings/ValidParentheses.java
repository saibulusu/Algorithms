package Strings;

import org.junit.Test;

public class ValidParentheses {

	public static boolean isValid(String string){
		int count = 0;
		for(int i = 0; i < string.length(); i++){
			if(string.charAt(i) == '('){
				count++;
			} else{
				if(count == 0){
					return false;
				} else {
					count--;
				}
			}
		} return count == 0;
	}

	@Test
	public void test(){
		String a = "";
		assert(isValid(a));
		
		String b = ")";
		assert(!isValid(b));
		
		String c = "(";
		assert(!isValid(c));
		
		String d = ")(";
		assert(!isValid(d));
		
		String e = "()";
		assert(isValid(e));
		
		String f = "()()";
		assert(isValid(f));
		
		String g = "()(";
		assert(!isValid(g));
		
		String h = ")()(";
		assert(!isValid(h));
	}
}
