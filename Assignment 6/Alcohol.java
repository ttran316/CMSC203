
public class Alcohol extends Beverage{
	//Declare initial variables
	public boolean weekend;
	public Beverage bev;
	
	//Constructor
	public Alcohol(String name, SIZE size, boolean weekend){
		this.name = name;
		this.size = size;
		this.weekend = weekend;
		setType(TYPE.ALCOHOL);
	}
	
	//Getter and Setter methods
	public void setWeekend(boolean weekend) {
		this.weekend = weekend;
	}
	
	//Check if its a weekend
	public boolean isWeekend() {
		return weekend;
	}
	
	//Find total price, base, size, and weekend
	public double calcPrice() {
		double price = getBasePrice()+getSizePrice();
		if(isWeekend() == true) {
			price += 0.6;
		}
		return price;
	}
	
	//Compare object with another. If same return true
	public boolean equals(Object obj) {
		Alcohol a = (Alcohol) obj;
		if(name != a.name) {
			return false;
		}
		if(size!= a.size) {
			return false;
		}
		if(weekend != a.weekend) {
			return false;
		}
		return true;
	}
	
	public String toString() {
		return "$"+ calcPrice() + " " + size.name() + " ALCOHOL for " + name;
	}

	

	
}
