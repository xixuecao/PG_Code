class Dog {
	int size;
	String breed;
	String name;		
	public static void main (String[] args){
			
		Dog d = new Dog();
		d . size = 40;
		d . bark();
			
		Dog[]  myDogs = new Dog[3];
		myDogs[0] = new Dog();
		myDogs[0].name = "Fido";
		myDogs[0].bark();
	}
	public void bark() {
		System.out.println("Ruff! Ruff!");
	}
}