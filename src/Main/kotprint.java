
package Main;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.*;

import javax.print.attribute.standard.Destination;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import javax.swing.table.*;
import javax.swing.GroupLayout.Alignment;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//@SuppressWarnings("all")
public class kotprint extends JFrame implements Printable {
    private JPanel contentPanel;
    
    private JTable SouthIndianTable;
    private JTable MumbaiChaatTable;
    private JTable IndianVegTable;
    private JTable BeveragesTable;
    private JTable CombosTable;
    private JTable ExtrasTable;
    
    private DefaultTableModel SouthIndianTableMODEL;
    private DefaultTableModel MumbaiChaatTableMODEL;
    private DefaultTableModel IndianVegTableMODEL;
    private DefaultTableModel BeveragesTableMODEL;
    private DefaultTableModel CombosTableMODEL;
    private DefaultTableModel ExtrasTableMODEL;
    
    private DefaultTableModel Model;
    private DefaultTableModel secondTableModel;
	private DefaultTableModel thirdTableModel;
	private DefaultTableModel fourthTableModel;
	private DefaultTableModel fifthTableModel;
	private DefaultTableModel sixthTableModel;
	private DefaultTableModel seventhTableModel;
	
	
	private JTable ChineseVegTable;
	private DefaultTableModel ChineseVegTableModel;
    
	private JLabel invoiceLabel;
	private JLabel ColumnLabel;
    
	

	private JLabel southIndianLabel;
	private JLabel MumbaiChaatLabel;
	private JLabel ExtrasLabel;
	private JLabel ChineseVegLabel;
	private JLabel IndianVegLabel;
	private JLabel BeveragesLabel;
	private JLabel CombosLabel;

	private String label;

	private JLabel BillNo_2;

	private JLabel BillNo_1_3;

	

    
    public kotprint(DefaultTableModel tableModel2,DefaultTableModel tableModel3, DefaultTableModel tableModel4,DefaultTableModel tableModel5,DefaultTableModel tableModel6,DefaultTableModel tableModel7,DefaultTableModel tableModel8, String label1) {
    	this.Model=tableModel2;
    	this.secondTableModel=tableModel3;
    	this.fourthTableModel=tableModel4;
    	this.fifthTableModel=tableModel5;
    	this.thirdTableModel=tableModel6;
    	this.sixthTableModel=tableModel7;
    	this.seventhTableModel=tableModel8;
    	this.label=label1;
        createGUI();
    }

    private void createGUI() {
        setTitle("");
        setIconImage(Toolkit.getDefaultToolkit().getImage(kotprint.class.getResource("/images/LOGO-removebg-preview.png")));
        setSize(270, 1000000); // Adjust the height to accommodate the second table
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

     
        
        JLabel titleLabel = new JLabel("FOOD   CHAIN");
        titleLabel.setFont(new Font("Arial Narrow", Font.BOLD, 10));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align the title
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel BillDate = new JLabel("Date:");
        BillDate.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BillDate.setAlignmentX(Component.CENTER_ALIGNMENT);
        BillDate.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel invoiceLabel = new JLabel("K O T");
        invoiceLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
        invoiceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        invoiceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        BillNo_2 = new JLabel("");
        BillNo_2.setHorizontalAlignment(SwingConstants.LEFT);
        BillNo_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BillNo_2.setAlignmentX(0.5f);

        JLabel BillNo_1_2 = new JLabel("Time:");
        BillNo_1_2.setHorizontalAlignment(SwingConstants.LEFT);
        BillNo_1_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BillNo_1_2.setAlignmentX(0.5f);
        
        BillNo_1_3 = new JLabel("");
        BillNo_1_3.setHorizontalAlignment(SwingConstants.LEFT);
        BillNo_1_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BillNo_1_3.setAlignmentX(0.5f);

        JLabel ColumnLabel = new JLabel("No   Item Description                                                   Qty");
        ColumnLabel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 8));
        ColumnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        String[] columnNames = {"Item Description", "Quantity", "    Amount"};
        
        SouthIndianTableMODEL=Model;
//        Model = new DefaultTableModel(columnNames, 0);
        SouthIndianTable = createTable(SouthIndianTableMODEL);
        // Set custom renderer for the third column
//        TableColumnModel columnModel = SouthIndianTable.getColumnModel();
//        columnModel.getColumn(2).setCellRenderer(new CustomCellRenderer());

        
        MumbaiChaatTableMODEL=secondTableModel;
//        secondTableModel = new DefaultTableModel(columnNames, 0);
        MumbaiChaatTable = createTable(MumbaiChaatTableMODEL);
        // Set custom renderer for the third column
//        TableColumnModel columnModel2 = MumbaiChaatTable.getColumnModel();
//        columnModel2.getColumn(2).setCellRenderer(new CustomCellRenderer());
        
        ChineseVegTableModel=thirdTableModel;
//        thirdTableModel = new DefaultTableModel(columnNames, 0);
        ChineseVegTable = createTable(ChineseVegTableModel);
     // Set custom renderer for the third column
//        TableColumnModel columnModel5 = ChineseVegTable.getColumnModel();
//        columnModel5.getColumn(2).setCellRenderer(new CustomCellRenderer());
        
//        thirdTableModel.addRow(new Object[]{"ChineseVegTable",  "Disc", "Net Value"});
        
//        fourthTableModel = new DefaultTableModel(columnNames, 0);
        IndianVegTableMODEL=fourthTableModel;
        IndianVegTable = createTable(IndianVegTableMODEL);
     // Set custom renderer for the third column
//        TableColumnModel columnModel3 = IndianVegTable.getColumnModel();
//        columnModel3.getColumn(2).setCellRenderer(new CustomCellRenderer());
//        fourthTableModel.addRow(new Object[]{"IndianVegTable", "Disc", "Net Value"});
        
//        fifthTableModel = new DefaultTableModel(columnNames, 0);
        BeveragesTableMODEL=fifthTableModel;
        BeveragesTable = createTable(BeveragesTableMODEL);
     // Set custom renderer for the third column
//        TableColumnModel columnModel4 = BeveragesTable.getColumnModel();
//        columnModel4.getColumn(2).setCellRenderer(new CustomCellRenderer());
//        fifthTableModel.addRow(new Object[]{"BeveragesTable", "Disc", "Net Value"});
        
        CombosTableMODEL=sixthTableModel;
//        sixthTableModel = new DefaultTableModel(columnNames, 0);
        CombosTable = createTable(CombosTableMODEL);
        // Set custom renderer for the third column
//        TableColumnModel columnModel6 = CombosTable.getColumnModel();
//        columnModel6.getColumn(2).setCellRenderer(new CustomCellRenderer());
//        sixthTableModel.addRow(new Object[]{"CombosTable", "Disc", "Net Value"});
        
        
        ExtrasTableMODEL=seventhTableModel;
//        seventhTableModel = new DefaultTableModel(columnNames, 0);
        ExtrasTable = createTable(ExtrasTableMODEL);
        // Set custom renderer for the third column
//        TableColumnModel columnModel7 = ExtrasTable.getColumnModel();
//        columnModel7.getColumn(2).setCellRenderer(new CustomCellRenderer());
//        seventhTableModel.addRow(new Object[]{"ExtrasTable", "Disc", "Net Value"});
        
        JSeparator separator0 = new JSeparator();
        separator0.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separator0.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separator01 = new JSeparator();
        separator01.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separator01.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separator02 = new JSeparator();
        separator02.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separator02.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separator03 = new JSeparator();
        separator03.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separator03.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separator04 = new JSeparator();
        separator04.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separator04.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separator05 = new JSeparator();
        separator05.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separator05.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separator06 = new JSeparator();
        separator06.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separator06.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separator1 = new JSeparator();
        separator1.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separator1.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separator2 = new JSeparator();
        separator2.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separator2.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separator21 = new JSeparator();
//        separator21.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separator21.setForeground(Color.BLACK); // Set separator color to black
        separator21.setBackground(Color.BLACK);
        
        JSeparator separator3 = new JSeparator();
        separator3.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separator3.setForeground(Color.BLACK); // Set separator color to black
        separator3.setBackground(Color.BLACK);

        JLabel BillNo = new JLabel("KOT No:");
        BillNo.setFont(new Font("Tahoma", Font.PLAIN, 9));
        BillNo.setAlignmentX(Component.CENTER_ALIGNMENT);
        BillNo.setHorizontalAlignment(SwingConstants.LEFT);
        
        JLabel BillNo_1 = new JLabel(label);
        BillNo_1.setHorizontalAlignment(SwingConstants.LEFT);
        BillNo_1.setFont(new Font("Arial", Font.BOLD, 10));
        BillNo_1.setAlignmentX(0.5f);
        
       
        
        JLabel BillNo_1_1 = new JLabel("Eat-In");
        BillNo_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        BillNo_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 10));
        BillNo_1_1.setAlignmentX(0.5f);
        
        southIndianLabel = new JLabel("<html>Food - South &ensp;Indian</html>");
        southIndianLabel.setFont(new Font("Arial Unicode MS", Font.BOLD, 8));
        
