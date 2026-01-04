package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.BevelBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Choice;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
//@SuppressWarnings("all")
public class PickerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JDatePickerImpl StartDatePicker;
	private JDatePickerImpl EndDatePicker;
	private String formattedDatenew;
	private boolean isShortFormatChecked = false;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PickerUI() {
		setForeground(new Color(0, 0, 0));
		setTitle("Sales Analysis");
//		setIconImage(Toolkit.getDefaultToolkit().getImage(PickerUI.class.getResource("/images/LOGO-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(650,320);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		// Get current date
        LocalDate currentDatenew = LocalDate.now();
        DateTimeFormatter formatternew = DateTimeFormatter.ofPattern("ddMMyyyy");
        formattedDatenew = currentDatenew.format(formatternew);
        
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("ColorChooser.swatchesDefaultRecentColor"));
		panel.setBorder(new CompoundBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(105, 105, 105)), null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 574, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1.setBackground(SystemColor.menu);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		JSeparator separator2 = new JSeparator();
        separator2.setForeground(Color.LIGHT_GRAY);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		 
		// Create a new separator
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setOrientation(SwingConstants.VERTICAL);
		 
		 JSeparator separator_2 = new JSeparator();
		 separator_2.setForeground(Color.LIGHT_GRAY);
		 
		 JSeparator separator_5 = new JSeparator();
		 separator_5.setForeground(Color.LIGHT_GRAY);
		 separator_5.setOrientation(SwingConstants.VERTICAL);
		 
		 JSeparator separator_6 = new JSeparator();
		 separator_6.setForeground(Color.LIGHT_GRAY);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("Document Selector");
		lblNewLabel.setForeground(new Color(0, 0, 51));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
						.addComponent(lblNewLabel))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"C01", "Counter Sale"},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"", ""
			}
		)
		{
			 @Override
		        public boolean isCellEditable(int row, int column) {
		            return false;
		        }
		});
		table.setTableHeader(null);
		// Override the isCellEditable method to make cells non-editable
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(Color.LIGHT_GRAY);
		separator_7.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setForeground(Color.LIGHT_GRAY);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setForeground(Color.LIGHT_GRAY);
		separator_9.setOrientation(SwingConstants.VERTICAL);
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_3 = new JPanel();
		
		JPanel panel_4 = new JPanel();
		
		JLabel lblOutputDevice = new JLabel("Output Device:");
		lblOutputDevice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOutputDevice.setForeground(new Color(0, 0, 51));
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Screen");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		rdbtnNewRadioButton_2.setForeground(new Color(0, 0, 51));
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Printer");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		rdbtnNewRadioButton_3.setForeground(new Color(0, 0, 51));
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			
		    public void actionPerformed(ActionEvent e) {
		        
		    	if (isShortFormatChecked) {
		    	    // Create new window
		    	    REPORTVIEW_SHORTCUT2 counter = new REPORTVIEW_SHORTCUT2();
		    	    counter.setVisible(true);  // Show it as a separate window
		    	}

		    	else {
		    	
		    	// Get the selected dates from the date pickers
		        java.util.Date startDateObj = (java.util.Date) StartDatePicker.getModel().getValue();
		        java.util.Date endDateObj = (java.util.Date) EndDatePicker.getModel().getValue();

		        Instant startDateInstant = startDateObj.toInstant();
		        Instant endDateInstant = endDateObj.toInstant();

		        LocalDate startDate = LocalDate.ofInstant(startDateInstant, ZoneId.systemDefault());
		        LocalDate endDate = LocalDate.ofInstant(endDateInstant, ZoneId.systemDefault());

		        // Print the selected dates
		        System.out.println("Start Date: " + startDate);
//		        System.out.println("End Date: " + endDate);
		     // Check if rdbtnNewRadioButton_2 is selected
		        
		        
			        if (rdbtnNewRadioButton_2.isSelected()) {
			        	 GetReport1(startDate,endDate);
			        }
			     // Check if rdbtnNewRadioButton_2 is selected
			        if (rdbtnNewRadioButton_3.isSelected()) {
			        	 GetReport(startDate,endDate);
			        }
		        }
		        // Call the GetReport method
//		        GetReport(startDate,endDate);
//		        GetReport1(startDate,endDate);
		    }
		});
