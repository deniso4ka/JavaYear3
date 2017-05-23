import java.io.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

// Client RMI Class
public class RMIClient extends JFrame implements ActionListener, ListSelectionListener {

	private JButton fileChoose;
	private JButton open;
	private JButton save;
	private JButton delete;
	private JButton refresh;
	private JPanel panel;
	private FileServerInterface myfile;
	private String hostName;
	private String serviceName;
	private JList<String> list;
	private JScrollPane scrollPane;
	private Vector <String> fileList;
	private File selectedFile;
	private String filePickedFromJlist;
	private String warningMessage;
	private String title = "Warning Message";

	// RMI Constructor
	public RMIClient(){

		// Create the JButtons
		fileChoose = new JButton("Choose File to Upload");
		open = new JButton("Open");
		save = new JButton("Save");
		delete = new JButton("Delete");
		refresh = new JButton("Refresh");
		panel = new JPanel();

		// Set the features of the JPanel
		setSize(480,400);
		setVisible(true);
		setLocation(550, 10);
		setResizable(false);
		setTitle("FILE EXPLORER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add Action Listeners to the JButtons
		fileChoose.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		delete.addActionListener(this);
		refresh.addActionListener(this);

		// Add the JButtons to the JPanel
		add(panel, BorderLayout.SOUTH);
		panel.add(open);
		panel.add(save);
		panel.add(delete);
		panel.add(fileChoose);
		panel.add(refresh);

		// Hardcoded (can be taken from a text field)
		hostName = "localhost";
		// Hardcoded (can be taken from a text field)
		serviceName = "remoteObject";

		try {
			// Run methods (remotely) from the Server
			 myfile = (FileServerInterface) Naming.lookup("rmi://"+hostName+"/"+serviceName);

			 	// Create the vector to hold all the Server's files names
			 	fileList = new Vector<String>();

			 	// Create the scroll pane
			 	scrollPane = new JScrollPane();

			 	// Call the method (remotely) which returns Vector of strings with all files stored in the Server
			 	displayFilesFromServer();

			 	// Create an instance of the JList
			 	list = new JList<String>(fileList);

			 	// Assign the vector to JList (easier to manipulate selected files)
			 	displayList();

			 	// Add listener to JList, which allows to select and manipulate files
				list.addListSelectionListener((ListSelectionListener)this);

				// Add the JScrollPane to the JFrame
				add(scrollPane, BorderLayout.CENTER);
				repaint();
				revalidate();

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	// Action Listeners
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		// If fileChoose button pressed then JFIleChooser is called to pick the file to be stored on the server
				if(source == fileChoose){
					JFileChooser fileChooser = new JFileChooser();
					// Display the users current directory
					fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
					int result = fileChooser.showOpenDialog(this);

					if (result == JFileChooser.APPROVE_OPTION) {
						// Get the file selected from JFileChooser
					    selectedFile = fileChooser.getSelectedFile();

					    // This used only for testing (uncomment later)
					    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
					}

				}

		// If the save button is clicked - call teh remote method which pass the file name and array of bytes
		if(source == save){
			try {
				// If file was not selected before upload button pressed
				if (selectedFile == null) {
					System.out.println("No file was selected! [save operation]");
					warningMessage = "No file was selected! [save operation].";
					JOptionPane.showMessageDialog(new JFrame(), warningMessage, title, JOptionPane.WARNING_MESSAGE);
				}
				else {
					// Get teh name from selected file and pass the name to server (call the file the same name)
					String nameOfFilePickedFromFileChooser = selectedFile.getName();

					// Receive the selected file from JFileChooser and divide teh file into bytes
					FileInputStream input = new FileInputStream(new File(selectedFile.getAbsolutePath()));
					byte[] bytes = new byte[1000000];
					input.read(bytes);
					input.close();

					// Upload the file by passing file name and array of bytes
					// The given name is the name we want to appear for the file stored on the server
					myfile.saveFile(nameOfFilePickedFromFileChooser, bytes);
					System.out.println("File has been succesfully uploaded!");
				}
			} catch (IOException e1) {
				System.out.println("Cannot find any file!");
			}
		}

		// If delete button is clicked - call the remote 'delete' method
		else if(source == delete) {

			try {
				// If string filePickedFromJList is empty (add an error message)
				if (filePickedFromJlist == null) {
					System.out.println("No file was selected! [delete operation]");
					warningMessage = "No file was selected! [delete operation].";
					JOptionPane.showMessageDialog(new JFrame(), warningMessage, title, JOptionPane.WARNING_MESSAGE);
				}
				else {
					// Call the remote method which receives the directory with file name and then delete it
					int c = myfile.deleteFile(filePickedFromJlist);
				}
			} catch (RemoteException e1) {
					System.out.println("Cannot find any file!");
			}
		}

		// If open button is clicked - call the remote open method
		else if(source == open) {

			try {
				// If string filePickedFromJList is empty (add an error message)
				if (filePickedFromJlist == null) {
					System.out.println("No file was selected! [open operation]");
					warningMessage = "No file was selected! [open operation].";
					JOptionPane.showMessageDialog(new JFrame(), warningMessage, title, JOptionPane.WARNING_MESSAGE);
				}
				else {
					// Call the remote openFile method, which copies selected file and sends back an array of bytes
					byte[] bytesReceived = myfile.openFile(filePickedFromJlist);

					// Take away the file path and leave a file name only
					String fileNameWithOutPath = filePickedFromJlist.replace("filesServer", "");

					// Create the file in client folder and open it
					File file = new File("filesClient/"+fileNameWithOutPath);
					FileOutputStream stream = new FileOutputStream(file);

					// If file doesn't exist, then create it
					if (!file.exists()) {
						file.createNewFile();
					}

					// Write the file
					stream.write(bytesReceived);
					stream.flush();
					stream.close();

					// Open the file which was created
					File filePickedToOpen = new File("filesClient/"+fileNameWithOutPath);
					Desktop.getDesktop().edit(filePickedToOpen);
				}
			} catch (IOException error) {
				System.out.println("Cannot find any file!");
			}
		}

		// If 'refresh' button is clicked - refresh JList with files
		// Items taken from the server's files vector
		else if(source == refresh){

			// JList redisplay
			displayFilesFromServer();
			displayList();
		}
	}

	// Display a JList of files in ScrollPane taken from Vector
	private void displayList() {

		//list = new JList<String>(fileList);
		list.setListData(fileList);
		scrollPane.setViewportView(list);
		repaint();
		revalidate();
	}

	// Add colours to the GUI
	public void addColours() {

		panel.setBackground(Color.YELLOW);
		list.setBackground(Color.BLUE);
		list.setForeground(Color.YELLOW);

		fileChoose.setBackground(Color.BLACK);
		open.setBackground(Color.BLACK);
		save.setBackground(Color.BLACK);
		delete.setBackground(Color.BLACK);
		refresh.setBackground(Color.BLACK);

		fileChoose.setForeground(Color.YELLOW);
		open.setForeground(Color.YELLOW);
		save.setForeground(Color.YELLOW);
		delete.setForeground(Color.YELLOW);
		refresh.setForeground(Color.YELLOW);
	}

	// Add borders to the GUI
	public void addBorders() {

		scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	}

	// Call the main method
	public static void main(String[] args) {

		RMIClient client = new RMIClient();
		client.addColours();
		client.addBorders();
	}

	// Call the remote method to display all files from server folder
	public void displayFilesFromServer() {

		try {
			fileList = myfile.diplayFiles();

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	 }

	// Listener method for JList selected file
	public void valueChanged(ListSelectionEvent e) {

		try {
			filePickedFromJlist = list.getSelectedValue().toString();
			System.out.println(filePickedFromJlist);
		} catch (Exception e2) {
			// Ignored
		}
	}
}

