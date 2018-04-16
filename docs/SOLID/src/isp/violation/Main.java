package isp.violation;

import java.util.Random;

public class Main
{
	public static void main(String[] args)
	{
		int gameCnt = 5;
		Random rand = new Random();
		Glider flyer = new Glider(); // showing breakage w/ Glider vs. Flyer
		
		for (int i = 0; i < gameCnt; i++) { // game loop
			flyer.isLanded = false;
			System.out.println("altitude = " + flyer.getAltitude() + " meters");
			int tree = rand.nextInt(2000) + 1;
			
			if (!flyer.landOnTree(tree)) {
				while (!flyer.isLanded) {
					String checkTree = flyer.checkTree(tree);
					if (checkTree == "low") {
						flyer.flyDownToTree(tree);
					} else {
						flyer.flyUpToTree(tree);
					}
					
					flyer.landOnTree(tree);
				}
			}
		}
	}
}
