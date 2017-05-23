import java.rmi.*;
import java.util.*;

// Create interface to declare methods
public interface FileServerInterface extends Remote {

	public int saveFile(String filename, byte[] bytes) throws RemoteException;
	public int deleteFile(String fileToDeletePath) throws RemoteException;
	public byte[] openFile(String filePickedPath) throws RemoteException;
	public Vector<String> diplayFiles() throws RemoteException;
}
