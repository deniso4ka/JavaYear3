
public class ProxyLocalServer implements WebServer  {

	RealLocalServer realLocalServer = new RealLocalServer();
	
	
	public void getConnection() {
		// TODO Auto-generated method stub
		
		System.out.println("You are attempting to connect to web but have connected instead to a Proxy ");
		System.out.println(" All website activity will be monitored ");
		realLocalServer.getConnection();
		
	}

}
