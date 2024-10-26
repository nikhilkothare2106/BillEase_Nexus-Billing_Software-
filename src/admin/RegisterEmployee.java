package admin;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import userdefined.*;
import validation.RegValidation;

import javax.swing.border.MatteBorder;

import billingSoftware.LoginPage;
import dbconnection.DbOperations;
import gettersetter.GetSetEmployee;

public class RegisterEmployee {

	private JFrame frame = new JFrame();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JRadioButton rdbtnNewRadioButton, rdbtnFemale;
	private RoundedButton btn_register;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public RegisterEmployee() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame.setTitle("Register Employee");
		frame.setBounds(0, 0, 1380, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 201, 176));
		panel.setBounds(228, 0, 1136, 101);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("  Log out");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_9.setForeground(new Color(0, 0, 240));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_9.setForeground(new Color(240, 0, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new LoginPage();
				frame.setVisible(false);
			}
		});
		lblNewLabel_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_9.setForeground(new Color(240, 0, 0));
		lblNewLabel_9.setFont(new Font("Rockwell", Font.BOLD, 22));
		lblNewLabel_9.setBounds(1000, 27, 108, 34);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_3_1 = new JLabel("Admin DashBoard");
		lblNewLabel_3_1.setForeground(new Color(46, 79, 79));
		lblNewLabel_3_1.setFont(new Font("Cooper Black", Font.BOLD, 42));
		lblNewLabel_3_1.setBounds(326, 16, 428, 67);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new LineBorder(new Color(15, 191, 169)));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(0, 0, 1204, 101);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(46, 79, 79));
		panel_1.setBounds(0, 101, 228, 638);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(46, 79, 79));
		panel_4.setBounds(0, 28, 228, 559);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_5_1_1_2_1_1 = new JLabel("");
		lblNewLabel_5_1_1_2_1_1.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\shopping_history.png"));
		lblNewLabel_5_1_1_2_1_1.setBounds(22, 356, 50, 57);
		panel_4.add(lblNewLabel_5_1_1_2_1_1);
		
		JLabel lblNewLabel_10_1 = new JLabel("Shopping History");
		lblNewLabel_10_1.setForeground(Color.BLACK);
		lblNewLabel_10_1.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_10_1.setBounds(76, 354, 119, 57);
		panel_4.add(lblNewLabel_10_1);
		
		RoundedLabel lblNewLabel_8_4_1 = new RoundedLabel("", 30, UIManager.getColor("Button.background"), Color.BLACK, 2);
		lblNewLabel_8_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ShoppingHistory();
				frame.setVisible(false);
			}
		});
		lblNewLabel_8_4_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_8_4_1.setBounds(10, 354, 208, 57);
		panel_4.add(lblNewLabel_8_4_1);
		
		JLabel lblNewLabel_10 = new JLabel("Change Password");
		lblNewLabel_10.setForeground(new Color(0, 0, 0));
		lblNewLabel_10.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_10.setBounds(76, 450, 142, 57);
		lblNewLabel_10.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_10);
		
		JLabel lblNewLabel_5_1_1_2 = new JLabel("");
		lblNewLabel_5_1_1_2.setIcon(new ImageIcon(RegisterEmployee.class.getResource("/images/edititem.png")));
		lblNewLabel_5_1_1_2.setBounds(10, 274, 53, 57);
		lblNewLabel_5_1_1_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1_2);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1.setIcon(new ImageIcon(RegisterEmployee.class.getResource("/images/edit.png")));
		lblNewLabel_5_1_1.setBounds(19, 95, 53, 57);
		lblNewLabel_5_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_3_1 = new JLabel("Add items");
		lblNewLabel_5_3_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_5_3_1.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_5_3_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_5_3_1.setBounds(66, 176, 112, 57);
		panel_4.add(lblNewLabel_5_3_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("");
		lblNewLabel_5_1_1_1.setIcon(new ImageIcon(RegisterEmployee.class.getResource("/images/additem.png")));
		lblNewLabel_5_1_1_1.setBounds(17, 176, 47, 57);
		lblNewLabel_5_1_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabel_5_1_1_2_1 = new JLabel("");
		lblNewLabel_5_1_1_2_1.setIcon(new ImageIcon(RegisterEmployee.class.getResource("/images/changepassword.png")));
		lblNewLabel_5_1_1_2_1.setBounds(23, 450, 57, 57);
		lblNewLabel_5_1_1_2_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1_2_1);
		
		JLabel lblNewLabel_5_3 = new JLabel("View/Edit Employee");
		lblNewLabel_5_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_5_3.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_5_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_5_3.setBounds(66, 93, 142, 57);
		panel_4.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5 = new JLabel("View/Edit items");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_5.setBounds(66, 266, 142, 57);
		panel_4.add(lblNewLabel_5);
		
		 RoundedLabel lblNewLabel_8_3 = new RoundedLabel("", 30, new Color(240,240,240), Color.BLACK, 2);
		lblNewLabel_8_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ViewEditItem();
				frame.setVisible(false);
			}
		});
		lblNewLabel_8_3.setBounds(10, 266, 208, 57);
		lblNewLabel_8_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_8_3);
		
		 RoundedLabel lblNewLabel_8_1 = new RoundedLabel("", 30, new Color(240,240,240), Color.BLACK, 2);
		lblNewLabel_8_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ViewEditEmployee();
				frame.setVisible(false);	}
		});
		lblNewLabel_8_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_8_1.setBounds(10, 93, 208, 57);
		panel_4.add(lblNewLabel_8_1);
		
		 RoundedLabel lblNewLabel_8_4 = new RoundedLabel("", 30, new Color(240,240,240), Color.BLACK, 2);
		lblNewLabel_8_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ChangePasswordAdmin();
				frame.setVisible(false);			}
		});
		lblNewLabel_8_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_8_4.setBounds(10, 449, 208, 57);
		panel_4.add(lblNewLabel_8_4);
		
		RoundedLabel lblNewLabel_8_2 = new RoundedLabel("", 30, new Color(240,240,240), Color.BLACK, 2);
		lblNewLabel_8_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddItems();
				frame.setVisible(false);
			}
		});
		lblNewLabel_8_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_8_2.setBounds(10, 176, 208, 57);
		panel_4.add(lblNewLabel_8_2);
		
		JLabel lblNewLabel_6 = new JLabel("Register Employee");
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_6.setBounds(72, 11, 142, 57);
		lblNewLabel_6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(RegisterEmployee.class.getResource("/images/register.png")));
		lblNewLabel_5_1.setBounds(22, 11, 53, 57);
		lblNewLabel_5_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1);
		
