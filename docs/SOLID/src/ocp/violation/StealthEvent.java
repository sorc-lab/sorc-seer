package ocp.violation;

public class StealthEvent
{
	private Ninja ninja;
	
	public StealthEvent(final Ninja ninja)
	{
		this.ninja = ninja;
	}
	
	// violation
	public void changeStealthMode(final StealthMode stealthMode)
	{
		switch (stealthMode) {
			case HIDE:
				ninja.setMovementSpeed(0);
				ninja.setVisibility(0);
				break;
			case SNEAK:
				ninja.setMovementSpeed(50);
				ninja.setVisibility(50);
				break;
			default:
				ninja.setMovementSpeed(100);
				ninja.setVisibility(100);
				break;
		}
		
		// When a new StealthMode (Shadow Dash) is added, 2 classes will have
		// to change--StealthMode and the StealthEvent.
	}
}
