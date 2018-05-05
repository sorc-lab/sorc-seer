package dip.violation;

public class ElectricPowerSwitchTest
{
	/**
	 * ElectricPowerSwitch depends on LighBulb -- bad code
	 */
	public static void main(String[] args)
	{
		LightBulb lightBulb = new LightBulb();
		ElectricPowerSwitch powerSwitch = new ElectricPowerSwitch(lightBulb);
		
		for (int i = 0; i < 10; i++) {
			powerSwitch.press();
		}
	}
}
