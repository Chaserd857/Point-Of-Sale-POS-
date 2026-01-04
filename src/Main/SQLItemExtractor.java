package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SQLItemExtractor {
	
	private static ArrayList<String> originalitemNames = new ArrayList<>();
	private static ArrayList<Integer> originalquantities = new ArrayList<>();
	private static ArrayList<Double> originalamounts = new ArrayList<>();
	private static Integer originalTotalQuantity=0;
	private static Double originalTotalAmount=0.00;
	
	
	private static ArrayList<String> choupsey = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\choupsey.sql");
	private static ArrayList<String> chooupseyitemNames = new ArrayList<>();
	private static ArrayList<Integer> chooupseyquantities = new ArrayList<>();
	private static ArrayList<Double> chooupseyamounts = new ArrayList<>();
	private static Integer choupseyQuantity=0;
	private static Double choupseyAmount=0.00;
	
	private static ArrayList<String> drinks = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\drinks.sql");
	private static ArrayList<String> drinksitemNames = new ArrayList<>();
	private static ArrayList<Integer> drinksquantities = new ArrayList<>();
	private static ArrayList<Double> drinksamounts = new ArrayList<>();
	private static Integer drinksQuantity=0;
	private static Double drinksAmount=0.00;
	
	private static ArrayList<String> extras = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\extras.sql");
	private static ArrayList<String> extrasitemNames = new ArrayList<>();
	private static ArrayList<Integer> extrasquantities = new ArrayList<>();
	private static ArrayList<Double> extrasamounts = new ArrayList<>();
	private static Integer extrasQuantity=0;
	private static Double extrasAmount=0.00;
	
	private static ArrayList<String> healthyuttappa = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\healthyuttappa.sql");
	private static ArrayList<String> healthyuttappaitemNames = new ArrayList<>();
	private static ArrayList<Integer> healthyuttappaquantities = new ArrayList<>();
	private static ArrayList<Double> healthyuttappaamounts = new ArrayList<>();
	private static Integer healthyuttappaQuantity=0;
	private static Double healthyuttappaAmount=0.00;
	
	private static ArrayList<String> hot = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\hot.sql");
	private static ArrayList<String> hotitemNames = new ArrayList<>();
	private static ArrayList<Integer> hotquantities = new ArrayList<>();
	private static ArrayList<Double> hotamounts = new ArrayList<>();
	private static Integer hotQuantity=0;
	private static Double hotAmount=0.00;
	
	private static ArrayList<String> idli = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\idli.sql");
	private static ArrayList<String> idliitemNames = new ArrayList<>();
	private static ArrayList<Integer> idliquantities = new ArrayList<>();
	private static ArrayList<Double> idliamounts = new ArrayList<>();
	private static Integer idliQuantity=0;
	private static Double idliAmount=0.00;
	
	private static ArrayList<String> indian = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\indian.sql");
	private static ArrayList<String> indianitemNames = new ArrayList<>();
	private static ArrayList<Integer> indianquantities = new ArrayList<>();
	private static ArrayList<Double> indianamounts = new ArrayList<>();
	private static Integer indianQuantity=0;
	private static Double indianAmount=0.00;
	
	private static ArrayList<String> mexican = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\mexican.sql");
	private static ArrayList<String> mexicanitemNames = new ArrayList<>();
	private static ArrayList<Integer> mexicanquantities = new ArrayList<>();
	private static ArrayList<Double> mexicanamounts = new ArrayList<>();
	private static Integer mexicanQuantity=0;
	private static Double mexicanAmount=0.00;
	
	private static ArrayList<String> mexican_uttappa = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\mexican_uttappa.sql");
	private static ArrayList<String> mexican_uttappaitemNames = new ArrayList<>();
	private static ArrayList<Integer> mexican_uttappaquantities = new ArrayList<>();
	private static ArrayList<Double> mexican_uttappaamounts = new ArrayList<>();
	private static Integer mexican_uttappaQuantity=0;
	private static Double mexican_uttappaAmount=0.00;
	
	private static ArrayList<String> packaging = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\packaging.sql");
	private static ArrayList<String> packagingitemNames = new ArrayList<>();
	private static ArrayList<Integer> packagingquantities = new ArrayList<>();
	private static ArrayList<Double> packagingamounts = new ArrayList<>();
	private static Integer packagingQuantity=0;
	private static Double packagingAmount=0.00;
	
	private static ArrayList<String> paper = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\paper.sql");
	private static ArrayList<String> paperitemNames = new ArrayList<>();
	private static ArrayList<Integer> paperquantities = new ArrayList<>();
	private static ArrayList<Double> paperamounts = new ArrayList<>();
	private static Integer paperQuantity=0;
	private static Double paperAmount=0.00;
	
	private static ArrayList<String> rice = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\rice.sql");
	private static ArrayList<String> riceitemNames = new ArrayList<>();
	private static ArrayList<Integer> ricequantities = new ArrayList<>();
	private static ArrayList<Double> riceamounts = new ArrayList<>();
	private static Integer riceQuantity=0;
	private static Double riceAmount=0.00;
	
	private static ArrayList<String> russian_salad = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\russian_salad.sql");
	private static ArrayList<String> russian_saladitemNames = new ArrayList<>();
	private static ArrayList<Integer> russian_saladquantities = new ArrayList<>();
	private static ArrayList<Double> russian_saladamounts = new ArrayList<>();
	private static Integer russian_saladQuantity=0;
	private static Double russian_saladAmount=0.00;
	
	private static ArrayList<String> Snacks = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\Snacks.sql");
	private static ArrayList<String> SnacksitemNames = new ArrayList<>();
	private static ArrayList<Integer> Snacksquantities = new ArrayList<>();
	private static ArrayList<Double> Snacksamounts = new ArrayList<>();
	private static Integer SnacksQuantity=0;
	private static Double SnacksAmount=0.00;
	
	private static ArrayList<String> specialuttappa = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\specialuttappa.sql");
	private static ArrayList<String> specialuttappaitemNames = new ArrayList<>();
	private static ArrayList<Integer> specialuttappaquantities = new ArrayList<>();
	private static ArrayList<Double> specialuttappaamounts = new ArrayList<>();
	private static Integer specialuttappaQuantity=0;
	private static Double specialuttappaAmount=0.00;
	
	private static ArrayList<String> spicy_plaza = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\spicy_plaza.sql");
	private static ArrayList<String> spicy_plazaitemNames = new ArrayList<>();
	private static ArrayList<Integer> spicy_plazaquantities = new ArrayList<>();
	private static ArrayList<Double> spicy_plazaamounts = new ArrayList<>();
	private static Integer spicy_plazaQuantity=0;
	private static Double spicy_plazaAmount=0.00;
	
	private static ArrayList<String> thali = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\thali.sql");
	private static ArrayList<String> thaliitemNames = new ArrayList<>();
	private static ArrayList<Integer> thaliquantities = new ArrayList<>();
	private static ArrayList<Double> thaliamounts = new ArrayList<>();
	private static Integer thaliQuantity=0;
	private static Double thaliAmount=0.00;
	
	private static ArrayList<String> thin = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\thin.sql");
	private static ArrayList<String> thinitemNames = new ArrayList<>();
	private static ArrayList<Integer> thinquantities = new ArrayList<>();
	private static ArrayList<Double> thinamounts = new ArrayList<>();
	private static Integer thinQuantity=0;
	private static Double thinAmount=0.00;

	private static ArrayList<String> Traditional = readSQLFile("C:\\POS\\SAMPLE_REPORT_DATA\\Traditional.sql");
	private static ArrayList<String> TraditionalitemNames = new ArrayList<>();
	private static ArrayList<Integer> Traditionalquantities = new ArrayList<>();
	private static ArrayList<Double> Traditionalamounts = new ArrayList<>();
	private static Integer TraditionalQuantity=0;
	private static Double TraditionalAmount=0.00;
	
	
    public static void main(String[] args) {
        // Get the current month in MM format
        String currentMonth = new SimpleDateFormat("MM").format(new Date());
        System.out.println("Current Month: " + currentMonth); // Debugging line

        // Specify the directory where the SQL files are located
        File folder = new File("C:\\POS\\Invoice_Data\\Complete"); // Replace with your actual directory path

        // List to store files that match the current month
        ArrayList<File> matchingFiles = new ArrayList<>();

        // Get all files in the directory
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();

                // Remove file extension if present
                String baseName = fileName.contains(".") ? fileName.substring(0, fileName.lastIndexOf('.')) : fileName;

                // Ensure file name follows ddMMyyyy format and is 8 characters long
                if (baseName.length() == 8 && baseName.matches("\\d{8}")) {
                    // Extract the month (characters 3 and 4)
                    String fileMonth = baseName.substring(2, 4);
                    System.out.println("File: " + baseName + ", Month: " + fileMonth); // Debugging line

                    // Check if the file's month matches the current month
                    if (fileMonth.equals(currentMonth)) {
                        matchingFiles.add(file);
                    }
                } else {
                    System.out.println("Skipped: " + fileName); // Debugging line for non-matching files
                }
            }
        } else {
            System.out.println("No files found in the specified directory."); // Debugging line
        }

        // Process the matching files
        if (!matchingFiles.isEmpty()) {
            System.out.println("Reading files with the current month:");
            for (File sqlFile : matchingFiles) {
                readSQLFileOrig(sqlFile);
            }
        } else {
            System.out.println("No files found for the current month.");
        }
