package math;
 import org.junit.Test;
 public class IsComposite {
 	// return if the integer x is composite
	public static boolean isComposite(int x) {
		//if x is 1, then it is not composite
		if (x == 1) return false;
		int count = 0;
		//count the number of divisors greater than 1 but less than the number itself
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0)
				count++;
		}
		//if there are any divisors in that region, then it is composite
		return count > 0;
	}
 	@Test
	public void test() {
		int a = 1;
		assert (!isComposite(a));
 		int b = 2;
		assert (!isComposite(b));
 		int c = 3;
		assert (!isComposite(c));
 		int d = 4;
		assert (isComposite(d));
 		int e = 10;
		assert (isComposite(e));
 		int f = 12;
		assert (isComposite(f));
 		int g = 37;
		assert (!isComposite(g));
	}
 }