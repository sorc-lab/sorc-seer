package ocp.solution;

public class Sneak implements StealthMode
{
	private static final int MOVEMENT_SPEED = 50;
	private static final int VISIBILITY = 50;
	
	public int getMovementSpeed() { return MOVEMENT_SPEED; }
	public int getVisibility() { return VISIBILITY; }
}
