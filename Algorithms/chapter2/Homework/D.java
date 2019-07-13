/*
 * Intersection of two sets. 
 * Given two arrays a[] and b[], each containing
 * n distinct 2D points in the plane, design a 
 * subquadratic algorithm to count the number of 
 * points that are contained both in array a[] 
 * and array b[].
 */

import edu.princeton.cs.algs4.StdRandom;
import java.awt.Point;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class D {
	private Set<Point> s = new HashSet<Point>();
	private int samePointsNum;
	D(int n,Point[] inputa, Point[] inputb){
		for(int i=0;i<n;i++){
			s.add(inputa[i]);
			s.add(inputb[i]);
		}
		samePointsNum = 2*n - s.size();
	}
	    
	public int samePointsNum(){
		return samePointsNum;
	}
	    
	public static void main(String[] args){
		int n = 10;
		Point[] a = new Point[n];
		Point[] b = new Point[n];
		System.out.println(a.length);
		for(int i=0;i<n;i++){
			a[i] = new Point();
			a[i].setLocation(StdRandom.uniform(n), StdRandom.uniform(n));
			b[i] = new Point();
			b[i].setLocation(StdRandom.uniform(n), StdRandom.uniform(n));
		}
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		D pp = new D(n,a,b);
		System.out.println(pp.samePointsNum);
	    }
}
