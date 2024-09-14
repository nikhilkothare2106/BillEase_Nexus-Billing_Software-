package billingSoftware;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;

import userdefined.*;
import dbconnection.*;
import admin.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class LoginPage {

	private JFrame frame = new JFrame();
	private JTextField txtEnterName;
	private JPasswordField pwdEnterPassword;
	private JLabel lblNewLabel;
	private JLabel lblUserPassword;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;


	public LoginPage() {
		initialize();
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new LoginPage());
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(0, 0, 950, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);		
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Nexus");
		lblNewLabel_3_1_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_3_1_1.setFont(new Font("Cooper Black", Font.BOLD, 54));
		lblNewLabel_3_1_1.setBounds(154, 122, 225, 67);
		frame.getContentPane().add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("BillEase");
		lblNewLabel_3_2.setForeground(new Color(255, 255, 224));
		lblNewLabel_3_2.setFont(new Font("Cooper Black", Font.BOLD, 54));
		lblNewLabel_3_2.setBounds(134, 61, 259, 67);
		frame.getContentPane().add(lblNewLabel_3_2);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(523, 31, 364, 548);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtEnterName = new JTextField();
		txtEnterName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pwdEnterPassword.requestFocus();
			}
		});
		txtEnterName.setCaretColor(new Color(255, 255, 255));
		txtEnterName.setForeground(new Color(255, 255, 255));
	
		txtEnterName.setFont(new Font("Serif", Font.BOLD, 14));
		txtEnterName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		txtEnterName.setBackground(new Color(15, 164, 149));
		txtEnterName.setBounds(28, 214, 298, 25);
		panel.add(txtEnterName);
		txtEnterName.setColumns(10);
		
		pwdEnterPassword = new JPasswordField();
		pwdEnterPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.doClick();
			}
		});
		pwdEnterPassword.setCaretColor(new Color(255, 255, 255));
		pwdEnterPassword.setForeground(new Color(255, 255, 255));
		pwdEnterPassword.setBackground(new Color(15, 164, 149));
		pwdEnterPassword.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		pwdEnterPassword.setBounds(28, 293, 298, 25);
		panel.add(pwdEnterPassword);
		
		lblNewLabel = new JLabel("Enter email");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 192, 79, 25);
		panel.add(lblNewLabel);
		
		lblUserPassword = new JLabel("Enter Password");
		lblUserPassword.setForeground(new Color(255, 255, 255));
		lblUserPassword.setFont(new Font("Rockwell", Font.PLAIN, 14));
		lblUserPassword.setBounds(28, 268, 106, 25);
		panel.add(lblUserPassword);
		
		JLabel lblNewLabel_5 = new JLabel("Login Page");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Rockwell", Font.BOLD, 25));
		lblNewLabel_5.setBounds(102, 73, 158, 63);
		panel.add(lblNewLabel_5);
		
		btnNewButton = new RoundedButton("Log in",20, Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = txtEnterName.getText();
				String password = String.valueOf(pwdEnterPassword.getPassword());

				boolean login_status = DbOperations.login(email, password);
				if(login_status){
					new AdminPanel();
				}else{
					JOptionPane.showMessageDialog(frame, "Email id and password didnt matched", "Login Error", JOptionPane.ERROR_MESSAGE);
					txtEnterName.setText("");
					pwdEnterPassword.setText("");
					
				}
			}
		});
		btnNewButton.setFont(new Font("Rockwell", Font.BOLD, 14));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(255,69,0));
		btnNewButton.setBounds(126, 371, 106, 36);
		panel.add(btnNewButton);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton.setBackground(new Color(255, 99, 71));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setFont(new Font("Rockwell", Font.BOLD, 15));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setFont(new Font("Rockwell", Font.BOLD, 14));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton.setBackground(new Color(255,69,0));
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\Untitled3.png"));
		lblNewLabel_2.setBounds(0, 0, 381, 548);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\imageedit_7_8214613300.png"));
		lblNewLabel_4.setBounds(75, 200, 364, 379);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_1 = new JLabel("Billing Software");
		lblNewLabel_1.setIconTextGap(3);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\Untitled.png"));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(0, 0, 944, 611);
		frame.getContentPane().add(lblNewLabel_1);
		
	}
}
