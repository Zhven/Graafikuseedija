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

                List<worker> shift = new ArrayList<>();
                switch (id) {
                    case 0:
                        int shiftRequiredSize = 6;
                        while (shift.size() < shiftRequiredSize) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getMonday() == ""
                                    || !workers.get(randint).getMonday().contains("07-15;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
                                shift.add(workers.get(randint));
                                workers.get(randint).setHours(workers.get(randint).getHours() + 8);
                                workers.get(randint).setHours_since_shift(0);
                            }
                        }
                        for (int k = 0; k < workers.size(); k++) {
                            if (!shift.contains(workers.get(k))){
                                workers.get(k).setHours_since_shift(workers.get(k).getHours_since_shift()+8);
                            }
                        }
                        for (Object worker : shift) {
                            System.out.println(worker);
                        }
                        break;
                    case 1:
                        int shiftRequiredSize2 = 6;
                        while (shift.size() < shiftRequiredSize2) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getMonday() == ""
                                    || !workers.get(randint).getMonday().contains("15-23;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() !=40
                                    && workers.get(randint).getHours_since_shift() > 12) {
                                shift.add(workers.get(randint));
                                workers.get(randint).setHours(workers.get(randint).getHours() + 8);
                                workers.get(randint).setHours_since_shift(0);
                            }
                        }
                        for (int k = 0; k < workers.size(); k++) {
                            if (!shift.contains(workers.get(k))){
                                workers.get(k).setHours_since_shift(workers.get(k).getHours_since_shift()+8);
                            }
                        }
                        for (Object worker : shift) {
                            System.out.println(worker);
                        }
                        break;
                    case 2:
                        int shiftRequiredSize3 = 3;
                        while (shift.size() < shiftRequiredSize3) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;


                            if ((workers.get(randint).getMonday() == ""
                                    || !workers.get(randint).getMonday().contains("23-07;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() !=40
                                    && workers.get(randint).getHours_since_shift() > 12) {
                                shift.add(workers.get(randint));
                                workers.get(randint).setHours(workers.get(randint).getHours() + 8);
                                workers.get(randint).setHours_since_shift(-8);
                            }
                        }
                        for (int k = 0; k < workers.size(); k++) {
                            if (!shift.contains(workers.get(k))){
                                workers.get(k).setHours_since_shift(workers.get(k).getHours_since_shift()+8);
                            }
                        }
                        for (Object worker : shift) {
                            System.out.println(worker);
                        }
                        break;
                    case 3:
                        int shiftRequiredSize4 = 6;
                        while (shift.size() < shiftRequiredSize4) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getTuesday() == ""
                                    || !workers.get(randint).getTuesday().contains("07-15;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
                                shift.add(workers.get(randint));
                                workers.get(randint).setHours(workers.get(randint).getHours() + 8);
                                workers.get(randint).setHours_since_shift(0);
                            }
                        }
                        for (int k = 0; k < workers.size(); k++) {
                            if (!shift.contains(workers.get(k))){
                                workers.get(k).setHours_since_shift(workers.get(k).getHours_since_shift()+8);
                            }
                        }
                        for (Object worker : shift) {
                            System.out.println(worker);
                        }
                        break;
                    case 4:
                        int shiftRequiredSize5 = 6;
                        while (shift.size() < shiftRequiredSize5) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getTuesday() == ""
                                    || !workers.get(randint).getTuesday().contains("15-23;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() !=40
                                    && workers.get(randint).getHours_since_shift() > 12) {
                                shift.add(workers.get(randint));
                                workers.get(randint).setHours(workers.get(randint).getHours() + 8);
                                workers.get(randint).setHours_since_shift(0);
                            }
                        }
                        for (int k = 0; k < workers.size(); k++) {
                            if (!shift.contains(workers.get(k))){
                                workers.get(k).setHours_since_shift(workers.get(k).getHours_since_shift()+8);
                            }
                        }
                        for (Object worker : shift) {
                            System.out.println(worker);
                        }
                        break;
                    case 5:
                        int shiftRequiredSize6 = 3;
                        while (shift.size() < shiftRequiredSize6) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;


                            if ((workers.get(randint).getTuesday() == ""
                                    || !workers.get(randint).getTuesday().contains("23-07;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() !=40
                                    && workers.get(randint).getHours_since_shift() > 12) {
                                shift.add(workers.get(randint));
                                workers.get(randint).setHours(workers.get(randint).getHours() + 8);
                                workers.get(randint).setHours_since_shift(-8);
                            }
                        }
                        for (int k = 0; k < workers.size(); k++) {
                            if (!shift.contains(workers.get(k))){
                                workers.get(k).setHours_since_shift(workers.get(k).getHours_since_shift()+8);
                            }
                        }
                        for (Object worker : shift) {
                            System.out.println(worker);
                        }
                        break;


                }
                id++;
            }

        }


    }
}