//		btnOk.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				GetReport();
//			}
//		});
		btnOk.setBackground(SystemColor.inactiveCaption);
		btnOk.setIcon(createResizedIcon("/images/greentick.png",15,15));
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setIcon(createResizedIcon("/images/360_F_711193350_YMDuQkVVH9WCuDbCgKlmsGcXaweaRij8-removebg-preview.png",15,15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
//							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator2, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator_6, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addComponent(separator_5, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addComponent(separator_7, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))))
						.addComponent(separator_8, GroupLayout.PREFERRED_SIZE, 595, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblOutputDevice)
							.addGap(15)
							.addComponent(rdbtnNewRadioButton_2)
							.addGap(15)
							.addComponent(rdbtnNewRadioButton_3)
							.addGap(30)
							.addComponent(separator_9, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
//							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(separator_7, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(5)
									.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
//							.addGap()
							.addComponent(separator_6, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addComponent(separator_5, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_8, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(separator_9, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOutputDevice)
								.addComponent(rdbtnNewRadioButton_2)
								.addComponent(rdbtnNewRadioButton_3)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnOk)
								.addComponent(btnNewButton)))))
		);
		
		JLabel lblNewLabel_3 = new JLabel("Item:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setForeground(new Color(0, 0, 51));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("All Items");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton.setForeground(new Color(0, 0, 51));
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Selective Item");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_1.setForeground(new Color(0, 0, 51));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
//					.addContainerGap()
						.addGap(4)
					.addComponent(lblNewLabel_3)
					.addGap(18)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnNewRadioButton_1)
						.addComponent(rdbtnNewRadioButton))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(rdbtnNewRadioButton))
					.addPreferredGap(ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
					.addComponent(rdbtnNewRadioButton_1))
		);
		panel_4.setLayout(gl_panel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Format:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(new Color(0, 0, 51));
		// Create the Choice menu
				Choice choice = new Choice();
				choice.add("Item Group + Item Wise");
				
				JCheckBox chckbxNewCheckBox = new JCheckBox("Short Format");
				chckbxNewCheckBox.setForeground(new Color(0, 0, 51));
				chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
				// Add action listener to update global variable
		        chckbxNewCheckBox.addActionListener(e -> {
		            isShortFormatChecked = chckbxNewCheckBox.isSelected();
		            System.out.println("Checkbox status updated: " + isShortFormatChecked);
		            // You can add more logic here based on the checkbox status
		        });

				
				GroupLayout gl_panel_3 = new GroupLayout(panel_3);
				gl_panel_3.setHorizontalGroup(
					gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
//							.addContainerGap()
								.addGap(4)
							.addComponent(lblNewLabel_2)
//							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGap(8)
							.addComponent(choice, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(60)
							.addComponent(chckbxNewCheckBox)
							.addContainerGap(94, Short.MAX_VALUE))
				);
				gl_panel_3.setVerticalGroup(
					gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(choice, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(chckbxNewCheckBox))
				);
				panel_3.setLayout(gl_panel_3);
		
		JLabel lblPeriod = new JLabel("Period:");
		lblPeriod.setBounds(10, 11, 40, 14);
		lblPeriod.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPeriod.setForeground(new Color(0, 0, 51));
		
		// Initialize the start date picker
       
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
       

	

		
		JLabel lblNewLabel_1 = new JLabel("to");
		lblNewLabel_1.setBounds(143, 11, 15, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(0, 0, 51));
		
		 // Date Picker
        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl StartDatePanel = new JDatePanelImpl(model, p);
        StartDatePicker = new JDatePickerImpl(StartDatePanel, new DateLabelFormatter());
        StartDatePicker.setShowYearButtons(true);
        StartDatePicker.getJFormattedTextField().setBorder(new LineBorder(new Color(171, 173, 179)));
        StartDatePicker.getJFormattedTextField().setBackground(Color.WHITE);
        StartDatePicker.getJFormattedTextField().setHorizontalAlignment(SwingConstants.CENTER);

        // Adjust button size
        JButton button = (JButton) StartDatePicker.getComponent(1);
        button.setPreferredSize(new Dimension(1, 20));
        button.setText("");
        button.setIcon(createResizedIcon("/images/calendar-icon-simple-style-sale-offer-poster-background-symbol-calendar-brand-logo-design-element-calendar-t-shirt-printing-for-sticker-free-vector.jpg",15,15));

        // Date Picker
        UtilDateModel Endmodel = new UtilDateModel();
        JDatePanelImpl EndDatePanel = new JDatePanelImpl(Endmodel, p);
        EndDatePicker = new JDatePickerImpl(EndDatePanel, new DateLabelFormatter());
        EndDatePicker.getJFormattedTextField().setHorizontalAlignment(SwingConstants.CENTER);
        EndDatePicker.setShowYearButtons(true);
        EndDatePicker.getJFormattedTextField().setBorder(new LineBorder(new Color(171, 173, 179)));
        EndDatePicker.getJFormattedTextField().setBackground(Color.WHITE);

        // Adjust button size
        JButton Endbutton = (JButton) EndDatePicker.getComponent(1);
        Endbutton.setPreferredSize(new Dimension(1, 20));
        Endbutton.setText("");
        Endbutton.setIcon(createResizedIcon("/images/calendar-icon-simple-style-sale-offer-poster-background-symbol-calendar-brand-logo-design-element-calendar-t-shirt-printing-for-sticker-free-vector.jpg",15,15));
        
        // Panel for Date Picker
        JPanel datePanelContainer = new JPanel();
     // Panel for Date Picker
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
                gl_panel_2.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addGap(4)
                                .addComponent(lblPeriod)
                                .addGap(10)
                                .addComponent(StartDatePicker, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(lblNewLabel_1)
                                .addGap(10)
                                .addComponent(EndDatePicker, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(10))
        );
        gl_panel_2.setVerticalGroup(
                gl_panel_2.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addGap(11)
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblPeriod)
                                        .addComponent(StartDatePicker, GroupLayout.PREFERRED_SIZE,19, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(EndDatePicker, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                                .addGap(0))
        );

        panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
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
	public void GetReport(LocalDate startDate1,LocalDate endDate1) {
		String filePath = "C:\\POS\\Invoice_Data\\Complete\\"+formattedDatenew+".sql";



        DefaultTableModel tableModel1 = new DefaultTableModel();
        tableModel1.addColumn("Date");
        tableModel1.addColumn("Name");
        tableModel1.addColumn("Unit Price");
        tableModel1.addColumn("Quantity");
        tableModel1.addColumn("Total");
        JTable table1 = new JTable(tableModel1);
        JScrollPane scrollPane1 = new JScrollPane(table1);

        DefaultTableModel tableModel2 = new DefaultTableModel();
        tableModel2.addColumn("Name");
        tableModel2.addColumn("Quantity");
        tableModel2.addColumn("Total");
        JTable table2 = new JTable(tableModel2);
        JScrollPane scrollPane2 = new JScrollPane(table2);

        DefaultTableModel tableModel3 = new DefaultTableModel();
        tableModel3.addColumn("Name");
        tableModel3.addColumn("Quantity");
        tableModel3.addColumn("Total");
        JTable table3 = new JTable(tableModel3);
        JScrollPane scrollPane3 = new JScrollPane(table3);
        
        DefaultTableModel tableModel4 = new DefaultTableModel();
        tableModel4.addColumn("Name");
        tableModel4.addColumn("Quantity");
        tableModel4.addColumn("Total");
        JTable table4 = new JTable(tableModel4);
        JScrollPane scrollPane4 = new JScrollPane(table4);
        
        DefaultTableModel tableModel5 = new DefaultTableModel();
        tableModel5.addColumn("Name");
        tableModel5.addColumn("Quantity");
        tableModel5.addColumn("Total");
        JTable table5 = new JTable(tableModel5);
        JScrollPane scrollPane5 = new JScrollPane(table5);

        DefaultTableModel tableModel6 = new DefaultTableModel();
        tableModel6.addColumn("Name");
        tableModel6.addColumn("Quantity");
        tableModel6.addColumn("Total");
        JTable table6 = new JTable(tableModel6);
        JScrollPane scrollPane6 = new JScrollPane(table6);
        
        DefaultTableModel tableModel7 = new DefaultTableModel();
        tableModel7.addColumn("Name");
        tableModel7.addColumn("Quantity");
        tableModel7.addColumn("Total");
        JTable table7 = new JTable(tableModel7);
        JScrollPane scrollPane7 = new JScrollPane(table7);
        
        DefaultTableModel tableModel8 = new DefaultTableModel();
        tableModel8.addColumn("Name");
        tableModel8.addColumn("Quantity");
        tableModel8.addColumn("Total");
        JTable table8 = new JTable(tableModel8);
        JScrollPane scrollPane8 = new JScrollPane(table8);
        
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
                for (int j = 0; j < tableModel1.getRowCount(); j++) {
                    if (tableModel1.getValueAt(j, 1).equals(productName)) {
                        // Update the quantity and total
                        int existingQuantity = Integer.parseInt((String) tableModel1.getValueAt(j, 3));
                        int newQuantity = existingQuantity + quantityInt;
                        tableModel1.setValueAt(String.valueOf(newQuantity), j, 3);

                        double newTotal = unitPriceDouble * newQuantity;
                        String newTotalString = String.format("%.2f", newTotal);
                        tableModel1.setValueAt(newTotalString, j, 4);

                        productExists = true;
                        break;
                    }
                }

                if (!productExists) {
                    // Add a new row to the first table
                    String[] data1 = new String[]{dateStr, productName, unitPrice, String.valueOf(quantityInt), totalString};
                    tableModel1.addRow(data1);
                }
            }
            
//            ===================================== SOUTH INDIAN DATA ========================
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

//            String[] SouthproductNames = {"Upma", "Chennai Idli 2 Pcs", "Spl. Mini Idli 12pcs", "14 Ghee Idli", "Mini Medu Wada 2pcs", "Mini Medu Wada 4pcs", "Dal Wada 2pcs", "Dal Wada 4pcs", "Dahi Wada 4pcs", "Sada Dosa", "Mysore Sada Dosa", "Masala Dosa", "Rocket Mysore Dosa", "Mysore Masala Dosa", "Onion Masala Dosa", "Paneer Masala Dosa", "Paneer Onion Masala Dosa", "Maharaja Masala Dosa", "Prem Masala Dosa", "Harabhara Masala Dosa", "Navratna Masala Dosa", "Garlic Roast Dosa", "Pudy Roast Dos", "Prem Sada 4 Types Of Chatni", "Maharaja Sada Dosa", "Harabhara Sada", "Schezwan Sada", "Onion Sada Dosa", "Spring Roll Dosa", "Paneer Spring Roll", "Chinese Delight Dosa", "Paneer Chinese Delight Dosa", "American Chopsuey Dosa", "Paneer American Chopsuey Dosa", "Mushroom Chopsuey Dosa", "Paneer Chilly Dosa", "Schezwan Dosa", "Mushroom Schezwan Dosa", "Paneer Schezwan Dosa", "Capsium Schezwan Dosa", "Tom-Chi Dosa", "Chaap Dosa", "American Delight Dosa", "American Paneer Delight Dosa", "Salad Roast Dosa", "Paneer Salad Roast Dosa", "Mexican Roast Dosa", "Red Chilly Dosa", "Paneer Crispy Dosa", "Aloo Crispy Dosa", "Mexi Roll Dosa", "Salsa Lite", "Salsa Noodles Dosa", "Sizz-Lee Noodles Dosa", "Corn Mac 'N' Cheese Dosa", "Pasta Dosa", "Onion Delight", "Hot Garlic Mexican", "Chilly Delight", "Paper Roast Dosa", "Special Pream Paper Roast Dosa", "Mysore Uttappa", "Tom-Chi Uttappa", "Plain Uttappa", "Onion Uttappa", "Paneer Onion Uttappa", "Tomato Uttappa", "Masala Uttappa", "Sandwich Uttappa", "Spl. Pream Uttappa", "Paneer Special Prem Uttappa", "Spl. Spicy Uttappa", "Spl. Paneer Spicy Uttappa", "Idli Manchurian", "Idli Schezwan", "Idli Chilly", "Idli Cheese Manchurian", "Idli Paneer Manchurian", "Idli Fry", "Bisebelle Bhatt", "Thakkali Sadan", "Chitranna", "Dahi Rice", "Chickpea Rice", "Shahi Korma Rice", "Mini Lunch", "Chetinad Biryani"};

            for (int j = 0; j < tableModel1.getRowCount(); j++) {
                String productName = (String) tableModel1.getValueAt(j, 1);
                for (String name : SouthIndianproductArray) {
                    if (productName.equals(name)) {
                        String quantity = (String) tableModel1.getValueAt(j, 3);
                        String total = (String) tableModel1.getValueAt(j, 4);
                        tableModel2.addRow(new Object[]{productName, quantity, total});
                        break;
                    }
                    if (productName.contains("Corn")) {
                        String quantity = (String) tableModel1.getValueAt(j, 1);
                        Object total = tableModel1.getValueAt(j, 2);
                        tableModel2.addRow(new Object[]{productName,quantity,total});
                        break;
                    }
                    if (productName.equals("4 Pcs")) {
                        String quantity = (String) tableModel1.getValueAt(j, 1);
                        Object total = tableModel1.getValueAt(j, 2);
                        tableModel2.addRow(new Object[]{productName,quantity,total});
                        break;
                    }
                }
            }
//            =====================================================================================
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

//            String[] SouthproductNames = {"Upma", "Chennai Idli 2 Pcs", "Spl. Mini Idli 12pcs", "14 Ghee Idli", "Mini Medu Wada 2pcs", "Mini Medu Wada 4pcs", "Dal Wada 2pcs", "Dal Wada 4pcs", "Dahi Wada 4pcs", "Sada Dosa", "Mysore Sada Dosa", "Masala Dosa", "Rocket Mysore Dosa", "Mysore Masala Dosa", "Onion Masala Dosa", "Paneer Masala Dosa", "Paneer Onion Masala Dosa", "Maharaja Masala Dosa", "Prem Masala Dosa", "Harabhara Masala Dosa", "Navratna Masala Dosa", "Garlic Roast Dosa", "Pudy Roast Dos", "Prem Sada 4 Types Of Chatni", "Maharaja Sada Dosa", "Harabhara Sada", "Schezwan Sada", "Onion Sada Dosa", "Spring Roll Dosa", "Paneer Spring Roll", "Chinese Delight Dosa", "Paneer Chinese Delight Dosa", "American Chopsuey Dosa", "Paneer American Chopsuey Dosa", "Mushroom Chopsuey Dosa", "Paneer Chilly Dosa", "Schezwan Dosa", "Mushroom Schezwan Dosa", "Paneer Schezwan Dosa", "Capsium Schezwan Dosa", "Tom-Chi Dosa", "Chaap Dosa", "American Delight Dosa", "American Paneer Delight Dosa", "Salad Roast Dosa", "Paneer Salad Roast Dosa", "Mexican Roast Dosa", "Red Chilly Dosa", "Paneer Crispy Dosa", "Aloo Crispy Dosa", "Mexi Roll Dosa", "Salsa Lite", "Salsa Noodles Dosa", "Sizz-Lee Noodles Dosa", "Corn Mac 'N' Cheese Dosa", "Pasta Dosa", "Onion Delight", "Hot Garlic Mexican", "Chilly Delight", "Paper Roast Dosa", "Special Pream Paper Roast Dosa", "Mysore Uttappa", "Tom-Chi Uttappa", "Plain Uttappa", "Onion Uttappa", "Paneer Onion Uttappa", "Tomato Uttappa", "Masala Uttappa", "Sandwich Uttappa", "Spl. Pream Uttappa", "Paneer Special Prem Uttappa", "Spl. Spicy Uttappa", "Spl. Paneer Spicy Uttappa", "Idli Manchurian", "Idli Schezwan", "Idli Chilly", "Idli Cheese Manchurian", "Idli Paneer Manchurian", "Idli Fry", "Bisebelle Bhatt", "Thakkali Sadan", "Chitranna", "Dahi Rice", "Chickpea Rice", "Shahi Korma Rice", "Mini Lunch", "Chetinad Biryani"};

            for (int j = 0; j < tableModel1.getRowCount(); j++) {
                String productName = (String) tableModel1.getValueAt(j, 1);
                for (String name : MumbaiChaatproductArray) {
                    if (productName.equals(name)) {
                        String quantity = (String) tableModel1.getValueAt(j, 3);
                        String total = (String) tableModel1.getValueAt(j, 4);
                        tableModel3.addRow(new Object[]{productName, quantity, total});
                        break;
                    }
                }
            }
//            ================================================================================================
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

//            String[] SouthproductNames = {"Upma", "Chennai Idli 2 Pcs", "Spl. Mini Idli 12pcs", "14 Ghee Idli", "Mini Medu Wada 2pcs", "Mini Medu Wada 4pcs", "Dal Wada 2pcs", "Dal Wada 4pcs", "Dahi Wada 4pcs", "Sada Dosa", "Mysore Sada Dosa", "Masala Dosa", "Rocket Mysore Dosa", "Mysore Masala Dosa", "Onion Masala Dosa", "Paneer Masala Dosa", "Paneer Onion Masala Dosa", "Maharaja Masala Dosa", "Prem Masala Dosa", "Harabhara Masala Dosa", "Navratna Masala Dosa", "Garlic Roast Dosa", "Pudy Roast Dos", "Prem Sada 4 Types Of Chatni", "Maharaja Sada Dosa", "Harabhara Sada", "Schezwan Sada", "Onion Sada Dosa", "Spring Roll Dosa", "Paneer Spring Roll", "Chinese Delight Dosa", "Paneer Chinese Delight Dosa", "American Chopsuey Dosa", "Paneer American Chopsuey Dosa", "Mushroom Chopsuey Dosa", "Paneer Chilly Dosa", "Schezwan Dosa", "Mushroom Schezwan Dosa", "Paneer Schezwan Dosa", "Capsium Schezwan Dosa", "Tom-Chi Dosa", "Chaap Dosa", "American Delight Dosa", "American Paneer Delight Dosa", "Salad Roast Dosa", "Paneer Salad Roast Dosa", "Mexican Roast Dosa", "Red Chilly Dosa", "Paneer Crispy Dosa", "Aloo Crispy Dosa", "Mexi Roll Dosa", "Salsa Lite", "Salsa Noodles Dosa", "Sizz-Lee Noodles Dosa", "Corn Mac 'N' Cheese Dosa", "Pasta Dosa", "Onion Delight", "Hot Garlic Mexican", "Chilly Delight", "Paper Roast Dosa", "Special Pream Paper Roast Dosa", "Mysore Uttappa", "Tom-Chi Uttappa", "Plain Uttappa", "Onion Uttappa", "Paneer Onion Uttappa", "Tomato Uttappa", "Masala Uttappa", "Sandwich Uttappa", "Spl. Pream Uttappa", "Paneer Special Prem Uttappa", "Spl. Spicy Uttappa", "Spl. Paneer Spicy Uttappa", "Idli Manchurian", "Idli Schezwan", "Idli Chilly", "Idli Cheese Manchurian", "Idli Paneer Manchurian", "Idli Fry", "Bisebelle Bhatt", "Thakkali Sadan", "Chitranna", "Dahi Rice", "Chickpea Rice", "Shahi Korma Rice", "Mini Lunch", "Chetinad Biryani"};

            for (int j = 0; j < tableModel1.getRowCount(); j++) {
                String productName = (String) tableModel1.getValueAt(j, 1);
                for (String name : IndianVegproductArray) {
                    if (productName.equals(name)) {
                        String quantity = (String) tableModel1.getValueAt(j, 3);
                        String total = (String) tableModel1.getValueAt(j, 4);
                        tableModel4.addRow(new Object[]{productName, quantity, total});
                        break;
                    }
                }
            }
//           =================================================================================================
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

//            String[] SouthproductNames = {"Upma", "Chennai Idli 2 Pcs", "Spl. Mini Idli 12pcs", "14 Ghee Idli", "Mini Medu Wada 2pcs", "Mini Medu Wada 4pcs", "Dal Wada 2pcs", "Dal Wada 4pcs", "Dahi Wada 4pcs", "Sada Dosa", "Mysore Sada Dosa", "Masala Dosa", "Rocket Mysore Dosa", "Mysore Masala Dosa", "Onion Masala Dosa", "Paneer Masala Dosa", "Paneer Onion Masala Dosa", "Maharaja Masala Dosa", "Prem Masala Dosa", "Harabhara Masala Dosa", "Navratna Masala Dosa", "Garlic Roast Dosa", "Pudy Roast Dos", "Prem Sada 4 Types Of Chatni", "Maharaja Sada Dosa", "Harabhara Sada", "Schezwan Sada", "Onion Sada Dosa", "Spring Roll Dosa", "Paneer Spring Roll", "Chinese Delight Dosa", "Paneer Chinese Delight Dosa", "American Chopsuey Dosa", "Paneer American Chopsuey Dosa", "Mushroom Chopsuey Dosa", "Paneer Chilly Dosa", "Schezwan Dosa", "Mushroom Schezwan Dosa", "Paneer Schezwan Dosa", "Capsium Schezwan Dosa", "Tom-Chi Dosa", "Chaap Dosa", "American Delight Dosa", "American Paneer Delight Dosa", "Salad Roast Dosa", "Paneer Salad Roast Dosa", "Mexican Roast Dosa", "Red Chilly Dosa", "Paneer Crispy Dosa", "Aloo Crispy Dosa", "Mexi Roll Dosa", "Salsa Lite", "Salsa Noodles Dosa", "Sizz-Lee Noodles Dosa", "Corn Mac 'N' Cheese Dosa", "Pasta Dosa", "Onion Delight", "Hot Garlic Mexican", "Chilly Delight", "Paper Roast Dosa", "Special Pream Paper Roast Dosa", "Mysore Uttappa", "Tom-Chi Uttappa", "Plain Uttappa", "Onion Uttappa", "Paneer Onion Uttappa", "Tomato Uttappa", "Masala Uttappa", "Sandwich Uttappa", "Spl. Pream Uttappa", "Paneer Special Prem Uttappa", "Spl. Spicy Uttappa", "Spl. Paneer Spicy Uttappa", "Idli Manchurian", "Idli Schezwan", "Idli Chilly", "Idli Cheese Manchurian", "Idli Paneer Manchurian", "Idli Fry", "Bisebelle Bhatt", "Thakkali Sadan", "Chitranna", "Dahi Rice", "Chickpea Rice", "Shahi Korma Rice", "Mini Lunch", "Chetinad Biryani"};

            for (int j = 0; j < tableModel1.getRowCount(); j++) {
                String productName = (String) tableModel1.getValueAt(j, 1);
                for (String name : BeveragesproductArray) {
                    if (productName.equals(name)) {
                        String quantity = (String) tableModel1.getValueAt(j, 3);
                        String total = (String) tableModel1.getValueAt(j, 4);
                        tableModel5.addRow(new Object[]{productName, quantity, total});
                        break;
                    }
                }
            }
//          =================================================================================================
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
           for (int j = 0; j < tableModel1.getRowCount(); j++) {
               String productName = (String) tableModel1.getValueAt(j, 1);
               for (String name : ChineseVegproductArray) {
                   if (productName.equals(name)) {
                       String quantity = (String) tableModel1.getValueAt(j, 3);
                       String total = (String) tableModel1.getValueAt(j, 4);
                       tableModel6.addRow(new Object[]{productName, quantity, total});
                       break;
                   }
               }
           }
//         =================================================================================================
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
          for (int j = 0; j < tableModel1.getRowCount(); j++) {
              String productName = (String) tableModel1.getValueAt(j, 1);
              for (String name : CombosproductArray) {
                  if (productName.equals(name)) {
                      String quantity = (String) tableModel1.getValueAt(j, 3);
                      String total = (String) tableModel1.getValueAt(j, 4);
                      tableModel7.addRow(new Object[]{productName, quantity, total});
                      break;
                  }
              }
          }
//        =================================================================================================
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
         for (int j = 0; j < tableModel1.getRowCount(); j++) {
             String productName = (String) tableModel1.getValueAt(j, 1);
             for (String name : ExtrasproductArray) {
                 if (productName.equals(name)) {
                     String quantity = (String) tableModel1.getValueAt(j, 3);
                     String total = (String) tableModel1.getValueAt(j, 4);
                     tableModel8.addRow(new Object[]{productName, quantity, total});
                     break;
                 }
             }
         }
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        dispose();
        ReportFile counter = new ReportFile(startDate1,endDate1,tableModel2,tableModel3,tableModel4,tableModel5,tableModel6,tableModel7,tableModel8);
//		 counter.setLocationRelativeTo(null);
//		 counter.setVisible(true);
    }
	public void GetReport1(LocalDate startDate1,LocalDate endDate1) {
		String filePath = "C:\\POS\\Invoice_Data\\Complete\\"+formattedDatenew+".sql";



        DefaultTableModel tableModel1 = new DefaultTableModel();
        tableModel1.addColumn("Date");
        tableModel1.addColumn("Name");
        tableModel1.addColumn("Unit Price");
        tableModel1.addColumn("Quantity");
        tableModel1.addColumn("Total");
        JTable table1 = new JTable(tableModel1);
        JScrollPane scrollPane1 = new JScrollPane(table1);

        DefaultTableModel tableModel2 = new DefaultTableModel();
        tableModel2.addColumn("Name");
        tableModel2.addColumn("Quantity");
        tableModel2.addColumn("Total");
        JTable table2 = new JTable(tableModel2);
        JScrollPane scrollPane2 = new JScrollPane(table2);

        DefaultTableModel tableModel3 = new DefaultTableModel();
        tableModel3.addColumn("Name");
        tableModel3.addColumn("Quantity");
        tableModel3.addColumn("Total");
        JTable table3 = new JTable(tableModel3);
        JScrollPane scrollPane3 = new JScrollPane(table3);
        
        DefaultTableModel tableModel4 = new DefaultTableModel();
        tableModel4.addColumn("Name");
        tableModel4.addColumn("Quantity");
        tableModel4.addColumn("Total");
        JTable table4 = new JTable(tableModel4);
        JScrollPane scrollPane4 = new JScrollPane(table4);
        
        DefaultTableModel tableModel5 = new DefaultTableModel();
        tableModel5.addColumn("Name");
        tableModel5.addColumn("Quantity");
        tableModel5.addColumn("Total");
        JTable table5 = new JTable(tableModel5);
        JScrollPane scrollPane5 = new JScrollPane(table5);

        DefaultTableModel tableModel6 = new DefaultTableModel();
        tableModel6.addColumn("Name");
        tableModel6.addColumn("Quantity");
        tableModel6.addColumn("Total");
        JTable table6 = new JTable(tableModel6);
        JScrollPane scrollPane6 = new JScrollPane(table6);
        
        DefaultTableModel tableModel7 = new DefaultTableModel();
        tableModel7.addColumn("Name");
        tableModel7.addColumn("Quantity");
        tableModel7.addColumn("Total");
        JTable table7 = new JTable(tableModel7);
        JScrollPane scrollPane7 = new JScrollPane(table7);
        
        DefaultTableModel tableModel8 = new DefaultTableModel();
        tableModel8.addColumn("Name");
        tableModel8.addColumn("Quantity");
        tableModel8.addColumn("Total");
        JTable table8 = new JTable(tableModel8);
        JScrollPane scrollPane8 = new JScrollPane(table8);
        
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
                for (int j = 0; j < tableModel1.getRowCount(); j++) {
                    if (tableModel1.getValueAt(j, 1).equals(productName)) {
                        // Update the quantity and total
                        int existingQuantity = Integer.parseInt((String) tableModel1.getValueAt(j, 3));
                        int newQuantity = existingQuantity + quantityInt;
                        tableModel1.setValueAt(String.valueOf(newQuantity), j, 3);

                        double newTotal = unitPriceDouble * newQuantity;
                        String newTotalString = String.format("%.2f", newTotal);
                        tableModel1.setValueAt(newTotalString, j, 4);

                        productExists = true;
                        break;
                    }
                }

                if (!productExists) {
                    // Add a new row to the first table
                    String[] data1 = new String[]{dateStr, productName, unitPrice, String.valueOf(quantityInt), totalString};
                    tableModel1.addRow(data1);
                }
            }
            
