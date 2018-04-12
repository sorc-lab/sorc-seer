package ocp.solution;

public class Main
{
	public static void main(String[] args)
	{
		Ninja ninja = new Ninja();
		StealthEvent stealth = new StealthEvent(ninja);
		Hide hide = new Hide();
		Sneak sneak = new Sneak();
		ShadowDash shadowDash = new ShadowDash();
		
		stealth.changeStealthMode(hide);
		stealth.changeStealthMode(sneak);
		stealth.changeStealthMode(shadowDash);
	}
}
