package dip.violation;

public class ElectricPowerSwitch
{
	public LightBulb lightBulb;
	public boolean on;
	
	public ElectricPowerSwitch(LightBulb lightBulb)
	{
		this.lightBulb = lightBulb;
		this.on = false;
	}
	
	public boolean isOn() { return on; }
	
	public void press()
	{
		boolean checkOn = isOn();
		if (checkOn) {
			lightBulb.turnOff();
			on = false;
		} else {
			lightBulb.turnOn();
			on = true;
		}
	}
}
