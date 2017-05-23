import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ChatGUI extends JFrame {

	//Global variables and JComponents
	//private static ChatController chatController = new ChatController();
	public static final String COPY_SYMBOL = "\u00a9";
	private String soundPath = "file:./beep1.wav";
	private static AudioClip beep;
	private static JMenuBar menuBar;
	private JMenu fileMenu;;
	private JMenu editMenu;
	private JMenu aboutMenu;
	private JMenu extraMenu;
	private JMenuItem clear;
	private JMenuItem exit;
	private JMenuItem open;
	private JMenuItem save;
	private JMenuItem copy;
	private JMenuItem paste;
	private JMenu changeSkin;
	private JMenuItem skin1;
	private JMenuItem skin2;
	private JMenuItem skin3;
	private JMenu changeSound;
	private JMenuItem muteSound;
	private JMenuItem sound1;
	private JMenuItem sound2;
	private JMenuItem sound3;
	private JMenuItem contactUs;
	private JMenuItem ourFriends;
	private JLabel welcomeLabel;
	private JLabel usernameLabel;
	private JLabel invisibleLabel;
	private JLabel footerLabel;
	private JPanel chattingPanel;
	private JTextArea messageContainer;
	private JTextField messageToSendField;
	private JScrollPane chatTextAreaScrollPane;
	private JButton sendMessageButton;
	private JButton sendEmoticonButton;
	private Font welcomeFont;
	private Font buttonFont;
	private Font nameFont;
	private Font footerFont;
	private ImageIcon icon;
	private ImageIcon likeIcon;

	//GUI Constructor
	public ChatGUI() {

		createMenuBar();
		disableMenuItems();
		buildPanel();
		addFonts();
		applySkin1();

		//Set the features of the terminal frame
		getContentPane().add(BorderLayout.CENTER, chattingPanel);
		setTitle("Chat");
		setLocation(150, 10);
		setSize(360, 400);
		setResizable(false);
		setVisible(true);

//****************************************************************************************
//****************************** ACTION LISTENERS ****************************************
//****************************************************************************************

		//Add Action Listener to the Exit Menu Item
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Exit the System
				if (e.getSource() == exit) {
					System.exit(0);
				}
			}
		});

		//Add Action Listener to the Clear Menu Item
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Clear the Chat Text Area
				if (e.getSource() == clear) {
					messageContainer.setText("");
				}
			}
		});

		//Add Action Listener to the Contact Us Menu Item
		contactUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Display the contact information
				if (e.getSource() == contactUs) {

					try {
						//Load the Image Icon for the Dialog Pane
						//icon = new ImageIcon(getClass().getResource("/like.png"));
					}
					catch (NullPointerException exc) {
						System.out.println("Cannot find the Image Icon!");
					}

					//Create the Option Diaog Pane
					JOptionPane.showMessageDialog(null,
						"Contact us at:\n" +
						"****************\n" +
						"tel:                    085000000" +
						"email:              chat@gmail.com\n" +
						"facebook:       Chat Ltd\n",
						"Chat Contact",
						JOptionPane.INFORMATION_MESSAGE, icon);
				}
			}
		});

		//Add Action Listener to the ourFriends Menu Item
		ourFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Connect to the Alien Chat webpage
				if (e.getSource() == ourFriends) {
					connectToUrl();
				}
			}
		});


		//Add Action Listener to the Skin 1 Menu Item
		skin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Change the skin to the Skin 1
				if (e.getSource() == skin1) {
					applySkin1();
				}
			}
		});


		//Add Action Listener to the Skin 2 Menu Item
		skin2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Change the skin to the Skin 2
				if (e.getSource() == skin2) {
					applySkin2();
				}
			}
		});
		
		//Add Action Listener to the Skin 3 Menu Items
		skin3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Change the skin to the Ghost Skin
				if (e.getSource() == skin3) {
					applySkin3();
				}
			}
		});

		//Add Action listener to disable the button sounds
		muteSound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Mute all the sounds
				if (e.getSource() == muteSound) {
					soundPath = null;
				}
			}
		});

		//Add Action Listener to the sound1 Menu Item
		sound1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Choose sound1
				if (e.getSource() == sound1) {
					soundPath = "file:./beep1.wav";
				}
			}
		});

		//Add Action Listener to the sound2 Menu Item
		sound2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Choose sound2
				if (e.getSource() == sound2) {
					soundPath = "file:./beep2.wav";
				}
			}
		});

		//Add Action Listener to the sound3 Menu Item
		sound3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Choose sound3
				if (e.getSource() == sound3) {
					soundPath = "file:./beep3.wav";
				}
			}
		});

		//Add Action Listener to the button to play sound effect (when the button has been clicked)
		sendMessageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					beep = Applet.newAudioClip(new URL(soundPath));
					beep.play();
				}
				catch (MalformedURLException exception) {

					if (soundPath == null) {
						//Nothing happens here (no need for any actions to perform)
					}
					else {
						System.out.println("Wrong URL to locate a wave file!");
					}
				}
			}
		});

		//Document Listener used to check if the message Text Field is empty or not
		//in order to enable or disable Send Message Button (to avoid sending blank messages)
		messageToSendField.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				enableSendMessageButton();
			}
			public void removeUpdate(DocumentEvent e) {
				enableSendMessageButton();
			}
			public void changedUpdate(DocumentEvent e) {
				enableSendMessageButton();
			}

			//Enable Button method
			public void enableSendMessageButton() {

				//Enable Send Message Button to send messages
				if (!messageToSendField.getText().trim().equals("")) {
					sendMessageButton.setEnabled(true);
				}
				//Disable Send Message Button
				else {
					sendMessageButton.setEnabled(false);
				}
			}
		});
	}

