package composition.example1;

public class BeeTest
{
	public static void main(String[] args)
	{
		Bee bee = new Bee(1, "black", new AttackImpl("fly", "move"));
		bee.attack();
		
		// If another impl. of move() is needed then changes do not need to be
		// made to Insect. Instead, use a new method to attack.
		
		Bee killerBee = new Bee(1, "black", new AttackImpl("fly", "sting"));
		killerBee.attack();
	}
}
