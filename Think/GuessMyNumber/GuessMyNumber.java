import java.util.Random;
import java.util.Scanner;

public class GuessMyNumber
{
	public static void main(String[] args)
	{
		/** ======================================================================= */
		// I'm thinking of a number between 1 and 100
		// (including both). Can you guess what it is?
		// Type a number: 45
		// Your guess is: 45
		// The number I was thinking of is: 14
		// You were off by: 31
		/** ======================================================================= */

		Random random = new Random();
		int num = random.nextInt(100) + 1;
		
		System.out.println("I'm thinking of a number between 1 and 100");
		System.out.println("(including both). Can you guess what it is?");
		System.out.print("Type a number: ");

		Scanner reader = new Scanner(System.in);
		int in_num = reader.nextInt();

		System.out.printf("Your guess is: %d\n", in_num);
		System.out.printf("The number I was thinking of is: %d\n", num);
		
		int diff = Math.abs(in_num - num);
		System.out.printf("You were off by: %d\n", diff);

	}
}
