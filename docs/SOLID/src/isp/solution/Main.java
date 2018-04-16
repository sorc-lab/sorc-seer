package isp.solution;

import java.util.Random;

public class Main
{
	public static void main(String[] args)
	{
		int gameCnt = 5;
		Random rand = new Random();
		TreeFlyer flyer = new TreeFlyer();
		Forest forest = new Forest();
		
		for (int i = 0; i < gameCnt; i++) { // game loop
			System.out.println("altitude = " + flyer.getAltitude() + " meters");
			flyer.setIsLanded(false);
			
			int treeIndex = rand.nextInt(2000) + 1;
			int tree = forest.getTree(treeIndex);
			
			
			if (!flyer.treeInteraction.landOnTree(tree)) {
				while (!flyer.getIsLanded()) {
					String checkTree = flyer.treeInteraction.checkTree(tree);
					if (checkTree == "low") {
						flyer.glide.flyDownTo(tree);
					} else {
						flyer.elevate.flyUpTo(tree);
					}
					flyer.treeInteraction.landOnTree(tree);
				}
			}
		}
	}
}
