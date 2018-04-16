package isp.solution;

import java.util.Random;

public class Flyer implements Flyable
{
	protected int altitude;
	protected boolean isLanded;
	
	public Flyer()
	{
		fly();
		Random rand = new Random();
		altitude = rand.nextInt(7290) + 1;
		isLanded = false;
	}
	
	@Override
	public void fly() {
		System.out.println("You are flying in the air.");
	}
	
	@Override
	public int getAltitude() { return altitude; }
}
