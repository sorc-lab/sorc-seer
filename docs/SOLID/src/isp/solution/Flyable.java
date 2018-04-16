package isp.solution;

//need to split some of these functions into more classes as well...
public interface Flyable
{
	public void fly();                 // keep
	public int getAltitude();          // keep
	public String checkTree(int tree); // keep
	
	public void gainAltitude(int n);   // maneuver, will not work for Glider
	public void reduceAltitude(int n); // maneuver
	
	public void flyUpToTree(int tree);   // maneuver
	public void flyDownToTree(int tree); // maneuver
	public boolean landOnTree(int tree); // maneuver (advanced?)
}
