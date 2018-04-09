package srp.violation;

public class Main
{
	public static void main(String[] args)
	{
		Netlist netlist = new Netlist();
		String id = netlist.getIdFromIp("10.10.43.144");
		//String ip = netlist.getIpFromId("SORC-T530");
	
		System.out.println(id);
		//System.out.println(ip);
		
		// replace w/ getIpFromId()
		boolean status = netlist.getStatus("10.10.43.140");
		System.out.println(status);
	}
}
