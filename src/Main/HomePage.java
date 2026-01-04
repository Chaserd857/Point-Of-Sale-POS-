package Main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class HomePage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane, rightPanel;
    private boolean reportclick = false;
    private BillingPanel billingPanel;
	private OperationPage OperationPage;
	private ItemSummaryReport ItemSummaryReport;
	private newpanel newpanel;
	private ArrayList<String> invoiceNumbers = new ArrayList<>();
	private ArrayList<Double> amounts = new ArrayList<>();
	private ArrayList<String> DISCinvoiceNumbers = new ArrayList<>();
	private ArrayList<Double> DISCamounts = new ArrayList<>();
	private DefaultTableModel model;
	private JTable table;
	private String filePathdisc = "C:\\POS\\DISCOUNT\\disc";  // Path to the SQL file

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomePage frame = new HomePage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public HomePage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setTitle("Dosa Plaza - Food Chain (Amity Noida) (R347249) - The Finest Restaurant Management Platform");
        setIconImage(Toolkit.getDefaultToolkit().getImage(HomePage.class.getResource("/image/logo.png")));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        // Set the frame's size to the screen size
        setSize(screenSize.width, screenSize.height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);

        // Create the left and right panels
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(197,31,49));
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(null);
        billpanel();
     // Create a new panel that you want below the leftPanel
        JPanel newPanelBelowLeft = new JPanel();
