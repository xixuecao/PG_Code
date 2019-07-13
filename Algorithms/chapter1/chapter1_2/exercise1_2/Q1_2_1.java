package exercise1_2;
import edu.princeton.cs.algs4.*;
public class Q1_2_1 {
	public static void main(String[] args) {
		int N=Integer.parseInt(args[0]);
		Point2D[] points=new Point2D[N];
		
		//set color and penradius
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setPenRadius(0.01);
		
		for (int i = 0; i < N; i++) {
			points[i]=new Point2D(Math.random(), Math.random());
			points[i].draw();
		}
		double min=points[0].distanceTo(points[1]);
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if (points[i].distanceTo(points[j])<min) {
					min=points[i].distanceTo(points[j]);
				}
			}
		}
		System.out.println("Min Distance: "+min);
	}
}
