package array;

import org.junit.Test;

public class Disjoint {

	//given two arrays of integers, check if they have no common values
	public static boolean disjoint(int[] a, int[] b){
		//sort both arrays
		int[] alpha = sort(a);
		int[] beta = sort(b);
		
		
		//iteration indices for a and b
		int aIterate = 0;
		int bIterate = 0;
		
		//iterate through the smaller value between alpha.length and beta.length
		for(int i = 0; i < Math.min(alpha.length, beta.length); i++){
			//if ever, we reach the maximum possible value for aIterate or bIterate, break out
			if(aIterate == a.length || bIterate == b.length)
				break;
			
			//if the current value in a is equal to the current value in b, return false
			if(a[aIterate] == b[bIterate])
				return false;
		}
		
		//if false is never returned, return true
		return true;
	}
	
	//sort an array, using bubble sort
	public static int[] sort(int[] array){
		//iterate through the whole array
		for(int i = 0; i < array.length - 1; i++){
			//forget the last i elements
			for(int j = 0; j < array.length - 1 - i; j++){
				//if the current value is greater than the next value, swap them
				if(array[j] > array[j + 1]){
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}
	
	
	@Test
	public void test(){
		int[] a1 = {0, 4, 1, 4, 2, 4, 3, 1, -1};
		int[] b1 = {5, -2};
		
		assert(disjoint(a1, b1));
		
		int[] a2 = {0, 1, 2, 3, 4, 5, 6};
		int[] b2 = {0, 6, 10};
		
		assert(!disjoint(a2, b2));
		
		int[] a3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
		int[] b3 = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11, -12};
		
		assert(disjoint(a3, b3));
		
		int[] a4 = {};
		int[] b4 = {};
		
		assert(disjoint(a4, b4));
	}
	
}









