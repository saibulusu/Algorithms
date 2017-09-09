package Searching;

public class BinarySearch {

        public static int binarySearch(int[] array, int target){
                int left = 0;
		int right = array.length - 1;
		while(left < right){
			int mid = (left + right) / 2;
			if(array[mid] < target){
				left = mid + 1;
			} else if(array[mid] > target){
				right = mid;
			} else {
				return mid;
			}
		}
                return -1;
        }

        public static void main(String[] args){
                int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
                int index = binarySearch(array, 9);
                System.out.println(index);
        }

}
