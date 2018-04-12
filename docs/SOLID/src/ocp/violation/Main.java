package ocp.violation;

public class Main
{
	public static void main(String[] args)
	{
		Ninja ninja = new Ninja();
		StealthEvent stealth = new StealthEvent(ninja);
		stealth.changeStealthMode(StealthMode.HIDE);
		// movementSpeed and visibility are now 0
	}

}
