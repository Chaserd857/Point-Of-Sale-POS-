
package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.table.*;


import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
@SuppressWarnings("all")
public class KOT_BILL extends JFrame implements Printable {
    private JPanel contentPanel;
	private JTable itemsTable;
	private DefaultTableModel Model;
	private JLabel BillNo_1_3;
	private JLabel BillNo_2;
	private DefaultTableModel tableModel;
	private String label;
	

    public KOT_BILL(DefaultTableModel model,String dat) {
    	this.tableModel = model;
    	this.label=dat;
    	createGUI();
    }
    private void createGUI() {
        setTitle("Blank Invoice - 80mm x 297mm");
        
        // Converting millimeters to pixels assuming 96 DPI
        int widthPx = (int) ((60 / 25.6) * 96);
        int heightPx = (int) ((90 / 25.6) * 96);

        setSize(270, 183);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
//        setIconImage(Toolkit.getDefaultToolkit().getImage(KOT_BILL.class.getResource("/images/LOGO-removebg-preview.png")));
      
        
        // Creating and configuring the content panel
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        // Add components to content panel
        JLabel titleLabel = new JLabel("FOOD   CHAIN");
        titleLabel.setFont(new Font("Arial Narrow", Font.BOLD, 10));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align the title
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

     

        JLabel invoiceLabel = new JLabel("Sub-total :  Rs.\"");
        invoiceLabel.setFont(new Font("Dialog", Font.PLAIN, 9));
        invoiceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        invoiceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JSeparator LineLabel = new JSeparator();
        LineLabel.setBackground(Color.BLACK);
        LineLabel.setForeground(Color.BLACK);
        JSeparator LineLabel1 = new JSeparator();
        LineLabel1.setBackground(Color.BLACK);
        LineLabel1.setForeground(Color.BLACK);
        JSeparator LineLabel12 = new JSeparator();
        LineLabel12.setBackground(Color.BLACK);
        LineLabel12.setForeground(Color.BLACK);
        JSeparator LineLabel13 = new JSeparator();
        LineLabel13.setBackground(Color.BLACK);
        LineLabel13.setForeground(Color.BLACK);
        
        JLabel BillNo = new JLabel("KOT No:");
        BillNo.setFont(new Font("Tahoma", Font.PLAIN, 9));
        BillNo.setAlignmentX(Component.CENTER_ALIGNMENT);
        BillNo.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel BillDate = new JLabel("Date:");
        BillDate.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BillDate.setAlignmentX(Component.CENTER_ALIGNMENT);
        BillDate.setHorizontalAlignment(SwingConstants.CENTER);
        
       
        // Add the content panel to the center of the BorderLayout
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        
        BillNo_2 = new JLabel("");
        BillNo_2.setHorizontalAlignment(SwingConstants.CENTER);
        BillNo_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BillNo_2.setAlignmentX(0.5f);
        
        JLabel BillNo_1 = new JLabel(label);
        BillNo_1.setHorizontalAlignment(SwingConstants.LEFT);
        BillNo_1.setFont(new Font("Tahoma", Font.BOLD, 9));
        BillNo_1.setAlignmentX(0.5f);
        
       
        
        JLabel BillNo_1_1 = new JLabel("Eat-In");
        BillNo_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        BillNo_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 10));
        BillNo_1_1.setAlignmentX(0.5f);
        
        JLabel BillNo_1_2 = new JLabel("Time :");
        BillNo_1_2.setHorizontalAlignment(SwingConstants.LEFT);
        BillNo_1_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BillNo_1_2.setAlignmentX(0.5f);
        
        BillNo_1_3 = new JLabel("");
        BillNo_1_3.setHorizontalAlignment(SwingConstants.LEFT);
        BillNo_1_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BillNo_1_3.setAlignmentX(0.5f);
        
     // Get the current date and time
        LocalDateTime current = LocalDateTime.now();

        // Define the desired format
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Format the current date and time
        String formatted = current.format(formatter2);
     // Define the desired format
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("hh:mm");

        // Format the current date and time
        String formatted1 = current.format(formatter1);
        
        BillNo_2.setText(formatted);
        BillNo_1_3.setText(formatted1);
        
        JLabel LineLabel2 = new JLabel("_________________________________________");
        LineLabel2.setFont(new Font("Tahoma", Font.BOLD, 8));
        LineLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        LineLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel LineLabel3 = new JLabel("_________________________________________");
        LineLabel3.setFont(new Font("Tahoma", Font.BOLD, 8));
        LineLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        LineLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel HEADING = new JLabel("1");
