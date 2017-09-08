package Searching;

public class LinearSearch {

        public static int linearSearch(int[] array, int target){
		for(int i = 0; i < array.length; i++){
			if(target == array[i]){
				return i;
			}
		}
		return -1;
        }

        public static void main(String[] args){
                int[] array = {0, -3, 10, 3, 4, 3, 9, 17, -10, 43};
                int index = linearSearch(array, 9);
                System.out.println(index);
        }

}












