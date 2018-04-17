package lsp.violation;

public class AssaultRifle extends Gun
{
	public AssaultRifle()
	{
		label = "Assault Rifle";
	}
	
	@Override
	protected void discharge()
	{
		if (getIsChambered() && getIsTriggerPulled()) {
			setIsChambered(false);
			System.out.print(label + " fired!\n");
			setIsChambered(true);
		}
	}
}
