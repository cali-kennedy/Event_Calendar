import java.time.LocalDateTime;
import java.time.*;
import java.time.Duration;
public class Meeting extends Event implements Completable {
    private LocalDateTime endDateTime;
    private String location;
    private boolean complete;
    private String name;

    public Meeting(String name, LocalDateTime dateTime, LocalDateTime endDateTime, String location) {
        super(name, dateTime);
        this.endDateTime = endDateTime;
        this.location = location;
        this.complete = false;
        super.setName(name);
        this.name = name;
    }

    public LocalDateTime getEndTime() {
        return endDateTime;
    }

    public void setEndTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDuration(){
        return (int) Duration.between(super.getDateTime(), endDateTime).toMinutes();
    }
    @Override
    public void complete() {
        this.complete = true;
    }

    @Override
    public boolean isComplete() {
        return complete;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
