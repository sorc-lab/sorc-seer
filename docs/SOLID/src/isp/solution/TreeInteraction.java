package isp.solution;

public class TreeInteraction implements TreeInteractable
{
	Forest forest;
	Flyer flyer;
	
	@Override
	public String checkTree(int treeIndex) {
		int treeHeight = forest.getTree(treeIndex);
		if (flyer.altitude == treeHeight) {
			return "equal";
		} else if (flyer.altitude > treeHeight) {
			return "low";
		} else {
			return "high";
		}
	}

	@Override
	public boolean landOnTree(int treeIndex) {
		int treeHeight = forest.getTree(treeIndex);
		if (flyer.altitude == treeHeight) {
			System.out.println("Landing successful!");
			flyer.isLanded = true;
			return true;
		} else if (flyer.altitude < treeHeight) {
			System.out.println("Landing FAILED! Tree is too high.");
		} else if (flyer.altitude > treeHeight) {
			System.out.println("Landing FAILED! Tree is too low.");
		}
		return false;
	}
}
