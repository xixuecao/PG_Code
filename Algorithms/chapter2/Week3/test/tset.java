package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
/**
 * @author evasean www.cnblogs.com/evasean/
 */
public class tset {
    
    private Point[] points; //�ύ��ҵʱ��ʾ����ĸ����캯�����������ݲ��ܷ����ı䣬�����мӸ����齫�������������
    private final LineSegment[] segments;
    private int segNum;
    
    private List<PointPair> pointPairList; //�洢����LineSegment�������յ�Point��
    /**
     * LineSegment�಻����䶯�����ǿ�ʹ���������ޣ��Լ��¼Ӹ��ڲ���ʹ��
     * ���������洢�ɹ���LineSegment�������յ�point��
     * �����ڱ��������л���ڰ�����ϵ�������յ�point�ԣ�������LineSegment��ʶ�������ϵ��Ч�ʻ�ܵ�
     * �����м���slope����¼�Ϳ��Ժܴ�����Ч���ˣ���Ϊһ�����һ��б�ʾ�ȷ����һ��ֱ��
     * ����Ҫ�ٽ��ж���ȽϺͼ���
     * ��Ϊ����PointPair�Ƕ�points��ǰ������������ģ������������PointPair���ڰ�����ϵ����ô
     * ������PointPair��largePoint��slopeһ�����
     * ��smallPoint����ȣ�smallPoint��С���Ǹ�PointPair��������һ��PointPair
     * ����LineSegmentȥ�صĹؼ�
     * @author evasean www.cnblogs.com/evasean/
     */
    private class PointPair{
        private final Point smallPoint;
        private final Point largePoint;
        private final double slope; 
        public PointPair(Point smallPoint, Point largePoint){
            this.smallPoint = smallPoint;
            this.largePoint = largePoint;
            this.slope = largePoint.slopeTo(smallPoint);
        }
        public Point getLargePoint(){
            return this.largePoint;
        }
        public Point getSmallPoint(){
            return this.smallPoint;
        }
        public double getSlope(){
            return this.slope;
        }
        public int compareTo(PointPair that) {
            Point l1 = this.getLargePoint();
            Point l2 = that.getLargePoint();
            double s1 = this.getSlope();
            double s2 = that.getSlope();
            if(l1.compareTo(l2) > 0) return 1;
            else if(l1.compareTo(l2) < 0) return -1;
            else{
                if(s1>s2) return 1;
                else if(s1<s2) return -1;
                else return 0;
            }
        }
        /**
         * �ж�PointPair�еİ�����ϵʱ��Ҫ�õ��Ƚ���
         * �˱Ƚ�������largePointΪ�Ƚϵ���ҪԪ�أ�slopeΪ��ҪԪ��
         * smallPoint���αȽϴ�С�Ŀ��ˣ�����������PointPair���ʱ�����жϰ�����ϵ֮��
         * ����PointPair pp1 �� pp2��
         * if pp1.largePoint > pp2.largePoint --> pp1 > pp2
         * else if pp1.largePoint < pp2.largePoint --> pp1 < pp2
         * if pp1.largePoint == pp2.largePoint && pp1.slope > pp2.slope --> pp1 > pp2
         * if pp1.largePoint == pp2.largePoint && pp1.slope < pp2.slope --> pp1 < pp2
         * if pp1.largePoint == pp2.largePoint && pp1.slope == pp2.slope --> pp1 == pp2
         * @return
         */
        public Comparator<PointPair> pointPairComparator() {
            return new PointPairComparator();
        }
        private class PointPairComparator implements Comparator<PointPair>{
            @Override
            public int compare(PointPair pp1, PointPair pp2) {
                // TODO Auto-generated method stub
                Point l1 = pp1.getLargePoint();
                Point l2 = pp2.getLargePoint();
                double s1 = pp1.getSlope();
                double s2 = pp2.getSlope();
                if(l1.compareTo(l2) > 0) return 1;
                else if(l1.compareTo(l2) < 0) return -1;
                else{
                    return Double.compare(s1, s2); //doubleԪ����Double.compare���бȽϸ���ȷ
                }
            }
        }
    }
    
    public tset(Point[] inpoints) {
        // finds all line segments containing 4 or more points
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
        findPointPairForLineSegment(points);
        segments = generateLineSegment();
    }