//        newPanelBelowLeft.setBackground(Color.GREEN); // Set a different color for distinction

        
        
	     // Create the label (newLabel7)
	     JLabel newLabel7 = new JLabel("   All Orders are synced                ");
	     newLabel7.setBackground(new Color(241,241,241,255));
	     newLabel7.setHorizontalAlignment(SwingConstants.LEFT);
	     newLabel7.setOpaque(true);
	     newLabel7.setFont(new Font("Arial", Font.PLAIN, 14));
	
	     // Set an icon for the label (assuming the createResizedIcon method is already defined)
	     ImageIcon resizedIconnewLabel7 = createResizedIcon("/homepanel/chech_updates.png", 16, 16); // Adjust the path and size
	     newLabel7.setIcon(resizedIconnewLabel7);
	     newLabel7.setForeground(Color.BLACK); // Set the label's text color
	  // Set the text alignment to the left and the icon to the right
	     newLabel7.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left
	     newLabel7.setHorizontalTextPosition(SwingConstants.LEFT); // Set the icon to appear to the right of the text

	  // Define a GroupLayout for the newPanelBelowLeft
	     GroupLayout gl_newPanelBelowLeft = new GroupLayout(newPanelBelowLeft);
	     newPanelBelowLeft.setLayout(gl_newPanelBelowLeft);
	     
	  // Define the GroupLayout for newPanelBelowLeft
	     gl_newPanelBelowLeft.setHorizontalGroup(
	         gl_newPanelBelowLeft.createSequentialGroup()
	             .addComponent(newLabel7, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE) // Set label width to 250
	     );

	     gl_newPanelBelowLeft.setVerticalGroup(
	         gl_newPanelBelowLeft.createSequentialGroup()
	         .addGap(3)
	             .addComponent(newLabel7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE) // Set label height to 40
	     );
        
        // Add a JScrollPane to the leftPanel
        JScrollPane scrollPane = new JScrollPane(leftPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Disable horizontal scrolling
     // Hide the vertical scrollbar but keep the scrolling functionality
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));

        // Set the scrollPane to scroll only when needed
        scrollPane.getViewport().setViewPosition(new Point(0, 0));

        // Define GroupLayout for the content pane
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        contentPane.setLayout(gl_contentPane);

     // Set the horizontal layout: 18% for both scrollPane and newPanelBelowLeft, and 82% for rightPanel
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createSequentialGroup()
                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, screenSize.width * 18 / 100, GroupLayout.PREFERRED_SIZE) // ScrollPane with 18% width
                    .addComponent(newPanelBelowLeft, GroupLayout.PREFERRED_SIZE, screenSize.width * 18 / 100, GroupLayout.PREFERRED_SIZE)) // New panel with the same 18% width
                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(rightPanel, GroupLayout.PREFERRED_SIZE, screenSize.width * 82 / 100, GroupLayout.PREFERRED_SIZE)) // RightPanel with 82% width
        );

        // Set the vertical layout: stack scrollPane and newPanelBelowLeft in the left column
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 665, GroupLayout.PREFERRED_SIZE) // ScrollPane height
                    .addComponent(newPanelBelowLeft, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)) // New panel below the scrollPane
                .addGroup(gl_contentPane.createSequentialGroup()
                		.addComponent(rightPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE) )// Right panel unchanged
        );

        // Add components to leftPanel (now inside scrollPane)
        JLabel titleLogo = new JLabel();
        titleLogo.setHorizontalAlignment(SwingConstants.CENTER);
        titleLogo.setForeground(Color.WHITE); // Optional: Set text color for better visibility
        ImageIcon resizedIconlogo = createResizedIcon("/homepanel/petpooja.jpg", 250,50); // Adjust the path and size
        titleLogo.setIcon(resizedIconlogo);

        JButton BillingLabel = new JButton(" Billing");
        BillingLabel.setHorizontalAlignment(SwingConstants.LEFT);
        BillingLabel.setForeground(new Color(179,85,97,255));
        BillingLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        BillingLabel.setBackground(Color.WHITE); // Your background color
       
        

        // Remove the button border and ensure the background color is displayed
        BillingLabel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 20)); // Set the border
        BillingLabel.setFocusPainted(false);        // Remove focus border (blue outline)
        BillingLabel.setContentAreaFilled(true);    // Ensure background color is used
        BillingLabel.setOpaque(true);     
        ImageIcon resizedIconbilling = createResizedIcon("/homepanel/bill_red.png", 20,20); // Adjust the path and size
        BillingLabel.setIcon(resizedIconbilling);

        
        JButton oprtationLabel = new JButton(" Operations                               ");
        
        oprtationLabel.setBorder(BorderFactory.createLineBorder(new Color(235,235,235,255), 2)); 
        oprtationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        oprtationLabel.setForeground(Color.BLACK);
        oprtationLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        oprtationLabel.setBackground(new Color(248,248,248)); // Your background color
        
        // Remove the button border and ensure the background color is displayed
        
        oprtationLabel.setFocusPainted(false);        // Remove focus border (blue outline)
        oprtationLabel.setContentAreaFilled(true);    // Ensure background color is used
        oprtationLabel.setOpaque(true);     
        ImageIcon resizedIconoprtationLabel = createResizedIcon("/homepanel/operationsblack.png", 20,20); // Adjust the path and size
        oprtationLabel.setIcon(resizedIconoprtationLabel);
        
        
        JButton reportLabel = new JButton(" Reports                                    ");
        reportLabel.setBorder(BorderFactory.createLineBorder(new Color(235,235,235,255), 2)); 
        
        reportLabel.setHorizontalAlignment(SwingConstants.CENTER);
        reportLabel.setForeground(Color.BLACK);
        reportLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        reportLabel.setBackground(new Color(248,248,248)); // Your background color
     // Remove the button border and ensure the background color is displayed
     // Set up the empty border for padding

       // Combine the line border with the empty border
        reportLabel.setFocusPainted(false);        // Remove focus border (blue outline)
        reportLabel.setContentAreaFilled(true);    // Ensure background color is used
        reportLabel.setOpaque(true);     
        ImageIcon resizedIconreport = createResizedIcon("/homepanel/reportsblack.png", 20,20); // Adjust the path and size
        reportLabel.setIcon(resizedIconreport);
        
        JButton itemsummary = new JButton(" Item Summary");
        itemsummary.setHorizontalAlignment(SwingConstants.LEFT);
        itemsummary.setForeground(Color.BLACK);
        itemsummary.setFont(new Font("Arial", Font.PLAIN, 14));
        itemsummary.setBackground(new Color(248,248,248)); // Your background color
     // Remove the button border and ensure the background color is displayed
     // Set up the empty border for padding

        // Combine the line border with the empty border
        itemsummary.setBorder(BorderFactory.createEmptyBorder(10, 42, 10, 20)); // Set the border
        itemsummary.setFocusPainted(false);        // Remove focus border (blue outline)
        itemsummary.setContentAreaFilled(true);    // Ensure background color is used
        itemsummary.setOpaque(true);     
        
        JButton salessummary = new JButton(" Sales Summary");
        salessummary.setHorizontalAlignment(SwingConstants.LEFT);
        salessummary.setForeground(Color.BLACK);
        salessummary.setFont(new Font("Arial", Font.PLAIN, 14));
        salessummary.setBackground(new Color(248,248,248)); // Your background color
     // Remove the button border and ensure the background color is displayed
     // Set up the empty border for padding

        // Combine the line border with the empty border
        salessummary.setBorder(BorderFactory.createEmptyBorder(10, 42, 10, 20)); // Set the border
        salessummary.setFocusPainted(false);        // Remove focus border (blue outline)
        salessummary.setContentAreaFilled(true);    // Ensure background color is used
        salessummary.setOpaque(true);     
        
        JButton ordersummary = new JButton(" Order Summary");
        ordersummary.setHorizontalAlignment(SwingConstants.LEFT);
        ordersummary.setForeground(Color.BLACK);
        ordersummary.setFont(new Font("Arial", Font.PLAIN, 14));
        ordersummary.setBackground(new Color(248,248,248)); // Your background color
     // Remove the button border and ensure the background color is displayed
     // Set up the empty border for padding

        // Combine the line border with the empty border
        ordersummary.setBorder(BorderFactory.createEmptyBorder(10, 42, 10, 20)); // Set the border
        ordersummary.setFocusPainted(false);        // Remove focus border (blue outline)
        ordersummary.setContentAreaFilled(true);    // Ensure background color is used
        ordersummary.setOpaque(true);     
        
        JButton exxecutivesummary = new JButton("<html> Executive Sales <br>Summary</html>");
        exxecutivesummary.setHorizontalAlignment(SwingConstants.LEFT);
        exxecutivesummary.setForeground(Color.BLACK);
        exxecutivesummary.setFont(new Font("Arial", Font.PLAIN, 14));
        exxecutivesummary.setBackground(new Color(248,248,248)); // Your background color

     // Remove the button border and ensure the background color is displayed
     // Set up the empty border for padding

        // Combine the line border with the empty border
        exxecutivesummary.setBorder(BorderFactory.createEmptyBorder(10, 46, 10, 20)); // Set the border
        exxecutivesummary.setFocusPainted(false);        // Remove focus border (blue outline)
        exxecutivesummary.setContentAreaFilled(true);    // Ensure background color is used
        exxecutivesummary.setOpaque(true);     
        
        JButton employeesummary = new JButton(" Employee Summary");
        employeesummary.setHorizontalAlignment(SwingConstants.LEFT);
        employeesummary.setForeground(Color.BLACK);
        employeesummary.setFont(new Font("Arial", Font.PLAIN, 14));
        employeesummary.setBackground(new Color(248,248,248)); // Your background color
     // Remove the button border and ensure the background color is displayed
     // Set up the empty border for padding

        // Combine the line border with the empty border
        employeesummary.setBorder(BorderFactory.createEmptyBorder(10, 42, 10, 20)); // Set the border
        employeesummary.setFocusPainted(false);        // Remove focus border (blue outline)
        employeesummary.setContentAreaFilled(true);    // Ensure background color is used
        employeesummary.setOpaque(true);   
        
        JButton settlementsummary = new JButton(" Settlement Summary");
        settlementsummary.setHorizontalAlignment(SwingConstants.LEFT);
        settlementsummary.setForeground(Color.BLACK);
        settlementsummary.setFont(new Font("Arial", Font.PLAIN, 14));
        settlementsummary.setBackground(new Color(248,248,248)); // Your background color
     // Remove the button border and ensure the background color is displayed
     // Set up the empty border for padding

        // Combine the line border with the empty border
        settlementsummary.setBorder(BorderFactory.createEmptyBorder(10, 42, 10, 20)); // Set the border
        settlementsummary.setFocusPainted(false);        // Remove focus border (blue outline)
        settlementsummary.setContentAreaFilled(true);    // Ensure background color is used
        settlementsummary.setOpaque(true);   
        
        JButton liveviewLabel = new JButton(" Live View                                 ");
        liveviewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        liveviewLabel.setForeground(Color.BLACK);
        liveviewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        liveviewLabel.setBackground(new Color(248,248,248)); // Your background color
     // Remove the button border and ensure the background color is displayed
     // Set up the empty border for padding

        liveviewLabel.setBorder(BorderFactory.createLineBorder(new Color(235,235,235,255), 2)); 
        // Combine the line border with the empty border
        liveviewLabel.setFocusPainted(false);        // Remove focus border (blue outline)
        liveviewLabel.setContentAreaFilled(true);    // Ensure background color is used
        liveviewLabel.setOpaque(true);
        
        ImageIcon resizedIconliveviewLabel = createResizedIcon("/homepanel/live_view.png", 20,20); // Adjust the path and size
        liveviewLabel.setIcon(resizedIconliveviewLabel);      
        
        JButton settingLabel = new JButton(" Settings                                    ");
        settingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        settingLabel.setForeground(Color.BLACK);
        settingLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        settingLabel.setBackground(new Color(248,248,248)); // Your background color
     // Remove the button border and ensure the background color is displayed
     // Set up the empty border for padding

        // Combine the line border with the empty border
        settingLabel.setFocusPainted(false);        // Remove focus border (blue outline)
        settingLabel.setContentAreaFilled(true);    // Ensure background color is used
        settingLabel.setOpaque(true);     
        ImageIcon resizedIconsettingLabel= createResizedIcon("/homepanel/settings.png", 20,20); // Adjust the path and size
        settingLabel.setIcon(resizedIconsettingLabel);         
        settingLabel.setBorder(BorderFactory.createLineBorder(new Color(235,235,235,255), 2)); 
        JButton updatesLabel = new JButton(" Check Updates");
        updatesLabel.setHorizontalAlignment(SwingConstants.LEFT);
        updatesLabel.setForeground(Color.BLACK);
        updatesLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        updatesLabel.setBackground(new Color(248,248,248)); // Your background color
     // Remove the button border and ensure the background color is displayed
     // Set up the empty border for padding

        // Combine the line border with the empty border
        updatesLabel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 20)); // Set the border
        updatesLabel.setFocusPainted(false);        // Remove focus border (blue outline)
        updatesLabel.setContentAreaFilled(true);    // Ensure background color is used
        updatesLabel.setOpaque(true);     
        ImageIcon resizedIconupdatesLabel= createResizedIcon("/homepanel/chech_updates.png", 20,20); // Adjust the path and size
        updatesLabel.setIcon(resizedIconupdatesLabel);         
