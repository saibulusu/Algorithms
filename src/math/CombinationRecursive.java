package math;
 import org.junit.Test;
 public class CombinationRecursive {
 	// find n choose r, or nCr
	public static int choose(int n, int r) {
		// if n chooses 0 or itself, return 1, because there is only one way to
		// do either of those
		if (r == 0 || r == n)
			return 1;
		// recursively return the two values in Pascla's triangle directly above
		// nCr
		return choose(n - 1, r - 1) + choose(n - 1, r);
	}
 	@Test
	public void test() {
		for (int i = 0; i < 10; i++) {
			assert (choose(i, 0) == 1);
			assert (choose(i, i) == 1);
		}
 		for (int i = 1; i < 10; i++) {
			assert (choose(i, 1) == i);
			assert (choose(i, i - 1) == i);
		}
 		for (int i = 0; i < 10; i++) {
			int k = 0;
			for (int j = 0; j <= i; j++) {
				k += choose(i, j);
			}
 			assert (k == Math.pow(2, i));
		}
 	}
 }