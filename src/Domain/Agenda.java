package Domain;

public class Agenda {
    private String id;
    private String name;
    private String day;
    private String duration;
    private String startHour;

    public Agenda(String id, String name, String day, String duration, String startHour) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.duration = duration;
        this.startHour = startHour;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", day='" + day + '\'' +
                ", duration='" + duration + '\'' +
                ", startHour='" + startHour + '\'' +
                '}';
    }
}
