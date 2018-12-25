package sorting;

import org.junit.Test;

public class HeapSort {

  public static int[] heapSort(int[] array) {
    int[] heap = new int[array.length];
    // heapify this array (min-heap)
    for (int i = 0; i < array.length; i++) {
      enqueue(heap, array[i]);
    }
    // remove from the heap;
    int[] temp = new int[heap.length];
    for (int i = 0; i < temp.length; i++) {
      temp[i] = dequeue(heap);
    }
    return temp;
  }

  public static int dequeue(int[] heap) {
    int value = heap[0];
    heap[0] = heap[heap.length - 1];
    percolateDown(heap, 0);
    int[] temp = new int[heap.length - 1];
    for (int i = 0; i < temp.length; i++) {
      temp[i] = heap[i];
    }
    heap = temp;
    return value;
  }

  public static void enqueue(int[] heap, int value) {
    int[] temp = new int[heap.length + 1];
    for (int i = 0; i < heap.length; i++) {
      temp[i] = heap[i];
    }
    heap = temp;
    heap[heap.length - 1] = value;
    percolateUp(heap, heap.length - 1);
  }

  public static void percolateUp(int[] heap, int index) {
    int parentIndex = (index % 2 == 0) ? index / 2 - 1 : index / 2;
    if (parentIndex >= 0 && heap[parentIndex] > heap[index]) {
      int temp = heap[parentIndex];
      heap[parentIndex] = heap[index];
      heap[index] = temp;
      percolateUp(heap, parentIndex);
    }
  }

  public static void percolateDown(int[] heap, int index) {
    int childIndex = index * 2;
    if (childIndex + 1 < heap.length) {
      if (heap[childIndex] > heap[childIndex + 1]) {
        childIndex ++;
      }
      if (heap[childIndex] < heap[index]) {
        int temp = heap[index];
        heap[index] = heap[childIndex];
        heap[childIndex] = temp;
        percolateDown(heap, childIndex);
      }
    } else if (childIndex < heap.length) {
      if (heap[childIndex] < heap[index]) {
        int temp = heap[index];
        heap[index] = heap[childIndex];
        heap[childIndex] = temp;
        percolateDown(heap, childIndex);
      }
    }
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
  public void test(){
      int[] arr1 = {0, -3, 10, 3, 4, 3, 9, 17, -10, 43};
      arr1 = heapSort(arr1);

      assert(isSorted(arr1));
      
      
      
      int[] arr2 = {0, 1, -1, 2, -2, 3, -3, 4, -4};
      arr2 = heapSort(arr2);
      
      assert(isSorted(arr2));
      
      
      
      int[] arr3 = {8, 7, 6, 5, 4, 3, 2, 1, 0};
      arr3 = heapSort(arr3);
      
      assert(isSorted(arr3));
  }   
}
