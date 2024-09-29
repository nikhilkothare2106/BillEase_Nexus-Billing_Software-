package employee;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

import dbconnection.DbOperations;
import gettersetter.GetSetEmployee;
import userdefined.RoundedButton;
import userdefined.RoundedLabel;
import validation.RegValidation;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangePasswordEmployee {

	private JFrame frame = new JFrame();
	private JPasswordField old_pwd;
	private JPasswordField new_pwd;
	private JPasswordField confirm_pwd;
	private GetSetEmployee employee = new GetSetEmployee();

	public ChangePasswordEmployee(GetSetEmployee employee) {
		this.employee = employee;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame.setTitle("Change Password");
		frame.setBounds(0, 0, 1380, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(46, 79, 79));
		panel.setBounds(0, 0, 1364, 100);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Change Password");
		lblNewLabel_5_1_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_5_1_1.setFont(new Font("Cooper Black", Font.BOLD, 32));
		lblNewLabel_5_1_1.setBounds(655, 24, 347, 47);
		panel.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_9 = new JLabel("Back");
		lblNewLabel_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EmployeePanel(employee);
				frame.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_9.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_9.setForeground(Color.RED);
			}
		});
		lblNewLabel_9.setForeground(new Color(240, 0, 0));
		lblNewLabel_9.setFont(new Font("Rockwell", Font.BOLD, 22));
		lblNewLabel_9.setBounds(1247, 30, 65, 34);
		panel.add(lblNewLabel_9);
		
		JLabel wel_name_label = new JLabel((String) null);
		wel_name_label.setText(employee.getName());
		wel_name_label.setForeground(new Color(255, 255, 224));
		wel_name_label.setFont(new Font("Cooper Black", Font.BOLD, 24));
		wel_name_label.setBounds(182, 27, 201, 47);
		panel.add(wel_name_label);
		
		JLabel lblNewLabel_5 = new JLabel("Welcome");
		lblNewLabel_5.setForeground(new Color(255, 255, 224));
		lblNewLabel_5.setFont(new Font("Cooper Black", Font.BOLD, 24));
		lblNewLabel_5.setBounds(57, 27, 121, 47);
		panel.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(159, 217, 217));
		panel_1.setBounds(0, 100, 1364, 641);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3_2 = new JLabel("BillEase");
		lblNewLabel_3_2.setForeground(new Color(255, 255, 224));
		lblNewLabel_3_2.setFont(new Font("Cooper Black", Font.BOLD, 54));
		lblNewLabel_3_2.setBounds(402, 63, 259, 67);
		panel_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Nexus");
		lblNewLabel_3_1_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_3_1_1.setFont(new Font("Cooper Black", Font.BOLD, 54));
		lblNewLabel_3_1_1.setBounds(427, 119, 225, 67);
		panel_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(ChangePasswordEmployee.class.getResource("/images/imageedit_7_8214613300.png")));
		lblNewLabel_4_1.setBounds(334, 187, 364, 379);
		panel_1.add(lblNewLabel_4_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(46, 79, 79));
		panel_5.setBounds(801, 67, 335, 456);
		panel_1.add(panel_5);
		
		old_pwd = new JPasswordField();
		old_pwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new_pwd.requestFocus();
			}
		});
		old_pwd.setForeground(Color.WHITE);
		old_pwd.setCaretColor(Color.WHITE);
		old_pwd.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		old_pwd.setBackground(new Color(15, 164, 149));
		old_pwd.setBounds(23, 144, 291, 25);
		panel_5.add(old_pwd);
		
		new_pwd = new JPasswordField();
		new_pwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirm_pwd.requestFocus();
			}
		});
		new_pwd.setForeground(Color.WHITE);
		new_pwd.setCaretColor(Color.WHITE);
		new_pwd.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		new_pwd.setBackground(new Color(15, 164, 149));
		new_pwd.setBounds(23, 207, 291, 25);
		panel_5.add(new_pwd);
		
		JLabel newpwdtext = new JLabel("New Password");
		newpwdtext.setForeground(Color.WHITE);
		newpwdtext.setFont(new Font("Rockwell", Font.BOLD, 14));
		newpwdtext.setBounds(23, 186, 214, 25);
		panel_5.add(newpwdtext);
		
		RoundedButton btn_change = new RoundedButton("Register", 20, Color.WHITE);
		btn_change.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String old_password = new String(old_pwd.getPassword());
				String new_password = new String(new_pwd.getPassword());
				String confirm_password = new String(confirm_pwd.getPassword());

				ResultSet rs = DbOperations.getEmployeePassword(employee.getEmail());

				if(rs != null){
					try{
						rs.next();
						if(!old_password.equals(rs.getString("Password"))){
							JOptionPane.showMessageDialog(frame, "Wrong Password", "Password error", JOptionPane.ERROR_MESSAGE);
						}
						else if(new_password.equals("")){
							JOptionPane.showMessageDialog(frame, "Enter password", "Password error", JOptionPane.ERROR_MESSAGE);
						}
						else if(!new_password.equals(confirm_password)){
							JOptionPane.showMessageDialog(frame, "Password not matched!", "Password error", JOptionPane.ERROR_MESSAGE);
						}else{
							boolean valid = new RegValidation().passwordValidation(new_password);

							if(!valid){
								JOptionPane.showMessageDialog(frame, "Invalid password", "Password error", JOptionPane.ERROR_MESSAGE);
							}else{
								changePwd(new_password,employee.getEmail());
							}
						}
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(frame, "Wrong Password", "Password error", JOptionPane.ERROR_MESSAGE);
				}
			}

			private void changePwd(String new_password,String email) {
				boolean status = DbOperations.changeEmployeePassword(new_password,email);
				if(status){
					JOptionPane.showMessageDialog(frame, "Password Changes Successfully!");
					old_pwd.setText("");
					new_pwd.setText("");
					confirm_pwd.setText("");
					employee.setPassword(new_password);
				}else{
					JOptionPane.showMessageDialog(frame, 
					"Some error occurred", "Password error", JOptionPane.ERROR_MESSAGE);
				}
			}

			
		});
		btn_change.setText("Change");
		btn_change.setForeground(Color.WHITE);
		btn_change.setFont(new Font("Rockwell", Font.BOLD, 14));
		btn_change.setFocusPainted(false);
		btn_change.setBackground(new Color(255, 69, 0));
		btn_change.setBounds(94, 340, 130, 40);
		panel_5.add(btn_change);
		
		confirm_pwd = new JPasswordField();
		confirm_pwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_change.doClick();;
			}
		});
		confirm_pwd.setForeground(Color.WHITE);
		confirm_pwd.setCaretColor(Color.WHITE);
		confirm_pwd.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		confirm_pwd.setBackground(new Color(15, 164, 149));
		confirm_pwd.setBounds(23, 276, 291, 25);
		panel_5.add(confirm_pwd);
		
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
		
		RoundedLabel lblNewLabel_2_1 = new RoundedLabel("", 30, new Color(15, 164, 149), Color.BLACK, 1);
		lblNewLabel_2_1.setBounds(0, 0, 336, 459);
		panel_5.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIconTextGap(3);
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(268, 11, 958, 579);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(46, 79, 79));
		panel_2.setBounds(268, 11, 958, 579);
		panel_1.add(panel_2);
	}
}
