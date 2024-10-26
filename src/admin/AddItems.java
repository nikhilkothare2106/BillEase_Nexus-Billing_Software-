package admin;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import userdefined.*;
import validation.ItemValidation;

import javax.swing.border.MatteBorder;

import billingSoftware.LoginPage;
import dbconnection.DbOperations;
import gettersetter.GetSetItem;

public class AddItems {

	private JFrame frame = new JFrame();
	private JTextField nametext;
	private JTextField idtext;
	private RoundedButton btn_register;
	private JTextField pricetext;
	private JTextField quantitytext;
	private String otherselected = "";

	public AddItems() {
		initialize();
		frame.setVisible(true);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame.setTitle("Add Items");
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
		lblNewLabel_3_1.setBounds(326, 16, 428, 67);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new LineBorder(new Color(15, 191, 169)));
		lblNewLabel.setBackground(new Color(72, 201, 255));
		lblNewLabel.setBounds(0, 0, 1136, 101);
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
		
		JLabel lblNewLabel_5_1_1_2_1_1 = new JLabel("");
		lblNewLabel_5_1_1_2_1_1.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\shopping_history.png"));
		lblNewLabel_5_1_1_2_1_1.setBounds(19, 363, 50, 57);
		panel_4.add(lblNewLabel_5_1_1_2_1_1);
		
		JLabel lblNewLabel_10_1 = new JLabel("Shopping History");
		lblNewLabel_10_1.setForeground(Color.BLACK);
		lblNewLabel_10_1.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_10_1.setBounds(73, 361, 119, 57);
		panel_4.add(lblNewLabel_10_1);
		
