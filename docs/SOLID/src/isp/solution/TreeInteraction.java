package isp.solution;

public class TreeInteraction implements TreeInteractable
{
	Flyer flyer;
	
	public TreeInteraction(Flyer flyer) { this.flyer = flyer; }
	
	@Override
	public String checkTree(int treeHight)
	{
		if (flyer.getAltitude() == treeHight) {
			return "equal";
		} else if (flyer.getAltitude() > treeHight) {
			return "low";
		} else {
			return "high";
		}
	}

	@Override
	public boolean landOnTree(int treeHight)
	{
		if (flyer.getAltitude() == treeHight) {
			System.out.println("Landing successful!");
			flyer.setIsLanded(true);
			return true;
		} else if (flyer.getAltitude() < treeHight) {
			System.out.println("Landing FAILED! Tree is too high.");
		} else if (flyer.getAltitude() > treeHight) {
			System.out.println("Landing FAILED! Tree is too low.");
		}
		return false;
	}
}
