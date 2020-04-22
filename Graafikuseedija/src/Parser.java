/*
This class is about everything related to the logic behind making the work shifts
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Parser {
    public static List<Worker> workers = ReadFromXSLX.readInput();
    //Main method that brings everything together
    public static Object[][] parse() {
        // Create a 2D object to hold the data
        Object[][] output = new Object[7][3];
        boolean unfinished = false;
        //iterating through output object to assign workers to shifts
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                List<Worker> shift = new ArrayList<>();
                switch (j) {
                    case 0:
                        get_shifty(shift, startTime, i, j, output, "07-15;", 6);
                        break;
                    case 1:
                        get_shifty(shift, startTime, i, j, output, "15-23;", 6);
                        break;
                    case 2:
                        get_shifty(shift, startTime, i, j, output, "23-07;", 3);
                        break;

                }
            }
        }

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}; // rotate the output by 90 degrees
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
    public static boolean suitable_worker(String shift_time, int id, int day, List<Worker> shift){
        return (workers.get(id).getDay(day) == null // worker has not requested the day off
                || !workers.get(id).getDay(day).contains(shift_time)) // worker has not requested the shift off
                && !shift.contains(workers.get(id)) // worker is not already in the shift
                && workers.get(id).getHours() != 40 // worker has not worked 40 hours already
                && workers.get(id).getHours_since_shift() > 12 // time passed from latest shift is more than
                && workers.get(id).getSeniority() != 9; // worker does not have the seniority 9 (shift manager) assigned to them

    }

    public static void get_shifty(List<Worker> shift, Long startTime, int i, int j, Object[][] output, String shift_time, int shiftRequiredSize) {
        while (shift.size() < shiftRequiredSize) {
            if (System.currentTimeMillis()-startTime > 5000){ // if the loop runs for longer than 5 seconds then the algorithm was unable to find a suitable distribution and the program needs to be restarted
                boolean unfinished = true;
                break;
            }
            //generating randint
            Random r = new Random();
            int randint = r.nextInt((workers.size() - 2) + 1) + 1;
            // Checking for a suitable worker
            if (suitable_worker(shift_time, randint, i, shift)) {
                // Adding the worker to the shift.
                shift.add(workers.get(randint));
                workers.get(randint).setHours(workers.get(randint).getHours() + 8);
                // Checking if the current shift, is a night one, in that case giving the worker 8 more hours to rest
                if (shiftRequiredSize == 3) {
                    workers.get(randint).setHours_since_shift(-8);
                }
                else{
                    workers.get(randint).setHours_since_shift(0);
                }

            }
        }
        //Updating the time since shift for all other workers
        for (Worker value : workers) {
            if (!shift.contains(value)) {
                value.setHours_since_shift(value.getHours_since_shift() + 8);
            }
        }
        // Stringbuilder for the shift to add it to the output object
        StringBuilder shiftParticipants = new StringBuilder();
        for (Worker worker : shift) {
            //Get the first name and the first letter of their last name
            shiftParticipants.append(worker.getName().split(" ")[0]).append(worker.getName().split(" ")[1].charAt(0)).append("/");
        }
        output[i][j] = shiftParticipants.toString();
    }
}
