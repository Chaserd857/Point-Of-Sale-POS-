package Main;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.JFormattedTextField.AbstractFormatter;
import java.awt.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
@SuppressWarnings("all")
public class AdminPanelInvoiceFormat extends JFrame {

    private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel1 = new DefaultTableModel(new Object[]{"Item Name", "Item Code", "Price"}, 0);
    private JPanel contentPane;
    private JDatePickerImpl DatePicker;
    private String formattedDate;
    private String formattedDate1;
    private String formattedDatenew;
    private JComboBox comboBox;
    private JTable table;
	private DefaultTableModel tableModel;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTextField textField;
	private JTable table_1;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
    /**
     * Launch the application.
     */
    
    /**
     * Create the frame.
     */
    public AdminPanelInvoiceFormat() {
        createGUI();
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1250, 610);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(AdminPanelInvoiceFormat.class.getResource("/image/logo.png")));
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set to full size
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

        setContentPane(contentPane);

        comboBox = new JComboBox();
        
        String[] columnNames = {"ITEM NAME", "QTY.", "RATE", "AMOUNT"};
        // Create a table model with these column names and override isCellEditable
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // All cells are non-editable
            }
        };
        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(180);
        table.getColumnModel().getColumn(1).setPreferredWidth(60);
        table.getColumnModel().getColumn(2).setPreferredWidth(60);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        
        // Initialize the start date picker
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        // Date Picker
        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl StartDatePanel = new JDatePanelImpl(model, p);
        DatePicker = new JDatePickerImpl(StartDatePanel, new DateLabelFormatter());
        DatePicker.setShowYearButtons(true);
        DatePicker.getJFormattedTextField().setBorder(new LineBorder(new Color(171, 173, 179)));
        DatePicker.getJFormattedTextField().setBackground(Color.WHITE);
        DatePicker.getJFormattedTextField().setHorizontalAlignment(SwingConstants.CENTER);

        // Adjust button size
        JButton button = (JButton) DatePicker.getComponent(1);
        button.setPreferredSize(new Dimension(1, 20));
        button.setText("");
        button.setIcon(createResizedIcon("/images/calendar-icon-simple-style-sale-offer-poster-background-symbol-calendar-brand-logo-design-element-calendar-t-shirt-printing-for-sticker-free-vector.jpg", 15, 15));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 0));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 102, 255));

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        
        panel_4 = new JPanel();
        panel_4.setBackground(Color.WHITE);
        panel_4.setVisible(false);
        
        panel_3 = new JPanel();
        panel_3.setBackground(Color.WHITE);
//        panel_3.setVisible(false);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 967, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                        .addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)))
        );

        JLabel lblNewLabel_3 = new JLabel("Select Date -");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JButton btnNewButton_2 = new JButton("Go");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Get the selected dates from the date pickers
        		comboBox.removeAllItems();
        		tableModel.setRowCount(0);
		        java.util.Date startDateObj = (java.util.Date) DatePicker.getModel().getValue();

		        Instant startDateInstant = startDateObj.toInstant();

		        LocalDate startDate = LocalDate.ofInstant(startDateInstant, ZoneId.systemDefault());
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
		        formattedDate = startDate.format(formatter);
		        // Print the selected dates
