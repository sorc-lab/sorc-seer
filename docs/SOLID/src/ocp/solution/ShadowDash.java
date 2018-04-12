package ocp.solution;

public class ShadowDash implements StealthMode
{
	private static final int MOVEMENT_SPEED = 200;
	private static final int VISIBILITY = 0;
	
	public int getMovementSpeed() { return MOVEMENT_SPEED; }
	public int getVisibility() { return VISIBILITY; }
}
