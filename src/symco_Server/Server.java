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
	
	ArrayList clientOutputStreams;		//서버와 연결된 client들의 output stream을 저장할 arraylist
	ArrayList<String> onlineUsers;		//현재 접속해 있는 users들을 저장할 arraylist
	ServerSocket serverSock = null;		//server socket

	public class ClientHandler implements Runnable{
		Socket sock;	//파라미터로 들어온 clientSocket을 저장하기 위함
		PrintWriter client;	//파라미터로 들어온 user을 저장하기 위함
		BufferedReader reader;	//client로부터 input stream에 들어온 데이터를 읽기 위함.
		
		public ClientHandler(Socket clientSocket, PrintWriter user){
			client = user;
			try{
				sock=clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);	//효율성을 위해 BufferedReader로 InputStreamReader를 감싼다.
			}catch(Exception e){
				outputPane.append("Error Beginning StreamReader.\n");
			}
		}
		
		public void run(){	
			String message;
			String connect = "Connect", disconnect="Disconnect",chat = "Chat";
			String[] data;
			
			try{
				while((message = reader.readLine()) != null){	//client로부터 들어온 메세지가 존재할 경우
					outputPane.append("Received: " + message + "\n");
					data = message.split(":");	//message를  ':'로 구분해서 data array에 저장
						
					if(data[2].equals(connect)){	//client가 connect했을 경우
						sendMessage(data[0] + ":" + data[1] + ":" + chat);	//다른 client들에게 connect를 알림
						userAdd(data[0]);	//접속중인 client에 추가
					}else if(data[2].equals(disconnect)){	//client가 disconnect했을 경우
						sendMessage(data[0] + ":has disconnected." + ":" + disconnect);	//다른 client들에게 disconnect 알림
						userRemove(data[0]);	//접속중인 client에서 제거
					}else if(data[2].equals(chat)){	//client가 채팅말을 보냈을 경우
						sendMessage(message);	//다른 client들에게 전달
					}
				}
			}catch(Exception e){
				//신호를 잃었을 경우, 해당 client의 input stream을 읽던 Print writer를 리스트에서 제거 
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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//해당 창만 닫기
		frame.getContentPane().setLayout(null);
		frame.setTitle("Chatting System Server");
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//스레드를 생성해서 서버 실행
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
				serverSock = new ServerSocket(5000); // 포트 5000번에 서버소켓을 생성
				while(true){
					//client와 서버를 연결하기 위한 배경 세팅. 
					Socket clientSock = serverSock.accept();	//서버소켓에서 accept로 받은 소켓, 이후 client와 연동
					PrintWriter writer = new PrintWriter(clientSock.getOutputStream());	//소켓의 outputstream을 읽을 PrintWriter 생성
					clientOutputStreams.add(writer);
					// 계속 대기하면서 client와 server를 연결해줄 client handler를 생성.
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
		
		//추가할 이름을 접속중인 user list에 추가
		onlineUsers.add(data);	
		outputPane.append("Complete to add " + data +"\n");
		
		//접속중인 user들의 이름을 client들에게 전달
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
		
		//제거할 이름을 접속중인 user list에서 제거
		onlineUsers.remove(data);
		outputPane.append("Complete to remove" + data + "\n");
		
		//접속중인 user들의 이름을 client들에게 전달
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
		//clientOutputStreams(서버와 연결된 client들의 output stream을 저장할 arraylist)에 순차적으로 접근
		Iterator iter = clientOutputStreams.iterator(); 
		
		while(iter.hasNext()){
			try{
				//서버와 연결된 client들에 순차적으로 메세지를 보냄
				PrintWriter writer = (PrintWriter) iter.next();
				//outputStream에 message를 write함
				writer.println(message);
				writer.flush(); //
				//결과를 서버창에 출력
				outputPane.append("Sending: " + message + "\n");
				//커서를 맨 끝으로 고정
				outputPane.setCaretPosition(outputPane.getDocument().getLength());
			}catch(Exception e){
				outputPane.append("Sending Message Error!\n");
			}
		}
	}
}
