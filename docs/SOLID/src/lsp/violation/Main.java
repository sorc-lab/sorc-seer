package lsp.violation;

public class Main
{
	public static void main(String[] args)
	{

		/**
		 * have two rifles, bolt action and assault 
		 * call fireVolley from a Commander class that fires in a row
		 * and see how that breaks when you use it w/ a sniper rifle
		 */
		
		Rifle rifle = new Rifle();
		
		for (int i = 0; i < 50; i++) {
			rifle.fire();
			rifle.loadRound();
			
			if (rifle.getAmmo() < 25) {
				rifle.reload();
			}
		}
	}
}
