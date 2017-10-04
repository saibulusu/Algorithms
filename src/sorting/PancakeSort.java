package sorting;

import org.junit.Test;

public class PancakeSort {
	
	public static int[] pancakeSort(int[] array){
		//iterate through the whole array backwards
		for(int size = array.length; size > 1; size--){
			//calculate maxIndex
			int maxIndex = maxElementIndex(array, size);
			if(maxIndex != size - 1){
				//while the maxIndex is not right before the size index, flip everything 
				//before the size index
				flip(array, maxIndex);
				flip(array, size - 1);
			}
		}
		return array;
	}
	
	//calculate the maximum element starting at 0 before end in a given array
	public static int maxElementIndex(int[] array, int end){
		//iterate through everything before end
		int index = 0;
		for(int i = 0; i < end; i++){
			//if the current value is greater than max, re-evaluate max
			if(array[index] < array[i]){
				index = i;
			}
		}
		return index;
	}

	//flip everything in the array from 0 to end inclusive
	public static void flip(int[] array, int end){
		//start at 0
		int start = 0;
		//go through the whole array from 0 to end and reverse elements
		while(start <= end){
			//swap the values at start and end
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			//update start and end
			start++;
			end--;
		}
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
		pancakeSort(arr1);

		assert(isSorted(arr1));
		
		
		
		int[] arr2 = {0, 1, -1, 2, -2, 3, -3, 4, -4};
		pancakeSort(arr2);
		
		assert(isSorted(arr2));
		
		
		
		int[] arr3 = {8, 7, 6, 5, 4, 3, 2, 1, 0};
		pancakeSort(arr3);
		
		assert(isSorted(arr3));
	}	
}
























