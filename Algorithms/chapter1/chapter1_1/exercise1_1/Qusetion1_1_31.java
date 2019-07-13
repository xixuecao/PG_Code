package exercise1_1;
import edu.princeton.cs.algs4.*;
public class Qusetion1_1_31 {
	public static void main(String[] args) {
		//drawCircle(10,10,5);
		ramdomLink(20,0.2);
	}
	/**
	 * 画圆
	 * @param x 圆心x坐标
	 * @param y 圆心y坐标
	 * @param r 半径r
	 */
	public static void drawCircle(double x,double y,double r) {
		StdDraw.setXscale(0,2*x);
		StdDraw.setYscale(0,2*y);
		StdDraw.setPenRadius(0.003);
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.circle(x, y, r);
	}/**
	 * 在圆上描点
	 * @param x0 圆心x坐标
	 * @param y0 圆心y坐标
	 * @param r 半径r
	 * @param N N个点
	 */
	public static double[][] drawPoint(double x0,double y0,double r,int N) {
		double[][] point=new double[N][2];
		StdDraw.setPenRadius(0.05);
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		for (int i = 0; i < point.length; i++) {
			double x=x0+r*Math.cos(2*Math.PI*i/N);
			double y=y0+r*Math.sin(2*Math.PI*i/N);
			point[i][0]=x;
			point[i][1]=y;
		}
		return point;
	}
	/**
	 * 以概率p随机连接顶点集points中的点
	 * @param points    点集
	 * @param p 概率p
	 */
	public static void ramdomlinkPoint(double[][] point,double p) {
		StdDraw.setPenRadius(0.002);
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		for (int i = 0; i < point.length; i++) {
			for (int j = 0; j < point.length; j++) {
				if (true == StdRandom.bernoulli(p))
					StdDraw.line(point[i][0],point[i][1],point[j][0],point[j][1]);
			}
		}
	}
	/**
	 * 在圆上画N个点然后每两点间以概率p连接
	 * @param N N个点
	 * @param p 概率p
	 */
	
	public static void ramdomLink(int N,double p) {
		double x=10.0;
		double y=10.0;
		double r=10.0;
		drawCircle(x, y, r);
		double[][] point=drawPoint(x, y, r, N);
		ramdomlinkPoint(point, p);
	}
}
