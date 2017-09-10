package Sorting;

public class BogoSort {
	
	public static int[] bogoSort(int[] array){
		while(!isSorted(array)){
			shuffle(array);
		}
		return array;
	}
	
	public static void shuffle(int[] array){
		int index1 = (int)(Math.random() * (array.length));
		int index2 = (int)(Math.random() * (array.length));
		
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public static boolean isSorted(int[] array){
		for(int i = 0; i < array.length - 1; i++){
			if(array[i] > array[i+1]){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		int[] array = {0, -3, 10, 3, 4, 3, 9, 17, -10, 43};
		int[] sorted = bogoSort(array);
		for(int i = 0; i < sorted.length; i++){
			System.out.print(sorted[i] + " ");
		}
	}
	
}
