package Sorting;

public class QuickSort {
	
	public static int[] quickSort(int[] array){
		return quickSort(array, 0, array.length - 1);
	}

	public static int[] quickSort(int[] array, int left, int right){
		int index = partition(array, left, right);
		
		if(left < index - 1){
			array = quickSort(array, left, index - 1);
		}
		if(right > index){
			array = quickSort(array, index, right);
		}
		return array;
	}
	
	public static int partition(int[] array, int left, int right){
		int pivot = array[(int)(Math.random() * array.length)];
		
		while(left < right){
			while(array[left] < pivot){
				left++;
			}
			
			while(array[right] > pivot){
				right--;
			}
			
			if(left <= right){
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}
	
	public static void main(String[] args){
		int[] array = {0, -3, 10, 3, 4, 3, 9, 17, -10, 43};
		int[] sorted = quickSort(array);
		for(int i = 0; i < sorted.length; i++){
			System.out.print(sorted[i] + " ");
		}
	}	
}
