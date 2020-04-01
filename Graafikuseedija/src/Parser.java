/*
This class is about everything related to the logic behind making the work shifts
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Parser {
    public static List<worker> workers = readFromXML.readInput();
    //Main method that brings everything together
    public static Object[][] parse() {

        Object[][] output = new Object[7][3];
        boolean unfinished = false;
        //iterating through output object to assign workers to shifts

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                List<worker> shift = new ArrayList<>();
                switch (j) {
                    case 0:
                        int shiftRequiredSize = 6;
                        while (shift.size() < shiftRequiredSize) {
                            if (System.currentTimeMillis()-startTime > 5000){
                                unfinished = true;
                                break;
                            }
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;


                            if (suitable_worker("7-15;", randint, i, shift)) {
                                shift.add(workers.get(randint));
                                workers.get(randint).setHours(workers.get(randint).getHours() + 8);
                                workers.get(randint).setHours_since_shift(0);
                            }
                        }
                        for (worker worker : workers) {
                            if (!shift.contains(worker)) {
                                worker.setHours_since_shift(worker.getHours_since_shift() + 8);
                            }
                        }
                        StringBuilder shiftParticipants = new StringBuilder();
                        for (worker worker : shift) {
                            shiftParticipants.append(worker.getName().split(" ")[0]).append(worker.getName().split(" ")[1].charAt(0)).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 1:
                        int shiftRequiredSize2 = 6;
                        while (shift.size() < shiftRequiredSize2) {
                            if (System.currentTimeMillis()-startTime > 5000){
                                unfinished = true;
                                break;
                            }
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if (suitable_worker("15-23;", randint, i, shift)) {
                                shift.add(workers.get(randint));
                                workers.get(randint).setHours(workers.get(randint).getHours() + 8);
                                workers.get(randint).setHours_since_shift(0);
                            }
                        }
                        for (worker value : workers) {
                            if (!shift.contains(value)) {
                                value.setHours_since_shift(value.getHours_since_shift() + 8);
                            }
                        }
                        shiftParticipants = new StringBuilder();
                        for (worker worker : shift) {
                            shiftParticipants.append(worker.getName().split(" ")[0]).append(worker.getName().split(" ")[1].charAt(0)).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 2:
                        int shiftRequiredSize3 = 3;
                        while (shift.size() < shiftRequiredSize3) {
                            if (System.currentTimeMillis()-startTime > 5000){
                                unfinished = true;
                                break;
                            }
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;


                            if (suitable_worker("23-07;", randint, i, shift)) {
                                shift.add(workers.get(randint));
                                workers.get(randint).setHours(workers.get(randint).getHours() + 8);
                                workers.get(randint).setHours_since_shift(-8);
                            }
                        }
                        for (worker worker : workers) {
                            if (!shift.contains(worker)) {
                                worker.setHours_since_shift(worker.getHours_since_shift() + 8);
                            }
                        }
                        shiftParticipants = new StringBuilder();
                        for (worker worker : shift) {
                            shiftParticipants.append(worker.getName().split(" ")[0]).append(worker.getName().split(" ")[1].charAt(0)).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;

                }
            }
        }
        if (unfinished){
            System.out.println("Didn't find a good distribution, the table is incomplete.");
            System.out.println("Suggestions: Change the shift required workers, change the data or rerun the program.");
        }
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        Object[][] week_shift = new Object[4][7];
        for (int i = 0; i < week_shift.length; i++) {
            for (int j = 0; j < week_shift[0].length; j++) {
                if (i == 0){
                    week_shift[i][j] = days[j];
                }
                else{
                    week_shift[i][j] = output[j][i-1];
                }
            }
        }
        return week_shift;
    }
    //A method for checking if the given worker(id) can actually work
    public static boolean suitable_worker(String shift_time, int id, int day, List<worker> shift){
        return (workers.get(id).getDay(day) == null
                || !workers.get(id).getDay(day).contains(shift_time))
                && !shift.contains(workers.get(id))
                && workers.get(id).getHours() != 40
                && workers.get(id).getHours_since_shift() > 12
                && workers.get(id).getSeniority() != 9;

    }
}
