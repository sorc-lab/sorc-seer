package ocp.solution;

// StealthEvent has no idea that Hide, Sneak, and ShadowDash even exist!
public class StealthEvent
{
	private Ninja ninja;
	
	public StealthEvent(final Ninja ninja)
	{
		this.ninja = ninja;
	}
	
	public void changeStealthMode(final StealthMode stealthMode)
	{
		ninja.setMovementSpeed(stealthMode.getMovementSpeed());
		ninja.setVisibility(stealthMode.getVisibility());
	}
}
