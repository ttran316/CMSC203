/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: Build an application that will step through some possible problems to restore 
	internet connectivity.  Assume that your computer uses wi-fi to connect to a router which
	connects to an Internet Service Provider (ISP) which connects to the Internet.
 * Due: 2/09/2021
 * Platform/compiler: Java Programming Language Compiler
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Thomas Tran
*/

import java.util.Scanner; 
public class WiFiDiagnosis {
	public static void main(String[] args) {
		//Variables, Scanner allows me to get user input
		Scanner input = new Scanner(System.in);
		String answer = "";
		System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis might work.");
		//do while b/c when user input something other than yes or no
		do {
			//if and else for different results depending on amount of no's and then a final yes
			System.out.println("\nFirst step: reboot your computer.\nAre you able to connect with the internet? (yes or no)");
			answer = input.next();
			if (answer.equals("no")) {
				System.out.println("Second step: reboot your router.\nNow are you able to connect with the internet? (yes or no)");
				answer = input.next();
				if (answer.equals("no")) {
					System.out.println("Third step: make sure the cables to your router are plugged in firmly and your router is getting power.\nNow are you able to connect with the internet? (yes or no)");
					answer = input.next();
					if (answer.equals("no")) {
						System.out.println("Fourth step: move the computer closer to the router.\nNow are you able to connect with the internet? (yes or no)");
						answer = input.next();
						if (answer.equals("no")) {
							System.out.println("Fifth step: contact your ISP.\nMake sure your ISP is hooked up to your router.");
							break;
						} else if (answer.equals("yes")) {
							System.out.println("Moving your computer closer to the router seemed to work.");
							break;
						}
					} else if (answer.equals("yes")) {
						System.out.println("Checking your cables seemed to work.");
						break;
					}
				} else if (answer.equals("yes")) {
					System.out.println("Rebooting your router seemed to work.");
					break;
				}
			} else if (answer.equals("yes")) {
				System.out.println("Rebooting your computer seemed to work.");
				break;
			}
			System.out.println("\n!!!Please enter yes or no!!!");
		}while(!answer.equals("yes") || !answer.equals("no"));
	}
}
