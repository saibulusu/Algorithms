package array;

import org.junit.Test;

public class TwoSum {

	//find two indices such that the values at those indices sum to target
	public static int[] twoSum(int[] nums, int target){
		int[] solution = new int[2];
		//originally set solution to {-1, -1} in case there is no answer
		solution[0] = -1;
		solution[1] = -1;
		//store the answer (two indices) in an array
		for(int i = 0; i < nums.length; i++){
			//iterate through the whole array
			for(int j = i + 1; j < nums.length; j++){
				//iterate through everything after that array
				if(nums[i] + nums[j] == target){
					//if the two current values sum to target, then these indices are the answer
					solution[0] = i;
					solution[1] = j;
				}
			}
		}
		return solution;
	}
	
	@Test
	public void test(){
		int[] array = {0, 1, 2, 3, 4, 5, 6};
		int alpha = 5;
		
		assert(twoSum(array, alpha)[0] == 2);
		assert(twoSum(array, alpha)[1] == 3);
		
		
		int[] arr = {0, 1, 2};
		int beta = 4;
		
		assert(twoSum(arr, beta)[0] == -1);
		assert(twoSum(arr, beta)[1] == -1);
		
		int[] nums = {0, 3};
		int gamma = 3;
		
		assert(twoSum(nums, gamma)[0] == 0);
		assert(twoSum(nums, gamma)[1] == 1);
	}
	
}
