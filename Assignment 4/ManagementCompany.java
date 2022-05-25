public class ManagementCompany {
	private int MAX_PROPERTY = 5, MGMT_WIDTH = 10, MGMT_DEPTH = 10, indexCounter = 0, index = -1;
	private double mgmFeePer;
	private String name, taxID;
	private Property[] properties;
	private Plot plot;
	
	//Constructors for ManagementCompany
	public ManagementCompany() {
		name = "";
		taxID = "";
		plot = new Plot(0,0,1,1);
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFeePer) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		properties = new Property[MAX_PROPERTY];
	}
	
	//Constructors for addProperty
	
	public int addProperty(Property property) {
		if(property == null) {
			return -2;
		}
		for(int i = 0; i < indexCounter; i++) {
			if(properties[i].getPlot().overlaps(property.getPlot())) {
				return -4;
			}else if(properties[i].getPlot().encompasses(property.getPlot())) {
				return -4;
			}
		}
		if(indexCounter < MAX_PROPERTY) {
			properties[indexCounter] = property;
			indexCounter++;
			index++;
			return index;
		}else if(indexCounter == MAX_PROPERTY) {
			return -3;
		}
		return -1;
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		Property property = new Property(name, city, rent, owner);
		properties[indexCounter] = property;
		for(int i = 0; i < indexCounter; i++) {
			if(properties[i].getPlot().overlaps(property.getPlot())) {
				return -4;
			}else if(properties[i].getPlot().encompasses(property.getPlot())) {
				return -4;
			}
		}
		indexCounter++;
		if(indexCounter == MAX_PROPERTY) {
			return -3;
		}
		return indexCounter;
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		properties[indexCounter] = property;
		for(int i = 0; i < indexCounter; i++) {
			if(properties[i].getPlot().overlaps(property.getPlot())) {
				return -4;
			}else if(properties[i].getPlot().encompasses(property.getPlot())) {
				return -4;
			}
		}
		indexCounter++;
		if(indexCounter == MAX_PROPERTY) {
			return -3;
		}
		return indexCounter;
	}
	
	//Display a certain property's info
	public String displayPropertyAtIndex(int i) {
		return properties[i].toString();
	}
	
	//Find in the array which one has the highest rent
	public String maxRentProp() {
		double number = 0, maxRentProp = 0;
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] != null) {
				number = properties[i].getRentAmount();
			}
			if(number > maxRentProp) {
				maxRentProp = number;
			}
		}
		return String.valueOf(maxRentProp);
	}
	
	//Needed a copy of maxRentProp() so that the code works in MgmCompanyGui line 299
	public double maxRentPropFix() {
		double number = 0, maxRentProp = 0;
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] != null) {
				number = properties[i].getRentAmount();
			}
			if(number > maxRentProp) {
				maxRentProp = number;
			}
		}
		return maxRentProp;
	}
	
	//Get the index of the array as to which has the most rent
	public int maxRentPropertyIndex() {
		int max = 0;
		for(int i = 0; i < indexCounter; i++) {
			if(properties[i].getRentAmount() >= properties[max].getRentAmount()) {
				max = i;
			}
		}
		return max;
	}
	
	//Add all the rent from each array element or plot
	public double totalRent() {
		double total = 0.0;
		for(int i = 0; i < indexCounter; i++) {
			total += properties[i].getRentAmount();
		}
		return total;
	}
	
	//Getter method
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	public String getTaxID() {
		return taxID;
	}
	
	public double getmgmFeePer() {
		return mgmFeePer*(0.01*totalRent());
	}
	//Getter methods needed because of MgmCompanyGui
	public String getName() {
		return name;
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	public String toString() {
		String toString = "List of the properties for " + getName() + ", taxID: " + getTaxID() + "\n=======================================================================\n";
		for(int i = 0; i < indexCounter; i++) {
			toString += "Property Name: " + properties[i].getPropertyName() + "\n";
			toString += " Located in " + properties[i].getCity() + "\n";
			toString += " Belonging to: " + properties[i].getOwner() + "\n";
			toString += " Rent Amount: " + properties[i].getRentAmount() + "\n";
		}
		toString += "=======================================================================\nTotal Management Fee: " + getmgmFeePer();
		return toString;
	}
}
