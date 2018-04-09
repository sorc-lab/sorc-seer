package srp.violation;

import java.util.HashMap;
import java.util.Map.Entry;

public class Netlist {
	// reportNetworkStatus: print network status
	// getIp: return ip
	// getStatus: return ONLINE or OFFLINE
	// getId: return id
	
	HashMap<String, String> network = new HashMap<String, String>();
	String ip;
	
	public Netlist()
	{
		this.network.put("10.10.43.140", "SORC-JMPBX");
		this.network.put("10.10.43.141", "SORC-DROPSTORE");
		this.network.put("10.10.43.142", "SORC-STAGE");
		this.network.put("10.10.43.143", "SORC-WORK01");
		this.network.put("10.10.43.144", "SORC-T530");
		
		for (Entry<String, String> entry : network.entrySet()) {
            if (entry.getValue().equals("SORC-T530")) {
                System.out.println(entry.getKey());
            }
        }
	}
	
	public String getIp(String id)
	{
		for (Entry<String, String> entry : network.entrySet()) {
            if (entry.getValue().equals(id)) {
                this.ip = entry.getKey();
            }
        }
		
		return this.ip;
	}
	
	
	
	
}
