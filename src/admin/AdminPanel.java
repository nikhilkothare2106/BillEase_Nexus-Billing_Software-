package admin;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import userdefined.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;

public class AdminPanel {

	private JFrame frame = new JFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
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
	public AdminPanel() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(0, 0, 1380, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(228, 0, 1136, 101);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("  Log out");
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
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/Untitled4.png")));
		lblNewLabel.setBounds(0, 0, 1204, 101);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 102, 228, 638);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 28, 228, 559);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Change Password");
		lblNewLabel_10.setForeground(new Color(47, 79, 79));
		lblNewLabel_10.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_10.setBounds(66, 358, 142, 57);
		lblNewLabel_10.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_10);
		
		JLabel lblNewLabel_5_1_1_2 = new JLabel("");
		lblNewLabel_5_1_1_2.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\edititem.png"));
		lblNewLabel_5_1_1_2.setBounds(0, 274, 53, 57);
		lblNewLabel_5_1_1_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1_2);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\edit.png"));
		lblNewLabel_5_1_1.setBounds(10, 93, 53, 57);
		lblNewLabel_5_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_3_1 = new JLabel("Add items");
		lblNewLabel_5_3_1.setForeground(new Color(47, 79, 79));
		lblNewLabel_5_3_1.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_5_3_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_5_3_1.setBounds(66, 176, 142, 57);
		panel_4.add(lblNewLabel_5_3_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("");
		lblNewLabel_5_1_1_1.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\additem.png"));
		lblNewLabel_5_1_1_1.setBounds(10, 176, 53, 57);
		lblNewLabel_5_1_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabel_5_1_1_2_1 = new JLabel("");
		lblNewLabel_5_1_1_2_1.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\changepassword.png"));
		lblNewLabel_5_1_1_2_1.setBounds(6, 358, 57, 57);
		lblNewLabel_5_1_1_2_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1_2_1);
		
		JLabel lblNewLabel_5_3 = new JLabel("View/Edit Employee");
		lblNewLabel_5_3.setForeground(new Color(47, 79, 79));
		lblNewLabel_5_3.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_5_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_5_3.setBounds(66, 93, 142, 57);
		panel_4.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5 = new JLabel("View/Edit items");
		lblNewLabel_5.setForeground(new Color(47, 79, 79));
		lblNewLabel_5.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_5.setBounds(66, 266, 142, 57);
		panel_4.add(lblNewLabel_5);
		
		JLabel lblNewLabel_8_3 = new JLabel("New label");
		lblNewLabel_8_3.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\Untitled.png"));
		lblNewLabel_8_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_3.setBounds(0, 266, 228, 57);
		lblNewLabel_8_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_8_3);
		
		JLabel lblNewLabel_8_1 = new JLabel("New label");
		lblNewLabel_8_1.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\Untitled.png"));
		lblNewLabel_8_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_8_1.setBounds(0, 93, 228, 57);
		panel_4.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_4 = new JLabel("New label");
		lblNewLabel_8_4.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\Untitled.png"));
		lblNewLabel_8_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_8_4.setBounds(0, 358, 228, 57);
		panel_4.add(lblNewLabel_8_4);
		
		JLabel lblNewLabel_8_2 = new JLabel("New label");
		lblNewLabel_8_2.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\Untitled.png"));
		lblNewLabel_8_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_8_2.setBounds(0, 176, 228, 57);
		panel_4.add(lblNewLabel_8_2);
		
		JLabel lblNewLabel_6 = new JLabel("Register Employee");
		lblNewLabel_6.setForeground(new Color(47, 79, 79));
		lblNewLabel_6.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_6.setBounds(66, 11, 142, 57);
		lblNewLabel_6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\register.png"));
		lblNewLabel_5_1.setBounds(10, 11, 53, 57);
		lblNewLabel_5_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RegisterEmployee();
				frame.setVisible(false);
			}
		});
		lblNewLabel_8.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\Untitled.png"));
		lblNewLabel_8.setBounds(0, 11, 228, 57);
		panel_4.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\Untitled.png"));
		lblNewLabel_7.setBounds(0, 0, 228, 559);
		panel_4.add(lblNewLabel_7);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 228, 741);
		lblNewLabel_2.setBorder(new MatteBorder(1, 1, 1, 2, (Color) new Color(0, 0, 0)));
		lblNewLabel_2.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/Untitled.png")));
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(228, 102, 1136, 644);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Welcome Admin to BillEase Nexus");
		lblNewLabel_11.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		lblNewLabel_11.setBounds(314, 11, 457, 134);
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/Untitled1.png")));
		lblNewLabel_3.setBounds(0, 0, 1136, 638);
		panel_2.add(lblNewLabel_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBounds(0, 0, 228, 101);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(51, 0, 112, 101);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/admin.png")));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\Untitled.png"));
		lblNewLabel_4.setBounds(0, 0, 228, 101);
		panel_3.add(lblNewLabel_4);
		lblNewLabel_4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		;
	}
}
