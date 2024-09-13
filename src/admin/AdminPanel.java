package admin;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;;

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
		panel.setBounds(0, 0, 1364, 119);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 164, 119);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(46, 79, 79));
		lblNewLabel_1.setBackground(new Color(46, 79, 79));
		lblNewLabel_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/logo1.png")));
		
		JLabel lblNewLabel_3_1 = new JLabel("Admin DashBoard");
		lblNewLabel_3_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_3_1.setFont(new Font("Cooper Black", Font.BOLD, 42));
		lblNewLabel_3_1.setBounds(410, 29, 428, 67);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(46, 79, 79));
		lblNewLabel.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/Untitled.png")));
		lblNewLabel.setBounds(0, 0, 1364, 119);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 117, 1364, 624);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/Untitled3.png")));
		lblNewLabel_2.setBounds(0, 0, 1364, 624);
		panel_1.add(lblNewLabel_2);
		;
	}
}
