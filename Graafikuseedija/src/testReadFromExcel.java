import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class testReadFromExcel {

    private static final String FILE_NAME = "Graafikuseedija/src/Testing testing(1-24).xlsx";

    public static void main(String[] args) throws IOException {
        List<worker> workers = new ArrayList<worker>();
        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = ((XSSFWorkbook) workbook).getSheetAt(0);
            int rowStart = Math.max(1, sheet.getFirstRowNum());
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
                workers.add(new worker(r.getCell(columnStart).getStringCellValue(), 0, "","","","","","","" ));

                int lastColumn = Math.max(columnEnd, columnStart);
                int j = 0;
                for (int cn = columnStart + 1; cn < lastColumn; cn++) {
                    Cell c = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
                    if (c == null) {
                        // The spreadsheet is empty in this cell
                        System.out.println("Empty cell");

                    } else {
                        // Do something useful with the cell's contents
                        System.out.println(c);

                    }
                    j++;
                }
                id++;
            }
        }catch (Exception e){
            System.out.println("error");
        }
        System.out.println(workers);
    }
}