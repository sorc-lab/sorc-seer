import java.util.Random;
import java.util.Arrays;

public class Reduce
{
	public static void main(String[] args)
	{
		int[] scores = randomArray(30);
		int a = inRange(scores, 90, 100);
		int b = inRange(scores, 80, 90);
		int c = inRange(scores, 70, 80);
		int d = inRange(scores, 60, 70);
		int f = inRange(scores, 0, 60);

		System.out.println(Arrays.toString(scores));
		System.out.printf("A = %d, B = %d, C = %d, D = %d, F = %d\n",
			a,b,c,d,f);
		
		// calc & print histogram
		int[] counts = new int[100];
		for (int score : scores) {
			counts[score]++;

			if (counts[score] >= 1)
				System.out.printf("%2d = %d\n", score, counts[score]);
		}
	}

	public static int[] randomArray(int size)
	{
		Random random = new Random();
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(100);
		}
		return arr;
	}

	public static int inRange(int[] arr, int low, int high)
	{
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= low && arr[i] < high) {
				cnt++;
			}
		}
		return cnt;
	}
}
