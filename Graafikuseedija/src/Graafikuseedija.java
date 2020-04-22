import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Graafikuseedija {
    public static void main(String selectedFile, String fileToSave) throws IOException {

            ReadFromXSLX.setFileName(selectedFile);
            WriteToXLSX.setFileLocation(fileToSave);
            WriteToXLSX.writeInput(Parser.parse());
            }


        //readFromXML.setFileName("Graafikuseedija/src/WS02-schedule-wishes-Jan-6th-12th_Sven.xlsx");


        /*
        List<worker> workers = readFromXML.readInput();
        for (worker worker: workers){
            System.out.print(worker.getName()+" ");
            for (String day: worker.getDays()){
                System.out.print(day +" ");
            }
            System.out.println();
        }

         */



}
