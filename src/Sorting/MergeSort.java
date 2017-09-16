package Sorting;

import org.junit.Test;

public class MergeSort {
	
	public static void mergeSort(int[] array){
		int[] temp = new int[array.length];
		//sort, using temp, from 0 to the length of the array - 1
		sort(array, temp, 0, array.length - 1);
	}
	
	//recursive method
	public static void sort(int[] array, int[] temp, int leftStart, int rightEnd){
		//base case : the leftStart and rightEnd have reached each other
		if(leftStart >= rightEnd){
			return;
		} else {
			//keep recalculating middle index, to be halfway between leftStart and rightEnd
			int middle = (leftStart + rightEnd)/2;
			//sort everything from leftStart to middle inclusive
			sort(array, temp, leftStart, middle);
			//sort everything after middle to right End inclusive
			sort(array, temp, middle + 1, rightEnd);
			//sort everything form leftStart to rightEnd inclusive
			merge(array, temp, leftStart, rightEnd);
		}
	}
	
	public static void merge(int[] array, int[] temp, int leftStart, int rightEnd){
		//initialize leftEnd to midway between leftStart and rightEnd, 
		//rightStart to one index after leftEnd
		int leftEnd = (rightEnd + leftStart)/2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		
		//left and right are used to iterate through both segments of the array
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		//iterate through both segments of the array
		while(left <= leftEnd && right <= rightEnd){
			//place the smaller value between the two in both segments, and increment the index
			if(array[left] <= array[right]){
				temp[index] = array[left];
				index++;
				left++;
			} else {
				temp[index] = array[right];
				index++;
				right++;
			}
		}

		int splash = index;
		
		//if left or right is still less than the length of the array segment
		//place all remaining values of the array segments into the array
		for(int i = left; i <  leftEnd + 1; i++){
			temp[index] = array[i];
			index ++;
		}
		index = splash;
		
		for(int i = right; i < rightEnd + 1; i++){
			temp[index] = array[i];
			index++;
		}
		index = splash;

		for(int i = leftStart; i < leftStart + size; i++){
			array[i] = temp[i];
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
		mergeSort(arr1);

		assert(isSorted(arr1));
		
		
		
		int[] arr2 = {0, 1, -1, 2, -2, 3, -3, 4, -4};
		mergeSort(arr2);
		
		assert(isSorted(arr2));
		
		
		
		int[] arr3 = {8, 7, 6, 5, 4, 3, 2, 1, 0};
		mergeSort(arr3);
		
		assert(isSorted(arr3));
	}	

}









