public class CheckFermat
{
	public static void main(String[] args)
	{
		checkFermat(1, 2, 3, 2);
	}
	
	/*
	 * Fermat's Last Theorem says that there are no integers a, b, and c such
	 * that a^n +b^n = c^n, except when n <= 2
	 *
	 * Takes four integers as parms.--a, b, c, and n, and checks to see if
	 * Fermat's theorem holds
	 * If n is greater than 2 and a^n + b^n = c^n, the program should display
	 * "Holy smokes, Fermat was wrong!"
	 * Otherwise the program shoud display "No, that doesn't work."
	 */
	private static boolean checkFermat(int a, int b, int c, int n)
	{

		boolean check_fermat = (
			n > 2 && Math.pow(a, n) + Math.pow(b, n) == Math.pow(c, n)
		);

		if (!check_fermat) {
			System.out.println("No, that doesn't work.");
		}
		else {
			System.out.println("Holy smokes, Fermat was wrong!");
			return false;
		}

		return true;
	}
}
