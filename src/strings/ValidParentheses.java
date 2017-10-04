package strings;

import org.junit.Test;

public class ValidParentheses {

	//check if an orientation of parentheses is valid
	public static boolean isValid(String string){
		int count = 0;
		//start count at 0, which resets to 0 every time the string is valid
		for(int i = 0; i < string.length(); i++){
			//iterate through the whole string
			if(string.charAt(i) == '('){
				//if it is an opening parentheses sign, increment count
				count++;
			} else{
				//otherwise, if count is zero, then it is valid until this character which
				//is a closing parentheses
				if(count == 0){
					return false;
				} else {
					//last case: decrement count, so it is still valid
					count--;
				}
			}
			//return true if the count is 0
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
