package isp.violation;

public class Main
{

	public static void main(String[] args)
	{
		Flyer flyer = new Flyer();
		System.out.println("altitude = " + flyer.getAltitude() + " meters");
		
		int tree = 666;
		
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
