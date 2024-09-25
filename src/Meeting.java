import java.time.LocalDateTime;
import java.time.*;
import java.time.Duration;

/**
 * The Meeting class represents a meeting event with a start time, end time, location,
 * and completion status. This class extends the abstract Event class and implements
 * the Completable interface.
 */
public class Meeting extends Event implements Completable {

    /**
     * The end date and time of the meeting.
     */
    private LocalDateTime endDateTime;

    /**
     * The location where the meeting will take place.
     */
    private String location;

    /**
     * Boolean flag to indicate if the meeting has been marked as complete.
     */
    private boolean complete;

    /**
     * The name of the meeting.
     */
    private String name;

    /**
     * Constructs a new Meeting with a name, start time, end time, and location.
     *
     * @param name        The name of the meeting.
     * @param dateTime    The start date and time of the meeting.
     * @param endDateTime The end date and time of the meeting.
     * @param location    The location of the meeting.
     */
    public Meeting(String name, LocalDateTime dateTime, LocalDateTime endDateTime, String location) {
        super(name, dateTime);  // Call the superclass constructor to set the name and start time
        this.endDateTime = endDateTime;
        this.location = location;
        this.complete = false;  // Meeting is not complete by default
        super.setName(name);   // Set the name of the event (inherited from Event)
        this.name = name;      // Store the name in the local field
    }

    /**
     * Returns the end date and time of the meeting.
     *
     * @return The LocalDateTime representing when the meeting ends.
     */
    public LocalDateTime getEndTime() {
        return endDateTime;
    }

    /**
     * Sets the end date and time for the meeting.
     *
     * @param endDateTime The new end date and time for the meeting.
     */
    public void setEndTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    /**
     * Returns the location where the meeting will take place.
     *
     * @return The location of the meeting as a String.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location for the meeting.
     *
     * @param location The new location for the meeting.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Calculates and returns the duration of the meeting in minutes.
     *
     * @return The duration of the meeting, in minutes, as an integer.
     */
    public int getDuration(){
        // Calculate the duration between the meeting's start time and end time in minutes
        return (int) Duration.between(super.getDateTime(), endDateTime).toMinutes();
    }

    /**
     * Marks the meeting as complete by setting the complete flag to true.
     */
    @Override
    public void complete() {
        this.complete = true; // Mark the meeting as complete
    }

    /**
     * Checks if the meeting has been marked as complete.
     *
     * @return True if the meeting is complete, false otherwise.
     */
    @Override
    public boolean isComplete() {
        return complete;
    }

    /**
     * Returns the name of the meeting.
     *
     * @return The name of the meeting as a String.
     */
    @Override
    public String getName() {
        return this.name;
    }
}
