/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: Build an application that will receive a guess and report if your 
	guess is the random number that was generated.  Your application will narrow 
	down the choices according to your previous guesses, and continue to prompt 
	you to enter until you guess correctly.  
 * Due: 2/23/2021
 * Platform/compiler: Java Programming Language Compiler
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Thomas Tran
*/
import java.util.Scanner; 
public class RandomNumberGuesser {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner stringInput = new Scanner(System.in);
		int guess, answer = 0, least = 0, most = 100, counter = 0;
		String again = "yes";
		
		do {
			//See if this is going to be first guess
			if(counter == 0) {
				answer = RNG.rand();
				System.out.println("Enter your first guess:");
				counter++;
			}
			
			//Looks to see if guess is in bounds, if not do again
			do {
				guess = input.nextInt();
			}while(RNG.inputValidation(guess, least, most) == false);
			
			//Checks if guess was answer and if not narrow bounds
			System.out.println("Number of guesses is " + RNG.getCount());
			if (guess < answer) {
				least = guess;
				System.out.println("Your guess is too low.\nEnter your next guess between " + least + " and " + most);
			} else if (guess > answer) {
				most = guess;
				System.out.println("Your guess is too high.\nEnter your next guess between " + least + " and " + most);
			} else {
				//Ask to play again and allows user to only input yes or no
				System.out.println("Congratulations, you guessed correctly.\n Try again? (yes or no)");
				do {
					again = stringInput.nextLine();
					if(!(again.equals("yes") || again.equals("no"))) {
						System.out.println("Please enter only yes or no!");
					}
				}while(!(again.equals("yes") || again.equals("no")));
				
				//If want to play again, reset counter(gives new answer), # of guesses, and bounds
				if(again.equals("yes")) {
					counter--;
					most = 100;
					least = 0;
					RNG.resetCount();
					System.out.println("\n");
				}
			}
		}while(again.equals("yes"));
		System.out.println("Thanks for playing!!");
	}
}