//      HEADING.setForeground();
      HEADING.setFont(new Font("Segoe UI", Font.PLAIN, 8));
      HEADING.setAlignmentX(Component.CENTER_ALIGNMENT);
      HEADING.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Table Data and Column Names
        String[] columnNames = {" No.", "Item Description", "    Qty."};
//        Object[][] data = {
//            {"Burger", "2", "5.50"},
//            {"Fries", "1", "2.00"},
//            {"Cola", "3", "1.50"}
//        };

        // Initialize the table
        Model = new DefaultTableModel(columnNames,0);
        itemsTable = new JTable(Model);
        itemsTable.setBackground(Color.WHITE);
        itemsTable.setFont(new Font("Tahoma", Font.PLAIN, 8));
        itemsTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        itemsTable.getColumnModel().getColumn(1).setPreferredWidth(400);
        itemsTable.getColumnModel().getColumn(2).setPreferredWidth(60);
        itemsTable.setShowHorizontalLines(false);
        itemsTable.setShowVerticalLines(false);
        itemsTable.getTableHeader().setVisible(false); // Hides the table header
        itemsTable.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 0)); // Adjust the size to ensure it doesn't take space
     // Set the font for table headers
        JTableHeader tableHeader = itemsTable.getTableHeader();
        tableHeader.setFont(new Font("Tahoma", Font.BOLD, 8));  // Set the font size for headers
        JScrollPane scrollPane = new JScrollPane(itemsTable);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        
        DefaultTableCellRenderer CENTERRenderer = new DefaultTableCellRenderer();
        CENTERRenderer.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer RIGHTRenderer = new DefaultTableCellRenderer();
        RIGHTRenderer.setHorizontalAlignment(JLabel.CENTER);
        itemsTable.getColumnModel().getColumn(0).setCellRenderer(CENTERRenderer);
        itemsTable.getColumnModel().getColumn(2).setCellRenderer(RIGHTRenderer);
        
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setForeground(Color.BLUE);
        scrollPane.setBorder(new LineBorder(new Color(255, 255, 255)));
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
        
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
        	gl_contentPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPanel.createSequentialGroup()
        					.addGap(78)
        					.addComponent(titleLabel))
        				.addComponent(LineLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_contentPanel.createSequentialGroup()
        					.addGap(120)
        					.addComponent(BillNo_1_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        					.addGap(2)
        					.addComponent(BillNo_1_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        				.addComponent(LineLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(LineLabel12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_contentPanel.createSequentialGroup()
        					.addGap(10)
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
        				.addComponent(LineLabel13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(HEADING, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_contentPanel.createSequentialGroup()
        					.addGap(15)
        					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
        						.addComponent(invoiceLabel, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
        						.addGroup(gl_contentPanel.createSequentialGroup()
        							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
        								.addGroup(gl_contentPanel.createSequentialGroup()
        									.addComponent(BillNo)
        									.addComponent(BillNo_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
        								.addGroup(gl_contentPanel.createSequentialGroup()
        									.addComponent(BillDate)
        									.addGap(15)
        									.addComponent(BillNo_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
        							.addGap(30)
        							.addComponent(BillNo_1_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))))
        			.addContainerGap(25, Short.MAX_VALUE))
        );
        gl_contentPanel.setVerticalGroup(
        	gl_contentPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addComponent(titleLabel)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPanel.createSequentialGroup()
        					.addGap(23)
        					.addComponent(LineLabel, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_contentPanel.createSequentialGroup()
        					.addGap(10)
        					.addComponent(invoiceLabel)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
        				.addComponent(BillNo)
        				.addComponent(BillNo_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        				.addComponent(BillNo_1_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(BillDate)
        				.addComponent(BillNo_2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        				.addComponent(BillNo_1_2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        				.addComponent(BillNo_1_3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        				.addGap(15))
        			.addComponent(LineLabel1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
        			.addGap(1)
        			.addComponent(HEADING)
        			.addGap(1)
        			.addComponent(LineLabel12, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
        			.addComponent(LineLabel13, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
        );
        contentPanel.setLayout(gl_contentPanel);

        // Making the frame visible
//        setVisible(true);
//        copyDataWithColumnMapping(tableModel,Model);
        
        // Call printContent automatically
        startTimer();
        copyDataWithColumnMapping(tableModel,Model);
     // Ensure the content panel is validated and repainted
        contentPanel.validate();
        contentPanel.repaint();
//        printContent();
        dispose();
        demo counter = new demo(Model,label);
        
        }

//    private void printContent() {	
//        PrinterJob job = PrinterJob.getPrinterJob();
//        job.setPrintable(this);
//
//        PageFormat pf = job.defaultPage();
//        Paper paper = new Paper();
//        paper.setSize((80 / 25.4) * 72, (297 / 25.4) * 72);  // converting mm to points
//        paper.setImageableArea(0, 0, paper.getWidth(), paper.getHeight());
//        pf.setPaper(paper);
//        job.setPrintable(this, pf);
//
//        if (job.printDialog()) {
//            try {
//                job.print();
//            } catch (PrinterException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public int print(Graphics g, PageFormat pf, int pageIndex) {
//        if (pageIndex != 0) {
//            return NO_SUCH_PAGE;
//        }
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.translate(pf.getImageableX(), pf.getImageableY());
//        contentPanel.printAll(g);
//        return PAGE_EXISTS;
//    }
    
    private void printContent() {
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
        paper.setImageableArea(0, 0, width, height);
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
//    public void copyDataWithColumnMapping(DefaultTableModel sourceModel, DefaultTableModel destinationModel) {
//    	int autoIncrement = 1;  // Start the auto-incrementing number
//        // Search for the item description in the table model
//        for (int row = 0; row < sourceModel.getRowCount(); row++) {
//            String description = (String) sourceModel.getValueAt(row, 1); // Assuming description is in column 1
//            Object Price = sourceModel.getValueAt(row, 4);
//            Object Qty = sourceModel.getValueAt(row, 3);
//            Object Amt = sourceModel.getValueAt(row, 5);
////            System.out.print("  "+Price+" ");
//         // Create a new row for the destination model, adding the auto-increment number as the first element
//            Object[] newRow = new Object[5];  // Adjust the size based on your destination model's column count
//            newRow[0] = autoIncrement++;  // Auto-increment ID
//            newRow[1] = description;
//            newRow[2] = Price;
//            newRow[3] = Qty;
//            newRow[4] = Amt;
//            destinationModel.addRow(newRow);
//            }
//        
//    }
    private void copyDataWithColumnMapping(DefaultTableModel sourceModel, DefaultTableModel destinationModel) {
        int autoIncrement = 1;  // Start the auto-incrementing number
        // Search for the item description in the table model
        for (int row = 0; row < sourceModel.getRowCount(); row++) {
            String description = (String) sourceModel.getValueAt(row, 1); // Assuming description is in column 1
            Object Qty = sourceModel.getValueAt(row, 3);
            

            // Create a new row for the destination model, adding the auto-increment number as the first element
            Object[] newRow = new Object[3];  // Adjust the size based on your destination model's column count
            newRow[0] = autoIncrement++;  // Auto-increment ID
            newRow[1] = description;
            newRow[2] = Qty;
            
            destinationModel.addRow(newRow);
        }
    }

//    @Override
//    public int print(Graphics g, PageFormat pf, int pageIndex) {
//        if (pageIndex > 0) {
//            return NO_SUCH_PAGE;
//        }
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.translate(pf.getImageableX(), pf.getImageableY());
//        contentPanel.printAll(g);
//        return PAGE_EXISTS;
//    }

//    public static void main(String[] args) {
//        new KOT_BILL(); // Create an instance of the frame
//    }
}
