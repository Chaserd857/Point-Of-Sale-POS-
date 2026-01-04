package Main;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class demo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel TableModel;
	private String label1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					demo frame = new demo();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public demo(DefaultTableModel Model,String label) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setIconImage(Toolkit.getDefaultToolkit().getImage(demo.class.getResource("/images/LOGO-removebg-preview.png")));
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.TableModel=Model;
		this.label1=label;
		GetReport();
		setContentPane(contentPane);
	}
 private void GetReport()
 {
	 DefaultTableModel tableModel2 = new DefaultTableModel();
	 tableModel2.addColumn("No");
	 tableModel2.addColumn("Name");
     tableModel2.addColumn("Quantity");
     JTable table2 = new JTable(tableModel2);
     JScrollPane scrollPane2 = new JScrollPane(table2);

     DefaultTableModel tableModel3 = new DefaultTableModel();
     tableModel3.addColumn("No");
     tableModel3.addColumn("Name");
     tableModel3.addColumn("Quantity");
     JTable table3 = new JTable(tableModel3);
     JScrollPane scrollPane3 = new JScrollPane(table3);
     
     DefaultTableModel tableModel4 = new DefaultTableModel();
     tableModel4.addColumn("No");
     tableModel4.addColumn("Name");
     tableModel4.addColumn("Quantity");
     JTable table4 = new JTable(tableModel4);
     JScrollPane scrollPane4 = new JScrollPane(table4);
     
     DefaultTableModel tableModel5 = new DefaultTableModel();
     tableModel5.addColumn("No");
     tableModel5.addColumn("Name");
     tableModel5.addColumn("Quantity");
     JTable table5 = new JTable(tableModel5);
     JScrollPane scrollPane5 = new JScrollPane(table5);

     DefaultTableModel tableModel6 = new DefaultTableModel();
     tableModel6.addColumn("No");
     tableModel6.addColumn("Name");
     tableModel6.addColumn("Quantity");
     JTable table6 = new JTable(tableModel6);
     JScrollPane scrollPane6 = new JScrollPane(table6);
     
     DefaultTableModel tableModel7 = new DefaultTableModel();
     tableModel7.addColumn("No");
     tableModel7.addColumn("Name");
     tableModel7.addColumn("Quantity");
     JTable table7 = new JTable(tableModel7);
     JScrollPane scrollPane7 = new JScrollPane(table7);
     
     DefaultTableModel tableModel8 = new DefaultTableModel();
     tableModel8.addColumn("No");
     tableModel8.addColumn("Name");
     tableModel8.addColumn("Quantity");
     JTable table8 = new JTable(tableModel8);
     JScrollPane scrollPane8 = new JScrollPane(table8);
     
//   ===================================== SOUTH INDIAN DATA ========================
   String SouthIndianfilePath = "C:\\POS\\Categorial_Data\\SouthIndianData.sql";
   ArrayList<String> SouthIndianproductNames = new ArrayList<>();

   try (BufferedReader br = new BufferedReader(new FileReader(SouthIndianfilePath))) {
       String line;
       Pattern pattern = Pattern.compile("'(.*?)'");

       while ((line = br.readLine()) != null) {
           Matcher matcher = pattern.matcher(line);
           while (matcher.find()) {
               SouthIndianproductNames.add(matcher.group(1));
           }
       }
   } catch (IOException e) {
       e.printStackTrace();
   }

   // Convert ArrayList to Array
   String[] SouthIndianproductArray = new String[SouthIndianproductNames.size()];
   SouthIndianproductArray = SouthIndianproductNames.toArray(SouthIndianproductArray);

//   String[] SouthproductNames = {"Upma", "Chennai Idli 2 Pcs", "Spl. Mini Idli 12pcs", "14 Ghee Idli", "Mini Medu Wada 2pcs", "Mini Medu Wada 4pcs", "Dal Wada 2pcs", "Dal Wada 4pcs", "Dahi Wada 4pcs", "Sada Dosa", "Mysore Sada Dosa", "Masala Dosa", "Rocket Mysore Dosa", "Mysore Masala Dosa", "Onion Masala Dosa", "Paneer Masala Dosa", "Paneer Onion Masala Dosa", "Maharaja Masala Dosa", "Prem Masala Dosa", "Harabhara Masala Dosa", "Navratna Masala Dosa", "Garlic Roast Dosa", "Pudy Roast Dos", "Prem Sada 4 Types Of Chatni", "Maharaja Sada Dosa", "Harabhara Sada", "Schezwan Sada", "Onion Sada Dosa", "Spring Roll Dosa", "Paneer Spring Roll", "Chinese Delight Dosa", "Paneer Chinese Delight Dosa", "American Chopsuey Dosa", "Paneer American Chopsuey Dosa", "Mushroom Chopsuey Dosa", "Paneer Chilly Dosa", "Schezwan Dosa", "Mushroom Schezwan Dosa", "Paneer Schezwan Dosa", "Capsium Schezwan Dosa", "Tom-Chi Dosa", "Chaap Dosa", "American Delight Dosa", "American Paneer Delight Dosa", "Salad Roast Dosa", "Paneer Salad Roast Dosa", "Mexican Roast Dosa", "Red Chilly Dosa", "Paneer Crispy Dosa", "Aloo Crispy Dosa", "Mexi Roll Dosa", "Salsa Lite", "Salsa Noodles Dosa", "Sizz-Lee Noodles Dosa", "Corn Mac 'N' Cheese Dosa", "Pasta Dosa", "Onion Delight", "Hot Garlic Mexican", "Chilly Delight", "Paper Roast Dosa", "Special Pream Paper Roast Dosa", "Mysore Uttappa", "Tom-Chi Uttappa", "Plain Uttappa", "Onion Uttappa", "Paneer Onion Uttappa", "Tomato Uttappa", "Masala Uttappa", "Sandwich Uttappa", "Spl. Pream Uttappa", "Paneer Special Prem Uttappa", "Spl. Spicy Uttappa", "Spl. Paneer Spicy Uttappa", "Idli Manchurian", "Idli Schezwan", "Idli Chilly", "Idli Cheese Manchurian", "Idli Paneer Manchurian", "Idli Fry", "Bisebelle Bhatt", "Thakkali Sadan", "Chitranna", "Dahi Rice", "Chickpea Rice", "Shahi Korma Rice", "Mini Lunch", "Chetinad Biryani"};
   int 	SOUTHROW=1;
   for (int j = 0; j < TableModel.getRowCount(); j++) {
       String productName = (String) TableModel.getValueAt(j, 1);
       for (String name : SouthIndianproductArray) {
           if (productName.equals(name)) {
               String quantity = (String) TableModel.getValueAt(j, 1);
               Object total = TableModel.getValueAt(j, 2);
               tableModel2.addRow(new Object[]{SOUTHROW++,quantity,total});
               break;
           }
           if (productName.contains("Corn")) {
               String quantity = (String) TableModel.getValueAt(j, 1);
               Object total = TableModel.getValueAt(j, 2);
               tableModel2.addRow(new Object[]{SOUTHROW++,quantity,total});
               break;
           }
           if (productName.equals("Mini Medu Wada 4pcs")) {
               String quantity = (String) TableModel.getValueAt(j, 1);
               Object total = TableModel.getValueAt(j, 2);
               tableModel2.addRow(new Object[]{productName,quantity,total});
               break;
           }
       }
   }
//   =====================================================================================
   String MumbaiChaatfilePath = "C:\\POS\\Categorial_Data\\MumbaiChaatData.sql";
   ArrayList<String> MumbaiChaatproductNames = new ArrayList<>();

   try (BufferedReader br = new BufferedReader(new FileReader(MumbaiChaatfilePath))) {
       String line;
       Pattern pattern = Pattern.compile("'(.*?)'");

       while ((line = br.readLine()) != null) {
           Matcher matcher = pattern.matcher(line);
           while (matcher.find()) {
               MumbaiChaatproductNames.add(matcher.group(1));
           }
       }
   } catch (IOException e) {
       e.printStackTrace();
   }

   // Convert ArrayList to Array
   String[] MumbaiChaatproductArray = new String[MumbaiChaatproductNames.size()];
   MumbaiChaatproductArray = MumbaiChaatproductNames.toArray(MumbaiChaatproductArray);
int MUMBAIROW=1;
//   String[] SouthproductNames = {"Upma", "Chennai Idli 2 Pcs", "Spl. Mini Idli 12pcs", "14 Ghee Idli", "Mini Medu Wada 2pcs", "Mini Medu Wada 4pcs", "Dal Wada 2pcs", "Dal Wada 4pcs", "Dahi Wada 4pcs", "Sada Dosa", "Mysore Sada Dosa", "Masala Dosa", "Rocket Mysore Dosa", "Mysore Masala Dosa", "Onion Masala Dosa", "Paneer Masala Dosa", "Paneer Onion Masala Dosa", "Maharaja Masala Dosa", "Prem Masala Dosa", "Harabhara Masala Dosa", "Navratna Masala Dosa", "Garlic Roast Dosa", "Pudy Roast Dos", "Prem Sada 4 Types Of Chatni", "Maharaja Sada Dosa", "Harabhara Sada", "Schezwan Sada", "Onion Sada Dosa", "Spring Roll Dosa", "Paneer Spring Roll", "Chinese Delight Dosa", "Paneer Chinese Delight Dosa", "American Chopsuey Dosa", "Paneer American Chopsuey Dosa", "Mushroom Chopsuey Dosa", "Paneer Chilly Dosa", "Schezwan Dosa", "Mushroom Schezwan Dosa", "Paneer Schezwan Dosa", "Capsium Schezwan Dosa", "Tom-Chi Dosa", "Chaap Dosa", "American Delight Dosa", "American Paneer Delight Dosa", "Salad Roast Dosa", "Paneer Salad Roast Dosa", "Mexican Roast Dosa", "Red Chilly Dosa", "Paneer Crispy Dosa", "Aloo Crispy Dosa", "Mexi Roll Dosa", "Salsa Lite", "Salsa Noodles Dosa", "Sizz-Lee Noodles Dosa", "Corn Mac 'N' Cheese Dosa", "Pasta Dosa", "Onion Delight", "Hot Garlic Mexican", "Chilly Delight", "Paper Roast Dosa", "Special Pream Paper Roast Dosa", "Mysore Uttappa", "Tom-Chi Uttappa", "Plain Uttappa", "Onion Uttappa", "Paneer Onion Uttappa", "Tomato Uttappa", "Masala Uttappa", "Sandwich Uttappa", "Spl. Pream Uttappa", "Paneer Special Prem Uttappa", "Spl. Spicy Uttappa", "Spl. Paneer Spicy Uttappa", "Idli Manchurian", "Idli Schezwan", "Idli Chilly", "Idli Cheese Manchurian", "Idli Paneer Manchurian", "Idli Fry", "Bisebelle Bhatt", "Thakkali Sadan", "Chitranna", "Dahi Rice", "Chickpea Rice", "Shahi Korma Rice", "Mini Lunch", "Chetinad Biryani"};

   for (int j = 0; j < TableModel.getRowCount(); j++) {
       String productName = (String) TableModel.getValueAt(j, 1);
       for (String name : MumbaiChaatproductArray) {
           if (productName.equals(name)) {
               String quantity = (String) TableModel.getValueAt(j, 1);
               Object total = TableModel.getValueAt(j, 2);
               tableModel3.addRow(new Object[]{MUMBAIROW++,quantity,total});
               break;
           }
       }
   }
//   ================================================================================================
   String IndianVegfilePath = "C:\\POS\\Categorial_Data\\IndianVegData.sql";
   ArrayList<String> IndianVegproductNames = new ArrayList<>();

   try (BufferedReader br = new BufferedReader(new FileReader(IndianVegfilePath))) {
       String line;
       Pattern pattern = Pattern.compile("'(.*?)'");

       while ((line = br.readLine()) != null) {
           Matcher matcher = pattern.matcher(line);
           while (matcher.find()) {
               IndianVegproductNames.add(matcher.group(1));
           }
       }
   } catch (IOException e) {
       e.printStackTrace();
   }

   // Convert ArrayList to Array
   String[] IndianVegproductArray = new String[IndianVegproductNames.size()];
   IndianVegproductArray = IndianVegproductNames.toArray(IndianVegproductArray);
int INDIANVEGROW=1;
//   String[] SouthproductNames = {"Upma", "Chennai Idli 2 Pcs", "Spl. Mini Idli 12pcs", "14 Ghee Idli", "Mini Medu Wada 2pcs", "Mini Medu Wada 4pcs", "Dal Wada 2pcs", "Dal Wada 4pcs", "Dahi Wada 4pcs", "Sada Dosa", "Mysore Sada Dosa", "Masala Dosa", "Rocket Mysore Dosa", "Mysore Masala Dosa", "Onion Masala Dosa", "Paneer Masala Dosa", "Paneer Onion Masala Dosa", "Maharaja Masala Dosa", "Prem Masala Dosa", "Harabhara Masala Dosa", "Navratna Masala Dosa", "Garlic Roast Dosa", "Pudy Roast Dos", "Prem Sada 4 Types Of Chatni", "Maharaja Sada Dosa", "Harabhara Sada", "Schezwan Sada", "Onion Sada Dosa", "Spring Roll Dosa", "Paneer Spring Roll", "Chinese Delight Dosa", "Paneer Chinese Delight Dosa", "American Chopsuey Dosa", "Paneer American Chopsuey Dosa", "Mushroom Chopsuey Dosa", "Paneer Chilly Dosa", "Schezwan Dosa", "Mushroom Schezwan Dosa", "Paneer Schezwan Dosa", "Capsium Schezwan Dosa", "Tom-Chi Dosa", "Chaap Dosa", "American Delight Dosa", "American Paneer Delight Dosa", "Salad Roast Dosa", "Paneer Salad Roast Dosa", "Mexican Roast Dosa", "Red Chilly Dosa", "Paneer Crispy Dosa", "Aloo Crispy Dosa", "Mexi Roll Dosa", "Salsa Lite", "Salsa Noodles Dosa", "Sizz-Lee Noodles Dosa", "Corn Mac 'N' Cheese Dosa", "Pasta Dosa", "Onion Delight", "Hot Garlic Mexican", "Chilly Delight", "Paper Roast Dosa", "Special Pream Paper Roast Dosa", "Mysore Uttappa", "Tom-Chi Uttappa", "Plain Uttappa", "Onion Uttappa", "Paneer Onion Uttappa", "Tomato Uttappa", "Masala Uttappa", "Sandwich Uttappa", "Spl. Pream Uttappa", "Paneer Special Prem Uttappa", "Spl. Spicy Uttappa", "Spl. Paneer Spicy Uttappa", "Idli Manchurian", "Idli Schezwan", "Idli Chilly", "Idli Cheese Manchurian", "Idli Paneer Manchurian", "Idli Fry", "Bisebelle Bhatt", "Thakkali Sadan", "Chitranna", "Dahi Rice", "Chickpea Rice", "Shahi Korma Rice", "Mini Lunch", "Chetinad Biryani"};

   for (int j = 0; j < TableModel.getRowCount(); j++) {
       String productName = (String) TableModel.getValueAt(j, 1);
       for (String name : IndianVegproductArray) {
           if (productName.equals(name)) {
               String quantity = (String) TableModel.getValueAt(j, 1);
               Object total = TableModel.getValueAt(j, 2);
               tableModel4.addRow(new Object[]{INDIANVEGROW++,quantity,total});
               break;
           }
       }
   }
//  =================================================================================================
   String BeveragesfilePath = "C:\\POS\\Categorial_Data\\BeveragesData.sql";
   ArrayList<String> BeveragesproductNames = new ArrayList<>();

   try (BufferedReader br = new BufferedReader(new FileReader(BeveragesfilePath))) {
       String line;
       Pattern pattern = Pattern.compile("'(.*?)'");

       while ((line = br.readLine()) != null) {
           Matcher matcher = pattern.matcher(line);
           while (matcher.find()) {
               BeveragesproductNames.add(matcher.group(1));
           }
       }
   } catch (IOException e) {
       e.printStackTrace();
   }
int BEVERAGESROW=1;
   // Convert ArrayList to Array
   String[] BeveragesproductArray = new String[BeveragesproductNames.size()];
   BeveragesproductArray = BeveragesproductNames.toArray(BeveragesproductArray);

//   String[] SouthproductNames = {"Upma", "Chennai Idli 2 Pcs", "Spl. Mini Idli 12pcs", "14 Ghee Idli", "Mini Medu Wada 2pcs", "Mini Medu Wada 4pcs", "Dal Wada 2pcs", "Dal Wada 4pcs", "Dahi Wada 4pcs", "Sada Dosa", "Mysore Sada Dosa", "Masala Dosa", "Rocket Mysore Dosa", "Mysore Masala Dosa", "Onion Masala Dosa", "Paneer Masala Dosa", "Paneer Onion Masala Dosa", "Maharaja Masala Dosa", "Prem Masala Dosa", "Harabhara Masala Dosa", "Navratna Masala Dosa", "Garlic Roast Dosa", "Pudy Roast Dos", "Prem Sada 4 Types Of Chatni", "Maharaja Sada Dosa", "Harabhara Sada", "Schezwan Sada", "Onion Sada Dosa", "Spring Roll Dosa", "Paneer Spring Roll", "Chinese Delight Dosa", "Paneer Chinese Delight Dosa", "American Chopsuey Dosa", "Paneer American Chopsuey Dosa", "Mushroom Chopsuey Dosa", "Paneer Chilly Dosa", "Schezwan Dosa", "Mushroom Schezwan Dosa", "Paneer Schezwan Dosa", "Capsium Schezwan Dosa", "Tom-Chi Dosa", "Chaap Dosa", "American Delight Dosa", "American Paneer Delight Dosa", "Salad Roast Dosa", "Paneer Salad Roast Dosa", "Mexican Roast Dosa", "Red Chilly Dosa", "Paneer Crispy Dosa", "Aloo Crispy Dosa", "Mexi Roll Dosa", "Salsa Lite", "Salsa Noodles Dosa", "Sizz-Lee Noodles Dosa", "Corn Mac 'N' Cheese Dosa", "Pasta Dosa", "Onion Delight", "Hot Garlic Mexican", "Chilly Delight", "Paper Roast Dosa", "Special Pream Paper Roast Dosa", "Mysore Uttappa", "Tom-Chi Uttappa", "Plain Uttappa", "Onion Uttappa", "Paneer Onion Uttappa", "Tomato Uttappa", "Masala Uttappa", "Sandwich Uttappa", "Spl. Pream Uttappa", "Paneer Special Prem Uttappa", "Spl. Spicy Uttappa", "Spl. Paneer Spicy Uttappa", "Idli Manchurian", "Idli Schezwan", "Idli Chilly", "Idli Cheese Manchurian", "Idli Paneer Manchurian", "Idli Fry", "Bisebelle Bhatt", "Thakkali Sadan", "Chitranna", "Dahi Rice", "Chickpea Rice", "Shahi Korma Rice", "Mini Lunch", "Chetinad Biryani"};

   for (int j = 0; j < TableModel.getRowCount(); j++) {
       String productName = (String) TableModel.getValueAt(j, 1);
       for (String name : BeveragesproductArray) {
           if (productName.equals(name)) {
               String quantity = (String) TableModel.getValueAt(j, 1);
               Object total =  TableModel.getValueAt(j, 2);
               tableModel5.addRow(new Object[]{BEVERAGESROW++,quantity,total});
               break;
           }
           
       }
   }
// =================================================================================================
  String ChineseVegfilePath = "C:\\POS\\Categorial_Data\\ChineseVegData.sql";
  ArrayList<String> ChineseVegproductNames = new ArrayList<>();

  try (BufferedReader br = new BufferedReader(new FileReader(ChineseVegfilePath))) {
      String line;
      Pattern pattern = Pattern.compile("'(.*?)'");

      while ((line = br.readLine()) != null) {
          Matcher matcher = pattern.matcher(line);
          while (matcher.find()) {
              ChineseVegproductNames.add(matcher.group(1));
          }
      }
  } catch (IOException e) {
      e.printStackTrace();
  }

  // Convert ArrayList to Array
  String[] ChineseVegproductArray = new String[ChineseVegproductNames.size()];
  ChineseVegproductArray = ChineseVegproductNames.toArray(ChineseVegproductArray);
int CHINESEVEGROW=1;
//  
  for (int j = 0; j < TableModel.getRowCount(); j++) {
      String productName = (String) TableModel.getValueAt(j, 1);
      for (String name : ChineseVegproductArray) {
          if (productName.equals(name)) {
              String quantity = (String) TableModel.getValueAt(j, 1);
              Object total = TableModel.getValueAt(j, 2);
              tableModel6.addRow(new Object[]{CHINESEVEGROW++,quantity,total});
              break;
          }
      }
  }
//=================================================================================================
 String CombosfilePath = "C:\\POS\\Categorial_Data\\CombosData.sql";
 ArrayList<String> CombosproductNames = new ArrayList<>();

 try (BufferedReader br = new BufferedReader(new FileReader(CombosfilePath))) {
     String line;
     Pattern pattern = Pattern.compile("'(.*?)'");

     while ((line = br.readLine()) != null) {
         Matcher matcher = pattern.matcher(line);
         while (matcher.find()) {
             CombosproductNames.add(matcher.group(1));
         }
     }
 } catch (IOException e) {
     e.printStackTrace();
 }
int COMBOSROW=1;
 // Convert ArrayList to Array
 String[] CombosproductArray = new String[CombosproductNames.size()];
 CombosproductArray = CombosproductNames.toArray(CombosproductArray);

// 
 for (int j = 0; j < TableModel.getRowCount(); j++) {
     String productName = (String) TableModel.getValueAt(j, 1);
     for (String name : CombosproductArray) {
         if (productName.equals(name)) {
             String quantity = (String) TableModel.getValueAt(j, 1);
             Object total = TableModel.getValueAt(j, 2);
             tableModel7.addRow(new Object[]{COMBOSROW++,quantity,total});
             break;
         }
     }
 }
//=================================================================================================
String ExtrasfilePath = "C:\\POS\\Categorial_Data\\ExtrasData.sql";
ArrayList<String> ExtrasproductNames = new ArrayList<>();

try (BufferedReader br = new BufferedReader(new FileReader(ExtrasfilePath))) {
    String line;
    Pattern pattern = Pattern.compile("'(.*?)'");

    while ((line = br.readLine()) != null) {
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            ExtrasproductNames.add(matcher.group(1));
        }
    }
} catch (IOException e) {
    e.printStackTrace();
}

// Convert ArrayList to Array
String[] ExtrasproductArray = new String[ExtrasproductNames.size()];
ExtrasproductArray = ExtrasproductNames.toArray(ExtrasproductArray);
int EXTRASROW=1;
//
for (int j = 0; j < TableModel.getRowCount(); j++) {
    String productName = (String) TableModel.getValueAt(j, 1);
    for (String name : ExtrasproductArray) {
        if (productName.equals(name)) {
            String quantity = (String) TableModel.getValueAt(j, 1);
            Object total = TableModel.getValueAt(j, 2);
            tableModel8.addRow(new Object[]{EXTRASROW++,quantity,total});
            break;
        }
    }
}
for (int row = 0; row < tableModel2.getRowCount(); row++) {
//    for (int col = 0; col < tableModel2.getColumnCount(); col++) 
	{
        System.out.print(tableModel2.getValueAt(row, 0) + " "+ tableModel2.getValueAt(row, 1)+" "+ tableModel2.getValueAt(row, 2));
    }
    System.out.println();
}
demo01 counter = new demo01(TableModel,label1);
//counter.setLocationRelativeTo(null);
//counter.setVisible(true);
//    	 
 }
}

