package exercise1_1;

public class Qusetion1_1_2 {
	public static void main(String[] args) {
		Double a=(1+2.236)/2;
		Double b=1+2+3+4.0;
		Boolean c=4.1>=4;
		String d=1+2+"3";
		/* �ַ���+���� ������ַ�����ÿ������
		 * "my name is:"+1+2+3����my name is:123
		 * ����+�ַ��� �����������Ӻ��ַ���
		 * 1+2+3+"my name is:" ��ʱ6my name is:
		 */
		System.out.println("my name is:"+1+2+3);
		System.out.println(1+2+3+"my name is:");
		
		System.out.println("a. "+a+" The type of class: "+a.getClass().toString());
		System.out.println("b. "+b+" The type of class: "+b.getClass().toString());
		System.out.println("c. "+c+" The type of class: "+c.getClass().toString());
		System.out.println("d. "+d+" The type of class: "+d.getClass().toString());
		
	}
}
