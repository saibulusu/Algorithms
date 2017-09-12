package Searching;

import org.junit.Test;

public class BinarySearch {

	public static int binarySearch(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (array[mid] < target) {
				left = mid + 1;
			} else if (array[mid] > target) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	@Test
	public void test(){
		int[] arr1 = {0, -3, 10, 3, 4, 3, 9, 17, -10, 43};
		
		int index1 = binarySearch(arr1, 17);
		int index2 = binarySearch(arr1, 43);
		int index3 = binarySearch(arr1, 3);
		int index4 = binarySearch(arr1, 8);
		
		assert(index1 == 7);
		assert(index2 == 9);
		assert(index3 == -1);
		assert(index4 == -1);
		
		
		java.util.Arrays.sort(arr1);
		
		int indexA = binarySearch(arr1, 17);
		int indexB = binarySearch(arr1, 43);
		int indexC = binarySearch(arr1, 3);
		int indexD = binarySearch(arr1, 8);
		
		assert(indexA == 8);
		assert(indexB == 9);
		assert(indexC == 4);
		assert(indexD == -1);
	}	


}
