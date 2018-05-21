package srp.solution;

public class Main
{
	public static void main(String[] args)
	{
		NetworkEntity[] network = {
				new NetworkEntity("SORC-JMPBX", "10.10.43.140"),
				new NetworkEntity("SORC-DROPSTORE","10.10.43.141"),
				new NetworkEntity("SORC-STAGE", "10.10.43.142"),
				new NetworkEntity("SORC-WORK01", "10.10.43.143"),
				new NetworkEntity("SORC-T530", "10.10.43.144")
		};
		
		Display display = new Display();
		display.printNetwork(network);
	}
}
