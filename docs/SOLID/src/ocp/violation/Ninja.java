package ocp.violation;

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
