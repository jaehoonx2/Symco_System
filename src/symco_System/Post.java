package symco_System;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Post extends JFrame {

	private static Post post = new Post();	//singleton
	public static Post getInstance(){
		return post;
	}
	
	private JPanel contentPane;
	
	private Scanner s;
	private List<String[]> postList;
	
	private int seq;
	private String PostNo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Post window = Post.getInstance();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	private Post() {
		
		s = new Scanner(System.in);
		postList = new ArrayList<String[]>();
		
		this.seq = 1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("게시물 목록");
		btnNewButton.setBounds(96, 12, 107, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getList();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("게시물 등록");
		btnNewButton_1.setBounds(96, 49, 107, 27);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPost();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("게시물 수정");
		btnNewButton_2.setBounds(96, 88, 107, 27);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getValue_update();
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("게시물 삭제");
		btnNewButton_3.setBounds(96, 127, 107, 27);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getValue_delPost();
			}
		});
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("종료");
		btnNewButton_4.setBounds(120, 166, 61, 27);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnNewButton_4);
		
	}
	
	
	
	public void addPost() {
		
		// JFrame(위젯)
        JFrame frame = new JFrame(); // 액자
        frame.setBounds(100,100,700,500); // 크기 설정
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel(); // 도화지
        panel.setLayout(null);
        frame.setContentPane(panel); // 액자에 도화지를 끼우기
        
        JLabel lblNewLabel = new JLabel("title");
		lblNewLabel.setBounds(106, 52, 62, 18);
		panel.add(lblNewLabel);
        
        JTextField txtTitle = new JTextField(); //제목 기입이 가능한 필드
        txtTitle.setBounds(189, 49, 406, 24);
        
        panel.add(txtTitle);
        
        JLabel lblNewLabel_1 = new JLabel("writer");
		lblNewLabel_1.setBounds(106, 88, 62, 18);
		panel.add(lblNewLabel_1);
        
        JTextField txtWriter = new JTextField(); //작성자 기입이 가능한 필드
        txtWriter.setBounds(189, 85, 406, 24);
        panel.add(txtWriter);
        
        JTextArea txtContent = new JTextArea(); //내용 기입이 가능한 필드
        txtContent.setBounds(83, 121, 512, 320);
        txtContent.setEditable(true);
        panel.add(txtContent);
        
        frame.setVisible(true);

        JButton btnRegister = new JButton(); //버튼
        btnRegister.setText("등록");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	
            	String no = String.valueOf(seq);
               String title = txtTitle.getText();
               String writer = txtWriter.getText();
               String content = txtContent.getText();
               
               String[] post = new String[4];
       			post[0] = no;
       			post[1] = title;
       			post[2] = content;
       			post[3] = writer;

       			postList.add(post);

       			seq++;
       			
       			frame.dispose();
            }
         });
        
        btnRegister.setBounds(530, 10, 61, 27);
        panel.add(btnRegister);
	}
	
	public void update(String PostNo) {
	
	if(PostNo == null || PostNo == "")	// 잘못 입력하셨습니다.
		return;
	
	
	String[] post = getSearch(PostNo);
	
	if(post == null)	// 게시글이 없습니다.
		return;
	 
	int PostNum = Integer.parseInt(PostNo);
	
	// JFrame(위젯)
    JFrame frame = new JFrame(); // 액자
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setBounds(100,100,700,500); // 크기 설정

    JPanel panel = new JPanel(); // 도화지
    panel.setLayout(null);
    frame.setContentPane(panel); // 액자에 도화지를 끼우기
   
    JLabel lblNewLabel = new JLabel("title");
	lblNewLabel.setBounds(106, 52, 62, 18);
	panel.add(lblNewLabel);
    
    JTextField txtTitle = new JTextField(); //제목 기입이 가능한 필드
    txtTitle.setBounds(189, 49, 406, 24);
    panel.add(txtTitle);
    txtTitle.setText(postList.get(PostNum)[1]);
    
    JLabel lblNewLabel_1 = new JLabel("writer");
	lblNewLabel_1.setBounds(106, 88, 62, 18);
	panel.add(lblNewLabel_1);
    
    JTextField txtWriter = new JTextField(); //작성자 기입이 가능한 필드
    txtWriter.setBounds(189, 85, 406, 24);
    panel.add(txtWriter);
    txtWriter.setText(postList.get(PostNum)[3]);
    
    JTextArea txtContent = new JTextArea(); //내용 기입이 가능한 필드
    txtContent.setBounds(83, 121, 512, 320);
    txtContent.setEditable(true);
    panel.add(txtContent);
    txtContent.setText(postList.get(PostNum)[2]);
    
    frame.setVisible(true);

    JButton btnUpdate = new JButton(); //버튼
    btnUpdate.setText("수정");
    btnUpdate.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
        	
           String title = txtTitle.getText();
           String content = txtContent.getText();
           
   			post[1] = title;
   			post[2] = content;

   			postList.add(PostNum, post);
   			frame.dispose();
        }
     });
    
    btnUpdate.setBounds(530, 10, 61, 27);
    panel.add(btnUpdate);
	}
	
	public void delPost(String PostNo) {
		if (PostNo == null || PostNo == "")	return;
		
		String[] post = this.getSearch(PostNo);
		
		if (post == null)	return;
		
		this.postList.remove(post);
	}
	
	public void getValue_update() {
		JFrame frame = new JFrame(); // 액자
		
		JPanel contentPane;
		JTextField textField;
		JButton btnNewButton_Confirm;
		JButton btnNewButton_Cancel;
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 300, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("\uAC8C\uC2DC\uBB3C \uBC88\uD638\uB97C \uC785\uB825\uD558\uC2DC\uC624");
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		contentPane.add(textField);
		
		btnNewButton_Confirm = new JButton("확인");
		btnNewButton_Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PostNo = textField.getText();
				update(PostNo);
			}
		});
		contentPane.add(btnNewButton_Confirm);
		
		btnNewButton_Cancel = new JButton("취소");
		btnNewButton_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		contentPane.add(btnNewButton_Cancel);
	}
	
	public void getValue_delPost() {
		JFrame frame = new JFrame(); // 액자
		
		JPanel contentPane;
		JTextField textField;
		JButton btnNewButton_Confirm;
		JButton btnNewButton_Cancel;
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 300, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("\uAC8C\uC2DC\uBB3C \uBC88\uD638\uB97C \uC785\uB825\uD558\uC2DC\uC624");
		contentPane.add(label);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton_Confirm = new JButton("확인");
		btnNewButton_Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PostNo = textField.getText();
				delPost(PostNo);
				frame.dispose();
			}
		});
		contentPane.add(btnNewButton_Confirm);
		
		btnNewButton_Cancel = new JButton("취소");
		btnNewButton_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		contentPane.add(btnNewButton_Cancel);
	}
	
	private String[] getSearch(String no) {
		for (String[] post : this.postList) {
			if (post != null && post[0].equals(no)) {
				return post;
			}
		}

		return null;
	}

	public void getList() {
		JPanel contentPane;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(14, 12, 554, 550);
		for (String[] post : this.postList) {
			if (post != null) {
				textArea.append("No: " + post[0] + "   " + " Writer: " + post[3] + "\t" +
								" Title: " + post[1] + "\t" + " Content: " + post[2] + "\n");
		contentPane.add(textArea);
			}
		}
		
		JButton button = new JButton("\uD655\uC778");
		button.setBounds(240, 574, 105, 27);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		contentPane.add(button);
	}
	
}