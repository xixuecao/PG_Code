package exercise1_1;

public class Qusetion1_1_15 {
	public static void main(String[] args) {
		int[] a={1,2,2,2,0,0,1,1};
		int M=4;
		//printArray(a);
		printArray(histogram(a, M));
	}
	
	static int[] histogram(int[] a,int M){
		int[] array=new int[M];
		for (int i = 0; i < M; i++) {
			int counter=0;
			for (int j = 0; j <a.length; j++) {
				if (a[j]==i) {
					counter++;					
				}
			}
			array[i]=counter;
		}
		return array;
	}
	static void printArray(int[] a){
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
}
