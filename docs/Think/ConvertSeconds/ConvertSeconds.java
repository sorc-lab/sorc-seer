import java.util.Scanner;

public class ConvertSeconds
{
	public static void main(String[] args)
	{
		//System.out.print("Enter seconds: ");
		//Scanner reader = new Scanner(System.in);
		//double in_secs = reader.nextDouble();
		//reader.close();

		double in_secs = Double.parseDouble(args[0]);

		double hrs = in_secs / 3600;
		double mins = (in_secs % 3600) / 60;
		double secs = (in_secs % 3600) % 60;

		System.out.printf(
			"%.2f seconds = %.2f hours, %.2f minutes, and %.2f seconds \n",
			in_secs, hrs, mins, secs
		);


		return;
	}
}
