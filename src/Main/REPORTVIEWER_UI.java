//
package Main;
//
//import java.awt.EventQueue;
//import java.time.LocalDate;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.GroupLayout;
//import javax.swing.GroupLayout.Alignment;
//import java.awt.Color;
//import java.awt.Dimension;
//
//import javax.swing.JScrollPane;
//import javax.swing.BoxLayout;
//import javax.swing.JLabel;
//import java.awt.Font;
//import java.awt.Toolkit;
//import javax.swing.JButton;
//import javax.swing.LayoutStyle.ComponentPlacement;
//
//public class REPORTVIEWER_UI extends JFrame {
//
//    private static final long serialVersionUID = 1L;
//    private JPanel contentPane;
//    private DefaultTableModel Model;
//    private DefaultTableModel secondTableModel;
//    private DefaultTableModel fourthTableModel;
//    private DefaultTableModel thirdTableModel;
//    private DefaultTableModel fifthTableModel;
//    private DefaultTableModel sixthTableModel;
//    private LocalDate start;
//    private DefaultTableModel seventhTableModel;
//    private LocalDate end;
//    private JPanel panel;
//    private JLabel lblNewLabel;
//
//    /**
//     * Launch the application.
//     */
////    public static void main(String[] args) {
////        EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                try {
////                    REPORTVIEWER_UI frame = new REPORTVIEWER_UI();
////                    frame.setVisible(true);
////                    frame.setLocationRelativeTo(null); // Center the frame on screen
////                } catch (Exception e) {
////                    e.printStackTrace();
////                }
////            }
////        });
////    }
//
//    /**
//     * Create the frame.
//     */
//    public REPORTVIEWER_UI(LocalDate startDate1, LocalDate endDate1, DefaultTableModel tableModel2, DefaultTableModel tableModel3, DefaultTableModel tableModel4, DefaultTableModel tableModel5, DefaultTableModel tableModel6, DefaultTableModel tableModel7, DefaultTableModel tableModel8) {
//        this.Model = tableModel2;
//        this.secondTableModel = tableModel3;
//        this.fourthTableModel = tableModel4;
//        this.fifthTableModel = tableModel5;
//        this.thirdTableModel = tableModel6;
//        this.sixthTableModel = tableModel7;
//        this.seventhTableModel = tableModel8;
//        this.start = startDate1;
//        this.end = endDate1;
//
//        createGUI();
//    }
//
//    private void createGUI() {
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setSize(500, 600); // Initial size
//        setIconImage(Toolkit.getDefaultToolkit().getImage(REPORTVIEWER_UI.class.getResource("/images/LOGO-removebg-preview.png")));
//        
//        setLocationRelativeTo(null); 
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//
//        panel = new JPanel();
//        panel.setBackground(new Color(255, 255, 255));
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Flexible height layout
//
//        JScrollPane scrollPane = new JScrollPane(panel);
//        
//        lblNewLabel = new JLabel("");
//        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
//        panel.add(lblNewLabel);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        
//        JButton btnNewButton = new JButton("New button");
//
//        GroupLayout gl_contentPane = new GroupLayout(contentPane);
//        gl_contentPane.setHorizontalGroup(
//        	gl_contentPane.createParallelGroup(Alignment.LEADING)
//        		.addGroup(gl_contentPane.createSequentialGroup()
//        			.addGap(25)
//        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
//        			.addContainerGap())
//        		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
//        			.addContainerGap(353, Short.MAX_VALUE)
//        			.addComponent(btnNewButton)
//        			.addGap(33))
//        );
//        gl_contentPane.setVerticalGroup(
//        	gl_contentPane.createParallelGroup(Alignment.LEADING)
//        		.addGroup(gl_contentPane.createSequentialGroup()
//        			.addContainerGap()
//        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
//        			.addPreferredGap(ComponentPlacement.RELATED)
//        			.addComponent(btnNewButton)
//        			.addContainerGap())
//        );
//        contentPane.setLayout(gl_contentPane);
//        showreport();
//        pack();
//        setVisible(true);
//    }
//
//    private void showreport() {
//        REPORTVIEW counter = new REPORTVIEW(start, end, Model, secondTableModel, fourthTableModel, fifthTableModel ,thirdTableModel, sixthTableModel, seventhTableModel);
//        panel.add(counter.getPanel());  // Add the new panel
//        panel.revalidate();
//        panel.repaint();
//    }
//}
//++++++++++++++++++++++++++      WORKING ++++++++++++++++++++++
//import javax.swing.*;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.LayoutStyle.ComponentPlacement;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.print.PageFormat;
//import java.awt.print.Printable;
//import java.awt.print.PrinterException;
//import java.awt.print.PrinterJob;
//import java.time.LocalDate;
//
//public class REPORTVIEWER_UI extends JFrame {
//
//    private JPanel contentPane;
//    private DefaultTableModel Model;
//    private DefaultTableModel secondTableModel;
//    private DefaultTableModel fourthTableModel;
//    private DefaultTableModel thirdTableModel;
//    private DefaultTableModel fifthTableModel;
//    private DefaultTableModel sixthTableModel;
//    private LocalDate start;
//    private DefaultTableModel seventhTableModel;
//    private LocalDate end;
//    private JPanel panel;
//    private JLabel lblNewLabel;
//    private JScrollPane scrollPane;
//
////    public static void main(String[] args) {
////        EventQueue.invokeLater(() -> {
////            try {
////                REPORTVIEWER_UI frame = new REPORTVIEWER_UI(LocalDate.now(), LocalDate.now(), new DefaultTableModel(), new DefaultTableModel(), new DefaultTableModel(), new DefaultTableModel(), new DefaultTableModel(), new DefaultTableModel(), new DefaultTableModel());
////                frame.setVisible(true);
////                frame.setLocationRelativeTo(null);
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////        });
////    }
//
//    public REPORTVIEWER_UI(LocalDate startDate1, LocalDate endDate1, DefaultTableModel tableModel2, DefaultTableModel tableModel3, DefaultTableModel tableModel4, DefaultTableModel tableModel5, DefaultTableModel tableModel6, DefaultTableModel tableModel7, DefaultTableModel tableModel8) {
//        this.Model = tableModel2;
//        this.secondTableModel = tableModel3;
//        this.fourthTableModel = tableModel4;
//        this.fifthTableModel = tableModel5;
//        this.thirdTableModel = tableModel6;
//        this.sixthTableModel = tableModel7;
//        this.seventhTableModel = tableModel8;
//        this.start = startDate1;
//        this.end = endDate1;
//
//        createGUI();
//    }
//
//    private void createGUI() {
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setSize(500, 600);
//        setIconImage(Toolkit.getDefaultToolkit().getImage(REPORTVIEWER_UI.class.getResource("/images/LOGO-removebg-preview.png")));
//        setLocationRelativeTo(null);
//
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//
//        panel = new JPanel();
//        panel.setBackground(new Color(255, 255, 255));
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//
//        scrollPane = new JScrollPane(panel);
//
//        lblNewLabel = new JLabel("");
//        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
//        panel.add(lblNewLabel);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//
//        JButton btnNewButton = new JButton("Save as PDF");
//        btnNewButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                saveAsPDF();
//            }
//        });
//
//        GroupLayout gl_contentPane = new GroupLayout(contentPane);
//        gl_contentPane.setHorizontalGroup(
//                gl_contentPane.createParallelGroup(Alignment.LEADING)
//                        .addGroup(gl_contentPane.createSequentialGroup()
//                                .addGap(25)
//                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
//                                .addContainerGap())
//                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
//                                .addContainerGap(353, Short.MAX_VALUE)
//                                .addComponent(btnNewButton)
//                                .addGap(33))
//        );
//        gl_contentPane.setVerticalGroup(
//                gl_contentPane.createParallelGroup(Alignment.LEADING)
//                        .addGroup(gl_contentPane.createSequentialGroup()
//                                .addContainerGap()
//                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
//                                .addPreferredGap(ComponentPlacement.RELATED)
//                                .addComponent(btnNewButton)
//                                .addContainerGap())
//        );
//        contentPane.setLayout(gl_contentPane);
//        showreport();
//        pack();
//        setVisible(true);
//    }
//
//    private void showreport() {
//        REPORTVIEW counter = new REPORTVIEW(start, end, Model, secondTableModel, fourthTableModel, fifthTableModel, thirdTableModel, sixthTableModel, seventhTableModel);
//        panel.add(counter.getPanel());
//        panel.revalidate();
//        panel.repaint();
//    }
//
//    private void saveAsPDF() {
//        PrinterJob printerJob = PrinterJob.getPrinterJob();
//        printerJob.setJobName("Save as PDF");
//
//        printerJob.setPrintable(new Printable() {
//            public int print(java.awt.Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
//                Graphics2D g2d = (Graphics2D) graphics;
//
//                // Set up the page size and margins
//                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
//                g2d.setClip(0, 0, (int) pageFormat.getImageableWidth(), (int) pageFormat.getImageableHeight());
//
//                // Calculate the scaling factor to fit the panel width to the page width
//                double scaleX = pageFormat.getImageableWidth() / panel.getWidth();
//                double scaleY = scaleX; // Keep aspect ratio
//
//                // Adjust the translation to center the panel on the page
//                double panelWidth = panel.getWidth() * scaleX;
//                double panelHeight = panel.getHeight() * scaleY;
//
//                // Calculate the number of pages needed
//                int totalNumPages = (int) Math.ceil(panelHeight / pageFormat.getImageableHeight());
//
//                // Check if the page index is out of range
//                if (pageIndex >= totalNumPages) {
//                    return Printable.NO_SUCH_PAGE;
//                }
//
//                // Translate the graphics to center the panel vertically
//                g2d.translate(0, -pageIndex * pageFormat.getImageableHeight());
//
//                // Scale the graphics to fit the panel
//                g2d.scale(scaleX, scaleY);
//
//                // Disable double buffering to improve performance
//                panel.setDoubleBuffered(false);
//
//                // Print the panel contents to the graphics context
//                panel.print(g2d);
//
//                return Printable.PAGE_EXISTS;
//            }
//        });
//
//        boolean userAccepted = printerJob.printDialog();
//        if (userAccepted) {
//            try {
//                printerJob.print();
//            } catch (PrinterException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//+++++++++++++++++++++++++++++++++++++++ TRYING ++++++++++++++++++++++++
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.print.*;
//import java.time.LocalDate;
//
//public class REPORTVIEWER_UI extends JFrame {
//
//    private JPanel contentPane;
//    private DefaultTableModel Model;
//    private DefaultTableModel secondTableModel;
//    private DefaultTableModel fourthTableModel;
//    private DefaultTableModel thirdTableModel;
//    private DefaultTableModel fifthTableModel;
//    private DefaultTableModel sixthTableModel;
//    private LocalDate start;
//    private DefaultTableModel seventhTableModel;
//    private LocalDate end;
//    private JPanel panel;
//    private JLabel lblNewLabel;
//    private JScrollPane scrollPane;
//
////    public static void main(String[] args) {
////        EventQueue.invokeLater(() -> {
////            try {
////                REPORTVIEWER_UI frame = new REPORTVIEWER_UI(LocalDate.now(), LocalDate.now(), new DefaultTableModel(), new DefaultTableModel(), new DefaultTableModel(), new DefaultTableModel(), new DefaultTableModel(), new DefaultTableModel(), new DefaultTableModel());
////                frame.setVisible(true);
////                frame.setLocationRelativeTo(null);
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////        });
////    }
//
//    public REPORTVIEWER_UI(LocalDate startDate1, LocalDate endDate1, DefaultTableModel tableModel2, DefaultTableModel tableModel3, DefaultTableModel tableModel4, DefaultTableModel tableModel5, DefaultTableModel tableModel6, DefaultTableModel tableModel7, DefaultTableModel tableModel8) {
//        this.Model = tableModel2;
//        this.secondTableModel = tableModel3;
//        this.fourthTableModel = tableModel4;
//        this.fifthTableModel = tableModel5;
//        this.thirdTableModel = tableModel6;
//        this.sixthTableModel = tableModel7;
//        this.seventhTableModel = tableModel8;
//        this.start = startDate1;
//        this.end = endDate1;
//
//        createGUI();
//    }
//
//    private void createGUI() {
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setSize(500, 600);
//        setIconImage(Toolkit.getDefaultToolkit().getImage(REPORTVIEWER_UI.class.getResource("/images/LOGO-removebg-preview.png")));
//        setLocationRelativeTo(null);
//
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//
//        panel = new JPanel();
//        panel.setBackground(new Color(255, 255, 255));
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//
//        scrollPane = new JScrollPane(panel);
//
//        lblNewLabel = new JLabel("");
//        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
//        panel.add(lblNewLabel);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//
//        JButton btnNewButton = new JButton("Save as PDF");
//        btnNewButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                saveAsPDF();
//            }
//        });
//
//        GroupLayout gl_contentPane = new GroupLayout(contentPane);
//        gl_contentPane.setHorizontalGroup(
//                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(gl_contentPane.createSequentialGroup()
//                                .addGap(25)
//                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
//                                .addContainerGap())
//                        .addGroup(GroupLayout.Alignment.TRAILING, gl_contentPane.createSequentialGroup()
//                                .addContainerGap(353, Short.MAX_VALUE)
//                                .addComponent(btnNewButton)
//                                .addGap(33))
//        );
//        gl_contentPane.setVerticalGroup(
//                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(gl_contentPane.createSequentialGroup()
//                                .addContainerGap()
//                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
//                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                                .addComponent(btnNewButton)
//                                .addContainerGap())
//        );
//        contentPane.setLayout(gl_contentPane);
//        showreport();
//        pack();
//        setVisible(true);
//    }
//
//    private void showreport() {
//        REPORTVIEW counter = new REPORTVIEW(start, end, Model, secondTableModel, fourthTableModel, fifthTableModel, thirdTableModel, sixthTableModel, seventhTableModel);
//        panel.add(counter.getPanel());
//        panel.revalidate();
//        panel.repaint();
//    }
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.print.*;
//import java.time.LocalDate;
//
//public class REPORTVIEWER_UI extends JFrame {
//
//    private JPanel contentPane;
//    private DefaultTableModel Model;
//    private DefaultTableModel secondTableModel;
//    private DefaultTableModel fourthTableModel;
//    private DefaultTableModel thirdTableModel;
//    private DefaultTableModel fifthTableModel;
//    private DefaultTableModel sixthTableModel;
//    private LocalDate start;
//    private DefaultTableModel seventhTableModel;
//    private LocalDate end;
//    private JPanel panel;
//    private JLabel lblNewLabel;
//    private JScrollPane scrollPane;
//
//    public REPORTVIEWER_UI(LocalDate startDate1, LocalDate endDate1, DefaultTableModel tableModel2, DefaultTableModel tableModel3, DefaultTableModel tableModel4, DefaultTableModel tableModel5, DefaultTableModel tableModel6, DefaultTableModel tableModel7, DefaultTableModel tableModel8) {
//        this.Model = tableModel2;
//        this.secondTableModel = tableModel3;
//        this.fourthTableModel = tableModel4;
//        this.fifthTableModel = tableModel5;
//        this.thirdTableModel = tableModel6;
//        this.sixthTableModel = tableModel7;
//        this.seventhTableModel = tableModel8;
//        this.start = startDate1;
//        this.end = endDate1;
//
//        createGUI();
//    }
//
//    private void createGUI() {
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setSize(500, 600);
//        setIconImage(Toolkit.getDefaultToolkit().getImage(REPORTVIEWER_UI.class.getResource("/images/LOGO-removebg-preview.png")));
//        setLocationRelativeTo(null);
//
//        contentPane = new JPanel(new BorderLayout());
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//
//        panel = new JPanel() {
//            @Override
//            public Dimension getPreferredSize() {
//                Dimension size = super.getPreferredSize();
//                size.width = 400; // Fixed width
//                size.height = Math.max(size.height, getParent().getHeight()); // Increase height as per parent
//                return size;
//            }
//        };
//        panel.setBackground(new Color(255, 255, 255));
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//
//        // Wrapper panel to keep the main panel centered
//        JPanel wrapperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
//        wrapperPanel.add(panel);
//
//        scrollPane = new JScrollPane(wrapperPanel);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//
//        lblNewLabel = new JLabel("");
//        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
//        panel.add(lblNewLabel);
//
//        JButton btnNewButton = new JButton("Save as PDF");
//        btnNewButton.setPreferredSize(new Dimension(100, 30)); // Set button size
//        btnNewButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                saveAsPDF();
//            }
//        });
//
//        contentPane.add(scrollPane, BorderLayout.CENTER);
//        contentPane.add(btnNewButton, BorderLayout.SOUTH);
//
//        showreport();
//        pack();
//        setVisible(true);
//    }
//
//    private void showreport() {
//        REPORTVIEW counter = new REPORTVIEW(start, end, Model, secondTableModel, fourthTableModel, fifthTableModel, thirdTableModel, sixthTableModel, seventhTableModel);
//        panel.add(counter.getPanel());
//        panel.revalidate();
//        panel.repaint();
//    }
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.*;
import java.time.LocalDate;

