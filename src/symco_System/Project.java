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
      employee.add(new Employee("leader","leader","강팀장","팀장","인사"));
      employee.add(new Employee("employee","employee","오사원","사원","마케팅"));
		 */
		
		
		
		memberlisttable = new JTable();
		memberlisttable.setModel(new DefaultTableModel(
			new Object[][] {
				{Employee.init().get(0).getDepartment(), Employee.init().get(0).getName(), Employee.init().get(0).getID(), Employee.init().get(0).getRank()},
				{Employee.init().get(1).getDepartment(), Employee.init().get(1).getName(), Employee.init().get(1).getID(), Employee.init().get(1).getRank()},
			},
			new String[] {
				"부서", "이름", "아이디", "직책"
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
//NullPointerError 발생
//						GroupList.groupMember.add(gl);
					}
					else{
						JOptionPane.showMessageDialog(null, "이미 추가된 멤버 입니다");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "없는 멤버 입니다");//////////////////////////////////여기 메모
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
						JOptionPane.showMessageDialog(null, "그룹명을 입력해주세요");
					}
					else{
						if(showaddmemberlabel.getText().isEmpty()){
							System.out.println(GroupList.groupMember.get(0).getID());
							JOptionPane.showMessageDialog(null, "그룹원을 입력해주세요");
						}
						else{
							if(hobbygroupRadioButton_1.isSelected() == true){
								GroupList.addGroup(groupnametextField.getText(), Login_System.getCurEmployee(), GroupList.groupMember);
								Employee.temployee.clear(); //그룹을 생성하면, 매번 초기화해줌
								GT = "취미";
								tGroupActivity = groupactivitytextField.getText();								
								JOptionPane.showMessageDialog(null, "취미 그룹이 성공적으로 생성되었습니다");
							}
							else{
								//////////////////////////로그인 연동시 getFirstEmployee 를 getCurEmployee로 수정요망
//								System.out.println(GroupList.groupMember.get(0).getID());
								GroupList.addGroup(groupnametextField.getText(), Login_System.getCurEmployee(), GroupList.groupMember);
								Employee.temployee.clear(); //그룹을 생성하면, 매번 초기화해줌
								GT = "프로젝트";
								tGroupActivity = groupactivitytextField.getText();
								JOptionPane.showMessageDialog(null, "프로젝트 그룹이 성공적으로 생성되었습니다");
							}
							
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "이미 존재하는 그룹 이름 입니다");
				}
			}
		});
		btnNewButton_1.setBounds(144, 396, 117, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uB2EB\uAE30");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//닫기
				dispose();
			}
		});
		btnNewButton_2.setBounds(154, 526, 105, 27);
		contentPane.add(btnNewButton_2);
		
		JButton button = new JButton("\uC804\uCCB4 \uADF8\uB8F9");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TotalList.main(null);
				System.out.println("그룹리스트 크기: " + GroupList.GgroupList.size());
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
