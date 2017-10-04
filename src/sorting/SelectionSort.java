package sorting;

import org.junit.Test;

public class SelectionSort {
	
	public static int[] selectionSort(int[] array){
		for(int i = 0; i < array.length - 1; i++){
			//compute the index of the smallest value outside of the sorted segment of the array
			int minIndex = i + 1;
			int min = array[minIndex];
			//iterate through the whole array
			for(int j = i + 1; j < array.length; j++){
				if(min > array[j]){
					//if min is greater than the current value, update min
					min = array[j];
					minIndex = j;
				}
			}
			
			//if the array minIndex is less than the current value, swap
			if(array[minIndex] < array[i]){
				//swap the current index with the min value, no rotation
				int temp = min;
				array[minIndex] = array[i];
				array[i] = temp;
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
		selectionSort(arr1);

		assert(isSorted(arr1));
		
		
		
		int[] arr2 = {0, 1, -1, 2, -2, 3, -3, 4, -4};
		selectionSort(arr2);
		
		assert(isSorted(arr2));
		
		
		
		int[] arr3 = {8, 7, 6, 5, 4, 3, 2, 1, 0};
		selectionSort(arr3);
		
		assert(isSorted(arr3));
	}	

	
}
