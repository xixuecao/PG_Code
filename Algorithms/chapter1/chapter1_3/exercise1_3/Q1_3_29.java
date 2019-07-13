package exercise1_3;

public class Q1_3_29<Item> {
	// ������2��ʵ�����������Ƕ���
	private class Node{
		Item item;
		Node next;
		public Node(Item item) {
			this.item=item;
		}
	}
	private Node last;
	public void enqueue(Item item) {
		//�տ�ʼlastΪ��,��ô�����ʼ��,��ָ���Լ�
		Node node=new Node(item);
		if (last==null) {
			last=node;
			last.next=last;
		}else {
			node.next =last.next;
			last.next=node;

			last=node;
		}
	}
	public Item dequeue() {
		//���lastΪ��,ֱ���׳��쳣
		if (last==null) {
			throw new NullPointerException();
		}
		Node first=last.next;
		
		if (first==last) {
			//���first��last���,˵��last.next = last,��������ֻʣһ�����
            //�����ÿ�
			last=null;
		}else {
			//��Ȼ����last�ĺ��ý��,��first���
			last.next=first.next;
		}
		return first.item;
	}
}
