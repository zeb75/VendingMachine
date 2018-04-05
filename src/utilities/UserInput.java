package utilities;

import java.util.Scanner;

public class UserInput {
	
	private static Scanner numSc = new Scanner(System.in);

	
	public static int getInt() {
		
		int input = 1;
		while (true) {
			
			try {
				input = numSc.nextInt();
				return input;
				}
				
			catch (Exception e) {
				System.out.println("Not a number");
				numSc.nextLine();
				
			}
		}
		
	}
	
}