//        MumbaiChaatLabel = new JLabel("Food - Mumbai Chaat");
//        MumbaiChaatLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
//        
//        ChineseVegLabel = new JLabel("Food - Chinese Veg.");
//        ChineseVegLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
//        
//        IndianVegLabel = new JLabel("Food - Indian Veg.");
//        IndianVegLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
//        
//        BeveragesLabel = new JLabel("Food - Beverages");
//        BeveragesLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
//        
//        CombosLabel = new JLabel("Food - Combos");
//        CombosLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
//        
//        ExtrasLabel = new JLabel("Food - Extra");
//        ExtrasLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
        
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        GroupLayout.ParallelGroup hGroup = gl_contentPanel.createParallelGroup(Alignment.LEADING);
        GroupLayout.SequentialGroup vGroup = gl_contentPanel.createSequentialGroup();

        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	    .addGap(80)
        	    .addComponent(titleLabel));
        	hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	    .addGap(80)
        	    .addComponent(invoiceLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE));
        	hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        			.addGap(5)
        	        .addComponent(separator21)
        	        );
        	hGroup.addGroup(gl_contentPanel.createSequentialGroup()
            	    .addGap(5)
            	    .addComponent(BillNo, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
            	    .addComponent(BillNo_1)
            	    .addGap(36)
            	    .addComponent(BillNo_1_1));
        	hGroup.addGroup(gl_contentPanel.createSequentialGroup()
            	     .addGap(5)
                    .addComponent(BillDate, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    
                    .addComponent(BillNo_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                    .addGap(10)
	                .addComponent(BillNo_1_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
	                .addGap(2) // Reduce the gap here
	                .addComponent(BillNo_1_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE));
        	hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        			.addGap(5)
        	    .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
        	    		
        	        .addComponent(separator1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
        	        .addGroup(gl_contentPanel.createSequentialGroup()
//        	        .addGap(11)
        	        .addComponent(ColumnLabel))
        	        .addComponent(separator2, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)));
        	// Add the label to the horizontal group
        	hGroup.addGroup(gl_contentPanel.createSequentialGroup()
//        	        .addGap(11)
        			.addGap(5)
        	        .addComponent(southIndianLabel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE));
        	
        	// Set the vertical layout with no gap between separator2 and SouthIndianTable
        	vGroup.addComponent(titleLabel)
        	    .addGap(5)
        	    .addComponent(invoiceLabel)
        	    .addGap(3)
        	    .addComponent(separator21, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
        	    .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(BillNo)
						.addComponent(BillNo_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
						.addComponent(BillNo_1_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
						.addGap(17)))
        	    .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(BillDate)
						
						.addComponent(BillNo_2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
						.addComponent(BillNo_1_2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        				.addComponent(BillNo_1_3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        				.addGap(20))
        	    .addComponent(separator1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
        	    .addComponent(ColumnLabel, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
        	    .addComponent(separator2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE) // Ensure gap is set to 2
        	.addComponent(southIndianLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE);
        	
           
            int counter=1;
        if (!isTableEmpty(Model)) {
        	int row=Model.getRowCount();
        	
        	
//            ================================ FOR 1 ROW ========================================
            if(row==1) {
            	
            	JLabel lblNewLabel_1 = new JLabel();
//        		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
        		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
        		
        		JLabel lblNewLabel_1_2 = new JLabel();
//        		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
        		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
        		setLabelIfNotEmpty(lblNewLabel_1_2, Model.getValueAt(0, 1).toString());
        		
        		JLabel lblNewLabel_1_3 = new JLabel();
        		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//        		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
        		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
        		setLabelIfNotEmpty(lblNewLabel_1_3, Model.getValueAt(0, 2).toString());
        		
        		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
        		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_1_2)
						.addComponent(lblNewLabel_1_3));
            }
//          ================================ FOR 2 ROWS ========================================
          if(row==2) {
          	
          	JLabel lblNewLabel_1 = new JLabel();
//      		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
      		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
      		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
      		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
      		
      		JLabel lblNewLabel_1_2 = new JLabel();
//      		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
      		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
      		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
      		setLabelIfNotEmpty(lblNewLabel_1_2, Model.getValueAt(0, 1).toString());
      		
      		JLabel lblNewLabel_1_3 = new JLabel();
      		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//      		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
      		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
      		setLabelIfNotEmpty(lblNewLabel_1_3, Model.getValueAt(0, 2).toString());

      		JLabel lblNewLabel_2_1 = new JLabel();
      		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//      		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
      		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
      		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
      		
      		JLabel lblNewLabel_2_2 = new JLabel();
      		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//      		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
      		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
      		setLabelIfNotEmpty(lblNewLabel_2_2, Model.getValueAt(1, 1).toString());
      		
      		JLabel lblNewLabel_2_3 = new JLabel();
      		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//      		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
      		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
      		setLabelIfNotEmpty(lblNewLabel_2_3, Model.getValueAt(1, 2).toString());
      		
      		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(1)
								.addGap(4)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
      		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
      		
      		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
      		
      		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
          }            
//        ================================ FOR 3 ROWS ========================================
        if(row==3) {
        	
        	JLabel lblNewLabel_1 = new JLabel();
//    		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
    		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
    		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
    		
    		JLabel lblNewLabel_1_2 = new JLabel();
//    		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
    		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
    		setLabelIfNotEmpty(lblNewLabel_1_2, Model.getValueAt(0, 1).toString());
    		
    		JLabel lblNewLabel_1_3 = new JLabel();
    		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//    		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
    		setLabelIfNotEmpty(lblNewLabel_1_3, Model.getValueAt(0, 2).toString());

    		JLabel lblNewLabel_2_1 = new JLabel();
    		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//    		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
    		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
    		
    		JLabel lblNewLabel_2_2 = new JLabel();
    		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//    		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
    		setLabelIfNotEmpty(lblNewLabel_2_2, Model.getValueAt(1, 1).toString());
    		
    		JLabel lblNewLabel_2_3 = new JLabel();
    		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//    		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
    		setLabelIfNotEmpty(lblNewLabel_2_3, Model.getValueAt(1, 2).toString());
    		
    		JLabel lblNewLabel_3_1 = new JLabel();
    		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//    		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
    		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
    		
    		JLabel lblNewLabel_3_2 = new JLabel();
    		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//    		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
    		setLabelIfNotEmpty(lblNewLabel_3_2, Model.getValueAt(2, 1).toString());
    		
    		JLabel lblNewLabel_3_3 = new JLabel();
    		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//    		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
    		setLabelIfNotEmpty(lblNewLabel_3_3, Model.getValueAt(2, 2).toString());
    		
    		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
    		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
    		
    		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
    		
    		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
    		
    		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
    		
    		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
        }             
//      ================================ FOR 4 ROWS ========================================
      if(row==4) {
      	
      	JLabel lblNewLabel_1 = new JLabel();
//  		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
  		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
  		
  		JLabel lblNewLabel_1_2 = new JLabel();
//  		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
  		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
  		setLabelIfNotEmpty(lblNewLabel_1_2, Model.getValueAt(0, 1).toString());
  		
  		JLabel lblNewLabel_1_3 = new JLabel();
  		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//  		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_1_3, Model.getValueAt(0, 2).toString());

  		JLabel lblNewLabel_2_1 = new JLabel();
  		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//  		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
  		
  		JLabel lblNewLabel_2_2 = new JLabel();
  		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//  		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
  		setLabelIfNotEmpty(lblNewLabel_2_2, Model.getValueAt(1, 1).toString());
  		
  		JLabel lblNewLabel_2_3 = new JLabel();
  		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//  		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_2_3, Model.getValueAt(1, 2).toString());
  		
  		JLabel lblNewLabel_3_1 = new JLabel();
  		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//  		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
  		
  		JLabel lblNewLabel_3_2 = new JLabel();
  		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//  		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
  		setLabelIfNotEmpty(lblNewLabel_3_2, Model.getValueAt(2, 1).toString());
  		
  		JLabel lblNewLabel_3_3 = new JLabel();
  		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//  		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_3_3, Model.getValueAt(2, 2).toString());
  		
  		JLabel lblNewLabel_4_1 = new JLabel();
  		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//  		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
  		
  		JLabel lblNewLabel_4_2 = new JLabel();
  		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//  		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
  		setLabelIfNotEmpty(lblNewLabel_4_2, Model.getValueAt(3, 1).toString());
  		
  		JLabel lblNewLabel_4_3 = new JLabel();
  		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//  		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_4_3, Model.getValueAt(3, 2).toString());
  		
  		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
  		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
  		
  		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
  		
  		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
  		
  		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
  		
  		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
  		
  		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
      }             
//    ================================ FOR 5 ROWS ========================================
    if(row==5) {
    	
    	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, Model.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, Model.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, Model.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, Model.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, Model.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, Model.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, Model.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, Model.getValueAt(3, 2).toString());
		
		JLabel lblNewLabel_5_1 = new JLabel();
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_1, counter+++".");
		
		JLabel lblNewLabel_5_2 = new JLabel();
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_5_2, Model.getValueAt(4, 1).toString());
		
		JLabel lblNewLabel_5_3 = new JLabel();
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_3, Model.getValueAt(4, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_5_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_5_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_5_1)
				.addComponent(lblNewLabel_5_2)
				.addComponent(lblNewLabel_5_3));
    }             
//  ================================ FOR 6 ROWS ========================================
  if(row==6) {
  	
  	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, Model.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, Model.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, Model.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, Model.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, Model.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, Model.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, Model.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, Model.getValueAt(3, 2).toString());
		
		JLabel lblNewLabel_5_1 = new JLabel();
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_1, counter+++".");
		
		JLabel lblNewLabel_5_2 = new JLabel();
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_5_2, Model.getValueAt(4, 1).toString());
		
		JLabel lblNewLabel_5_3 = new JLabel();
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_3, Model.getValueAt(4, 2).toString());
		
		JLabel lblNewLabel_6_1 = new JLabel();
		lblNewLabel_6_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_1, counter+++".");
		
		JLabel lblNewLabel_6_2 = new JLabel();
		lblNewLabel_6_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_6_2, Model.getValueAt(5, 1).toString());
		
		JLabel lblNewLabel_6_3 = new JLabel();
		lblNewLabel_6_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_3, Model.getValueAt(5, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_5_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_5_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_5_1)
				.addComponent(lblNewLabel_5_2)
				.addComponent(lblNewLabel_5_3));
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_6_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_6_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_6_1)
				.addComponent(lblNewLabel_6_2)
				.addComponent(lblNewLabel_6_3));
  }             
