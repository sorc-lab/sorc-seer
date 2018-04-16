package isp.solution;

public class TreeInteraction implements TreeInteractable
{
	Forest forest;
	Flyer flyer;
	
	@Override
	public String checkTree(int treeHight, Flyer flyer) {
		if (flyer.altitude == treeHight) {
			return "equal";
		} else if (flyer.altitude > treeHight) {
			return "low";
		} else {
			return "high";
		}
	}

	@Override
	public boolean landOnTree(int treeHight, Flyer flyer) {
		if (flyer.altitude == treeHight) {
			System.out.println("Landing successful!");
			flyer.isLanded = true;
			return true;
		} else if (flyer.altitude < treeHight) {
			System.out.println("Landing FAILED! Tree is too high.");
		} else if (flyer.altitude > treeHight) {
			System.out.println("Landing FAILED! Tree is too low.");
		}
		return false;
	}
}
