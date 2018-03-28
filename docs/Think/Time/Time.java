public class Time
{
	private int hour;
	private int minute;
	private double second;
	
	public Time()
	{
		this.hour = 0;
		this.minute = 0;
		this.second = 0.0;
	}

	// Constructor: Time time = new Time(11, 59, 59.9)
	public Time(int hour, int minute, double second)
	{
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
}