//================================ FOR 7 ROWS ========================================
if(row==7) {
	
	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, Model.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, Model.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, Model.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, Model.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, Model.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, Model.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, Model.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, Model.getValueAt(3, 2).toString());
		
		JLabel lblNewLabel_5_1 = new JLabel();
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_1, counter+++".");
		
		JLabel lblNewLabel_5_2 = new JLabel();
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_5_2, Model.getValueAt(4, 1).toString());
		
		JLabel lblNewLabel_5_3 = new JLabel();
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_3, Model.getValueAt(4, 2).toString());
		
		JLabel lblNewLabel_6_1 = new JLabel();
		lblNewLabel_6_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_1, counter+++".");
		
		JLabel lblNewLabel_6_2 = new JLabel();
		lblNewLabel_6_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_6_2, Model.getValueAt(5, 1).toString());
		
		JLabel lblNewLabel_6_3 = new JLabel();
		lblNewLabel_6_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_3, Model.getValueAt(5, 2).toString());
		
		JLabel lblNewLabel_7_1 = new JLabel();
		lblNewLabel_7_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_1, counter+++".");
		
		JLabel lblNewLabel_7_2 = new JLabel();
		lblNewLabel_7_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_7_2, Model.getValueAt(6, 1).toString());
		
		JLabel lblNewLabel_7_3 = new JLabel();
		lblNewLabel_7_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_3, Model.getValueAt(6, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_5_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_5_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_5_1)
				.addComponent(lblNewLabel_5_2)
				.addComponent(lblNewLabel_5_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_6_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_6_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_6_1)
				.addComponent(lblNewLabel_6_2)
				.addComponent(lblNewLabel_6_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_7_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_7_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_7_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_7_1)
				.addComponent(lblNewLabel_7_2)
				.addComponent(lblNewLabel_7_3));
}       
//================================ FOR 8 ROWS ========================================
if(row==8) {
	
	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, Model.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, Model.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, Model.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, Model.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, Model.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, Model.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, Model.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, Model.getValueAt(3, 2).toString());
		
		JLabel lblNewLabel_5_1 = new JLabel();
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_1, counter+++".");
		
		JLabel lblNewLabel_5_2 = new JLabel();
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_5_2, Model.getValueAt(4, 1).toString());
		
		JLabel lblNewLabel_5_3 = new JLabel();
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_3, Model.getValueAt(4, 2).toString());
		
		JLabel lblNewLabel_6_1 = new JLabel();
		lblNewLabel_6_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_1, counter+++".");
		
		JLabel lblNewLabel_6_2 = new JLabel();
		lblNewLabel_6_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_6_2, Model.getValueAt(5, 1).toString());
		
		JLabel lblNewLabel_6_3 = new JLabel();
		lblNewLabel_6_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_3, Model.getValueAt(5, 2).toString());
		
		JLabel lblNewLabel_7_1 = new JLabel();
		lblNewLabel_7_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_1, counter+++".");
		
		JLabel lblNewLabel_7_2 = new JLabel();
		lblNewLabel_7_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_7_2, Model.getValueAt(6, 1).toString());
		
		JLabel lblNewLabel_7_3 = new JLabel();
		lblNewLabel_7_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_3, Model.getValueAt(6, 2).toString());

		JLabel lblNewLabel_8_1 = new JLabel();
		lblNewLabel_8_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_8_1, counter+++".");
		
		JLabel lblNewLabel_8_2 = new JLabel();
		lblNewLabel_8_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_8_2, Model.getValueAt(7, 1).toString());
		
		JLabel lblNewLabel_8_3 = new JLabel();
		lblNewLabel_8_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_8_3, Model.getValueAt(7, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_5_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_5_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_5_1)
				.addComponent(lblNewLabel_5_2)
				.addComponent(lblNewLabel_5_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_6_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_6_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_6_1)
				.addComponent(lblNewLabel_6_2)
				.addComponent(lblNewLabel_6_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_7_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_7_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_7_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_7_1)
				.addComponent(lblNewLabel_7_2)
				.addComponent(lblNewLabel_7_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_8_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_8_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_8_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_8_1)
				.addComponent(lblNewLabel_8_2)
				.addComponent(lblNewLabel_8_3));
}       
//================================ FOR 9 ROWS ========================================
if(row==9) {
	
	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, Model.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, Model.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, Model.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, Model.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, Model.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, Model.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, Model.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, Model.getValueAt(3, 2).toString());
		
		JLabel lblNewLabel_5_1 = new JLabel();
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_1, counter+++".");
		
		JLabel lblNewLabel_5_2 = new JLabel();
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_5_2, Model.getValueAt(4, 1).toString());
		
		JLabel lblNewLabel_5_3 = new JLabel();
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_3, Model.getValueAt(4, 2).toString());
		
		JLabel lblNewLabel_6_1 = new JLabel();
		lblNewLabel_6_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_1, counter+++".");
		
		JLabel lblNewLabel_6_2 = new JLabel();
		lblNewLabel_6_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_6_2, Model.getValueAt(5, 1).toString());
		
		JLabel lblNewLabel_6_3 = new JLabel();
		lblNewLabel_6_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_3, Model.getValueAt(5, 2).toString());
		
		JLabel lblNewLabel_7_1 = new JLabel();
		lblNewLabel_7_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_1, counter+++".");
		
		JLabel lblNewLabel_7_2 = new JLabel();
		lblNewLabel_7_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_7_2, Model.getValueAt(6, 1).toString());
		
		JLabel lblNewLabel_7_3 = new JLabel();
		lblNewLabel_7_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_3, Model.getValueAt(6, 2).toString());

		JLabel lblNewLabel_8_1 = new JLabel();
		lblNewLabel_8_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_8_1, counter+++".");
		
		JLabel lblNewLabel_8_2 = new JLabel();
		lblNewLabel_8_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_8_2, Model.getValueAt(7, 1).toString());
		
		JLabel lblNewLabel_8_3 = new JLabel();
		lblNewLabel_8_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_8_3, Model.getValueAt(7, 2).toString());
		
		JLabel lblNewLabel_9_1 = new JLabel();
		lblNewLabel_9_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_9_1, counter+++".");
		
		JLabel lblNewLabel_9_2 = new JLabel();
		lblNewLabel_9_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_9_2, Model.getValueAt(8, 1).toString());
		
		JLabel lblNewLabel_9_3 = new JLabel();
		lblNewLabel_9_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_9_3, Model.getValueAt(8, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_5_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_5_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_5_1)
				.addComponent(lblNewLabel_5_2)
				.addComponent(lblNewLabel_5_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_6_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_6_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_6_1)
				.addComponent(lblNewLabel_6_2)
				.addComponent(lblNewLabel_6_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_7_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_7_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_7_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_7_1)
				.addComponent(lblNewLabel_7_2)
				.addComponent(lblNewLabel_7_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_8_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_8_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_8_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_8_1)
				.addComponent(lblNewLabel_8_2)
				.addComponent(lblNewLabel_8_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_9_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_9_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_9_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_9_1)
				.addComponent(lblNewLabel_9_2)
				.addComponent(lblNewLabel_9_3));
}  
//================================ FOR 9 ROWS ========================================
if(row==10) {
	
	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, Model.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, Model.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, Model.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, Model.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, Model.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, Model.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, Model.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, Model.getValueAt(3, 2).toString());
		
		JLabel lblNewLabel_5_1 = new JLabel();
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_1, counter+++".");
		
		JLabel lblNewLabel_5_2 = new JLabel();
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_5_2, Model.getValueAt(4, 1).toString());
		
		JLabel lblNewLabel_5_3 = new JLabel();
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_3, Model.getValueAt(4, 2).toString());
		
		JLabel lblNewLabel_6_1 = new JLabel();
		lblNewLabel_6_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_1, counter+++".");
		
		JLabel lblNewLabel_6_2 = new JLabel();
		lblNewLabel_6_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_6_2, Model.getValueAt(5, 1).toString());
		
		JLabel lblNewLabel_6_3 = new JLabel();
		lblNewLabel_6_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_3, Model.getValueAt(5, 2).toString());
		
		JLabel lblNewLabel_7_1 = new JLabel();
		lblNewLabel_7_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_1, counter+++".");
		
		JLabel lblNewLabel_7_2 = new JLabel();
		lblNewLabel_7_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_7_2, Model.getValueAt(6, 1).toString());
		
		JLabel lblNewLabel_7_3 = new JLabel();
		lblNewLabel_7_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_3, Model.getValueAt(6, 2).toString());

		JLabel lblNewLabel_8_1 = new JLabel();
		lblNewLabel_8_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_8_1, counter+++".");
		
		JLabel lblNewLabel_8_2 = new JLabel();
		lblNewLabel_8_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_8_2, Model.getValueAt(7, 1).toString());
		
		JLabel lblNewLabel_8_3 = new JLabel();
		lblNewLabel_8_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_8_3, Model.getValueAt(7, 2).toString());
		
		JLabel lblNewLabel_9_1 = new JLabel();
		lblNewLabel_9_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_9_1, counter+++".");
		
		JLabel lblNewLabel_9_2 = new JLabel();
		lblNewLabel_9_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_9_2, Model.getValueAt(8, 1).toString());
		
		JLabel lblNewLabel_9_3 = new JLabel();
		lblNewLabel_9_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_9_3, Model.getValueAt(8, 2).toString());
		
		JLabel lblNewLabel_10_1 = new JLabel();
		lblNewLabel_10_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_10_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_10_1, counter+++".");
		
		JLabel lblNewLabel_10_2 = new JLabel();
		lblNewLabel_10_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_10_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_10_2, Model.getValueAt(9, 1).toString());
		
		JLabel lblNewLabel_10_3 = new JLabel();
		lblNewLabel_10_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_10_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_10_3, Model.getValueAt(9, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_5_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_5_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_5_1)
				.addComponent(lblNewLabel_5_2)
				.addComponent(lblNewLabel_5_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_6_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_6_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_6_1)
				.addComponent(lblNewLabel_6_2)
				.addComponent(lblNewLabel_6_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_7_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_7_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_7_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_7_1)
				.addComponent(lblNewLabel_7_2)
				.addComponent(lblNewLabel_7_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_8_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_8_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_8_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_8_1)
				.addComponent(lblNewLabel_8_2)
				.addComponent(lblNewLabel_8_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_9_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_9_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_9_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_9_1)
				.addComponent(lblNewLabel_9_2)
				.addComponent(lblNewLabel_9_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_10_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_10_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_10_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_10_1)
				.addComponent(lblNewLabel_10_2)
				.addComponent(lblNewLabel_10_3));
}       
        
        
          
