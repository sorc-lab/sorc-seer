package isp.solution;

public class Glide implements Glideable
{
	Forest forest;
	Flyer flyer;

	@Override
	public void reduceAltitude(Flyer flyer, int n) { flyer.altitude -= n; }

	@Override
	public void flyDownTo(int treeHeight, Flyer flyer) {
		if (flyer.altitude > treeHeight) {
			System.out.println("Reducing altitude...");		
			while (flyer.altitude != treeHeight)
				reduceAltitude(flyer, 1);
		}
	}
	
}
