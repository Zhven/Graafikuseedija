import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;

public class Graafikuseedija {
    public static void main(String[] args) throws IOException {
        // Simplistic UI for choosing input file
        // Create file chooser
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        // Open file chooser dialog
        int returnValue = jfc.showOpenDialog(null);
        // If a file is chosen
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // Return the AbsolutePath of the selected file
            File selectedFile = jfc.getSelectedFile();
            ReadFromXSLX.setFileName(selectedFile.getAbsolutePath());

            // Open file save dialog
            int userSelection = jfc.showSaveDialog(null);
            // If a save location is chosen
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // Return the absolute path and continue with program
                File fileToSave = jfc.getSelectedFile();
                WriteToXLSX.setFileLocation(fileToSave.getAbsolutePath());
                WriteToXLSX.writeInput(Parser.parse());
            }

        } else {
            // If user cancels choosing a file then:
            System.out.println("No file was chosen. Exiting program");
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
}
