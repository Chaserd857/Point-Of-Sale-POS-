package Main;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JComboBox;

public class AddminPanelAddMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_1;
	private JButton btnNewButton_1 = new JButton("ADD MENU");
	private JButton btnNewButton_1_1 = new JButton("DELETE MENU");
	private JButton btnNewButton_1_1_1 = new JButton("BACK");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private DefaultTableModel tableModel;
	private static final String FILE_PATH = "C:\\POS\\Menu_Data\\menu_data.sql";
	private static final String FILE_PATH_NORMAL = "C:\\POS\\Menu_Data\\menu_data_withoutpanel.sql";
	private static final String FILE_PATH_PANEL = "C:\\POS\\Menu_Data\\menu_data_withpanel.sql";
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public AddminPanelAddMenu() {
		createGUI();
    }
    @SuppressWarnings("serial")
	private void createGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1250, 610);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Set to full size
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddminPanelAddMenu.class.getResource("/image/logo.png")));
//		setUndecorated(true);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setWheelScrollingEnabled(false);
		
		JLabel AVAILABILITY = new JLabel("Is this Item Available with Butter/Cheese?");
		AVAILABILITY.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_3 = new JLabel("ITEM NAME");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_4 = new JLabel("ITEM CODE");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_5 = new JLabel("ITEM RATE");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Yes");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		rdbtnNewRadioButton_2.setForeground(new Color(0, 0, 51));
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("No");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		rdbtnNewRadioButton_3.setForeground(new Color(0, 0, 51));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setDisabledTextColor(Color.BLACK);
		textField.setBorder(new LineBorder(new Color(171, 173, 179)));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setDisabledTextColor(Color.BLACK);
		textField_1.setBorder(new LineBorder(new Color(171, 173, 179)));
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setDisabledTextColor(Color.BLACK);
		textField_2.setBorder(new LineBorder(new Color(171, 173, 179)));
		textField_2.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("ADD");
		// Add ActionListener to "ADD" button
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Retrieve text from text fields and print them
						String itemName = textField.getText();
						String itemCode = textField_1.getText();
						String itemRate = textField_2.getText();
