package lsp.violation;

public class Rifle implements Gun
{
	private int ammo;
	private boolean isLoaded;
	
	public Rifle()
	{
		ammo = 25;
		loadRound();
	}
	
	public void loadRound() {
		isLoaded = true;
	}
	
	public void fire()
	{
		if (ammo > 0 && isLoaded) {
			ammo -= 1;
			isLoaded = false;
			System.out.println("Weapon fired.");
		} else if (!isLoaded) {
			System.out.println("No bullet in chamber.");
		} else {
			System.out.println("Weapon is out of ammo.");
		}
	}
	
	public void reload() { ammo = 25; }
	public int getAmmo() { return ammo; }
}
