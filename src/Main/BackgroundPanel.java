package Main;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//public class SQLFileReader {
//    public static void main(String[] args) {
//        String directoryPath = "C:\\POS\\Invoice_Data\\Day_Wise";
//        String startDateStr = "10062024"; // ddMMyyyy
//        String endDateStr = "20062024";   // ddMMyyyy
//
//        try {
//            int rowCount = countRowsInDateRange(directoryPath, startDateStr, endDateStr);
//            System.out.println("Number of rows in date range: " + rowCount);
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static int countRowsInDateRange(String directoryPath, String startDateStr, String endDateStr) throws IOException, ParseException {
//        int rowCount = 0;
//        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
//        Date startDate = dateFormat.parse(startDateStr);
//        Date endDate = dateFormat.parse(endDateStr);
//
//        List<String> dateList = generateDateList(startDate, endDate, dateFormat);
//
//        for (String dateStr : dateList) {
//            String filePath = directoryPath + "/" + dateStr + ".sql";
//            rowCount += countRowsInFile(filePath);
//        }
//        return rowCount;
//    }
//
//    private static List<String> generateDateList(Date startDate, Date endDate, SimpleDateFormat dateFormat) {
//        List<String> dateList = new ArrayList<>();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(startDate);
//
//        while (!calendar.getTime().after(endDate)) {
//            dateList.add(dateFormat.format(calendar.getTime()));
//            calendar.add(Calendar.DATE, 1);
//        }
//
//        return dateList;
//    }
//
//    private static int countRowsInFile(String filePath) throws IOException {
//        int rowCount = 0;
//        String targetString = "INSERT INTO Invoices (invoice_number)";
//        
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                if (line.trim().contains(targetString)) {
//                    rowCount++;
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading file: " + filePath + " - " + e.getMessage());
//        }
//        return rowCount;
//    }
//}
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
    	GroupLayout groupLayout = new GroupLayout(this);
    	groupLayout.setHorizontalGroup(
    		groupLayout.createParallelGroup(Alignment.LEADING)
    			.addGap(0, 450, Short.MAX_VALUE)
    	);
    	groupLayout.setVerticalGroup(
    		groupLayout.createParallelGroup(Alignment.LEADING)
    			.addGap(0, 300, Short.MAX_VALUE)
    	);
    	setLayout(groupLayout);
        try {
            // Ensure the path is correct and image exists
            if (getClass().getResource(imagePath) != null) {
                backgroundImage = ImageIO.read(getClass().getResource(imagePath));
            } else {
                System.err.println("Image not found at: " + imagePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}


//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//public class SQLFileReader {
//    public static void main(String[] args) {
//        String[] productNames = {""};
////        		"Iced Lemon Tea","Iced Strawberry Tea","Iced Peach Tea","Lemoni","Cool Sky","Irish Berry","Cold Coffee","Cafe Mocha","Chocolate Milk Shake","Strawberry Milk Shake","Tea","Filter Coffee","Sweet Lassi","Butter Milk","Fresh Lime Soad"};
////
//        try (FileWriter writer = new FileWriter("C:\\POS\\Categorial_Data\\ExtrasData.sql")) {
//            writer.write("INSERT INTO products (name) VALUES \n");
//            for (int i = 0; i < productNames.length; i++) {
//                writer.write("'" + productNames[i] + "'");
//                if (i < productNames.length - 1) {
//                    writer.write(",\n");
//                } else {
//                    writer.write(";");
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error writing to file: " + e.getMessage());
//        }
//    }
//    	String sqlFile = "C:\\POS\\Categorial_Data\\MumbaiChaatData.sql";
//    
//    	String newElement = "'New Product'";
//
//    	try (BufferedReader reader = new BufferedReader(new FileReader(sqlFile));
//    	     FileWriter writer = new FileWriter("temp.sql")) {
//
//    	    String line;
//    	    boolean lastLine = false;
//    	    while ((line = reader.readLine())!= null) {
//    	        if (line.trim().endsWith(";")) {
//    	            lastLine = true;
//    	            line = line.substring(0, line.length() - 1) + ",";
//    	        }
//    	        writer.write(line + System.lineSeparator());
//    	    }
//
//    	    if (lastLine) {
//    	        writer.write(newElement + ";" + System.lineSeparator());
//    	    } else {
//    	        writer.write("INSERT INTO products VALUES" + newElement + ";" + System.lineSeparator());
//    	    }
//
//    	    System.out.println("New element inserted into SQL file");
//    	} catch (IOException e) {
//    	    System.err.println("Error modifying SQL file: " + e.getMessage());
//    	}
//
//    	// Replace the original file with the temporary file
//    	try {
//			Files.move(Paths.get("temp.sql"), Paths.get(sqlFile), StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
//}





//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//
//public class SQLFileReader extends JPanel {
//    private BufferedImage image;
//
//    public SQLFileReader(String imagePath) {
//        try {
//            image = ImageIO.read(new File(imagePath));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        if (image != null) {
//            // Draw the image, scaled to fit the panel
//            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
//        }
//    }
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 400);
//
//        SQLFileReader panel = new SQLFileReader("C:\\Users\\1234\\Downloads\\images.png");
//        frame.add(panel);
//
//        frame.setVisible(true);
//    }
//}

//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class SQLFileReader {
//
//    public static void main(String[] args) {
//        String filePath = "C:\\POS\\Categorial_Data\\SouthIndianData.sql";
//        ArrayList<String> productNames = new ArrayList<>();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            Pattern pattern = Pattern.compile("'(.*?)'");
//
//            while ((line = br.readLine()) != null) {
//                Matcher matcher = pattern.matcher(line);
//                while (matcher.find()) {
//                    productNames.add(matcher.group(1));
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Convert ArrayList to Array
//        String[] productArray = new String[productNames.size()];
//        productArray = productNames.toArray(productArray);
//
//        // Print the array to verify
//        for (String product : productArray) {
//            System.out.println(product);
//        }
//
//        // Example usage: Matching product names with tableModel1 and adding to tableModel2
//        // Assuming tableModel1 and tableModel2 are already defined and initialized
////        for (int j = 0; j < tableModel1.getRowCount(); j++) {
////            String productName = (String) tableModel1.getValueAt(j, 1);
////            for (String name : productArray) {
////                if (productName.equals(name)) {
////                    String quantity = (String) tableModel1.getValueAt(j, 3);
////                    String total = (String) tableModel1.getValueAt(j, 4);
////                    tableModel2.addRow(new Object[]{productName, quantity, total});
////                    break;
////                }
////            }
////        }
//    }
//}
