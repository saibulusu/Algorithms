package searching;

import org.junit.Test;

public class LinearSearch {

	public static int linearSearch(int[] array, int target) {
		//Iterate through the whole array
		for (int i = 0; i < array.length; i++) {
			if (target == array[i]) {
				//If the current index holds the target, then return that index
				return i;
			}
		}
		//The value may not be in the array
		return -1;
	}

	@Test
	public void test() {
		int[] arr1 = { 0, -3, 10, 3, 4, 3, 9, 17, -10, 43 };

		int index1 = linearSearch(arr1, 17);
		int index2 = linearSearch(arr1, 43);
		int index3 = linearSearch(arr1, 3);
		int index4 = linearSearch(arr1, 8);

		assert (index1 == 7);
		assert (index2 == 9);
		assert (index3 == 3);
		assert (index4 == -1);
	}

}
