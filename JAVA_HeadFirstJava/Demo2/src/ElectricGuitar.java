class ElectricGuitar {
	
	String brand;
	private int numOfPickups;
	boolean rockStarUsesIt;
	
	String getBrand(){
		return brand;
	}
	void setBrand(String aBrand){
		brand=aBrand;
	}
	int getnumOfPickups(){
		return numOfPickups;
	}
	void setnumOfPickups(int num){
		numOfPickups=num;
	}
	boolean getrockStarUsesIt(){
		return rockStarUsesIt;
	}
	void setrockStarUsesIt(boolean yesOrNo){
		rockStarUsesIt=yesOrNo;
	}
	public static void main(String[] args) {
		ElectricGuitar [] a=new ElectricGuitar[3];
		a[0]=new ElectricGuitar();
		a[1]=new ElectricGuitar();
		a[2]=new ElectricGuitar();
		
        a[0].setBrand("my name");
        a[0].brand="55";
		System.out.println(a[0].getBrand());
		a[0].setnumOfPickups(5);
		//a[0].numOfPickups=1;
		System.out.println(a[0].getnumOfPickups());
		a[0].setrockStarUsesIt(true);
		System.out.println(a[0].getrockStarUsesIt());
	}
}
