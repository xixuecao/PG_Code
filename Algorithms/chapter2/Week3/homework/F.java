package homework;

import java.util.ArrayList;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdRandom;

public class F {
	
	private class Element{
		public int element;
		public int count;
		public Element(int e, int c) {
			this.element=e;
			this.count=c;
		}
	}
	private Element[] elements = new Element[9];
	
	public ArrayList<Integer> findElement(int[] arrays) {
		int n=arrays.length;
		for (int k = 0; k < 9; k++)
			elements[k]=new Element(0, 0);
		for (int i = 0; i < n; i++) {
			int index=findIndex(arrays[i]);
			if (index >= 0)
				elements[index].count++;
			else
				addToElems(arrays[i]);
		}
		return verifyElems(arrays);
	}
	
	private int findIndex(int e) {
		for (int k = 0; k < 9; k++) {
			if (elements[k].element == e) 
				return k;
			else if (elements[k].count==0){
				elements[k].element=e;
				return k;
			}
		}
		return -1;
	}
	
	private void addToElems(int e) {
		boolean insertFlag=false;
		while (!insertFlag) {
			for (int k = 0; k < 9; k++) {
				elements[k].count--;
				if (elements[k].count<=0) {
					elements[k].element=e;
					elements[k].count=1;
					insertFlag=true;
					break;
				}
			}
		}
	}
	
	private ArrayList<Integer> verifyElems(int[] arrays) {
		int n=arrays.length;
		for (int k = 0; k < 9; k++) {
			elements[k].count=0;
			for (int i = 0; i < n; i++) {
				if (arrays[i] == elements[k].element)
					elements[k].count++;
			}
		}
		ArrayList<Integer> elenList=new ArrayList<Integer>();
		for (int k = 0; k < 9; k++) {
			if (elements[k].count > n/10)
				elenList.add(elements[k].element);
		}
		return elenList;
	}
	
	public static void main(String[] args) {
		int n=20;
		int[] array=new int[n];
		for (int i = 0; i < n; i++)
			array[i]=StdRandom.uniform(n);
		System.out.println(Arrays.toString(array));
		F elems=new F();
		ArrayList<Integer> elemList=elems.findElement(array);
		System.out.println(elemList.toString());
	}
}
