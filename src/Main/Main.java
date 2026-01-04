package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.border.LineBorder;

import org.jdesktop.swingx.prompt.PromptSupport;

public class Main {

    private JFrame frame;
    private JPanel bottomBottomPanel;
    private JPanel rightBottomPanel,leftBottomPanel;
    private JFXPanel videoPanel;  // Keep a reference to the video panel
    private MediaPlayer mediaPlayer; // Keep a reference to the MediaPlayer
    private int clickCount = 0; // Counter for button clicks
    private int input = 0;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
//    --------------------ROUND BUTTON
    // Create a custom JButton class
    class RoundButton extends JButton {
        public RoundButton(String text) {
            super(text);
            setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (getModel().isArmed()) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(getBackground());
            }
            g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 20, 20); // Use fillRoundRect instead of fillOval
            super.paintComponent(g);
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension size = super.getPreferredSize();
            size.width = size.height = Math.max(size.width, size.height);
            return size;
        }
    }
//  -------------------------------------  HINT TEXT FIELD
    public class HintTextField extends JTextField {
        private String hint;
        private int padding;

        // Constructor with hint and padding
        public HintTextField(String hint, int padding) {
            this.hint = hint;
            this.padding = padding; // Padding value
        }

        @Override
        public Insets getInsets() {
            return new Insets(5, padding, 5, 5); // Top, left, bottom, right padding
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (getText().isEmpty()) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(Color.GRAY);  // Color of the hint

                // Set the font to bold
                g2.setFont(g2.getFont().deriveFont(Font.PLAIN));

                // Get font metrics to calculate the vertical position for centering the hint
                FontMetrics fm = g2.getFontMetrics();
                int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent(); // Calculate y for vertical centering

                // Use the padding value for left alignment
                g2.drawString(hint, padding, y);
                g2.dispose();
            }
        }
    }
    
