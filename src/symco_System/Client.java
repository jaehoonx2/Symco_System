package symco_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import java.net.*;
import java.util.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client implements Colleague{

	private JFrame frame;
	private JTextArea inputTextArea;
	private JTextArea chatTextArea;
	private JTextArea usersList;
	private JTextPane curEmployeePane;
	
	String serverIP="172.17.198.186";	//����� IP Ȯ���ϰ� �Ź� �ٲ���� ��.
	int Port = 5000;	//��Ʈ ��ȣ
	Socket sock;
	String username;
	BufferedReader reader;	//�����κ��� ����
	PrintWriter writer;		//������ ����
	ArrayList<String> onlineUsers = new ArrayList<String>();
	Boolean isConnected = false;
	
	public class IncomingReader implements Runnable{
		public void run(){
			String message;
			String done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";
			String[] data;
			
			try{
				while((message = reader.readLine()) != null){
					data = message.split(":");
					
					if(data[2].equals(chat)){
						//�����κ��� chat�� ���� ���, ���� user�� ������ ����ϰ� Ŀ���� ���������� ����.
						chatTextArea.append(data[0] + ": " + data[1] + "\n");
						chatTextArea.setCaretPosition(chatTextArea.getDocument().getLength());
					}else if(data[2].equals(connect)){
						//�ٸ� user�� ä�ù濡 �߰��� ���, onlineUsers�� �߰�
						onlineUsers.add(data[0]);
					}else if(data[2].equals(disconnect)){
						//�ٸ� user�� ä�ù濡�� ���� ���, 
						//�������� �ش� user�� onlineUsers���� �����ϰ� done�� �������Ƿ� Client���� ���� ������ �ʿ�� ����.
						chatTextArea.append(data[0] + " has disconnected.\n");
					}else if(data[2].equals(done)){
						//ä�ù濡 user�� �߰� Ȥ�� ������ ��� �������� done�� �����κ��� ����
						usersList.setText("");	//TextArea �ʱ�ȭ
						writeUsers();	// online user�� �ٽ� TextArea�� ����
						onlineUsers.clear();	
					}
				}
			}catch(Exception ex){
				chatTextArea.append("No signal from Server.\n");
			}
		}
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void exec(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 684, 529);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//�ش� â�� �ݱ�
		frame.getContentPane().setLayout(null);
		
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		sendButton.setBounds(371, 401, 105, 69);
		frame.getContentPane().add(sendButton);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(490, 45, 162, 425);
		frame.getContentPane().add(scrollPane_2);
		
		usersList = new JTextArea();
		scrollPane_2.setViewportView(usersList);
		
		JLabel lblOnlineUsers = new JLabel("ONLINE USERS");
		lblOnlineUsers.setBounds(516, 12, 115, 35);
		frame.getContentPane().add(lblOnlineUsers);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 45, 462, 344);
		frame.getContentPane().add(scrollPane_1);
		
		chatTextArea = new JTextArea();
		scrollPane_1.setViewportView(chatTextArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 401, 357, 69);
		frame.getContentPane().add(scrollPane);
		
		inputTextArea = new JTextArea();
		scrollPane.setViewportView(inputTextArea);
		
		JButton connectButton = new JButton("Connect");
		connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connectToMediator();
			}
		});
		connectButton.setBounds(252, 12, 105, 27);
		frame.getContentPane().add(connectButton);
		
		JButton disconnectButton = new JButton("Disconnect");
		disconnectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//������ disconnect ��ȣ�� ����
					writer.println(username + ": :Disconnect");
					writer.flush();
					
					//ä��â�� disconnect ��� �� sock ����
					chatTextArea.append("Disconnected.\n");
					sock.close();
					
					//online users ��� �� ������� �ʱ�ȭ
					usersList.setText("");
					isConnected=false;
				}catch(Exception ex){
					chatTextArea.append("Fail to disconnect. \n");
				}
			}
		});
		disconnectButton.setBounds(371, 12, 115, 27);
		frame.getContentPane().add(disconnectButton);
		
		JLabel lblMyName = new JLabel("My name : ");
		lblMyName.setBounds(14, 20, 75, 18);
		frame.getContentPane().add(lblMyName);
		
		curEmployeePane = new JTextPane();
		curEmployeePane.setBounds(94, 12, 138, 27);
		frame.getContentPane().add(curEmployeePane);
	}
	
	public void connectToMediator(){
		//Server�� ����Ǿ� ���� ���� ���
		if(isConnected == false){
			//���� �α��εǾ� �ִ� ����� ID�� ����.
			username = Login_System.getCurEmployee().getID();	
			curEmployeePane.setText(username);
			curEmployeePane.setEditable(false);
		
			try{
				//�����κ��� ������ �޾� Client�� Server�� ����.
				sock = new Socket(serverIP, Port);
				//������ ������, ������ �������� ClientHandler��  �ش� message�� �ٸ� colleague�鿡 ����
				InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(streamreader);
				writer = new PrintWriter(sock.getOutputStream()); 
				writer.println(username + ":has connected.:Connect");	
				writer.flush();
				isConnected = true;
			}catch(Exception ex){
				chatTextArea.append("Fail to Connect! Try again. \n");
			}
			receiveMessage();	//������ ����
		}else if(isConnected == true){
			chatTextArea.append("You are already connected.\n");
		}
	}
	
	public void receiveMessage(){
		//������ ������ ����
		Thread IncomingReader = new Thread(new IncomingReader());
		IncomingReader.start();
	}
	
	public void sendMessage(){
		//�ƹ� �Է��� ���� ���
		if(inputTextArea.getText().equals("")){
			//null implementation
		}else{
			try{
				//������ �Է��� string�� ����
				writer.println(username + ":" + inputTextArea.getText() + ":" + "Chat");
				writer.flush();
				
				//ä�� �Է�â �ʱ�ȭ
				inputTextArea.setText("");
			}catch(Exception ex){
				chatTextArea.append("Fail to send a message to Server.\n");
			}
		}
		//ä�� �Է�â �ʱ�ȭ
		inputTextArea.setText("");
	}
	
	public void writeUsers(){
		String[] tempList = new String[(onlineUsers.size())];
		onlineUsers.toArray(tempList);
		for(int i=0; i<onlineUsers.size(); i++){
			String username = tempList[i];
			usersList.append(username + "\n");
		}
	}
}
