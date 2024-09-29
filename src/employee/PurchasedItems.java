package employee;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.*;

import userdefined.RoundedLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import gettersetter.GetSetEmployee;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class PurchasedItems {

	private JFrame frame = new JFrame();
	private JTable table;
	private DefaultTableModel model;
	private GetSetEmployee employee;
	private Object[] row;
	@SuppressWarnings("rawtypes")
	private HashMap<String,ArrayList> map;
	private JScrollPane scrollPane;
	private JPanel panel_2, panel_1;
	private JLabel lblTotalBill,rs_label,total_label,id_label;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

	public PurchasedItems(GetSetEmployee employee,@SuppressWarnings("rawtypes") HashMap<String,ArrayList> map) {
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

	        // Set the renderer for each column
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

		panel_2.setBounds(745,tableHeight+rc1.y+35,182,45);
		total_label.setText(String.valueOf(total_bill));
	}
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frame.setTitle("Purchased Items");
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
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Purchased Items");
		lblNewLabel_5_1_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_5_1_1.setFont(new Font("Cooper Black", Font.BOLD, 32));
		lblNewLabel_5_1_1.setBounds(579, 27, 343, 47);
		panel.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_9 = new JLabel("Back");
		lblNewLabel_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new StartBilling(employee,map);
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
		lblNewLabel_9.setBounds(1245, 30, 65, 34);
		panel.add(lblNewLabel_9);
		
		JLabel wel_name_label = new JLabel(employee.getName());
		wel_name_label.setForeground(new Color(255, 255, 224));
		wel_name_label.setFont(new Font("Cooper Black", Font.BOLD, 24));
		wel_name_label.setBounds(182, 27, 257, 47);
		panel.add(wel_name_label);
		
		JLabel lblNewLabel_5 = new JLabel("Welcome");
		lblNewLabel_5.setForeground(new Color(255, 255, 224));
		lblNewLabel_5.setFont(new Font("Cooper Black", Font.BOLD, 24));
		lblNewLabel_5.setBounds(57, 27, 121, 47);
		panel.add(lblNewLabel_5);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(159, 217, 217));
		panel_1.setBounds(0, 100, 1364, 642);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel next_label = new JLabel("");
		next_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FinalBilling(employee,map);
				frame.setVisible(false);
			}
		});
		next_label.setBackground(new Color(15, 164, 149));
		next_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		next_label.setIcon(new ImageIcon(PurchasedItems.class.getResource("/images/next.png")));
		next_label.setBounds(1010, 367, 67, 42);
		panel_1.add(next_label);
		
		id_label = new JLabel("______");
		id_label.setForeground(Color.WHITE);
		id_label.setFont(new Font("Rockwell", Font.PLAIN, 16));
		id_label.setBounds(1010, 153, 110, 25);
		panel_1.add(id_label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = id_label.getText();
				if(!id.equals("")) {
					map.remove(id);
					getDetails();
					id_label.setText("______");
					comboBox.removeAllItems();
				}
				
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setIcon(new ImageIcon(PurchasedItems.class.getResource("/images/delete.png")));
		lblNewLabel.setBounds(982, 296, 50, 50);
		panel_1.add(lblNewLabel);
		
		JLabel lblItemQuantity = new JLabel("Item Quantity:");
		lblItemQuantity.setForeground(Color.WHITE);
		lblItemQuantity.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblItemQuantity.setBounds(982, 197, 118, 25);
		panel_1.add(lblItemQuantity);
		
		JLabel oldpwdtext = new JLabel("Item Id:");
		oldpwdtext.setForeground(Color.WHITE);
		oldpwdtext.setFont(new Font("Rockwell", Font.BOLD, 16));
		oldpwdtext.setBounds(1001, 122, 79, 25);
		panel_1.add(oldpwdtext);
		
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.addMouseListener(new MouseAdapter() {
					@SuppressWarnings("unchecked")
					@Override
					public void mouseClicked(MouseEvent e) {
						String id = id_label.getText();
						if(comboBox.getSelectedItem() != null){
							String quantity = (String) comboBox.getSelectedItem();
							if(map.get(id).get(2) != quantity){
								ArrayList al = map.get(id);
								al.set(2,quantity);
								map.replace(id, al);

								String price = (String) al.get(1);
								int total = Integer.parseInt(price) * Integer.parseInt(quantity);
								al.set(3,String.valueOf(total));

								getDetails();
							}
						}
						
					}
				});
				lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblNewLabel_1.setIcon(new ImageIcon(PurchasedItems.class.getResource("/images/update.png")));
				lblNewLabel_1.setBounds(1065, 296, 51, 45);
				panel_1.add(lblNewLabel_1);
		

		comboBox = new JComboBox();
		comboBox.setBounds(993, 233, 95, 25);
		panel_1.add(comboBox);
		
		RoundedLabel panel_2_1 = new RoundedLabel("", 30, new Color(15, 164, 149), Color.BLACK, 1);
		panel_2_1.setBounds(955, 101, 177, 323);
		panel_1.add(panel_2_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(46, 79, 79));
		panel_2.setLayout(null);
		
		panel_2.setBounds(745, 177, 182, 45);
		panel_1.add(panel_2);
		lblTotalBill = new JLabel("Total Bill:");
		lblTotalBill.setBounds(0, 11, 80, 25);
		lblTotalBill.setForeground(new Color(255, 255, 255));
		lblTotalBill.setFont(new Font("Rockwell", Font.BOLD, 16));
		panel_2.add(lblTotalBill);
		
		rs_label = new JLabel("Rs.");
		rs_label.setBounds(90, 11, 26, 25);
		rs_label.setForeground(Color.WHITE);
		rs_label.setFont(new Font("Rockwell", Font.PLAIN, 16));
		panel_2.add(rs_label);
		
		total_label = new JLabel("______");
		total_label.setBounds(113, 11, 95, 25);
		total_label.setForeground(Color.WHITE);
		total_label.setFont(new Font("Rockwell", Font.PLAIN, 16));
		panel_2.add(total_label);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(311, 122, 616, 29);
		panel_1.add(scrollPane);
		
		
		String[] cols = new String[]{"Sr No","Item id","Item Name","Item Price","Quantity","Total Price"};
		Object[][] data = new Object[][] {
			
		};
		
		model = new DefaultTableModel(data,cols) {
		
			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@SuppressWarnings({"unchecked" })
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				String id = (String) table.getValueAt(i, 1);
				String quantity = (String) map.get(id).get(2);
				id_label.setText(id);
				comboBox.setModel(new DefaultComboBoxModel(
					new String[]{
						"1","2","3","4","5","6","7","8"
					}
				));
				comboBox.setSelectedIndex(Integer.parseInt(quantity)-1);
			}
		});
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
		panel_6.setBounds(257, 11, 888, 579);
		panel_1.add(panel_6);
	}
}
