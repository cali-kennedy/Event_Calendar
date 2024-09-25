import java.time.*;

/**
 * The Event class represents an event on a calendar, containing the event's name
 * and the date and time when the event starts. The Event class implements the Comparable
 * interface to allow comparison between events based on their start date and time.
 * This class is abstract, and concrete event types (such as meetings or deadlines) will
 * extend it.
 */
 abstract class Event implements Comparable<Event>{

    /**
     * The name of the event.
     */
    private String name;

    /**
     * The date and time when the event starts.
     */
    private LocalDateTime date;

    /**
     * Constructs an Event with a given name and start date and time.
     *
     * @param name The name of the event.
     * @param date The start date and time of the event.
     */
    public Event(String name, LocalDateTime date){
        this.name = name;
        this.date = date;
    }

    /**
     * Default constructor for Event.
     * Initializes the event with default name and date (null).
     */
    public Event() {
        this.name = name;
        this.date = date;
    }

    /**
     * Gets the name of the event.
     * This method is abstract and must be implemented by any subclass.
     *
     * @return The name of the event.
     */
    public abstract String getName();

    /**
     * Gets the date and time of the event.
     *
     * @return The LocalDateTime object representing the date and time of the event.
     */
    public LocalDateTime getDateTime() {
        return this.date;
    }

    /**
     * Sets the date and time of the event.
     *
     * @param date The new date and time for the event.
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Sets the name of the event.
     *
     * @param name The new name for the event.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Compares the date and time of this event to another event.
     * This method allows events to be sorted based on their start time.
     *
     * @param e An event object to compare against.
     * @return A positive integer if this event's date is after the given event's date,
     *         a negative integer if this event's date is before the given event's date,
     *         or 0 if both events have the same date and time.
     */
    public int compareTo(Event e){
        return this.date.compareTo(e.getDateTime());
        }

}
