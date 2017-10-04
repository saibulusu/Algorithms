package sorting;

import org.junit.Test;

public class CountingSort {
	
	public static int[] countingSort(int[] array){
		//determine the max value in this array
		int max = array[0];
		
		//iterate through the whole array and check if the value at this index is already
		//greater than the max 
		for(int i = 0; i < array.length; i++){
			max = Math.max(array[i], max);
		}

		//array to record the number of counts,
		//meaning all of the remainders when divided by max
		int[] counts = new int[max + 1];
		//iterate through the whole array
		for(int i = 0; i < array.length; i++){
			//the remainders count when divided by max are added to this array
			counts[i%max]++;
		}
		
		//copy the array, sorted count is zero, meaning the number of elements already sorted
		int[] copy = array;
		int sorted = 0;
		
		//iterate through the counts array
		for(int i = 0; i < counts.length; i++){
			int count = counts[i];
			//iterate to each element in the array from zero (0, 1, 2, ..., count - 1)
			for(int j = 0; j < count; j++){
				//place i into the array, at sorted, increment sorted
				array[sorted] = i;
				sorted++;
			}
		}
		return array;
	}
	
	public static boolean isSorted(int[] array){
		if(array.length == 0) return true;
		for(int i = 1; i < array.length; i++){
			if(array[i] < array[i - 1]){
				return false;
			}
		} return true;
	}
	
	@Test
	public void test(){
		int[] arr1 = {0, -3, 10, 3, 4, 3, 9, 17, -10, 43};
		countingSort(arr1);

		assert(isSorted(arr1));
		
		
		
		int[] arr2 = {0, 1, -1, 2, -2, 3, -3, 4, -4};
		countingSort(arr2);
		
		assert(isSorted(arr2));
		
		
		
		int[] arr3 = {8, 7, 6, 5, 4, 3, 2, 1, 0};
		countingSort(arr3);
		
		assert(isSorted(arr3));
	}	

		
	
}
