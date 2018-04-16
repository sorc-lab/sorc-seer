package isp.solution;

import java.util.Random;

public class Flyer implements Flyable
{
	private int altitude;
	private boolean isLanded;
	
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
	
	@Override
	public void setAltitude(int n) { altitude = n; }
	
	@Override
	public boolean getIsLanded() { return isLanded; }
	
	@Override
	public void setIsLanded(boolean isLanded) { this.isLanded = isLanded; }
}
