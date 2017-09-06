package Sorting;

public class SelectionSort {
	
	public static int[] selectionSort(int[] array){
		for(int i = 0; i < array.length - 1; i++){
			int minIndex = i + 1;
			int min = array[minIndex];
			for(int j = i + 1; j < array.length; j++){
				if(min > array[j]){
					min = array[j];
					minIndex = j;
				}
			}
			if(array[minIndex] < array[i]){
				int temp = min;
				array[minIndex] = array[i];
				array[i] = temp;
			}
		}
		return array;
	}
	
	public static void main(String[] args){
		int[] array = {0, -3, 10, 3, 4, 3, 9, 17, -10, 43};
		int[] sorted = selectionSort(array);
		for(int i = 0; i < sorted.length; i++){
			System.out.print(sorted[i] + " ");
		}
	}
	
}
