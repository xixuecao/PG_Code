package exercise1_3;
import edu.princeton.cs.algs4.StdIn;

public class Q1_3_9 {
	public static void main(String[] args) {
		Stack<String> ops=new Stack<String>();
		Stack<String> vals=new Stack<String>();
		while (!StdIn.isEmpty()) {
			String s=StdIn.readString();
			if (s.equals("+")||s.equals("-")||s.equals("*")) {
				ops.push(s);
			}else if	(s.equals(")")){
				//����ַ�Ϊ������������������Ͳ�������������ʽѹ��ջ
				String op=ops.pop();
				String first=vals.pop();
				String second=vals.pop();
				vals.push("("+second+op+first+")");
			}
			else vals.push(s);
		}
		System.out.println(vals.pop());
	}
}
