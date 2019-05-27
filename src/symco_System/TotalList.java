package symco_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TotalList extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TotalList frame = new TotalList();
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
	public TotalList() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 604, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC804\uCCB4 \uB9AC\uC2A4\uD2B8 \uC870\uD68C");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(14, 12, 558, 33);
		contentPane.add(lblNewLabel);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 46, 558, 225);
		contentPane.add(scrollPane);
		
		JTable table = new JTable();
        String[] colName = { "그룹명", "그룹장", "그룹 멤버"};
        
        ArrayList<GroupList> gg = new ArrayList<GroupList>();
        gg = GroupList.GgroupList;
        
        Object[][] object = new Object[10][10];
        int i = 0;
        if (gg.size() != 0) {
            for (GroupList grouplist : gg) {
                object[i][0] = grouplist.getGroupName();
                object[i][1] = grouplist.getGroupLeader().getName();
                object[i][2] = grouplist.getGroupMember().get(i).getName();
                i++;
                table = new JTable(object, colName);
            }
        }
        
        
        scrollPane.setViewportView(table);
		
        
        
        
		JButton btnNewButton = new JButton("\uB2EB\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	
		
		
		////////////////////////////////테이블
		
		
		//////////////////////////////////
		
				

		btnNewButton.setBounds(241, 299, 105, 27);
		contentPane.add(btnNewButton);
	}
	

}
