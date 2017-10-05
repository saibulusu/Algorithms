package math;

import org.junit.Test;

public class ReverseInteger {

	public static int reverse(int i){
		int j = 0;
		while(i != 0){
			j *= 10;
			j += i % 10;
			i /= 10;
		}
		return j;
		
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
