package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class BruteCollinearPoints {
	private int num;
	private Point[] points;
	private ArrayList<LineSegment> segmentList=new ArrayList<LineSegment>();
	public BruteCollinearPoints(Point[] points) {
		// finds all line segments containing 4 points
		if (points==null) 
			throw new IllegalArgumentException("Constructor argument Point[] is null");
		for (int i = 0; i < points.length; i++)
			if (points[i]==null) 
				throw new IllegalArgumentException("there is nll in argument");
		this.points=new Point[points.length];
		for (int i = 0; i < points.length; i++)
			this.points[i]=points[i];
		Arrays.sort(this.points);
		for (int i = 0; i < this.points.length-1; i++)
			if (this.points[i].compareTo(this.points[i+1])==0)
				throw new IllegalArgumentException("there exists repeated points");
		findLineSegment(this.points);
	}
	private void findLineSegment(Point[] points) {
		int pNum=points.length;
		for (int i = 0; i < pNum-3; i++) {
			Comparator<Point> comparator=points[i].slopeOrder();
			for (int j = i+1; j < pNum-2; j++) {
				if (points[j].compareTo(points[i])==0) continue;
				for (int k = j+1; k < pNum-1; k++) {
					if (points[k].compareTo(points[i])==0) continue;
					if (points[k].compareTo(points[j])==0) continue;
					if (comparator.compare(points[j], points[k])==0) {
						for (int m = k+1; m < pNum; m++) {
							if (points[m].compareTo(points[i])==0) continue;
							if (points[m].compareTo(points[j])==0) continue;
							if (points[m].compareTo(points[k])==0) continue;
							if (comparator.compare(points[m], points[k])==0) {
								LineSegment segment=new LineSegment(points[i], points[m]);
								segmentList.add(segment);
							}
						}
					}
				}
			}
		}
		num=segmentList.size();
	}
	public int numberOfSegments() {
		// the number of line segments
		return num;
	}
	public LineSegment[] segments() {
		// the line segments
		LineSegment[] segments=new LineSegment[num];
		int i=0;
		for (LineSegment lineSegment : segmentList) {
			segments[i++]=lineSegment;
		}
		return segments;
	}
	public static void main(String[] args) {
		In in=new In(StdIn.readString());
		int n=in.readInt();
		Point[] points=new Point[n];
		for (int i = 0; i < n; i++) {
			int x=in.readInt(),y=in.readInt();
			points[i]=new Point(x, y);
		}
		StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		for (Point point : points) {
			point.draw();
		}
		StdDraw.show();
		BruteCollinearPoints collinear=new BruteCollinearPoints(points);
		for (LineSegment segment : collinear.segments()) {
			System.out.println(segment);
			segment.draw();
		}
		StdDraw.show();
	}
}
