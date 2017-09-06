package Sorting;

public class MergeSort {
	
	public static void mergeSort(int[] array){
		int[] temp = new int[array.length];
		sort(array, temp, 0, array.length - 1);
	}
	
	public static void sort(int[] array, int[] temp, int leftStart, int rightEnd){
		if(leftStart >= rightEnd){
			return;
		} else {
			int middle = (leftStart + rightEnd)/2;
			sort(array, temp, leftStart, middle);
			sort(array, temp, middle + 1, rightEnd);
			merge(array, temp, leftStart, rightEnd);
		}
	}
	
	public static void merge(int[] array, int[] temp, int leftStart, int rightEnd){
		int leftEnd = (rightEnd + leftStart)/2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		while(left <= leftEnd && right <= rightEnd){
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
	
	
	public static void main(String[] args){
		int[] array = {0, -3, 10, 3, 4, 3, 9, 17, -10, 43};
		mergeSort(array);
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
	}
}









