import java.rmi.Naming;

// File Server Class
public class RMIFileServer {

	public static void main(String [] args) throws Exception {

		try{
			FileServerInterfaceImpl serverImplementation = new FileServerInterfaceImpl();

			String hostName = "localhost";
			String serviceName = "remoteObject";
			// Link the FileServerInterfaceImpl and name it
			Naming.rebind("rmi://"+hostName+"/"+serviceName, serverImplementation);

			System.out.println("Server is ready");
		}
		catch(Exception e){
			// Ignored
		}
	}
}