//            hGroup.addComponent(separator0);
//            vGroup.addGap(2).addComponent(separator0, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE);
           
        }
        

        if (!isTableEmpty(secondTableModel)) {
        	int row=secondTableModel.getRowCount();
        	// Add the label to the horizontal group
//        	hGroup.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
////        	        .addGap(15)
//        	        .addComponent(MumbaiChaatLabel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE));
//            // Add the label to the vertical group
//            vGroup.addComponent(MumbaiChaatLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE);
        	for(int i=0;i<secondTableModel.getRowCount();i++)
        	{
        		secondTableModel.setValueAt(Integer.toString(counter++)+".   ", i, 0);
        		
        	}

            JScrollPane secondScrollPane = createScrollPane(MumbaiChaatTable);
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
//        	        .addGap(10)
        	        .addComponent(secondScrollPane, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(secondScrollPane, GroupLayout.PREFERRED_SIZE, ((row*11)), GroupLayout.PREFERRED_SIZE);
//            
//            hGroup.addComponent(separator01);
//            vGroup.addComponent(separator01, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE);
        }

        if (!isTableEmpty(thirdTableModel)) {
        	int row=thirdTableModel.getRowCount();
        	// Add the label to the horizontal group
//        	hGroup.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
////        	        .addGap(15)
//        	        .addComponent(ChineseVegLabel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE));
//            // Add the label to the vertical group
//            vGroup.addComponent(ChineseVegLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE);
        	for(int i=0;i<thirdTableModel.getRowCount();i++)
        	{
        		thirdTableModel.setValueAt(Integer.toString(counter++)+".   ", i, 0);
        		
        	}
            JScrollPane thirdScrollPane = createScrollPane(ChineseVegTable);
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
//        	        .addGap(15)
        	        .addComponent(thirdScrollPane, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(thirdScrollPane, GroupLayout.PREFERRED_SIZE, ((row*11)), GroupLayout.PREFERRED_SIZE);
//            
//            hGroup.addComponent(separator02);
//            vGroup.addComponent(separator02, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE);
                   }

        if (!isTableEmpty(fourthTableModel)) {
        	int row=fourthTableModel.getRowCount(); 
        	// Add the label to the horizontal group
//        	hGroup.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
//        	        .addComponent(IndianVegLabel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE));
//            // Add the label to the vertical group
//            vGroup.addComponent(IndianVegLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE);
        	for(int i=0;i<fourthTableModel.getRowCount();i++)
        	{
        		fourthTableModel.setValueAt(Integer.toString(counter++)+".   ", i, 0);
        		
        	}
        	
            JScrollPane fourthScrollPane = createScrollPane(IndianVegTable);
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addComponent(fourthScrollPane, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(fourthScrollPane, GroupLayout.PREFERRED_SIZE, ((row*11)), GroupLayout.PREFERRED_SIZE);
            

//            hGroup.addComponent(separator03);
//            vGroup.addComponent(separator03, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE);
        }
        if (!isTableEmpty(fifthTableModel)) {
        	int row=fifthTableModel.getRowCount();
        	// Add the label to the horizontal group
//        	hGroup.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
//        	       .addComponent(BeveragesLabel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE));
//            // Add the label to the vertical group
//            vGroup.addComponent(BeveragesLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE);
//          ================================ FOR 1 ROW ========================================
          if(row==1) {
          	
          	JLabel lblNewLabel_1 = new JLabel();
//      		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
      		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
      		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
      		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
      		
      		JLabel lblNewLabel_1_2 = new JLabel();
//      		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
      		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
      		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
      		setLabelIfNotEmpty(lblNewLabel_1_2, fifthTableModel.getValueAt(0, 1).toString());
      		
      		JLabel lblNewLabel_1_3 = new JLabel();
      		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//      		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
      		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
      		setLabelIfNotEmpty(lblNewLabel_1_3, fifthTableModel.getValueAt(0, 2).toString());
      		
      		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
      		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_1_2)
						.addComponent(lblNewLabel_1_3));
          }
//        ================================ FOR 2 ROWS ========================================
        if(row==2) {
        	
        	JLabel lblNewLabel_1 = new JLabel();
//    		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
    		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
    		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
    		
    		JLabel lblNewLabel_1_2 = new JLabel();
//    		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
    		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
    		setLabelIfNotEmpty(lblNewLabel_1_2, fifthTableModel.getValueAt(0, 1).toString());
    		
    		JLabel lblNewLabel_1_3 = new JLabel();
    		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//    		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
    		setLabelIfNotEmpty(lblNewLabel_1_3, fifthTableModel.getValueAt(0, 2).toString());

    		JLabel lblNewLabel_2_1 = new JLabel();
    		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//    		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
    		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
    		
    		JLabel lblNewLabel_2_2 = new JLabel();
    		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//    		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
    		setLabelIfNotEmpty(lblNewLabel_2_2, fifthTableModel.getValueAt(1, 1).toString());
    		
    		JLabel lblNewLabel_2_3 = new JLabel();
    		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//    		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
    		setLabelIfNotEmpty(lblNewLabel_2_3, fifthTableModel.getValueAt(1, 2).toString());
    		
    		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
    		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
    		
    		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
    		
    		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
        }            
//      ================================ FOR 3 ROWS ========================================
      if(row==3) {
      	
      	JLabel lblNewLabel_1 = new JLabel();
//  		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
  		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
  		
  		JLabel lblNewLabel_1_2 = new JLabel();
//  		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
  		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
  		setLabelIfNotEmpty(lblNewLabel_1_2, fifthTableModel.getValueAt(0, 1).toString());
  		
  		JLabel lblNewLabel_1_3 = new JLabel();
  		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//  		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_1_3, fifthTableModel.getValueAt(0, 2).toString());

  		JLabel lblNewLabel_2_1 = new JLabel();
  		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//  		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
  		
  		JLabel lblNewLabel_2_2 = new JLabel();
  		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//  		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
  		setLabelIfNotEmpty(lblNewLabel_2_2, fifthTableModel.getValueAt(1, 1).toString());
  		
  		JLabel lblNewLabel_2_3 = new JLabel();
  		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//  		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_2_3, fifthTableModel.getValueAt(1, 2).toString());
  		
  		JLabel lblNewLabel_3_1 = new JLabel();
  		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//  		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
  		
  		JLabel lblNewLabel_3_2 = new JLabel();
  		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//  		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
  		setLabelIfNotEmpty(lblNewLabel_3_2, fifthTableModel.getValueAt(2, 1).toString());
  		
  		JLabel lblNewLabel_3_3 = new JLabel();
  		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//  		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_3_3, fifthTableModel.getValueAt(2, 2).toString());
  		
  		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
  		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
  		
  		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
  		
  		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
  		
  		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
  		
  		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
      }             
//    ================================ FOR 4 ROWS ========================================
    if(row==4) {
    	
    	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, fifthTableModel.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, fifthTableModel.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, fifthTableModel.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, fifthTableModel.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, fifthTableModel.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, fifthTableModel.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, fifthTableModel.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, fifthTableModel.getValueAt(3, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
    }             
//  ================================ FOR 5 ROWS ========================================
  if(row==5) {
  	
  	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, fifthTableModel.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, fifthTableModel.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, fifthTableModel.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, fifthTableModel.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, fifthTableModel.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, fifthTableModel.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, fifthTableModel.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, fifthTableModel.getValueAt(3, 2).toString());
		
		JLabel lblNewLabel_5_1 = new JLabel();
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_1, counter+++".");
		
		JLabel lblNewLabel_5_2 = new JLabel();
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_5_2, fifthTableModel.getValueAt(4, 1).toString());
		
		JLabel lblNewLabel_5_3 = new JLabel();
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_3, fifthTableModel.getValueAt(4, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_5_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_5_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_5_1)
				.addComponent(lblNewLabel_5_2)
				.addComponent(lblNewLabel_5_3));
  }             
