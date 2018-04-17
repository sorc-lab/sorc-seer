package lsp.violation;

public class Gun
{
	protected String label;
	int magazine;
	int chamber;
	private boolean isChambered;
	private boolean isTriggerPulled;
	
	public Gun()
	{
		label = "Gun";
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
	
	protected void discharge()
	{
		if (getIsChambered() && getIsTriggerPulled()) {
			isChambered = false;
			System.out.println(label + " fired!\n");
		} else {
			System.out.println(label + " did not fire, check if chambered.\n");
		}
	}
	
	public int getAmmo() { return magazine; }
	public boolean getIsChambered() { return isChambered; }
	public boolean getIsTriggerPulled() { return isTriggerPulled; }
	public void setIsChambered(boolean status) { isChambered = status; }
}
