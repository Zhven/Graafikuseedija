public class worker {
    private String name;
    private int seniority;
    private int hours;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;

    public worker(String name, int seniority, int hours, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) {
        this.name = name;
        this.seniority = seniority;
        this.hours = hours;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public String getName() {
        return name;
    }

    public int getSeniority() {
        return seniority;
    }

    public String getMonday() {
        return monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public String getSaturday() {
        return saturday;
    }

    public String getSunday() {
        return sunday;
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
                ", monday='" + monday + '\'' +
                ", tuesday='" + tuesday + '\'' +
                ", wednesday='" + wednesday + '\'' +
                ", thursday='" + thursday + '\'' +
                ", friday='" + friday + '\'' +
                ", saturday='" + saturday + '\'' +
                ", sunday='" + sunday + '\'' +
                '}';
    }
}
