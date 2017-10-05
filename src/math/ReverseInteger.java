package math;

import org.junit.Test;

public class ReverseInteger {
	
	//reverse the digits of a given integer x
    public int reverse(int x) {
    	//convert the int to a string, and set up an empty string which we will return
		String x1 = "" + x;
		String y1 = "";
		//if the zeroth char is negative, disregard it for now
		if(x1.charAt(0) == '-'){
			x1 = x1.substring(1);
			//iterate through and add in the opposite order to the other string
			for(int i = 0; i < x1.length(); i++){
				y1 += x1.charAt(x1.length() - 1 - i);
			}
			//add a negative if necessary
			y1 = "-" + y1;
		} else{
			//if no negative is needed, just do the conversion
			for(int i = 0; i < x1.length(); i++){
				y1 += x1.charAt(x1.length() - 1 - i);
			}
		}
		//if converting the string back to an int returns an exception, then return 0
		//in this case, the integer is clearly out of bounds
		try {
			return Integer.parseInt(y1);
		} catch (NumberFormatException n){
			return 0;
		}

    }
	
	@Test
	public void test(){
		assert(reverse(-1) == -1);
		
		assert(reverse(1) == 1);
		
		assert(reverse(0) == 0);
		
		assert(reverse(100) == 1);
		
		assert(reverse(572840183) == 381048275);
		
		assert(reverse(-100394400) == -4493001);
	}
}