//            ===================================== SOUTH INDIAN DATA ========================
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

//            String[] SouthproductNames = {"Upma", "Chennai Idli 2 Pcs", "Spl. Mini Idli 12pcs", "14 Ghee Idli", "Mini Medu Wada 2pcs", "Mini Medu Wada 4pcs", "Dal Wada 2pcs", "Dal Wada 4pcs", "Dahi Wada 4pcs", "Sada Dosa", "Mysore Sada Dosa", "Masala Dosa", "Rocket Mysore Dosa", "Mysore Masala Dosa", "Onion Masala Dosa", "Paneer Masala Dosa", "Paneer Onion Masala Dosa", "Maharaja Masala Dosa", "Prem Masala Dosa", "Harabhara Masala Dosa", "Navratna Masala Dosa", "Garlic Roast Dosa", "Pudy Roast Dos", "Prem Sada 4 Types Of Chatni", "Maharaja Sada Dosa", "Harabhara Sada", "Schezwan Sada", "Onion Sada Dosa", "Spring Roll Dosa", "Paneer Spring Roll", "Chinese Delight Dosa", "Paneer Chinese Delight Dosa", "American Chopsuey Dosa", "Paneer American Chopsuey Dosa", "Mushroom Chopsuey Dosa", "Paneer Chilly Dosa", "Schezwan Dosa", "Mushroom Schezwan Dosa", "Paneer Schezwan Dosa", "Capsium Schezwan Dosa", "Tom-Chi Dosa", "Chaap Dosa", "American Delight Dosa", "American Paneer Delight Dosa", "Salad Roast Dosa", "Paneer Salad Roast Dosa", "Mexican Roast Dosa", "Red Chilly Dosa", "Paneer Crispy Dosa", "Aloo Crispy Dosa", "Mexi Roll Dosa", "Salsa Lite", "Salsa Noodles Dosa", "Sizz-Lee Noodles Dosa", "Corn Mac 'N' Cheese Dosa", "Pasta Dosa", "Onion Delight", "Hot Garlic Mexican", "Chilly Delight", "Paper Roast Dosa", "Special Pream Paper Roast Dosa", "Mysore Uttappa", "Tom-Chi Uttappa", "Plain Uttappa", "Onion Uttappa", "Paneer Onion Uttappa", "Tomato Uttappa", "Masala Uttappa", "Sandwich Uttappa", "Spl. Pream Uttappa", "Paneer Special Prem Uttappa", "Spl. Spicy Uttappa", "Spl. Paneer Spicy Uttappa", "Idli Manchurian", "Idli Schezwan", "Idli Chilly", "Idli Cheese Manchurian", "Idli Paneer Manchurian", "Idli Fry", "Bisebelle Bhatt", "Thakkali Sadan", "Chitranna", "Dahi Rice", "Chickpea Rice", "Shahi Korma Rice", "Mini Lunch", "Chetinad Biryani"};

            for (int j = 0; j < tableModel1.getRowCount(); j++) {
                String productName = (String) tableModel1.getValueAt(j, 1);
                for (String name : SouthIndianproductArray) {
                    if (productName.equals(name)) {
                        String quantity = (String) tableModel1.getValueAt(j, 3);
                        String total = (String) tableModel1.getValueAt(j, 4);
                        tableModel2.addRow(new Object[]{productName, quantity, total});
                        break;
                    }
//                    if (productName.contains("Corn")) {
//                        String quantity = (String) tableModel1.getValueAt(j, 1);
//                        Object total = tableModel1.getValueAt(j, 2);
//                        tableModel2.addRow(new Object[]{productName,quantity,total});
//                        break;
//                    }
                    if (productName.equals("4 Pcs")) {
                        String quantity = (String) tableModel1.getValueAt(j, 1);
                        Object total = tableModel1.getValueAt(j, 2);
                        tableModel2.addRow(new Object[]{productName,quantity,total});
                        break;
                    }
//                    if (productName.contains("Medu Wada 4pcs")) {
//                        String quantity = (String) tableModel1.getValueAt(j, 1);
//                        Object total = tableModel1.getValueAt(j, 2);
//                        tableModel2.addRow(new Object[]{productName,quantity,total});
//                        break;
//                    }
                }
            }
