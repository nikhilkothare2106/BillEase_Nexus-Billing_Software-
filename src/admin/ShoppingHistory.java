package admin;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dbconnection.DbOperations;
import userdefined.RoundedLabel;

public class ShoppingHistory {

	private JFrame frame = new JFrame();
	private JTable table;
	private DefaultTableModel model;
	private JTextField phone_text;
	private Object[] row;
	private JScrollPane scrollPane;
	private JLabel name_label;

	public ShoppingHistory() {
		initialize();
		frame.setVisible(true);
	}


	private void setTableHeight(){
		int rowCount = table.getRowCount();
		int rowHeight = table.getRowHeight();
		int tableHeight = rowCount * rowHeight;

		Rectangle rc = table.getBounds();
		table.setPreferredSize(new Dimension(table.getPreferredSize().width, tableHeight));
		table.setBounds(rc.x, rc.y, rc.width, tableHeight);
		Rectangle rc1 = scrollPane.getBounds();
		if(scrollPane.getBounds().height < 400){
			scrollPane.setBounds(rc1.x, rc1.y, rc1.width, tableHeight + 28);
		}
	}
	private void initialize() {
		frame.setTitle("Shopping History");
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
		
		JLabel lblNewLabel_5_1_1_2_1_1 = new JLabel("");
		lblNewLabel_5_1_1_2_1_1.setIcon(new ImageIcon("C:\\Users\\nikhil\\OneDrive\\Desktop\\New folder (5)\\src\\images\\shopping_history.png"));
		lblNewLabel_5_1_1_2_1_1.setBounds(22, 358, 50, 57);
		panel_4.add(lblNewLabel_5_1_1_2_1_1);
		
		JLabel lblNewLabel_10_1 = new JLabel("Shopping History");
		lblNewLabel_10_1.setForeground(Color.BLACK);
		lblNewLabel_10_1.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_10_1.setBounds(76, 356, 119, 57);
		panel_4.add(lblNewLabel_10_1);
		
		RoundedLabel lblNewLabel_8_4_1 = new RoundedLabel("", 30, UIManager.getColor("Button.background"), Color.BLACK, 2);
		lblNewLabel_8_4_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_8_4_1.setBounds(10, 356, 208, 57);
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
		lblNewLabel_10.setBounds(76, 450, 129, 57);
		lblNewLabel_10.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_10);
		
