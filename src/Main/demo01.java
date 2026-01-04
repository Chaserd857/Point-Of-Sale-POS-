
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
import javax.swing.border.LineBorder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//@SuppressWarnings("all")
public class demo01 extends JFrame implements Printable {
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
	
	private GroupLayout gl_contentPanel;
    private GroupLayout.ParallelGroup hGroup;
    private GroupLayout.SequentialGroup vGroup;
	
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

	

    
    public demo01(DefaultTableModel tableModel2, String label1) {
    	this.Model=tableModel2;
    	
    	this.label=label1;
        createGUI();
    }

    private void createGUI() {
        setTitle("");
//        setIconImage(Toolkit.getDefaultToolkit().getImage(demo01.class.getResource("/images/LOGO-removebg-preview.png")));
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

        

        

        BillNo_2 = new JLabel("");
        BillNo_2.setHorizontalAlignment(SwingConstants.LEFT);
        BillNo_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
        BillNo_2.setAlignmentX(0.5f);

        JLabel BillNo_1_2 = new JLabel("Time:");
        BillNo_1_2.setHorizontalAlignment(SwingConstants.LEFT);
        BillNo_1_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BillNo_1_2.setAlignmentX(0.5f);
        
        BillNo_1_3 = new JLabel("");
        BillNo_1_3.setHorizontalAlignment(SwingConstants.LEFT);
        BillNo_1_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
        BillNo_1_3.setAlignmentX(0.5f);

        JLabel ColumnLabel = new JLabel("No   Item Description                                                   Qty");
        ColumnLabel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 8));
        ColumnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        String[] columnNames = {"Item Description", "Quantity", "    Amount"};
        
       
        
        JLabel separator0 = new JLabel("-------------------------------------------------");
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

        JLabel BillNo = new JLabel("KOT -");
        BillNo.setFont(new Font("Tahoma", Font.PLAIN, 10));
        BillNo.setAlignmentX(Component.CENTER_ALIGNMENT);
        BillNo.setHorizontalAlignment(SwingConstants.LEFT);
        
        JLabel BillNo_1 = new JLabel(label);
        BillNo_1.setHorizontalAlignment(SwingConstants.LEFT);
        BillNo_1.setFont(new Font("Arial", Font.PLAIN, 10));
        BillNo_1.setAlignmentX(0.5f);
        
        JLabel PickupLabel = new JLabel("Pick Up");
        PickupLabel.setHorizontalAlignment(SwingConstants.LEFT);
        PickupLabel.setFont(new Font("Nirmala UI", Font.BOLD | Font.BOLD, 10));
        PickupLabel.setAlignmentX(0.5f);
        
        JLabel HEADING = new JLabel("Item");
//        HEADING.setBorder(new LineBorder(new Color(128,128,255)));
        HEADING.setVerticalAlignment(SwingConstants.CENTER); // Center the text vertically
        HEADING.setFont(new Font("Tahoma", Font.PLAIN, 10));
        JLabel HEADING1 = new JLabel("Qty.");
        HEADING1.setVerticalAlignment(SwingConstants.CENTER); // Center the text vertically
        HEADING1.setFont(new Font("Tahoma", Font.PLAIN, 10));
//        HEADING1.setBorder(new LineBorder(new Color(128,128,255)));
        JLabel HEADING2 = new JLabel("<html>Special<br>Note</html>");
        HEADING2.setFont(new Font("Tahoma", Font.PLAIN, 10));
        
        JPanel specialnotePanel = new JPanel(new BorderLayout());
        specialnotePanel.setBackground(Color.WHITE);
        specialnotePanel.add(HEADING2, BorderLayout.NORTH);
        specialnotePanel.setPreferredSize(new Dimension(30, 30)); // Set the preferred size of the panel
