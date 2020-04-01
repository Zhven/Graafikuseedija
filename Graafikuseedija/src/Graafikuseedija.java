import java.io.IOException;
import java.util.List;

public class Graafikuseedija {
    public static void main(String[] args) throws IOException {
        /*
        if (args.length == 0){
            readFromXML.setFileName("Graafikuseedija/src/Testing testing(1-24).xlsx");
        }
        else{
            readFromXML.setFileName(args[0]);
        }

         */

        readFromXML.setFileName("Graafikuseedija/src/WS02-schedule-wishes-Jan-6th-12th_Sven.xlsx");


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

        writeToXML.setFileLocation("graafik.xlsx");
        writeToXML.writeInput(Parser.parse());

    }
}
