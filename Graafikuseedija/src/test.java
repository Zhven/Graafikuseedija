import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        if (args.length == 0){
            readFromXML.setFileName("Graafikuseedija/src/WS02-schedule-wishes-Jan-6th-12th_Sven.xlsx");
        }
        else{
            readFromXML.setFileName(args[0]);
        }
        writeToXML.writeInput(Parser.parse());
        /*
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                if (i>0){
                    System.out.println(s[i][j]);
                }

            }
        }

         */


    }
}
