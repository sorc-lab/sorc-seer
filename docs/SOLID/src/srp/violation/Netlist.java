package srp.violation;

import java.util.HashMap;

public class Netlist {
	// reportNetworkStatus: print network status
	// getIp: return ip
	// getStatus: return ONLINE or OFFLINE
	// getId: return id
	
	HashMap<String, String> network = new HashMap<String, String>();
	
	public Netlist()
	{
		this.network.put("10.10.43.140", "SORC-JMPBX");
		this.network.put("10.10.43.141", "SORC-DROPSTORE");
		this.network.put("10.10.43.142", "SORC-STAGE");
		this.network.put("10.10.43.143", "SORC-WORK01");
		this.network.put("10.10.43.144", "SORC-T530");
	}
	
	public String getIp(String name)
	{
		return "";
	}
	
	
}
