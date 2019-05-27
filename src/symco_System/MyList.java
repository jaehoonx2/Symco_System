package symco_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class MyList extends JFrame {
	public static int val = 0;
	private JPanel contentPane;
	private JTextField deleteprojecttextField;
	private JTextField mvprojectNamelabel;

	public static String tGroupName = "";
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyList frame = new MyList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addprojectbtn = new JButton("\uD504\uB85C\uC81D\uD2B8 \uCD94\uAC00");
		addprojectbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Project.main(null);
			}
		});
		addprojectbtn.setBounds(429, 351, 140, 27);
		contentPane.add(addprojectbtn);
		

		deleteprojecttextField = new JTextField();
		deleteprojecttextField.setBounds(237, 402, 178, 24);
		contentPane.add(deleteprojecttextField);
		deleteprojecttextField.setColumns(10);
		
		
		JButton deleteprojectbtn = new JButton("\uD504\uB85C\uC81D\uD2B8 \uC0AD\uC81C");
		deleteprojectbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//프로젝트 삭제	
				if(FindGroupIndex(GroupList.GgroupList, deleteprojecttextField.getText()) == true){
					GroupList.GgroupList.remove(val);
					JOptionPane.showMessageDialog(null, "그룹이 성공적으로 삭제되었습니다.");
				}
				else{
					JOptionPane.showMessageDialog(null, "존재하지 않는 그룹입니다.");
				}
			}
		});
		deleteprojectbtn.setBounds(429, 401, 140, 27);
		contentPane.add(deleteprojectbtn);
		
		JButton button_1 = new JButton("\uB2EB\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(439, 148, 119, 27);
		contentPane.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 42, 401, 336);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("\uB0B4\uAC00 \uCC38\uC5EC\uD55C \uADF8\uB8F9 \uB9AC\uC2A4\uD2B8");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(14, 12, 555, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC0AD\uC81C\uD560 \uD504\uB85C\uC81D\uD2B8\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694: ");
		lblNewLabel_1.setBounds(14, 405, 231, 18);
		contentPane.add(lblNewLabel_1);
	

		mvprojectNamelabel = new JTextField();
		mvprojectNamelabel.setBounds(442, 254, 116, 24);
		contentPane.add(mvprojectNamelabel);
		mvprojectNamelabel.setColumns(10);
		
		
		JButton btnNewButton = new JButton("\uC774\uB3D9\uD558\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//이동
				if(FindGroupIndex(GroupList.GgroupList, deleteprojecttextField.getText()) == true){
					tGroupName = GroupList.GgroupList.get(val).getGroupName();
					ShowGroup.main(null);
				}
				else{
					JOptionPane.showMessageDialog(null, "존재하지 않는 그룹입니다.");
				}
				
				
			}
		});
		btnNewButton.setBounds(442, 290, 105, 27);
		contentPane.add(btnNewButton);
	
	}
	
	public boolean FindGroupIndex(ArrayList<GroupList> gl, String wgn){
		int i;
		boolean state = false;
		
		for(i=0; i<gl.size(); i++){
			if(gl.get(i).getGroupName().equals(wgn) == true){
				val = i;
				state = true;
			}
		}
		
		System.out.println(val);
	
		return state;
	}

}