//================================ FOR 6 ROWS ========================================
if(row==6) {
	
	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, fifthTableModel.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, fifthTableModel.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, fifthTableModel.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, fifthTableModel.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, fifthTableModel.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, fifthTableModel.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, fifthTableModel.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, fifthTableModel.getValueAt(3, 2).toString());
		
		JLabel lblNewLabel_5_1 = new JLabel();
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_1, counter+++".");
		
		JLabel lblNewLabel_5_2 = new JLabel();
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_5_2, fifthTableModel.getValueAt(4, 1).toString());
		
		JLabel lblNewLabel_5_3 = new JLabel();
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_3, fifthTableModel.getValueAt(4, 2).toString());
		
		JLabel lblNewLabel_6_1 = new JLabel();
		lblNewLabel_6_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_1, counter+++".");
		
		JLabel lblNewLabel_6_2 = new JLabel();
		lblNewLabel_6_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_6_2, fifthTableModel.getValueAt(5, 1).toString());
		
		JLabel lblNewLabel_6_3 = new JLabel();
		lblNewLabel_6_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_3, fifthTableModel.getValueAt(5, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_5_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_5_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_5_1)
				.addComponent(lblNewLabel_5_2)
				.addComponent(lblNewLabel_5_3));
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_6_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_6_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_6_1)
				.addComponent(lblNewLabel_6_2)
				.addComponent(lblNewLabel_6_3));
}             
//================================ FOR 7 ROWS ========================================
if(row==7) {
	
	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, fifthTableModel.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, fifthTableModel.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, fifthTableModel.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, fifthTableModel.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, fifthTableModel.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, fifthTableModel.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, fifthTableModel.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, fifthTableModel.getValueAt(3, 2).toString());
		
		JLabel lblNewLabel_5_1 = new JLabel();
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_1, counter+++".");
		
		JLabel lblNewLabel_5_2 = new JLabel();
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_5_2, fifthTableModel.getValueAt(4, 1).toString());
		
		JLabel lblNewLabel_5_3 = new JLabel();
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_3, fifthTableModel.getValueAt(4, 2).toString());
		
		JLabel lblNewLabel_6_1 = new JLabel();
		lblNewLabel_6_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_1, counter+++".");
		
		JLabel lblNewLabel_6_2 = new JLabel();
		lblNewLabel_6_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_6_2, fifthTableModel.getValueAt(5, 1).toString());
		
		JLabel lblNewLabel_6_3 = new JLabel();
		lblNewLabel_6_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_3, fifthTableModel.getValueAt(5, 2).toString());
		
		JLabel lblNewLabel_7_1 = new JLabel();
		lblNewLabel_7_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_1, counter+++".");
		
		JLabel lblNewLabel_7_2 = new JLabel();
		lblNewLabel_7_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_7_2, fifthTableModel.getValueAt(6, 1).toString());
		
		JLabel lblNewLabel_7_3 = new JLabel();
		lblNewLabel_7_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_3, fifthTableModel.getValueAt(6, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_5_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_5_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_5_1)
				.addComponent(lblNewLabel_5_2)
				.addComponent(lblNewLabel_5_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_6_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_6_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_6_1)
				.addComponent(lblNewLabel_6_2)
				.addComponent(lblNewLabel_6_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_7_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_7_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_7_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_7_1)
				.addComponent(lblNewLabel_7_2)
				.addComponent(lblNewLabel_7_3));
}       
//================================ FOR 8 ROWS ========================================
if(row==8) {
	
	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, fifthTableModel.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, fifthTableModel.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, fifthTableModel.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, fifthTableModel.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, fifthTableModel.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, fifthTableModel.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, fifthTableModel.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, fifthTableModel.getValueAt(3, 2).toString());
		
		JLabel lblNewLabel_5_1 = new JLabel();
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_1, counter+++".");
		
		JLabel lblNewLabel_5_2 = new JLabel();
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_5_2, fifthTableModel.getValueAt(4, 1).toString());
		
		JLabel lblNewLabel_5_3 = new JLabel();
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_3, fifthTableModel.getValueAt(4, 2).toString());
		
		JLabel lblNewLabel_6_1 = new JLabel();
		lblNewLabel_6_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_1, counter+++".");
		
		JLabel lblNewLabel_6_2 = new JLabel();
		lblNewLabel_6_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_6_2, fifthTableModel.getValueAt(5, 1).toString());
		
		JLabel lblNewLabel_6_3 = new JLabel();
		lblNewLabel_6_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_3, fifthTableModel.getValueAt(5, 2).toString());
		
		JLabel lblNewLabel_7_1 = new JLabel();
		lblNewLabel_7_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_1, counter+++".");
		
		JLabel lblNewLabel_7_2 = new JLabel();
		lblNewLabel_7_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_7_2, fifthTableModel.getValueAt(6, 1).toString());
		
		JLabel lblNewLabel_7_3 = new JLabel();
		lblNewLabel_7_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_3, fifthTableModel.getValueAt(6, 2).toString());

		JLabel lblNewLabel_8_1 = new JLabel();
		lblNewLabel_8_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_8_1, counter+++".");
		
		JLabel lblNewLabel_8_2 = new JLabel();
		lblNewLabel_8_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_8_2, fifthTableModel.getValueAt(7, 1).toString());
		
		JLabel lblNewLabel_8_3 = new JLabel();
		lblNewLabel_8_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_8_3, fifthTableModel.getValueAt(7, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_5_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_5_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_5_1)
				.addComponent(lblNewLabel_5_2)
				.addComponent(lblNewLabel_5_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_6_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_6_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_6_1)
				.addComponent(lblNewLabel_6_2)
				.addComponent(lblNewLabel_6_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_7_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_7_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_7_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_7_1)
				.addComponent(lblNewLabel_7_2)
				.addComponent(lblNewLabel_7_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_8_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_8_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_8_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_8_1)
				.addComponent(lblNewLabel_8_2)
				.addComponent(lblNewLabel_8_3));
}       
//================================ FOR 9 ROWS ========================================
if(row==9) {
	
	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, fifthTableModel.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, fifthTableModel.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, fifthTableModel.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, fifthTableModel.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, fifthTableModel.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, fifthTableModel.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, fifthTableModel.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, fifthTableModel.getValueAt(3, 2).toString());
		
		JLabel lblNewLabel_5_1 = new JLabel();
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_1, counter+++".");
		
		JLabel lblNewLabel_5_2 = new JLabel();
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_5_2, fifthTableModel.getValueAt(4, 1).toString());
		
		JLabel lblNewLabel_5_3 = new JLabel();
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_3, fifthTableModel.getValueAt(4, 2).toString());
		
		JLabel lblNewLabel_6_1 = new JLabel();
		lblNewLabel_6_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_1, counter+++".");
		
		JLabel lblNewLabel_6_2 = new JLabel();
		lblNewLabel_6_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_6_2, fifthTableModel.getValueAt(5, 1).toString());
		
		JLabel lblNewLabel_6_3 = new JLabel();
		lblNewLabel_6_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_3, fifthTableModel.getValueAt(5, 2).toString());
		
		JLabel lblNewLabel_7_1 = new JLabel();
		lblNewLabel_7_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_1, counter+++".");
		
		JLabel lblNewLabel_7_2 = new JLabel();
		lblNewLabel_7_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_7_2, fifthTableModel.getValueAt(6, 1).toString());
		
		JLabel lblNewLabel_7_3 = new JLabel();
		lblNewLabel_7_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_3, fifthTableModel.getValueAt(6, 2).toString());

		JLabel lblNewLabel_8_1 = new JLabel();
		lblNewLabel_8_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_8_1, counter+++".");
		
		JLabel lblNewLabel_8_2 = new JLabel();
		lblNewLabel_8_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_8_2, fifthTableModel.getValueAt(7, 1).toString());
		
		JLabel lblNewLabel_8_3 = new JLabel();
		lblNewLabel_8_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_8_3, fifthTableModel.getValueAt(7, 2).toString());
		
		JLabel lblNewLabel_9_1 = new JLabel();
		lblNewLabel_9_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_9_1, counter+++".");
		
		JLabel lblNewLabel_9_2 = new JLabel();
		lblNewLabel_9_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_9_2, fifthTableModel.getValueAt(8, 1).toString());
		
		JLabel lblNewLabel_9_3 = new JLabel();
		lblNewLabel_9_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_9_3, fifthTableModel.getValueAt(8, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_5_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_5_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_5_1)
				.addComponent(lblNewLabel_5_2)
				.addComponent(lblNewLabel_5_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_6_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_6_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_6_1)
				.addComponent(lblNewLabel_6_2)
				.addComponent(lblNewLabel_6_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_7_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_7_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_7_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_7_1)
				.addComponent(lblNewLabel_7_2)
				.addComponent(lblNewLabel_7_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_8_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_8_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_8_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_8_1)
				.addComponent(lblNewLabel_8_2)
				.addComponent(lblNewLabel_8_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_9_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_9_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_9_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_9_1)
				.addComponent(lblNewLabel_9_2)
				.addComponent(lblNewLabel_9_3));
}  
//================================ FOR 9 ROWS ========================================
if(row==10) {
	
	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, fifthTableModel.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, fifthTableModel.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, fifthTableModel.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, fifthTableModel.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, fifthTableModel.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, fifthTableModel.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, fifthTableModel.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, fifthTableModel.getValueAt(3, 2).toString());
		
		JLabel lblNewLabel_5_1 = new JLabel();
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_1, counter+++".");
		
		JLabel lblNewLabel_5_2 = new JLabel();
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_5_2, fifthTableModel.getValueAt(4, 1).toString());
		
		JLabel lblNewLabel_5_3 = new JLabel();
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_3, fifthTableModel.getValueAt(4, 2).toString());
		
		JLabel lblNewLabel_6_1 = new JLabel();
		lblNewLabel_6_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_1, counter+++".");
		
		JLabel lblNewLabel_6_2 = new JLabel();
		lblNewLabel_6_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_6_2, fifthTableModel.getValueAt(5, 1).toString());
		
		JLabel lblNewLabel_6_3 = new JLabel();
		lblNewLabel_6_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_3, fifthTableModel.getValueAt(5, 2).toString());
		
		JLabel lblNewLabel_7_1 = new JLabel();
		lblNewLabel_7_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_1, counter+++".");
		
		JLabel lblNewLabel_7_2 = new JLabel();
		lblNewLabel_7_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_7_2, fifthTableModel.getValueAt(6, 1).toString());
		
		JLabel lblNewLabel_7_3 = new JLabel();
		lblNewLabel_7_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_3, fifthTableModel.getValueAt(6, 2).toString());

		JLabel lblNewLabel_8_1 = new JLabel();
		lblNewLabel_8_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_8_1, counter+++".");
		
		JLabel lblNewLabel_8_2 = new JLabel();
		lblNewLabel_8_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_8_2, fifthTableModel.getValueAt(7, 1).toString());
		
		JLabel lblNewLabel_8_3 = new JLabel();
		lblNewLabel_8_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_8_3, fifthTableModel.getValueAt(7, 2).toString());
		
		JLabel lblNewLabel_9_1 = new JLabel();
		lblNewLabel_9_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_9_1, counter+++".");
		
		JLabel lblNewLabel_9_2 = new JLabel();
		lblNewLabel_9_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_9_2, fifthTableModel.getValueAt(8, 1).toString());
		
		JLabel lblNewLabel_9_3 = new JLabel();
		lblNewLabel_9_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_9_3, fifthTableModel.getValueAt(8, 2).toString());
		
		JLabel lblNewLabel_10_1 = new JLabel();
		lblNewLabel_10_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_10_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_10_1, counter+++".");
		
		JLabel lblNewLabel_10_2 = new JLabel();
		lblNewLabel_10_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_10_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_10_2, fifthTableModel.getValueAt(9, 1).toString());
		
		JLabel lblNewLabel_10_3 = new JLabel();
		lblNewLabel_10_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_10_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_10_3, fifthTableModel.getValueAt(9, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_5_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_5_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_5_1)
				.addComponent(lblNewLabel_5_2)
				.addComponent(lblNewLabel_5_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_6_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_6_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_6_1)
				.addComponent(lblNewLabel_6_2)
				.addComponent(lblNewLabel_6_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_7_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_7_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_7_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_7_1)
				.addComponent(lblNewLabel_7_2)
				.addComponent(lblNewLabel_7_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_8_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_8_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_8_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_8_1)
				.addComponent(lblNewLabel_8_2)
				.addComponent(lblNewLabel_8_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_9_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_9_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_9_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_9_1)
				.addComponent(lblNewLabel_9_2)
				.addComponent(lblNewLabel_9_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_10_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_10_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_10_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_10_1)
				.addComponent(lblNewLabel_10_2)
				.addComponent(lblNewLabel_10_3));
}       

