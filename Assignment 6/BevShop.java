import java.util.ArrayList;
import java.util.Collections;
public class BevShop {
	//Declare initial variables
	public final int MIN_AGE_FOR_ALCOHOL = 21, MAX_ORDER_FOR_ALCOHOL= 3, MIN_TIME= 8, MAX_TIME= 23, MAX_FRUIT = 5;				
	public int currentNumAlcohol = 0;
	Order order;
	ArrayList<Order> orderList = new ArrayList<Order>();
	
	//method that begins new order and add to orderlist
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		order = new Order(time, day, customerName, customerAge);
		orderList.add(order);
		//Alternative for sort method
		for(int i = 0; i < orderList.size(); i++) {
			orderList.get(i).setOrderNo(i);
		}
	}
		
	//Methods that process all types of beverages
	public void processAlcoholOrder(String bevName, SIZE size) {
		order.addNewBeverage(bevName, size);
	}

	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		order.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
		
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		order.addNewBeverage(bevName, size, numOfFruits, addProtien);
	}
	
	//Getter methods
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	public int getNumOfAlcoholDrink() {
		return currentNumAlcohol;
	}

	public Order getCurrentOrder() {
		return order;
	}

	public Order getOrderAtIndex(int index) {
		return orderList.get(index);
	}
	
	
	//Methods that check if some variables are within a certain range
	public boolean validTime(int time) {
			if(MIN_TIME <= time && time <= MAX_TIME) {
				return true;
			}
			return false;
		}

	public boolean eligibleForMore() {
			if(currentNumAlcohol < MAX_ORDER_FOR_ALCOHOL) {
				return true;
			}
			return false;
		}

	public boolean validAge(int age) {
			if(age > MIN_AGE_FOR_ALCOHOL) {
				return true;
			}
			return false;
		}
		
	public boolean isMaxFruit(int max) {
			if(max > MAX_FRUIT) {
				return true;
			}
			return false;
		}
	
	//method, given a ordernumber find what index it is
	public int findOrder(int orderNo) {
		int index = -1;
		for(int i = 0; i < orderList.size(); i++) {
			if(orderList.get(i).getOrderNo() == orderNo) {
				index = i;
			}
		}
		return index;
	}

	//method, given a ordernumber find the total of that order
	public double totalOrderPrice(int orderNo) {
		int index = findOrder(orderNo);
		return orderList.get(index).calcOrderTotal();
	}
	
	//method that checks amount of orders
	public int totalNumOfMonthlyOrders() {
		return orderList.size();
	}
	
	//method that finds price of whole orderlist
	public double totalMonthlySale() {
		double total = 0;
		for(int i = 0; i < orderList.size(); i++) {
			total += orderList.get(i).calcOrderTotal();
		}
		return total;
	}
	
	public void sortOrders() {
		//Collections.sort(orderList);
	}

	public String toString() {
		String temp = "";
		for(int i = 0; i < orderList.size(); i++) {
			temp += orderList.get(i);
			temp += "\n";
		}
		return temp + totalMonthlySale();
	}
}
