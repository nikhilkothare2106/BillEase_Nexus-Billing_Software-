package admin;
import userdefined.RoundedBorder;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import userdefined.*;
public class RegisterEmployee{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtEnterName;
	private JPasswordField pwdEnterPassword;
	private JLabel lblNewLabel;
	private JLabel lblUserPassword;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 950, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(523, 31, 364, 548);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnNewButton_1 = new RoundedButton("Register",20,Color.WHITE);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_1.setBackground(new Color(255,0,0));
//				btnNewButton_1 = new RoundedButton("Register",30,Color.GREEN);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setFont(new Font("Rockwell", Font.BOLD, 15));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setFont(new Font("Rockwell", Font.BOLD, 14));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton_1.setBackground(new Color(36, 156, 196));
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Rockwell", Font.BOLD, 14));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorder(new RoundedBorder(20));
		btnNewButton_1.setBackground(new Color(36, 156, 196));
		btnNewButton_1.setBounds(106, 437, 141, 40);
		panel.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		passwordField.setBackground(new Color(15, 164, 149));
		passwordField.setBounds(31, 361, 298, 25);
		panel.add(passwordField);
		
		JLabel lblEnterPhoneNo = new JLabel("Enter Phone No");
		lblEnterPhoneNo.setForeground(Color.WHITE);
		lblEnterPhoneNo.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblEnterPhoneNo.setBounds(31, 336, 214, 25);
		panel.add(lblEnterPhoneNo);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Rockwell", Font.BOLD, 12));
		rdbtnFemale.setFocusPainted(false);
		rdbtnFemale.setBackground(new Color(15, 164, 149));
		rdbtnFemale.setBounds(106, 298, 81, 23);
		panel.add(rdbtnFemale);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Rockwell", Font.BOLD, 12));
		rdbtnNewRadioButton.setFocusPainted(false);
		rdbtnNewRadioButton.setBackground(new Color(15, 164, 149));
		rdbtnNewRadioButton.setBounds(31, 298, 73, 23);
		panel.add(rdbtnNewRadioButton);
		
		JLabel lblSelectGender = new JLabel("Select Gender");
		lblSelectGender.setForeground(Color.WHITE);
		lblSelectGender.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblSelectGender.setBounds(31, 270, 214, 25);
		panel.add(lblSelectGender);
		
		txtEnterName = new JTextField();
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
		pwdEnterPassword.setBounds(31, 219, 298, 25);
		panel.add(pwdEnterPassword);
		
		lblNewLabel = new JLabel("Enter Name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel.setBounds(31, 118, 214, 25);
		panel.add(lblNewLabel);
		
		lblUserPassword = new JLabel("Enter Password");
		lblUserPassword.setForeground(new Color(255, 255, 255));
		lblUserPassword.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblUserPassword.setBounds(31, 194, 214, 25);
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
		
		lblNewLabel_1 = new JLabel("Billing Software");
		lblNewLabel_1.setIconTextGap(3);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\Untitled.png"));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(0, 0, 944, 611);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
