package edu.java.string02;

class Point {
	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if(obj instanceof Point) {
			Point pt = (Point) obj; // 각제 형 변환
			if(x == pt.x && y == pt.y) {
				result = true;
			}
		}
		return result;
	}
	
	
}

public class StringMain02 {

	public static void main(String[] args) {
	Point pt1 = new Point(1, 2);
	System.out.println(pt1);
	
	Point pt2 = new Point(1, 2);
	System.out.println(pt2);
	
	if(pt1.equals(pt2)) {
		System.out.println("같은 좌표");
	}else {
		System.out.println("다른 좌표");
	}
	}

}