//        // Print the extracted data
//        System.out.println("Item Names: " + originalitemNames);
//        System.out.println("Quantities: " + originalquantities);
//        System.out.println("Amounts: " + originalamounts);
        
        getchoupseydata();
        getdrinksdata();
        getextrasdata(); 
        gethealthyuttappadata();
        gethotdata();
        getidlidata();
        getindiandata();
        getmexicandata();
        getmexican_uttappadata();
        getpackagingdata();
        getpaperdata();
        getricedata();
        getrussian_saladdata();
        getspecialuttappadata();
        getSnacksdata();
        getspicy_plazadata();
        getthalidata();
        getthindata();

        getTraditionaldata();
        // Display the processed data
        for (int i = 0; i < originalitemNames.size(); i++) {
            originalTotalQuantity+=originalquantities.get(i) ;
            originalTotalAmount+=originalamounts.get(i);
        }
        Excelreport();
    }

    private static void readSQLFileOrig(File sqlFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(sqlFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Check for INSERT statement
                if (line.startsWith("INSERT INTO InvoiceDetails VALUES")) {
                    // Remove the "INSERT INTO InvoiceDetails VALUES" part and the parentheses
                    String valuesPart = line.substring(line.indexOf('(') + 1, line.lastIndexOf(')'));
                    // Split the values by comma and trim whitespace
                    String[] values = valuesPart.split(",");
                    for (int i = 0; i < values.length; i++) {
                        values[i] = values[i].trim().replace("'", ""); // Clean up values
                    }
                    // Extract the required fields
                    if (values.length >= 7) {
                        String itemName = values[3]; // Item name
                        int quantity = Integer.parseInt(values[5]); // Quantity
                        double amount = Double.parseDouble(values[6]); // Amount
                        
                        // Check if the item name already exists in the itemNames list
                        int index = originalitemNames.indexOf(itemName);
                        if (index != -1) {
                            // Item exists, update the quantity
                            originalquantities.set(index, originalquantities.get(index) + quantity);
                         // Update the amount if needed (you can decide how you want to handle this)
                            originalamounts.set(index, originalamounts.get(index) + amount);
                        } else {
                            // Item does not exist, add it to the lists
                            originalitemNames.add(itemName);
                            originalquantities.add(quantity);
                            originalamounts.add(amount); // You may want to handle amounts differently if needed
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + sqlFile.getName());
            e.printStackTrace();
        }
    }
    // Function to read the SQL file and return a list of product names
    public static ArrayList<String> readSQLFile(String filePath) {
        ArrayList<String> productNames = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isReadingValues = false;  // Flag to start reading after "VALUES"

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                line = line.trim();  // Trim whitespace

                // Start reading values after the "VALUES" keyword
                if (line.contains("VALUES")) {
                    isReadingValues = true;
                }

                // Stop reading when the semicolon is encountered (end of statement)
                if (line.endsWith(";")) {
                    isReadingValues = false;
                }

                // If we are reading values, extract the product names
                if (isReadingValues && !line.contains("VALUES")) {
                    // Remove any leading or trailing commas and single quotes
                    line = line.replace(",", "").replace("'", "").trim();

                    // Skip empty lines
                    if (!line.isEmpty()) {
                        productNames.add(line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productNames;  // Return the list of product names
    }
    private static void getchoupseydata() {
    	for(int i=0;i<originalitemNames.size();i++) {
    		String name = originalitemNames.get(i);
    		if(choupsey.contains(name)) {
    			chooupseyitemNames.add(name);
    			chooupseyquantities.add(originalquantities.get(i));
    			chooupseyamounts.add(originalamounts.get(i));
    			choupseyQuantity+=originalquantities.get(i);
    			choupseyAmount+=originalamounts.get(i);
    		}
    		
    	}
    }
    private static  void getspicy_plazadata() {
    for(int i=0;i<originalitemNames.size();i++) {
    	String name = originalitemNames.get(i);
    	if(spicy_plaza.contains(name)) {
    		spicy_plazaitemNames.add(name);
    		spicy_plazaquantities.add(originalquantities.get(i));
    		spicy_plazaamounts.add(originalamounts.get(i));
    		spicy_plazaQuantity+=originalquantities.get(i);
    		spicy_plazaAmount+=originalamounts.get(i);
    	}
    	
    }
    }
    private static void getindiandata() {
    	for(int i=0;i<originalitemNames.size();i++) {
    		String name = originalitemNames.get(i);
    		if(indian.contains(name)) {
    			indianitemNames.add(name);
    			indianquantities.add(originalquantities.get(i));
    			indianamounts.add(originalamounts.get(i));
    			indianQuantity+=originalquantities.get(i);
    			indianAmount+=originalamounts.get(i);
    		}
    		
    	}
    }
    private static void getpackagingdata() {
    	for(int i=0;i<originalitemNames.size();i++) {
    		String name = originalitemNames.get(i);
    		if(packaging.contains(name)) {
    			packagingitemNames.add(name);
    			packagingquantities.add(originalquantities.get(i));
    			packagingamounts.add(originalamounts.get(i));
    			packagingQuantity+=originalquantities.get(i);
    			packagingAmount+=originalamounts.get(i);
    		}
    		
    	}
    }

    private static void getspecialuttappadata() {
    	for(int i=0;i<originalitemNames.size();i++) {
    		String name = originalitemNames.get(i);
    		if(specialuttappa.contains(name)) {
    			specialuttappaitemNames.add(name);
    			specialuttappaquantities.add(originalquantities.get(i));
    			specialuttappaamounts.add(originalamounts.get(i));
    			specialuttappaQuantity+=originalquantities.get(i);
    			specialuttappaAmount+=originalamounts.get(i);
    		}
    		
    	}
    }
    private static void getSnacksdata() {
    	for(int i=0;i<originalitemNames.size();i++) {
    		String name = originalitemNames.get(i);
    		if(Snacks.contains(name)) {
    			SnacksitemNames.add(name);
    			Snacksquantities.add(originalquantities.get(i));
    			Snacksamounts.add(originalamounts.get(i));
    			SnacksQuantity+=originalquantities.get(i);
    			SnacksAmount+=originalamounts.get(i);
    		}
    		
    	}
    }
    private static void getdrinksdata() {
    	for(int i=0;i<originalitemNames.size();i++) {
    		String name = originalitemNames.get(i);
    		if(drinks.contains(name)) {
    			drinksitemNames.add(name);
    			drinksquantities.add(originalquantities.get(i));
    			drinksamounts.add(originalamounts.get(i));
    			drinksQuantity+=originalquantities.get(i);
    			drinksAmount+=originalamounts.get(i);
    		}
    		
    	}
    }

    private static void getpaperdata() {
    for(int i=0;i<originalitemNames.size();i++) {
    	String name = originalitemNames.get(i);
    	if(paper.contains(name)) {
    		paperitemNames.add(name);
    		paperquantities.add(originalquantities.get(i));
    		paperamounts.add(originalamounts.get(i));
    		paperQuantity+=originalquantities.get(i);
    		paperAmount+=originalamounts.get(i);
    	}
    	
    }
    }  
    private static void getricedata() {
    for(int i=0;i<originalitemNames.size();i++) {
    	String name = originalitemNames.get(i);
    	if(rice.contains(name)) {
    		riceitemNames.add(name);
    		ricequantities.add(originalquantities.get(i));
    		riceamounts.add(originalamounts.get(i));
    		riceQuantity+=originalquantities.get(i);
    		riceAmount+=originalamounts.get(i);
    	}
    	
    }
    }
    private static void getrussian_saladdata() {
        for(int i=0;i<originalitemNames.size();i++) {
        	String name = originalitemNames.get(i);
        	if(russian_salad.contains(name)) {
        		russian_saladitemNames.add(name);
        		russian_saladquantities.add(originalquantities.get(i));
        		russian_saladamounts.add(originalamounts.get(i));
        		russian_saladQuantity+=originalquantities.get(i);
    			russian_saladAmount+=originalamounts.get(i);
        	}
        	
        }
        } 
    private static void gethotdata() {
    	for(int i=0;i<originalitemNames.size();i++) {
    		String name = originalitemNames.get(i);
    		if(hot.contains(name)) {
    			hotitemNames.add(name);
    			hotquantities.add(originalquantities.get(i));
    			hotamounts.add(originalamounts.get(i));
    			hotQuantity+=originalquantities.get(i);
    			hotAmount+=originalamounts.get(i);
    		}
    		
    	}
    }

    private static void getthalidata() {
    	for(int i=0;i<originalitemNames.size();i++) {
    		String name = originalitemNames.get(i);
    		if(thali.contains(name)) {
    			thaliitemNames.add(name);
    			thaliquantities.add(originalquantities.get(i));
    			thaliamounts.add(originalamounts.get(i));
    			thaliQuantity+=originalquantities.get(i);
    			thaliAmount+=originalamounts.get(i);
    		}
    		
    	}
    }

    private static void getthindata() {
    	for(int i=0;i<originalitemNames.size();i++) {
    		String name = originalitemNames.get(i);
    		if(thin.contains(name)) {
    			thinitemNames.add(name);
    			thinquantities.add(originalquantities.get(i));
    			thinamounts.add(originalamounts.get(i));
    			thinQuantity+=originalquantities.get(i);
    			thinAmount+=originalamounts.get(i);
    		}
    		
    	}
    }
    	private static void getTraditionaldata() {
    	for(int i=0;i<originalitemNames.size();i++) {
    		String name = originalitemNames.get(i);
    		if(Traditional.contains(name)) {
    			TraditionalitemNames.add(name);
    			Traditionalquantities.add(originalquantities.get(i));
    			Traditionalamounts.add(originalamounts.get(i));
    			TraditionalQuantity+=originalquantities.get(i);
    			TraditionalAmount+=originalamounts.get(i);
    		}
    		
    	}
    }
    private static void getextrasdata() {
    	for(int i=0;i<originalitemNames.size();i++) {
    		String name = originalitemNames.get(i);
    		if(extras.contains(name)) {
    			extrasitemNames.add(name);
    			extrasquantities.add(originalquantities.get(i));
    			extrasamounts.add(originalamounts.get(i));
    			extrasQuantity+=originalquantities.get(i);
    			extrasAmount+=originalamounts.get(i);
    		}
    		
    	}
    }
    private static void gethealthyuttappadata() {
    	for(int i=0;i<originalitemNames.size();i++) {
    		String name = originalitemNames.get(i);
    		if(healthyuttappa.contains(name)) {
    			healthyuttappaitemNames.add(name);
    			healthyuttappaquantities.add(originalquantities.get(i));
    			healthyuttappaamounts.add(originalamounts.get(i));
    			healthyuttappaQuantity+=originalquantities.get(i);
    			healthyuttappaAmount+=originalamounts.get(i);
    		}
    		
    	}
    }
    private static void getmexicandata() {
    	for(int i=0;i<originalitemNames.size();i++) {
    		String name = originalitemNames.get(i);
    		if(mexican.contains(name)) {
    			mexicanitemNames.add(name);
    			mexicanquantities.add(originalquantities.get(i));
    			mexicanamounts.add(originalamounts.get(i));
    			mexicanQuantity+=originalquantities.get(i);
    			mexicanAmount+=originalamounts.get(i);
    		}
    		
    	}
    }
    private static void getmexican_uttappadata() {
    	for(int i=0;i<originalitemNames.size();i++) {
    		String name = originalitemNames.get(i);
    		if(mexican_uttappa.contains(name)) {
    			mexican_uttappaitemNames.add(name);
    			mexican_uttappaquantities.add(originalquantities.get(i));
    			mexican_uttappaamounts.add(originalamounts.get(i));
    			mexican_uttappaQuantity+=originalquantities.get(i);
    			mexican_uttappaAmount+=originalamounts.get(i);
    		}
    		
    	}
    }
    private static void getidlidata() {
    	for(int i=0;i<originalitemNames.size();i++) {
    		String name = originalitemNames.get(i);
    		if(idli.contains(name)) {
    			idliitemNames.add(name);
    			idliquantities.add(originalquantities.get(i));
    			idliamounts.add(originalamounts.get(i));
    			idliQuantity+=originalquantities.get(i);
    			idliAmount+=originalamounts.get(i);
    		}
    		
    	}
    }
    private static void Excelreport() {
   	 
    	 // Heading for Table 1
    	// Get the current date
        LocalDate today = LocalDate.now();

        // Get the start of the month
        LocalDate startOfMonth = today.withDayOfMonth(1);

        // Get the end of the month
        LocalDate endOfMonth = today.withDayOfMonth(today.lengthOfMonth());
        String monthName = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        // Get the current year in "yyyy" format
        int year = today.getYear();
        
        // Define a date formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
     // Get the current date and time
        LocalDateTime current = LocalDateTime.now();
        // Define the desired format
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm");

        // Format the current date and time
        String formatted1 = current.format(formatter1);
        

    	  // Specify the custom location where you want to save the CSV file
        String customFilePath = "C:\\POS\\Monthly_Report\\"+monthName+"-"+year+".csv"; // Change this to your desired location


            // Now write the data to the specified file
            try (FileWriter writer = new FileWriter(customFilePath)) {
               
                // Print the dates
                System.out.println("Start of Month: " + startOfMonth.format(formatter));
                System.out.println("Today's Date: " + today.format(formatter));
                System.out.println("End of Month: " + endOfMonth.format(formatter));
                
                writer.append("------------------------DOSA PLAZA------------------------\n");
                writer.append("Monthly Report - "+startOfMonth.format(formatter)+"-"+endOfMonth.format(formatter)+"\n\n");
                writer.append("Last Updated:  "+today.format(formatter)+"  "+formatted1+" \n\n");
                writer.append("\n");
                writer.append("Category,Item,Code,Qty.,Total(Rs)\n");
                writer.append("\n");
                
                // Write Table 1 header
                writer.append("Snacks\n");
               
                // Write Table 1 data rows
                for (int i = 0; i < SnacksitemNames.size() ; i++) {
               	 writer.append(""+","+SnacksitemNames.get(i)+","+","+Snacksquantities.get(i)+","+Snacksamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + SnacksQuantity + ","+SnacksAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");
                
                // Write Table 1 header
                writer.append("Tradiitional Masala Plaza\n");
               
                // Write Table 1 data rows
                for (int i = 0; i < TraditionalitemNames.size() ; i++) {
               	 writer.append(""+","+TraditionalitemNames.get(i)+","+","+Traditionalquantities.get(i)+","+Traditionalamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + TraditionalQuantity + ","+TraditionalAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");
                
                // Write Table 1 header
                writer.append("Thin & Crispy Dosas\n");	
                // Write Table 1 data rows
                for (int i = 0; i < thinitemNames.size() ; i++) {
               	 writer.append(""+","+thinitemNames.get(i)+","+","+thinquantities.get(i)+","+thinamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + thinQuantity + ","+thinAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");
                
                // Write Table 1 header
                writer.append("Chopsuey Plaza\n");
                // Write Table 1 data rows
                for (int i = 0; i < chooupseyitemNames.size() ; i++) {
               	 writer.append(""+","+chooupseyitemNames.get(i)+","+","+chooupseyquantities.get(i)+","+chooupseyamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + choupseyQuantity + ","+choupseyAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");
                
                
                // Write Table 1 header
                writer.append("Spicy Plaza\n");
                // Write Table 1 data rows
                for (int i = 0; i < spicy_plazaitemNames.size() ; i++) {
               	 writer.append(""+","+spicy_plazaitemNames.get(i)+","+","+spicy_plazaquantities.get(i)+","+spicy_plazaamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + spicy_plazaQuantity + ","+spicy_plazaAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");
                
                // Write Table 1 header
                writer.append("Mexican Style Dosas\n");
                // Write Table 1 data rows
                for (int i = 0; i < mexicanitemNames.size() ; i++) {
               	 writer.append(""+","+mexicanitemNames.get(i)+","+","+mexicanquantities.get(i)+","+mexicanamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + mexicanQuantity + ","+mexicanAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");
                
                // Write Table 1 header
                writer.append("Mexican Uttappas\n");
                // Write Table 1 data rows
                for (int i = 0; i < mexican_uttappaitemNames.size() ; i++) {
               	 writer.append(""+","+mexican_uttappaitemNames.get(i)+","+","+mexican_uttappaquantities.get(i)+","+mexican_uttappaamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + mexican_uttappaQuantity + ","+mexican_uttappaAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");
                
                // Write Table 1 header
                writer.append("Paper Plaza\n");
                // Write Table 1 data rows
                for (int i = 0; i < paperitemNames.size() ; i++) {
               	 writer.append(""+","+paperitemNames.get(i)+","+","+paperquantities.get(i)+","+paperamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + paperQuantity + ","+paperAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");
                
                // Write Table 1 header
                writer.append("Healthy Uttappas\n");
                // Write Table 1 data rows
                for (int i = 0; i < healthyuttappaitemNames.size() ; i++) {
               	 writer.append(""+","+healthyuttappaitemNames.get(i)+","+","+healthyuttappaquantities.get(i)+","+healthyuttappaamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + healthyuttappaQuantity + ","+healthyuttappaAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");
                
                // Write Table 1 header
                writer.append("Special Uttappas\n");
                // Write Table 1 data rows
                for (int i = 0; i < specialuttappaitemNames.size() ; i++) {
               	 writer.append(""+","+specialuttappaitemNames.get(i)+","+","+specialuttappaquantities.get(i)+","+specialuttappaamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + specialuttappaQuantity + ","+specialuttappaAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");	
                
                // Write Table 1 header
                writer.append("Chinnese Style Idli\n");
                // Write Table 1 data rows
                for (int i = 0; i < idliitemNames.size() ; i++) {
               	 writer.append(""+","+idliitemNames.get(i)+","+","+idliquantities.get(i)+","+idliamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + idliQuantity + ","+idliAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");
                
                // Write Table 1 header
                writer.append("Rice Plaza\n");
                // Write Table 1 data rows
                for (int i = 0; i < riceitemNames.size() ; i++) {
               	 writer.append(""+","+riceitemNames.get(i)+","+","+ricequantities.get(i)+","+riceamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + riceQuantity + ","+riceAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");
                
                // Write Table 1 header
                writer.append("SOFT DRINKS\n");
                // Write Table 1 data rows
                for (int i = 0; i < drinksitemNames.size() ; i++) {
               	 writer.append(""+","+drinksitemNames.get(i)+","+","+drinksquantities.get(i)+","+drinksamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + drinksQuantity + ","+drinksAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");
                
                // Write Table 1 header
                writer.append("Russian Salad Dosas\n");
                // Write Table 1 data rows
                for (int i = 0; i < russian_saladitemNames.size() ; i++) {
               	 writer.append(""+","+russian_saladitemNames.get(i)+","+","+russian_saladquantities.get(i)+","+russian_saladamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + russian_saladQuantity + ","+russian_saladAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");
                
                // Write Table 1 header
                writer.append("Indian Style Dosas\n");
                // Write Table 1 data rows
                for (int i = 0; i < indianitemNames.size() ; i++) {
               	 writer.append(""+","+indianitemNames.get(i)+","+","+indianquantities.get(i)+","+indianamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + indianQuantity + ","+indianAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");
                
                // Write Table 1 header
                writer.append("Thali Items\n");
                // Write Table 1 data rows
                for (int i = 0; i < thaliitemNames.size() ; i++) {
               	 writer.append(""+","+thaliitemNames.get(i)+","+","+thaliquantities.get(i)+","+thaliamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + thaliQuantity + ","+thaliAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");
                
                // Write Table 1 header
                writer.append("Hot & Cold\n");
                // Write Table 1 data rows
                for (int i = 0; i < hotitemNames.size() ; i++) {
               	 writer.append(""+","+hotitemNames.get(i)+","+","+hotquantities.get(i)+","+hotamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + hotQuantity + ","+hotAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");
                
                // Write Table 1 header
                writer.append("Packing Charges\n");
                // Write Table 1 data rows
                for (int i = 0; i < packagingitemNames.size() ; i++) {
               	 writer.append(""+","+packagingitemNames.get(i)+","+","+packagingquantities.get(i)+","+packagingamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + packagingQuantity + ","+packagingAmount +"\n");

                // Add a blank line before the next table
                writer.append("\n");
                
                // Write Table 1 header
                writer.append("Extras\n");
                // Write Table 1 data rows
                for (int i = 0; i < extrasitemNames.size() ; i++) {
               	 writer.append(""+","+extrasitemNames.get(i)+","+","+extrasquantities.get(i)+","+extrasamounts.get(i)+"\n");
                }
                writer.append("\n");
                writer.append("Sub Total,,," + extrasQuantity + ","+extrasAmount +"\n");
                writer.append("\n");
                writer.append("**OVERALL**\n");
                writer.append(",,," + "Total Quantity" + ","+"Total Amount" +"\n");
                writer.append("Sub-Total,,," + originalTotalQuantity + ","+originalTotalAmount +"\n");
                writer.append("Tax(5%),,," + "" + ","+String.format("%.2f",originalTotalAmount*0.05) +"\n");
                writer.append("Grand Total,,," + "" + ","+String.format("%.0f",(originalTotalAmount+(originalTotalAmount*0.05))) +"\n");
                // Add a blank line before the next table
                writer.append("\n");
               

                System.out.println("CSV file saved successfully at: " + customFilePath);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
   
}
