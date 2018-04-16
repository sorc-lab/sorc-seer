package isp.solution;

public class Glider implements Glideable
{
	Forest forest;
	Flyer flyer;

	@Override
	public void reduceAltitude(Flyer flyer, int n) { flyer.altitude -= n; }

	@Override
	public void flyDownTo(int treeIndex) {
		int treeHeight = forest.getTree(treeIndex);
		if (flyer.altitude > treeHeight) {
			System.out.println("Reducing altitude...");		
			while (flyer.altitude != treeHeight)
				reduceAltitude(flyer, 1);
		}
	}
	
}
