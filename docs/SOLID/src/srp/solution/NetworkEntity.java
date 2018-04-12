package srp.solution;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * NetworkEntity class contains a 'hostName' and 'ip' field that will take
 * whatever the user passes into its constructor. The getStatus function will
 * return true/false if the set 'ip' field returns a ping response. The class
 * only has one reason to change--if the IP address is provided in a different
 * format, i.e. IPv6, instead of the current IPv4 format. 
 */
public class NetworkEntity
{
	private String _hostName;
	private String _ip;
	
	public NetworkEntity(String hostName, String ip)
	{
		this._hostName = hostName;
		this._ip = ip;
	}
	
	public String getHostName() { return _hostName; }
	public String getIp() { return _ip; }
	
	// one reason to change, IPv4 to IPv6
	public boolean getStatus()
	{
		String[] splitIp = _ip.split("\\.");
		
		byte nib1 = (byte) Integer.parseInt(splitIp[0]);
		byte nib2 = (byte) Integer.parseInt(splitIp[1]);
		byte nib3 = (byte) Integer.parseInt(splitIp[2]);
		byte nib4 = (byte) Integer.parseInt(splitIp[3]);
		
		InetAddress inetAddr;
		
		try {
			inetAddr = InetAddress.getByAddress(
				new byte[] { nib1, nib2, nib3, nib4 }
			);
			
			try {
				if (inetAddr.isReachable(100)) {
					return true;
				} else {
					return false;
				}
			} catch (IOException e) {
				
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
