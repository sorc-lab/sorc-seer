package isp.solution;

public class TreeFlyer extends Flyer
{
	Elevate elevate;
	Glide glide;
	TreeInteraction treeInteraction;
	
	public TreeFlyer()
	{
		elevate = new Elevate();
		glide = new Glide();
		treeInteraction = new TreeInteraction();
	}
}