//****************************************************************************************
//******************************** GETTER METHODS  ***************************************
//****************************************************************************************

	public JButton getSendMessageButton() {
		return sendMessageButton;
	}
	public JTextField getMessageToSendField() {
		return messageToSendField;
	}
	public JLabel getUsernameLabel() {
		return usernameLabel;
	}
	public JTextArea getMessageContainer() {
		return messageContainer;
	}

//****************************************************************************************
//********************************* SETTER METHODS ***************************************
//****************************************************************************************

	public void setUsernameLabel(JLabel usernameLabel) {
		this.usernameLabel = usernameLabel;
	}
	public void setMessageContainer(JTextArea messageContainer) {
		this.messageContainer = messageContainer;
	}

//****************************************************************************************
//********************************* EDITING METHODS **************************************
//****************************************************************************************

	//Default GUI terminal colours
	public void applySkin1() {

		chattingPanel.setBackground(Color.GREEN);
		messageContainer.setBackground(Color.CYAN);
		messageContainer.setForeground(Color.BLUE);
		sendMessageButton.setBackground(Color.RED);
		sendMessageButton.setForeground(Color.WHITE);
		sendEmoticonButton.setBackground(Color.GREEN);
		sendEmoticonButton.setForeground(Color.WHITE);
		welcomeLabel.setForeground(Color.RED);
		usernameLabel.setForeground(Color.BLUE);
		footerLabel.setForeground(Color.RED);

		addBorders();
		//Add invisible Border around the Like Emoticon
		sendEmoticonButton.setBorder(new EmptyBorder(2, 2, 2, 2));
	}

	//Apply dark colours to the GUI terminal
	public void applySkin2() {

		chattingPanel.setBackground(Color.BLACK);
		sendMessageButton.setBackground(Color.YELLOW);
		sendMessageButton.setForeground(Color.RED);
		sendEmoticonButton.setBackground(Color.BLACK);
		sendEmoticonButton.setForeground(Color.RED);
		welcomeLabel.setForeground(Color.YELLOW);
		usernameLabel.setForeground(Color.WHITE);
		footerLabel.setForeground(Color.YELLOW);

		//Change the Panel Borders
		chattingPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
		messageContainer.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
		messageToSendField.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
	}

	//Apply light colours to the GUI terminal
	public void applySkin3() {

		chattingPanel.setBackground(Color.WHITE);
		sendMessageButton.setBackground(Color.YELLOW);
		sendMessageButton.setForeground(Color.GRAY);
		sendEmoticonButton.setBackground(Color.WHITE);
		sendEmoticonButton.setForeground(Color.GRAY);
		welcomeLabel.setForeground(Color.GRAY);
		usernameLabel.setForeground(Color.GRAY);
		footerLabel.setForeground(Color.GRAY);

		//Change the Panel Borders
		chattingPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
		messageContainer.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		messageToSendField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	}

	//Add borders to some J Components
	public void addBorders() {

		chattingPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		messageContainer.setBorder(BorderFactory.createLineBorder(Color.RED));
		messageToSendField.setBorder(BorderFactory.createLineBorder(Color.RED));
	}

	//Selection of different Fonts used for the GUI
	public void addFonts() {

        welcomeFont = new Font("Monospaced", Font.PLAIN ,20);
        buttonFont = new Font("Monospaced", Font.PLAIN, 12);
        nameFont = new Font("Monospaced", Font.BOLD, 14);
        footerFont = new Font("Monospaced", Font.PLAIN, 11);
        welcomeLabel.setFont(welcomeFont);
        usernameLabel.setFont(nameFont);
        footerLabel.setFont(footerFont);
        sendMessageButton.setFont(buttonFont);
        sendEmoticonButton.setFont(buttonFont);
	}

