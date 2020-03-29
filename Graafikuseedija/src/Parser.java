import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Parser {
    public static void main(String[] args) {

        List<worker> workers = readFromXML.readInput();
        Object[][] output = {
                {"Monday morning", "Monday evening", "Monday night"},
                {"Tuesday morning", "Tuesday evening", "Tuesday night"},
                {"Wednesday morning", "Wednesday evening", "Wednesday night"},
                {"Thursday morning", "Thursday evening", "Thursday night"},
                {"Friday morning", "Friday evening", "Friday night"},
                {"Saturday morning", "Saturday evening", "Saturday night"},
                {"Sunday morning", "Sunday evening", "Sunday night"},
        };

        int id = 0;
        //iterating through output object to assign workers to shifts
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                System.out.println(output[i][j]);

                List<worker> MondayMorning = new ArrayList<>();
                List<worker> MondayEvening = new ArrayList<>();
                List<worker> MondayNight = new ArrayList<>();
                switch (id) {
                    case 0:
                        int shiftRequiredSize = 6;
                        while (MondayMorning.size() < shiftRequiredSize) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getMonday() == "" || !workers.get(randint).getMonday().contains("07-15;")) && !MondayMorning.contains(workers.get(randint)) && workers.get(randint).getHours() != 40) {
                                MondayMorning.add(workers.get(randint));
                                workers.get(randint).setHours(workers.get(randint).getHours() + 8);
                            }
                        }
                        for (Object worker : MondayMorning) {
                            System.out.println(worker);
                        }
                        break;
                    case 1:
                        int shiftRequiredSize2 = 6;
                        while (MondayEvening.size() < shiftRequiredSize2) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getMonday() == "" || !workers.get(randint).getMonday().contains("15-23;"))
                                    && !MondayEvening.contains(workers.get(randint)) && workers.get(randint).getHours() !=40
                                    && !MondayMorning.contains(workers.get(randint))) {
                                MondayEvening.add(workers.get(randint));
                                workers.get(randint).setHours(workers.get(randint).getHours() + 8);
                            }
                        }
                        for (Object worker : MondayEvening) {
                            System.out.println(worker);
                        }
                        break;
                    case 2:
                        int shiftRequiredSize3 = 3;
                        while (MondayNight.size() < shiftRequiredSize3) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;


                            if ((workers.get(randint).getMonday() == "" || !workers.get(randint).getMonday().contains("23-07;"))
                                    && !MondayNight.contains(workers.get(randint)) && workers.get(randint).getHours() !=40
                                    && !MondayEvening.contains(workers.get(randint))
                                    && !MondayMorning.contains(workers.get(randint))) {
                                MondayNight.add(workers.get(randint));
                                workers.get(randint).setHours(workers.get(randint).getHours() + 8);
                            }
                        }
                        for (Object worker : MondayNight) {
                            System.out.println(worker);
                        }
                        break;

                }
                id++;
            }

        }


    }
}
