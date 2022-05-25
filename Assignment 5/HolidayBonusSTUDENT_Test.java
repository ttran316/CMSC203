import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusSTUDENT_Test {
	
	private double[][] dataSet1 = {{5,6,2},{7,8},{10,3,1}};
	private double[][] dataSet2 = {{0,5,99,46},{57,1,2,3,4,5},{4,5,7},{18,64,72,21}};
	private double[][] dataSet3 = {{-1.2,3.4,5.6,7.8},{-9.1},{11.2,-13.4,15.6},{17.8,19.0,-21.2,23.4}};
	private double[][] dataSet4 = {{-5.6,2.7,8.1},{-3.1,0.5},{-9.9,-4.6},{-5.7,1.2,-3.9,5.6}};
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
		/**
		 * Test calculateHolidayBonus method with a high of 1500, low of 1000 and 5000 as other
		 */

		@Test
		public void testCalculateHolidayBonusA() {
			try{
				
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1,1500, 1000, 500);
			assertEquals(3000.0,result[0],.001);
			assertEquals(2000.0,result[1],.001);
			assertEquals(3500.0,result[2],.001);
			
			result = HolidayBonus.calculateHolidayBonus(dataSet2,1500, 1000, 500);
			assertEquals(4500.0,result[0],.001);
			assertEquals(7500.0,result[1],.001);
			assertEquals(1500.0,result[2],.001);
			assertEquals(3000.0,result[3],.001);
			
			result = HolidayBonus.calculateHolidayBonus(dataSet3,1500, 1000, 500);
			assertEquals(2000.0,result[0],.001);
			assertEquals(0.0,result[1],.001);
			assertEquals(2000.0,result[2],.001);
			assertEquals(4500.0,result[3],.001);
			
			result = HolidayBonus.calculateHolidayBonus(dataSet4,1500, 1000, 500);
			assertEquals(3000.0,result[0],.001);
			assertEquals(2000.0,result[1],.001);
			assertEquals(0.0,result[2],.001);
			assertEquals(2000.0,result[3],.001);
			}
			catch (Exception e) {
				fail("This should not have caused an Exception");
			} 
			
		}

		/**
		 * Test calculateHolidayBonus method with a high of 2500, low of 1500 and 200 as other
		 */

		@Test
		public void testCalculateHolidayBonusB() {
			
			try{
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1,2500,1500,200);
			assertEquals(4200.0,result[0],.001);
			assertEquals(2700.0,result[1],.001);
			assertEquals(5500.0,result[2],.001);
			
			result = HolidayBonus.calculateHolidayBonus(dataSet2,2500,1500,200);
			assertEquals(6700.0,result[0],.001);
			assertEquals(12000.0,result[1],.001);
			assertEquals(600.0,result[2],.001);
			assertEquals(3100.0,result[3],.001);
			
			result = HolidayBonus.calculateHolidayBonus(dataSet3,2500,1500,200);
			assertEquals(1900.0,result[0],.001);
			assertEquals(0.0,result[1],.001);
			assertEquals(2700.0,result[2],.001);
			assertEquals(7500.0,result[3],.001);
			
			result = HolidayBonus.calculateHolidayBonus(dataSet4,2500,1500,200);
			assertEquals(5000.0,result[0],.001);
			assertEquals(2700.0,result[1],.001);
			assertEquals(0.0,result[2],.001);
			assertEquals(2700.0,result[3],.001);
			}
			catch (Exception e) {
				fail("This should not have caused an Exception");
			} 
			
		}

		/**
		 * Test calculateTotalHolidayBonus method with a high of 1500, low of 1000 and 500 as other
		 */
	@Test
	public void testCalculateTotalHolidayBonusA() {
		assertEquals(8500.0,HolidayBonus.calculateTotalHolidayBonus(dataSet1, 1500, 1000, 500),.001);
		assertEquals(16500.0,HolidayBonus.calculateTotalHolidayBonus(dataSet2, 1500, 1000, 500),.001);
		assertEquals(8500.0,HolidayBonus.calculateTotalHolidayBonus(dataSet3, 1500, 1000, 500),.001);
		assertEquals(7000.0,HolidayBonus.calculateTotalHolidayBonus(dataSet4, 1500, 1000, 500),.001);

	}
	
	/** 
	 * Test calculateTotalHolidayBonus method with a high of 2500, low of 1500 and 200 as other
	 */
	@Test
	public void testCalculateTotalHolidayBonusB() {
		assertEquals(12400.0,HolidayBonus.calculateTotalHolidayBonus(dataSet1, 2500,1500,200),.001);
		assertEquals(22400.0,HolidayBonus.calculateTotalHolidayBonus(dataSet2, 2500,1500,200),.001);
		assertEquals(12100.0,HolidayBonus.calculateTotalHolidayBonus(dataSet3, 2500,1500,200),.001);
		assertEquals(10400.0,HolidayBonus.calculateTotalHolidayBonus(dataSet4, 2500,1500,200),.001);

	}

}