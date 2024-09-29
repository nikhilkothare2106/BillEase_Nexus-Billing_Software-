package billingSoftware;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StartPage {

	private JFrame frame;
	JProgressBar progressBar;
	JLabel lblNewLabel,lblNewLabel_2;

	public static void main(String[] args) {
		new StartPage();
	}
	public StartPage() {
		initialize();
		frame.setVisible(true);
	}
	
	int i = 1;
	Timer timer = new Timer(15, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			progressBar.setValue(i);
			if(i == 100){
				timer.stop();
				new LoginPage();
				frame.setVisible(false);
			}
			if(i == 10) {
				lblNewLabel_2.setText("loading, Please wait...");
			}
			if(i == 70) {
				lblNewLabel_2.setText("Starting the Software...");
			}
			i++;
		}
	});	
	private JLabel lblNewLabel_4;

	private void initialize() {
		frame = new JFrame();
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				timer.start();
			}
		});
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 696, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel_4 = new JLabel("Created by: Nikhil Kothare");
		lblNewLabel_4.setFont(new Font("Rockwell", Font.BOLD, 11));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(515, 11, 159, 26);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Rockwell", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 332, 192, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(1, 77, 254));
		progressBar.setStringPainted(true);
		progressBar.setBounds(0, 369, 696, 14);
		frame.getContentPane().add(progressBar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(StartPage.class.getResource("/images/startlogo.png")));
		lblNewLabel_1.setBounds(43, 49, 309, 303);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Software");
		lblNewLabel_3_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_3_1.setFont(new Font("Cooper Black", Font.BOLD, 54));
		lblNewLabel_3_1.setBounds(367, 172, 295, 67);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("Billing");
		lblNewLabel_3.setForeground(new Color(255, 255, 224));
		lblNewLabel_3.setFont(new Font("Cooper Black", Font.BOLD, 54));
		lblNewLabel_3.setBounds(403, 111, 259, 67);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(StartPage.class.getResource("/images/startbg.jpg")));
		lblNewLabel.setBounds(0, 0, 696, 414);
		frame.getContentPane().add(lblNewLabel);
		frame.setLocationRelativeTo(null);	
		
		
	}
}
