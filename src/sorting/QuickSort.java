package sorting;

import org.junit.Test;

public class QuickSort {

  // quickSort from 0 to the last index of the array
  public static int[] quickSort(int[] array) {
    quickSort(array, 0, array.length - 1);
    return array;
  }

  public static void quickSort(int[] array, int start, int end) {
    if (start < end) {
      int partition = partition(array, start, end);
      quickSort(array, start, partition - 1);
      quickSort(array, partition, end);
    }
  }

  public static int partition(int[] array, int start, int end) {
    int pivot = array[end];
    int index = start;
    for (int i = index; i < end; i++) {
      if (array[i] <= pivot) {
        int temp = array[i];
        array[i] = array[index];
        array[index] = pivot;
        index++;
      }
    }
    int temp = array[index];
    array[index] = array[end];
    array[end] = temp;
    return index;
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
    int[] arr1 = {0, 2, 5, -2, -100, 4};
    quickSort(arr1);

    assert (isSorted(arr1));



    int[] arr2 = {0, 1, -1, 2, -2, 3, -3, 4, -4};
    quickSort(arr2);

    assert (isSorted(arr2));



    int[] arr3 = {8, 7, 6, 5, 4, 3, 2, 1, 0};
    quickSort(arr3);

    assert (isSorted(arr3));

    int[] arr4 = {2, 1, 3, 6, 8, 5, 7, 4};
    quickSort(arr4);

    assert (isSorted(arr4));
  }

}
