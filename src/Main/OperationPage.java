package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OperationPage extends JPanel {

    private JPanel panel,mainPanel,generatebill,supportpanel;
    private JScrollPane scrollPane1;
    private GroupLayout.ParallelGroup hGrouppanel;
    private GroupLayout.SequentialGroup vGrouppanel;
    private GroupLayout.ParallelGroup hGrouppanel_generatebill;
    private GroupLayout.SequentialGroup vGrouppanel_generatebill;
    private GroupLayout.ParallelGroup hGrouppanel_supportpanel;
    private GroupLayout.SequentialGroup vGrouppanel_supportpanel;
    private GroupLayout gl_panel,gl_panel_generate_bill,gl_panel_supportpanel;
    private JSeparator separator;
	private JPanel ButtonPanel1;
	private GroupLayout gl_panel_ButtonPanel1;
	private GroupLayout.ParallelGroup hGrouppanel_ButtonPanel1;
	private GroupLayout.SequentialGroup vGrouppanel_ButtonPanel1;
	private JPanel ButtonPanel2;
	private GroupLayout gl_panel_ButtonPanel2;
	private GroupLayout.ParallelGroup hGrouppanel_ButtonPanel2;
	private GroupLayout.SequentialGroup vGrouppanel_ButtonPanel2;
	private JPanel panel1;
	private GroupLayout gl_panel1;
	private GroupLayout.ParallelGroup hGrouppanel1;
	private GroupLayout.SequentialGroup vGrouppanel1;
	private JPanel panel2;
	private GroupLayout gl_panel2;
	private GroupLayout.ParallelGroup hGrouppanel2;
	private GroupLayout.SequentialGroup vGrouppanel2;
	private JPanel panel3;
	private GroupLayout gl_panel3;
	private GroupLayout.ParallelGroup hGrouppanel3;
	private GroupLayout.SequentialGroup vGrouppanel3;
	private JPanel panel4;
	private GroupLayout gl_panel4;
	private GroupLayout.ParallelGroup hGrouppanel4;
	private GroupLayout.SequentialGroup vGrouppanel4;
	private String filePath;

    // Arrays to store invoice details
	private ArrayList<String> dates = new ArrayList<>();
	private ArrayList<String> invoiceNumbers = new ArrayList<>();
	private ArrayList<Double> amounts = new ArrayList<>();
	
    public OperationPage() {
    	mainPanel = new JPanel();
    	mainPanel.setLayout(new BorderLayout());
    	 GroupLayout layout = new GroupLayout(mainPanel);
         mainPanel.setLayout(layout);
        
         LocalDate currentDate = LocalDate.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
         String formattedDate = currentDate.format(formatter);
         
         filePath = "C:\\POS\\Invoice_Data\\Complete\\"+formattedDate+".sql"; // Specify the file path
         
         panel = new JPanel();
         panel.setBackground(Color.WHITE);
         panel.setPreferredSize(new Dimension(1125, 1000)); // Set desired size
         panel.setLayout(new GroupLayout(panel));

        
        
        separator = new JSeparator(); // Create a separator
		separator.setPreferredSize(new Dimension(0, 1)); // Set the height of the separator
		separator.setBackground(Color.GRAY);
		separator.setForeground(Color.GRAY);
        
		
		
        gl_panel = (GroupLayout) panel.getLayout();
        hGrouppanel = gl_panel.createParallelGroup(Alignment.LEADING);
        vGrouppanel = gl_panel.createSequentialGroup();

        generatebill = new JPanel();

        generatebill.setBorder(new LineBorder(Color.GRAY, 1, true));
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
        hGrouppanel_ButtonPanel1 = gl_panel_ButtonPanel1.createParallelGroup(Alignment.LEADING);
        vGrouppanel_ButtonPanel1 = gl_panel_ButtonPanel1.createSequentialGroup();
        
        ButtonPanel2 = new JPanel();

//      ButtonPanel1.setBorder(new LineBorder(Color.GRAY, 1, true));
      ButtonPanel2.setBackground(Color.WHITE);
      gl_panel_ButtonPanel2 = new GroupLayout(ButtonPanel2);
      ButtonPanel2.setLayout(gl_panel_ButtonPanel2);
      hGrouppanel_ButtonPanel2 = gl_panel_ButtonPanel2.createParallelGroup(Alignment.LEADING);
      vGrouppanel_ButtonPanel2 = gl_panel_ButtonPanel2.createSequentialGroup();
        
        supportpanel = new JPanel();
        supportpanel.setBackground(new Color(246,218,222));
        supportpanel.setBorder(new LineBorder(Color.GRAY, 1, true));
        gl_panel_supportpanel = new GroupLayout(supportpanel);
        supportpanel.setLayout(gl_panel_supportpanel);
        hGrouppanel_supportpanel = gl_panel_supportpanel.createParallelGroup(Alignment.LEADING);
        vGrouppanel_supportpanel = gl_panel_supportpanel.createSequentialGroup();
        
        

        
        
        
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
        	    layout.createSequentialGroup()  // Use SequentialGroup to stack components vertically
        	        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
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


private void initializelayouts() {
	 // Add the new panel to the layout
    addgeneratebill();
    addbuttonpanel1();
    ButtonPanel2.setVisible(false);
    
    addbuttonpanel2();
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

private void addbuttonpanel1() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(ButtonPanel1, GroupLayout.PREFERRED_SIZE, 1120, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel
    		.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
            .addComponent(ButtonPanel1, GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE));
    gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}

private void addbuttonpanel2() {
	hGrouppanel.addGroup(gl_panel.createSequentialGroup()
            .addComponent(ButtonPanel2, GroupLayout.PREFERRED_SIZE, 1120, GroupLayout.PREFERRED_SIZE)
    );
	vGrouppanel
    		.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
            .addComponent(ButtonPanel2, GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE));
    gl_panel.setHorizontalGroup(hGrouppanel);
    gl_panel.setVerticalGroup(vGrouppanel);
}



private void generatebillfunction() {
	 // Create components here
	JLabel labelgeneratebill = new JLabel("<html><span style='font-size:16px;'>Operations</span><br><span style='font-size:10px;'>Version: 112.0.33</span></html>");

    labelgeneratebill.setFont(new Font("Arial", Font.BOLD, 16));
    
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
             + "<span style='font-size:12px; color:black;'>Call For Support</span><br>"
             + "<span style='font-size:9px; color:#ffafaf; font-weight:bold;'>.</span><span style='font-size:13px; color:b94759; font-weight:bold;'>  07969 223344</span>"
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


private void generatebillfunction1() {
	 // Create components here
	JLabel labelgeneratebill = new JLabel("Orders");

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
    
    vGrouppanel_generatebill
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
private void buttonPanel1function() {
	
	JPanel squarePanel1 = new JPanel();
	  GroupLayout squarePanel1Layout = new GroupLayout(squarePanel1);
	  squarePanel1.setLayout(squarePanel1Layout);
	  squarePanel1.setBackground(new Color(243,243,243)); // Example color
	  squarePanel1.addMouseListener(new MouseAdapter() {
          @Override
          public void mousePressed(MouseEvent e) {
        	  ButtonPanel1.setVisible(false);
        	  ButtonPanel2.setVisible(true);

        	    operationpanel();
        	    generatebill.removeAll();
        	    generatebillfunction1();
        	    generatebill.revalidate();
        	    generatebill.repaint();
//        	  operationpanel();
          }
      });
	  JLabel Panel1Label1 = new JLabel();    
	  Panel1Label1.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  ImageIcon ICO1 = createResizedIcon("/operationpanel/1.png", 35,45); // Adjust the path and size
	  Panel1Label1.setIcon(ICO1);
	  
	  JLabel Panel1Label2 = new JLabel("  Orders");
	  Panel1Label2.setHorizontalAlignment(SwingConstants.CENTER);
	  Panel1Label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	  

	  squarePanel1Layout.setHorizontalGroup(
	      squarePanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel1Layout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel1Label1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel1Label2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel1Layout.setVerticalGroup(
	  		
	      squarePanel1Layout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel1Label1)
	          .addGap(10) // Add space between the labels
	          .addComponent(Panel1Label2)
	  );
	  
	JPanel squarePanel2 = new JPanel();
	  GroupLayout squarePanel2Layout = new GroupLayout(squarePanel2);
	  squarePanel2.setLayout(squarePanel2Layout);
	  squarePanel2.setBackground(new Color(243,243,243)); // Example color

	  JLabel panel2Label1 = new JLabel();   
	  panel2Label1.setHorizontalAlignment(SwingConstants.CENTER);
	  ImageIcon ICO2 = createResizedIcon("/operationpanel/2.png", 45,45); // Adjust the path and size
	  panel2Label1.setIcon(ICO2);
	  
	  JLabel panel2Label2 = new JLabel(" Online Orders");
	  panel2Label2.setHorizontalAlignment(SwingConstants.CENTER);
	  panel2Label2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel2Layout.setHorizontalGroup(
	      squarePanel2Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel2Layout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(panel2Label1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(panel2Label2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel2Layout.setVerticalGroup(
	  		
	      squarePanel2Layout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(panel2Label1)
	          .addGap(10) // Add space between the labels
	          .addComponent(panel2Label2)
	  );
	  JPanel squarePanel3 = new JPanel();
	  GroupLayout squarePanel3Layout = new GroupLayout(squarePanel3);
	  squarePanel3.setLayout(squarePanel3Layout);
	  squarePanel3.setBackground(new Color(243,243,243)); // Example color
	  

	  JLabel Panel3Label1 = new JLabel(); 
	  Panel3Label1.setHorizontalAlignment(SwingConstants.CENTER);      
	  ImageIcon ICO3 = createResizedIcon("/operationpanel/3.png", 35,45); // Adjust the path and size
	  Panel3Label1.setIcon(ICO3);
	  
	  JLabel Panel3Label2 = new JLabel(" KOTs");
	  Panel3Label2.setHorizontalAlignment(SwingConstants.CENTER);
	  Panel3Label2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel3Layout.setHorizontalGroup(
	      squarePanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel3Layout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel3Label1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel3Label2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel3Layout.setVerticalGroup(
	  		
	      squarePanel3Layout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel3Label1)
	          .addGap(10) // Add space between the labels
	          .addComponent(Panel3Label2)
	  );	
	  
	  JPanel squarePanel4 = new JPanel();
	  GroupLayout squarePanel4Layout = new GroupLayout(squarePanel4);
	  squarePanel4.setLayout(squarePanel4Layout);
	  squarePanel4.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel4Label1 = new JLabel();       
	  Panel4Label1.setHorizontalAlignment(SwingConstants.CENTER);      
	  ImageIcon ICO4 = createResizedIcon("/operationpanel/4.PNG", 45,45); // Adjust the path and size
	  Panel4Label1.setIcon(ICO4);
	  
	  JLabel Panel4Label2 = new JLabel(" Customers");
	  Panel4Label2.setHorizontalAlignment(SwingConstants.CENTER); 
	  Panel4Label2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel4Layout.setHorizontalGroup(
	      squarePanel4Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel4Layout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel4Label1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel4Label2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel4Layout.setVerticalGroup(
	  		
	      squarePanel4Layout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel4Label1)
	          .addGap(10) // Add space between the labels
	          .addComponent(Panel4Label2)
	  );
	  
	  JPanel squarePanel5 = new JPanel();
	  GroupLayout squarePanel5Layout = new GroupLayout(squarePanel5);
	  squarePanel5.setLayout(squarePanel5Layout);
	  squarePanel5.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel5Label1 = new JLabel();  
	  Panel5Label1.setHorizontalAlignment(SwingConstants.CENTER);      
	  ImageIcon ICO5 = createResizedIcon("/operationpanel/5.PNG", 45,45); // Adjust the path and size
	  Panel5Label1.setIcon(ICO5);
	  
	  JLabel Panel5Label2 = new JLabel(" Cash Flow");
	  Panel5Label2.setHorizontalAlignment(SwingConstants.CENTER);  
	  Panel5Label2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel5Layout.setHorizontalGroup(
	      squarePanel5Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel5Layout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel5Label1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel5Label2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel5Layout.setVerticalGroup(
	  		
	      squarePanel5Layout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel5Label1)
	          .addGap(10) // Add space between the labels
	          .addComponent(Panel5Label2)
	  );
	  JPanel squarePanel6 = new JPanel();
	  GroupLayout squarePanel6Layout = new GroupLayout(squarePanel6);
	  squarePanel6.setLayout(squarePanel6Layout);
	  squarePanel6.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel6Label1 = new JLabel(); 
	  Panel6Label1.setHorizontalAlignment(SwingConstants.CENTER);      
	  ImageIcon ICO6 = createResizedIcon("/operationpanel/6.PNG", 45,45); // Adjust the path and size
	  Panel6Label1.setIcon(ICO6);
	  
	  JLabel Panel6Label2 = new JLabel(" Expense");
	  Panel6Label2.setHorizontalAlignment(SwingConstants.CENTER);  
	  Panel6Label2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel6Layout.setHorizontalGroup(
	      squarePanel6Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel6Layout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel6Label1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel6Label2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel6Layout.setVerticalGroup(
	  		
	      squarePanel6Layout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel6Label1)
	          .addGap(10) // Add space between the labels
	          .addComponent(Panel6Label2)
	  );
	  JPanel squarePanel7 = new JPanel();
	  GroupLayout squarePanel7Layout = new GroupLayout(squarePanel7);
	  squarePanel7.setLayout(squarePanel7Layout);
	  squarePanel7.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel7Label1 = new JLabel();  
	  Panel7Label1.setHorizontalAlignment(SwingConstants.CENTER);      
	  ImageIcon ICO7 = createResizedIcon("/operationpanel/7.PNG", 45,45); // Adjust the path and size
	  Panel7Label1.setIcon(ICO7);
	  
	  JLabel Panel7Label2 = new JLabel(" Withdrawal");
	  Panel7Label2.setHorizontalAlignment(SwingConstants.CENTER); 
	  Panel7Label2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel7Layout.setHorizontalGroup(
	      squarePanel7Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel7Layout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel7Label1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel7Label2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel7Layout.setVerticalGroup(
	  		
	      squarePanel7Layout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel7Label1)
	          .addGap(10) // Add space between the labels
	          .addComponent(Panel7Label2)
	  );
	  
	  JPanel squarePanel1A = new JPanel();
	  GroupLayout squarePanel1ALayout = new GroupLayout(squarePanel1A);
	  squarePanel1A.setLayout(squarePanel1ALayout);
	  squarePanel1A.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel1ALabel1 = new JLabel();  
	  Panel1ALabel1.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  ImageIcon ICO1A = createResizedIcon("/operationpanel/8.PNG", 45,45); // Adjust the path and size
	  Panel1ALabel1.setIcon(ICO1A);
	  
	  JLabel Panel1ALabel2 = new JLabel(" Cash Top-Up");
	  Panel1ALabel2.setHorizontalAlignment(SwingConstants.CENTER);
	  Panel1ALabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel1ALayout.setHorizontalGroup(
	      squarePanel1ALayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel1ALayout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel1ALabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel1ALabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel1ALayout.setVerticalGroup(
	  		
	      squarePanel1ALayout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel1ALabel1)
	          .addGap(10) // Add space between the labels
	          .addComponent(Panel1ALabel2)
	  );
	  
	JPanel squarePanel2A = new JPanel();
	  GroupLayout squarePanel2ALayout = new GroupLayout(squarePanel2A);
	  squarePanel2A.setLayout(squarePanel2ALayout);
	  squarePanel2A.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel2ALabel1 = new JLabel();   
	  Panel2ALabel1.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  ImageIcon ICO1B = createResizedIcon("/operationpanel/9.PNG", 45,45); // Adjust the path and size
	  Panel2ALabel1.setIcon(ICO1B);
	  
	  JLabel Panel2ALabel2 = new JLabel(" Inventory");
	  Panel2ALabel2.setHorizontalAlignment(SwingConstants.CENTER);
	  Panel2ALabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel2ALayout.setHorizontalGroup(
	      squarePanel2ALayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel2ALayout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel2ALabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel2ALabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel2ALayout.setVerticalGroup(
	  		
	      squarePanel2ALayout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel2ALabel1)
	          .addGap(10) // Add space between the labels
	          .addComponent(Panel2ALabel2)
	  );
	  JPanel squarePanel3A = new JPanel();
	  GroupLayout squarePanel3ALayout = new GroupLayout(squarePanel3A);
	  squarePanel3A.setLayout(squarePanel3ALayout);
	  squarePanel3A.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel3ALabel1 = new JLabel();       
	  Panel3ALabel1.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  ImageIcon ICO1C = createResizedIcon("/operationpanel/10.PNG", 38,40); // Adjust the path and size
	  Panel3ALabel1.setIcon(ICO1C);
	  
	  JLabel Panel3ALabel2 = new JLabel(" Notification");
	  Panel3ALabel2.setHorizontalAlignment(SwingConstants.CENTER);
	  Panel3ALabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel3ALayout.setHorizontalGroup(
	      squarePanel3ALayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel3ALayout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel3ALabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel3ALabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel3ALayout.setVerticalGroup(
	  		
	      squarePanel3ALayout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel3ALabel1)
	          .addGap(10) // Add space between the labels
	          .addComponent(Panel3ALabel2)
	  );	
	  
	  JPanel squarePanel4A = new JPanel();
	  GroupLayout squarePanel4ALayout = new GroupLayout(squarePanel4A);
	  squarePanel4A.setLayout(squarePanel4ALayout);
	  squarePanel4A.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel4ALabel1 = new JLabel();   
	  Panel4ALabel1.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  ImageIcon ICO1D = createResizedIcon("/operationpanel/11.PNG", 45,40); // Adjust the path and size
	  Panel4ALabel1.setIcon(ICO1D);
	  
	  JLabel Panel4ALabel2 = new JLabel("  Table");
	  Panel4ALabel2.setHorizontalAlignment(SwingConstants.CENTER);
	  Panel4ALabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel4ALayout.setHorizontalGroup(
	      squarePanel4ALayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel4ALayout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel4ALabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel4ALabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel4ALayout.setVerticalGroup(
	  		
	      squarePanel4ALayout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel4ALabel1)
	          .addGap(10) // Add space between the labels
	          .addComponent(Panel4ALabel2)
	  );
	  
	  JPanel squarePanel5A = new JPanel();
	  GroupLayout squarePanel5ALayout = new GroupLayout(squarePanel5A);
	  squarePanel5A.setLayout(squarePanel5ALayout);
	  squarePanel5A.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel5ALabel1 = new JLabel(); 
	  Panel5ALabel1.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  ImageIcon ICO1E = createResizedIcon("/operationpanel/12.PNG", 45,40); // Adjust the path and size
	  Panel5ALabel1.setIcon(ICO1E);
	  
	  JLabel Panel5ALabel2 = new JLabel(" Manual Sync");

	  Panel5ALabel2.setHorizontalAlignment(SwingConstants.CENTER);
	  Panel5ALabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel5ALayout.setHorizontalGroup(
	      squarePanel5ALayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel5ALayout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel5ALabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel5ALabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel5ALayout.setVerticalGroup(
	  		
	      squarePanel5ALayout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel5ALabel1)
	          .addGap(10) // Add space between the labels
	          .addComponent(Panel5ALabel2)
	  );
	  JPanel squarePanel6A = new JPanel();
	  GroupLayout squarePanel6ALayout = new GroupLayout(squarePanel6A);
	  squarePanel6A.setLayout(squarePanel6ALayout);
	  squarePanel6A.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel6ALabel1 = new JLabel();  
	  Panel6ALabel1.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  ImageIcon ICO1F = createResizedIcon("/operationpanel/13.PNG", 45,40); // Adjust the path and size
	  Panel6ALabel1.setIcon(ICO1F);
	  
	  JLabel Panel6ALabel2 = new JLabel(" Help");
	  Panel6ALabel2.setHorizontalAlignment(SwingConstants.CENTER);
	  Panel6ALabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel6ALayout.setHorizontalGroup(
	      squarePanel6ALayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel6ALayout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel6ALabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel6ALabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel6ALayout.setVerticalGroup(
	  		
	      squarePanel6ALayout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel6ALabel1)
	          .addGap(10) // Add space between the labels
	          .addComponent(Panel6ALabel2)
	  );
	  JPanel squarePanel7A = new JPanel();
	  GroupLayout squarePanel7ALayout = new GroupLayout(squarePanel7A);
	  squarePanel7A.setLayout(squarePanel7ALayout);
	  squarePanel7A.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel7ALabel1 = new JLabel();    
	  Panel7ALabel1.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  ImageIcon ICO1G = createResizedIcon("/operationpanel/14.PNG", 45,40); // Adjust the path and size
	  Panel7ALabel1.setIcon(ICO1G);
	  
	  JLabel Panel7ALabel2 = new JLabel(" Live View");
	  Panel7ALabel2.setHorizontalAlignment(SwingConstants.CENTER);
	  Panel7ALabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel7ALayout.setHorizontalGroup(
	      squarePanel7ALayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel7ALayout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel7ALabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel7ALabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel7ALayout.setVerticalGroup(
	  		
	      squarePanel7ALayout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel7ALabel1)
	          .addGap(10) // Add space between the labels
	          .addComponent(Panel7ALabel2)
	  );
	  
	  JPanel squarePanel1B = new JPanel();
	  GroupLayout squarePanel1BLayout = new GroupLayout(squarePanel1B);
	  squarePanel1B.setLayout(squarePanel1BLayout);
	  squarePanel1B.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel1BLabel1 = new JLabel(); 
	  Panel1BLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  ImageIcon ICO1H = createResizedIcon("/operationpanel/15.PNG", 45,40); // Adjust the path and size
	  Panel1BLabel1.setIcon(ICO1H);
	  
	  JLabel Panel1BLabel2 = new JLabel(" Due Payment");
	  Panel1BLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	  Panel1BLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel1BLayout.setHorizontalGroup(
	      squarePanel1BLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel1BLayout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel1BLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel1BLabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel1BLayout.setVerticalGroup(
	  		
	      squarePanel1BLayout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel1BLabel1)
	          .addGap(10) // Bdd space between the labels
	          .addComponent(Panel1BLabel2)
	  );
	  
	JPanel squarePanel2B = new JPanel();
	  GroupLayout squarePanel2BLayout = new GroupLayout(squarePanel2B);
	  squarePanel2B.setLayout(squarePanel2BLayout);
	  squarePanel2B.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel2BLabel1 = new JLabel();    
	  Panel2BLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  ImageIcon ICO1I = createResizedIcon("/operationpanel/16.PNG", 45,40); // Adjust the path and size
	  Panel2BLabel1.setIcon(ICO1I);
	  
	  JLabel Panel2BLabel2 = new JLabel("<html> Language<br><span style='font-size:9px; color:#f3f3f3; font-weight:bold;'>..</span>Profiles</html>");
	  Panel2BLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	  Panel2BLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel2BLayout.setHorizontalGroup(
	      squarePanel2BLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel2BLayout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel2BLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel2BLabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel2BLayout.setVerticalGroup(
	  		
	      squarePanel2BLayout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel2BLabel1)
	          .addGap(3) // Bdd space between the labels
	          .addComponent(Panel2BLabel2)
	  );
	  JPanel squarePanel3B = new JPanel();
	  GroupLayout squarePanel3BLayout = new GroupLayout(squarePanel3B);
	  squarePanel3B.setLayout(squarePanel3BLayout);
	  squarePanel3B.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel3BLabel1 = new JLabel();   
	  Panel3BLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  ImageIcon ICO1J = createResizedIcon("/operationpanel/17.PNG", 35,40); // Adjust the path and size
	  Panel3BLabel1.setIcon(ICO1J);
	  
	  JLabel Panel3BLabel2 = new JLabel("<html> Billing User <br><span style='font-size:9px; color:#f3f3f3; font-weight:bold;'>.....</span>Profile</html>");
	  Panel3BLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	  Panel3BLabel2.setHorizontalAlignment(SwingConstants.CENTER);

	  squarePanel3BLayout.setHorizontalGroup(
	      squarePanel3BLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel3BLayout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel3BLabel1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel3BLabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel3BLayout.setVerticalGroup(
	  		
	      squarePanel3BLayout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel3BLabel1)
	          .addGap(3) // Bdd space between the labels
	          .addComponent(Panel3BLabel2)
	  );	
	  
	  JPanel squarePanel4B = new JPanel();
	  GroupLayout squarePanel4BLayout = new GroupLayout(squarePanel4B);
	  squarePanel4B.setLayout(squarePanel4BLayout);
	  squarePanel4B.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel4BLabel1 = new JLabel();  
	  Panel4BLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  ImageIcon ICO1K = createResizedIcon("/operationpanel/18.PNG", 45,40); // Adjust the path and size
	  Panel4BLabel1.setIcon(ICO1K);
	  
	  JLabel Panel4BLabel2 = new JLabel("<html><span style='font-size:9px; color:#f3f3f3; font-weight:bold;'>.</span> Currency <br>Conversion</html>");
	  Panel4BLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	  Panel4BLabel2.setHorizontalAlignment(SwingConstants.CENTER);

	  squarePanel4BLayout.setHorizontalGroup(
	      squarePanel4BLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel4BLayout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel4BLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel4BLabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel4BLayout.setVerticalGroup(
	  		
	      squarePanel4BLayout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel4BLabel1)
	          .addGap(3) // Bdd space between the labels
	          .addComponent(Panel4BLabel2)
	  );
	  
	  JPanel squarePanel5B = new JPanel();
	  GroupLayout squarePanel5BLayout = new GroupLayout(squarePanel5B);
	  squarePanel5B.setLayout(squarePanel5BLayout);
	  squarePanel5B.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel5BLabel1 = new JLabel();   
	  Panel5BLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  ImageIcon ICO1L = createResizedIcon("/operationpanel/19.PNG", 45,40); // Adjust the path and size
	  Panel5BLabel1.setIcon(ICO1L);
	  
	  JLabel Panel5BLabel2 = new JLabel("  Feedback");
	  Panel5BLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	  Panel5BLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel5BLayout.setHorizontalGroup(
	      squarePanel5BLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel5BLayout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel5BLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel5BLabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel5BLayout.setVerticalGroup(
	  		
	      squarePanel5BLayout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel5BLabel1)
	          .addGap(10) // Bdd space between the labels
	          .addComponent(Panel5BLabel2)
	  );
	  JPanel squarePanel6B = new JPanel();
	  GroupLayout squarePanel6BLayout = new GroupLayout(squarePanel6B);
	  squarePanel6B.setLayout(squarePanel6BLayout);
	  squarePanel6B.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel6BLabel1 = new JLabel();  
	  Panel6BLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  ImageIcon ICO1M = createResizedIcon("/operationpanel/20.PNG", 35,43); // Adjust the path and size
	  Panel6BLabel1.setIcon(ICO1M);
	  
	  JLabel Panel6BLabel2 = new JLabel("  Delivery Boys");
	  Panel6BLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	  Panel6BLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel6BLayout.setHorizontalGroup(
	      squarePanel6BLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel6BLayout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel6BLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel6BLabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel6BLayout.setVerticalGroup(
	  		
	      squarePanel6BLayout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel6BLabel1)
	          .addGap(10) // Bdd space between the labels
	          .addComponent(Panel6BLabel2)
	  );
	  JPanel squarePanel7B = new JPanel();
	  GroupLayout squarePanel7BLayout = new GroupLayout(squarePanel7B);
	  squarePanel7B.setLayout(squarePanel7BLayout);
	  squarePanel7B.setBackground(new Color(243,243,243)); // Example color

	  JLabel Panel7BLabel1 = new JLabel();  
	  Panel7BLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  ImageIcon ICO1N = createResizedIcon("/operationpanel/21.PNG", 35,43); // Adjust the path and size
	  Panel7BLabel1.setIcon(ICO1N);
	  
	  JLabel Panel7BLabel2 = new JLabel(" LED Display");
	  Panel7BLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	  Panel7BLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));

	  squarePanel7BLayout.setHorizontalGroup(
	      squarePanel7BLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	      .addGroup(squarePanel7BLayout.createSequentialGroup()
	      	.addGap(10)
	          .addComponent(Panel7BLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	          .addComponent(Panel7BLabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	  );
	  squarePanel7BLayout.setVerticalGroup(
	  		
	      squarePanel7BLayout.createSequentialGroup()
	      .addGap(20)
	          .addComponent(Panel7BLabel1)
	          .addGap(10) // Bdd space between the labels
	          .addComponent(Panel7BLabel2)
	  );
	  
	  JPanel squarePanel7C = new JPanel();
	  GroupLayout squarePanel7CLayout = new GroupLayout(squarePanel7C);
	  squarePanel7C.setLayout(squarePanel7CLayout);
	  squarePanel7C.setBackground(Color.WHITE); // Example color
	  
	  JLabel Panel7CLabel1 = new JLabel();  
	  Panel7CLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  ImageIcon ICO1C1 = createResizedIcon("/operationpanel/22-transformed.png", 300,120); // Adjust the path and size
	  Panel7CLabel1.setIcon(ICO1C1);
	  
	  squarePanel7CLayout.setHorizontalGroup(
		      squarePanel7CLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
		      .addGroup(squarePanel7CLayout.createSequentialGroup()
		      	.addGap(10)
		          .addComponent(Panel7CLabel1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
		         
		  );
		  squarePanel7CLayout.setVerticalGroup(
		  		
		      squarePanel7CLayout.createSequentialGroup()
		      .addGap(5)
		          .addComponent(Panel7CLabel1));
		  
		  
		  JLabel newLabel = new JLabel("Set the configuration for your restaurant");
		  newLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		  newLabel.setHorizontalAlignment(SwingConstants.LEFT);
		  
		  
			
			 JPanel squarePanel1D = new JPanel();
			  GroupLayout squarePanel1DLayout = new GroupLayout(squarePanel1D);
			  squarePanel1D.setLayout(squarePanel1DLayout);
			  squarePanel1D.setBackground(new Color(243,243,243)); // Example color

			  JLabel Panel1DLabel1 = new JLabel(); 
			  Panel1DLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			  
			  ImageIcon ICO1NA = createResizedIcon("/operationpanel/01.PNG", 35,43); // Adjust the path and size
			  Panel1DLabel1.setIcon(ICO1NA);
			  
			  JLabel Panel1DLabel2 = new JLabel(" Menu");
			  Panel1DLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			  Panel1DLabel2.setHorizontalAlignment(SwingConstants.CENTER);

			  squarePanel1DLayout.setHorizontalGroup(
			      squarePanel1DLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
			      .addGroup(squarePanel1DLayout.createSequentialGroup()
			      	.addGap(10)
			          .addComponent(Panel1DLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
			          .addComponent(Panel1DLabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
			  );
			  squarePanel1DLayout.setVerticalGroup(
			  		
			      squarePanel1DLayout.createSequentialGroup()
			      .addGap(20)
			          .addComponent(Panel1DLabel1)
			          .addGap(10) // Ddd space between the labels
			          .addComponent(Panel1DLabel2)
			  );
			  
			JPanel squarePanel2D = new JPanel();
			  GroupLayout squarePanel2DLayout = new GroupLayout(squarePanel2D);
			  squarePanel2D.setLayout(squarePanel2DLayout);
			  squarePanel2D.setBackground(new Color(243,243,243)); // Example color

			  JLabel Panel2DLabel1 = new JLabel();  
			  Panel2DLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			  
			  ImageIcon ICO1NB = createResizedIcon("/operationpanel/02.PNG", 35,43); // Adjust the path and size
			  Panel2DLabel1.setIcon(ICO1NB);
			  
			  JLabel Panel2DLabel2 = new JLabel(" Bill / KOT Print");
			  Panel2DLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			  Panel2DLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));

			  squarePanel2DLayout.setHorizontalGroup(
			      squarePanel2DLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
			      .addGroup(squarePanel2DLayout.createSequentialGroup()
			      	.addGap(10)
			          .addComponent(Panel2DLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
			          .addComponent(Panel2DLabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
			  );
			  squarePanel2DLayout.setVerticalGroup(
			  		
			      squarePanel2DLayout.createSequentialGroup()
			      .addGap(20)
			          .addComponent(Panel2DLabel1)
			          .addGap(10) // Ddd space between the labels
			          .addComponent(Panel2DLabel2)
			  );
			  JPanel squarePanel3D = new JPanel();
			  GroupLayout squarePanel3DLayout = new GroupLayout(squarePanel3D);
			  squarePanel3D.setLayout(squarePanel3DLayout);
			  squarePanel3D.setBackground(new Color(243,243,243)); // Example color

			  JLabel Panel3DLabel1 = new JLabel();    
			  Panel3DLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			  
			  ImageIcon ICO1NC = createResizedIcon("/operationpanel/03.PNG", 35,43); // Adjust the path and size
			  Panel3DLabel1.setIcon(ICO1NC);
			  
			  JLabel Panel3DLabel2 = new JLabel("  Tax");
			  Panel3DLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			  Panel3DLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));

			  squarePanel3DLayout.setHorizontalGroup(
			      squarePanel3DLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
			      .addGroup(squarePanel3DLayout.createSequentialGroup()
			      	.addGap(10)
			          .addComponent(Panel3DLabel1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
			          .addComponent(Panel3DLabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
			  );
			  squarePanel3DLayout.setVerticalGroup(
			  		
			      squarePanel3DLayout.createSequentialGroup()
			      .addGap(20)
			          .addComponent(Panel3DLabel1)
			          .addGap(10) // Ddd space between the labels
			          .addComponent(Panel3DLabel2)
			  );	
			  
			  JPanel squarePanel4D = new JPanel();
			  GroupLayout squarePanel4DLayout = new GroupLayout(squarePanel4D);
			  squarePanel4D.setLayout(squarePanel4DLayout);
			  squarePanel4D.setBackground(new Color(243,243,243)); // Example color

			  JLabel Panel4DLabel1 = new JLabel();   
			  Panel4DLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			  
			  ImageIcon ICO1ND = createResizedIcon("/operationpanel/04.PNG", 35,43); // Adjust the path and size
			  Panel4DLabel1.setIcon(ICO1ND);
			  
			  JLabel Panel4DLabel2 = new JLabel(" Discount");
			  Panel4DLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			  Panel4DLabel2.setHorizontalAlignment(SwingConstants.CENTER);

			  squarePanel4DLayout.setHorizontalGroup(
			      squarePanel4DLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
			      .addGroup(squarePanel4DLayout.createSequentialGroup()
			      	.addGap(10)
			          .addComponent(Panel4DLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
			          .addComponent(Panel4DLabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
			  );
			  squarePanel4DLayout.setVerticalGroup(
			  		
			      squarePanel4DLayout.createSequentialGroup()
			      .addGap(20)
			          .addComponent(Panel4DLabel1)
			          .addGap(10) // Ddd space between the labels
			          .addComponent(Panel4DLabel2)
			  );
			  
			  JPanel squarePanel5D = new JPanel();
			  GroupLayout squarePanel5DLayout = new GroupLayout(squarePanel5D);
			  squarePanel5D.setLayout(squarePanel5DLayout);
			  squarePanel5D.setBackground(new Color(243,243,243)); // Example color

			  JLabel Panel5DLabel1 = new JLabel();      
			  Panel5DLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			  
			  ImageIcon ICO1NE = createResizedIcon("/operationpanel/05.PNG", 35,43); // Adjust the path and size
			  Panel5DLabel1.setIcon(ICO1NE);
			  
			  JLabel Panel5DLabel2 = new JLabel(" Billing Screen");
			  Panel5DLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			  Panel5DLabel2.setHorizontalAlignment(SwingConstants.CENTER);

			  squarePanel5DLayout.setHorizontalGroup(
			      squarePanel5DLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
			      .addGroup(squarePanel5DLayout.createSequentialGroup()
			      	.addGap(10)
			          .addComponent(Panel5DLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
			          .addComponent(Panel5DLabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
			  );
			  squarePanel5DLayout.setVerticalGroup(
			  		
			      squarePanel5DLayout.createSequentialGroup()
			      .addGap(20)
			          .addComponent(Panel5DLabel1)
			          .addGap(10) // Ddd space between the labels
			          .addComponent(Panel5DLabel2)
			  );
			  JPanel squarePanel6D = new JPanel();
			  GroupLayout squarePanel6DLayout = new GroupLayout(squarePanel6D);
			  squarePanel6D.setLayout(squarePanel6DLayout);
			  squarePanel6D.setBackground(new Color(243,243,243)); // Example color

			  JLabel Panel6DLabel1 = new JLabel(); 
			  Panel6DLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			  
			  ImageIcon ICO1NF = createResizedIcon("/operationpanel/06.PNG", 35,43); // Adjust the path and size
			  Panel6DLabel1.setIcon(ICO1NF);
			  
			  JLabel Panel6DLabel2 = new JLabel(" Settings");
			  Panel6DLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			  Panel6DLabel2.setHorizontalAlignment(SwingConstants.CENTER);

			  squarePanel6DLayout.setHorizontalGroup(
			      squarePanel6DLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
			      .addGroup(squarePanel6DLayout.createSequentialGroup()
			      	.addGap(10)
			          .addComponent(Panel6DLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
			          .addComponent(Panel6DLabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
			  );
			  squarePanel6DLayout.setVerticalGroup(
			  		
			      squarePanel6DLayout.createSequentialGroup()
			      .addGap(20)
			          .addComponent(Panel6DLabel1)
			          .addGap(10) // Ddd space between the labels
			          .addComponent(Panel6DLabel2)
			  );
			  JPanel squarePanel7D = new JPanel();
			  GroupLayout squarePanel7DLayout = new GroupLayout(squarePanel7D);
			  squarePanel7D.setLayout(squarePanel7DLayout);
			  squarePanel7D.setBackground(new Color(243,243,243)); // Example color

			  JLabel Panel7DLabel1 = new JLabel();   
			  Panel7DLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			  
			  ImageIcon ICO1NG = createResizedIcon("/operationpanel/07.PNG", 35,43); // Adjust the path and size
			  Panel7DLabel1.setIcon(ICO1NG);    
			  
			  JLabel Panel7DLabel2 = new JLabel("<html> Menu Item On <br><span style='font-size:9px; color:#f3f3f3; font-weight:bold;'>.......__</span>Off</html>");
			  Panel7DLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			  Panel7DLabel2.setHorizontalAlignment(SwingConstants.CENTER);

			  squarePanel7DLayout.setHorizontalGroup(
			      squarePanel7DLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
			      .addGroup(squarePanel7DLayout.createSequentialGroup()
			      	.addGap(10)
			          .addComponent(Panel7DLabel1))
			          .addComponent(Panel7DLabel2)
			  );
			  squarePanel7DLayout.setVerticalGroup(
			  		
			      squarePanel7DLayout.createSequentialGroup()
			      .addGap(20)
			          .addComponent(Panel7DLabel1)
			          .addGap(3) // Ddd space between the labels
			          .addComponent(Panel7DLabel2)
			  );
			  
			  JPanel squarePanel1E = new JPanel();
			  GroupLayout squarePanel1ELayout = new GroupLayout(squarePanel1E);
			  squarePanel1E.setLayout(squarePanel1ELayout);
			  squarePanel1E.setBackground(new Color(243,243,243)); // Example color

			  JLabel Panel1ELabel1 = new JLabel();  
			  Panel1ELabel1.setHorizontalAlignment(SwingConstants.CENTER);
			  
			  ImageIcon ICO1NH = createResizedIcon("/operationpanel/08.PNG", 40,40); // Adjust the path and size
			  Panel1ELabel1.setIcon(ICO1NH);         
			  
			  JLabel Panel1ELabel2 = new JLabel(" Service Renewal");
			  Panel1ELabel2.setHorizontalAlignment(SwingConstants.CENTER);
			  Panel1ELabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));

			  squarePanel1ELayout.setHorizontalGroup(
			      squarePanel1ELayout.createParallelGroup(GroupLayout.Alignment.CENTER)
			      .addGroup(squarePanel1ELayout.createSequentialGroup()
			      	.addGap(10)
			          .addComponent(Panel1ELabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
			          .addComponent(Panel1ELabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
			  );
			  squarePanel1ELayout.setVerticalGroup(
			  		
			      squarePanel1ELayout.createSequentialGroup()
			      .addGap(20)
			          .addComponent(Panel1ELabel1)
			          .addGap(10) // Edd space between the labels
			          .addComponent(Panel1ELabel2)
			  );
			  
			JPanel squarePanel2E = new JPanel();
			  GroupLayout squarePanel2ELayout = new GroupLayout(squarePanel2E);
			  squarePanel2E.setLayout(squarePanel2ELayout);
			  squarePanel2E.setBackground(new Color(243,243,243)); // Example color

			  JLabel Panel2ELabel1 = new JLabel();  
			  Panel2ELabel1.setHorizontalAlignment(SwingConstants.CENTER);
			  
			  ImageIcon ICO1NI = createResizedIcon("/operationpanel/09.PNG", 40,40); // Adjust the path and size
			  Panel2ELabel1.setIcon(ICO1NI);              
			  
			  JLabel Panel2ELabel2 = new JLabel("<html> Custom Order<br><span style='font-size:9px; color:#f3f3f3; font-weight:bold;'>....__</span>Status</html>");
			  Panel2ELabel2.setHorizontalAlignment(SwingConstants.CENTER);
			  Panel2ELabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));

			  squarePanel2ELayout.setHorizontalGroup(
			      squarePanel2ELayout.createParallelGroup(GroupLayout.Alignment.CENTER)
			      .addGroup(squarePanel2ELayout.createSequentialGroup()
			      	.addGap(5)
			          .addComponent(Panel2ELabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
			          .addComponent(Panel2ELabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
			  );
			  squarePanel2ELayout.setVerticalGroup(
			  		
			      squarePanel2ELayout.createSequentialGroup()
			      .addGap(20)
			          .addComponent(Panel2ELabel1)
			          .addGap(3) // Edd space between the labels
			          .addComponent(Panel2ELabel2)
			  );
			
	  
	  hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup()
			  .addGap(15)
	            .addComponent(squarePanel1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
	            .addComponent(squarePanel2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
	            .addComponent(squarePanel3, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
	            .addComponent(squarePanel4, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
	            .addComponent(squarePanel5, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
	            .addComponent(squarePanel6, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
	            .addComponent(squarePanel7, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
	            
	            
	            );
	    
	    vGrouppanel_ButtonPanel1.addGap(15)
	    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
	    			.addComponent(squarePanel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	    			.addComponent(squarePanel2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	    			.addComponent(squarePanel3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	    			.addComponent(squarePanel4, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	    			.addComponent(squarePanel5, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	    			.addComponent(squarePanel6, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	    			.addComponent(squarePanel7, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                
	                );
	    
	    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup()
				  .addGap(15)
		            .addComponent(squarePanel1A, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
		            .addComponent(squarePanel2A, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
		            .addComponent(squarePanel3A, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
		            .addComponent(squarePanel4A, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
		            .addComponent(squarePanel5A, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
		            .addComponent(squarePanel6A, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
		            .addComponent(squarePanel7A, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
		            
		            
		            );
		    
		    vGrouppanel_ButtonPanel1.addGap(10)
		    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
		    			.addComponent(squarePanel1A, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
		    			.addComponent(squarePanel2A, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
		    			.addComponent(squarePanel3A, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
		    			.addComponent(squarePanel4A, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
		    			.addComponent(squarePanel5A, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
		    			.addComponent(squarePanel6A, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
		    			.addComponent(squarePanel7A, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
		                
		                );
		    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup()
					  .addGap(15)
			            .addComponent(squarePanel1B, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
			            .addComponent(squarePanel2B, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
			            .addComponent(squarePanel3B, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
			            .addComponent(squarePanel4B, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
			            .addComponent(squarePanel5B, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
			            .addComponent(squarePanel6B, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
			            .addComponent(squarePanel7B, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
			            
			            
			            );
			    
			    vGrouppanel_ButtonPanel1.addGap(10)
			    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
			    			.addComponent(squarePanel1B, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
			    			.addComponent(squarePanel2B, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
			    			.addComponent(squarePanel3B, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
			    			.addComponent(squarePanel4B, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
			    			.addComponent(squarePanel5B, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
			    			.addComponent(squarePanel6B, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
			    			.addComponent(squarePanel7B, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
			                
			                );
			    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup()
				            .addComponent(squarePanel7C, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
				            
				            
				            );
				    
				    vGrouppanel_ButtonPanel1.addGap(10)
				    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
				    			.addComponent(squarePanel7C, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
				                
				                );
				    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
				            .addComponent(newLabel, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
				            
				            
				            );
				    
				    vGrouppanel_ButtonPanel1.addGap(30)
				    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
				    			.addComponent(newLabel)
				                
				                );
				    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup().addGap(15)
				            .addComponent(separator, GroupLayout.PREFERRED_SIZE, 1070, GroupLayout.PREFERRED_SIZE)
				            
				            
				            );
				    
				    vGrouppanel_ButtonPanel1.addGap(4)
				    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
				    			.addComponent(separator)
				                
				                );
				    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup()
							  .addGap(15)
					            .addComponent(squarePanel1D, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
					            .addComponent(squarePanel2D, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
					            .addComponent(squarePanel3D, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
					            .addComponent(squarePanel4D, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
					            .addComponent(squarePanel5D, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
					            .addComponent(squarePanel6D, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
					            .addComponent(squarePanel7D, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					            
					            
					            );
					    
					    vGrouppanel_ButtonPanel1.addGap(20)
					    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
					    			.addComponent(squarePanel1D, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					    			.addComponent(squarePanel2D, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					    			.addComponent(squarePanel3D, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					    			.addComponent(squarePanel4D, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					    			.addComponent(squarePanel5D, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					    			.addComponent(squarePanel6D, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					    			.addComponent(squarePanel7D, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					                
					                );
					    hGrouppanel_ButtonPanel1.addGroup(gl_panel_ButtonPanel1.createSequentialGroup()
								  .addGap(15)
						            .addComponent(squarePanel1E, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
						            .addComponent(squarePanel2E, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE).addGap(10)
						           
						            
						            );
						    
						    vGrouppanel_ButtonPanel1.addGap(10)
						    	.addGroup(gl_panel_ButtonPanel1.createParallelGroup(Alignment.CENTER)
						    			.addComponent(squarePanel1E, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						    			.addComponent(squarePanel2E, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						    		
						                );
					    
	    gl_panel_ButtonPanel1.setHorizontalGroup(hGrouppanel_ButtonPanel1);
	    gl_panel_ButtonPanel1.setVerticalGroup(vGrouppanel_ButtonPanel1);
}

private void operationpanel() {
	
	
	panel1 = new JPanel();
	panel1.setBackground(new Color(224,228,224));
    panel1.setPreferredSize(new Dimension(1125, 1250)); // Set desired size
    panel1.setLayout(new GroupLayout(panel1));
    gl_panel1 = (GroupLayout) panel1.getLayout();
    hGrouppanel1 = gl_panel1.createParallelGroup(Alignment.LEADING);
    vGrouppanel1 = gl_panel1.createSequentialGroup();
    
    panel2 = new JPanel();
    panel2.setBackground(Color.WHITE);
    panel2.setPreferredSize(new Dimension(1125, 1250)); // Set desired size
    panel2.setLayout(new GroupLayout(panel2));
    gl_panel2 = (GroupLayout) panel2.getLayout();
    panel2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); 
    hGrouppanel2 = gl_panel2.createParallelGroup(Alignment.LEADING);
    vGrouppanel2 = gl_panel2.createSequentialGroup();
    
    JSeparator separator1 = new JSeparator(); // Create a separator
	separator1.setPreferredSize(new Dimension(0, 1)); // Set the height of the separator
	separator1.setBackground(Color.GRAY);
	
    
    
	 RoundLabel button4 = new RoundLabel("Current Order",10);
	    button4.setBorder(null);
	    button4.setFont(new Font("Arial", Font.BOLD, 14));
	    button4.setHorizontalAlignment(SwingConstants.CENTER);
	    button4.setBackground(Color.WHITE); // Set the background color
	    button4.setForeground(Color.RED); // Set the text color
	    
	    JLabel Panel6DLabel1 = new JLabel("Online Order"); 
	    Panel6DLabel1.setBackground(Color.LIGHT_GRAY);
	    Panel6DLabel1.setFont(new Font("Arial", Font.BOLD, 14));
		Panel6DLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel Panel6DLabel12 = new JLabel("Advance Order"); 
	    Panel6DLabel12.setBackground(Color.LIGHT_GRAY);
	    Panel6DLabel12.setFont(new Font("Arial", Font.BOLD, 14));
		Panel6DLabel12.setHorizontalAlignment(SwingConstants.CENTER);
		
		RoundButtonGray button42 = new RoundButtonGray("<  Back");
	    button42.setBorder(null);
	    button42.setFont(new Font("Arial", Font.BOLD, 14));
	    button42.setHorizontalAlignment(SwingConstants.CENTER);
	    button42.setBackground(Color.WHITE); // Set the background color
	    button42.setForeground(Color.BLACK); // Set the text color
	    
		hGrouppanel1.addGroup(gl_panel1.createSequentialGroup().addGap(20)
	            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
	            .addComponent(Panel6DLabel1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
	            .addComponent(Panel6DLabel12, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
	            .addGap(500)
	            .addComponent(button42, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
	            );
	    
		vGrouppanel1
	    	.addGroup(gl_panel1.createParallelGroup(Alignment.CENTER)
	    			.addComponent(button4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
	    			.addComponent(Panel6DLabel1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
	    			.addComponent(Panel6DLabel12, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
	    			.addComponent(button42, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
	    			
	                );
    
		gl_panel1.setHorizontalGroup(		hGrouppanel1);
		gl_panel1.setVerticalGroup(		vGrouppanel1);

		JPanel squarePanel1 = new JPanel();
		  GroupLayout squarePanel1Layout = new GroupLayout(squarePanel1);
		  squarePanel1.setLayout(squarePanel1Layout);
		  squarePanel1.setBackground(Color.pink); // Example color

		  JLabel Panel1Label1 = new JLabel();    
		  Panel1Label1.setHorizontalAlignment(SwingConstants.CENTER);
		  
		  ImageIcon ICO1 = createResizedIcon("/operationpanel/14.PNG", 30,30); // Adjust the path and size
		  Panel1Label1.setIcon(ICO1);
		  
		  JLabel Panel1Label2 = new JLabel("  All");
		  
		  Panel1Label2.setForeground(Color.RED); // Set the text color
		  Panel1Label2.setHorizontalAlignment(SwingConstants.CENTER);
		  Panel1Label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  

		  squarePanel1Layout.setHorizontalGroup(
		      squarePanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
		      .addGroup(squarePanel1Layout.createSequentialGroup()
		      	.addGap(10)
		          .addComponent(Panel1Label1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
		          .addComponent(Panel1Label2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
		  );
		  squarePanel1Layout.setVerticalGroup(
		  		
		      squarePanel1Layout.createSequentialGroup()
		      .addGap(15)
		          .addComponent(Panel1Label1)
		          .addGap(10) // Add space between the labels
		          .addComponent(Panel1Label2)
		  );
		  
		JPanel squarePanel2 = new JPanel();
		  GroupLayout squarePanel2Layout = new GroupLayout(squarePanel2);
		  squarePanel2.setLayout(squarePanel2Layout);
		  squarePanel2.setBackground(Color.WHITE); // Example color

		  JLabel panel2Label1 = new JLabel();   
		  panel2Label1.setHorizontalAlignment(SwingConstants.CENTER);
		  ImageIcon ICO2 = createResizedIcon("/operationpanel/2.png", 30,30); // Adjust the path and size
		  panel2Label1.setIcon(ICO2);
		  
		  JLabel panel2Label2 = new JLabel(" Dine In");
		  panel2Label2.setHorizontalAlignment(SwingConstants.CENTER);
		  panel2Label2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		  squarePanel2Layout.setHorizontalGroup(
		      squarePanel2Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
		      .addGroup(squarePanel2Layout.createSequentialGroup()
		      	.addGap(10)
		          .addComponent(panel2Label1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
		          .addComponent(panel2Label2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
		  );
		  squarePanel2Layout.setVerticalGroup(
		  		
		      squarePanel2Layout.createSequentialGroup()
		      .addGap(15)
		          .addComponent(panel2Label1)
		          .addGap(10) // Add space between the labels
		          .addComponent(panel2Label2)
		  );
		  JPanel squarePanel3 = new JPanel();
		  GroupLayout squarePanel3Layout = new GroupLayout(squarePanel3);
		  squarePanel3.setLayout(squarePanel3Layout);
		  squarePanel3.setBackground(Color.WHITE); // Example color
		  

		  JLabel Panel3Label1 = new JLabel(); 
		  Panel3Label1.setHorizontalAlignment(SwingConstants.CENTER);      
		  ImageIcon ICO3 = createResizedIcon("/operationpanel/3.png", 30,30); // Adjust the path and size
		  Panel3Label1.setIcon(ICO3);
		  
		  JLabel Panel3Label2 = new JLabel(" Delivery");
		  Panel3Label2.setHorizontalAlignment(SwingConstants.CENTER);
		  Panel3Label2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		  squarePanel3Layout.setHorizontalGroup(
		      squarePanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
		      .addGroup(squarePanel3Layout.createSequentialGroup()
		      	.addGap(10)
		          .addComponent(Panel3Label1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
		          .addComponent(Panel3Label2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
		  );
		  squarePanel3Layout.setVerticalGroup(
		  		
		      squarePanel3Layout.createSequentialGroup()
		      .addGap(15)
		          .addComponent(Panel3Label1)
		          .addGap(10) // Add space between the labels
		          .addComponent(Panel3Label2)
		  );	
		  
		  JPanel squarePanel4 = new JPanel();
		  GroupLayout squarePanel4Layout = new GroupLayout(squarePanel4);
		  squarePanel4.setLayout(squarePanel4Layout);
		  squarePanel4.setBackground(Color.WHITE); // Example color

		  JLabel Panel4Label1 = new JLabel();       
		  Panel4Label1.setHorizontalAlignment(SwingConstants.CENTER);      
		  ImageIcon ICO4 = createResizedIcon("/operationpanel/4.PNG", 30,30); // Adjust the path and size
		  Panel4Label1.setIcon(ICO4);
		  
		  JLabel Panel4Label2 = new JLabel(" Pick Up");
		  Panel4Label2.setHorizontalAlignment(SwingConstants.CENTER); 
		  Panel4Label2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		  squarePanel4Layout.setHorizontalGroup(
		      squarePanel4Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
		      .addGroup(squarePanel4Layout.createSequentialGroup()
		      	.addGap(10)
		          .addComponent(Panel4Label1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
		          .addComponent(Panel4Label2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
		  );
		  squarePanel4Layout.setVerticalGroup(
		  		
		      squarePanel4Layout.createSequentialGroup()
		      .addGap(15)
		          .addComponent(Panel4Label1)
		          .addGap(10) // Add space between the labels
		          .addComponent(Panel4Label2)
		  );
		  RoundButtonGray button420 = new RoundButtonGray("     Get Past Orders");
		    button420.setBorder(null);
		    button420.setFont(new Font("Arial", Font.BOLD, 14));
		    button420.setHorizontalAlignment(SwingConstants.LEFT);
		    button420.setBackground(Color.WHITE); // Set the background color
		    button420.setForeground(Color.RED); // Set the text color
	    
		  hGrouppanel2.addGroup(gl_panel2.createSequentialGroup()
		            .addComponent(squarePanel1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
		            .addComponent(squarePanel2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
		            .addComponent(squarePanel3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)

		            .addComponent(squarePanel4, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
		            .addGap(360)
		            .addComponent(button420, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
		            );
		    
			vGrouppanel2
		    	.addGroup(gl_panel2.createParallelGroup(Alignment.CENTER)
		    			 .addComponent(squarePanel1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				            .addComponent(squarePanel2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				            .addComponent(squarePanel3, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)

				            .addComponent(squarePanel4, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
		    			.addComponent(button420, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
		    			
		                );
			gl_panel2.setHorizontalGroup(		hGrouppanel2);
			gl_panel2.setVerticalGroup(		vGrouppanel2);
	    
	    	    
	    	hGrouppanel_ButtonPanel2.addGroup(gl_panel_ButtonPanel2.createSequentialGroup()
		            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 1110, GroupLayout.PREFERRED_SIZE)
		            );
		    
		    vGrouppanel_ButtonPanel2
		    	.addGroup(gl_panel_ButtonPanel2.createParallelGroup(Alignment.CENTER)
		    			.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
		                );
		    hGrouppanel_ButtonPanel2.addGroup(gl_panel_ButtonPanel2.createSequentialGroup()
		            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 1110, GroupLayout.PREFERRED_SIZE)
		            );
		    
		    vGrouppanel_ButtonPanel2
		    	.addGroup(gl_panel_ButtonPanel2.createParallelGroup(Alignment.CENTER)
		    			.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
		                );
		    hGrouppanel_ButtonPanel2.addGroup(gl_panel_ButtonPanel2.createSequentialGroup()
		            .addComponent(separator1, GroupLayout.PREFERRED_SIZE, 1110, GroupLayout.PREFERRED_SIZE)
		            );
		    
		    vGrouppanel_ButtonPanel2
		    	.addGroup(gl_panel_ButtonPanel2.createParallelGroup(Alignment.CENTER)
		    			.addComponent(separator1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
		                );
		    
		    RoundButtonGray button421 = new RoundButtonGray(" Search  v");
		    button421.setBorder(null);
		    button421.setFont(new Font("Arial", Font.BOLD, 14));
		    button421.setHorizontalAlignment(SwingConstants.CENTER);
		    button421.setBackground(Color.WHITE); // Set the background color
		    button421.setForeground(Color.BLACK); // Set the text color
		    ImageIcon resizedIconbuttonC = createResizedIcon("/operationpanel/Untitled.png", 15,15); // Adjust the path and size
		    button421.setIcon(resizedIconbuttonC);
		    
		    
		    JLabel greengot = new JLabel("Printed Bill");
	        greengot.setOpaque(true);
	        greengot.setHorizontalAlignment(SwingConstants.LEFT);
	        greengot.setBackground(new Color(240,240,240));
	        ImageIcon resizedIcongreengot = createResizedIcon("/homepanel/greendot.png", 10,10); // Adjust the path and size
	        greengot.setIcon(resizedIcongreengot);
	        
	        JLabel GRAYgot = new JLabel("Saved Bill  ");
	        GRAYgot.setOpaque(true);
	        GRAYgot.setHorizontalAlignment(SwingConstants.CENTER);
	        GRAYgot.setBackground(new Color(240,240,240));
	        ImageIcon resizedIconGRAYgot = createResizedIcon("/homepanel/graygot.png", 10,10); // Adjust the path and size
	        GRAYgot.setIcon(resizedIconGRAYgot);
	        
	        JLabel cancelledgot = new JLabel("Cancelled Bill");
	        cancelledgot.setOpaque(true);
	        cancelledgot.setHorizontalAlignment(SwingConstants.LEFT);
	        cancelledgot.setBackground(new Color(240,240,240)); // Your background color
	        ImageIcon resizedIconcancelledgot = createResizedIcon("/homepanel/redgot.png", 10,10); // Adjust the path and size
	        cancelledgot.setIcon(resizedIconcancelledgot);
	        
	        JLabel Paidgot = new JLabel("paid");
	        Paidgot.setOpaque(true);
	        Paidgot.setHorizontalAlignment(SwingConstants.LEFT);
	        Paidgot.setBackground(new Color(240,240,240));// Your background color
	        ImageIcon resizedIconPaidgot = createResizedIcon("/homepanel/paigot.png", 10,10); // Adjust the path and size
	        Paidgot.setIcon(resizedIconPaidgot);
	        
		    hGrouppanel_ButtonPanel2.addGroup(gl_panel_ButtonPanel2.createSequentialGroup().addGap(15)
		            
		            .addComponent(button421, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE).addGap(570)
		            .addComponent(GRAYgot, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
		            .addComponent(greengot, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
		            .addComponent(cancelledgot, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
		            .addComponent(Paidgot, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
		            );
		    
		    vGrouppanel_ButtonPanel2.addGap(15)
		    	.addGroup(gl_panel_ButtonPanel2.createParallelGroup(Alignment.CENTER)
		    			.addComponent(button421, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
		    			
		    			.addComponent(greengot, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
			            .addComponent(GRAYgot, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
			            .addComponent(cancelledgot, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
			            .addComponent(Paidgot, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
		                )
		    	.addGap(20);
		    
		    panel3 = new JPanel();
		    panel3.setBackground(new Color(224,228,224));
		    panel3.setPreferredSize(new Dimension(1125, 1250)); // Set desired size
		    panel3.setLayout(new GroupLayout(panel3));
		    gl_panel3 = (GroupLayout) panel3.getLayout();
		    panel3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); 
		    hGrouppanel3 = gl_panel3.createParallelGroup(Alignment.LEADING);
		    vGrouppanel3 = gl_panel3.createSequentialGroup();
		    
		    panel4 = new JPanel();
		    panel4.setBackground(new Color(224,228,224));
		    panel4.setLayout(new GroupLayout(panel4));
		    gl_panel4 = (GroupLayout) panel4.getLayout();
//		    panel4.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); 
		    hGrouppanel4 = gl_panel4.createParallelGroup(Alignment.LEADING);
		    vGrouppanel4 = gl_panel4.createSequentialGroup();
		    
		    JScrollPane scrollPane2 = new JScrollPane(panel4);
		    scrollPane2.setPreferredSize(new Dimension(1125, 400)); // Set size of scrollable area

		    // Customize the scroll pane's appearance (optional)
		    scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		    scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		    
		    JLabel Panel10DLabel1 = new JLabel("Order No."); 
		    Panel10DLabel1.setBackground(Color.LIGHT_GRAY);
		    Panel10DLabel1.setFont(new Font("Arial", Font.BOLD, 14));
			Panel10DLabel1.setHorizontalAlignment(SwingConstants.LEFT);
			
			JLabel Panel10DLabel2 = new JLabel("Order Type"); 
			Panel10DLabel2.setBackground(Color.LIGHT_GRAY);
			Panel10DLabel2.setFont(new Font("Arial", Font.BOLD, 14));
			Panel10DLabel2.setHorizontalAlignment(SwingConstants.LEFT);
			
			JLabel Panel10DLabel3 = new JLabel("<html>Customer<br> Phone</html>"); 
		    Panel10DLabel3.setBackground(Color.LIGHT_GRAY);
		    Panel10DLabel3.setFont(new Font("Arial", Font.BOLD, 14));
			Panel10DLabel3.setHorizontalAlignment(SwingConstants.LEFT);
			
			JLabel Panel10DLabel4 = new JLabel("<html>Customer<br> Name</html>"); 
		    Panel10DLabel4.setBackground(Color.LIGHT_GRAY);
		    Panel10DLabel4.setFont(new Font("Arial", Font.BOLD, 14));
			Panel10DLabel4.setHorizontalAlignment(SwingConstants.LEFT);
			
			JLabel Panel10DLabel5 = new JLabel("<html>Payment<br> Type</html>"); 
		    Panel10DLabel5.setBackground(Color.LIGHT_GRAY);
		    Panel10DLabel5.setFont(new Font("Arial", Font.BOLD, 14));
			Panel10DLabel5.setHorizontalAlignment(SwingConstants.LEFT);
			
			
			JLabel Panel10DLabel6 = new JLabel("<html>My<br>Amount<br>(₹)</html>"); 
		    Panel10DLabel6.setBackground(Color.LIGHT_GRAY);
		    Panel10DLabel6.setFont(new Font("Arial", Font.BOLD, 14));
			Panel10DLabel6.setHorizontalAlignment(SwingConstants.LEFT);
			
			
			JLabel Panel10DLabel7 = new JLabel("<html>Tax(<br> ₹)</html>"); 
		    Panel10DLabel7.setBackground(Color.LIGHT_GRAY);
		    Panel10DLabel7.setFont(new Font("Arial", Font.BOLD, 14));
			Panel10DLabel7.setHorizontalAlignment(SwingConstants.LEFT);
			
			
			JLabel Panel10DLabel8 = new JLabel("<html>Discount<br> (₹)</html>"); 
		    Panel10DLabel8.setBackground(Color.LIGHT_GRAY);
		    Panel10DLabel8.setFont(new Font("Arial", Font.BOLD, 14));
			Panel10DLabel8.setHorizontalAlignment(SwingConstants.LEFT);
			
			
			JLabel Panel10DLabel9 = new JLabel("<html>Grand<br> Ttotal(₹<br>)</html>"); 
		    Panel10DLabel9.setBackground(Color.LIGHT_GRAY);
		    Panel10DLabel9.setFont(new Font("Arial", Font.BOLD, 14));
			Panel10DLabel9.setHorizontalAlignment(SwingConstants.LEFT);
			
			JLabel Panel10DLabel10 = new JLabel("Created"); 
		    Panel10DLabel10.setBackground(Color.LIGHT_GRAY);
		    Panel10DLabel10.setFont(new Font("Arial", Font.BOLD, 14));
			Panel10DLabel10.setHorizontalAlignment(SwingConstants.LEFT);
			
		    
		    
		    
		    hGrouppanel3.addGroup(gl_panel3.createSequentialGroup().addGap(10)
		            .addComponent(Panel10DLabel1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
		            .addComponent(Panel10DLabel2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
		            .addComponent(Panel10DLabel3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
		            .addComponent(Panel10DLabel4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
		            .addComponent(Panel10DLabel5, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
		            .addComponent(Panel10DLabel6, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
		            .addComponent(Panel10DLabel7, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
		            .addComponent(Panel10DLabel8, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
		            .addComponent(Panel10DLabel9, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
		            .addComponent(Panel10DLabel10, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
		            
		            );
		    
			vGrouppanel3
		    	.addGroup(gl_panel3.createParallelGroup(Alignment.CENTER)
		    			.addComponent(Panel10DLabel1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
			            .addComponent(Panel10DLabel2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
			            .addComponent(Panel10DLabel3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
			            .addComponent(Panel10DLabel4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
			            .addComponent(Panel10DLabel5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
			            .addComponent(Panel10DLabel6, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
			            .addComponent(Panel10DLabel7, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
			            .addComponent(Panel10DLabel8, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
			            .addComponent(Panel10DLabel9, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
			            .addComponent(Panel10DLabel10, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
		    			
		                );
	    
			gl_panel3.setHorizontalGroup(		hGrouppanel3);
			gl_panel3.setVerticalGroup(		vGrouppanel3);
			
			 hGrouppanel_ButtonPanel2.addGroup(gl_panel_ButtonPanel2.createSequentialGroup()
					 .addGap(15)
			            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
			            );
			    
			    vGrouppanel_ButtonPanel2.addGap(3)
			    	.addGroup(gl_panel_ButtonPanel2.createParallelGroup(Alignment.CENTER)
			    			.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
			                );
			    
			    
			    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
		            String line;

		            while ((line = br.readLine()) != null) {
		                // Extracting data from the SQL line
		                if (line.startsWith("INSERT INTO InvoiceDetails")) {
		                    String[] values = line.split("VALUES")[1].trim().replace("(", "").replace(");", "").split(",");
		                    String date = values[0].trim().replace("'", "");
		                    String invoiceNo = values[1].trim().replace("'", "");
		                    double amount = Double.parseDouble(values[6].trim().replace("'", ""));

		                    // Check if the invoice number already exists
		                    int index = invoiceNumbers.indexOf(invoiceNo);

		                    if (index != -1) {
		                        // If invoice number exists, update the amount
		                        amounts.set(index, amounts.get(index) + amount);
		                    } else {
		                        // If new invoice number, add the details to the lists
		                        dates.add(date);
		                        invoiceNumbers.add(invoiceNo);
		                        amounts.add(amount);
		                    }
		                }
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

			 // Printing the final invoice totals in reverse order
			    for (int i = invoiceNumbers.size() - 1; i >= 0; i--) {
			        report(invoiceNumbers.get(i), amounts.get(i), dates.get(i));
			    }

			    hGrouppanel_ButtonPanel2.addGroup(gl_panel_ButtonPanel2.createSequentialGroup()
						 .addGap(15)
				            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
				            );
				    
				    vGrouppanel_ButtonPanel2.addGap(0)
				    	.addGroup(gl_panel_ButtonPanel2.createParallelGroup(Alignment.CENTER)
				    			.addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE,600, GroupLayout.PREFERRED_SIZE) // Height will be flexible
				    		    )
				    	.addGap(30);
			    
			    
			    
			    
gl_panel_ButtonPanel2.setHorizontalGroup(hGrouppanel_ButtonPanel2);
gl_panel_ButtonPanel2.setVerticalGroup(vGrouppanel_ButtonPanel2);
}
private void report(String InvoiceNo,Double amount,String date) {
	Double tax=amount*0.05;
	Double grandtotal=amount+tax;
	
	JLabel Panel10DLabel1 = new JLabel(" "+InvoiceNo); 
    Panel10DLabel1.setBackground(new Color(54,143,85));
    Panel10DLabel1.setOpaque(true);
    Panel10DLabel1.setForeground(new Color(204,0,0));
    Panel10DLabel1.setFont(new Font("Arial", Font.BOLD, 14));
	Panel10DLabel1.setHorizontalAlignment(SwingConstants.LEFT);
	
	JLabel Panel10DLabel2 = new JLabel("<html> <span style='font-size:9px;'>Pick Up</span><br><span style='font-size:10px;'><b><i>(Pick Up)</i></b></span></html>"); 
	Panel10DLabel2.setBackground(new Color(54,143,85));
	Panel10DLabel2.setOpaque(true);
	Panel10DLabel2.setFont(new Font("Arial", Font.PLAIN, 14));
	Panel10DLabel2.setHorizontalAlignment(SwingConstants.LEFT);
	
	JLabel Panel10DLabel3 = new JLabel(""); 
    Panel10DLabel3.setBackground(new Color(54,143,85));
    Panel10DLabel3.setOpaque(true);
    Panel10DLabel3.setFont(new Font("Arial", Font.BOLD, 14));
	Panel10DLabel3.setHorizontalAlignment(SwingConstants.LEFT);
	
	JLabel Panel10DLabel4 = new JLabel(""); 
    Panel10DLabel4.setBackground(new Color(54,143,85));
    Panel10DLabel4.setOpaque(true);
    Panel10DLabel4.setFont(new Font("Arial", Font.BOLD, 14));
	Panel10DLabel4.setHorizontalAlignment(SwingConstants.LEFT);
	
	JLabel Panel10DLabel5 = new JLabel("Cash"); 
    Panel10DLabel5.setBackground(new Color(54,143,85));
    Panel10DLabel5.setOpaque(true);
    Panel10DLabel5.setFont(new Font("Arial", Font.BOLD, 14));
	Panel10DLabel5.setHorizontalAlignment(SwingConstants.LEFT);
	
	
	JLabel Panel10DLabel6 = new JLabel(String.format("%.2f",amount)); 
    Panel10DLabel6.setBackground(new Color(54,143,85));
    Panel10DLabel6.setOpaque(true);
    Panel10DLabel6.setFont(new Font("Arial", Font.BOLD, 14));
	Panel10DLabel6.setHorizontalAlignment(SwingConstants.LEFT);
	
	
	JLabel Panel10DLabel7 = new JLabel(String.format("%.2f",tax)); 
    Panel10DLabel7.setBackground(new Color(54,143,85));
    Panel10DLabel7.setOpaque(true);
    Panel10DLabel7.setFont(new Font("Arial", Font.BOLD, 14));
	Panel10DLabel7.setHorizontalAlignment(SwingConstants.LEFT);
	
	
	JLabel Panel10DLabel8 = new JLabel("(0.00)"); 
    Panel10DLabel8.setBackground(new Color(54,143,85));
    Panel10DLabel8.setOpaque(true);
    Panel10DLabel8.setFont(new Font("Arial", Font.BOLD, 14));
	Panel10DLabel8.setHorizontalAlignment(SwingConstants.LEFT);
	
	
	JLabel Panel10DLabel9 = new JLabel(String.format("%.2f",grandtotal)); 
    Panel10DLabel9.setBackground(new Color(54,143,85));
    Panel10DLabel9.setForeground(new Color(204,0,0));
    Panel10DLabel9.setOpaque(true);
    Panel10DLabel9.setFont(new Font("Arial", Font.BOLD, 14));
	Panel10DLabel9.setHorizontalAlignment(SwingConstants.LEFT);
	
	JLabel Panel10DLabel10 = new JLabel(date); 
    Panel10DLabel10.setBackground(new Color(54,143,85));
    Panel10DLabel10.setOpaque(true);
    Panel10DLabel10.setFont(new Font("Arial", Font.BOLD, 14));
	Panel10DLabel10.setHorizontalAlignment(SwingConstants.LEFT);
	
	JLabel Panel10DLabel11 = new JLabel(""); 
    Panel10DLabel11.setBackground(new Color(54,143,85));
    Panel10DLabel11.setOpaque(true);
	Panel10DLabel11.setHorizontalAlignment(SwingConstants.CENTER);
	ImageIcon resizedIcongreengot1 = createResizedIcon("/homepanel/sa.png", 30,30); // Adjust the path and size
	Panel10DLabel11.setIcon(resizedIcongreengot1);
	
    
    
    
    hGrouppanel4.addGroup(gl_panel4.createSequentialGroup()
            .addComponent(Panel10DLabel1, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
            .addComponent(Panel10DLabel2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
            .addComponent(Panel10DLabel3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
            .addComponent(Panel10DLabel4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
            .addComponent(Panel10DLabel5, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
            .addComponent(Panel10DLabel6, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
            .addComponent(Panel10DLabel7, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
            .addComponent(Panel10DLabel8, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
            .addComponent(Panel10DLabel9, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
            .addComponent(Panel10DLabel10, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
            .addComponent(Panel10DLabel11, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
            
            );
    
	vGrouppanel4
    	.addGroup(gl_panel4.createParallelGroup(Alignment.CENTER)
    			.addComponent(Panel10DLabel1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
	            .addComponent(Panel10DLabel2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
	            .addComponent(Panel10DLabel3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
	            .addComponent(Panel10DLabel4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
	            .addComponent(Panel10DLabel5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
	            .addComponent(Panel10DLabel6, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
	            .addComponent(Panel10DLabel7, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
	            .addComponent(Panel10DLabel8, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
	            .addComponent(Panel10DLabel9, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
	            .addComponent(Panel10DLabel10, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
	            .addComponent(Panel10DLabel11, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
    			
                )
    	.addGap(3);

	gl_panel4.setHorizontalGroup(		hGrouppanel4);
	gl_panel4.setVerticalGroup(		vGrouppanel4);
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
