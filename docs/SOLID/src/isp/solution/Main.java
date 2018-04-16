package isp.solution;

import java.util.Random;

public class Main
{
	public static void main(String[] args)
	{
		/**
		 * Flyer can now use component behaviors, but all component behaviors
		 * now have to pass in the Flyer as a parameter to access its fields.
		 * Seems wrong...
		 */
		int gameCnt = 5;
		Random rand = new Random();
		TreeFlyer flyer = new TreeFlyer();
		Forest forest = new Forest();
		
		for (int i = 0; i < gameCnt; i++) { // game loop
			flyer.isLanded = false;
			System.out.println("altitude = " + flyer.getAltitude() + " meters");
			int treeIndex = rand.nextInt(2000) + 1;
			int tree = forest.getTree(treeIndex);
			
			if (!flyer.treeInteraction.landOnTree(tree, flyer)) {
				while (!flyer.isLanded) {
					String checkTree = flyer.treeInteraction.checkTree(tree, flyer);
					if (checkTree == "low") {
						flyer.glide.flyDownTo(tree, flyer);
					} else {
						flyer.elevate.flyUpTo(tree, flyer);
					}
					
					flyer.treeInteraction.landOnTree(tree, flyer);
				}
			}
		}
	}
}
