import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class readFromXML {
    private static final String FILE_NAME = "Graafikuseedija/src/WS02-schedule-wishes-Jan-6th-12th_Sven.xlsx";

    public static List<worker> readInput(){
        List<worker> workers = new ArrayList<worker>();
        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = ((XSSFWorkbook) workbook).getSheetAt(0);
            int rowStart = Math.max(0, sheet.getFirstRowNum());
            int rowEnd = Math.max(100, sheet.getLastRowNum());
            int columnStart = 4;
            int columnEnd = 12;
            int id = 0;
            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                Row r = sheet.getRow(rowNum);
                if (r == null) {
                    // This whole row is empty
                    // Handle it as needed
                    break;
                }
                workers.add(new worker(r.getCell(columnStart).getStringCellValue(), 0, 0, 24, "","","","","","","" ));

                int lastColumn = Math.max(columnEnd, columnStart);
                for (int cn = columnStart + 1; cn < lastColumn; cn++) {
                    Cell c = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
                    if (c == null) {
                        // The spreadsheet is empty in this cell
                        //System.out.println("Empty cell");

                    } else {
                        // Do something useful with the cell's contents
                        switch (cn){
                            case 5:
                                workers.get(id).setMonday(c.getStringCellValue());
                                break;
                            case 6:
                                workers.get(id).setTuesday(c.getStringCellValue());
                                break;
                            case 7:
                                workers.get(id).setWednesday(c.getStringCellValue());
                                break;
                            case 8:
                                workers.get(id).setThursday(c.getStringCellValue());
                                break;
                            case 9:
                                workers.get(id).setFriday(c.getStringCellValue());
                                break;
                            case 10:
                                workers.get(id).setSaturday(c.getStringCellValue());
                                break;
                            case 11:
                                workers.get(id).setSunday(c.getStringCellValue());
                                break;
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