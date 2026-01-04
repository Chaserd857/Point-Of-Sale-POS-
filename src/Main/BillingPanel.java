package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BillingPanel extends JPanel {

    private JPanel panel,mainPanel,splitpane,generatebill,RoundOff,AppliedTaxes,ContainerCharge,supportpanel,radiopanel,mobilepanel,addresspanel,itembar,itemheader,subtotalpanel,appliedDiscounts,totalpanel,DeliveryCharge;
    private JScrollPane scrollPane1;
    private static String selecteditem,selectedDiscountType;
	private static String selectedPrice = "";
    private ArrayList<String> itemNames = new ArrayList<>();
    private ArrayList<Double> itemPrices = new ArrayList<>();
    private ArrayList<Integer> itemQuantities = new ArrayList<>();
    private GroupLayout.ParallelGroup hGrouppanel;
    private GroupLayout.SequentialGroup vGrouppanel;
    private GroupLayout.ParallelGroup hGrouppanel_itemheader;
    private GroupLayout.SequentialGroup vGrouppanel_itemheader;
    private GroupLayout.ParallelGroup hGrouppanel_itembar;
    private GroupLayout.SequentialGroup vGrouppanel_itembar;
    private GroupLayout.ParallelGroup hGrouppanel_BelowRight;
    private GroupLayout.SequentialGroup vGrouppanel_BelowRight;
    private GroupLayout.ParallelGroup hGrouppanel_generatebill;
    private GroupLayout.SequentialGroup vGrouppanel_generatebill;
    private GroupLayout.ParallelGroup hGrouppanel_supportpanel;
    private GroupLayout.SequentialGroup vGrouppanel_supportpanel;
    private GroupLayout.ParallelGroup hGrouppanel_radiopanel;
    private GroupLayout.SequentialGroup vGrouppanel_radiopanel;
    private GroupLayout.ParallelGroup hGrouppanel_mobilepanel;
    private GroupLayout.SequentialGroup vGrouppanel_mobilepanel;
    private GroupLayout.ParallelGroup hGrouppanel_addresspanel ;
    private GroupLayout.SequentialGroup vGrouppanel_addresspanel ;
    private GroupLayout.ParallelGroup hGrouppanel_subtotalpanel ;
    private GroupLayout.SequentialGroup vGrouppanel_subtotalpanel ;
    private GroupLayout.ParallelGroup hGrouppanel_appliedDiscounts;
    private GroupLayout.SequentialGroup vGrouppanel_appliedDiscounts;
    private GroupLayout.ParallelGroup hGrouppanel_totalpanel;
    private GroupLayout.SequentialGroup vGrouppanel_totalpanel;
    private GroupLayout.ParallelGroup hGrouppanel_DeliveryCharge;
    private GroupLayout.SequentialGroup vGrouppanel_DeliveryCharge;
    private GroupLayout.ParallelGroup hGrouppanel_ContainerCharge;
    private GroupLayout.SequentialGroup vGrouppanel_ContainerCharge;
    private GroupLayout.ParallelGroup hGrouppanel_AppliedTaxes;
    private GroupLayout.SequentialGroup vGrouppanel_AppliedTaxes;
    private GroupLayout.ParallelGroup hGrouppanel_RoundOff;
    private GroupLayout.SequentialGroup vGrouppanel_RoundOff;
    private GroupLayout.ParallelGroup hGrouppanel_splitpane;
    private GroupLayout.SequentialGroup vGrouppanel_splitpane;
    private GroupLayout gl_panel_itemheader,gl_panel_RoundOff,gl_panel,gl_panel_splitpane,gl_panel_subtotalpanel,gl_panel_AppliedTaxes,gl_panel_ContainerCharge,gl_panel_BelowRight,gl_panel_DeliveryCharge,gl_panel_totalpanel,gl_panel_generate_bill,gl_panel_supportpanel,gl_panel_itembar,gl_panel_radiopanel,gl_panel_addresspanel,gl_panel_mobilepanel,gl_panel_appliedDiscounts;
    private JSeparator separator;
	private JPanel customerpaid;
	private GroupLayout gl_panel_customerpaid;
	private GroupLayout.SequentialGroup vGrouppanel_customerpaid;
	private GroupLayout.ParallelGroup hGrouppanel_customerpaid;
	private JPanel returncustomer;
	private GroupLayout gl_panel_returncustomer;
	private GroupLayout.ParallelGroup hGrouppanel_returncustomer;
	private GroupLayout.SequentialGroup vGrouppanel_returncustomer;
	private JPanel tip;
	private GroupLayout gl_panel_tip;
	private GroupLayout.ParallelGroup hGrouppanel_tip;
	private GroupLayout.SequentialGroup vGrouppanel_tip;
	private HintTextField itemname;
	private ArrayList<String> itemList = new ArrayList<>();
	private ArrayList<String> priceList = new ArrayList<>();
	private static final String[][] FRUITS = readSQLFile("C:\\POS\\Menu_Data\\menu_data.sql");
	private static final String[][] FRUITSNORMAL = readSQLFile("C:\\POS\\Menu_Data\\menu_data_withoutpanel.sql");
    private static final String[][] FRUITSDOSA = readSQLFile("C:\\POS\\Menu_Data\\menu_data_withpanel.sql");
    private JPopupMenu popupMenu;
	private JPanel itemListPanel;
	private GroupLayout gl_itemListPanel;
	private GroupLayout.ParallelGroup hGrouppanel_itemListPanel;
	private GroupLayout.SequentialGroup vGrouppanel_itemListPanel;
	private JLabel subtotalheadervalue_subtotalpanel;
	private JLabel TotalValue;
	private JLabel Roundoffevalue;
	private JLabel taxvalue;
	private JLabel Totalheading;
	private JLabel totslqtyvalue_subtotalpanel;
    private static int currentIndex = -1;  // To track the currently selected index
    private static RoundLabel pricefield;
	private RoundLabel amountfield;
    private static String Sselectedbutton;
    private static Double cheese = 33.33;
	private static Double butter =23.81;
	private static Double ghee = 42.75;
	private ArrayList<String> itemListpanel = new ArrayList<>();
	private ArrayList<String> itemListnopanel = new ArrayList<>();
	private JPanel discPanel;
	private GroupLayout gl_discPanel;
	private GroupLayout.SequentialGroup vGrouppanel_discPanel;
	private GroupLayout.ParallelGroup hGrouppanel_discPanel;
	private HintTextField discvalue;
	private JLabel applied_discval;
	private boolean discclick=false;
	private boolean discclicktax=false;
	private JPanel SGST_CGST_Panel;
	private GroupLayout gl_SGST_CGST_Panel;
	private GroupLayout.ParallelGroup hGrouppanel_SGST_CGST_Panel;
	private GroupLayout.SequentialGroup vGrouppanel_SGST_CGST_Panel;
	private RoundLabel SGSval;
	private RoundLabel CGSval;
	private JMenuItem menuItem;
	private JTable table2;
	private DefaultTableModel tableModel2;
	
    public BillingPanel() {
    	mainPanel = new JPanel();
    	
    	mainPanel.setLayout(new BorderLayout());
    	 GroupLayout layout = new GroupLayout(mainPanel);
         mainPanel.setLayout(layout);
         for(int i=0;i<FRUITSDOSA.length;i++)
        	 itemListpanel.add(FRUITSDOSA[i][0].toString());
         for(int i=0;i<FRUITSNORMAL.length;i++)
        	 itemListnopanel.add(FRUITSNORMAL[i][0].toString());
         
         for(int i=0;i<FRUITS.length;i++) {
        	 itemList.add(FRUITS[i][0].toString());
        	 priceList.add(FRUITS[i][2].toString());
         }
         
         panel = new JPanel();
         
         panel.setBackground(Color.WHITE);
         panel.setPreferredSize(new Dimension(1125, 1250)); // Set desired size
         panel.setLayout(new GroupLayout(panel));

        JPanel newPanelBelowRight = new JPanel();
        newPanelBelowRight.setBackground(new Color(221,221,221)); // Set a different color for distinction
        gl_panel_BelowRight = new GroupLayout(newPanelBelowRight);
        newPanelBelowRight.setBorder(null);
        newPanelBelowRight.setLayout(gl_panel_BelowRight);
        hGrouppanel_BelowRight = gl_panel_BelowRight.createParallelGroup(Alignment.LEADING);
        vGrouppanel_BelowRight = gl_panel_BelowRight.createSequentialGroup();
        
        separator = new JSeparator(); // Create a separator
		separator.setPreferredSize(new Dimension(0, 1)); // Set the height of the separator
		separator.setBackground(Color.GRAY);
		separator.setForeground(Color.GRAY);
        
		bottomrightpanel();
		
        gl_panel = (GroupLayout) panel.getLayout();
        hGrouppanel = gl_panel.createParallelGroup(Alignment.LEADING);
        vGrouppanel = gl_panel.createSequentialGroup();

        generatebill = new JPanel();
        generatebill.setBackground(Color.WHITE);
        gl_panel_generate_bill = new GroupLayout(generatebill);
        generatebill.setLayout(gl_panel_generate_bill);
        hGrouppanel_generatebill = gl_panel_generate_bill.createParallelGroup(Alignment.LEADING);
        vGrouppanel_generatebill = gl_panel_generate_bill.createSequentialGroup();

        supportpanel = new JPanel();
        supportpanel.setBackground(new Color(246,218,222));
        gl_panel_supportpanel = new GroupLayout(supportpanel);
        supportpanel.setLayout(gl_panel_supportpanel);
        hGrouppanel_supportpanel = gl_panel_supportpanel.createParallelGroup(Alignment.LEADING);
        vGrouppanel_supportpanel = gl_panel_supportpanel.createSequentialGroup();
        
        radiopanel = new JPanel();
        radiopanel.setBackground(new Color(241,241,241));
        radiopanel.setPreferredSize(new Dimension(1125, 200)); // Set desired size
        gl_panel_radiopanel = new GroupLayout(radiopanel);
        radiopanel.setLayout(gl_panel_radiopanel);
        hGrouppanel_radiopanel = gl_panel_radiopanel.createParallelGroup(Alignment.LEADING);
        vGrouppanel_radiopanel = gl_panel_radiopanel.createSequentialGroup();

        mobilepanel = new JPanel();
        mobilepanel.setBackground(new Color(241,241,241));
        mobilepanel.setPreferredSize(new Dimension(1125, 200)); // Set desired size
        gl_panel_mobilepanel = new GroupLayout(mobilepanel);
        mobilepanel.setLayout(gl_panel_mobilepanel);
        hGrouppanel_mobilepanel = gl_panel_mobilepanel.createParallelGroup(Alignment.LEADING);
        vGrouppanel_mobilepanel = gl_panel_mobilepanel.createSequentialGroup();
        
        addresspanel = new JPanel();
        addresspanel.setBackground(new Color(241,241,241));
        addresspanel.setPreferredSize(new Dimension(1125, 200)); // Set desired size
        gl_panel_addresspanel = new GroupLayout(addresspanel);
        addresspanel.setLayout(gl_panel_addresspanel);
        hGrouppanel_addresspanel = gl_panel_addresspanel.createParallelGroup(Alignment.LEADING);
        vGrouppanel_addresspanel = gl_panel_addresspanel.createSequentialGroup();

        itembar = new JPanel();
        itembar.setBackground(new Color(241,241,241));
        itembar.setPreferredSize(new Dimension(1125, 200)); // Set desired size
        gl_panel_itembar = new GroupLayout(itembar);
        itembar.setLayout(gl_panel_itembar);
        hGrouppanel_itembar = gl_panel_itembar.createParallelGroup(Alignment.LEADING);
        vGrouppanel_itembar = gl_panel_itembar.createSequentialGroup();
        
        itemheader = new JPanel();
        itemheader.setPreferredSize(new Dimension(1125, 200)); // Set desired size
        gl_panel_itemheader = new GroupLayout(itemheader);
        itemheader.setLayout(gl_panel_itemheader);
        hGrouppanel_itemheader = gl_panel_itemheader.createParallelGroup(Alignment.LEADING);
        vGrouppanel_itemheader = gl_panel_itemheader.createSequentialGroup();
        
        subtotalpanel = new JPanel();
        subtotalpanel.setBorder(BorderFactory.createLineBorder(new Color(204,204,204), 2)); 
        subtotalpanel.setBackground(new Color(241,241,241));
        subtotalpanel.setPreferredSize(new Dimension(1125, 200)); // Set desired size
        gl_panel_subtotalpanel = new GroupLayout(subtotalpanel);
        subtotalpanel.setLayout(gl_panel_subtotalpanel);
        hGrouppanel_subtotalpanel = gl_panel_subtotalpanel.createParallelGroup(Alignment.LEADING);
        vGrouppanel_subtotalpanel = gl_panel_subtotalpanel.createSequentialGroup();
        
        appliedDiscounts = new JPanel();
        appliedDiscounts.setBackground(new Color(242,247,248));
        appliedDiscounts.setPreferredSize(new Dimension(1125, 200)); // Set desired size
        gl_panel_appliedDiscounts = new GroupLayout(appliedDiscounts);
//        appliedDiscounts.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        appliedDiscounts.setLayout(gl_panel_appliedDiscounts);
        hGrouppanel_appliedDiscounts = gl_panel_appliedDiscounts.createParallelGroup(Alignment.LEADING);
        vGrouppanel_appliedDiscounts = gl_panel_appliedDiscounts.createSequentialGroup();
        
        totalpanel = new JPanel();
        totalpanel.setBorder(BorderFactory.createLineBorder(new Color(203,204,205), 2)); 
        totalpanel.setBackground(new Color(241,241,241));
        totalpanel.setPreferredSize(new Dimension(1125, 200)); // Set desired size
        gl_panel_totalpanel = new GroupLayout(totalpanel);
        totalpanel.setLayout(gl_panel_totalpanel);
        hGrouppanel_totalpanel = gl_panel_totalpanel.createParallelGroup(Alignment.LEADING);
        vGrouppanel_totalpanel = gl_panel_totalpanel.createSequentialGroup();
        
        DeliveryCharge = new JPanel();
        DeliveryCharge.setBackground(new Color(241,241,241));
//        DeliveryCharge.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); 
        DeliveryCharge.setPreferredSize(new Dimension(1125, 200)); // Set desired size
        gl_panel_DeliveryCharge = new GroupLayout(DeliveryCharge);
        DeliveryCharge.setLayout(gl_panel_DeliveryCharge);
        hGrouppanel_DeliveryCharge = gl_panel_DeliveryCharge.createParallelGroup(Alignment.LEADING);
        vGrouppanel_DeliveryCharge = gl_panel_DeliveryCharge.createSequentialGroup();

        ContainerCharge = new JPanel();
        ContainerCharge.setBackground(new Color(241,241,241));
        ContainerCharge.setBorder(BorderFactory.createLineBorder(new Color(205,205,205), 2)); 
        ContainerCharge.setPreferredSize(new Dimension(1125, 200)); // Set desired size
        gl_panel_ContainerCharge = new GroupLayout(ContainerCharge);
        ContainerCharge.setLayout(gl_panel_ContainerCharge);
        hGrouppanel_ContainerCharge = gl_panel_ContainerCharge.createParallelGroup(Alignment.LEADING);
        vGrouppanel_ContainerCharge = gl_panel_ContainerCharge.createSequentialGroup();

        AppliedTaxes = new JPanel();
        AppliedTaxes.setBackground(new Color(242,247,248,255));
        AppliedTaxes.setPreferredSize(new Dimension(1125, 200)); // Set desired size
        gl_panel_AppliedTaxes = new GroupLayout(AppliedTaxes);
        AppliedTaxes.setVisible(false);
        AppliedTaxes.setBorder(new LineBorder(new Color(205,205,205,255), 1, true));
        AppliedTaxes.setLayout(gl_panel_AppliedTaxes);
        hGrouppanel_AppliedTaxes = gl_panel_AppliedTaxes.createParallelGroup(Alignment.LEADING);
        vGrouppanel_AppliedTaxes = gl_panel_AppliedTaxes.createSequentialGroup();
        
        RoundOff = new JPanel();
        RoundOff.setBackground(new Color(241,241,241,255));
        RoundOff.setPreferredSize(new Dimension(1125, 200)); // Set desired size
        gl_panel_RoundOff = new GroupLayout(RoundOff);
        RoundOff.setLayout(gl_panel_RoundOff);
        hGrouppanel_RoundOff = gl_panel_RoundOff.createParallelGroup(Alignment.LEADING);
        vGrouppanel_RoundOff = gl_panel_RoundOff.createSequentialGroup();
        
        splitpane = new JPanel();
        splitpane.setBackground(new Color(228,228,228,255));

        splitpane.setBorder(new LineBorder(new Color(205,205,205,255), 1, true));
        splitpane.setPreferredSize(new Dimension(1125, 200)); // Set desired size
        gl_panel_splitpane = new GroupLayout(splitpane);
        splitpane.setLayout(gl_panel_splitpane);
        hGrouppanel_splitpane = gl_panel_splitpane.createParallelGroup(Alignment.LEADING);
        vGrouppanel_splitpane = gl_panel_splitpane.createSequentialGroup();

        customerpaid = new JPanel();
        customerpaid.setBackground(new Color(241,241,241,255));
        customerpaid.setPreferredSize(new Dimension(1125, 200)); // Set desired size
        gl_panel_customerpaid = new GroupLayout(customerpaid);
        customerpaid.setBorder(new LineBorder(new Color(205,205,205,255), 1, true));
        customerpaid.setLayout(gl_panel_customerpaid);
        hGrouppanel_customerpaid = gl_panel_customerpaid.createParallelGroup(Alignment.LEADING);
        vGrouppanel_customerpaid = gl_panel_customerpaid.createSequentialGroup();

        returncustomer = new JPanel();
        returncustomer.setBackground(new Color(241,241,241,255));
        returncustomer.setPreferredSize(new Dimension(1125, 200)); // Set desired size
        gl_panel_returncustomer = new GroupLayout(returncustomer);
        returncustomer.setBorder(new LineBorder(new Color(205,205,205,255), 1, true));
        returncustomer.setLayout(gl_panel_returncustomer);
        hGrouppanel_returncustomer = gl_panel_returncustomer.createParallelGroup(Alignment.LEADING);
        vGrouppanel_returncustomer = gl_panel_returncustomer.createSequentialGroup();
        
        tip = new JPanel();
        tip.setBackground(new Color(241,241,241,255));
        tip.setBorder(new LineBorder(new Color(205,205,205,255), 1, true));
        tip.setPreferredSize(new Dimension(1125, 200)); // Set desired size
        gl_panel_tip = new GroupLayout(tip);
        tip.setLayout(gl_panel_tip);
        hGrouppanel_tip = gl_panel_tip.createParallelGroup(Alignment.LEADING);
        vGrouppanel_tip = gl_panel_tip.createSequentialGroup();

        itemListPanel = new JPanel();
        itemListPanel.setBackground(Color.WHITE);
        itemListPanel.setLayout(new GroupLayout(itemListPanel));
        gl_itemListPanel = new GroupLayout(itemListPanel);
        itemListPanel.setLayout(gl_itemListPanel);
        hGrouppanel_itemListPanel = gl_itemListPanel.createParallelGroup(Alignment.LEADING);
        vGrouppanel_itemListPanel = gl_itemListPanel.createSequentialGroup();

        discPanel = new JPanel();
        discPanel.setLayout(new GroupLayout(discPanel));
        gl_discPanel = new GroupLayout(discPanel);
        discPanel.setLayout(gl_discPanel);
        hGrouppanel_discPanel = gl_discPanel.createParallelGroup(Alignment.LEADING);
        vGrouppanel_discPanel = gl_discPanel.createSequentialGroup();
        discPanel.setVisible(false);
        
        
        SGST_CGST_Panel = new JPanel();
        SGST_CGST_Panel.setLayout(new GroupLayout(SGST_CGST_Panel));
        gl_SGST_CGST_Panel = new GroupLayout(SGST_CGST_Panel);
        SGST_CGST_Panel.setLayout(gl_SGST_CGST_Panel);
        SGST_CGST_Panel.setBorder(new LineBorder(Color.GRAY, 1, true));
        hGrouppanel_SGST_CGST_Panel = gl_SGST_CGST_Panel.createParallelGroup(Alignment.LEADING);
        vGrouppanel_SGST_CGST_Panel = gl_SGST_CGST_Panel.createSequentialGroup();
        SGST_CGST_Panel.setVisible(false);
        
        String[] columnNames = {"","Item Desccription", "I.No.", "Qty.", "Rate", "Amount", "Disc", "Net Value"};
        tableModel2 = new DefaultTableModel(columnNames,0);
        table2 = new JTable(tableModel2);
		table2.setBorder(new LineBorder(new Color(0, 0, 0)));
		table2.setBackground(SystemColor.text);
		table2.setRowHeight(20);
		table2.getColumnModel().getColumn(0).setPreferredWidth(10);
		table2.getColumnModel().getColumn(1).setPreferredWidth(300);
		table2.getColumnModel().getColumn(2).setPreferredWidth(40);
		table2.getColumnModel().getColumn(3).setPreferredWidth(80);
		table2.getColumnModel().getColumn(4).setPreferredWidth(80);
		table2.getColumnModel().getColumn(5).setPreferredWidth(100);
		table2.getColumnModel().getColumn(6).setPreferredWidth(70);
		table2.getColumnModel().getColumn(7).setPreferredWidth(100);
        
        
     // Wrap the panel inside a JScrollPane
        scrollPane1 = new JScrollPane(panel);
        scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
     // Remove default arrow key bindings to prevent the scroll pane from moving
        InputMap im = scrollPane1.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "none");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "none");

        
        // Set layout for newpanel and add the scrollPane1
        setLayout(new BorderLayout());
        add(scrollPane1, BorderLayout.CENTER);
        
        generatebillfunction();
        supportcontactfunction();
        radiopanelfunction();
        mobilepanelfunction();
        addresspanelfunction();
        itembar();
        subtotalpanel();
        appliedDiscountspanel();
        
        Dissccomponents();
        totalPanelcomponents();
        DeliveryChargecomponents();
        ContainerChargecomponents();
        AppliedTaxespanel();
        sgstcgstcomponents();
        RoundOffcomponents();
        splitpanecomponents();
        customerpaid();
        returncustomercomponents();
        tipcomponents();
        initializelayouts();
        
       
        System.out.println("Main panel size: " + mainPanel.getSize());
        System.out.println("Scroll pane size: " + scrollPane1.getSize());

       
        System.out.println("Billing panel size: " + getSize());
        
        
        layout.setHorizontalGroup(
        	    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        	        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
        	        .addComponent(newPanelBelowRight, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
        	);

        	layout.setVerticalGroup(
        	    layout.createSequentialGroup()  // Use SequentialGroup to stack components vertically
        	        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 630, GroupLayout.PREFERRED_SIZE)
        	        .addComponent(newPanelBelowRight, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
        	);
        	
        	
        	

    }
    

    public JPanel getPanel() {
        return mainPanel;
    }
    private ImageIcon createResizedIcon(String path, int width, int height) {
        try {
            Image image = ImageIO.read(getClass().getResource(path));
            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
            return null;
        }
    }
    public JScrollPane getScrollPane() {
        return scrollPane1;
    }


