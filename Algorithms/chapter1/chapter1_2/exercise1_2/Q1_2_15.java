package exercise1_2;

import edu.princeton.cs.algs4.*;

public class Q1_2_15 {
	public static void main(String[] args) {
		//read by E:\LUBO\Java\MyText.txt
		int[] ints=readInts(args[0]);
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}
	}
	
	public static int[] readInts(String name) {
		In in=new In(name);
		String input=in.readAll();
		String[] words=input.split("\\s+");
		int[] ints=new int[words.length];
		for (int i = 0; i < ints.length; i++) {
			ints[i]=Integer.parseInt(words[i]);
		}
		return ints;
	}
}
