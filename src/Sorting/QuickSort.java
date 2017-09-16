package Sorting;

import org.junit.Test;

public class QuickSort {
	
	//quickSort from 0 to the last index of the array
	public static int[] quickSort(int[] array){
		return quickSort(array, 0, array.length - 1);
	}

	//recursive quickSort from left to right inclusive
	public static int[] quickSort(int[] array, int left, int right){
		//partition the array
		int index = partition(array, left, right);
		
		//if left is to the left of index - 1, sort everything in this range
		if(left < index - 1){
			array = quickSort(array, left, index - 1);
		}
		
		//if right is to the right of index, sort everything in this range
		if(right > index){
			array = quickSort(array, index, right);
		}
		return array;
	}
	
	//partition the array from left to right inclusive
	public static int partition(int[] array, int left, int right){
		//choose a pivot randomly
		int pivot = array[(int)(Math.random() * array.length)];
		
		//from left to right, array[left] and array[right] to pivot,
		//then swap the two values and move in closer to the pivot
		while(left < right){
			while(array[left] < pivot){
				left++;
			}
			
			while(array[right] > pivot){
				right--;
			}
			
			if(left <= right){
				//swap left and right
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				//increment and decrement left and right respectively, more close to pivot
				left++;
				right--;
			}
		}
		return left;
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
		quickSort(arr1);

		assert(isSorted(arr1));
		
		
		
		int[] arr2 = {0, 1, -1, 2, -2, 3, -3, 4, -4};
		quickSort(arr2);
		
		assert(isSorted(arr2));
		
		
		
		int[] arr3 = {8, 7, 6, 5, 4, 3, 2, 1, 0};
		quickSort(arr3);
		
		assert(isSorted(arr3));
	}	

}
