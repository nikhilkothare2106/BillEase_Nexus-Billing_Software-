package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.border.*;
import userdefined.RoundedLabel;
import dbconnection.DbOperations;
import java.sql.ResultSet;

public class ViewAllEmployee {

	private JFrame frame = new JFrame();
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;
	private JScrollPane scrollPane;
	
	public ViewAllEmployee() {
		initialize();
		frame.setVisible(true);
	}

	private void setTableHeight() {
		int rowCount = table.getRowCount();
		int rowHeight = table.getRowHeight();
		int tableHeight = rowCount * rowHeight;

		Rectangle rc = table.getBounds();
		table.setPreferredSize(new Dimension(table.getPreferredSize().width, tableHeight));
		table.setBounds(rc.x, rc.y, rc.width, tableHeight);
		Rectangle rc1 = scrollPane.getBounds();
		if(scrollPane.getBounds().height < 476){
			scrollPane.setBounds(rc1.x, rc1.y, rc1.width, tableHeight + 30);
		}
	}
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try{
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

					        for (int i = 0; i < table.getColumnCount(); i++) {
					            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
					        }
						}
						setTableHeight();
					}
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		frame.setBounds(0, 0, 1380, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 79, 79));
		panel.setBounds(0, 0, 1364, 100);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("  Log out");
		lblNewLabel_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		
		JLabel lblNewLabel_5_1_1 = new JLabel("View Employees");
		lblNewLabel_5_1_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_5_1_1.setFont(new Font("Cooper Black", Font.BOLD, 32));
		lblNewLabel_5_1_1.setBounds(626, 27, 288, 47);
		panel.add(lblNewLabel_5_1_1);
		lblNewLabel_9.setForeground(new Color(240, 0, 0));
		lblNewLabel_9.setFont(new Font("Rockwell", Font.BOLD, 22));
		lblNewLabel_9.setBounds(1198, 27, 108, 34);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_5_1 = new JLabel("Nikhil");
		lblNewLabel_5_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_5_1.setFont(new Font("Cooper Black", Font.BOLD, 24));
		lblNewLabel_5_1.setBounds(182, 27, 99, 47);
		panel.add(lblNewLabel_5_1);
		
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
		
		JLabel lblNewLabel = new JLabel("Employee Details");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 22));
		lblNewLabel.setBounds(663, 88, 191, 25);
		panel_1.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBackground(Color.BLACK);
		scrollPane.setBounds(477, 133, 522, 25);
		panel_1.add(scrollPane);
		
		
		String[] cols = new String[]{"Sr No","Name","Email","Gender","Phone No"};
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
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.setBorder(null);
		scrollPane.setViewportView(table);
		
		RoundedLabel panel_6 = new RoundedLabel("", 30, new Color(46,79,79), Color.BLACK, 1);
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(46, 79, 79));
		panel_6.setBounds(285, 37, 888, 579);
		panel_1.add(panel_6);
	}
}
