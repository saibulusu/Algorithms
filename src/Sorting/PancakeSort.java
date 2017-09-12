package Sorting;

public class PancakeSort {
	
	public static int[] pancakeSort(int[] array){
		for(int size = array.length; size > 1; size--){
			int maxIndex = maxElementIndex(array, size);
			if(maxIndex != size - 1){
				flip(array, maxIndex);
				flip(array, size - 1);
			}
		}
		return array;
	}
	
	public static int maxElementIndex(int[] array, int end){
		int index = 0;
		for(int i = 0; i < end; i++){
			if(array[index] < array[i]){
				index = i;
			}
		}
		return index;
	}
	
	public static void flip(int[] array, int end){
		int start = 0;
		while(start <= end){
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args){
		int[] array = {0, -3, 10, 3, 4, 3, 9, 17, -10, 43};
		int[] sorted = pancakeSort(array);

		for(int i = 0; i < array.length; i++){
			System.out.print(sorted[i] + " ");
		}
	}
}
