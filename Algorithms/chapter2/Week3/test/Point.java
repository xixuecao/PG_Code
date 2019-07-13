package test;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {
	
	private final int x;
	private final int y;
	
	public Point(int x,int y) {
		// constructs the point (x, y)
		this.x=x;
		this.y=y;
	}
	public void draw() {
		// draws this point
		StdDraw.point(x, y);
	}
	public void drawTo(Point that) {
		// draws the line segment from this point to that point
		StdDraw.line(this.x, this.y, that.x, that.y);
	}
	public String toString() {
		// string representation
		return "("+x+", "+y+")";
	}
	public int compareTo(Point that) {
		// compare two points by y-coordinates, breaking ties by x-coordinates
		if (this.y==that.y) {
			if (this.x==that.x) {
				return 0;
			}else if (this.x<that.x) {
				return -1;
			}else {
				return 1;
			}
		}
		else if (this.y<that.y) {
			return -1;
		}
		else {
			return 1;
		}
	}
	public double slopeTo(Point that) {
		// the slope between this point and that point
		int x0=this.x,y0=this.y;
		int x1=that.x,y1=that.y;
		if (x0==x1&&y0==y1) {
			return Double.NEGATIVE_INFINITY;
		}else if (x0==x1) {
			return Double.POSITIVE_INFINITY;
		}else if (y0==y1) {
			return 0.0;
		}else {
			return (y1-y0)/(double)(x1-x0);
		}
	}
	public Comparator<Point> slopeOrder(){
		// compare two points by slopes they make with this point
		return new SlopeOrder(this);
	}
	
	private class SlopeOrder implements Comparator<Point>{
		private final Point p;
		public SlopeOrder(Point p) {
			// TODO Auto-generated constructor stub
			this.p=p;
		}
		public int compare(Point o1,Point o2) {
			// TODO Auto-generated method stub
			double slope1=p.slopeTo(o1);
			double slope2=p.slopeTo(o2);
			return Double.compare(slope1, slope2);
		}
	}
}
