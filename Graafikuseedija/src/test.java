import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        /*
        if (args.length == 0){
            readFromXML.setFileName("Graafikuseedija/src/Testing testing(1-24).xlsx");
        }
        else{
            readFromXML.setFileName(args[0]);
        }

         */

        readFromXML.setFileName("Graafikuseedija/src/Testing testing(1-24).xlsx");
        writeToXML.setFileLocation("graafik.xlsx");

        writeToXML.writeInput(Parser.parse());

    }
}
