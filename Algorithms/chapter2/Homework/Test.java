import java.util.Arrays;
import edu.princeton.cs.algs4.StdRandom;

public class Test {
    public static final int RED = 0;
    public static final int WHITE = 1;
    public static final int BLUE = 2;
    private int n;
    private int[] buckets;
    public int callColorNum = 0;
    public int callSwapNum = 0;

    public Test(int[] buckets) {
        n = buckets.length;
        this.buckets = buckets;
    }

    public void sort() {
        int lo = 0;
        int hi = n - 1;
        int current = lo;
        while (current <= hi) {
            switch(color(current)){
            case RED:
                if (current != lo) 
                    swap(current, lo);
                current++;
                lo++;
                break;
            case WHITE:
                current++;
                break;
            case BLUE:
                swap(hi,current);
                hi--;
                break;
            }
        }
    }

    private void swap(int i, int j) {
        callSwapNum++;
        int t = buckets[i];
        buckets[i] = buckets[j];
        buckets[j] = t;
    }

    private int color(int i) {
        callColorNum ++;
        return buckets[i];
    }

    public static void main(String[] args) {
        int n = 10;
        int[] buckets = new int[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = StdRandom.uniform(3);
        }
        System.out.println(Arrays.toString(buckets));
        Test dnf = new Test(buckets);
        dnf.sort();
        System.out.println("after sort call color+"+dnf.callColorNum+"times, call swap="+ dnf.callSwapNum+"times");
        System.out.println(Arrays.toString(buckets));
    }
}