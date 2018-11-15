package math;
 import org.junit.Test;
 public class Distance {
	
	//Point class
	class Point {
		int x;
		int y;
		
		//A point contains an x-coordinate and a y-coordinate
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	//return the distance between two points using the distance formula in coordinate geometry
	public double distance(Point a, Point b){
		//compute the x and y difference, sign does not matter
		int dx = a.x - b.x;
		int dy = a.y - b.y;
		//square both, sum them, and square root the results
		return Math.sqrt(dx * dx + dy * dy);
		//this is equivalent to the Pythagorean Theorem
	}
	
	@Test
	public void test(){
		Point a = new Point(0, 0);
		Point b = new Point(3, 4);
		
		assert(distance(b,a) == distance(a,b));
		assert(distance(a, b) == 5.0);
		
		Point c = new Point(3,0);
		assert(distance(b,c) == distance(c,b));
		assert(distance(b,c) == 4.0);
		
		Point d = new Point(5,0);
		Point e = new Point(4, -1);
		assert(distance(d, e) == distance(e,d));
		assert(distance(d, e) == Math.sqrt(2));
		
		
	}
	
}