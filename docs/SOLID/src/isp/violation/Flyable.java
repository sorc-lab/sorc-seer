package isp.violation;

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