//            =====================================================================================
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

//            String[] SouthproductNames = {"Upma", "Chennai Idli 2 Pcs", "Spl. Mini Idli 12pcs", "14 Ghee Idli", "Mini Medu Wada 2pcs", "Mini Medu Wada 4pcs", "Dal Wada 2pcs", "Dal Wada 4pcs", "Dahi Wada 4pcs", "Sada Dosa", "Mysore Sada Dosa", "Masala Dosa", "Rocket Mysore Dosa", "Mysore Masala Dosa", "Onion Masala Dosa", "Paneer Masala Dosa", "Paneer Onion Masala Dosa", "Maharaja Masala Dosa", "Prem Masala Dosa", "Harabhara Masala Dosa", "Navratna Masala Dosa", "Garlic Roast Dosa", "Pudy Roast Dos", "Prem Sada 4 Types Of Chatni", "Maharaja Sada Dosa", "Harabhara Sada", "Schezwan Sada", "Onion Sada Dosa", "Spring Roll Dosa", "Paneer Spring Roll", "Chinese Delight Dosa", "Paneer Chinese Delight Dosa", "American Chopsuey Dosa", "Paneer American Chopsuey Dosa", "Mushroom Chopsuey Dosa", "Paneer Chilly Dosa", "Schezwan Dosa", "Mushroom Schezwan Dosa", "Paneer Schezwan Dosa", "Capsium Schezwan Dosa", "Tom-Chi Dosa", "Chaap Dosa", "American Delight Dosa", "American Paneer Delight Dosa", "Salad Roast Dosa", "Paneer Salad Roast Dosa", "Mexican Roast Dosa", "Red Chilly Dosa", "Paneer Crispy Dosa", "Aloo Crispy Dosa", "Mexi Roll Dosa", "Salsa Lite", "Salsa Noodles Dosa", "Sizz-Lee Noodles Dosa", "Corn Mac 'N' Cheese Dosa", "Pasta Dosa", "Onion Delight", "Hot Garlic Mexican", "Chilly Delight", "Paper Roast Dosa", "Special Pream Paper Roast Dosa", "Mysore Uttappa", "Tom-Chi Uttappa", "Plain Uttappa", "Onion Uttappa", "Paneer Onion Uttappa", "Tomato Uttappa", "Masala Uttappa", "Sandwich Uttappa", "Spl. Pream Uttappa", "Paneer Special Prem Uttappa", "Spl. Spicy Uttappa", "Spl. Paneer Spicy Uttappa", "Idli Manchurian", "Idli Schezwan", "Idli Chilly", "Idli Cheese Manchurian", "Idli Paneer Manchurian", "Idli Fry", "Bisebelle Bhatt", "Thakkali Sadan", "Chitranna", "Dahi Rice", "Chickpea Rice", "Shahi Korma Rice", "Mini Lunch", "Chetinad Biryani"};

            for (int j = 0; j < tableModel1.getRowCount(); j++) {
                String productName = (String) tableModel1.getValueAt(j, 1);
                for (String name : MumbaiChaatproductArray) {
                    if (productName.equals(name)) {
                        String quantity = (String) tableModel1.getValueAt(j, 3);
                        String total = (String) tableModel1.getValueAt(j, 4);
                        tableModel3.addRow(new Object[]{productName, quantity, total});
                        break;
                    }
                }
            }
