import java.util.ArrayList;
public class HolidayBonus {
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		//Declaring variables
		double singleCol = data[0].length;
		double[] test = {10.0,20.0};
		double highest = 0, lowest = 0, total;
		ArrayList<Double> bonus = new ArrayList<Double>();
		ArrayList<Double> values = new ArrayList<Double>();
		
		//For loop that goes through data[][]
		for(int r = 0; r < data.length; r++) {
			//Clear value and total for new row
			values.clear();
			total = 0.0;
			//For loop that caluclates high, low, or other in a row and add to values
			for(int c = 0; c < data[r].length; c++) {
				try {
					highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, c);
					lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, c);
					if(data[r][c] == highest) {
						values.add(high);
					}else if(data[r][c] < 0) {
						values.add(0.0);
					}else if(data[r][c] == lowest) {
						values.add(low);
					}else {
						values.add(other);
					}
				}catch(Exception na) {
					//If this column only has one data then add high
					values.add(high);
					continue;
				}
			}
			//Calculate total for a row
			for(int i = 0; i < values.size(); i++) {
				total += values.get(i);
			}
			bonus.add(total);
		}
		//Turn arraylist to array
		double[] bonusConvert = new double[bonus.size()];
		for(int i = 0; i < bonus.size(); i++) {
			bonusConvert[i] = bonus.get(i);
		}
		return bonusConvert;
	}
	
	
	
	public static double calculateTotalHolidayBonus(double[][] data, double high,double low, double other) {
		double[] temp = HolidayBonus.calculateHolidayBonus(data,high,low,other);
		double total = 0.0;
		for(int i = 0; i < temp.length; i++) {
			total += temp[i];
		}
		return total;
	}
}
