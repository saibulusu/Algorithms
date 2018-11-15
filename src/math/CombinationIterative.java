package math;
 import org.junit.Test;
 public class CombinationIterative {
	
	//find n choose r, or nCr
	public static int choose(int n, int r){
		//the formula is: nCr = n! / ((n-r)! * r!)
		return factorial(n) / (factorial(n - r) * factorial(r));
	}
	
	
	//find a number x's factorial value recursively
	public static int factorial(int x){
		/*
		 * if the value of x is less than or equal to 1 (1 or 0), return 1
		 * otherwise, return the product of x and (x-1)!
		 */
		return (x <= 1) ? 1 : x * factorial(x - 1);
	}
	
	@Test
	public void test(){		
		for(int i = 0; i < 10; i++){
			assert(choose(i, 0) == 1);
			assert(choose(i, i) == 1);
		}
		
		for(int i = 1; i < 10; i++){
			assert(choose(i, 1) == i);
			assert(choose(i, i - 1) == i);
		}
		
		for(int i = 0; i < 10; i++){
			int k = 0;
			for(int j = 0; j <= i; j++){
				k += choose(i, j);
			}
			
			assert(k == Math.pow(2, i));
		}
		
	}
}
