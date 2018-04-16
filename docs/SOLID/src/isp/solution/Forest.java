package isp.solution;

import java.util.Random;

public class Forest
{
	int[] trees;
	
	public Forest()
	{
		trees = new int[2000];
		Random rand = new Random();
		for (int i = 0; i < trees.length; i++)
			trees[i] = rand.nextInt(115) + 10;
	}
	
	public int getTree(int i) { return trees[i + 1]; }
}