//            ================================================================================================
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

//            String[] SouthproductNames = {"Upma", "Chennai Idli 2 Pcs", "Spl. Mini Idli 12pcs", "14 Ghee Idli", "Mini Medu Wada 2pcs", "Mini Medu Wada 4pcs", "Dal Wada 2pcs", "Dal Wada 4pcs", "Dahi Wada 4pcs", "Sada Dosa", "Mysore Sada Dosa", "Masala Dosa", "Rocket Mysore Dosa", "Mysore Masala Dosa", "Onion Masala Dosa", "Paneer Masala Dosa", "Paneer Onion Masala Dosa", "Maharaja Masala Dosa", "Prem Masala Dosa", "Harabhara Masala Dosa", "Navratna Masala Dosa", "Garlic Roast Dosa", "Pudy Roast Dos", "Prem Sada 4 Types Of Chatni", "Maharaja Sada Dosa", "Harabhara Sada", "Schezwan Sada", "Onion Sada Dosa", "Spring Roll Dosa", "Paneer Spring Roll", "Chinese Delight Dosa", "Paneer Chinese Delight Dosa", "American Chopsuey Dosa", "Paneer American Chopsuey Dosa", "Mushroom Chopsuey Dosa", "Paneer Chilly Dosa", "Schezwan Dosa", "Mushroom Schezwan Dosa", "Paneer Schezwan Dosa", "Capsium Schezwan Dosa", "Tom-Chi Dosa", "Chaap Dosa", "American Delight Dosa", "American Paneer Delight Dosa", "Salad Roast Dosa", "Paneer Salad Roast Dosa", "Mexican Roast Dosa", "Red Chilly Dosa", "Paneer Crispy Dosa", "Aloo Crispy Dosa", "Mexi Roll Dosa", "Salsa Lite", "Salsa Noodles Dosa", "Sizz-Lee Noodles Dosa", "Corn Mac 'N' Cheese Dosa", "Pasta Dosa", "Onion Delight", "Hot Garlic Mexican", "Chilly Delight", "Paper Roast Dosa", "Special Pream Paper Roast Dosa", "Mysore Uttappa", "Tom-Chi Uttappa", "Plain Uttappa", "Onion Uttappa", "Paneer Onion Uttappa", "Tomato Uttappa", "Masala Uttappa", "Sandwich Uttappa", "Spl. Pream Uttappa", "Paneer Special Prem Uttappa", "Spl. Spicy Uttappa", "Spl. Paneer Spicy Uttappa", "Idli Manchurian", "Idli Schezwan", "Idli Chilly", "Idli Cheese Manchurian", "Idli Paneer Manchurian", "Idli Fry", "Bisebelle Bhatt", "Thakkali Sadan", "Chitranna", "Dahi Rice", "Chickpea Rice", "Shahi Korma Rice", "Mini Lunch", "Chetinad Biryani"};

            for (int j = 0; j < tableModel1.getRowCount(); j++) {
                String productName = (String) tableModel1.getValueAt(j, 1);
                for (String name : IndianVegproductArray) {
                    if (productName.equals(name)) {
                        String quantity = (String) tableModel1.getValueAt(j, 3);
                        String total = (String) tableModel1.getValueAt(j, 4);
                        tableModel4.addRow(new Object[]{productName, quantity, total});
                        break;
                    }
                }
            }
