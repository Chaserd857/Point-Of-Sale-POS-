
package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.table.*;


import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
@SuppressWarnings("all")
public class mainpanelgenbill extends JFrame implements Printable {
    private JPanel contentPanel;
	private JLabel cashierLabel;
	private JTable itemsTable;
	private static JLabel lblRounding;
	private DefaultTableModel Model;
	private JLabel TimeLabel;
	private JLabel DateLabel;
	private DefaultTableModel tableModel;
	private Object Sub_Field;
	private Object Total_Field;
	private JLabel InvoiceNoLabel;
	private String filePath = "C:\\POS\\Invoices\\invoices.sql";  // Path to the SQL file
	private static SimpleDateFormat dateFormatter;
	private GroupLayout gl_contentPanel;
    private GroupLayout.ParallelGroup hGroup;
    private GroupLayout.SequentialGroup vGroup;
    private String billval,datetodo,invdata1;
    private JLabel Token_number;
    private int q1;
    
	
    public mainpanelgenbill(DefaultTableModel model,Object Subtotal_Field, Object Total_Field, String DATEGET, String invdata,int qty1) {
    	this.Sub_Field = Subtotal_Field;
    	this.Total_Field = Total_Field;
    	this.tableModel = model;
    	this.datetodo = DATEGET;
    	this.invdata1 = invdata;
    	this.q1 = qty1;
    	createGUI();
    }
    private void createGUI() {
        setTitle("Blank Invoice - 80mm x 297mm");
        
        // Converting millimeters to pixels assuming 96 DPI
        int widthPx = (int) ((60 / 25.6) * 96);
        int heightPx = (int) ((90 / 25.6) * 96);

     // Get current date
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String formattedDate = currentDate.format(formatter);

        // File path with date
        filePath = "C:\\POS\\Invoice_Data\\Day_Wise\\"+formattedDate + ".sql";
        
        setSize(270, 299);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        setIconImage(Toolkit.getDefaultToolkit().getImage(mainpanelgenbill.class.getResource("/mainpanel/LOGO-removebg-preview.png")));
        
        int[] sourceColumns = {1, 4, 3,7};       // indices of the columns in the source table
        int[] destinationColumns = {1, 2, 3,4};  // corresponding indices in the destination table
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        
        // Creating and configuring the content panel
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        
        
     // Add components to content panel
        JLabel titleLogo = new JLabel();
     // Use the createResizedIcon method to load and resize the image
        ImageIcon resizedIcon = createResizedIcon("/mainpanel/dp.png", 140,50); // Adjust the path and size
        // Set the image icon to the JLabel
        titleLogo.setIcon(resizedIcon);
        
        // Add components to content panel
        JLabel titleLabel = new JLabel("Guruji Sai Enterprises");
        titleLabel.setFont(new Font("Arial Black", Font.BOLD, 10));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align the title
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
     // Create plain text labels f	or each line
        JLabel firstLine1 = new JLabel("Shop No : 22, H-Block, Amity");
        firstLine1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 10	));
        firstLine1.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstLine1.setHorizontalAlignment(SwingConstants.CENTER); // Center align the first line
        
        JLabel firstLine2 = new JLabel("University,");
        firstLine2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 10	));
        firstLine2.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstLine2.setHorizontalAlignment(SwingConstants.CENTER); // Center align the first line
        
        JLabel firstLine3 = new JLabel("Sector 125, Noida, U.P. - 201301");
        firstLine3.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 10	));
        firstLine3.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstLine3.setHorizontalAlignment(SwingConstants.CENTER); // Center align the first line
        
        JLabel Mobno = new JLabel("Mob: +91 9540 9999 30");
        Mobno.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 10));
        Mobno.setAlignmentX(Component.CENTER_ALIGNMENT);	
        Mobno.setHorizontalAlignment(SwingConstants.CENTER); // Center align the first line
        
        JLabel GstIn = new JLabel("FSSAI: 12725055000422");
        GstIn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 10));
        GstIn.setAlignmentX(Component.CENTER_ALIGNMENT);
        GstIn.setHorizontalAlignment(SwingConstants.CENTER); // Center align the first line
        
        JLabel siteweb = new JLabel("www.dosaplaza.com");
        siteweb.setFont(new Font("Arial", Font.PLAIN, 10));
        siteweb.setAlignmentX(Component.CENTER_ALIGNMENT);
        siteweb.setHorizontalAlignment(SwingConstants.CENTER); // Center align the first line

        JLabel invoiceLabel = new JLabel("RETAIL INVOICE");
        invoiceLabel.setFont(new Font("Myanmar Text", Font.PLAIN, 11));
        invoiceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        invoiceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        
        
        JSeparator LineLabel = new JSeparator();
        LineLabel.setBackground(Color.BLACK);
        LineLabel.setForeground(Color.BLACK);
        JSeparator LineLabel12 = new JSeparator(); 
        LineLabel12.setBackground(Color.BLACK);
        LineLabel12.setForeground(Color.BLACK);
        JSeparator LineLabel13 = new JSeparator();       
        LineLabel13.setBackground(Color.BLACK);
        LineLabel13.setForeground(Color.BLACK);
        JSeparator LineLabel14 = new JSeparator();       
        LineLabel14.setBackground(Color.BLACK);
        LineLabel14.setForeground(Color.BLACK);
        
        JSeparator LineLabel2A = new JSeparator();
        LineLabel2A.setBackground(Color.BLACK);
        LineLabel2A.setForeground(Color.BLACK);
        
        JLabel namelabel = new JLabel("Name:");
        namelabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
        namelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        namelabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align the first line
        
        JLabel BillNo = new JLabel("Bill No.:" + invdata1);
        BillNo.setFont(new Font("Tahoma", Font.PLAIN, 10));
        BillNo.setAlignmentX(Component.CENTER_ALIGNMENT);
        BillNo.setHorizontalAlignment(SwingConstants.LEFT);
        
        JLabel BillDate = new JLabel("Date:");
        BillDate.setFont(new Font("Tahoma", Font.PLAIN, 10));
        BillDate.setAlignmentX(Component.CENTER_ALIGNMENT);
        BillDate.setHorizontalAlignment(SwingConstants.LEFT);
        
        cashierLabel = new JLabel("Cashier: biller"); // New Label for the cashier
        cashierLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
        cashierLabel.setHorizontalAlignment(SwingConstants.LEFT);

        String yearlyfilePath = "C:\\POS\\Invoice_Data\\Complete\\yearlybill.sql";
       
        
        Token_number= new JLabel("Token No.:");
        Token_number.setFont(new Font("Tahoma", Font.BOLD, 10));
        Token_number.setHorizontalAlignment(SwingConstants.LEFT);
        
        
        
        // Add the content panel to the center of the BorderLayout
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        
        DateLabel = new JLabel(datetodo);
        DateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        DateLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
        
        
        InvoiceNoLabel = new JLabel("");
        InvoiceNoLabel.setHorizontalAlignment(SwingConstants.LEFT);
        InvoiceNoLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
        
