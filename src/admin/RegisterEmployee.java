package admin;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import dbconnection.DbOperations;
import gettersetter.*;
import validation.*;
import java.awt.event.*;
import userdefined.*;
public class RegisterEmployee{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame = new JFrame();
	private JTextField txtEnterName;
	private JPasswordField pwdEnterPassword;
	private JLabel lblNewLabel;
	private JLabel lblUserPassword;
	private JLabel lblNewLabel_1;
	private JButton btn_register;
	private JLabel lblNewLabel_2;
	private JRadioButton rdbtnNewRadioButton, rdbtnFemale;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField text_phone;
	private JLabel lblNewLabel_6;
	private JTextField textField_1;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterEmployee window = new RegisterEmployee();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	
	public RegisterEmployee() {
		initialize();
		frame.setVisible(true);;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(0, 0, 944, 612);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		
		lblNewLabel_7 = new JLabel("Back");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AdminPanel();
				frame.setVisible(false);
			}
		});
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblNewLabel_7.setBounds(21, 22, 55, 26);
		frame.getContentPane().add(lblNewLabel_7);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(523, 31, 364, 548);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel_6 = new JLabel("Enter email");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_6.setBounds(31, 184, 214, 25);
		panel.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pwdEnterPassword.requestFocus();
			}
		});
		
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Serif", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setCaretColor(Color.WHITE);
		textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textField_1.setBackground(new Color(15, 164, 149));
		textField_1.setBounds(31, 206, 298, 25);
		panel.add(textField_1);
		
		text_phone = new JTextField();
		text_phone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_register.doClick();
			}
		});
		text_phone.setForeground(Color.WHITE);
		text_phone.setFont(new Font("Serif", Font.BOLD, 14));
		text_phone.setColumns(10);
		text_phone.setCaretColor(Color.WHITE);
		text_phone.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		text_phone.setBackground(new Color(15, 164, 149));
		text_phone.setBounds(31, 405, 298, 25);
		panel.add(text_phone);
		
		btn_register = new RoundedButton("Register",20,Color.WHITE);
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtEnterName.getText();
				String email = textField_1.getText();
				String password = String.valueOf(pwdEnterPassword.getPassword());
				String gender = "";
				if(rdbtnNewRadioButton.isSelected()){
					gender = "M";
				}else if(rdbtnFemale.isSelected()){
					gender = "F";
				}
				String phone_no = text_phone.getText();
				String module = "Employee";
				
				RegValidation validate = new RegValidation();
				if(!validate.nameValidation(name)){
					JOptionPane.showMessageDialog(frame, "Invalid name", "Name error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!validate.emailValidation(email)){
					JOptionPane.showMessageDialog(frame, "Invalid email", "Email error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!validate.passwordValidation(password)){
					JOptionPane.showMessageDialog(frame, "Invalid password", "Password error", JOptionPane.ERROR_MESSAGE);
				}else if(gender.equals("")){
					JOptionPane.showMessageDialog(frame, "Gender not selected", "Gender error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!validate.phonenoValidation(phone_no)) {
					JOptionPane.showMessageDialog(frame, "Invalid Phone No", "Phone No error", JOptionPane.ERROR_MESSAGE);
				}
				else{
					Register employee = new Register();
					employee.setName(name);
					employee.setEmail(email);
					employee.setPassword(password);
					employee.setPhoneno(phone_no);
					employee.setGender(gender);
					employee.setModule(module);

					boolean status = DbOperations.register(employee);
					if(status){
						JOptionPane.showMessageDialog(frame, "Employee Registered Successfully");
						txtEnterName.setText("");
						textField_1.setText("");
						pwdEnterPassword.setText("");
						text_phone.setText("");
						buttonGroup.clearSelection();
						new AdminPanel();
						frame.setVisible(false);
					}else{
						JOptionPane.showMessageDialog(frame, "Error ocuured!", "Register error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btn_register.setForeground(Color.WHITE);
		btn_register.setFont(new Font("Rockwell", Font.BOLD, 14));
		btn_register.setFocusPainted(false);
		btn_register.setBackground(new Color(255,69,0));
		btn_register.setBounds(94, 463, 141, 40);
		panel.add(btn_register);
		btn_register.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btn_register.setBackground(new Color(255, 99, 71));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_register.setFont(new Font("Rockwell", Font.BOLD, 15));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btn_register.setFont(new Font("Rockwell", Font.BOLD, 14));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_register.setBackground(new Color(255,69,0));
			}
		});
		
		JLabel lblEnterPhoneNo = new JLabel("Enter Phone No");
		lblEnterPhoneNo.setForeground(Color.WHITE);
		lblEnterPhoneNo.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblEnterPhoneNo.setBounds(31, 383, 214, 25);
		panel.add(lblEnterPhoneNo);
		
		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Rockwell", Font.BOLD, 12));
		rdbtnFemale.setFocusPainted(false);
		rdbtnFemale.setBackground(new Color(15, 164, 149));
		rdbtnFemale.setBounds(106, 353, 81, 23);
		panel.add(rdbtnFemale);
		
		rdbtnNewRadioButton = new JRadioButton("Male");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Rockwell", Font.BOLD, 12));
		rdbtnNewRadioButton.setFocusPainted(false);
		rdbtnNewRadioButton.setBackground(new Color(15, 164, 149));
		rdbtnNewRadioButton.setBounds(31, 353, 73, 23);
		panel.add(rdbtnNewRadioButton);
		
		JLabel lblSelectGender = new JLabel("Select Gender");
		lblSelectGender.setForeground(Color.WHITE);
		lblSelectGender.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblSelectGender.setBounds(31, 321, 214, 25);
		panel.add(lblSelectGender);
		
		txtEnterName = new JTextField();
		txtEnterName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.requestFocus();
			}
		});
		txtEnterName.setCaretColor(new Color(255, 255, 255));
		txtEnterName.setForeground(new Color(255, 255, 255));
	
		txtEnterName.setFont(new Font("Serif", Font.BOLD, 14));
		txtEnterName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		txtEnterName.setBackground(new Color(15, 164, 149));
		txtEnterName.setBounds(31, 140, 298, 25);
		panel.add(txtEnterName);
		txtEnterName.setColumns(10);
		
		pwdEnterPassword = new JPasswordField();
		pwdEnterPassword.setCaretColor(new Color(255, 255, 255));
		pwdEnterPassword.setForeground(new Color(255, 255, 255));
		pwdEnterPassword.setBackground(new Color(15, 164, 149));
		pwdEnterPassword.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		pwdEnterPassword.setBounds(31, 274, 298, 25);
		panel.add(pwdEnterPassword);
		
		lblNewLabel = new JLabel("Enter Name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel.setBounds(31, 118, 214, 25);
		panel.add(lblNewLabel);
		
		lblUserPassword = new JLabel("Enter Password");
		lblUserPassword.setForeground(new Color(255, 255, 255));
		lblUserPassword.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblUserPassword.setBounds(31, 253, 214, 25);
		panel.add(lblUserPassword);
		
		JLabel lblNewLabel_5 = new JLabel("Register Employee");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Rockwell", Font.BOLD, 26));
		lblNewLabel_5.setBounds(57, 31, 256, 63);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setIcon(new ImageIcon(RegisterEmployee.class.getResource("/images/Untitled3.png")));
		lblNewLabel_2.setBounds(0, 0, 364, 548);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("BillEase");
		lblNewLabel_3.setFont(new Font("Cooper Black", Font.BOLD, 54));
		lblNewLabel_3.setForeground(new Color(255, 255, 224));
		lblNewLabel_3.setBounds(179, 61, 259, 67);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nexus");
		lblNewLabel_3_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_3_1.setFont(new Font("Cooper Black", Font.BOLD, 54));
		lblNewLabel_3_1.setBounds(199, 122, 225, 67);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\imageedit_7_8214613300.png"));
		lblNewLabel_4.setBounds(85, 200, 364, 379);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIconTextGap(3);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\Untitled.png"));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(0, 0, 944, 611);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
