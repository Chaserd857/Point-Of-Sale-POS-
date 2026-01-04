package Main;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.io.BufferedReader;
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
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AdminPanel() {
		createGUI();
    }
    private void createGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1250, 610);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminPanel.class.getResource("/image/logo.png")));
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Set to full size
//		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 255));
		
//		JPanel panel_2 = new JPanel();
		 // Use the custom BackgroundPanel for panel_2
        BackgroundPanel panel_2 = new BackgroundPanel("");
        panel_2.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1259, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)))
		);
		
		JLabel lblNewLabel_3 = new JLabel("         ");
		lblNewLabel_3.setForeground(new Color(173, 216, 230));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(215, 234, 234));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(903, Short.MAX_VALUE)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(118)
					.addComponent(lblNewLabel_3)
					.addContainerGap(373, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnNewButton_1 = new JButton("MENU MANAGEMENT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddminPanelAddMenu counter= new AddminPanelAddMenu();
				counter.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		
		JButton btnNewButton_1_1 = new JButton("INVOICE MANAGEMENT");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanelInvoiceFormat counter= new AdminPanelInvoiceFormat();
				counter.setVisible(true);
				dispose();
			}
		});
		JButton btnNewButton_1_2 = new JButton("Export Menu");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// File path to the SQL file
				 // ArrayLists to store the data
		        ArrayList<String> itemNames = new ArrayList<>();
		        ArrayList<String> itemCodes = new ArrayList<>();
		        ArrayList<String> prices = new ArrayList<>();
		        
		        String filePath =  "C:\\POS\\Menu_Data\\menu_data.sql";

		        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
		            String line;
		            Pattern pattern = Pattern.compile("INSERT INTO menu \\(item_name, item_code, price\\) VALUES \\('([^']*)', '([^']*)', '([^']*)'\\);");

		            while ((line = reader.readLine()) != null) {
		                Matcher matcher = pattern.matcher(line);
		                if (matcher.find()) {
		                    String itemName = matcher.group(1);
		                    String itemCode = matcher.group(2);
		                    String price = matcher.group(3);
		                    itemNames.add(itemName);
		                    itemCodes.add(itemCode);
		                    prices.add(price);
		                   
		                }
		            }

		            System.out.println("Data has been successfully loaded into the JTable.");
		        } catch (IOException e2) {
		            e2.printStackTrace();
		        }
		     // Predefined file name
		        String predefinedFileName = "Menu_Data.csv";

		        // Use JFileChooser to get the user-specified location
		        JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setDialogTitle("Save CSV file");

		        // Set the predefined file name with .csv extension
		        fileChooser.setSelectedFile(new File(predefinedFileName));

		        // Restrict the file filter to .csv files only
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
		        fileChooser.setFileFilter(filter);

		        // Show save dialog; if approved, proceed to save the file
		        int userSelection = fileChooser.showSaveDialog(null);

		        if (userSelection == JFileChooser.APPROVE_OPTION) {
		            File fileToSave = fileChooser.getSelectedFile();

		            // Now write the data to the file
		            try (FileWriter writer = new FileWriter(fileToSave)) {
		                // Heading for Table 1
		               

		                // Write Table 1 header
		                writer.append("ITEM NAME,ITEM CODE,ITEM PRICE\n\n");

		                // Write Table 1 data rows
		                for (int i = 0; i < itemNames.size(); i++) {
		                	writer.append(itemNames.get(i)+","+itemCodes.get(i)+","+prices.get(i)+"\n");
		                }

		               
		                System.out.println("CSV file saved successfully at: " + fileToSave.getAbsolutePath());
		                JOptionPane.showMessageDialog(null, "Menu Exported Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
					       
		            } catch (IOException e2) {
		                e2.printStackTrace();
		            }
		        }
			}
		});
		JButton btnNewButton_1_G = new JButton("GENERATE INVOICE");
		btnNewButton_1_G.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADMINBILLGENERATE counter= new ADMINBILLGENERATE();
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
						.addComponent(btnNewButton_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
						.addComponent(btnNewButton_1_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
						.addComponent(btnNewButton_1_G, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
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
					.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_1_G, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(338, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(createResizedIcon("/images/user-icon-2048x2048-ihoxz4vq-removebg-preview.png",110,110));
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN PANEL");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
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
		contentPane.setLayout(gl_contentPane);
	}
    private static ImageIcon createResizedIcon(String path, int width, int height) {
        ImageIcon icon = null;
        try {
            // Load the image from classpath
            Image image = ImageIO.read(AdminPanel.class.getResource(path));
            // Resize the image
            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            icon = new ImageIcon(resizedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return icon;
    }
}
