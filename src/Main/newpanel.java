package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class newpanel extends JPanel {

    private JPanel panel,mainPanel,generatebill;
    private JScrollPane scrollPane1;
    private GroupLayout.ParallelGroup hGrouppanel;
    private GroupLayout.SequentialGroup vGrouppanel;
    private GroupLayout.ParallelGroup hGrouppanel_generatebill;
    private GroupLayout.SequentialGroup vGrouppanel_generatebill;
    private GroupLayout gl_panel,gl_panel_generate_bill;
    private JSeparator separator;
	private GroupLayout.ParallelGroup hGrouppanel_ButtonPanel1;
	private GroupLayout.SequentialGroup vGrouppanel_ButtonPanel1;
	private JPanel ButtonPanel1;
	private GroupLayout gl_panel_ButtonPanel1;
	private GroupLayout gl_panel_roundedPanel;
	private GroupLayout.ParallelGroup hGrouppanel_roundedPanel;
	private GroupLayout.SequentialGroup vGrouppanel_roundedPanel;
	private JLabel totalheader4;
	private JLabel totalheader5;
	private String filepathoriginal;
	private String filepathoriginalinvoiiceno ;

	
	private Double originalTotalAmount=0.00;
	private Integer number=0;
	private String formattedDate;	
	

	




	
    public newpanel() {
    	mainPanel = new JPanel();
    	mainPanel.setLayout(new BorderLayout());
    	 GroupLayout layout = new GroupLayout(mainPanel);
         mainPanel.setLayout(layout);
        
       
         panel = new JPanel();
         panel.setBackground(Color.WHITE);
         panel.setPreferredSize(new Dimension(1125, 2000)); // Set desired size
         panel.setLayout(new GroupLayout(panel));

         LocalDate currentDate = LocalDate.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
         String formattedDate = currentDate.format(formatter);
         
         filepathoriginal = "C:\\POS\\Invoice_Data\\Complete\\"+formattedDate+".sql"; // Specify the file path
         filepathoriginalinvoiiceno ="C:\\POS\\Invoice_Data\\Day_Wise\\"+formattedDate+".sql";
         
         getoriginaldata(filepathoriginal);
         number=getLastInvoiceNumber(filepathoriginalinvoiiceno);
        




        separator = new JSeparator(); // Create a separator
		separator.setBackground(Color.BLACK);
        
		
		
        gl_panel = (GroupLayout) panel.getLayout();
        hGrouppanel = gl_panel.createParallelGroup(Alignment.LEADING);
        vGrouppanel = gl_panel.createSequentialGroup();

        generatebill = new JPanel();

//        generatebill.setBorder(new LineBorder(Color.GRAY, 1, true));
        generatebill.setBackground(Color.WHITE);
        gl_panel_generate_bill = new GroupLayout(generatebill);
        generatebill.setLayout(gl_panel_generate_bill);
        hGrouppanel_generatebill = gl_panel_generate_bill.createParallelGroup(Alignment.LEADING);
        vGrouppanel_generatebill = gl_panel_generate_bill.createSequentialGroup();

        ButtonPanel1 = new JPanel();

//        ButtonPanel1.setBorder(new LineBorder(Color.GRAY, 1, true));
        ButtonPanel1.setBackground(Color.WHITE);
        gl_panel_ButtonPanel1 = new GroupLayout(ButtonPanel1);
        ButtonPanel1.setLayout(gl_panel_ButtonPanel1);
        hGrouppanel_ButtonPanel1=gl_panel_ButtonPanel1.createParallelGroup(Alignment.LEADING);
        vGrouppanel_ButtonPanel1=gl_panel_ButtonPanel1.createSequentialGroup();
        
        


       

        
        
        
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
        buttonPanel1function();
        
        
        initializelayouts();
        
       
        System.out.println("Main panel size: " + mainPanel.getSize());
        System.out.println("Scroll pane size: " + scrollPane1.getSize());

       
        System.out.println("Billing panel size: " + getSize());
        
        
        layout.setHorizontalGroup(
        	    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        	        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1125, GroupLayout.PREFERRED_SIZE)
        	);

        layout.setVerticalGroup(
        	    layout.createSequentialGroup()
        	        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)  // Make scroll pane flexible
        	);

        	
        	
        	

    }
    

    public JPanel getPanel() {
        return mainPanel;
    }
    public JScrollPane getScrollPane() {
        return scrollPane1;
    }

    // Function to read the SQL file and return a list of product names
    public static ArrayList<String> readSQLFile(String filePath) {
        ArrayList<String> productNames = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isReadingValues = false;  // Flag to start reading after "VALUES"

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                line = line.trim();  // Trim whitespace

                // Start reading values after the "VALUES" keyword
                if (line.contains("VALUES")) {
                    isReadingValues = true;
                }

                // Stop reading when the semicolon is encountered (end of statement)
                if (line.endsWith(";")) {
                    isReadingValues = false;
                }

                // If we are reading values, extract the product names
                if (isReadingValues && !line.contains("VALUES")) {
                    // Remove any leading or trailing commas and single quotes
                    line = line.replace(",", "").replace("'", "").trim();

                    // Skip empty lines
                    if (!line.isEmpty()) {
                        productNames.add(line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productNames;  // Return the list of product names
    }
private void initializelayouts() {
	 // Add the new panel to the layout
    addgeneratebill();
    addbuttonpanel1();
    
}


private void addgeneratebill() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(generatebill, GroupLayout.PREFERRED_SIZE, 1120, GroupLayout.PREFERRED_SIZE)
            
    );
	vGrouppanel
    		.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
            .addComponent(generatebill, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
            );

	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(separator, GroupLayout.PREFERRED_SIZE, 1120, GroupLayout.PREFERRED_SIZE)
            
    );
	vGrouppanel
    		.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
            .addComponent(separator)
            );
	
    gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
    updatePanelSize(); // Update panel size
}

