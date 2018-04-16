package isp.solution;

public interface Flyable
{
	void fly();
	int getAltitude();
	void setAltitude(int n);
	boolean getIsLanded();
	void setIsLanded(boolean isLanded);
}
