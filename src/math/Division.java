package math;

import org.junit.Test;

public class Division {

	//division algorithm (rounds down)
	public static int divide(int dividend, int divisor) {

		//special cases: divisor is 0 -> error, dividend is 0 -> return 0
		if (divisor == 0)
			throw new IllegalArgumentException();
		if (dividend == 0)
			return 0;

		//this will be incremented if necessary
		int quotient = 0;

		//shift if the input is negative anywhere
		int shift = 1;

		//if the dividend or divisor is negative, swap the sign of shift and that value
		if(dividend < 0){
			shift *= -1;
			dividend *= -1;
		}
		if(divisor < 0){
			shift *= -1;
			divisor *= -1;
		}

		//want to ensure that the remainder is strictly less than the absolute value of the divisor
		int remainder = dividend;

		while (remainder >= divisor) {
			quotient++;
			//increment quotient and subtract remaineder by divisor
			remainder -= divisor;
		}
		
		//if there was a negative input anywhere, the answer will be multiplied by -1
		return quotient * shift;
		//if they were both negative, then the answer technically won't change
	}

	@Test
	public void test() {
		assert (divide(5, 6) == 0);
		assert (divide(6, 5) == 1);
		assert (divide(5, 5) == 1);
		assert (divide(9, 1000) == 0);

		assert (divide(-1, -1) == 1);
		assert (divide(1, -1) == -1);
		assert (divide(-1, 1) == -1);
		assert (divide(1, 1) == 1);
		
		for(int i = 1; i < 100; i++){
			assert(divide(0, i) == 0);
			assert(divide(i, 2) + divide(i, 2) == i || divide(i, 2) + divide(i, 2) == i - 1);
		}
	}

}









