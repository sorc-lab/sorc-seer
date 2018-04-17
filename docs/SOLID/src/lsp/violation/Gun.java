package lsp.violation;

public class Gun
{
	int magazine;
	int chamber;
	private boolean isChambered;
	private boolean isTriggerPulled;
	
	public Gun()
	{
		magazine = 25;
		isChambered = false;
		isTriggerPulled = false;
	}
	
	public void loadRound()
	{
		magazine--;
		isChambered = true;
	}
	
	public void pullTrigger()
	{
		isTriggerPulled = true;
		discharge();
	}
	
	public void releaseTrigger() { isTriggerPulled = false; }
	
	private void discharge()
	{
		if (isChambered && isTriggerPulled) {
			isChambered = false;
			System.out.println("Weapon fired!");
		} else {
			System.out.println("Weapon did not fire, check if chambered.");
		}
	}
	
	public int getAmmo() { return magazine; }
}
