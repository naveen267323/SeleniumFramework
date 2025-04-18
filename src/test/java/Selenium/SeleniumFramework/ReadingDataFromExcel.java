package Selenium.SeleniumFramework;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;

public class ReadingDataFromExcel {

	
//Excel--worbook--sheet--row--cell	

	
    public static void main(String[] args) throws IOException {
        // Dynamic file path for portability
        String filePath = System.getProperty("user.dir") + "\\testdata\\Book1.xlsx";
        FileInputStream inputfile = new FileInputStream(filePath);

        try (XSSFWorkbook workbook = new XSSFWorkbook(inputfile)) {
            XSSFSheet excelsheet = workbook.getSheet("Sheet1"); 

         //Get the total number of rows and column   
            int totalrow = excelsheet.getLastRowNum(); // to get the number of rows
            int totalcolumn = excelsheet.getRow(0).getLastCellNum(); // // to get the number of column

            System.out.println("Total Rows: " + totalrow);
            System.out.println("Total Columns: " + totalcolumn);
            System.out.println("--------------------------------");

            for (int i = 0; i <= totalrow; i++) {
                XSSFRow currentrow = excelsheet.getRow(i);
                if (currentrow == null) continue; // Skip empty rows

                for (int j = 0; j < totalcolumn; j++) {
                    XSSFCell currentcolumn = currentrow.getCell(j);
                    if (currentcolumn == null) {
                        System.out.print(" [Empty] "); 
                    } else {
                        System.out.print(currentcolumn.toString() + "  ");
                    }
                }
                System.out.println();
            }
        }
        
        
    }
}
