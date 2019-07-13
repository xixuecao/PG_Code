package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/**
 * @author evasean www.cnblogs.com/evasean/
 */
public class Brute {
    private int segNum;
    private Point[] points; //�ύ��ҵʱ��ʾ����ĸ����캯�����������ݲ��ܷ����ı䣬�����мӸ����齫�������������
    private ArrayList<LineSegment> segmentList= new ArrayList<LineSegment>();

    public Brute(Point[] inpoints) {
        if (inpoints == null)
            throw new IllegalArgumentException("Constructor argument Point[] is null!");
        // finds all line segments containing 4 points
        for (int i=0;i<inpoints.length;i++) {
            if (inpoints[i] == null)
                throw new IllegalArgumentException("there is null in constructor argument");
        }
        points = new Point[inpoints.length];
        for (int i=0;i<inpoints.length;i++) {
            points[i] = inpoints[i];
        }
        Arrays.sort(points); //�Ա������˽�������������
        for (int i=0;i<points.length-1;i++) {
            if (points[i].compareTo(points[i+1]) == 0) // ��ǰһ��Ԫ�����
                throw new IllegalArgumentException("there exists repeated points!");
        }
        //��ҵ�ύʱ��ʾ�������˳�����numberOfSegments()��segment()�������ؽ��Ҫ���ȶ�
        //��ô���캯���о�Ҫ��LineSegment�Һ�
        findLineSegment(points); 
    }

    /**
     * ������ҵҪ�����Ĳ�ѭ������
     * @param points
     */
    private void findLineSegment(Point[] points) {
        int pNum = points.length;
        for (int i = 0; i < pNum - 3; i++) { // i����Ҫ������������ڵ㣬��Ϊ�����ĸ��ڵ�������LineSegment
            // ÿ��comparator��Ҫռ�ݶ���ռ䣬�ܹ���Ҫn-4��Comparator<Point>�Ķ���ռ�
            Comparator<Point> comparator = points[i].slopeOrder();
            for (int j = i + 1; j < pNum - 2; j++) {
                if (points[j].compareTo(points[i]) == 0)
                    continue; // ��ͬpointֱ������
                for (int l = j + 1; l < pNum - 1; l++) {
                    if (points[l].compareTo(points[i]) == 0)
                        continue;
                    if (points[l].compareTo(points[j]) == 0)
                        continue;
                    if (comparator.compare(points[j], points[l]) == 0) { // point[j]��point[l]�����point[i]��б�����
                        for (int m = l + 1; m < pNum; m++) {
                            if (points[m].compareTo(points[i]) == 0)
                                continue;
                            if (points[m].compareTo(points[j]) == 0)
                                continue;
                            if (points[m].compareTo(points[l]) == 0)
                                continue;
                            if (comparator.compare(points[l], points[m]) == 0) {
                                // point[l]��point[m]�����point[i]��б�����ʱ��i��j��l��m �ĵ�������һ��linesegment
                                // ÿ��LineSegment��Ҫռ��һ�ݶ���ռ�
                                LineSegment seg = new LineSegment(points[i], points[m]);
                                segmentList.add(seg);
                            }
                        }
                    }
                }
            }
        }
        segNum = segmentList.size();
        
    }
    
    public int numberOfSegments() {
        // the number of line segments
        return segNum;
    }
    
    public LineSegment[] segments() {
        // the line segments
        //��ҵ�ύʱ����ʾҪ���ε���segments()�������ص�Ӧ���ǲ�ͬ�Ķ���
        LineSegment[] segments = new LineSegment[segNum];
        int i = 0;
        for(LineSegment seg : segmentList){
            segments[i++] = seg;
        }
        return segments;
    }

    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(StdIn.readString());
        //In in = new In("collinear/input8.txt"); //���ز���ʹ��
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }
        
        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.01);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        Brute collinear = new Brute(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}