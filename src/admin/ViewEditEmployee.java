package admin;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.border.LineBorder;
import userdefined.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dbconnection.*;
import gettersetter.GetSetEmployee;
import billingSoftware.*;

public class ViewEditEmployee {

	private JFrame frame = new JFrame();
	private JTable table;
	private Object[] row;
	private DefaultTableModel model;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JRadioButton rdbtnNewRadioButton,rdbtnFemale;
	private JTextField textField_2;
	private JScrollPane scrollPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEditEmployee window = new ViewEditEmployee();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ViewEditEmployee() {
		initialize();
		getEmployeeDetails();
		frame.setVisible(true);
	}

	private void getEmployeeDetails(){
		try{
			model.setRowCount(0);
			ResultSet rs = DbOperations.showAllEmployeeData();
			if(rs != null){
				int sr = 1;
				while(rs.next()){
					String email = rs.getString("Email");
					String name = rs.getString("Name");
					String gender = rs.getString("Gender");
					String phone = rs.getString("Phone_No");
					row = new Object[]{sr,name,email,gender,phone};
					sr++;
					model.addRow(row);
					DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

			        // Set the renderer for each column
			        for (int i = 0; i < table.getColumnCount(); i++) {
			            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			        }
				}
				sr = 0;
				setTableHeight();
			}
		}
		catch(Exception e1){
			e1.printStackTrace();
		}
	}
	private void clearForm(){
		textField.setText("");
		passwordField.setText("");
		textField_2.setText("");
		textField_1.setText("");
		buttonGroup.clearSelection();
	}
	private void setTableHeight() {
		int rowCount = table.getRowCount();
		int rowHeight = table.getRowHeight();
		int tableHeight = rowCount * rowHeight;

		Rectangle rc = table.getBounds();
		table.setPreferredSize(new Dimension(table.getPreferredSize().width, tableHeight));
		table.setBounds(rc.x, rc.y, rc.width, tableHeight);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
		Rectangle rc1 = scrollPane.getBounds();
		if(scrollPane.getBounds().height < 476){
			scrollPane.setBounds(rc1.x, rc1.y, rc1.width, tableHeight + 30);
		}
	}
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
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
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
		lblNewLabel_3_1.setBounds(324, 18, 428, 67);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new LineBorder(new Color(46, 79, 79)));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(ViewEditEmployee.class.getResource("/images/Untitled4.png")));
		lblNewLabel.setBounds(0, 0, 1136, 101);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 101, 228, 638);
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
		lblNewLabel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_2.setIcon(new ImageIcon(ViewEditEmployee.class.getResource("/images/Untitled.png")));
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(228, 101, 1136, 644);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		RoundedButton btn_register = new RoundedButton("Register", 20, Color.WHITE);
		btn_register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField_1.getText();
				if(!email.equals("")){
					String name = textField.getText();;
					String pwd = new String(passwordField.getPassword());
					String phone = textField_2.getText();
					String gender = "";
					if(rdbtnNewRadioButton.isSelected()){
						gender = "M";
					}else{
						gender = "F";
					}
					GetSetEmployee employee = new GetSetEmployee();
					employee.setEmail(email);
					employee.setGender(gender);
					employee.setName(name);
					employee.setPassword(pwd);
					employee.setPhoneno(phone);

					boolean status = DbOperations.updateEmployeeData(employee);
					
					if(status){
						JOptionPane.showMessageDialog(frame, "Employee data Updated Successfully!");
						getEmployeeDetails();
						clearForm();
					}else{
						JOptionPane.showMessageDialog(frame, "Error occurred!", "Update error", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(frame, "Employee not selected!", "Invalid data", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		RoundedButton btn_register_1 = new RoundedButton("Register", 20, Color.WHITE);
		btn_register_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_register_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField_1.getText();
				if(!email.equals("")){
					boolean status = DbOperations.deleteEmployeeData(email);

					if(status){
						JOptionPane.showMessageDialog(frame, "Employee data Deleted Successfully!");
						getEmployeeDetails();
						clearForm();
					}else{
						JOptionPane.showMessageDialog(frame, "Error occurred!", "Delete error", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(frame, "Employee not selected!", "Invalid data", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Serif", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setCaretColor(Color.WHITE);
		textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textField_2.setBackground(new Color(15, 164, 149));
		textField_2.setBounds(690, 413, 298, 25);
		panel_2.add(textField_2);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Serif", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setCaretColor(Color.WHITE);
		textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textField_1.setBackground(new Color(15, 164, 149));
		textField_1.setBounds(690, 215, 298, 25);
		panel_2.add(textField_1);
		
		rdbtnNewRadioButton = new JRadioButton("Male");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Rockwell", Font.BOLD, 12));
		rdbtnNewRadioButton.setFocusPainted(false);
		rdbtnNewRadioButton.setBackground(new Color(15, 164, 149));
		rdbtnNewRadioButton.setBounds(690, 362, 73, 23);
		panel_2.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_6_1 = new JLabel("Employee's email");
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_6_1.setBounds(690, 193, 214, 25);
		panel_2.add(lblNewLabel_6_1);
		btn_register_1.setText("Delete");
		btn_register_1.setForeground(Color.WHITE);
		btn_register_1.setFont(new Font("Rockwell", Font.BOLD, 14));
		btn_register_1.setFocusPainted(false);
		btn_register_1.setBackground(new Color(255, 69, 0));
		btn_register_1.setBounds(689, 471, 123, 40);
		panel_2.add(btn_register_1);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		passwordField.setBackground(new Color(15, 164, 149));
		passwordField.setBounds(690, 283, 298, 25);
		panel_2.add(passwordField);
		
		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Rockwell", Font.BOLD, 12));
		rdbtnFemale.setFocusPainted(false);
		rdbtnFemale.setBackground(new Color(15, 164, 149));
		rdbtnFemale.setBounds(765, 362, 81, 23);
		panel_2.add(rdbtnFemale);
		
		JLabel lblEnterPhoneNo = new JLabel("Employee's Phone No");
		lblEnterPhoneNo.setForeground(Color.WHITE);
		lblEnterPhoneNo.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblEnterPhoneNo.setBounds(690, 392, 214, 25);
		panel_2.add(lblEnterPhoneNo);
		
		JLabel lblNewLabel_5_2 = new JLabel("Update Employee");
		lblNewLabel_5_2.setForeground(Color.WHITE);
		lblNewLabel_5_2.setFont(new Font("Rockwell", Font.BOLD, 26));
		lblNewLabel_5_2.setBounds(715, 53, 256, 63);
		panel_2.add(lblNewLabel_5_2);
		
		String[] cols = new String[]{"Sr No","Name","Email","Gender","Phone No"};
		Object[][] data = new Object[][]{
			
		};
		model = new DefaultTableModel(data, cols){
			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		
		scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setViewportBorder(null);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBackground(new Color(0, 0, 0));
		scrollPane.setBounds(110, 108, 522, 31);
		panel_2.add(scrollPane);
		table = new JTable(model);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int i = table.getSelectedRow();
				String email = (String) table.getValueAt(i, 2);
				ResultSet rs = DbOperations.getEmployeeData(email);
				try{
					if(rs != null){
						if(rs.next()){
							textField.setText(rs.getString("Name"));
							passwordField.setText(rs.getString("Password"));
							textField_2.setText(rs.getString("Phone_No"));
							textField_1.setText(email);
							if(rs.getString("Gender").equals("M")){
								rdbtnNewRadioButton.setSelected(true);
							}else{
								rdbtnFemale.setSelected(true);
							}
						}
					}
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Rockwell", Font.PLAIN, 14));
		table.setRowHeight(25);
		table.setCellSelectionEnabled(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.setBorder(null);
		
		table.setBackground(new Color(192, 192, 192));
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Serif", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textField.setBackground(new Color(15, 164, 149));
		textField.setBounds(690, 149, 298, 25);
		panel_2.add(textField);
		
		JLabel lblNewLabel_11 = new JLabel("Employee Details");
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setFont(new Font("Rockwell", Font.BOLD, 19));
		lblNewLabel_11.setBounds(260, 66, 171, 31);
		panel_2.add(lblNewLabel_11);
		btn_register.setText("Update");
		btn_register.setForeground(Color.WHITE);
		btn_register.setFont(new Font("Rockwell", Font.BOLD, 14));
		btn_register.setFocusPainted(false);
		btn_register.setBackground(new Color(255, 69, 0));
		btn_register.setBounds(848, 471, 123, 40);
		panel_2.add(btn_register);
		
		JLabel lblUserPassword = new JLabel("Employee's Password");
		lblUserPassword.setForeground(Color.WHITE);
		lblUserPassword.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblUserPassword.setBounds(690, 262, 214, 25);
		panel_2.add(lblUserPassword);
		
		JLabel lblNewLabel_12 = new JLabel("Employee Name");
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_12.setBounds(690, 127, 214, 25);
		panel_2.add(lblNewLabel_12);
		
		JLabel lblSelectGender = new JLabel("Employee's Gender");
		lblSelectGender.setForeground(Color.WHITE);
		lblSelectGender.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblSelectGender.setBounds(690, 330, 214, 25);
		panel_2.add(lblSelectGender);
		
		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(46, 79, 79)));
		lblNewLabel_2_1.setIcon(new ImageIcon(ViewEditEmployee.class.getResource("/images/Untitled3.png")));
		lblNewLabel_2_1.setBounds(659, 36, 364, 535);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIconTextGap(3);
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\Untitled.png"));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(90, 11, 958, 579);
		panel_2.add(lblNewLabel_1_1);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBorder(new LineBorder(new Color(46, 79, 79)));
		lblNewLabel_3.setIcon(new ImageIcon(ViewEditEmployee.class.getResource("/images/Untitled1.png")));
		lblNewLabel_3.setBounds(0, 0, 1136, 644);
		panel_2.add(lblNewLabel_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBounds(0, 0, 228, 101);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(51, 0, 112, 101);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(ViewEditEmployee.class.getResource("/images/admin.png")));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\Untitled.png"));
		lblNewLabel_4.setBounds(0, 0, 228, 101);
		panel_3.add(lblNewLabel_4);
		lblNewLabel_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		;
	}
}
