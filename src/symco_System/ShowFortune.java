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
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowFortune extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowFortune frame = new ShowFortune();
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
	public ShowFortune() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB2F9\uC2E0\uC758 \uC6B4\uC138\uB294...");
		lblNewLabel.setBounds(0, 0, 432, 45);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC6B0\uB9AC\uAC00 \uC120\uC744 \uD589\uD558\uB418 \uB099\uC2EC\uD558\uC9C0 \uB9D0\uC9C0\uB2C8,");
		lblNewLabel_1.setBounds(24, 190, 247, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uD53C\uACE4\uD558\uC9C0 \uC544\uB2C8\uD558\uBA74 \uB54C\uAC00 \uC774\uB974\uB9E4 \uAC70\uB450\uB9AC\uB77C");
		lblNewLabel_2.setBounds(24, 209, 352, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("(\uAC08\uB77C\uB514\uC544\uC11C 6:9)");
		lblNewLabel_3.setBounds(296, 223, 108, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel showfortune = new JLabel("God bless you");
		showfortune.setBounds(0, 43, 432, 82);
		showfortune.setBackground(Color.PINK);
		showfortune.setFont(new Font("±Ã¼­Ã¼", Font.BOLD, 22));
		showfortune.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(showfortune);
		
		JButton button = new JButton("\uC624\uB298\uC758 \uC6B4\uC138");
		button.setBounds(34, 135, 133, 27);
		Fortune today = new TodayFortune();
		Fortune nextday = new NextdayFortune();
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, today.popFortune());
			}
		});
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\uB0B4\uC77C\uC758 \uC6B4\uC138");
		btnNewButton.setBounds(270, 135, 133, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, nextday.popFortune());
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uB2EB\uAE30");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		btnNewButton_1.setBounds(166, 256, 105, 27);
		contentPane.add(btnNewButton_1);
	}
}
