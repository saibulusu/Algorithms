package array;

import org.junit.Test;

public class Rotate {

	//rotate an array shift times
	public static int[] rotate(int[] array, int shift){
		if(array.length <=  1) return array;
		//if the array length is 0 or 1, no rotation will change that
		shift %= array.length;
		//no need to shift more than the length of the array
		for(int i = 0; i < shift; i++){
			//rotate the array shift times
			rotate(array);
		}
		return array;
	}
	
	//rotate the array
	public static void rotate(int[] array){
		//start from the back and swap with the previous value
		for(int i = array.length - 1; i > 0; i--){
			int temp = array[i];
			array[i] = array[i - 1];
			array[i - 1] = temp;
		}
	}
	
	@Test
	public void test(){
		int[] a = {};
		assert(rotate(a, 3) == a);
		
		int[] b = {0, 1, 2};
		assert(rotate(b, 4)[0] == 2);
		
		int[] c = {0, 0, 0, 0, 0};
		assert(rotate(c, 3) == rotate(c, 4));
		
		int[] d = {1, 2, 3, 4, 5};
		assert(rotate(d, 4) == rotate(d, 9));
	}
	
}