    /**
     * Ѱ������LineSegment��PointPair
     * @param points
     */
    private void findPointPairForLineSegment(Point[] points){
        int pNum = points.length;
        pointPairList = new ArrayList<PointPair>();
        for (int i = 0; i < pNum - 3; i++) { //i����Ҫ������������ڵ㣬��Ϊ�����ĸ��ڵ�������LineSegment
            if(points[i]==null)
                throw new IllegalArgumentException("there is null in constructor argument");
            Point origin = points[i]; //i���ڵ���Ϊ���ԭ��
            Point[] tPoints = new Point[pNum-i-1]; //��Ҫ�õ�����ռ����洢����i֮��Ľڵ�������Ǹ�����ڵ�i�����б��������Ľ��
            int tpNum = 0;
            for (int j = i + 1; j < pNum; j++) {
                tPoints[tpNum++] = points[j];
            }
            //origin.slopeOrder()����Ƚ������Ǹ���Arrays.sort���������Щ�ڵ�tPoints����������Ǹ�����ڵ�i��б��
            Arrays.sort(tPoints,origin.slopeOrder()); 
            
            int startPostion = 0; //startPosition������¼slope��ͬ��pointλ���������ʼλ��
            double slope = origin.slopeTo(tPoints[0]);
            Map<Integer,Integer> intervalMap = new HashMap<Integer,Integer>(); //��¼slope��ͬ��pointλ������
            int curPostion = 1;
            for(; curPostion<tpNum; curPostion++){
                if(Double.compare(origin.slopeTo(tPoints[curPostion]), slope)==0)
                    continue;
                else{ //������slope����֮ǰ��ͬ��λ��
                    if(curPostion-startPostion >= 3) { //�������3���ͱ�ʾ���������LineSegment����������¼pointλ������
                        intervalMap.put(startPostion, curPostion-1);//curPostion-1����������ֹ�ڵ�λ��
                    }
                    slope = origin.slopeTo(tPoints[curPostion]);
                    startPostion = curPostion; //������ʼ�ڵ�
                }
            }
            if(curPostion-startPostion >= 3) { //tPoints���һ���ڵ�Ҳ������ǰһ�ڵ�����ͬ��slope
                intervalMap.put(startPostion, curPostion-1);
            }
            //������������������λ�ã�����PointPair
            for(int key : intervalMap.keySet()){
                int value = intervalMap.get(key);
                Point[] linearPoints = new Point[value-key+2];
                linearPoints[0] = origin;
                int l = 1;
                while(key<=value){
                    linearPoints[l++] = tPoints[key++];
                }
                Arrays.sort(linearPoints);
                PointPair pointPair = new PointPair(linearPoints[0], linearPoints[l-1]);
                pointPairList.add(pointPair);
            }
            //�����ʱ���ݣ�������������
            intervalMap.clear();
            intervalMap = null;
            for(int t=0;t<tPoints.length;t++){
                tPoints[t] = null;
            }
            tPoints = null;
        }
    }
    /**
     * ����LineSegment
     * @return
     */
    private LineSegment[]  generateLineSegment(){
        int ppsize = pointPairList.size();
        if(ppsize==0) return new LineSegment[0];;
        PointPair[] pointPairs =  new PointPair[ppsize];
        int i = 0;
        for(PointPair pp : pointPairList){
            pointPairs[i++] = pp;
        }
        pointPairList.clear();
        //����pointPairComparator�Ƚ��������Ƶ��������ݽ�������ʹ�ô��ڰ�����ϵ��PointPair������ڹ�ϵ
        Arrays.sort(pointPairs,pointPairs[0].pointPairComparator());
        List<LineSegment> lineSegmentList = new ArrayList<LineSegment>();
        
        PointPair ppls = pointPairs[0]; 
        for(i=1;i<ppsize;i++){
            if(ppls.compareTo(pointPairs[i])==0){ //���ڵ�PointPair���ʱ�����и�СsmallPoint��PointPair�������
                Point s = pointPairs[i].getSmallPoint();
                if(ppls.getSmallPoint().compareTo(s) > 0)
                    ppls = pointPairs[i];
            }else{
                LineSegment seg = new LineSegment(ppls.getSmallPoint(),ppls.getLargePoint());
                lineSegmentList.add(seg);
                ppls = pointPairs[i];
            }
        }
        LineSegment seg = new LineSegment(ppls.getSmallPoint(),ppls.getLargePoint());
        lineSegmentList.add(seg);
        
        LineSegment[] segments = new LineSegment[lineSegmentList.size()];
        segNum = 0;
        for (LineSegment ls : lineSegmentList) {
            segments[segNum++] = ls;
        }
        return segments;
    }
    
    public int numberOfSegments() {
        // the number of line segments
        return segNum;
    }
    
    public LineSegment[] segments() {
        // the line segments
        //��ҵ�ύʱ����ʾҪ���ε���segments()�������ص�Ӧ���ǲ�ͬ�Ķ���
        LineSegment[] retseg = new LineSegment[segNum];
        for(int i =0 ;i<segNum;i++){
            retseg[i] = segments[i];
        }
        return retseg;
    }
    
    public static void main(String[] args) {
        // read the n points from a file
        //In in = new In(args[0]);
        In in = new In("collinear/rs1423.txt"); //���ز���ʹ��
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
//        StdDraw.setPenColor(StdDraw.RED);
//        StdDraw.setPenRadius(0.01);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        tset collinear = new tset(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
