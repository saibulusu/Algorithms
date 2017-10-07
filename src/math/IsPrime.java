package math;

import org.junit.Test;

public class IsPrime {
	
	//check if a given number n is prime
	public static boolean isPrime(int n){
		/*
		 * if n is one, then this is an edge case, because one is neither prime nor composite
		 * this means that it should still return false for not being prime
		 */
		if(n == 1) return false;
		//iterate through everything from 2 to the square root of n
		for(int i = 2; i <= Math.sqrt(n); i++){
			/*
			 * if the current value divides n, return false
			 * 1 can never be the current value, and neither can n itself
			 */
			if(n % i == 0) return false;
		} return true;
		//if in every scenario, n cannot be divided, then n is prime
	}
	
	@Test
	public void test(){
		int a = 1;
		assert(!isPrime(a));
		
		int b = 2;
		assert(isPrime(b));
		
		int c = 3;
		assert(isPrime(c));
		
		int d = 4;
		assert(!isPrime(d));
		
		int e = 10;
		assert(!isPrime(e));
		
		int f = 12;
		assert(!isPrime(f));
		
		int g = 37;
		assert(isPrime(g));
	}
	
}
