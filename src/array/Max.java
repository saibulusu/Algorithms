package array;

import org.junit.Test;

public class Max {
	
	//find the maximum value in an array of integers
	public static int max(int[] array) throws Exception{
		//if the length of the array is 0, throw an exception
		if(array.length == 0) throw new Exception();
		//set max to the zeroth value
		int max = array[0];
		for(int i = 0; i < array.length; i++){
			/*
			 * iterate through the whole array
			 * set max to the greater value between max and the current value
			 */
			max = Math.max(array[i], max);
		}
		return max;
	}
	
	@Test
	public void test() throws Exception{
		int[] a = {0};
		assert(max(a) == 0);
		
		int[] b = {0, 1};
		assert(max(b) == 1);
		
		int[] c = {0, 100, 2, 4, 6, 2, 4, 2, 3, 5, 2, 4, 3, 6};
		assert(max(c) == 100);
	}
	
}
