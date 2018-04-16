package isp.solution;

import java.util.Random;

public class Main
{
	public static void main(String[] args)
	{
		/*
		NOTE: Will need 3 interfaces for basic flying, plane-type flying and
		      glider-type flying.
		
		interface TailedAnimal {
		    void moveTail();
		}
		interface HornedAnimal {
		    void hitWithHorn();
		}
		class Rhinoceros() implements TailedAnimal, HornedAnimal {
		    private TailedAnimal tail;  //Instantiate it somehow e.g. constructor, setter
		    private HornedAnimal horn;  //Instantiate is somehow e.g. constructor, setter
		    public void moveTail() {
		        tail.moveTail();
		    }
		    public void hitWithHorn() {
		        horn.hitWithHorn();
		    }
		}
		 */
		
		int gameCnt = 5;
		Random rand = new Random();
		Flyer flyer = new Flyer();
		
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
