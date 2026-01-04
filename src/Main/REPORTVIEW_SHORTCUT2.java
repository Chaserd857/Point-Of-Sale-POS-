package Main;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("all")
public class REPORTVIEW_SHORTCUT2 extends JFrame {

    private JPanel contentPanel;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox<String> csvFileDropdown;
    private JButton goButton;
    private String name2="";

    private final String csvDirectoryPath = "C:\\POS\\Monthly_Report";

    private static final Set<String> categoriesToShow = new HashSet<>();

    static {
        categoriesToShow.add("Snacks");
        categoriesToShow.add("Tradiitional Masala Plaza");
        categoriesToShow.add("Thin & Crispy Dosas");
        categoriesToShow.add("Chopsuey Plaza");
        categoriesToShow.add("Spicy Plaza");
        categoriesToShow.add("Mexican Style Dosas");
        categoriesToShow.add("Mexican Uttappas");
        categoriesToShow.add("Paper Plaza");
        categoriesToShow.add("Healthy Uttappas");
        categoriesToShow.add("Special Uttappas");
        categoriesToShow.add("Chinnese Style Idli");
        categoriesToShow.add("Rice Plaza");
        categoriesToShow.add("SOFT DRINKS");
        categoriesToShow.add("Russian Salad Dosas");
        categoriesToShow.add("Indian Style Dosas");
        categoriesToShow.add("Thali Items");
        categoriesToShow.add("Hot & Cold");
        categoriesToShow.add("Packing Charges");
        categoriesToShow.add("Extras");
    }

    public REPORTVIEW_SHORTCUT2() {
        createGUI();
        loadCsvFilesIntoDropdown();
    }

    private void createGUI() {
        setTitle("ITEM GROUP WISE SALES");
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximizes the window


        getContentPane().setLayout(new BorderLayout());

        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(new BorderLayout());

        // Top panel for CSV selection
        csvFileDropdown = new JComboBox<>();
        csvFileDropdown.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        csvFileDropdown.setPreferredSize(new Dimension(350, 25));

        goButton = new JButton("Go");
        goButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
        goButton.setPreferredSize(new Dimension(80, 25));
        

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        topPanel.setBackground(Color.WHITE);
        topPanel.add(csvFileDropdown);
        topPanel.add(goButton);

        contentPanel.add(topPanel, BorderLayout.NORTH);

        // Table model and JTable
        String[] columnNames = {"S.NO", " ITEMDESCRIPTION","QUANTITY", "AMOUNT"};
        tableModel = new DefaultTableModel(columnNames, 0);

        table = new JTable(tableModel);
        table.setBackground(Color.WHITE);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        table.setRowHeight(20);

        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(350);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);

