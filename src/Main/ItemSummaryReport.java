package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemSummaryReport extends JPanel {

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
	private ArrayList<Double> amounts = new ArrayList<>();
	private GroupLayout gl_panel_roundedPanel;
	private GroupLayout.ParallelGroup hGrouppanel_roundedPanel;
	private GroupLayout.SequentialGroup vGrouppanel_roundedPanel;
	private JLabel totalheader4;
	private JLabel totalheader5;
	private String filepathoriginal;
	
	private ArrayList<String> originalitemNames = new ArrayList<>();
	private ArrayList<Integer> originalquantities = new ArrayList<>();
	private ArrayList<Double> originalamounts = new ArrayList<>();
	private Integer originalTotalQuantity=0;
	private Double originalTotalAmount=0.00;
	
	
	private ArrayList<String> choupsey = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\choupsey.sql");
	private ArrayList<String> chooupseyitemNames = new ArrayList<>();
	private ArrayList<Integer> chooupseyquantities = new ArrayList<>();
	private ArrayList<Double> chooupseyamounts = new ArrayList<>();
	private Integer choupseyQuantity=0;
	private Double choupseyAmount=0.00;
	
	private ArrayList<String> drinks = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\drinks.sql");
	private ArrayList<String> drinksitemNames = new ArrayList<>();
	private ArrayList<Integer> drinksquantities = new ArrayList<>();
	private ArrayList<Double> drinksamounts = new ArrayList<>();
	private Integer drinksQuantity=0;
	private Double drinksAmount=0.00;
	
	private ArrayList<String> extras = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\extras.sql");
	private ArrayList<String> extrasitemNames = new ArrayList<>();
	private ArrayList<Integer> extrasquantities = new ArrayList<>();
	private ArrayList<Double> extrasamounts = new ArrayList<>();
	private Integer extrasQuantity=0;
	private Double extrasAmount=0.00;
	
	private ArrayList<String> healthyuttappa = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\healthyuttappa.sql");
	private ArrayList<String> healthyuttappaitemNames = new ArrayList<>();
	private ArrayList<Integer> healthyuttappaquantities = new ArrayList<>();
	private ArrayList<Double> healthyuttappaamounts = new ArrayList<>();
	private Integer healthyuttappaQuantity=0;
	private Double healthyuttappaAmount=0.00;
	
	private ArrayList<String> hot = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\hot.sql");
	private ArrayList<String> hotitemNames = new ArrayList<>();
	private ArrayList<Integer> hotquantities = new ArrayList<>();
	private ArrayList<Double> hotamounts = new ArrayList<>();
	private Integer hotQuantity=0;
	private Double hotAmount=0.00;
	
	private ArrayList<String> idli = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\idli.sql");
	private ArrayList<String> idliitemNames = new ArrayList<>();
	private ArrayList<Integer> idliquantities = new ArrayList<>();
	private ArrayList<Double> idliamounts = new ArrayList<>();
	private Integer idliQuantity=0;
	private Double idliAmount=0.00;
	
	private ArrayList<String> indian = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\indian.sql");
	private ArrayList<String> indianitemNames = new ArrayList<>();
	private ArrayList<Integer> indianquantities = new ArrayList<>();
	private ArrayList<Double> indianamounts = new ArrayList<>();
	private Integer indianQuantity=0;
	private Double indianAmount=0.00;
	
	private ArrayList<String> mexican = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\mexican.sql");
	private ArrayList<String> mexicanitemNames = new ArrayList<>();
	private ArrayList<Integer> mexicanquantities = new ArrayList<>();
	private ArrayList<Double> mexicanamounts = new ArrayList<>();
	private Integer mexicanQuantity=0;
	private Double mexicanAmount=0.00;
	
	private ArrayList<String> mexican_uttappa = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\mexican_uttappa.sql");
	private ArrayList<String> mexican_uttappaitemNames = new ArrayList<>();
	private ArrayList<Integer> mexican_uttappaquantities = new ArrayList<>();
	private ArrayList<Double> mexican_uttappaamounts = new ArrayList<>();
	private Integer mexican_uttappaQuantity=0;
	private Double mexican_uttappaAmount=0.00;
	
	private ArrayList<String> packaging = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\packaging.sql");
	private ArrayList<String> packagingitemNames = new ArrayList<>();
	private ArrayList<Integer> packagingquantities = new ArrayList<>();
	private ArrayList<Double> packagingamounts = new ArrayList<>();
	private Integer packagingQuantity=0;
	private Double packagingAmount=0.00;
	
	private ArrayList<String> paper = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\paper.sql");
	private ArrayList<String> paperitemNames = new ArrayList<>();
	private ArrayList<Integer> paperquantities = new ArrayList<>();
	private ArrayList<Double> paperamounts = new ArrayList<>();
	private Integer paperQuantity=0;
	private Double paperAmount=0.00;
	
	private ArrayList<String> rice = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\rice.sql");
	private ArrayList<String> riceitemNames = new ArrayList<>();
	private ArrayList<Integer> ricequantities = new ArrayList<>();
	private ArrayList<Double> riceamounts = new ArrayList<>();
	private Integer riceQuantity=0;
	private Double riceAmount=0.00;
	
	private ArrayList<String> russian_salad = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\russian_salad.sql");
	private ArrayList<String> russian_saladitemNames = new ArrayList<>();
	private ArrayList<Integer> russian_saladquantities = new ArrayList<>();
	private ArrayList<Double> russian_saladamounts = new ArrayList<>();
	private Integer russian_saladQuantity=0;
	private Double russian_saladAmount=0.00;
	
	private ArrayList<String> Snacks = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\Snacks.sql");
	private ArrayList<String> SnacksitemNames = new ArrayList<>();
	private ArrayList<Integer> Snacksquantities = new ArrayList<>();
	private ArrayList<Double> Snacksamounts = new ArrayList<>();
	private Integer SnacksQuantity=0;
	private Double SnacksAmount=0.00;
	
	private ArrayList<String> specialuttappa = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\specialuttappa.sql");
	private ArrayList<String> specialuttappaitemNames = new ArrayList<>();
	private ArrayList<Integer> specialuttappaquantities = new ArrayList<>();
	private ArrayList<Double> specialuttappaamounts = new ArrayList<>();
	private Integer specialuttappaQuantity=0;
	private Double specialuttappaAmount=0.00;
	
	private ArrayList<String> spicy_plaza = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\spicy_plaza.sql");
	private ArrayList<String> spicy_plazaitemNames = new ArrayList<>();
	private ArrayList<Integer> spicy_plazaquantities = new ArrayList<>();
	private ArrayList<Double> spicy_plazaamounts = new ArrayList<>();
	private Integer spicy_plazaQuantity=0;
	private Double spicy_plazaAmount=0.00;
	
	private ArrayList<String> thali = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\thali.sql");
	private ArrayList<String> thaliitemNames = new ArrayList<>();
	private ArrayList<Integer> thaliquantities = new ArrayList<>();
	private ArrayList<Double> thaliamounts = new ArrayList<>();
	private Integer thaliQuantity=0;
	private Double thaliAmount=0.00;
	
	private ArrayList<String> thin = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\thin.sql");
	private ArrayList<String> thinitemNames = new ArrayList<>();
	private ArrayList<Integer> thinquantities = new ArrayList<>();
	private ArrayList<Double> thinamounts = new ArrayList<>();
	private Integer thinQuantity=0;
	private Double thinAmount=0.00;

	private ArrayList<String> Traditional = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\Traditional.sql");
	private ArrayList<String> TraditionalitemNames = new ArrayList<>();
	private ArrayList<Integer> Traditionalquantities = new ArrayList<>();
	private ArrayList<Double> Traditionalamounts = new ArrayList<>();
	private Integer TraditionalQuantity=0;
	private Double TraditionalAmount=0.00;
	private String formattedDate;




	
    public ItemSummaryReport() {
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
         
         getoriginaldata(filepathoriginal);
         getchoupseydata();
         getdrinksdata();
         getextrasdata(); 
         gethealthyuttappadata();
         gethotdata();
         getidlidata();
         getindiandata();
         getmexicandata();
         getmexican_uttappadata();
         getpackagingdata();
         getpaperdata();
         getricedata();
         getrussian_saladdata();
         getspecialuttappadata();
         getSnacksdata();
         getspicy_plazadata();
         getthalidata();
         getthindata();

         getTraditionaldata();




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
	JLabel labelgeneratebill = new JLabel("Item Report");

    labelgeneratebill.setFont(new Font("Arial", Font.BOLD, 20));
    
   

    // Align label to the left using Alignment.LEADING
    hGrouppanel_generatebill.addGroup(gl_panel_generate_bill.createSequentialGroup()
    		.addGap(20)
            .addComponent(labelgeneratebill, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
           
            );
    
    vGrouppanel_generatebill.addGap(5)
    		.addGroup(gl_panel_generate_bill.createParallelGroup(Alignment.BASELINE)
        		.addComponent(labelgeneratebill, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        		
    		);

    gl_panel_generate_bill.setHorizontalGroup(hGrouppanel_generatebill);
    gl_panel_generate_bill.setVerticalGroup(vGrouppanel_generatebill);
    

}
private void buttonPanel1function() {
	RoundButtonGray button42 = new RoundButtonGray("  Monthly Report");
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
    
    JPanel roundedPanel = new JPanel();
    roundedPanel.setBackground(Color.WHITE);  // Set background color
    roundedPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));  // Optional border
    gl_panel_roundedPanel = new GroupLayout(roundedPanel);
    roundedPanel.setLayout(gl_panel_roundedPanel);
    hGrouppanel_roundedPanel=gl_panel_roundedPanel.createParallelGroup(Alignment.LEADING);
    vGrouppanel_roundedPanel=gl_panel_roundedPanel.createSequentialGroup();
    
    
    RoundButton button2 = new RoundButton("Columns");
    button2.setBorder(null);
    button2.setFont(new Font("Arial", Font.BOLD, 14));
    button2.setBackground(new Color(238, 52, 70, 255)); // Set the background color
    button2.setForeground(Color.WHITE); // Set the text color
    
    RoundButton1 button4 = new RoundButton1("Save Preferences");
    button4.setBorder(null);
    button4.setFont(new Font("Arial", Font.PLAIN, 14));
    button4.setBackground(Color.WHITE); // Set the background color
    button4.setForeground(Color.BLACK); // Set the text color
    
    RoundButton1 button41 = new RoundButton1("Export Excel");
    button41.setBorder(null);
    button41.setFont(new Font("Arial", Font.PLAIN, 14));
    button41.setBackground(Color.WHITE); // Set the background color
    button41.setForeground(Color.BLACK); // Set the text color
    
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
    
    
    JLabel itemreport = new JLabel("   Item Report");
    itemreport.setOpaque(true);
    itemreport.setFont(new Font("Arial", Font.BOLD, 13));
    itemreport.setHorizontalAlignment(SwingConstants.LEFT);
    itemreport.setBackground(new Color(249,249,249));// Your background color
    
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    formattedDate = currentDate.format(formatter);
    
    JLabel datelabel = new JLabel("- "+formattedDate);
    datelabel.setOpaque(true);
    datelabel.setFont(new Font("Arial", Font.PLAIN, 13));
    datelabel.setHorizontalAlignment(SwingConstants.LEFT);
    datelabel.setBackground(new Color(249,249,249));// Your background color
    
    button41.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	Excelreport();
        }
    });
    
    button42.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	SQLItemExtractorCUSTOM.main(null);
        }
    });
    
    hGrouppanel_roundedPanel.addGroup(gl_panel_roundedPanel.createSequentialGroup().addGap(8)
            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE).addGap(10)
            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE).addGap(580)

            .addComponent(button41, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)  .addGap(10)

            .addComponent(button411, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)  
            
            
            );
    
    vGrouppanel_roundedPanel.addGap(10)
    	.addGroup(gl_panel_roundedPanel.createParallelGroup(Alignment.CENTER)
    			.addComponent(button2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)      
    			.addComponent(button4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)    
    			.addComponent(button41, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)          
                
    			.addComponent(button411, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)            
                );
    
    gl_panel_roundedPanel.setHorizontalGroup(hGrouppanel_roundedPanel);
    gl_panel_roundedPanel.setVerticalGroup(vGrouppanel_roundedPanel);
    
    
    
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(button421, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE).addGap(15)
            .addComponent(button42, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)            
            
            );
    
    vGrouppanel_ButtonPanel1.addGap(10)
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(button421, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)            
                
    			.addComponent(button42, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)            
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
            .addComponent(itemreport, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
            .addComponent(datelabel, GroupLayout.PREFERRED_SIZE, 988, GroupLayout.PREFERRED_SIZE)
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
    
    JLabel header1 = new JLabel("   Category");
    header1.setOpaque(true);
    header1.setFont(new Font("Arial", Font.BOLD, 13));
    header1.setHorizontalAlignment(SwingConstants.LEFT);
    header1.setBackground(new Color(240,240,240));// Your background color

    JLabel header2 = new JLabel("Item");
    header2.setOpaque(true);
    header2.setFont(new Font("Arial", Font.BOLD, 13));
    header2.setHorizontalAlignment(SwingConstants.LEFT);
    header2.setBackground(new Color(240,240,240));// Your background color
    
    JLabel header3 = new JLabel("Code");
    header3.setOpaque(true);
    header3.setFont(new Font("Arial", Font.BOLD, 13));
    header3.setHorizontalAlignment(SwingConstants.LEFT);
    header3.setBackground(new Color(240,240,240));// Your background color

//    header3.setBackground(Color.BLUE);// Your background color
    
    JLabel header4 = new JLabel("Qty.");
    header4.setOpaque(true);
    header4.setFont(new Font("Arial", Font.BOLD, 13));
    header4.setHorizontalAlignment(SwingConstants.RIGHT);
    header4.setBackground(new Color(240,240,240));// Your background color
    
    JLabel header5 = new JLabel("Total(₹) ");
    header5.setOpaque(true);
    header5.setFont(new Font("Arial", Font.BOLD, 13));
    header5.setHorizontalAlignment(SwingConstants.RIGHT);
    header5.setBackground(new Color(240,240,240));// Your background color
    
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
    		.addComponent(icon3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            .addComponent(header1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
            .addComponent(header2, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
            .addComponent(header3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
            .addComponent(header4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)

            .addComponent(header5, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
            .addComponent(icon4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            
            
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(icon3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
    			.addComponent(header1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)    
    			.addComponent(header2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)    
    			.addComponent(header3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)     
    			.addComponent(header4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)  
    			   
    			.addComponent(header5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)  
    			.addComponent(icon4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
    			);
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(separator2, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(separator2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)            
                
    			);
    
    JLabel totalheader1 = new JLabel("   Total");
    totalheader1.setOpaque(true);
    totalheader1.setFont(new Font("Arial", Font.BOLD, 13));
    totalheader1.setHorizontalAlignment(SwingConstants.LEFT);
    totalheader1.setBackground(new Color(240,240,240));// Your background color

    JLabel totalheader2 = new JLabel("-");
    totalheader2.setOpaque(true);
    totalheader2.setFont(new Font("Arial", Font.BOLD, 16));
    totalheader2.setHorizontalAlignment(SwingConstants.LEFT);
    totalheader2.setBackground(new Color(240,240,240));// Your background color
    
    JLabel totalheader3 = new JLabel("-");
    totalheader3.setOpaque(true);
    totalheader3.setFont(new Font("Arial", Font.BOLD, 16));
    totalheader3.setHorizontalAlignment(SwingConstants.LEFT);
    totalheader3.setBackground(new Color(240,240,240));// Your background color

//    header3.setBackground(Color.BLUE);// Your background color
    
    totalheader4 = new JLabel(originalTotalQuantity.toString());
    totalheader4.setOpaque(true);
    totalheader4.setFont(new Font("Arial", Font.BOLD, 13));
    totalheader4.setHorizontalAlignment(SwingConstants.RIGHT);
    totalheader4.setBackground(new Color(240,240,240));// Your background color
    
    totalheader5 = new JLabel(String.format("%.2f", originalTotalAmount)+" ");
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
            .addComponent(totalheader1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
            .addComponent(totalheader2, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
            .addComponent(totalheader3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
            .addComponent(totalheader4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)

            .addComponent(totalheader5, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
            .addComponent(totalicon4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            
            
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(totalicon3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
    			.addComponent(totalheader1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)    
    			.addComponent(totalheader2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)    
    			.addComponent(totalheader3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)     
    			.addComponent(totalheader4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)  
    			   
    			.addComponent(totalheader5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)  
    			.addComponent(totalicon4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
    			);
    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
            .addComponent(separator3, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(separator3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)            
                
    			);
    
    addheadervalues("Snacks");
    for(int i=0;i<SnacksitemNames.size();i++) {
    	addtablevalues(SnacksitemNames.get(i),Snacksquantities.get(i),Snacksamounts.get(i));
    }


    Subtotalfunction(SnacksQuantity,SnacksAmount);
    
    
    addheadervalues("Tradiitional Masala Plaza");

for(int i=0;i<TraditionalitemNames.size();i++) {
	addtablevalues(TraditionalitemNames.get(i),Traditionalquantities.get(i),Traditionalamounts.get(i));
}
    Subtotalfunction(TraditionalQuantity,TraditionalAmount);
    
    
    addheadervalues("Thin & Crispy Dosas");

for(int i=0;i<thinitemNames.size();i++) {
	addtablevalues(thinitemNames.get(i),thinquantities.get(i),thinamounts.get(i));
}

    Subtotalfunction(thinQuantity,thinAmount);
    
    
    addheadervalues("Chopsuey Plaza");
    for(int i=0;i<chooupseyitemNames.size();i++) {
    	addtablevalues(chooupseyitemNames.get(i),chooupseyquantities.get(i),chooupseyamounts.get(i));
    }
    Subtotalfunction(choupseyQuantity,choupseyAmount);

    
    addheadervalues("Spicy Plaza");
    for(int i=0;i<spicy_plazaitemNames.size();i++) {
    	addtablevalues(spicy_plazaitemNames.get(i),spicy_plazaquantities.get(i),spicy_plazaamounts.get(i));
    }


    Subtotalfunction(spicy_plazaQuantity,spicy_plazaAmount);
    
    
    addheadervalues("Mexican Style Dosas");
    for(int i=0;i<mexicanitemNames.size();i++) {
    	addtablevalues(mexicanitemNames.get(i),mexicanquantities.get(i),mexicanamounts.get(i));
    }
    Subtotalfunction(mexicanQuantity,mexicanAmount);
    
    
    addheadervalues("Mexican Uttappas");
    for(int i=0;i<mexican_uttappaitemNames.size();i++) {
    	addtablevalues(mexican_uttappaitemNames.get(i),mexican_uttappaquantities.get(i),mexican_uttappaamounts.get(i));
    }
    Subtotalfunction(mexican_uttappaQuantity,mexican_uttappaAmount);
    
    addheadervalues("Paper Plaza");
    for(int i=0;i<paperitemNames.size();i++) {
    	addtablevalues(paperitemNames.get(i),paperquantities.get(i),paperamounts.get(i));
    }
 
    Subtotalfunction(paperQuantity,paperAmount);
    
    
    addheadervalues("Healthy Uttappas");
    for(int i=0;i<healthyuttappaitemNames.size();i++) {
    	addtablevalues(healthyuttappaitemNames.get(i),healthyuttappaquantities.get(i),healthyuttappaamounts.get(i));
    }
    Subtotalfunction(healthyuttappaQuantity,healthyuttappaAmount);
    
    
    addheadervalues("Special Uttappas");
    for(int i=0;i<specialuttappaitemNames.size();i++) {
    	addtablevalues(specialuttappaitemNames.get(i),specialuttappaquantities.get(i),specialuttappaamounts.get(i));
    }

    Subtotalfunction(specialuttappaQuantity,specialuttappaAmount);
    
    addheadervalues("Chinnese Style Idli");
    for(int i=0;i<idliitemNames.size();i++) {
    	addtablevalues(idliitemNames.get(i),idliquantities.get(i),idliamounts.get(i));
    }
    Subtotalfunction(idliQuantity,idliAmount);
    
    addheadervalues("Rice Plaza");
    for(int i=0;i<riceitemNames.size();i++) {
    	addtablevalues(riceitemNames.get(i),ricequantities.get(i),riceamounts.get(i));
    }

    Subtotalfunction(riceQuantity,riceAmount);
    
    addheadervalues("SOFT DRINKS");
    for(int i=0;i<drinksitemNames.size();i++) {
    	addtablevalues(drinksitemNames.get(i),drinksquantities.get(i),drinksamounts.get(i));
    }
    Subtotalfunction(drinksQuantity,drinksAmount);
    
    addheadervalues("Russian Salad Dosas");
    for(int i=0;i<russian_saladitemNames.size();i++) {
    	addtablevalues(russian_saladitemNames.get(i),russian_saladquantities.get(i),russian_saladamounts.get(i));
    }

   
    Subtotalfunction(russian_saladQuantity,russian_saladAmount);
    
    addheadervalues("Indian Style Dosas");
    for(int i=0;i<indianitemNames.size();i++) {
    	addtablevalues(indianitemNames.get(i),indianquantities.get(i),indianamounts.get(i));
    }
    Subtotalfunction(indianQuantity,indianAmount);
    
    addheadervalues("Thali Items");
    for(int i=0;i<thaliitemNames.size();i++) {
    	addtablevalues(thaliitemNames.get(i),thaliquantities.get(i),thaliamounts.get(i));
    }
    Subtotalfunction(thaliQuantity,thaliAmount);
    
    addheadervalues("Hot & Cold");
    for(int i=0;i<hotitemNames.size();i++) {
    	addtablevalues(hotitemNames.get(i),hotquantities.get(i),hotamounts.get(i));
    }
    Subtotalfunction(hotQuantity,hotAmount);
    
    addheadervalues("Packing Charges");
    for(int i=0;i<packagingitemNames.size();i++) {
    	addtablevalues(packagingitemNames.get(i),packagingquantities.get(i),packagingamounts.get(i));
    }


    Subtotalfunction(packagingQuantity,packagingAmount);
    
    addheadervalues("Extras");
    for(int i=0;i<extrasitemNames.size();i++) {
    	addtablevalues(extrasitemNames.get(i),extrasquantities.get(i),extrasamounts.get(i));
    }
    Subtotalfunction(extrasQuantity,extrasAmount);
    
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
private void Subtotalfunction(Integer quantity, Double Amount) {
    // Create subtotal labels
    JLabel totalheader1 = new JLabel("   Sub Total");
    totalheader1.setOpaque(true);
    totalheader1.setFont(new Font("Arial", Font.BOLD, 13));
    totalheader1.setHorizontalAlignment(SwingConstants.LEFT);
    totalheader1.setBackground(new Color(240, 240, 240));

    JLabel subtotalheader4 = new JLabel(quantity.toString()); // Use the passed Amount
    subtotalheader4.setOpaque(true);
    subtotalheader4.setFont(new Font("Arial", Font.BOLD, 13));
    subtotalheader4.setHorizontalAlignment(SwingConstants.RIGHT);
    subtotalheader4.setBackground(new Color(240, 240, 240));

    JLabel subtotalheader5 = new JLabel(String.format("%.2f",(Amount))+" "); // Adjust as necessary
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
        .addComponent(totalheader1, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)
        .addComponent(subtotalheader4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
        .addComponent(subtotalheader5, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
        .addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
    );

    vGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
            .addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        .addComponent(totalheader1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        .addComponent(subtotalheader4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
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
private void addtablevalues(String itemname,Integer quantity, Double amount) {
	JLabel valueheader1 = new JLabel("");
    valueheader1.setOpaque(true);
    valueheader1.setFont(new Font("Arial", Font.PLAIN, 13));
    valueheader1.setHorizontalAlignment(SwingConstants.LEFT);
    valueheader1.setBackground(Color.WHITE);// Your background color

    JLabel valueheader2 = new JLabel(itemname);
    valueheader2.setOpaque(true);
    valueheader2.setFont(new Font("Arial", Font.PLAIN, 13));
    valueheader2.setHorizontalAlignment(SwingConstants.LEFT);
    valueheader2.setBackground(Color.WHITE);// Your background color
    
    JLabel valueheader3 = new JLabel("#");
    valueheader3.setOpaque(true);
    valueheader3.setFont(new Font("Arial", Font.PLAIN, 13));
    valueheader3.setHorizontalAlignment(SwingConstants.LEFT);
    valueheader3.setBackground(Color.WHITE);// Your background color

//    header3.setBackground(Color.BLUE);// Your background color
    
    JLabel valueheader4 = new JLabel(quantity.toString());
    valueheader4.setOpaque(true);
    valueheader4.setFont(new Font("Arial", Font.PLAIN, 13));
    valueheader4.setHorizontalAlignment(SwingConstants.RIGHT);
    valueheader4.setBackground(Color.WHITE);// Your background color
    
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
            .addComponent(valueheader1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueheader2, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueheader3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueheader4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)

            .addComponent(valueheader5, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
            .addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
            
            
           );
    
    vGrouppanel_ButtonPanel1
    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
    			.addComponent(valueicon3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
    			.addComponent(valueheader1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)    
    			.addComponent(valueheader2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)    
    			.addComponent(valueheader3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)     
    			.addComponent(valueheader4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)  
    			   
    			.addComponent(valueheader5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)  
    			.addComponent(valueicon4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
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

private void addheadervalues(String heading) {
	JLabel snackheader1 = new JLabel("  "+heading);
    snackheader1.setOpaque(true);
    snackheader1.setFont(new Font("Arial", Font.BOLD, 15));
    snackheader1.setHorizontalAlignment(SwingConstants.LEFT);
    snackheader1.setBackground(Color.white);// Your background color
    
    JLabel snackicon3 = new JLabel();
    snackicon3.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    JLabel snackicon4 = new JLabel();
    snackicon4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
    
    JSeparator separator4 = new JSeparator(); // Create a separator\
    separator4.setBackground(Color.LIGHT_GRAY);
    
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
}

private void getoriginaldata(String filepath) {
	 // Pattern to match the SQL INSERT statement and extract relevant data
    Pattern pattern = Pattern.compile("INSERT INTO InvoiceDetails VALUES \\('[^']+', '[^']+', '[^']+', '([^']+)', '[^']+', '([^']+)', '([^']+)'\\);");

    // Reading the file (assuming the data is in "invoice.sql")
    try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
        String line;
        
        while ((line = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String itemName = matcher.group(1).trim();
                int quantity = Integer.parseInt(matcher.group(2).trim());
                double amount = Double.parseDouble(matcher.group(3).trim());

                // Check if item already exists in the itemNames list
                int index = originalitemNames.indexOf(itemName);

                if (index != -1) { // Item exists, update quantity and amount
                    originalquantities.set(index, originalquantities.get(index) + quantity);
                    originalamounts.set(index, originalamounts.get(index) + amount);
                } else { // New item, add it to the lists
                    originalitemNames.add(itemName);
                    originalquantities.add(quantity);
                    originalamounts.add(amount);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Display the processed data
    for (int i = 0; i < originalitemNames.size(); i++) {
        originalTotalQuantity+=originalquantities.get(i) ;
        originalTotalAmount+=originalamounts.get(i);
    }

}

private void getchoupseydata() {
	for(int i=0;i<originalitemNames.size();i++) {
		String name = originalitemNames.get(i);
		if(choupsey.contains(name)) {
			chooupseyitemNames.add(name);
			chooupseyquantities.add(originalquantities.get(i));
			chooupseyamounts.add(originalamounts.get(i));
			choupseyQuantity+=originalquantities.get(i);
			choupseyAmount+=originalamounts.get(i);
		}
		
	}
}
private void getspicy_plazadata() {
for(int i=0;i<originalitemNames.size();i++) {
	String name = originalitemNames.get(i);
	if(spicy_plaza.contains(name)) {
		spicy_plazaitemNames.add(name);
		spicy_plazaquantities.add(originalquantities.get(i));
		spicy_plazaamounts.add(originalamounts.get(i));
		spicy_plazaQuantity+=originalquantities.get(i);
		spicy_plazaAmount+=originalamounts.get(i);
	}
	
}
}
private void getindiandata() {
	for(int i=0;i<originalitemNames.size();i++) {
		String name = originalitemNames.get(i);
		if(indian.contains(name)) {
			indianitemNames.add(name);
			indianquantities.add(originalquantities.get(i));
			indianamounts.add(originalamounts.get(i));
			indianQuantity+=originalquantities.get(i);
			indianAmount+=originalamounts.get(i);
		}
		
	}
}
private void getpackagingdata() {
	for(int i=0;i<originalitemNames.size();i++) {
		String name = originalitemNames.get(i);
		if(packaging.contains(name)) {
			packagingitemNames.add(name);
			packagingquantities.add(originalquantities.get(i));
			packagingamounts.add(originalamounts.get(i));
			packagingQuantity+=originalquantities.get(i);
			packagingAmount+=originalamounts.get(i);
		}
		
	}
}

private void getspecialuttappadata() {
	for(int i=0;i<originalitemNames.size();i++) {
		String name = originalitemNames.get(i);
		if(specialuttappa.contains(name)) {
			specialuttappaitemNames.add(name);
			specialuttappaquantities.add(originalquantities.get(i));
			specialuttappaamounts.add(originalamounts.get(i));
			specialuttappaQuantity+=originalquantities.get(i);
			specialuttappaAmount+=originalamounts.get(i);
		}
		
	}
}
private void getSnacksdata() {
	for(int i=0;i<originalitemNames.size();i++) {
		String name = originalitemNames.get(i);
		if(Snacks.contains(name)) {
			SnacksitemNames.add(name);
			Snacksquantities.add(originalquantities.get(i));
			Snacksamounts.add(originalamounts.get(i));
			SnacksQuantity+=originalquantities.get(i);
			SnacksAmount+=originalamounts.get(i);
		}
		
	}
}
private void getdrinksdata() {
	for(int i=0;i<originalitemNames.size();i++) {
		String name = originalitemNames.get(i);
		if(drinks.contains(name)) {
			drinksitemNames.add(name);
			drinksquantities.add(originalquantities.get(i));
			drinksamounts.add(originalamounts.get(i));
			drinksQuantity+=originalquantities.get(i);
			drinksAmount+=originalamounts.get(i);
		}
		
	}
}

private void getpaperdata() {
for(int i=0;i<originalitemNames.size();i++) {
	String name = originalitemNames.get(i);
	if(paper.contains(name)) {
		paperitemNames.add(name);
		paperquantities.add(originalquantities.get(i));
		paperamounts.add(originalamounts.get(i));
		paperQuantity+=originalquantities.get(i);
		paperAmount+=originalamounts.get(i);
	}
	
}
}  
private void getricedata() {
for(int i=0;i<originalitemNames.size();i++) {
	String name = originalitemNames.get(i);
	if(rice.contains(name)) {
		riceitemNames.add(name);
		ricequantities.add(originalquantities.get(i));
		riceamounts.add(originalamounts.get(i));
		riceQuantity+=originalquantities.get(i);
		riceAmount+=originalamounts.get(i);
	}
	
}
}
private void getrussian_saladdata() {
    for(int i=0;i<originalitemNames.size();i++) {
    	String name = originalitemNames.get(i);
    	if(russian_salad.contains(name)) {
    		russian_saladitemNames.add(name);
    		russian_saladquantities.add(originalquantities.get(i));
    		russian_saladamounts.add(originalamounts.get(i));
    		russian_saladQuantity+=originalquantities.get(i);
			russian_saladAmount+=originalamounts.get(i);
    	}
    	
    }
    } 
private void gethotdata() {
	for(int i=0;i<originalitemNames.size();i++) {
		String name = originalitemNames.get(i);
		if(hot.contains(name)) {
			hotitemNames.add(name);
			hotquantities.add(originalquantities.get(i));
			hotamounts.add(originalamounts.get(i));
			hotQuantity+=originalquantities.get(i);
			hotAmount+=originalamounts.get(i);
		}
		
	}
}

private void getthalidata() {
	for(int i=0;i<originalitemNames.size();i++) {
		String name = originalitemNames.get(i);
		if(thali.contains(name)) {
			thaliitemNames.add(name);
			thaliquantities.add(originalquantities.get(i));
			thaliamounts.add(originalamounts.get(i));
			thaliQuantity+=originalquantities.get(i);
			thaliAmount+=originalamounts.get(i);
		}
		
	}
}

private void getthindata() {
	for(int i=0;i<originalitemNames.size();i++) {
		String name = originalitemNames.get(i);
		if(thin.contains(name)) {
			thinitemNames.add(name);
			thinquantities.add(originalquantities.get(i));
			thinamounts.add(originalamounts.get(i));
			thinQuantity+=originalquantities.get(i);
			thinAmount+=originalamounts.get(i);
		}
		
	}
}
	private void getTraditionaldata() {
	for(int i=0;i<originalitemNames.size();i++) {
		String name = originalitemNames.get(i);
		if(Traditional.contains(name)) {
			TraditionalitemNames.add(name);
			Traditionalquantities.add(originalquantities.get(i));
			Traditionalamounts.add(originalamounts.get(i));
			TraditionalQuantity+=originalquantities.get(i);
			TraditionalAmount+=originalamounts.get(i);
		}
		
	}
}
private void getextrasdata() {
	for(int i=0;i<originalitemNames.size();i++) {
		String name = originalitemNames.get(i);
		if(extras.contains(name)) {
			extrasitemNames.add(name);
			extrasquantities.add(originalquantities.get(i));
			extrasamounts.add(originalamounts.get(i));
			extrasQuantity+=originalquantities.get(i);
			extrasAmount+=originalamounts.get(i);
		}
		
	}
}
private void gethealthyuttappadata() {
	for(int i=0;i<originalitemNames.size();i++) {
		String name = originalitemNames.get(i);
		if(healthyuttappa.contains(name)) {
			healthyuttappaitemNames.add(name);
			healthyuttappaquantities.add(originalquantities.get(i));
			healthyuttappaamounts.add(originalamounts.get(i));
			healthyuttappaQuantity+=originalquantities.get(i);
			healthyuttappaAmount+=originalamounts.get(i);
		}
		
	}
}
private void getmexicandata() {
	for(int i=0;i<originalitemNames.size();i++) {
		String name = originalitemNames.get(i);
		if(mexican.contains(name)) {
			mexicanitemNames.add(name);
			mexicanquantities.add(originalquantities.get(i));
			mexicanamounts.add(originalamounts.get(i));
			mexicanQuantity+=originalquantities.get(i);
			mexicanAmount+=originalamounts.get(i);
		}
		
	}
}
private void getmexican_uttappadata() {
	for(int i=0;i<originalitemNames.size();i++) {
		String name = originalitemNames.get(i);
		if(mexican_uttappa.contains(name)) {
			mexican_uttappaitemNames.add(name);
			mexican_uttappaquantities.add(originalquantities.get(i));
			mexican_uttappaamounts.add(originalamounts.get(i));
			mexican_uttappaQuantity+=originalquantities.get(i);
			mexican_uttappaAmount+=originalamounts.get(i);
		}
		
	}
}
private void getidlidata() {
	for(int i=0;i<originalitemNames.size();i++) {
		String name = originalitemNames.get(i);
		if(idli.contains(name)) {
			idliitemNames.add(name);
			idliquantities.add(originalquantities.get(i));
			idliamounts.add(originalamounts.get(i));
			idliQuantity+=originalquantities.get(i);
			idliAmount+=originalamounts.get(i);
		}
		
	}
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
     fileChooser.setDialogTitle("Save Daily Report");

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
             writer.append("Item Report -"+formattedDate+"\n");
             writer.append("\n");
             writer.append("Category,Item,Code,Qty.,Total(Rs)\n");
             writer.append("\n");
             writer.append("Total,-,-," + originalTotalQuantity + ","+originalTotalAmount +"\n");
             writer.append("\n");
             // Write Table 1 header
             writer.append("Snacks\n");
            
             // Write Table 1 data rows
             for (int i = 0; i < SnacksitemNames.size() ; i++) {
            	 writer.append(""+","+SnacksitemNames.get(i)+","+","+Snacksquantities.get(i)+","+Snacksamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + SnacksQuantity + ","+SnacksAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
             
             // Write Table 1 header
             writer.append("Tradiitional Masala Plaza\n");
            
             // Write Table 1 data rows
             for (int i = 0; i < TraditionalitemNames.size() ; i++) {
            	 writer.append(""+","+TraditionalitemNames.get(i)+","+","+Traditionalquantities.get(i)+","+Traditionalamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + TraditionalQuantity + ","+TraditionalAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
             
             // Write Table 1 header
             writer.append("Thin & Crispy Dosas\n");	
             // Write Table 1 data rows
             for (int i = 0; i < thinitemNames.size() ; i++) {
            	 writer.append(""+","+thinitemNames.get(i)+","+","+thinquantities.get(i)+","+thinamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + thinQuantity + ","+thinAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
             
             // Write Table 1 header
             writer.append("Chopsuey Plaza\n");
             // Write Table 1 data rows
             for (int i = 0; i < chooupseyitemNames.size() ; i++) {
            	 writer.append(""+","+chooupseyitemNames.get(i)+","+","+chooupseyquantities.get(i)+","+chooupseyamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + choupseyQuantity + ","+choupseyAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
             
             
             // Write Table 1 header
             writer.append("Spicy Plaza\n");
             // Write Table 1 data rows
             for (int i = 0; i < spicy_plazaitemNames.size() ; i++) {
            	 writer.append(""+","+spicy_plazaitemNames.get(i)+","+","+spicy_plazaquantities.get(i)+","+spicy_plazaamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + spicy_plazaQuantity + ","+spicy_plazaAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
             
             // Write Table 1 header
             writer.append("Mexican Style Dosas\n");
             // Write Table 1 data rows
             for (int i = 0; i < mexicanitemNames.size() ; i++) {
            	 writer.append(""+","+mexicanitemNames.get(i)+","+","+mexicanquantities.get(i)+","+mexicanamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + mexicanQuantity + ","+mexicanAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
             
             // Write Table 1 header
             writer.append("Mexican Uttappas\n");
             // Write Table 1 data rows
             for (int i = 0; i < mexican_uttappaitemNames.size() ; i++) {
            	 writer.append(""+","+mexican_uttappaitemNames.get(i)+","+","+mexican_uttappaquantities.get(i)+","+mexican_uttappaamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + mexican_uttappaQuantity + ","+mexican_uttappaAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
             
             // Write Table 1 header
             writer.append("Paper Plaza\n");
             // Write Table 1 data rows
             for (int i = 0; i < paperitemNames.size() ; i++) {
            	 writer.append(""+","+paperitemNames.get(i)+","+","+paperquantities.get(i)+","+paperamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + paperQuantity + ","+paperAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
             
             // Write Table 1 header
             writer.append("Healthy Uttappas\n");
             // Write Table 1 data rows
             for (int i = 0; i < healthyuttappaitemNames.size() ; i++) {
            	 writer.append(""+","+healthyuttappaitemNames.get(i)+","+","+healthyuttappaquantities.get(i)+","+healthyuttappaamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + healthyuttappaQuantity + ","+healthyuttappaAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
             
             // Write Table 1 header
             writer.append("Special Uttappas\n");
             // Write Table 1 data rows
             for (int i = 0; i < specialuttappaitemNames.size() ; i++) {
            	 writer.append(""+","+specialuttappaitemNames.get(i)+","+","+specialuttappaquantities.get(i)+","+specialuttappaamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + specialuttappaQuantity + ","+specialuttappaAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");	
             
             // Write Table 1 header
             writer.append("Chinnese Style Idli\n");
             // Write Table 1 data rows
             for (int i = 0; i < idliitemNames.size() ; i++) {
            	 writer.append(""+","+idliitemNames.get(i)+","+","+idliquantities.get(i)+","+idliamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + idliQuantity + ","+idliAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
             
             // Write Table 1 header
             writer.append("Rice Plaza\n");
             // Write Table 1 data rows
             for (int i = 0; i < riceitemNames.size() ; i++) {
            	 writer.append(""+","+riceitemNames.get(i)+","+","+ricequantities.get(i)+","+riceamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + riceQuantity + ","+riceAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
             
             // Write Table 1 header
             writer.append("SOFT DRINKS\n");
             // Write Table 1 data rows
             for (int i = 0; i < drinksitemNames.size() ; i++) {
            	 writer.append(""+","+drinksitemNames.get(i)+","+","+drinksquantities.get(i)+","+drinksamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + drinksQuantity + ","+drinksAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
             
             // Write Table 1 header
             writer.append("Russian Salad Dosas\n");
             // Write Table 1 data rows
             for (int i = 0; i < russian_saladitemNames.size() ; i++) {
            	 writer.append(""+","+russian_saladitemNames.get(i)+","+","+russian_saladquantities.get(i)+","+russian_saladamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + russian_saladQuantity + ","+russian_saladAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
             
             // Write Table 1 header
             writer.append("Indian Style Dosas\n");
             // Write Table 1 data rows
             for (int i = 0; i < indianitemNames.size() ; i++) {
            	 writer.append(""+","+indianitemNames.get(i)+","+","+indianquantities.get(i)+","+indianamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + indianQuantity + ","+indianAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
             
             // Write Table 1 header
             writer.append("Thali Items\n");
             // Write Table 1 data rows
             for (int i = 0; i < thaliitemNames.size() ; i++) {
            	 writer.append(""+","+thaliitemNames.get(i)+","+","+thaliquantities.get(i)+","+thaliamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + thaliQuantity + ","+thaliAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
             
             // Write Table 1 header
             writer.append("Hot & Cold\n");
             // Write Table 1 data rows
             for (int i = 0; i < hotitemNames.size() ; i++) {
            	 writer.append(""+","+hotitemNames.get(i)+","+","+hotquantities.get(i)+","+hotamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + hotQuantity + ","+hotAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
             
             // Write Table 1 header
             writer.append("Packing Charges\n");
             // Write Table 1 data rows
             for (int i = 0; i < packagingitemNames.size() ; i++) {
            	 writer.append(""+","+packagingitemNames.get(i)+","+","+packagingquantities.get(i)+","+packagingamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + packagingQuantity + ","+packagingAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
             
             // Write Table 1 header
             writer.append("Extras\n");
             // Write Table 1 data rows
             for (int i = 0; i < extrasitemNames.size() ; i++) {
            	 writer.append(""+","+extrasitemNames.get(i)+","+","+extrasquantities.get(i)+","+extrasamounts.get(i)+"\n");
             }
             writer.append("\n");
             writer.append("Sub Total,,," + extrasQuantity + ","+extrasAmount +"\n");

             // Add a blank line before the next table
             writer.append("\n");
            

             System.out.println("CSV file saved successfully at: " + filePath);

         } catch (IOException e) {
             e.printStackTrace();
         }
     }
}
}	
