
public class Coffee extends Beverage{
	//Declare initial variables
	public boolean extraCoffee = false, extraSyrup = false;
	
	//Constructors
	public Coffee(String name, SIZE size, boolean extraCoffee, boolean extraSyrup){
		this.name = name;
		this.size = size;
		this.extraCoffee = extraCoffee;
		this.extraSyrup = extraSyrup;
		setType(TYPE.COFFEE);
	}
	
	//Getter and Setter methods
	public void setExtraShot(boolean extraCoffee) {
		this.extraCoffee = extraCoffee;
	}
	
	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}
	
	public boolean getExtraShot() {
		return extraCoffee;
	}
	
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
	//Find total price, base, size and extras
	public double calcPrice() {
		double price = getBasePrice()+getSizePrice();
		if(extraCoffee == true) {
			price += 0.5;
		}
		if(extraSyrup == true) {
			price += 0.5;
		}
		return price;
	}
	
	//Compare object with another. If same return true
	public boolean equals(Object obj) {
		Coffee c = (Coffee) obj;
		if(name != c.name) {
			return false;
		}
		if(size!= c.size) {
			return false;
		}
		if(extraCoffee != c.extraCoffee) {
			return false;
		}
		if(extraSyrup != c.extraSyrup) {
			return false;
		}
		return true;
	}
	
	public String toString() {
		return "$"+ calcPrice() + " " + size.name() + " COFFEE for " + name;
	}
}