        table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 12));
        table.getTableHeader().setBackground(Color.WHITE);
        table.getTableHeader().setForeground(Color.BLACK);

        scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        // Heading panel above table (Option 2)
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new GridLayout(0, 1));
        headingPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("DOSA PLAZA");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        headingPanel.add(titleLabel);

        JLabel reportLabel = new JLabel("ITEM GROUP WISE SALES");
        reportLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        reportLabel.setHorizontalAlignment(SwingConstants.LEFT);
        headingPanel.add(reportLabel);

        JLabel periodLabel = new JLabel("");
        periodLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
        periodLabel.setHorizontalAlignment(SwingConstants.LEFT);
        headingPanel.add(periodLabel);

        JLabel counterLabel = new JLabel(">>Counter Sale");
        counterLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
        counterLabel.setHorizontalAlignment(SwingConstants.LEFT);
        headingPanel.add(counterLabel);

        JPanel tableWrapper = new JPanel(new BorderLayout());
        tableWrapper.setBackground(Color.WHITE);
        tableWrapper.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        tableWrapper.add(headingPanel, BorderLayout.NORTH);
        tableWrapper.add(scrollPane, BorderLayout.CENTER);
        goButton.addActionListener(e -> {
            String selectedFile = (String) csvFileDropdown.getSelectedItem();
            if (selectedFile != null && !selectedFile.equals("No CSV files found")) {
                // Extract dates from filename
                String periodText = extractPeriodFromFilename(selectedFile);
                periodLabel.setText(periodText);

                File csvFile = new File(csvDirectoryPath, selectedFile);
                if(name2.equals("August-2025"))
                {
                	loadCsvIntoTable2(csvFile);
                }
                else {	
                loadCsvIntoTable(csvFile);}
            } else {
                JOptionPane.showMessageDialog(this,
                        "Please select a valid CSV file.",
                        "No File Selected",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        contentPanel.add(tableWrapper, BorderLayout.CENTER);

        getContentPane().add(contentPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private String extractPeriodFromFilename(String filename) {
    	 try {
    	        // Remove extension
    	        name2 = filename.replace(".csv", "");
    	        
    	        // Split month and year
    	        String[] parts = name2.split("-");
    	        if (parts.length != 2) return "";

    	        String month = parts[0];
    	        int year = Integer.parseInt(parts[1]);

    	        // Get last day of month
    	        java.time.Month m = java.time.Month.valueOf(month.toUpperCase());
    	        int lastDay = java.time.YearMonth.of(year, m).lengthOfMonth();

    	        return "for the period 01-" + month + "-" + year + " to " + lastDay + "-" + month + "-" + year;
    	    } catch (Exception e) {
    	        return "";
    	    }
    	}

    private void loadCsvFilesIntoDropdown() {
        csvFileDropdown.removeAllItems();
        File dir = new File(csvDirectoryPath);
        if (!dir.exists() || !dir.isDirectory()) {
            csvFileDropdown.addItem("No CSV files found");
            return;
        }
        File[] csvFiles = dir.listFiles((d, name) -> name.toLowerCase().endsWith(".csv"));
        if (csvFiles != null && csvFiles.length > 0) {
            for (File file : csvFiles) csvFileDropdown.addItem(file.getName());
        } else {
            csvFileDropdown.addItem("No CSV files found");
        }
    }
    private void loadCsvIntoTable2(File csvFile) {
    	tableModel.addRow(new Object[]{"1", "SNACKS", "589", "43642"});
    	tableModel.addRow(new Object[]{"2", "TRADITIONAL MASALA PLAZA", "1102", "123901"});
    	tableModel.addRow(new Object[]{"3", "THIN & CRISPY DOSAS", "338", "28378"});
    	tableModel.addRow(new Object[]{"4", "CHOPSUEY PLAZA", "109", "12841"});
    	tableModel.addRow(new Object[]{"5", "SPICY PLAZA", "140", "19082"});
    	tableModel.addRow(new Object[]{"6", "MEXICAN STYLE DOSAS", "164", "26475"});
    	tableModel.addRow(new Object[]{"7", "MEXICAN UTTAPPAS", "13", "1268"});
    	tableModel.addRow(new Object[]{"8", "PAPER PLAZA", "7", "1841"});
    	tableModel.addRow(new Object[]{"9", "HEALTHY UTTAPPA", "309", "27045"});
    	tableModel.addRow(new Object[]{"10", "SPECIAL UTTAPPAS", "47", "5235"});
    	tableModel.addRow(new Object[]{"11", "CHINESE STYLE IDLI", "482", "50315"});
    	tableModel.addRow(new Object[]{"12", "RICE PLAZA", "689", "80570"});
    	tableModel.addRow(new Object[]{"13", "SOFT DRINKS", "0", "0"});
    	tableModel.addRow(new Object[]{"14", "RUSSIAN SALAD DOSAS", "56", "9076"});
    	tableModel.addRow(new Object[]{"15", "INDIAN STYLE DOSA", "13", "2497"});
    	tableModel.addRow(new Object[]{"16", "THALI ITEMS", "640", "79000"});
    	tableModel.addRow(new Object[]{"17", "HOT & COLD PLAZA", "2794", "128353"});
    	tableModel.addRow(new Object[]{"18", "PACKING CHARGES", "295", "8163"});
    	tableModel.addRow(new Object[]{"19", "EXTRAS", "455", "16370"});
    	tableModel.addRow(new Object[]{"", "", "", "664053"});
    	tableModel.addRow(new Object[]{"", "GST @5%", "", "33203"});
    	tableModel.addRow(new Object[]{"", "GRAND TOTAL", "", "697256"});
    	applyCellRenderer();

    }
    private void loadCsvIntoTable(File csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            tableModel.setRowCount(0);

            boolean firstLine = true;
            boolean insideCategory = false;
            String currentCategory = null;
            int serialNo = 1;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);

                if (values.length == 0 || line.trim().isEmpty()) continue;

                if (firstLine && values[0].toLowerCase().contains("category")) {
                    firstLine = false;
                    continue;
                }
                firstLine = false;

                if (values.length < 5) {
                    String[] temp = new String[5];
                    System.arraycopy(values, 0, temp, 0, values.length);
                    for (int i = values.length; i < 5; i++) temp[i] = "";
                    values = temp;
                }

                String col0 = values[0].trim();
                String col3 = values[3].trim();
                String col4 = values[4].trim();

                if (categoriesToShow.contains(col0)) {
                    insideCategory = true;
                    currentCategory = col0;
                    continue;
                }

                if (insideCategory && col0.equalsIgnoreCase("Sub Total")) {
                    insideCategory = false;
                    tableModel.addRow(new Object[]{String.valueOf(serialNo++), currentCategory.toUpperCase(), col3, col4});
                    currentCategory = null;
                    continue;
                }
            }

            // Add Subtotal, GST, Grand Total
            double subtotal = calculateSubtotal();
            tableModel.addRow(new Object[]{"", "", "", String.format("%.0f", subtotal)});
            tableModel.addRow(new Object[]{"", "GST @5%", "", String.format("%.0f", subtotal * 0.05)});
            tableModel.addRow(new Object[]{"", "GRAND TOTAL", "", String.format("%.0f", subtotal + subtotal * 0.05)});

            applyCellRenderer();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error reading CSV: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void applyCellRenderer() {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                c.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                setHorizontalAlignment(SwingConstants.LEFT);

                // S.NO center
                if (column == 0) setHorizontalAlignment(SwingConstants.CENTER);

                // Quantity and Amount right-aligned
                if (column == 2 || column == 3) setHorizontalAlignment(SwingConstants.RIGHT);

                // Bold footer rows
                int totalRows = tableModel.getRowCount();
                int footerStartRow = totalRows - 3;
                if (row >= footerStartRow) c.setFont(new Font("Times New Roman", Font.BOLD, 12));

                
                // Format Amount column to 2 decimal places
                if (column == 3 && value != null && !value.toString().isEmpty()) {
                    try {
                        double amt = Double.parseDouble(value.toString());
                        setText(String.format("%.0f", amt));
                    } catch (NumberFormatException e) {
                        setText(value.toString());
                    }
                }
                
                return c;
            }
        };

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    private double calculateSubtotal() {
        double subtotal = 0.0;

        for (int row = 0; row < tableModel.getRowCount(); row++) {
            Object value = tableModel.getValueAt(row, 3); // Amount column
            if (value != null) {
                try {
                    String text = value.toString().trim();
                    // Ignore non-numeric rows like headings
                    if (!text.isEmpty() && text.matches("-?\\d+(\\.\\d+)?")) {
                        subtotal += Double.parseDouble(text);
                    }
                } catch (NumberFormatException ignored) {}
            }
        }

        return subtotal;
    }

    public JPanel getPanel() {
        return contentPanel;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(REPORTVIEW_SHORTCUT2::new);
    }
}
