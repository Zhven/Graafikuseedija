import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Parser {

    public static Object[][] parse() {
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
                List<worker> shift = new ArrayList<>();
                switch (id) {
                    case 0:
                        int shiftRequiredSize = 6;
                        while (shift.size() < shiftRequiredSize) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;


                            if ((workers.get(randint).getMonday().equals("")
                                    || !workers.get(randint).getMonday().contains("07-15;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {

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
                        StringBuilder shiftParticipants = new StringBuilder();
                        for (worker value : shift) {
                            shiftParticipants.append(value.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();

                        break;
                    case 1:
                        int shiftRequiredSize2 = 6;
                        while (shift.size() < shiftRequiredSize2) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getMonday().equals("")
                                    || !workers.get(randint).getMonday().contains("15-23;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                        for (worker value : shift) {
                            shiftParticipants.append(value.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 2:
                        int shiftRequiredSize3 = 3;
                        while (shift.size() < shiftRequiredSize3) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;


                            if ((workers.get(randint).getMonday().equals("")
                                    || !workers.get(randint).getMonday().contains("23-07;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
                                shift.add(workers.get(randint));
                                workers.get(randint).setHours(workers.get(randint).getHours() + 8);
                                workers.get(randint).setHours_since_shift(-8);
                            }
                        }
                        for (worker value : workers) {
                            if (!shift.contains(value)) {
                                value.setHours_since_shift(value.getHours_since_shift() + 8);
                            }
                        }
                        shiftParticipants = new StringBuilder();
                        for (worker value : shift) {
                            shiftParticipants.append(value.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 3:
                        int shiftRequiredSize4 = 6;
                        while (shift.size() < shiftRequiredSize4) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getTuesday().equals("")
                                    || !workers.get(randint).getTuesday().contains("07-15;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                        for (worker value : shift) {
                            shiftParticipants.append(value.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 4:
                        int shiftRequiredSize5 = 6;
                        while (shift.size() < shiftRequiredSize5) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getTuesday().equals("")
                                    || !workers.get(randint).getTuesday().contains("15-23;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                        for (worker value : shift) {
                            shiftParticipants.append(value.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 5:
                        int shiftRequiredSize6 = 3;
                        while (shift.size() < shiftRequiredSize6) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;


                            if ((workers.get(randint).getTuesday().equals("")
                                    || !workers.get(randint).getTuesday().contains("23-07;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                            shiftParticipants.append(worker.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 6:
                        int shiftRequiredSize7 = 6;
                        while (shift.size() < shiftRequiredSize7) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getWednesday().equals("")
                                    || !workers.get(randint).getWednesday().contains("07-15;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                        shiftParticipants = new StringBuilder();
                        for (worker worker : shift) {
                            shiftParticipants.append(worker.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 7:
                        int shiftRequiredSize8 = 6;
                        while (shift.size() < shiftRequiredSize8) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getWednesday().equals("")
                                    || !workers.get(randint).getWednesday().contains("15-23;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                        shiftParticipants = new StringBuilder();
                        for (worker worker : shift) {
                            shiftParticipants.append(worker.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 8:
                        int shiftRequiredSize9 = 3;
                        while (shift.size() < shiftRequiredSize9) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;


                            if ((workers.get(randint).getWednesday().equals("")
                                    || !workers.get(randint).getWednesday().contains("23-07;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                            shiftParticipants.append(worker.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 9:
                        int shiftRequiredSize10 = 6;
                        while (shift.size() < shiftRequiredSize10) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getThursday().equals("")
                                    || !workers.get(randint).getThursday().contains("07-15;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                        shiftParticipants = new StringBuilder();
                        for (worker value : shift) {
                            shiftParticipants.append(value.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 10:
                        int shiftRequiredSize11 = 6;
                        while (shift.size() < shiftRequiredSize11) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getThursday().equals("")
                                    || !workers.get(randint).getThursday().contains("15-23;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                        shiftParticipants = new StringBuilder();
                        for (worker worker : shift) {
                            shiftParticipants.append(worker.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 11:
                        int shiftRequiredSize12 = 3;
                        while (shift.size() < shiftRequiredSize12) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;


                            if ((workers.get(randint).getThursday().equals("")
                                    || !workers.get(randint).getThursday().contains("23-07;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                            shiftParticipants.append(worker.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 12:
                        int shiftRequiredSize13 = 6;
                        while (shift.size() < shiftRequiredSize13) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getFriday().equals("")
                                    || !workers.get(randint).getFriday().contains("07-15;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                        shiftParticipants = new StringBuilder();
                        for (worker worker : shift) {
                            shiftParticipants.append(worker.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 13:
                        int shiftRequiredSize14 = 6;
                        while (shift.size() < shiftRequiredSize14) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getFriday().equals("")
                                    || !workers.get(randint).getFriday().contains("15-23;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                        shiftParticipants = new StringBuilder();
                        for (worker worker : shift) {
                            shiftParticipants.append(worker.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 14:
                        int shiftRequiredSize15 = 3;
                        while (shift.size() < shiftRequiredSize15) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;


                            if ((workers.get(randint).getFriday().equals("")
                                    || !workers.get(randint).getFriday().contains("23-07;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                            shiftParticipants.append(worker.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 15:
                        int shiftRequiredSize16 = 6;
                        while (shift.size() < shiftRequiredSize16) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getSaturday().equals("")
                                    || !workers.get(randint).getSaturday().contains("07-15;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                        shiftParticipants = new StringBuilder();
                        for (worker worker : shift) {
                            shiftParticipants.append(worker.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 16:
                        int shiftRequiredSize17 = 6;
                        while (shift.size() < shiftRequiredSize17) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getSaturday().equals("")
                                    || !workers.get(randint).getSaturday().contains("15-23;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                        shiftParticipants = new StringBuilder();
                        for (worker worker : shift) {
                            shiftParticipants.append(worker.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 17:
                        int shiftRequiredSize18 = 3;
                        while (shift.size() < shiftRequiredSize18) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;


                            if ((workers.get(randint).getSaturday().equals("")
                                    || !workers.get(randint).getSaturday().contains("23-07;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                            shiftParticipants.append(worker.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 18:
                        int shiftRequiredSize19 = 6;
                        while (shift.size() < shiftRequiredSize19) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getSunday().equals("")
                                    || !workers.get(randint).getSunday().contains("07-15;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                        shiftParticipants = new StringBuilder();
                        for (worker worker : shift) {
                            shiftParticipants.append(worker.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 19:
                        int shiftRequiredSize20 = 6;
                        while (shift.size() < shiftRequiredSize20) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;

                            if ((workers.get(randint).getSunday().equals("")
                                    || !workers.get(randint).getSunday().contains("15-23;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                        shiftParticipants = new StringBuilder();
                        for (worker worker : shift) {
                            shiftParticipants.append(worker.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();
                        break;
                    case 20:
                        int shiftRequiredSize21 = 3;
                        while (shift.size() < shiftRequiredSize21) {
                            //generating randint
                            Random r = new Random();
                            int randint = r.nextInt((workers.size() - 2) + 1) + 1;


                            if ((workers.get(randint).getSunday().equals("")
                                    || !workers.get(randint).getSunday().contains("23-07;"))
                                    && !shift.contains(workers.get(randint))
                                    && workers.get(randint).getHours() != 40
                                    && workers.get(randint).getHours_since_shift() > 12) {
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
                            shiftParticipants.append(worker.getName().split(" ")[0]).append("/");
                        }
                        output[i][j] = shiftParticipants.toString();

                        break;
                }
                id++;
            }
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
}
