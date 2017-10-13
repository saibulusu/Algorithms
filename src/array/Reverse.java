package array;

import org.junit.Test;

public class Reverse {
	
	//reverse an array
	public static int[] reverse(int[] array){
		//iterate through the first half of the array
		for(int i = 0; i < array.length / 2; i++){
			//swap the current value with the value at the other end
			int temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
		return array;
	}

	@Test
	public void test(){
		int[] a = {};
		assert(reverse(a).length == 0);
		
		int[] b = {0, 1, 2, 3};
		reverse(b);		
		assert(b[3] == 0);
		assert(b[2] == 1);
		assert(b[1] == 2);
		assert(b[0] == 3);
		
		int[] c = {0, 0, 0};
		assert(reverse(c) == c);
		
		int[] d = {0, 2, 3, 1, 3, 2, 5, 1, -1};
		reverse(d);
		assert(d.length == 9);
		assert(d[0] == -1);
		assert(d[1] == 1);
	}
}
