package symco_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowGroup extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowGroup frame = new ShowGroup();
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
	public ShowGroup() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		GroupFactory groupFactory = new GroupFactory();
		
		
		
		JLabel groupname = new JLabel("");
		groupname.setHorizontalAlignment(SwingConstants.CENTER);
		groupname.setBounds(14, 12, 404, 37);
		contentPane.add(groupname);
		
		groupname.setText(MyList.tGroupName);
		
		
		JLabel lblNewLabel_1 = new JLabel("\uADF8\uB8F9 \uBD84\uB958: ");
		lblNewLabel_1.setBounds(14, 74, 93, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel grouptypelabel = new JLabel("");
		grouptypelabel.setBounds(83, 74, 269, 18);
		contentPane.add(grouptypelabel);
		
		
		JLabel groupactivitylabel = new JLabel("");
		groupactivitylabel.setBounds(276, 303, 142, 18);
		contentPane.add(groupactivitylabel);
		
		
		
		
		if(Project.GT == "취미"){
			Group G1 = groupFactory.getGroup("취미");
			grouptypelabel.setText(G1.groupType());
			groupactivitylabel.setText(G1.groupActivity(Project.tGroupActivity));
		}
		else if(Project.GT == "프로젝트"){
			Group G2 = groupFactory.getGroup("프로젝트");
			grouptypelabel.setText(G2.groupType());
			groupactivitylabel.setText(G2.groupActivity(Project.tGroupActivity));
		}
		
		
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 140, 404, 129);
		contentPane.add(scrollPane);
		
		String t = "   ";
		
		JLabel groupmemberlabel = new JLabel("\uADF8\uB8F9 \uBA64\uBC84 \uCC3D");
		scrollPane.setViewportView(groupmemberlabel);
		
		for(int i=0; i<GroupList.GgroupList.get(MyList.val).getGroupMember().size(); i++){
			t = t + GroupList.GgroupList.get(MyList.val).getGroupMember().get(i).getName() + "(" + GroupList.GgroupList.get(MyList.val).getGroupMember().get(i).getID() +  ")";
		}
		
		groupmemberlabel.setText(t);
		
		
		
		JLabel label = new JLabel("\uADF8\uB8F9 \uBA64\uBC84: ");
		label.setBounds(14, 110, 93, 18);
		contentPane.add(label);
		
		
		JButton btnNewButton = new JButton("\uB2EB\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(165, 319, 105, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uD3EC\uC2A4\uD2B8");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Post.main(null);
			}
		});
		btnNewButton_1.setBounds(27, 319, 105, 27);
		contentPane.add(btnNewButton_1);
		
		
		
		
	}

}