//****************************************************************************************
//****************************** SET UP MENU BAR *****************************************
//****************************************************************************************

	public void createMenuBar() {

		//Create the Menu Bar
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		//Create the Menu
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		aboutMenu = new JMenu("About");
		extraMenu = new JMenu("Extras");

		//Create the Menu Items
		open = new JMenuItem("Open");
		save = new JMenuItem("Save");
		clear = new JMenuItem("Clear");
		exit = new JMenuItem("Exit");
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");

		changeSkin = new JMenu("Skins");
		skin1 = new JMenuItem("Skin 1");
		skin2 = new JMenuItem("Skin 2");
		skin3 = new JMenuItem("Skin 3");

		changeSound = new JMenu("Sounds");
		muteSound = new JMenuItem("Mute");
		sound1 = new JMenuItem("Beep 1");
		sound2 = new JMenuItem("Beep 2");
		sound3 = new JMenuItem("Beep 3");

		contactUs = new JMenuItem("Contact Us");
		ourFriends = new JMenuItem("Top Chats");

		//Add Menu Items to the File Menu
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.addSeparator();
		fileMenu.add(clear);
		fileMenu.addSeparator();
		fileMenu.add(exit);

		//Add Menu Items to the Edit Menu
		editMenu.add(copy);
		editMenu.add(paste);
		editMenu.addSeparator();
		editMenu.add(changeSkin);
		editMenu.add(changeSound);

		//Add Submenu Items to the Skins Menu Item
		changeSkin.add(skin1);
		changeSkin.add(skin2);
		changeSkin.add(skin3);

		//Add Submenu Items to the Sound Menu Item
		changeSound.add(muteSound);
		changeSound.add(sound1);
		changeSound.add(sound2);
		changeSound.add(sound3);

		//Add Menu Items to the About Menu
		aboutMenu.add(contactUs);

		//Add Menu Items to the Help Menu
		extraMenu.add(ourFriends);

		//Add Components to the Menu Bar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(aboutMenu);
		menuBar.add(extraMenu);

		//Set Accelerator keys for the Menu Items
		addAcceleratorKeys();
	}

	//Add key shortcuts to speed up the operation of the application
	public void addAcceleratorKeys() {

		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		clear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		skin1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		skin2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		skin3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
	}

	//Some J Menu Items are not accessible yet (will be extended)
	public void disableMenuItems() {

		open.setEnabled(false);
		save.setEnabled(false);
		copy.setEnabled(false);
		paste.setEnabled(false);
	}

//****************************************************************************************
//********************************* BUILD GUI PANEL **************************************
//****************************************************************************************

	public void buildPanel() {

		//Create the Text Area and disable editing
		messageContainer = new JTextArea(10, 30);
		messageContainer.setEditable(false);

		//Wrap the text in the Text Area
		messageContainer.setLineWrap(true);

		//Add the Text Area to the Scroll Pane
		chatTextAreaScrollPane = new JScrollPane(messageContainer);

		//Create the buttons and add Action Listeners to the buttons
		sendMessageButton = new JButton();
		sendMessageButton.setEnabled(false);
		sendMessageButton.setText("SEND MESSAGE");
		sendEmoticonButton = new JButton();

		//Load the like Icon add it to the button
		//likeIcon = new ImageIcon(getClass().getResource("/like.png"));
		//sendEmoticonButton.setIcon(likeIcon);

		//Set the size for buttons
		sendMessageButton.setPreferredSize(new Dimension(121, 22));
		sendEmoticonButton.setPreferredSize(new Dimension(30, 30));

		//Create the Text Field
		messageToSendField = new JTextField(22);

		//Set up the labels
		invisibleLabel = new JLabel();
		invisibleLabel.setPreferredSize(new Dimension(200, 20));
		welcomeLabel = new JLabel();
		welcomeLabel.setText("Welcome to the Chat");
		usernameLabel = new JLabel();
		usernameLabel.setPreferredSize(new Dimension(320, 20));
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		footerLabel = new JLabel();
		footerLabel.setText(" Chat ltd " + COPY_SYMBOL + " Copyright 2016");
		footerLabel.setPreferredSize(new Dimension(200, 20));
		footerLabel.setHorizontalAlignment(SwingConstants.CENTER);

		//Create the chatting panel and add JComponents to it
		chattingPanel = new JPanel();
		chattingPanel.add(welcomeLabel);
		chattingPanel.add(usernameLabel);
		chattingPanel.add(chatTextAreaScrollPane);
		chattingPanel.add(invisibleLabel);
		chattingPanel.add(messageToSendField);
		chattingPanel.add(sendMessageButton);
		chattingPanel.add(sendEmoticonButton);
		chattingPanel.add(invisibleLabel);
		chattingPanel.add(footerLabel);
	}

//****************************************************************************************
//****************************** CONNECT TO INTERNET *************************************
//****************************************************************************************

	//This method creates the URL link to connect to the website (other top chat apps)
	public static void connectToUrl() {

		try {
			//Set the URL
			String url = "http://www.capterra.com/live-chat-software/";

			//Open the webpage
			Desktop.getDesktop().browse(java.net.URI.create(url));
		}
		//Webpage URL failed to load
		catch (MalformedURLException e) {
			System.out.println("URL cannot be located!");
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
