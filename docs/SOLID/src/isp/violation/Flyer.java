package isp.violation;

import java.util.Random;

public class Flyer implements Flyable
{
	private int altitude;
	Forest forest;
	boolean isLanded;

	public Flyer()
	{
		forest = new Forest();
		fly();
		Random rand = new Random();
		altitude = rand.nextInt(7290) + 1;
		isLanded = false;
	}

	@Override
	public void fly() {
		System.out.println("You are flying in the air.");
	}
	
	@Override
	public int getAltitude() { return altitude; }
	
	@Override
	public void gainAltitude(int n) { altitude += n; }
	
	@Override
	public void reduceAltitude(int n) { altitude -= n; }
	
	@Override
	public boolean landOnTree(int tree)
	{
		int treeHeight = forest.getTree(tree);
		
		if (altitude == treeHeight) {
			System.out.println("Landing successful!");
			isLanded = true;
			return true;
		} else if (altitude < treeHeight) {
			System.out.println("Landing FAILED! Tree is too high.");
		} else if (altitude > treeHeight) {
			System.out.println("Landing FAILED! Tree is too low.");
		}
		
		return false;
	}
	
	@Override
	public void flyUpToTree(int tree)
	{
		int treeHeight = forest.getTree(tree);
		
		if (altitude == treeHeight) {
			System.out.println(
				"You are at the same altitude as the tree, just land on it."
			);
			return;
		}
		
		if (altitude < treeHeight) {
			System.out.println("Reducing altitude...");		
			while (altitude != treeHeight)
				gainAltitude(1);
		}
		
		if (altitude > treeHeight) {
			System.out.println(
				"You are higher than that tree, try flying down."
			);
			return;
		}
	}

	@Override
	public void flyDownToTree(int tree)
	{
		int treeHeight = forest.getTree(tree);
		
		if (altitude == treeHeight) {
			System.out.println(
				"You are at the same altitude as the tree, just land on it."
			);
			return;
		}
		
		if (altitude < treeHeight) {
			System.out.println(
				"You are lower than that tree, try flying up."
			);
			return;
		}
		
		if (altitude > treeHeight) {
			System.out.println("Reducing altitude...");		
			while (altitude != treeHeight)
				reduceAltitude(1);
		}
	}

	@Override
	public String checkTree(int tree) {
		int treeHeight = forest.getTree(tree);
		
		if (altitude == treeHeight) {
			return "equal";
		} else if (altitude > treeHeight) {
			return "low";
		} else {
			return "high";
		}
	}
}
