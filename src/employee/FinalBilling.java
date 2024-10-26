package employee;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;

import userdefined.RoundedLabel;
import validation.RegValidation;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dbconnection.DbOperations;
import gettersetter.GetSetEmployee;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import userdefined.RoundedButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinalBilling {

	private JFrame frame = new JFrame();
	private JTable table;
	private DefaultTableModel model;
	private JTextField phone_text;
	private JTextField name_text;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private GetSetEmployee employee;
	@SuppressWarnings("rawtypes")
	private HashMap<String,ArrayList> map;
	private Object[] row;
	private JScrollPane scrollPane;
	private JLabel lblTotalBill,rs_label,total_label;
	private JPanel panel_2,panel_3;
	private JRadioButton rdbtnMale,rdbtnFemale;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

	public FinalBilling(GetSetEmployee employee, @SuppressWarnings("rawtypes") HashMap<String,ArrayList> map) {
		this.employee = employee;
		this.map = map;
		initialize();
		getDetails();
		frame.setVisible(true);
	}

	
	private void getDetails(){
		model.setRowCount(0);
		int sr = 0;
		int total_bill = 0;
		for(String key:map.keySet()){
			sr++;
			String id = key;
			@SuppressWarnings("rawtypes")
			ArrayList list = map.get(key);
			String name = (String) list.get(0);
			String price = (String) list.get(1);
			String quantity = (String) list.get(2);
			String total = (String) list.get(3);
			total_bill += Integer.parseInt(total);
			row = new Object[]{sr,id,name,price,quantity,total};
			model.addRow(row);
			
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

	        for (int i = 0; i < table.getColumnCount(); i++) {
	            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	        }
		}
		setTableHeight(total_bill);
	}
	private void setTableHeight(int total_bill){
		int rowCount = table.getRowCount();
		int rowHeight = table.getRowHeight();
		int tableHeight = rowCount * rowHeight;
		Rectangle rc = table.getBounds();
		table.setPreferredSize(new Dimension(table.getPreferredSize().width, tableHeight));
		table.setBounds(rc.x, rc.y, rc.width, tableHeight);


		Rectangle rc1 = scrollPane.getBounds();
		if(scrollPane.getBounds().height < 370){
			scrollPane.setBounds(rc1.x, rc1.y, rc1.width, tableHeight + 30);
		}

		panel_2.setBounds(676,tableHeight+rc1.y+35,182,45);
		total_label.setText(String.valueOf(total_bill));
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame.setTitle("Final Billing");
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
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Final Billing");
		lblNewLabel_5_1_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_5_1_1.setFont(new Font("Cooper Black", Font.BOLD, 32));
		lblNewLabel_5_1_1.setBounds(655, 24, 347, 47);
		panel.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_9 = new JLabel("Back");
		lblNewLabel_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PurchasedItems(employee,map);
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
		wel_name_label.setBounds(182, 27, 306, 47);
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
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(46, 79, 79));
		panel_2.setBounds(676, 157, 182, 45);
		panel_1.add(panel_2);
		
		lblTotalBill = new JLabel("Total Bill:");
		lblTotalBill.setForeground(Color.WHITE);
		lblTotalBill.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblTotalBill.setBounds(0, 11, 80, 25);
		panel_2.add(lblTotalBill);
		
		rs_label = new JLabel("Rs.");
		rs_label.setForeground(Color.WHITE);
		rs_label.setFont(new Font("Rockwell", Font.PLAIN, 16));
		rs_label.setBounds(90, 11, 26, 25);
		panel_2.add(rs_label);
		
		total_label = new JLabel("0");
		total_label.setForeground(Color.WHITE);
		total_label.setFont(new Font("Rockwell", Font.PLAIN, 16));
		total_label.setBounds(113, 11, 95, 25);
		panel_2.add(total_label);
		
		RoundedButton btnNewButton = new RoundedButton("Log in", 20, Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phone = phone_text.getText();
				String name = name_text.getText();
				String gender = "";
				if(rdbtnMale.isSelected()){
					gender = "M";
				}else if(rdbtnFemale.isSelected()){
					gender = "F";
				}
				if(!(new RegValidation().phonenoValidation(phone))){
					JOptionPane.showMessageDialog(panel_3, "Invalid Phone No", "Phone error", JOptionPane.ERROR_MESSAGE);
				}
				else if(name.equals("")){
					JOptionPane.showMessageDialog(panel_3, "Enter Name", "Name error", JOptionPane.ERROR_MESSAGE);
				}
				else if(gender.equals("")){
					JOptionPane.showMessageDialog(panel_3, "Select Gender", "Gender error", JOptionPane.ERROR_MESSAGE);
				}
				else{
					String payment = (String) comboBox.getSelectedItem();
					if(payment.equals("Payment Options")){
						payment = "";
					}

					ResultSet rs = DbOperations.getCustomerData(phone);
					try{
						
						if(!rs.next()){
							boolean status = DbOperations.insertCustomerDetails(phone, name, gender, payment);

							if(status){
								new Payment(employee,map,phone,name,total_label.getText());
								frame.setVisible(false);
							}
							else{
								JOptionPane.showMessageDialog(panel_3, "Data not saved!", "Error", JOptionPane.ERROR_MESSAGE);
							}

						}else {
							new Payment(employee,map,phone,name,total_label.getText());
							frame.setVisible(false);
						}
					}
					catch(Exception e1){
						e1.printStackTrace();;
					}
				}
			}
		});
		btnNewButton.setText("Confirm");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Rockwell", Font.BOLD, 14));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setBounds(995, 467, 106, 36);
		panel_1.add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Payment Options", "Cash", "Credit Card", "Debit Card"}));
		comboBox.setBounds(920, 411, 142, 25);
		panel_1.add(comboBox);
		
		JLabel lblPaymentOptions = new JLabel("Payment Options:");
		lblPaymentOptions.setForeground(Color.WHITE);
		lblPaymentOptions.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblPaymentOptions.setBounds(920, 375, 156, 25);
		panel_1.add(lblPaymentOptions);
		
		rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Rockwell", Font.BOLD, 12));
		rdbtnMale.setFocusPainted(false);
		rdbtnMale.setBackground(new Color(15, 164, 149));
		rdbtnMale.setBounds(920, 345, 73, 23);
		panel_1.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Rockwell", Font.BOLD, 12));
		rdbtnFemale.setFocusPainted(false);
		rdbtnFemale.setBackground(new Color(15, 164, 149));
		rdbtnFemale.setBounds(995, 345, 81, 23);
		panel_1.add(rdbtnFemale);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblGender.setBounds(920, 313, 100, 25);
		panel_1.add(lblGender);
		
		name_text = new JTextField();
		name_text.setForeground(Color.WHITE);
		name_text.setFont(new Font("Serif", Font.BOLD, 14));
		name_text.setColumns(10);
		name_text.setCaretColor(Color.WHITE);
		name_text.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		name_text.setBackground(new Color(15, 164, 149));
		name_text.setBounds(920, 265, 260, 25);
		panel_1.add(name_text);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblName.setBounds(920, 245, 58, 25);
		panel_1.add(lblName);
		
		phone_text = new JTextField();
		phone_text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name_text.requestFocus();
			}
		});
		phone_text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String phone = phone_text.getText();
				ResultSet rs = DbOperations.getCustomerData(phone);

				try{
					if(rs.next()){
						name_text.setText(rs.getString("Name"));
						String gender = rs.getString("Gender");
						if(gender.equals("M")){
							rdbtnMale.setSelected(true);
						}else{
							rdbtnFemale.setSelected(true);
						}
						comboBox.setSelectedItem(rs.getString("Payment_mode"));
					}
					else{
						name_text.setText("");
						rdbtnMale.setSelected(false);
						rdbtnFemale.setSelected(false);
						comboBox.setSelectedIndex(0);
					}
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		phone_text.setForeground(Color.WHITE);
		phone_text.setFont(new Font("Serif", Font.BOLD, 14));
		phone_text.setColumns(10);
		phone_text.setCaretColor(Color.WHITE);
		phone_text.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		phone_text.setBackground(new Color(15, 164, 149));
		phone_text.setBounds(920, 200, 260, 25);
		panel_1.add(phone_text);
		
		JLabel lblPhoneNo = new JLabel("Phone No:");
		lblPhoneNo.setForeground(Color.WHITE);
		lblPhoneNo.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblPhoneNo.setBounds(920, 177, 90, 25);
		panel_1.add(lblPhoneNo);
		
		JLabel lblCustomerDetails = new JLabel("Customer Details");
		lblCustomerDetails.setForeground(Color.WHITE);
		lblCustomerDetails.setFont(new Font("Rockwell", Font.BOLD, 22));
		lblCustomerDetails.setBounds(955, 121, 204, 51);
		panel_1.add(lblCustomerDetails);
		
		RoundedLabel lblNewLabel_2_1 = new RoundedLabel("", 30, new Color(15, 164, 149), Color.BLACK, 1);
		lblNewLabel_2_1.setBounds(897, 105, 313, 431);
		panel_1.add(lblNewLabel_2_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(234, 122, 632, 29);
		panel_1.add(scrollPane);
		

		String[] cols = new String[]{"Sr No","Item id","Item Name","Item Price","Quantity","Total Price"};
		Object[][] data = new Object[][] {
			
		};
		model = new DefaultTableModel(data,cols){
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		table = new JTable(model);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setFont(new Font("Rockwell", Font.PLAIN, 14));
		table.getTableHeader().setFont(new Font("RockWell", Font.BOLD, 18));
		table.getColumnModel().getColumn(0).setPreferredWidth(75);
		table.getColumnModel().getColumn(1).setPreferredWidth(102);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
		table.getColumnModel().getColumn(4).setPreferredWidth(103);
		table.getColumnModel().getColumn(5).setPreferredWidth(103);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		RoundedLabel panel_6 = new RoundedLabel("", 30, new Color(46, 79, 79), Color.BLACK, 1);
		panel_6.setBackground(new Color(46, 79, 79));
		panel_6.setBounds(172, 22, 1068, 579);
		panel_1.add(panel_6);
		
		panel_3 = new JPanel();
		panel_3.setBounds(897, 105, 313, 431);
		panel_1.add(panel_3);
	}
}