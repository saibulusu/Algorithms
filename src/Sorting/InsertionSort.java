package Sorting;

import org.junit.Test;

public class InsertionSort {
	
	public static int[] insertionSort(int[] array){
		//iterate through the whole array
		for(int i = 0; i < array.length; i++){
			//the previous value in the array, will be compared
			int j = i - 1;
			int key = array[i];
			
			//choose the next index in the array and place it in the proper location in the sorted
			//section at the beginning of the array
			while(j >= 0 && key < array[j]){
				//rotate all of the values already in the sorted section of the array
				//into the chosen index
				int temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				j--;
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
		insertionSort(arr1);

		assert(isSorted(arr1));
		
		
		
		int[] arr2 = {0, 1, -1, 2, -2, 3, -3, 4, -4};
		insertionSort(arr2);
		
		assert(isSorted(arr2));
		
		
		
		int[] arr3 = {8, 7, 6, 5, 4, 3, 2, 1, 0};
		insertionSort(arr3);
		
		assert(isSorted(arr3));
	}	

	
}
