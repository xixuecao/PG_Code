package exercise1_1;
import edu.princeton.cs.algs4.*;
public class Qusetion1_1_35 {
	// ɫ�������棬��ֵ�ֱ���1��2��3��4��5��6
	private static int sides = 6;

	/**
	 * ��ӡ
	 * @param dist  ���������
	 */
	private static void print(double[] dist) {
	    for(int i = 2; i <= 2 * sides; ++i)
	        StdOut.println(dist[i]);
	    StdOut.println("-------------------------");
	}

	/**
	 * ����ͳ�����ݼ������ֵ
	 * @param dist  ͳ����������
	 * @return  ��������
	 */
	private static double[] computeProbability(double[] dist, int testTimes) {
	    for(int i = 2; i <= 2 * sides; ++i)
	        dist[i] /= (1.0 * testTimes);
	    return dist;
	}

	/**
	 *  ����ɫ��֮�͵����۸���ֵ
	 * @return  ���۸���ֵ
	 */
	private static double[] theoreticalValue() {
	    double[] dist = new double[2 * sides + 1];
	    // ͳ��ֵ���ֵ����۴���
	    for(int i = 1; i <=sides; ++i)
	        for(int j = 1; j <= sides; ++j)
	            dist[i+j] += 1.0;
	    // �������۸���
	    dist = computeProbability(dist, 36);
	    return dist;
	}

	/**
	 *  �������ģ����ɫ�Ӳ�ͳ������������
	 * @param N ��������
	 * @return  �������
	 */
	private static double[] simulate(int N) {
	    double[] dist = new double[2 * sides + 1];
	    // ��N���������ģ����ɫ��,��ͳ������
	    for(int i = 0; i < N; ++i) {
	        int a = StdRandom.uniform(1, 6 + 1);
	        int b = StdRandom.uniform(1, 6 + 1);
	        dist[a + b] += 1.0;
	    }
	    // �����������ֵ
	    dist = computeProbability(dist, N);
	    return dist;
	}

	/**
	 * �������ֵ�ܷ������۸���ֵ����ƥ�䵽С�������λ��
	 * @param dist0    ���۸���ֵ
	 * @param dist1    �������ֵ
	 * @return  ��ƥ�䵽С�������λ���򷵻�true�����򷵻�false
	 */
	private static boolean isMatch(double[] dist0, double[] dist1) {
	    for(int i = 2; i <= 2 * sides; ++i)
	        if(Math.abs(dist0[i] - dist1[i]) >= 0.0001)
	            return false;
	    return true;
	}

	/**
	 * ���Եõ�����Ҫ����������N
	 * @param initTimes   �����ʼ����ֵ
	 * @param dist0 ���۸���
	 * @return  ����Ҫ����������
	 */
	private static int testGetN(int initTimes, double[] dist0) {
	    int N = initTimes;
	    boolean match = false;
	    while(!match) {
	        double[] dist1 = simulate(N);
	        match = isMatch(dist0, dist1);
	        if(match)
	            print(dist1);
	        // ��ǰN����Ҫ����N����10��
	        N *= 10;
	    }
	    return N;
	}

	public static void main(String[] args) {
	    double[] dist0 = theoreticalValue();
	    print(dist0);
	    int initTimes = 1000000;
	    int N = testGetN(initTimes, dist0);
	    System.out.println("���������������������(" + N + ")");
	}
}
