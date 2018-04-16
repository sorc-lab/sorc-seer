package isp.solution;

public class TreeFlyer extends Flyer
{
	Elevate elevate;
	Glide glide;
	TreeInteraction treeInteraction;
	
	public TreeFlyer()
	{
		elevate = new Elevate(this);
		glide = new Glide(this);
		treeInteraction = new TreeInteraction(this);
	}
}
