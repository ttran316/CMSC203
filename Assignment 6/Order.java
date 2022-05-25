import java.util.ArrayList;

public class Order {
	//Declare intital variables
	public int orderNumber, orderTime;
	public DAY orderDay;
	public Customer customer;
	ArrayList<Beverage> bevList = new ArrayList<Beverage>();
	
	//Constructors for order
	public Order(int orderTime, DAY orderDay, String customerName, int customerAge) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = new Customer(customerName,customerAge);
	}
	
	public Order(int orderTime, DAY orderDay, Customer customer) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = new Customer(customer.name,customer.age);
	}
	
	//Add Alcohol bev
	public void addNewBeverage(String bevName, SIZE size, boolean weekend) {
		bevList.add(new Alcohol (bevName, size, weekend));
	}
	
	public void addNewBeverage(String bevName, SIZE size) {
		boolean weekend = false;
		if(orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
			weekend = true;
		}
		bevList.add(new Alcohol (bevName, size, weekend));
	}
	
	//Add Coffee bev
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		bevList.add(new Coffee (bevName, size, extraShot, extraSyrup));
	}
	
	//Add Smoothie bev
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		bevList.add(new Smoothie (bevName, size, numOfFruits, addPRotien));
	}
	
	//Getter and setter methods
	public int getOrderTime() {
		return orderTime;
	}
	
	public int getOrderNo() {
		return orderNumber;
	}
	
	public DAY getOrderDay() {
		return orderDay;
	}
	
	public void setOrderNo(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public int getTotalItems() {
		return bevList.size();
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public Beverage getBeverage(int item) {
		return bevList.get(item);
	}
	
	//method creates random number with max of 90000 and min of 10000
	public int randomNum() {
		return (int)Math.floor(Math.random()*(90000-10000+1)+10000);
	}
	
	//method checks if day is weekend
	public boolean isWeekend() {
		if(orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
			return true;
		}
		return false;
	}
	
	//method that goes through bevlist and returns the amount of types similar to parameter
	public int findNumOfBeveType(TYPE type) {
		int total = 0;
		for(int i = 0; i < bevList.size();i++) {
			if(type == bevList.get(i).getType()) {
				total++;
			}
		}
		return total;
	}
	
	//method that calculates bevlist total
	public double calcOrderTotal() {
		double price = 0;
		for(int i = 0; i < bevList.size(); i++) {
			price += bevList.get(i).calcPrice();
		}
		return price;
	}
	
	//Method compares one obj with current obj
	public int compareTo(Order compare) {
        if(this.orderNumber > compare.getOrderNo()) {
        	return 1;
        }
        if(this.orderNumber < compare.getOrderNo()){
        	return -1;
        }
        return 0;
    }
	
	public String toString() {
		String temp = "";
		for(int i = 0; i < bevList.size(); i++) {
			temp += bevList.get(i);
			temp += "\n";
		}
		return "Order Number: " + getOrderNo()
				+ " \nOrder\n" + temp + "Total: " + calcOrderTotal()
				+ "\nCustomer: " + getCustomer().getAge() + " year old " + getCustomer().getName();
	}
}