//		        System.out.println("Start Date: " + formattedDate);
//		        System.out.println("End Date: " + endDate);
		        
		        // Regex pattern to extract the invoice number
		        Pattern pattern = Pattern.compile("INSERT INTO Invoices \\(invoice_number\\) VALUES \\('([^']+)");

		        // Read data from .sql file and add to JComboBox
		        String filePath = "C:\\POS\\Invoice_Data\\Day_Wise\\"+formattedDate +".sql";
		        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
		            String line;
		            while ((line = reader.readLine()) != null) {
		                Matcher matcher = pattern.matcher(line);
		                if (matcher.find()) {
		                    String invoiceNumber = matcher.group(1);
		                    comboBox.addItem(invoiceNumber);
		                }
		            }
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
        	}
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
        
        JButton btnNewButton_2_1 = new JButton("Go");
        btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        btnNewButton_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	tableModel.setRowCount(0);
                // Get the selected item from the combo box
            	
            	 java.util.Date startDateObj = (java.util.Date) DatePicker.getModel().getValue();

 		        Instant startDateInstant = startDateObj.toInstant();

 		        LocalDate startDate = LocalDate.ofInstant(startDateInstant, ZoneId.systemDefault());
 		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 		       formattedDate1 = startDate.format(formatter);
            	
                String selectedItem = (String) comboBox.getSelectedItem();
                if (selectedItem != null) {
                	System.out.println("Selected Date: " + formattedDate1);
                    System.out.println("Selected Item: " + selectedItem);
                 // Get current date
                    LocalDate currentDatenew = LocalDate.now();
                    DateTimeFormatter formatternew = DateTimeFormatter.ofPattern("ddMMyyyy");
                    String formattedDatenew = currentDatenew.format(formatternew);
                    readSqlFileAndDisplayInTable("C:\\POS\\Invoice_Data\\Complete\\"+formattedDatenew+".sql",formattedDate1,selectedItem);
//                    panel_3.setVisible(true);
                    // You can add your print logic here
                    // For example: Print to a printer, generate a report, etc.
                } else {
//                    System.out.println("No item selected.");
                }
                printTotalAmount();
            }
        });
        
        JScrollPane scrollPane = new JScrollPane();
        
        JButton btnNewButton_3 = new JButton("SHOW MENU LIST");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel_4.setVisible(true);
        	}
        });
        
        JButton btnNewButton_4 = new JButton("DELETE ITEM");
        btnNewButton_4.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) { // Check if a row is actually selected
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(selectedRow);
                    printTotalAmount();
                }
        	}
        });
        
        JButton btnNewButton_5 = new JButton("EDIT ITEM");
        btnNewButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() != -1) {
                    int selectedRow = table.getSelectedRow();
                    handleTableRowEdit(selectedRow);
                    printTotalAmount();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to edit.");
                }
            }
        });
        
        
        
        
        
        
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
        	gl_panel_2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_2.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addGap(9)
        					.addComponent(lblNewLabel_3)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(DatePicker, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnNewButton_2))
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addGap(48)
        					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
        				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addGap(20)
        					.addComponent(btnNewButton_3)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnNewButton_4)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnNewButton_5))
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addGap(206)
        					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        			.addGap(60)
        			.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panel_2.setVerticalGroup(
        	gl_panel_2.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        						.addComponent(btnNewButton_2)
        						.addComponent(DatePicker, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_3))
        					.addGap(18)
        					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
        						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
        					.addGap(46)
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnNewButton_3)
        						.addComponent(btnNewButton_4)
        						.addComponent(btnNewButton_5))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        					.addGap(23))))
        );
        
        textField = new JTextField(20);
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchTableContents(textField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchTableContents(textField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchTableContents(textField.getText());
            }
        });

        JScrollPane scrollPane_1 = new JScrollPane();
        
        JLabel lblNewLabel_3_1 = new JLabel("");
        lblNewLabel_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        lblNewLabel_3_1.setBackground(SystemColor.activeCaption);
        GroupLayout gl_panel_4 = new GroupLayout(panel_4);
        gl_panel_4.setHorizontalGroup(
        	gl_panel_4.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_4.createSequentialGroup()
        			.addGap(39)
        			.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_4.createSequentialGroup()
        					.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        					.addGap(3)
        					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE))
        				.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(48, Short.MAX_VALUE))
        );
        gl_panel_4.setVerticalGroup(
        	gl_panel_4.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_4.createSequentialGroup()
        			.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        			.addGap(11)
        			.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(22, Short.MAX_VALUE))
        );
        
        table_1 = new JTable(tableModel1);
        table_1.getColumnModel().getColumn(0).setPreferredWidth(180);
        table_1.getColumnModel().getColumn(1).setPreferredWidth(60);
        table_1.getColumnModel().getColumn(2).setPreferredWidth(60);
        loadDataFromSqlFile("C:\\POS\\Menu_Data\\menu_data.sql");
        scrollPane_1.setViewportView(table_1);
        panel_4.setLayout(gl_panel_4);
        
        lblNewLabel_10 = new JLabel("");
        lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_10.setOpaque(true);
        lblNewLabel_10.setBackground(SystemColor.menu);
        lblNewLabel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
        
        lblNewLabel_9 = new JLabel("");
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_9.setOpaque(true);
        lblNewLabel_9.setBackground(SystemColor.menu);
        lblNewLabel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
        
        lblNewLabel_11 = new JLabel("");
        lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_11.setOpaque(true);
        lblNewLabel_11.setBackground(SystemColor.menu);
        lblNewLabel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
        
        lblNewLabel_5 = new JLabel("SGST");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        lblNewLabel_4 = new JLabel("AMOUNT");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        lblNewLabel_6 = new JLabel("CGST");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        lblNewLabel_7 = new JLabel("TOTAL");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_8.setOpaque(true);
        lblNewLabel_8.setBackground(SystemColor.menu);
        lblNewLabel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
        
        JButton btnNewButton_6 = new JButton("SAVE");
        btnNewButton_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the selected item from the combo box
                    String selectedItem = (String) comboBox.getSelectedItem();
                    
                    if (selectedItem == null) {
//                        System.out.println("No item selected.");
                        return;
                    }

                    // Get and format the selected date from the DatePicker
                    java.util.Date startDateObj = (java.util.Date) DatePicker.getModel().getValue();
                    
                    if (startDateObj == null) {
//                        System.out.println("No date selected.");
                        return;
                    }

                    Instant startDateInstant = startDateObj.toInstant();
                    LocalDate startDate = LocalDate.ofInstant(startDateInstant, ZoneId.systemDefault());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String formattedDate1 = startDate.format(formatter);

                    System.out.println("Selected Date: " + formattedDate1);
                    System.out.println("Selected Item: " + selectedItem);

                    // Construct the file path
                    String filePath = "C:\\POS\\Invoice_Data\\Complete\\"+formattedDatenew+".sql";
                    StringBuilder fileContent = new StringBuilder();

                    // Define the regex pattern to match the SQL insert statements
                    Pattern pattern = Pattern.compile("INSERT INTO InvoiceDetails VALUES \\('([^']+)', '([^']+)', '([^']+)', '([^']+)', '([^']+)', '([^']+)', '([^']+)'\\);");

                    // Read the file and store its contents, except for the lines to be replaced
                    boolean matchFound = false;
                    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            Matcher matcher = pattern.matcher(line);
                            if (matcher.find()) {
                                String date = matcher.group(1);
                                String invoiceNo = matcher.group(2);

                                // Check if the date and invoice number match the selected criteria
                                if (date.equals(formattedDate1) && invoiceNo.equals(selectedItem)) {
                                    matchFound = true;
                                    continue; // Skip this line (i.e., remove it)
                                }
                            }
                            fileContent.append(line).append(System.lineSeparator());
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return;
                    }

                    if (!matchFound) {
                        System.out.println("No matching data found to replace.");
                        return;
                    }

                    // Get data from JTable and format it as SQL insert statements
                    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                    StringBuilder newEntries = new StringBuilder();
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        String tableItemName = tableModel.getValueAt(i, 0).toString();  // Assuming itemName is in column 0
                        String tableQty = tableModel.getValueAt(i, 1).toString();  // Assuming qty is in column 1
                        String tableRate =tableModel.getValueAt(i, 2).toString();  // Assuming rate is in column 2
                        String tableAmount =tableModel.getValueAt(i, 3).toString();  // Assuming amount is in column 3

                        newEntries.append(String.format(
                            "INSERT INTO InvoiceDetails VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s');%n",
                            formattedDate1, selectedItem, i+1, tableItemName, tableRate, tableQty, tableAmount
                        ));
                    }

                    // Append the new entries at the place of the removed ones
                    fileContent.append(newEntries.toString());

                    // Write the modified content back to the file
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                        writer.write(fileContent.toString());
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(null, "INVOICE Saved Successfully......");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        
        GroupLayout gl_panel_3 = new GroupLayout(panel_3);
        gl_panel_3.setHorizontalGroup(
        	gl_panel_3.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_3.createSequentialGroup()
        			.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_3.createSequentialGroup()
        					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        					.addGap(30)
        					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblNewLabel_8, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        						.addComponent(lblNewLabel_9, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        						.addComponent(lblNewLabel_10, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        						.addComponent(lblNewLabel_11, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
        				.addGroup(gl_panel_3.createSequentialGroup()
        					.addGap(42)
        					.addComponent(btnNewButton_6)))
        			.addContainerGap())
        );
        gl_panel_3.setVerticalGroup(
        	gl_panel_3.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_3.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNewLabel_4))
        			.addGap(5)
        			.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNewLabel_5))
        			.addGap(5)
        			.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNewLabel_6))
        			.addGap(5)
        			.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNewLabel_7))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnNewButton_6)
        			.addContainerGap(12, Short.MAX_VALUE))
        );
        panel_3.setLayout(gl_panel_3);
        
       
        scrollPane.setViewportView(table);
        panel_2.setLayout(gl_panel_2);

        JButton btnNewButton_1 = new JButton("SETTINGS");
        btnNewButton_1.setEnabled(true);
        btnNewButton_1.addActionListener(e -> {
            File sqlFile = new File("C:\\POS\\Categorial_Data\\dat.sql");
            String percentageValue = "";

            // 🔹 Read current value from .sql file
            try (BufferedReader br = new BufferedReader(new FileReader(sqlFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (line.toUpperCase().startsWith("INSERT INTO INVOICE_DISC")) {
                        int firstQuote = line.indexOf('\'');
                        int secondQuote = line.indexOf('\'', firstQuote + 1);
                        if (firstQuote != -1 && secondQuote != -1) {
                            percentageValue = line.substring(firstQuote + 1, secondQuote);
                            break;
                        }
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error reading .sql file");
                return;
            }

            // 🪟 Show dialog with prefilled value
            JDialog dialog = new JDialog((Frame) null, "Set Percentage", true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setSize(300, 150);
            dialog.setLayout(new BorderLayout());
            dialog.setLocationRelativeTo(null);

            JPanel inputPanel = new JPanel(new FlowLayout());
            JLabel label = new JLabel("Enter Percentage:");
            JTextField percentageField = new JTextField(10);
            percentageField.setText(percentageValue);
            inputPanel.add(label);
            inputPanel.add(percentageField);

            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(ev -> {
                String text = percentageField.getText().trim();
                try {
                    double val = Double.parseDouble(text);
                    if (val < 0 || val > 100) {
                        JOptionPane.showMessageDialog(dialog, "Enter value between 0 and 100");
                        return;
                    }

                    // 🔹 Overwrite the .sql file with new value
                    String newSql = "INSERT INTO Invoice_Disc (set) VALUES ('" + text + "');";
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(sqlFile, false))) {
                        bw.write(newSql);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(dialog, "Error writing .sql file");
                        return;
                    }

                    System.out.println("Saved: " + val + "%");
                    dialog.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog, "Enter a valid number");
                }
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(saveButton);

            dialog.add(inputPanel, BorderLayout.CENTER);
            dialog.add(buttonPanel, BorderLayout.SOUTH);
            dialog.setVisible(true);
        });

        btnNewButton_1.setBackground(Color.WHITE);

        JButton btnNewButton_1_1 = new JButton("BACK");
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AdminPanel counter = new AdminPanel();
                counter.setVisible(true);
                dispose();
        	}
        });
        btnNewButton_1_1.setBackground(Color.WHITE);
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
            gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_1.createSequentialGroup()
                    .addGap(70)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
                        .addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNewButton_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                    .addContainerGap(82, Short.MAX_VALUE))
        );
        gl_panel_1.setVerticalGroup(
            gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_1.createSequentialGroup()
                    .addGap(61)
                    .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(338, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(createResizedIcon("/images/user-icon-2048x2048-ihoxz4vq-removebg-preview.png", 110, 110));

        JLabel lblNewLabel_1 = new JLabel("ADMIN PANEL");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel_1.setForeground(new Color(0, 0, 102));

        JButton btnNewButton = new JButton("LOGOUT");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 Main.main(new String[]{}); // You can pass arguments if needed
                 dispose();
            }
        });
        btnNewButton.setBackground(Color.RED);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));

        JLabel lblNewLabel_2 = new JLabel("DOSA PLAZA");
        lblNewLabel_2.setForeground(new Color(255, 0, 0));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                    .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(lblNewLabel_1)
                            .addGap(385)
                            .addComponent(lblNewLabel_2)))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(330)
                            .addComponent(btnNewButton)
                        ))
        );
        gl_panel.setVerticalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(50)
                            .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblNewLabel_2)
                                .addGroup(gl_panel.createSequentialGroup()
                                    .addComponent(lblNewLabel_1)
                                    .addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                    .addComponent(btnNewButton)))))
                    .addContainerGap())
        );
        panel.setLayout(gl_panel);
        // Add mouse listener to table_1
        table_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && table_1.getSelectedRow() != -1) {
                    int selectedRow = table_1.getSelectedRow();
                    handleTableRowSelection(selectedRow);
                }
            }
        });

        // Add key listener to table_1
        table_1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && table_1.getSelectedRow() != -1) {
                    int selectedRow = table_1.getSelectedRow();
                    handleTableRowSelection(selectedRow);
                }
            }
        });
        contentPane.setLayout(gl_contentPane);

        // Add a button to print the selected date
        JButton btnPrintDate = new JButton("Print Date");
        btnPrintDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Calendar selectedDate = (Calendar) DatePicker.getModel().getValue();
                if (selectedDate != null) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
                    String formattedDate = dateFormat.format(selectedDate.getTime());
                    System.out.println("Selected Date: " + formattedDate);
                } else {
                    System.out.println("No date selected.");
                }
            }
        });

        panel_2.add(btnPrintDate);
    }
   

    private void searchTableContents(String searchString) {
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel1);
        table_1.setRowSorter(rowSorter);

        if (searchString.trim().isEmpty()) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchString));
        }
    }
    private void handleTableRowSelection(int row) {
        // Get the item details from the selected row
        String itemName = (String) tableModel1.getValueAt(row, 0);
        String itemCode = (String) tableModel1.getValueAt(row, 1);
        String itemPrice = (String) tableModel1.getValueAt(row, 2);

        // Show dialog to ask for quantity
        String quantityStr = JOptionPane.showInputDialog(this, "Enter quantity for " + itemName + ":");
        if (quantityStr != null && !quantityStr.isEmpty()) {
            try {
                int quantity = Integer.parseInt(quantityStr);
                double price = Double.parseDouble(itemPrice);
                double amount = quantity * price;

                // Add to the main table
                tableModel.addRow(new Object[]{itemName, quantity, price, amount});
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid quantity or price", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        printTotalAmount();
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
    private void readSqlFileAndDisplayInTable(String filePath, String formattedDate1, String selectedItem) {
        Pattern pattern = Pattern.compile("INSERT INTO InvoiceDetails VALUES \\('([^']+)', '([^']+)', '([^']+)', '([^']+)', '([^']+)', '([^']+)', '([^']+)'\\);");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String date = matcher.group(1);
                    String invoiceNo = matcher.group(2);
                    String itemName = matcher.group(4);
                    String rate = matcher.group(5);
                    String qty = matcher.group(6);
                    String amount = matcher.group(7);

                    // Check if the date and invoice number match the selected criteria
                    if (date.equals(formattedDate1) && invoiceNo.equals(selectedItem)) {
                        tableModel.addRow(new Object[]{itemName,qty,rate, amount});
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void handleTableRowEdit(int row) {
        JCheckBox quantityCheckBox = new JCheckBox("Quantity");
        JCheckBox rateCheckBox = new JCheckBox("Rate");
        Object[] options = {quantityCheckBox, rateCheckBox, "OK"};
        int result = JOptionPane.showOptionDialog(this, "Select the fields to edit:", "Edit Row",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[2]);

        if (result == 2) { // If "OK" is clicked
            Integer newQuantity = null;
            Double newRate = null;

            if (quantityCheckBox.isSelected()) {
                String quantityStr = JOptionPane.showInputDialog(this, "Enter new quantity:");
                if (quantityStr != null && !quantityStr.isEmpty()) {
                    try {
                        newQuantity = Integer.parseInt(quantityStr);
                        tableModel.setValueAt(newQuantity, row, 1); // Update the quantity in the table
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Invalid quantity", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            if (rateCheckBox.isSelected()) {
                String rateStr = JOptionPane.showInputDialog(this, "Enter new rate:");
                if (rateStr != null && !rateStr.isEmpty()) {
                    try {
                        newRate = Double.parseDouble(rateStr);
                        tableModel.setValueAt(newRate, row, 2); // Update the rate in the table
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Invalid rate", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            // Update the amount based on the new quantity or rate
            if (newQuantity != null || newRate != null) {
                // Get current values as strings and convert them
                String currentQuantityStr = tableModel.getValueAt(row, 1).toString();
                String currentRateStr = tableModel.getValueAt(row, 2).toString();

                // Convert to appropriate types
                int currentQuantity = newQuantity != null ? newQuantity : Integer.parseInt(currentQuantityStr);
                double currentRate = newRate != null ? newRate : Double.parseDouble(currentRateStr);

                double newAmount = currentQuantity * currentRate;
                tableModel.setValueAt(newAmount, row, 3); // Update the amount in the table
            }
        }
    }

    private void loadDataFromSqlFile(String inputFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            Pattern pattern = Pattern.compile("INSERT INTO menu \\(item_name, item_code, price\\) VALUES \\('([^']*)', '([^']*)', '([^']*)'\\);");

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String itemName = matcher.group(1);
                    String itemCode = matcher.group(2);
                    String price = matcher.group(3);

                    tableModel1.addRow(new Object[]{itemName, itemCode, price});
                }
            }

            System.out.println("Data has been successfully loaded into the JTable.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void printTotalAmount() {
        double totalAmount = 0.0;
        int rowCount = tableModel.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            String amountStr = tableModel.getValueAt(i, 3).toString(); // Assuming the "Amount" column is at index 3
            try {
                double amount = Double.parseDouble(amountStr);
                totalAmount += amount;
            } catch (NumberFormatException e) {
                // Handle potential parsing error if the value is not a valid number
                System.err.println("Invalid amount value at row " + i + ": " + amountStr);
            }
        }
        lblNewLabel_8.setText(String.format("%.2f", totalAmount)+"  ");
        Double CGST_SGST= totalAmount*0.025;
        Double Total= totalAmount+(CGST_SGST*2);
        lblNewLabel_9.setText(String.format("%.2f", CGST_SGST)+"  ");
        lblNewLabel_10.setText(String.format("%.2f", CGST_SGST)+"  ");
        lblNewLabel_11.setText(String.format("%.2f", Total)+"  ");
//        System.out.println("Total Amount: " + totalAmount);
    }

    private static ImageIcon createResizedIcon(String path, int width, int height) {
        ImageIcon icon = null;
        try {
            // Load the image from classpath
            Image image = ImageIO.read(AdminPanelInvoiceFormat.class.getResource(path));
            // Resize the image
            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            icon = new ImageIcon(resizedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return icon;
    }
}
