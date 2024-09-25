import java.time.LocalDateTime;

/**
 * The Deadline class represents a deadline event with a specified date and time.
 * A Deadline can be marked as complete, and it extends the abstract Event class.
 */
public class Deadline extends Event {

    /**
     * A flag indicating whether the deadline has been completed.
     */
    private boolean complete;

    /**
     * The name of the deadline.
     */
    private String name;

    /**
     * Constructs a Deadline with a given name and start date and time.
     *
     * @param name     The name of the deadline.
     * @param dateTime The date and time by which the deadline must be completed.
     */
    public Deadline(String name, LocalDateTime dateTime){
        super(name, dateTime); // Call the superclass constructor to set the name and date
        this.name = name;     // Initialize the name
        this.complete = false;  // Initialize the deadline as incomplete

    }

    /**
     * Marks the deadline as complete by setting the complete flag to true.
     */
    public void complete()
    {
        this.complete = true; // Mark the deadline as complete
    }

    /**
     * Returns whether the deadline has been completed.
     *
     * @return True if the deadline is complete, false otherwise.
     */
    public boolean isComplete()
    {
        return this.complete; // Return the completion status
    }

    /**
     * Returns the name of the deadline.
     *
     * @return The name of the deadline as a String.
     */
    @Override
    public String getName() {
        return this.name;
    }
}
