package Main;
import java.io.*;
import java.util.regex.*;

public class SQLToCSV {
    public static void main(String[] args) {
        // Input SQL file and output CSV file paths
        String sqlFilePath = "C:\\POS\\Menu_Data\\menu_data.sql";  // Replace with your actual file path
        String csvFilePath = "menu.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath));
             FileWriter csvWriter = new FileWriter(csvFilePath)) {

            // Write the header for the CSV file
            csvWriter.append("Item Name,Price,Tax,Amount\n");

            // Regular expression to match the required values from the SQL file (excluding item_code)
            String regex = "VALUES \\('([^']*)',\\s*'[^']*',\\s*'([^']*)'\\)";
            Pattern pattern = Pattern.compile(regex);

            String line;
            while ((line = reader.readLine()) != null) {
                // Match the line against the regex
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    // Extract item_name and price from the SQL insert statement
                    String itemName = matcher.group(1);
                    double price = Double.parseDouble(matcher.group(2));

                    // Calculate tax and amount
                    double tax = 0.05 * price;
                    double amount = price + tax;

                    // Write to the CSV file
                    csvWriter.append(itemName).append(',')
                             .append(String.format("%.6f", price)).append(',')
                             .append(String.format("%.6f", tax)).append(',')
                             .append(String.format("%.0f", amount)).append('\n');
                }
            }

            System.out.println("Data has been written to " + csvFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