//		JLabel lblNewLabel_8 = new JLabel("");
		 RoundedLabel lblNewLabel_8 = new RoundedLabel("", 30, new Color(240,240,240), Color.BLACK, 2);
		lblNewLabel_8.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_8.setBounds(10, 11, 208, 57);
		panel_4.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_7.setBounds(0, 0, 228, 559);
		panel_4.add(lblNewLabel_7);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 228, 638);
		lblNewLabel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(201, 228, 222));
		panel_2.setBounds(228, 101, 1136, 644);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3_2 = new JLabel("BillEase");
		lblNewLabel_3_2.setForeground(new Color(255, 255, 224));
		lblNewLabel_3_2.setFont(new Font("Cooper Black", Font.BOLD, 54));
		lblNewLabel_3_2.setBounds(224, 63, 259, 67);
		panel_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Nexus");
		lblNewLabel_3_1_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_3_1_1.setFont(new Font("Cooper Black", Font.BOLD, 54));
		lblNewLabel_3_1_1.setBounds(249, 119, 225, 67);
		panel_2.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(RegisterEmployee.class.getResource("/images/imageedit_7_8214613300.png")));
		lblNewLabel_4_1.setBounds(156, 187, 364, 379);
		panel_2.add(lblNewLabel_4_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(46, 79, 79));
		panel_5.setBounds(623, 42, 346, 516);
		panel_2.add(panel_5);
		
		JLabel lblNewLabel_6_1 = new JLabel("Enter email");
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_6_1.setBounds(25, 172, 214, 25);
		panel_5.add(lblNewLabel_6_1);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.requestFocus();
			}
		});
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Serif", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textField.setBackground(new Color(15, 164, 149));
		textField.setBounds(25, 194, 298, 25);
		panel_5.add(textField);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_register.doClick();
			}
		});
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Serif", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setCaretColor(Color.WHITE);
		textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textField_1.setBackground(new Color(15, 164, 149));
		textField_1.setBounds(25, 393, 298, 25);
		panel_5.add(textField_1);
		
		btn_register = new RoundedButton("Register", 20, Color.WHITE);
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_2.getText();
				String email = textField.getText();
				String pwd = new String(passwordField.getPassword());
				String phone = textField_1.getText();
				String gender = "";
				if(rdbtnNewRadioButton.isSelected()){
					gender = "M";
				}else if(rdbtnFemale.isSelected()){
					gender = "F";
				}
				String module = "Employee";
				RegValidation validate = new RegValidation();
				if(!validate.nameValidation(name)){
					JOptionPane.showMessageDialog(frame, "Invalid name", "Name error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!validate.emailValidation(email)){
					JOptionPane.showMessageDialog(frame, "Invalid email", "Email error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!validate.passwordValidation(pwd)){
					JOptionPane.showMessageDialog(frame, "Invalid password", "Password error", JOptionPane.ERROR_MESSAGE);
				}else if(!validate.phonenoValidation(phone)){
					JOptionPane.showMessageDialog(frame, "Invalid phone no", "Phone No error", JOptionPane.ERROR_MESSAGE);
				}else if(gender.equals("")){
					JOptionPane.showMessageDialog(frame, "Select gender", "Gender error", JOptionPane.ERROR_MESSAGE);
				}else{
					GetSetEmployee employee = new GetSetEmployee();
					employee.setEmail(email);
					employee.setName(name);
					employee.setGender(gender);
					employee.setPassword(pwd);
					employee.setPhoneno(phone);
					employee.setModule(module);

					boolean status = DbOperations.register(employee);
					if(status){
						JOptionPane.showMessageDialog(frame, "Employee Registered Sucessfully");
						textField_2.setText("");
						textField.setText("");
						passwordField.setText("");
						textField_1.setText("");
						buttonGroup.clearSelection();
					}else{
						JOptionPane.showMessageDialog(frame, "Error occurred", "Register error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btn_register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_register.setForeground(Color.WHITE);
		btn_register.setFont(new Font("Rockwell", Font.BOLD, 14));
		btn_register.setFocusPainted(false);
		btn_register.setBackground(new Color(255, 69, 0));
		btn_register.setBounds(100, 448, 141, 40);
		panel_5.add(btn_register);
		
		JLabel lblEnterPhoneNo = new JLabel("Enter Phone No");
		lblEnterPhoneNo.setForeground(Color.WHITE);
		lblEnterPhoneNo.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblEnterPhoneNo.setBounds(25, 371, 214, 25);
		panel_5.add(lblEnterPhoneNo);
		
		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Rockwell", Font.BOLD, 12));
		rdbtnFemale.setFocusPainted(false);
		rdbtnFemale.setBackground(new Color(15, 164, 149));
		rdbtnFemale.setBounds(100, 341, 81, 23);
		panel_5.add(rdbtnFemale);
		
		rdbtnNewRadioButton = new JRadioButton("Male");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Rockwell", Font.BOLD, 12));
		rdbtnNewRadioButton.setFocusPainted(false);
		rdbtnNewRadioButton.setBackground(new Color(15, 164, 149));
		rdbtnNewRadioButton.setBounds(25, 341, 73, 23);
		panel_5.add(rdbtnNewRadioButton);
		
		JLabel lblSelectGender = new JLabel("Select Gender");
		lblSelectGender.setForeground(Color.WHITE);
		lblSelectGender.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblSelectGender.setBounds(25, 309, 214, 25);
		panel_5.add(lblSelectGender);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.requestFocus();
			}
		});
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Serif", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setCaretColor(Color.WHITE);
		textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textField_2.setBackground(new Color(15, 164, 149));
		textField_2.setBounds(25, 128, 298, 25);
		panel_5.add(textField_2);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		passwordField.setBackground(new Color(15, 164, 149));
		passwordField.setBounds(25, 262, 298, 25);
		panel_5.add(passwordField);
		
		JLabel lblNewLabel_11 = new JLabel("Enter Name");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_11.setBounds(25, 106, 214, 25);
		panel_5.add(lblNewLabel_11);
		
		JLabel lblUserPassword = new JLabel("Enter Password");
		lblUserPassword.setForeground(Color.WHITE);
		lblUserPassword.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblUserPassword.setBounds(25, 241, 214, 25);
		panel_5.add(lblUserPassword);
		
		JLabel lblNewLabel_5_2 = new JLabel("Register Employee");
		lblNewLabel_5_2.setForeground(Color.WHITE);
		lblNewLabel_5_2.setFont(new Font("Rockwell", Font.BOLD, 26));
		lblNewLabel_5_2.setBounds(49, 21, 256, 63);
		panel_5.add(lblNewLabel_5_2);
		
		RoundedLabel lblNewLabel_2_1 = new RoundedLabel("", 30, new Color(15,164,149), Color.BLACK, 1);
		lblNewLabel_2_1.setBounds(0, 0, 346, 516);
		panel_5.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIconTextGap(3);
		lblNewLabel_1_1.setBackground(new Color(46, 79, 79));
		lblNewLabel_1_1.setBounds(90, 11, 958, 579);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBorder(new LineBorder(new Color(46, 79, 79)));
		lblNewLabel_3.setBounds(0, 0, 1136, 638);
		panel_2.add(lblNewLabel_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(46, 79, 79));
		panel_6.setBounds(90, 11, 958, 579);
		panel_2.add(panel_6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(46, 79, 79));
		panel_3.setBorder(null);
		panel_3.setBounds(0, 0, 228, 101);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AdminPanel();
				frame.setVisible(false);
			}
		});
		lblNewLabel_1.setBounds(51, 0, 112, 101);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/admin.png")));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, 0, 228, 101);
		panel_3.add(lblNewLabel_4);
		lblNewLabel_4.setBorder(null);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		;
	}
}
