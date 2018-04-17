package lsp.violation;

public class Main
{
	public static void main(String[] args)
	{
		/**
		 * AssaultRifle overrides the discharge() function to call loadRound()
		 * before discharge() returns. AssaultRifle now breaks Liskov's
		 * Substitution Principle because it cannot be substituted for its
		 * parent class: Gun.
		 * 
		 * Firing each Gun object in a loop should produce the exact same
		 * behavior.
		 */
		
		AssaultRifle assaultRifle = new AssaultRifle();
		assaultRifle.loadRound();
		for (int i = 0; i < 3; i++)
			assaultRifle.pullTrigger();
		
		BoltRifle boltRifle = new BoltRifle();
		for (int i = 0; i < 3; i++)
			boltRifle.pullTrigger();
	}
}
