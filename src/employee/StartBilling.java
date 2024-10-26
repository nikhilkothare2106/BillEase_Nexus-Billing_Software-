package employee;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import userdefined.RoundedLabel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import dbconnection.DbOperations;
import gettersetter.GetSetEmployee;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import userdefined.RoundedButton;

public class StartBilling {

	private JFrame frame = new JFrame();
	private JTextField id_text;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JLabel price_label, name_label,category_label,total_label;
	@SuppressWarnings("rawtypes")
	private HashMap<String,ArrayList> map;
	private GetSetEmployee employee;
	private RoundedButton next_label;
	private RoundedLabel panel_2;

	public StartBilling(GetSetEmployee employee,@SuppressWarnings("rawtypes") HashMap<String,ArrayList> map) {
		this.employee = employee;
		this.map = map;
		initialize();
		if(!map.isEmpty()){
			next_label.setEnabled(true);
		}
		frame.setVisible(true);
	}

	private void clearDetails(){
		name_label.setText("_________________");
		price_label.setText("______");
		category_label.setText("_________________");
		total_label.setText("______");
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame.setTitle("Start Billing");
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
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Start Billing");
		lblNewLabel_5_1_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_5_1_1.setFont(new Font("Cooper Black", Font.BOLD, 32));
		lblNewLabel_5_1_1.setBounds(579, 27, 247, 47);
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
		
		JLabel wel_name_label = new JLabel(employee.getName());
		wel_name_label.setForeground(new Color(255, 255, 224));
		wel_name_label.setFont(new Font("Cooper Black", Font.BOLD, 24));
		wel_name_label.setBounds(182, 27, 221, 47);
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
		
		
		next_label = new RoundedButton("Log in", 10, Color.WHITE);
		next_label.setIcon(new ImageIcon(StartBilling.class.getResource("/images/next.png")));
		next_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		next_label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PurchasedItems(employee,map);
				frame.setVisible(false);
			}
		});
		next_label.setText("");
		next_label.setForeground(Color.WHITE);
		next_label.setFont(new Font("Rockwell", Font.BOLD, 14));
		next_label.setFocusPainted(false);
		next_label.setEnabled(false);
		next_label.setBackground(new Color(15, 164, 149));
		next_label.setBounds(961, 518, 63, 25);
		panel_1.add(next_label);
		
		RoundedButton lblAddToCart = new RoundedButton("Log in", 20, Color.WHITE);
		lblAddToCart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = id_text.getText();
				String name = name_label.getText();
				String price = price_label.getText();
				String quantity = (String) comboBox.getSelectedItem();
				String total = total_label.getText();

				ArrayList<String> list = new ArrayList<>();

				list.add(name);
				list.add(price);
				list.add(quantity);
				list.add(total);

				map.put(id,list);
				JOptionPane.showMessageDialog(panel_2, "Item Added Successfully!");
				id_text.setText("");
				next_label.setEnabled(true);
				comboBox.setSelectedIndex(0);
				clearDetails();
				lblAddToCart.setEnabled(false);
			}
		});
		lblAddToCart.setText("Add To Cart");
		lblAddToCart.setEnabled(false);
		lblAddToCart.setForeground(Color.WHITE);
		lblAddToCart.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblAddToCart.setFocusPainted(false);
		lblAddToCart.setBackground(new Color(255, 69, 0));
		lblAddToCart.setBounds(829, 447, 106, 36);
		panel_1.add(lblAddToCart);
		
		lblAddToCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblAddToCart.setBackground(new Color(255, 99, 71));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAddToCart.setFont(new Font("Rockwell", Font.BOLD, 15));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblAddToCart.setFont(new Font("Rockwell", Font.BOLD, 14));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblAddToCart.setBackground(new Color(255,69,0));
			}
			
		
		});
		
		
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(StartBilling.class.getResource("/images/imageedit_7_8214613300.png")));
		lblNewLabel_4_1.setBounds(261, 179, 364, 379);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("BillEase");
		lblNewLabel_3_2.setForeground(new Color(255, 255, 224));
		lblNewLabel_3_2.setFont(new Font("Cooper Black", Font.BOLD, 54));
		lblNewLabel_3_2.setBounds(329, 55, 259, 67);
		panel_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Nexus");
		lblNewLabel_3_1_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_3_1_1.setFont(new Font("Cooper Black", Font.BOLD, 54));
		lblNewLabel_3_1_1.setBounds(354, 111, 225, 67);
		panel_1.add(lblNewLabel_3_1_1);
		
		total_label = new JLabel("______");
		total_label.setForeground(Color.WHITE);
		total_label.setFont(new Font("Rockwell", Font.PLAIN, 16));
		total_label.setBounds(902, 395, 112, 25);
		panel_1.add(total_label);
		
		JLabel price_label_1_1 = new JLabel("Rs.");
		price_label_1_1.setForeground(Color.WHITE);
		price_label_1_1.setFont(new Font("Rockwell", Font.PLAIN, 16));
		price_label_1_1.setBounds(871, 395, 26, 25);
		panel_1.add(price_label_1_1);
		
		JLabel price_label_1 = new JLabel("Rs.");
		price_label_1.setForeground(Color.WHITE);
		price_label_1.setFont(new Font("Rockwell", Font.PLAIN, 16));
		price_label_1.setBounds(871, 245, 26, 25);
		panel_1.add(price_label_1);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String quantity = (String)comboBox.getSelectedItem();
				int quantity1 = Integer.parseInt(quantity);

				String price = price_label.getText();
				int price1 = Integer.parseInt(price);
				int total_bill = quantity1 * price1;
				total_label.setText(String.valueOf(total_bill));
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		comboBox.setBounds(871, 348, 102, 25);
		panel_1.add(comboBox);
		
		price_label = new JLabel("______");
		price_label.setForeground(Color.WHITE);
		price_label.setFont(new Font("Rockwell", Font.PLAIN, 16));
		price_label.setBounds(901, 245, 123, 25);
		panel_1.add(price_label);
		
		category_label = new JLabel("_________________");
		category_label.setForeground(Color.WHITE);
		category_label.setFont(new Font("Rockwell", Font.PLAIN, 16));
		category_label.setBounds(871, 295, 143, 25);
		panel_1.add(category_label);
		
		name_label = new JLabel("_________________");
		name_label.setForeground(Color.WHITE);
		name_label.setFont(new Font("Rockwell", Font.PLAIN, 16));
		name_label.setBounds(871, 195, 143, 25);
		panel_1.add(name_label);
		
		id_text = new JTextField();
		id_text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAddToCart.doClick();
			}
		});
		id_text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String id = id_text.getText();
				ResultSet rs = DbOperations.getItemData(id);
				try{
					if(rs.next()){
						name_label.setText(rs.getString("Name"));
						price_label.setText(rs.getString("Price"));
						category_label.setText(rs.getString("Category"));

						String quantity = (String)comboBox.getSelectedItem();
						int quantity1 = Integer.parseInt(quantity);

						String price = price_label.getText();
						int price1 = Integer.parseInt(price);
						int total_bill = quantity1 * price1;
						total_label.setText(String.valueOf(total_bill));
						lblAddToCart.setEnabled(true);
						
					}else{
						clearDetails();
						lblAddToCart.setEnabled(false);
					}
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		id_text.setForeground(Color.WHITE);
		id_text.setFont(new Font("Serif", Font.PLAIN, 14));
		id_text.setColumns(10);
		id_text.setCaretColor(Color.WHITE);
		id_text.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		id_text.setBackground(new Color(15, 164, 149));
		id_text.setBounds(871, 145, 138, 25);
		panel_1.add(id_text);
		
		JLabel lblBilling = new JLabel("Billing");
		lblBilling.setForeground(Color.WHITE);
		lblBilling.setFont(new Font("Rockwell", Font.BOLD, 24));
		lblBilling.setBounds(829, 84, 102, 25);
		panel_1.add(lblBilling);
		
		JLabel lblTotalBill = new JLabel("Total Bill:");
		lblTotalBill.setForeground(Color.WHITE);
		lblTotalBill.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblTotalBill.setBounds(732, 395, 118, 25);
		panel_1.add(lblTotalBill);
		
		JLabel oldpwdtext = new JLabel("Item Id:");
		panel_1.add(oldpwdtext);
		oldpwdtext.setForeground(Color.WHITE);
		oldpwdtext.setFont(new Font("Rockwell", Font.BOLD, 16));
		oldpwdtext.setBounds(732, 145, 79, 25);
		
		JLabel lblItemName_1 = new JLabel("Item Name:");
		lblItemName_1.setForeground(Color.WHITE);
		lblItemName_1.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblItemName_1.setBounds(732, 195, 102, 25);
		panel_1.add(lblItemName_1);
		
		JLabel lblItemPrice = new JLabel("Item Price:");
		lblItemPrice.setForeground(Color.WHITE);
		lblItemPrice.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblItemPrice.setBounds(732, 245, 118, 25);
		panel_1.add(lblItemPrice);
		
		JLabel lblItemCategory = new JLabel("Item Category:");
		lblItemCategory.setForeground(Color.WHITE);
		lblItemCategory.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblItemCategory.setBounds(732, 295, 118, 25);
		panel_1.add(lblItemCategory);
		
		JLabel lblItemQuantity = new JLabel("Item Quantity:");
		lblItemQuantity.setForeground(Color.WHITE);
		lblItemQuantity.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblItemQuantity.setBounds(732, 345, 118, 25);
		panel_1.add(lblItemQuantity);
		
		panel_2 = new RoundedLabel("", 30, new Color(15,164,149), Color.BLACK, 1);
		panel_2.setBounds(690, 36, 369, 521);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		RoundedLabel panel_6 = new RoundedLabel("", 30, new Color(46, 79, 79), Color.BLACK, 1);
		panel_6.setBackground(new Color(46, 79, 79));
		panel_6.setBounds(200, 11, 888, 579);
		panel_1.add(panel_6);
	}
}
