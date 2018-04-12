package ocp.solution;

/**
 * OCP: Class should be open to extension but closed to modification.
 * By using an Interface StealthMode that contains getMovementSpeed() and
 * getVisibility(), we can create a class for each Stealth mode that will
 * implement the StealthMode interface and OVERRIDE those getters.
 * 
 * e.g.:
 	private static final int MOVEMENT_SPEED = 200;
	private static final int VISIBILITY = 0;
	
	public int getMovementSpeed() { return MOVEMENT_SPEED; }
	public int getVisibility() { return VISIBILITY; }
	
 * By using constant variables inside those classes we no longer need to use
 * switch statements to figure out what type of StealthMode is being used, we
 * can pass the obj. 'Hide' or whatever to the StealthEvent class, which stores
 * the 'changeStealthMode' function that calls the Ninja obj.'s setters.
 * 
 	public void changeStealthMode(final StealthMode stealthMode)
	{
		ninja.setMovementSpeed(stealthMode.getMovementSpeed());
		ninja.setVisibility(stealthMode.getVisibility());
	}
	
 * Now when we need to add a new stealth mode, we can just create a new class
 * and not have to modify any existing code.
 */
public class Ninja
{
	private int movementSpeed;
	private int visibility;
	
	public Ninja()
	{
		movementSpeed = 100;
		visibility = 100;
	}
	
	public int getMovementSpeed() { return movementSpeed; }
	public int getVisibility() { return visibility; }
	
	public void setMovementSpeed(final int movementSpeed)
	{
		this.movementSpeed = movementSpeed;
	}
	
	public void setVisibility(final int visibility)
	{
		this.visibility = visibility;
	}
}
