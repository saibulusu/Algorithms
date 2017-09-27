package Math;

import org.junit.Test;

public class Combination {

	//find n choose r, or nCr
	public static int choose(int n, int r){
		//if n chooses 0 or itself, return 1, because there is only one way to do either of those
		if(r == 0 || r == n) return 1;
		//recursively return the two values in Pascla's triangle directly above nCr
		return choose(n - 1, r - 1) + choose(n - 1, r);
	}
	
	
	@Test
	public void test(){
		
		assert(choose(0,0) == 1);		
		assert(choose(1,0) == 1);
		assert(choose(1,1) == 1);
		assert(choose(2,0) == 1);
		assert(choose(2,1) == 2);
		assert(choose(2,2) == 1);
		assert(choose(3,0) == 1);
		assert(choose(3,1) == 3);
		assert(choose(3,2) == 3);
		assert(choose(3,3) == 1);
		
	}
	
}