//        updatesLabel.setBorder(BorderFactory.createLineBorder(new Color(235,235,235,255), 2)); 
        JButton logoutLabel = new JButton(" biller - Logout");
        logoutLabel.setHorizontalAlignment(SwingConstants.LEFT);
        logoutLabel.setForeground(Color.BLACK);
        logoutLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        logoutLabel.setBackground(new Color(248,248,248)); // Your background color
     // Remove the button border and ensure the background color is displayed
     // Set up the empty border for padding

        JLabel greengot = new JLabel("");
        greengot.setOpaque(true);
        greengot.setHorizontalAlignment(SwingConstants.CENTER);
        greengot.setBackground(Color.white); // Your background color
        ImageIcon resizedIcongreengot = createResizedIcon("/homepanel/greendot.png", 10,10); // Adjust the path and size
        greengot.setIcon(resizedIcongreengot);
        
        // Combine the line border with the empty border
        logoutLabel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 20)); // Set the border
        logoutLabel.setFocusPainted(false);        // Remove focus border (blue outline)
        logoutLabel.setContentAreaFilled(true);    // Ensure background color is used
        logoutLabel.setOpaque(true);     
        ImageIcon resizedIconlogoutLabel= createResizedIcon("/homepanel/power_off.png", 20,20); // Adjust the path and size
        logoutLabel.setIcon(resizedIconlogoutLabel);                
        
       
        JSeparator s1= new JSeparator();
        s1.setBackground(new Color(239,239,239,255));
        s1.setForeground(new Color(239,239,239,255));

        JSeparator s2= new JSeparator();
        s2.setBackground(new Color(239,239,239,255));
        s2.setForeground(new Color(239,239,239,255));
        
        JSeparator s3= new JSeparator();
        s3.setBackground(new Color(239,239,239,255));
        s3.setForeground(new Color(239,239,239,255));
        
        JSeparator s4= new JSeparator();
        s4.setBackground(new Color(239,239,239,255));
        s4.setForeground(new Color(239,239,239,255));
        
        
        JSeparator s5= new JSeparator();
        s5.setBackground(new Color(239,239,239,255));
        s5.setForeground(new Color(239,239,239,255));
        
        JSeparator s6= new JSeparator();
        s6.setBackground(new Color(222,222,222,255));
        s6.setForeground(new Color(222,222,222,255));
        
        
        
     // Create a panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(248,248,248)); // Set background color for panel

        // Create a label
        JLabel newLabel = new JLabel("112.0.3");
        newLabel.setBackground(Color.WHITE);
        newLabel.setHorizontalAlignment(SwingConstants.CENTER);
        newLabel.setOpaque(true);
        newLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        newLabel.setForeground(Color.BLACK); // Set the label's text color

        // Set GroupLayout for panel
        GroupLayout groupLayout = new GroupLayout(panel);
        panel.setLayout(groupLayout);
        
        // Automatically set gaps between components
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);

        // Create horizontal and vertical groups for GroupLayout
        GroupLayout.SequentialGroup hGroup1 = groupLayout.createSequentialGroup();
        GroupLayout.SequentialGroup vGroup1 = groupLayout.createSequentialGroup();

        // Horizontal group - center the label
        hGroup1.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(newLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE));

        // Vertical group - shift the label down with a gap
        vGroup1.addGap(18) // Add 50 pixels gap above the label (shift it down)
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(newLabel));

        // Set the horizontal and vertical groups in the GroupLayout
        groupLayout.setHorizontalGroup(hGroup1);
        groupLayout.setVerticalGroup(vGroup1);
        
     // Create a panel
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(248,248,248)); // Set background color for panel

        // Create a label
        JLabel newLabel1 = new JLabel("Ctrl+L");
        newLabel1.setBackground(Color.WHITE);
        newLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        newLabel1.setOpaque(true);
        newLabel1.setFont(new Font("Arial", Font.PLAIN, 12));
        
        newLabel1.setForeground(Color.BLACK); // Set the label's text color

        // Set GroupLayout for panel
        GroupLayout groupLayout1 = new GroupLayout(panel1);
        panel1.setLayout(groupLayout1);
        
        // Automatically set gaps between components
        groupLayout1.setAutoCreateGaps(true);
        groupLayout1.setAutoCreateContainerGaps(true);

        // Create horizontal and vertical groups for GroupLayout
        GroupLayout.SequentialGroup hGroup2 = groupLayout1.createSequentialGroup();
        GroupLayout.SequentialGroup vGroup2 = groupLayout1.createSequentialGroup();

        // Horizontal group - center the label
        hGroup2.addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(newLabel1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE));

        // Vertical group - shift the label down with a gap
        vGroup2.addGap(18) // Add 50 pixels gap above the label (shift it down)
                .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(newLabel1));

        // Set the horizontal and vertical groups in the GroupLayout
        groupLayout1.setHorizontalGroup(hGroup2);
        groupLayout1.setVerticalGroup(vGroup2);
        
        // Create a panel
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(248,248,248)); // Set background color for panel

        // Create a label
        JLabel newLabel2 = new JLabel("Ctrl+I");
        newLabel2.setBackground(new Color(248,248,248));
        newLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        newLabel2.setOpaque(true);
        newLabel2.setFont(new Font("Arial", Font.PLAIN, 12));
        
        newLabel2.setForeground(Color.BLACK); // Set the label's text color

        // Set GroupLayout for panel
        GroupLayout groupLayout2 = new GroupLayout(panel2);
        panel2.setLayout(groupLayout2);
        
        // Automatically set gaps between components
        groupLayout2.setAutoCreateGaps(true);
        groupLayout2.setAutoCreateContainerGaps(true);

        // Create horizontal and vertical groups for GroupLayout
        GroupLayout.SequentialGroup hGroup3 = groupLayout2.createSequentialGroup();
        GroupLayout.SequentialGroup vGroup3 = groupLayout2.createSequentialGroup();

        // Horizontal group - center the label
        hGroup3.addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(newLabel2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE));

        // Vertical group - shift the label down with a gap
        vGroup3.addGap(18) // Add 50 pixels gap above the label (shift it down)
                .addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(newLabel2));

        // Set the horizontal and vertical groups in the GroupLayout
        groupLayout2.setHorizontalGroup(hGroup3);
        groupLayout2.setVerticalGroup(vGroup3);
        
        
        // Create a panel
        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(248,248,248)); // Set background color for panel

        // Create a label
        JLabel newLabel3 = new JLabel("Ctrl+R");
        newLabel3.setBackground(Color.WHITE);
        newLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        newLabel3.setOpaque(true);
        newLabel3.setFont(new Font("Arial", Font.PLAIN, 12));
        
        newLabel3.setForeground(Color.BLACK); // Set the label's text color

        // Set GroupLayout for panel
        GroupLayout groupLayout3 = new GroupLayout(panel3);
        panel3.setLayout(groupLayout3);
        
        // Automatically set gaps between components
        groupLayout3.setAutoCreateGaps(true);
        groupLayout3.setAutoCreateContainerGaps(true);

        // Create horizontal and vertical groups for GroupLayout
        GroupLayout.SequentialGroup hGroup4 = groupLayout3.createSequentialGroup();
        GroupLayout.SequentialGroup vGroup4 = groupLayout3.createSequentialGroup();

        // Horizontal group - center the label
        hGroup4.addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(newLabel3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE));

        // Vertical group - shift the label down with a gap
        vGroup4.addGap(18) // Add 50 pixels gap above the label (shift it down)
                .addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(newLabel3));

        // Set the horizontal and vertical groups in the GroupLayout
        groupLayout3.setHorizontalGroup(hGroup4);
        groupLayout3.setVerticalGroup(vGroup4);
        
        
     // Create a panel
        JPanel panel4 = new JPanel();
        panel4.setBackground(new Color(248,248,248)); // Set background color for panel

        // Create a label
        JLabel newLabel4 = new JLabel("Ctrl+S");
        newLabel4.setBackground(Color.WHITE);
        newLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        newLabel4.setOpaque(true);
        newLabel4.setFont(new Font("Arial", Font.PLAIN, 12));
        
        newLabel4.setForeground(Color.BLACK); // Set the label's text color

        // Set GroupLayout for panel
        GroupLayout groupLayout4 = new GroupLayout(panel4);
        panel4.setLayout(groupLayout4);
        
        // Automatically set gaps between components
        groupLayout4.setAutoCreateGaps(true);
        groupLayout4.setAutoCreateContainerGaps(true);

        // Create horizontal and vertical groups for GroupLayout
        GroupLayout.SequentialGroup hGroup5 = groupLayout4.createSequentialGroup();
        GroupLayout.SequentialGroup vGroup5 = groupLayout4.createSequentialGroup();

        // Horizontal group - center the label
        hGroup5.addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(newLabel4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE));

        // Vertical group - shift the label down with a gap
        vGroup5.addGap(18) // Add 50 pixels gap above the label (shift it down)
                .addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(newLabel4));

        // Set the horizontal and vertical groups in the GroupLayout
        groupLayout4.setHorizontalGroup(hGroup5);
        groupLayout4.setVerticalGroup(vGroup5);
        
    
        
     // Create a separator
		JSeparator separator = new JSeparator(); // Create a separator
		separator.setPreferredSize(new Dimension(0, 1)); // Set the height of the separator
		separator.setBackground(new Color(239,239,239,255));
		separator.setForeground(new Color(239,239,239,255));
        
		itemsummary.setVisible(false);
    	salessummary.setVisible(false);
    	ordersummary.setVisible(false);
    	exxecutivesummary.setVisible(false);
    	employeesummary.setVisible(false);
    	settlementsummary.setVisible(false);
    	panel2.setVisible(false);
    	panel3.setVisible(false);
    	panel4.setVisible(false);
    	s1.setVisible(false);
    	s2.setVisible(false);
    	s3.setVisible(false);
    	s4.setVisible(false);
    	s5.setVisible(false);
    	
    	
		
		reportLabel.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(reportclick) {
		    		itemsummary.setVisible(false);
		        	salessummary.setVisible(false);
		        	ordersummary.setVisible(false);
		        	exxecutivesummary.setVisible(false);
		        	employeesummary.setVisible(false);
		        	settlementsummary.setVisible(false);
		        	panel2.setVisible(false);
		        	panel3.setVisible(false);
		        	panel4.setVisible(false);
		        	s1.setVisible(false);
		        	s2.setVisible(false);
		        	s3.setVisible(false);
		        	s4.setVisible(false);
		        	s5.setVisible(false);
		        	reportclick=false;
		    	}
		    	else {
		    		itemsummary.setVisible(true);
			    	panel2.setVisible(true);
			    	panel3.setVisible(true);
			    	panel4.setVisible(true);
			    	salessummary.setVisible(true);
			    	ordersummary.setVisible(true);
			    	exxecutivesummary.setVisible(true);
			    	employeesummary.setVisible(true);
			    	settlementsummary.setVisible(true);
			    	s1.setVisible(true);
			    	s2.setVisible(true);
			    	s3.setVisible(true);
			    	s4.setVisible(true);
			    	s5.setVisible(true);
			    	reportclick=true;
		    	}
		    }
		});
		
		JLabel recentorder = new JLabel("   Recent Orders Detail");
		recentorder.setBackground(Color.WHITE);
		recentorder.setHorizontalAlignment(SwingConstants.LEFT);
		recentorder.setOpaque(true);
		recentorder.setFont(new Font("Arial", Font.BOLD, 13));
		
		JLabel imagelabel = new JLabel("");
		ImageIcon resizedIconimagelabel = createResizedIcon("/homepanel/Capture.PNG", 243,40); // Adjust the path and size
		imagelabel.setIcon(resizedIconimagelabel);
		
		JLabel dinein = new JLabel("Dine In");
		dinein.setForeground(Color.BLACK);
		dinein.setHorizontalAlignment(SwingConstants.CENTER);
        dinein.setFont(new Font("Arial", Font.PLAIN, 12		));
        dinein.setBackground(Color.WHITE); // Your background color
    
        dinein.setOpaque(true);    
        
        JLabel pickup = new JLabel("Pick Up");
        pickup.setForeground(Color.BLACK);
        dinein.setHorizontalAlignment(SwingConstants.CENTER);
        pickup.setFont(new Font("Arial", Font.PLAIN, 12));
        pickup.setBackground(Color.WHITE); // Your background color
    
           // Ensure background color is used
        pickup.setOpaque(true);    	
		
        JLabel delivery = new JLabel("Delivery");
        delivery.setForeground(Color.BLACK);
        dinein.setHorizontalAlignment(SwingConstants.CENTER);
        delivery.setFont(new Font("Arial", Font.PLAIN, 12));
        delivery.setBackground(Color.WHITE); // Your background color
        delivery.setOpaque(true); 
        
        JLabel kot = new JLabel("KOT");
        kot.setHorizontalAlignment(SwingConstants.CENTER);
        kot.setForeground(Color.BLACK);
        kot.setFont(new Font("Arial", Font.PLAIN, 12));
        kot.setBackground(Color.WHITE); // Your background color
        kot.setOpaque(true); 
        
     // Define column names
        String[] columnNames = {"Order No.", "(₹)"};

        // Create a table model with 10 rows and 2 columns
        model = new DefaultTableModel(100, 2);
        model.setColumnIdentifiers(columnNames);

        addMoreData();
        populateTable();

        // Create a JTable with the model
        table = new JTable(model);

        // Set the preferred size of the table
        table.setPreferredScrollableViewportSize(new Dimension(250, 250));

        // Set the width of the columns
        table.getColumnModel().getColumn(0).setPreferredWidth(170);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getTableHeader().setPreferredSize(new Dimension(0, 25));
     // Set the header background color to grey
        table.getTableHeader().	setBackground(new Color(229,229,229,255));

        // Set the header text color to white
        table.getTableHeader().setForeground(Color.BLACK);
        table.setRowHeight(25);

        // Set the header font to bold
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
     // Set the grid line color to white
        table.setGridColor(Color.LIGHT_GRAY);
     // Set the background color of the rows to green
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                component.setBackground(new Color(118,203,96,255));
                return component;
            }
        });
        
        // Set the header border to a thin line
        // Add the table to a scroll pane
        JScrollPane scrollPanetable = new JScrollPane(table);
        scrollPanetable.setPreferredSize(new Dimension(250, 250)); // Set the size of the scroll pane

     
        BillingLabel.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	billpanel();
		    	BillingLabel.setForeground(Color.RED);
		        BillingLabel.setBackground(Color.WHITE); // Your background color
		        greengot.setBackground(Color.WHITE); // Your background color
		        oprtationLabel.setForeground(Color.BLACK);
		        oprtationLabel.setBackground(new Color(248,248,248)); // Your background color
		        reportLabel.setForeground(Color.BLACK);
		        reportLabel.setBackground(new Color(248,248,248)); // Your background color
		        liveviewLabel.setForeground(Color.BLACK);
		        liveviewLabel.setBackground(new Color(248,248,248)); // Your background color
		        settingLabel.setForeground(Color.BLACK);
		        settingLabel.setBackground(new Color(248,248,248)); // Your background color
		        exxecutivesummary.setBackground(new Color(248,248,248)); // Your background color
		        exxecutivesummary.setForeground(Color.BLACK);
		        itemsummary.setForeground(Color.BLACK);
		        panel2.setBackground(new Color(248,248,248)); // Your background color
		        itemsummary.setBackground(new Color(248,248,248)); // Your background color
		    }
		});
        oprtationLabel.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	operationpanel();
		    	BillingLabel.setForeground(Color.RED);
		        BillingLabel.setBackground(new Color(248,248,248)); // Your background color
		        greengot.setBackground(new Color(248,248,248)); // Your background color
		        oprtationLabel.setForeground(Color.BLACK);
		        oprtationLabel.setBackground(Color.WHITE); // Your background color
		        reportLabel.setForeground(Color.BLACK);
		        reportLabel.setBackground(new Color(248,248,248)); // Your background color
		        liveviewLabel.setForeground(Color.BLACK);
		        liveviewLabel.setBackground(new Color(248,248,248)); // Your background color
		        settingLabel.setForeground(Color.BLACK);
		        settingLabel.setBackground(new Color(248,248,248)); // Your background color
		        itemsummary.setForeground(Color.BLACK);
		        itemsummary.setBackground(new Color(248,248,248)); // Your background color
		        panel2.setBackground(new Color(248,248,248)); // Your background color
		        exxecutivesummary.setBackground(new Color(248,248,248)); // Your background color
		        exxecutivesummary.setForeground(Color.BLACK);
		    }
		});
        itemsummary.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	itemsummarypanel();
		    	BillingLabel.setForeground(Color.RED);
		        BillingLabel.setBackground(new Color(248,248,248)); // Your background color
		        greengot.setBackground(new Color(248,248,248)); // Your background color
		        oprtationLabel.setForeground(Color.BLACK);
		        oprtationLabel.setBackground(new Color(248,248,248)); // Your background color
		        reportLabel.setForeground(Color.BLACK);
		        reportLabel.setBackground(new Color(248,248,248)); // Your background color
		        liveviewLabel.setForeground(Color.BLACK);
		        liveviewLabel.setBackground(new Color(248,248,248)); // Your background color
		        settingLabel.setForeground(Color.BLACK);
		        settingLabel.setBackground(new Color(248,248,248)); // Your background color
		        itemsummary.setBackground(Color.WHITE);
		        itemsummary.setForeground(Color.red);
		        panel2.setBackground(Color.WHITE);
		        exxecutivesummary.setBackground(new Color(248,248,248)); // Your background color
		        exxecutivesummary.setForeground(Color.BLACK);
		    }
		});
        
       exxecutivesummary.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	executivesummarypanel();
		    	BillingLabel.setForeground(Color.RED);
		        BillingLabel.setBackground(new Color(248,248,248)); // Your background color
		        greengot.setBackground(new Color(248,248,248)); // Your background color
		        oprtationLabel.setForeground(Color.BLACK);
		        oprtationLabel.setBackground(new Color(248,248,248)); // Your background color
		        reportLabel.setForeground(Color.BLACK);
		        reportLabel.setBackground(new Color(248,248,248)); // Your background color
		        liveviewLabel.setForeground(Color.BLACK);
		        liveviewLabel.setBackground(new Color(248,248,248)); // Your background color
		        settingLabel.setForeground(Color.BLACK);
		        settingLabel.setBackground(new Color(248,248,248)); // Your background color
		        itemsummary.setBackground(new Color(248,248,248));
		        itemsummary.setForeground(Color.BLACK);
		        panel2.setBackground(new Color(248,248,248));
		        exxecutivesummary.setBackground(Color.WHITE);
		        exxecutivesummary.setForeground(Color.red);
		    }
		});

        salessummary.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	PickerUI counter1 = new PickerUI();
				 counter1.setLocationRelativeTo(null);
				 counter1.setVisible(true);
		    }
		});       
        logoutLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the Main class when the button is pressed
            	SQLItemExtractor.main(null); // Assuming there's an execute method		
                Main.main(new String[]{}); // You can pass arguments if needed
                dispose();
            }
        });

        
        
        
        
        // Define GroupLayout for leftPanel with gaps and alignment
        GroupLayout gl_leftPanel = new GroupLayout(leftPanel);
        leftPanel.setLayout(gl_leftPanel);

        // Create horizontal group for leftPanel
        GroupLayout.ParallelGroup hGroup = gl_leftPanel.createParallelGroup(Alignment.LEADING);
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(titleLogo, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(BillingLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addComponent(greengot, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(oprtationLabel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(reportLabel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(itemsummary, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(s1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
        
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(salessummary, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                .addComponent(panel4, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(s2, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
        
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(ordersummary, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(s3, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
        
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(exxecutivesummary, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(s4, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
        
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(employeesummary, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(s5, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
        
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(settlementsummary, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
        
        
        
        
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(liveviewLabel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(settingLabel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
       
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(updatesLabel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(separator, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(logoutLabel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(s6, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
        
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(recentorder, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(imagelabel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(dinein, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                .addComponent(pickup, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addComponent(delivery, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addComponent(kot, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE));
        hGroup.addGroup(gl_leftPanel.createSequentialGroup()
                .addComponent(scrollPanetable, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));
        	
        // Create vertical group for leftPanel
        GroupLayout.SequentialGroup vGroup = gl_leftPanel.createSequentialGroup();
        vGroup.addComponent(titleLogo, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
        			.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
        	  		.addComponent(BillingLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        	  		.addComponent(greengot, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        			.addComponent(oprtationLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        			.addComponent(reportLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        			.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
                			.addComponent(itemsummary, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                			.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        			.addComponent(s1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
        			.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
                			.addComponent(salessummary, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                			.addComponent(panel4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        			.addComponent(s2, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
        			.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
                			.addComponent(ordersummary, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                			.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        			.addComponent(s3, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
        			.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
                			.addComponent(exxecutivesummary, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        			.addComponent(s4, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
        			.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
                			.addComponent(employeesummary, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        			.addComponent(s5, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
        			.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
                			.addComponent(settlementsummary, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        			
        			
        			
        			.addComponent(liveviewLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        			.addComponent(settingLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        			.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
        			.addComponent(updatesLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        			.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
        			.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
        			.addComponent(logoutLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        			.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        			.addComponent(s6, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
        			
        			
        			.addComponent(recentorder, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        			.addComponent(imagelabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGroup(gl_leftPanel.createParallelGroup(Alignment.BASELINE)
                			.addComponent(dinein, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                			.addComponent(pickup, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                			.addComponent(delivery, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                			.addComponent(kot, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                			)
        			.addComponent(scrollPanetable, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)	
        			;

        // Set horizontal and vertical group in the layout for leftPanel
        gl_leftPanel.setHorizontalGroup(hGroup);
        gl_leftPanel.setVerticalGroup(vGroup);
     // Timer to refresh the table every 5 seconds (5000 milliseconds)
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear existing data
                model.setRowCount(0);
             // Create SimpleDateFormat with "ddMMYYYY"
                SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY");
                
                // Get the current date
                String currentDate = sdf.format(new Date());
                readDiscFromFile(filePathdisc+currentDate+".sql");
                // Add new data to the lists and refresh the table
                addMoreData();
                populateTable();
            }
        });
        timer.start();
    }
    // Add more data to simulate dynamic updates
    private void addMoreData() {
    	
    	invoiceNumbers.clear();
    	amounts.clear();
    	 LocalDate currentDate = LocalDate.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
         String formattedDate = currentDate.format(formatter);
         
         String filePath = "C:\\POS\\Invoice_Data\\Complete\\"+formattedDate+".sql"; // Specify the file path
         
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
                        
                        invoiceNumbers.add(invoiceNo);
                        amounts.add(amount);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    	if (!DISCinvoiceNumbers.isEmpty()) {
            for (int i = 0; i < DISCinvoiceNumbers.size(); i++) {
                String newInvoice = DISCinvoiceNumbers.get(i);
                double newAmount = DISCamounts.get(i);

                int index = invoiceNumbers.indexOf(newInvoice);
                if (!invoiceNumbers.isEmpty() && index != -1) {
                    // Invoice exists, update amount by adding newAmount
                	newAmount =newAmount-newAmount*0.05;
                    amounts.set(index, newAmount);
                } else {
                    // New invoice, add it to the list
                    invoiceNumbers.add(newInvoice);
                    amounts.add(newAmount);
                }
            }
        }
    }

    // Populate table with data from the lists
    private void populateTable() {
    	for (int i = invoiceNumbers.size() - 1; i >= 0; i--) {
    		Double amt=amounts.get(i)+(amounts.get(i)*0.05);
    		String amt1=String.format("%.0f", amt);
    		Double Gamt=Double.parseDouble(amt1);
            model.addRow(new Object[]{invoiceNumbers.get(i), Gamt});
        }
    }
    private void billpanel() {
      
        billingPanel = new BillingPanel();
       
        rightPanel.removeAll();
        rightPanel.add(billingPanel.getPanel());
        rightPanel.revalidate();
        rightPanel.repaint();
    }
    private void operationpanel() {
        	OperationPage = new OperationPage();
        rightPanel.removeAll();
        
        rightPanel.add(OperationPage.getPanel()).setVisible(true);
        rightPanel.revalidate();
        rightPanel.repaint();
    }
    
    private void itemsummarypanel() {
    	ItemSummaryReport = new ItemSummaryReport();
    rightPanel.removeAll();
    
    rightPanel.add(ItemSummaryReport.getPanel());
    rightPanel.revalidate();
    rightPanel.repaint();
}
    
    private void executivesummarypanel() {
    	newpanel = new newpanel();
    rightPanel.removeAll();
    
    rightPanel.add(newpanel.getPanel());
    rightPanel.revalidate();
    rightPanel.repaint();
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
    
    private void readDiscFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new String(filePath)))) {
            String line;
            Pattern pattern = Pattern.compile("INSERT INTO Invoice_Disc \\(invoice_number, amount\\) VALUES \\('(.+?)',\\s*'(.+?)'\\);");

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    DISCinvoiceNumbers.add(matcher.group(1)); // Extract invoice_number
                    
                    // Convert amount to double before storing
                    double amountValue = Double.parseDouble(matcher.group(2).trim());
                    DISCamounts.add(amountValue);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error parsing amount: " + e.getMessage());
        }
    }
    
}
