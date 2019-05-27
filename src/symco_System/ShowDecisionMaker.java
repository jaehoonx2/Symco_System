package symco_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowDecisionMaker extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowDecisionMaker frame = new ShowDecisionMaker();
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
	public ShowDecisionMaker() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 497, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uACB0\uC815 \uC7A5\uC560\uB294 \uC7A5\uC560\uAC00 \uC544\uB2D9\uB2C8\uB2E4, \uB2E8\uC9C0 \uC870\uAE08 \uB354\uB51C \uBFD0..");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(14, 25, 451, 25);
		contentPane.add(lblNewLabel);
		
		EitherOr eitherOr = new EitherOr();
		
		JButton eitherorbtn = new JButton("\uC591\uC790 \uD0DD\uC77C");
		eitherorbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//양자 택일
				JOptionPane.showMessageDialog(null, eitherOr.Decision());
			}
		});
		eitherorbtn.setBounds(51, 89, 161, 53);
		contentPane.add(eitherorbtn);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\\uD55C\uB3D9\uB300 \uAC15\uC758\uBCC4\\3\uD559\uB144 1\uD559\uAE30\\\uAC1D\uCCB4\uC9C0\uD5A5 \uC124\uACC4\uD328\uD134\\Simco\\src\\symco_System\\nagulman.jpg"));
		lblNewLabel_1.setBounds(136, 221, 203, 190);
		contentPane.add(lblNewLabel_1);
		
		
		DoOrNot doOrNot = new DoOrNot();
		
		JButton doornotbtn = new JButton("\uD560\uAE4C \uB9D0\uAE4C");
		doornotbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//할까 말까
				JOptionPane.showMessageDialog(null, doOrNot.Decision());
			}
		});
		doornotbtn.setBounds(272, 89, 161, 53);
		contentPane.add(doornotbtn);
		
		JLabel lblNewLabel_2 = new JLabel("\uB108\uC758 \uACB0\uC815 \uC7A5\uC560\uB294 \uB108\uAD74\uB9E8\uC774 \uCE58\uB8CC\uD588\uC73C\uB2C8 \uC548\uC2EC\uD558\uB77C\uAD6C!");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(14, 167, 451, 42);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\uACE0\uB9C8\uC6CC, \uB108\uAD74\uB9E8!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(150, 445, 171, 27);
		contentPane.add(btnNewButton);
	}

}
