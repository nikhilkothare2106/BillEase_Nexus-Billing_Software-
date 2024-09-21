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

public class EmployeePanel {

	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeePanel window = new EmployeePanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EmployeePanel() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 79, 79));
		panel.setBounds(0, 0, 984, 100);
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
		});
		
		JLabel lblNewLabel_5_1_1 = new JLabel("DashBoard");
		lblNewLabel_5_1_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_5_1_1.setFont(new Font("Cooper Black", Font.BOLD, 30));
		lblNewLabel_5_1_1.setBounds(460, 27, 201, 47);
		panel.add(lblNewLabel_5_1_1);
		lblNewLabel_9.setForeground(new Color(240, 0, 0));
		lblNewLabel_9.setFont(new Font("Rockwell", Font.BOLD, 22));
		lblNewLabel_9.setBounds(847, 31, 108, 34);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_5_1 = new JLabel("Nikhil");
		lblNewLabel_5_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_5_1.setFont(new Font("Cooper Black", Font.BOLD, 24));
		lblNewLabel_5_1.setBounds(182, 30, 99, 47);
		panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5 = new JLabel("Welcome");
		lblNewLabel_5.setForeground(new Color(255, 255, 224));
		lblNewLabel_5.setFont(new Font("Cooper Black", Font.BOLD, 24));
		lblNewLabel_5.setBounds(57, 27, 121, 47);
		panel.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(159, 217, 217));
		panel_1.setBounds(0, 100, 984, 461);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(159, 217, 217));
		panel_2.setBounds(260, 29, 494, 388);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.setBorder(null);
		panel_3.setBounds(56, 32, 135, 138);
		panel_2.add(panel_3);
		panel_3.setBackground(new Color(159, 217, 217));
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("My Profile");
		lblNewLabel_3.setBounds(21, 78, 104, 49);
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Rockwell", Font.BOLD, 18));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(EmployeePanel.class.getResource("/images/my-profilee.png")));
		lblNewLabel_2.setBounds(31, 18, 68, 60);
		panel_3.add(lblNewLabel_2);
		
		RoundedLabel lblNewLabel_1 = new RoundedLabel("", 30, new Color(72,201,176), Color.BLACK, 2);
		lblNewLabel_1.setBounds(0, 0, 135, 138);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(null);
		panel_3_1.setBackground(new Color(159, 217, 217));
		panel_3_1.setBounds(285, 32, 135, 138);
		panel_2.add(panel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("Employee");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblNewLabel_4.setBounds(25, 92, 81, 20);
		panel_3_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("View All");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(32, 66, 68, 29);
		panel_3_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(EmployeePanel.class.getResource("/images/allemployee.png")));
		lblNewLabel_2_1.setBounds(34, 11, 68, 60);
		panel_3_1.add(lblNewLabel_2_1);
		
		RoundedLabel lblNewLabel_1_1 = new RoundedLabel("", 30, new Color(72, 201, 176), Color.BLACK, 2);
		lblNewLabel_1_1.setBounds(0, 0, 135, 138);
		panel_3_1.add(lblNewLabel_1_1);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBorder(null);
		panel_3_1_1.setBackground(new Color(159, 217, 217));
		panel_3_1_1.setBounds(56, 219, 135, 138);
		panel_2.add(panel_3_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Password");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblNewLabel_4_1.setBounds(30, 95, 81, 20);
		panel_3_1_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Change");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblNewLabel_3_1_1.setBounds(35, 69, 68, 29);
		panel_3_1_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(EmployeePanel.class.getResource("/images/change-passwordd.png")));
		lblNewLabel_2_1_1.setBounds(33, 11, 68, 60);
		panel_3_1_1.add(lblNewLabel_2_1_1);
		
		RoundedLabel lblNewLabel_1_1_1 = new RoundedLabel("", 30, new Color(72, 201, 176), Color.BLACK, 2);
		lblNewLabel_1_1_1.setBounds(0, 0, 135, 138);
		panel_3_1_1.add(lblNewLabel_1_1_1);
		
		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3_1_2.setLayout(null);
		panel_3_1_2.setBorder(null);
		panel_3_1_2.setBackground(new Color(159, 217, 217));
		panel_3_1_2.setBounds(285, 219, 135, 138);
		panel_2.add(panel_3_1_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("Billing");
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblNewLabel_4_2.setBounds(43, 94, 64, 20);
		panel_3_1_2.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Start");
		lblNewLabel_3_1_2.setForeground(Color.WHITE);
		lblNewLabel_3_1_2.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblNewLabel_3_1_2.setBounds(50, 68, 47, 26);
		panel_3_1_2.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2.setIcon(new ImageIcon(EmployeePanel.class.getResource("/images/start_billing.png")));
		lblNewLabel_2_1_2.setBounds(33, 11, 70, 60);
		panel_3_1_2.add(lblNewLabel_2_1_2);
		
		RoundedLabel lblNewLabel_1_1_2 = new RoundedLabel("", 30, new Color(72, 201, 176), Color.BLACK, 2);
		lblNewLabel_1_1_2.setBounds(0, 0, 135, 138);
		panel_3_1_2.add(lblNewLabel_1_1_2);
	}
}
