package exercise1_1;
import edu.princeton.cs.algs4.*;
public class Qusetion1_1_32 {
	/**
	 * ������״ͼ
	 * @param N
	 * @param l
	 * @param r
	 * @param arr
	 */
	private static void dataHistogram(int N, double l, double r, double[] arr) {
	    int length = arr.length;
	    int[] statistics = new int[N];
	    double interval = (r - l) / N;
	    // ͳ�����ݷֲ�
	    for(int i = 0; i < length; ++i) {
	        double remain = arr[i] - l;
	        int idx = (int)(remain / interval);
	        ++ statistics[idx];
	    }
	    // ����ͳ�ƽ�������ֵ�����ڻ���ֱ��ͼʱ������״ͼ��ʱ
	    double max = statistics[0];
	    for(int i = 1; i < statistics.length; ++i) {
	        if(max < statistics[i])
	            max = statistics[i];
	    }
	    // ����ֱ��ͼ
	    StdDraw.setXscale(l, r);
	    StdDraw.setPenColor(StdDraw.BOOK_BLUE);
	    double x0 = l + interval / 2.0;
	    for(int i = 0; i < statistics.length; ++i) {
	        double x = x0 + i * interval;
	        double y = statistics[i] / (max + 1) / 2.0;
	        double hw = 0.99 * interval / 2.0;
	        double hh = y;
	        StdDraw.filledRectangle(x, y, hw, hh);
	    }
	}

	public static void main(String[] args) {
	    In in = new In("./data/largeW.txt");
	    double[] whiteList = in.readAllDoubles();
	    double min = Double.POSITIVE_INFINITY;
	    double max = Double.NEGATIVE_INFINITY;
	    for(int i = 0; i < whiteList.length; ++i) {
	        if(min > whiteList[i])
	            min = whiteList[i];
	        if(max < whiteList[i])
	            max = whiteList[i];
	    }
	    // �ӿ���̨��ȡӦ�ý����ݷָ�Ķ���
	    StdOut.print("�����ݷָ�Ķ�����");
	    int N = StdIn.readInt();
	    dataHistogram(N, min, max + 10.0, whiteList);
	}
}
