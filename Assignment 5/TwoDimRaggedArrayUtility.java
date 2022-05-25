import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class TwoDimRaggedArrayUtility {
	public static void writeToFile(double[][] data, File file) {
		try {
			PrintWriter out = new PrintWriter(file);
			for(int r = 0; r < data.length;r++) {
				for(int c = 0; c < data[r].length; c++) {
					out.print(data[r][c] + " ");
				}
				out.print("\n");
			}
			out.close();
		}catch(Exception na) {
			
		}
	}
	
	public static double[][] readFile(File file){
		if(file.length() == 0) {
			return null;
		}else {
			double[][] array = null;
			int counter = 0;
			try {
				Scanner input = new Scanner(file);
				while(input.hasNextLine()) {
					counter++;
					input.nextLine();
				}
				input.close();
				input = new Scanner(file);
				array = new double[counter][];
				for(int r = 0; r < counter; r++) {
					String str = input.nextLine();
					String[]nums = str.split(" ");
					array[r] = new double[nums.length];
					for(int c = 0; c < array[r].length; c++) {
						array[r][c] = Double.valueOf(nums[c]);
					}
				}
				input.close();
			} catch(Exception na) {
				
			}
			return array;
		}
	}
	
	//Involve all row and columns
	public static double getAverage(double[][] data) {
		double divison = 0.0;
		for(int r = 0; r < data.length; r++) {
			for(int c = 0; c < data[r].length; c++) {
				divison++;
			}
		}
		return getTotal(data)/divison;
	}
	
	public static double getTotal(double[][] data) {
		double total = 0.0;
		for(int r = 0; r < data.length; r++) {
			for(int c = 0; c < data[r].length; c++) {
				total += data[r][c];
			}
		}
		return total;
	}
	
	public static double getHighestInArray(double[][] data) {
		double highest = data[0][0];
		for(int r = 0; r < data.length; r++) {
			for(int c = 0; c < data[r].length; c++) {
				if(highest < data[r][c]) {
					highest = data[r][c];
				}
			}
		}
		return highest;
	}
	
	public static double getLowestInArray(double[][] data) {
		double lowest = data[0][0];
		for(int r = 0; r < data.length; r++) {
			for(int c = 0; c < data[r].length; c++) {
				if(lowest > data[r][c]) {
					lowest = data[r][c];
				}
			}
		}
		return lowest;
	}
	
	//Row methods
	public static double getRowTotal(double[][] data, int row) {
		double total = 0.0;
		for(int c = 0; c < data[row].length; c++) {
			total += data[row][c];
		}
		return total;
	}
	
	public static double getHighestInRow(double[][] data, int row) {
		double highest = data[row][0];
		for(int c = 0; c < data[row].length; c++) {
			if(highest < data[row][c]) {
				highest = data[row][c];
			}
		}
		return highest;
	}
	
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highest = data[row][0];
		int highestIndex = 0;
		for(int c = 0; c < data[row].length; c++) {
			if(highest < data[row][c]) {
				highest = data[row][c];
				highestIndex = c;
			}
		}
		return highestIndex;
	}
	
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = data[row][0];
		for(int c = 0; c < data[row].length; c++) {
			if(lowest > data[row][c]) {
				lowest = data[row][c];
			}
		}
		return lowest;
	}
	
	public static int getLowestInRowIndex(double[][] data, int row){
		double lowest = data[row][0];
		int lowestIndex = 0;
		for(int c = 0; c < data[row].length; c++) {
			if(lowest > data[row][c]) {
				lowest = data[row][c];
				lowestIndex = c;
			}
		}
		return lowestIndex;
	}
	
	//Column  methods
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0.0;
		for(int r = 0; r < data.length; r++) {
			if(data[r].length > col) {
				total += data[r][col];
			}
		}
		return total;
	}
	
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = data[0][col];
		for(int r = 0; r < data.length; r++) {
			try {
				if(highest < data[r][col]) {
					highest = data[r][col];
				}
			}catch(Exception na) { 
				continue;
			}
		}
		return highest;
	}
	
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highest = data[0][col];
		int highestIndex = 0;
		for(int r = 0; r < data.length; r++) {
			try {
				if(highest < data[r][col]) {
					highest = data[r][col];
					highestIndex = r;
				}
			}catch(Exception na) {
				continue;
			}
		}
		return highestIndex;
	}
	
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = data[0][col];
		for(int r = 0; r < data.length; r++) {
			try {
				if(lowest > data[r][col]) {
					lowest = data[r][col];
				}
			}catch(Exception na) {
				continue;
			}
		}
		return lowest;
	}
	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowest = data[0][col];
		int lowestIndex = 0;
		for(int r = 0; r < data.length; r++) {
			try {
				if(lowest > data[r][col]) {
					lowest = data[r][col];
					lowestIndex = r;
				}
			}catch(Exception na) {
				continue;
			}
		}
		return lowestIndex;
	}
	
}
