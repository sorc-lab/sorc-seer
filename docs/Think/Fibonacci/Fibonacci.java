public class Fibonacci
{
	public static void main(String[] args)
	{
		fibonacci(2);
	}
	
	/**
	 * Computes Fibonacci sequence of given n.
	 * @param n number given
	 * @return Fibonacci sequence
	 */
	public static int fibonacci(int n)
	{
		if (n == 1 || n == 2) {
			return 1;
		}

		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
