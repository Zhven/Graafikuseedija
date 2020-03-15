import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class testReadFromExcel {
    public static void main(String[] args) throws IOException {

        File myFile = new File("Graafikuseedija/src/Testing testing(1-24).xlsx");
        FileInputStream fis = new FileInputStream(myFile);

        // Finds the workbook instance for XLSX file
        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);

        // Return first sheet from the XLSX workbook
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);

        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = mySheet.iterator();

        // Traversing over each row of XLSX file
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {


                Cell cell = cellIterator.next();
                int veerg = cell.getColumnIndex();
                if (veerg > 3){
                    worker blank = new worker(cell.getStringCellValue(), 0,"","","","","","","");
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING: System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        default :
                    }

                }


            }
            System.out.println();
        }


    }
}