//  -------------------------------------  HINT PASS  FIELD
    
    public class HintPasswordField extends JPasswordField {
        private String hint;
        private int padding;

        // Constructor with hint and padding
        public HintPasswordField(String hint, int padding) {
            this.hint = hint;
            this.padding = padding; // Padding value
        }

        @Override
        public Insets getInsets() {
            return new Insets(5, padding, 5, 5); // Top, left, bottom, right padding
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (getPassword().length == 0) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(Color.GRAY);  // Color of the hint

                // Set the font to bold
                g2.setFont(g2.getFont().deriveFont(Font.PLAIN));

                // Get font metrics to calculate the vertical position for centering the hint
                FontMetrics fm = g2.getFontMetrics();
                int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent(); // Calculate y for vertical centering

                // Use the padding value for left alignment
                g2.drawString(hint, padding, y);
                g2.dispose();
            }
        }
    }
    
    
    /**
     * Create the application.
     */
    public Main() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Dosa Plaza - Food Chain (Amity Noida) (R347249) - The Finest Restaurant Management Platform");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/image/logo.png")));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        // Set the frame's size to the screen size
        frame.setSize(screenSize.width, screenSize.height);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createFolder("C:\\POS");
        createFolder("C:\\POS\\Invoice_Data");
        createFolder("C:\\POS\\Menu_Data");
        createFolder("C:\\POS\\Daily_Report");
        createFolder("C:\\POS\\Monthly_Report");
        createFolder("C:\\POS\\Categorial_Data");
        createFolder("C:\\POS\\DISCOUNT");
        createFolder("C:\\POS\\Invoice_Data\\Complete");
        createFolder("C:\\POS\\Invoice_Data\\Day_Wise");
        Delete_Old_Data();
        createe_data_file();
        delete_Old_File();
        bottomBottomPanel = new JPanel();
        // Create a panel for the top section
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(197,32,49,255)); // Set a background color for visibility

        // Create a panel for the bottom section
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(248,248,248,255)); // Set a background color for visibility

        
        // Create a JSplitPane with a 20-80% split
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, bottomPanel);
        splitPane.setResizeWeight(0.0);
        splitPane.setDividerSize(0);
        JLabel Petpooja_Logo = new JLabel("");
        ImageIcon resizedIcon = createResizedIcon("/image/petpooja.png", 140,50); // Adjust the path and size
        Petpooja_Logo.setIcon(resizedIcon);

        JLabel Dosa_plaza_name = new JLabel("<html><b><font face='Tw Cen MT' size=6>Dosa Plaza - Food Chain (Amity Noida)</font></b><br><b><font face='Calibri (Body)' size=4><font color='#c52031'>___________________________________</font> REF No.: 347249</font></b></html>");
        Dosa_plaza_name.setHorizontalAlignment(SwingConstants.RIGHT);

        Dosa_plaza_name.setForeground(Color.WHITE);

        GroupLayout gl_topPanel = new GroupLayout(topPanel);
        gl_topPanel.setHorizontalGroup(
            gl_topPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_topPanel.createSequentialGroup()
                    .addGap(40)
                    .addComponent(Petpooja_Logo)
                    .addComponent(Dosa_plaza_name)
                    .addGap(40)
                    )
        );
        gl_topPanel.setVerticalGroup(
            gl_topPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_topPanel.createSequentialGroup()
                    .addGap(10)
                    .addGroup(gl_topPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(Petpooja_Logo)
                        .addComponent(Dosa_plaza_name))
                    .addGap(10))
        );
        topPanel.setLayout(gl_topPanel);

        // Create two new panels inside the bottom panel
        leftBottomPanel = new JPanel();
        leftBottomPanel.setBorder(new LineBorder(Color.WHITE, 5, true));
        leftBottomPanel.setBackground(Color.WHITE); // Set a background color for visibility
        leftBottomPanel.setLayout(new BorderLayout()); // Set a layout manager

        
     // Create a panel for the login fields
        leftbottompanellogin();
        
        
        rightBottomPanel = new JPanel();
        rightBottomPanel.setLayout(new BorderLayout()); // Set a layout manager
        rightBottomPanel.setBackground(new Color(248,248,248,255));

        // Add the panels to the bottom panel using a layout manager
        GroupLayout gl_bottomPanel = new GroupLayout(bottomPanel);
        gl_bottomPanel.setHorizontalGroup(
            gl_bottomPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_bottomPanel.createSequentialGroup()
                    .addGap(430)
                    .addComponent(leftBottomPanel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                    .addGap(185)
                    .addComponent(rightBottomPanel, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0))
        );
        gl_bottomPanel.setVerticalGroup(
            gl_bottomPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_bottomPanel.createSequentialGroup()
                		.addGap(60)
                    .addGroup(gl_bottomPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(leftBottomPanel, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
                        .addComponent(rightBottomPanel, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, 0))
        );
        bottomPanel.setLayout(gl_bottomPanel);

     
        displayComponentsInRightBottomPanelmain();
      
        
        // Create a new panel below the bottom panel
        
        bottomBottomPanel.setBackground(Color.WHITE); // Set a background color for visibility
        bottomBottomPanel.setLayout(new BorderLayout()); // Set a layout manager
		bottomBottomPanel.setPreferredSize(new java.awt.Dimension(0, 40)); // Set the preferred height to 20 pixels
		
		// Create a new panel with a GridBagLayout
		bottomBottomPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Create a new panel with a FlowLayout
		JPanel bottomBottomInnerPanel = new JPanel();
		bottomBottomInnerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		bottomBottomInnerPanel.setBackground(Color.WHITE);
		
		JLabel spacer1 = new JLabel(" ");
		spacer1.setPreferredSize(new Dimension(305, 0)); // Set the preferred width to 10 pixels
		JLabel spacer2 = new JLabel(" ");
		spacer2.setPreferredSize(new Dimension(10, 0)); // Set the preferred width to 10 pixels
		JLabel spacer3 = new JLabel(" ");
		spacer3.setPreferredSize(new Dimension(20, 0)); // Set the preferred width to 10 pixels
		JLabel spacer4 = new JLabel(" ");
		spacer4.setPreferredSize(new Dimension(15, 0)); // Set the preferred width to 10 pixels
		JLabel spacer5 = new JLabel(" ");
		spacer5.setPreferredSize(new Dimension(350, 0)); // Set the preferred width to 10 pixels

		
		
		JLabel bottombarhelp = new JLabel("Need Quick Help?");
		bottombarhelp.setFont(new Font("Twentieth Century", Font.PLAIN, 12));
		bottombarhelp.setForeground(Color.BLACK); // Set the text color to black
		
		JLabel bottombarnumber = new JLabel("07969 223344");
		bottombarnumber.setFont(new Font("Twentieth Century", Font.PLAIN, 12));
		bottombarnumber.setForeground(new Color(238,52,70,255)); // Set the text color to black
		ImageIcon resizedIconcall = createResizedIcon("/image/callbutton.png", 15,15); // Adjust the path and size
		bottombarnumber.setIcon(resizedIconcall);
		
		JLabel bottombarsupport = new JLabel("Contact for Support");
		bottombarsupport.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		bottombarsupport.setForeground(Color.WHITE); // Set the text color to black

		JLabel bottombaremail = new JLabel("support@petpooja.com");
		bottombaremail.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		bottombaremail.setForeground(Color.BLACK); // Set the text color to black
		ImageIcon resizedIconemail = createResizedIcon("/image/mailicon.png", 17,12); // Adjust the path and size
		bottombaremail.setIcon(resizedIconemail);
		
		JLabel bottombarversion = new JLabel("Version  112.0.3");
		bottombarversion.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		bottombarversion.setForeground(Color.GRAY); // Set the text color to black
		
		// Add labels to the inner panel
		bottomBottomInnerPanel.add(spacer1);
		bottomBottomInnerPanel.add(bottombarhelp); // Add the label to the panel
		bottomBottomInnerPanel.add(spacer2);
		bottomBottomInnerPanel.add(bottombarnumber);
		bottomBottomInnerPanel.add(spacer3);
		bottomBottomInnerPanel.add(bottombarsupport);
		bottomBottomInnerPanel.add(spacer4);
		bottomBottomInnerPanel.add(bottombaremail);
		bottomBottomInnerPanel.add(spacer5);
		bottomBottomInnerPanel.add(bottombarversion);

		// Add the inner panel to the bottomBottomPanel
		gbc.anchor = GridBagConstraints.CENTER; // Center the inner panel
		bottomBottomPanel.add(bottomBottomInnerPanel, gbc);
		
        // Create a GridBagLayout for the frame's content pane
        GridBagLayout gbl_frameContentPane = new GridBagLayout();
        gbl_frameContentPane.columnWeights = new double[]{1.0};
        gbl_frameContentPane.rowWeights = new double[]{1.0, 0.0};
        frame.getContentPane().setLayout(gbl_frameContentPane);

        // Add the split pane to the frame's content pane
        GridBagConstraints gbc_splitPane = new GridBagConstraints();
        gbc_splitPane.fill = GridBagConstraints.BOTH;
        gbc_splitPane.gridx = 0;
        gbc_splitPane.gridy = 0;
        gbc_splitPane.weightx = 1.0;
        gbc_splitPane.weighty = 1.0;
        frame.getContentPane().add(splitPane, gbc_splitPane);

        // Add the new panel to the frame's content pane
        GridBagConstraints gbc_bottomBottomPanel = new GridBagConstraints();
        gbc_bottomBottomPanel.fill = GridBagConstraints.HORIZONTAL;
        gbc_bottomBottomPanel.gridx = 0;
        gbc_bottomBottomPanel.gridy = 1;
        gbc_bottomBottomPanel.weightx = 1.0;
        gbc_bottomBottomPanel.weighty = 0.0;
        frame.getContentPane().add(bottomBottomPanel, gbc_bottomBottomPanel);
    }
    private void delete_Old_File() {
        LocalDate currentDate = LocalDate.now();
        YearMonth currentMonth = YearMonth.from(currentDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String directoryPath = "C:\\POS\\Invoice_Data\\Day_Wise";
        List<String> matchingFiles = new ArrayList<>();
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    if (fileName.matches("\\d{8}\\.sql")) {
                        String fileDateString = fileName.substring(0, 8);
                        LocalDate fileDate = LocalDate.parse(fileDateString, formatter);
                        
                        // Delete files not in the current month
                        if (!YearMonth.from(fileDate).equals(currentMonth)) {
                            if (file.delete()) {
                                matchingFiles.add(fileName);
                                System.out.println("Deleted file: " + fileName);
                            } else {
                                System.out.println("Failed to delete file: " + fileName);
                            }
                        }
                    }
                }
            }
        }

        if (!matchingFiles.isEmpty()) {
            System.out.println("Matching files deleted:");
            for (String fileName : matchingFiles) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("No matching files found or deleted.");
        }
    }

    private void createe_data_file() {
    	// Get current date
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String formattedDate = currentDate.format(formatter);
    	String filePath = "C:\\POS\\Invoice_Data\\Complete\\"+formattedDate+".sql";
        try {
            if (!Files.exists(Paths.get(filePath))) {
                Files.createFile(Paths.get(filePath));
                System.out.println("Blank SQL file created successfully at " + filePath);
            } else {
                System.out.println("File already exists at " + filePath);
            }
        } catch (IOException e) {
            System.err.println("Error creating SQL file: " + e.getMessage());
        }
    }
    public void clearRightBottomPanel() {
        rightBottomPanel.removeAll();
        rightBottomPanel.revalidate();
        rightBottomPanel.repaint();
    }
    public void clearLeftBottomPanel() {
        leftBottomPanel.removeAll();
        leftBottomPanel.revalidate();
        leftBottomPanel.repaint();
    }
    public void displayComponentsInRightBottomPanelmain() {
        rightBottomPanel.removeAll();

        // Create the buttons
        RoundButton buttonA = new RoundButton("  Login");
        buttonA.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonA.setBackground(new Color(197,32,49,255)); // Set the background color
        buttonA.setForeground(Color.WHITE); // Set the text color
        buttonA.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Set the border
        buttonA.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left
        ImageIcon resizedIconbuttonA = createResizedIcon("/image/profilecodewhite.png", 15,15); // Adjust the path and size
        buttonA.setIcon(resizedIconbuttonA);

        RoundButton buttonB = new RoundButton("  Passcode");
        buttonB.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonB.setBackground(Color.WHITE); // Set the background color
        buttonB.setForeground(Color.BLACK); // Set the text color
        buttonB.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Set the border
        buttonB.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left
        ImageIcon resizedIconbuttonB = createResizedIcon("/image/passcode.png", 15,15); // Adjust the path and size
        buttonB.setIcon(resizedIconbuttonB);

        RoundButton buttonC = new RoundButton("Swipe Card");
        buttonC.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonC.setBackground(Color.WHITE); // Set the background color
        buttonC.setForeground(Color.BLACK); // Set the text color
        buttonC.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Set the border
        buttonC.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left
        ImageIcon resizedIconbuttonC = createResizedIcon("/image/swipecaedwhi.png", 15,15); // Adjust the path and size
        buttonC.setIcon(resizedIconbuttonC);

        buttonA.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	
            }
        });

        buttonB.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Clear the rightBottomPanel
                clearRightBottomPanel();
                clearLeftBottomPanel();
                leftbottompanellogpasscode();
                // Add the new elements to the rightBottomPanel
                displayComponentsInRightBottomPanel1();
            }
        });

        buttonC.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	 // Clear the rightBottomPanel
                clearRightBottomPanel();
                clearLeftBottomPanel();
                leftbottompanellogswipe();
                // Add the new elements to the rightBottomPanel
            	displayComponentsInRightBottomPanel2();
            }
        });
        
        JPanel buttonPanel = new JPanel();
        GroupLayout layout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(layout);
        buttonPanel.setBackground(new Color(248,248,248,255));
        
     // Configure the layout
        layout.setHorizontalGroup(
        	    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        	        .addComponent(buttonA, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
        	        .addGroup(layout.createSequentialGroup()
        	        		.addGap(20)
        	        .addComponent(buttonB, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
        	        .addGroup(layout.createSequentialGroup()
        	        		.addGap(20)
        	        .addComponent(buttonC, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
        	);

        	layout.setVerticalGroup(
        	    layout.createSequentialGroup()
        	    	.addGap(30)
        	        .addComponent(buttonA, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
        	        .addGap(10)
        	        .addComponent(buttonB, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
        	        .addGap(10)
        	        .addComponent(buttonC, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
        	);
     // Add the button panel to the left bottom panel
        rightBottomPanel.setLayout(new BorderLayout());
        rightBottomPanel.add(buttonPanel, BorderLayout.WEST);
        rightBottomPanel.revalidate();
        rightBottomPanel.repaint();
    }
 // Delete old data from SQL file
    private void Delete_Old_Data() {
        LocalDate currentDate = LocalDate.now();
        YearMonth currentMonth = YearMonth.from(currentDate); // Get current year and month
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String directoryPath = "C:\\POS\\Invoice_Data\\Complete";
        List<String> matchingFiles = new ArrayList<>();
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    if (fileName.matches("\\d{8}\\.sql")) {
                        String fileDateString = fileName.substring(0, 8);
                        LocalDate fileDate = LocalDate.parse(fileDateString, formatter);
                        
                        // Delete files that are not in the current month
                        if (!YearMonth.from(fileDate).equals(currentMonth)) {
                            if (file.delete()) {
                                matchingFiles.add(fileName);
                                System.out.println("Deleted file: " + fileName);
                            } else {
                                System.out.println("Failed to delete file: " + fileName);
                            }
                        }
                    }
                }
            }
        }

        if (!matchingFiles.isEmpty()) {
            System.out.println("Matching files deleted:");
            for (String fileName : matchingFiles) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("No matching files found or deleted.");
        }
    }


    public static void createFolder(String path) {
        // Create a File object with the specified path
        File newFolder = new File(path);

        // Check if the folder already exists
        if (!newFolder.exists()) {
            // Try to create the directory
            boolean isCreated = newFolder.mkdir();

            // Check if the directory was created successfully
            if (isCreated) {
                System.out.println("Folder created successfully: " + path);
            } else {
                System.out.println("Failed to create the folder: " + path);
            }
        } else {
            System.out.println("Folder already exists: " + path);
        }
    }
    public void displayComponentsInRightBottomPanel1() {
    	rightBottomPanel.removeAll();

        // Create the buttons
        RoundButton buttonA = new RoundButton("  Login");
        buttonA.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonA.setBackground(Color.WHITE); // Set the background color
        buttonA.setForeground(Color.BLACK); // Set the text color
        buttonA.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Set the border
        buttonA.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left
        ImageIcon resizedIconbuttonA = createResizedIcon("/image/profilecode.png", 15,15); // Adjust the path and size
        buttonA.setIcon(resizedIconbuttonA);

        RoundButton buttonB = new RoundButton("  Passcode");
        buttonB.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonB.setBackground(new Color(197,32,49,255)); // Set the background color
        buttonB.setForeground(Color.WHITE); // Set the text color
        buttonB.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Set the border
        buttonB.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left
        ImageIcon resizedIconbuttonB = createResizedIcon("/image/passcodewhite.png", 15,15); // Adjust the path and size
        buttonB.setIcon(resizedIconbuttonB);

        RoundButton buttonC = new RoundButton("Swipe Card");
        buttonC.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonC.setBackground(Color.WHITE); // Set the background color
        buttonC.setForeground(Color.BLACK); // Set the text color
        buttonC.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Set the border
        buttonC.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left
        ImageIcon resizedIconbuttonC = createResizedIcon("/image/swipecaedwhi.png", 15,15); // Adjust the path and size
        buttonC.setIcon(resizedIconbuttonC);

        buttonA.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Clear the rightBottomPanel
                clearRightBottomPanel();
                clearLeftBottomPanel();
                leftbottompanellogin();

                // Add the new elements to the rightBottomPanel
                displayComponentsInRightBottomPanelmain();
            }
        });

        buttonB.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            }
        });

        buttonC.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	// Clear the rightBottomPanel
            	 clearRightBottomPanel();
                 clearLeftBottomPanel();
                 leftbottompanellogswipe();
                 // Add the new elements to the rightBottomPanel
             	displayComponentsInRightBottomPanel2();
            }
        });
        
        JPanel buttonPanel = new JPanel();
        GroupLayout layout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(layout);
        buttonPanel.setBackground(new Color(248,248,248,255));
        
     // Configure the layout
        layout.setHorizontalGroup(
        	    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        	    .addGroup(layout.createSequentialGroup()
    	        		.addGap(20)
        	        .addComponent(buttonA, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
        	        .addGroup(layout.createSequentialGroup()
//        	        		.addGap(20)
        	        .addComponent(buttonB, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
        	        .addGroup(layout.createSequentialGroup()
        	        		.addGap(20)
        	        .addComponent(buttonC, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
        	);

        	layout.setVerticalGroup(
        	    layout.createSequentialGroup()
        	    	.addGap(30)
        	        .addComponent(buttonA, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
        	        .addGap(10)
        	        .addComponent(buttonB, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
        	        .addGap(10)
        	        .addComponent(buttonC, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
        	);
     // Add the button panel to the left bottom panel
        rightBottomPanel.setLayout(new BorderLayout());
        rightBottomPanel.add(buttonPanel, BorderLayout.WEST);
        rightBottomPanel.revalidate();
        rightBottomPanel.repaint();
    }
    public void displayComponentsInRightBottomPanel2() {
    	rightBottomPanel.removeAll();

        // Create the buttons
        RoundButton buttonA = new RoundButton("  Login");
        buttonA.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonA.setBackground(Color.WHITE); // Set the background color
        buttonA.setForeground(Color.BLACK); // Set the text color
        buttonA.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Set the border
        buttonA.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left
        ImageIcon resizedIconbuttonA = createResizedIcon("/image/profilecode.png", 15,15); // Adjust the path and size
        buttonA.setIcon(resizedIconbuttonA);

        RoundButton buttonB = new RoundButton("  Passcode");
        buttonB.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonB.setBackground(Color.WHITE); // Set the background color
        buttonB.setForeground(Color.BLACK); // Set the text color
        buttonB.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Set the border
        buttonB.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left
        ImageIcon resizedIconbuttonB = createResizedIcon("/image/passcode.png", 15,15); // Adjust the path and size
        buttonB.setIcon(resizedIconbuttonB);

        RoundButton buttonC = new RoundButton("  Swipe Card");
        buttonC.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonC.setBackground(new Color(197,32,49,255)); // Set the background color
        buttonC.setForeground(Color.WHITE); // Set the text color
        buttonC.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Set the border
        buttonC.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left
        ImageIcon resizedIconbuttonC = createResizedIcon("/image/swipecaedwhi.png", 15,15); // Adjust the path and size
        buttonC.setIcon(resizedIconbuttonC);

        buttonA.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Clear the rightBottomPanel
                clearRightBottomPanel();
                clearLeftBottomPanel();
                leftbottompanellogin();

                // Add the new elements to the rightBottomPanel
                displayComponentsInRightBottomPanelmain();
            }
        });

        buttonB.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	// Clear the rightBottomPanel
                clearRightBottomPanel();
                clearLeftBottomPanel();
                leftbottompanellogpasscode();
                // Add the new elements to the rightBottomPanel
                displayComponentsInRightBottomPanel1();
            }
        });

        buttonC.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	
            }
        });
        
        JPanel buttonPanel = new JPanel();
        GroupLayout layout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(layout);
        buttonPanel.setBackground(new Color(248,248,248,255));
        
     // Configure the layout
        layout.setHorizontalGroup(
        	    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        	    .addGroup(layout.createSequentialGroup()
    	        		.addGap(20)
        	        .addComponent(buttonA, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
        	        .addGroup(layout.createSequentialGroup()
        	        		.addGap(20)
        	        .addComponent(buttonB, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
        	        .addGroup(layout.createSequentialGroup()
//        	        		.addGap(20)
        	        .addComponent(buttonC, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
        	);

        	layout.setVerticalGroup(
        	    layout.createSequentialGroup()
        	    	.addGap(30)
        	        .addComponent(buttonA, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
        	        .addGap(10)
        	        .addComponent(buttonB, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
        	        .addGap(10)
        	        .addComponent(buttonC, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
        	);
     // Add the button panel to the left bottom panel
        rightBottomPanel.setLayout(new BorderLayout());
        rightBottomPanel.add(buttonPanel, BorderLayout.WEST);
        rightBottomPanel.revalidate();
        rightBottomPanel.repaint();
    }
    private void leftbottompanellogin() {
    	String correctUsernameADMIN = "Admin"; // Replace "your_admin_username_here" with your actual admin username
        String correctPasswordADMIN = "Admin@DP1008"; // Replace "your_admin_password_here" with your actual admin password
        
    	// Create a panel for the login fields
        JPanel loginPanel = new JPanel();
        GroupLayout gl_loginPanel = new GroupLayout(loginPanel);
        loginPanel.setBackground(Color.WHITE); 
        loginPanel.setLayout(gl_loginPanel);

        // Create the login heading
        JLabel loginHeading = new JLabel("Login to your Billing Station");
        loginHeading.setFont(new Font("Century Gothic", Font.BOLD, 18));
        JLabel loginHeading2 = new JLabel("Enter your username and password");
        loginHeading2.setFont(new Font("Century Gothic", Font.PLAIN, 14));

        // Create the login name heading
        JLabel loginNameHeading = new JLabel("User Name");
        loginNameHeading.setForeground(Color.DARK_GRAY);
        loginNameHeading.setFont(new Font("Tw Cen MT", Font.PLAIN, 13));

        // Create the login name input field
        HintTextField  loginNameInput = new HintTextField ("Enter username",10);
        loginNameInput.setBorder(new LineBorder(new Color(229,231,234,255), 1, true));
        loginNameInput.setColumns(20);

        // Create the password heading
        JLabel passwordHeading = new JLabel("Password");
        passwordHeading.setForeground(Color.DARK_GRAY);
        passwordHeading.setFont(new Font("Tw Cen MT", Font.PLAIN, 13));

        // Create the password input field
        HintPasswordField passwordInput = new HintPasswordField("Enter password",10);
        passwordInput.setBorder(new LineBorder(new Color(229,231,234,255), 1, true));
        passwordInput.setColumns(20);

        
        
        // Create the login button
        JButton loginButton = new JButton("Log in");
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(197,32,49,255));
        loginButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
        loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String enteredUsername = loginNameInput.getText();  // Retrieve the username inside the ActionListener
			        String enteredPassword = new String(passwordInput.getPassword());  // Retrieve the password inside the ActionListener
			        
			        if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
			            // Empty username or password, show warning
			            JOptionPane.showMessageDialog(null, "Please enter both username and password.", "Empty Fields", JOptionPane.WARNING_MESSAGE);
			        } else if (enteredUsername.equals(correctUsernameADMIN) && enteredPassword.equals(correctPasswordADMIN)) {
			            // Correct admin username and password, open the admin panel window
			            AdminPanel adminPanel = new AdminPanel();
			            adminPanel.setVisible(true);

			            // Close the login page
			            frame.dispose();
			        } else {
			            // Wrong username or password, show warning
			            JOptionPane.showMessageDialog(null, "Incorrect username or password. Please try again.", "Incorrect Credentials", JOptionPane.WARNING_MESSAGE);
			        }
				}
			});
        

     // Add the new label to the layout
     gl_loginPanel.setHorizontalGroup(
         gl_loginPanel.createParallelGroup(Alignment.CENTER)
             .addGroup(gl_loginPanel.createSequentialGroup()
                 .addContainerGap()
                 .addGroup(gl_loginPanel.createParallelGroup(Alignment.CENTER)
                     .addComponent(loginHeading)
                     .addComponent(loginHeading2)) // Add the new label here
                 .addContainerGap())
             .addGroup(gl_loginPanel.createSequentialGroup()
            		 .addGap(30)
                 
                 .addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
                		
                     .addComponent(loginNameHeading)
                     .addComponent(loginNameInput,GroupLayout.PREFERRED_SIZE,385,GroupLayout.PREFERRED_SIZE)
                     .addComponent(passwordHeading)
                     .addComponent(passwordInput,GroupLayout.PREFERRED_SIZE,385,GroupLayout.PREFERRED_SIZE)
                     .addComponent(loginButton,GroupLayout.PREFERRED_SIZE,385,GroupLayout.PREFERRED_SIZE))
                 .addContainerGap())
     );

     gl_loginPanel.setVerticalGroup(
         gl_loginPanel.createParallelGroup(Alignment.LEADING)
             .addGroup(gl_loginPanel.createSequentialGroup()
                 .addGap(20)
                 .addComponent(loginHeading)
                 .addGap(3)
                 .addComponent(loginHeading2) // Add the new label here
                 .addGap(20)
                 .addComponent(loginNameHeading)
                 .addGap(10)
                 .addComponent(loginNameInput, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                 .addGap(20)
                 .addComponent(passwordHeading)
                 .addGap(10)
                 .addComponent(passwordInput, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                 .addGap(20)
                 .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                 .addContainerGap())
     );

        // Add the login panel to the leftBottomPanel
        leftBottomPanel.add(loginPanel, BorderLayout.CENTER);
    }
    private void leftbottompanellogpasscode() {
    	
    	clickCount = 0;
    	
    	
    	// Create a panel for the login fields
        JPanel loginPanel = new JPanel();
        GroupLayout gl_loginPanel = new GroupLayout(loginPanel);
        loginPanel.setBackground(Color.WHITE); 
        loginPanel.setLayout(gl_loginPanel);
        
       
        

        // Create the login heading
        JLabel loginHeading = new JLabel("Login to your Billing Station");
        loginHeading.setFont(new Font("Century Gothic", Font.BOLD, 18));
        JLabel loginHeading2 = new JLabel("Enter your passcode");
        loginHeading2.setFont(new Font("Century Gothic", Font.PLAIN, 14));

     // Create a new panel below the loginHeading2 for the new buttons
        JPanel newPanel = new JPanel();
        newPanel.setBackground(new Color(247,243,244)); // Set a background color for the new panel
        GroupLayout gl_newPanel = new GroupLayout(newPanel); // Set GroupLayout for newPanel
        newPanel.setLayout(gl_newPanel);

        // Create 4 buttons for newPanel
        CircularButton btn1 = new CircularButton("");
        btn1.setBackground(Color.WHITE);
        btn1.setForeground(Color.GRAY);
        btn1.setPreferredSize(new Dimension(20, 20)); // Smaller size
        CircularButton btn2 = new CircularButton("");
        btn2.setBackground(Color.WHITE);
        btn2.setForeground(Color.GRAY);
        btn2.setPreferredSize(new Dimension(20, 20)); // Smaller size
        CircularButton btn3 = new CircularButton("");
        btn3.setBackground(Color.WHITE);
        btn3.setForeground(Color.GRAY);
        btn3.setPreferredSize(new Dimension(20, 20)); // Smaller size
        CircularButton btn4 = new CircularButton("");
        btn4.setBackground(Color.WHITE);
        btn4.setForeground(Color.GRAY	);
        btn4.setPreferredSize(new Dimension(20, 20)); // Smaller size

        

        // Arrange buttons in a single row within the newPanel
     // Set the horizontal group
        gl_newPanel.setHorizontalGroup(
            gl_newPanel.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(gl_newPanel.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btn1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                    .addGap(30)
                    .addComponent(btn2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                    .addGap(30)
                    .addComponent(btn3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                    .addGap(30)
                    .addComponent(btn4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)
                )
        );

        // Set the vertical group
        gl_newPanel.setVerticalGroup(
            gl_newPanel.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(gl_newPanel.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(gl_newPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btn1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                    )
                    .addGap(0, 0, Short.MAX_VALUE)
                )
        );


        
        JButton numberButton1 = new JButton();
        numberButton1.setBackground(Color.WHITE); // Button background color
        numberButton1.setForeground(Color.BLACK); // Text color
        ImageIcon resizedIcon1 = createResizedIcon("/image/NO1.png", 45,45); // Adjust the path and size
        numberButton1.setIcon(resizedIcon1);
        numberButton1.setBorderPainted(false);   // Remove the border
        numberButton1.setFocusPainted(false);    // Remove the focus border
        numberButton1.setContentAreaFilled(false); // Remove the background fill
        numberButton1.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		 clickCount++; // Increment the click count

                 // Change button colors based on click count
                 switch (clickCount) {
                     case 1:
                         btn1.setBackground(Color.RED); // Set btn1 to red
                         input= input*10+1;
                         break;
                     case 2:
                         btn2.setBackground(Color.RED); // Set btn2 to red
                         input= input*10+1;
                         break;
                     case 3:
                         btn3.setBackground(Color.RED); // Set btn3 to red
                         input= input*10+1;
                         break;
                     case 4:
                         btn4.setBackground(Color.RED); // Set btn4 to red
                         input= input*10+1;
                         
                         if(input==1234)
                        	 System.out.println("LOGIN SUCCESSFUL");
                         else
                        	 System.out.println("INVALID CREDENTIALS");
                         break;
                     case 5:
                         // Reset all buttons to black
                         btn1.setBackground(Color.WHITE);
                         btn2.setBackground(Color.WHITE);
                         btn3.setBackground(Color.WHITE);
                         btn4.setBackground(Color.WHITE);
                         clickCount = 0; // Reset the click count
                         input = 0;
                         break;
                     default:
                         break; // No action for more than 5 clicks
                 }
             }
         });
        
        JButton numberButton2 = new JButton();
        numberButton2.setBackground(Color.WHITE); // Button background color
        numberButton2.setForeground(Color.BLACK); // Text color
        ImageIcon resizedIcon2 = createResizedIcon("/image/NO2.png", 45,45); // Adjust the path and size
        numberButton2.setIcon(resizedIcon2);
        numberButton2.setBorderPainted(false);   // Remove the border
        numberButton2.setFocusPainted(false);    // Remove the focus border
        numberButton2.setContentAreaFilled(false); // Remove the background fill
        numberButton2.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		 clickCount++; // Increment the click count

                 // Change button colors based on click count
                 switch (clickCount) {
                     case 1:
                         btn1.setBackground(Color.RED); // Set btn1 to red
                         input= input*10+2;
                         break;
                     case 2:
                         btn2.setBackground(Color.RED); // Set btn2 to red
                         input= input*10+2;
                         break;
                     case 3:
                         btn3.setBackground(Color.RED); // Set btn3 to red
                         input= input*10+2;
                         break;
                     case 4:
                         btn4.setBackground(Color.RED); // Set btn4 to red
                         input= input*10+2;
                         if(input==1234)
                        	 System.out.println("LOGIN SUCCESSFUL");
                         else
                        	 System.out.println("INVALID CREDENTIALS");
                         break;
                     case 5:
                         // Reset all buttons to black
                         btn1.setBackground(Color.WHITE);
                         btn2.setBackground(Color.WHITE);
                         btn3.setBackground(Color.WHITE);
                         btn4.setBackground(Color.WHITE);
                         clickCount = 0; // Reset the click count
                         input = 0;
                         break;
                     default:
                         break; // No action for more than 5 clicks
                 }
             }
         });
        
        
        JButton numberButton3 = new JButton();
        numberButton3.setBackground(Color.WHITE); // Button background color
        numberButton3.setForeground(Color.BLACK); // Text color
        ImageIcon resizedIcon3 = createResizedIcon("/image/NO3.png", 45,45); // Adjust the path and size
        numberButton3.setIcon(resizedIcon3);
        numberButton3.setBorderPainted(false);   // Remove the border
        numberButton3.setFocusPainted(false);    // Remove the focus border
        numberButton3.setContentAreaFilled(false); // Remove the background fill
        numberButton3.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		 clickCount++; // Increment the click count

                 // Change button colors based on click count
                 switch (clickCount) {
                     case 1:
                         btn1.setBackground(Color.RED); // Set btn1 to red
                         input= input*10+3;
                         break;
                     case 2:
                         btn2.setBackground(Color.RED); // Set btn2 to red
                         input= input*10+3;
                         break;
                     case 3:
                         btn3.setBackground(Color.RED); // Set btn3 to red
                         input= input*10+3;
                         break;
                     case 4:
                         btn4.setBackground(Color.RED); // Set btn4 to red
                         input= input*10+3;
                         if(input==1234)
                        	 System.out.println("LOGIN SUCCESSFUL");
                         else
                        	 System.out.println("INVALID CREDENTIALS");
                         break;
                     case 5:
                         // Reset all buttons to black
                         btn1.setBackground(Color.WHITE);
                         btn2.setBackground(Color.WHITE);
                         btn3.setBackground(Color.WHITE);
                         btn4.setBackground(Color.WHITE);
                         clickCount = 0; // Reset the click count
                         input = 0;
                         break;
                     default:
                         break; // No action for more than 5 clicks
                 }
             }
         });
        
        JButton numberButton4 = new JButton();
        numberButton4.setBackground(Color.WHITE); // Button background color
        numberButton4.setForeground(Color.BLACK); // Text color
        ImageIcon resizedIcon4 = createResizedIcon("/image/NO$.png", 45,45); // Adjust the path and size
        numberButton4.setIcon(resizedIcon4);
        numberButton4.setBorderPainted(false);   // Remove the border
        numberButton4.setFocusPainted(false);    // Remove the focus border
        numberButton4.setContentAreaFilled(false); // Remove the background fill
        numberButton4.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		 clickCount++; // Increment the click count

                 // Change button colors based on click count
                 switch (clickCount) {
                     case 1:
                         btn1.setBackground(Color.RED); // Set btn1 to red
                         input= input*10+4;
                         break;
                     case 2:
                         btn2.setBackground(Color.RED); // Set btn2 to red
                         input= input*10+4;
                         break;
                     case 3:
                         btn3.setBackground(Color.RED); // Set btn3 to red
                         input= input*10+4;
                         break;
                     case 4:
                         btn4.setBackground(Color.RED); // Set btn4 to red
                         input= input*10+4;
                         if(input==1234) {
                        	 System.out.println("LOGIN SUCCESSFUL");
                        	 frame.dispose();
                        	 HomePage Frame = new HomePage();
                        	 Frame.setVisible(true);
                        	
                        	
                        	    }
                         else
                        	 System.out.println("INVALID CREDENTIALS");
                         break;
                     case 5:
                         // Reset all buttons to black
                         btn1.setBackground(Color.WHITE);
                         btn2.setBackground(Color.WHITE);
                         btn3.setBackground(Color.WHITE);
                         btn4.setBackground(Color.WHITE);
                         clickCount = 0; // Reset the click count
                         input = 0;
                         break;
                     default:
                         break; // No action for more than 5 clicks
                 }
             }
         });
        
        JButton numberButton5 = new JButton();
        numberButton5.setBackground(Color.WHITE); // Button background color
        numberButton5.setForeground(Color.BLACK); // Text color
        ImageIcon resizedIcon5 = createResizedIcon("/image/NO5.png", 45,45); // Adjust the path and size
        numberButton5.setIcon(resizedIcon5);
        numberButton5.setBorderPainted(false);   // Remove the border
        numberButton5.setFocusPainted(false);    // Remove the focus border
        numberButton5.setContentAreaFilled(false); // Remove the background fill
        numberButton5.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		 clickCount++; // Increment the click count

                 // Change button colors based on click count
                 switch (clickCount) {
                     case 1:
                         btn1.setBackground(Color.RED); // Set btn1 to red
                         input= input*10+5;
                         break;
                     case 2:
                         btn2.setBackground(Color.RED); // Set btn2 to red
                         input= input*10+5;
                         break;
                     case 3:
                         btn3.setBackground(Color.RED); // Set btn3 to red
                         input= input*10+5;
                         break;
                     case 4:
                         btn4.setBackground(Color.RED); // Set btn4 to red
                         input= input*10+5;
                         if(input==1234)
                        	 System.out.println("LOGIN SUCCESSFUL");
                         else
                        	 System.out.println("INVALID CREDENTIALS");
                         break;
                     case 5:
                         // Reset all buttons to black
                         btn1.setBackground(Color.WHITE);
                         btn2.setBackground(Color.WHITE);
                         btn3.setBackground(Color.WHITE);
                         btn4.setBackground(Color.WHITE);
                         clickCount = 0; // Reset the click count
                         input = 0;
                         break;
                     default:
                         break; // No action for more than 5 clicks
                 }
             }
         });
        
        JButton numberButton6 = new JButton();
        numberButton6.setBackground(Color.WHITE); // Button background color
        numberButton6.setForeground(Color.BLACK); // Text color
        ImageIcon resizedIcon6 = createResizedIcon("/image/NO6.png", 45,45); // Adjust the path and size
        numberButton6.setIcon(resizedIcon6);
        numberButton6.setBorderPainted(false);   // Remove the border
        numberButton6.setFocusPainted(false);    // Remove the focus border
        numberButton6.setContentAreaFilled(false); // Remove the background fill
        numberButton6.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		 clickCount++; // Increment the click count

                 // Change button colors based on click count
                 switch (clickCount) {
                     case 1:
                         btn1.setBackground(Color.RED); // Set btn1 to red
                         input= input*10+6;
                         break;
                     case 2:
                         btn2.setBackground(Color.RED); // Set btn2 to red
                         input= input*10+6;
                         break;
                     case 3:
                         btn3.setBackground(Color.RED); // Set btn3 to red
                         input= input*10+6;
                         break;
                     case 4:
                         btn4.setBackground(Color.RED); // Set btn4 to red
                         input= input*10+6;
                         if(input==1234)
                        	 System.out.println("LOGIN SUCCESSFUL");
                         else
                        	 System.out.println("INVALID CREDENTIALS");
                         break;
                     case 5:
                         // Reset all buttons to black
                         btn1.setBackground(Color.WHITE);
                         btn2.setBackground(Color.WHITE);
                         btn3.setBackground(Color.WHITE);
                         btn4.setBackground(Color.WHITE);
                         clickCount = 0; // Reset the click count
                         input = 0;
                         break;
                     default:
                         break; // No action for more than 5 clicks
                 }
             }
         });
        
        JButton numberButton7 = new JButton();
        numberButton7.setBackground(Color.WHITE); // Button background color
        numberButton7.setForeground(Color.BLACK); // Text color
        ImageIcon resizedIcon7 = createResizedIcon("/image/NO7.png", 45,45); // Adjust the path and size
        numberButton7.setIcon(resizedIcon7);
        numberButton7.setBorderPainted(false);   // Remove the border
        numberButton7.setFocusPainted(false);    // Remove the focus border
        numberButton7.setContentAreaFilled(false); // Remove the background fill
        numberButton7.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		 clickCount++; // Increment the click count

                 // Change button colors based on click count
                 switch (clickCount) {
                     case 1:
                         btn1.setBackground(Color.RED); // Set btn1 to red
                         input= input*10+7;
                         break;
                     case 2:
                         btn2.setBackground(Color.RED); // Set btn2 to red
                         input= input*10+7;
                         break;
                     case 3:
                         btn3.setBackground(Color.RED); // Set btn3 to red
                         input= input*10+7;
                         break;
                     case 4:
                         btn4.setBackground(Color.RED); // Set btn4 to red
                         input= input*10+7;
                         if(input==1234)
                        	 System.out.println("LOGIN SUCCESSFUL");
                         else
                        	 System.out.println("INVALID CREDENTIALS");
                         break;
                     case 5:
                         // Reset all buttons to black
                         btn1.setBackground(Color.WHITE);
                         btn2.setBackground(Color.WHITE);
                         btn3.setBackground(Color.WHITE);
                         btn4.setBackground(Color.WHITE);
                         clickCount = 0; // Reset the click count
                         input = 0;
                         break;
                     default:
                         break; // No action for more than 5 clicks
                 }
             }
         });
        
        JButton numberButton8 = new JButton();
        numberButton8.setBackground(Color.WHITE); // Button background color
        numberButton8.setForeground(Color.BLACK); // Text color
        ImageIcon resizedIcon8 = createResizedIcon("/image/NO8.png", 45,45); // Adjust the path and size
        numberButton8.setIcon(resizedIcon8);
        numberButton8.setBorderPainted(false);   // Remove the border
        numberButton8.setFocusPainted(false);    // Remove the focus border
        numberButton8.setContentAreaFilled(false); // Remove the background fill
        numberButton8.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		 clickCount++; // Increment the click count

                 // Change button colors based on click count
                 switch (clickCount) {
                     case 1:
                         btn1.setBackground(Color.RED); // Set btn1 to red
                         input= input*10+8;
                         break;
                     case 2:
                         btn2.setBackground(Color.RED); // Set btn2 to red
                         input= input*10+8;
                         break;
                     case 3:
                         btn3.setBackground(Color.RED); // Set btn3 to red
                         input= input*10+8;
                         break;
                     case 4:
                         btn4.setBackground(Color.RED); // Set btn4 to red
                         input= input*10+8;
                         if(input==1234)
                        	 System.out.println("LOGIN SUCCESSFUL");
                         else
                        	 System.out.println("INVALID CREDENTIALS");
                         break;
                     case 5:
                         // Reset all buttons to black
                         btn1.setBackground(Color.WHITE);
                         btn2.setBackground(Color.WHITE);
                         btn3.setBackground(Color.WHITE);
                         btn4.setBackground(Color.BLACK);
                         clickCount = 0; // Reset the click count
                         input = 0;
                         break;
                     default:
                         break; // No action for more than 5 clicks
                 }
             }
         });
        
        JButton numberButton9 = new JButton();
        numberButton9.setBackground(Color.WHITE); // Button background color
        numberButton9.setForeground(Color.BLACK); // Text color
        ImageIcon resizedIcon9 = createResizedIcon("/image/NO9.png", 45,45); // Adjust the path and size
        numberButton9.setIcon(resizedIcon9);
        numberButton9.setBorderPainted(false);   // Remove the border
        numberButton9.setFocusPainted(false);    // Remove the focus border
        numberButton9.setContentAreaFilled(false); // Remove the background fill
        numberButton9.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		 clickCount++; // Increment the click count

                 // Change button colors based on click count
                 switch (clickCount) {
                     case 1:
                         btn1.setBackground(Color.RED); // Set btn1 to red
                         input= input*10+9;
                         break;
                     case 2:
                         btn2.setBackground(Color.RED); // Set btn2 to red
                         input= input*10+9;
                         break;
                     case 3:
                         btn3.setBackground(Color.RED); // Set btn3 to red
                         input= input*10+9;
                         break;
                     case 4:
                         btn4.setBackground(Color.RED); // Set btn4 to red
                         input= input*10+9;
                         if(input==1234)
                        	 System.out.println("LOGIN SUCCESSFUL");
                         else
                        	 System.out.println("INVALID CREDENTIALS");
                         break;
                     case 5:
                         // Reset all buttons to black
                         btn1.setBackground(Color.WHITE);
                         btn2.setBackground(Color.WHITE);
                         btn3.setBackground(Color.WHITE);
                         btn4.setBackground(Color.WHITE);
                         clickCount = 0; // Reset the click count
                         input = 0;
                         break;
                     default:
                         break; // No action for more than 5 clicks
                 }
             }
         });
        
        JButton numberButton0 = new JButton();
        numberButton0.setBackground(Color.WHITE); // Button background color
        numberButton0.setForeground(Color.BLACK); // Text color
        ImageIcon resizedIcon0 = createResizedIcon("/image/NO0.png", 45,45); // Adjust the path and size
        numberButton0.setIcon(resizedIcon0);
        numberButton0.setBorderPainted(false);   // Remove the border
        numberButton0.setFocusPainted(false);    // Remove the focus border
        numberButton0.setContentAreaFilled(false); // Remove the background fill
        numberButton0.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		 clickCount++; // Increment the click count

                 // Change button colors based on click count
                 switch (clickCount) {
                     case 1:
                         btn1.setBackground(Color.RED); // Set btn1 to red
                         input= input*10+0;
                         break;
                     case 2:
                         btn2.setBackground(Color.RED); // Set btn2 to red
                         input= input*10+0;
                         break;
                     case 3:
                         btn3.setBackground(Color.RED); // Set btn3 to red
                         input= input*10+0;
                         break;
                     case 4:
                         btn4.setBackground(Color.RED); // Set btn4 to red
                         input= input*10+0;
                         if(input==1234)
                        	 System.out.println("LOGIN SUCCESSFUL");
                         else
                        	 System.out.println("INVALID CREDENTIALS");
                         break;
                     case 5:
                         // Reset all buttons to black
                         btn1.setBackground(Color.WHITE);
                         btn2.setBackground(Color.WHITE);
                         btn3.setBackground(Color.WHITE);
                         btn4.setBackground(Color.BLACK);
                         clickCount = 0; // Reset the click count
                         input = 0;
                         break;
                     default:
                         break; // No action for more than 5 clicks
                 }
             }
         });
        
        JButton numberButtonx = new JButton();
        numberButtonx.setBackground(Color.WHITE); // Button background color
        numberButtonx.setForeground(Color.BLACK); // Text color
        ImageIcon resizedIconx = createResizedIcon("/image/NOCROSS.png", 45,45); // Adjust the path and size
        numberButtonx.setIcon(resizedIconx);
        numberButtonx.setBorderPainted(false);   // Remove the border
        numberButtonx.setFocusPainted(false);    // Remove the focus border
        numberButtonx.setContentAreaFilled(false); // Remove the background fill
        numberButtonx.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		 
                         // Reset all buttons to black
                         btn1.setBackground(Color.WHITE);
                         btn2.setBackground(Color.WHITE);
                         btn3.setBackground(Color.WHITE);
                         btn4.setBackground(Color.WHITE);
                         clickCount = 0; // Reset the click count
                         input = 0;
                        
             }
         });
        
        JButton numberButtonback = new JButton();
        numberButtonback.setBackground(Color.WHITE); // Button background color
        numberButtonback.setForeground(Color.BLACK); // Text color
        ImageIcon resizedIconback = createResizedIcon("/image/NOBACK.png", 45,45); // Adjust the path and size
        numberButtonback.setIcon(resizedIconback);
        numberButtonback.setBorderPainted(false);   // Remove the border
        numberButtonback.setFocusPainted(false);    // Remove the focus border
        numberButtonback.setContentAreaFilled(false); // Remove the background fill
        numberButtonback.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		

        		String titleLabelText = "Alert"; // Your custom label text
        		String message = "Please enter valid Passcode";

        		// Create a JDialog for the alert box
        		JDialog dialog = new JDialog();
        		dialog.setUndecorated(true); // Remove the default title bar
        		dialog.setSize(550, 180); // Set custom size
        		dialog.setLocationRelativeTo(null); // Center the dialog

        		// Create the main panel
        		JPanel panel = new JPanel();
        		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Set black outline
        		panel.setBackground(Color.WHITE); // Set background color
        		GroupLayout gl = new GroupLayout(panel);
        		panel.setLayout(gl);
        		gl.setAutoCreateGaps(true);
        		gl.setAutoCreateContainerGaps(true);

        		// Create title label
        		JLabel titleLabel = new JLabel(titleLabelText);
        		titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        		titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10)); // Add some padding
        		ImageIcon resizedIcontitleLabel = createResizedIcon("/image/alerticon.png", 40, 40); // Adjust the path and size
        		titleLabel.setIcon(resizedIcontitleLabel);

        		// Create close button
        		JButton closeButton = new JButton("X");
        		closeButton.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font for the close button
        		closeButton.setPreferredSize(new Dimension(30, 30)); // Set size for the close button
        		closeButton.setBorderPainted(false); // Remove border
        		closeButton.setContentAreaFilled(false); // Remove background
        		closeButton.setFocusPainted(false); // Remove focus outline
        		closeButton.setForeground(Color.GRAY); // Set color for the close button
        		closeButton.addActionListener(new ActionListener() {
        		    @Override
        		    public void actionPerformed(ActionEvent e) {
        		        dialog.dispose(); // Close the dialog when clicked
        		    }
        		});

        		// Create a separator
        		JSeparator separator = new JSeparator(); // Create a separator
        		separator.setPreferredSize(new Dimension(0, 1)); // Set the height of the separator
        		separator.setBackground(Color.LIGHT_GRAY);
        		separator.setForeground(Color.LIGHT_GRAY);

        		JSeparator separator1 = new JSeparator(); // Create a separator
        		separator1.setPreferredSize(new Dimension(0, 1)); // Set the height of the separator
        		separator1.setBackground(Color.LIGHT_GRAY);
        		separator1.setForeground(Color.LIGHT_GRAY);
        		
        		// Create a message label
        		JLabel messageLabel = new JLabel(message, SwingConstants.LEFT);
        		messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        		messageLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10)); // Add padding to the message label

        		JButton okButton = new JButton("OK");
        		okButton.setPreferredSize(new Dimension(80, 30));
        		okButton.setBackground(Color.GRAY); // Set the background color
        		okButton.setForeground(Color.BLACK); // Set the text color
        		okButton.setBackground(Color.WHITE);
        		okButton.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
        		okButton.setHorizontalAlignment(SwingConstants.CENTER); // Align text to the left
        		okButton.addActionListener(new ActionListener() {
        		    @Override
        		    public void actionPerformed(ActionEvent e) {
        		        dialog.dispose(); // Close the dialog when clicked
        		    }
        		});
        		
        		// Create a button panel for the OK button
        		JPanel buttonPanel = new JPanel();
        		buttonPanel.setBackground(Color.WHITE);
        		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Align contents to the right
        		buttonPanel.add(okButton);

        		// Set the layout for the GroupLayout
        		gl.setHorizontalGroup(
        		    gl.createSequentialGroup()
        		        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
        		            .addGroup(gl.createSequentialGroup()
        		                .addComponent(titleLabel)
        		                .addGap(380)
        		                .addComponent(closeButton) // Add the close button next to the title label
        		            )
        		            .addComponent(separator) // Move the separator to the left with no gaps
        		            .addComponent(messageLabel)
        		            .addComponent(separator1)
        		            .addComponent(buttonPanel, GroupLayout.Alignment.TRAILING)) // Add button panel with OK button
        		        .addContainerGap()
        		);

        		gl.setVerticalGroup(
        		    gl.createSequentialGroup()
        		        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
        		            .addComponent(titleLabel)
        		            .addComponent(closeButton) // Align close button with title label
        		        )
        		        .addComponent(separator) // Separator aligned to the left with no space
        		        .addGap(10)
        		        .addComponent(messageLabel)
        		        .addGap(10)
        		        .addComponent(separator1)
        		        .addComponent(buttonPanel) // Add button panel for OK button
        		);

        		// Add the panel to the dialog
        		dialog.add(panel);
        		dialog.setVisible(true);



}
         });

        


        // Add the new label and panel to the layout
        // Add the new label and panel to the layout
        gl_loginPanel.setAutoCreateGaps(false); // Optional: Automatically create gaps between components
        gl_loginPanel.setAutoCreateContainerGaps(false); // Optional: Automatically create gaps around the container

        gl_loginPanel.setHorizontalGroup(
            gl_loginPanel.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(gl_loginPanel.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_loginPanel.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(loginHeading)
                        .addComponent(loginHeading2)
                        // Add the new panel here
                    )
                    .addContainerGap())
                .addGroup(gl_loginPanel.createSequentialGroup()
                		.addGap(100)
                		.addGroup(gl_loginPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                		.addComponent(newPanel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                		.addGap(370)))
                
                .addGroup(gl_loginPanel.createSequentialGroup()
//                    .addGap(30)
                    .addGroup(gl_loginPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_loginPanel.createSequentialGroup()
                            .addComponent(numberButton1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(54)
                            .addComponent(numberButton2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(54)
                            .addComponent(numberButton3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(20))
                        .addGroup(gl_loginPanel.createSequentialGroup()
                            .addComponent(numberButton4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(54)
                            .addComponent(numberButton5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(54)
                            .addComponent(numberButton6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(20))
                        .addGroup(gl_loginPanel.createSequentialGroup()
                            .addComponent(numberButton7, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(54)
                            .addComponent(numberButton8, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(54)
                            .addComponent(numberButton9, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(20))
                        .addGroup(gl_loginPanel.createSequentialGroup()
                            .addComponent(numberButtonx, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(54)
                            .addComponent(numberButton0, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(54)
                            .addComponent(numberButtonback, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(20))
                    )
                    .addContainerGap())
        );

        gl_loginPanel.setVerticalGroup(
            gl_loginPanel.createSequentialGroup()
                .addGap(20)
                .addComponent(loginHeading)
                .addGap(3)
                .addComponent(loginHeading2)
                .addGap(10)
                .addGroup(gl_loginPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(newPanel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addGroup(gl_loginPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(numberButton1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberButton2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberButton3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    )
                .addGap(15)
                .addGroup(gl_loginPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(numberButton4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberButton5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberButton6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                .addGap(15)
                .addGroup(gl_loginPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(numberButton7, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberButton8, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberButton9, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                .addGap(15)
                .addGroup(gl_loginPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(numberButtonx, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberButton0, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberButtonback, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addContainerGap()
        );

        // Add the login panel to the leftBottomPanel
        leftBottomPanel.add(loginPanel, BorderLayout.CENTER);
    }
    
    private void leftbottompanellogswipe() {
        // Create a panel for the login fields
        JPanel loginPanel = new JPanel();
        GroupLayout gl_loginPanel = new GroupLayout(loginPanel);
        loginPanel.setBackground(Color.WHITE);
        loginPanel.setLayout(gl_loginPanel);

        // Create the login heading
        JLabel loginHeading = new JLabel("Login to your Billing Station");
        loginHeading.setFont(new Font("Century Gothic", Font.BOLD, 18));
        JLabel loginHeading2 = new JLabel("Swipe your card on the machine.");
        loginHeading2.setFont(new Font("Century Gothic", Font.PLAIN, 14));

        // Add components to the layout
        gl_loginPanel.setAutoCreateGaps(true);
        gl_loginPanel.setAutoCreateContainerGaps(true);

        gl_loginPanel.setHorizontalGroup(
            gl_loginPanel.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(gl_loginPanel.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_loginPanel.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(loginHeading)
                        .addComponent(loginHeading2)
                    )
                    .addContainerGap())
        );

        gl_loginPanel.setVerticalGroup(
            gl_loginPanel.createSequentialGroup()
                .addGap(20)
                .addComponent(loginHeading)
                .addGap(3)
                .addComponent(loginHeading2)
        );

        // Add the login panel to the leftBottomPanel
        leftBottomPanel.add(loginPanel, BorderLayout.CENTER);
    }


    // Call this method when switching panels to clean up the MediaPlayer
    private void cleanupMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.stop(); // Stop playback
            mediaPlayer.dispose(); // Release resources
            mediaPlayer = null; // Allow garbage collection
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
}