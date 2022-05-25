
public class Customer {
	//Declare initial variables
	public String name;
	public int age;
	
	//Constructors
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Customer(Customer customer) {
		this.name = customer.name;
		this.age = customer.age;
	}
	
	//Setter and Getter Methods
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return getAge() + " year old " + getName();
	}
}
