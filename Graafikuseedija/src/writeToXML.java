
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeToXML {
    public static String FILE_LOCATION;

    public static void setFileLocation(String fileLocation) {
        FILE_LOCATION = fileLocation;
    }

    public static void writeInput(Object[][] bookData) throws IOException {


        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Shift");
        XSSFSheet sheet2 = workbook.createSheet("People with under 40 hours");

        int total_names = 0;
        Object[][] under_40hours = new Object[25][2];


        for (worker worker: Parser.workers){
            if (worker.getHours()<40){
                if (total_names>0){
                    under_40hours[total_names-1][0] = worker.getName().split(" ")[0];
                    under_40hours[total_names-1][1] = worker.getHours();
                }
                total_names++;
            }

        }

        int rowCount = 0;

        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);

            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
        rowCount ++;

        for (Object[] aBook : under_40hours) {
            Row row = sheet.createRow(++rowCount);

            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream outputStream = new FileOutputStream(FILE_LOCATION)) {
            workbook.write(outputStream);
        }
    }

}
