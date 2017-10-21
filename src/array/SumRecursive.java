package array;

import org.junit.Test;

public class SumRecursive {

	//return the sum of every element in the array
	public static int sum(int[] array){
		
		if(array.length == 0) return 0;
		
		//use the recursive method with indices 0 and array.length - 1
		return sum(array, 0, array.length - 1);
	}
	
	//recursive method to find the sum between index start and index end inclusive
	public static int sum(int[] array, int start, int end){
		//base case: start and end are equal -> return the current value
		if(start == end){
			return array[start];
		}
		//recursion: return the current value + this method called on everything after this value
		return array[start] + sum(array, start + 1, end);
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