//            hGroup.addComponent(separator04);
//            vGroup.addComponent(separator04, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE);
        }
        
        if (!isTableEmpty(sixthTableModel)) {
        	int row=sixthTableModel.getRowCount();
        	// Add the label to the horizontal group
//        	hGroup.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
////        	        .addGap(15).
//        	        .addComponent(CombosLabel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE));
//            // Add the label to the vertical group
//            vGroup.addComponent(CombosLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE);
        	for(int i=0;i<sixthTableModel.getRowCount();i++)
        	{
        		sixthTableModel.setValueAt(Integer.toString(counter++)+".   ", i, 0);
        		
        	}
            JScrollPane sixthScrollPane = createScrollPane(CombosTable);
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
//        	        .addGap(15)
        	        .addComponent(sixthScrollPane, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(sixthScrollPane, GroupLayout.PREFERRED_SIZE, ((row*11)), GroupLayout.PREFERRED_SIZE);
            
//            hGroup.addComponent(separator05);
//            vGroup.addComponent(separator05, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE);
        }
        
        if (!isTableEmpty(seventhTableModel)) {
        	int row=seventhTableModel.getRowCount();
        	// Add the label to the horizontal group
//        	hGroup.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
////        	        .addGap(15)
//        	        .addComponent(ExtrasLabel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE));
//            // Add the label to the vertical group
//            vGroup.addComponent(ExtrasLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE);
//          ================================ FOR 1 ROW ========================================
          if(row==1) {
          	
          	JLabel lblNewLabel_1 = new JLabel();
//      		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
      		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
      		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
      		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
      		
      		JLabel lblNewLabel_1_2 = new JLabel();
//      		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
      		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
      		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
      		setLabelIfNotEmpty(lblNewLabel_1_2, seventhTableModel.getValueAt(0, 1).toString());
      		
      		JLabel lblNewLabel_1_3 = new JLabel();
      		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//      		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
      		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
      		setLabelIfNotEmpty(lblNewLabel_1_3, seventhTableModel.getValueAt(0, 2).toString());
      		
      		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
      		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_1_2)
						.addComponent(lblNewLabel_1_3));
          }
