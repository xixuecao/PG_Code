package exercise1_3;
import edu.princeton.cs.algs4.StdIn;

public class Q1_3_4 {
	public boolean parentheses(String s,Stack<String> stack) {
		for (Character c:s.toCharArray()) {
			if (c=='('||c=='['||c=='{') {
				stack.push(c.toString());
			}else {
				
				// ����Ҫ�ȳ�ջ������ÿ�б�һ�Σ�����һ����Ҳ������peek()���ⱻ��ջ��ɾ����
				String item=stack.pop();
				System.out.print(item+" ");
				System.out.println(c.toString());
				
				// String��equals�Ƚϣ���������������==�Ƚϣ�
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