		RoundedLabel lblNewLabel_8_4_1 = new RoundedLabel("", 30, UIManager.getColor("Button.background"), Color.BLACK, 2);
		lblNewLabel_8_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ShoppingHistory();
				frame.setVisible(false);
			}
		});
		lblNewLabel_8_4_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_8_4_1.setBounds(7, 361, 208, 57);
		panel_4.add(lblNewLabel_8_4_1);
		
		JLabel lblNewLabel_10 = new JLabel("Change Password");
		lblNewLabel_10.setForeground(new Color(0, 0, 0));
		lblNewLabel_10.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_10.setBounds(75, 454, 129, 57);
		lblNewLabel_10.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_10);
		
		JLabel lblNewLabel_5_1_1_2 = new JLabel("");
		lblNewLabel_5_1_1_2.setIcon(new ImageIcon(AddItems.class.getResource("/images/edititem.png")));
		lblNewLabel_5_1_1_2.setBounds(10, 274, 53, 57);
		lblNewLabel_5_1_1_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1_2);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1.setIcon(new ImageIcon(AddItems.class.getResource("/images/edit.png")));
		lblNewLabel_5_1_1.setBounds(20, 93, 53, 57);
		lblNewLabel_5_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_3_1 = new JLabel("Add items");
		lblNewLabel_5_3_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_5_3_1.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_5_3_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_5_3_1.setBounds(73, 176, 108, 57);
		panel_4.add(lblNewLabel_5_3_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("");
		lblNewLabel_5_1_1_1.setIcon(new ImageIcon(AddItems.class.getResource("/images/additem.png")));
		lblNewLabel_5_1_1_1.setBounds(20, 176, 53, 57);
		lblNewLabel_5_1_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabel_5_1_1_2_1 = new JLabel("");
		lblNewLabel_5_1_1_2_1.setIcon(new ImageIcon(AddItems.class.getResource("/images/changepassword.png")));
		lblNewLabel_5_1_1_2_1.setBounds(16, 454, 57, 57);
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
		lblNewLabel_5.setBounds(73, 266, 118, 57);
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
		lblNewLabel_8_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ChangePasswordAdmin();
				frame.setVisible(false);			}
		});
		lblNewLabel_8_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_8_4.setBounds(10, 454, 208, 57);
		panel_4.add(lblNewLabel_8_4);
		
		RoundedLabel lblNewLabel_8_2 = new RoundedLabel("", 30, new Color(240,240,240), Color.BLACK, 2);
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
		lblNewLabel_5_1.setIcon(new ImageIcon(AddItems.class.getResource("/images/register.png")));
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
		lblNewLabel_2.setBounds(0, 0, 228, 741);
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
		lblNewLabel_4_1.setIcon(new ImageIcon(AddItems.class.getResource("/images/imageedit_7_8214613300.png")));
		lblNewLabel_4_1.setBounds(156, 187, 364, 379);
		panel_2.add(lblNewLabel_4_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(46, 79, 79));
		panel_5.setBounds(623, 42, 346, 516);
		panel_2.add(panel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selecteditem = (String) comboBox.getSelectedItem();
				if(selecteditem.equals("Other")){
					otherselected = JOptionPane.showInputDialog(panel_5, "Enter category");
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Category", "Electronics", "Clothing", "Groceries", "Toys", "Health and Beauty", "Home and Kitchen", "Books and Stationery", "Other"}));
		comboBox.setBounds(25, 384, 160, 25);
		panel_5.add(comboBox);
		
		quantitytext = new JTextField();
		quantitytext.setForeground(Color.WHITE);
		quantitytext.setFont(new Font("Serif", Font.BOLD, 14));
		quantitytext.setColumns(10);
		quantitytext.setCaretColor(Color.WHITE);
		quantitytext.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		quantitytext.setBackground(new Color(15, 164, 149));
		quantitytext.setBounds(25, 314, 298, 25);
		panel_5.add(quantitytext);
		
		pricetext = new JTextField();
		pricetext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quantitytext.requestFocus();
			}
		});
		pricetext.setForeground(Color.WHITE);
		pricetext.setFont(new Font("Serif", Font.BOLD, 14));
		pricetext.setColumns(10);
		pricetext.setCaretColor(Color.WHITE);
		pricetext.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		pricetext.setBackground(new Color(15, 164, 149));
		pricetext.setBounds(25, 246, 298, 25);
		panel_5.add(pricetext);
		
		JLabel namelabel = new JLabel("Item Name");
		namelabel.setForeground(Color.WHITE);
		namelabel.setFont(new Font("Rockwell", Font.BOLD, 14));
		namelabel.setBounds(27, 158, 214, 25);
		panel_5.add(namelabel);
		
		nametext = new JTextField();
		nametext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pricetext.requestFocus();
			}
		});
		nametext.setForeground(Color.WHITE);
		nametext.setFont(new Font("Serif", Font.BOLD, 14));
		nametext.setColumns(10);
		nametext.setCaretColor(Color.WHITE);
		nametext.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		nametext.setBackground(new Color(15, 164, 149));
		nametext.setBounds(25, 179, 298, 25);
		panel_5.add(nametext);
		
		btn_register = new RoundedButton("Register", 20, Color.WHITE);
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idtext.getText();
				String name = nametext.getText();
				String price = pricetext.getText();
				String quantity = quantitytext.getText();
				String category = (String)comboBox.getSelectedItem();

				ItemValidation validate = new ItemValidation();

				if(!validate.idValidation(id)){
					JOptionPane.showMessageDialog(frame, "Invalid id", "Id error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!validate.nameValidation(name)){
					JOptionPane.showMessageDialog(frame, "Invalid name", "Name error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!validate.priceValidation(price)){
					JOptionPane.showMessageDialog(frame, "Invalid price", "Price error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!validate.quantityValidation(quantity)){
					JOptionPane.showMessageDialog(frame, "Invalid quantity", "Quantity error", JOptionPane.ERROR_MESSAGE);
				}else{
					if(category.equals("Select Category")){
						category = "";
					}else if(category.equals("Other")){
						category = otherselected;
					}

					GetSetItem item = new GetSetItem();
					item.setId(id);
					item.setName(name);
					item.setPrice(price);
					item.setQuantity(quantity);
					item.setCategory(category);

					boolean status = DbOperations.addItem(item);
					if(status){
						JOptionPane.showMessageDialog(frame, "Item added Sucessfully");
						idtext.setText("");
						nametext.setText("");
						pricetext.setText("");
						quantitytext.setText("");
						comboBox.setSelectedIndex(0);
					}
					else{
						JOptionPane.showMessageDialog(frame, "Error occurred", "Add item error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btn_register.setText("Add");
		btn_register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_register.setForeground(Color.WHITE);
		btn_register.setFont(new Font("Rockwell", Font.BOLD, 14));
		btn_register.setFocusPainted(false);
		btn_register.setBackground(new Color(255, 69, 0));
		btn_register.setBounds(118, 449, 113, 40);
		panel_5.add(btn_register);
		
		JLabel categorylable = new JLabel("Item Category");
		categorylable.setForeground(Color.WHITE);
		categorylable.setFont(new Font("Rockwell", Font.BOLD, 14));
		categorylable.setBounds(25, 355, 214, 25);
		panel_5.add(categorylable);
		
		JLabel quantitylable = new JLabel("Item Quantity");
		quantitylable.setForeground(Color.WHITE);
		quantitylable.setFont(new Font("Rockwell", Font.BOLD, 14));
		quantitylable.setBounds(25, 290, 214, 25);
		panel_5.add(quantitylable);
		
		idtext = new JTextField();
		idtext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nametext.requestFocus();
			}
		});
		idtext.setForeground(Color.WHITE);
		idtext.setFont(new Font("Serif", Font.BOLD, 14));
		idtext.setColumns(10);
		idtext.setCaretColor(Color.WHITE);
		idtext.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		idtext.setBackground(new Color(15, 164, 149));
		idtext.setBounds(25, 117, 298, 25);
		panel_5.add(idtext);
		
		JLabel idlabel = new JLabel("Item ID");
		idlabel.setForeground(Color.WHITE);
		idlabel.setFont(new Font("Rockwell", Font.BOLD, 14));
		idlabel.setBounds(25, 95, 214, 25);
		panel_5.add(idlabel);
		
		JLabel pricelable = new JLabel("Item Price");
		pricelable.setForeground(Color.WHITE);
		pricelable.setFont(new Font("Rockwell", Font.BOLD, 14));
		pricelable.setBounds(25, 223, 214, 25);
		panel_5.add(pricelable);
		
		JLabel labletext = new JLabel("Add Item");
		labletext.setForeground(Color.WHITE);
		labletext.setFont(new Font("Rockwell", Font.BOLD, 26));
		labletext.setBounds(100, 21, 122, 63);
		panel_5.add(labletext);
		
		RoundedLabel lblNewLabel_2_1 = new RoundedLabel("", 30, new Color(15,164,149), Color.BLACK, 1);
		lblNewLabel_2_1.setBounds(0, 0, 346, 516);
		panel_5.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIconTextGap(3);
		lblNewLabel_1_1.setBackground(new Color(255, 255, 255));
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
