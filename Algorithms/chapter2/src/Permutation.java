import edu.princeton.cs.algs4.StdIn;

public class Permutation {
	public static void main(String[] args) {
		RandomizedQueue<String> rq=new RandomizedQueue<String>();
		int k=Integer.parseInt(args[0]);
		int cnt=0;
		while (!StdIn.isEmpty()) {
			cnt++;
			String s=StdIn.readString();
			System.out.println(s);
            rq.enqueue(s);
        }
		if (k>cnt) {
			System.out.println("wrong! k > n is wrong");
		}else {
			 while (k > 0) {
				 System.out.println(rq.dequeue());
				 k--;
			 }
		}
       
	}
}