//        specialnotePanel.setBorder(new LineBorder(new Color(128,128,255)));

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
        
        gl_contentPanel = new GroupLayout(contentPanel);
        hGroup = gl_contentPanel.createParallelGroup(Alignment.LEADING);
        vGroup = gl_contentPanel.createSequentialGroup();

       hGroup.addGroup(gl_contentPanel.createSequentialGroup()
               .addGap(77)
               .addComponent(BillNo_2)
               .addGap(3)
               .addComponent(BillNo_1_3));
       hGroup.addGroup(gl_contentPanel.createSequentialGroup()
               .addGap(95)
               .addComponent(BillNo)
               .addGap(3)
               .addComponent(BillNo_1));
       hGroup.addGroup(gl_contentPanel.createSequentialGroup()
       .addGap(95)
       .addComponent(PickupLabel));
       hGroup.addGroup(gl_contentPanel.createSequentialGroup()
    	       .addGap(20)
    	       .addComponent(separator0));
       hGroup.addGroup(gl_contentPanel.createSequentialGroup()
               .addGap(20)
               .addComponent(HEADING)
               .addGap(83)
               .addComponent(specialnotePanel,GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
               .addGap(25)
               .addComponent(HEADING1)
               );
       
       vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
               .addComponent(BillNo_2)
               .addComponent(BillNo_1_3));
       vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
               .addComponent(BillNo)
               .addComponent(BillNo_1))
       .addComponent(PickupLabel)
       .addComponent(separator0,GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
       .addGap(3)
       .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
       		.addComponent(HEADING, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
       		.addComponent(specialnotePanel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
       		.addComponent(HEADING1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE));
       
        if (!isTableEmpty(Model)) {
        	int row=Model.getRowCount();
        	
        		createRows(row,Model);
        	
        	
        	
        }
        
	
        
        gl_contentPanel.setHorizontalGroup(hGroup);
        gl_contentPanel.setVerticalGroup(vGroup);

        contentPanel.setLayout(gl_contentPanel);
        pack();
//        setVisible(true);
        
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
        Date now = new Date();
        BillNo_2.setText(dateFormatter.format(now)+" ");
        BillNo_1_3.setText(timeFormatter.format(now)+" ");
        contentPanel.validate();
        contentPanel.repaint();
        printContent();
    }
    public void createRows(int rowCount, DefaultTableModel model) {
        int counter = 1;

        for (int row = 0; row < rowCount; row++) {
        	String item = model.getValueAt(row, 1).toString();
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
            
            JLabel lblIndex = new JLabel();
            lblIndex.setFont(new Font("Segoe UI", Font.BOLD, 10));
            lblIndex.setHorizontalAlignment(SwingConstants.LEFT);
            setLabelIfNotEmpty(lblIndex, "--");

            JLabel lblName = new JLabel();
            lblName.setFont(new Font("Dialog", Font.BOLD, 11));
            lblName.setHorizontalAlignment(SwingConstants.LEFT);
            setLabelIfNotEmpty(lblName, item);
//            lblName.setBorder(new LineBorder(new Color(128,128,255)));

            JLabel lblValue = new JLabel();
            lblValue.setFont(new Font("Tahoma", Font.PLAIN, 10));
            lblValue.setHorizontalAlignment(SwingConstants.RIGHT);
//            lblValue.setBorder(new LineBorder(new Color(128,128,255)));
            setLabelIfNotEmpty(lblValue, model.getValueAt(row, 2).toString());

            // Add to the horizontal group
            hGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                    .addGroup(gl_contentPanel.createSequentialGroup()
                            .addGap(20)
                            .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addGap(13)
                            .addComponent(lblIndex,  GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                            .addGap(37)
                            .addComponent(lblValue, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)));

            // Add to the vertical group
            vGroup.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
            		.addComponent(lblName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIndex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));
        }
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
//class CustomFontRenderer extends DefaultTableCellRenderer {
//    @Override
//    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//
//
//        // Set custom font for this column
//        cellComponent.setFont(new Font("Segoe UI", Font.PLAIN, 9));
//        ((JLabel) cellComponent).setHorizontalAlignment(SwingConstants.RIGHT);
//
//        return cellComponent;
//    }
//}
//class CustomFontRenderer1 extends DefaultTableCellRenderer {
//    @Override
//    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//
//      
//
//        // Set custom font for this column
//        cellComponent.setFont(new Font("Segoe UI", Font.PLAIN, 10));
//        ((JLabel) cellComponent).setHorizontalAlignment(SwingConstants.RIGHT);
//
//        return cellComponent;
//    }
//}