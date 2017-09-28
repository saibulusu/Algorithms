package Math;

public class Permutation {
	
	
	//calculate n permutes r, or nPr
	public static int permutation(int n, int r){
		//return factorial called on n divided by factorial called on (n - r)
		return factorial(n) / factorial(n - r);
	}
	
	
	//factorial method, recursively for any positive integer n
	public static int factorial(int n){
		//if n <= 1, return 1, otherwise return n * factorial called on (n - 1)
		return (n <= 1) ? 1 : n * factorial(n - 1);
	}
	
}
