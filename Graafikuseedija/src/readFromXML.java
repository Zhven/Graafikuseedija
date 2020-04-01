import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class readFromXML {
    public static String FILE_NAME;

    public static void setFileName(String fileName) {
        FILE_NAME = fileName;
    }

    public static List<worker> readInput(){
        List<worker> workers = new ArrayList<>();
        try {
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
                    workers.add(new worker(r.getCell(columnStart).getStringCellValue(), 0, 0, 24, new String[7]));
                }

                int day = 0;
                int lastColumn = Math.max(columnEnd, columnStart);
                for (int cn = columnStart + 1; cn < lastColumn; cn++) {
                    Cell c = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
                    if (c == null) {
                        // The spreadsheet is empty in this cell

                    }
                    else if (c.getStringCellValue().contains("SM")) {
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
                            workers.get(id).setDays(day, c.getStringCellValue());
                            day++;
                        }
                    }
                }
                id++;
            }
        }catch (Exception e){
            System.out.println("error");
        }
        return workers;
    }
}