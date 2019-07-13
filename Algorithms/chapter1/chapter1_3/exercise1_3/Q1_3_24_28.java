package exercise1_3;

import java.util.LinkedList;

public class Q1_3_24_28 {
	private class Node{
		int item1;
		String item;
		Node next;
	}
	private Node first;
	// 24题
	public void removeAfter(Node node) {
		/*
		 * 删除所有节点
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
		// 仅删除后续一个节点
		if (node!=null&&node.next!=null) {
			node.next=null;
		}
	}
	
	//25题
	public void insertAfter(Node m,Node n) {
		if (m!=null&&n!=null) {
			n.next=m.next;
			m.next=n;
		}
	}
	
	// 26题
	public void remove(LinkedList<String> list,String key) {
		 //first节点默认为没有实际意义的结点
        Node before = first;
        Node node = before.next;
        while (node != null) {
            Node next = node.next;
            if (node.item.equals(key)) {
                //如果该节点应该深处,那么前置结点直接与后置结点相连
                //前置节点不变
                before.next = next;
            }else {
                //否则前置结点应该转移到下一个结点
                before = node;
            }
            //遍历的结点转为后置结点
            node = next;
        }
	}
	
	// 27题
	public int max(Node first) {
		int value =0;
        for ( Node node= first; node!=null ; node = node.next) {
            if (value < node.item1) {
                value = node.item1;
            }
        }
        return value;
	}
	
	// 28题
	public int maxRec(Node first,int max) {
		if (first==null) return max;
		if (max<first.item1) 
			max=first.item1;
		return maxRec(first.next,max);
	}
}