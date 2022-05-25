/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: You are given a file called Movie.java, which has the data fields for a movie, 
	along with “setters” and “getters”, and a “toString” method.  You will create a driver class 
	from the pseudocode in Task #1 below to test the Movie class
 * Due: 2/16/2021
 * Platform/compiler: Java Programming Language Compiler
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Thomas Tran
*/
import java.util.Scanner; 
public class MovieDriver {
	public static void main(String[] args) {
		/*Two different scanners, one for string and one for int. 
		If use same scanner it messes up the amount of inputs it ask. */
		Scanner input = new Scanner(System.in);
		Scanner numInput = new Scanner(System.in);
		String title, rating, again;
		int tickets;
		Movie movie = new Movie();
		do {
			System.out.println("Enter the name of the movie.");
			title = input.nextLine();
			movie.setTitle(title);
			
			System.out.println("Enter the rating of the movie.");
			rating = input.nextLine();
			while(!(rating.equals("G") || rating.equals("PG") || rating.equals("PG13") || rating.equals("R") || rating.equals("NC17"))) {
				System.out.println("Please enter a valid rating: G, PG, PG13, R, NC17");
				rating = input.nextLine();
			}
			movie.setRating(rating);
			
			System.out.println("Enter the number of tickets sold for this movie.");
			tickets = numInput.nextInt();
			movie.setSoldTickets(tickets);
			
			System.out.println(movie.toString());
			System.out.println("Do you want to enter another? (y or n)");
			again = input.nextLine();
		}while(again.equals("y"));
		System.out.println("Goodbye.");
	}
}
