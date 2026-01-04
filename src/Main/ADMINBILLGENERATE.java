package Main;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.JScrollPane;
import javax.swing.JTable;
@SuppressWarnings("all")
public class ADMINBILLGENERATE extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel panel_1;
    private JPanel panel_3;

    private JButton btnNewButton_1_1_1 = new JButton("BACK");
    private JTextField textField;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTable table1;
    private DefaultTableModel tableModel1;
    
    private static final String[][] data = readSQLFile("C:\\POS\\Menu_Data\\menu_data.sql");
   
    private static final String FILE_PATH = "C:\\POS\\Menu_Data\\menu_data.sql";

    /**
     * Launch the application.
     */
   
    /**
     * Create the frame.
     */
    public ADMINBILLGENERATE() {
        createGUI();
        addSearchFunctionality();
        addNavigationFunctionality();
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1250, 610);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ADMINBILLGENERATE.class.getResource("/image/logo.png")));
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set to full size
//        setUndecorated(true);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
        
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 0));

        panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 102, 255));

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
//                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                        .addGroup(gl_contentPane.createSequentialGroup()
//                            .addGap(4)
                            .addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))))
        );

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
        lblNewLabel_3.setBackground(SystemColor.activeCaption);
        ImageIcon icon = createResizedIcon("/images/Q-removebg-preview.png", 25, 25);
        lblNewLabel_3.setIcon(icon);

        textField = new JTextField(20);

        JScrollPane scrollPane = new JScrollPane();

        String[] columnNames = {"ITEM NAME", "ITEM CODE", "ITEM RATE"};
        // Create a table model with these column names and override isCellEditable
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // All cells are non-editable
            }
        };
        table = new JTable(tableModel);
        for (String[] row : data) {
            tableModel.addRow(row);
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(180);
        table.getColumnModel().getColumn(1).setPreferredWidth(60);
        table.getColumnModel().getColumn(2).setPreferredWidth(60);
        table.setRowHeight(20);

        scrollPane.setViewportView(table);
        
        JLabel lblNewLabel_4 = new JLabel("SEARCH FIELD");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        panel_3 = new JPanel();
//        panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_3.setBackground(Color.WHITE);
        panel_3.setVisible(false);
        
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
        	gl_panel_2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_2.createSequentialGroup()
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addGap(10)
        					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_panel_2.createSequentialGroup()
        							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							
        							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_panel_2.createSequentialGroup()
        							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        							.addGap(3)
        							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE))))
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addGap(188)
        					.addComponent(lblNewLabel_4)))
        			.addContainerGap(25, Short.MAX_VALUE))
        );
        gl_panel_2.setVerticalGroup(
        	gl_panel_2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_2.createSequentialGroup()
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addGap(5)
        					.addComponent(lblNewLabel_4)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        					.addGap(11)
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel_2.createSequentialGroup()
        					
        					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(15, Short.MAX_VALUE))
        );
        
     // --- Title label ---
        

     // --- Table setup ---
     // --- Table setup ---
        String[] columnNames1 = {"ITEM NAME", "ITEM QUANTITY", "ITEM RATE", "TOTAL"};
        tableModel1 = new DefaultTableModel(columnNames1, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Makes all cells non-editable
            }
        };

        table1 = new JTable(tableModel1);
        table1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        table1.setRowHeight(25);
        table1.setAutoCreateRowSorter(true);

        // --- Scroll pane for table ---
        JScrollPane scrollPane1 = new JScrollPane(table1);

        // --- Input fields ---
        JLabel lblInvoice = new JLabel("Invoice No:");
        lblInvoice.setFont(new Font("Tahoma", Font.BOLD, 14));

        JTextField txtInvoice = new JTextField();
        txtInvoice.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtInvoice.setColumns(10);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));

        JTextField txtDate = new JTextField();
        txtDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtDate.setColumns(10);

        // Auto-fill current date in dd/MM/yyyy format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        txtDate.setText(LocalDate.now().format(formatter));
        JLabel lblDate1 = new JLabel("");
        lblDate1.setFont(new Font("Tahoma", Font.BOLD, 14));
        JLabel lblDate2 = new JLabel("");
        lblDate2.setFont(new Font("Tahoma", Font.BOLD, 14));
     // --- Method to update totals ---
        Runnable updateTotals = () -> {
            double subtotal = 0.0;
            for (int i = 0; i < tableModel1.getRowCount(); i++) {
                Object totalObj = tableModel1.getValueAt(i, 3); // "TOTAL" column
                if (totalObj != null) {
                    try {
                        subtotal += Double.parseDouble(totalObj.toString());
                    } catch (NumberFormatException ignored) {}
                }
            }
            double tax = subtotal * 0.05;
            double grandTotal = subtotal + tax;

            lblDate1.setText(String.format("%.2f", subtotal));
            
            lblDate2.setText(String.format("%.2f", grandTotal));
        };

        // --- Listen for table data changes ---
        tableModel1.addTableModelListener(e -> updateTotals.run());
        // --- Print Button ---
        JButton btnPrint = new JButton("Print");
        btnPrint.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnPrint.addActionListener(e -> {
            int quantityColumn = 1; // "ITEM QUANTITY" column
            int totalQuantity = 0;

            for (int i = 0; i < tableModel1.getRowCount(); i++) {
                Object value = tableModel1.getValueAt(i, quantityColumn);
                if (value != null && !value.toString().trim().isEmpty()) {
                    try {
                        totalQuantity += Integer.parseInt(value.toString());
                    } catch (NumberFormatException ignored) {}
                }
            }

            // totalQuantity now contains the sum of all ITEM QUANTITY column values
            System.out.println("Total Quantity = " + totalQuantity);

            // Pass totalQuantity to next window or use it elsewhere
            mainpanelgenbill counter = new mainpanelgenbill(
                tableModel1,
                lblDate1.getText(),
                lblDate2.getText(),
                txtDate.getText(),
                txtInvoice.getText(),
                totalQuantity
            );
            counter.setLocationRelativeTo(null);
            counter.setVisible(false);
        });


        // --- Layout setup using GroupLayout ---
        GroupLayout gl_panel_3 = new GroupLayout(panel_3);
        gl_panel_3.setHorizontalGroup(
            gl_panel_3.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_panel_3.createSequentialGroup()
                    .addGap(20)
                    .addGroup(gl_panel_3.createParallelGroup(GroupLayout.Alignment.LEADING)
                        // Input Row
                        .addGroup(gl_panel_3.createSequentialGroup()
                            .addComponent(lblInvoice)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtInvoice, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addGap(30)
                            .addComponent(lblDate)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                        // Table
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                        // Print button
                        .addComponent(btnPrint, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(20, Short.MAX_VALUE))
        );

        gl_panel_3.setVerticalGroup(
            gl_panel_3.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_panel_3.createSequentialGroup()
                    .addGap(10)
                    // Input fields
                    .addGroup(gl_panel_3.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblInvoice)
                        .addComponent(txtInvoice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDate)
                        .addComponent(txtDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(20)
                    // Table
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                    .addGap(15)
                    // Print button
                    .addComponent(btnPrint)
                    .addContainerGap(20, Short.MAX_VALUE))
        );

        panel_3.setLayout(gl_panel_3);


        
        panel_2.setLayout(gl_panel_2);

        

        btnNewButton_1_1_1 = new JButton("BACK");
        btnNewButton_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminPanel counter = new AdminPanel();
                counter.setVisible(true);
                dispose();
            }
        });
        btnNewButton_1_1_1.setBackground(Color.WHITE);
        
        
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(70)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
        				
        				.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
        					))
        			.addContainerGap(82, Short.MAX_VALUE))
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(61)
        			 			.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(214, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(createResizedIcon("/images/user-icon-2048x2048-ihoxz4vq-removebg-preview.png", 110, 110));

        JLabel lblNewLabel_1 = new JLabel("ADMIN PANEL");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_1.setForeground(new Color(0, 0, 102));

        JButton btnNewButton = new JButton("LOGOUT");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		 Main.main(new String[]{}); // You can pass arguments if needed
                 dispose();
        	}
        });
        btnNewButton.setBackground(Color.RED);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));

        JLabel lblNewLabel_2 = new JLabel("DOSA PLAZA");
        lblNewLabel_2.setForeground(new Color(255, 0, 0));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 35));
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
        contentPane.setLayout(gl_contentPane);
    }

    private static ImageIcon createResizedIcon(String path, int width, int height) {
        ImageIcon icon = null;
        try {
            // Load the image from classpath
            Image image = ImageIO.read(ADMINBILLGENERATE.class.getResource(path));
            // Resize the image
            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            icon = new ImageIcon(resizedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return icon;
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

    private void addSearchFunctionality() {
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Not used, but required by KeyListener interface
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_UP) {
                    table.requestFocus(); // Move focus to the table for navigation
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                filterTable(textField.getText());
            }
        });
    }

    private void filterTable(String text) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text)); // Case-insensitive regex filter

        if (table.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0); // Select the first row if available
        }
    }

    private void addNavigationFunctionality() {
        table.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Not used, but required by KeyListener interface
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int selectedRow = table.getSelectedRow();

                if (keyCode == KeyEvent.VK_DOWN) {
                    if (selectedRow < table.getRowCount() - 1) {
                        table.setRowSelectionInterval(selectedRow + 1, selectedRow + 1);
                    }
                } else if (keyCode == KeyEvent.VK_UP) {
                    if (selectedRow > 0) {
                        table.setRowSelectionInterval(selectedRow - 1, selectedRow - 1);
                    }
                } else if (keyCode == KeyEvent.VK_ENTER) {
                    printSelectedRow();
                    textField.requestFocus(); // Move focus back to the search field after printing
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not used, but required by KeyListener interface
            }
        });

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 1) {
                    printSelectedRow();
                }
            }
        });
    }


    private void printSelectedRow() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            try {
                int modelRow = table.convertRowIndexToModel(selectedRow);

                // Assuming table columns: [Item Code, Item Name, Rate]
                String itemName = table.getModel().getValueAt(modelRow, 0).toString();
                String itemRateStr = table.getModel().getValueAt(modelRow, 2).toString();

                double rate;
                try {
                    rate = Double.parseDouble(itemRateStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid rate value!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // --- Ask for quantity ---
                String qtyStr = JOptionPane.showInputDialog(this, "Enter quantity for " + itemName + ":");
                if (qtyStr == null || qtyStr.trim().isEmpty()) {
                    return; // cancelled or empty input
                }

                int quantity;
                try {
                    quantity = Integer.parseInt(qtyStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid quantity!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // --- Calculate total ---
                double total = rate * quantity;

                // --- Add row to table_1 (panel_3 table) ---
                Object[] newRow = { itemName, quantity, rate, total };
                tableModel1.addRow(newRow);

                // --- Make panel visible if hidden ---
                panel_3.setVisible(true);

            } catch (IndexOutOfBoundsException e) {
                System.err.println("Error: Invalid row selection");
            }
        } else {
            System.err.println("No row selected");
        }
    }


    
    public static void updateSQLFile(String filePath, String itemName, String newCode, String newRate) {
        ArrayList<String> lines = new ArrayList<>();
        boolean itemFound = false;
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
                        String[] valuesArray = values.split("\\s*,\\s*");
                        for (int i = 0; i < valuesArray.length; i++) {
                            valuesArray[i] = valuesArray[i].replaceAll("^'|'$", ""); // remove single quotes
                        }

                        if (valuesArray[0].equalsIgnoreCase(itemName)) {
                            // Update code and rate
                            valuesArray[1] = newCode;
                            valuesArray[2] = newRate;
                            itemFound = true;
                        }

                        StringBuilder newValues = new StringBuilder();
                        for (String value : valuesArray) {
                            newValues.append("'").append(value).append("', ");
                        }
                        // Remove the last comma and space
                        newValues.setLength(newValues.length() - 2);

                        line = "INSERT INTO " + matcher.group(0).split("\\(")[0] + "(" + columns + ") VALUES (" + newValues.toString() + ");";
                    }
                }
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!itemFound) {
            // If the item was not found, add a new line with the new item
            lines.add("INSERT INTO menu (item_name, item_code, price) VALUES ('" + itemName + "', '" + newCode + "', '" + newRate + "');");
        }

        // Write the updated content back to the file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String updatedLine : lines) {
                bw.write(updatedLine);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String[][] readSQLFile1() {
        ArrayList<String[]> rows = new ArrayList<>();
        String regex = "INSERT INTO \\w+ \\(([^)]+)\\) VALUES \\(([^)]+)\\);";
        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Matcher matcher = pattern.matcher(line.trim());
                    if (matcher.find()) {
                        String columns = matcher.group(1);
                        String values = matcher.group(2);

                        // Split values and remove surrounding single quotes
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
    public JPanel getPanel() {
        return panel_1;
    }
}
