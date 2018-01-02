import java.util.Scanner;

public class ConvertSeconds
{
	public static void main(String[] args)
	{
		// 1. Prompt the user for input
		// 2. Read an integer from the keyboard
		// 3. Calculate the result
		// 4. Use printf to display the output
		// e.g. "5000 seconds = 1 hours, 23 minutes, and 20 seconds"
		// 5000 seconds = 1.388889

		System.out.print("Enter seconds: ");
		Scanner reader = new Scanner(System.in);
		int input_seconds = reader.nextInt();
		reader.close();
		
		int hours;
		int minutes;
		int seconds;

		System.out.printf("%d\n", hours);
		return;
	}
}
