package exercise1_4;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
public class DoublingTest {
	
	public static double timeTrial(int N) {
		int MAX=1000000;
		int[] a=new int[N];
		for (int i = 0; i < N; i++)
			a[i]=StdRandom.uniform(-MAX,MAX);
		Stopwatch timer=new Stopwatch();
		int cnt=ThreeSum.count(a);
		return timer.elapsedTime();
	}
	
	public static void drawStandard(int[] n,double[] time) {
		StdDraw.setXscale(-0.5,1.2*n[n.length-1]/1000);
		StdDraw.setYscale(-0.5,1.2*time[n.length-1]);
		// 建立坐标系
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.001);
		StdDraw.line(0, 0, 1.1*n[n.length-1]/1000, 0);
		StdDraw.line(0, 0, 0, 1.1*time[n.length-1]);
		for (int i = 1; i < 1.1*n[n.length-1]/1000; i++) 
			StdDraw.text(i,-0.2, i+"K");
		for (double t = 2; t < time[n.length-1]*1.1; t++)
			StdDraw.text(-0.2, t, t+"");
		// 绘制图像
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		StdDraw.setPenRadius(0.02);
		for (int i = 0; i < time.length; i++)
			StdDraw.point(n[i]/1000, time[i]);
	}
	
	public static void drawLog(int[] n,double[] time) {
		// 将坐标转换为对数
		//int[] n
		double[] timelog=new double[time.length];
		for (int i = 0; i < timelog.length; i++)
			timelog[i]=Math.log(time[i]);
		StdDraw.setXscale(-0.5, 1.2*n[n.length-1]/1000);
		StdDraw.setYscale(-0.5, 1.2*timelog[time.length-1]);
		//  建立坐标系
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.001);
		StdDraw.line(0, 0, 1.1*n[n.length-1]/1000, 0);
		StdDraw.line(0, 0, 0, 1.1*timelog[time.length-1]);
		for (int i = 1; i < 1.1*n[n.length-1]/1000; i++)
			StdDraw.text(i, -0.2, i+"K");
		for (double t = 0; t <1.1*timelog[time.length-1]; t+=timelog[n.length-1]/5)
			StdDraw.text(-0.2, t, String.format("%.2f",t));
		// 绘制图像
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		StdDraw.setPenRadius(0.02);
		for (int i = 0; i < n.length; i++)
			StdDraw.point(n[i]/1000, timelog[i]);
	}
	
	public static void main(String[] args) {
		//System.out.println("请输入上限最大N值：");
		int MAX=4000;//StdIn.readInt();
		int i=0;
		int len=(int)(Math.log(MAX/250)/Math.log(2)+1);
		int[] x=new int[len];
		double[] y=new double[len];
		for (int N=250;N<=MAX;N+=N) {
			System.out.print(N+": ");
			double time=timeTrial(N);
			System.out.println(time+" seconds");
			x[i]=N;
			y[i++]=time;
		}
		//drawStandard(x, y);
		drawLog(x, y);
	}
}
