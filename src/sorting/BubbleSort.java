package sorting;

import org.junit.Test;

public class BubbleSort {

  public static int[] bubbleSort(int[] array) {
    // iterate through the whole array besides the last value
    for (int i = 0; i < array.length - 1; i++) {
      // for each iteration, iterate through the whole array besides the last i values
      for (int j = 0; j < array.length - 1 - i; j++) {
        // if the current value is greater than the value after it, swap
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
    return array;
  }

  public static boolean isSorted(int[] array) {
    if (array.length == 0)
      return true;
    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[i - 1]) {
        return false;
      }
    }
    return true;
  }

  @Test
  public void test() {
    int[] arr1 = {0, -3, 10, 3, 4, 3, 9, 17, -10, 43};
    bubbleSort(arr1);

    assert (isSorted(arr1));



    int[] arr2 = {0, 1, -1, 2, -2, 3, -3, 4, -4};
    bubbleSort(arr2);

    assert (isSorted(arr2));



    int[] arr3 = {8, 7, 6, 5, 4, 3, 2, 1, 0};
    bubbleSort(arr3);

    assert (isSorted(arr3));
  }

}
