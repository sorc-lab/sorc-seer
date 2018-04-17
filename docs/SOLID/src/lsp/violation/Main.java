package lsp.violation;

public class Main
{
	public static void main(String[] args)
	{
		// VIOLATION
		// Gun class
			// pull trigger, release trigger, load round
			// magazine, chamber
			// fire gun, if trigger pulled
		
		// AssaultRifle extends Gun
			// fire: continues to fire if trigger is pulled && round in chamber
				// load round keeps getting called as long as magazine > 0 
		
		// BoltRifle extends Gun
			// stops firing if chamber is empty
			// does not automatically load new rounds
		
		// Command class
			// fire volley: shoots
			// NOTE: Behaves differently w/ Bolt vs. Assault but extends Gun
		
		Gun gun = new Gun();
		gun.loadRound();
		gun.pullTrigger();
		System.out.println(gun.getAmmo());
		gun.loadRound();
		gun.pullTrigger();
	}
}
