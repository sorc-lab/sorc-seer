package ocp.solution;

public class Hide implements StealthMode
{
	private static final int MOVEMENT_SPEED = 0;
	private static final int VISIBILITY = 0;
	
	@Override
	public int getMovementSpeed() { return MOVEMENT_SPEED; }
	
	@Override
	public int getVisibility() { return VISIBILITY; }
}
