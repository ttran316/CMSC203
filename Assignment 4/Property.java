
public class Property {
	private String propertyName, city, owner;
	private double rentAmount;
	private Plot plot;
	
	public Property() {
		propertyName = "";
		city = "";
		owner = "";
		rentAmount = 0;
		plot = new Plot(0,0,1,1);
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		plot = new Plot(0,0,1,1);
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		plot = new Plot(x,y,width,depth);
	}
	
	public Plot getPlot() {
		return plot;
	}
	public String getCity() {
		return city;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public double getRentAmount() {
		return rentAmount;
	}
	
	public Plot setPlot(int x, int y, int width, int depth) {
		plot = new Plot(x, y, width, depth);
		return plot;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	public String toString() {
		return "Property Name: " + propertyName + "\n Located in " + city + "\n Belonging to: " + owner + "\n Rent Amount: " + rentAmount;
	}
}
