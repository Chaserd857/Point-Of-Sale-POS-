
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.table.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@SuppressWarnings("all")
public class PDFReport extends JFrame implements Printable {
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
    
	private JPanel labelPanel1;
	private JPanel labelPanel2;
	private JPanel labelPanel3;
    private JPanel labelPanel4;
    private JPanel labelPanel5;
    private JPanel labelPanel6;
    private JPanel labelPanel7;
    private JPanel labelPanelLast;
	
	private JLabel Southindian_subTotalLabel;
	private JLabel Southindian_subTotalValue;
	private JLabel Southindian_salesTaxLabel;
	private JLabel Southindian_chargesLabel;
	private JLabel Southindian_chargesValue;
	private JLabel Southindian_salesTaxValue;
	private JLabel Southindian_totalLabel;
	private JLabel Southindian_totalValue;
	private JLabel Southindian_QuantityValue;
	
	private JLabel MumbaiChaat_totalValue;
	private JLabel MumbaiChaat_totalLabel;
	private JLabel MumbaiChaat_chargesValue;
	private JLabel MumbaiChaat_chargesLabel;
	private JLabel MumbaiChaat_salesTaxValue;
	private JLabel MumbaiChaat_salesTaxLabel;
	private JLabel MumbaiChaat_subTotalValue;
	private JLabel MumbaiChaat_subTotalLabel;
	private JLabel MumbaiChaat_QuantityValue;
	
	private JLabel ChineseVeg_subTotalLabel;
	private JLabel ChineseVeg_subTotalValue;
	private JLabel ChineseVeg_salesTaxLabel;
	private JLabel ChineseVeg_salesTaxValue;
	private JLabel ChineseVeg_chargesLabel;
	private JLabel ChineseVeg_chargesValue;
	private JLabel ChineseVeg_totalValue;
	private JLabel ChineseVeg_QuantityValue;
	private JLabel ChineseVeg_totalLabel;
	
	private JLabel IndianVeg_subTotalLabel;
    private JLabel IndianVeg_subTotalValue;
    private JLabel IndianVeg_salesTaxLabel;
    private JLabel IndianVeg_salesTaxValue;
    private JLabel IndianVeg_chargesLabel;
    private JLabel IndianVeg_chargesValue;
    private JLabel IndianVeg_totalValue;
    private JLabel IndianVeg_QuantityValue;
    private JLabel IndianVeg_totalLabel;
    
    private JLabel Beverages_subTotalLabel;
    private JLabel Beverages_subTotalValue;
    private JLabel Beverages_salesTaxLabel;
    private JLabel Beverages_salesTaxValue;
    private JLabel Beverages_chargesLabel;
    private JLabel Beverages_chargesValue;
    private JLabel Beverages_totalValue;
    private JLabel Beverages_QuantityValue;
    private JLabel Beverages_totalLabel;
	
    private JLabel Combos_subTotalLabel;
    private JLabel Combos_subTotalValue;
    private JLabel Combos_salesTaxLabel;
    private JLabel Combos_salesTaxValue;
    private JLabel Combos_chargesLabel;
    private JLabel Combos_chargesValue;
    private JLabel Combos_totalValue;
    private JLabel Combos_QuantityValue;
    private JLabel Combos_totalLabel;
    
    private JLabel Extras_subTotalLabel;
    private JLabel Extras_subTotalValue;
    private JLabel Extras_salesTaxLabel;
    private JLabel Extras_salesTaxValue;
    private JLabel Extras_chargesLabel;
    private JLabel Extras_chargesValue;
    private JLabel Extras_totalValue;
    private JLabel Extras_QuantityValue;
    private JLabel Extras_totalLabel;

    private JLabel Last_subTotalLabel;
    private JLabel Last_subTotalValue;
    private JLabel Last_salesTaxLabel;
    private JLabel Last_salesTaxValue;
    private JLabel Last_chargesLabel;
    private JLabel Last_chargesValue;
    private JLabel Last_totalValue;
    private JLabel Last_QuantityValue;
    private JLabel Last_totalLabel;
    private JLabel Last_QuantityLabel;
	private JLabel noOfBillsValue;
	private JLabel noOfPersonsValue;
	private JLabel cashValue;
	private JLabel cashLabel;
	private JLabel noOfBillsLabel;
	private JLabel noOfPersonsLabel;

	private JLabel southIndianLabel;
	private JLabel MumbaiChaatLabel;
	private JLabel ExtrasLabel;
	private JLabel ChineseVegLabel;
	private JLabel IndianVegLabel;
	private JLabel BeveragesLabel;
	private JLabel CombosLabel;

	private String directoryPath = "C:\\POS\\Invoice_Data\\Day_Wise";

    
    public PDFReport(DefaultTableModel tableModel2,DefaultTableModel tableModel3, DefaultTableModel tableModel4,DefaultTableModel tableModel5,DefaultTableModel tableModel6,DefaultTableModel tableModel7,DefaultTableModel tableModel8) {
    	this.Model=tableModel2;
    	this.secondTableModel=tableModel3;
    	this.fourthTableModel=tableModel4;
    	this.fifthTableModel=tableModel5;
    	this.thirdTableModel=tableModel6;
    	this.sixthTableModel=tableModel7;
    	this.seventhTableModel=tableModel8;
        createGUI();
    }

