package Sorting;

import org.junit.Test;

public class CountingSort {
	
	public static int[] countingSort(int[] array){
		int max = array[0];
		
		for(int i = 0; i < array.length; i++){
			max = Math.max(array[i], max);
		}
		
		int[] counts = new int[max + 1];
		for(int i = 0; i < array.length; i++){
			counts[i%max]++;
		}
		
		int[] copy = array;
		int sorted = 0;
		
		for(int i = 0; i < counts.length; i++){
			int count = counts[i];
			
			for(int j = 0; j < count; j++){
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
