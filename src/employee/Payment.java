package employee;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import dbconnection.DbOperations;
import gettersetter.GetSetEmployee;
import userdefined.RoundedLabel;
import userdefined.RoundedButton;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Payment {

	private JFrame frame = new JFrame();
	private JTextField cash_text;
	private GetSetEmployee employee;
	@SuppressWarnings("rawtypes")
	private HashMap<String,ArrayList> map;
	private String phone,name,total;

	public Payment(GetSetEmployee employee,@SuppressWarnings("rawtypes") HashMap<String,ArrayList> map,String phone, String name,String total) {
		this.map = map;
		this.employee = employee;
		this.name = name;
		this.phone = phone;
		this.total = total;
		initialize();
		frame.setVisible(true);
	}

	private String mapToString(){
		String items = "";
		for(String key: map.keySet()){
			items = items + key + ",";
			@SuppressWarnings("rawtypes")
			ArrayList al = map.get(key);
			items=items+al.get(0)+",";
            items=items+al.get(1)+",";
            items=items+al.get(2)+",";
		}
		return items;
	}
	private void initialize() {
		frame.setTitle("Payment");
		frame.setBounds(0, 0, 1380, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1364, 100);
		panel.setBackground(new Color(46, 79, 79));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Payment");
		lblNewLabel_5_1_1.setBounds(655, 24, 201, 47);
		lblNewLabel_5_1_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_5_1_1.setFont(new Font("Cooper Black", Font.BOLD, 32));
		panel.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_9 = new JLabel("Back");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_9.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_9.setForeground(Color.RED);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new FinalBilling(employee,map);
				frame.setVisible(false);
			}
		});
		lblNewLabel_9.setBounds(1238, 30, 70, 34);
		lblNewLabel_9.setForeground(new Color(240, 0, 0));
		lblNewLabel_9.setFont(new Font("Rockwell", Font.BOLD, 22));
		panel.add(lblNewLabel_9);
		
		JLabel wel_name_label = new JLabel(employee.getName());
		wel_name_label.setBounds(182, 27, 201, 47);
		wel_name_label.setForeground(new Color(255, 255, 224));
		wel_name_label.setFont(new Font("Cooper Black", Font.BOLD, 24));
		panel.add(wel_name_label);
		
		JLabel lblNewLabel_5 = new JLabel("Welcome");
		lblNewLabel_5.setBounds(57, 27, 121, 47);
		lblNewLabel_5.setForeground(new Color(255, 255, 224));
		lblNewLabel_5.setFont(new Font("Cooper Black", Font.BOLD, 24));
		panel.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 100, 1364, 641);
		panel_1.setBackground(new Color(159, 217, 217));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(46, 79, 79));
		panel_2.setBounds(201, 26, 958, 579);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		RoundedButton confirm_btn = new RoundedButton("Log in", 20, Color.WHITE);
		confirm_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item_purchased = mapToString();
				LocalDate ld=LocalDate.now();
        		String date=ld.toString();
				LocalTime lt = LocalTime.now();
				String time = lt.toString();

				boolean status = DbOperations.insertShoppingDetails(name, phone, item_purchased, date, time, employee.getEmail());
				if(status){
					JOptionPane.showMessageDialog(frame, "Items Sold Successfully!");
					new EmployeePanel(employee);
					frame.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(frame, "Error occured!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		confirm_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confirm_btn.setText("Confirm");
		confirm_btn.setForeground(Color.WHITE);
		confirm_btn.setFont(new Font("Rockwell", Font.BOLD, 14));
		confirm_btn.setFocusPainted(false);
		confirm_btn.setBackground(new Color(255, 69, 0));
		confirm_btn.setBounds(692, 370, 106, 36);
		panel_2.add(confirm_btn);
		
		JLabel return_label = new JLabel("0");
		return_label.setForeground(Color.WHITE);
		return_label.setFont(new Font("Rockwell", Font.PLAIN, 16));
		return_label.setBounds(733, 308, 143, 25);
		panel_2.add(return_label);
		
		JLabel lblReturnAmount = new JLabel("Return Amount:");
		lblReturnAmount.setForeground(Color.WHITE);
		lblReturnAmount.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblReturnAmount.setBounds(613, 308, 112, 25);
		panel_2.add(lblReturnAmount);
		
		JLabel price_label_1 = new JLabel("Rs.");
		price_label_1.setForeground(Color.WHITE);
		price_label_1.setFont(new Font("Rockwell", Font.PLAIN, 16));
		price_label_1.setBounds(727, 258, 26, 25);
		panel_2.add(price_label_1);
		
		JLabel total_label = new JLabel(total);
		total_label.setForeground(Color.WHITE);
		total_label.setFont(new Font("Rockwell", Font.PLAIN, 16));
		total_label.setBounds(692, 210, 143, 25);
		panel_2.add(total_label);
		
		JLabel name_label = new JLabel(name);
		name_label.setForeground(Color.WHITE);
		name_label.setFont(new Font("Rockwell", Font.PLAIN, 16));
		name_label.setBounds(660, 163, 143, 25);
		panel_2.add(name_label);
		
		JLabel lblNewLabel_3_2 = new JLabel("BillEase");
		lblNewLabel_3_2.setForeground(new Color(255, 255, 224));
		lblNewLabel_3_2.setFont(new Font("Cooper Black", Font.BOLD, 54));
		lblNewLabel_3_2.setBounds(203, 65, 259, 67);
		panel_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Nexus");
		lblNewLabel_3_1_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_3_1_1.setFont(new Font("Cooper Black", Font.BOLD, 54));
		lblNewLabel_3_1_1.setBounds(228, 121, 225, 67);
		panel_2.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(Payment.class.getResource("/images/imageedit_7_8214613300.png")));
		lblNewLabel_4_1.setBounds(135, 189, 364, 379);
		panel_2.add(lblNewLabel_4_1);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setForeground(Color.WHITE);
		lblPayment.setFont(new Font("Rockwell", Font.BOLD, 26));
		lblPayment.setBounds(692, 82, 121, 51);
		panel_2.add(lblPayment);
		
		JLabel lblHello = new JLabel("Hello");
		lblHello.setForeground(Color.WHITE);
		lblHello.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblHello.setBounds(613, 163, 37, 25);
		panel_2.add(lblHello);
		
		JLabel lblTotalBill = new JLabel("Total Bill:");
		lblTotalBill.setForeground(Color.WHITE);
		lblTotalBill.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblTotalBill.setBounds(613, 211, 69, 25);
		panel_2.add(lblTotalBill);
		
		JLabel lblCashProvided = new JLabel("Cash Provided:");
		lblCashProvided.setForeground(Color.WHITE);
		lblCashProvided.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblCashProvided.setBounds(611, 258, 106, 25);
		panel_2.add(lblCashProvided);
		
		cash_text = new JTextField();
		cash_text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					String cash_provided = cash_text.getText();
					int cash_provided1 = Integer.parseInt(cash_provided);
					int total1 = Integer.parseInt(total);
					if(cash_provided1 > total1){
						int return_cash = cash_provided1 - total1;
						return_label.setText(String.valueOf(return_cash));
					}else{
						return_label.setText("0");
					}
				}
				catch(Exception e1){
					System.out.println("dfovuhdi");
				}
			}
		});
		cash_text.setText((String) null);
		cash_text.setForeground(Color.WHITE);
		cash_text.setFont(new Font("Serif", Font.BOLD, 14));
		cash_text.setColumns(10);
		cash_text.setCaretColor(Color.WHITE);
		cash_text.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		cash_text.setBackground(new Color(15, 164, 149));
		cash_text.setBounds(755, 258, 70, 25);
		panel_2.add(cash_text);
		
		RoundedLabel lblNewLabel_2_1 = new RoundedLabel("", 30, new Color(15, 164, 149), Color.BLACK, 1);
		lblNewLabel_2_1.setBounds(586, 49, 327, 431);
		panel_2.add(lblNewLabel_2_1);
	}
}
