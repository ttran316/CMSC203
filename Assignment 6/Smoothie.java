
public class Smoothie extends Beverage{
	//Declare initial variables
	public boolean protein;
	public int fruit;
	
	//Constructor
	public Smoothie(String name, SIZE size,int fruit, boolean protein){
		this.name = name;
		this.size = size;
		this.fruit = fruit;
		this.protein = protein;
		setType(TYPE.SMOOTHIE);
	}
	
	//Getter and setter methods
	public boolean getAddProtien() {
		return protein;
	}
	
	public int getNumOfFruits() {
		return fruit;
	}
	
	//Find total price, base, size, and weekend
	public double calcPrice() {
		double price = getBasePrice()+getSizePrice();
		for(int i = 0; i < fruit; i++) {
			price += 0.5;
		}
		if(protein == true) {
			price += 1.5;
		}
		return price;
	}
	
	//Compare object with another. If same return true
	public boolean equals(Object obj) {
		Smoothie s = (Smoothie) obj;
		if(name != s.name) {
			return false;
		}
		if(size!= s.size) {
			return false;
		}
		if(fruit != s.fruit) {
			return false;
		}
		if(protein != s.protein) {
			return false;
		}
		return true;
	}
		
	public String toString() {
		return "$"+ calcPrice() + " " + size.name() + " SMOOTHIE with " + getNumOfFruits() + " fruits for " + name;
	}
}
