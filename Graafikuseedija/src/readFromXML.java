/*
Everything in this class is related to reading from the XML/xlsx file
 */
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class readFromXML {
    // Setting the file name
    public static String FILE_NAME;
    public static void setFileName(String fileName) {
        FILE_NAME = fileName;
    }
    //Main method that brings the class together.
    public static List<worker> readInput(){
        List<worker> workers = new ArrayList<>(); // Create a list for storing workers
        try { // Open the file and start iterating through it starting from the given coordinates
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            int rowStart = Math.max(0, sheet.getFirstRowNum());
            int rowEnd = Math.max(100, sheet.getLastRowNum());
            int columnStart = 4;
            int columnEnd = 12;
            int id = 0;
            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                Row r = sheet.getRow(rowNum);
                if (r == null) {
                    // This whole row is empty or includes SM
                    // Handle it as needed
                    break;
                }

                if (!r.getCell(columnStart).getStringCellValue().equals("")){
                    workers.add(new worker(r.getCell(columnStart).getStringCellValue(), 0, 0, 24, new String[7])); //create a worker with the name value
                }

                int day = 0;
                int lastColumn = Math.max(columnEnd, columnStart);
                for (int cn = columnStart + 1; cn < lastColumn; cn++) {
                    Cell c = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
                    if (c == null) {
                        // The spreadsheet is empty in this cell

                    }
                    else if (c.getStringCellValue().contains("SM")) { //SM's free shifts follow a different logic, which was not in the scope of this project
                        // The worker is in SM position
                        workers.get(id).setSeniority(9);
                        // Add the free shift requests of SM position workers
                        if (cn>4){
                            workers.get(id).setDays(day, c.getStringCellValue());
                            day++;
                        }
                    }

                    else {
                        if (cn>4){
                            workers.get(id).setDays(day, c.getStringCellValue()); // Set the free shift requests for each worker
                            day++;
                        }
                    }
                }
                id++;
            }
        }catch (Exception e){
            System.out.println("An error occured while reading data from the file");
        }
        /*
        for (worker worker:workers) {
            System.out.println(worker);

        }
         */
        return workers;
    }
}