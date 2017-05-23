import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.applet.Applet;
import java.applet.AudioClip;

import javax.swing.*;


//Client Chat Application
public class ChatClient extends JFrame {

	private static ChatGUI chatGUI = new ChatGUI();
	private static AudioClip beep;
	private static String soundPath = "file:./start.wav";
	private static boolean checkTextField;
	private static String username;
	private static String serverName;
	private static int port;
	public BufferedReader reader;
	public PrintWriter writer;
	private Socket socket;
	private SimpleDateFormat date;


	//Create the Constructor
	public ChatClient() {

		//Date Format to include the current time
		date = new SimpleDateFormat("HH:mm:ss");

		//Add Action Listener to the button (when message is sent)
		chatGUI.getSendMessageButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try{
					//Add the exact time of the sent messages
					String currentDate = "Message sent at " + date.format(new Date());
					String message = username + ": " + chatGUI.getMessageToSendField().getText() + "\n" + currentDate + "\n";
					//sending text field content TO THE SERVER after button has been pressed
					writer.println(message);
					writer.flush();
				}
				catch(Exception e) {
					e.printStackTrace();
				}

				//Clear the text field after sending the message
				chatGUI.getMessageToSendField().setText("");
				chatGUI.getMessageToSendField().requestFocus();
			}
		});
	}

	//Main method
	public static void main(String[] args) {

		askForName();
		//System.out.println(username);
		chatGUI.getUsernameLabel().setText(username);

		//Assign the arguments to the server and port
		
		//serverName = args[0];
		//port = Integer.parseInt(args[1]);
		
		//serverName = "localhost";
		//port = 8808;
		
		//Start the connection
		ChatClient client = new ChatClient();
		client.startChat();
	}

	//Display the Dialog Box
	//Ask the user for the chat username to be used
	public static void askForName() {

		//Use the loop to make sure that there is String (username) entered
		//(Null value is always returned when the CANCEL button is pressed)
		do {
			username = JOptionPane.showInputDialog(null, "Enter your chat Username!");
		} while (username == null || (username != null && ("".equals(username))));

		//Welcoming sound effect
		try {
			beep = Applet.newAudioClip(new URL(soundPath));
			beep.play();
		}
		catch (MalformedURLException exception) {
			System.out.println("Wrong URL to locate a wave file!");
		}
	}


	//Make connection and start the chat
	public void startChat() {

		//Call the connection method to connect to the Server
		connection();

		//Create the tread and read the incoming message
		Thread thread = new Thread(new IncomingReader());
		thread.start();
	}

	//Make connection to the Server
	private void connection() {

		//String messageOut = username + " " + chatGUI.getMessageToSendField().getText();

		try{
			//socket = new Socket(serverName, port);
			socket = new Socket("localhost", 6077);
			InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(socket.getOutputStream());
			System.out.println(username + " connected to the chat");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	//Execute threads to display the messages in the chat text area
	public class IncomingReader implements Runnable {
		public synchronized void run() {

			String message;

			try {
				//Thread.sleep(1000);
				//while (true) {
					while ((message = reader.readLine()) !=null) {
						//chatGUI.getSendMessageButton().setEnabled(true);
						System.out.println(message);
						chatGUI.getMessageContainer().append(message + "\n");

						//Set Caret Position of the Scroll Pane so it scrolls down automatically
						chatGUI.getMessageContainer().setCaretPosition(chatGUI.getMessageContainer().getDocument().getLength());

						//Reset the layout of the chat text area
						chatGUI.getMessageContainer().repaint();
						chatGUI.getMessageContainer().validate();
					}
				//}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
