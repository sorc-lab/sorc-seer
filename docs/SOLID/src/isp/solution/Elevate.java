package isp.solution;

public class Elevate implements Elevatable
{
	Forest forest;
	Flyer flyer;
	
	public Elevate(Flyer flyer) { this.flyer = flyer; }
	
	@Override
	public void elevateAltitude(int n) {
		flyer.setAltitude(flyer.getAltitude() + 1);
	}

	@Override
	public void flyUpTo(int treeHeight)
	{
		if (flyer.getAltitude() < treeHeight) {
			System.out.println("Gaining altitude...");		
			while (flyer.getAltitude() != treeHeight)
				elevateAltitude(1);
		}
	}
}
