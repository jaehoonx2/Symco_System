package symco_Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.JPanel;

import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Server implements Mediator{

	private JFrame frame;
	private JTextArea outputPane;
	
	ArrayList clientOutputStreams;		//������ ����� client���� output stream�� ������ arraylist
	ArrayList<String> onlineUsers;		//���� ������ �ִ� users���� ������ arraylist
	ServerSocket serverSock = null;		//server socket

	public class ClientHandler implements Runnable{
		Socket sock;	//�Ķ���ͷ� ���� clientSocket�� �����ϱ� ����
		PrintWriter client;	//�Ķ���ͷ� ���� user�� �����ϱ� ����
		BufferedReader reader;	//client�κ��� input stream�� ���� �����͸� �б� ����.
		
		public ClientHandler(Socket clientSocket, PrintWriter user){
			client = user;
			try{
				sock=clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);	//ȿ������ ���� BufferedReader�� InputStreamReader�� ���Ѵ�.
			}catch(Exception e){
				outputPane.append("Error Beginning StreamReader.\n");
			}
		}
		
		public void run(){	
			String message;
			String connect = "Connect", disconnect="Disconnect",chat = "Chat";
			String[] data;
			
			try{
				while((message = reader.readLine()) != null){	//client�κ��� ���� �޼����� ������ ���
					outputPane.append("Received: " + message + "\n");
					data = message.split(":");	//message��  ':'�� �����ؼ� data array�� ����
						
					if(data[2].equals(connect)){	//client�� connect���� ���
						sendMessage(data[0] + ":" + data[1] + ":" + chat);	//�ٸ� client�鿡�� connect�� �˸�
						userAdd(data[0]);	//�������� client�� �߰�
					}else if(data[2].equals(disconnect)){	//client�� disconnect���� ���
						sendMessage(data[0] + ":has disconnected." + ":" + disconnect);	//�ٸ� client�鿡�� disconnect �˸�
						userRemove(data[0]);	//�������� client���� ����
					}else if(data[2].equals(chat)){	//client�� ä�ø��� ������ ���
						sendMessage(message);	//�ٸ� client�鿡�� ����
					}
				}
			}catch(Exception e){
				//��ȣ�� �Ҿ��� ���, �ش� client�� input stream�� �д� Print writer�� ����Ʈ���� ���� 
				outputPane.append("Lost a connection.\n");
				clientOutputStreams.remove(client);
			}
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server window = new Server();
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
	public Server() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 536, 460);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//�ش� â�� �ݱ�
		frame.getContentPane().setLayout(null);
		frame.setTitle("Chatting System Server");
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�����带 �����ؼ� ���� ����
				Thread starter = new Thread(new ServerStart());	
				starter.start();
				
				outputPane.append("Server started. \n");
			}
		});
		btnStart.setBounds(0, 348, 253, 65);
		frame.getContentPane().add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage("Server:is stopping and all users will be disconnected. : Chat\n");
				outputPane.append("Server is stopping....\n");
				if(serverSock != null){
					try{
						serverSock.close();
					}catch(Exception ex){
						JOptionPane.showMessageDialog(null, "Fail to stop Chat Server","Chatting System Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnStop.setBounds(252, 348, 266, 65);
		frame.getContentPane().add(btnStop);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 12, 490, 324);
		frame.getContentPane().add(scrollPane_1);
		
		outputPane = new JTextArea();
		scrollPane_1.setViewportView(outputPane);
	}   
	
	public class ServerStart implements Runnable{
		public void run(){
			clientOutputStreams = new ArrayList();
			onlineUsers = new ArrayList();
			
			try{
				serverSock = new ServerSocket(5000); // ��Ʈ 5000���� ���������� ����
				while(true){
					//client�� ������ �����ϱ� ���� ��� ����. 
					Socket clientSock = serverSock.accept();	//�������Ͽ��� accept�� ���� ����, ���� client�� ����
					PrintWriter writer = new PrintWriter(clientSock.getOutputStream());	//������ outputstream�� ���� PrintWriter ����
					clientOutputStreams.add(writer);
					// ��� ����ϸ鼭 client�� server�� �������� client handler�� ����.
					Thread listner = new Thread(new ClientHandler(clientSock, writer));
					listner.start();
					outputPane.append("Got a connection. \n");
				}
			}catch(Exception e){
				outputPane.append("Error making a connection.\n");
			}
		}
	}

	public void userAdd(String data){
		String message;
		
		//�߰��� �̸��� �������� user list�� �߰�
		onlineUsers.add(data);	
		outputPane.append("Complete to add " + data +"\n");
		
		//�������� user���� �̸��� client�鿡�� ����
		String[] tempList = new String[onlineUsers.size()];
		onlineUsers.toArray(tempList);
		
		for(int i =0; i<tempList.length; i++){
			String username = tempList[i];
			message = username + ": :Connect";
			sendMessage(message);
		}
		sendMessage("Server: :Done");
		
	}
	
	public void userRemove(String data){
		String message;
		
		//������ �̸��� �������� user list���� ����
		onlineUsers.remove(data);
		outputPane.append("Complete to remove" + data + "\n");
		
		//�������� user���� �̸��� client�鿡�� ����
		String[] tempList = new String[onlineUsers.size()];
		onlineUsers.toArray(tempList);
		
		for(int i =0; i<tempList.length; i++){
			String username = tempList[i];
			message = username + ": :Connect";
			sendMessage(message);
		}
		sendMessage("Server: :Done");
	}

	public void sendMessage(String message){
		//clientOutputStreams(������ ����� client���� output stream�� ������ arraylist)�� ���������� ����
		Iterator iter = clientOutputStreams.iterator(); 
		
		while(iter.hasNext()){
			try{
				//������ ����� client�鿡 ���������� �޼����� ����
				PrintWriter writer = (PrintWriter) iter.next();
				//outputStream�� message�� write��
				writer.println(message);
				writer.flush(); //
				//����� ����â�� ���
				outputPane.append("Sending: " + message + "\n");
				//Ŀ���� �� ������ ����
				outputPane.setCaretPosition(outputPane.getDocument().getLength());
			}catch(Exception e){
				outputPane.append("Sending Message Error!\n");
			}
		}
	}
}
