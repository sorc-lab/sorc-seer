package srp.solution;

public class Display
{
	public void printNetwork(NetworkEntity[] network)
	{
		for (int i = 0; i < network.length; i++) {
			NetworkEntity entity = network[i];
			String hostName = entity.getHostName();
			String ip = entity.getIp();
			String isOnline = entity.getStatus() ? "Online" : "Offline";
			
			System.out.println(hostName + ": " + ip + " (" + isOnline + ")");
		}
		
		return;
	}
}
