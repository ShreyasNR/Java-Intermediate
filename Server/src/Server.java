import java.awt.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class Server extends JFrame{
	
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	
	//constructor
	
	public Server() {
		super("Shreyas Messenger");
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					sendMessage(event.getActionCommand());
					userText.setText("");
				}
			}
		);
		add(userText, BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow));
		setSize(300,150);
		setVisible(true);
	}
	// set up and run the server
	public void startRunning() {
		try {
			server = new ServerSocket(6789, 50);
			while(true){
				try {
					waitForConnection();
					setupStreams();
					whileChatting();
				}catch(EOFException eofException) {
					showMessage("\n Server ended the connection!");
				}finally {
					closeCrap();
				}
			}
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}
		
	}
	
	// waiting for connection, display status
	private void waitForConnection() throws IOException{
		showMessage(" Waiting for someone to connect...\n");
		connection = server.accept();
		showMessage(" Now Connected to " + connection.getInetAddress().getHostName());
	}
	
	//creating stream to send and receive data
	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Stream has been setup. \n");
	}
	
	//during a conversation
	private void whileChatting() throws IOException{
		String message = " You are connected. ";
		showMessage(message);
		ableToType(true);
		do {
			try {
				message = (String) input.readObject();
				showMessage("\n" + message);
			}catch(ClassNotFoundException classNotFoundException) {
				showMessage("\n I dont know what that message was.");
			}
		}while (!message.equals("CLIENT - END"));
	}
	
	//closing the connections
	private void closeCrap() {
		showMessage("\n Closing the connections..... \n");
		ableToType(false);
		try {
			output.close();
			input.close();
			connection.close();
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	//send message to client
	private void sendMessage(String message) {
		try {
			output.writeObject("SERVER - " + message);
			output.flush();
			showMessage("\nSERVER - " + message);
		}catch(IOException ioException) {
			chatWindow.append("\n ERROR: CANNOT SEND THE MESSAGE");
		}
	}
	
	//updates chat window
	private void showMessage(final String text) {
		SwingUtilities.invokeLater(
			new Runnable() {
				public void run() {
					chatWindow.append(text);
				}
			}
		);
	}
	
	//set user to type the message
	private void ableToType(final boolean tof) {
		SwingUtilities.invokeLater(
			new Runnable() {
				public void run() {
					userText.setEditable(tof);
				}
			}
		);
	}
}
