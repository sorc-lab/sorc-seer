import java.util.Scanner;

public class ConvertSeconds
{
	public static void main(String[] args)
	{
		System.out.print("Enter seconds: ");
		Scanner reader = new Scanner(System.in);
		int in_secs = reader.nextInt();
		reader.close();

		int hrs = in_secs / 3600;
		int mins = (in_secs % 3600) / 60;
		int secs = (in_secs % 3600) % 60;

		System.out.printf("%d seconds = %d hours, %d minutes, and %d seconds \n",
			in_secs, hrs, mins, secs);
		return;
	}
}
