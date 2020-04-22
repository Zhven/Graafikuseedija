/*
Nothing really to explain here, basically a class for holding the data that is associated with each employee.
 */
public class Worker {
    private String name;
    private int seniority;
    private int hours;
    private int hours_since_shift;
    private String[] days;


    public Worker(String name, int seniority, int hours, int hours_since_shift, String[] days) {
        this.name = name;
        this.seniority = seniority;
        this.hours = hours;
        this.hours_since_shift = hours_since_shift;
        this.days = days;

    }
    public void setDays(int day, String data) {
        days[day] = data;
    }

    public String getName() {
        return name;
    }

    public String getDay(int day) {
        return days[day];
    }

    public String[] getDays() {
        return days;
    }

    public int getSeniority() {
        return seniority;
    }

    public int getHours_since_shift() {
        return hours_since_shift;
    }

    public void setHours_since_shift(int hours_since_shift) {
        this.hours_since_shift = hours_since_shift;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "worker{" +
                "name='" + name + '\'' +
                ", seniority='" + seniority + '\'' +
                ", hours='" + hours + '\'' +
                ", hours_since_shift='" + hours_since_shift + '\''
                ;
    }
}