private void expandtable() {
	
	JLabel crosslabel = new JLabel("");
	crosslabel.setBackground(new Color(197,31,49));
	crosslabel.setOpaque(true);
	
	JLabel itemName = new JLabel("<html><u> Item</u></html>");
    itemName.setBackground(new Color(197,31,49));
    itemName.setForeground(Color.WHITE);
    itemName.setFont(new Font("Arial", Font.BOLD, 14)); // Default font for unformatted text
    itemName.setOpaque(true);
    
    JLabel checkitemlink = new JLabel("<html><u>Check items</u></html>");
    checkitemlink.setBackground(new Color(197,31,49));
    checkitemlink.setFont(new Font("Arial", Font.BOLD, 14)); // Default font for unformatted text
    checkitemlink.setOpaque(true);
    checkitemlink.setForeground(Color.WHITE);
    
    JLabel specialnotelabel = new JLabel("Special Note");
    specialnotelabel.setBackground(new Color(197,31,49));
    specialnotelabel.setFont(new Font("Arial", Font.BOLD, 14)); // Default font for unformatted text
    specialnotelabel.setOpaque(true);
    specialnotelabel.setForeground(Color.WHITE);
    
    JLabel qtylabel = new JLabel("Qty.");
    qtylabel.setBackground(new Color(197,31,49));
    qtylabel.setFont(new Font("Arial", Font.BOLD, 14)); // Default font for unformatted text
    qtylabel.setOpaque(true);
    qtylabel.setForeground(Color.WHITE);
    
    JLabel pricelabel = new JLabel("Price");
    pricelabel.setBackground(new Color(197,31,49));
    pricelabel.setFont(new Font("Arial", Font.BOLD, 14)); // Default font for unformatted text
    pricelabel.setOpaque(true);
    pricelabel.setForeground(Color.WHITE);
    
    JLabel amountlabel = new JLabel("Amount");
    amountlabel.setBackground(new Color(197,31,49));
    amountlabel.setFont(new Font("Arial", Font.BOLD, 14)); // Default font for unformatted text
    amountlabel.setOpaque(true);
    amountlabel.setForeground(Color.WHITE);
    
    
    hGrouppanel_itemheader.addGroup(gl_panel_itemheader.createSequentialGroup()
            .addGap(0)
            .addComponent(crosslabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
            .addComponent(itemName, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
          
            .addComponent(checkitemlink, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
            
            .addComponent(specialnotelabel, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
            .addComponent(qtylabel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
            .addComponent(pricelabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
            .addComponent(amountlabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
            );
    
    vGrouppanel_itemheader.addGap(0)
    	.addGroup(gl_panel_itemheader.createParallelGroup(Alignment.LEADING)
    			.addComponent(crosslabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
    			.addComponent(itemName, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(checkitemlink, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(specialnotelabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(qtylabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(pricelabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(amountlabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
            
           );
    
    gl_panel_itemheader.setHorizontalGroup(hGrouppanel_itemheader);
    gl_panel_itemheader.setVerticalGroup(vGrouppanel_itemheader);
    ;

}

private void initializelayouts() {
	 // Add the new panel to the layout
    addgeneratebill();
    addradiopanel();
    addmobilepanel();
    addaddresspanel();
    additembar();
    additemheader();
    additemlists(0);
    addsubtotalpanel();
    adddiscountpanel();
    addDiscpanel();
    addtotalpanel();
    addDeliveryCharge();
    addContainerCharge();
    addAppliedTaxes();
    addSgstCgstpanel();
    addRoundOff();
    addsplitpane();
    addcustomerpaid();
    addreturncustomer();
    addtip();
}


private void addgeneratebill() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(generatebill, GroupLayout.PREFERRED_SIZE, 935, GroupLayout.PREFERRED_SIZE)
            .addComponent(supportpanel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel
    		.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
            .addComponent(generatebill, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
            .addComponent(supportpanel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE));
    gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void addmobilepanel() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(mobilepanel, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel .addGap(2)
    .addComponent(mobilepanel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE);
	gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void additemheader() {
	
		hGrouppanel.addGroup(gl_panel.createSequentialGroup()
	            .addComponent(itemheader, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
	    );
	    vGrouppanel
	            .addComponent(itemheader, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE);
	    
	    gl_panel.setHorizontalGroup(hGrouppanel);
	    gl_panel.setVerticalGroup(vGrouppanel);
	
    expandtable();
}
private void additemlists(int rows) {
	
	if(rows>2) {
			hGrouppanel.addGroup(gl_panel.createSequentialGroup()
		            .addComponent(itemListPanel, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
		    );
		    vGrouppanel
		            .addComponent(itemListPanel, GroupLayout.PREFERRED_SIZE, rows *60, GroupLayout.PREFERRED_SIZE);
		    
		    gl_panel.setHorizontalGroup(hGrouppanel);
		    gl_panel.setVerticalGroup(vGrouppanel);
	}
	else {
		hGrouppanel.addGroup(gl_panel.createSequentialGroup()
	            .addComponent(itemListPanel, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
	    );
	    vGrouppanel
	            .addComponent(itemListPanel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE);
	    
	    gl_panel.setHorizontalGroup(hGrouppanel);
	    gl_panel.setVerticalGroup(vGrouppanel);
	}
	
}

private void addradiopanel() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(radiopanel, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel.addComponent(radiopanel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE);
	gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void addDiscpanel() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(discPanel, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel.addComponent(discPanel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE);
	gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void addsubtotalpanel() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(subtotalpanel, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel.addComponent(subtotalpanel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE);
	gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void adddiscountpanel() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(appliedDiscounts, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel.addComponent(appliedDiscounts, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE);
	gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void addSgstCgstpanel() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(SGST_CGST_Panel, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel.addComponent(SGST_CGST_Panel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE);
	gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void addtotalpanel() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(totalpanel, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel.addComponent(totalpanel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE);
	gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void addDeliveryCharge() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(DeliveryCharge, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel.addComponent(DeliveryCharge, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE);
	gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void addAppliedTaxes() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(AppliedTaxes, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel.addComponent(AppliedTaxes, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE);
	gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void addRoundOff() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(RoundOff, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel.addComponent(RoundOff, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE);
	gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void addsplitpane() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(splitpane, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel.addComponent(splitpane, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE);
	gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void addcustomerpaid() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(customerpaid, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel.addComponent(customerpaid, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE);
	gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void addreturncustomer() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(returncustomer, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel.addComponent(returncustomer, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE);
	gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void addContainerCharge() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(ContainerCharge, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel.addComponent(ContainerCharge, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE);
	gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void addtip() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(tip, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel.addComponent(tip, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE);
	gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void addaddresspanel() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(addresspanel, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel .addGap(2)
    .addComponent(addresspanel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE);
	gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void additembar() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(itembar, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel .addGap(4)
    .addComponent(itembar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE);
	gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}
private void addNewItemRow(String itemNameText, String specialNoteText, String qtyText, String price09, String amountText) {
    // Iterate over existing rows to check if the item already exists
	// Iterate over existing rows to check if the item already exists
	Double priceorig = Double.parseDouble(price09);
	String priceText = String.format("%.2f", priceorig);
    Component[] existingRows = itemListPanel.getComponents();
    for (Component existingRow : existingRows) {
        if (existingRow instanceof JPanel) {
            JPanel existingRowPanel = (JPanel) existingRow;
            JLabel existingItemNameLabel = (JLabel) ((JPanel) existingRowPanel.getComponent(1)).getComponent(0); 

            // Check if item name matches
            if (existingItemNameLabel.getText().trim().equals(itemNameText)) {
                // Item already exists, update quantity and amount if needed
                JTextField qtyTextField = (JTextField) ((JPanel) existingRowPanel.getComponent(3)).getComponent(0);
                JLabel amountLabel = (JLabel) existingRowPanel.getComponent(5);

                // Update the quantity only if the new quantity differs
                int existingQuantity = Integer.parseInt(qtyTextField.getText());
                int newQuantity = existingQuantity + Integer.parseInt(qtyText);
                
                // If quantities are unchanged, do nothing
                if (existingQuantity == Integer.parseInt(qtyText)) {
                    return; // No changes needed, exit the method
                }
                
                // Update the amount
                double price = Double.parseDouble(priceText);
                double newAmount = newQuantity * price;
                qtyTextField.setText(String.valueOf(newQuantity));
                amountLabel.setText(String.format("%.2f", newAmount));

                // Remove from the backup lists
                removeFromBackup(itemNameText, existingQuantity); // Optional: Update this method if needed

                // Return without adding a new row
                return;
            }
        }
    }

    // Item does not exist, add a new row
    JPanel itemRowPanel = new JPanel();
    GroupLayout gl_itemRowPanel = new GroupLayout(itemRowPanel);
    itemRowPanel.setLayout(gl_itemRowPanel);

    JLabel crosslabel = new JLabel("");
    crosslabel.setOpaque(true);
    crosslabel.setHorizontalAlignment(JLabel.CENTER);
    crosslabel.setPreferredSize(new Dimension(40, 40));
    crosslabel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    ImageIcon resizedIconx = createResizedIcon("/homepanel/54344.png", 30,35); // Adjust the path and size
    crosslabel.setIcon(resizedIconx);

    // Add action listener for the cross label
    crosslabel.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        	removeItemRow(itemRowPanel, itemNameText);
        }
    });

    // Create a JPanel for itemName instead of JLabel
    JPanel itemNamePanel = new JPanel();
    GroupLayout gl_itemNamePanel = new GroupLayout(itemNamePanel);
    itemNamePanel.setLayout(gl_itemNamePanel);
    itemNamePanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    itemNamePanel.setBackground(Color.WHITE);

    // Add JLabel to the itemNamePanel
    JLabel itemNameLabel = new JLabel(" " + itemNameText);
    itemNameLabel.setFont(new Font("Arial", Font.BOLD, 13));

    // Create a new JLabel for item description
    JLabel itemDescriptionLabel = new JLabel("  Taxes: SGST(2.5%),CGST(2.5%)");
    itemDescriptionLabel.setFont(new Font("Arial", Font.ITALIC, 12));
    itemDescriptionLabel.setForeground(Color.BLACK);
    itemDescriptionLabel.setBackground(new Color(255,234,229));
    itemDescriptionLabel.setOpaque(true);

    // Define GroupLayout for itemNamePanel, with itemDescriptionLabel below itemNameLabel
    gl_itemNamePanel.setHorizontalGroup(
        gl_itemNamePanel.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(itemNameLabel, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
            .addGroup(gl_itemNamePanel.createSequentialGroup()
            		.addGap(5)
                .addComponent(itemDescriptionLabel, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE) )// New label below
    );
    gl_itemNamePanel.setVerticalGroup(
        gl_itemNamePanel.createSequentialGroup()
            .addGap(3)
            .addComponent(itemNameLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE) // Adjust height
            .addComponent(itemDescriptionLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE) // Adjust height
    );

    JLabel specialnotelabel = new JLabel("  " + specialNoteText);
    specialnotelabel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));

    // Create a JPanel for qtyLabel instead of JLabel
    JPanel qtyPanel = new JPanel();
    GroupLayout gl_qtyPanel = new GroupLayout(qtyPanel);
    qtyPanel.setLayout(gl_qtyPanel);
    qtyPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    qtyPanel.setBackground(Color.WHITE);

    // Create JTextField for qtyTextField
    JTextField qtyTextField = new JTextField(qtyText);
    qtyTextField.setFont(new Font("Arial", Font.PLAIN, 14));
    qtyTextField.setOpaque(true);
    qtyTextField.setBackground(Color.WHITE);
    qtyTextField.setForeground(Color.BLACK);
    qtyTextField.setHorizontalAlignment(JTextField.LEFT);

    // Define GroupLayout for qtyPanel
    gl_qtyPanel.setHorizontalGroup(
        gl_qtyPanel.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(gl_qtyPanel.createSequentialGroup()
                .addGap(2)
                .addComponent(qtyTextField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
    );
    gl_qtyPanel.setVerticalGroup(
        gl_qtyPanel.createSequentialGroup()
            .addGap(5)
            .addComponent(qtyTextField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
    );

    JLabel pricelabel = new JLabel(priceText);
    pricelabel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    pricelabel.setHorizontalAlignment(JLabel.RIGHT);
    JLabel amountlabel = new JLabel(amountText);
    amountlabel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    amountlabel.setHorizontalAlignment(JLabel.RIGHT);

    // Convert price text to a double for calculation
    double price = Double.parseDouble(priceText);

    // Add a DocumentListener to update the amount based on quantity input
 // Inside your DocumentListener for qtyTextField
    qtyTextField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
        public void insertUpdate(javax.swing.event.DocumentEvent e) {
            updateAmount();
        }
        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            updateAmount();
        }
        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            updateAmount();
        }

        private void updateAmount() {
            try {
                int quantity = Integer.parseInt(qtyTextField.getText());
                double amount = quantity * price; // Assuming 'price' is defined elsewhere
                amountlabel.setText(String.format("%.2f", amount));

                // Assuming 'itemNameText' is the name of the item being updated
//                String itemNameText = "Example Item Name"; // Replace with actual item name context
                int index = itemNames.indexOf(itemNameText);
                if (index != -1) { // If the item exists in the list
                    itemQuantities.set(index, quantity); // Update the quantity in the ArrayList
                }

                updateSubtotal(); // Call to update subtotal (assuming this method is defined)
            } catch (NumberFormatException ex) {
                // Handle invalid input (e.g., empty field or non-numeric input)
                amountlabel.setText("0.00");
            }
        }
    });

    // Set label styles
    for (JLabel label : new JLabel[]{specialnotelabel, pricelabel, amountlabel}) {
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setForeground(Color.BLACK);
    }

    // Add components to horizontal group
    GroupLayout.ParallelGroup hGroup = gl_itemRowPanel.createParallelGroup(GroupLayout.Alignment.LEADING);
    hGroup.addGroup(gl_itemRowPanel.createSequentialGroup()
        .addComponent(crosslabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        .addComponent(itemNamePanel, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
        .addComponent(specialnotelabel, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
        .addComponent(qtyPanel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        .addComponent(pricelabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        .addComponent(amountlabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE));

    // Add components to vertical group
    GroupLayout.SequentialGroup vGroup = gl_itemRowPanel.createSequentialGroup();
    vGroup.addGroup(gl_itemRowPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(crosslabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
        .addComponent(itemNamePanel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
        .addComponent(specialnotelabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
        .addComponent(qtyPanel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
        .addComponent(pricelabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
        .addComponent(amountlabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE));

    // Set the horizontal and vertical groups for the GroupLayout
    gl_itemRowPanel.setHorizontalGroup(hGroup);
    gl_itemRowPanel.setVerticalGroup(vGroup);

    // Add the item row panel to the main item list panel
    addRowToItemListPanel(itemRowPanel);
    itemNames.add(itemNameText);
    
    itemPrices.add(Double.parseDouble(priceText));
    itemQuantities.add(Integer.parseInt(qtyText));
    updateSubtotal();
    AppliedTaxes.setVisible(true);
}
private void removeFromBackup(String itemNameText, int quantity) {
    int indexToRemove = itemNames.indexOf(itemNameText);
    if (indexToRemove != -1) {
        itemNames.remove(indexToRemove);
        itemPrices.remove(indexToRemove);
        itemQuantities.remove(indexToRemove);
    }
}
private void updateSubtotal() {
    double total = 0.0; // Initialize total to zero
    int totalQuantity = 0;
    
    // Iterate through all components in itemListPanel
    Component[] itemRows = itemListPanel.getComponents();
    for (Component row : itemRows) {
        if (row instanceof JPanel) {
            JPanel rowPanel = (JPanel) row;

            // Assuming the amount label is in a known position in the row panel (e.g., index 5)
            JLabel amountLabel = (JLabel) rowPanel.getComponent(5); // Adjust index based on your layout

            // Parse the amount and add to total
            try {
                String amountText = amountLabel.getText().trim();
                double amount = Double.parseDouble(amountText);
                total += amount; // Add to total
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount: " + amountLabel.getText());
            }
        }
    }
    for (int quantity : itemQuantities) {
        totalQuantity += quantity;
    }
 // Now you have the total quantity
    totslqtyvalue_subtotalpanel.setText(String.valueOf(totalQuantity));
    
    if(discvalue.getText().toString().equals("")) {
    	TotalValue.setText(String.format("%.2f", total));
        taxvalue.setText(String.format("%.2f", total*0.05));
        Totalheading.setText(String.format("%.0f", total+(total*0.05)));
        subtotalheadervalue_subtotalpanel.setText(String.format("%.2f", total)); // Format to two decimal places
        double result = Double.parseDouble(Totalheading.getText().toString())-(Double.parseDouble(subtotalheadervalue_subtotalpanel.getText().toString())+Double.parseDouble(taxvalue.getText().toString()));
        String sign = "";
        if (result > 0) {
            sign = "+";
        } else if (result < 0) {
            sign = "";
        }
//        System.out.println("______________________________________Result: " + sign + String.format("%.2f", result));
        Roundoffevalue.setText(sign + String.format("%.2f", result)+" ");
        SGSval.setText(String.format("%.2f", (total*0.025))+" ");
        CGSval.setText(String.format("%.2f", (total*0.025))+" ");
        
    }
    else {
    	 double result = Double.parseDouble(Totalheading.getText().toString())-(Double.parseDouble(subtotalheadervalue_subtotalpanel.getText().toString())+Double.parseDouble(taxvalue.getText().toString()));
         String sign = "";
         if (result > 0) {
             sign = "+";
         } else if (result < 0) {
             sign = "";
         }
//         System.out.println("______________________________________Result: " + sign + String.format("%.2f", result));
         Roundoffevalue.setText(sign + String.format("%.2f", result)+" ");
    	TotalValue.setText(String.format("%.2f", total));
        taxvalue.setText(String.format("%.2f", total*0.05));
        
        if(selectedDiscountType.equals("P")) {
        	
        	Double totalvalue =total+(total*0.05);
        	totalvalue= totalvalue-(totalvalue*((Double.parseDouble(discvalue.getText().toString()))/100));
        	Totalheading.setText(String.format("%.0f",totalvalue ));
        }
        else {
        	Double totalvalue =total+(total*0.05);
        	totalvalue= totalvalue-Double.parseDouble(discvalue.getText().toString());
        	Totalheading.setText(String.format("%.0f",totalvalue ));
        }
//        Totalheading.setText(String.format("%.0f", ));
        
        subtotalheadervalue_subtotalpanel.setText(String.format("%.2f", total)); // Format to two decimal places
       
        SGSval.setText(String.format("%.2f", (total*0.025))+" ");
        CGSval.setText(String.format("%.2f", (total*0.025))+" ");
    }
    // Set the total value to the subtotal label
    
}
private void addRowToItemListPanel(JPanel itemRowPanel) {
    // Add the new row panel to the main item list panel
    itemListPanel.add(itemRowPanel);
    itemListPanel.revalidate();
    itemListPanel.repaint();

    // Update the GroupLayout for the item list panel
    GroupLayout gl_itemListPanel = (GroupLayout) itemListPanel.getLayout();
    GroupLayout.ParallelGroup hGrouppanel_itemListPanel = gl_itemListPanel.createParallelGroup(GroupLayout.Alignment.LEADING);
    GroupLayout.SequentialGroup vGrouppanel_itemListPanel = gl_itemListPanel.createSequentialGroup();

    for (Component comp : itemListPanel.getComponents()) {
        hGrouppanel_itemListPanel.addComponent(comp);
        vGrouppanel_itemListPanel.addComponent(comp);
    }
    
    gl_itemListPanel.setHorizontalGroup(hGrouppanel_itemListPanel);
    gl_itemListPanel.setVerticalGroup(vGrouppanel_itemListPanel);
}

private void restoreItems() {
    // Clear the item list panel
    itemListPanel.removeAll();
    itemListPanel.revalidate();
    itemListPanel.repaint();

    // Restore items from ArrayLists
    for (int i = 0; i < itemNames.size(); i++) {
        String name = itemNames.get(i);
        double price = itemPrices.get(i);
        int quantity = itemQuantities.get(i);
        String specialNote = ""; // Provide a way to get the special note if needed
        String amount = String.format("%.2f", quantity * price); // Calculate amount

        addNewItemRow(name, specialNote, String.valueOf(quantity), String.valueOf(price), amount);
    }
}
private void removeItemRow(JPanel itemRowPanel, String itemNameText) {
    // Remove the row from the UI panel
    itemListPanel.remove(itemRowPanel);
    itemListPanel.revalidate();
    itemListPanel.repaint();

    // Remove the item from the ArrayList
    int index = itemNames.indexOf(itemNameText);
    if (index != -1) {
        // Remove the item from all lists at the corresponding index
        itemNames.remove(index);
        itemPrices.remove(index);
        itemQuantities.remove(index);
    }
    if(itemNames.size()<=0)
    {
    	AppliedTaxes.setVisible(false);
    }
    
    // Update the subtotal after removing the item
    updateSubtotal();
    refreshpage();
}

private void clearPanel() {
    itemListPanel.removeAll();
    itemListPanel.revalidate();
    itemListPanel.repaint();
    // Optionally clear ArrayLists if you want to reset the backup
    // itemNames.clear();
    // itemPrices.clear();
    // itemQuantities.clear();
}

private void refreshpage() {
	panel.remove(itemListPanel);
    panel.remove(subtotalpanel);
    panel.remove(appliedDiscounts);
    panel.remove(discPanel);
    panel.remove(subtotalpanel);
    panel.remove(totalpanel);
    panel.remove(DeliveryCharge);
    panel.remove(ContainerCharge);
    panel.remove(AppliedTaxes);
    panel.remove(SGST_CGST_Panel);
    panel.remove(RoundOff);
    panel.remove(splitpane);
    panel.remove(customerpaid);
    panel.remove(returncustomer);
    panel.remove(tip);
    
    panel.revalidate();       // Refresh the layout
    panel.repaint();          // Redr
    
    
    int size = itemNames.size();
	additemlists(size);
	addsubtotalpanel();
    adddiscountpanel();
    addDiscpanel();
    addtotalpanel();
    addDeliveryCharge();
    
    addContainerCharge();
    addAppliedTaxes();
    addSgstCgstpanel();
    addRoundOff();
    addsplitpane();
    addcustomerpaid();
    addreturncustomer();
    addtip();
}
private void bottomrightpanel() {
	// Create radio buttons
    JRadioButton radioButton1 = new JRadioButton("Cash");
    radioButton1.setBackground(new Color(221,221,221));
    radioButton1.setIcon(new CustomRadioButtonIcon());
    radioButton1.setSelectedIcon(new CustomRadioButtonIcon(true));
    radioButton1.setSelected(true);
    
    JRadioButton radioButton2 = new JRadioButton("Card");
    radioButton2.setBackground(new Color(221,221,221));
    radioButton2.setIcon(new CustomRadioButtonIcon());
    radioButton2.setSelectedIcon(new CustomRadioButtonIcon(false));
    
    JRadioButton radioButton3 = new JRadioButton("Due Payment");
    radioButton3.setBackground(new Color(221,221,221));
    radioButton3.setIcon(new CustomRadioButtonIcon());
    radioButton3.setSelectedIcon(new CustomRadioButtonIcon(false));
    
    JRadioButton radioButton4 = new JRadioButton("Part Payment");
    radioButton4.setBackground(new Color(221,221,221));
    radioButton4.setIcon(new CustomRadioButtonIcon());
    radioButton4.setSelectedIcon(new CustomRadioButtonIcon(false));

 // Create buttons
    RoundButton button1 = new RoundButton("Save");
    button1.setBorder(null);
    button1.setFont(new Font("Arial", Font.BOLD, 14));
    button1.setBackground(new Color(197,31,49,255)); // Set the background color
    button1.setForeground(Color.WHITE); // Set the text color
    button1.addActionListener(e -> {
    		
//    		panel.remove(itemListPanel);
//    	    panel.remove(subtotalpanel);
//    	    panel.remove(appliedDiscounts);
//    	    panel.remove(subtotalpanel);
//    	    panel.remove(totalpanel);
//    	    panel.remove(DeliveryCharge);
//    	    panel.remove(ContainerCharge);
//    	    panel.remove(AppliedTaxes);
//    	    panel.remove(RoundOff);
//    	    panel.remove(splitpane);
//    	    panel.remove(customerpaid);
//    	    panel.remove(returncustomer);
//    	    panel.remove(tip);
//    	    
//    	    panel.revalidate();       // Refresh the layout
//    	    panel.repaint();          // Redraw the panel
    
    });
    
    RoundButton button2 = new RoundButton("Print & EBILL");
    button2.setBorder(null);
    button2.setFont(new Font("Arial", Font.BOLD, 14));
    button2.setBackground(new Color(197,31,49,255)); // Set the background color
    button2.setForeground(Color.WHITE); // Set the text color

    // Define the action to be performed (same as in ActionListener)
    Action performAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < itemNames.size(); i++) {
                String itemName = itemNames.get(i);
                int quantity = itemQuantities.get(i);
                double rate = itemPrices.get(i);
                double amount = rate * quantity;
                String formattedAmount = String.format("%.2f", amount);
                String formattedrate = String.format("%.2f", rate);

                // Create a row with blank cells where necessary
                Object[] row = {"", itemName, "", quantity, formattedrate, formattedAmount, "", formattedAmount};

                // Add the row to the table
                tableModel2.addRow(row);
                System.out.println("Row Inserted");
            }
            if(itemNames.size()>0) {
	            mainPanel01 counter = new mainPanel01(tableModel2, subtotalheadervalue_subtotalpanel.getText(), Totalheading.getText());
	            counter.setLocationRelativeTo(null);
	            counter.setVisible(false); // Set the visibility to false (hidden by default)
	            clearData();
	            pdfprint();
	            refreshpage();

	            	
            }
            else {
            	System.out.println("list empty");
            }
            
        }
    };

    // Attach the action listener to the button (when clicked)
    button2.addActionListener(performAction);

    // Bind the F8 key to trigger the same action as the button click
    button2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F8"), "performAction");
    button2.getActionMap().put("performAction", performAction);

    
    RoundButton1 button3 = new RoundButton1("Reset");
    button3.setBorder(null);
    button3.setBackground(new Color(221,221,221));
    button3.setFont(new Font("Arial", Font.BOLD, 14));
    button3.setForeground(Color.BLACK); // Set the text color
    button3.addActionListener(e -> {
    	
    	          // Redraw the panel

    });
    
    RoundButton1 button4 = new RoundButton1("KOT");
    button4.setBorder(null);
    button4.setFont(new Font("Arial", Font.BOLD, 14));
    button4.setBackground(new Color(77,87,93,255)); // Set the background color
    button4.setForeground(Color.WHITE); // Set the text color
    button4.addActionListener(e -> {
//    	restoreItems();
    	          // Redraw the panel

    });
    
    RoundButton1 button5 = new RoundButton1("KOT & Print");
    button5.setBorder(null);
    button5.setFont(new Font("Arial", Font.BOLD, 14));
    button5.setBackground(new Color(77,87,93,255)); // Set the background color
    button5.setForeground(Color.WHITE); // Set the text color
    
    RoundButton1 button6 = new RoundButton1("Hold");
    button6.setBackground(new Color(221,221,221));
    button6.setBorder(null);
    button6.setFont(new Font("Arial", Font.BOLD, 14));
    button6.setForeground(Color.BLACK); // Set the text color
    
    hGrouppanel_BelowRight.addGroup(gl_panel_BelowRight.createSequentialGroup()
            .addGap(18)
            .addComponent(radioButton1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
          
            .addComponent(radioButton2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
            
            .addComponent(radioButton3, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
            
            .addComponent(radioButton4, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
            .addGap(50)
            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
            .addGap(8)
            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
            .addGap(8)
            .addComponent(button3, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
            .addGap(8)
            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
            .addGap(8)
            .addComponent(button5, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
            .addGap(8)
            .addComponent(button6, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
           
            );
    
    vGrouppanel_BelowRight.addGap(10)
    	.addGroup(gl_panel_BelowRight.createParallelGroup(Alignment.LEADING)
            .addComponent(radioButton1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
            .addComponent(radioButton2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
            .addComponent(radioButton3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
            .addComponent(radioButton4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            .addComponent(button3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            .addComponent(button5, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            .addComponent(button6, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
          
           );
    
    gl_panel_BelowRight.setHorizontalGroup(hGrouppanel_BelowRight);
    gl_panel_BelowRight.setVerticalGroup(vGrouppanel_BelowRight);
}
private void clearData() {
    // Clear the lists
    itemNames.clear();
    itemPrices.clear();
    itemQuantities.clear();

    // Clear the item list panel
    itemListPanel.removeAll();
    itemListPanel.revalidate(); // Refresh the layout
    itemListPanel.repaint(); // Repaint the panel
    tableModel2.setRowCount(0);
    // Reset any other UI components as necessary
    subtotalheadervalue_subtotalpanel.setText("0.00");
    TotalValue.setText("0.00");
    Roundoffevalue.setText("0.00");
    taxvalue.setText("0.00");
    totslqtyvalue_subtotalpanel.setText("0");
    Totalheading.setText("");
    
    // Optionally, reset other fields like discounts, delivery charge, etc.
    discvalue.setText("");
    // Reset any other fields as needed
}
private void pdfprint() {
	LocalDate currentDate = LocalDate.now();
    
    // Format the date to a string
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedDateStr = currentDate.format(formatter);
    
    // Parse the formatted string back to LocalDate
    LocalDate formattedDate = LocalDate.parse(formattedDateStr, formatter);
    GetReport1(formattedDate,formattedDate);
}
private void GetReport1(LocalDate startDate1,LocalDate endDate1) {
	// Get current date
    LocalDate currentDatenew = LocalDate.now();
    DateTimeFormatter formatternew = DateTimeFormatter.ofPattern("ddMMyyyy");
    String formattedDatenew = currentDatenew.format(formatternew);
	String filePath = "C:\\POS\\Invoice_Data\\Complete\\"+formattedDatenew+".sql";



    DefaultTableModel tableModelA = new DefaultTableModel();
    tableModelA.addColumn("Date");
    tableModelA.addColumn("Name");
    tableModelA.addColumn("Unit Price");
    tableModelA.addColumn("Quantity");
    tableModelA.addColumn("Total");
    JTable tableA = new JTable(tableModelA);
    JScrollPane scrollPane1 = new JScrollPane(tableA);

    DefaultTableModel tableModelB = new DefaultTableModel();
    tableModelB.addColumn("Name");
    tableModelB.addColumn("Quantity");
    tableModelB.addColumn("Total");
    JTable tableB = new JTable(tableModelB);
    JScrollPane scrollPane2 = new JScrollPane(tableB);

    DefaultTableModel tableModelC = new DefaultTableModel();
    tableModelC.addColumn("Name");
    tableModelC.addColumn("Quantity");
    tableModelC.addColumn("Total");
    JTable tableC = new JTable(tableModelC);
    JScrollPane scrollPane3 = new JScrollPane(tableC);
    
    DefaultTableModel tableModelD = new DefaultTableModel();
    tableModelD.addColumn("Name");
    tableModelD.addColumn("Quantity");
    tableModelD.addColumn("Total");
    JTable tableD = new JTable(tableModelD);
    JScrollPane scrollPane4 = new JScrollPane(tableD);
    
    DefaultTableModel tableModelE = new DefaultTableModel();
    tableModelE.addColumn("Name");
    tableModelE.addColumn("Quantity");
    tableModelE.addColumn("Total");
    JTable tableE = new JTable(tableModelE);
    JScrollPane scrollPane5 = new JScrollPane(tableE);
    
    DefaultTableModel tableModelF = new DefaultTableModel();
    tableModelF.addColumn("Name");
    tableModelF.addColumn("Quantity");
    tableModelF.addColumn("Total");
    JTable tableF = new JTable(tableModelF);
    JScrollPane scrollPaneF = new JScrollPane(tableF);
    
    DefaultTableModel tableModelG = new DefaultTableModel();
    tableModelG.addColumn("Name");
    tableModelG.addColumn("Quantity");
    tableModelG.addColumn("Total");
    JTable tableG = new JTable(tableModelG);
    JScrollPane scrollPaneG = new JScrollPane(tableG);
    
    DefaultTableModel tableModelH = new DefaultTableModel();
    tableModelH.addColumn("Name");
    tableModelH.addColumn("Quantity");
    tableModelH.addColumn("Total");
    JTable tableH = new JTable(tableModelH);
    JScrollPane scrollPaneH = new JScrollPane(tableH);
    
    // Define the date range
    LocalDate startDate = startDate1; // Start Date
    LocalDate endDate = endDate1;   // End Date

    try (FileReader fr = new FileReader(filePath)) {
        int ch;
        StringBuilder sb = new StringBuilder();

        while ((ch = fr.read()) != -1) {
            sb.append((char) ch);
        }

        String sqlData = sb.toString();
        String[] rows = sqlData.split("VALUES");

        for (int i = 1; i < rows.length; i++) {
            String row = rows[i].trim().replace("(", "").replace(");", "");
            String[] values = row.split(",");

            // Extract the values
            String dateStr = values[0].trim().replace("'", "");
            LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            if (date.isBefore(startDate) || date.isAfter(endDate)) {
                continue; // Skip this row if the date is outside the range
            }

            String productName = values[3].trim().replace("'", "");
            String unitPrice = values[4].trim().replace("'", "");
            String quantity = values[5].trim().replace("'", "");

            // Calculate the total
            double unitPriceDouble = Double.parseDouble(unitPrice);
            int quantityInt = Integer.parseInt(quantity);
            double totalDouble = unitPriceDouble * quantityInt;
            String totalString = String.format("%.2f", totalDouble);

            // Check if the product already exists in the first table
            boolean productExists = false;
            for (int j = 0; j < tableModelA.getRowCount(); j++) {
                if (tableModelA.getValueAt(j, 1).equals(productName)) {
                    // Update the quantity and total
                    int existingQuantity = Integer.parseInt((String) tableModelA.getValueAt(j, 3));
                    int newQuantity = existingQuantity + quantityInt;
                    tableModelA.setValueAt(String.valueOf(newQuantity), j, 3);

                    double newTotal = unitPriceDouble * newQuantity;
                    String newTotalString = String.format("%.2f", newTotal);
                    tableModelA.setValueAt(newTotalString, j, 4);

                    productExists = true;
                    break;
                }
            }

            if (!productExists) {
                // Add a new row to the first table
                String[] data1 = new String[]{dateStr, productName, unitPrice, String.valueOf(quantityInt), totalString};
                tableModelA.addRow(data1);
            }
        }

//      ===================================== SOUTH INDIAN DATA ========================
      String SouthIndianfilePath = "C:\\POS\\Categorial_Data\\SouthIndianData.sql";
      ArrayList<String> SouthIndianproductNames = new ArrayList<>();

      try (BufferedReader br = new BufferedReader(new FileReader(SouthIndianfilePath))) {
          String line;
          Pattern pattern = Pattern.compile("'(.*?)'");

          while ((line = br.readLine()) != null) {
              Matcher matcher = pattern.matcher(line);
              while (matcher.find()) {
                  SouthIndianproductNames.add(matcher.group(1));
              }
          }
      } catch (IOException e) {
          e.printStackTrace();
      }

      // Convert ArrayList to Array
      String[] SouthIndianproductArray = new String[SouthIndianproductNames.size()];
      SouthIndianproductArray = SouthIndianproductNames.toArray(SouthIndianproductArray);

//      String[] SouthproductNames = {"Upma", "Chennai Idli 2 Pcs", "Spl. Mini Idli 12pcs", "14 Ghee Idli", "Mini Medu Wada 2pcs", "Mini Medu Wada 4pcs", "Dal Wada 2pcs", "Dal Wada 4pcs", "Dahi Wada 4pcs", "Sada Dosa", "Mysore Sada Dosa", "Masala Dosa", "Rocket Mysore Dosa", "Mysore Masala Dosa", "Onion Masala Dosa", "Paneer Masala Dosa", "Paneer Onion Masala Dosa", "Maharaja Masala Dosa", "Prem Masala Dosa", "Harabhara Masala Dosa", "Navratna Masala Dosa", "Garlic Roast Dosa", "Pudy Roast Dos", "Prem Sada 4 Types Of Chatni", "Maharaja Sada Dosa", "Harabhara Sada", "Schezwan Sada", "Onion Sada Dosa", "Spring Roll Dosa", "Paneer Spring Roll", "Chinese Delight Dosa", "Paneer Chinese Delight Dosa", "American Chopsuey Dosa", "Paneer American Chopsuey Dosa", "Mushroom Chopsuey Dosa", "Paneer Chilly Dosa", "Schezwan Dosa", "Mushroom Schezwan Dosa", "Paneer Schezwan Dosa", "Capsium Schezwan Dosa", "Tom-Chi Dosa", "Chaap Dosa", "American Delight Dosa", "American Paneer Delight Dosa", "Salad Roast Dosa", "Paneer Salad Roast Dosa", "Mexican Roast Dosa", "Red Chilly Dosa", "Paneer Crispy Dosa", "Aloo Crispy Dosa", "Mexi Roll Dosa", "Salsa Lite", "Salsa Noodles Dosa", "Sizz-Lee Noodles Dosa", "Corn Mac 'N' Cheese Dosa", "Pasta Dosa", "Onion Delight", "Hot Garlic Mexican", "Chilly Delight", "Paper Roast Dosa", "Special Pream Paper Roast Dosa", "Mysore Uttappa", "Tom-Chi Uttappa", "Plain Uttappa", "Onion Uttappa", "Paneer Onion Uttappa", "Tomato Uttappa", "Masala Uttappa", "Sandwich Uttappa", "Spl. Pream Uttappa", "Paneer Special Prem Uttappa", "Spl. Spicy Uttappa", "Spl. Paneer Spicy Uttappa", "Idli Manchurian", "Idli Schezwan", "Idli Chilly", "Idli Cheese Manchurian", "Idli Paneer Manchurian", "Idli Fry", "Bisebelle Bhatt", "Thakkali Sadan", "Chitranna", "Dahi Rice", "Chickpea Rice", "Shahi Korma Rice", "Mini Lunch", "Chetinad Biryani"};

      for (int j = 0; j < tableModelA.getRowCount(); j++) {
          String productName = (String) tableModelA.getValueAt(j, 1);
          for (String name : SouthIndianproductArray) {
              if (productName.equals(name)) {
                  String quantity = (String) tableModelA.getValueAt(j, 3);
                  String total = (String) tableModelA.getValueAt(j, 4);
                  tableModelB.addRow(new Object[]{productName, quantity, total});
                  break;
              }
              
              if (productName.equals("4 Pcs")) {
                  String quantity = (String) tableModelA.getValueAt(j, 1);
                  Object total = tableModelA.getValueAt(j, 2);
                  tableModelB.addRow(new Object[]{productName,quantity,total});
                  break;
              }
          }
      }
//      =====================================================================================
      String MumbaiChaatfilePath = "C:\\POS\\Categorial_Data\\MumbaiChaatData.sql";
      ArrayList<String> MumbaiChaatproductNames = new ArrayList<>();

      try (BufferedReader br = new BufferedReader(new FileReader(MumbaiChaatfilePath))) {
          String line;
          Pattern pattern = Pattern.compile("'(.*?)'");

          while ((line = br.readLine()) != null) {
              Matcher matcher = pattern.matcher(line);
              while (matcher.find()) {
                  MumbaiChaatproductNames.add(matcher.group(1));
              }
          }
      } catch (IOException e) {
          e.printStackTrace();
      }

      // Convert ArrayList to Array
      String[] MumbaiChaatproductArray = new String[MumbaiChaatproductNames.size()];
      MumbaiChaatproductArray = MumbaiChaatproductNames.toArray(MumbaiChaatproductArray);

//      String[] SouthproductNames = {"Upma", "Chennai Idli 2 Pcs", "Spl. Mini Idli 12pcs", "14 Ghee Idli", "Mini Medu Wada 2pcs", "Mini Medu Wada 4pcs", "Dal Wada 2pcs", "Dal Wada 4pcs", "Dahi Wada 4pcs", "Sada Dosa", "Mysore Sada Dosa", "Masala Dosa", "Rocket Mysore Dosa", "Mysore Masala Dosa", "Onion Masala Dosa", "Paneer Masala Dosa", "Paneer Onion Masala Dosa", "Maharaja Masala Dosa", "Prem Masala Dosa", "Harabhara Masala Dosa", "Navratna Masala Dosa", "Garlic Roast Dosa", "Pudy Roast Dos", "Prem Sada 4 Types Of Chatni", "Maharaja Sada Dosa", "Harabhara Sada", "Schezwan Sada", "Onion Sada Dosa", "Spring Roll Dosa", "Paneer Spring Roll", "Chinese Delight Dosa", "Paneer Chinese Delight Dosa", "American Chopsuey Dosa", "Paneer American Chopsuey Dosa", "Mushroom Chopsuey Dosa", "Paneer Chilly Dosa", "Schezwan Dosa", "Mushroom Schezwan Dosa", "Paneer Schezwan Dosa", "Capsium Schezwan Dosa", "Tom-Chi Dosa", "Chaap Dosa", "American Delight Dosa", "American Paneer Delight Dosa", "Salad Roast Dosa", "Paneer Salad Roast Dosa", "Mexican Roast Dosa", "Red Chilly Dosa", "Paneer Crispy Dosa", "Aloo Crispy Dosa", "Mexi Roll Dosa", "Salsa Lite", "Salsa Noodles Dosa", "Sizz-Lee Noodles Dosa", "Corn Mac 'N' Cheese Dosa", "Pasta Dosa", "Onion Delight", "Hot Garlic Mexican", "Chilly Delight", "Paper Roast Dosa", "Special Pream Paper Roast Dosa", "Mysore Uttappa", "Tom-Chi Uttappa", "Plain Uttappa", "Onion Uttappa", "Paneer Onion Uttappa", "Tomato Uttappa", "Masala Uttappa", "Sandwich Uttappa", "Spl. Pream Uttappa", "Paneer Special Prem Uttappa", "Spl. Spicy Uttappa", "Spl. Paneer Spicy Uttappa", "Idli Manchurian", "Idli Schezwan", "Idli Chilly", "Idli Cheese Manchurian", "Idli Paneer Manchurian", "Idli Fry", "Bisebelle Bhatt", "Thakkali Sadan", "Chitranna", "Dahi Rice", "Chickpea Rice", "Shahi Korma Rice", "Mini Lunch", "Chetinad Biryani"};

      for (int j = 0; j < tableModelA.getRowCount(); j++) {
          String productName = (String) tableModelA.getValueAt(j, 1);
          for (String name : MumbaiChaatproductArray) {
              if (productName.equals(name)) {
                  String quantity = (String) tableModelA.getValueAt(j, 3);
                  String total = (String) tableModelA.getValueAt(j, 4);
                  tableModelC.addRow(new Object[]{productName, quantity, total});
                  break;
              }
          }
      }
//      ================================================================================================
      String IndianVegfilePath = "C:\\POS\\Categorial_Data\\IndianVegData.sql";
      ArrayList<String> IndianVegproductNames = new ArrayList<>();

      try (BufferedReader br = new BufferedReader(new FileReader(IndianVegfilePath))) {
          String line;
          Pattern pattern = Pattern.compile("'(.*?)'");

          while ((line = br.readLine()) != null) {
              Matcher matcher = pattern.matcher(line);
              while (matcher.find()) {
                  IndianVegproductNames.add(matcher.group(1));
              }
          }
      } catch (IOException e) {
          e.printStackTrace();
      }

      // Convert ArrayList to Array
      String[] IndianVegproductArray = new String[IndianVegproductNames.size()];
      IndianVegproductArray = IndianVegproductNames.toArray(IndianVegproductArray);

//      String[] SouthproductNames = {"Upma", "Chennai Idli 2 Pcs", "Spl. Mini Idli 12pcs", "14 Ghee Idli", "Mini Medu Wada 2pcs", "Mini Medu Wada 4pcs", "Dal Wada 2pcs", "Dal Wada 4pcs", "Dahi Wada 4pcs", "Sada Dosa", "Mysore Sada Dosa", "Masala Dosa", "Rocket Mysore Dosa", "Mysore Masala Dosa", "Onion Masala Dosa", "Paneer Masala Dosa", "Paneer Onion Masala Dosa", "Maharaja Masala Dosa", "Prem Masala Dosa", "Harabhara Masala Dosa", "Navratna Masala Dosa", "Garlic Roast Dosa", "Pudy Roast Dos", "Prem Sada 4 Types Of Chatni", "Maharaja Sada Dosa", "Harabhara Sada", "Schezwan Sada", "Onion Sada Dosa", "Spring Roll Dosa", "Paneer Spring Roll", "Chinese Delight Dosa", "Paneer Chinese Delight Dosa", "American Chopsuey Dosa", "Paneer American Chopsuey Dosa", "Mushroom Chopsuey Dosa", "Paneer Chilly Dosa", "Schezwan Dosa", "Mushroom Schezwan Dosa", "Paneer Schezwan Dosa", "Capsium Schezwan Dosa", "Tom-Chi Dosa", "Chaap Dosa", "American Delight Dosa", "American Paneer Delight Dosa", "Salad Roast Dosa", "Paneer Salad Roast Dosa", "Mexican Roast Dosa", "Red Chilly Dosa", "Paneer Crispy Dosa", "Aloo Crispy Dosa", "Mexi Roll Dosa", "Salsa Lite", "Salsa Noodles Dosa", "Sizz-Lee Noodles Dosa", "Corn Mac 'N' Cheese Dosa", "Pasta Dosa", "Onion Delight", "Hot Garlic Mexican", "Chilly Delight", "Paper Roast Dosa", "Special Pream Paper Roast Dosa", "Mysore Uttappa", "Tom-Chi Uttappa", "Plain Uttappa", "Onion Uttappa", "Paneer Onion Uttappa", "Tomato Uttappa", "Masala Uttappa", "Sandwich Uttappa", "Spl. Pream Uttappa", "Paneer Special Prem Uttappa", "Spl. Spicy Uttappa", "Spl. Paneer Spicy Uttappa", "Idli Manchurian", "Idli Schezwan", "Idli Chilly", "Idli Cheese Manchurian", "Idli Paneer Manchurian", "Idli Fry", "Bisebelle Bhatt", "Thakkali Sadan", "Chitranna", "Dahi Rice", "Chickpea Rice", "Shahi Korma Rice", "Mini Lunch", "Chetinad Biryani"};

      for (int j = 0; j < tableModelA.getRowCount(); j++) {
          String productName = (String) tableModelA.getValueAt(j, 1);
          for (String name : IndianVegproductArray) {
              if (productName.equals(name)) {
                  String quantity = (String) tableModelA.getValueAt(j, 3);
                  String total = (String) tableModelA.getValueAt(j, 4);
                  tableModelD.addRow(new Object[]{productName, quantity, total});
                  break;
              }
          }
      }
//     =================================================================================================
      String BeveragesfilePath = "C:\\POS\\Categorial_Data\\BeveragesData.sql";
      ArrayList<String> BeveragesproductNames = new ArrayList<>();

      try (BufferedReader br = new BufferedReader(new FileReader(BeveragesfilePath))) {
          String line;
          Pattern pattern = Pattern.compile("'(.*?)'");

          while ((line = br.readLine()) != null) {
              Matcher matcher = pattern.matcher(line);
              while (matcher.find()) {
                  BeveragesproductNames.add(matcher.group(1));
              }
          }
      } catch (IOException e) {
          e.printStackTrace();
      }

      // Convert ArrayList to Array
      String[] BeveragesproductArray = new String[BeveragesproductNames.size()];
      BeveragesproductArray = BeveragesproductNames.toArray(BeveragesproductArray);

//      String[] SouthproductNames = {"Upma", "Chennai Idli 2 Pcs", "Spl. Mini Idli 12pcs", "14 Ghee Idli", "Mini Medu Wada 2pcs", "Mini Medu Wada 4pcs", "Dal Wada 2pcs", "Dal Wada 4pcs", "Dahi Wada 4pcs", "Sada Dosa", "Mysore Sada Dosa", "Masala Dosa", "Rocket Mysore Dosa", "Mysore Masala Dosa", "Onion Masala Dosa", "Paneer Masala Dosa", "Paneer Onion Masala Dosa", "Maharaja Masala Dosa", "Prem Masala Dosa", "Harabhara Masala Dosa", "Navratna Masala Dosa", "Garlic Roast Dosa", "Pudy Roast Dos", "Prem Sada 4 Types Of Chatni", "Maharaja Sada Dosa", "Harabhara Sada", "Schezwan Sada", "Onion Sada Dosa", "Spring Roll Dosa", "Paneer Spring Roll", "Chinese Delight Dosa", "Paneer Chinese Delight Dosa", "American Chopsuey Dosa", "Paneer American Chopsuey Dosa", "Mushroom Chopsuey Dosa", "Paneer Chilly Dosa", "Schezwan Dosa", "Mushroom Schezwan Dosa", "Paneer Schezwan Dosa", "Capsium Schezwan Dosa", "Tom-Chi Dosa", "Chaap Dosa", "American Delight Dosa", "American Paneer Delight Dosa", "Salad Roast Dosa", "Paneer Salad Roast Dosa", "Mexican Roast Dosa", "Red Chilly Dosa", "Paneer Crispy Dosa", "Aloo Crispy Dosa", "Mexi Roll Dosa", "Salsa Lite", "Salsa Noodles Dosa", "Sizz-Lee Noodles Dosa", "Corn Mac 'N' Cheese Dosa", "Pasta Dosa", "Onion Delight", "Hot Garlic Mexican", "Chilly Delight", "Paper Roast Dosa", "Special Pream Paper Roast Dosa", "Mysore Uttappa", "Tom-Chi Uttappa", "Plain Uttappa", "Onion Uttappa", "Paneer Onion Uttappa", "Tomato Uttappa", "Masala Uttappa", "Sandwich Uttappa", "Spl. Pream Uttappa", "Paneer Special Prem Uttappa", "Spl. Spicy Uttappa", "Spl. Paneer Spicy Uttappa", "Idli Manchurian", "Idli Schezwan", "Idli Chilly", "Idli Cheese Manchurian", "Idli Paneer Manchurian", "Idli Fry", "Bisebelle Bhatt", "Thakkali Sadan", "Chitranna", "Dahi Rice", "Chickpea Rice", "Shahi Korma Rice", "Mini Lunch", "Chetinad Biryani"};

      for (int j = 0; j < tableModelA.getRowCount(); j++) {
          String productName = (String) tableModelA.getValueAt(j, 1);
          for (String name : BeveragesproductArray) {
              if (productName.equals(name)) {
                  String quantity = (String) tableModelA.getValueAt(j, 3);
                  String total = (String) tableModelA.getValueAt(j, 4);
                  tableModelE.addRow(new Object[]{productName, quantity, total});
                  break;
              }
          }
      }
//    =================================================================================================
     String ChineseVegfilePath = "C:\\POS\\Categorial_Data\\ChineseVegData.sql";
     ArrayList<String> ChineseVegproductNames = new ArrayList<>();

     try (BufferedReader br = new BufferedReader(new FileReader(ChineseVegfilePath))) {
         String line;
         Pattern pattern = Pattern.compile("'(.*?)'");

         while ((line = br.readLine()) != null) {
             Matcher matcher = pattern.matcher(line);
             while (matcher.find()) {
                 ChineseVegproductNames.add(matcher.group(1));
             }
         }
     } catch (IOException e) {
         e.printStackTrace();
     }

     // Convert ArrayList to Array
     String[] ChineseVegproductArray = new String[ChineseVegproductNames.size()];
     ChineseVegproductArray = ChineseVegproductNames.toArray(ChineseVegproductArray);

//     
     for (int j = 0; j < tableModelA.getRowCount(); j++) {
         String productName = (String) tableModelA.getValueAt(j, 1);
         for (String name : ChineseVegproductArray) {
             if (productName.equals(name)) {
                 String quantity = (String) tableModelA.getValueAt(j, 3);
                 String total = (String) tableModelA.getValueAt(j, 4);
                 tableModelF.addRow(new Object[]{productName, quantity, total});
                 break;
             }
         }
     }
//   =================================================================================================
    String CombosfilePath = "C:\\POS\\Categorial_Data\\CombosData.sql";
    ArrayList<String> CombosproductNames = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(CombosfilePath))) {
        String line;
        Pattern pattern = Pattern.compile("'(.*?)'");

        while ((line = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                CombosproductNames.add(matcher.group(1));
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Convert ArrayList to Array
    String[] CombosproductArray = new String[CombosproductNames.size()];
    CombosproductArray = CombosproductNames.toArray(CombosproductArray);

//    
    for (int j = 0; j < tableModelA.getRowCount(); j++) {
        String productName = (String) tableModelA.getValueAt(j, 1);
        for (String name : CombosproductArray) {
            if (productName.equals(name)) {
                String quantity = (String) tableModelA.getValueAt(j, 3);
                String total = (String) tableModelA.getValueAt(j, 4);
                tableModelG.addRow(new Object[]{productName, quantity, total});
                break;
            }
        }
    }
//  =================================================================================================
   String ExtrasfilePath = "C:\\POS\\Categorial_Data\\ExtrasData.sql";
   ArrayList<String> ExtrasproductNames = new ArrayList<>();

   try (BufferedReader br = new BufferedReader(new FileReader(ExtrasfilePath))) {
       String line;
       Pattern pattern = Pattern.compile("'(.*?)'");

       while ((line = br.readLine()) != null) {
           Matcher matcher = pattern.matcher(line);
           while (matcher.find()) {
               ExtrasproductNames.add(matcher.group(1));
           }
       }
   } catch (IOException e) {
       e.printStackTrace();
   }

   // Convert ArrayList to Array
   String[] ExtrasproductArray = new String[ExtrasproductNames.size()];
   ExtrasproductArray = ExtrasproductNames.toArray(ExtrasproductArray);

//   
   for (int j = 0; j < tableModelA.getRowCount(); j++) {
       String productName = (String) tableModelA.getValueAt(j, 1);
       for (String name : ExtrasproductArray) {
           if (productName.equals(name)) {
               String quantity = (String) tableModelA.getValueAt(j, 3);
               String total = (String) tableModelA.getValueAt(j, 4);
               tableModelH.addRow(new Object[]{productName, quantity, total});
               break;
           }
       }
   }
    } catch (IOException e) {
        e.printStackTrace();
    }
    

//    dispose();
    PDFReport counter = new PDFReport(tableModelB,tableModelC,tableModelD,tableModelE,tableModelF,tableModelG,tableModelH);
//	 counter.setLocationRelativeTo(null);
//	 counter.setVisible(true);
}
private void generatebillfunction() {
	 // Create components here
    JLabel labelgeneratebill = new JLabel("Generate Bill");
    labelgeneratebill.setFont(new Font("Arial", Font.BOLD, 22));
    
    JLabel icon1 = new JLabel();
    ImageIcon resizedIconlogo1 = createResizedIcon("/homepanel/21.PNG", 33,33); // Adjust the path and size
    icon1.setIcon(resizedIconlogo1);
    JLabel icon2 = new JLabel();
    ImageIcon resizedIconlogo2 = createResizedIcon("/homepanel/22.PNG", 33,33); // Adjust the path and size
    icon2.setIcon(resizedIconlogo2);
    JLabel icon3 = new JLabel();
    ImageIcon resizedIconlogo3 = createResizedIcon("/homepanel/live_view.png", 26,26); // Adjust the path and size
    icon3.setIcon(resizedIconlogo3);
    JLabel icon4 = new JLabel();
    ImageIcon resizedIconlogo4 = createResizedIcon("/homepanel/23.PNG", 33,33); // Adjust the path and size
    icon4.setIcon(resizedIconlogo4);
    JLabel icon5 = new JLabel();
    ImageIcon resizedIconlogo5 = createResizedIcon("/homepanel/24.PNG", 33,33); // Adjust the path and size
    icon5.setIcon(resizedIconlogo5);
    JLabel icon6 = new JLabel();
    ImageIcon resizedIconlogo6 = createResizedIcon("/homepanel/25.PNG", 30,30); // Adjust the path and size
    icon6.setIcon(resizedIconlogo6);
    JLabel icon7 = new JLabel();
    ImageIcon resizedIconlogo7 = createResizedIcon("/homepanel/26.PNG", 30,30); // Adjust the path and size
    icon7.setIcon(resizedIconlogo7);
    

    // Align label to the left using Alignment.LEADING
    hGrouppanel_generatebill.addGroup(gl_panel_generate_bill.createSequentialGroup()
    		.addGap(20)
            .addComponent(labelgeneratebill, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
            .addGap(485)
            .addComponent(icon1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
            .addComponent(icon2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
            .addGap(2)
            .addComponent(icon3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
            .addComponent(icon4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
            .addComponent(icon5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
            .addComponent(icon6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
            .addComponent(icon7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
            );
    
    vGrouppanel_generatebill.addGap(10)
    		.addGroup(gl_panel_generate_bill.createParallelGroup(Alignment.BASELINE)
        		.addComponent(labelgeneratebill, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        		.addComponent(icon1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(icon2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(icon3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(icon4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(icon5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(icon6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(icon7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
    		);

    gl_panel_generate_bill.setHorizontalGroup(hGrouppanel_generatebill);
    gl_panel_generate_bill.setVerticalGroup(vGrouppanel_generatebill);

}
private void supportcontactfunction() {
	 JLabel icon8 = new JLabel();
     ImageIcon resizedIconlogo8 = createResizedIcon("/homepanel/music.png", 40,40); // Adjust the path and size
     icon8.setIcon(resizedIconlogo8);
     
     JButton supportcontact = new JButton("<html>"
             + "<span style='font-size:12px; color:black;font-weight:plain;'>Call For Support</span><br>"
             + "<span style='font-size:9px; color:#ffafaf; font-weight:bold;'>.</span><span style='font-size:13px; color:#b94759; font-weight:bold;'>  07969 223344</span>"
             + "</html>");
     supportcontact.setHorizontalAlignment(SwingConstants.CENTER);
     supportcontact.setForeground(Color.BLACK); // Overall text color (will be overridden by HTML formatting)
     supportcontact.setBorder(null);  // Remove button border
     supportcontact.setFont(new Font("Arial", Font.PLAIN, 14)); // Default font for unformatted text
     supportcontact.setBackground(new Color(246,218,222)); // Set the background color

     
  // Align label to the left using Alignment.LEADING
     hGrouppanel_supportpanel.addGroup(gl_panel_supportpanel.createSequentialGroup()
     		.addGap(5)
             .addComponent(icon8, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
             .addComponent(supportcontact, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
             );
     
     vGrouppanel_supportpanel.addGap(5)
     		.addGroup(gl_panel_supportpanel.createParallelGroup(Alignment.BASELINE)
//	        		
	        		.addComponent(icon8, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
	        		.addComponent(supportcontact, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
	                
     		);

     gl_panel_supportpanel.setHorizontalGroup(hGrouppanel_supportpanel);
     gl_panel_supportpanel.setVerticalGroup(vGrouppanel_supportpanel);
}
private void radiopanelfunction() {
	 JRadioButton Delivery = new JRadioButton("Delivery");
     Delivery.setBackground(new Color(241,241,241));
     Delivery.setFont(new Font("Arial", Font.PLAIN, 15)); // Default font for unformatted text
     Delivery.setIcon(new CustomRadioButtonIcon());
     Delivery.setSelectedIcon(new CustomRadioButtonIcon(false));
     
     JRadioButton Pickup = new JRadioButton("Pick Up");
     Pickup.setBackground(new Color(241,241,241));
     Pickup.setFont(new Font("Arial", Font.PLAIN, 14)); // Default font for unformatted text
     Pickup.setIcon(new CustomRadioButtonIcon());
     Pickup.setSelectedIcon(new CustomRadioButtonIcon(true));
     
     
     JRadioButton DineIn = new JRadioButton("Dine In");
     DineIn.setBackground(new Color(241,241,241));
     DineIn.setFont(new Font("Arial", Font.PLAIN, 14)); // Default font for unformatted text
     DineIn.setIcon(new CustomRadioButtonIcon());
     DineIn.setSelectedIcon(new CustomRadioButtonIcon(false));
     
     JLabel tableNo = new JLabel("Table No.");
     tableNo.setBackground(new Color(241,241,241));
     tableNo.setFont(new Font("Arial", Font.PLAIN, 14)); // Default font for unformatted text
     
     JLabel kotNo = new JLabel("View Kot");
     kotNo.setBackground(new Color(241,241,241));
     kotNo.setForeground(Color.RED);
     kotNo.setFont(new Font("Arial", Font.PLAIN, 13)); // Default font for unformatted text
     
     JLabel personNo = new JLabel("Persons:");
     personNo.setBackground(new Color(241,241,241));
     personNo.setFont(new Font("Arial", Font.PLAIN, 14)); // Default font for unformatted text
     
     JTextField blankbox = new JTextField("");
     blankbox.setBackground(Color.WHITE);
     blankbox.setFont(new Font("Arial", Font.PLAIN, 14)); // Default font for unformatted text
     blankbox.setBackground(Color.WHITE); // Set background color
     
     
     JTextField blankbox1 = new JTextField("");
     blankbox1.setBackground(Color.WHITE);
     blankbox1.setFont(new Font("Arial", Font.PLAIN, 14)); // Default font for unformatted text
     blankbox1.setBackground(Color.WHITE); // Set background color

	      // Create an array of options for the JComboBox
     String[] options = {"  Dine In"};

     // Create the JComboBox with the options array
     JComboBox<String> comboBox = new JComboBox<>(options);
     comboBox.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font
     comboBox.setBackground(Color.WHITE); // Set background color
     comboBox.setBorder(null);
     
  // Set "Pick Up" as the default selected radio button
     Pickup.setSelected(true);
     comboBox.setVisible(false);
 	tableNo.setVisible(false);
 	blankbox.setVisible(false);
 	blankbox1.setVisible(false);
 	kotNo.setVisible(false);
 	personNo.setVisible(false);
     
     
  
     
  // Adding ActionListeners to each JRadioButton
     Delivery.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
//             System.out.println("Delivery selected");
         	 Delivery.setIcon(new CustomRadioButtonIcon(true));
              Pickup.setIcon(new CustomRadioButtonIcon(false));
              DineIn.setIcon(new CustomRadioButtonIcon(false));
         	comboBox.setVisible(false);
         	tableNo.setVisible(false);
         	blankbox.setVisible(false);
         	blankbox1.setVisible(false);
         	kotNo.setVisible(false);
         	personNo.setVisible(false);
         	
         }
     });

     Pickup.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         	 Delivery.setIcon(new CustomRadioButtonIcon(false));
              Pickup.setIcon(new CustomRadioButtonIcon(true));
              DineIn.setIcon(new CustomRadioButtonIcon(false));
         	comboBox.setVisible(false);
         	tableNo.setVisible(false);
         	blankbox.setVisible(false);
         	blankbox1.setVisible(false);
         	kotNo.setVisible(false);
         	personNo.setVisible(false);
         }
     });

     DineIn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         	 Delivery.setIcon(new CustomRadioButtonIcon(false));
              Pickup.setIcon(new CustomRadioButtonIcon(false));
              DineIn.setIcon(new CustomRadioButtonIcon(true));
         	comboBox.setVisible(true);
         	tableNo.setVisible(true);
         	blankbox.setVisible(true);
         	blankbox1.setVisible(true);
         	kotNo.setVisible(true);
         	personNo.setVisible(true);
         }
     });
 hGrouppanel_radiopanel.addGroup(gl_panel_radiopanel.createSequentialGroup()
         .addGap(15)
         .addComponent(Delivery)
         .addGap(5)
         .addComponent(Pickup)
         .addGap(5)
         .addComponent(DineIn)
         .addGap(5)
         .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
         .addGap(10)
         .addComponent(tableNo, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
         .addComponent(blankbox, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
         .addGap(5)
         .addComponent(kotNo, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
         
         .addComponent(personNo, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
         .addComponent(blankbox1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE));
 
 vGrouppanel_radiopanel.addGap(7)
 	.addGroup(gl_panel_radiopanel.createParallelGroup(Alignment.LEADING)
         .addComponent(Delivery, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
         .addComponent(Pickup, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
         .addComponent(DineIn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
         .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
         .addComponent(tableNo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
         .addComponent(blankbox, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
         .addComponent(kotNo, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
         .addComponent(personNo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
         .addComponent(blankbox1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE));
 
 gl_panel_radiopanel.setHorizontalGroup(hGrouppanel_radiopanel);
 gl_panel_radiopanel.setVerticalGroup(vGrouppanel_radiopanel);
}
private void mobilepanelfunction() {
	JLabel MobileNo = new JLabel("Mobile:");
    MobileNo.setBackground(new Color(241,241,241));
    MobileNo.setFont(new Font("Arial", Font.PLAIN, 14)); // Default font for unformatted text
    
    HintTextField MobileInput = new HintTextField("Enter min. 10 digit no.",10);
    MobileInput.setBackground(Color.WHITE);
    MobileInput.setBorder(new LineBorder(new Color(214,214,214), 1)); // Set red border with thickness of 2
    MobileInput.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Default font for unformatted text
    
    JLabel image1 = new JLabel();
    ImageIcon resizedIconimage1 = createResizedIcon("/homepanel/image1.png", 25,25); // Adjust the path and size
    image1.setIcon(resizedIconimage1);

    JLabel image2 = new JLabel();
    ImageIcon resizedIconimage2 = createResizedIcon("/homepanel/image2.png", 25,25); // Adjust the path and size
    image2.setIcon(resizedIconimage2);
    
    JLabel Namelabel = new JLabel("Name:");
    Namelabel.setBackground(new Color(241,241,241));
    Namelabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Default font for unformatted text
    
    JTextField nameblankbox = new JTextField("");
    nameblankbox.setBackground(Color.WHITE);
    nameblankbox.setBorder(new LineBorder(new Color(222,222,222), 1)); // Set red border with thickness of 2
    nameblankbox.setFont(new Font("Arial", Font.PLAIN, 14)); // Default font for unformatted text
    nameblankbox.setBackground(Color.WHITE); // Set background color
    
    hGrouppanel_mobilepanel.addGroup(gl_panel_mobilepanel.createSequentialGroup()
            .addGap(18)
            .addComponent(MobileNo, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
          
            .addComponent(MobileInput, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
            .addGap(10)
            .addComponent(image1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
            .addGap(5)
            .addComponent(image2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
           
            .addGap(10)
            .addComponent(Namelabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
            .addComponent(nameblankbox, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
            );
    
    vGrouppanel_mobilepanel.addGap(7)
    	.addGroup(gl_panel_mobilepanel.createParallelGroup(Alignment.LEADING)
            .addComponent(MobileNo, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            .addComponent(MobileInput, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            .addComponent(image1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
            .addComponent(image2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
            .addComponent(Namelabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            .addComponent(nameblankbox, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
           );
    
    gl_panel_mobilepanel.setHorizontalGroup(hGrouppanel_mobilepanel);
    gl_panel_mobilepanel.setVerticalGroup(vGrouppanel_mobilepanel);
}
private void addresspanelfunction() {
	JLabel address = new JLabel("Add:");
    address.setBackground(new Color(241,241,241));
    address.setFont(new Font("Arial", Font.PLAIN, 14)); // Default font for unformatted text
    
    HintTextField addressInput = new HintTextField("Enter address",10);
    addressInput.setBackground(Color.WHITE);
    addressInput.setBorder(new LineBorder(new Color(229,229,229), 1)); // Set red border with thickness of 2
    addressInput.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Default font for unformatted text
    
    HintTextField locality = new HintTextField("Enter locality",10);
    locality.setBackground(Color.WHITE);
    locality.setBorder(new LineBorder(new Color(224,224,224), 1)); // Set red border with thickness of 2
    locality.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Default font for unformatted text
    
    hGrouppanel_addresspanel.addGroup(gl_panel_addresspanel.createSequentialGroup()
            .addGap(18)
            .addComponent(address, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
          
            .addComponent(addressInput, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
            .addGap(14)
            .addComponent(locality, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
            
            );
    
    vGrouppanel_addresspanel.addGap(10)
    	.addGroup(gl_panel_addresspanel.createParallelGroup(Alignment.LEADING)
            .addComponent(address, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            .addComponent(addressInput, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            .addComponent(locality, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            
           );
    
    gl_panel_addresspanel.setHorizontalGroup(hGrouppanel_addresspanel);
    gl_panel_addresspanel.setVerticalGroup(vGrouppanel_addresspanel);
}
private void itembar() {
    itemname = new HintTextField("Item", 10);
    itemname.setBackground(Color.WHITE);
    itemname.setFont(new Font("Tahoma", Font.PLAIN, 14));

    itemname.setBorder(new LineBorder(new Color(219,219,219), 1)); // Set red border with thickness of 2
    popupMenu = new JPopupMenu();
    popupMenu.setFocusable(false); // Prevent popup from taking focus

    // Initialize the table model and table for the popup (without header)
    DefaultTableModel tableModel = new DefaultTableModel(0, 1) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Disable cell editing
        }
    };
    JTable table = new JTable(tableModel);
    table.setTableHeader(null); // Remove table header
    table.setFocusable(false);
    table.setBackground(Color.WHITE);
    table.setRowSelectionAllowed(true);
    table.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
    table.setRowHeight(30);
    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    table.setSelectionBackground(Color.LIGHT_GRAY);
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
    scrollPane.setPreferredSize(new Dimension(200, 150)); // Set preferred size of the table
    popupMenu.add(scrollPane);

    // Current index to keep track of selected item
//    int currentIndex = -1;

    HintTextField specialnote = new HintTextField("Special Note", 10);
    specialnote.setBackground(Color.WHITE);
    specialnote.setBorder(null);
    specialnote.setFont(new Font("Tahoma", Font.PLAIN, 14));

    HintTextField qtyfield = new HintTextField("", 10);
    qtyfield.setBackground(Color.WHITE);
    qtyfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
    qtyfield.setBorder(new LineBorder(new Color(205,205,205), 1)); // Set red border with thickness of 2
    

    pricefield = new RoundLabel("", 6);
    pricefield.setBackground(new Color(233,236,239));
    pricefield.setFont(new Font("Arial", Font.PLAIN, 14));
    pricefield.setBorder(new LineBorder(new Color(215,216,218), 1)); // Set red border with thickness of 2

    amountfield = new RoundLabel("", 6);
    amountfield.setBorder(new LineBorder(new Color(215,216,218), 1)); // Set red border with thickness of 2
    amountfield.setBackground(new Color(233,236,239));
    amountfield.setFont(new Font("Arial", Font.PLAIN, 14));

    itemname.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent e) {
            String filter = itemname.getText().toLowerCase(); // Get the filter text

            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                // Handle Enter key press
            	// Check if itemname is empty
                if (itemname.getText().trim().isEmpty()) {
                    // If itemname is empty, stay in itemname field and show a message or keep focus
                    itemname.requestFocus();
                    return; // Don't proceed further
                }
                if (popupMenu.isVisible() && currentIndex != -1) {
                    int row = table.getSelectedRow();
                    if (row != -1) {
                        String selectedItem = (String) table.getValueAt(row, 0);
                        itemname.setText(selectedItem);
                        selecteditem = selectedItem;
                        qtyfield.setText("1");

                        int index = itemList.indexOf(selectedItem);
                        if (index != -1) {
                            selectedPrice = priceList.get(index);
                            if (itemListpanel.contains(selecteditem)) {
                                updateTableListDataDOSA(Double.parseDouble(selectedPrice), selecteditem);
                            } else {
                            	Double P= Double.parseDouble(selectedPrice);
                            	String PRI = String.format("%.2f", P);
                            	
                                pricefield.setText(PRI);
                                amountfield.setText(PRI);
                            }
                        } else {
                            selectedPrice = null;
                        }
                        popupMenu.setVisible(false);
                        qtyfield.requestFocus();
                    }
                } else {
                    qtyfield.requestFocus(); // Proceed to next field when popup is not open
                }
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP) {
                // Handle arrow key navigation in the table
                if (popupMenu.isVisible()) {
                    int rowCount = table.getRowCount();
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        currentIndex = (currentIndex + 1) % rowCount;
                    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                        currentIndex = (currentIndex - 1 + rowCount) % rowCount;
                    }
                    table.setRowSelectionInterval(currentIndex, currentIndex);
                    // Make sure the selected row is visible (auto-scroll)
                    table.scrollRectToVisible(table.getCellRect(currentIndex, 0, true)); 
                }
            } else {
                // Handle typing and filtering the table items
                tableModel.setRowCount(0); // Clear the table model
                currentIndex = -1;

                // Filter the itemList based on the typed text
                for (String item : itemList) {
                    if (item.toLowerCase().contains(filter) && !filter.isEmpty()) {
                        tableModel.addRow(new Object[]{item});
                    }
                }

                // Display popup if items are present
                if (tableModel.getRowCount() > 0) {
                    popupMenu.show(itemname, 0, itemname.getHeight());
                    popupMenu.setPopupSize(itemname.getWidth(), Math.min(tableModel.getRowCount() * 30, 300));
                    currentIndex = 0; // Reset index to the first item after filtering
                    table.setRowSelectionInterval(currentIndex, currentIndex);
                } else {
                    popupMenu.setVisible(false);
                }
            }
        }
    });

    qtyfield.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            String qty = qtyfield.getText().trim();

            // Set default value if qty is empty and user presses Enter
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (qty.isEmpty()) {
                    qty = "1";
                    qtyfield.setText(qty);
                }

                double quantity;
                double price;
                try {
                    quantity = Double.parseDouble(qty);
                    price = Double.parseDouble(selectedPrice);
                    amountfield.setText(String.format("%.2f", price * quantity));

                    System.out.println("Item: " + itemname.getText() + ", Quantity: " + qty);

                    if (selectedPrice == null || selectedPrice.isEmpty()) {
                        System.out.println("Selected price is not set.");
                        amountfield.setText("");
                        return;
                    }

                    addNewItemRow(selecteditem, "", qty, selectedPrice, String.format("%.2f", price * quantity));
                    itemname.requestFocus();
                    selecteditem = "";
                    selectedPrice = "";
                    itemname.setText("");
                    pricefield.setText("");
                    qtyfield.setText("");
                    amountfield.setText("");

                    refreshpage();
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid number format: " + ex.getMessage());
                }
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // Clear the field if any key is pressed and the field is set to default value
            if (qtyfield.getText().equals("1")) {
                qtyfield.setText("");
            }
        }
    });


    hGrouppanel_itembar.addGroup(gl_panel_itembar.createSequentialGroup()
        .addGap(2)
        .addComponent(itemname, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
        .addComponent(specialnote, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
        .addComponent(qtyfield, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
        .addComponent(pricefield, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
        .addComponent(amountfield, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
    );

    vGrouppanel_itembar.addGap(10)
        .addGroup(gl_panel_itembar.createParallelGroup(Alignment.LEADING)
            .addComponent(itemname, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            .addComponent(specialnote, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            .addComponent(qtyfield, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            .addComponent(pricefield, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            .addComponent(amountfield, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        );

    gl_panel_itembar.setHorizontalGroup(hGrouppanel_itembar);
    gl_panel_itembar.setVerticalGroup(vGrouppanel_itembar);
}


private static void updateTableListDataDOSA(Double Rate, Object selectedValue) {
	
    // Create the dialog without a window header
    JDialog dialog = new JDialog((Frame) null, "Popup", Dialog.ModalityType.APPLICATION_MODAL);
    dialog.setUndecorated(true);  // Removes the window header
    dialog.setSize(700, 350);
    dialog.getContentPane().setLayout(new BorderLayout());

    // Main panel with GroupLayout
    JPanel mainPanel = new JPanel();
    mainPanel.setBackground(Color.WHITE);
    mainPanel.setBorder(new LineBorder(Color.BLACK, 1, true));

    
    dialog.getContentPane().add(mainPanel);
    
    JButton regularbutton = new JButton(String.format("<html>Regular<br>₹%d</html>", Math.round(Rate+(Rate*0.05))));
    JButton butterbutton = new JButton(String.format("<html>Butter<br>₹%d</html>",  Math.round((Rate+butter)+((Rate+butter)*0.05))));
    JButton cheesebutton = new JButton(String.format("<html>Cheese<br>₹%d</html>",  Math.round((Rate+cheese)+((Rate+cheese)*0.05))));
    JButton gheebutton = new JButton(String.format("<html>Ghee<br>₹%d</html>", Math.round((Rate+ghee)+((Rate+ghee)*0.05))));
    JLabel pricelabel = new JLabel();
//  pricelabel.setBorder(new LineBorder(new Color(128,128,255)));
    regularbutton.setOpaque(true);
    regularbutton.setBackground(UIManager.getColor("Button.background"));
    regularbutton.setHorizontalAlignment(SwingConstants.CENTER);
    regularbutton.setFont(new Font("Century Gothic", Font.BOLD, 12));
    regularbutton.setBorder(new LineBorder(SystemColor.activeCaption));
 // Add a MouseListener to the label
    regularbutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Change the background color to red when clicked
        	butterbutton.setBackground(UIManager.getColor("Button.background"));
        	butterbutton.setForeground(Color.BLACK);
        	regularbutton.setBackground(Color.RED);
        	regularbutton.setForeground(Color.WHITE);
        	cheesebutton.setBackground(UIManager.getColor("Button.background"));
        	cheesebutton.setForeground(Color.BLACK);
        	gheebutton.setBackground(UIManager.getColor("Button.background"));
        	gheebutton.setForeground(Color.BLACK);
        	Sselectedbutton = "Regular";
        	pricelabel.setText("₹"+Math.round(Rate+(Rate*0.05)));
        }
    });
    
//    DEFAULT BUTTON COLOR AND BG
    regularbutton.setBackground(Color.RED);
	regularbutton.setForeground(Color.WHITE);
	Sselectedbutton = "Regular";
	pricelabel.setText("₹"+Math.round(Rate+(Rate*0.05)));
    
    butterbutton.setOpaque(true);
    butterbutton.setBackground(UIManager.getColor("Button.background"));
    butterbutton.setFont(new Font("Century Gothic", Font.BOLD, 12));
    butterbutton.setHorizontalAlignment(SwingConstants.CENTER);
    butterbutton.setBorder(new LineBorder(SystemColor.activeCaption));
 // Add a MouseListener to the label
    butterbutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Change the background color to red when clicked
        	butterbutton.setBackground(Color.RED);
        	butterbutton.setForeground(Color.WHITE);
        	regularbutton.setBackground(UIManager.getColor("Button.background"));
        	regularbutton.setForeground(Color.BLACK);
        	cheesebutton.setBackground(UIManager.getColor("Button.background"));
        	cheesebutton.setForeground(Color.BLACK);
        	gheebutton.setBackground(UIManager.getColor("Button.background"));
        	gheebutton.setForeground(Color.BLACK);
        	Sselectedbutton = "Butter";
        	pricelabel.setText("₹"+Math.round((Rate+butter)+((Rate+butter)*0.05)));
        }
    });

    
   
    cheesebutton.setOpaque(true);
    cheesebutton.setBackground(UIManager.getColor("Button.background"));
    cheesebutton.setFont(new Font("Century Gothic", Font.BOLD, 12));
    cheesebutton.setHorizontalAlignment(SwingConstants.CENTER);
    cheesebutton.setBorder(new LineBorder(SystemColor.activeCaption));
 // Add a MouseListener to the label
    cheesebutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Change the background color to red when clicked
        	butterbutton.setBackground(UIManager.getColor("Button.background"));
        	butterbutton.setForeground(Color.BLACK);
        	regularbutton.setBackground(UIManager.getColor("Button.background"));
        	regularbutton.setForeground(Color.BLACK);
        	cheesebutton.setBackground(Color.RED);
        	cheesebutton.setForeground(Color.WHITE);
        	gheebutton.setBackground(UIManager.getColor("Button.background"));
        	gheebutton.setForeground(Color.BLACK);
        	Sselectedbutton = "Cheese";
        	pricelabel.setText("₹"+Math.round((Rate+cheese)+((Rate+cheese)*0.05)));
        }
    });
    
    
    gheebutton.setOpaque(true);
    gheebutton.setBackground(UIManager.getColor("Button.background"));
    gheebutton.setFont(new Font("Century Gothic", Font.BOLD, 12));
    gheebutton.setHorizontalAlignment(SwingConstants.CENTER);
    gheebutton.setBorder(new LineBorder(SystemColor.activeCaption));
 // Add a MouseListener to the label
    gheebutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Change the background color to red when clicked
        	butterbutton.setBackground(UIManager.getColor("Button.background"));
        	butterbutton.setForeground(Color.BLACK);
        	regularbutton.setBackground(UIManager.getColor("Button.background"));
        	regularbutton.setForeground(Color.BLACK);
        	cheesebutton.setBackground(UIManager.getColor("Button.background"));
        	cheesebutton.setForeground(Color.BLACK);
        	gheebutton.setBackground(Color.RED);
        	gheebutton.setForeground(Color.WHITE);
        	Sselectedbutton = "Ghee";
        	pricelabel.setText("₹"+Math.round((Rate+ghee)+((Rate+ghee)*0.05)));
        }
    });
    
 // Key listener to handle left-right navigation and trigger button actions
    KeyAdapter arrowKeyListener = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                // Navigate to the left button and perform click
                if (e.getSource() == butterbutton) {
                    regularbutton.requestFocus();
                    regularbutton.doClick();  // Trigger regularbutton action
                } else if (e.getSource() == cheesebutton) {
                    butterbutton.requestFocus();
                    butterbutton.doClick();  // Trigger butterbutton action
                } else if (e.getSource() == gheebutton) {
                    cheesebutton.requestFocus();
                    cheesebutton.doClick();  // Trigger cheesebutton action
                } else if (e.getSource() == regularbutton) {
                    gheebutton.requestFocus();
                    gheebutton.doClick();  // Trigger gheebutton action
                }
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                // Navigate to the right button and perform click
                if (e.getSource() == regularbutton) {
                    butterbutton.requestFocus();
                    butterbutton.doClick();  // Trigger butterbutton action
                } else if (e.getSource() == butterbutton) {
                    cheesebutton.requestFocus();
                    cheesebutton.doClick();  // Trigger cheesebutton action
                } else if (e.getSource() == cheesebutton) {
                    gheebutton.requestFocus();
                    gheebutton.doClick();  // Trigger gheebutton action
                } else if (e.getSource() == gheebutton) {
                    regularbutton.requestFocus();
                    regularbutton.doClick();  // Trigger regularbutton action
                }
            }
        }
    };

    // Attach the updated key listener to each button
    regularbutton.addKeyListener(arrowKeyListener);
    butterbutton.addKeyListener(arrowKeyListener);
    cheesebutton.addKeyListener(arrowKeyListener);
    gheebutton.addKeyListener(arrowKeyListener);


    // Make buttons focusable
    regularbutton.setFocusable(true);
    butterbutton.setFocusable(true);
    cheesebutton.setFocusable(true);
    gheebutton.setFocusable(true);

    // Ensure the first button gets focus when dialog opens
    regularbutton.requestFocus();

    
    

    JButton cancelbutton = new JButton("Cancel");
    cancelbutton.setOpaque(true);
    cancelbutton.setBackground(Color.WHITE);
    cancelbutton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          dialog.dispose();
        }
    });

    JButton savebutton = new JButton("Save");
    savebutton.setOpaque(true);
    savebutton.setBackground(Color.RED);
    savebutton.setForeground(Color.WHITE);
    savebutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
//          dialog.dispose();
        	String item = null;
        	Double Price = 0.00;
        	System.out.println("selected button :" + Sselectedbutton);
        	if(Sselectedbutton.equals("Regular")) {
        		item = selectedValue.toString()+" .Regular";
        		Price = Rate;
        	}
        	if(Sselectedbutton.equals("Cheese")) {
        		item = selectedValue.toString()+" .Cheese";
        		Price = Rate+cheese;
        	}
        	if(Sselectedbutton.equals("Butter")) {
        		item = selectedValue.toString()+" .Butter";
        		Price = Rate+butter;
        	}
        	if(Sselectedbutton.equals("Ghee")) {
        		item = selectedValue.toString()+" .Ghee";
        		Price = Rate+ghee;
        	}
        	pricefield.setText(String.format("%.2f", Price));
        	selectedPrice=String.format("%.2f", Price);
        	selecteditem = item;
        	dialog.setVisible(false);
            
        }
    });
    
 
 // Assuming you have a button named saveButton
    savebutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "performSaveClick");
    savebutton.getActionMap().put("performSaveClick", new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            savebutton.doClick(); // Simulate a button click when Enter is pressed
        }
    });

    JLabel itemnamelabel = new JLabel(selectedValue.toString());
    itemnamelabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));

    JLabel variationlabel = new JLabel("Variation");
    variationlabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
    
    
    
    JLabel lblNewLabel_1 = new JLabel("X");
    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_1.setFont(new Font("Calibri Light", Font.PLAIN, 22));
    lblNewLabel_1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          dialog.dispose();
        }
    });
    
    JSeparator separator = new JSeparator();
    JSeparator separator1 = new JSeparator();
    
    GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
    gl_mainPanel.setHorizontalGroup(
    	    gl_mainPanel.createParallelGroup(Alignment.LEADING)
    	        .addGroup(gl_mainPanel.createSequentialGroup()
    	            .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
    	                .addGroup(gl_mainPanel.createSequentialGroup()
    	                    .addGap(20)
    	                    .addComponent(itemnamelabel, GroupLayout.PREFERRED_SIZE, 640, GroupLayout.PREFERRED_SIZE)
    	                    .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
    	                .addComponent(separator)
    	                .addGroup(gl_mainPanel.createSequentialGroup()
        	                    .addGap(20)
    	                .addComponent(variationlabel) ) // Adding variationlabel in the horizontal 
    	                .addGroup(gl_mainPanel.createSequentialGroup()
        	                    .addGap(35)
        	                    .addComponent(regularbutton, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
    	                		.addComponent(butterbutton, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
    	                		.addComponent(cheesebutton, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
    	                .addGroup(gl_mainPanel.createSequentialGroup()
        	                    .addGap(35)
        	                    .addComponent(gheebutton, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
    	                .addGroup(gl_mainPanel.createSequentialGroup()
        	                    .addComponent(separator1))
    	                .addGroup(gl_mainPanel.createSequentialGroup()
        	                    .addGap(15)
        	                    .addComponent(pricelabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        	                    .addGap(120)
        	                    .addGap(70)
        	                    .addGap(150)
        	                   
    	                		.addComponent(cancelbutton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    	                		.addGap(3)
    	                		.addComponent(savebutton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
    	            )
    	        )
    	);

    	gl_mainPanel.setVerticalGroup(
    	    gl_mainPanel.createParallelGroup(Alignment.LEADING)
    	        .addGroup(gl_mainPanel.createSequentialGroup()
    	            .addGap(25)
    	            .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
    	                .addComponent(itemnamelabel)
    	                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
    	            .addGap(20)
    	            .addComponent(separator)
    	            .addGap(5)  // Add some space between separator and variationlabel (optional)
    	            .addComponent(variationlabel)  // Adding variationlabel below separator
    	            .addGap(10)
    	            .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
    	            		.addComponent(regularbutton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
	                		.addComponent(butterbutton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
	                		.addComponent(cheesebutton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
    	            .addGap(3)
    	            .addComponent(gheebutton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
    	            .addGap(40)
    	            .addComponent(separator1)
//    	            .addGap(10)
    	            .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
    	            		
    	            		.addComponent(pricelabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                		.addComponent(cancelbutton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                		.addComponent(savebutton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
    	        )
    	);

    mainPanel.setLayout(gl_mainPanel);

    // ESC key to close dialog
    KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    
    dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
    dialog.getRootPane().getActionMap().put("ESCAPE", new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            dialog.dispose();
        }
    });

    // Display the dialog
    dialog.setLocationRelativeTo(null);
    dialog.setVisible(true);
}

////Method to handle arrow keys and Enter key for selection
//private static void navigatePopup(KeyEvent e, JPopupMenu popupMenu, JTextField textField) {
//    int itemCount = popupMenu.getComponentCount();
//
//    // Handle "DOWN" key press
//    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//        if (itemCount > 0) {
//            currentIndex = (currentIndex + 1) % itemCount; // Move to next item
//            highlightMenuItem(popupMenu, currentIndex);
//        }
//    }
//
//    // Handle "UP" key press
//    if (e.getKeyCode() == KeyEvent.VK_UP) {
//        if (itemCount > 0) {
//            currentIndex = (currentIndex - 1 + itemCount) % itemCount; // Move to previous item
//            highlightMenuItem(popupMenu, currentIndex);
//        }
//    }
//
//    // Handle "ENTER" key press
//    if (e.getKeyCode() == KeyEvent.VK_ENTER && currentIndex != -1) {
//        JMenuItem selectedItem = (JMenuItem) popupMenu.getComponent(currentIndex);
//        textField.setText(selectedItem.getText()); // Set the selected item in the text field
//        popupMenu.setVisible(false); // Close the popup
//    }
//}

//Method to handle arrow key navigation in the popup menu
private void navigatePopup(KeyEvent e, JPopupMenu popupMenu) {
 int itemCount = popupMenu.getComponentCount();

 if (itemCount > 0) {
     if (e.getKeyCode() == KeyEvent.VK_DOWN) {
         // Navigate down in the popup menu
         currentIndex = (currentIndex + 1) % itemCount; // Circular navigation
     } else if (e.getKeyCode() == KeyEvent.VK_UP) {
         // Navigate up in the popup menu
         currentIndex = (currentIndex - 1 + itemCount) % itemCount; // Circular navigation
     }

     // Highlight the current menu item
     highlightMenuItem(popupMenu, currentIndex);
 }
}

//Method to highlight the selected menu item
private void highlightMenuItem(JPopupMenu popupMenu, int index) {
 int itemCount = popupMenu.getComponentCount();

 for (int i = 0; i < itemCount; i++) {
     JMenuItem menuItem = (JMenuItem) popupMenu.getComponent(i);
     menuItem.setArmed(i == index); // Highlight the currently selected item
 }
}
//
//// Method to highlight a menu item at a given index
//private static void highlightMenuItem(JPopupMenu popupMenu, int index) {
//    for (int i = 0; i < popupMenu.getComponentCount(); i++) {
//        JMenuItem item = (JMenuItem) popupMenu.getComponent(i);
//        item.setBackground(i == index ? Color.LIGHT_GRAY : Color.WHITE); // Highlight the selected item
//    }
//}
private void subtotalpanel() {
	JLabel totslqty_subtotalpanel = new JLabel("Total Qty.");
	totslqty_subtotalpanel.setBackground(new Color(241,241,241));	
	totslqty_subtotalpanel.setOpaque(true);
	
	totslqty_subtotalpanel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Default font for unformatted text
	
	JLabel totslqty_subtotalpanel1 = new JLabel("");
	totslqty_subtotalpanel1.setBorder(BorderFactory.createLineBorder(new Color(210,210,210), 1)); 
	JLabel totslqty_subtotalpanel2 = new JLabel("");
	totslqty_subtotalpanel2.setBorder(BorderFactory.createLineBorder(new Color(210,210,210), 1)); 
	JLabel totslqty_subtotalpanel3 = new JLabel("");
	totslqty_subtotalpanel3.setBorder(BorderFactory.createLineBorder(new Color(210,210,210), 1)); 
	
	totslqtyvalue_subtotalpanel = new JLabel("0 ");
	totslqtyvalue_subtotalpanel.setBorder(null); 
	totslqtyvalue_subtotalpanel.setBackground(new Color(241,241,241));

	totslqtyvalue_subtotalpanel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Default font for unformatted text
	totslqtyvalue_subtotalpanel.setHorizontalAlignment(SwingConstants.RIGHT); // Align text to the left
	totslqtyvalue_subtotalpanel.setOpaque(true);
	
	JLabel subtotalheader_subtotalpanel = new JLabel(" Sub Total");
	subtotalheader_subtotalpanel.setBackground(new Color(241,241,241));
	subtotalheader_subtotalpanel.setBorder(null); 
	subtotalheader_subtotalpanel.setOpaque(true);
	subtotalheader_subtotalpanel.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text
	
	subtotalheadervalue_subtotalpanel = new JLabel("0.00 ");
	subtotalheadervalue_subtotalpanel.setBackground(new Color(241,241,241));
	subtotalheadervalue_subtotalpanel.setBorder(null);  
	subtotalheadervalue_subtotalpanel.setHorizontalAlignment(SwingConstants.RIGHT);
	subtotalheadervalue_subtotalpanel.setOpaque(true);
	subtotalheadervalue_subtotalpanel.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text
	
	hGrouppanel_subtotalpanel.addGroup(gl_panel_subtotalpanel.createSequentialGroup()
            .addGap(770)
            .addComponent(totslqty_subtotalpanel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
            .addComponent(totslqty_subtotalpanel1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)          
            .addComponent(totslqtyvalue_subtotalpanel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
            .addComponent(totslqty_subtotalpanel2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            .addComponent(subtotalheader_subtotalpanel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
            .addComponent(totslqty_subtotalpanel3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            .addComponent(subtotalheadervalue_subtotalpanel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
            );
    
    vGrouppanel_subtotalpanel
    	.addGroup(gl_panel_subtotalpanel.createParallelGroup(Alignment.LEADING)
    			.addComponent(totslqty_subtotalpanel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
    			.addComponent(totslqty_subtotalpanel1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(totslqtyvalue_subtotalpanel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(totslqty_subtotalpanel2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(subtotalheader_subtotalpanel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(totslqty_subtotalpanel3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(subtotalheadervalue_subtotalpanel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
            
           );
    
    gl_panel_subtotalpanel.setHorizontalGroup(hGrouppanel_subtotalpanel);
    gl_panel_subtotalpanel.setVerticalGroup(vGrouppanel_subtotalpanel);
	
}
private void appliedDiscountspanel() {
	JLabel plusicon = new JLabel("+");
	plusicon.setBackground(new Color(242,247,248));
	plusicon.setOpaque(true);
	plusicon.setFont(new Font("Tahoma", Font.BOLD, 18)); // Default font for unformatted text
	plusicon.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        	if(discclick) {
        		discPanel.setVisible(false);
        		discclick=false;
        	}
        	else {
        		discPanel.setVisible(true);
        		discclick=true;
        	}
        	
        }
    });
	
	JLabel applieddisc = new JLabel("Applied Discounts");
	applieddisc.setBackground(new Color(242,247,248));

	applieddisc.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text
	applieddisc.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left
	applieddisc.setOpaque(true);
	applieddisc.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseClicked(java.awt.event.MouseEvent evt) {
        	if(discclick) {
        		discPanel.setVisible(false);
        		discclick=false;
        	}
        	else {
        		discPanel.setVisible(true);
        		discclick=true;
        	}
        	
        }
    });
	
	
	JLabel applied_showdetails = new JLabel("<html><u>(Show Detail)</u></html>");
	applied_showdetails.setBackground(new Color(242,247,248)); 
	applied_showdetails.setOpaque(true);
	applied_showdetails.setFont(new Font("Tahoma", Font.PLAIN, 12)); // Default font for unformatted text
	applied_showdetails.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseClicked(java.awt.event.MouseEvent evt) {
        	if(discclick) {
        		discPanel.setVisible(false);
        		discclick=false;
        	}
        	else {
        		discPanel.setVisible(true);
        		discclick=true;
        	}
        	
        }
    });
	
	
	JLabel discountvalue = new JLabel("(0.00)");
	discountvalue.setBackground(new Color(242,247,248));
	discountvalue.setHorizontalAlignment(SwingConstants.RIGHT);
	discountvalue.setOpaque(true);
	discountvalue.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Default font for unformatted text
	
	hGrouppanel_appliedDiscounts.addGroup(gl_panel_appliedDiscounts.createSequentialGroup()
            .addGap(10)
            .addComponent(plusicon, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
          
            .addComponent(applieddisc, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
            
            .addComponent(applied_showdetails, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
            .addComponent(discountvalue, GroupLayout.PREFERRED_SIZE, 865, GroupLayout.PREFERRED_SIZE)
            );
    
    vGrouppanel_appliedDiscounts
    	.addGroup(gl_panel_appliedDiscounts.createParallelGroup(Alignment.LEADING)
    			.addComponent(plusicon, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addComponent(applieddisc, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addComponent(applied_showdetails, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addComponent(discountvalue, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            
           );
    
    gl_panel_appliedDiscounts.setHorizontalGroup(hGrouppanel_appliedDiscounts);
    gl_panel_appliedDiscounts.setVerticalGroup(vGrouppanel_appliedDiscounts);
	
}
private void totalPanelcomponents() {
	JLabel Totalheading = new JLabel("Total(₹) ");
	Totalheading.setBackground(new Color(241,241,241));
	Totalheading.setHorizontalAlignment(SwingConstants.RIGHT);
	Totalheading.setOpaque(true);
	Totalheading.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text

	JLabel b1= new JLabel();
	b1.setBorder(new LineBorder(new Color(217,217,217), 1, true));
	
	TotalValue = new JLabel("0.00");
	TotalValue.setBackground(new Color(241,241,241));
	TotalValue.setHorizontalAlignment(SwingConstants.RIGHT);
	TotalValue.setOpaque(true);
	TotalValue.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text
	

	hGrouppanel_totalpanel.addGroup(gl_panel_totalpanel.createSequentialGroup()
            .addGap(909)
            .addComponent(Totalheading, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
            .addComponent(b1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)          
            .addComponent(TotalValue, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
            );
    
    vGrouppanel_totalpanel
    	.addGroup(gl_panel_totalpanel.createParallelGroup(Alignment.LEADING)
    			.addComponent(Totalheading, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
    			.addComponent(b1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addComponent(TotalValue, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                
            
           );
    
    gl_panel_totalpanel.setHorizontalGroup(hGrouppanel_totalpanel);
    gl_panel_totalpanel.setVerticalGroup(vGrouppanel_totalpanel);
	
}
private void DeliveryChargecomponents() {
	JLabel DeliveryChargeHeading = new JLabel("Delivery Charge ");
	DeliveryChargeHeading.setBackground(new Color(241,241,241));
	DeliveryChargeHeading.setHorizontalAlignment(SwingConstants.RIGHT);
	DeliveryChargeHeading.setOpaque(true);
//	DeliveryChargeHeading.setBorder(new LineBorder(Color.GRAY, 1, true));
	DeliveryChargeHeading.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Default font for unformatted text

	JLabel b1= new JLabel();
	b1.setBorder(new LineBorder(new Color(217,217,217), 1, true));
	
	
	HintTextField DeliveryChargevalue = new HintTextField("0",10);
	DeliveryChargevalue.setBackground(Color.white);
	DeliveryChargevalue.setHorizontalAlignment(SwingConstants.LEFT);
	DeliveryChargevalue.setBorder(new LineBorder(new Color(215,215,215), 1, true));
//	DeliveryChargevalue.setHorizontalAlignment(SwingConstants.CENTER); // Align text to the left
	DeliveryChargevalue.setOpaque(true);
	DeliveryChargevalue.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text
	

	hGrouppanel_DeliveryCharge.addGroup(gl_panel_DeliveryCharge.createSequentialGroup()
          
            .addComponent(DeliveryChargeHeading, GroupLayout.PREFERRED_SIZE, 977, GroupLayout.PREFERRED_SIZE)
            .addComponent(b1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)  
            .addGap(4)
            .addComponent(DeliveryChargevalue, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
            );
    
    vGrouppanel_DeliveryCharge
    	.addGroup(gl_panel_DeliveryCharge.createParallelGroup(Alignment.CENTER)
    			.addComponent(DeliveryChargeHeading, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
    			.addComponent(b1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)  
                .addComponent(DeliveryChargevalue, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                
            
           );
    
    gl_panel_DeliveryCharge.setHorizontalGroup(hGrouppanel_DeliveryCharge);
    gl_panel_DeliveryCharge.setVerticalGroup(vGrouppanel_DeliveryCharge);
	
}

private void Dissccomponents() { 
	
	RoundButton1 addbutton = new RoundButton1("Add");
	addbutton.setBorder(null);
	addbutton.setBackground(new Color(203,210,203));
	addbutton.setFont(new Font("Arial", Font.BOLD, 14));
	addbutton.setForeground(Color.BLACK); // Set the text color
	addbutton.addActionListener(e -> {
//		clearPanel();
		          // Redraw the panel
	
	});
	
	JLabel discHeading = new JLabel("Discount: ");
	discHeading.setBackground(new Color(224,228,224));
	discHeading.setHorizontalAlignment(SwingConstants.RIGHT);
	discHeading.setOpaque(true);
//	discHeading.setBorder(new LineBorder(Color.GRAY, 1, true));
	discHeading.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text

	JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Percentage");
	rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	rdbtnNewRadioButton_2.setForeground(Color.DARK_GRAY);
	rdbtnNewRadioButton_2.setSelected(true);
	 // Adding ActionListener to radioButton1
	
	JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Fixed");
	rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
	rdbtnNewRadioButton_3.setForeground(Color.DARK_GRAY);
	
	rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (rdbtnNewRadioButton_2.isSelected()) {
                System.out.println("Option 1 selected");
                rdbtnNewRadioButton_2.setSelected(true);
                rdbtnNewRadioButton_3.setSelected(false);
                selectedDiscountType="P";
            }
        }
    });
	rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (rdbtnNewRadioButton_2.isSelected()) {
                System.out.println("Option 2 selected");
                rdbtnNewRadioButton_2.setSelected(false);
                rdbtnNewRadioButton_3.setSelected(true);
                selectedDiscountType="F";
            }
        }
    });
	
	HintTextField1 reasonvalue = new HintTextField1("Reason",10);
	reasonvalue.setBackground(Color.white);
	reasonvalue.setHorizontalAlignment(SwingConstants.LEFT);
//	DeliveryChargevalue.setHorizontalAlignment(SwingConstants.CENTER); // Align text to the left
	reasonvalue.setOpaque(true);
	reasonvalue.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text
	
	discvalue = new HintTextField("",10);
	discvalue.setBackground(Color.white);
	discvalue.setHorizontalAlignment(SwingConstants.LEFT);
//	DeliveryChargevalue.setHorizontalAlignment(SwingConstants.CENTER); // Align text to the left
	discvalue.setOpaque(true);
	discvalue.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text
	// Adding KeyListener to discvalue for simple text listening
    discvalue.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent e) {
        	
        	updateSubtotal();
        }
    });
	
	
	applied_discval = new JLabel("0.00");
//	applied_showdetails.setBackground(new Color(242,247,248));
	applied_discval.setHorizontalAlignment(SwingConstants.CENTER); 
	applied_discval.setOpaque(true);
	applied_discval.setFont(new Font("Tahoma", Font.PLAIN, 12)); // Default font for unformatted text
	applied_discval.setBorder(new LineBorder(Color.GRAY, 1, true));
	

	hGrouppanel_discPanel.addGroup(gl_discPanel.createSequentialGroup()
          .addGap(420)
            .addComponent(addbutton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
            .addGap(2)
            .addComponent(discHeading, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
            .addComponent(rdbtnNewRadioButton_2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
            .addComponent(rdbtnNewRadioButton_3, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
            .addComponent(reasonvalue, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
            .addGap(6)
            .addComponent(discvalue, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE).addGap(3)
            .addComponent(applied_discval, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
            
            );
    
    vGrouppanel_discPanel.addGap(5)
    	.addGroup(gl_discPanel.createParallelGroup(Alignment.CENTER)
    			
    			.addComponent(addbutton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addComponent(discHeading, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addComponent(rdbtnNewRadioButton_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addComponent(rdbtnNewRadioButton_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addComponent(reasonvalue, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addComponent(discvalue, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addComponent(applied_discval, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                
            
           );
    
    gl_discPanel.setHorizontalGroup(hGrouppanel_discPanel);
    gl_discPanel.setVerticalGroup(vGrouppanel_discPanel);
	
}

private void ContainerChargecomponents() {
	JLabel ContainerChargeHeading = new JLabel("Container Charge ");
	ContainerChargeHeading.setBackground(new Color(241,241,241));
	ContainerChargeHeading.setHorizontalAlignment(SwingConstants.RIGHT);
	ContainerChargeHeading.setOpaque(true);
//	ContainerChargeHeading.setBorder(new LineBorder(Color.GRAY, 1, true));
	ContainerChargeHeading.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Default font for unformatted text
	 ImageIcon resizedIcon = createResizedIcon("/homepanel/860820.png", 20,20); // Adjust the path and size
	 ContainerChargeHeading.setIcon(resizedIcon);
     
	 JLabel b1= new JLabel();
		b1.setBorder(new LineBorder(new Color(217,217,217), 1, true));
		
	 
	HintTextField ContainerChargevalue = new HintTextField("0",10);
	ContainerChargevalue.setBackground(Color.white);
	ContainerChargevalue.setBorder(new LineBorder(new Color(217,217,217), 1, true));
	ContainerChargevalue.setHorizontalAlignment(SwingConstants.LEFT);
//	DeliveryChargevalue.setHorizontalAlignment(SwingConstants.CENTER); // Align text to the left
	ContainerChargevalue.setOpaque(true);
	ContainerChargevalue.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text
	

	hGrouppanel_ContainerCharge.addGroup(gl_panel_ContainerCharge.createSequentialGroup()
          
            .addComponent(ContainerChargeHeading, GroupLayout.PREFERRED_SIZE, 976, GroupLayout.PREFERRED_SIZE)
            .addComponent(b1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            .addGap(4)
            .addComponent(ContainerChargevalue, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
            );
    
    vGrouppanel_ContainerCharge
    	.addGroup(gl_panel_ContainerCharge.createParallelGroup(Alignment.CENTER)
    			.addComponent(ContainerChargeHeading, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
    			.addComponent(b1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(ContainerChargevalue, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                
            
           );
    
    gl_panel_ContainerCharge.setHorizontalGroup(hGrouppanel_ContainerCharge);
    gl_panel_ContainerCharge.setVerticalGroup(vGrouppanel_ContainerCharge);
	
}
private void AppliedTaxespanel() {
	JLabel plusicon1 = new JLabel("+");
	plusicon1.setBackground(new Color(242,247,248));
	plusicon1.setOpaque(true);
	
	plusicon1.setFont(new Font("Tahoma", Font.BOLD, 18)); // Default font for unformatted text
	plusicon1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        	if(discclicktax) {
        		SGST_CGST_Panel.setVisible(false);
        		discclicktax=false;
        	}
        	else {
        		SGST_CGST_Panel.setVisible(true);
        		discclicktax=true;
        	}
        	
        }
    });
	
	
	JLabel appliedtax = new JLabel("Applied Taxes");
	appliedtax.setBackground(new Color(242,247,248));

	appliedtax.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text
	appliedtax.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left
	appliedtax.setOpaque(true);
	appliedtax.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        	if(discclicktax) {
        		SGST_CGST_Panel.setVisible(false);
        		discclicktax=false;
        	}
        	else {
        		SGST_CGST_Panel.setVisible(true);
        		discclicktax=true;
        	}
        	
        }
    });
	
	JLabel applied_showdetails = new JLabel("<html><u>(Show Detail)</u></html>");
	applied_showdetails.setBackground(new Color(242,247,248,255)); 
	applied_showdetails.setOpaque(true);
	applied_showdetails.setFont(new Font("Tahoma", Font.PLAIN, 12)); // Default font for unformatted text
	applied_showdetails.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        	if(discclicktax) {
        		SGST_CGST_Panel.setVisible(false);
        		discclicktax=false;
        	}
        	else {
        		SGST_CGST_Panel.setVisible(true);
        		discclicktax=true;
        	}
        	
        }
    });
	
	taxvalue = new JLabel("(0.00)");
	taxvalue.setBackground(new Color(242,247,248,255));
	taxvalue.setHorizontalAlignment(SwingConstants.RIGHT);
	taxvalue.setOpaque(true);
	taxvalue.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Default font for unformatted text
	
	hGrouppanel_AppliedTaxes.addGroup(gl_panel_AppliedTaxes.createSequentialGroup()
            .addGap(10)
            .addComponent(plusicon1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
          
            .addComponent(appliedtax, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
            
            .addComponent(applied_showdetails, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
            .addComponent(taxvalue, GroupLayout.PREFERRED_SIZE, 865, GroupLayout.PREFERRED_SIZE)
            );
    
    vGrouppanel_AppliedTaxes
    	.addGroup(gl_panel_AppliedTaxes.createParallelGroup(Alignment.LEADING)
    			.addComponent(plusicon1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addComponent(appliedtax, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addComponent(applied_showdetails, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addComponent(taxvalue, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
            
           );
    
    gl_panel_AppliedTaxes.setHorizontalGroup(hGrouppanel_AppliedTaxes);
    gl_panel_AppliedTaxes.setVerticalGroup(vGrouppanel_AppliedTaxes);
	
}
private void RoundOffcomponents() {
	
	HintTextField orderwisecomments = new HintTextField("Order Wise Comments",10);
	orderwisecomments.setBackground(Color.white);

	orderwisecomments.setBorder(new LineBorder(new Color(218,218,218,255), 1)); // Set red border with thickness of 2
	orderwisecomments.setHorizontalAlignment(SwingConstants.LEFT);
//	DeliveryChargevalue.setHorizontalAlignment(SwingConstants.CENTER); // Align text to the left
	orderwisecomments.setOpaque(true);
	orderwisecomments.setFont(new Font("Tahoma", Font.BOLD, 13)); // Default font for unformatted text
	
	
	JLabel RoundoffHeading = new JLabel("Round Off");
	RoundoffHeading.setBackground(new Color(241,241,241,255));
	RoundoffHeading.setHorizontalAlignment(SwingConstants.RIGHT);
	RoundoffHeading.setOpaque(true);
	RoundoffHeading.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Default font for unformatted text
	
     
	 Roundoffevalue = new JLabel("0");
	 Roundoffevalue.setBackground(new Color(241,241,241,255));
	 Roundoffevalue.setHorizontalAlignment(SwingConstants.RIGHT);
//	DeliveryChargevalue.setHorizontalAlignment(SwingConstants.CENTER); // Align text to the left
	 Roundoffevalue.setOpaque(true);
	 Roundoffevalue.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text
	

	hGrouppanel_RoundOff.addGroup(gl_panel_RoundOff.createSequentialGroup()
			.addComponent(orderwisecomments, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
            .addComponent(RoundoffHeading, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
            .addGap(10)
            .addComponent(Roundoffevalue, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
            );
    
    vGrouppanel_RoundOff
    	.addGroup(gl_panel_RoundOff.createParallelGroup(Alignment.CENTER)
    			.addComponent(orderwisecomments, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
    			.addComponent(RoundoffHeading, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                .addComponent(Roundoffevalue, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                
            
           );
    
    gl_panel_RoundOff.setHorizontalGroup(hGrouppanel_RoundOff);
    gl_panel_RoundOff.setVerticalGroup(vGrouppanel_RoundOff);
	
}

private void splitpanecomponents() {
	
	RoundButton1 splitbutton = new RoundButton1("Split");
	splitbutton.setBorder(null);
	splitbutton.setFont(new Font("Arial", Font.BOLD, 14));
	splitbutton.setBackground(new Color(77,87,93,255)); // Set the background color
	splitbutton.setForeground(Color.WHITE); // Set the text color
	splitbutton.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		 showCustomDialog();
         }
     });
	
	RoundButton1 advanceorder = new RoundButton1("Advance Order");
	advanceorder.setBorder(null);
	advanceorder.setFont(new Font("Arial", Font.BOLD, 14));
	advanceorder.setBackground(new Color(77,87,93,255)); // Set the background color
	advanceorder.setForeground(Color.WHITE); // Set the text color
    
	JLabel GrandTotalheading = new JLabel("Grand Total(₹)");
	GrandTotalheading.setBackground(new Color(224,228,224));
	GrandTotalheading.setHorizontalAlignment(SwingConstants.RIGHT);
	GrandTotalheading.setOpaque(true);
	GrandTotalheading.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text

	Totalheading = new JLabel("0");
	Totalheading.setBackground(new Color(224,228,224));
	Totalheading.setForeground(new Color(68,104,124,255));
	Totalheading.setHorizontalAlignment(SwingConstants.RIGHT);
	Totalheading.setOpaque(true);
	Totalheading.setFont(new Font("Tahoma", Font.BOLD, 19)); // Default font for unformatted text

	
	hGrouppanel_splitpane.addGroup(gl_panel_splitpane.createSequentialGroup()
			.addGap(665)
			.addComponent(splitbutton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
			.addGap(9)
            .addComponent(advanceorder, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
            
            .addComponent(GrandTotalheading, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
            .addComponent(Totalheading, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
			);
    
    vGrouppanel_splitpane
    	.addGroup(gl_panel_splitpane.createParallelGroup(Alignment.CENTER)
    			.addComponent(splitbutton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
    			.addComponent(advanceorder, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(GrandTotalheading, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addComponent(Totalheading, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
           );
    
    gl_panel_splitpane.setHorizontalGroup(hGrouppanel_splitpane);
    gl_panel_splitpane.setVerticalGroup(vGrouppanel_splitpane);
	
}
private void customerpaid() {
	
	 // Create a new JCheckBox
    JCheckBox checkBox = new JCheckBox("Customer already Paid for this Order");
    checkBox.setBackground(new Color(248,248,248,255));
    checkBox.setOpaque(true);
    checkBox.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Default font for unformatted text
    
    JLabel customerpaidheading = new JLabel("Customer Paid");
    
    customerpaidheading.setBackground(new Color(241,241,241,255));
    customerpaidheading.setHorizontalAlignment(SwingConstants.RIGHT);
    customerpaidheading.setOpaque(true);
    customerpaidheading.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text
	
	HintTextField customerpaidvalue = new HintTextField("0",10);
	customerpaidvalue.setBackground(Color.white);
	customerpaidvalue.setHorizontalAlignment(SwingConstants.LEFT);
//	DeliveryChargevalue.setHorizontalAlignment(SwingConstants.CENTER); // Align text to the left

	customerpaidvalue.setBorder(new LineBorder(new Color(211,211,211,255), 1)); // Set red border with thickness of 2
	customerpaidvalue.setOpaque(true);
	customerpaidvalue.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text
    
	hGrouppanel_customerpaid.addGroup(gl_panel_customerpaid.createSequentialGroup()
            .addComponent(checkBox, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
            .addGap(256)
            .addComponent(customerpaidheading, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
            .addGap(7)
            .addComponent(customerpaidvalue, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
            );
    
    vGrouppanel_customerpaid
    	.addGroup(gl_panel_customerpaid.createParallelGroup(Alignment.CENTER)
    			.addComponent(checkBox, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addComponent(customerpaidheading, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addComponent(customerpaidvalue, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                );
    
    gl_panel_customerpaid.setHorizontalGroup(hGrouppanel_customerpaid);
    gl_panel_customerpaid.setVerticalGroup(vGrouppanel_customerpaid);
}
private void returncustomercomponents() {
	JLabel returncustomerHeading = new JLabel("Return to Customer");
	returncustomerHeading.setBackground(new Color(241,241,241,255));
	returncustomerHeading.setHorizontalAlignment(SwingConstants.RIGHT);
	returncustomerHeading.setOpaque(true);
//	returncustomerHeading.setBorder(new LineBorder(Color.GRAY, 1, true));
	returncustomerHeading.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text

	JLabel returncustomervalue = new JLabel("0.00 ");
	returncustomervalue.setBackground(new Color(241,241,241,255));
	returncustomervalue.setForeground(new Color(197,31,49,255));
	returncustomervalue.setHorizontalAlignment(SwingConstants.RIGHT);
//	DeliveryChargevalue.setHorizontalAlignment(SwingConstants.CENTER); // Align text to the left
	returncustomervalue.setOpaque(true);
	returncustomervalue.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text

	returncustomervalue.setBorder(new LineBorder(new Color(211,211,211,255), 1)); // Set red border with thickness of 2

	hGrouppanel_returncustomer.addGroup(gl_panel_returncustomer.createSequentialGroup()
          
            .addComponent(returncustomerHeading, GroupLayout.PREFERRED_SIZE, 977, GroupLayout.PREFERRED_SIZE)
            .addGap(5)
            .addComponent(returncustomervalue, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
            );
    
    vGrouppanel_returncustomer
    	.addGroup(gl_panel_returncustomer.createParallelGroup(Alignment.CENTER)
    			.addComponent(returncustomerHeading, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(returncustomervalue, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                
            
           );
    
    gl_panel_returncustomer.setHorizontalGroup(hGrouppanel_returncustomer);
    gl_panel_returncustomer.setVerticalGroup(vGrouppanel_returncustomer);
	
}
private void tipcomponents() {
	JLabel tipHeading = new JLabel("Tip");
	tipHeading.setBackground(new Color(241,241,241,255));
	tipHeading.setHorizontalAlignment(SwingConstants.RIGHT);
	tipHeading.setOpaque(true);
//	tipHeading.setBorder(new LineBorder(Color.GRAY, 1, true));
	tipHeading.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Default font for unformatted text

	HintTextField tipvalue = new HintTextField("0",10);
	tipvalue.setBackground(Color.white);
	tipvalue.setHorizontalAlignment(SwingConstants.LEFT);
//	DeliveryChargevalue.setHorizontalAlignment(SwingConstants.CENTER); // Align text to the left
	tipvalue.setOpaque(true);
	tipvalue.setFont(new Font("Tahoma", Font.BOLD, 14)); // Default font for unformatted text
	

	hGrouppanel_tip.addGroup(gl_panel_tip.createSequentialGroup()
          
            .addComponent(tipHeading, GroupLayout.PREFERRED_SIZE, 977, GroupLayout.PREFERRED_SIZE)
            .addGap(5)
            .addComponent(tipvalue, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
            );
    
    vGrouppanel_tip
    	.addGroup(gl_panel_tip.createParallelGroup(Alignment.CENTER)
    			.addComponent(tipHeading, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addComponent(tipvalue, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                
            
           );
    
    gl_panel_tip.setHorizontalGroup(hGrouppanel_tip);
    gl_panel_tip.setVerticalGroup(vGrouppanel_tip);
	
}
private void sgstcgstcomponents() {
    JLabel SGSTHeading = new JLabel("100@ SGST ");
    SGSTHeading.setBackground(new Color(224, 228, 224));
    SGSTHeading.setHorizontalAlignment(SwingConstants.RIGHT);
    SGSTHeading.setOpaque(true);
    SGSTHeading.setBorder(new LineBorder(Color.GRAY, 1, true));
    SGSTHeading.setFont(new Font("Tahoma", Font.PLAIN, 14));

    JLabel CGSTHeading = new JLabel("100@ CGST ");
    CGSTHeading.setBackground(new Color(224, 228, 224));
    CGSTHeading.setHorizontalAlignment(SwingConstants.RIGHT);
    CGSTHeading.setOpaque(true);
    CGSTHeading.setBorder(new LineBorder(Color.GRAY, 1, true));
    CGSTHeading.setFont(new Font("Tahoma", Font.PLAIN, 14));

    JLabel SGSTHeadingval = new JLabel("2.5%");
    SGSTHeadingval.setBackground(new Color(224, 228, 224));
    SGSTHeadingval.setHorizontalAlignment(SwingConstants.LEFT);
    SGSTHeadingval.setOpaque(true);
    SGSTHeadingval.setBorder(new LineBorder(Color.GRAY, 1, true));
    SGSTHeadingval.setFont(new Font("Tahoma", Font.PLAIN, 14));

    JLabel CGSTHeadingval = new JLabel("2.5%");
    CGSTHeadingval.setBackground(new Color(224, 228, 224));
    CGSTHeadingval.setHorizontalAlignment(SwingConstants.LEFT  );
    CGSTHeadingval.setOpaque(true);
    CGSTHeadingval.setBorder(new LineBorder(Color.GRAY, 1, true));
    CGSTHeadingval.setFont(new Font("Tahoma", Font.PLAIN, 14));

    // Create panels for SGSval and CGSval
    JPanel SGSvalPanel = new JPanel();

    SGSvalPanel.setBorder(new LineBorder(Color.GRAY, 1, true));
    JPanel CGSvalPanel = new JPanel();

    CGSTHeadingval.setBorder(new LineBorder(Color.GRAY, 2, true));

    SGSval = new RoundLabel(" 2.5", 10);
    SGSval.setBackground(new Color(224, 228, 224));
    SGSval.setHorizontalAlignment(SwingConstants.LEFT);
    SGSval.setOpaque(true);
    SGSval.setBorder(new LineBorder(Color.GRAY, 1, true));
    SGSval.setFont(new Font("Tahoma", Font.PLAIN, 14));

    CGSval = new RoundLabel(" 2.5", 10);
    CGSval.setBackground(new Color(224, 228, 224));
    CGSval.setHorizontalAlignment(SwingConstants.LEFT);
    CGSval.setOpaque(true);
    CGSval.setBorder(new LineBorder(Color.GRAY, 1, true));
    CGSval.setFont(new Font("Tahoma", Font.PLAIN, 14));

 // Set GroupLayout for SGSvalPanel
    GroupLayout gl_SGSvalPanel = new GroupLayout(SGSvalPanel);
    SGSvalPanel.setLayout(gl_SGSvalPanel);
    gl_SGSvalPanel.setHorizontalGroup(
        gl_SGSvalPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(gl_SGSvalPanel.createSequentialGroup()
        		.addGap(5)
            .addComponent(SGSval, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
    );
    gl_SGSvalPanel.setVerticalGroup(
        gl_SGSvalPanel.createParallelGroup(GroupLayout.Alignment.CENTER)
        
            .addComponent(SGSval, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
    );

    // Set GroupLayout for CGSvalPanel
    GroupLayout gl_CGSvalPanel = new GroupLayout(CGSvalPanel);
    CGSvalPanel.setLayout(gl_CGSvalPanel);
    gl_CGSvalPanel.setHorizontalGroup(
        gl_CGSvalPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(gl_CGSvalPanel.createSequentialGroup()
        		.addGap(5)
            .addComponent(CGSval, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
    );
    gl_CGSvalPanel.setVerticalGroup(
        gl_CGSvalPanel.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(CGSval, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
    );


    // Add the components to GroupLayout
    hGrouppanel_SGST_CGST_Panel.addGroup(gl_SGST_CGST_Panel.createSequentialGroup()
   
        .addComponent(SGSTHeading, GroupLayout.PREFERRED_SIZE, 891, GroupLayout.PREFERRED_SIZE)
        .addComponent(SGSTHeadingval, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
        .addComponent(SGSvalPanel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
    );
    hGrouppanel_SGST_CGST_Panel.addGroup(gl_SGST_CGST_Panel.createSequentialGroup()
    		
        .addComponent(CGSTHeading, GroupLayout.PREFERRED_SIZE, 891, GroupLayout.PREFERRED_SIZE)
        .addComponent(CGSTHeadingval, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
        .addComponent(CGSvalPanel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
    );

    vGrouppanel_SGST_CGST_Panel.addGroup(gl_SGST_CGST_Panel.createParallelGroup(Alignment.CENTER)
        .addComponent(SGSTHeading, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        .addComponent(SGSTHeadingval, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        .addComponent(SGSvalPanel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
    );
    vGrouppanel_SGST_CGST_Panel.addGroup(gl_SGST_CGST_Panel.createParallelGroup(Alignment.CENTER)
        .addComponent(CGSTHeading, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        .addComponent(CGSTHeadingval, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        .addComponent(CGSvalPanel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
    );

    gl_SGST_CGST_Panel.setHorizontalGroup(hGrouppanel_SGST_CGST_Panel);
    gl_SGST_CGST_Panel.setVerticalGroup(vGrouppanel_SGST_CGST_Panel);
}

//Method to show the custom dialog using GroupLayout
private void showCustomDialog() {
    // Create a custom JDialog
    JDialog customDialog = new JDialog((Frame) null, "Popup", Dialog.ModalityType.APPLICATION_MODAL);
    customDialog.setSize(800, 320);
    customDialog.setUndecorated(true);  // Removes the window header
    
    // Custom content panel with GroupLayout
    JPanel contentPanel = new JPanel();
    contentPanel.setBackground(Color.WHITE);
    GroupLayout layout = new GroupLayout(contentPanel);
    contentPanel.setLayout(layout);

    // Labels to be displayed at the top
    JLabel label1 = new JLabel("Split Bill");
    label1.setFont(new Font("Tahoma", Font.PLAIN, 16));
    label1.setHorizontalAlignment(SwingConstants.CENTER);

    JLabel label2 = new JLabel("X");
    label2.setFont(new Font("Calibri Light", Font.BOLD, 22));
    label2.setHorizontalAlignment(SwingConstants.CENTER);
    label2.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            customDialog.dispose();
        }
    });

    JSeparator separator = new JSeparator(); // Create a separator
    separator.setPreferredSize(new Dimension(0, 1)); // Set the height of the separator
    separator.setBackground(Color.GRAY);
    separator.setForeground(Color.GRAY);
    
    JSeparator separator1 = new JSeparator(); // Create a separator
    separator1.setPreferredSize(new Dimension(0, 1)); // Set the height of the separator
    separator1.setBackground(Color.GRAY);
    separator1.setForeground(Color.GRAY);
    
    JSeparator separator2 = new JSeparator(); // Create a separator
    separator2.setPreferredSize(new Dimension(0, 1)); // Set the height of the separator
    separator2.setBackground(Color.GRAY);
    separator2.setForeground(Color.GRAY);

    // Panel 1 with two labels using GroupLayout
    JPanel squarePanel1 = new JPanel();
    GroupLayout squarePanel1Layout = new GroupLayout(squarePanel1);
    squarePanel1.setLayout(squarePanel1Layout);
    squarePanel1.setBackground(new Color(242,247,248)); // Example color
    

    JLabel panel1Label1 = new JLabel();
    ImageIcon resizedIconupdatesLabel11= createResizedIcon("/homepanel/part1.png", 30,30); // Adjust the path and size
    panel1Label1.setIcon(resizedIconupdatesLabel11);
    JLabel panel1Label2 = new JLabel("Portion Wise");
    panel1Label2.setForeground(Color.RED); // Example color
    panel1Label2.setFont(new Font("Tahoma", Font.PLAIN, 16));

    squarePanel1Layout.setHorizontalGroup(
        squarePanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
        .addGroup(squarePanel1Layout.createSequentialGroup()
            	.addGap(20)
            .addComponent(panel1Label1))
        .addGroup(squarePanel1Layout.createSequentialGroup()
        		.addGap(10)
            .addComponent(panel1Label2))
    );
    squarePanel1Layout.setVerticalGroup(
        squarePanel1Layout.createSequentialGroup()
        .addGap(10)
            .addComponent(panel1Label1)
            .addGap(10) // Add space between the labels
            .addComponent(panel1Label2)
    );

    // Panel 2 with two labels using GroupLayout
    JPanel squarePanel2 = new JPanel();
    GroupLayout squarePanel2Layout = new GroupLayout(squarePanel2);
    squarePanel2.setLayout(squarePanel2Layout);
    squarePanel2.setBackground(Color.WHITE); // Example color
    squarePanel2.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
        	customDialog.dispose();
           showCustomDialog1();
        }
    });

    JLabel panel2Label1 = new JLabel();
    ImageIcon resizedIconupdatesLabel= createResizedIcon("/homepanel/part2.png", 30,30); // Adjust the path and size
    panel2Label1.setIcon(resizedIconupdatesLabel);         
    
    JLabel panel2Label2 = new JLabel(" Percentage Wise");
    panel2Label2.setFont(new Font("Tahoma", Font.PLAIN, 16));

    squarePanel2Layout.setHorizontalGroup(
        squarePanel2Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
        .addGroup(squarePanel2Layout.createSequentialGroup()
        	.addGap(10)
            .addComponent(panel2Label1))
            .addComponent(panel2Label2)
    );
    squarePanel2Layout.setVerticalGroup(
    		
        squarePanel2Layout.createSequentialGroup()
        .addGap(10)
            .addComponent(panel2Label1)
            .addGap(10) // Add space between the labels
            .addComponent(panel2Label2)
    );

 // New label to be added below separator1
    JLabel newLabel = new JLabel("Please enter number in which bill can be splitted:");
    newLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    newLabel.setHorizontalAlignment(SwingConstants.LEFT);
    
 // New label to be added below separator1
    JLabel newLabel1 = new JLabel("1/");
    newLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
    newLabel.setHorizontalAlignment(SwingConstants.LEFT);
    
    HintTextField1 portiontext = new HintTextField1("Enter portion here..",10);
    portiontext.setBackground(Color.WHITE);
    portiontext.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Default font for unformatted text
    
    RoundButton1 cancelbutton1 = new RoundButton1("Cancel");
    cancelbutton1.setBorder(null);
    cancelbutton1.setFont(new Font("Arial", Font.BOLD, 14));
    cancelbutton1.setBackground(Color.WHITE); // Set the background color
    cancelbutton1.setForeground(Color.BLACK); // Set the text color
    cancelbutton1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
        	customDialog.dispose();
        }
    });
    
    RoundButton savebutton1 = new RoundButton("Save");
    savebutton1.setBorder(null);
    savebutton1.setFont(new Font("Arial", Font.BOLD, 14));
    savebutton1.setBackground(new Color(238, 52, 70, 255)); // Set the background color
    savebutton1.setForeground(Color.WHITE); // Set the text color
    savebutton1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
        	customDialog.dispose();
        }
    });
    
    // Set horizontal group for main layout
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20)
                .addComponent(label1)
                .addGap(690)
                .addComponent(label2))
            .addComponent(separator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20)
                .addComponent(squarePanel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                
                .addComponent(squarePanel2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
            .addComponent(separator1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                    .addGap(20)
                    .addComponent(newLabel, GroupLayout.PREFERRED_SIZE, 760, GroupLayout.PREFERRED_SIZE)) // New label below separator1
            .addGroup(layout.createSequentialGroup()
                    .addGap(20)
                    .addComponent(newLabel1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE) // New label below separator1
            .addComponent(portiontext, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)) // New label below separator1
            .addComponent(separator2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                    .addGap(570)
                    .addComponent(cancelbutton1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                   .addGap(10)
                    .addComponent(savebutton1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
    		);

    // Set vertical group for main layout
    layout.setVerticalGroup(
        layout.createSequentialGroup()
            .addGap(15)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label1)
                .addComponent(label2))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, 0)
            .addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(squarePanel1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                .addComponent(squarePanel2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
            .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addGap(10)
            .addComponent(newLabel) // New label below separator1
            .addGap(7)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            		
                    .addComponent(newLabel1)
                    .addComponent(portiontext, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
            .addGap(40)
            .addComponent(separator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addGap(15)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelbutton1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(savebutton1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
    );

    // Add content panel to the dialog
    customDialog.add(contentPanel);

    // Set dialog location relative to parent frame and make it visible
    customDialog.setLocationRelativeTo(null);
    customDialog.setVisible(true);
}
//Method to show the custom dialog using GroupLayout
private void showCustomDialog1() {
  // Create a custom JDialog
  JDialog customDialog = new JDialog((Frame) null, "Popup", Dialog.ModalityType.APPLICATION_MODAL);
  customDialog.setSize(800, 460);
  customDialog.setUndecorated(true);  // Removes the window header
  
  // Custom content panel with GroupLayout
  JPanel contentPanel = new JPanel();
  contentPanel.setBackground(Color.WHITE);
  GroupLayout layout = new GroupLayout(contentPanel);
  contentPanel.setLayout(layout);

  // Labels to be displayed at the top
  JLabel label1 = new JLabel("Split Bill");
  label1.setFont(new Font("Tahoma", Font.PLAIN, 16));
  label1.setHorizontalAlignment(SwingConstants.CENTER);

  JLabel label2 = new JLabel("X");
  label2.setFont(new Font("Calibri Light", Font.BOLD, 22));
  label2.setHorizontalAlignment(SwingConstants.CENTER);
  label2.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
          customDialog.dispose();
      }
  });

  JSeparator separator = new JSeparator(); // Create a separator
  separator.setPreferredSize(new Dimension(0, 1)); // Set the height of the separator
  separator.setBackground(Color.GRAY);
  separator.setForeground(Color.GRAY);
  
  JSeparator separator1 = new JSeparator(); // Create a separator
  separator1.setPreferredSize(new Dimension(0, 1)); // Set the height of the separator
  separator1.setBackground(Color.GRAY);
  separator1.setForeground(Color.GRAY);
  
  JSeparator separator2 = new JSeparator(); // Create a separator
  separator2.setPreferredSize(new Dimension(0, 1)); // Set the height of the separator
  separator2.setBackground(Color.GRAY);
  separator2.setForeground(Color.GRAY);

  // Panel 1 with two labels using GroupLayout
  JPanel squarePanel1 = new JPanel();
  GroupLayout squarePanel1Layout = new GroupLayout(squarePanel1);
  squarePanel1.setLayout(squarePanel1Layout);
  squarePanel1.setBackground(Color.WHITE); // Example color
  squarePanel1.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
          customDialog.dispose();
          showCustomDialog();
      }
  });
  

  JLabel panel1Label1 = new JLabel();
  ImageIcon resizedIconupdatesLabel11= createResizedIcon("/homepanel/part1.png", 30,30); // Adjust the path and size
  panel1Label1.setIcon(resizedIconupdatesLabel11);
  JLabel panel1Label2 = new JLabel("Portion Wise");
  panel1Label2.setForeground(Color.WHITE); // Example color
  panel1Label2.setFont(new Font("Tahoma", Font.PLAIN, 16));

  squarePanel1Layout.setHorizontalGroup(
      squarePanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
      .addGroup(squarePanel1Layout.createSequentialGroup()
          	.addGap(20)
          .addComponent(panel1Label1))
      .addGroup(squarePanel1Layout.createSequentialGroup()
      		.addGap(10)
          .addComponent(panel1Label2))
  );
  squarePanel1Layout.setVerticalGroup(
      squarePanel1Layout.createSequentialGroup()
      .addGap(10)
          .addComponent(panel1Label1)
          .addGap(10) // Add space between the labels
          .addComponent(panel1Label2)
  );

  // Panel 2 with two labels using GroupLayout
  JPanel squarePanel2 = new JPanel();
  GroupLayout squarePanel2Layout = new GroupLayout(squarePanel2);
  squarePanel2.setLayout(squarePanel2Layout);
  squarePanel2.setBackground(Color.RED); // Example color

  JLabel panel2Label1 = new JLabel();
  ImageIcon resizedIconupdatesLabel= createResizedIcon("/homepanel/part2.png", 30,30); // Adjust the path and size
  panel2Label1.setIcon(resizedIconupdatesLabel);         
  
  JLabel panel2Label2 = new JLabel(" Percentage Wise");
  panel2Label2.setFont(new Font("Tahoma", Font.PLAIN, 16));

  squarePanel2Layout.setHorizontalGroup(
      squarePanel2Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
      .addGroup(squarePanel2Layout.createSequentialGroup()
      	.addGap(10)
          .addComponent(panel2Label1))
          .addComponent(panel2Label2)
  );
  squarePanel2Layout.setVerticalGroup(
  		
      squarePanel2Layout.createSequentialGroup()
      .addGap(10)
          .addComponent(panel2Label1)
          .addGap(10) // Add space between the labels
          .addComponent(panel2Label2)
  );

// New label to be added below separator1
  JLabel newLabel = new JLabel("Please provide only number");
  newLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
  newLabel.setHorizontalAlignment(SwingConstants.LEFT);
  
// New label to be added below separator1
  JLabel newLabel1 = new JLabel("Percentage Number:");
  newLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
  newLabel.setHorizontalAlignment(SwingConstants.LEFT);
  
  HintTextField1 portiontext = new HintTextField1("Enter portion here..",10);
  portiontext.setBackground(Color.WHITE);
  portiontext.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Default font for unformatted text
  
  JLabel newLabel11 = new JLabel("Percentage Number:");
  newLabel1.setFont(new Font("Tahoma", Font.BOLD, 16));
  newLabel1.setHorizontalAlignment(SwingConstants.LEFT);
  
  HintTextField1 portiontext1 = new HintTextField1("Enter portion here..",10);
  portiontext1.setBackground(Color.WHITE);
  portiontext1.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Default font for unformatted text
  
  RoundButton1 cancelbutton1 = new RoundButton1("Cancel");
  cancelbutton1.setBorder(null);
  cancelbutton1.setFont(new Font("Arial", Font.BOLD, 14));
  cancelbutton1.setBackground(Color.WHITE); // Set the background color
  cancelbutton1.setForeground(Color.BLACK); // Set the text color
  cancelbutton1.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
      	customDialog.dispose();
      }
  });
  
  RoundButton savebutton1 = new RoundButton("Save");
  savebutton1.setBorder(null);
  savebutton1.setFont(new Font("Arial", Font.BOLD, 14));
  savebutton1.setBackground(new Color(238, 52, 70, 255)); // Set the background color
  savebutton1.setForeground(Color.WHITE); // Set the text color
  savebutton1.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
      	customDialog.dispose();
      }
  });
  RoundButton savebutton11 = new RoundButton("Add More");
  savebutton11.setBorder(null);
  savebutton11.setFont(new Font("Arial", Font.BOLD, 14));
  savebutton11.setBackground(new Color(238, 52, 70, 255)); // Set the background color
  savebutton11.setForeground(Color.WHITE); // Set the text color
  savebutton11.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
//      	customDialog.dispose();
      }
  });
  
  // Set horizontal group for main layout
  layout.setHorizontalGroup(
      layout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
              .addGap(20)
              .addComponent(label1)
              .addGap(690)
              .addComponent(label2))
          .addComponent(separator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
              .addGap(20)
              .addComponent(squarePanel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
              
              .addComponent(squarePanel2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
          .addComponent(separator1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
                  .addGap(20)
                  .addComponent(newLabel, GroupLayout.PREFERRED_SIZE, 760, GroupLayout.PREFERRED_SIZE)) // New label below separator1
          .addGroup(layout.createSequentialGroup()
                  .addGap(20)
                  .addComponent(newLabel1))
          .addGroup(layout.createSequentialGroup()
                  .addGap(20)
                   // New label below separator1
          .addComponent(portiontext, GroupLayout.PREFERRED_SIZE, 750, GroupLayout.PREFERRED_SIZE)) // New label below separator1
          .addGroup(layout.createSequentialGroup()
                  .addGap(20)
                  .addComponent(newLabel11))
          .addGroup(layout.createSequentialGroup()
                  .addGap(20)
                   // New label below separator1
          .addComponent(portiontext1, GroupLayout.PREFERRED_SIZE, 750, GroupLayout.PREFERRED_SIZE)) // New label below separator1
          .addGroup(layout.createSequentialGroup()
                  .addGap(670)
                  .addComponent(savebutton11, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
          .addComponent(separator2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
                  .addGap(570)
                  .addComponent(cancelbutton1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                 .addGap(10)
                  .addComponent(savebutton1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
  		);

  // Set vertical group for main layout
  layout.setVerticalGroup(
      layout.createSequentialGroup()
          .addGap(15)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
              .addComponent(label1)
              .addComponent(label2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, 0)
          .addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addComponent(squarePanel1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
              .addComponent(squarePanel2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
          .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addGap(10)
          .addComponent(newLabel) // New label below separator1
          .addGap(7)
          .addComponent(newLabel1)
          .addGap(5)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          		
                  
                  .addComponent(portiontext, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
          .addGap(20)
          .addComponent(newLabel11)
          .addGap(5)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          		
                  
                  .addComponent(portiontext1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
          .addGap(20)
          .addComponent(savebutton11, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
          .addGap(10)
          .addComponent(separator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addGap(20)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                  .addComponent(cancelbutton1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                  .addComponent(savebutton1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
  );

  // Add content panel to the dialog
  customDialog.add(contentPanel);

  // Set dialog location relative to parent frame and make it visible
  customDialog.setLocationRelativeTo(null);
  customDialog.setVisible(true);
}
public static String[][] readSQLFile(String filePath) {
	 ArrayList<String[]> rows = new ArrayList<>();
    String regex = "INSERT INTO \\w+ \\(([^)]+)\\) VALUES \\(([^)]+)\\);";
    Pattern pattern = Pattern.compile(regex);

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                Matcher matcher = pattern.matcher(line.trim());
                if (matcher.find()) {
                    String columns = matcher.group(1);
                    String values = matcher.group(2);
                    
                    // Split values and remove surrounding single quotes
                    String[] columnsArray = columns.split("\\s*,\\s*");
                    String[] valuesArray = values.split("\\s*,\\s*");
                    for (int i = 0; i < valuesArray.length; i++) {
                        valuesArray[i] = valuesArray[i].replaceAll("^'|'$", ""); // remove single quotes
                    }
                    rows.add(valuesArray);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Convert ArrayList to 2D String array
    String[][] data = new String[rows.size()][];
    for (int i = 0; i < rows.size(); i++) {
        data[i] = rows.get(i);
    }
    return data;
}
// Test in a JFrame
//public static void main(String[] args) {
//    JFrame frame = new JFrame("ScrollPane Test");
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.setSize(850, 650); // Make sure it's large enough to display the scroll pane
//    frame.add(new BillingPanel());
//    frame.setVisible(true);
//}
}	
