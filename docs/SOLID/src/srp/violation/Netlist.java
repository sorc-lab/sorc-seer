package srp.violation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Netlist {
	/** TODO: printReport() method */
	/** TODO: Add exceptions and fix getIpFromId and getIdFromIp */
	/** TODO: Store Network objects in HashMap instead of str. data */
	
	HashMap<String, String> network = new HashMap<String, String>();
	
	public Netlist()
	{
		this.network.put("10.10.43.140", "SORC-JMPBX");
		this.network.put("10.10.43.141", "SORC-DROPSTORE");
		this.network.put("10.10.43.142", "SORC-STAGE");
		this.network.put("10.10.43.143", "SORC-WORK01");
		this.network.put("10.10.43.144", "SORC-T530");
	}
	
	public String getNetIpById(String id)
	{
		String ip = "";
		
		for (Entry<String, String> entry : network.entrySet()) {
            if (entry.getValue().equals(id)) {
            	ip = entry.getKey();
            } else {
            	ip = "Unable to get IP address from that ID.";
            }
        }
		
		return ip;
	}
	
	public String getIdByNetIp(String ip) { return network.get(ip); }
	
	public boolean getStatus(String ip)
	{
		String[] splitIp = ip.split("\\.");
		
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
				if (inetAddr.isReachable(200)) {
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
	
	public void printNetwork()
	{
		Iterator<Entry<String, String>> it = network.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> pair = it.next();
			String ip = pair.getKey();
			System.out.println(pair.getKey() + " = " + pair.getValue() + " (" + this.getStatus(ip) +")");
			it.remove(); // avoids a ConcurrentModificationException
		}
	}
}
