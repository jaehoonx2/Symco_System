package symco_System;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import symco_Server.Server;

import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;

public class Mainscreen_blue implements Mainscreen{

	private JFrame frame;
	private JTextArea TestArea;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void exec(ArrayList<Employee> employee) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainscreen_blue window = new Mainscreen_blue(employee);
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

	public Mainscreen_blue(ArrayList<Employee> employee){
		initialize(employee);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Employee> employee) {
		Moomin moomin = new ConcreteMoomin();
		frame = new JFrame();
		frame.setBounds(300, 300, 541, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton serverButton = new JButton("Chat Server");
		serverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Server.main(null);
			}
		});
		serverButton.setBounds(120, 496, 138, 31);
		frame.getContentPane().add(serverButton);
		
		JLabel lblMainscreenDemo = new JLabel("Simco System");
		lblMainscreenDemo.setBounds(215, 23, 143, 31);
		frame.getContentPane().add(lblMainscreenDemo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(14, 55, 554, 8);
		frame.getContentPane().add(separator);
		
		JButton btnTotalProjectList = new JButton("Total Project List");
		btnTotalProjectList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TotalList.main(null);
			}
		});
		btnTotalProjectList.setBounds(316, 206, 183, 106);
		frame.getContentPane().add(btnTotalProjectList);
		
		JTextArea txtMypage = new JTextArea();
		txtMypage.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		txtMypage.setBounds(5, 362, 253, 133);
		frame.getContentPane().add(txtMypage);
		txtMypage.append("Cur_ID : "+Login_System.getCurEmployee().getID() + "\nName : " + Login_System.getCurEmployee().getName()
				+ "\nDepartment : " + Login_System.getCurEmployee().getDepartment() + "\nRank : " + Login_System.getCurEmployee().getRank());
		
		
		JButton btnMyProjectList = new JButton("My Project List");
		btnMyProjectList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyList.main(null);
			}
		});
		btnMyProjectList.setBounds(312, 313, 187, 104);
		frame.getContentPane().add(btnMyProjectList);
		
		JButton btnChattingSystem = new JButton("Chatting System");
		btnChattingSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client.exec(null);
			}
		});
		btnChattingSystem.setBounds(312, 418, 186, 109);
		frame.getContentPane().add(btnChattingSystem);
		
		//set moomin avatar
		JLabel avatarLabel = new JLabel("");
		avatarLabel.setIcon(moomin.MyGetImage());
		avatarLabel.setBounds(40, 139, 195, 218);
		frame.getContentPane().add(avatarLabel);
		
		JRadioButton rdbtnBlackHat = new JRadioButton("Black Hat");
		buttonGroup.add(rdbtnBlackHat);
		rdbtnBlackHat.setBounds(14, 73, 139, 27);
		frame.getContentPane().add(rdbtnBlackHat);
		
		JRadioButton rdbtnSummerHat = new JRadioButton("Summer Hat");
		buttonGroup.add(rdbtnSummerHat);
		rdbtnSummerHat.setBounds(14, 104, 139, 27);
		frame.getContentPane().add(rdbtnSummerHat);
		
		JRadioButton rdbtnStick = new JRadioButton("Stick");
		rdbtnStick.setBounds(165, 71, 139, 27);
		frame.getContentPane().add(rdbtnStick);
		
		//아바타 꾸미기 / 데코레이터 패턴
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Moomin new_moomin = new ConcreteMoomin();
				
				if(rdbtnBlackHat.isSelected()){
					new_moomin = new BlackHat(new_moomin);
				}
				if(rdbtnSummerHat.isSelected()){
					new_moomin = new SummerHat(new_moomin);
				}
				if(rdbtnStick.isSelected()){
					new_moomin = new Stick(new_moomin);
				}
				
				avatarLabel.setIcon(new_moomin.MyGetImage());
			}
		});
		btnChange.setBounds(153, 100, 105, 27);
		frame.getContentPane().add(btnChange);	
		
		JButton Fortunebtn = new JButton("Fortune");
		Fortunebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowFortune.main(null);
			}
		});
		Fortunebtn.setBounds(332, 139, 166, 27);
		frame.getContentPane().add(Fortunebtn);
		
		//setting
		JButton btnSetting = new JButton("setting");
		btnSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				select_theme.main(employee);
				frame.dispose();
			}
		});
		btnSetting.setBounds(393, 25, 105, 27);
		frame.getContentPane().add(btnSetting);
		
		JButton btnDecisionMaker = new JButton("Decision Maker");
		btnDecisionMaker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowDecisionMaker.main(null);
			}
		});
		btnDecisionMaker.setBounds(332, 70, 166, 27);
		frame.getContentPane().add(btnDecisionMaker);
		
		JButton btnTodaysMenu = new JButton("Today's Menu");
		btnTodaysMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowFood.main(null);
			}
		});
		btnTodaysMenu.setBounds(332, 104, 166, 27);
		frame.getContentPane().add(btnTodaysMenu);
		
		JButton btnDressCode = new JButton("Dress Code");
		btnDressCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowDressCode.main(null);
			}
		});
		btnDressCode.setBounds(332, 178, 166, 27);
		frame.getContentPane().add(btnDressCode);
		
		JLabel lblbgType = new JLabel("");
		lblbgType.setBounds(0, 0, 523, 553);
		lblbgType.setIcon(new ImageIcon(this.getClass().getResource("/screenBlue.jpg")));
		frame.getContentPane().add(lblbgType);
	}
}
