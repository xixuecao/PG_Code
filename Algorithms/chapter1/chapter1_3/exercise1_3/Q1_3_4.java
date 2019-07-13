package exercise1_3;
import edu.princeton.cs.algs4.StdIn;

public class Q1_3_4 {
	public boolean parentheses(String s,Stack<String> stack) {
		for (Character c:s.toCharArray()) {
			if (c=='('||c=='['||c=='{') {
				stack.push(c.toString());
			}else {
				
				// 这里要先出栈，否则每判别一次，弹出一个；也可以用peek()避免被出栈被删除；
				String item=stack.pop();
				System.out.print(item+" ");
				System.out.println(c.toString());
				
				// String用equals比较，基本数据类型用==比较；
				if (item.equals("(")&&c!=')') {
					return false;
				}else if (item.equals("[")&&c!=']') {
					return false;
				}else if (item.equals("{")&&c!='}') {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Q1_3_4 q=new Q1_3_4();
		String string=StdIn.readString();
		System.out.println(q.parentheses(string, new Stack<String>()));
	}
}