//						System.out.println("Item Name: " + itemName);
//						System.out.println("Item Code: " + itemCode);
//						System.out.println("Item Rate: " + itemRate);
						// Add the values to the table
						tableModel.addRow(new Object[] { itemName, itemCode, itemRate });
					}
				});
		
		JButton btnNewButton_3 = new JButton("CLEAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear the text fields
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("ITEM DETAILS");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton_4 = new JButton("Delete");
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) { // Check if a row is actually selected
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(selectedRow);
            }
			}
        });
		
		JLabel lblNewLabel_7 = new JLabel("PREVIEW");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_5 = new JButton("SUBMIT");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String selectedValue = (String) comboBox.getSelectedItem();
				if (selectedValue.equals("South Indian")) {
					String sqlFile = "C:\\POS\\Categorial_Data\\SouthIndianData.sql";
				    
					if(rdbtnNewRadioButton_2.isSelected()) {
			    	String newElement = "'"+textField.getText()+" .Regular'";

			    	try (BufferedReader reader = new BufferedReader(new FileReader(sqlFile));
			    	     FileWriter writer = new FileWriter("temp.sql")) {

			    	    String line;
			    	    boolean lastLine = false;
			    	    while ((line = reader.readLine())!= null) {
			    	        if (line.trim().endsWith(";")) {
			    	            lastLine = true;
			    	            line = line.substring(0, line.length() - 1) + ",";
			    	        }
			    	        writer.write(line + System.lineSeparator());
			    	    }

			    	    if (lastLine) {
			    	        writer.write(newElement + ";" + System.lineSeparator());
			    	    } else {
			    	        writer.write("INSERT INTO products VALUES" + newElement + ";" + System.lineSeparator());
			    	    }

			    	    System.out.println("New element inserted into SQL file");
			    	} catch (IOException e1) {
			    	    System.err.println("Error modifying SQL file: " + e1.getMessage());
			    	}

			    	// Replace the original file with the temporary file
			    	try {
						Files.move(Paths.get("temp.sql"), Paths.get(sqlFile), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			    	newElement = "'"+textField.getText()+" .Butter'";

			    	try (BufferedReader reader = new BufferedReader(new FileReader(sqlFile));
			    	     FileWriter writer = new FileWriter("temp.sql")) {

			    	    String line;
			    	    boolean lastLine = false;
			    	    while ((line = reader.readLine())!= null) {
			    	        if (line.trim().endsWith(";")) {
			    	            lastLine = true;
			    	            line = line.substring(0, line.length() - 1) + ",";
			    	        }
			    	        writer.write(line + System.lineSeparator());
			    	    }

			    	    if (lastLine) {
			    	        writer.write(newElement + ";" + System.lineSeparator());
			    	    } else {
			    	        writer.write("INSERT INTO products VALUES" + newElement + ";" + System.lineSeparator());
			    	    }

			    	    System.out.println("New element inserted into SQL file");
			    	} catch (IOException e1) {
			    	    System.err.println("Error modifying SQL file: " + e1.getMessage());
			    	}

			    	// Replace the original file with the temporary file
			    	try {
						Files.move(Paths.get("temp.sql"), Paths.get(sqlFile), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			    	newElement = "'"+textField.getText()+" .Cheese'";

			    	try (BufferedReader reader = new BufferedReader(new FileReader(sqlFile));
			    	     FileWriter writer = new FileWriter("temp.sql")) {

			    	    String line;
			    	    boolean lastLine = false;
			    	    while ((line = reader.readLine())!= null) {
			    	        if (line.trim().endsWith(";")) {
			    	            lastLine = true;
			    	            line = line.substring(0, line.length() - 1) + ",";
			    	        }
			    	        writer.write(line + System.lineSeparator());
			    	    }

			    	    if (lastLine) {
			    	        writer.write(newElement + ";" + System.lineSeparator());
			    	    } else {
			    	        writer.write("INSERT INTO products VALUES" + newElement + ";" + System.lineSeparator());
			    	    }

			    	    System.out.println("New element inserted into SQL file");
			    	} catch (IOException e1) {
			    	    System.err.println("Error modifying SQL file: " + e1.getMessage());
			    	}

			    	// Replace the original file with the temporary file
			    	try {
						Files.move(Paths.get("temp.sql"), Paths.get(sqlFile), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			    	newElement = "'"+textField.getText()+" .Ghee'";

			    	try (BufferedReader reader = new BufferedReader(new FileReader(sqlFile));
			    	     FileWriter writer = new FileWriter("temp.sql")) {

			    	    String line;
			    	    boolean lastLine = false;
			    	    while ((line = reader.readLine())!= null) {
			    	        if (line.trim().endsWith(";")) {
			    	            lastLine = true;
			    	            line = line.substring(0, line.length() - 1) + ",";
			    	        }
			    	        writer.write(line + System.lineSeparator());
			    	    }

			    	    if (lastLine) {
			    	        writer.write(newElement + ";" + System.lineSeparator());
			    	    } else {
			    	        writer.write("INSERT INTO products VALUES" + newElement + ";" + System.lineSeparator());
			    	    }

			    	    System.out.println("New element inserted into SQL file");
			    	} catch (IOException e1) {
			    	    System.err.println("Error modifying SQL file: " + e1.getMessage());
			    	}

			    	// Replace the original file with the temporary file
			    	try {
						Files.move(Paths.get("temp.sql"), Paths.get(sqlFile), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					}
					else {
						String newElement = "'"+textField.getText()+"'";

				    	try (BufferedReader reader = new BufferedReader(new FileReader(sqlFile));
				    	     FileWriter writer = new FileWriter("temp.sql")) {

				    	    String line;
				    	    boolean lastLine = false;
				    	    while ((line = reader.readLine())!= null) {
				    	        if (line.trim().endsWith(";")) {
				    	            lastLine = true;
				    	            line = line.substring(0, line.length() - 1) + ",";
				    	        }
				    	        writer.write(line + System.lineSeparator());
				    	    }

				    	    if (lastLine) {
				    	        writer.write(newElement + ";" + System.lineSeparator());
				    	    } else {
				    	        writer.write("INSERT INTO products VALUES" + newElement + ";" + System.lineSeparator());
				    	    }

				    	    System.out.println("New element inserted into SQL file");
				    	} catch (IOException e1) {
				    	    System.err.println("Error modifying SQL file: " + e1.getMessage());
				    	}

				    	// Replace the original file with the temporary file
				    	try {
							Files.move(Paths.get("temp.sql"), Paths.get(sqlFile), StandardCopyOption.REPLACE_EXISTING);
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				}
				if (selectedValue.equals("Mumbai Chaat")) {
					String sqlFile = "C:\\POS\\Categorial_Data\\MumbaiChaatData.sql";
				    
			    	String newElement = "'"+textField.getText()+"'";

			    	try (BufferedReader reader = new BufferedReader(new FileReader(sqlFile));
			    	     FileWriter writer = new FileWriter("temp.sql")) {

			    	    String line;
			    	    boolean lastLine = false;
			    	    while ((line = reader.readLine())!= null) {
			    	        if (line.trim().endsWith(";")) {
			    	            lastLine = true;
			    	            line = line.substring(0, line.length() - 1) + ",";
			    	        }
			    	        writer.write(line + System.lineSeparator());
			    	    }

			    	    if (lastLine) {
			    	        writer.write(newElement + ";" + System.lineSeparator());
			    	    } else {
			    	        writer.write("INSERT INTO products VALUES" + newElement + ";" + System.lineSeparator());
			    	    }

			    	    System.out.println("New element inserted into SQL file");
			    	} catch (IOException e1) {
			    	    System.err.println("Error modifying SQL file: " + e1.getMessage());
			    	}

			    	// Replace the original file with the temporary file
			    	try {
						Files.move(Paths.get("temp.sql"), Paths.get(sqlFile), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
				if (selectedValue.equals("Indian Veg.")) {
					String sqlFile = "C:\\POS\\Categorial_Data\\IndianVegData.sql";
				    
			    	String newElement = "'"+textField.getText()+"'";

			    	try (BufferedReader reader = new BufferedReader(new FileReader(sqlFile));
			    	     FileWriter writer = new FileWriter("temp.sql")) {

			    	    String line;
			    	    boolean lastLine = false;
			    	    while ((line = reader.readLine())!= null) {
			    	        if (line.trim().endsWith(";")) {
			    	            lastLine = true;
			    	            line = line.substring(0, line.length() - 1) + ",";
			    	        }
			    	        writer.write(line + System.lineSeparator());
			    	    }

			    	    if (lastLine) {
			    	        writer.write(newElement + ";" + System.lineSeparator());
			    	    } else {
			    	        writer.write("INSERT INTO products VALUES" + newElement + ";" + System.lineSeparator());
			    	    }

			    	    System.out.println("New element inserted into SQL file");
			    	} catch (IOException e1) {
			    	    System.err.println("Error modifying SQL file: " + e1.getMessage());
			    	}

			    	// Replace the original file with the temporary file
			    	try {
						Files.move(Paths.get("temp.sql"), Paths.get(sqlFile), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
				if (selectedValue.equals("Chinese Veg.")) {
					String sqlFile = "C:\\POS\\Categorial_Data\\ChineseVegData.sql";
				    
			    	String newElement = "'"+textField.getText()+"'";

			    	try (BufferedReader reader = new BufferedReader(new FileReader(sqlFile));
			    	     FileWriter writer = new FileWriter("temp.sql")) {

			    	    String line;
			    	    boolean lastLine = false;
			    	    while ((line = reader.readLine())!= null) {
			    	        if (line.trim().endsWith(";")) {
			    	            lastLine = true;
			    	            line = line.substring(0, line.length() - 1) + ",";
			    	        }
			    	        writer.write(line + System.lineSeparator());
			    	    }

			    	    if (lastLine) {
			    	        writer.write(newElement + ";" + System.lineSeparator());
			    	    } else {
			    	        writer.write("INSERT INTO products VALUES" + newElement + ";" + System.lineSeparator());
			    	    }

			    	    System.out.println("New element inserted into SQL file");
			    	} catch (IOException e1) {
			    	    System.err.println("Error modifying SQL file: " + e1.getMessage());
			    	}

			    	// Replace the original file with the temporary file
			    	try {
						Files.move(Paths.get("temp.sql"), Paths.get(sqlFile), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
				if (selectedValue.equals("Beverages")) {
					String sqlFile = "C:\\POS\\Categorial_Data\\BeveragesData.sql";
				    
			    	String newElement = "'"+textField.getText()+"'";

			    	try (BufferedReader reader = new BufferedReader(new FileReader(sqlFile));
			    	     FileWriter writer = new FileWriter("temp.sql")) {

			    	    String line;
			    	    boolean lastLine = false;
			    	    while ((line = reader.readLine())!= null) {
			    	        if (line.trim().endsWith(";")) {
			    	            lastLine = true;
			    	            line = line.substring(0, line.length() - 1) + ",";
			    	        }
			    	        writer.write(line + System.lineSeparator());
			    	    }

			    	    if (lastLine) {
			    	        writer.write(newElement + ";" + System.lineSeparator());
			    	    } else {
			    	        writer.write("INSERT INTO products VALUES" + newElement + ";" + System.lineSeparator());
			    	    }

			    	    System.out.println("New element inserted into SQL file");
			    	} catch (IOException e1) {
			    	    System.err.println("Error modifying SQL file: " + e1.getMessage());
			    	}

			    	// Replace the original file with the temporary file
			    	try {
						Files.move(Paths.get("temp.sql"), Paths.get(sqlFile), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
				if (selectedValue.equals("Combos")) {
					String sqlFile = "C:\\POS\\Categorial_Data\\CombosData.sql";
				    
			    	String newElement = "'"+textField.getText()+"'";

			    	try (BufferedReader reader = new BufferedReader(new FileReader(sqlFile));
			    	     FileWriter writer = new FileWriter("temp.sql")) {

			    	    String line;
			    	    boolean lastLine = false;
			    	    while ((line = reader.readLine())!= null) {
			    	        if (line.trim().endsWith(";")) {
			    	            lastLine = true;
			    	            line = line.substring(0, line.length() - 1) + ",";
			    	        }
			    	        writer.write(line + System.lineSeparator());
			    	    }

			    	    if (lastLine) {
			    	        writer.write(newElement + ";" + System.lineSeparator());
			    	    } else {
			    	        writer.write("INSERT INTO products VALUES" + newElement + ";" + System.lineSeparator());
			    	    }

			    	    System.out.println("New element inserted into SQL file");
			    	} catch (IOException e1) {
			    	    System.err.println("Error modifying SQL file: " + e1.getMessage());
			    	}

			    	// Replace the original file with the temporary file
			    	try {
						Files.move(Paths.get("temp.sql"), Paths.get(sqlFile), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
				if (selectedValue.equals("Extras")) {
					String sqlFile = "C:\\POS\\Categorial_Data\\ExtrasData.sql";
				    
			    	String newElement = "'"+textField.getText()+"'";

			    	try (BufferedReader reader = new BufferedReader(new FileReader(sqlFile));
			    	     FileWriter writer = new FileWriter("temp.sql")) {

			    	    String line;
			    	    boolean lastLine = false;
			    	    while ((line = reader.readLine())!= null) {
			    	        if (line.trim().endsWith(";")) {
			    	            lastLine = true;
			    	            line = line.substring(0, line.length() - 1) + ",";
			    	        }
			    	        writer.write(line + System.lineSeparator());
			    	    }

			    	    if (lastLine) {
			    	        writer.write(newElement + ";" + System.lineSeparator());
			    	    } else {
			    	        writer.write("INSERT INTO products VALUES" + newElement + ";" + System.lineSeparator());
			    	    }

			    	    System.out.println("New element inserted into SQL file");
			    	} catch (IOException e1) {
			    	    System.err.println("Error modifying SQL file: " + e1.getMessage());
			    	}

			    	// Replace the original file with the temporary file
			    	try {
						Files.move(Paths.get("temp.sql"), Paths.get(sqlFile), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
				
				
				String val=textField.getText();
				String val_1=textField_1.getText();
				String val_2=textField_2.getText();
				updateSQLFile(FILE_PATH,val,val_1,val_2);
				if(rdbtnNewRadioButton_2.isSelected())
					updateSQLFile(FILE_PATH_PANEL,val,val_1,val_2);
				else
					updateSQLFile(FILE_PATH_NORMAL,val,val_1,val_2);
				
				JOptionPane.showMessageDialog(null, "Menu added successfully", "", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JLabel lblNewLabel_4_1 = new JLabel("SELECT CATEGORY");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JList list = new JList();
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.addItem("South Indian");
		comboBox.addItem("Mumbai Chaat");
		comboBox.addItem("Indian Veg.");
		comboBox.addItem("Chinese Veg.");
		comboBox.addItem("Beverages");
		comboBox.addItem("Combos");
		comboBox.addItem("Extras");
		
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(89)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(btnNewButton_5, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(51)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4_1))))
					
					.addGap(100)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(234)
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.RELATED, 390, Short.MAX_VALUE)
					.addComponent(lblNewLabel_7)
					.addGap(218))
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
	                    .addGroup(gl_panel_2.createSequentialGroup()
	                            .addGap(70)
	                            .addComponent(AVAILABILITY)
	                            .addGap(13)
	                            .addComponent(rdbtnNewRadioButton_2)
	                            .addGap(37)
	                            .addComponent(rdbtnNewRadioButton_3)))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(15)
							.addComponent(lblNewLabel_7)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel_6)
							.addGap(27)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(44)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
				            		.addComponent(AVAILABILITY)
				                    .addComponent(rdbtnNewRadioButton_2)
				                    .addComponent(rdbtnNewRadioButton_3))
							.addGap(20)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_5, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))))
					.addComponent(btnNewButton_4)
					.addContainerGap(124, Short.MAX_VALUE))
		);
		String[] columnNames = {"ITEM NAME", "ITEM CODE", "ITEM RATE"};
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
		table.setRowHeight(20);
		
		scrollPane.setViewportView(table);
		panel_2.setLayout(gl_panel_2);
		
		btnNewButton_1 = new JButton("ADD MENU");
		btnNewButton_1.setBackground(Color.WHITE);
		
		btnNewButton_1_1 = new JButton("DELETE MENU");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanelDeleteMenu counter= new AdminPanelDeleteMenu();
				counter.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setBackground(Color.WHITE);
		
		btnNewButton_1_1_1 = new JButton("BACK");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel counter= new AdminPanel();
				counter.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setBackground(Color.WHITE);
		
		JButton btnNewButton_1_1_1_1 = new JButton("EDIT MENU ITEM");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanelEditMenuItemDetails counter= new AdminPanelEditMenuItemDetails();
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
						.addComponent(btnNewButton_1_1_1_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))))
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
		lblNewLabel.setIcon(createResizedIcon("/images/user-icon-2048x2048-ihoxz4vq-removebg-preview.png",110,110));
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN PANNEL");
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
            Image image = ImageIO.read(AddminPanelAddMenu.class.getResource(path));
            // Resize the image
            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            icon = new ImageIcon(resizedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return icon;
    }
    private void updateSQLFile(String filePath, String itemName, String newCode, String newRate) {
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
            lines.add("INSERT INTO INSERT INTO menu (item_name, item_code, price) VALUES ('" + itemName + "', '" + newCode + "', '" + newRate + "');");
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

    public JPanel getPanel() {
        return panel_1;
    }
}
