import java.util.ArrayList;
import java.util.TreeSet;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class PointSET {
	private TreeSet<Point2D> points;
	public PointSET() {
		// construct an empty set of points
		points = new TreeSet<Point2D>();
	}
	
	public boolean isEmpty() {
		// is the set empty ?
		return points.isEmpty();
	}
	public int size() {
		// number of point in the set
		return points.size();
	}
	public void insert(Point2D p) {
		// add the point to the set (if it is not already in the set)
		if (p == null) throw new IllegalArgumentException("argument is null");
		if (!points.contains(p))
			points.add(p);
	}
	public boolean contains(Point2D p) {
		// does the set contain point p ?
		if (p == null) throw new IllegalArgumentException("argument is null");
		return points.contains(p);
	}
	public void draw() {
		// draw all points to standard draw
		for (Point2D point : points)
			point.draw();
		StdDraw.show();
	}
	public Iterable<Point2D> range(RectHV rect) {
		// all points that are inside the rectangle (or on the boundary)
		if (rect == null) 
			throw new IllegalArgumentException("argument is null");
		ArrayList<Point2D> list = new ArrayList<Point2D>();
		for (Point2D point : points) {
			if (rect.contains(point))
				list.add(point);
		}
		return list;
	}
	public Point2D nearest(Point2D p) {
		// a nearest neighbor in the set to point p: null if the set is empty
		if (p == null) throw new IllegalArgumentException("argument is null");
		if (points.size() == 0) return null;
		double nearestDistance = Double.POSITIVE_INFINITY;
		Point2D nearest = null;
		for (Point2D point : points) {
			if (Double.compare(p.distanceTo(point), nearestDistance) < 0) {
				nearestDistance = p.distanceTo(point);
				nearest = point;
			}
		}
		return nearest;
	}
}
