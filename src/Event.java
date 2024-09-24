import java.time.*;

/**
 * An Event object represents an event on a calendar that contains
 * the name of the event and the time and date the event starts.
 * The Event class implements the Comparable class.
 * @author Cali Kennedy
 * @version 1.1
 */
abstract class Event implements Comparable<Event>{
    // Instance variables
    private String name;
    private LocalDateTime date;

    // Constructor
    public Event(String name, LocalDateTime date){
        this.name = name;
        this.date = date;
    }

    public Event() {
        this.name = name;
        this.date = date;
    }

    // Abstract method to get the name of the event
    public abstract String getName();

    // Method to get the date of the event
    public LocalDateTime getDateTime() {
        return this.date;
    }

    // Method to set the date of the event
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    // Method to set the name of the event
    public void setName(String name){
        this.name = name;
    }

    /**
     * Compares the date of this Event to the incoming event
     * @param e an object of the event class
     * @return a positive int if this event comes later, a negative int if this event comes
     * before, and 0 if the two have the same dateTime.
     */
    public int compareTo(Event e){
        return this.date.compareTo(e.getDateTime());
        }

}
