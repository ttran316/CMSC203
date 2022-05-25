import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany company;
	@Before
	public void setUp() throws Exception {
		//student create a management company
		company = new ManagementCompany("Thomas", "123456789",2);
		//student add three properties, with plots, to mgmt co
		company.addProperty("New Works", "Rockville", 5, "Person A", 1, 2, 5, 5);
		company.addProperty("Borkin", "Silver Spring", 2, "Person B", 3, 6, 3, 3);
		company.addProperty("Soccer League", "Twinbrook", 3, "Person C", 4, 7, 4, 4);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null 
		company = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//fail("STUDENT test not implemented yet");
		company = new ManagementCompany("Thomas", "123456789",2);
		//student should add property with 4 args & default plot (0,0,1,1)
		Property one = new Property("PropertyName1", "City1", 1000.0, "Owner1");
		company.addProperty(one);
		company.addProperty(one);
		company.addProperty(one);
		//student should add property with 8 args
		Property two = new Property("PropertyName2", "City2", 2000.0, "Owner2", 5, 5, 3, 3);
		company.addProperty(two);
		company.addProperty(two);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		Property three = new Property("PropertyName3", "City3", 2500.0, "Owner3", 0, 3, 6, 6);
		assertEquals(company.addProperty(three),-1,0);
	}
 
	@Test
	public void testMaxRentProp() {
		//fail("STUDENT test not implemented yet");
		company = new ManagementCompany("Thomas", "123456789",2);
		Property one = new Property("PropertyName1", "City1", 1000.0, "Owner1");
		Property two = new Property("PropertyName2", "City2", 2000.0, "Owner2", 5, 5, 3, 3);
		Property three = new Property("PropertyName3", "City3", 2500.0, "Owner3", 0, 3, 6, 6);
		Property four = new Property("PropertyName4", "City4", 500.0, "Owner4", 10, 10, 2, 2);
		company.addProperty(one);
		company.addProperty(two);
		company.addProperty(three);
		company.addProperty(four);
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(company.maxRentProp(), "2500.0");
	}

	@Test
	public void testTotalRent() {
		//fail("STUDENT test not implemented yet");
		ManagementCompany company = new ManagementCompany("Thomas", "123456789",2);
		Property one = new Property("PropertyName1", "City1", 1000.0, "Owner1");
		Property two = new Property("PropertyName2", "City2", 2000.0, "Owner2", 5, 5, 3, 3);
		Property three = new Property("PropertyName3", "City3", 2500.0, "Owner3", 0, 3, 6, 6);
		Property four = new Property("PropertyName4", "City4", 500.0, "Owner4", 10, 10, 2, 2);
		company.addProperty(one);
		company.addProperty(two);
		company.addProperty(three);
		company.addProperty(four);
		//student should test if totalRent returns the total rent of properties
		assertEquals(company.totalRent(), 6000.0, 0);
	}

 }