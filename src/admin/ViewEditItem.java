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
import billingSoftware.*;

public class ViewEditItem {

	private JFrame frame = new JFrame();
	private JTable table;
	private Object[] row;
	private DefaultTableModel model;
	private JTextField idtext;
	private JTextField nametext;
	private JScrollPane scrollPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField pricetext;
	private JTextField quantitytext;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ViewEditItem();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ViewEditItem() {
		initialize();
		getItemDetails();
		frame.setVisible(true);
	}

	private void getItemDetails(){
		try{
			model.setRowCount(0);
			ResultSet rs = DbOperations.showItemData();
			if(rs != null){
				while(rs.next()){
					String id = rs.getString("id");
					String name = rs.getString("Name");
					String price = rs.getString("Price");
					String quantity = rs.getString("Quantity");
					String category = rs.getString("Category");
					row = new Object[]{id,name,price,quantity,category};
					model.addRow(row);
					DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

			        // Set the renderer for each column
			        for (int i = 0; i < table.getColumnCount(); i++) {
			            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			        }
				}
				setTableHeight();
			}else{
				System.out.println("sosfoifs");
			}
		}
		catch(Exception e1){
			e1.printStackTrace();
		}
	}
	private void clearForm(){
		idtext.setText("");
		nametext.setText("");
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
		lblNewLabel.setIcon(new ImageIcon(ViewEditItem.class.getResource("/images/Untitled4.png")));
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
		lblNewLabel_8_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ChangePassword();
				frame.setVisible(false);
			}
		});
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
		lblNewLabel_2.setBounds(0, 0, 228, 650);
		lblNewLabel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_2.setIcon(new ImageIcon(ViewEditItem.class.getResource("/images/Untitled.png")));
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(228, 101, 1136, 644);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		RoundedButton btn_register = new RoundedButton("Register", 20, Color.WHITE);
		btn_register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		RoundedButton btn_register_1 = new RoundedButton("Register", 20, Color.WHITE);
		btn_register_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel quantitylable = new JLabel("Item Quantity");
		quantitylable.setForeground(Color.WHITE);
		quantitylable.setFont(new Font("Rockwell", Font.BOLD, 14));
		quantitylable.setBounds(690, 333, 214, 25);
		panel_2.add(quantitylable);
		
		JLabel categorylable = new JLabel("Item Category");
		categorylable.setForeground(Color.WHITE);
		categorylable.setFont(new Font("Rockwell", Font.BOLD, 14));
		categorylable.setBounds(690, 398, 214, 25);
		panel_2.add(categorylable);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(690, 427, 160, 25);
		panel_2.add(comboBox);
		
		quantitytext = new JTextField();
		quantitytext.setForeground(new Color(255, 255, 255));
		quantitytext.setFont(new Font("Serif", Font.BOLD, 14));
		quantitytext.setColumns(10);
		quantitytext.setCaretColor(Color.WHITE);
		quantitytext.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		quantitytext.setBackground(new Color(15, 164, 149));
		quantitytext.setBounds(690, 357, 298, 25);
		panel_2.add(quantitytext);
		
		pricetext = new JTextField();
		pricetext.setForeground(new Color(255, 255, 255));
		pricetext.setFont(new Font("Serif", Font.BOLD, 14));
		pricetext.setColumns(10);
		pricetext.setCaretColor(Color.WHITE);
		pricetext.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		pricetext.setBackground(new Color(15, 164, 149));
		pricetext.setBounds(690, 285, 298, 25);
		panel_2.add(pricetext);
		
		nametext = new JTextField();
		nametext.setForeground(new Color(255, 255, 255));
		nametext.setFont(new Font("Serif", Font.BOLD, 14));
		nametext.setColumns(10);
		nametext.setCaretColor(Color.WHITE);
		nametext.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		nametext.setBackground(new Color(15, 164, 149));
		nametext.setBounds(690, 215, 298, 25);
		panel_2.add(nametext);
		
		JLabel namelable = new JLabel("Item Name");
		namelable.setForeground(Color.WHITE);
		namelable.setFont(new Font("Rockwell", Font.BOLD, 14));
		namelable.setBounds(690, 193, 214, 25);
		panel_2.add(namelable);
		btn_register_1.setText("Delete");
		btn_register_1.setForeground(Color.WHITE);
		btn_register_1.setFont(new Font("Rockwell", Font.BOLD, 14));
		btn_register_1.setFocusPainted(false);
		btn_register_1.setBackground(new Color(255, 69, 0));
		btn_register_1.setBounds(689, 471, 123, 40);
		panel_2.add(btn_register_1);
		
		JLabel headlable = new JLabel("Update Item");
		headlable.setForeground(Color.WHITE);
		headlable.setFont(new Font("Rockwell", Font.BOLD, 26));
		headlable.setBounds(715, 53, 256, 63);
		panel_2.add(headlable);
		
		String[] cols = new String[]{"Id","Name","Price","Quantity","Category"};
		Object[][] data = new Object[][]{
			
		};
		model = new DefaultTableModel(data, cols){
			private static final long serialVersionUID = 1L;

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
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int i = table.getSelectedRow();
				String id = (String) table.getValueAt(i, 0);
				ResultSet rs = DbOperations.getItemData(id);
				try{
					if(rs != null){
						if(rs.next()){
							idtext.setText(rs.getString("id"));
							nametext.setText(rs.getString("Name"));
							pricetext.setText(rs.getString("Price"));
							quantitytext.setText(rs.getString("Quantity"));

							comboBox.setModel(new DefaultComboBoxModel(new String[] {rs.getString("Category"), "Electronics", "Clothing", "Groceries", "Toys", "Health and Beauty", "Home and Kitchen", "Books and Stationery", "Other"}));
		
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
		
		idtext = new JTextField();
		idtext.setEnabled(false);
		idtext.setForeground(new Color(255, 255, 255));
		idtext.setFont(new Font("Serif", Font.BOLD, 14));
		idtext.setColumns(10);
		idtext.setCaretColor(Color.WHITE);
		idtext.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		idtext.setBackground(new Color(15, 164, 149));
		idtext.setBounds(690, 149, 298, 25);
		panel_2.add(idtext);
		
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
		
		JLabel pricelable = new JLabel("Item Price");
		pricelable.setForeground(Color.WHITE);
		pricelable.setFont(new Font("Rockwell", Font.BOLD, 14));
		pricelable.setBounds(690, 262, 214, 25);
		panel_2.add(pricelable);
		
		JLabel idlable = new JLabel("Item Id");
		idlable.setForeground(Color.WHITE);
		idlable.setFont(new Font("Rockwell", Font.BOLD, 14));
		idlable.setBounds(690, 127, 214, 25);
		panel_2.add(idlable);
		
		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(46, 79, 79)));
		lblNewLabel_2_1.setIcon(new ImageIcon(ViewEditItem.class.getResource("/images/Untitled3.png")));
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
		lblNewLabel_3.setIcon(new ImageIcon(ViewEditItem.class.getResource("/images/Untitled1.png")));
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
		lblNewLabel_1.setIcon(new ImageIcon(ViewEditItem.class.getResource("/images/admin.png")));
		
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