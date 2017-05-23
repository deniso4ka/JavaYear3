import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

// Skeleton Class
public class FileServerInterfaceImpl extends UnicastRemoteObject implements FileServerInterface {

	private byte[] bytes;

	// Create the constructor to handle exceptions
	protected FileServerInterfaceImpl() throws RemoteException {
		super();
	}

	// Save the file on the server
	public int saveFile(String filename, byte[] bytes) throws RemoteException {

		try {
			// Store files received from a client
			File file = new File("filesServer/"+filename);
			FileOutputStream stream = new FileOutputStream(file);

			// If file doesn't exists, then create it
			if (!file.exists()){
				file.createNewFile();
			}

			// Store the file on the Server
			stream.write(bytes);
			stream.flush();
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//System.out.println("just to test"+filename);
		return 0;
	}

	// Delete the file
	public int deleteFile(String fileToDeletePath) throws RemoteException {

		// Retrieve files from the server folder and delete it (java jdk 8 supported)
		Path delete = Paths.get(fileToDeletePath);

		try {
			Files.delete(delete);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("File was succesfully removed");

		return 0;
	}

	// Save the file
	public byte[] openFile(String filePickedPath) throws RemoteException {

		// Read file to byte stream from server and send the file to client to open it
		FileInputStream input;
		try {
			input = new FileInputStream(new File(filePickedPath));

			bytes = new byte[1000000];
			input.read(bytes);
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bytes;
	}

	// Traverse the server folder and store all files from it
	// to the vector and display them
	public Vector<String> diplayFiles() throws RemoteException {

		Vector<String> files = new Vector<String>();
		// jdk 8 feature
		try {
			Files.walk(Paths.get("filesServer")).forEach(filePath -> {
				if(Files.isRegularFile(filePath)){
					//convert the path and store the value
					String test = filePath.toString();
					// Add the string path value to vector
					files.addElement(test);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		return files;
	}
}



