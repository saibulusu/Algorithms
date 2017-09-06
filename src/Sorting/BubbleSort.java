package Sorting;

public class BubbleSort {
	
	public static int[] bubbleSort(int[] array){
		for(int i = 0; i < array.length - 1; i++){
			for(int j = 0; j < array.length - 1 - i; j++){
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}

	public static void main(String[] args){
		int[] array = {0, -3, 10, 3, 4, 3, 9, 17, -10, 43};
		int[] sorted = bubbleSort(array);
		for(int i = 0; i < sorted.length; i++){
			System.out.print(sorted[i] + " ");
		}
	}

}
