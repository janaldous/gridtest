
public class Point {
	private int xcoordinate;
	private int ycoordinate;
	
	public Point(int x, int y) {
		this.xcoordinate = x;
		this.ycoordinate = y;
	}
	
	public String toString() {
		return "(" + xcoordinate + ", " + ycoordinate + ")";
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Point 
				&& ((Point)obj).xcoordinate == this.xcoordinate
				&& ((Point)obj).ycoordinate == this.ycoordinate
				) {
			return true;
		}
		return false;
	}
	
	public int calculateDistance(Point p) {
		return Math.abs(p.xcoordinate - this.xcoordinate) 
				+ Math.abs(p.ycoordinate - this.ycoordinate);
	}
}
