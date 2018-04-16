package isp.solution;

import java.util.Random;

public class TreeGlider implements Flyable, Glideable, TreeInteractable
{
	private int altitude;
	private Forest forest;
	boolean isLanded;
	
	public TreeGlider()
	{
		forest = new Forest();
		fly();
		Random rand = new Random();
		altitude = rand.nextInt(7290) + 1;
		isLanded = false;
	}
	
	// TODO: Figure out how to create a builder class to prevent having to
	//       re-write all these methods every time.
	
	@Override
	public String checkTree(int tree) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flyUpToTree(int tree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flyDownToTree(int tree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean landOnTree(int tree) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reduceAltitude(int n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAltitude() {
		// TODO Auto-generated method stub
		return 0;
	}

}
