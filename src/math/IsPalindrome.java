package math;
 import org.junit.Test;
 public class IsPalindrome {
	
	//check if a given integer is a palindrome
	public static boolean isPalindrome(int x){
		int copy = x;
		//create a copy of x so that we don't have to change it
		int y = 0;
		//y will become the palimage of x
		
		/* 
		 * while the copy is not 0, keep adding the last digit of copy to the back of y,
		 * multiply y by time right afterwards
		 */
		while(copy != 0){
			y *= 10;
			y += copy % 10;
			//dividing copy by 10 will help it reach 0
			copy /= 10;
		}
		
		//if x and y, after copy reaches 0, are equal, then x is a paindrome
		return x == y;
	}
	
	
	@Test
	public void test(){
		assert(isPalindrome(0));
		assert(isPalindrome(1));
		assert(isPalindrome(2));
		assert(isPalindrome(9));
		assert(!isPalindrome(15));
		assert(!isPalindrome(20));
		assert(isPalindrome(22));
		assert(isPalindrome(33));
		assert(!isPalindrome(100));
		assert(isPalindrome(101));
		assert(isPalindrome(111));
		assert(isPalindrome(121));
		assert(!isPalindrome(200));
		assert(!isPalindrome(1000));
		assert(!isPalindrome(1003));
		assert(isPalindrome(203040302));
	}
}