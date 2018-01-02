import java.util.Scanner;

class CelsiusToFahrenheit
{
	public static void main(String[] args)
	{
		// 1. Prompt user for input
		// 2. Read a double value from the keyboard
		// 3. Calculate the result
		// 4. Format the output to one decimal place
		// e.g. "24.0 C = 75.2 F"
		//
		// F = C * 9/5 + 32

		System.out.print("Enter degrees in Celsius: ");
		double celsius = _getUserInput();
		double fahrenheit = calculate(celsius);

		System.out.printf("%.1f C = %.1f F\n", celsius, fahrenheit);
		return;
	}

	private static double _getUserInput()
	{
		Scanner reader = new Scanner(System.in);
		double user_input = reader.nextInt();
		reader.close();
		return user_input;
	}

	public static double calculate(double celsius)
	{
		return celsius * (9/5) + 32;
	}
}