//        try {
//            // Extract yearlynumber value from the SQL file
//                String yearlyNumber = extractYearlyNumberValue(yearlyfilePath);
//                if (yearlyNumber != null) {
//                	
//                   System.out.println("Yearly Number Value: " + yearlyNumber);
//                   InvoiceNoLabel.setText(Integer.toString(Integer.parseInt(yearlyNumber)+1));
//                   updateYearlyNumberValue(yearlyfilePath, Integer.toString(Integer.parseInt(yearlyNumber)+1));
//                  } else {
//                         System.out.println("No yearlynumber value found in the SQL file.");
//                      }
//           } catch (IOException e) {
//                      e.printStackTrace();
//                 }
        
        
        JLabel PickupLabel = new JLabel("Pick Up");
        PickupLabel.setHorizontalAlignment(SwingConstants.LEFT);
        PickupLabel.setFont(new Font("Nirmala UI", Font.BOLD | Font.BOLD, 11));
        PickupLabel.setAlignmentX(0.5f);
        
        JLabel qtyTotal = new JLabel("Total Qty:");
        qtyTotal.setVerticalAlignment(SwingConstants.CENTER); // Center the text vertically
        qtyTotal.setFont(new Font("Tahoma", Font.PLAIN, 10));
        
        JLabel qtyTotalval = new JLabel(String.valueOf(q1));
        qtyTotalval.setFont(new Font("Tahoma", Font.PLAIN, 10));
        qtyTotalval.setHorizontalAlignment(SwingConstants.RIGHT);
        
        
        TimeLabel = new JLabel("");
        TimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        TimeLabel.setFont(new Font("Century Gothic", Font.PLAIN, 10));
        TimeLabel.setAlignmentX(0.5f);
        
        JLabel SubTotal = new JLabel("<html><span style='color:white'>.</span>Sub<br>Total</html>");
        SubTotal.setFont(new Font("Dialog", Font.PLAIN, 10));
        SubTotal.setVerticalAlignment(SwingConstants.CENTER); // Add this line
        
        SubTotal.setPreferredSize(new Dimension(30,30));
        JPanel subTotalPanel = new JPanel(new BorderLayout());
        subTotalPanel.setBackground(Color.WHITE);
        subTotalPanel.add(SubTotal, BorderLayout.NORTH);
        subTotalPanel.setPreferredSize(new Dimension(30, 30)); // Set the preferred size of the panel

        
        JLabel SGST = new JLabel("SGST 2.5%");
        SGST.setFont(new Font("Dialog", Font.PLAIN, 10));
