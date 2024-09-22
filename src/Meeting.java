import java.time.LocalDateTime;
import java.time.*;

public class Meeting extends Event implements Completable {
    private LocalDateTime endDateTime;
    private String location;
    private boolean complete;

    public Meeting(String name, LocalDateTime dateTime, LocalDateTime endDateTime, String location) {
        super(name, dateTime);
        this.endDateTime = endDateTime;
        this.location = location;
        this.complete = false;
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
        int begin_time_mon = this.getDateTime().getDayOfMonth();
        int end_time_mon = endDateTime.getDayOfMonth();
        int result = begin_time_mon - end_time_mon;
        return result;
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
