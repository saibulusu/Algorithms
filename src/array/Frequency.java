package array;

import org.junit.Test;

public class Frequency {
	
	//find the frequency of a given value in an array
	public static int frequency(int[] array, int x){
		//set count to 0, this will be the actual occurrence of x
		int count = 0;
		for(int i = 0; i < array.length; i++){
			//iterate through the whole array, and if the current value is x, increment count
			if(array[i] == x)
				count++;
		}
		return count;
	}
	
	@Test
	public void test(){
		int[] a = {};
		assert(frequency(a, 0) == 0);
		assert(frequency(a, 1) == 0);
		
		int[] b = {9, 3, 1, 4, 3, 3, 3, 3};
		assert(frequency(b, 0) == 0);
		assert(frequency(b, 1) == 1);
		assert(frequency(b, 2) == 0);
		assert(frequency(b, 3) == 5);
		
		int[] c = {6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6};
		assert(frequency(c, 6) == c.length);
		assert(frequency(c, 4) == 0);
		assert(frequency(c, -1) == 0);
		assert(frequency(c, -2) != 3);
		
	}
	
}
