package exercise1_3;
import java.util.Stack;
import edu.princeton.cs.algs4.StdIn;

public class Evaluate {
	public static void main(String[] args) {
		Stack<String> ops=new Stack<String>();
		Stack<Double> vals=new Stack<Double>();
		while (!StdIn.isEmpty()) {
			//读取字符，如果是运算符压入栈
			String s=StdIn.readString();
			if (s.equals("(")) ;
			else if	(s.equals("+")) ops.push(s);	
			else if	(s.equals("-")) ops.push(s);	
			else if	(s.equals("*")) ops.push(s);	
			else if	(s.equals("/")) ops.push(s);	
			else if	(s.equals("sqrt")) ops.push(s);	
			else if	(s.equals(")")){
				//如果字符为“）”，弹出运算符和操作数，计算结果压入栈
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
要有空格分隔
 可以计算  ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
      ( ( 1 + sqrt ( 5.0 ) ) / 2.0 )
不能计算   ( 1 + ( ( 1 + 2 + 3 ) * ( 4 * 5 ) ) )三个连续操作
*/