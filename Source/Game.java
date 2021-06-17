package Source;
import java.util.Scanner;

class Game {
	public static void main(String[] args) {
		int lowerlimit, upperlimit;
		if(args.length == 0) {
			lowerlimit = 1;
			upperlimit = 10;
		}
		else if(args.length == 1) {
			lowerlimit = Integer.parseInt(args[0]);
			upperlimit = 10;
		}
		else {
			lowerlimit = Integer.parseInt(args[0]);
			upperlimit = Integer.parseInt(args[1]);
		}

		if(lowerlimit < 0 || upperlimit < 0) System.out.println("Either of the limits is negative");
		else if(lowerlimit == upperlimit) System.out.println("Upper and lowerlimits cannot be equal!");
		else Game.logic(lowerlimit, upperlimit);
	}

	public static void logic(int lowerlimit, int upperlimit) {
		java.util.Random rand = new java.util.Random();
		int random = rand.nextInt(upperlimit - lowerlimit) + lowerlimit;
		Scanner myScanner = new Scanner(System.in);

		System.out.println("A random number between " + lowerlimit + " and " + upperlimit + " has been chosen. You have 5 tries to guess the correct answer");
		for(int i = 0; i < 5; i++) {
			int input;

			try {
				String val = myScanner.next();
				input = Integer.parseInt(val);
			}
			catch(NumberFormatException err) {
				System.out.println("Please provide a valid number as input!");
				i -= 1;
				continue;
			}

			if(input == random) {
				System.out.println("You guessed the correct number! You win!");
				break;
			}
			else {
				if(input > random) System.out.println("The number is less than the given number");
				else System.out.println("The number is more than the given number");

				if(i == 4) System.out.println("You lost! The number was " + random);
				else System.out.println("Number of tries left: " + (4 - i));
			}
		}

		myScanner.close();
	}
}