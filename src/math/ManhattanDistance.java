package math;

import org.junit.Test;

import math.Distance.Point;

public class ManhattanDistance {

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
	
	
	public int distance(Point a, Point b){
		int dx = Math.abs(a.x - b.x);
		int dy = Math.abs(a.y - b.y);
		return dx + dy;
	}
	
	@Test
	public void test(){
		Point a = new Point(0, 0);
		Point b = new Point(3, 4);
		
		assert(distance(b,a) == distance(a,b));
		assert(distance(a, b) == 7);
		
		Point c = new Point(3,0);
		assert(distance(b,c) == distance(c,b));
		assert(distance(b,c) == 4);
		
		Point d = new Point(5,0);
		Point e = new Point(4, -1);
		assert(distance(d, e) == distance(e,d));
		assert(distance(d, e) == 2);
		
		
	}
	
}
