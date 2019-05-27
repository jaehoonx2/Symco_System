package symco_System;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.image.*;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class select_theme extends JFrame{

	private JPanel contentPane;
	private ButtonGroup buttongroup = new ButtonGroup();
	Factory screenfactory;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(ArrayList<Employee> employee) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					select_theme frame = new select_theme(employee);
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
	public select_theme(ArrayList<Employee> employee) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Image img = new ImageIcon(this.getClass().getResource("/blue.jpg")).getImage();
		contentPane.setLayout(null);
		
		//summer.jpg image
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(242, 29, 143, 138);
		
		Image img1 = new ImageIcon(this.getClass().getResource("/summer.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		contentPane.add(lblNewLabel_1);
		
		//blue.jpg image
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(39, 29, 143, 138);
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		
		//radiobutton
		JRadioButton rdbtnBlue = new JRadioButton("Blue");
		rdbtnBlue.setBounds(78, 178, 75, 29);
		contentPane.add(rdbtnBlue);
		buttongroup.add(rdbtnBlue); //하나만 선택
		
		JRadioButton rdbtnSummer = new JRadioButton("Summer");
		rdbtnSummer.setBounds(265, 178, 106, 29);
		contentPane.add(rdbtnSummer);
		buttongroup.add(rdbtnSummer);//하나만 선택
		
		JButton btnok = new JButton("OK");
		//ok 버튼 누르면 실행되는 것 연결
		btnok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnBlue.isSelected())
				{
					screenfactory = new screenFactory();
					screenfactory.create(employee, "blue");
					dispose();
				}
				
				if(rdbtnSummer.isSelected())
				{
					screenfactory = new screenFactory();
					screenfactory.create(employee, "summer");
					dispose();
				}
			}
		});
		btnok.setBounds(166, 200, 86, 29);
		contentPane.add(btnok);
		
		
		//background blue 실행
		
			/*JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("C:\\Users\\\uD604\uC9C0\\Desktop\\moomin\\screenBlue.jpg"));
			label.setBounds(0, 0, 428, 244);
			contentPane.add(label);*/
		
		
	}//select_theme()
 }//class
