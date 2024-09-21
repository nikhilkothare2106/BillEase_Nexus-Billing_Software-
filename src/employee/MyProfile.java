package employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import userdefined.RoundedLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import userdefined.RoundedButton;
import javax.swing.JRadioButton;

public class MyProfile {

	private JFrame frame;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyProfile window = new MyProfile();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MyProfile() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
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
		
		JLabel lblNewLabel_5_1 = new JLabel("Nikhil");
		lblNewLabel_5_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_5_1.setFont(new Font("Cooper Black", Font.BOLD, 24));
		lblNewLabel_5_1.setBounds(182, 27, 99, 47);
		panel.add(lblNewLabel_5_1);
		
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
		panel_5.setBounds(532, 61, 327, 457);
		panel_6.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(46, 79, 79));
		
		JLabel lblSelectGender = new JLabel("Select Gender");
		lblSelectGender.setForeground(Color.WHITE);
		lblSelectGender.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblSelectGender.setBounds(25, 224, 214, 25);
		panel_5.add(lblSelectGender);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Serif", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setCaretColor(Color.WHITE);
		textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textField_2.setBackground(new Color(15, 164, 149));
		textField_2.setBounds(25, 179, 281, 25);
		panel_5.add(textField_2);
		
		RoundedButton btn_update = new RoundedButton("", 20, Color.WHITE);
		btn_update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_update.setText("Update");
		btn_update.setForeground(Color.WHITE);
		btn_update.setFont(new Font("Rockwell", Font.BOLD, 14));
		btn_update.setFocusPainted(false);
		btn_update.setBackground(new Color(255, 69, 0));
		btn_update.setBounds(109, 372, 113, 40);
		panel_5.add(btn_update);
		
		JLabel namelabel = new JLabel("Email");
		namelabel.setForeground(Color.WHITE);
		namelabel.setFont(new Font("Rockwell", Font.BOLD, 14));
		namelabel.setBounds(27, 158, 214, 25);
		panel_5.add(namelabel);
		
		JLabel lblEnterPhoneNo = new JLabel("Enter Phone No");
		lblEnterPhoneNo.setForeground(Color.WHITE);
		lblEnterPhoneNo.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblEnterPhoneNo.setBounds(28, 287, 214, 25);
		panel_5.add(lblEnterPhoneNo);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setFont(new Font("Rockwell", Font.BOLD, 12));
		rdbtnNewRadioButton.setFocusPainted(false);
		rdbtnNewRadioButton.setBackground(new Color(15, 164, 149));
		rdbtnNewRadioButton.setBounds(25, 256, 73, 23);
		panel_5.add(rdbtnNewRadioButton);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Serif", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textField.setBackground(new Color(15, 164, 149));
		textField.setBounds(27, 308, 279, 25);
		panel_5.add(textField);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Rockwell", Font.BOLD, 12));
		rdbtnFemale.setFocusPainted(false);
		rdbtnFemale.setBackground(new Color(15, 164, 149));
		rdbtnFemale.setBounds(100, 256, 81, 23);
		panel_5.add(rdbtnFemale);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Serif", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setCaretColor(Color.WHITE);
		textField_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textField_3.setBackground(new Color(15, 164, 149));
		textField_3.setBounds(25, 117, 281, 25);
		panel_5.add(textField_3);
		
		JLabel idlabel = new JLabel("Name");
		idlabel.setForeground(Color.WHITE);
		idlabel.setFont(new Font("Rockwell", Font.BOLD, 14));
		idlabel.setBounds(25, 95, 214, 25);
		panel_5.add(idlabel);
		
		JLabel labletext = new JLabel("Profile");
		labletext.setForeground(Color.WHITE);
		labletext.setFont(new Font("Rockwell", Font.BOLD, 26));
		labletext.setBounds(118, 21, 94, 63);
		panel_5.add(labletext);
		
		RoundedLabel lblNewLabel_2_1 = new RoundedLabel("", 30, new Color(15, 164, 149), Color.BLACK, 1);
		lblNewLabel_2_1.setBounds(0, 0, 327, 457);
		panel_5.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(-532, -54, 958, 579);
		panel_5.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setIconTextGap(3);
		lblNewLabel_1_1.setBackground(Color.WHITE);
	}
}
