class DogTestDrive {
	
	public static void main (String[] args){
		
		Dog d = new Dog();
		d . size = 40;
		d . bark();
		System.out.println(d.size);
		
		Dog[]  myDogs = new Dog[3];
		myDogs[0] = new Dog();
		myDogs[0].name = "Fido";
		myDogs[0].bark();
	}
}