private void addbuttonpanel1() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(ButtonPanel1, GroupLayout.PREFERRED_SIZE, 1120, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel
    		.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
            .addComponent(ButtonPanel1, GroupLayout.PREFERRED_SIZE, 20000, GroupLayout.PREFERRED_SIZE));
    gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
    updatePanelSize(); // Update panel size
}



private void generatebillfunction() {
	 // Create components here
	JLabel labelgeneratebill = new JLabel("Executive Sales Summary");

    labelgeneratebill.setFont(new Font("Arial", Font.BOLD, 20));
    
   

    // Align label to the left using Alignment.LEADING
    hGrouppanel_generatebill.addGroup(gl_panel_generate_bill.createSequentialGroup()
    		.addGap(20)
            .addComponent(labelgeneratebill, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
           
            );
    
    vGrouppanel_generatebill.addGap(5)
    		.addGroup(gl_panel_generate_bill.createParallelGroup(Alignment.BASELINE)
        		.addComponent(labelgeneratebill, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        		
    		);

    gl_panel_generate_bill.setHorizontalGroup(hGrouppanel_generatebill);
    gl_panel_generate_bill.setVerticalGroup(vGrouppanel_generatebill);
    

}
private void buttonPanel1function() {
	RoundButtonGray button42 = new RoundButtonGray("  Print Configuration");
    button42.setBorder(null);
    button42.setFont(new Font("Arial", Font.PLAIN, 14));
    button42.setHorizontalAlignment(SwingConstants.CENTER);
    button42.setBackground(Color.WHITE); // Set the background color
    button42.setForeground(Color.BLACK); // Set the text color
    ImageIcon resizedIconbuttonA = createResizedIcon("/homepanel/settings1.png", 20,20); // Adjust the path and size
    button42.setIcon(resizedIconbuttonA);
    
	RoundButtonGray button421 = new RoundButtonGray(" Search  v");
    button421.setBorder(null);
    button421.setFont(new Font("Arial", Font.PLAIN, 14));
    button421.setHorizontalAlignment(SwingConstants.CENTER);
    button421.setBackground(Color.WHITE); // Set the background color
    button421.setForeground(Color.BLACK); // Set the text color
    ImageIcon resizedIconbuttonC = createResizedIcon("/operationpanel/Untitled.png", 15,15); // Adjust the path and size
    button421.setIcon(resizedIconbuttonC);
    
    RoundButtonGray button2 = new RoundButtonGray("Yesterday Sales");
    button2.setBorder(null);
    button2.setFont(new Font("Arial", Font.PLAIN, 14));
    button2.setHorizontalAlignment(SwingConstants.CENTER);
    button2.setBackground(Color.WHITE); // Set the background color
    button2.setForeground(Color.BLACK); // Set the text color
    
    RoundButtonGray button4 = new RoundButtonGray("Today Sales");
    button4.setBorder(null);
    button4.setFont(new Font("Arial", Font.PLAIN, 14));
    button4.setHorizontalAlignment(SwingConstants.CENTER);
    button4.setBackground(Color.WHITE); // Set the background color
    button4.setForeground(Color.BLACK); // Set the text color
    
    JPanel roundedPanel = new JPanel();
    roundedPanel.setBackground(Color.WHITE);  // Set background color
    roundedPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));  // Optional border
    gl_panel_roundedPanel = new GroupLayout(roundedPanel);
    roundedPanel.setLayout(gl_panel_roundedPanel);
    hGrouppanel_roundedPanel=gl_panel_roundedPanel.createParallelGroup(Alignment.LEADING);
    vGrouppanel_roundedPanel=gl_panel_roundedPanel.createSequentialGroup();
    
    
    
    
    RoundButton1 button41 = new RoundButton1("Export Excel");
    button41.setBorder(null);
    button41.setFont(new Font("Arial", Font.PLAIN, 14));
    button41.setBackground(Color.WHITE); // Set the background color
    button41.setForeground(Color.BLACK); // Set the text color
    button41.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	Excelreport();
        }
    });
    
    RoundButton1 button411 = new RoundButton1("Print");
    button411.setBorder(null);
    button411.setFont(new Font("Arial", Font.PLAIN, 14));
    button411.setBackground(Color.WHITE); // Set the background color
    button411.setForeground(Color.BLACK); // Set the text color
    
    JPanel blankPanel = new JPanel();
    blankPanel.setBackground(Color.WHITE);  // Set background color
    blankPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));  // Optional border
    
    JLabel icon1 = new JLabel();
    icon1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    JLabel icon2 = new JLabel();
    icon2.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    JLabel icon3 = new JLabel();
    icon3.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    JLabel icon4 = new JLabel();
    icon4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    
    
    
    JSeparator separator1 = new JSeparator(); // Create a separator\
    separator1.setBackground(Color.LIGHT_GRAY);
    JSeparator separator2 = new JSeparator(); // Create a separator\
    separator2.setBackground(Color.LIGHT_GRAY);
    JSeparator separator3 = new JSeparator(); // Create a separator\
    separator3.setBackground(Color.LIGHT_GRAY);
    JSeparator separator4 = new JSeparator(); // Create a separator\
    separator4.setBackground(Color.LIGHT_GRAY);
    
    
    JLabel itemreport = new JLabel("   Executive Sales Report");
    itemreport.setOpaque(true);
    itemreport.setFont(new Font("Arial", Font.BOLD, 12));
    itemreport.setHorizontalAlignment(SwingConstants.LEFT);
    itemreport.setBackground(new Color(249,249,249));// Your background color
    
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    formattedDate = currentDate.format(formatter);
    
    JLabel datelabel = new JLabel("- "+formattedDate);
    datelabel.setOpaque(true);
    datelabel.setFont(new Font("Arial", Font.PLAIN, 12));
    datelabel.setHorizontalAlignment(SwingConstants.LEFT);
    datelabel.setBackground(new Color(249,249,249));// Your background color
    
    
    hGrouppanel_roundedPanel.addGroup(gl_panel_roundedPanel.createSequentialGroup().addGap(8).addGap(845)

            .addComponent(button41, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)  .addGap(10)

            .addComponent(button411, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)  
            );
    
    vGrouppanel_roundedPanel.addGap(10)
    	.addGroup(gl_panel_roundedPanel.createParallelGroup(Alignment.CENTER)
    			.addComponent(button41, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)          
                
    			.addComponent(button411, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)  
                );
    
    gl_panel_roundedPanel.setHorizontalGroup(hGrouppanel_roundedPanel);
    gl_panel_roundedPanel.setVerticalGroup(vGrouppanel_roundedPanel);
    
    
    
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(button421, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE).addGap(15)
            .addComponent(button42, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)  .addGap(480) 
            
            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE) .addGap(15)             
            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE) 
            
            );
    
    vGrouppanel_ButtonPanel1.addGap(10)
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(button421, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)            
                
    			.addComponent(button42, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)  
    			

    			.addComponent(button2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)  
    			.addComponent(button4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)  
                );
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(roundedPanel, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
           );
    
    vGrouppanel_ButtonPanel1.addGap(10)
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(roundedPanel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)            
                
    			);
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(blankPanel, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(blankPanel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)            
                
    			);
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(icon1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            .addComponent(itemreport, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
            .addComponent(datelabel, GroupLayout.PREFERRED_SIZE, 933, GroupLayout.PREFERRED_SIZE)
            .addComponent(icon2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(icon1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
    			.addComponent(itemreport, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
    			.addComponent(datelabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
    			.addComponent(icon2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
    			);
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(separator1, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(separator1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)            
                
    			);
    JLabel snackheader1 = new JLabel(" 	Billing (Success)");
    snackheader1.setOpaque(true);
    snackheader1.setFont(new Font("Arial", Font.BOLD, 13));
    snackheader1.setHorizontalAlignment(SwingConstants.LEFT);
    snackheader1.setBackground(Color.white);// Your background color
    
    JLabel snackicon3 = new JLabel();
    snackicon3.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    JLabel snackicon4 = new JLabel();
    snackicon4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    
//    JSeparator separator4 = new JSeparator(); // Create a separator\
//    separator4.setBackground(Color.LIGHT_GRAY);
    
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
    		.addComponent(snackicon3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            .addComponent(snackheader1, GroupLayout.PREFERRED_SIZE, 1078, GroupLayout.PREFERRED_SIZE)
            .addComponent(snackicon4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            
            
           );
    vGrouppanel_ButtonPanel1
	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
			.addComponent(snackicon3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
			.addComponent(snackheader1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)      
			.addComponent(snackicon4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
			);
    
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(separator4, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(separator4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)            
                
    			);
    Double sub=originalTotalAmount +((originalTotalAmount*0.05));
    String sub_format = String.format("%.0f", sub);
    Double round=(originalTotalAmount*0.05)/2;
    
    Double Roundoff = sub-Double.parseDouble(sub_format);
    System.out.println(Roundoff);
   Subtotalfunction();
   addtablevaluesCount("   Count:", number.toString());
   addtablevaluesCount("   Invoice Nos.:", "NA");
   addtablevalues("   Sub Total:", originalTotalAmount);
   addtablevalues("   Discount:", 0.00);
   addtablevalues("   Delivery Charge:", 0.00);
   addtablevalues("   Container Charge:", 0.00);
   addtablevalues("   Additional Charge:", 0.00);
   addtablevalues("   SGST:", round);
   addtablevalues("   CGST:", round);
   addtablevalues("   Round Off:", Roundoff);
   addtablevalues("   Waived Off:", 0.00);
   addtablevaluesBOLD("   Grand Total:",Double.parseDouble(sub_format));
   addtablevaluesNOSEP("   Net Sales:", originalTotalAmount);
   
   
   
   JLabel snackheader11 = new JLabel(" 	Billing (Cancel)");
   snackheader11.setOpaque(true);
   snackheader11.setFont(new Font("Arial", Font.BOLD, 13));
   snackheader11.setHorizontalAlignment(SwingConstants.LEFT);
   snackheader11.setBackground(Color.white);// Your background color
   
   JLabel snackicon31 = new JLabel();
   snackicon31.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
   JLabel snackicon41 = new JLabel();
   snackicon41.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
   
//   JSeparator separator4 = new JSeparator(); // Create a separator\
//   separator4.setBackground(Color.LIGHT_GRAY);
   
   hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
   		.addComponent(snackicon31, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
           .addComponent(snackheader11, GroupLayout.PREFERRED_SIZE, 1078, GroupLayout.PREFERRED_SIZE)
           .addComponent(snackicon41, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
           
           
          );
   vGrouppanel_ButtonPanel1
	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
			.addComponent(snackicon31, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
			.addComponent(snackheader11, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)      
			.addComponent(snackicon41, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
			);
   
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(separator2, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(separator2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)            
                
    			);
    
    Subtotalfunction();
    addtablevaluesCount("   Count:", "0");
    addtablevaluesNOSEP("   Amount:", 0.00);
    
    JLabel snackheader12 = new JLabel(" 	Order Type");
    snackheader12.setOpaque(true);
    snackheader12.setFont(new Font("Arial", Font.BOLD, 13));
    snackheader12.setHorizontalAlignment(SwingConstants.LEFT);
    snackheader12.setBackground(Color.white);// Your background color
    
    JLabel snackicon32 = new JLabel();
    snackicon32.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    JLabel snackicon42 = new JLabel();
    snackicon42.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    
 //   JSeparator separator4 = new JSeparator(); // Create a separator\
 //   separator4.setBackground(Color.LIGHT_GRAY);
    
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
    		.addComponent(snackicon32, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            .addComponent(snackheader12, GroupLayout.PREFERRED_SIZE, 1078, GroupLayout.PREFERRED_SIZE)
            .addComponent(snackicon42, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            
            
           );
    vGrouppanel_ButtonPanel1
 	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
 			.addComponent(snackicon32, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
 			.addComponent(snackheader12, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)      
 			.addComponent(snackicon42, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
 			);
    
    JLabel totalheader1 = new JLabel("   Order");
    totalheader1.setOpaque(true);
    totalheader1.setFont(new Font("Arial", Font.BOLD, 13));
    totalheader1.setHorizontalAlignment(SwingConstants.LEFT);
    totalheader1.setBackground(new Color(240,240,240));// Your background color

    
    totalheader4 = new JLabel("Count");
    totalheader4.setOpaque(true);
    totalheader4.setFont(new Font("Arial", Font.BOLD, 13));
    totalheader4.setHorizontalAlignment(SwingConstants.RIGHT);
    totalheader4.setBackground(new Color(240,240,240));// Your background color
    
    totalheader5 = new JLabel("Total(₹) ");
    totalheader5.setOpaque(true);
    totalheader5.setFont(new Font("Arial", Font.BOLD, 13));
    totalheader5.setHorizontalAlignment(SwingConstants.RIGHT);
    totalheader5.setBackground(new Color(240,240,240));// Your background color
    
    JLabel totalicon3 = new JLabel();
    totalicon3.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    JLabel totalicon4 = new JLabel();
    totalicon4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    
   
    
    
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
    		.addComponent(totalicon3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            .addComponent(totalheader1, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)
           .addComponent(totalheader4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)

            .addComponent(totalheader5, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
            .addComponent(totalicon4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            
            
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(totalicon3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
    			.addComponent(totalheader1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)    
    			.addComponent(totalheader4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)  
    			   
    			.addComponent(totalheader5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)  
    			.addComponent(totalicon4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
    			);
    
    ordertypebold("Delivery",0,0.00);
    addseperator();
    ordertypebold("Dine In",0,0.00);
    addseperator();
    ordertypebold("Pick Up",number,Double.parseDouble(sub_format));
    
    graypattern("Payment Mode");
    
    SubtotalfunctionPay();
    addtablevaluesNOSEP("   Cash",Double.parseDouble(sub_format));
    
    graypattern("Complimentary Orders");
    Subtotalfunction();
    addtablevaluesCount("   Count:", "0");
    addtablevaluesNOSEP("   Amount:", 0.00);
    graypattern("Sales Return Orders");
    Subtotalfunction();
    addtablevaluesCount("   Count:", "0");
    addtablevaluesNOSEP("   Amount:", 0.00);
    graypattern("Virtual Wallet Summary");
    SubtotalfunctionPay();
    addtablevaluesNOSEP1("   Records not available");
    graypattern("Expenses Summary");
    Subtotalfunctiondate();
    addtablevaluesNOSEP1("   Records not available");
    graypattern("Withdrawal Summary");
    Subtotalfunctiondate();
    addtablevaluesNOSEP1("   Records not available");
    graypattern("Cash Top-Up Summary");
    Subtotalfunctiondate();
    addtablevaluesNOSEP1("   Records not available");
    graypattern("Online Orders");
    
    
    JLabel header1 = new JLabel("   Payment Type");
    header1.setOpaque(true);
    header1.setFont(new Font("Arial", Font.BOLD, 13));
    header1.setHorizontalAlignment(SwingConstants.LEFT);
    header1.setBackground(new Color(240,240,240));// Your background color

    JLabel header2 = new JLabel("My Amount(₹)");
    header2.setOpaque(true);
    header2.setFont(new Font("Arial", Font.BOLD, 13));
    header2.setHorizontalAlignment(SwingConstants.LEFT);
    header2.setBackground(new Color(240,240,240));// Your background color
    
    JLabel header3 = new JLabel("Total(₹)");
    header3.setOpaque(true);
    header3.setFont(new Font("Arial", Font.BOLD, 13));
    header3.setHorizontalAlignment(SwingConstants.LEFT);
    header3.setBackground(new Color(240,240,240));// Your background color

//    header3.setBackground(Color.BLUE);// Your background color
 
    
    JLabel header5 = new JLabel("Orders ");
    header5.setOpaque(true);
    header5.setFont(new Font("Arial", Font.BOLD, 13));
    header5.setHorizontalAlignment(SwingConstants.RIGHT);
    header5.setBackground(new Color(240,240,240));// Your background color
    
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
    		.addComponent(icon3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            .addComponent(header1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
            .addComponent(header2, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
            .addComponent(header3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
            
            .addComponent(header5, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
            .addComponent(icon4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            
            
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(icon3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
    			.addComponent(header1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)    
    			.addComponent(header2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)    
    			.addComponent(header3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)     
    			   
    			.addComponent(header5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)  
    			.addComponent(icon4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
    			);
    
    addtablevaluesNOSEP1("   Records not available");
    Subtotalfunctioncustom("Advance Order(Success Orders)");
    addtablevaluesCount("   Count:", "0.00");
    addtablevaluesCount("   Today Recieved Amount:", "0.00");
    addtablevaluesNOSEP("   Total:", 0.00);
    Subtotalfunctioncustom("Advance Order(Memo)");
    addtablevaluesCount("   Count:", "0.00");
    addtablevaluesNOSEP("   Total:", 0.00);
    addseperator();
    
    
   
    
    JPanel blankPanel1 = new JPanel();
    blankPanel1.setBackground(Color.WHITE);  // Set background color
    blankPanel1.setBorder(null);  // Optional border
    
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(blankPanel1, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(blankPanel1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)            
                
    			);
    
    gl_panel_ButtonPanel1.setHorizontalGroup(hGrouppanel_ButtonPanel1);
    gl_panel_ButtonPanel1.setVerticalGroup(vGrouppanel_ButtonPanel1);
    updatePanelSize();
	
}

private void graypattern(String name) {
	 JLabel snackheader13 = new JLabel(" 	"+name);
	    snackheader13.setOpaque(true);
	    snackheader13.setFont(new Font("Arial", Font.BOLD, 13));
	    snackheader13.setHorizontalAlignment(SwingConstants.LEFT);
	    snackheader13.setBackground(Color.white);// Your background color
	    
	    JLabel snackicon33 = new JLabel();
	    snackicon33.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
	    JLabel snackicon43 = new JLabel();
	    snackicon43.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
	    
	 //   JSeparator separator4 = new JSeparator(); // Create a separator\
	 //   separator4.setBackground(Color.LIGHT_GRAY);
	    
	    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
	    		.addComponent(snackicon33, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
	            .addComponent(snackheader13, GroupLayout.PREFERRED_SIZE, 1078, GroupLayout.PREFERRED_SIZE)
	            .addComponent(snackicon43, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
	            
	            
	           );
	    vGrouppanel_ButtonPanel1
	 	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
	 			.addComponent(snackicon33, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
	 			.addComponent(snackheader13, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)      
	 			.addComponent(snackicon43, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
	 			);
}
private void Subtotalfunction() {
    // Create subtotal labels
    JLabel totalheader1 = new JLabel("   Order");
    totalheader1.setOpaque(true);
    totalheader1.setFont(new Font("Arial", Font.BOLD, 13));
    totalheader1.setHorizontalAlignment(SwingConstants.LEFT);
    totalheader1.setBackground(new Color(240, 240, 240));

    

    JLabel subtotalheader5 = new JLabel("Total(₹) "); // Adjust as necessary
    subtotalheader5.setOpaque(true);
    subtotalheader5.setFont(new Font("Arial", Font.BOLD, 13));
    subtotalheader5.setHorizontalAlignment(SwingConstants.RIGHT);
    subtotalheader5.setBackground(new Color(240, 240, 240));

    JLabel valueicon3 = new JLabel();
    valueicon3.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    JLabel valueicon4 = new JLabel();
    valueicon4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    
    JSeparator separator01 = new JSeparator(); // Create a separator\
    separator01.setBackground(Color.LIGHT_GRAY);
    
    // Add components to the layout
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup()
        .addGap(15)
        .addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
        .addComponent(totalheader1, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
        .addComponent(subtotalheader5, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
        .addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
    );

    vGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
            .addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        .addComponent(totalheader1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        .addComponent(subtotalheader5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        .addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
    );
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(separator01, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(separator01, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)            
                
    			);

   
    
    // Update layout groups
    gl_panel_ButtonPanel1.setHorizontalGroup(hGrouppanel_ButtonPanel1);
    gl_panel_ButtonPanel1.setVerticalGroup(vGrouppanel_ButtonPanel1);

    // Update panel size and refresh UI
//    updatePanelSize();
 
}
private void SubtotalfunctionPay() {
    // Create subtotal labels
    JLabel totalheader1 = new JLabel("   Payment Type");
    totalheader1.setOpaque(true);
    totalheader1.setFont(new Font("Arial", Font.BOLD, 13));
    totalheader1.setHorizontalAlignment(SwingConstants.LEFT);
    totalheader1.setBackground(new Color(240, 240, 240));

    

    JLabel subtotalheader5 = new JLabel("Total(₹) "); // Adjust as necessary
    subtotalheader5.setOpaque(true);
    subtotalheader5.setFont(new Font("Arial", Font.BOLD, 13));
    subtotalheader5.setHorizontalAlignment(SwingConstants.RIGHT);
    subtotalheader5.setBackground(new Color(240, 240, 240));

    JLabel valueicon3 = new JLabel();
    valueicon3.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    JLabel valueicon4 = new JLabel();
    valueicon4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    
    JSeparator separator01 = new JSeparator(); // Create a separator\
    separator01.setBackground(Color.LIGHT_GRAY);
    
    // Add components to the layout
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup()
        .addGap(15)
        .addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
        .addComponent(totalheader1, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
        .addComponent(subtotalheader5, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
        .addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
    );

    vGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
            .addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        .addComponent(totalheader1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        .addComponent(subtotalheader5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        .addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
    );
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(separator01, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(separator01, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)            
                
    			);

   
    
    // Update layout groups
    gl_panel_ButtonPanel1.setHorizontalGroup(hGrouppanel_ButtonPanel1);
    gl_panel_ButtonPanel1.setVerticalGroup(vGrouppanel_ButtonPanel1);

    // Update panel size and refresh UI
//    updatePanelSize();
 
}
private int getLastInvoiceNumber(String filepath) {
    // Pattern to match the INSERT INTO Invoices statement and extract invoice_number
    Pattern pattern = Pattern.compile("INSERT INTO Invoices \\(invoice_number\\) VALUES \\('([^']+)'\\);");

    int lastInvoiceNumber = -1;  // Initialize with a default value (e.g., -1 if no valid invoice is found)

    // Reading the file (assuming the data is in the provided filepath)
    try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
        String line;

        while ((line = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String invoiceNumberStr = matcher.group(1).trim();  // Capture the invoice_number as a string
                try {
                    lastInvoiceNumber = Integer.parseInt(invoiceNumberStr);  // Convert to integer
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing invoice number: " + invoiceNumberStr);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return lastInvoiceNumber;  // Return the last captured invoice_number as an integer
}

private void Subtotalfunctiondate() {
    // Create subtotal labels
    JLabel totalheader1 = new JLabel("   Date");
    totalheader1.setOpaque(true);
    totalheader1.setFont(new Font("Arial", Font.BOLD, 13));
    totalheader1.setHorizontalAlignment(SwingConstants.LEFT);
    totalheader1.setBackground(new Color(240, 240, 240));

    

    JLabel subtotalheader5 = new JLabel("Total(₹) "); // Adjust as necessary
    subtotalheader5.setOpaque(true);
    subtotalheader5.setFont(new Font("Arial", Font.BOLD, 13));
    subtotalheader5.setHorizontalAlignment(SwingConstants.RIGHT);
    subtotalheader5.setBackground(new Color(240, 240, 240));

    JLabel valueicon3 = new JLabel();
    valueicon3.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    JLabel valueicon4 = new JLabel();
    valueicon4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    
    JSeparator separator01 = new JSeparator(); // Create a separator\
    separator01.setBackground(Color.LIGHT_GRAY);
    
    // Add components to the layout
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup()
        .addGap(15)
        .addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
        .addComponent(totalheader1, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
        .addComponent(subtotalheader5, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
        .addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
    );

    vGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
            .addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        .addComponent(totalheader1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        .addComponent(subtotalheader5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        .addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
    );
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(separator01, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(separator01, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)            
                
    			);

   
    
    // Update layout groups
    gl_panel_ButtonPanel1.setHorizontalGroup(hGrouppanel_ButtonPanel1);
    gl_panel_ButtonPanel1.setVerticalGroup(vGrouppanel_ButtonPanel1);

    // Update panel size and refresh UI
//    updatePanelSize();
 
}
private void Subtotalfunctioncustom(String item) {
    // Create subtotal labels
    JLabel totalheader1 = new JLabel("   "+item);
    totalheader1.setOpaque(true);
    totalheader1.setFont(new Font("Arial", Font.BOLD, 13));
    totalheader1.setHorizontalAlignment(SwingConstants.LEFT);
    totalheader1.setBackground(new Color(240, 240, 240));

    

    JLabel subtotalheader5 = new JLabel(" "); // Adjust as necessary
    subtotalheader5.setOpaque(true);
    subtotalheader5.setFont(new Font("Arial", Font.BOLD, 13));
    subtotalheader5.setHorizontalAlignment(SwingConstants.RIGHT);
    subtotalheader5.setBackground(new Color(240, 240, 240));

    JLabel valueicon3 = new JLabel();
    valueicon3.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    JLabel valueicon4 = new JLabel();
    valueicon4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    
    JSeparator separator01 = new JSeparator(); // Create a separator\
    separator01.setBackground(Color.LIGHT_GRAY);
    
    // Add components to the layout
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup()
        .addGap(15)
        .addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
        .addComponent(totalheader1, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
        .addComponent(subtotalheader5, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
        .addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
    );

    vGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
            .addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        .addComponent(totalheader1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        .addComponent(subtotalheader5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        .addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
    );
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(separator01, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(separator01, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)            
                
    			);

   
    
    // Update layout groups
    gl_panel_ButtonPanel1.setHorizontalGroup(hGrouppanel_ButtonPanel1);
    gl_panel_ButtonPanel1.setVerticalGroup(vGrouppanel_ButtonPanel1);

    // Update panel size and refresh UI
//    updatePanelSize();
 
}

private void ordertypebold(String Name, Integer Qty, Double amt) {
	JLabel totalheader1 = new JLabel("   "+Name);
    totalheader1.setOpaque(true);
    totalheader1.setFont(new Font("Arial", Font.PLAIN, 13));
    totalheader1.setHorizontalAlignment(SwingConstants.LEFT);
    totalheader1.setBackground(Color.WHITE);// Your background color

    
    totalheader4 = new JLabel(Qty.toString());
    totalheader4.setOpaque(true);
    totalheader4.setFont(new Font("Arial", Font.PLAIN, 13));
    totalheader4.setHorizontalAlignment(SwingConstants.RIGHT);
    totalheader4.setBackground(Color.WHITE);// Your background color
    
    totalheader5 = new JLabel(String.format("%.2f", amt)+" ");
    totalheader5.setOpaque(true);
    totalheader5.setFont(new Font("Arial", Font.PLAIN, 13));
    totalheader5.setHorizontalAlignment(SwingConstants.RIGHT);
    totalheader5.setBackground(Color.WHITE);// Your background color
    
    JLabel totalicon3 = new JLabel();
    totalicon3.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    JLabel totalicon4 = new JLabel();
    totalicon4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    
   
    
    
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
    		.addComponent(totalicon3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            .addComponent(totalheader1, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)
           .addComponent(totalheader4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)

            .addComponent(totalheader5, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
            .addComponent(totalicon4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            
            
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(totalicon3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
    			.addComponent(totalheader1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)    
    			.addComponent(totalheader4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)  
    			   
    			.addComponent(totalheader5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)  
    			.addComponent(totalicon4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
    			);
    
}
private  void addseperator() {
	JSeparator separator01 = new JSeparator(); // Create a separator\
    separator01.setBackground(Color.LIGHT_GRAY);
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(separator01, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(separator01, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)            
                
    			);
   
}
private void addtablevalues(String itemname, Double amount) {
	JLabel valueheader1 = new JLabel(itemname);
    valueheader1.setOpaque(true);
    valueheader1.setFont(new Font("Arial", Font.PLAIN, 13));
    valueheader1.setHorizontalAlignment(SwingConstants.LEFT);
    valueheader1.setBackground(Color.WHITE);// Your background color

    
    
    JLabel valueheader5 = new JLabel(String.format("%.2f", amount)+" ");
    valueheader5.setOpaque(true);
    valueheader5.setFont(new Font("Arial", Font.PLAIN, 13));
    valueheader5.setHorizontalAlignment(SwingConstants.RIGHT);
    valueheader5.setBackground(Color.WHITE);// Your background color
    
    JLabel valueicon3 = new JLabel();
    valueicon3.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    JLabel valueicon4 = new JLabel();
    valueicon4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    
    JSeparator separator01 = new JSeparator(); // Create a separator\
    separator01.setBackground(Color.LIGHT_GRAY);
   
    
    
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
    		.addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueheader1, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueheader5, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            
            
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
    			.addComponent(valueheader1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)    
    			
    			.addComponent(valueheader5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)  
    			.addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
    			);
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(separator01, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(separator01, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)            
                
    			);
}
private void addtablevaluesNOSEP(String itemname, Double amount) {
	JLabel valueheader1 = new JLabel(itemname);
    valueheader1.setOpaque(true);
    valueheader1.setFont(new Font("Arial", Font.PLAIN, 13));
    valueheader1.setHorizontalAlignment(SwingConstants.LEFT);
    valueheader1.setBackground(Color.WHITE);// Your background color

    
    
    JLabel valueheader5 = new JLabel(String.format("%.2f", amount)+" ");
    valueheader5.setOpaque(true);
    valueheader5.setFont(new Font("Arial", Font.PLAIN, 13));
    valueheader5.setHorizontalAlignment(SwingConstants.RIGHT);
    valueheader5.setBackground(Color.WHITE);// Your background color
    
    JLabel valueicon3 = new JLabel();
    valueicon3.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    JLabel valueicon4 = new JLabel();
    valueicon4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
  
   
    
    
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
    		.addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueheader1, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueheader5, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            
            
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
    			.addComponent(valueheader1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)    
    			
    			.addComponent(valueheader5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)  
    			.addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
    			);
    
}
private void addtablevaluesNOSEP1(String itemname) {
	JLabel valueheader1 = new JLabel(itemname);
    valueheader1.setOpaque(true);
    valueheader1.setFont(new Font("Arial", Font.PLAIN, 13));
    valueheader1.setHorizontalAlignment(SwingConstants.LEFT);
    valueheader1.setBackground(Color.WHITE);// Your background color

    
    
    JLabel valueheader5 = new JLabel(" ");
    valueheader5.setOpaque(true);
    valueheader5.setFont(new Font("Arial", Font.PLAIN, 13));
    valueheader5.setHorizontalAlignment(SwingConstants.RIGHT);
    valueheader5.setBackground(Color.WHITE);// Your background color
    
    JLabel valueicon3 = new JLabel();
    valueicon3.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    JLabel valueicon4 = new JLabel();
    valueicon4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
  
   
    
    
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
    		.addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueheader1, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueheader5, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            
            
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
    			.addComponent(valueheader1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)    
    			
    			.addComponent(valueheader5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)  
    			.addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
    			);
    
}
private void addtablevaluesBOLD(String itemname, Double amount) {
	JLabel valueheader1 = new JLabel(itemname);
    valueheader1.setOpaque(true);
    valueheader1.setFont(new Font("Arial", Font.BOLD, 13));
    valueheader1.setHorizontalAlignment(SwingConstants.LEFT);
    valueheader1.setBackground(Color.WHITE);// Your background color

    
    
    JLabel valueheader5 = new JLabel(String.format("%.2f", amount)+" ");
    valueheader5.setOpaque(true);
    valueheader5.setFont(new Font("Arial", Font.PLAIN, 13));
    valueheader5.setHorizontalAlignment(SwingConstants.RIGHT);
    valueheader5.setBackground(Color.WHITE);// Your background color
    
    JLabel valueicon3 = new JLabel();
    valueicon3.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    JLabel valueicon4 = new JLabel();
    valueicon4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    
    JSeparator separator01 = new JSeparator(); // Create a separator\
    separator01.setBackground(Color.LIGHT_GRAY);
   
    
    
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
    		.addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueheader1, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueheader5, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            
            
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
    			.addComponent(valueheader1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)    
    			
    			.addComponent(valueheader5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)  
    			.addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
    			);
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(separator01, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(separator01, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)            
                
    			);
}
private void addtablevaluesCount(String itemname, String amount) {
	JLabel valueheader1 = new JLabel(itemname);
    valueheader1.setOpaque(true);
    valueheader1.setFont(new Font("Arial", Font.PLAIN, 13));
    valueheader1.setHorizontalAlignment(SwingConstants.LEFT);
    valueheader1.setBackground(Color.WHITE);// Your background color

    
    
    JLabel valueheader5 = new JLabel(amount+" ");
    valueheader5.setOpaque(true);
    valueheader5.setFont(new Font("Arial", Font.PLAIN, 13));
    valueheader5.setHorizontalAlignment(SwingConstants.RIGHT);
    valueheader5.setBackground(Color.WHITE);// Your background color
    
    JLabel valueicon3 = new JLabel();
    valueicon3.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    JLabel valueicon4 = new JLabel();
    valueicon4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    
    JSeparator separator01 = new JSeparator(); // Create a separator\
    separator01.setBackground(Color.LIGHT_GRAY);
   
    
    
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
    		.addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueheader1, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueheader5, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            
            
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
    			.addComponent(valueheader1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)    
    			
    			.addComponent(valueheader5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)  
    			.addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
    			);
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(separator01, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(separator01, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)            
                
    			);
}
private void updatePanelSize() {
    int totalHeight = 0;  // Variable to accumulate total height of components

    // Loop through all components in the panel
    for (Component component : panel.getComponents()) {
        Dimension preferredSize = component.getPreferredSize(); // Get the preferred size of each component
        totalHeight += preferredSize.height; // Add the height of the component to the total height
    }

    // Set the preferred size of the panel based on the total height
    panel.setPreferredSize(new Dimension(1125, totalHeight));
    
    // Revalidate and repaint the panel to apply changes
    panel.revalidate();
    panel.repaint();
}

private void getoriginaldata(String filepath) {
    // Pattern to match the SQL INSERT statement and extract relevant data (focusing on amount)
    Pattern pattern = Pattern.compile("INSERT INTO InvoiceDetails VALUES \\('[^']+', '[^']+', '[^']+', '[^']+', '[^']+', '([^']+)', '([^']+)'\\);");

    

    // Reading the file (assuming the data is in the provided filepath)
    try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
        String line;

        while ((line = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                double amount = Double.parseDouble(matcher.group(2).trim());
                originalTotalAmount += amount;  // Add amount to the total
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Display or return the total amount
    System.out.println("Total Amount of All Items: " + originalTotalAmount);
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


private void Excelreport() {
	 

     // Use JFileChooser to get the user-specified location
     JFileChooser fileChooser = new JFileChooser();
     fileChooser.setDialogTitle("Save CSV file");

     // Set default file name with .csv extension
     fileChooser.setSelectedFile(new File("data.csv"));

     // Restrict the file filter to .csv files only
     FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
     fileChooser.setFileFilter(filter);

     // Show save dialog; if approved, proceed to save the file
     int userSelection = fileChooser.showSaveDialog(null);

     if (userSelection == JFileChooser.APPROVE_OPTION) {
         File fileToSave = fileChooser.getSelectedFile();

         // Ensure the file has a ".csv" extension
         String filePath = fileToSave.getAbsolutePath();
         if (!filePath.endsWith(".csv")) {
             filePath += ".csv"; // Add .csv if the user didn't specify it
         }

         // Now write the data to the specified file
         try (FileWriter writer = new FileWriter(filePath)) {
             // Heading for Table 1
        	 Double sub=originalTotalAmount +((originalTotalAmount*0.05));
        	    String sub_format = String.format("%.0f", sub);
        	    Double round=(originalTotalAmount*0.05)/2;
        	    
        	    Double Roundoff = sub-Double.parseDouble(sub_format);
        	    System.out.println(Roundoff);
        	   
        	
             writer.append("Executive Sales Report -"+formattedDate+"\n");
             writer.append("\n");
             writer.append("Billing (Success)\n");
             writer.append("Order, , ,Total(Rs)\n");
             writer.append("Count:, , ,"+number+"\n");
             writer.append("Invoice Nos.:, , ,NA\n");
             writer.append("Sub Total:, , ,"+originalTotalAmount+"\n");
             writer.append("Discount:, , ,0.00\n");
             writer.append("Delivery Charge:, , ,0.00\n");
             writer.append("Container Charge:, , ,0.00\n");
             writer.append("Additional Charge:, , ,0.00\n");
             writer.append("SGST:, , ,"+round+"\n");
             writer.append("CGST:, , ,"+round+"\n");
             writer.append("Round Off:, , ,"+Roundoff+"\n");
             writer.append("Waived Off:, , ,0.00\n");
             writer.append("Grand Total:, , ,"+Double.parseDouble(sub_format)+"\n");
             writer.append("Net Sales:, , ,"+originalTotalAmount+"\n");
             
             writer.append("\n");
             writer.append("\n");
             writer.append("Billing (Cancel)\n");
             writer.append("Order, , ,Total(Rs)\n");
             writer.append("Count:, , ,0.00\n");
             writer.append("Amount:, , ,0.00\n");
             
             writer.append("\n");
             writer.append("\n");
             writer.append("Order Type\n");
             writer.append("Order, ,Count,Total(Rs)\n");
             writer.append("Delivery:, ,0.00 ,0.00\n");
             writer.append("Dine In:, ,0.00 ,0.00\n");
             writer.append("Pick Up:, ,"+number+","+Double.parseDouble(sub_format)+"\n");
             
             writer.append("\n");
             writer.append("\n");
             writer.append("Payment Mode\n");
             writer.append("Payment Type, , ,Total(Rs)\n");
             writer.append("Cash, , ,"+Double.parseDouble(sub_format) +"\n");
             
             writer.append("\n");
             writer.append("\n");
             writer.append("Complimentary Orders\n");
             writer.append("Order, , ,Total(Rs)\n");
             writer.append("Count:, , ,0.00\n");
             writer.append("Amount:, , ,0.00\n");
             
             writer.append("\n");
             writer.append("\n");
             writer.append("Sales Return Orders\n");
             writer.append("Order, , ,Total(Rs)\n");
             writer.append("Count:, , ,0.00\n");
             writer.append("Amount:, , ,0.00\n");
             
             writer.append("\n");
             writer.append("\n");
             writer.append("Virtual Wallet Summary\n");
             writer.append("Payment Type, , ,Total(Rs)\n");
             writer.append("Records not available\n");
             
             writer.append("\n");
             writer.append("\n");
             writer.append("Expenses Summary\n");
             writer.append("Date, , ,Total(Rs)\n");
             writer.append("Records not available\n");

             writer.append("\n");
             writer.append("\n");
             writer.append("Withdrawal Summary\n");
             writer.append("Date, , ,Total(Rs)\n");
             writer.append("Records not available\n");
             
             writer.append("\n");
             writer.append("\n");
             writer.append("Cash Top-Up Summary\n");
             writer.append("Date, , ,Total(Rs)\n");
             writer.append("Records not available\n");
             
             writer.append("\n");
             writer.append("\n");
             writer.append("Online Orders\n");
             writer.append("Payment Type, My Account(Rs),Total(Rs),Orders\n");
             writer.append("Records not available\n");
             
             writer.append("\n");
             writer.append("\n");
             writer.append("Advance Order(Success Orders)\n");
             writer.append("Count:, , ,0.00\n");
             writer.append("Today Recieved Amount:, , ,0.00\n");
             writer.append("Total:, , ,0.00\n");	
             
             writer.append("\n");
             writer.append("\n");
             writer.append("Advance Order(Memo)\n");
             writer.append("Count:, , ,0.00\n");
             writer.append("Total:, , ,0.00\n");	
             // Add a blank line before the next table
            

             System.out.println("CSV file saved successfully at: " + filePath);

         } catch (IOException e) {
             e.printStackTrace();
         }
     }
}

}	