public class REPORTVIEWER_UI extends JFrame {

    private JPanel contentPane;
    private DefaultTableModel Model;
    private DefaultTableModel secondTableModel;
    private DefaultTableModel fourthTableModel;
    private DefaultTableModel thirdTableModel;
    private DefaultTableModel fifthTableModel;
    private DefaultTableModel sixthTableModel;
    private LocalDate start;
    private DefaultTableModel seventhTableModel;
    private LocalDate end;
    private JPanel panel;
    private JLabel lblNewLabel;
    private JScrollPane scrollPane;

    public REPORTVIEWER_UI(LocalDate startDate1, LocalDate endDate1, DefaultTableModel tableModel2, DefaultTableModel tableModel3, DefaultTableModel tableModel4, DefaultTableModel tableModel5, DefaultTableModel tableModel6, DefaultTableModel tableModel7, DefaultTableModel tableModel8) {
        this.Model = tableModel2;
        this.secondTableModel = tableModel3;
        this.fourthTableModel = tableModel4;
        this.fifthTableModel = tableModel5;
        this.thirdTableModel = tableModel6;
        this.sixthTableModel = tableModel7;
        this.seventhTableModel = tableModel8;
        this.start = startDate1;
        this.end = endDate1;

        createGUI();
    }

    private void createGUI() {
    	setTitle("SALES ANALYSIS REPORT");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 900);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setIconImage(Toolkit.getDefaultToolkit().getImage(REPORTVIEWER_UI.class.getResource("/images/LOGO-removebg-preview.png")));
        setLocationRelativeTo(null);

