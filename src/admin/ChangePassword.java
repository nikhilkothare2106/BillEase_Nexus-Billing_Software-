package admin;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.border.LineBorder;
import userdefined.*;
import validation.RegValidation;

import javax.swing.border.MatteBorder;

import billingSoftware.LoginPage;
import dbconnection.DbOperations;

public class ChangePassword {

	private JFrame frame = new JFrame();
	private JPasswordField confirmpwd;
	private RoundedButton btn_change;
	private JPasswordField newpwd;
	private JPasswordField oldpwd;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword window = new ChangePassword();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ChangePassword() {
		initialize();
		frame.setVisible(true);
	}


	private void initialize() {
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
		
		JLabel lblNewLabel_10 = new JLabel("Change Password");
		lblNewLabel_10.setForeground(new Color(0, 0, 0));
		lblNewLabel_10.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_10.setBounds(73, 358, 142, 57);
		lblNewLabel_10.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_10);
		
		JLabel lblNewLabel_5_1_1_2 = new JLabel("");
		lblNewLabel_5_1_1_2.setIcon(new ImageIcon(ChangePassword.class.getResource("/images/edititem.png")));
		lblNewLabel_5_1_1_2.setBounds(10, 274, 53, 57);
		lblNewLabel_5_1_1_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1_2);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1.setIcon(new ImageIcon(ChangePassword.class.getResource("/images/edit.png")));
		lblNewLabel_5_1_1.setBounds(20, 93, 53, 57);
		lblNewLabel_5_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_3_1 = new JLabel("Add items");
		lblNewLabel_5_3_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_5_3_1.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_5_3_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_5_3_1.setBounds(73, 176, 92, 57);
		panel_4.add(lblNewLabel_5_3_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("");
		lblNewLabel_5_1_1_1.setIcon(new ImageIcon(ChangePassword.class.getResource("/images/additem.png")));
		lblNewLabel_5_1_1_1.setBounds(20, 176, 53, 57);
		lblNewLabel_5_1_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabel_5_1_1_2_1 = new JLabel("");
		lblNewLabel_5_1_1_2_1.setIcon(new ImageIcon(ChangePassword.class.getResource("/images/changepassword.png")));
		lblNewLabel_5_1_1_2_1.setBounds(16, 358, 57, 57);
		lblNewLabel_5_1_1_2_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1_2_1);
		
		JLabel lblNewLabel_5_3 = new JLabel("View/Edit Employee");
		lblNewLabel_5_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_5_3.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_5_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_5_3.setBounds(73, 93, 142, 57);
		panel_4.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5 = new JLabel("View/Edit items");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_5.setBounds(73, 266, 125, 57);
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
		lblNewLabel_8_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_8_4.setBounds(10, 358, 208, 57);
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
		lblNewLabel_6.setBounds(73, 11, 142, 57);
		lblNewLabel_6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(ChangePassword.class.getResource("/images/register.png")));
		lblNewLabel_5_1.setBounds(20, 11, 53, 57);
		lblNewLabel_5_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1);
		
		RoundedLabel lblNewLabel_8 = new RoundedLabel("", 30, new Color(240,240,240), Color.BLACK, 2);
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RegisterEmployee();
				frame.setVisible(false);
			}
		});
		lblNewLabel_8.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_8.setBounds(10, 11, 208, 57);
		panel_4.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_7.setBounds(0, 0, 228, 559);
		panel_4.add(lblNewLabel_7);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 228, 653);
		lblNewLabel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(203, 228, 222));
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
		lblNewLabel_4_1.setIcon(new ImageIcon(ChangePassword.class.getResource("/images/imageedit_7_8214613300.png")));
		lblNewLabel_4_1.setBounds(156, 187, 364, 379);
		panel_2.add(lblNewLabel_4_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(46, 79, 79));
		panel_5.setBounds(623, 42, 346, 516);
		panel_2.add(panel_5);
		
		oldpwd = new JPasswordField();
		oldpwd.setForeground(Color.WHITE);
		oldpwd.setCaretColor(Color.WHITE);
		oldpwd.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		oldpwd.setBackground(new Color(15, 164, 149));
		oldpwd.setBounds(23, 144, 298, 25);
		panel_5.add(oldpwd);
		
		newpwd = new JPasswordField();
		newpwd.setForeground(Color.WHITE);
		newpwd.setCaretColor(Color.WHITE);
		newpwd.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		newpwd.setBackground(new Color(15, 164, 149));
		newpwd.setBounds(23, 207, 298, 25);
		panel_5.add(newpwd);
		
		JLabel newpwdtext = new JLabel("New Password");
		newpwdtext.setForeground(Color.WHITE);
		newpwdtext.setFont(new Font("Rockwell", Font.BOLD, 14));
		newpwdtext.setBounds(23, 186, 214, 25);
		panel_5.add(newpwdtext);
		
		btn_change = new RoundedButton("Register", 20, Color.WHITE);
		btn_change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldpassword = new String(oldpwd.getPassword());
				ResultSet rs = DbOperations.getAdminPassword();
				if(rs != null){
					try{
						rs.next();
						if(!oldpassword.equals(rs.getString("Password"))){
							JOptionPane.showMessageDialog(frame, "Incorrect Password", "Password error", JOptionPane.ERROR_MESSAGE);
						}else{
							String newpassword = new String(newpwd.getPassword());
							String confirmpassword = new String(confirmpwd.getPassword());
							
							if(newpassword.equals("")){
								JOptionPane.showMessageDialog(frame, "Enter password", "Password error", JOptionPane.ERROR_MESSAGE);
							}
							else if(!newpassword.equals(confirmpassword)){
								JOptionPane.showMessageDialog(frame, "Password not matched!", "Password error", JOptionPane.ERROR_MESSAGE);
							}else{
								boolean valid = new RegValidation().passwordValidation(newpassword);
								if(!valid){
									JOptionPane.showMessageDialog(frame, "Invalid password", "Password error", JOptionPane.ERROR_MESSAGE);
								}else{
									changePwd(newpassword);
								}
							}
						}
					}
					catch(Exception e1){
						e1.printStackTrace();;
					}
				}
			}

			private void changePwd(String newpassord) {
				boolean status = DbOperations.changeAdminPassword(newpassord);
				if(status){
					JOptionPane.showMessageDialog(frame, "Password Changes Successfully!");
					oldpwd.setText("");
					newpwd.setText("");
					confirmpwd.setText("");

				}else{
					JOptionPane.showMessageDialog(frame, 
					"Some error occurred", "Password error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn_change.setText("Change");
		btn_change.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_change.setForeground(Color.WHITE);
		btn_change.setFont(new Font("Rockwell", Font.BOLD, 14));
		btn_change.setFocusPainted(false);
		btn_change.setBackground(new Color(255, 69, 0));
		btn_change.setBounds(107, 335, 130, 40);
		panel_5.add(btn_change);
		
		confirmpwd = new JPasswordField();
		confirmpwd.setForeground(Color.WHITE);
		confirmpwd.setCaretColor(Color.WHITE);
		confirmpwd.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		confirmpwd.setBackground(new Color(15, 164, 149));
		confirmpwd.setBounds(23, 276, 298, 25);
		panel_5.add(confirmpwd);
		
		JLabel oldpwdtext = new JLabel("Old Password");
		oldpwdtext.setForeground(Color.WHITE);
		oldpwdtext.setFont(new Font("Rockwell", Font.BOLD, 14));
		oldpwdtext.setBounds(23, 120, 214, 25);
		panel_5.add(oldpwdtext);
		
		JLabel confirmpwdtext = new JLabel("Confirm New Password");
		confirmpwdtext.setForeground(Color.WHITE);
		confirmpwdtext.setFont(new Font("Rockwell", Font.BOLD, 14));
		confirmpwdtext.setBounds(23, 255, 214, 25);
		panel_5.add(confirmpwdtext);
		
		JLabel lblNewLabel_5_2 = new JLabel("Change Password");
		lblNewLabel_5_2.setForeground(Color.WHITE);
		lblNewLabel_5_2.setFont(new Font("Rockwell", Font.BOLD, 26));
		lblNewLabel_5_2.setBounds(49, 21, 256, 63);
		panel_5.add(lblNewLabel_5_2);
		
		RoundedLabel lblNewLabel_2_1 = new RoundedLabel("", 30, new Color(15,164,149), Color.BLACK, 1);
//		lblNewLabel_2_1.setIcon(new ImageIcon(ChangePassword.class.getResource("/images/Untitled3.png")));
		lblNewLabel_2_1.setBounds(0, 0, 346, 516);
		panel_5.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIconTextGap(3);
		lblNewLabel_1_1.setBackground(Color.WHITE);
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
