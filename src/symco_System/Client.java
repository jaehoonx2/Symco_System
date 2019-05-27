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
	
	String serverIP="172.17.198.186";	//연결된 IP 확인하고 매번 바꿔줘야 함.
	int Port = 5000;	//포트 번호
	Socket sock;
	String username;
	BufferedReader reader;	//서버로부터 받음
	PrintWriter writer;		//서버에 보냄
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
						//서버로부터 chat이 왔을 경우, 보낸 user와 내용을 출력하고 커서를 마지막으로 세팅.
						chatTextArea.append(data[0] + ": " + data[1] + "\n");
						chatTextArea.setCaretPosition(chatTextArea.getDocument().getLength());
					}else if(data[2].equals(connect)){
						//다른 user가 채팅방에 추가된 경우, onlineUsers에 추가
						onlineUsers.add(data[0]);
					}else if(data[2].equals(disconnect)){
						//다른 user가 채팅방에서 나간 경우, 
						//서버에서 해당 user를 onlineUsers에서 삭제하고 done을 보냈으므로 Client에서 따로 제거할 필요는 없다.
						chatTextArea.append(data[0] + " has disconnected.\n");
					}else if(data[2].equals(done)){
						//채팅방에 user를 추가 혹은 제거한 경우 마지막에 done을 서버로부터 받음
						usersList.setText("");	//TextArea 초기화
						writeUsers();	// online user를 다시 TextArea에 적음
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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//해당 창만 닫기
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
					//서버에 disconnect 신호를 보냄
					writer.println(username + ": :Disconnect");
					writer.flush();
					
					//채팅창에 disconnect 출력 후 sock 해제
					chatTextArea.append("Disconnected.\n");
					sock.close();
					
					//online users 목록 및 연결상태 초기화
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
		//Server에 연결되어 있지 않은 경우
		if(isConnected == false){
			//현재 로그인되어 있는 사람의 ID를 설정.
			username = Login_System.getCurEmployee().getID();	
			curEmployeePane.setText(username);
			curEmployeePane.setEditable(false);
		
			try{
				//서버로부터 소켓을 받아 Client와 Server를 연결.
				sock = new Socket(serverIP, Port);
				//서버로 보내면, 서버의 리스너인 ClientHandler가  해당 message를 다른 colleague들에 전달
				InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(streamreader);
				writer = new PrintWriter(sock.getOutputStream()); 
				writer.println(username + ":has connected.:Connect");	
				writer.flush();
				isConnected = true;
			}catch(Exception ex){
				chatTextArea.append("Fail to Connect! Try again. \n");
			}
			receiveMessage();	//리스너 역할
		}else if(isConnected == true){
			chatTextArea.append("You are already connected.\n");
		}
	}
	
	public void receiveMessage(){
		//리스너 스레드 생성
		Thread IncomingReader = new Thread(new IncomingReader());
		IncomingReader.start();
	}
	
	public void sendMessage(){
		//아무 입력이 없을 경우
		if(inputTextArea.getText().equals("")){
			//null implementation
		}else{
			try{
				//서버에 입력한 string을 보냄
				writer.println(username + ":" + inputTextArea.getText() + ":" + "Chat");
				writer.flush();
				
				//채팅 입력창 초기화
				inputTextArea.setText("");
			}catch(Exception ex){
				chatTextArea.append("Fail to send a message to Server.\n");
			}
		}
		//채팅 입력창 초기화
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
