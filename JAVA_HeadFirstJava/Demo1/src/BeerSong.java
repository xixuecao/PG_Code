
public class BeerSong {
	
	public static void main(String[] args) {
		int BeerNum=99;
		String word="bottles";
		
		while (BeerNum>0) {
			
			System.out.println(BeerNum + " " + word + " of beer on the wall");
			System.out.println(BeerNum + " " + word + " of beer.");
			System.out.println("Take one down.");
			System.out.println("Pass it around.");
			BeerNum=BeerNum-1;
			
			if (BeerNum==1) {
				word="bottle";
			}
			
			if (BeerNum > 0) {
				continue;
				//System.out.println(BeerNum + " " + word + " of beer on the wall");
				} else {
				System.out.println("No more bottles of beer on the wall");
				}
		}
		
	}

}