        contentPane = new JPanel(new GridBagLayout());
        
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width = 400; // Fixed width
                size.height = Math.max(size.height, getParent().getHeight()); // Increase height as per parent
                return size;
            }
        };
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Wrapper panel to keep the main panel centered
        JPanel wrapperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        wrapperPanel.setBackground(Color.GRAY); // Grey background color
        wrapperPanel.add(panel);

        scrollPane = new JScrollPane(wrapperPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        lblNewLabel = new JLabel("");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
        panel.add(lblNewLabel);

        JButton btnNewButton = new JButton("Save as PDF");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveAsPDF();
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(0, 0, 5, 0);
        contentPane.add(scrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPane.add(btnNewButton, gbc);

        showreport();
        pack();
        setVisible(true);
    }

    private void showreport() {
        REPORTVIEW counter = new REPORTVIEW(start, end, Model, secondTableModel, fourthTableModel, fifthTableModel, thirdTableModel, sixthTableModel, seventhTableModel);
        panel.add(counter.getPanel());
        panel.revalidate();
        panel.repaint();
    }

    private void saveAsPDF() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Save as PDF");

        PageFormat pageFormat = printerJob.defaultPage();
        Paper paper = new Paper();
        
        // Increase the paper height
        double paperWidth = 210.0 * 72 / 25.4; // Width of A4 paper in points (1 inch = 72 points, 1 inch = 25.4 mm)
        double paperHeight = 400.0 * 100 / 25.4; // New Height in points (Example: Increase height to 400 mm)
        
        paper.setSize(paperWidth, paperHeight);
        // Ensure the printable area is also set to the new size
        paper.setImageableArea(0, 0, paperWidth, paperHeight);
        
        pageFormat.setPaper(paper);
        pageFormat.setOrientation(PageFormat.PORTRAIT); // Set orientation to portrait

        // Debugging output to verify paper size settings
        System.out.println("Paper width: " + paper.getWidth());
        System.out.println("Paper height: " + paper.getHeight());
        System.out.println("Imageable width: " + paper.getImageableWidth());
        System.out.println("Imageable height: " + paper.getImageableHeight());

        printerJob.setPrintable(new Printable() {
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                Graphics2D g2d = (Graphics2D) graphics;

                // Calculate the number of pages needed
                int panelHeight = panel.getHeight();
                int panelWidth = panel.getWidth();
                double pageHeight = pageFormat.getImageableHeight();
                double pageWidth = pageFormat.getImageableWidth();
                double scaleFactor = pageWidth / panelWidth;
                int totalNumPages = (int) Math.ceil((panelHeight * scaleFactor) / pageHeight);

                if (pageIndex >= totalNumPages) {
                    return Printable.NO_SUCH_PAGE;
                }

                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                g2d.scale(scaleFactor, scaleFactor);
                g2d.translate(0, -pageIndex * (pageHeight / scaleFactor));
                
                panel.printAll(g2d);

                return Printable.PAGE_EXISTS;
            }
        }, pageFormat);

        boolean userAccepted = printerJob.printDialog();
        if (userAccepted) {
            try {
                printerJob.print();
                JOptionPane.showMessageDialog(null, "File Saved Successfully!", "Print Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }

}

