public class Beverage {
	//Declare variables
	public String name;
	public SIZE size;
	public TYPE type;
	public DAY day;
	public final double basePrice = 2.0, sizePrice = 1.0;
	
	//Constructors
	public Beverage() {
		name = "No Name";
	}
	
	public Beverage(String name, TYPE type, SIZE size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}
	
	//Setter and Getter Methods
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSize(SIZE size) {
		this.size = size;
	}
	
	public void setType(TYPE type) {
		this.type = type;
	}
	
	public String getBevName() {
		return name;
	}
	
	public double getBasePrice() {
		return basePrice;
	}
	
	public SIZE getSize() {
		return size;
	}
	
	public TYPE getType() {
		return type;
	}
	
	//Method that gets the price for size, small = 0, medium = 1, large = 2
	public double getSizePrice() {
		double price = 0.0;
		switch (size) {
		case SMALL:
			break;
		case MEDIUM:
			price = sizePrice;
			break;
		case LARGE:
			price = sizePrice+1;
			break;
		}
		return price;
	}
	
	//Find total price, base and size
	public double calcPrice() {
		return getBasePrice()+getSizePrice();
	}
	
	public String toString() {
		return size.name() + " " + type.name() + " for " + name;
	}
}
