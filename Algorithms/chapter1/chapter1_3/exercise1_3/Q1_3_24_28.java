package exercise1_3;

import java.util.LinkedList;

public class Q1_3_24_28 {
	private class Node{
		int item1;
		String item;
		Node next;
	}
	private Node first;
	// 24��
	public void removeAfter(Node node) {
		/*
		 * ɾ�����нڵ�
		if (node!=null&&node.next!=null) {
			Node current=node.next;
			Node next=current.next;
			node.next=null;
			while (current.next!=null) {
				current=null;
				current=next;
				next=next.next;
			}
		}*/
		// ��ɾ������һ���ڵ�
		if (node!=null&&node.next!=null) {
			node.next=null;
		}
	}
	
	//25��
	public void insertAfter(Node m,Node n) {
		if (m!=null&&n!=null) {
			n.next=m.next;
			m.next=n;
		}
	}
	
	// 26��
	public void remove(LinkedList<String> list,String key) {
		 //first�ڵ�Ĭ��Ϊû��ʵ������Ľ��
        Node before = first;
        Node node = before.next;
        while (node != null) {
            Node next = node.next;
            if (node.item.equals(key)) {
                //����ýڵ�Ӧ���,��ôǰ�ý��ֱ������ý������
                //ǰ�ýڵ㲻��
                before.next = next;
            }else {
                //����ǰ�ý��Ӧ��ת�Ƶ���һ�����
                before = node;
            }
            //�����Ľ��תΪ���ý��
            node = next;
        }
	}
	
	// 27��
	public int max(Node first) {
		int value =0;
        for ( Node node= first; node!=null ; node = node.next) {
            if (value < node.item1) {
                value = node.item1;
            }
        }
        return value;
	}
	
	// 28��
	public int maxRec(Node first,int max) {
		if (first==null) return max;
		if (max<first.item1) 
			max=first.item1;
		return maxRec(first.next,max);
	}
}