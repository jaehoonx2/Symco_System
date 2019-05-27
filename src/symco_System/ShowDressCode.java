package symco_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

public class ShowDressCode extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowDressCode frame = new ShowDressCode();
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
	public ShowDressCode() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\uB2EB\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(165, 377, 105, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\uD328\uC158\uC758 \uC644\uC131\uC740 \uC5BC\uAD74, \uD558\uC9C0\uB9CC \uB10C...");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 12, 386, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\\uD55C\uB3D9\uB300 \uAC15\uC758\uBCC4\\3\uD559\uB144 1\uD559\uAE30\\\uAC1D\uCCB4\uC9C0\uD5A5 \uC124\uACC4\uD328\uD134\\Simco\\src\\symco_System\\fas.jpg"));
		lblNewLabel_1.setBounds(68, 58, 298, 192);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\"\uC637\uC774\uB77C\uB3C4 \uC798 \uC785\uACE0 \uB2E4\uB140\uB77C.\"");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(33, 262, 367, 27);
		contentPane.add(lblNewLabel_2);
		
		

		JRadioButton womanradiobtn = new JRadioButton("\uC5EC\uC790");
		womanradiobtn.setBounds(353, 297, 69, 27);
		contentPane.add(womanradiobtn);
		
		JRadioButton manradiobtn = new JRadioButton("\uB0A8\uC790");
		manradiobtn.setBounds(282, 297, 69, 27);
		contentPane.add(manradiobtn);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 301, 258, 60);
		contentPane.add(scrollPane);
		

		JLabel showflabel = new JLabel("\uC0AC\uB0B4 \uD328\uC158\uC655\uC740 \uBC14\uB85C \uB2F9\uC2E0!");
		showflabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setViewportView(showflabel);
		
		
		DressCode womanDress = new WomanDress();
		DressCode manDress = new ManDress();

		
		JButton btnNewButton_1 = new JButton("\uD328\uC158 \uCD94\uCC9C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//패션 보여주기
				if(womanradiobtn.isSelected() && manradiobtn.isSelected() == true){
					JOptionPane.showMessageDialog(null, "성별을 둘 중 하나만 선택해주세요.");
				}
				else if(womanradiobtn.isSelected() == true){
					showflabel.setText(OutputMent(womanDress.Top(), womanDress.Bottom(), womanDress.Shoes()));			
				}
				else if(manradiobtn.isSelected() == true){
					showflabel.setText(OutputMent(manDress.Top(), manDress.Bottom(), manDress.Shoes()));	
				}
				else{
					JOptionPane.showMessageDialog(null, "성별을 선택해주세요.");
				}
			}
		});
		btnNewButton_1.setBounds(301, 332, 105, 27);
		contentPane.add(btnNewButton_1);

	}
	
	public String OutputMent(String tp, String btm, String sho){
		String ment = "";
		
		ment = "오늘 상의는 " + tp + "를(을) 입으시고, 하의로는 " + btm + "를(을) 입으세요. 신발은 " + sho + "를(을) 신으시면 됩니다!";
		
		return ment;
	}

}
