import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class testReadFromExcel {

    public static void main(String[] args) throws IOException {
        List<worker> workers = new ArrayList<worker>();
        File myFile = new File("Graafikuseedija/src/Testing testing(1-24).xlsx");
        FileInputStream fis = new FileInputStream(myFile);

        // Finds the workbook instance for XLSX file
        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);

        // Return first sheet from the XLSX workbook
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);

        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = mySheet.iterator();

        // Traversing over each row of XLSX file
        Row row = rowIterator.next();
        while (rowIterator.hasNext()) {
            row = rowIterator.next();

            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            int id = 0;
            Cell cell = cellIterator.next();
            cell = cellIterator.next();
            cell = cellIterator.next();
            cell = cellIterator.next();
            cell = cellIterator.next();
            System.out.println(cell);
            workers.add(new worker(cell.getStringCellValue(), 0,"","","","","","",""));

            try {
                cell = cellIterator.next();
                System.out.println(cell.getCellTypeEnum());
                cell = cellIterator.next();
                System.out.println(cell.getCellTypeEnum());
                cell = cellIterator.next();
                System.out.println(cell.getCellTypeEnum());
                cell = cellIterator.next();
                System.out.println(cell.getCellTypeEnum());
                cell = cellIterator.next();
                System.out.println(cell.getCellTypeEnum());
                cell = cellIterator.next();
                System.out.println(cell.getCellTypeEnum());
                cell = cellIterator.next();
                System.out.println(cell.getCellTypeEnum());
            }catch (Exception e){
                System.out.println("error");
            }
            id++;
        }
        System.out.println(workers);
    }
}
