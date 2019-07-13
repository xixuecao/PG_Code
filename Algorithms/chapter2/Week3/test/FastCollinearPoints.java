package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class FastCollinearPoints {
	
	private Point[] points;
	private int num;
	private HashMap<Double, Point> hMap;
	private ArrayList<LineSegment> segmentList=new ArrayList<LineSegment>();
	public FastCollinearPoints(Point[] points) {
		// TODO Auto-generated constructor stub
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
		
		for (int i = 0; i < pNum-1; i++) {
			int k=0;
			double[] slope=new double[pNum-1-i];
			int[] line=new int[pNum-1-i];
			hMap=new HashMap<Double,Point>();
			
			for (int j = i+1; j < pNum; j++) {
				line[k]=0;
				slope[k]=points[i].slopeTo(points[j]);
				if (!hMap.containsKey(slope[k])) {
					line[k]++;
					hMap.put(slope[k], points[j]);
				}else {
					line[k]++;
					
					hMap.put(slope[k], points[j]);
				}
				k++;
			}
			for (int k1 = 0; k1 < line.length; k1++) {
				if (line[k1]>=4) {
					LineSegment segment=new LineSegment(points[i], hMap.get(slope[k1]));
					segmentList.add(segment);
				}
			}
		}
		num=segmentList.size();
	}
	
	public int numberOfSegments() {
		return num;
	}
	public LineSegment[] segments() {
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
// F:\Algorithms\Week3\Data\input6.txt