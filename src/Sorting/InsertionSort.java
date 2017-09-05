package Sorting;

public class InsertionSort {
	
	public static int[] insertionSort(int[] array){
		for(int i = 0; i < array.length; i++){
			int j = i - 1;
			int key = array[i];
			while(j >= 0 && key < array[j]){
				int temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				j--;
			}
		}
		return array;
	}
	
	public static void main(String[] args){
		int[] array = {0, -3, 10, 3, 4, 3, 9, 17, -10, 43};
		int[] sorted = insertionSort(array);
		for(int i = 0; i < sorted.length; i++){
			System.out.print(sorted[i] + " ");
		}
	}
	
}
