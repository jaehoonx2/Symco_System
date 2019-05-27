package symco_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.util.Random;

public class ShowFood extends JFrame {
	Random random = new Random();
	static int number;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowFood frame = new ShowFood();
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
	public ShowFood() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC74C\uC2DD \uCD94\uCC9C");
		lblNewLabel.setBounds(14, 12, 484, 49);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel showfoodlist = new JLabel("\uB2E4 \uBA39\uACE0 \uC0B4\uC790\uACE0 \uD558\uB294 \uC9D3\uC778\uB370..");
		showfoodlist.setBounds(14, 216, 482, 56);
		contentPane.add(showfoodlist);
		showfoodlist.setHorizontalAlignment(SwingConstants.CENTER);
		

		JLabel showfoodpack = new JLabel("\uB108\uBB34 \uBB34\uB9AC\uD558\uC9C0 \uB9C8\uC2DC\uACE0, \uC26C\uBA74\uC11C \uD558\uC138\uC694!");
		showfoodpack.setHorizontalAlignment(SwingConstants.CENTER);
		showfoodpack.setBounds(14, 274, 482, 56);
		contentPane.add(showfoodpack);
		
		JLabel showfoodtel = new JLabel("\uC624\uB298\uB9CC \uB0A0\uC740 \uC544\uB2C8\uB2C8\uAE4C\uC694 :) \uD654\uC774\uD305!");
		showfoodtel.setHorizontalAlignment(SwingConstants.CENTER);
		showfoodtel.setBounds(14, 329, 482, 56);
		contentPane.add(showfoodtel);
		
		
		
		/////////food building
		
		FoodBuilder foodbuilder = new FoodBuilder();
		
		//////////////////////
		
		JButton button = new JButton("\uD074\uB9AD");
		button.setBounds(115, 59, 290, 49);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = random.nextInt();
				if(number%5 == 0){
					FoodSet goodfood = foodbuilder.FeelgoodFood();
					goodfood.setFoods();
					showfoodlist.setText("기분 좋은 날 추천합니다: " + goodfood.foodList);
					showfoodpack.setText(goodfood.foodPack);
					showfoodtel.setText(goodfood.foodTel);
				}
				else if(number%5 == 1){
					FoodSet badfood = foodbuilder.FeelbadFood();
					badfood.setFoods();
					showfoodlist.setText("기분 나쁜 날 드셔보세요: " + badfood.foodList);
					showfoodpack.setText(badfood.foodPack);
					showfoodtel.setText(badfood.foodTel);
				}
				else if(number%5 == 2){
					FoodSet sosofood = foodbuilder.FeelsosoFood();
					sosofood.setFoods();
					showfoodlist.setText("기분이 꿀꿀할 때 추천합니다: " + sosofood.foodList);
					showfoodpack.setText(sosofood.foodPack);
					showfoodtel.setText(sosofood.foodTel);
				}
				else if(number%5 == 3){
					FoodSet busyfood = foodbuilder.FeelbusyFood();
					busyfood.setFoods();
					showfoodlist.setText("바쁜날 추천합니다: " + busyfood.foodList);
					showfoodpack.setText(busyfood.foodPack);
					showfoodtel.setText(busyfood.foodTel);
				}
				else{
					FoodSet Vbusyfood = foodbuilder.FeelVbusyFood();
					Vbusyfood.setFoods();
					showfoodlist.setText("매우매우 바쁜날 추천합니다: " + Vbusyfood.foodList);
					showfoodpack.setText(Vbusyfood.foodPack);
					showfoodtel.setText(Vbusyfood.foodTel);
				}
				
				FoodSet.init_setFoods();
		
			}
		});
		
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\uB2EB\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//닫기
				dispose();
			}
		});
		btnNewButton.setBounds(201, 407, 105, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("<\uC885\uB958>");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(14, 120, 484, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("\uC2DD\uC0AC\uB958: \uB3C4\uC2DC\uB77D\uC9D1(\uD55C\uC1A5\uB3C4\uC2DC\uB77D, \uACF5\uC528\uB124\uC8FC\uBA39\uBC25), \uBC84\uAC70\uC9D1(\uB86F\uB370\uB9AC\uC544, \uB9E5\uB3C4\uB0A0\uB4DC, \uBC84\uAC70\uD0B9)");
		label.setFont(new Font("굴림", Font.PLAIN, 12));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(14, 150, 484, 27);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\uAC04\uC2DD\uB958: \uCE58\uD0A8(\uB545\uB545\uCE58\uD0A8, \uBD80\uC5B4\uCE58\uD0A8, BBQ, \uC300\uD1B5\uB2ED)");
		label_1.setFont(new Font("굴림", Font.PLAIN, 12));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(14, 177, 484, 27);
		contentPane.add(label_1);
	}
}
