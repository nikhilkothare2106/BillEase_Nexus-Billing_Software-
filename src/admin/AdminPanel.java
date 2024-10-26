package admin;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import billingSoftware.LoginPage;
import userdefined.RoundedLabel;

public class AdminPanel {

	private JFrame frame = new JFrame();

	public AdminPanel() {
		initialize();
		frame.setVisible(true);
	}


	private void initialize() {
		frame.setTitle("Admin Panel");
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
		lblNewLabel_3_1.setBounds(326, 11, 428, 67);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new LineBorder(new Color(15, 191, 169)));
		lblNewLabel.setBackground(new Color(72, 201, 176));
		lblNewLabel.setBounds(0, 0, 1204, 101);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(46, 79, 79));
		panel_1.setBounds(0, 101, 228, 638);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(46, 79, 79));
		panel_4.setBounds(0, 28, 228, 599);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_10_1 = new JLabel("Shopping History");
		lblNewLabel_10_1.setForeground(Color.BLACK);
		lblNewLabel_10_1.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_10_1.setBounds(76, 359, 127, 57);
		panel_4.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_5_1_1_2_1_1 = new JLabel("");
		
		lblNewLabel_5_1_1_2_1_1.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\shopping_history.png"));
		lblNewLabel_5_1_1_2_1_1.setBounds(20, 362, 53, 57);
		panel_4.add(lblNewLabel_5_1_1_2_1_1);
		
		RoundedLabel lblNewLabel_8_4_1 = new RoundedLabel("", 30, UIManager.getColor("Button.background"), Color.BLACK, 2);
		lblNewLabel_8_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ShoppingHistory();
				frame.setVisible(false);
			}
		});
		lblNewLabel_8_4_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblNewLabel_8_4_1.setBounds(10, 359, 208, 57);
		panel_4.add(lblNewLabel_8_4_1);
		
		JLabel lblNewLabel_6 = new JLabel("Register Employee");
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_6.setBounds(76, 11, 142, 57);
		lblNewLabel_6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_6);
		
		JLabel lblNewLabel_10 = new JLabel("Change Password");
		lblNewLabel_10.setForeground(new Color(0, 0, 0));
		lblNewLabel_10.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_10.setBounds(76, 453, 142, 57);
		lblNewLabel_10.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_10);
		
		JLabel lblNewLabel_5_1_1_2 = new JLabel("");
		lblNewLabel_5_1_1_2.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/edititem.png")));
		lblNewLabel_5_1_1_2.setBounds(10, 270, 53, 62);
		lblNewLabel_5_1_1_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1_2);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/edit.png")));
		lblNewLabel_5_1_1.setBounds(20, 94, 53, 57);
		lblNewLabel_5_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_3_1 = new JLabel("Add items");
		lblNewLabel_5_3_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_5_3_1.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_5_3_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_5_3_1.setBounds(76, 175, 142, 57);
		panel_4.add(lblNewLabel_5_3_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("");
		lblNewLabel_5_1_1_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/additem.png")));
		lblNewLabel_5_1_1_1.setBounds(18, 175, 53, 57);
		lblNewLabel_5_1_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabel_5_1_1_2_1 = new JLabel("");
		lblNewLabel_5_1_1_2_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/changepassword.png")));
		lblNewLabel_5_1_1_2_1.setBounds(22, 453, 50, 57);
		lblNewLabel_5_1_1_2_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1_2_1);
		
		JLabel lblNewLabel_5_3 = new JLabel("View/Edit Employee");
		lblNewLabel_5_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_5_3.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_5_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_5_3.setBounds(67, 94, 142, 57);
		panel_4.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5 = new JLabel("View/Edit items");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_5.setBounds(76, 266, 142, 57);
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
				frame.setVisible(false);
			}
		});
		lblNewLabel_8_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_8_1.setBounds(10, 93, 208, 57);
		panel_4.add(lblNewLabel_8_1);
		
		RoundedLabel lblNewLabel_8_4 = new RoundedLabel("", 30, new Color(240,240,240), Color.BLACK, 2);
		lblNewLabel_8_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ChangePasswordAdmin();
				frame.setVisible(false);
			}
		});
		lblNewLabel_8_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_8_4.setBounds(10, 453, 208, 57);
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
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/register.png")));
		lblNewLabel_5_1.setBounds(22, 11, 53, 57);
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
		lblNewLabel_2.setBounds(0, 0, 228, 660);
		lblNewLabel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(203, 228, 222));
		panel_2.setBounds(228, 101, 1136, 644);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Welcome Admin to BillEase Nexus");
		lblNewLabel_11.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		lblNewLabel_11.setBounds(314, 11, 457, 134);
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(203, 228, 222));
		lblNewLabel_3.setBorder(new LineBorder(new Color(46, 79, 79)));
//		lblNewLabel_3.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/Untitled1.png")));
		lblNewLabel_3.setBounds(0, 0, 1136, 638);
		panel_2.add(lblNewLabel_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(46, 79, 79));
		panel_3.setBorder(null);
		panel_3.setBounds(0, 0, 228, 101);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setBounds(51, 0, 112, 101);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/admin.png")));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, 0, 228, 101);
		panel_3.add(lblNewLabel_4);
		lblNewLabel_4.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		;
	}
}
