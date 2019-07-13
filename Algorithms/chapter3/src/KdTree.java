import java.util.ArrayList;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class KdTree {
	
	private Node root;
	
	private class Node {
		private Point2D p;
		private RectHV rect;
		private Node left, right;
		private int size;
		private boolean xCoordinate;
		
		public Node(Point2D point, RectHV rect, int size, boolean xCoordinate) {
			this.p = point;
			this.rect = rect;
			this.size = size;
			this.xCoordinate = xCoordinate;
		}
	}
	
	public KdTree() {}
	
	public boolean isEmpty() {
		// is the set empty ?
		return size() == 0;
	}
	
	public int size() {
		// number of point in the set
		return size(root);
	}
	private int size(Node x) {
		if (x == null)
			return 0;
		else
			return x.size;
	}
	
	public void insert(Point2D p) {
		// add the point to the set (if it is not already in the set)
		if (p == null) throw new IllegalArgumentException("argument is null");
		if (root == null)
			root = new Node(p, new RectHV(0, 0, 1.0, 1.0), 1, true);
		else
			insert(root, p);
	}
	private void insert(Node x, Point2D p) {
		if (x.xCoordinate == true) {
			int cmp = Double.compare(p.x(), x.p.x());
			if (cmp == -1) {
				if (x.left != null)
					insert(x.left, p);
				else {
					RectHV parent = x.rect;
					double newXmin = parent.xmin();
					double newYmin = parent.ymin();
					double newXmax = x.p.x();
					double newYmax = parent.ymax();
					x.left = new Node(p, new RectHV(newXmin, newYmin, newXmax, newYmax), 1, false);
				}
			}else if (cmp == 1) {
				if (x.right != null)
					insert(x.right, p);
				else {
					RectHV parent = x.rect;
					double newXmin = x.p.x();
					double newYmin = parent.ymin();
					double newXmax = parent.xmax();
					double newYmax = parent.ymax();
					x.right = new Node(p, new RectHV(newXmin, newYmin, newXmax, newYmax), 1, false);
				}
			}else {
				int cmp2 = Double.compare(p.y(), x.p.y());
				if (cmp2 == -1) {
					if (x.left != null)
						insert(x.left, p);
					else {
						x.left = new Node(p, x.rect, 1, false);
					}
				}else if (cmp2 == 1) {
					if (x.right != null)
						insert(x.right, p);
					else {
						x.right = new Node(p, x.rect, 1, false);
					}
				}
			}
		}else {
			int cmp = Double.compare(p.y(), x.p.y());
			if (cmp == -1) {
				if (x.left != null)
					insert(x.left, p);
				else {
					RectHV parent = x.rect;
					double newXmin = parent.xmin();
					double newYmin = parent.ymin();
					double newXmax = parent.xmax();
					double newYmax = x.p.y();
					x.left = new Node(p, new RectHV(newXmin, newYmin, newXmax, newYmax), 1, true);
				}
			}else if (cmp == 1) {
				if (x.right != null)
					insert(x.right, p);
				else {
					RectHV parent = x.rect;
					double newXmin = parent.xmin();
					double newYmin = x.p.y();
					double newXmax = parent.xmax();
					double newYmax = parent.ymax();
					x.right = new Node(p, new RectHV(newXmin, newYmin, newXmax, newYmax), 1, true);
				}
			}else {
				int cmp2 = Double.compare(p.x(), x.p.x());
				if (cmp2 == -1) {
					if (x.left != null)
						insert(x.left, p);
					else {
						x.left = new Node(p, x.rect, 1, true);
					}
				}else if (cmp2 == 1) {
					if (x.right != null)
						insert(x.right, p);
					else {
						x.right = new Node(p, x.rect, 1, true);
					}
				}
			}
		}
		x.size = 1 + size(x.left) + size(x.right);
	}
	
	public boolean contains(Point2D p) {
		// does the set contain point p ?
		if (p == null) throw new IllegalArgumentException("argument is null");
		return contains(root, p);
	}
	private boolean contains(Node x, Point2D p) {
		if (x == null) return false;
		if (x.p.equals(p)) {
			return true;
		}else {
			if (x.xCoordinate == true) {
				int cmp = Double.compare(p.x(), x.p.x());
				if (cmp == -1) return contains(x.left, p);
				else if (cmp == 1) return contains(x.right, p);
				else {
					int cmp2 = Double.compare(p.y(), x.p.y());
					if (cmp2 == -1) return contains(x.left, p);
					else if (cmp2 == 1) return contains(x.right, p);
					else return true;
				}
			}else {
				int cmp = Double.compare(p.y(), x.p.y());
				if (cmp == -1) return contains(x.left, p);
				else if (cmp == 1) return contains(x.right, p);
				else {
					int cmp2 = Double.compare(p.x(), x.p.x());
					if (cmp2 == -1) return contains(x.left, p);
					else if (cmp2 == 1) return contains(x.right, p);
					else return true;
				}
			}
		}
	}
	public void draw() {
		// draw all points to standard draw
		StdDraw.setXscale(0, 1.0);
		StdDraw.setYscale(0, 1.0);
		draw(root);
		
	}
	private void draw(Node x) {
		if (x == null) return;
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.01);
		x.p.draw();
		if (x.xCoordinate == true) {
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.setPenRadius();
			Point2D start = new Point2D(x.p.x(), x.rect.ymin());
			Point2D end = new Point2D(x.p.x(), x.rect.ymax());
			start.drawTo(end);
		}else {
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.setPenRadius();
			Point2D start = new Point2D(x.rect.xmin(), x.p.y());
			Point2D end = new Point2D(x.rect.xmax(), x.p.y());
			start.drawTo(end);
		}
		draw(x.left);
		draw(x.right);
	}
	public Iterable<Point2D> range(RectHV rect) {
		// all points that are inside the rectangle (or on the boundary)
		if (rect == null) 
			throw new IllegalArgumentException("argument is null");
		if (root != null)
			return range(root, rect);
		else
			return new ArrayList<Point2D>();
	}
	private ArrayList<Point2D> range(Node x, RectHV rect) {
		ArrayList<Point2D> points = new ArrayList<Point2D>();
		if (x.rect.intersects(rect)) {
			if (rect.contains(x.p))
				points.add(x.p);
			if (x.left != null)
				points.addAll(range(x.left, rect));
			if (x.right != null)
				points.addAll(range(x.right, rect));
		}
		return points;
	}
	public Point2D nearest(Point2D p) {
		// a nearest neighbor in the set to point p: null if the set is empty
		if (p == null) throw new IllegalArgumentException("argument is null");
		if (root != null)
			return nearest(root, p, root.p);
		return null;
	}
	private Point2D nearest(Node x, Point2D p, Point2D currNearPoint) {
		if (x.p.equals(p)) return x.p;
		double currMinDistance = currNearPoint.distanceTo(p);
		if (Double.compare(x.rect.distanceTo(p), currMinDistance) >= 0)
			return currNearPoint;
		else {
			double distance = x.p.distanceTo(p);
			if (Double.compare(x.p.distanceTo(p), currMinDistance) == -1) {
				currNearPoint = x.p;
				currMinDistance = distance;
			}
			if (x.left != null)
				currNearPoint = nearest(x.left, p, currNearPoint);
			if (x.right != null)
				currNearPoint = nearest(x.right, p, currNearPoint);
		}
		return currNearPoint;
	}
}
