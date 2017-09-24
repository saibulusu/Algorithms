package Math;

import org.junit.Test;

public class Fibonacci {
	
	//return the nth fibonacci
	public static int fibonacci(int n){
		//if n is 0, return 0, and so if n is 1, return 1
		if(n == 0) return 0;
		if(n == 1) return 1;
		//return the sum of the two previous fibonacci numbers
		return fibonacci(n - 2) + fibonacci(n - 1);
	}
	
	@Test
	public void test(){
		int n = 0;
		assert(fibonacci(n) == 0);
		
		n = 1;
		assert(fibonacci(n) == 1);
		
		n = 2;
		assert(fibonacci(n) == 1);
		
		n = 3;
		assert(fibonacci(n) == 2);
		
		n = 4;
		assert(fibonacci(n) == 3);
	}
	
}
