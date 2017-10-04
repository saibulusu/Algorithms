package sorting;

import org.junit.Test;

public class BogoSort {
	
	public static int[] bogoSort(int[] array){
		//while the array is not sorted, continue to shuffle the array
		while(!isSorted(array)){
			shuffle(array);
		}
		return array;
	}
	
	public static void shuffle(int[] array){
		//choose two indices of this array at random
		int index1 = (int)(Math.random() * (array.length));
		int index2 = (int)(Math.random() * (array.length));
		
		//swap those two indices
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public static boolean isSorted(int[] array){
		//iteratively check if this array is already sorted
		//return true if there are no values in the array
		if(array.length == 0) return true;
		//iterate through the whole array
		for(int i = 1; i < array.length; i++){
			// if the current value is less than the previous value, then the array is not sorted
			if(array[i] < array[i - 1]){
				return false;
			}
		} return true;
	}
	
	@Test
	public void test(){
		int[] arr1 = {0, -3, 10, 3, 4, 3, 9, 17, -10, 43};
		bogoSort(arr1);

		assert(isSorted(arr1));
		
		
		
		int[] arr2 = {0, 1, -1, 2, -2, 3, -3, 4, -4};
		bogoSort(arr2);
		
		assert(isSorted(arr2));
		
		
		
		int[] arr3 = {8, 7, 6, 5, 4, 3, 2, 1, 0};
		bogoSort(arr3);
		
		assert(isSorted(arr3));
	}	
	
}