//        SGST.setFont(SGST.getFont().deriveFont(8.5f));
        SGST.setAlignmentX(Component.CENTER_ALIGNMENT);
        SGST.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel CGST = new JLabel("CGST 2.5%");
        CGST.setFont(new Font("Dialog", Font.PLAIN, 10));
        CGST.setAlignmentX(Component.CENTER_ALIGNMENT);
        CGST.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel Rounding = new JLabel("Round off");
        Rounding.setFont(new Font("Dialog", Font.PLAIN, 7));
        Rounding.setAlignmentX(Component.CENTER_ALIGNMENT);
        Rounding.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblSubTotal = new JLabel("00000");
        lblSubTotal.setBorder(null);
        lblSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblSubTotal.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblSubTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JLabel lblSGST = new JLabel("00000");
        lblSGST.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblSGST.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSGST.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel lblCGST = new JLabel("00000");
        lblCGST.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblCGST.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCGST.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        lblRounding = new JLabel("+0.00 ");
        lblRounding.setFont(new Font("Tahoma", Font.PLAIN, 8));
        lblRounding.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblRounding.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JSeparator LineLabel2 = new JSeparator();
        LineLabel2.setBackground(Color.BLACK);
        LineLabel2.setForeground(Color.BLACK);
        
        JSeparator LineLabel3 = new JSeparator();
        LineLabel3.setBackground(Color.BLACK);
        LineLabel3.setForeground(Color.BLACK);
        
        
        JLabel Total = new JLabel("Grand Total");
        Total.setFont(new Font("Dialog", Font.BOLD, 11));
        Total.setAlignmentX(Component.CENTER_ALIGNMENT);
        Total.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblTotal = new JLabel("00000");
        lblTotal.setBorder(null);
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblTotal.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
//        lblTotal.setBorder(new LineBorder(new Color(128,128,255)));
        
        JLabel GSTNo = new JLabel("  GST No: 09AADFF3676N1ZV");
        GSTNo.setFont(new Font("Tahoma", Font.PLAIN, 8));
        GSTNo.setAlignmentX(Component.CENTER_ALIGNMENT);
        GSTNo.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel site = new JLabel("Thanks for Dinning with us...");
        site.setForeground(new Color(0, 0, 128));
        site.setFont(new Font("Tahoma", Font.PLAIN, 10));
        site.setAlignmentX(Component.CENTER_ALIGNMENT);
        site.setHorizontalAlignment(SwingConstants.LEFT);
        
        JLabel Greet = new JLabel("Please Visit Again...");
        Greet.setForeground(new Color(0, 0, 128));
        Greet.setFont(new Font("Tahoma", Font.PLAIN, 10));
        Greet.setAlignmentX(Component.CENTER_ALIGNMENT);
        Greet.setHorizontalAlignment(SwingConstants.LEFT);
        
        JLabel HEADING = new JLabel("Item");
        HEADING.setFont(new Font("Tahoma", Font.PLAIN, 10));
        JLabel HEADING1 = new JLabel("Qty.");
        HEADING1.setFont(new Font("Tahoma", Font.PLAIN, 10));
        JLabel HEADING2 = new JLabel("Price");
        HEADING2.setFont(new Font("Tahoma", Font.PLAIN, 10));
        JLabel HEADING3 = new JLabel("Amount");
        HEADING3.setFont(new Font("Tahoma", Font.PLAIN, 10));
        
        // Table Data and Column Names
        String[] columnNames = {" No.", "Item Name", "Price","Qty.","     Total  "};

        // Initialize the table
        Model = new DefaultTableModel(columnNames,0);
        itemsTable = new JTable(Model);
        itemsTable.setBorder(new LineBorder(Color.WHITE));
        itemsTable.setRowSelectionAllowed(false);
        itemsTable.setBackground(Color.WHITE);
        itemsTable.setFont(new Font("Tahoma", Font.PLAIN, 8));
        itemsTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        itemsTable.getColumnModel().getColumn(1).setPreferredWidth(270);
        itemsTable.getColumnModel().getColumn(2).setPreferredWidth(70);
        itemsTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        itemsTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        itemsTable.setShowHorizontalLines(false);
        itemsTable.setShowVerticalLines(false);
     // Set the font for table headers
        JTableHeader tableHeader = itemsTable.getTableHeader();
        tableHeader.setFont(new Font("Tahoma", Font.BOLD, 8));  // Set the font size for headers
        JScrollPane scrollPane = new JScrollPane(itemsTable);
        scrollPane.setBorder(new LineBorder(Color.WHITE));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        
        DefaultTableCellRenderer CENTERRenderer = new DefaultTableCellRenderer();
        CENTERRenderer.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer RIGHTRenderer = new DefaultTableCellRenderer();
        RIGHTRenderer.setHorizontalAlignment(JLabel.RIGHT);
        itemsTable.getColumnModel().getColumn(0).setCellRenderer(CENTERRenderer);
        itemsTable.getColumnModel().getColumn(3).setCellRenderer(CENTERRenderer);
        itemsTable.getColumnModel().getColumn(2).setCellRenderer(RIGHTRenderer);
        itemsTable.getColumnModel().getColumn(4).setCellRenderer(RIGHTRenderer);
        itemsTable.setRowHeight(10);
        itemsTable.getTableHeader().setVisible(false); // Hides the table header
        itemsTable.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 0)); // Adjust the size to ensure it doesn't take space
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setForeground(Color.BLUE);
        scrollPane.setPreferredSize(new Dimension(250, 60)); // Make sure the table fits within the frame
        scrollPane.setMaximumSize(new Dimension(250, Integer.MAX_VALUE)); // allow height to increase

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
     // Apply this renderer to all header columns
        JTableHeader header = itemsTable.getTableHeader();
        header.setDefaultRenderer(headerRenderer);
        
        int RowCount=tableModel.getRowCount();
        
        gl_contentPanel = new GroupLayout(contentPanel);
        hGroup = gl_contentPanel.createParallelGroup(Alignment.LEADING);
        vGroup = gl_contentPanel.createSequentialGroup();

        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
                .addGap(45)
                .addComponent(titleLogo));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
                .addGap(75)
                .addComponent(invoiceLabel));
        vGroup.addComponent(titleLogo)
        		.addGap(4)
        		.addComponent(invoiceLabel,GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE);
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
                .addGap(50)
                .addComponent(titleLabel));
        
        
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
                .addGap(20)
                .addComponent(LineLabel));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
                .addGap(20)
                .addComponent(namelabel));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
                .addGap(20)
                .addComponent(LineLabel2A));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
			    .addGap(	20)
			    .addComponent(BillDate,GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
			    
			    .addComponent(DateLabel,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
			    .addGap(12)
			    .addComponent(PickupLabel));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
			    .addGap(	20)
			    .addComponent(cashierLabel,GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
			    .addGap(2)
			    .addComponent(BillNo)
			    .addGap(5)
			    .addComponent(InvoiceNoLabel,GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
                .addGap(20)
                .addComponent(TimeLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        		.addGap(20)
                .addComponent(LineLabel12));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
                .addGap(20)
                .addComponent(HEADING)
                .addGap(75)
                .addComponent(HEADING1)
                .addGap(5)
                .addComponent(HEADING2)
                .addGap(5)
                .addComponent(HEADING3));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        		.addGap(20)
                .addComponent(LineLabel13));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
                .addGap(	45)
                .addComponent(firstLine1));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
                .addGap(	39)
                .addComponent(firstLine2,GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
                .addGap(	37)
                .addComponent(firstLine3));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
                .addGap(	37)
                .addComponent(Mobno,GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
                .addGap(	37)
                .addComponent(GstIn,GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
                .addGap(	37)
                .addComponent(siteweb,GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE));
        
        
        
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        		.addGap(20)
                .addComponent(LineLabel14));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        		.addGap(74)
        		.addComponent(qtyTotal)
        		.addComponent(qtyTotalval,GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
        		.addGap(4)
                .addComponent(subTotalPanel,GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                
                .addComponent(lblSubTotal, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        		.addGap(107)
                .addComponent(SGST)
                .addGap(10)
                .addComponent(lblSGST, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        		.addGap(107)
                .addComponent(CGST)
                .addGap(10)
                .addComponent(lblCGST, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE));
        
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        		.addGap(20)
        		.addComponent(LineLabel2));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        		.addGap(107)
                .addComponent(Rounding)
                .addGap(14)
                .addComponent(lblRounding, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE));
        
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        		.addGap(72)
                .addComponent(Total)
                .addGap(10)
                .addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
        		.addGap(20)
        		.addComponent(LineLabel3));
       
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
                .addGap(45)
                .addComponent(site));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
                .addGap(65)
                .addComponent(Greet));
        hGroup.addGroup(gl_contentPanel.createSequentialGroup()
                .addGap(20)
                .addComponent(Token_number));

        vGroup.addComponent(titleLabel)
        .addComponent(firstLine1)
    	.addComponent(firstLine2)
    	.addComponent(firstLine3)
    	.addComponent(Mobno)
    	.addComponent(GstIn)
    	.addGap(1)
    	.addComponent(siteweb)
            .addGap(2)
            
            .addComponent(LineLabel)
            .addGap(3)
            .addComponent(namelabel)
            .addGap(3)
            .addComponent(LineLabel2A)
            .addGap(6)
            .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                    .addComponent(BillDate)
                    .addComponent(DateLabel)
                    .addComponent(PickupLabel))
            .addComponent(TimeLabel, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
            .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                    .addComponent(cashierLabel)
                    .addComponent(BillNo)
                    .addComponent(InvoiceNoLabel))
            .addComponent(Token_number)
                
            .addGap(1)
            
            	
                .addComponent(LineLabel12)
                .addGap(5)
                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                		.addComponent(HEADING, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                		.addComponent(HEADING1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                		.addComponent(HEADING2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                		.addComponent(HEADING3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                .addGap(5)
            
                .addComponent(LineLabel13)
                .addGap(5);
    		int row=tableModel.getRowCount();
    		addRowsToPanel(row);


            vGroup.addGap(4)
            .addComponent(LineLabel14)
            .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
            		.addComponent(qtyTotal, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
            		.addComponent(qtyTotalval, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(subTotalPanel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblSubTotal, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
            .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                .addComponent(SGST)
                .addComponent(lblSGST))
            .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                .addComponent(CGST)
                .addComponent(lblCGST))
            
            .addGap(3)
            .addComponent(LineLabel2)
            .addGap(3)
            .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
            		
                    .addComponent(Rounding)
                    .addGap(1)
                    .addComponent(lblRounding))
            .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                .addComponent(Total)
                .addComponent(lblTotal)
                )
            .addGap(3)
            .addComponent(LineLabel3)
            .addGap(3)
            .addComponent(site)
            .addComponent(Greet);

        gl_contentPanel.setHorizontalGroup(hGroup);
        gl_contentPanel.setVerticalGroup(vGroup);

        contentPanel.setLayout(gl_contentPanel);
        
        // Making the frame visible
//        setVisible(true);
        copyDataWithColumnMapping(tableModel,Model);
        lblSubTotal.setText(Sub_Field.toString()+"  ");
        lblTotal.setText(String.format("₹%d.00", manipulateString(Total_Field.toString()))+" ");

        
        Double sub=Double.parseDouble(Sub_Field.toString().trim());
        Double SGST_CGST=sub*0.025;
        lblSGST.setText(String.format("%.2f", SGST_CGST) +" ");
        lblCGST.setText(String.format("%.2f", SGST_CGST) +" ");
//        System.out.print("================="+SGST_CGST);
        
//        CheckInvoice(filePath);
     // Ensure the content panel is validated and repainted
        contentPanel.validate();
        contentPanel.repaint();
        
        // Get the current date and time
        LocalDateTime current = LocalDateTime.now();

        // Define the desired format
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yy");

        // Format the current date and time
        String formatted = current.format(formatter2);
     // Define the desired format
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm");

        // Format the current date and time
        String formatted1 = current.format(formatter1);
        
        TimeLabel.setText(formatted1);
        pack();
        String grandTotalText = lblTotal.getText();
        grandTotalText = grandTotalText.replace("₹", "");
        calculateGrandTotal(Double.parseDouble(lblSubTotal.getText()),Double.parseDouble(lblSGST.getText()),Double.parseDouble(lblCGST.getText()),Double.parseDouble(grandTotalText));
        
        // Create SimpleDateFormat with "ddMMYYYY"
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY");
        
        // Get the current date
        String currentDatedisc = "C:\\POS\\DISCOUNT\\disc"+sdf.format(new Date())+".sql";
        
//        appendDiscToFile(currentDatedisc,billval,grandTotalText);
        
//        KOT(billval);
        printContent(filePath);
        String invoice=billval;
     // Get current date
        LocalDate currentDatenew = LocalDate.now();
        DateTimeFormatter formatternew = DateTimeFormatter.ofPattern("ddMMyyyy");
        String formattedDatenew = currentDatenew.format(formatternew);
//        writeDataToSQLFile(invoice,itemsTable, "C:\\POS\\Invoice_Data\\Complete\\"+formattedDatenew+".sql");
        
        }

    private void printContent(String filePath) {
    	PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);

        PageFormat pf = job.defaultPage();
        Paper paper = new Paper();
        // Calculate required paper size dynamically
        Dimension contentSize = contentPanel.getPreferredSize();
        double width = contentSize.width * 72 / 25.4;  // converting mm to points
        double height = contentSize.height * 72 / 25.4;
        paper.setSize(width, height);

        // Set the imageable area to match the paper size exactly, to avoid white space
        paper.setImageableArea(0.2,0.2, width, height);
        pf.setPaper(paper);
        job.setPrintable(this, pf);

        try {
            job.print();
            dispose();
            
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }

    @Override
        public int print(Graphics g, PageFormat pf, int pageIndex) {
            if (pageIndex != 0) {
                return NO_SUCH_PAGE;
            }
            Graphics2D g2d = (Graphics2D) g;
            g2d.translate(pf.getImageableX(), pf.getImageableY());
            contentPanel.printAll(g);
            return PAGE_EXISTS;
        }
    private void copyDataWithColumnMapping(DefaultTableModel sourceModel, DefaultTableModel destinationModel) {
        int autoIncrement = 1;  // Start the auto-incrementing number
        // Search for the item description in the table model
        for (int row = 0; row < sourceModel.getRowCount(); row++) {
            String description = (String) sourceModel.getValueAt(row, 0); // Assuming description is in column 1
            Object Price = sourceModel.getValueAt(row, 2);
            Object Qty = sourceModel.getValueAt(row, 1);
            Object Amt = sourceModel.getValueAt(row, 3);
            double value = Double.parseDouble(Price.toString());
            int intValue = (int) Math.round(value);
//            String strValue = String.valueOf(intValue);
            // Create a new row for the destination model, adding the auto-increment number as the first element
            Object[] newRow = new Object[5];  // Adjust the size based on your destination model's column count
            newRow[0] = autoIncrement++;  // Auto-increment ID
            newRow[1] = description;
            newRow[2] = intValue+" ";
            newRow[3] = Qty;
            newRow[4] = Amt+" ";
            destinationModel.addRow(newRow);

            // Recalculate the table's size and update the scroll pane's preferred size
            itemsTable.doLayout();
            JViewport viewport = (JViewport) itemsTable.getParent();
            viewport.setPreferredSize(new Dimension(viewport.getWidth(), itemsTable.getPreferredSize().height));
        }
    }
    public static void calculateGrandTotal(double subtotal, double sgst, double cgst, double grandTotal) {
        double result = grandTotal-(subtotal + sgst + cgst);
        String sign = "";
        if (result > 0) {
            sign = "+";
        } else if (result < 0) {
            sign = "";
        }
//        System.out.println("______________________________________Result: " + sign + String.format("%.2f", result));
        lblRounding.setText(sign + String.format("%.2f", result)+" ");
    }
//  Function to read the file and extract yearlynumber value from INSERT statement
 	    public static String extractYearlyNumberValue(String filePath) throws IOException {
 	        StringBuilder content = new StringBuilder();
 	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
 	            String line;
 	            while ((line = reader.readLine()) != null) {
 	                content.append(line).append("\n");
 	            }
 	        }
 	
 	        // SQL pattern to match "INSERT INTO" statements and extract yearlynumber value
 	        String regex = "INSERT INTO\\s+Invoices\\s*\\(yearlynumber\\)\\s*VALUES\\s*\\(\\s*'(.+?)'\\s*\\)";
 	        Pattern pattern = Pattern.compile(regex);
 	        Matcher matcher = pattern.matcher(content.toString());
 	
 	        if (matcher.find()) {
 	            return matcher.group(1); // Extract the value inside the single quotes
 	        } else {
 	            return null; // No matching INSERT statement found
 	        }
 	    }
    
    private void CheckInvoice(String filePath)
    {
    	
        File file = new File(filePath);
        boolean fileExists = file.exists();  // Check if the file already exists

        Set<String> existingInvoices = new HashSet<>();
        Pattern pattern = Pattern.compile("VALUES \\('([^']*)'\\)");  // Regex to extract invoice numbers

        // Read all existing invoices if the file exists
        if (fileExists) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        existingInvoices.add(matcher.group(1));
                    }
                }
            } catch (IOException e) {
                System.err.println("An error occurred while reading the file: " + e.getMessage());
                return;
            }
        } else {
            // File does not exist, so we'll create it and write the initial SQL command to create the table
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write("CREATE TABLE Invoices (\n");
                writer.write("    id INT AUTO_INCREMENT PRIMARY KEY,\n");
                writer.write("    invoice_number VARCHAR(255) NOT NULL\n");
                writer.write(");\n");
                System.out.println("Initialized new SQL file with table structure.");
            } catch (IOException e) {
                System.err.println("Failed to create and initialize new SQL file: " + e.getMessage());
                return;
            }
        }

        String baseInvoiceNumber = "1";  // Starting point for invoice numbers
        String invoiceNumberToWrite = generateUniqueInvoice(existingInvoices);
        billval=invoiceNumberToWrite;
        Token_number.setText("Token No.: "+billval);
        InvoiceNoLabel.setText(billval);        // Append the unique invoice to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(String.format("INSERT INTO Invoices (invoice_number) VALUES ('%s');\n", invoiceNumberToWrite));
            System.out.println("Invoice added: " + invoiceNumberToWrite);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
    public void addRowsToPanel(int rowCount) {
        int setCounter = 1; // Counter for numbering the rows

        for (int row = 0; row < rowCount; row++) {
            String item = tableModel.getValueAt(row, 0).toString();
            if(item.contains(".Regular")) {
            	item= item.replace(".Regular","(Regular)" );
            	
            }
            if(item.contains(".Cheese")) {
            	item= item.replace(".Cheese","(Cheese)" );
            	
            }
            if(item.contains(".Butter")) {
            	item= item.replace(".Butter","(Butter)" );
            	
            }
            if(item.contains(".Ghee")) {
            	item= item.replace(".Ghee","(Ghee)" );
            	
            }
            
            System.out.println(item);
            JLabel lblColumn2 = new JLabel();
//            lblColumn2.setBorder(new LineBorder(Color.BLACK));
            lblColumn2.setFont(new Font("Tahoma", Font.PLAIN, 10));
            lblColumn2.setHorizontalAlignment(SwingConstants.LEFT);
            setLabelIfNotEmpty(lblColumn2, item);

            double val1 = Double.parseDouble(tableModel.getValueAt(row, 2).toString());
            JLabel lblColumn4 = new JLabel(String.format("%.2f", val1) + " ");
            manipulateLabel(lblColumn4);

//            lblColumn4.setBorder(new LineBorder(Color.BLACK));

            JLabel lblColumn3 = new JLabel();
            manipulateLabel(lblColumn3);
            setLabelIfNotEmpty(lblColumn3, tableModel.getValueAt(row, 1).toString());
//            lblColumn3.setBorder(new LineBorder(Color.BLACK));

            double val = Double.parseDouble(tableModel.getValueAt(row, 3).toString());
            JLabel lblColumn5 = new JLabel(String.format("%.2f", val) + " ");
            manipulateLabel(lblColumn5);


            // Add the horizontal group for each row
            hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPanel.createSequentialGroup()
                    
                    .addGap(20)
                    .addComponent(lblColumn2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                    
                    .addComponent(lblColumn3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                    .addGap(4)
                    .addComponent(lblColumn4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    
                    .addComponent(lblColumn5, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                )
            );

            // Add the vertical group for each row
            vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                
                .addComponent(lblColumn2)
                .addComponent(lblColumn3)
                .addComponent(lblColumn4)
                .addComponent(lblColumn5)
            );
        }
    }

    private static String generateUniqueInvoice(Set<String> existingInvoices) {
        int number = 1; // Start the invoice number from 1
        String invoiceNumber;
        // Increment the number part until a unique invoice is found
        do {
            invoiceNumber = String.valueOf(number++);
        }while (existingInvoices.contains(invoiceNumber));
        
        return invoiceNumber;
    }
    private static void appendInvoiceToFile(String filePath, String invoiceNumber) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath), true))) {
            writer.write(String.format("INSERT INTO Invoices (invoice_number) VALUES ('%s');\n", invoiceNumber));
            System.out.println("Invoice added: " + invoiceNumber);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
    private static void appendDiscToFile(String filePath, String invoiceNumber, String TAMT) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath), true))) {
            writer.write(String.format("INSERT INTO Invoice_Disc (invoice_number, amount) VALUES ('%s', '%s');\n", invoiceNumber, TAMT));
            System.out.println("DISCOUNT Invoice added: " + invoiceNumber + ", Amount: " + TAMT);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

//    @Override
    public void KOT(String dat) {
    	KOT_BILL counter = new KOT_BILL(Model,dat);
//		 counter.setLocationRelativeTo(null);
//		 counter.setVisible(true);
    }
    private static void writeDataToSQLFile(String invoiceNumber, JTable table, String filename) {
    	TableModel model = table.getModel();
        int rowCount = model.getRowCount();

        // Check if file exists, and create it if it does not
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();  // This will create the file if it does not exist
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Append data to the file
     // Append data to the file
        try (FileWriter writer = new FileWriter(file, true)) { // Enable append mode
            for (int i = 0; i < rowCount; i++) {
                StringBuilder sql = new StringBuilder("INSERT INTO InvoiceDetails VALUES (");
                
                java.util.Date today = new java.util.Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = dateFormat.format(today);
                sql.append("'").append(formattedDate).append("', ");  // Insert the current date in the format yyyy/MM/dd
                
                sql.append("'").append(invoiceNumber).append("'").append(", ");  // Insert the invoice number
                
                for (int j = 0; j < model.getColumnCount(); j++) {
                    Object value = model.getValueAt(i, j);
                    if (value!= null) {
                        sql.append("'").append(value).append("'");
                    } else {
                        sql.append("NULL");
                    }
                    if (j < model.getColumnCount() - 1) sql.append(", ");  
                }
                
                // Fill remaining columns with NULL up to 14 items
                for (int j = model.getColumnCount(); j < 5; j++) {
                    sql.append("NULL");
                    if (j < 13) sql.append(", ");
                }
                sql.append(");");
                writer.write(sql.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setLabelIfNotEmpty(JLabel label, String text) {
		if (!text.isEmpty()) {
			label.setText("<html>" + text.replaceAll("\n", "<br>") + "</html>");
		}
		
	}
    private static ImageIcon createResizedIcon(String path, int width, int height) {
        ImageIcon icon = null;
        try {
            // Load the image from classpath
            Image image = ImageIO.read(mainpanelgenbill.class.getResource(path));
            // Resize the image
            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            icon = new ImageIcon(resizedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return icon;
    }
 // Function that takes a JLabel as input and returns a JLabel
    public JLabel manipulateLabel(JLabel label) {
    	label.setFont(new Font("Tahoma", Font.PLAIN, 10));
    	label.setHorizontalAlignment(SwingConstants.RIGHT);
        return label;
    }
    private long manipulateString(String input) {  
     // Convert String to double
			double num = Double.parseDouble(input);

			// Round the double to the nearest whole number
			long output = Math.round(num);

        return output;
    }
 // Function to read the file, update yearlynumber, and save the changes
    public static void updateYearlyNumberValue(String filePath, String newYearlyNumber) throws IOException {
        StringBuilder content = new StringBuilder();
        
        // 1. Read the file and store its content in memory
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        // 2. Use a regular expression to find the INSERT statement and update the yearlynumber value
        String regex = "INSERT INTO\\s+Invoices\\s*\\(yearlynumber\\)\\s*VALUES\\s*\\(\\s*'(.+?)'\\s*\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content.toString());

        // If the yearlynumber value is found, update it with the new value
        if (matcher.find()) {
            // Replace the old yearlynumber value with the new one
            String updatedContent = matcher.replaceFirst("INSERT INTO Invoices (yearlynumber) VALUES ('" + newYearlyNumber + "')");

            // 3. Write the updated content back to the file
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(updatedContent);
            }

            System.out.println("Yearly number updated successfully!");
        } else {
            System.out.println("No matching yearlynumber found to update.");
        }
    }
}
