package isp.solution;

/**
 * Interface Segregation Principle (ISP):
 * All functionality needed for Birds consist of more than what Glider needs.
 * Glider is a Flyer but does not need:
 * 		gainAltitude or flyUpToTree
 * Flyable needs to be broken into two interfaces.
 * Flyer needs to be broken into two classes.
 */

// TODO: Add example showing Bird and Glider objects breaking the game loop.
public interface Flyable {
	public void fly();
	public int getAltitude();
	public void gainAltitude(int n);
	public void reduceAltitude(int n);
	public void flyUpToTree(int tree);
	public void flyDownToTree(int tree);
	public boolean landOnTree(int tree);
	public String checkTree(int tree);
}
