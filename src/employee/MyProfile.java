package employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

import userdefined.RoundedLabel;
import validation.RegValidation;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import dbconnection.DbOperations;
import gettersetter.GetSetEmployee;
import userdefined.RoundedButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class MyProfile {

	private JFrame frame = new JFrame();
	private JTextField email_label;
	private JTextField name_label;
	private JTextField phone_label;
	private RoundedButton btn_update, btn_cancel;
	private GetSetEmployee employee = new GetSetEmployee();
	private JRadioButton rdbtnFemale,rdbtnMale;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public MyProfile(GetSetEmployee employee) {
		this.employee = employee;
		initialize();
		getDetails();
		frame.setVisible(true);
	}

	private void getDetails(){
		name_label.setText(employee.getName());
		email_label.setText(employee.getEmail());
		phone_label.setText(employee.getPhoneno());
		if(employee.getGender().equals("M")){
			rdbtnMale.setSelected(true);
		}else{
			rdbtnFemale.setSelected(true);
		}
	}
	private void initialize() {
		frame.setBounds(0, 0, 1380, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 79, 79));
		panel.setBounds(0, 0, 1364, 100);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("  Log out");
		lblNewLabel_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_9.setForeground(new Color(0, 0, 240));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_9.setForeground(new Color(240, 0, 0));
			}
		});
		
		JLabel lblNewLabel_5_1_1 = new JLabel("My Profile");
		lblNewLabel_5_1_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_5_1_1.setFont(new Font("Cooper Black", Font.BOLD, 32));
		lblNewLabel_5_1_1.setBounds(655, 24, 201, 47);
		panel.add(lblNewLabel_5_1_1);
		lblNewLabel_9.setForeground(new Color(240, 0, 0));
		lblNewLabel_9.setFont(new Font("Rockwell", Font.BOLD, 22));
		lblNewLabel_9.setBounds(1198, 27, 108, 34);
		panel.add(lblNewLabel_9);
		
		JLabel wel_name_label = new JLabel(employee.getName());
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(159, 217, 217));
		panel_2.setBounds(120, 21, 1136, 630);
		panel_1.add(panel_2);
		
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
		lblNewLabel_4_1.setIcon(new ImageIcon(MyProfile.class.getResource("/images/imageedit_7_8214613300.png")));
		lblNewLabel_4_1.setBounds(156, 187, 364, 379);
		panel_2.add(lblNewLabel_4_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(46, 79, 79));
		panel_6.setBounds(90, 11, 958, 579);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(532, 61, 327, 432);
		panel_6.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(46, 79, 79));
		
		JLabel edit_label = new JLabel("Edit");
		edit_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				edit_label.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				edit_label.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_update.setVisible(true);
				btn_cancel.setVisible(true);
				edit_label.setVisible(false);

				name_label.setEditable(true);
				email_label.setEditable(true);
				phone_label.setEditable(true);
				rdbtnMale.setEnabled(true);
				rdbtnFemale.setEnabled(true);
			}
		});
		
		btn_cancel = new RoundedButton("", 20, Color.WHITE);
		btn_cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				edit_label.setVisible(true);
				btn_update.setVisible(false);
				btn_cancel.setVisible(false);
				getDetails();
				
				name_label.setEditable(false);
				email_label.setEditable(false);
				phone_label.setEditable(false);
				rdbtnMale.setEnabled(false);
				rdbtnFemale.setEnabled(false);
				
			}
		});
		btn_cancel.setText("Cancel");
		btn_cancel.setForeground(Color.WHITE);
		btn_cancel.setFont(new Font("Rockwell", Font.BOLD, 14));
		btn_cancel.setFocusPainted(false);
		btn_cancel.setBackground(new Color(255, 69, 0));
		btn_cancel.setBounds(36, 360, 113, 40);
		panel_5.add(btn_cancel);
		edit_label.setFont(new Font("Rockwell", Font.PLAIN, 18));
		edit_label.setBounds(260, 21, 46, 14);
		btn_cancel.setVisible(false);
		panel_5.add(edit_label);
		
		JLabel lblSelectGender = new JLabel("Select Gender");
		lblSelectGender.setForeground(Color.WHITE);
		lblSelectGender.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblSelectGender.setBounds(25, 228, 214, 25);
		panel_5.add(lblSelectGender);
		
		email_label = new JTextField();
		email_label.setEditable(false);
		email_label.setForeground(Color.WHITE);
		email_label.setFont(new Font("Serif", Font.BOLD, 14));
		email_label.setColumns(10);
		email_label.setCaretColor(Color.WHITE);
		email_label.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		email_label.setBackground(new Color(15, 164, 149));
		email_label.setBounds(25, 183, 281, 25);
		panel_5.add(email_label);
		
		btn_update = new RoundedButton("", 20, Color.WHITE);
		btn_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = name_label.getText();
				String email = email_label.getText();
				String phone = phone_label.getText();
				String gender;
				if(rdbtnMale.isSelected()){
					gender = "M";
				}else{
					gender = "F";
				}

				RegValidation validate = new RegValidation();
				if(!validate.nameValidation(name)){
					JOptionPane.showMessageDialog(frame, "Invalid name", "Name error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!validate.emailValidation(email)){
					JOptionPane.showMessageDialog(frame, "Invalid email", "Email error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!validate.phonenoValidation(phone)){
					JOptionPane.showMessageDialog(frame, "Invalid Phone No", "Phone No error", JOptionPane.ERROR_MESSAGE);
				}else{
					GetSetEmployee emp = new GetSetEmployee();
					emp.setName(name);
					emp.setEmail(email);
					emp.setGender(gender);
					emp.setPhoneno(phone);

					boolean status = DbOperations.updateProfile(emp,employee.getEmail());

					if(status){
						JOptionPane.showMessageDialog(frame, "Details Updated Successfully!");

						employee.setName(name);
						employee.setEmail(email);
						employee.setGender(gender);
						employee.setPhoneno(phone);

					}else{
						JOptionPane.showMessageDialog(frame, "Error Occurred!", "Update error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btn_update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_update.setText("Update");
		btn_update.setForeground(Color.WHITE);
		btn_update.setFont(new Font("Rockwell", Font.BOLD, 14));
		btn_update.setFocusPainted(false);
		btn_update.setBackground(new Color(255, 69, 0));
		btn_update.setBounds(168, 360, 113, 40);
		btn_update.setVisible(false);
		panel_5.add(btn_update);
		
		JLabel namelabel = new JLabel("Email");
		namelabel.setForeground(Color.WHITE);
		namelabel.setFont(new Font("Rockwell", Font.BOLD, 14));
		namelabel.setBounds(27, 162, 214, 25);
		panel_5.add(namelabel);
		
		JLabel lblEnterPhoneNo = new JLabel("Enter Phone No");
		lblEnterPhoneNo.setForeground(Color.WHITE);
		lblEnterPhoneNo.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblEnterPhoneNo.setBounds(28, 291, 214, 25);
		panel_5.add(lblEnterPhoneNo);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setEnabled(false);
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Rockwell", Font.BOLD, 12));
		rdbtnMale.setFocusPainted(false);
		rdbtnMale.setBackground(new Color(15, 164, 149));
		rdbtnMale.setBounds(25, 260, 73, 23);
		panel_5.add(rdbtnMale);
		
		phone_label = new JTextField();
		phone_label.setEditable(false);
		phone_label.setForeground(Color.WHITE);
		phone_label.setFont(new Font("Serif", Font.BOLD, 14));
		phone_label.setColumns(10);
		phone_label.setCaretColor(Color.WHITE);
		phone_label.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		phone_label.setBackground(new Color(15, 164, 149));
		phone_label.setBounds(27, 312, 279, 25);
		panel_5.add(phone_label);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setEnabled(false);
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Rockwell", Font.BOLD, 12));
		rdbtnFemale.setFocusPainted(false);
		rdbtnFemale.setBackground(new Color(15, 164, 149));
		rdbtnFemale.setBounds(100, 260, 81, 23);
		panel_5.add(rdbtnFemale);
		
		name_label = new JTextField();
		name_label.setEditable(false);
		name_label.setForeground(Color.WHITE);
		name_label.setFont(new Font("Serif", Font.BOLD, 14));
		name_label.setColumns(10);
		name_label.setCaretColor(Color.WHITE);
		name_label.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		name_label.setBackground(new Color(15, 164, 149));
		name_label.setBounds(25, 121, 281, 25);
		panel_5.add(name_label);
		
		JLabel idlabel = new JLabel("Name");
		idlabel.setForeground(Color.WHITE);
		idlabel.setFont(new Font("Rockwell", Font.BOLD, 14));
		idlabel.setBounds(25, 99, 214, 25);
		panel_5.add(idlabel);
		
		JLabel labletext = new JLabel("Profile");
		labletext.setForeground(Color.WHITE);
		labletext.setFont(new Font("Rockwell", Font.BOLD, 26));
		labletext.setBounds(118, 37, 94, 51);
		panel_5.add(labletext);
		
		RoundedLabel lblNewLabel_2_1 = new RoundedLabel("", 30, new Color(15, 164, 149), Color.BLACK, 1);
		lblNewLabel_2_1.setBounds(0, 0, 327, 431);
		panel_5.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(-532, -61, 958, 580);
		panel_5.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setIconTextGap(3);
		lblNewLabel_1_1.setBackground(Color.WHITE);
	}
}