//           =================================================================================================
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

//            String[] SouthproductNames = {"Upma", "Chennai Idli 2 Pcs", "Spl. Mini Idli 12pcs", "14 Ghee Idli", "Mini Medu Wada 2pcs", "Mini Medu Wada 4pcs", "Dal Wada 2pcs", "Dal Wada 4pcs", "Dahi Wada 4pcs", "Sada Dosa", "Mysore Sada Dosa", "Masala Dosa", "Rocket Mysore Dosa", "Mysore Masala Dosa", "Onion Masala Dosa", "Paneer Masala Dosa", "Paneer Onion Masala Dosa", "Maharaja Masala Dosa", "Prem Masala Dosa", "Harabhara Masala Dosa", "Navratna Masala Dosa", "Garlic Roast Dosa", "Pudy Roast Dos", "Prem Sada 4 Types Of Chatni", "Maharaja Sada Dosa", "Harabhara Sada", "Schezwan Sada", "Onion Sada Dosa", "Spring Roll Dosa", "Paneer Spring Roll", "Chinese Delight Dosa", "Paneer Chinese Delight Dosa", "American Chopsuey Dosa", "Paneer American Chopsuey Dosa", "Mushroom Chopsuey Dosa", "Paneer Chilly Dosa", "Schezwan Dosa", "Mushroom Schezwan Dosa", "Paneer Schezwan Dosa", "Capsium Schezwan Dosa", "Tom-Chi Dosa", "Chaap Dosa", "American Delight Dosa", "American Paneer Delight Dosa", "Salad Roast Dosa", "Paneer Salad Roast Dosa", "Mexican Roast Dosa", "Red Chilly Dosa", "Paneer Crispy Dosa", "Aloo Crispy Dosa", "Mexi Roll Dosa", "Salsa Lite", "Salsa Noodles Dosa", "Sizz-Lee Noodles Dosa", "Corn Mac 'N' Cheese Dosa", "Pasta Dosa", "Onion Delight", "Hot Garlic Mexican", "Chilly Delight", "Paper Roast Dosa", "Special Pream Paper Roast Dosa", "Mysore Uttappa", "Tom-Chi Uttappa", "Plain Uttappa", "Onion Uttappa", "Paneer Onion Uttappa", "Tomato Uttappa", "Masala Uttappa", "Sandwich Uttappa", "Spl. Pream Uttappa", "Paneer Special Prem Uttappa", "Spl. Spicy Uttappa", "Spl. Paneer Spicy Uttappa", "Idli Manchurian", "Idli Schezwan", "Idli Chilly", "Idli Cheese Manchurian", "Idli Paneer Manchurian", "Idli Fry", "Bisebelle Bhatt", "Thakkali Sadan", "Chitranna", "Dahi Rice", "Chickpea Rice", "Shahi Korma Rice", "Mini Lunch", "Chetinad Biryani"};

            for (int j = 0; j < tableModel1.getRowCount(); j++) {
                String productName = (String) tableModel1.getValueAt(j, 1);
                for (String name : BeveragesproductArray) {
                    if (productName.equals(name)) {
                        String quantity = (String) tableModel1.getValueAt(j, 3);
                        String total = (String) tableModel1.getValueAt(j, 4);
                        tableModel5.addRow(new Object[]{productName, quantity, total});
                        break;
                    }
                }
            }
