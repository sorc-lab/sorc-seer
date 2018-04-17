package isp.solution;

public class Glide implements Glideable
{
	Flyer flyer;
	
	public Glide(Flyer flyer) { this.flyer = flyer; }

	@Override
	public void reduceAltitude(int n)
	{
		flyer.setAltitude(flyer.getAltitude() - 1);
	}

	@Override
	public void flyDownTo(int treeHeight) {
		if (flyer.getAltitude() > treeHeight) {
			System.out.println("Reducing altitude...");		
			while (flyer.getAltitude() != treeHeight)
				reduceAltitude(1);
		}
	}
}
