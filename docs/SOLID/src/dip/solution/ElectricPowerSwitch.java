package dip.solution;

public class ElectricPowerSwitch implements Switch
{
	public Switchable client;
	public boolean on;
	
	public ElectricPowerSwitch(Switchable client)
	{
		this.client = client;
		this.on = false;
	}
	
	@Override
	public boolean isOn() { return on; }

	@Override
	public void press()
	{
		boolean checkOn = isOn();
		if (checkOn) {
			client.turnOff();
			on = false;
		} else {
			client.turnOn();
			on = true;
		}
	}
}
