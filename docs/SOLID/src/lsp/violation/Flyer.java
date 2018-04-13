package lsp.violation;

import java.util.Random;

public class Flyer
{
	private int altitude;
	
	public Flyer()
	{
		fly();
		Random rand = new Random();
		altitude = rand.nextInt(7290) + 1;
	}
	
	private void fly() {
		System.out.println("You are flying in the air.");
	}
	
	public int getAltitude() { return altitude; }
	public void gainAltitude(int n) { altitude += n; }
	public void reduceAltitude(int n) { altitude -= n; }
	
	public void landOnTree(int treeHeight)
	{
		if (altitude == treeHeight) {
			System.out.println("Landing successful!");
		} else if (altitude < treeHeight) {
			System.out.println("Landing FAILED! Tree is too high.");
		} else if (altitude > treeHeight) {
			System.out.println("Landing FAILED! Tree is too low.");
		}
	}
	
	// break into two methods: flyUpToTree and flyDownToTree--using gain/reduce
	// altitude functions.
	public void autoLanding(int treeHeight)
	{
		System.out.println(
			"Executing autoLanding(treeHeight = " + treeHeight + ") function..."
		);
		
		// Find way to divide the distance the least number of times in a loop
		// in order to reach the altitude needed to land.
		
		// hit up these links:
		// http://www.dotnetcurry.com/patterns-practices/1259/liskov-substitution-principle-perspective
		// https://people.cs.umass.edu/~rjust/courses/2017Fall/CS520/2017_09_14.pdf
	}
}
