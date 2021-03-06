/*
Everything in this class is related to reading from the XML/xlsx file
 */
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class ReadFromXLSX {
    // Setting the file name
    public static String FILE_NAME;
    public static void setFileName(String fileName) {
        FILE_NAME = fileName;
    }
    //Main method that brings the class together.
    public static List<Worker> readInput(){
        List<Worker> workers = new ArrayList<>(); // Create a list for storing workers
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
                    //System.out.println(r.getCell(columnStart-1).getStringCellValue());
                    workers.add(new Worker(r.getCell(columnStart).getStringCellValue(), r.getCell(columnStart-1).getStringCellValue(), 0, 24, new String[7])); //create a worker with the name value
                }

                int day = 0;
                int lastColumn = Math.max(columnEnd, columnStart);
                for (int cn = columnStart + 1; cn < lastColumn; cn++) {
                    Cell c = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
                    if (c == null) {
                        // The spreadsheet is empty in this cell
                        if (cn>4){
                            workers.get(id).setDays(day, null); // Set the free shift requests for each worker
                            System.out.println(day);
                            System.out.println(workers.get(id).getDay(day));
                            day++;
                        }

                    }
                    /*
                    else if (c.getStringCellValue().contains("SM")) { //SM's free shifts follow a different logic, which was not in the scope of this project
                        // The worker is in SM position
                        workers.get(id).setSeniority("SM");
                        // Add the free shift requests of SM position workers
                        if (cn>4){
                            workers.get(id).setDays(day, c.getStringCellValue());
                            day++;
                        }
                    }
                     */

                    else {
                        if (cn>4){
                            workers.get(id).setDays(day, c.getStringCellValue()); // Set the free shift requests for each worker
                            System.out.println(day);
                            System.out.println(workers.get(id).getDay(day));
                            day++;
                        }
                    }
                }
                System.out.println(workers.get(id));
                id++;
            }
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Error reading data from file");;
        }
        /*
        for (worker worker:workers) {
            System.out.println(worker);

        }
         */
        return workers;
    }
}