//        ================================ FOR 2 ROWS ========================================
        if(row==2) {
        	
        	JLabel lblNewLabel_1 = new JLabel();
//    		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
    		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
    		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
    		
    		JLabel lblNewLabel_1_2 = new JLabel();
//    		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
    		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
    		setLabelIfNotEmpty(lblNewLabel_1_2, seventhTableModel.getValueAt(0, 1).toString());
    		
    		JLabel lblNewLabel_1_3 = new JLabel();
    		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//    		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
    		setLabelIfNotEmpty(lblNewLabel_1_3, seventhTableModel.getValueAt(0, 2).toString());

    		JLabel lblNewLabel_2_1 = new JLabel();
    		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//    		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
    		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
    		
    		JLabel lblNewLabel_2_2 = new JLabel();
    		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//    		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
    		setLabelIfNotEmpty(lblNewLabel_2_2, seventhTableModel.getValueAt(1, 1).toString());
    		
    		JLabel lblNewLabel_2_3 = new JLabel();
    		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//    		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
    		setLabelIfNotEmpty(lblNewLabel_2_3, seventhTableModel.getValueAt(1, 2).toString());
    		
    		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
    		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
    		
    		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
    		
    		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
        }            
//      ================================ FOR 3 ROWS ========================================
      if(row==3) {
      	
      	JLabel lblNewLabel_1 = new JLabel();
//  		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
  		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
  		
  		JLabel lblNewLabel_1_2 = new JLabel();
//  		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
  		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
  		setLabelIfNotEmpty(lblNewLabel_1_2, seventhTableModel.getValueAt(0, 1).toString());
  		
  		JLabel lblNewLabel_1_3 = new JLabel();
  		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//  		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_1_3, seventhTableModel.getValueAt(0, 2).toString());

  		JLabel lblNewLabel_2_1 = new JLabel();
  		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//  		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
  		
  		JLabel lblNewLabel_2_2 = new JLabel();
  		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//  		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
  		setLabelIfNotEmpty(lblNewLabel_2_2, seventhTableModel.getValueAt(1, 1).toString());
  		
  		JLabel lblNewLabel_2_3 = new JLabel();
  		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//  		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_2_3, seventhTableModel.getValueAt(1, 2).toString());
  		
  		JLabel lblNewLabel_3_1 = new JLabel();
  		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//  		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
  		
  		JLabel lblNewLabel_3_2 = new JLabel();
  		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//  		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
  		setLabelIfNotEmpty(lblNewLabel_3_2, seventhTableModel.getValueAt(2, 1).toString());
  		
  		JLabel lblNewLabel_3_3 = new JLabel();
  		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//  		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
  		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
  		setLabelIfNotEmpty(lblNewLabel_3_3, seventhTableModel.getValueAt(2, 2).toString());
  		
  		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
  		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
  		
  		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
  		
  		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
  		
  		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
  		
  		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
      }             
//    ================================ FOR 4 ROWS ========================================
    if(row==4) {
    	
    	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, seventhTableModel.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, seventhTableModel.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, seventhTableModel.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, seventhTableModel.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, seventhTableModel.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, seventhTableModel.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, seventhTableModel.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, seventhTableModel.getValueAt(3, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
    }             
//  ================================ FOR 5 ROWS ========================================
  if(row==5) {
  	
  	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, seventhTableModel.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, seventhTableModel.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, seventhTableModel.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, seventhTableModel.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, seventhTableModel.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, seventhTableModel.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, seventhTableModel.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, seventhTableModel.getValueAt(3, 2).toString());
		
		JLabel lblNewLabel_5_1 = new JLabel();
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_1, counter+++".");
		
		JLabel lblNewLabel_5_2 = new JLabel();
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_5_2, seventhTableModel.getValueAt(4, 1).toString());
		
		JLabel lblNewLabel_5_3 = new JLabel();
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_3, seventhTableModel.getValueAt(4, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_5_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_5_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_5_1)
				.addComponent(lblNewLabel_5_2)
				.addComponent(lblNewLabel_5_3));
  }             
//================================ FOR 6 ROWS ========================================
if(row==6) {
	
	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, seventhTableModel.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, seventhTableModel.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, seventhTableModel.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, seventhTableModel.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, seventhTableModel.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, seventhTableModel.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, seventhTableModel.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, seventhTableModel.getValueAt(3, 2).toString());
		
		JLabel lblNewLabel_5_1 = new JLabel();
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_1, counter+++".");
		
		JLabel lblNewLabel_5_2 = new JLabel();
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_5_2, seventhTableModel.getValueAt(4, 1).toString());
		
		JLabel lblNewLabel_5_3 = new JLabel();
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_3, seventhTableModel.getValueAt(4, 2).toString());
		
		JLabel lblNewLabel_6_1 = new JLabel();
		lblNewLabel_6_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_1, counter+++".");
		
		JLabel lblNewLabel_6_2 = new JLabel();
		lblNewLabel_6_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_6_2, seventhTableModel.getValueAt(5, 1).toString());
		
		JLabel lblNewLabel_6_3 = new JLabel();
		lblNewLabel_6_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_3, seventhTableModel.getValueAt(5, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_5_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_5_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_5_1)
				.addComponent(lblNewLabel_5_2)
				.addComponent(lblNewLabel_5_3));
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_6_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_6_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_6_1)
				.addComponent(lblNewLabel_6_2)
				.addComponent(lblNewLabel_6_3));
}             
//================================ FOR 7 ROWS ========================================
if(row==7) {
	
	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, seventhTableModel.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, seventhTableModel.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, seventhTableModel.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, seventhTableModel.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, seventhTableModel.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, seventhTableModel.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, seventhTableModel.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, seventhTableModel.getValueAt(3, 2).toString());
		
		JLabel lblNewLabel_5_1 = new JLabel();
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_1, counter+++".");
		
		JLabel lblNewLabel_5_2 = new JLabel();
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_5_2, seventhTableModel.getValueAt(4, 1).toString());
		
		JLabel lblNewLabel_5_3 = new JLabel();
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_3, seventhTableModel.getValueAt(4, 2).toString());
		
		JLabel lblNewLabel_6_1 = new JLabel();
		lblNewLabel_6_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_1, counter+++".");
		
		JLabel lblNewLabel_6_2 = new JLabel();
		lblNewLabel_6_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_6_2, seventhTableModel.getValueAt(5, 1).toString());
		
		JLabel lblNewLabel_6_3 = new JLabel();
		lblNewLabel_6_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_3, seventhTableModel.getValueAt(5, 2).toString());
		
		JLabel lblNewLabel_7_1 = new JLabel();
		lblNewLabel_7_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_1, counter+++".");
		
		JLabel lblNewLabel_7_2 = new JLabel();
		lblNewLabel_7_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_7_2, seventhTableModel.getValueAt(6, 1).toString());
		
		JLabel lblNewLabel_7_3 = new JLabel();
		lblNewLabel_7_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_3, seventhTableModel.getValueAt(6, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_5_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_5_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_5_1)
				.addComponent(lblNewLabel_5_2)
				.addComponent(lblNewLabel_5_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_6_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_6_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_6_1)
				.addComponent(lblNewLabel_6_2)
				.addComponent(lblNewLabel_6_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_7_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_7_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_7_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_7_1)
				.addComponent(lblNewLabel_7_2)
				.addComponent(lblNewLabel_7_3));
}       
//================================ FOR 8 ROWS ========================================
if(row==8) {
	
	JLabel lblNewLabel_1 = new JLabel();
//		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1, counter+++".");
		
		JLabel lblNewLabel_1_2 = new JLabel();
//		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_1_2, seventhTableModel.getValueAt(0, 1).toString());
		
		JLabel lblNewLabel_1_3 = new JLabel();
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_1_3, seventhTableModel.getValueAt(0, 2).toString());

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_1, counter+++".");
		
		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_2_2, seventhTableModel.getValueAt(1, 1).toString());
		
		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_2_3, seventhTableModel.getValueAt(1, 2).toString());
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_1, counter+++".");
		
		JLabel lblNewLabel_3_2 = new JLabel();
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_3_2, seventhTableModel.getValueAt(2, 1).toString());
		
		JLabel lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_3_3, seventhTableModel.getValueAt(2, 2).toString());
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_1, counter+++".");
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_4_2, seventhTableModel.getValueAt(3, 1).toString());
		
		JLabel lblNewLabel_4_3 = new JLabel();
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_4_3, seventhTableModel.getValueAt(3, 2).toString());
		
		JLabel lblNewLabel_5_1 = new JLabel();
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_1, counter+++".");
		
		JLabel lblNewLabel_5_2 = new JLabel();
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_5_2, seventhTableModel.getValueAt(4, 1).toString());
		
		JLabel lblNewLabel_5_3 = new JLabel();
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_5_3, seventhTableModel.getValueAt(4, 2).toString());
		
		JLabel lblNewLabel_6_1 = new JLabel();
		lblNewLabel_6_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_1, counter+++".");
		
		JLabel lblNewLabel_6_2 = new JLabel();
		lblNewLabel_6_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_6_2, seventhTableModel.getValueAt(5, 1).toString());
		
		JLabel lblNewLabel_6_3 = new JLabel();
		lblNewLabel_6_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_6_3, seventhTableModel.getValueAt(5, 2).toString());
		
		JLabel lblNewLabel_7_1 = new JLabel();
		lblNewLabel_7_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_1, counter+++".");
		
		JLabel lblNewLabel_7_2 = new JLabel();
		lblNewLabel_7_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_7_2, seventhTableModel.getValueAt(6, 1).toString());
		
		JLabel lblNewLabel_7_3 = new JLabel();
		lblNewLabel_7_3.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_7_3, seventhTableModel.getValueAt(6, 2).toString());

		JLabel lblNewLabel_8_1 = new JLabel();
		lblNewLabel_8_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_8_1, counter+++".");
		
		JLabel lblNewLabel_8_2 = new JLabel();
		lblNewLabel_8_2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.LEFT);
		setLabelIfNotEmpty(lblNewLabel_8_2, seventhTableModel.getValueAt(7, 1).toString());
		
		JLabel lblNewLabel_8_3 = new JLabel();
		lblNewLabel_8_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
