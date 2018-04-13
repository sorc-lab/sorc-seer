package lsp.violation;

public class Main
{

	public static void main(String[] args)
	{
		// super class -> subclass inherits too many things that it doesn't use
		// IS-A relationship is broken. Glider doesn't technically fly?
		// Make two subclasses of the super class and show how they cannot be
		// substituted for one another... they are not similar.
		
		// flyable object vs. a flyable animal?
		// a bird can soar and gain altitude, but a hang glider can only soar
		// A programmer that is using the Obj. Flyer should not have to know
		// that and should expect a hang glider that has enherited from the
		// flyer obj. to be able to gainAltitude in his flyToHigherTree method.
		
		// method getTrees
		// method getTreeHeight
		
		// method gain/lowerAltitude will reduce altitude and display it
		
		// flyToClosestHigherTree (glider cannot do this)
		// flyToClosestLowerTree
		
		Flyer flyer = new Flyer();
		System.out.println("altitude = " + flyer.getAltitude() + " meters");
		
		Forest forest = new Forest();
		int tree = forest.getClosestTreeHeight();
		System.out.println("closest tree = " + tree + " meters");
		
		flyer.landOnTree(tree);
		flyer.autoLanding(tree);
		
		
		// method landOnTree, requires altitude to match the tree's height
		// MUST reduce or gain altitude in order to match tree's height
	}

}
