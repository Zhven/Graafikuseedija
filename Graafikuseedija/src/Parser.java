import java.util.Random;

public class Parser {
    public static void main(String[] args) {
        Object[][] output = {
                {"Monday morning", "Tuesday morning", "Wednesday morning", "Thursday morning", "Friday morning", "Saturday morning", "Sunday morning"},
                {"Monday evening", "Tuesday evening", "Wednesday evening", "Thursday evening", "Friday evening", "Saturday evening", "Sunday evening"},
                {"Monday night", "Tuesday night", "Wednesday night", "Thursday night", "Friday night", "Saturday night", "Sunday night"}
        };
        //iterating through output object to assign workers to shifts
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                System.out.println(output[i][j]);

                StringBuilder shift = new StringBuilder();
                //generating randint
                Random r = new Random();
                int randint = r.nextInt((100 - 1) + 1) + 1;

                if (workers)
            }

        }


    }
}
