package exercise1_1;

public class Qusetion1_1_13 {
	public static void main(String[] args) {
		int[][] array={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		for (int j = 0; j < array[0].length; j++) {
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
}