//          =================================================================================================
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
           for (int j = 0; j < tableModel1.getRowCount(); j++) {
               String productName = (String) tableModel1.getValueAt(j, 1);
               for (String name : ChineseVegproductArray) {
                   if (productName.equals(name)) {
                       String quantity = (String) tableModel1.getValueAt(j, 3);
                       String total = (String) tableModel1.getValueAt(j, 4);
                       tableModel6.addRow(new Object[]{productName, quantity, total});
                       break;
                   }
               }
           }
//         =================================================================================================
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
          for (int j = 0; j < tableModel1.getRowCount(); j++) {
              String productName = (String) tableModel1.getValueAt(j, 1);
              for (String name : CombosproductArray) {
                  if (productName.equals(name)) {
                      String quantity = (String) tableModel1.getValueAt(j, 3);
                      String total = (String) tableModel1.getValueAt(j, 4);
                      tableModel7.addRow(new Object[]{productName, quantity, total});
                      break;
                  }
              }
          }
//        =================================================================================================
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
         for (int j = 0; j < tableModel1.getRowCount(); j++) {
             String productName = (String) tableModel1.getValueAt(j, 1);
             for (String name : ExtrasproductArray) {
                 if (productName.equals(name)) {
                     String quantity = (String) tableModel1.getValueAt(j, 3);
                     String total = (String) tableModel1.getValueAt(j, 4);
                     tableModel8.addRow(new Object[]{productName, quantity, total});
                     break;
                 }
             }
         }
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        dispose();
        REPORTVIEWER_UI counter = new REPORTVIEWER_UI(startDate1,endDate1,tableModel2,tableModel3,tableModel4,tableModel5,tableModel6,tableModel7,tableModel8);
//		 counter.setLocationRelativeTo(null);
//		 counter.setVisible(true);
    }
	
	
	
	public class DateLabelFormatter extends AbstractFormatter {
	    private String datePattern = "dd/MM/yyyy";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	    @Override
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }

	    @Override
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }
	        return "";
	    }
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PickerUI frame = new PickerUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