//		lblNewLabel_1_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8_3.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelIfNotEmpty(lblNewLabel_8_3, seventhTableModel.getValueAt(7, 2).toString());
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_1_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(lblNewLabel_1_2)
					.addComponent(lblNewLabel_1_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_2_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_2_1)
					.addComponent(lblNewLabel_2_2)
					.addComponent(lblNewLabel_2_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_3_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//								.addGap(19)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_3_1)
					.addComponent(lblNewLabel_3_2)
					.addComponent(lblNewLabel_3_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_4_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_4_1)
				.addComponent(lblNewLabel_4_2)
				.addComponent(lblNewLabel_4_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_5_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_5_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_5_1)
				.addComponent(lblNewLabel_5_2)
				.addComponent(lblNewLabel_5_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_6_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_6_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_6_1)
				.addComponent(lblNewLabel_6_2)
				.addComponent(lblNewLabel_6_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_7_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_7_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_7_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_7_1)
				.addComponent(lblNewLabel_7_2)
				.addComponent(lblNewLabel_7_3));
		
		hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(5)
							.addComponent(lblNewLabel_8_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblNewLabel_8_2,GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//							.addGap(19)
							.addComponent(lblNewLabel_8_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));
		
		vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblNewLabel_8_1)
				.addComponent(lblNewLabel_8_2)
				.addComponent(lblNewLabel_8_3));
}       
  
//            hGroup.addComponent(separator06);
//            vGroup.addComponent(separator06, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE);
        }
        
        hGroup.addComponent(separator3);
        vGroup.addGap(3).addComponent(separator3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE);
        
        
        gl_contentPanel.setHorizontalGroup(hGroup);
        gl_contentPanel.setVerticalGroup(vGroup);

        contentPanel.setLayout(gl_contentPanel);
        pack();
//        setVisible(true);
        
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
        Date now = new Date();
        BillNo_2.setText(dateFormatter.format(now)+" ");
        BillNo_1_3.setText(timeFormatter.format(now)+" ");
        contentPanel.validate();
        contentPanel.repaint();
        printContent();
    }

    public void printContent() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);

        PageFormat pf = job.defaultPage();
        Paper paper = new Paper();

        // Set initial paper size based on content size
        Dimension contentSize = contentPanel.getPreferredSize();
        double width = contentSize.width * 72 / 25.4;  // converting mm to points
        double height = contentSize.height * 72 / 25.4;
        paper.setSize(width, height);

        // Set the imageable area to match the paper size exactly, to avoid white space
        paper.setImageableArea(0, 0, width, height);
        pf.setPaper(paper);
        job.setPrintable(this, pf);

        try {
            job.print();
            dispose();  // Dispose the frame or dialog after printing
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex) {
        Graphics2D g2d = (Graphics2D) g;

        // Calculate content bounds based on the panel's preferred size
        Dimension contentSize = contentPanel.getPreferredSize();
        double panelWidth = contentSize.width;
        double panelHeight = contentSize.height;

        // Calculate imageable area bounds
        double imageableX = pf.getImageableX();
        double imageableY = pf.getImageableY();
        double imageableWidth = pf.getImageableWidth();
        double imageableHeight = pf.getImageableHeight();

        // Calculate the number of pages required
        int totalNumPages = (int) Math.ceil(panelHeight / imageableHeight);

        // Ensure we don't try to print beyond the total number of pages
        if (pageIndex >= totalNumPages) {
            return Printable.NO_SUCH_PAGE;
        }

        // Calculate the visible part of content for the current page
        double pageStartY = pageIndex * imageableHeight;
        double pageEndY = Math.min(pageStartY + imageableHeight, panelHeight);

        // Translate and clip the graphics context to the current page
        g2d.translate(imageableX, imageableY - pageStartY);
        g2d.clipRect(0, (int) pageStartY, (int) imageableWidth, (int) (pageEndY - pageStartY));

        // Paint the visible part of the content panel
        contentPanel.paint(g2d);

        // Undo transformations
        g2d.translate(-imageableX, -(imageableY - pageStartY));
        g2d.dispose();

        return Printable.PAGE_EXISTS;
    }

    // Example dispose method assuming it's in a Swing application

    private boolean isTableEmpty(DefaultTableModel model) {
        return model.getRowCount() == 0;
    }

    private JTable createTable(DefaultTableModel model) {
        JTable table = new JTable(model);
        table.setBackground(Color.WHITE);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        table.getColumnModel().getColumn(0).setPreferredWidth(42);
        table.getColumnModel().getColumn(1).setPreferredWidth(483);
        table.setShowGrid(false); // Remove grid lines
        table.setShowHorizontalLines(false); // Remove horizontal lines
        table.setShowVerticalLines(false); // Remove vertical lines
        table.setIntercellSpacing(new Dimension(0, 0)); // Remove space between cells
        table.setBorder(BorderFactory.createEmptyBorder()); // Remove table border
//        table.setTableHeader(null); // Remove table header
        table.setRowHeight(11);
        
        DefaultTableCellRenderer LEFTRenderer = new DefaultTableCellRenderer();
        LEFTRenderer.setHorizontalAlignment(JLabel.LEFT);
        DefaultTableCellRenderer RIGHTRenderer = new DefaultTableCellRenderer();
        RIGHTRenderer.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(0).setCellRenderer(LEFTRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(LEFTRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(RIGHTRenderer);
        table.getColumnModel().getColumn(0).setCellRenderer(new CustomFontRenderer());
        table.getColumnModel().getColumn(1).setCellRenderer(new CustomFontRenderer1());
        table.getColumnModel().getColumn(2).setCellRenderer(new CustomFontRenderer1());
     // Custom header renderer
        TableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
        
        	@Override
            public Component getTableCellRendererComponent(JTable itemsTable, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                super.getTableCellRendererComponent(itemsTable, value, isSelected, hasFocus, row, column);
//                setBackground(new Color(33,128,196));  // Set desired background color
                setForeground(Color.BLUE);               // Set desired text color
                setBorder(BorderFactory.createLineBorder(Color.WHITE)); // Set border if needed
                setHorizontalAlignment(LEFT);           // Center text in label
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));  // Create a bottom border
//                setFont(getFont().deriveFont(Font.BOLD)); // Set bold font
                return this;
            }
        };
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(headerRenderer);
        table.setTableHeader(null);
        return table;
    }


        
        
     
        
    private JScrollPane createScrollPane(JTable table) {
    	DefaultTableCellRenderer RIGHTRenderer = new DefaultTableCellRenderer();
        RIGHTRenderer.setHorizontalAlignment(JLabel.LEFT);
        table.getColumnModel().getColumn(1).setCellRenderer(RIGHTRenderer);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setForeground(Color.BLUE);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setPreferredSize(new Dimension(250, 60));
        scrollPane.setMaximumSize(new Dimension(250, Integer.MAX_VALUE));
        return scrollPane;
    }
   
    
   
    
    private void startTimer() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
                SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
                Date now = new Date();
                BillNo_2.setText(dateFormatter.format(now)+" ");
                BillNo_1_3.setText(timeFormatter.format(now)+" ");
//                OperatorLabel.setText(timeFormatter.format(now)); // Optional: show time in the operator label for consistency
            }
        });
        timer.start();
    }
    private void setLabelIfNotEmpty(JLabel label, String text) {
		if (!text.isEmpty()) {
			label.setText("<html>" + text.replaceAll("\n", "<br>") + "</html>");
		}
	}



//    public static void main(String[] args) {
//        new PDFReport(); // Create an instance of the frame
//    }
}
class CustomFontRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


        // Set custom font for this column
        cellComponent.setFont(new Font("Segoe UI", Font.PLAIN, 9));
        ((JLabel) cellComponent).setHorizontalAlignment(SwingConstants.RIGHT);

        return cellComponent;
    }
}
class CustomFontRenderer1 extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

      

        // Set custom font for this column
        cellComponent.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        ((JLabel) cellComponent).setHorizontalAlignment(SwingConstants.RIGHT);

        return cellComponent;
    }
}