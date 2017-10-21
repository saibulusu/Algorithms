package array;

import org.junit.Test;

public class SumIterative {

	//An iterative method to find the sum of the elements of an array
	public static int sum(int[] array){
		//compute the sum
		int sum = 0;
		//iterate through the array
		for(int i = 0; i < array.length; i++){
			//add the current value to sum
			sum += array[i];
		}
		return sum;
	}
	
	@Test
	public void test(){
		int[] a = {};
		assert(sum(a) == 0);
		
		int[] b = {0, 1, 2, 3, 4, 5};
		assert(sum(b) == 15);
		
		int[] c = {-1, 0, 1};
		assert(sum(c) == 0);
		
		int[] d = {8, 7, 5, 1, 4, 2, 5, 2};
		assert(sum(d) == 34);
	}
	
}
