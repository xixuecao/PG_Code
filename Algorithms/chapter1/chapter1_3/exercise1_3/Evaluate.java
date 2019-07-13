package exercise1_3;
import java.util.Stack;
import edu.princeton.cs.algs4.StdIn;

public class Evaluate {
	public static void main(String[] args) {
		Stack<String> ops=new Stack<String>();
		Stack<Double> vals=new Stack<Double>();
		while (!StdIn.isEmpty()) {
			//��ȡ�ַ�������������ѹ��ջ
			String s=StdIn.readString();
			if (s.equals("(")) ;
			else if	(s.equals("+")) ops.push(s);	
			else if	(s.equals("-")) ops.push(s);	
			else if	(s.equals("*")) ops.push(s);	
			else if	(s.equals("/")) ops.push(s);	
			else if	(s.equals("sqrt")) ops.push(s);	
			else if	(s.equals(")")){
				//����ַ�Ϊ������������������Ͳ�������������ѹ��ջ
				String op=ops.pop();
				double v=vals.pop();
				if (op.equals("+")) v=vals.pop()+v;
				else if (op.equals("-")) v=vals.pop()-v; 
				else if (op.equals("*")) v=vals.pop()*v; 
				else if (op.equals("/")) v=vals.pop()/v; 
				else if (op.equals("sqrt")) v=Math.sqrt(v);
				vals.push(v);
			}
			else vals.push(Double.parseDouble(s));
		}
		System.out.println(vals.pop());
	}
}
/*
Ҫ�пո�ָ�
 ���Լ���  ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
      ( ( 1 + sqrt ( 5.0 ) ) / 2.0 )
���ܼ���   ( 1 + ( ( 1 + 2 + 3 ) * ( 4 * 5 ) ) )������������
*/