package symco_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Project extends JFrame {
	static int getIndexOfName;
	private JPanel contentPane;
	private JTextField addIDtextField;
	private JTextField groupnametextField;
	private JTable table;
	private JTable memberlisttable;
	public static Employee gl = null;

	static String GT = "";
	static String tGroupActivity = "";
	private JTextField groupactivitytextField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project frame = new Project();
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
	public Project() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uADF8\uB8F9 \uC0DD\uC131");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(14, 12, 404, 19);
		contentPane.add(lblNewLabel);
		
		addIDtextField = new JTextField();
		addIDtextField.setBounds(250, 352, 97, 22);
		contentPane.add(addIDtextField);
		addIDtextField.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 247, 404, 93);
		contentPane.add(scrollPane_1);
		
		JLabel showaddmemberlabel = new JLabel("");
		scrollPane_1.setViewportView(showaddmemberlabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uADF8\uB8F9\uC5D0 \uC18D\uD55C \uBA85\uB2E8");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(14, 225, 404, 18);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 43, 404, 170);
		contentPane.add(scrollPane);
		
		
		/*
      employee.add(new Employee("leader","leader","������","����","�λ�"));
      employee.add(new Employee("employee","employee","�����","���","������"));
		 */
		
		
		
		memberlisttable = new JTable();
		memberlisttable.setModel(new DefaultTableModel(
			new Object[][] {
				{Employee.init().get(0).getDepartment(), Employee.init().get(0).getName(), Employee.init().get(0).getID(), Employee.init().get(0).getRank()},
				{Employee.init().get(1).getDepartment(), Employee.init().get(1).getName(), Employee.init().get(1).getID(), Employee.init().get(1).getRank()},
			},
			new String[] {
				"�μ�", "�̸�", "���̵�", "��å"
			}
		));
		scrollPane.setViewportView(memberlisttable);
		
		
		JLabel lblNewLabel_2 = new JLabel("\uADF8\uB8F9\uC5D0 \uCD94\uAC00\uD560 \uC544\uC774\uB514\uB97C \uC785\uB825\uD558\uC2DC\uC624: ");
		lblNewLabel_2.setBounds(14, 354, 247, 19);
		contentPane.add(lblNewLabel_2);

//		Employee.addEmployee(Login_System.getCurEmployee().getID(), Login_System.getCurEmployee().getID(), Login_System.getCurEmployee().getID(), Login_System.getCurEmployee().getID(), Login_System.getCurEmployee().getID());
		
		JButton btnNewButton = new JButton("\uCD94\uAC00");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IsMember(Employee.init(), addIDtextField.getText()) == true){
					if(GroupList.GgroupList.contains(addIDtextField.getText()) == false){
					showaddmemberlabel.setText(showaddmemberlabel.getText() + "  " + showListForm(addIDtextField.getText(), Employee.init().get(getIndexOfName).getName()));
						gl = Employee.init().get(getIndexOfName);
						Employee.addEmployee(gl.getID(), gl.getPassword(), gl.getName(), gl.getRank(), gl.getDepartment());
//NullPointerError �߻�
//						GroupList.groupMember.add(gl);
					}
					else{
						JOptionPane.showMessageDialog(null, "�̹� �߰��� ��� �Դϴ�");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "���� ��� �Դϴ�");//////////////////////////////////���� �޸�
				}
			}
		});
		btnNewButton.setBounds(352, 350, 66, 27);
		contentPane.add(btnNewButton);
		
		groupnametextField = new JTextField();
		groupnametextField.setText("\uADF8\uB8F9\uBA85");
		groupnametextField.setBounds(14, 396, 116, 24);
		contentPane.add(groupnametextField);
		groupnametextField.setColumns(10);
		
		JRadioButton hobbygroupRadioButton_1 = new JRadioButton("\uCDE8\uBBF8 \uADF8\uB8F9");
		hobbygroupRadioButton_1.setBounds(305, 395, 89, 27);
		contentPane.add(hobbygroupRadioButton_1);
		

		groupactivitytextField = new JTextField();
		groupactivitytextField.setBounds(281, 504, 116, 24);
		contentPane.add(groupactivitytextField);
		groupactivitytextField.setColumns(10);
		
		
		
		JButton btnNewButton_1 = new JButton("\uADF8\uB8F9 \uC0DD\uC131");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IsGroupNameExist(GroupList.GgroupList, groupnametextField.getText()) == false){
					if(groupnametextField.getText().equals("")){
						JOptionPane.showMessageDialog(null, "�׷���� �Է����ּ���");
					}
					else{
						if(showaddmemberlabel.getText().isEmpty()){
							System.out.println(GroupList.groupMember.get(0).getID());
							JOptionPane.showMessageDialog(null, "�׷���� �Է����ּ���");
						}
						else{
							if(hobbygroupRadioButton_1.isSelected() == true){
								GroupList.addGroup(groupnametextField.getText(), Login_System.getCurEmployee(), GroupList.groupMember);
								Employee.temployee.clear(); //�׷��� �����ϸ�, �Ź� �ʱ�ȭ����
								GT = "���";
								tGroupActivity = groupactivitytextField.getText();								
								JOptionPane.showMessageDialog(null, "��� �׷��� ���������� �����Ǿ����ϴ�");
							}
							else{
								//////////////////////////�α��� ������ getFirstEmployee �� getCurEmployee�� �������
//								System.out.println(GroupList.groupMember.get(0).getID());
								GroupList.addGroup(groupnametextField.getText(), Login_System.getCurEmployee(), GroupList.groupMember);
								Employee.temployee.clear(); //�׷��� �����ϸ�, �Ź� �ʱ�ȭ����
								GT = "������Ʈ";
								tGroupActivity = groupactivitytextField.getText();
								JOptionPane.showMessageDialog(null, "������Ʈ �׷��� ���������� �����Ǿ����ϴ�");
							}
							
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "�̹� �����ϴ� �׷� �̸� �Դϴ�");
				}
			}
		});
		btnNewButton_1.setBounds(144, 396, 117, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uB2EB\uAE30");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�ݱ�
				dispose();
			}
		});
		btnNewButton_2.setBounds(154, 526, 105, 27);
		contentPane.add(btnNewButton_2);
		
		JButton button = new JButton("\uC804\uCCB4 \uADF8\uB8F9");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TotalList.main(null);
				System.out.println("�׷츮��Ʈ ũ��: " + GroupList.GgroupList.size());
			}
		});
		button.setBounds(25, 526, 105, 27);
		contentPane.add(button);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(14, 432, 191, 59);
		contentPane.add(scrollPane_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uD504\uB85C\uC81D\uD2B8:      \r\n1. \uC0AC\uB0B4 \uC18C\uC18D \uBD80\uC11C \r\n2. \uC0AC\uB0B4 \uC18C\uC18D\uC678 \uBD80\uC11C \r\n3. \uD0C0\uC0AC(\uC678\uC8FC) \uD611\uC5C5 \r\n4. \uAE30\uD0C0 ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_2.setViewportView(lblNewLabel_3);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(227, 433, 191, 59);
		contentPane.add(scrollPane_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uCDE8\uBBF8:      \r\n1. \uC5EC\uAC00 \r\n2. \uC608\uC220 \r\n3. \uD559\uD68C \r\n4. \uAE30\uD0C0 ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_3.setViewportView(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uC704\uC5D0\uC11C \uADF8\uB8F9 \uD65C\uB3D9 \uC131\uD5A5\uC744 \uC120\uD0DD\uD558\uC2DC\uC624");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(14, 503, 270, 18);
		contentPane.add(lblNewLabel_5);
	}
	
	
	public String showListForm(String mID, String mName){
		return (mName + "(" + mID + ")");
	}
	
	public boolean IsGroupNameExist(ArrayList<GroupList> arrayList, String wGN){
		int i;
		boolean state = false;
		
		for(i=0; i<arrayList.size(); i++){
			if(arrayList.get(i).getGroupName().equals(wGN)){
				state = true;
			}
		}
		
		return state;
	}
	
	public boolean IsMember(ArrayList<Employee> arrayList, String wID){
		int i;
		boolean state = false;
		
		for(i=0; i<arrayList.size(); i++){
			if(arrayList.get(i).getID().equals(wID)){
				getIndexOfName = i;
				state = true;
			}
		}
		/*
		 *test code
		System.out.println(getIndexOfName);
		System.out.println(arrayList.size());
		System.out.println(state);
		*/
		return state;
	}
	
	
}