		JLabel lblNewLabel_5_1_1_2 = new JLabel("");
		lblNewLabel_5_1_1_2.setIcon(new ImageIcon(ShoppingHistory.class.getResource("/images/edititem.png")));
		lblNewLabel_5_1_1_2.setBounds(10, 270, 53, 62);
		lblNewLabel_5_1_1_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1_2);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1.setIcon(new ImageIcon(ShoppingHistory.class.getResource("/images/edit.png")));
		lblNewLabel_5_1_1.setBounds(20, 94, 53, 57);
		lblNewLabel_5_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_3_1 = new JLabel("Add items");
		lblNewLabel_5_3_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_5_3_1.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_5_3_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_5_3_1.setBounds(76, 175, 98, 57);
		panel_4.add(lblNewLabel_5_3_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("");
		lblNewLabel_5_1_1_1.setIcon(new ImageIcon(ShoppingHistory.class.getResource("/images/additem.png")));
		lblNewLabel_5_1_1_1.setBounds(18, 175, 53, 57);
		lblNewLabel_5_1_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_4.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabel_5_1_1_2_1 = new JLabel("");
		lblNewLabel_5_1_1_2_1.setIcon(new ImageIcon(ShoppingHistory.class.getResource("/images/changepassword.png")));
		lblNewLabel_5_1_1_2_1.setBounds(22, 450, 50, 57);
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
		lblNewLabel_5.setBounds(76, 266, 112, 57);
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
		lblNewLabel_8_4.setBounds(10, 450, 208, 57);
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
		lblNewLabel_5_1.setIcon(new ImageIcon(ShoppingHistory.class.getResource("/images/register.png")));
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
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(46, 79, 79));
		panel_5.setBounds(135, 11, 888, 579);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		phone_text = new JTextField();
		phone_text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String phone = phone_text.getText();
				ResultSet rs = DbOperations.getCustomerHistory(phone);

				try{
					if(rs != null){
						while(rs.next()){
							String item = rs.getString("Item_Purchased");

							String[] items = item.split(",");
							int total_item = items.length/4;

							String item_list = "";
							int index = -1;
							for(int i = 1; i <= total_item; i++){
								index += 2;
								String item_name = items[index];
								index += 1;
								String item_price = items[index];
								index += 1;
								String item_quantity = items[index];

								item_list = item_list + " " + item_quantity + " " + item_name + " of " + item_price + ",";
							}
					
							String date = rs.getString("Date");
							String time = rs.getString("Time");
							String email = rs.getString("Employee_email");
							
							row = new Object[]{item_list,date,time,email};
							model.addRow(row);

							DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			        		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

			        		for (int i = 0; i < table.getColumnCount(); i++) {
			        		    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			        		}
							name_label.setText(rs.getString("Customer_Name"));
						}
						setTableHeight();
					}
					else{
						name_label.setText("");
					}
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
		name_label = new JLabel("");
		name_label.setForeground(new Color(255, 255, 255));
		name_label.setFont(new Font("Rockwell", Font.PLAIN, 16));
		name_label.setBounds(640, 92, 143, 25);
		panel_5.add(name_label);
		phone_text.setCaretColor(new Color(255, 255, 255));
		phone_text.setFont(new Font("Rockwell", Font.PLAIN, 16));
		phone_text.setForeground(new Color(255, 255, 255));
		phone_text.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		phone_text.setBackground(new Color(46, 79, 79));
		phone_text.setBounds(333, 96, 108, 19);
		panel_5.add(phone_text);
		phone_text.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBackground(Color.BLACK);
		scrollPane.setBounds(160, 145, 612, 25);
		panel_5.add(scrollPane);

		String[] cols = new String[]{"Item Details","Date","Time","Emp Email"};
		Object[][] data = new Object[][]{
			
		};
		model = new DefaultTableModel(data, cols){
			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		
		table = new JTable(model);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Rockwell", Font.PLAIN, 14));
		table.setRowHeight(25);
		table.setCellSelectionEnabled(true);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
		table.getColumnModel().getColumn(0).setPreferredWidth(220);
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		table.setBorder(null);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_11 = new JLabel("Enter Phone No:");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblNewLabel_11.setBounds(172, 92, 158, 25);
		panel_5.add(lblNewLabel_11);
		
		JLabel lblNewLabel_11_1 = new JLabel("Customer Name:");
		lblNewLabel_11_1.setForeground(Color.WHITE);
		lblNewLabel_11_1.setFont(new Font("Rockwell", Font.BOLD, 19));
		lblNewLabel_11_1.setBounds(475, 92, 165, 25);
		panel_5.add(lblNewLabel_11_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(203, 228, 222));
		lblNewLabel_3.setBorder(new LineBorder(new Color(46, 79, 79)));
//		lblNewLabel_3.setIcon(new ImageIcon(ShoppingHistory.class.getResource("/images/Untitled1.png")));
		lblNewLabel_3.setBounds(0, 0, 1136, 638);
		panel_2.add(lblNewLabel_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(46, 79, 79));
		panel_3.setBorder(null);
		panel_3.setBounds(0, 0, 228, 101);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AdminPanel();
				frame.setVisible(false);
			}
		});
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setBounds(51, 0, 112, 101);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(ShoppingHistory.class.getResource("/images/admin.png")));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, 0, 228, 101);
		panel_3.add(lblNewLabel_4);
		lblNewLabel_4.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		;
	}
}
