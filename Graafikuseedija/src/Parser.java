/*
This class is about everything related to the logic behind making the work shifts
 */
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Parser {
    public static List<Worker> workers = ReadFromXLSX.readInput();

    //Main method that brings everything together
    public static String[][] parse(String[][] output) {
        //Resetting the hours worked to 0 for all workers in case the program is ran more than once during the same startup
        for (Worker worker : workers) {
            worker.setHours_since_shift(24);
            worker.setHours(0);
            worker.setNightShift(false);
        }
        //iterating through output object to assign workers to shifts
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                List<Worker> shift = new ArrayList<>();
                switch (j) {
                    case 0:
                        get_shifty(shift, startTime, i, j, output, "7-15", Integer.parseInt(output[i][j]));
                        break;
                    case 1:
                        get_shifty(shift, startTime, i, j, output, "15-23", Integer.parseInt(output[i][j]));
                        break;
                    case 2:
                        get_shifty(shift, startTime, i, j, output, "23-7", Integer.parseInt(output[i][j]));
                        break;

                }
            }
        }

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}; // rotate the output by 90 degrees
        String[][] week_shift = new String[4][7];
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
        /*
        System.out.println("Nimi: "+workers.get(id).getName());
        System.out.println("Töötaja request: " + workers.get(id).getDay(day));
        System.out.println("Input day: " + day);
        System.out.println("Shift_time: " + shift_time);
        if (workers.get(id).getDay(day) != null) {
            System.out.println("Kas töötaja info sisaldab shift_time väärtust: "+workers.get(id).getDay(day).contains(shift_time));
        }
        System.out.println();

         */
        return (workers.get(id).getDay(day) == null // worker has not requested the day off
                || !workers.get(id).getDay(day).contains(shift_time)) // worker has not requested the shift off
                && !shift.contains(workers.get(id)) // worker is not already in the shift
                && workers.get(id).getHours() != 40 // worker has not worked 40 hours already
                && workers.get(id).getHours_since_shift() > 12 // time passed from latest shift is more than
                && !workers.get(id).isNightShift() // worker has not been assigned a nightShift
                && !workers.get(id).getSeniority().equals("SM"); // worker does not have the seniority (shift manager) assigned to them

    }
    public static boolean suitable_SL(String shift_time, int id, int day, List<Worker> shift){
        System.out.println("Testing worker " + id);
        return (workers.get(id).getDay(day) == null // worker has not requested the day off
                || !workers.get(id).getDay(day).contains(shift_time)) // worker has not requested the shift off
                && !shift.contains(workers.get(id)) // worker is not already in the shift
                && workers.get(id).getHours() != 40 // worker has not worked 40 hours already
                && workers.get(id).getHours_since_shift() > 12 // time passed from latest shift is more than
                && !workers.get(id).isNightShift() // worker has not been assigned a nightShift
                && !workers.get(id).getSeniority().equals("SM") // worker does not have the seniority 9 (shift manager) assigned to them
                && workers.get(id).getSeniority().equals("SL");

    }

    public static void get_shifty(List<Worker> shift, Long startTime, int i, int j, Object[][] output, String shift_time, int shiftRequiredSize) {
        boolean containsSL = false;
        while (shift.size() < shiftRequiredSize) {
            if (System.currentTimeMillis()-startTime > 100){ // if the loop runs for longer than 5 seconds then the algorithm was unable to find a suitable distribution and the program needs to be restarted
                boolean unfinished = true;
                break;
            }
            //System.out.println(System.currentTimeMillis()-startTime);
            //generating randint
            Random r = new Random();
            int randint = r.nextInt((workers.size() - 2) + 1) + 1;
            // Checking for a suitable SL


            while (!containsSL){
                randint = r.nextInt((workers.size() - 2) + 1) + 1;
                System.out.println("Shift does not contain SL");
                if (suitable_SL(shift_time, randint, i, shift)) {
                    System.out.println("Looking for SL");
                    // Adding the worker to the shift.
                    shift.add(workers.get(randint));
                    containsSL = true;
                    // Checking if the current shift, is a night one
                    if (shift_time.equals("23-07;")) {
                        // Setting hours since last shift to -8 so that they would have 8 + 8 hours of time to rest before next shift
                        workers.get(randint).setHours_since_shift(-8);
                        // Adding the 16 hours that they have worked
                        workers.get(randint).setHours(workers.get(randint).getHours() + 16);
                        // Editing the nightShift flag to avoid assigning multiple nightshifts
                        workers.get(randint).setNightShift(true);
                    } else {
                        // Setting hours since last shift to 0 so that they would have time to rest before next shift
                        workers.get(randint).setHours_since_shift(0);
                        // Adding the 8 hours that they have worked
                        workers.get(randint).setHours(workers.get(randint).getHours() + 8);
                    }

                }
            }



            // Checking for a suitable worker
            if (suitable_worker(shift_time, randint, i, shift)) {
                // Adding the worker to the shift.
                shift.add(workers.get(randint));
                // Checking if the current shift, is a night one
                if (shift_time.equals("23-7")) {
                    // Setting hours since last shift to -8 so that they would have 8 + 8 hours of time to rest before next shift
                    workers.get(randint).setHours_since_shift(-8);
                    // Adding the 16 hours that they have worked
                    workers.get(randint).setHours(workers.get(randint).getHours() + 16);
                    // Editing the nightShift flag to avoid assigning multiple nightshifts
                    workers.get(randint).setNightShift(true);
                }
                else{
                    // Setting hours since last shift to 0 so that they would have time to rest before next shift
                    workers.get(randint).setHours_since_shift(0);
                    // Adding the 8 hours that they have worked
                    workers.get(randint).setHours(workers.get(randint).getHours() + 8);
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
