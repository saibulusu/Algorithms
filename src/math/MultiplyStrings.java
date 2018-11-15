package math;
 import org.junit.Test;
 public class MultiplyStrings {
 	//multiply two strings that represent a number
	public static int multiply(String x, String y){
		//shift according to the sign of the two numbers
		int shift = 1;
		if(x.charAt(0) == '-'){
			shift *= -1;
			x = x.substring(1);
		}
		if(y.charAt(0) == '-'){
			shift *= -1;
			y = y.substring(1);
		}
		
		//if the length of x or the length of y is 0 after removing sign, then throw an error
		if(x.length() == 0 || y.length() == 0){
			throw new IllegalArgumentException();
		}
		
		//multiply character by character and add to value
		int value = 0;
		
		//iterate through the entire string for x and y
		for(int i = 0; i < x.length(); i++){
			//take the current value and multiply by the appropriate power of 10
			int alpha = x.charAt(i) - 48;
			alpha *= Math.pow(10, x.length() - 1 - i);
			for(int j = 0; j < y.length(); j++){
				int beta = y.charAt(j) - 48;
				beta *= Math.pow(10, y.length() - 1 - j);
				//multiply the two current values
				value += alpha * beta;
			}
		}
		
		
		//return according to sign
		return value * shift;
	}
	
	@Test
	public void test(){
		assert(multiply("1", "1") == 1);
		assert(multiply("1", "2") == 2);
		assert(multiply("1", "10") == 10);
		assert(multiply("40", "50") == 2000);
		assert(multiply("-1", "50") == -50);
		assert(multiply("900", "-50") == -45000);
		assert(multiply("-5", "-100") == 500);
		assert(multiply("-1", "1") == -1);
	}
	
}