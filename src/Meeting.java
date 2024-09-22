import java.time.LocalDateTime;

public class Meeting extends Event implements Completable{

    // Instance Variables
    private LocalDateTime endDateTime;
    private String location;
    private boolean complete;

    // Constructor
    public Meeting() {
        super(); // Call the constructor of the Event
        this.complete = false;
    }



    // Method to set the end time for the meeting
    public void setEndTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    // Method to get the time that the meeting ends
    public LocalDateTime getEndTime() {
        return this.endDateTime;
    }

    // Method to set the location for the meeting
    public void setLocation(String location){
        this.location = location;
    }

    // Method to get the location of the meeting
    public String getLocation(){
        return this.location;
    }

    public int getDuration(){
        int begin_time_mon = this.getDateTime().getDayOfMonth();
        int end_time_mon = this.endDateTime.getDayOfMonth();
        int result = begin_time_mon - end_time_mon;
        return result;
    }


    // Instantiate methods from implemented and extended classes
    // Method to mark the meeting as complete
    @Override
    public void complete(){
        this.complete = true;
    }

    // Method to return the name of the meeting
    @Override
    public String getName() {
        return Meeting.this.getName();
    }

    // Constructor for the isComplete method of the Completable interface
    // Set to false by default
    @Override
    public boolean isComplete() {
        return false;
    }
}
