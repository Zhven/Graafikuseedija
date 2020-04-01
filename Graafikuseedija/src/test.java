import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Object[][] s = Parser.parse();
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                if (i>0){
                    System.out.println(s[i][j]);
                }

            }
        }
        writeToXML.writeInput(s);

    }
}
