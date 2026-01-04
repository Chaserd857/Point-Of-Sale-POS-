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
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
@SuppressWarnings("all")
public class AdminPanelDeleteMenu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel panel_1;
    private JButton btnNewButton_1 = new JButton("ADD MENU");
    private JButton btnNewButton_1_1 = new JButton("DELETE MENU");
    private JButton btnNewButton_1_1_1 = new JButton("BACK");
    private JTextField textField;
    private JTable table;
    private DefaultTableModel tableModel;
    private static final String[][] data = readSQLFile("C:\\POS\\Menu_Data\\menu_data.sql");
    private JTable table_1;
	private DefaultTableModel tableModel_1;
	private static final String FILE_PATH = "C:\\POS\\Menu_Data\\menu_data.sql";

    /**
     * Launch the application.
     */
   

    /**
     * Create the frame.
     */
    public AdminPanelDeleteMenu() {
        createGUI();
        addSearchFunctionality();
        addNavigationFunctionality();
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1250, 610);
        setIconImage(Toolkit.getDefaultToolkit().getImage(AdminPanelDeleteMenu.class.getResource("/image/logo.png")));
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
        
        JScrollPane scrollPane_1 = new JScrollPane();

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

        // Set the sorter for the table
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING)); // Sort by the first column (ITEM NAME)
        sorter.setSortKeys(sortKeys);
        
        scrollPane.setViewportView(table);
        
        JLabel lblNewLabel_4 = new JLabel("SEARCH FIELD");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JButton btnNewButton_2 = new JButton("CLEAR");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tableModel_1.setRowCount(0);
        	}
        });
        
        JButton btnNewButton_3 = new JButton("REMOVE");
        btnNewButton_3.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table_1.getSelectedRow();
                if (selectedRow != -1) { // Check if a row is actually selected
                    DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                    model.removeRow(selectedRow);
                }
        	}
        });
        
        JButton btnNewButton_4 = new JButton("DELETE");
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TableModel model = table_1.getModel();
                
                for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
                    Object value = model.getValueAt(rowIndex, 0);
                    String valueAsString = value != null ? value.toString() : "null";
                    deleteRowFromFile("C:\\POS\\Menu_Data\\menu_data.sql",valueAsString);
                    tableModel_1.setRowCount(0);
                    JOptionPane.showMessageDialog(null, "Item Deleted successfully", "", JOptionPane.INFORMATION_MESSAGE);
                 // Refresh the table data
                    String[][] updatedData = readSQLFile1();
                    tableModel.setRowCount(0); // Clear existing rows
                    for (String[] row : updatedData) {
                        tableModel.addRow(row);
                    }
                }
        	}
        });
        
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
        	gl_panel_2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_2.createSequentialGroup()
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addGap(10)
        					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_panel_2.createSequentialGroup()
        							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        							.addGap(3)
        							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_panel_2.createSequentialGroup()
        							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(106)
        							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
        								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
        								.addGroup(gl_panel_2.createSequentialGroup()
        									.addComponent(btnNewButton_4)
        									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addComponent(btnNewButton_3)
        									.addGap(10)
        									.addComponent(btnNewButton_2))))))
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addGap(188)
        					.addComponent(lblNewLabel_4)))
        			.addContainerGap(32, Short.MAX_VALUE))
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
        					.addGap(86)
        					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
        					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnNewButton_2)
        						.addComponent(btnNewButton_3)
        						.addComponent(btnNewButton_4))))
        			.addContainerGap(15, Short.MAX_VALUE))
        );
        tableModel_1 = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // All cells are non-editable
            }
        };
        table_1 = new JTable(tableModel_1);
        table_1.getColumnModel().getColumn(0).setPreferredWidth(180);
        table_1.getColumnModel().getColumn(1).setPreferredWidth(60);
        table_1.getColumnModel().getColumn(2).setPreferredWidth(60);
//        table_1.setRowHeight(15);
        scrollPane_1.setViewportView(table_1);
        panel_2.setLayout(gl_panel_2);

        btnNewButton_1 = new JButton("ADD MENU");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AddminPanelAddMenu counter = new AddminPanelAddMenu();
                counter.setVisible(true);
                dispose();
        	}
        });
        btnNewButton_1.setBackground(Color.WHITE);

        btnNewButton_1_1 = new JButton("DELETE MENU");
        btnNewButton_1_1.setBackground(Color.WHITE);

        btnNewButton_1_1_1 = new JButton("BACK");
        btnNewButton_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminPanel counter = new AdminPanel();
                counter.setVisible(true);
                dispose();
            }
        });
        btnNewButton_1_1_1.setBackground(Color.WHITE);
        
        JButton btnNewButton_1_1_1_1 = new JButton("EDIT MENU ITEM");
        btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AdminPanelEditMenuItemDetails counter = new AdminPanelEditMenuItemDetails();
                counter.setVisible(true);
                dispose();
        	}
        });
        btnNewButton_1_1_1_1.setBackground(Color.WHITE);
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(70)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnNewButton_1_1_1_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
        					.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(btnNewButton_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
        			.addContainerGap(82, Short.MAX_VALUE))
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(61)
        			.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btnNewButton_1_1_1_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
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
        		 Main.main(new String[]{}); 
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
        contentPane.setLayout(gl_contentPane);
    }

    private static ImageIcon createResizedIcon(String path, int width, int height) {
        ImageIcon icon = null;
        try {
            // Load the image from classpath
            Image image = ImageIO.read(AdminPanelDeleteMenu.class.getResource(path));
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

                StringBuilder rowData = new StringBuilder();
                Object[] rowValues = new Object[table.getColumnCount()];

                for (int col = 0; col < table.getColumnCount(); col++) {
                    Object value = table.getModel().getValueAt(modelRow, col);
                    rowData.append(value).append(" ");
                    rowValues[col] = value; // Store the value for insertion into table_1
                }

//                System.out.println("Selected Row Data: " + rowData.toString().trim());

                // Insert the row into table_1
                tableModel_1.addRow(rowValues);

            } catch (IndexOutOfBoundsException e) {
                System.err.println("Error: Invalid row selection");
            }
        } else {
            System.err.println("No row selected");
        }
    }
    
    public void deleteRowFromFile(String filePath, String itemNameToDelete) {
        File inputFile = new File(filePath);
        File tempFile = new File("tempFile.sql");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (!currentLine.contains(itemNameToDelete)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Delete the original file
        if (!inputFile.delete()) {
            System.out.println("Could not delete original file");
            return;
        }

        // Rename the temp file to the original file
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename temp file");
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
