import javax.swing.*;
import java.time.LocalDateTime;

/**
 * EventPlanner is the main class that sets up and displays the event planning application.
 * It creates the main JFrame, adds the EventListPanel to display events, and adds some default events.
 */
public class EventPlanner {

    /**
     * The main method of the EventPlanner application.
     * This method creates the main JFrame, adds the EventListPanel, and adds some default events.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {

        // Create the main frame for the application with the title "Event Planner"
        JFrame frame = new JFrame("Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Ensure the application exits on close
        frame.setSize(800, 600);  // Set the initial size of the frame

        // Create and add the EventListPanel, which will hold the event panels
        EventListPanel eventListPanel = new EventListPanel();
        frame.add(eventListPanel);  // Add EventListPanel to the frame's content pane

        // Add some default events (Deadline and Meeting) to the EventListPanel
        addDefaultEvents(eventListPanel);

        // Pack the frame to fit the size of the components and make it visible
        frame.pack();
        frame.setVisible(true);  // Make the window visible on the screen
    }

    /**
     * Adds default events (a Deadline and a Meeting) to the given EventListPanel.
     * These events are added for demonstration purposes when the application starts.
     *
     * @param eventListPanel The EventListPanel to which default events will be added.
     */
    public static void addDefaultEvents(EventListPanel eventListPanel) {
        // Create a Deadline event with a due date two days from now
        Deadline deadline = new Deadline("Project Deadline", LocalDateTime.now().plusDays(2));

        // Create a Meeting event with a start time one hour from now and an end time two hours from now
        Meeting meeting = new Meeting("Team Meeting", LocalDateTime.now().plusHours(1),
                LocalDateTime.now().plusHours(2), "Conference Room");

        // Add the Deadline event to the EventListPanel wrapped in an EventPanel
        eventListPanel.addEvent(new EventPanel(deadline));

        // Add the Meeting event to the EventListPanel wrapped in an EventPanel
        eventListPanel.addEvent(new EventPanel(meeting));
    }
}
