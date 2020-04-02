/*
This class is about everything related to writing to the Excel sheet(XML/xslx file)
 */
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeToXML {
    // A location used to write the new file to
    public static String FILE_LOCATION;

    public static void setFileLocation(String fileLocation) {
        FILE_LOCATION = fileLocation;
    }
    //A method for inputing into the given Excel sheet
    public static void inputIntoSheet(Object[][] data, XSSFSheet sheet, int rowCount, int columnCount){
        // Create a new row for each row of objects
        for (Object[] aBook : data) {
            Row row = sheet.createRow(++rowCount);

            int column = columnCount;
            // Create and fill a new cell for each object in row
            for (Object field : aBook) {
                Cell cell = row.createCell(++column);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

    }
    public static void addIntoRow(Object[][] data, XSSFSheet sheet, int rowCount, int columnCount){
        // Create a new row for each row of objects
        for (Object[] aBook : data) {
            Row row = sheet.getRow(++rowCount);

            int column = columnCount;
            // Create and fill a new cell for each object in row
            for (Object field : aBook) {
                Cell cell = row.createCell(++column);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
    }
    //The main method of the class, where everything comes together
    public static void writeInput(Object[][] bookData) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet 1");
        //Creating an object for the workers who have been assigned less than 40 hours
        int total_names = 0;
        Object[][] under_40hours = new Object[50][2];
        for (worker worker: Parser.workers){
            if (worker.getHours()<40){
                if (total_names>0){
                    under_40hours[total_names-1][0] = worker.getName().split(" ")[0]+worker.getName().split(" ")[1].charAt(0);
                    under_40hours[total_names-1][1] = worker.getHours();
                }
                total_names++;
            }
        }

        // Creating the row headers
        Object[][] timeSlots = {
                {"07-15"},
                {"15-23"},
                {"23-07"}
        };

        // Stage the changes
        // Schedule data
        inputIntoSheet(bookData, sheet, -1, 0);
        // Row headers
        addIntoRow(timeSlots, sheet, 0, -1);
        // Workers with less than 40 hours
        inputIntoSheet(under_40hours, sheet, 6, 0);

        // Formatting the sheet
        // Autosize the first 9 columns
        for (int i = 0; i < 8; i++) {
            sheet.autoSizeColumn(i);
        }


        // Write the changes to the specified file location
        try (FileOutputStream outputStream = new FileOutputStream(FILE_LOCATION)) {
            workbook.write(outputStream);
        }
    }

}
