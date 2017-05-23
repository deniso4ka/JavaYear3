import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.net.ServerSocket;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ChatServer {

	private ArrayList clientOutputStream;
	private int clientsCounter = 0;

	//Client Handler class maintains the list of all individual client's connections
	public class ClientHandler implements Runnable {

		BufferedReader reader;
		InputStreamReader read;
		Socket socket;

		//Create the user defined constructor
		public ClientHandler(Socket clientSocket){

			try{
				socket = clientSocket;
				read = new InputStreamReader(socket.getInputStream());
				reader = new BufferedReader(read);
			}
			catch(Exception e) {
				e.printStackTrace();
				//System.out.println("Someone logged out!");
			}
		}

		//Run method to read incoming messages and broadcast them to all chat clients
		public synchronized void run() {

			String message;

			try{
				//while (true) {
					while((message = reader.readLine()) !=null) {
						System.out.println(message);
						broadcastMessage(message);
					}
				//}
			}
			catch(Exception e) {
				//e.printStackTrace();
				System.out.println("One User left the Chat!");
				clientsCounter--;
				System.out.println("Users logged in: " + clientsCounter);
			}
		}
	}

	//Main method to create the new instance of ChatServer and start chat (initial network connection made)
	public static void main(String[] args) {

		new ChatServer().startChat();
	}

	//Make a connection and start the chat
	public void startChat(){

		clientOutputStream = new ArrayList();

		try{
			//Server is listening on the port 6066 for new socket connections (new clients)
			ServerSocket serverSocket = new ServerSocket(6077);
		
			while(true) {
				//Socket is accepted and Server can take messages from the client
				Socket clientSocket = serverSocket.accept();
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				clientOutputStream.add(writer);

				//Creating a Thread for the client
				Thread thread = new Thread(new ClientHandler(clientSocket));
				thread.start();

				//Count the number of logged in chat users
				System.out.println("One User Connected!");
				clientsCounter++;
				System.out.println("Users logged in: " + clientsCounter);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	//Broadcast messages to all chat participants
	private void broadcastMessage(String message) {

		Iterator iterator = clientOutputStream.iterator();

			while(iterator.hasNext()) {
				try {
					PrintWriter writer = (PrintWriter)iterator.next();
					writer.println(message);
					//Flush method makes sure that the messaeg is immediately sent to clients
					writer.flush();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
}
