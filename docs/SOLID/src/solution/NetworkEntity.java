package solution;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkEntity
{
	private String _hostName;
	private String _ip;
	
	public NetworkEntity(String hostName, String ip)
	{
		this._hostName = hostName;
		this._ip = ip;
	}
	
	public String getHostName() { return this._hostName; }
	public String getIp() { return this._ip; }
	
	public boolean getStatus()
	{
		String[] splitIp = this._ip.split("\\.");
		
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