    private void createGUI() {
        setTitle("Blank Invoice - 80mm x 297mm");
//        setIconImage(Toolkit.getDefaultToolkit().getImage(PDFReport.class.getResource("/images/LOGO-removebg-preview.png")));
        setSize(270, 10000); // Adjust the height to accommodate the second table
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

     // Get the current system date
        LocalDate currentDate = LocalDate.now();

        // Create a DateTimeFormatter for the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Format the current date using the formatter
        String formattedDate = currentDate.format(formatter);
        
     // Create a DateTimeFormatter for the desired format
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Format the current date using the formatter
        String formattedDate2 = currentDate.format(formatter2);
        
     // Create a DateTimeFormatter for the desired format
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("ddMMyyyy");

        // Format the current date using the formatter
        String formattedDate3 = currentDate.format(formatter3);
        
        JLabel titleLabel = new JLabel("DOSA PLAZA");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        invoiceLabel = new JLabel("");
        invoiceLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        invoiceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel BillNo = new JLabel("Item Group+Item wise Sales");
        BillNo.setFont(new Font("Tahoma", Font.BOLD, 8));
        BillNo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel BillDate = new JLabel("For the period "+formattedDate+" to "+formattedDate);
        BillDate.setFont(new Font("Tahoma", Font.BOLD, 8));
        BillDate.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel counter = new JLabel(">> Counter Sale");
        counter.setFont(new Font("Tahoma", Font.BOLD, 8));
        counter.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel ColumnLabel = new JLabel("Item Description                              Quantity     Amount");
        ColumnLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
        ColumnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        labelPanel1 = createLabelPanel(Model);
        labelPanel2 = createLabelPanel1(secondTableModel);
        labelPanel3 = createLabelPanel2(thirdTableModel);
        labelPanel4 = createLabelPanel3(fourthTableModel);
        labelPanel5 = createLabelPanel4(fifthTableModel);
        labelPanel6 = createLabelPanel5(sixthTableModel);
        labelPanel7 = createLabelPanel6(seventhTableModel);
        labelPanelLast = createLabelPanelLast();
        
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        String[] columnNames = {"Item Description", "Quantity", "    Amount"};
        
        SouthIndianTableMODEL=Model;
//        Model = new DefaultTableModel(columnNames, 0);
        SouthIndianTable = createTable(SouthIndianTableMODEL);
        // Set custom renderer for the third column
        TableColumnModel columnModel = SouthIndianTable.getColumnModel();
        columnModel.getColumn(2).setCellRenderer(new CustomCellRenderer());

        
        MumbaiChaatTableMODEL=secondTableModel;
//        secondTableModel = new DefaultTableModel(columnNames, 0);
        MumbaiChaatTable = createTable(MumbaiChaatTableMODEL);
        // Set custom renderer for the third column
        TableColumnModel columnModel2 = MumbaiChaatTable.getColumnModel();
        columnModel2.getColumn(2).setCellRenderer(new CustomCellRenderer());
        
        ChineseVegTableModel=thirdTableModel;
//        thirdTableModel = new DefaultTableModel(columnNames, 0);
        ChineseVegTable = createTable(ChineseVegTableModel);
     // Set custom renderer for the third column
        TableColumnModel columnModel5 = ChineseVegTable.getColumnModel();
        columnModel5.getColumn(2).setCellRenderer(new CustomCellRenderer());
        
//        thirdTableModel.addRow(new Object[]{"ChineseVegTable",  "Disc", "Net Value"});
        
//        fourthTableModel = new DefaultTableModel(columnNames, 0);
        IndianVegTableMODEL=fourthTableModel;
        IndianVegTable = createTable(IndianVegTableMODEL);
     // Set custom renderer for the third column
        TableColumnModel columnModel3 = IndianVegTable.getColumnModel();
        columnModel3.getColumn(2).setCellRenderer(new CustomCellRenderer());
//        fourthTableModel.addRow(new Object[]{"IndianVegTable", "Disc", "Net Value"});
        
//        fifthTableModel = new DefaultTableModel(columnNames, 0);
        BeveragesTableMODEL=fifthTableModel;
        BeveragesTable = createTable(BeveragesTableMODEL);
     // Set custom renderer for the third column
        TableColumnModel columnModel4 = BeveragesTable.getColumnModel();
        columnModel4.getColumn(2).setCellRenderer(new CustomCellRenderer());
//        fifthTableModel.addRow(new Object[]{"BeveragesTable", "Disc", "Net Value"});
        
        CombosTableMODEL=sixthTableModel;
//        sixthTableModel = new DefaultTableModel(columnNames, 0);
        CombosTable = createTable(CombosTableMODEL);
        // Set custom renderer for the third column
        TableColumnModel columnModel6 = CombosTable.getColumnModel();
        columnModel6.getColumn(2).setCellRenderer(new CustomCellRenderer());
//        sixthTableModel.addRow(new Object[]{"CombosTable", "Disc", "Net Value"});
        
        
        ExtrasTableMODEL=seventhTableModel;
//        seventhTableModel = new DefaultTableModel(columnNames, 0);
        ExtrasTable = createTable(ExtrasTableMODEL);
        // Set custom renderer for the third column
        TableColumnModel columnModel7 = ExtrasTable.getColumnModel();
        columnModel7.getColumn(2).setCellRenderer(new CustomCellRenderer());
//        seventhTableModel.addRow(new Object[]{"ExtrasTable", "Disc", "Net Value"});
        
        JSeparator separator1 = new JSeparator();
        separator1.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separator1.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separator2 = new JSeparator();
        separator2.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separator2.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separator3 = new JSeparator();
        separator3.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separator3.setForeground(Color.BLACK); // Set separator color to black
        
        southIndianLabel = new JLabel("<html><u>South Indian</u></html>");
        southIndianLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
        
        MumbaiChaatLabel = new JLabel("<html><u>Mumbai Chaat</u></html>");
        MumbaiChaatLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
        
        ChineseVegLabel = new JLabel("<html><u>Chinese Veg.</u></html>");
        ChineseVegLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
        
        IndianVegLabel = new JLabel("<html><u>Indian Veg.</u></html>");
        IndianVegLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
        
        BeveragesLabel = new JLabel("<html><u>Beverages</u></html>");
        BeveragesLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
        
        CombosLabel = new JLabel("<html><u>Combos</u></html>");
        CombosLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
        
        ExtrasLabel = new JLabel("<html><u>Extra</u></html>");
        ExtrasLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
        
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        GroupLayout.ParallelGroup hGroup = gl_contentPanel.createParallelGroup(Alignment.LEADING);
        GroupLayout.SequentialGroup vGroup = gl_contentPanel.createSequentialGroup();

        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	    .addGap(15)
        	    .addComponent(titleLabel));
        	hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	    .addGap(55)
        	    .addComponent(invoiceLabel, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE));
        	hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	    .addGap(15)
        	    .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
        	        .addComponent(BillNo)
        	        .addComponent(BillDate)
        	        .addComponent(counter))
        	    .addContainerGap());
        	hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	    .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
        	        .addComponent(separator1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
        	        .addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(15)
        	        .addComponent(ColumnLabel))
        	        .addComponent(separator2, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)));

        	// Set the vertical layout with no gap between separator2 and SouthIndianTable
        	vGroup.addComponent(titleLabel)
        	    .addGap(5)
        	    .addComponent(invoiceLabel)
        	    .addGap(3)
        	    .addComponent(BillNo)
        	    .addComponent(BillDate)
        	    .addComponent(counter)
        	    .addComponent(separator1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
        	    .addComponent(ColumnLabel, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
        	    .addComponent(separator2, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE); // Ensure gap is set to 2

        

        if (!isTableEmpty(Model)) {
        	int row=Model.getRowCount();
        	// Add the label to the horizontal group
        	hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(15)
        	        .addComponent(southIndianLabel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE));
            // Add the label to the vertical group
            vGroup.addComponent(southIndianLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE);

            JScrollPane scrollPane = createScrollPane(SouthIndianTable);
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(15)
        	        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, ((row*10)), GroupLayout.PREFERRED_SIZE);
            
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(10)
        	        .addComponent(labelPanel1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(labelPanel1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE);
        }
        

        if (!isTableEmpty(secondTableModel)) {
        	int row=secondTableModel.getRowCount();
        	// Add the label to the horizontal group
        	hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(15)
        	        .addComponent(MumbaiChaatLabel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE));
            // Add the label to the vertical group
            vGroup.addComponent(MumbaiChaatLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE);
            JScrollPane secondScrollPane = createScrollPane(MumbaiChaatTable);
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(15)
        	        .addComponent(secondScrollPane, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(secondScrollPane, GroupLayout.PREFERRED_SIZE, ((row*10)), GroupLayout.PREFERRED_SIZE);
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(10).addComponent(labelPanel2, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(labelPanel2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE);
        }

        if (!isTableEmpty(thirdTableModel)) {
        	int row=thirdTableModel.getRowCount();
        	// Add the label to the horizontal group
        	hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(15).addComponent(ChineseVegLabel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE));
            // Add the label to the vertical group
            vGroup.addComponent(ChineseVegLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE);
            JScrollPane thirdScrollPane = createScrollPane(ChineseVegTable);
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(15).addComponent(thirdScrollPane, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(thirdScrollPane, GroupLayout.PREFERRED_SIZE, ((row*10)), GroupLayout.PREFERRED_SIZE);
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(10).addComponent(labelPanel3, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(labelPanel3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE);
        }

        if (!isTableEmpty(fourthTableModel)) {
        	int row=fourthTableModel.getRowCount(); 
        	// Add the label to the horizontal group
        	hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(15).addComponent(IndianVegLabel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE));
            // Add the label to the vertical group
            vGroup.addComponent(IndianVegLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE);
            JScrollPane fourthScrollPane = createScrollPane(IndianVegTable);
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(15).addComponent(fourthScrollPane, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(fourthScrollPane, GroupLayout.PREFERRED_SIZE, ((row*10)), GroupLayout.PREFERRED_SIZE);
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(10).addComponent(labelPanel4, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(labelPanel4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE);
        }
        if (!isTableEmpty(fifthTableModel)) {
        	int row=fifthTableModel.getRowCount();
        	// Add the label to the horizontal group
        	hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(15).addComponent(BeveragesLabel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE));
            // Add the label to the vertical group
            vGroup.addComponent(BeveragesLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE);
            JScrollPane fifthScrollPane = createScrollPane(BeveragesTable);
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(15).addComponent(fifthScrollPane, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(fifthScrollPane, GroupLayout.PREFERRED_SIZE, ((row*10)), GroupLayout.PREFERRED_SIZE);
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(10).addComponent(labelPanel5, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(labelPanel5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE);
        }
        
        if (!isTableEmpty(sixthTableModel)) {
        	int row=sixthTableModel.getRowCount();
        	// Add the label to the horizontal group
        	hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(15).addComponent(CombosLabel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE));
            // Add the label to the vertical group
            vGroup.addComponent(CombosLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE);
            JScrollPane sixthScrollPane = createScrollPane(CombosTable);
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(15).addComponent(sixthScrollPane, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(sixthScrollPane, GroupLayout.PREFERRED_SIZE, ((row*10)), GroupLayout.PREFERRED_SIZE);
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(10).addComponent(labelPanel6, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(labelPanel6, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE);
        }
        
        if (!isTableEmpty(seventhTableModel)) {
        	int row=seventhTableModel.getRowCount();
        	// Add the label to the horizontal group
        	hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(15).addComponent(ExtrasLabel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE));
            // Add the label to the vertical group
            vGroup.addComponent(ExtrasLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE);
            JScrollPane seventhScrollPane = createScrollPane(ExtrasTable);
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(15).addComponent(seventhScrollPane, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(seventhScrollPane, GroupLayout.PREFERRED_SIZE, ((row*10)), GroupLayout.PREFERRED_SIZE);
            hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        	        .addGap(10).addComponent(labelPanel7, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE));
            vGroup.addComponent(labelPanel7, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE);
        }
        
//        hGroup.addComponent(separator3);
//        vGroup.addComponent(separator3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE);
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
    	        .addGap(15).addComponent(labelPanelLast, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE));
        vGroup.addComponent(labelPanelLast, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE);
        
        gl_contentPanel.setHorizontalGroup(hGroup);
        gl_contentPanel.setVerticalGroup(vGroup);

        contentPanel.setLayout(gl_contentPanel);
        pack();
//        setVisible(true);
        try {
            int rowCount = countRowsInDateRange(directoryPath, formattedDate3, formattedDate3);
            System.out.println("Number of rows in date range: " + rowCount);
            noOfBillsValue.setText(String.format("%d", rowCount));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
//        startTimer();
        printContent("C:\\POS\\Daily_Report\\Report-"+formattedDate2+".pdf","Microsoft Print to PDF");
    }

    private boolean isTableEmpty(DefaultTableModel model) {
        return model.getRowCount() == 0;
    }

    private JTable createTable(DefaultTableModel model) {
        JTable table = new JTable(model);
        table.setBackground(Color.WHITE);
        table.setFont(new Font("Tahoma", Font.PLAIN, 8));
        table.getColumnModel().getColumn(0).setPreferredWidth(360);
        table.getColumnModel().getColumn(1).setPreferredWidth(70);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.setShowGrid(false); // Remove grid lines
        table.setShowHorizontalLines(false); // Remove horizontal lines
        table.setShowVerticalLines(false); // Remove vertical lines
        table.setIntercellSpacing(new Dimension(0, 0)); // Remove space between cells
        table.setBorder(BorderFactory.createEmptyBorder()); // Remove table border
//        table.setTableHeader(null); // Remove table header
        table.setRowHeight(10);
        
        DefaultTableCellRenderer LEFTRenderer = new DefaultTableCellRenderer();
        LEFTRenderer.setHorizontalAlignment(JLabel.LEFT);
        DefaultTableCellRenderer RIGHTRenderer = new DefaultTableCellRenderer();
        RIGHTRenderer.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(0).setCellRenderer(LEFTRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(RIGHTRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(RIGHTRenderer);
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

        
        
     
    private JPanel createLabelPanel(DefaultTableModel tableModel) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        
        
        
        Southindian_subTotalLabel = new JLabel("Sub Total:");
        Southindian_subTotalLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        
        Southindian_subTotalValue = new JLabel(""); // Set appropriate values
        Southindian_subTotalValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Southindian_subTotalValue.setHorizontalAlignment(SwingConstants.RIGHT);
//        Southindian_subTotalValue.setBorder(new LineBorder(new Color(0, 0, 0)));
        
        Southindian_salesTaxLabel = new JLabel("Sales Tax:");
        Southindian_salesTaxLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Southindian_salesTaxValue = new JLabel(""); // Set appropriate values
        Southindian_salesTaxValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Southindian_salesTaxValue.setHorizontalAlignment(SwingConstants.RIGHT);
//        Southindian_salesTaxValue.setBorder(new LineBorder(new Color(0, 0, 0)));

        Southindian_chargesLabel = new JLabel("Charges:");
        Southindian_chargesLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Southindian_chargesValue = new JLabel("0.00"); // Set appropriate values
        Southindian_chargesValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Southindian_chargesValue.setHorizontalAlignment(SwingConstants.RIGHT);
//        Southindian_chargesValue.setBorder(new LineBorder(new Color(0, 0, 0)));
        
        Southindian_totalLabel = new JLabel("Total:");
        Southindian_totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Southindian_totalValue = new JLabel(""); // Set appropriate values
        Southindian_totalValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Southindian_totalValue.setHorizontalAlignment(SwingConstants.RIGHT);
//        Southindian_totalValue.setBorder(new LineBorder(new Color(0, 0, 0)));
        
        Southindian_QuantityValue = new JLabel(""); // Set appropriate values
        Southindian_QuantityValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Southindian_QuantityValue.setHorizontalAlignment(SwingConstants.RIGHT);
//        Southindian_QuantityValue.setBorder(new LineBorder(new Color(0, 0, 0)));
     // Sum the quantity column in table1
        int totalQuantity1 = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int quantity = Integer.parseInt((String) tableModel.getValueAt(i, 1));
            totalQuantity1 += quantity;
        }
        double totalVal1 = 0.00;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
        	double total1 = Double.parseDouble(tableModel.getValueAt(i, 2).toString());
        	totalVal1 += total1;
        }
//        System.out.println("Total quantty in table1: " + totalQuantity1);
        double SalesValue= totalVal1*0.05;
        double TotalValue= SalesValue+totalVal1;
        Southindian_QuantityValue.setText(String.format("%d", totalQuantity1));
        Southindian_subTotalValue.setText(String.format("%.2f", totalVal1));
        Southindian_salesTaxValue.setText(String.format("%.2f", SalesValue));
        Southindian_totalValue.setText(String.format("%.2f", TotalValue));
        
        JSeparator separator = new JSeparator();
        separator.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separator.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separator12 = new JSeparator();
        separator12.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separator12.setForeground(Color.BLACK); // Set separator color to black
        
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(separator, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                        		.addGap(73)
                            .addComponent(Southindian_subTotalLabel)
                            .addGap(32)
                            .addComponent(Southindian_QuantityValue, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                            .addGap(1)
                            .addComponent(Southindian_subTotalValue, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                        		.addGap(73)
                            .addComponent(Southindian_salesTaxLabel)
                            .addGap(42)
                            .addComponent(Southindian_salesTaxValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                        		.addGap(73)
                            .addComponent(Southindian_chargesLabel)
                            .addGap(49)
                            .addComponent(Southindian_chargesValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                        		.addGap(73)
                            .addComponent(Southindian_totalLabel)
                            .addGap(57)
                            .addComponent(Southindian_totalValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(separator12, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                    )
            );

            layout.setVerticalGroup(
                layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(Southindian_subTotalLabel)
                        .addComponent(Southindian_QuantityValue)
                        .addComponent(Southindian_subTotalValue))
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(Southindian_salesTaxLabel)
                        .addComponent(Southindian_salesTaxValue))
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(Southindian_chargesLabel)
                        .addComponent(Southindian_chargesValue))
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(Southindian_totalLabel)
                        .addComponent(Southindian_totalValue))
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(separator12, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
            );

            return panel;
        }
 
    private JPanel createLabelPanel1(DefaultTableModel tableModel) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        MumbaiChaat_subTotalLabel = new JLabel("Sub Total:");
        MumbaiChaat_subTotalLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        MumbaiChaat_subTotalValue = new JLabel(""); // Set appropriate values
        MumbaiChaat_subTotalValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        MumbaiChaat_subTotalValue.setHorizontalAlignment(SwingConstants.RIGHT);
        
        MumbaiChaat_salesTaxLabel = new JLabel("Sales Tax:");
        MumbaiChaat_salesTaxLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        MumbaiChaat_salesTaxValue = new JLabel(""); // Set appropriate values
        MumbaiChaat_salesTaxValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        MumbaiChaat_salesTaxValue.setHorizontalAlignment(SwingConstants.RIGHT);

        MumbaiChaat_chargesLabel = new JLabel("Charges:");
        MumbaiChaat_chargesLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        MumbaiChaat_chargesValue = new JLabel("0.00"); // Set appropriate values
        MumbaiChaat_chargesValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        MumbaiChaat_chargesValue.setHorizontalAlignment(SwingConstants.RIGHT);

        MumbaiChaat_totalLabel = new JLabel("Total:");
        MumbaiChaat_totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        MumbaiChaat_totalValue = new JLabel(""); // Set appropriate values
        MumbaiChaat_totalValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        MumbaiChaat_totalValue.setHorizontalAlignment(SwingConstants.RIGHT);

        MumbaiChaat_QuantityValue = new JLabel(""); // Set appropriate values
        MumbaiChaat_QuantityValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        MumbaiChaat_QuantityValue.setHorizontalAlignment(SwingConstants.RIGHT);
        
     // Sum the quantity column in table1
        int totalQuantity1 = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int quantity = Integer.parseInt((String) tableModel.getValueAt(i, 1));
            totalQuantity1 += quantity;
        }
        double totalVal1 = 0.00;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
        	double total1 = Double.parseDouble(tableModel.getValueAt(i, 2).toString());
        	totalVal1 += total1;
        }
//        System.out.println("Total quantty in table1: " + totalQuantity1);
        double SalesValue= totalVal1*0.05;
        double TotalValue= SalesValue+totalVal1;
        MumbaiChaat_QuantityValue.setText(String.format("%d", totalQuantity1));
        MumbaiChaat_subTotalValue.setText(String.format("%.2f", totalVal1));
        MumbaiChaat_salesTaxValue.setText(String.format("%.2f", SalesValue));
        MumbaiChaat_totalValue.setText(String.format("%.2f", TotalValue));
        
        JSeparator separatorM = new JSeparator();
        separatorM.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separatorM.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separatorM12 = new JSeparator();
        separatorM12.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separatorM12.setForeground(Color.BLACK); // Set separator color to black
        
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(separatorM, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(MumbaiChaat_subTotalLabel)
                            .addGap(32)
                            .addComponent(MumbaiChaat_QuantityValue, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                            .addGap(1)
                            .addComponent(MumbaiChaat_subTotalValue, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(MumbaiChaat_salesTaxLabel)
                            .addGap(42)
                            .addComponent(MumbaiChaat_salesTaxValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(MumbaiChaat_chargesLabel)
                            .addGap(49)
                            .addComponent(MumbaiChaat_chargesValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(MumbaiChaat_totalLabel)
                            .addGap(57)
                            .addComponent(MumbaiChaat_totalValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(separatorM12, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                    )
            );

            layout.setVerticalGroup(
                layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(separatorM, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(MumbaiChaat_subTotalLabel)
                        .addComponent(MumbaiChaat_QuantityValue)
                        .addComponent(MumbaiChaat_subTotalValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(MumbaiChaat_salesTaxLabel)
                        .addComponent(MumbaiChaat_salesTaxValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(MumbaiChaat_chargesLabel)
                        .addComponent(MumbaiChaat_chargesValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(MumbaiChaat_totalLabel)
                        .addComponent(MumbaiChaat_totalValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(separatorM12, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
            );

            return panel;
        }
    
    private JPanel createLabelPanel2(DefaultTableModel tableModel) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        ChineseVeg_subTotalLabel = new JLabel("Sub Total:");
        ChineseVeg_subTotalLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        ChineseVeg_subTotalValue = new JLabel("0.00"); // Set appropriate values
        ChineseVeg_subTotalValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        ChineseVeg_subTotalValue.setHorizontalAlignment(SwingConstants.RIGHT);
        
        ChineseVeg_salesTaxLabel = new JLabel("Sales Tax:");
        ChineseVeg_salesTaxLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        ChineseVeg_salesTaxValue = new JLabel(""); // Set appropriate values
        ChineseVeg_salesTaxValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        ChineseVeg_salesTaxValue.setHorizontalAlignment(SwingConstants.RIGHT);

        ChineseVeg_chargesLabel = new JLabel("Charges:");
        ChineseVeg_chargesLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        ChineseVeg_chargesValue = new JLabel(""); // Set appropriate values
        ChineseVeg_chargesValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        ChineseVeg_chargesValue.setHorizontalAlignment(SwingConstants.RIGHT);

        ChineseVeg_totalLabel = new JLabel("Total:");
        ChineseVeg_totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        ChineseVeg_totalValue = new JLabel(""); // Set appropriate values
        ChineseVeg_totalValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        ChineseVeg_totalValue.setHorizontalAlignment(SwingConstants.RIGHT);

        ChineseVeg_QuantityValue = new JLabel("0"); // Set appropriate values
        ChineseVeg_QuantityValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        ChineseVeg_QuantityValue.setHorizontalAlignment(SwingConstants.RIGHT);
        
     // Sum the quantity column in table1
        int totalQuantity1 = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int quantity = Integer.parseInt((String) tableModel.getValueAt(i, 1));
            totalQuantity1 += quantity;
        }
        double totalVal1 = 0.00;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
        	double total1 = Double.parseDouble(tableModel.getValueAt(i, 2).toString());
        	totalVal1 += total1;
        }
//        System.out.println("Total quantty in table1: " + totalQuantity1);
        double SalesValue= totalVal1*0.05;
        double TotalValue= SalesValue+totalVal1;
        ChineseVeg_QuantityValue.setText(String.format("%d", totalQuantity1));
        ChineseVeg_subTotalValue.setText(String.format("%.2f", totalVal1));
        ChineseVeg_salesTaxValue.setText(String.format("%.2f", SalesValue));
        ChineseVeg_totalValue.setText(String.format("%.2f", TotalValue));
        
        JSeparator separatorM = new JSeparator();
        separatorM.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separatorM.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separatorM12 = new JSeparator();
        separatorM12.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separatorM12.setForeground(Color.BLACK); // Set separator color to black
        
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(separatorM, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(ChineseVeg_subTotalLabel)
                            .addGap(32)
                            .addComponent(ChineseVeg_QuantityValue, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                           .addGap(1)
                            .addComponent(ChineseVeg_subTotalValue, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(ChineseVeg_salesTaxLabel)
                            .addGap(42)
                            .addComponent(ChineseVeg_salesTaxValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(ChineseVeg_chargesLabel)
                            .addGap(49)
                            .addComponent(ChineseVeg_chargesValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(ChineseVeg_totalLabel)
                            .addGap(57)
                            .addComponent(ChineseVeg_totalValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(separatorM12, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                    )
            );

            layout.setVerticalGroup(
                layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(separatorM, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(ChineseVeg_subTotalLabel)
                        .addComponent(ChineseVeg_QuantityValue)
                        .addComponent(ChineseVeg_subTotalValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(ChineseVeg_salesTaxLabel)
                        .addComponent(ChineseVeg_salesTaxValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(ChineseVeg_chargesLabel)
                        .addComponent(ChineseVeg_chargesValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(ChineseVeg_totalLabel)
                        .addComponent(ChineseVeg_totalValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(separatorM12, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
            );


            return panel;
        }
    
    private JPanel createLabelPanel3(DefaultTableModel tableModel) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        IndianVeg_subTotalLabel = new JLabel("Sub Total:");
        IndianVeg_subTotalLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        IndianVeg_subTotalValue = new JLabel(""); // Set appropriate values
        IndianVeg_subTotalValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        IndianVeg_subTotalValue.setHorizontalAlignment(SwingConstants.RIGHT);
        
        IndianVeg_salesTaxLabel = new JLabel("Sales Tax:");
        IndianVeg_salesTaxLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        IndianVeg_salesTaxValue = new JLabel(""); // Set appropriate values
        IndianVeg_salesTaxValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        IndianVeg_salesTaxValue.setHorizontalAlignment(SwingConstants.RIGHT);

        IndianVeg_chargesLabel = new JLabel("Charges:");
        IndianVeg_chargesLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        IndianVeg_chargesValue = new JLabel("0.00"); // Set appropriate values
        IndianVeg_chargesValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        IndianVeg_chargesValue.setHorizontalAlignment(SwingConstants.RIGHT);

        IndianVeg_totalLabel = new JLabel("Total:");
        IndianVeg_totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        IndianVeg_totalValue = new JLabel(""); // Set appropriate values
        IndianVeg_totalValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        IndianVeg_totalValue.setHorizontalAlignment(SwingConstants.RIGHT);

        IndianVeg_QuantityValue = new JLabel(""); // Set appropriate values
        IndianVeg_QuantityValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        IndianVeg_QuantityValue.setHorizontalAlignment(SwingConstants.RIGHT);
        
     // Sum the quantity column in table1
        int totalQuantity1 = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int quantity = Integer.parseInt((String) tableModel.getValueAt(i, 1));
            totalQuantity1 += quantity;
        }
        double totalVal1 = 0.00;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
        	double total1 = Double.parseDouble(tableModel.getValueAt(i, 2).toString());
        	totalVal1 += total1;
        }
//        System.out.println("Total quantty in table1: " + totalQuantity1);
        double SalesValue= totalVal1*0.05;
        double TotalValue= SalesValue+totalVal1;
        IndianVeg_QuantityValue.setText(String.format("%d", totalQuantity1));
        IndianVeg_subTotalValue.setText(String.format("%.2f", totalVal1));
        IndianVeg_salesTaxValue.setText(String.format("%.2f", SalesValue));
        IndianVeg_totalValue.setText(String.format("%.2f", TotalValue));
        
        JSeparator separatorM = new JSeparator();
        separatorM.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separatorM.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separatorM12 = new JSeparator();
        separatorM12.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separatorM12.setForeground(Color.BLACK); // Set separator color to black
        
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(separatorM, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(IndianVeg_subTotalLabel)
                            .addGap(32)
                            .addComponent(IndianVeg_QuantityValue, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                            .addGap(1)
                            .addComponent(IndianVeg_subTotalValue, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(IndianVeg_salesTaxLabel)
                            .addGap(42)
                            .addComponent(IndianVeg_salesTaxValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(IndianVeg_chargesLabel)
                            .addGap(49)
                            .addComponent(IndianVeg_chargesValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(IndianVeg_totalLabel)
                            .addGap(57)
                            .addComponent(IndianVeg_totalValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(separatorM12, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                    )
            );

            layout.setVerticalGroup(
                layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(separatorM, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(IndianVeg_subTotalLabel)
                        .addComponent(IndianVeg_QuantityValue)
                        .addComponent(IndianVeg_subTotalValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(IndianVeg_salesTaxLabel)
                        .addComponent(IndianVeg_salesTaxValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(IndianVeg_chargesLabel)
                        .addComponent(IndianVeg_chargesValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(IndianVeg_totalLabel)
                        .addComponent(IndianVeg_totalValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(separatorM12, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
            );

            return panel;
        }
    
    private JScrollPane createScrollPane(JTable table) {
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setForeground(Color.BLUE);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setPreferredSize(new Dimension(250, 60));
        scrollPane.setMaximumSize(new Dimension(250, Integer.MAX_VALUE));
        return scrollPane;
    }
    private JPanel createLabelPanel4(DefaultTableModel tableModel) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        Beverages_subTotalLabel = new JLabel("Sub Total:");
        Beverages_subTotalLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Beverages_subTotalValue = new JLabel(""); // Set appropriate values
        Beverages_subTotalValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Beverages_subTotalValue.setHorizontalAlignment(SwingConstants.RIGHT);
        
        Beverages_salesTaxLabel = new JLabel("Sales Tax:");
        Beverages_salesTaxLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Beverages_salesTaxValue = new JLabel(""); // Set appropriate values
        Beverages_salesTaxValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Beverages_salesTaxValue.setHorizontalAlignment(SwingConstants.RIGHT);

        Beverages_chargesLabel = new JLabel("Charges:");
        Beverages_chargesLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Beverages_chargesValue = new JLabel("0.00"); // Set appropriate values
        Beverages_chargesValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Beverages_chargesValue.setHorizontalAlignment(SwingConstants.RIGHT);

        Beverages_totalLabel = new JLabel("Total:");
        Beverages_totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Beverages_totalValue = new JLabel(""); // Set appropriate values
        Beverages_totalValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Beverages_totalValue.setHorizontalAlignment(SwingConstants.RIGHT);
//        Beverages_totalValue.setBorder(new LineBorder(new Color(0, 0, 0)));

        Beverages_QuantityValue = new JLabel(""); // Set appropriate values
        Beverages_QuantityValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Beverages_QuantityValue.setHorizontalAlignment(SwingConstants.RIGHT);
        
     // Sum the quantity column in table1
        int totalQuantity1 = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int quantity = Integer.parseInt((String) tableModel.getValueAt(i, 1));
            totalQuantity1 += quantity;
        }
        double totalVal1 = 0.00;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
        	double total1 = Double.parseDouble(tableModel.getValueAt(i, 2).toString());
        	totalVal1 += total1;
        }
//        System.out.println("Total quantty in table1: " + totalQuantity1);
        double SalesValue= totalVal1*0.05;
        double TotalValue= SalesValue+totalVal1;
        Beverages_QuantityValue.setText(String.format("%d", totalQuantity1));
        Beverages_subTotalValue.setText(String.format("%.2f", totalVal1));
        Beverages_salesTaxValue.setText(String.format("%.2f", SalesValue));
        Beverages_totalValue.setText(String.format("%.2f", TotalValue));
        
        JSeparator separatorM = new JSeparator();
        separatorM.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separatorM.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separatorM12 = new JSeparator();
        separatorM12.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separatorM12.setForeground(Color.BLACK); // Set separator color to black
        
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(separatorM, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(Beverages_subTotalLabel)
                            .addGap(32)
                            .addComponent(Beverages_QuantityValue, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                            .addGap(1)
                            .addComponent(Beverages_subTotalValue, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(Beverages_salesTaxLabel)
                            .addGap(42)
                            .addComponent(Beverages_salesTaxValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(Beverages_chargesLabel)
                            .addGap(49)
                            .addComponent(Beverages_chargesValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(Beverages_totalLabel)
                            .addGap(57)
                            .addComponent(Beverages_totalValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(separatorM12, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                    )
            );

            layout.setVerticalGroup(
                layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(separatorM, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Beverages_subTotalLabel)
                        .addComponent(Beverages_QuantityValue)
                        .addComponent(Beverages_subTotalValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Beverages_salesTaxLabel)
                        .addComponent(Beverages_salesTaxValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Beverages_chargesLabel)
                        .addComponent(Beverages_chargesValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Beverages_totalLabel)
                        .addComponent(Beverages_totalValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(separatorM12, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
            );

            return panel;
        }
    private JPanel createLabelPanel5(DefaultTableModel tableModel) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        Combos_subTotalLabel = new JLabel("Sub Total:");
        Combos_subTotalLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Combos_subTotalValue = new JLabel(""); // Set appropriate values
        Combos_subTotalValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Combos_subTotalValue.setHorizontalAlignment(SwingConstants.RIGHT);
        
        Combos_salesTaxLabel = new JLabel("Sales Tax:");
        Combos_salesTaxLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Combos_salesTaxValue = new JLabel(""); // Set appropriate values
        Combos_salesTaxValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Combos_salesTaxValue.setHorizontalAlignment(SwingConstants.RIGHT);

        Combos_chargesLabel = new JLabel("Charges:");
        Combos_chargesLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Combos_chargesValue = new JLabel("0.00"); // Set appropriate values
        Combos_chargesValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Combos_chargesValue.setHorizontalAlignment(SwingConstants.RIGHT);

        Combos_totalLabel = new JLabel("Total:");
        Combos_totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Combos_totalValue = new JLabel("0.00"); // Set appropriate values
        Combos_totalValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Combos_totalValue.setHorizontalAlignment(SwingConstants.RIGHT);

        Combos_QuantityValue = new JLabel("0"); // Set appropriate values
        Combos_QuantityValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Combos_QuantityValue.setHorizontalAlignment(SwingConstants.RIGHT);
        
     // Sum the quantity column in table1
        int totalQuantity1 = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int quantity = Integer.parseInt((String) tableModel.getValueAt(i, 1));
            totalQuantity1 += quantity;
        }
        double totalVal1 = 0.00;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
        	double total1 = Double.parseDouble(tableModel.getValueAt(i, 2).toString());
        	totalVal1 += total1;
        }
//        System.out.println("Total quantty in table1: " + totalQuantity1);
        double SalesValue= totalVal1*0.05;
        double TotalValue= SalesValue+totalVal1;
        Combos_QuantityValue.setText(String.format("%d", totalQuantity1));
        Combos_subTotalValue.setText(String.format("%.2f", totalVal1));
        Combos_salesTaxValue.setText(String.format("%.2f", SalesValue));
        Combos_totalValue.setText(String.format("%.2f", TotalValue));
        
        JSeparator separatorM = new JSeparator();
        separatorM.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separatorM.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separatorM12 = new JSeparator();
        separatorM12.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separatorM12.setForeground(Color.BLACK); // Set separator color to black
        
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(separatorM, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(Combos_subTotalLabel)
                            .addGap(32)
                            .addComponent(Combos_QuantityValue, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                            .addGap(1)
                            .addComponent(Combos_subTotalValue, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(Combos_salesTaxLabel)
                            .addGap(42)
                            .addComponent(Combos_salesTaxValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(Combos_chargesLabel)
                            .addGap(49)
                            .addComponent(Combos_chargesValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(Combos_totalLabel)
                            .addGap(57)
                            .addComponent(Combos_totalValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(separatorM12, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                    )
            );

            layout.setVerticalGroup(
                layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(separatorM, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Combos_subTotalLabel)
                        .addComponent(Combos_QuantityValue)
                        .addComponent(Combos_subTotalValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Combos_salesTaxLabel)
                        .addComponent(Combos_salesTaxValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Combos_chargesLabel)
                        .addComponent(Combos_chargesValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Combos_totalLabel)
                        .addComponent(Combos_totalValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(separatorM12, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
            );


            return panel;
        }
    private JPanel createLabelPanel6(DefaultTableModel tableModel) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        Extras_subTotalLabel = new JLabel("Sub Total:");
        Extras_subTotalLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Extras_subTotalValue = new JLabel("0.00"); // Set appropriate values
        Extras_subTotalValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Extras_subTotalValue.setHorizontalAlignment(SwingConstants.RIGHT);
        
        Extras_salesTaxLabel = new JLabel("Sales Tax:");
        Extras_salesTaxLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Extras_salesTaxValue = new JLabel(""); // Set appropriate values
        Extras_salesTaxValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Extras_salesTaxValue.setHorizontalAlignment(SwingConstants.RIGHT);

        Extras_chargesLabel = new JLabel("Charges:");
        Extras_chargesLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Extras_chargesValue = new JLabel("0.00"); // Set appropriate values
        Extras_chargesValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Extras_chargesValue.setHorizontalAlignment(SwingConstants.RIGHT);

        Extras_totalLabel = new JLabel("Total:");
        Extras_totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Extras_totalValue = new JLabel(""); // Set appropriate values
        Extras_totalValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Extras_totalValue.setHorizontalAlignment(SwingConstants.RIGHT);

        Extras_QuantityValue = new JLabel("0"); // Set appropriate values
        Extras_QuantityValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Extras_QuantityValue.setHorizontalAlignment(SwingConstants.RIGHT);
        
     // Sum the quantity column in table1
        int totalQuantity1 = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int quantity = Integer.parseInt((String) tableModel.getValueAt(i, 1));
            totalQuantity1 += quantity;
        }
        double totalVal1 = 0.00;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
        	double total1 = Double.parseDouble(tableModel.getValueAt(i, 2).toString());
        	totalVal1 += total1;
        }
//        System.out.println("Total quantty in table1: " + totalQuantity1);
        double SalesValue= totalVal1*0.05;
        double TotalValue= SalesValue+totalVal1;
        Extras_QuantityValue.setText(String.format("%d", totalQuantity1));
        Extras_subTotalValue.setText(String.format("%.2f", totalVal1));
        Extras_salesTaxValue.setText(String.format("%.2f", SalesValue));
        Extras_totalValue.setText(String.format("%.2f", TotalValue));
        
        JSeparator separatorM = new JSeparator();
        separatorM.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separatorM.setForeground(Color.BLACK); // Set separator color to black
        
        JSeparator separatorM12 = new JSeparator();
        separatorM12.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separatorM12.setForeground(Color.BLACK); // Set separator color to black
        
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(separatorM, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(Extras_subTotalLabel)
                            .addGap(32)
                            .addComponent(Extras_QuantityValue, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                            .addGap(1)
                            .addComponent(Extras_subTotalValue, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(Extras_salesTaxLabel)
                            .addGap(42)
                            .addComponent(Extras_salesTaxValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(Extras_chargesLabel)
                            .addGap(49)
                            .addComponent(Extras_chargesValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(Extras_totalLabel)
                            .addGap(57)
                            .addComponent(Extras_totalValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(separatorM12, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                    )
            );

            layout.setVerticalGroup(
                layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(separatorM, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Extras_subTotalLabel)
                        .addComponent(Extras_QuantityValue)
                        .addComponent(Extras_subTotalValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Extras_salesTaxLabel)
                        .addComponent(Extras_salesTaxValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Extras_chargesLabel)
                        .addComponent(Extras_chargesValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Extras_totalLabel)
                        .addComponent(Extras_totalValue))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(separatorM12, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
            );


            return panel;
        }
    
    private JPanel createLabelPanelLast() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        Last_subTotalLabel = new JLabel("Totals:");
        Last_subTotalLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
//        Last_subTotalLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
        Last_subTotalValue = new JLabel(""); // Set appropriate values
        Last_subTotalValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Last_subTotalValue.setHorizontalAlignment(SwingConstants.RIGHT);
//        Last_subTotalValue.setBorder(new LineBorder(new Color(0, 0, 0)));
        
        Last_salesTaxLabel = new JLabel("Sales Tax:");
        Last_salesTaxLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
//        Last_salesTaxLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
        Last_salesTaxValue = new JLabel(""); // Set appropriate values
        Last_salesTaxValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Last_salesTaxValue.setHorizontalAlignment(SwingConstants.RIGHT);
//        Last_salesTaxValue.setBorder(new LineBorder(new Color(0, 0, 0)));

        Last_chargesLabel = new JLabel("Charges:");
        Last_chargesLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
//        Last_chargesLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
        Last_chargesValue = new JLabel("0.00"); // Set appropriate values
        Last_chargesValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Last_chargesValue.setHorizontalAlignment(SwingConstants.RIGHT);
//        Last_chargesValue.setBorder(new LineBorder(new Color(0, 0, 0)));

        Last_totalLabel = new JLabel("G. Total:");
        Last_totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
//        Last_totalLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
        Last_totalValue = new JLabel(""); // Set appropriate values
        Last_totalValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Last_totalValue.setHorizontalAlignment(SwingConstants.RIGHT);
//        Last_totalValue.setBorder(new LineBorder(new Color(0, 0, 0)));

        Last_QuantityLabel = new JLabel(" Qty. #"); // Set appropriate values
        Last_QuantityLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
//        Last_QuantityLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
        Last_QuantityValue = new JLabel(""); // Set appropriate values
        Last_QuantityValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Last_QuantityValue.setHorizontalAlignment(SwingConstants.RIGHT);
//        Last_QuantityValue.setBorder(new LineBorder(new Color(0, 0, 0)));
        
        noOfBillsLabel = new JLabel("No of Bills:");
        noOfBillsLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
//        noOfBillsLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
        noOfBillsValue = new JLabel("XXXX");
        noOfBillsValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        noOfBillsValue.setHorizontalAlignment(SwingConstants.RIGHT);

        noOfPersonsLabel = new JLabel("No of Persons:");
        noOfPersonsLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
//        noOfPersonsLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
        noOfPersonsValue = new JLabel("-");
        noOfPersonsValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
//        noOfPersonsValue.setBorder(new LineBorder(new Color(0, 0, 0)));

        cashLabel = new JLabel("Cash:");
        cashLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
//        cashLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
        cashValue = new JLabel("");
        cashValue.setFont(new Font("Tahoma", Font.PLAIN, 8));
        cashValue.setHorizontalAlignment(SwingConstants.RIGHT);
        
        int totalQuantity=Integer.parseInt(Southindian_QuantityValue.getText())+Integer.parseInt(MumbaiChaat_QuantityValue.getText())+Integer.parseInt(ChineseVeg_QuantityValue.getText())+Integer.parseInt(IndianVeg_QuantityValue.getText())+Integer.parseInt(Beverages_QuantityValue.getText())+Integer.parseInt(Combos_QuantityValue.getText())+Integer.parseInt(Extras_QuantityValue.getText());
        double totalsWithoutGst=0.00;
        totalsWithoutGst=totalsWithoutGst+Double.parseDouble(Southindian_subTotalValue.getText().toString());
        totalsWithoutGst=totalsWithoutGst+Double.parseDouble(MumbaiChaat_subTotalValue.getText().toString());
        totalsWithoutGst=totalsWithoutGst+Double.parseDouble(ChineseVeg_subTotalValue.getText().toString());
        totalsWithoutGst=totalsWithoutGst+Double.parseDouble(IndianVeg_subTotalValue.getText().toString());
   		totalsWithoutGst=totalsWithoutGst+Double.parseDouble(Beverages_subTotalValue.getText().toString());
   		totalsWithoutGst=totalsWithoutGst+Double.parseDouble(Combos_subTotalValue.getText().toString());        
   		totalsWithoutGst=totalsWithoutGst+Double.parseDouble(Extras_subTotalValue.getText().toString());
   		
   		double SalesValue= totalsWithoutGst*0.05;
   		
   		Last_totalValue.setText(String.format("%.2f", totalsWithoutGst+SalesValue));
   		cashValue.setText(String.format("%.2f", totalsWithoutGst+SalesValue));
   		Last_QuantityValue.setText(String.format("%d", totalQuantity));
        Last_subTotalValue.setText(String.format("%.2f", totalsWithoutGst));
        Last_salesTaxValue.setText(String.format("%.2f", SalesValue).concat(" "));
        
        Southindian_QuantityValue.setText(Southindian_QuantityValue.getText()+" ");
        Southindian_subTotalValue.setText(Southindian_subTotalValue.getText()+"  ");
        Southindian_salesTaxValue.setText(Southindian_salesTaxValue.getText()+"  ");
        Southindian_chargesValue.setText(Southindian_chargesValue.getText()+"  ");
        Southindian_totalValue.setText(Southindian_totalValue.getText()+"  ");
        
        MumbaiChaat_QuantityValue.setText(MumbaiChaat_QuantityValue.getText()+" ");
        MumbaiChaat_subTotalValue.setText(MumbaiChaat_subTotalValue.getText()+"  ");
        MumbaiChaat_salesTaxValue.setText(MumbaiChaat_salesTaxValue.getText()+"  ");
        MumbaiChaat_chargesValue.setText(MumbaiChaat_chargesValue.getText()+"  ");
        MumbaiChaat_totalValue.setText(MumbaiChaat_totalValue.getText()+"  ");
        
        IndianVeg_QuantityValue.setText(IndianVeg_QuantityValue.getText()+" ");
        IndianVeg_subTotalValue.setText(IndianVeg_subTotalValue.getText()+"  ");
        IndianVeg_salesTaxValue.setText(IndianVeg_salesTaxValue.getText()+"  ");
        IndianVeg_chargesValue.setText(IndianVeg_chargesValue.getText()+"  ");
        IndianVeg_totalValue.setText(IndianVeg_totalValue.getText()+"  ");
        
        Beverages_QuantityValue.setText(Beverages_QuantityValue.getText()+" ");
        Beverages_subTotalValue.setText(Beverages_subTotalValue.getText()+"  ");
        Beverages_salesTaxValue.setText(Beverages_salesTaxValue.getText()+"  ");
        Beverages_chargesValue.setText(Beverages_chargesValue.getText()+"  ");
        Beverages_totalValue.setText(Beverages_totalValue.getText()+"  ");
        
        ChineseVeg_QuantityValue.setText(ChineseVeg_QuantityValue.getText()+" ");
        ChineseVeg_subTotalValue.setText(ChineseVeg_subTotalValue.getText()+"  ");
        ChineseVeg_salesTaxValue.setText(ChineseVeg_salesTaxValue.getText()+"  ");
        ChineseVeg_chargesValue.setText(ChineseVeg_chargesValue.getText()+"  ");
        ChineseVeg_totalValue.setText(ChineseVeg_totalValue.getText()+"  ");
        
        Combos_QuantityValue.setText(Combos_QuantityValue.getText()+" ");
        Combos_subTotalValue.setText(Combos_subTotalValue.getText()+"  ");
        Combos_salesTaxValue.setText(Combos_salesTaxValue.getText()+"  ");
        Combos_chargesValue.setText(Combos_chargesValue.getText()+"  ");
        Combos_totalValue.setText(Combos_totalValue.getText()+"  ");
        
        Extras_QuantityValue.setText(Extras_QuantityValue.getText()+" ");
        Extras_subTotalValue.setText(Extras_subTotalValue.getText()+"  ");
        Extras_salesTaxValue.setText(Extras_salesTaxValue.getText()+"  ");
        Extras_chargesValue.setText(Extras_chargesValue.getText()+"  ");
        Extras_totalValue.setText(Extras_totalValue.getText()+"  ");
        
        Last_subTotalValue.setText(Last_subTotalValue.getText()+"  ");
        Last_salesTaxValue.setText(Last_salesTaxValue.getText()+"  ");
        Last_chargesValue.setText(Last_chargesValue.getText()+"  ");
        Last_totalValue.setText(Last_totalValue.getText()+"  ");
        Last_QuantityValue.setText(Last_QuantityValue.getText()+" ");
        noOfBillsValue.setText(noOfBillsValue.getText()+" ");
        noOfPersonsValue.setText(noOfPersonsValue.getText()+" ");
        cashValue.setText(cashValue.getText()+"  ");
     // Get the current date and time
        LocalDateTime current = LocalDateTime.now();

        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy     hh:mm:ssa");

        // Format the current date and time
        String formatted = current.format(formatter);
        
        invoiceLabel.setText(formatted);
        
        JSeparator separatorL = new JSeparator();
        separatorL.setPreferredSize(new Dimension(100, 90)); // Adjust width as necessary
        separatorL.setForeground(Color.BLACK); // Set separator color to black
        
       
        
     // Set horizontal group
        layout.setHorizontalGroup(
        	    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        	        .addComponent(separatorL, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE) // Make separator span full width
        	        .addGroup(layout.createSequentialGroup()
        	            .addGap(2) // Add space only before Last_QuantityLabel
        	            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        	                .addGroup(layout.createSequentialGroup()
        	                    .addComponent(Last_QuantityLabel)
//        	                    .addGap(3) // Adjust gap between label and its value
        	                    .addComponent(Last_QuantityValue, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        	                    .addGap(16) // Adjust gap between value and next label
        	                    .addComponent(Last_subTotalLabel)
        	                    .addGap(51) // Adjust gap between label and its value
        	                    .addComponent(Last_subTotalValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
        	                .addGroup(layout.createSequentialGroup()
        	                    .addComponent(noOfBillsLabel)
        	                    .addGap(3) // Adjust gap between label and its value
        	                    .addComponent(noOfBillsValue, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        	                .addGroup(layout.createSequentialGroup()
        	                    .addComponent(noOfPersonsLabel)
        	                    .addGap(10) // Adjust gap between label and its value
        	                    .addComponent(noOfPersonsValue))
        	                .addGroup(layout.createSequentialGroup()
        	                    .addComponent(cashLabel)
        	                    .addGap(10) // Adjust gap between label and its value
        	                    .addComponent(cashValue, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        	                .addGroup(layout.createSequentialGroup()
        	                	.addGap(66)
        	                    .addComponent(Last_salesTaxLabel)
        	                    .addGap(43) // Adjust gap between label and its value
        	                    .addComponent(Last_salesTaxValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
        	                .addGroup(layout.createSequentialGroup()
        	                	.addGap(66)
        	                    .addComponent(Last_chargesLabel)
        	                    .addGap(47) // Adjust gap between label and its value
        	                    .addComponent(Last_chargesValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
        	                .addGroup(layout.createSequentialGroup()
        	                	.addGap(66)
        	                    .addComponent(Last_totalLabel)
        	                    .addGap(45) // Adjust gap between label and its value
        	                    .addComponent(Last_totalValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
        	            )
        	        )
        	);



        // Set vertical group
        layout.setVerticalGroup(
        	    layout.createSequentialGroup()
        	        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        	            .addComponent(Last_QuantityLabel)
        	            .addComponent(Last_QuantityValue)
        	            .addComponent(Last_subTotalLabel)
        	            .addComponent(Last_subTotalValue))
        	        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        	            .addComponent(Last_salesTaxLabel)
        	            .addComponent(Last_salesTaxValue))
        	        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        	            .addComponent(Last_chargesLabel)
        	            .addComponent(Last_chargesValue))
        	        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        	            .addComponent(Last_totalLabel)
        	            .addComponent(Last_totalValue))
        	        .addComponent(separatorL, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
        	        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        	            .addComponent(noOfBillsLabel)
        	            .addComponent(noOfBillsValue))
        	        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        	            .addComponent(noOfPersonsLabel)
        	            .addComponent(noOfPersonsValue))
        	        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        	            .addComponent(cashLabel)
        	            .addComponent(cashValue))
        	);


            return panel;
        }
    

//    public void printContent(String outputFilePath) {
//        PrinterJob job = PrinterJob.getPrinterJob();
//
//        // Get available print services
//        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
//        PrintService pdfPrinter = null;
//
//        // Look for a PDF printer
//        for (PrintService printer : printServices) {
//            if (printer.getName().toLowerCase().contains("pdf")) {
//                pdfPrinter = printer;
//                break;
//            }
//        }
//
//        if (pdfPrinter == null) {
//            System.out.println("PDF printer not found.");
//            return;
//        }
//
//        try {
//            // Set the PDF printer as the print service
//            job.setPrintService(pdfPrinter);
//
//            // Set the printable content
//            job.setPrintable(this);
//
//            // Set print attributes
//            PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
//            File pdfFile = new File(outputFilePath);
//            attr.add(new Destination(pdfFile.toURI()));
//
//            // Perform the print operation
//            job.print(attr);
//
//        } catch (PrinterException ex) {
//            System.out.println("Printing error: " + ex.getMessage());
//            ex.printStackTrace();
//        }
//    }
    public void printContent(String outputFilePath, String printerName) {
        PrinterJob job = PrinterJob.getPrinterJob();

        // Get available print services
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        PrintService selectedPrinter = null;

        // Look for the specific printer by name
        for (PrintService printer : printServices) {
            if (printer.getName().equalsIgnoreCase(printerName)) {
                selectedPrinter = printer;
                break;
            }
        }

        if (selectedPrinter == null) {
            System.out.println("Printer '" + printerName + "' not found.");
            return;
        }

        try {
            // Set the selected printer as the print service
            job.setPrintService(selectedPrinter);

            // Set the printable content
            job.setPrintable(this);

            // Set print attributes
            PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
            File pdfFile = new File(outputFilePath);
            attr.add(new Destination(pdfFile.toURI()));

            // Perform the print operation
            job.print(attr);

        } catch (PrinterException ex) {
            System.out.println("Printing error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }


    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        // Get the size of the content
        Dimension contentSize = contentPanel.getPreferredSize();

        // Calculate the number of pages
        int pageHeight = (int) pf.getImageableHeight();
        int totalPageCount = (int) Math.ceil(contentSize.getHeight() / pageHeight);

        if (pageIndex >= totalPageCount) {
            return NO_SUCH_PAGE;
        }

        // Calculate the area of the content to be printed on the current page
        int yOffset = pageIndex * pageHeight;
        // Add a small margin on top for all pages after the first one
        if (pageIndex > 0) {
            yOffset += 80; // Adjust the margin size as needed
        }
        g2d.translate(0, -yOffset);

        // Print the visible portion of the content on the current page
        contentPanel.printAll(g);

        return PAGE_EXISTS;
    }

    public static int countRowsInDateRange(String directoryPath, String startDateStr, String endDateStr) throws IOException, ParseException {
        int rowCount = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date startDate = dateFormat.parse(startDateStr);
        Date endDate = dateFormat.parse(endDateStr);

        List<String> dateList = generateDateList(startDate, endDate, dateFormat);

        for (String dateStr : dateList) {
            String filePath = directoryPath + "/" + dateStr + ".sql";
            rowCount += countRowsInFile(filePath);
        }
        return rowCount;
    }

    private static List<String> generateDateList(Date startDate, Date endDate, SimpleDateFormat dateFormat) {
        List<String> dateList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        while (!calendar.getTime().after(endDate)) {
            dateList.add(dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.DATE, 1);
        }

        return dateList;
    }

    private static int countRowsInFile(String filePath) throws IOException {
        int rowCount = 0;
        String targetString = "INSERT INTO Invoices (invoice_number)";
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().contains(targetString)) {
                    rowCount++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath + " - " + e.getMessage());
        }
        return rowCount;
    }
    




 // Custom cell renderer to add space after the value
    static class CustomCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                label.setText(value.toString() + " "); // Add space after the value
            }
            return c;
        }
        }
//    public static void main(String[] args) {
//        new PDFReport(); // Create an instance of the frame
//    }
}
