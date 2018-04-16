package isp.solution;

public class Elevate implements Elevatable
{
	Forest forest;
	Flyer flyer;
	
	@Override
	public void elevateAltitude(Flyer flyer, int n) { flyer.altitude += n; }

	@Override
	public void flyUpTo(int treeIndex)
	{
		int treeHeight = forest.getTree(treeIndex);		
		if (flyer.altitude < treeHeight) {
			System.out.println("Gaining altitude...");		
			while (flyer.altitude != treeHeight)
				elevateAltitude(flyer, 1);
		}
	}
}
